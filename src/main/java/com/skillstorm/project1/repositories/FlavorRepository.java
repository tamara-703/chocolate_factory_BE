package com.skillstorm.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.project1.models.Flavor;

public interface FlavorRepository extends JpaRepository<Flavor,Integer> {}
