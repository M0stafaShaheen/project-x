package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.* ; 


@Table(name="Book")
@Entity
public class book {
	
	

	@Id
   private long id ; 
	  @NotBlank(message = "Name is required")
	    @Size(min = 3, max = 50,
	          message = "Name must be between 3 and 50 characters")
   private String name  ;
	
	  public book() {
		  
	  }
	  
	  public book(long id,
			@NotBlank(message = "Name is required") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	  
	  
	  
	  
	  
	
	
}
