package com.greatlearning.TicketTrackerApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.TicketTrackerApplication.Entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {	
	
	@Query(value = "select * from ticket_tracker t where t.ticket_title = :keyword or t.ticket_desc = :keyword", nativeQuery = true)
	 List<Ticket> findByKeyword(@Param("keyword") String keyword);

}