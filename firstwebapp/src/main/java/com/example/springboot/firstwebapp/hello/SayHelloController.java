package com.example.springboot.firstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    @RequestMapping("homepage")
    @ResponseBody
    public String sayHello(){
        return "Hi Om!!";
    }

    @RequestMapping("homepage1")
    @ResponseBody
    public String sayHelloHTML(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Hi Om !!</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Hi Om from HTML!!");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();


    }

    @RequestMapping("homepage2")
    public String sayHelloJSP(){
        return "sayHello";
    }
}
