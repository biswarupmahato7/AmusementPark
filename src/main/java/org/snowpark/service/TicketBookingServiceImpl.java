package org.snowpark.service;

import java.util.List;
import java.util.Optional;

import org.snowpark.model.TicketBooking;
import org.snowpark.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingServiceImpl implements TicketBookingService{

	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	

	@Override
	public List<TicketBooking> getAllTickets() {
		return ticketBookingRepository.findAll();
	}

	@Override
	public TicketBooking addTicketBooking(TicketBooking ticketBooking) {
		return ticketBookingRepository.save(ticketBooking);
	}

	@Override
	public TicketBooking findTicketBookingById(Long ticketBookingId) {
		Optional<TicketBooking> opt=ticketBookingRepository.findById(ticketBookingId);
		if (opt.isPresent())
		{
			return opt.get();
			
		}else
		{
			return null;
		}
	}

	@Override
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking) {
		return ticketBookingRepository.save(ticketBooking);
	}

	@Override
	public TicketBooking deleteTicketBooking(Long ticketBookingId) {
		TicketBooking tkt=ticketBookingRepository.findById(ticketBookingId).get();
		ticketBookingRepository.deleteById(ticketBookingId);
		 return tkt;
	}

}
