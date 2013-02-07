package com.mindfine.servlet.model;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-29
 * Time: 下午5:48
 */
public class UploadStatus {
    private long bytesRead;
    private long contentLength;
    private int items;
    private long startTime = System.currentTimeMillis();

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getAvgTransRate() {
        if(uploadNotEnd()){
            return bytesRead / ((System.currentTimeMillis() - startTime) / 1000);
        }
        return 0;
    }

    public String getFormattedAvgTransRate(){
        return formatDataSize(getAvgTransRate()) + "/s";
    }

    public String getNeedMoreTime() {
        long moreTime = 0;
        if (uploadNotEnd()) {
            moreTime = (getContentLength() - getBytesRead()) / (bytesRead / (System.currentTimeMillis() - startTime));
        }
        return formatMillis(moreTime);
    }

    public String getFinishPercent() {
        return String.format("%.2f", (100 * (double)bytesRead / (double)contentLength));
    }

    public String getUsedTime() {
        long usedMilliSecond = System.currentTimeMillis() - startTime;
        return formatMillis(usedMilliSecond);
    }

    public String formatMillis(long usedMilliSecond) {
        long usedSecond = usedMilliSecond / 1000;
        if (usedSecond < 60) {
            return "00:00:" + String.format("%02d", usedSecond);
        } else if (usedSecond < 3600) {
            return "00:" + String.format("%02d", usedSecond / 60) + ":" + String.format("%02d", usedSecond % 60);
        } else {
            return "" + (usedSecond / 3600) + ":" + String.format("%02d", usedSecond % 3600 / 60) + ":" + String.format("%02d", usedSecond % 3600 % 60);
        }
    }

    public boolean uploadNotEnd(){
        return bytesRead != contentLength;
    }

    public String getUploaded() {
        return formatDataSize(bytesRead);
    }

    public String formatDataSize(long bytesQuantity){
        if(bytesQuantity < 1024) return bytesQuantity + "B";
        else if(bytesQuantity < 1024 * 1024) return (bytesQuantity / 1024) + "KB";
        return (bytesQuantity / 1024 / 1024) + "MB";
    }

    public String getFileSize() {
        return formatDataSize(contentLength);
    }
}
