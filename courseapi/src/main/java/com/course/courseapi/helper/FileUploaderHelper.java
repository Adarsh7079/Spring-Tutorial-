package com.course.courseapi.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.boot.autoconfigure.ssl.SslProperties.Bundles.Watch.File;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploaderHelper {
    public final String UPLOAD_DIR="/home/adarsh/Dev/spring/courseapi/src/main/static/images";
    public boolean uploadFile(MultipartFile f){
        boolean ff=false;

        try {
            // InputStream is=f.getInputStream();
            // byte data[]=new byte[is.available()];
            // is.read(data);

            // //Write
            // FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+f.getOriginalFilename());
            // fos.write(data);
            // fos.close();
            // fos.flush();
            // Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+f.getOriginalFilename(),StandardCopyOption.REPLACE_EXISTINGl));
            ff=true;
        } catch (Exception e) {
            // TODO: handle exception\
            e.printStackTrace();
        }
        return ff;
    }
}