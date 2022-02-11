package com.bigarson.todo.repositories;

import com.bigarson.todo.models.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Integer> {

}
