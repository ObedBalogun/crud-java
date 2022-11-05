package com.obed.example.rest.Repo;

import com.obed.example.rest.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
