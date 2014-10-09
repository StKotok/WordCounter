﻿﻿<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<!-- //todo do refactor after change web design by kristi-->
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="robots" content="noindex,nofollow"/>
    <title>Word Counter ${version}</title>
    <link href="css/wordcounter.css" rel="stylesheet" type="text/css"/>
    <link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <link href="css/dataTables.foundation.css" rel="stylesheet" type="text/css"/>
    <link href="css/foundation.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/osx.css" rel="stylesheet" type="text/css" media="screen" />
    <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>

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
<div id="allContent">
    <div id="logo">
        <img src="img/wc-6.png" alt="WordCounterLogo">
    </div>
    <div id="navi">
            <ul>
              <li><a href="/WordCounter"><spring:message code="about.home"/></a></li>
              <li><a href="about" id="aboutUsLink"><spring:message code="index.aboutLink"/></a></li>
            </ul>
    </div>
<div id="headingText">
<div id="welcomeText">
    <p> </p>
    <p id="p1">Get the most frequently used words in one click!</p>
    <div class="hidden">
    <p>Word Counter is a simple, fast and completely free tool, which will allow you to count words and sort
            them by alphabet or by frequency of occurrence on a web page or in any text.</p>
    <p>Please note that our tool not just counts words in a submitted text, but it will as well work with a link to
            almost any document in the web.</p>
    <p>Simply put a URL or a text into the form below, press “Count words” and the result will immediately appear
            just under the text box.</p>
    <p>If you would like your request to be processed as a URL, please add http:// prefix to it. Otherwise, it will
            be handled as a plain text.</p>
    </div>
    <i class="show"></i>
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
                        <input id="CountWords" type="button" value="<spring:message code="index.bCountWords"/>"/>
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
                        <div id="saveAsPdf"><a href="#" id="getPdfByUrl"><spring:message code="index.saveAsPdf"/></a></div>
                    </div>
                    <div id="noWordCounter"><spring:message code="index.noCount"/></div>
                    <div id="wordCounterResponse">
                        <table cellpadding="0" cellspacing="0" border="0" class="display" id="countedWords"></table>
                        <div id="wordsColumNameAnchor"><spring:message code="index.wordsColumName"/></div>
                        <div id="countColumNameAnchor"><spring:message code="index.countColumName"/></div>
                    </div>
                </div>
            </fieldset>
        </div>
    </div>
</div>
<div id="osx-modal-content">
    <div id="osx-modal-title"><spring:message code="index.modalTitle"/></div>
    <div class="close"><a href="#" class="simplemodal-close">x</a></div>
    <div id="osx-modal-data">
        <h2><spring:message code="index.modalHeader"/></h2>
        <div id="wordsFilter">${filter}</div>
        </p><button class="simplemodal-close"><spring:message code="index.modalClose"/></button>
    </div>
</div>
</div>
<footer>
  Disclaimer: While we strive to make Word Counter as accurate as possible, we know that sometimes errors might still occur.<br>
  We will do our best to improve the quality of our tool.
</footer>
</body>
</html>   