package org.snowpark.controller;

import java.util.ArrayList;
import java.util.List;

import org.snowpark.model.Activity;
import org.snowpark.model.TicketBooking;
import org.snowpark.repository.ActivityRepository;
import org.snowpark.service.ActivityService;
import org.snowpark.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticketbooking")
public class TicketBookingController {
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private TicketBookingService ticketBookingService;
	
	@GetMapping("/addticketbooking")
	public String addTicketBooking(Model model) {
		List<Activity> activities = activityService.getAllActivities();
		TicketBooking ticketbooking = new TicketBooking();
		model.addAttribute("activities", activities);
		model.addAttribute("ticketbooking", ticketbooking);
		return "TicketJsp/addticketbooking";
	}
	
	
	@PostMapping("/addticketbooking")
	public String addTicketBookingProcess(@ModelAttribute("ticketbooking") TicketBooking ticketbooking) {
		
		if(ticketBookingService.addTicketBooking(ticketbooking)==null) {
			return "TicketJsp/ticketbookingunsuccess";
		}else
			return "TicketJsp/ticketbookingsuccess";
	}
	
	
	@GetMapping("/listticketbooking")
	public String listTicketBooking(Model model) {
		List<TicketBooking> list = ticketBookingService.getAllTickets();
		model.addAttribute("ticketbooking",list);
		return "TicketJsp/listticketbooking";
	}
	
	
	@GetMapping("/modifyticketbooking")
	public String modifyTicketBooking(Model model) {
	TicketBooking ticketbooking=new TicketBooking();
	 model.addAttribute("ticketbooking",ticketbooking);
	 return "TicketJsp/modifyticketbooking";
}
	
	
	@PostMapping("/fetchticketbooking")
	public String fetchTicketBooking(@ModelAttribute("ticketbooking")TicketBooking ticketbooking,Model model) {
		ticketbooking=ticketBookingService.findTicketBookingById(ticketbooking.getTicketBookingId());
		if(ticketbooking==null) {
			return "TicketJsp/ticketbookingnotfound";
		}else {
			model.addAttribute("ticketbooking",ticketbooking);
			return "TicketJsp/ticketbookingmodifyfound";
		}
	}
	@PostMapping("/modifyticketbookingprocess")
	public String modifyTicketBookingProcess(@ModelAttribute("ticketbooking")TicketBooking ticketbooking) {
		TicketBooking tkt=ticketBookingService.updateTicketBooking(ticketbooking);
		if(tkt==null) {
			return "TicketJsp/ticketbookingmodifyfailed";
		}else {
			return "TicketJsp/ticketbookingmodifysuccess";
		}
		
	}
	
	@GetMapping("/deleteticketbooking")
	public String deleteTicketBooking(Model model) {
		TicketBooking ticketbooking=new TicketBooking();
		model.addAttribute("ticketbooking", ticketbooking);
		return "TicketJsp/deleteticketbooking";
		}
	
	
	@PostMapping("/fetchfordeleteticketbooking")
	public String fetchForDeleteTicketBooking(@ModelAttribute("ticketbooking")TicketBooking ticketbooking,Model model) {
		ticketbooking=ticketBookingService.findTicketBookingById(ticketbooking.getTicketBookingId());
		if(ticketbooking==null) {
			return "TicketJsp/ticketbookingnotfound";
		}else {
			model.addAttribute("ticketbooking",ticketbooking);
			return "TicketJsp/ticketbookingdeletefound";
		}
	}
	
	
	@PostMapping("/deleteticketbookingprocess")
	public String deleteTicketBookingProcess(@ModelAttribute("ticketbooking")TicketBooking ticketbooking) {
		TicketBooking tkt=ticketBookingService.deleteTicketBooking(ticketbooking.getTicketBookingId());
		if(tkt==null) {
			return "TicketJsp/ticketbookingdeletefailed";
		}else {
			return "TicketJsp/ticketbookingdeletesuccess";
		}
		
	}

}
