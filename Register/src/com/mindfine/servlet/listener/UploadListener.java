package com.mindfine.servlet.listener;

import com.mindfine.servlet.model.UploadStatus;
import org.apache.commons.fileupload.ProgressListener;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-29
 * Time: 下午5:54
 */
public class UploadListener implements ProgressListener {
    private UploadStatus status;

    public UploadListener(UploadStatus status) {
        this.status = status;
    }

    @Override
    public void update(long l, long l2, int i) {
        status.setBytesRead(l);
        status.setContentLength(l2);
        status.setItems(i);
    }
}
