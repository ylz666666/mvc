package controller;



import domain.Person;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import util.MyExcetion;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.annotation.Annotation;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class TestController {

//    @Override //写配置的方法 需要实现Controller类 方法固定了参数固定
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        System.out.println(111);
//        return null;
//    }
    @RequestMapping("testOne.do")
    public String test(){
        System.out.println(111);
        //要有返回值 否则页面报错
        return "index.jsp";
    }
    @RequestMapping("testTwo.do")
    public void testTwo(){
        System.out.println(2222);
    }
    @RequestMapping(value="testThree.do")
    public String testThree(Person person){
        System.out.println(person);
        return "test.jsp";
    }
    @RequestMapping("login.do")
    public String login(String name,String password){
        System.out.println(name+"---"+password);
        return "";
    }
    @RequestMapping("test.do")
    public void json(@RequestBody Person person){
        Person p1 = new Person("ylz",18);
        Person p2 = new Person("ylz",18);
        Person p3 = new Person("ylz",18);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        System.out.println(person);

    }

    @RequestMapping("excetion.do")
    public String excetion(){
        System.out.println("异常");
        //捕获异常
        try {
         String  s = null;
         s.length();
        }catch (Exception e){
            //把异常抛给小总管处理 还要写个处理类
            e.printStackTrace();
            throw new MyExcetion("服务端产生问题了");//参数 处理异常携带的信息
        }
        return "test.jsp";
    }
    @RequestMapping("inter.do")
    public String inter(){
        System.out.println("目标方法");
        return "erroe.jsp";
    }
    //文件下载
//    @RequestMapping("upload.do")
//    public String upload(HttpServletRequest request) throws Exception {
//        System.out.println("文件下载");
//        //1.导包 + 三部曲
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        factory.setSizeThreshold(10240000);//设置缓存大小
//        List<FileItem> fileItems = upload.parseRequest(request);//解析request
//        for (FileItem fileItem : fileItems) {
//            if(fileItem.isFormField()){//是一个普通的表单
//                System.out.println(1111);
//                String key = fileItem.getFieldName();//key这里getName是Null
//                String value = fileItem.getString("UTF-8");//value
//                System.out.println(key+"---"+value);
//            }else{//是一个文件
//                System.out.println(2222);
//                String name = fileItem.getName();//key
//                System.out.println("文件名字:"+name);
//                //把上传的文件直接写入
//                fileItem.write(new File("D:\\pages",name));
//        }
//        }
//        return "test.jsp";
//    }
    //文件上传 mvc
    @RequestMapping("upload.do")
    public String upload(MultipartFile upload) throws IOException {
//        System.out.println("mvc文件上传");
//        System.out.println("text:"+text+"---"+"sex:"+sex);

        String name = upload.getOriginalFilename();
        upload.transferTo(new File("D:\\pages",name));
        return "test.jsp";
    }

    //原生文件下载
//    @RequestMapping("download.do")
//    public void download(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        String fileName = request.getParameter("fname");
//        File file = new File("D:\\pages",fileName);
//        InputStream is = new FileInputStream(file);
//        //  做响应啦----设置
//        //   如果服务端存储的文件名字含有中文，需要处理一下
//        fileName = URLEncoder.encode(fileName,"UTF-8");
//        System.out.println("经过处理的中文:"+fileName);
//        //设置响应内容类型 告诉浏览器这个一个下载的文件 保存到本地
//        response.setContentType("application/x-msdownload");
//        //设置响应头 告诉浏览器弹出一个下载框并且显示文件名字提示
//        response.setHeader("Content-disposition","attachment;filename="+fileName);//这里面文件名不能为中文
//        //相应的数据可以用respone
//        OutputStream os = response.getOutputStream();
//        byte[] b = new byte[1024];
//        while (true){
//            int n = is.read(b);
//            if(n==-1){
//                break;
//            }
//            os.write(b,0,n);
//            os.flush();
//        }
//
//    }
    //mvc下载
    @RequestMapping("download.do")
    public ResponseEntity<byte[]> download(String fileName) throws IOException {//文件名字自动注入 名字要和传入的传输名一致
        //1.找到文件路径
        File file = new File("D:\\pages",fileName);
        //2.处理文件名字 用String的方法
        //fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
        fileName = URLEncoder.encode(fileName,"UTF-8");
        System.out.println("经过处理的中文:"+fileName);
        //创建一个请求头
        HttpHeaders headers =new HttpHeaders();
        // 设置响应内容类型 告诉浏览器这个一个下载的文件 保存到本地
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       // 设置响应头 告诉浏览器弹出一个下载框并且显示文件名字提示
        headers.setContentDispositionFormData("attachment",fileName);
        //将响应信息存入一个返回值对象内即可----ResponseEntity
        byte[] b = FileUtils.readFileToByteArray(file);
        return new ResponseEntity(b,headers, HttpStatus.CREATED);
    }
}
