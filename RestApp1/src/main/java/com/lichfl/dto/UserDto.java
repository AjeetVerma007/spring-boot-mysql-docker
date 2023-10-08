package com.lichfl.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank(message = "User Last Name should not be empty")
	private String lastName;
	
	@Email
	@NotBlank
	private String email;


}
