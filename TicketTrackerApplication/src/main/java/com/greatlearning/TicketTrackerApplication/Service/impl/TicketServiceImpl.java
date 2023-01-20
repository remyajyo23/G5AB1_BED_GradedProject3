package com.greatlearning.TicketTrackerApplication.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.TicketTrackerApplication.Entity.Ticket;
import com.greatlearning.TicketTrackerApplication.Repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	private TicketRepository ticketRepository;
	
	@Autowired
	public TicketServiceImpl(TicketRepository theTicketRepoObj) {
		this.ticketRepository = theTicketRepoObj;
	}
	
	@Override
	public List<Ticket> listTicket() {		
		return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> findByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	@Override
	public void deleteTicketById(Long id) {
		ticketRepository.deleteById(id);		
	}
}
