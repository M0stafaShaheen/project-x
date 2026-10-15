package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.* ; 


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Book")
@Entity
public class book {
	@Id
   private long id ; 
	  @NotBlank(message = "Name is required")
	    @Size(min = 3, max = 50,
	          message = "Name must be between 3 and 50 characters")
   private String name  ;  
	

}
