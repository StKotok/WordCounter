﻿<%@ page contentType="text/html;charset=UTF-8" %>
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

    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/jquery.simplemodal.js" type="text/javascript"></script>
    <script src="js/osx.js" type="text/javascript"></script>

    <script src="js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="js/dataTables.foundation.js" type="text/javascript"></script>
    <script src="js/spin.js" type="text/javascript"></script>
    <script src="js/wordcounter.js"  type="text/javascript"></script>

</head>

<body>
<div id="wordCounterContent">
    <div id="wordCounterHeader">
        <a href="">Word Counter ${version}</a>
    </div>
    <div id="aboutUs"><a href="about"><spring:message code="index.aboutLink"/></a></div>
    <div id="webFormContainer" name="webFormContainer">
        <form id="wordCounterForm">
            <fieldset>
                <text id="descriptionMessage"><spring:message code="index.textBig"/></text>
                <p id="examleRequest"><spring:message code="index.example"/> <br><span id="exampleFullText"><spring:message code="index.exampleText1"/></span>
                <br><span id="exampleFullText"><spring:message code="index.exampleText2"/></span></br></p>
                <p>
                    <label for="userUrlsList"><spring:message code="index.enter"/></label>
                    <textarea id="userUrlsList" name=userUrlsList" cols="70" rows="7"></textarea>
                </p>
                <p>
                    <div id="spinner"></div>
                    <input id="CountWords" type="button" value="<spring:message code="index.bCountWords"/>"/>
                </p>
            </fieldset>
        </form>

        <div id="responseContainer">
            <fieldset>
                <legend><spring:message code="index.response"/></legend>
                <div id="filterContainer" class="filterContainer">
                    <div class="filterButton">
                        <div id="getFilterWords" class="buttonGetFilterWords">
                            <input id="buttonGetFilterWords" type="button" value="<spring:message code="index.bFilter"/>"/>
                            <input id="buttonGetUnFilterWords" type="button" value="<spring:message code="index.bUnFilter"/>"/></div>
                        <div id="showFilter" class="showFilter"><a href="#" class="osx"><spring:message code="index.contentLocalLang"/></a></div>
                        <div id="saveAsPdf">
                            <a href="#" id="getPdfByUrl"><spring:message code="index.saveAsPdf"/></a>
                            <input id="buttonSaveAsPdf" type="button" value="<spring:message code="index.saveAsPdf"/>" target="_blank"/>
                        </div>
                    </div>
                    <div id="pdfGetter" class="buttonSaveAsPdf"></div>
                </div>
                <div id="noWordCounter"><spring:message code="index.noCount"/></div>
                <div id="wordCounterResponse"><table cellpadding="0" cellspacing="0" border="0" class="display" id="countedWords"></table></div>
            </fieldset>
        </div>
    </div>
</div>
<div id="osx-modal-content">
    <div id="osx-modal-title"><spring:message code="index.modalTitle"/></div>
    <div class="close"><a href="#" class="simplemodal-close">x</a></div>
    <div id="osx-modal-data">
        <h2><spring:message code="index.modalHeader"/></h2>
        <div id="wordsFilter"><spring:message code="index.consolidateFilter"/></div>
        </p><button class="simplemodal-close"><spring:message code="index.modalClose"/></button>
    </div>
</div>
</body>
</html>   