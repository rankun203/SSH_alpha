package com.mindfine.servlet.servlet;

import com.mindfine.servlet.listener.UploadListener;
import com.mindfine.servlet.model.UploadStatus;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rankun203
 * Date: 13-1-28
 * Time: 下午3:15
 */
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        File clientFile = null;
        File serverFile = null;
        String description = "";
        PrintWriter out = response.getWriter();
        DiskFileUpload diskFileUpload = new DiskFileUpload();

        UploadStatus status = new UploadStatus();
        ProgressListener listener = new UploadListener(status);
        diskFileUpload.setProgressListener(listener);
        request.getSession().setAttribute("uploadStatus", status);

        try {
            List<FileItem> fileItems = diskFileUpload.parseRequest(request);
            for(FileItem fileItem: fileItems){
                if(fileItem.isFormField()) {
                    if ("fileDescription".equals(fileItem.getFieldName())) {
System.out.println("收到一段描述：" +  cvtStrWithUtf8(fileItem.getString()));
                    }
                } else {
                    if ("upFile".equals(fileItem.getFieldName()) && fileItem.getName() != null && !"".equals(fileItem.getName())) {
                        clientFile = new File(cvtStrWithUtf8(fileItem.getName()));
System.out.println("远程文件的位置：" + clientFile.getAbsolutePath());
System.out.println("服务器文件位置：" + cvtStrWithUtf8(request.getServletContext().getRealPath("attachment")) + "下的" + clientFile.getName());
                        serverFile = new File(cvtStrWithUtf8(request.getServletContext().getRealPath("attachment")), clientFile.getName());
                        serverFile.getParentFile().mkdirs();
                        serverFile.createNewFile();
                        InputStream inStream = fileItem.getInputStream();
                        OutputStream outStream = new FileOutputStream(serverFile);

                        try{
                            byte[] buffer = new byte[2048];
                            int len = 0;
                            while((len = inStream.read(buffer)) > -1){
                                outStream.write(buffer, 0, len);
                                outStream.flush();
                            }
System.out.println("已保存文件");
                            out.println("上传完毕<br />");
                            out.println("文件名：" + serverFile.getName() + "<br />");
                            out.println("文件大小：" + String.format("%.3f", (serverFile.length()) / 1024.0 / 1024.0) + "MB<br />-------------------------------<br />");
                        } finally {
                            outStream.close();
                            inStream.close();
                        }
                    } else {
                        out.println("请选择文件！");
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        UploadStatus status = (UploadStatus) request.getSession().getAttribute("uploadStatus");

        response.setContentType("text/html");

        if (status != null) {
            String finishPercent = status.getFinishPercent();
            String uploaded = status.getUploaded();
            String fileSize = status.getFileSize();
            String usedTime = status.getUsedTime();
            String needMoreTime = status.getNeedMoreTime();
            String formattedAvgTransRate = status.getFormattedAvgTransRate();
            int currentItem = status.getItems();
            //完成百分比|已上传字节数|总长度|已用时间|剩余时间|平均速度(字节/秒)|当前上传文件序号
            out.println(finishPercent + "|" + uploaded + "|" + fileSize + "|" + usedTime + "|" + needMoreTime + "|" + formattedAvgTransRate + "|" + currentItem);
        } else {
            out.println("status is null!");
        }
    }


    public String cvtStrWithUtf8(String str){
        try {
            return new String(str.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
