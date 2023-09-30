package org.snowpark.service;

import java.util.List;

import org.snowpark.model.TicketBooking;
import org.springframework.stereotype.Service;

@Service
public interface TicketBookingService {
	public List<TicketBooking> getAllTickets();
    public TicketBooking addTicketBooking(TicketBooking ticketBooking);
    public TicketBooking findTicketBookingById(Long ticketBookingId);
    public TicketBooking updateTicketBooking(TicketBooking ticketBooking);
    public TicketBooking deleteTicketBooking(Long ticketBookingId);
}
