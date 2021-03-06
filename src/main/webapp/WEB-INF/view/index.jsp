﻿﻿﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="robots" content="noindex,nofollow"/>
    <title>Word Counter ${version}</title>

    <link href="css/wordcounter.css" rel="stylesheet" type="text/css"/>
    <link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <link href="css/dataTables.foundation.css" rel="stylesheet" type="text/css"/>
    <link href="css/foundation.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/osx.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="font/OpenSans-Regular.ttf" rel="stylesheet" type='text/css'>

    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/jquery.fileDownload.js" type="text/javascript"></script>
    <script src="js/jquery.simplemodal.js" type="text/javascript"></script>
    <script src="js/osx.js" type="text/javascript"></script>
    <script src="js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="js/dataTables.foundation.js" type="text/javascript"></script>
    <script src="js/spin.js" type="text/javascript"></script>
    <script src="js/wordcounter.js"  type="text/javascript"></script>

</head>

<body id="home">
<div id="allContent">
    <div id="logo">
        <img src="img/wc-6.png" alt="WordCounterLogo">
    </div>
    <div id="navi">
            <ul>
              <li><a href="/WordCounter" id="homeNav"><spring:message code="about.home"/></a></li>
              <li><a href="about" id="aboutUsLink"><spring:message code="index.aboutLink"/></a></li>
            </ul>
    </div>
<div id="headingText">
<div id="welcomeText">
    <div id="p1"><spring:message code="index.welcomeHeader"/></div>
    <div id="p2"><spring:message code="index.welcomeText"/></div>
    <a href="about"><spring:message code="index.showMore"/></a>
    </div>
 </div>
<div id="wordCounterContent">
    <div id="webFormContainer" name="webFormContainer">
        <form id="wordCounterForm">
            <p>
                <label for="textCount"><spring:message code="index.enter"/></label>
                <textarea id="textCount" name="textCount" cols="70" rows="7"></textarea>
            </p>
            <div id="spinnerAnchor"></div>
            <p id="note"><spring:message code="index.note"/></p>
            <input id="CountWords" type="button" value="<spring:message code="index.bCountWords"/>"/>
        </form>

        <fieldset>
            <legend><spring:message code="index.response"/></legend>
            <div id="errorsSpoiler" class="spoiler_open" tabindex="1">
                <div id="errors" class="spoiler_desc">
                    <div id="errorsContainer" name="errorsContainer"></div>
                </div>
                <span class="spoiler_title"><spring:message code="index.errorsTitleOpen"/></span>
                <span id="spoiler_close" tabindex="0" class="spoiler_close"><spring:message code="index.errorsTitleClose"/></span>
            </div>

            <div id="responseContainer">
                <div id="pdfContainerIframe"></div>
                <div id="filterContainer" class="filterContainer">
                    <div class="filterButton">
                        <div id="getFilterWords" class="buttonGetFilterWords">
                            <input id="buttonGetFilterWords" type="button" value="<spring:message code="index.bFilter"/>" onclick="closeSpoiler()"/>
                            <input id="buttonGetUnFilterWords" type="button" value="<spring:message code="index.bUnFilter"/>" onclick="closeSpoiler()"/>
                        </div>
                        <div id="showFilter" class="showFilter"><a href="#" class="osx" onclick="closeSpoiler()"><spring:message code="index.contentLocalLang"/></a></div>
                        <div id="saveAsPdf">
                            <form id="getPdfForm" class="pdfDownloadForm" action="/WordCounter/downloadPDF" method="post">
                                <input id="pdfTextCount" type="hidden" value="" name="textCount">
                                <input id="pdfSortingOrder" type="hidden" value="" name="sortingOrder">
                                <input id="pdfIsFilterWords" type="hidden" value="" name="isFilterWords">
                                <input id="getPdf" type="image" src="img/pdf-32.png" alt="<spring:message code="index.saveAsPdf"/>" onclick="setPdfFields()"/>
                            </form>
                        </div>
                        <div id="saveAsXls">
                            <form id="getXlsForm" class="xlsDownloadForm" action="/WordCounter/downloadExcel" method="post">
                                <input id="xlsTextCount" type="hidden" value="" name="textCount">
                                <input id="xlsSortingOrder" type="hidden" value="" name="sortingOrder">
                                <input id="xlsIsFilterWords" type="hidden" value="" name="isFilterWords">
                                <input id="getXls" type="image" src="img/excel-32.png" alt="<spring:message code="index.saveAsXls"/>" onclick="setXlsFields()"/>
                            </form>
                        </div>
                    </div>
                    <div id="messageCounter"><spring:message code="index.noCount"/></div>
                    <div id="wordCounterResponse">
                        <table id="countedWords" cellpadding="0" cellspacing="0" border="0" class="display"></table>
                        <div id="wordsColumNameAnchor"><spring:message code="index.wordsColumName"/></div>
                        <div id="countColumNameAnchor"><spring:message code="index.countColumName"/></div>
                    </div>
                </div>
            </div>
        </fieldset>
    </div>
</div>
<div id="osx-modal-content">
    <div id="osx-modal-title"><spring:message code="index.modalTitle"/></div>
    <div class="close"><a href="#" class="simplemodal-close">x</a></div>
    <div id="osx-modal-data">
        <h2><spring:message code="index.modalHeader"/></h2>
        <div id="wordsFilter">${filter}</div>
        <p><button class="simplemodal-close"><spring:message code="index.modalClose"/></button></p>
    </div>
</div>
</div>

<footer>
    <spring:message code="index.footer"/>
    <p>V. ${version}</p>
</footer>
</body>
</html>
   