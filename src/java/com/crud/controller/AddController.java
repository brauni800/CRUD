
package com.crud.controller;

import com.crud.model.DBConnect;
import com.crud.model.Personas;
import com.crud.model.PersonasValidaciones;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
}
