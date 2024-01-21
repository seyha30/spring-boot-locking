//@formatter:off
/**
 * @project spring-boot-locking
 * @author seyha.sin
 * @email sinseyha1@gmail.com
 * @phone 010366946
 * @created on Jan 21, 2024 : 11:12:43 PM
 * @fileName TicketRepository.java
 * 
 */
package spring.boot.locking.repository;

import org.springframework.data.repository.CrudRepository;

import spring.boot.locking.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long>{

}
