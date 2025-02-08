package com.pa.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pa.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

	
}
