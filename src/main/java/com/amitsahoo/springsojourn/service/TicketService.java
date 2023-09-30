package com.amitsahoo.springsojourn.service;

import com.amitsahoo.springsojourn.entity.Ticket;
import java.util.List;

public interface TicketService {
  List<Ticket> findTickets();
  
  Ticket findTicket(Long paramLong);
  
  Long countTickets();
}



