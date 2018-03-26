package com.ssmblog.core.admin;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author wangyj
 * @date 2018/3/25
 * @description
 */
@Controller
@RequestMapping("/loading")
public class LoadImageController {

    /**
     * 上传文件
     * @param request
     * @param response
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, HttpServletResponse response, @RequestParam("file")MultipartFile file) throws IOException {
        ServletContext servletContext = request.getSession().getServletContext();
        String dir = servletContext.getRealPath("/upload");
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1, file.getOriginalFilename().length());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random random = new Random();
        String imgName = "";
        if (type.equals("jpg")) {
            imgName = simpleDateFormat.format(new Date()) + random.nextInt(100) + ".jpg";
        } else if (type.equals("png")) {
            imgName = simpleDateFormat.format(new Date()) + random.nextInt(100) + ".png";
        } else if (type.equals("jpeg")) {
            imgName = simpleDateFormat.format(new Date()) + random.nextInt(100) + ".jpeg";
        } else {
            return null;
        }
        FileUtils.writeByteArrayToFile(new File(dir,imgName),file.getBytes());
        response.getWriter().print("upload/"+imgName);
        return null;
    }



}
