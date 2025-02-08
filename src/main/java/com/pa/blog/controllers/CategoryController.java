package com.pa.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pa.blog.payloads.ApiResponse;
import com.pa.blog.payloads.CategoryDto;
import com.pa.blog.services.CategoryServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceI categoryServiceI;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cateoDto){
		
		CategoryDto createCategory = this.categoryServiceI.createCategory(cateoDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
		
	}
	
	//update
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
		
		CategoryDto updatedCategory = this.categoryServiceI.updateCategory(categoryDto,catId);
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
		
	}
	
	
	//delete
	

	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		
	 this.categoryServiceI.deleteCategory(catId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfullu!!",false),HttpStatus.OK);
		
	}
	
	
	//get
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
		
    CategoryDto categoryDto = this.categoryServiceI.getCategory(catId);
    return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	
	}
	
	
	//get all
	

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		
   List<CategoryDto> categories = this.categoryServiceI.getCategories();
   return ResponseEntity.ok(categories);
	}
	
}
