package com.crud.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonasValidaciones implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> type) {
        return Personas.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Personas personas = (Personas) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "El campo Nombre es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo", "required.correo", "El campo Correo electrónico es Obligatorio.");

        if (!(personas.getCorreo() != null && personas.getCorreo().isEmpty())) {
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(personas.getCorreo());
            if (!matcher.matches()) {
                errors.rejectValue("correo", "correo.incorrect", "El Correo electrónico " + personas.getCorreo() + " no es válido");
            }
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required.telefono", "El campo Teléfono es Obligatorio.");
    }
}
