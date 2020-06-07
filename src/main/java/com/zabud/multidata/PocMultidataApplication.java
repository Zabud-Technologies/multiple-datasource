package com.zabud.multidata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.zabud.multidata.void1.repo.SomethingReporitory;

@SpringBootApplication
public class PocMultidataApplication {

  public static void main(String[] args) {
    SpringApplication.run(PocMultidataApplication.class, args);
  }

}
