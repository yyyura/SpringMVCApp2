package ie.yyyura.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {

    @GetMapping("/hello")
    public String sayHello(){

        return "hello";
    }


}
