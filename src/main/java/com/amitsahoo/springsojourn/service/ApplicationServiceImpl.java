package com.amitsahoo.springsojourn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitsahoo.springsojourn.entity.Application;
import com.amitsahoo.springsojourn.exception.ApplicationNotFoundException;
import com.amitsahoo.springsojourn.repository.ApplicationRepository;


@Service
public class ApplicationServiceImpl implements ApplicationService
{
  @Autowired
  private ApplicationRepository applicationRepository;
  
  public List<Application> findApplications() {
     return (List<Application>)this.applicationRepository.findAll();
  }

  
  public Application findApplication(Long id) {
     Optional<Application> optionalApplication = this.applicationRepository.findById(id);
     if (optionalApplication.isPresent()) {
       return optionalApplication.get();
    }

    
     throw new ApplicationNotFoundException("Application Not Found");
  }



  
  public Long countApplications() {
     return Long.valueOf(this.applicationRepository.count());
  }
}



