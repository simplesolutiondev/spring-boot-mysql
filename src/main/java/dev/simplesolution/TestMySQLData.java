package dev.simplesolution;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.simplesolution.entity.Customer;
import dev.simplesolution.repository.CustomerRepository;

@Component
public class TestMySQLData implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(TestMySQLData.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// create new customer 
		Customer newCustomer = new Customer();
		newCustomer.setFirstName("John");
		newCustomer.setLastName("Doe");
		newCustomer.setEmail("john@simplesolution.dev");
		newCustomer.setPhone("123-456-789");
		customerRepository.save(newCustomer);
		
		List<Customer> customers = new ArrayList<>(); 
		customerRepository.findAll().forEach(customers::add);
		for(Customer customer: customers) {
			logger.info("Customer: " + customer.toString());
		}
	}
}
