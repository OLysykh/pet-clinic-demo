package oleksandr.spring5.petclinicdemo.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {


    @RequestMapping({"/test","/tests"})
    public String testMethod(){
        return "htmlBasics/index";
    }



}
