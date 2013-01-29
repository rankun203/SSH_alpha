package com.mindfine.servlet.servlet;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

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
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        File clientFile = null;
        File serverFile = null;
        String description = "";
        PrintWriter out = response.getWriter();
        DiskFileUpload diskFileUpload = new DiskFileUpload();
        try {
            List<FileItem> fileItems = diskFileUpload.parseRequest(request);
            for(FileItem fileItem: fileItems){
                if(fileItem.isFormField()) {
                    if ("fileDescription".equals(fileItem.getFieldName())) {
                        System.out.println("收到一段描述：" +  cvtstrWithUtf8(fileItem.getString()) + "<br />");
                    }
                } else {
                    if ("upFile".equals(fileItem.getFieldName())) {
                        clientFile = new File(cvtstrWithUtf8(fileItem.getName()));
                        System.out.println("远程文件的位置：" + clientFile.getAbsolutePath() + "<br />");
                        System.out.println("服务器文件位置：" + cvtstrWithUtf8(request.getServletContext().getRealPath("attachment")) + "下的" + clientFile.getName());
                        serverFile = new File(cvtstrWithUtf8(request.getServletContext().getRealPath("attachment")), clientFile.getName());
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
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("不行，必须用Post方式提交数据。");
    }

    private String cvtstrWithUtf8(String str){
        try {
            return new String(str.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
