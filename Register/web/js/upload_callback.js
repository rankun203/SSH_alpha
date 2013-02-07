/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-29
 * Time: 下午5:18
 */
var uploadStatusUrl = "servlet/uploadMng";
var finished = true;
var xmlHttp;
if(window.XMLHttpRequest){
    xmlHttp = new XMLHttpRequest();
} else {
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
}

function loadStatus(url, calFun){
    xmlHttp.onreadystatechange = calFun;
    xmlHttp.open("GET", url, true);
    xmlHttp.send();
}
function uploadBegin(){
    if(getEle("fileSelectField").value){
        getEle("submitButton").disabled = true;
        getEle("progression").style.width = 0 + "%";
        getEle("finishPercent").innerHTML = 0;
        getEle("usedTime").innerHTML = "00:00:00";
        getEle("needMoreTime").innerHTML = "00:00:00";
        getEle("uploaded").innerHTML = "0KB";
        getEle("fileSize").innerHTML = "0KB";
        getEle("avgTransRate").innerHTML = "0KB/s";

        getEle("progressBarController").style.display = "block";
        setTimeout("increaseProgression()", 500);
        finished = false;
        return true;
    }
    getEle("fileSelectField").style.border = "1px #f00 solid";
    return false;
}
function increaseProgression(){
    if(finished) return;
    loadStatus(uploadStatusUrl, function() {
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            changeProgression(xmlHttp.responseText);
        }
    });
    setTimeout("increaseProgression()", 500);
}
function changeProgression(status) {
    var statusArray = status.split("|");
    //完成百分比|已上传字节数|总长度|已用时间|剩余时间|平均速度(字节/秒)|当前上传文件序号
    var finishPercent = statusArray[0];
    var uploaded = statusArray[1];
    var fileSize = statusArray[2];
    var usedTime = statusArray[3];
    var needMoreTime = statusArray[4];
    var formattedAvgTransRate = statusArray[5];
    var currentItem = statusArray[6];
    getEle("progression").style.width = finishPercent + "%";
    getEle("finishPercent").innerHTML = finishPercent;
    getEle("usedTime").innerHTML = usedTime;
    getEle("needMoreTime").innerHTML = needMoreTime;
    getEle("uploaded").innerHTML = uploaded;
    getEle("fileSize").innerHTML = fileSize;
    getEle("avgTransRate").innerHTML = formattedAvgTransRate;

    if(finishPercent >= 100){
        finished = true;
    }
}
function checkFileSelectField(){
    if(getEle("fileSelectField").value){
        getEle("fileSelectField").style.border = "1px #fff solid";
        getEle("submitButton").disabled = false;
    } else {
        getEle("fileSelectField").style.border = "1px #f00 solid";
    }
}
function getEle(eleId){
    return document.getElementById(eleId);
}
