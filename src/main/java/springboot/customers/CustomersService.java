package springboot.customers;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import springboot.customers.repository.Customer;
import springboot.customers.repository.CustomerRepository;

@Service
public class CustomersService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * iNITIALIZING data, "Bean" is the keyword!!!
	 * @return
	 */
	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			System.out.println("data  initializein.............");
			customerRepository.save(new Customer("Jack", "Bauer", 25));
			customerRepository.save(new Customer("Chloe", "O'Brian", 35));
			customerRepository.save(new Customer("Kim", "Bauer", 45));
			customerRepository.save(new Customer("Joseph", "Bauer", 25));
			customerRepository.save(new Customer("Seph", "Bauer", 27));
			customerRepository.save(new Customer("David", "Palmer", 22));
			customerRepository.save(new Customer("Michelle", "Dessler", 33));
		};
	}

	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
