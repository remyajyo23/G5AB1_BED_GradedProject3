package com.greatlearning.TicketTrackerApplication.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TicketTracker")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ticketTitle")
	private String ticketTitle;
	@Column(name = "ticketDesc")
	private String ticketDescription;
	@Column(name = "ticketCreateOn")
	private String ticketCreateOn;
	@Column(name = "ticketContent")
	private String ticketContent;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ticket() {
		
	}
	
	public Ticket(Long id,String ticketTitle, String ticketDescription, String ticketCreateOn, String ticketContent) {
		super();
		this.id = id;
		this.ticketTitle = ticketTitle;
		this.ticketDescription = ticketDescription;
		this.ticketCreateOn = ticketCreateOn;
		this.ticketContent = ticketContent;
	}
	
	public String getTicketTitle() {
		return ticketTitle;
	}
	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}
	public String getTicketDescription() {
		return ticketDescription;
	}
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}
	public String getTicketCreateOn() {
		return ticketCreateOn;
	}
	public void setTicketCreateOn(String ticketCreateOn) {
		this.ticketCreateOn = ticketCreateOn;
	}
	public String getTicketContent() {
		return ticketContent;
	}
	public void setTicketContent(String ticketContent) {
		this.ticketContent = ticketContent;
	}
	

}
