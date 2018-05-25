package com.base.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/test", produces=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, String>> test() {

        Map<Integer, String> status = new HashMap<>();
        status.put(0, "index");

        logger.info("/index/test");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @RequestMapping(value="/other", produces=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, String>> other() {

        Map<Integer, String> status = new HashMap<>();
        status.put(0, "other");

        logger.info("/index/other");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @RequestMapping("/call/test")
    public String callHome() {
        logger.info("/index/call/test");
        return restTemplate.getForObject("http://localhost:8080/index/test", String.class);
    }

    @RequestMapping("/call/other")
    public String callOther() {
        logger.info("/index/call/other");
        return restTemplate.getForObject("http://localhost:8080/index/other", String.class);
    }
}
