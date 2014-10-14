package com.qalight.javacourse.controller;

import com.qalight.javacourse.service.JsonResultPresentation;
import com.qalight.javacourse.service.WordCounterResultContainer;
import com.qalight.javacourse.service.WordCounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CountWordsController {
    private static final Logger LOG = LoggerFactory.getLogger(CountWordsController.class);
    private final WordCounterService wordCounterService;
    private final JsonResultPresentation resultPresentation;

    @Autowired
    public CountWordsController(@Qualifier("wordCounterService") WordCounterService wordCounterService, JsonResultPresentation resultPresentation) {
        this.wordCounterService = wordCounterService;
        this.resultPresentation = resultPresentation;
    }

    @RequestMapping(value = "/countWords", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getResult(@RequestParam String textCount) throws Throwable {
        CountWordsUserRequest request = new CountWordsUserRequest(textCount);
        WordCounterResultContainer result = wordCounterService.getWordCounterResult(request);

        String jsonResult = resultPresentation.createResponse(result.getCountedResult());
        return jsonResult;
    }

    @RequestMapping(value = "/countWordsRestStyle", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public WordCounterResultContainer getResultRestStyle(@RequestParam String textCount) throws Throwable {
        CountWordsUserRequest request = new CountWordsUserRequest(textCount);
        WordCounterResultContainer result = wordCounterService.getWordCounterResult(request);
        return result;
    }

    @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET, produces = "application/pdf;charset=UTF-8")
    public ModelAndView getPdfResult(@RequestParam String textCount,
                                     @RequestParam String sortingOrder,
                                     @RequestParam String isFilterWords) throws  Throwable {
        final String viewName = "pdfView";
        final String modelName = "calculatedWords";

        CountWordsUserRequest request = new CountWordsUserRequest(textCount, sortingOrder, isFilterWords);
        WordCounterResultContainer result = wordCounterService.getWordCounterResult(request);

        Map<String, Integer> resultMap = result.getCountedResult();
        return new ModelAndView(viewName, modelName, resultMap);
    }

    @RequestMapping(value = "/downloadExcel", method = RequestMethod.GET, produces = "application/vnd.ms-excel;charset=UTF-8")
    public ModelAndView getExcelResult(@RequestParam String textCount,
                                       @RequestParam String sortingOrder,
                                       @RequestParam String isFilterWords) throws Throwable {
        final String viewName = "excelView";
        final String modelName = "calculatedWords";

        CountWordsUserRequest request = new CountWordsUserRequest(textCount, sortingOrder, isFilterWords);
        WordCounterResultContainer result = wordCounterService.getWordCounterResult(request);

        Map<String, Integer> resultMap = result.getCountedResult();
        return new ModelAndView(viewName, modelName, resultMap);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleExceptions(Throwable ex) {
        String errorMessage = resultPresentation.createErrorResponse(ex);
        LOG.error("Error while processing request: " + ex.getMessage(), ex);
        return errorMessage;
    }
}