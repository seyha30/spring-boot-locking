//@formatter:off
/**
 * @project spring-boot-locking
 * @author seyha.sin
 * @email sinseyha1@gmail.com
 * @phone 010366946
 * @created on Jan 21, 2024 : 10:43:26 PM
 * @fileName Ticket.java
 * 
 */
package spring.boot.locking.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
@Getter@Setter@Entity@Table
public class Ticket {
	@Id
	private Long id;
	private String firstname;
	private String lastName;
	private String gender;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bus_id")
	private BusDetails busDetails;
	@Version
	private Long version;
}
