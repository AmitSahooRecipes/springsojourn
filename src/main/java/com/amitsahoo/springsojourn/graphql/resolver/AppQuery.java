package com.amitsahoo.springsojourn.graphql.resolver;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.amitsahoo.springsojourn.entity.Application;
import com.amitsahoo.springsojourn.repository.ApplicationRepository;
import  com.amitsahoo.springsojourn.exception.ApplicationNotFoundGQLException;



@Controller
public class AppQuery {

   @Autowired
   private ApplicationRepository applicationRepository;

   public AppQuery(ApplicationRepository applicationRepository) {
      this.applicationRepository = applicationRepository;
   }

   @QueryMapping
   public List<Application> findAllApplications() {
      return (List<Application>) this.applicationRepository.findAll();
   }

   @QueryMapping
   public Application findApplication(@Argument Long id) {
      Optional<Application> optionalApplication = this.applicationRepository.findById(id);
      if (optionalApplication.isPresent()) {
         return optionalApplication.get();
      }
      throw new ApplicationNotFoundGQLException("Application Not Found", id);
   }

   @QueryMapping
   public Long countApplications() {
      return Long.valueOf(this.applicationRepository.count());
   }
}


