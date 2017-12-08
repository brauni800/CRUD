package com.crud.controller;

import com.crud.model.DBConnect;
import com.crud.model.Personas;
import com.crud.model.PersonasValidaciones;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("add.htm")
public class AddController {

    PersonasValidaciones personasValidaciones;
    private JdbcTemplate jdbcTemplate;

    public AddController() {
        this.personasValidaciones = new PersonasValidaciones();
        DBConnect conexion = new DBConnect();
        this.jdbcTemplate = new JdbcTemplate(conexion.connect());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add");
        mav.addObject("personas", new Personas());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("personas") Personas person, BindingResult result, SessionStatus status) {
        this.personasValidaciones.validate(person, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("add");
            mav.addObject("personas", new Personas());
            return mav;
        } else {
            this.jdbcTemplate.update("INSERT INTO persona(nombre, telefono, correo, edad) VALUES (?,?,?,?)",
                    person.getNombre(), person.getTelefono(), person.getCorreo(), person.getEdad());
            return new ModelAndView("redirect:/home.htm");
        }
    }
}
