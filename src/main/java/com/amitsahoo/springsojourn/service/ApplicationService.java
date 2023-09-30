package com.amitsahoo.springsojourn.service;

import com.amitsahoo.springsojourn.entity.Application;
import java.util.List;

public interface ApplicationService {
  List<Application> findApplications();
  
  Application findApplication(Long paramLong);
  
  Long countApplications();
}



