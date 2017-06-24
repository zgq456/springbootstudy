package hello;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home(String str) {
        System.out.println("str:" + str + " " + new Date());
        return "Hello World2 ! " + str;
    }
	
	@RequestMapping("/home2")
    @ResponseBody
    String home2(String par) {
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//�ȼ���now.toLocaleString()
        System.out.println("###begin:" + myFmt.format(new Date()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String s = "Hello World!  111111111111111111111 222222222222222222222222222222222222222222222222222222222222";
        System.out.println("###par:" + par);
        String s = null;
//        "Hello World!  111111111111111111111 " +
//                "222222222222222222222222222222222222222222222222222222222222" +
//                "33333333333333333333333333333333333333333333333333333333333333" + par;
        try {
            s = FileUtils.readFileToString(new File("data.txt"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + "   home " + s);
        System.out.println("###end:" + myFmt.format(new Date()));
        return s;
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SampleController.class, args);
//    }
}