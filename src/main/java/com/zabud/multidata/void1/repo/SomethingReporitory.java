package com.zabud.multidata.void1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zabud.multidata.void1.domain.Something;

@Repository
public interface SomethingReporitory extends JpaRepository<Something, Long> {
  
  Something findById(Integer id); 
  
}