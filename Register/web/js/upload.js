/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-29
 * Time: 下午5:18
 */
var xmlHttp;
var uploadStatusUrl = "servlet/uploadMng";
if(window.XMLHttpRequest){
    xmlHttp = new XMLHttpRequest();
} else {
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}
function uploadBegin(){
    var uploadStatus = "";
    if(getEle("fileSelectField").value){
        xmlHttp.open("GET", uploadStatusUrl, true);
        xmlHttp.send();
        xmlHttp.onreadystatechange = function(){
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                uploadStatus = xmlHttp.responseText;
            }
        };
        return true;
    }
    getEle("fileSelectField").style.border = "1px #f00 solid";
    return false;
}
function checkFileSelectField(){
    if(getEle("fileSelectField").value){
        getEle("fileSelectField").style.border = "1px #fff solid";
    } else {
        getEle("fileSelectField").style.border = "1px #f00 solid";
    }
}
function getEle(eleId){
    return document.getElementById(eleId);
}
