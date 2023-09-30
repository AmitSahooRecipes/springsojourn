package com.amitsahoo.springsojourn.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amitsahoo.springsojourn.entity.Application;
import com.amitsahoo.springsojourn.entity.Release;
import com.amitsahoo.springsojourn.entity.Ticket;
import com.amitsahoo.springsojourn.service.ApplicationService;
import com.amitsahoo.springsojourn.service.ReleaseService;
import com.amitsahoo.springsojourn.service.TicketService;

@RestController
@RequestMapping({ "/tza" })
public class TzaRestController {
   private ApplicationService applicationService;
   private TicketService ticketService;
   private ReleaseService releaseService;

   @Autowired
   public void setTicketService(TicketService ticketService) {
      this.ticketService = ticketService;
   }

   @Autowired
   public void setApplicationService(ApplicationService applicationService) {
      this.applicationService = applicationService;
   }

   @Autowired
   public void setReleaseService(ReleaseService releaseService) {
      this.releaseService = releaseService;
   }

   @GetMapping({ "/applications" })
   public ResponseEntity<List<Application>> getAllApplications() {
      List<Application> applications = this.applicationService.findApplications();
      return new ResponseEntity<List<Application>> (applications,HttpStatus.OK);
   }

   @GetMapping({ "/application/{id}" })
   public ResponseEntity<Application> getApplicationbyId(@PathVariable("id") Long id) {
      Application application = this.applicationService.findApplication(id);
      return new ResponseEntity<Application>(application, (HttpStatusCode) HttpStatus.OK);
   }

   @GetMapping({ "/releases" })
   public ResponseEntity<List<Release>> getReleases(Long id) {
      List<Release> releases = this.releaseService.findReleases();
      return new ResponseEntity<List<Release>>(releases, (HttpStatusCode) HttpStatus.OK);
   }

   @GetMapping({ "/release/{id}" })
   public ResponseEntity<Release> getReleasebyId(@PathVariable("id") Long id) {
      Release release = this.releaseService.findRelease(id);
      return new ResponseEntity<Release>(release, (HttpStatusCode) HttpStatus.OK);
   }

   @GetMapping({ "/tickets" })
   public ResponseEntity<List<Ticket>> getAllTickets() {
      List<Ticket> tickets = this.ticketService.findTickets();
      return new ResponseEntity<List<Ticket>>(tickets, (HttpStatusCode) HttpStatus.OK);
   }

   @GetMapping({ "/ticket/{id}" })
   public ResponseEntity<Ticket> getTicketbyId(@PathVariable("id") Long id) {
      return new ResponseEntity<Ticket>(this.ticketService.findTicket(id), (HttpStatusCode) HttpStatus.OK);
   }
}
