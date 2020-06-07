package com.zabud.multidata.void2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Thing {
  
  @Id
  @GeneratedValue
  private Integer id;
  private String name;
   
}
