package com.amitsahoo.springsojourn.graphql.mutator;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import com.amitsahoo.springsojourn.entity.Application;
import com.amitsahoo.springsojourn.exception.ApplicationNotFoundGQLException;
import com.amitsahoo.springsojourn.repository.ApplicationRepository;

@Controller
public class AppMutation {
    @Autowired
    private ApplicationRepository applicationRepository;

    
    public AppMutation(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @MutationMapping
    public Application newApplication(@Argument String name, @Argument String owner,
                                      @Argument String description) {
        Application app = new Application(name, owner, description);
        applicationRepository.save(app);
        return app;
    }

    @MutationMapping
    public boolean deleteApplication(@Argument Long id) {
        applicationRepository.deleteById(id);
        return true;
    }

    @MutationMapping
    public Application updateApplicationOwner(@Argument String newOwner, @Argument Long id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);

        if(optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setOwner(newOwner);
            applicationRepository.save(application);
            return application;
        } else {
            throw new ApplicationNotFoundGQLException("Application Not Found", id);
        }
    }
}