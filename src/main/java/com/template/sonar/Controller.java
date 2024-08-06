package com.template.sonar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping
public class Controller {

    @GetMapping
    public String hello() {
        return "<h1>Hello!</h1>";

        //unnecessary comment
    }

    public String borken (Optional<String> something) {
        Optional<String> myOptional = something;

        return something.get();
    }
 }
