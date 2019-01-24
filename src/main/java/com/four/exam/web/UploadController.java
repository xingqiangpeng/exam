package com.four.exam.web;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class UploadController {
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file,String tpname) throws FileNotFoundException {
        if(file.isEmpty()){
            return "false";
        }
        System.out.println(tpname);
        String fileName = file.getOriginalFilename();
        File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
        File dest = new File(path1.getAbsolutePath(),"upload/"+tpname+"/"+fileName);
        //创建不存在的文件夹
        chuagnajin(dest);
        try {
            file.transferTo(dest); //保存文件
            return tpname+"/"+fileName;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping("download.do")
    public String downLoad(HttpServletResponse response,String filename) throws FileNotFoundException {
        System.out.println(filename);
        File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
        File file = new File(path1.getAbsolutePath(),"upload/"+filename);
        String str= filename.substring(filename.indexOf("/")+1,filename.length());
        System.out.println(str);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +str);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping("cxtfileUpload")
    @ResponseBody
    public String cxtfileUpload(@RequestParam("fileName") MultipartFile file) throws FileNotFoundException {
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
        File dest = new File(path1.getAbsolutePath(),"chengxuti/"+fileName);
        //创建不存在的文件夹
        chuagnajin(dest);
        try {
            file.transferTo(dest); //保存文件
            return fileName;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping("cxtdownload.do")
    public String cxtdownLoad(HttpServletResponse response,String filename) throws FileNotFoundException {
        System.out.println(filename);
        File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
        File file = new File(path1.getAbsolutePath(),"chengxuti/"+filename);
        String str= filename.substring(filename.indexOf("/")+1,filename.length());
        System.out.println(str);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +str);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void chuagnajin(File file){
        if(!file.getParentFile().exists()){ //判断文件父目录是否存在
            chuagnajin(file.getParentFile());
            file.getParentFile().mkdir();
        }
    }
}