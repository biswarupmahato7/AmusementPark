package org.snowpark.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="ticketbooking")
public class TicketBooking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ticketBookingId;
	
	@OneToMany
	private List<Activity> activityList = new ArrayList();

	private LocalDateTime bookingDate;
	
	public TicketBooking() {
		
	}
	
	
	public TicketBooking(Long ticketBookingId, List<Activity> activityList, LocalDateTime bookingDate) {
		super();
		this.ticketBookingId = ticketBookingId;
		this.activityList = activityList;
		this.bookingDate = bookingDate;
	}



	public LocalDateTime getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}


	public void setTicketBookingId(Long ticketBookingId) {
		this.ticketBookingId = ticketBookingId;
	}
	

	public Long getTicketBookingId() {
		return ticketBookingId;
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}


	@Override
	public String toString() {
		return "TicketBooking [ticketBookingId=" + ticketBookingId + ", activityList=" + activityList
				+ ", fromDateTime=" + bookingDate + "]";
	}
	
	
}
