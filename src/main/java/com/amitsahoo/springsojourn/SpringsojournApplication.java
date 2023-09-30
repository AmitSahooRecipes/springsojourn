package com.amitsahoo.springsojourn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringsojournApplication
{
   private static final Logger log = LoggerFactory.getLogger(com.amitsahoo.springsojourn.SpringsojournApplication.class);
  
  public static void main(String[] args) {
     SpringApplication.run(com.amitsahoo.springsojourn.SpringsojournApplication.class, args);
     log.info("Application Started");
  }
}



