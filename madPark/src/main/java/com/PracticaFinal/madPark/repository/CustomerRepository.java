package com.PracticaFinal.madPark.repository;
import com.PracticaFinal.madPark.model.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
    @Query("SELECT * FROM CUSTOMER WHERE CUSTOMER.EMAIL= :email")
    public Iterable<Customer> retrieveCustomer(String email);

    public Customer findByEmail(String email);

    //@Query("INSERT INTO CUSTOMER (CUSTOMER.NAME, CUSTOMER.APELLIDOS, CUSTOMER.EMAIL, CUSTOMER.PASSWORD, CUSTOMER.NUM_TARJETA, CUSTOMER.CVV, CUSTOMER.SCADUCIDAD) VALUES (customer.getName(),customer.getApellidos(),customer.getEmail(), customer.getPassowrd(), customer.getNumTarjeta(), customer.getCvv(), customer.getCaducidad())")
    //public Customer createCustomer(Customer customer);


}
