package com.codingdojo.EventsBeltReviewTwo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.EventsBeltReviewTwo.models.User;

@Component
public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
	//8/3/19 Got it to work so user's pw and pw confirmation must match
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
			System.out.println("the two passwords did not match");
		}
		else {
		System.out.println("the two passwords did match");
		//errors.rejectValue("passwordConfirmation", "Match"); //8/3/19 
		}
		
	}

	
	
//	@Override
//	//8/13/19 confirmed that the below works for preventing non duplicate passwords from registering
//public void validate(Object target, Errors errors) {
//	User user = (User) target;
//	
//	if(!user.getPasswordConfirmation().equals(user.getPassword())) {
//		System.out.println("the two passwords did not match");
//		errors.rejectValue("passwordConfirmation", "Match");
//		
//	}
//	else {
//	System.out.println("the two passwords did match");
//	//errors.rejectValue("passwordConfirmation", "Match"); //8/3/19 
//	}
	

	
	
	
	
	
}
