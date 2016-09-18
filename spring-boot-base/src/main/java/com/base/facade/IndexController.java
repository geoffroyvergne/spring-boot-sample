package com.base.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.config.ConfigObject;
import com.base.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${test.value}")
    private String testValue;

    @Autowired
    private ConfigObject configObject;

    @RequestMapping(value="/test", produces=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Status> test() {

        logger.info("configObject : " + configObject);
        return new ResponseEntity<>(new Status(0, "index " + testValue), HttpStatus.OK);
    }
}
