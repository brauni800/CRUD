package com.crud.controller;

import com.crud.model.DBConnect;
import com.crud.model.Personas;
import com.crud.model.PersonasValidaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("edit.htm")
public class EditController {

    PersonasValidaciones personasValidaciones;
    private JdbcTemplate jdbcTemplate;

    public EditController() {
        this.personasValidaciones = new PersonasValidaciones();
        DBConnect conexion = new DBConnect();
        this.jdbcTemplate = new JdbcTemplate(conexion.connect());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Personas datos = this.selectPersona(id);
        mav.setViewName("edit");
        mav.addObject("personas", new Personas(id, datos.getNombre(), datos.getTelefono(), datos.getCorreo(), datos.getEdad()));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("usuarios") Personas u, BindingResult result, SessionStatus status, HttpServletRequest request) {
        this.personasValidaciones.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("id"));
            Personas datos = this.selectPersona(id);
            mav.setViewName("edit");
            mav.addObject("personas", new Personas(id, datos.getNombre(), datos.getTelefono(), datos.getCorreo(), datos.getEdad()));
            return mav;
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            this.jdbcTemplate.update(
                    "update usuarios "
                    + "set nombre=?,"
                    + " correo=?,"
                    + "telefono=? "
                    + "where "
                    + "id=? ",
                    u.getNombre(), u.getCorreo(), u.getTelefono(), id);
            return new ModelAndView("redirect:/home.htm");
        }
    }

    public Personas selectPersona(int id) {
        final Personas user = new Personas();
        String quer = "SELECT * FROM usuarios WHERE id='" + id + "'";
        return (Personas) jdbcTemplate.query(quer, new ResultSetExtractor<Personas>() {
            public Personas extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setNombre(rs.getString("nombre"));
                    user.setCorreo(rs.getString("correo"));
                    user.setTelefono(rs.getString("telefono"));
                }
                return user;
            }
        }
        );
    }
}
