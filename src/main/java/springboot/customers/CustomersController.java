package springboot.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.customers.repository.Customer;

@RestController
public class CustomersController {

	@Autowired
	CustomersService service;
	
	@RequestMapping("/customers")
	public Iterable<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}	
}
