//@formatter:off
/**
 * @project spring-boot-locking
 * @author seyha.sin
 * @email sinseyha1@gmail.com
 * @phone 010366946
 * @created on Jan 21, 2024 : 11:38:08 PM
 * @fileName LockingDemoController.java
 * 
 */
package spring.boot.locking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.function.FailableRunnable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.boot.locking.service.BookingService;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class LockingDemoController {
	
	BookingService bookingService;
	
	@GetMapping("/bookTiket")
  public void bookTiket() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(run(bookingService::bookTicket));
		executorService.execute(run(bookingService::bookTicket1));
		executorService.shutdown();
	  
  }

	/**
	 * @param object
	 * @return
	 */
	private Runnable run(FailableRunnable<Exception>  runnable) {
		// TODO Auto-generated method stub
		return () -> {
			try {
				runnable.run();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
}
