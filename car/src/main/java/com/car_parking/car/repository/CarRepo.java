package com.car_parking.car.repository;

import com.car_parking.car.dao.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Cars, Long> {

}