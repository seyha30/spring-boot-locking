//@formatter:off
/**
 * @project spring-boot-locking
 * @author seyha.sin
 * @email sinseyha1@gmail.com
 * @phone 010366946
 * @created on Jan 21, 2024 : 10:40:40 PM
 * @fileName BusDetails.java
 * 
 */
package spring.boot.locking.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Entity@Table
public class BusDetails {
	@Id
	private Long id;
	private LocalDate departDateTime;
	private Integer seatCapacity;
	@OneToMany(mappedBy = "busDetails")
	private List<Ticket> tickets;
	
	public void addTicket(Ticket ticket) {
		ticket.setBusDetails(this);
		getTickets().add(ticket);
	}

}
