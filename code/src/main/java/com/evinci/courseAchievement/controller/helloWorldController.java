package courseAchievement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
    @RequestMapping("/")
    public String initSpeaking() {
        String str = "Hello! Here is the course achievement system of evinci.";
        return str;
    }
}
