package com.obed.example.rest.Repo;

import com.obed.example.rest.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository <Customer,Long> {

}
