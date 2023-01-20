package com.greatlearning.TicketTrackerApplication.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.TicketTrackerApplication.Entity.Ticket;
import com.greatlearning.TicketTrackerApplication.Service.impl.TicketService;

@Controller
public class TicketController {
	
	public TicketService ticketService;
	
	public TicketController(TicketService theTicketServiceObj) {
		this.ticketService = theTicketServiceObj;
	}
	
	@GetMapping("/ticketList")
	public String listTicket(Model model) {
		model.addAttribute("ticketList", ticketService.listTicket());
		model.addAttribute("standardDate", new Date());
		return "/ticketList";
	}
	
	@GetMapping("/ticketList/new")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "/createTicket";
		
	}

	@PostMapping("/ticketList")
	public String saveEmployee(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/ticketList";
	}
	
	@GetMapping("/search")
	public String searchTicket(Ticket ticket,Model model,String keyword) {
		List<Ticket> list = ticketService.findByKeyword(keyword);
		model.addAttribute("list", list);
		return "searchTicket";		
	}
	
	@GetMapping("/ticketList/edit/{id}")
	public String editTicket(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "editTicket";
	}
	
	@PostMapping("/ticketList/{id}")
	public String updateemployee(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {

		Ticket updTicket = ticketService.getTicketById(id);
		updTicket.setId(id);
		updTicket.setTicketTitle(ticket.getTicketTitle());
		updTicket.setTicketDescription(ticket.getTicketDescription());
		updTicket.setTicketContent(ticket.getTicketContent());

		ticketService.updateTicket(updTicket);
		return "redirect:/ticketList";
	}
	
	@GetMapping("/ticketList/{id}")
	public String deleteticket(@PathVariable Long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/ticketList";
	}

	@GetMapping("/ticketList/view/{id}")
	public String viewTicket(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "viewTicket";
	}
}
