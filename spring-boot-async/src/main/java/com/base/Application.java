package com.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class Application extends AsyncConfigurerSupport {

  @Value("${executor.corePoolSize}")
  private int corePoolSize;

  @Value("${executor.maxPoolSize}")
  private int maxPoolSize;

  @Value("${executor.queueCapacity}")
  private int queueCapacity;

  @Value("${executor.threadNamePrefix}")
  private String threadNamePrefix;

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public Executor getAsyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setQueueCapacity(queueCapacity);
    executor.setThreadNamePrefix(threadNamePrefix);
    executor.initialize();
    return executor;
  }
}
