package com.base.facade;

import com.base.common.model.Status;
import com.base.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/async")
public class AsyncController {

  @Autowired
  AsyncService asyncService;

  private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

  @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public ResponseEntity<Status> test() {

    Status status = asyncService.getStatus();

    logger.info("async/test");

    return new ResponseEntity<>(status, HttpStatus.OK);
  }

  @RequestMapping(value = "/longtest", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public Callable<ResponseEntity<Status>> longTest() throws InterruptedException {

    Future<Status> status = asyncService.getLongStatus();

    return () -> ResponseEntity.ok(status.get());
  }
}
