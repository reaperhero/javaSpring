package cn.chenqiangjun.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileController {

    //  传统上传方式
    @RequestMapping("fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("成功执行 传统文件上传");

        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断该路径是否存在
        File file = new File(path);
        //不存在则创建该文件夹（在工程target文件夹下）
        if (!file.exists()) {
            file.mkdirs();
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析requesth得到一个list集合
        List<FileItem> items = upload.parseRequest(request);
        System.out.println(items);
        //遍历
        for (FileItem item : items) {
            //进行判断，当前item对象是否是上传文件项
            if (item.isFormField()) {
                //为true，书名普通表单项
                System.out.println("普通表单项");
            } else {
                //为false说明上传文件项
                //获取上传文件的名称
                System.out.println("上传文件项");
                String name = item.getName();
                name = UUID.randomUUID().toString().replace("-","") + "_" +name;
                System.out.println(name);
                //完成文件上传
                item.write(new File(path, name));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    //  springmvc上传方式
    // 需要配置文件解析器
    @RequestMapping("fileupload2")
    public String fileupload2(HttpServletRequest request,MultipartFile upload) throws Exception {
        System.out.println("Springmvc文件上传");

        // 使用fileupload组件
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        // 获取名称
        String filename = upload.getOriginalFilename();
        filename = UUID.randomUUID().toString().replace("-","") + "_" +filename;
        // 完成文件上传
        upload.transferTo(new File(path,filename));
        return "success";
    }
}