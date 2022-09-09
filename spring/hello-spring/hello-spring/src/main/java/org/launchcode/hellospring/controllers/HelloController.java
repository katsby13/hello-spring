package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles request of the form /hello?name=ANY
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // handles request of the form /hello/ANY
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post' >" +
                "<input type = 'text' name = 'name' >" +
                "<label for=\"lang-select\">Choose a language:</label>\n" +
                "\n" +
                "<select name=\"languages\" id=\"lang-select\">\n" +
                "    <option value=\"\">---</option>\n" +
                "    <option value=\"english\">English</option>\n" +
                "    <option value=\"french\">French</option>\n" +
                "    <option value=\"spanish\">Spanish</option>\n" +
                "    <option value=\"korean\">Korean</option>\n" +
                "    <option value=\"japanese\">Japanese</option>\n" +
                "</select>\n" +
                "<input type = 'submit' value = 'Greet me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String languages) {
        if (name == null) {
            name = "World";
        } else if (name.equals("")) {
            name = "World";
        }
        return createMessage(name, languages);
    }
    public static String createMessage(String name, String lang) {
        String greeting = "";
        if (lang.equals("english")) {
            greeting = "Hello, ";
        } else if (lang.equals("french")) {
            greeting = "Bonjour, ";
        } else if (lang.equals("spanish")) {
            greeting = "Hola, ";
        } else if (lang.equals("korean")) {
            greeting = "Annyeong haseyo, ";
        } else if (lang.equals("japanese")) {
            greeting = "Konnichiwa, ";
        }
        return greeting + name;
    }
}
