package com.example.formBinding.entity;

import com.example.formBinding.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@NotNull(message = "is required")
	@Size(min = 1, message="is required")
	private String firstName;
	private String lastName;
	@Pattern(regexp="^[A-Z]{5}\\d{4}[A-Z]$", message="Provide valid pan number")
	private String panNumber;
	private String stream;
	private String gender;
	private String programmingLanguage;
	@Min(value=1, message="rating must be between 1 to 10")
	@Max(value=10, message="rating must be between 1 to 10")
	private int rating;
	@CourseCode(value="ABC", message="Must start with ABC")
	private String courseCode;
	
}
