package com.zabud.multidata;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zabud.multidata.void1.domain.Something;
import com.zabud.multidata.void1.repo.SomethingReporitory;
import com.zabud.multidata.void2.domain.Thing;
import com.zabud.multidata.void2.repo.ThingReporitory;

@RestController
@RequestMapping("/api")
public class TestController {
  
  @Autowired
  SomethingReporitory somethingReporitory;
  @GetMapping("/test1")
  public List<Something> test1() {
    return somethingReporitory.findAll(); 
  }
  
  @Autowired
  ThingReporitory thingReporitory;
  @GetMapping("/test2")
  public List<Thing> test2() {
    return thingReporitory.findAll(); 
  }
}