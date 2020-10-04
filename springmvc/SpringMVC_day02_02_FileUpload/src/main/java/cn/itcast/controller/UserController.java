package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年02月19日 15:49:00
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /*SpringMVC 文件上传*/
    @RequestMapping("/testFileUpload")
//   MultipartFile upload：固定写法，必须这么写，
// 其中upload为文件上传项，必须与表单中的文件选择域中的name值相同
    public String testFileUpload(HttpServletRequest request, MultipartFile upload) throws IOException {

        System.out.println("FileUpload执行。。。");

//       1. 获取文件的上传路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file=new File(path);
//       2.判断路径是否存在
        if(!file.exists()){
//            2.1如果路径不存在，就创建
            file.mkdirs();
        }

//        上传的文件已经通过SpringMVC.xml中的文件解析器对象解析过了

//        3.获取上传文件的文件名
        String originalFilename = upload.getOriginalFilename();
//        使用UUID将文件名设置为唯一值，防止出现文件名重复现象
//        原始的UUID会有"-"分隔符，这里将其替换为空字符
        String UUIDS = UUID.randomUUID().toString().replace("-", "");
        String fileName=UUIDS+"_"+originalFilename;
//      4.完成文件上传
        upload.transferTo(new File(path,fileName));
        return "success";
    }

    /*跨服务器文件上传*/
    @RequestMapping("/testFileUpload2")
//   MultipartFile upload：固定写法，必须这么写，
// 其中upload为文件上传项，必须与表单中的文件选择域中的name值相同
    public String testFileUpload2(MultipartFile upload) throws IOException {

        System.out.println("跨服务器FileUpload2执行。。。");

//       1. 定义文件的路径
           String path="http://localhost:8081/uploads/";

//        上传的文件已经通过SpringMVC.xml中的文件解析器对象解析过了

//        2.获取上传文件的文件名
        String originalFilename = upload.getOriginalFilename();
//        使用UUID将文件名设置为唯一值，防止出现文件名重复现象
//        原始的UUID会有"-"分隔符，这里将其替换为空字符
        String UUIDS = UUID.randomUUID().toString().replace("-", "");
        String fileName=UUIDS+"_"+originalFilename;

//      3.创建客户端对象
        Client client=Client.create();

//      4.和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);
//        上传文件
//        这里需要传入的是一个二进制文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
