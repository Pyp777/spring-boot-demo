package springboot.customers.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    List<Customer> findByLastNameOrFirstName(String lastName, String firstName);
    List<Customer> findByLastNameAndFirstName(String lastName, String firstName);

    // this is fail on No property lN found for type Customer
    // List<Customer> findByLNAndFN(String lastName, String firstName);
    
    @Query("SELECT c FROM Customer c WHERE c.age < 30")
    Collection<Customer> findAllYoungUsers();
    
    @Query(value = "SELECT * FROM Customer c WHERE c.age < 30", nativeQuery = true)
    Collection<Customer> findAllYoungUsersNative();    
    
    @Query("SELECT c FROM Customer c WHERE c.age = ?1")
    Customer findCustomerByAge(Integer age);
    
    @Query("SELECT c FROM Customer c WHERE c.firstName like :firstName and c.lastName like :lastName")
    List<Customer> findUserByFistNameAndLastNameNamedParams(
      @Param("firstName") String fistName, 
      @Param("lastName") String lastName);
}