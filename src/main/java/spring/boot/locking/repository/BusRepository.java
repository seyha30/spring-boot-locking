//@formatter:off
/**
 * @project spring-boot-locking
 * @author seyha.sin
 * @email sinseyha1@gmail.com
 * @phone 010366946
 * @created on Jan 21, 2024 : 11:11:29 PM
 * @fileName BusRepository.java
 * 
 */
package spring.boot.locking.repository;

import org.springframework.data.repository.CrudRepository;

import spring.boot.locking.entity.BusDetails;

public interface BusRepository  extends CrudRepository<BusDetails, Long>{

}
