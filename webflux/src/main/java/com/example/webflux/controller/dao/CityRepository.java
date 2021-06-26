package com.example.webflux.controller.dao;

import com.example.webflux.controller.domain.City;
import com.example.webflux.controller.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {

}