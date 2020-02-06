package com.springdemo.validators;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import com.springdemo.annotations.M2i;

public class CodePromoValidator implements ConstraintValidator<M2i, String>{

	private String s;
	@Override
	public void initialize(M2i arg0) {
		this.s = arg0.value();
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		boolean is_Valid = true;
		if(arg0.equals(null))
		{
			is_Valid = false;
		}
		else
		{
			if(!arg0.equals("m2i2020"))
			{
				is_Valid = false;
			}
		}
		return is_Valid;
	}

}
