package dev.simplesolution.repository;

import org.springframework.data.repository.CrudRepository;
import dev.simplesolution.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
