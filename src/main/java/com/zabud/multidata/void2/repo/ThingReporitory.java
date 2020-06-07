package com.zabud.multidata.void2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zabud.multidata.void2.domain.Thing;

@Repository
public interface ThingReporitory extends JpaRepository<Thing, Long> {
  
  Thing findById(Integer id); 
  
}