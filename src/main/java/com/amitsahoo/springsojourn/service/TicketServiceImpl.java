package com.amitsahoo.springsojourn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitsahoo.springsojourn.entity.Ticket;
import com.amitsahoo.springsojourn.exception.TicketNotFoundException;
import com.amitsahoo.springsojourn.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
   @Autowired
   TicketRepository ticketRepository;

   public List<Ticket> findTickets() {
      return (List<Ticket>) this.ticketRepository.findAll();
   }

   public Ticket findTicket(Long id) {
      Optional<Ticket> optionalTicket = this.ticketRepository.findById(id);
      if (optionalTicket.isPresent()) {
         return optionalTicket.get();
      }

      throw new TicketNotFoundException("Ticket Not Found");
   }

   public Long countTickets() {
      return Long.valueOf(this.ticketRepository.count());
   }
}
