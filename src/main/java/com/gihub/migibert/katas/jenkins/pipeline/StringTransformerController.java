package com.gihub.migibert.katas.jenkins.pipeline;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
public class StringTransformerController {

    private StringTransformer transformer = new StringTransformer();

    @RequestMapping(value = "/first/{input}", method = RequestMethod.GET)
    public ResponseEntity<String> firstTransformation(@PathVariable String input) {
        String result = transformer.firstTransformation(input);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(result);
    }
}