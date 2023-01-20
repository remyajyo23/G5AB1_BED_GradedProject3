package com.greatlearning.TicketTrackerApplication.Service.impl;

import java.util.List;

import com.greatlearning.TicketTrackerApplication.Entity.Ticket;

public interface TicketService {
	
	public List<Ticket> listTicket();
	
	public Ticket saveTicket(Ticket ticket);
	
	public List<Ticket> findByKeyword(String keyword);
	
	Ticket getTicketById(Long id);
	
	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(Long id);

}
