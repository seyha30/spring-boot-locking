/**
 * @project spring-boot-locking
 * @author seyha.sin
 * @email sinseyha1@gmail.com
 * @phone 010366946
 * @created on Jan 21, 2024 : 11:10:01 PM
 * @fileName BookingService.java
 * 
 */
package spring.boot.locking.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import spring.boot.locking.entity.BusDetails;
import spring.boot.locking.entity.Ticket;
import spring.boot.locking.repository.BusRepository;
import spring.boot.locking.repository.TicketRepository;

@Service @Transactional
@RequiredArgsConstructor
public class BookingService {
	private final TicketRepository ticketRepository;
	private final BusRepository busRepository;

	private void saveTicket(String firstname, String lastName, String gender, BusDetails busDetails)
			throws SeatNotAvailable {

		if (busDetails.getSeatCapacity() <= busDetails.getTickets().size()) {
			throw new SeatNotAvailable();
		}
		Ticket ticket = new Ticket();
		ticket.setFirstname(firstname);
		ticket.setLastName(lastName);
		ticket.setGender(gender);
		busDetails.addTicket(ticket);
	}

	public void bookTicket() throws SeatNotAvailable, InterruptedException {
		Optional<BusDetails> busDeOptional = busRepository.findWithLockingById(1L);
		if (busDeOptional.isPresent()) {
			saveTicket("John", "Smit", "M", busDeOptional.get());
		}

		Thread.sleep(1000);

	}
	public void bookTicket1() throws SeatNotAvailable, InterruptedException {
		Optional<BusDetails> busDeOptional = busRepository.findById(1L);
		if (busDeOptional.isPresent()) {
			saveTicket("John", "Smit", "M", busDeOptional.get());
		}
		
		Thread.sleep(1000);
		
	}
}
