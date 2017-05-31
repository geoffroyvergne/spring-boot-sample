package com.base.service;

import com.base.common.model.Status;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {

  public Status getStatus() {
    return new Status(0, "Status");
  }

  @Async
  public Future<Status> getLongStatus() throws InterruptedException {
    Thread.sleep(5000);

    Status status = new Status(0, "Long Status");
    return new AsyncResult<>(status);
  }
}
