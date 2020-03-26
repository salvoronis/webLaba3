package com.laba3;

import javax.faces.context.FacesContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.application.FacesMessage;

import javax.faces.validator.Validator;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("textValidator")
public class TextValidator implements Validator{
	private static final String PATTERN = "^(-?[0-3])|[45]$";

	private Pattern pattern;

	public TextValidator(){
		pattern = Pattern.compile(PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Matcher matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage("Invalid Y", "Incorrect Y");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}