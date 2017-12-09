package com.crud.controller;

import com.crud.model.DBConnect;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteController {
private JdbcTemplate jdbcTemplate;
    public DeleteController(){
        DBConnect conexion = new DBConnect();
        this.jdbcTemplate=new JdbcTemplate(conexion.connect());
    }
    
    @RequestMapping("delete.htm")
    public ModelAndView home(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "delete from persona "
                + "where "
                + "id=? ",
        id);
        return new ModelAndView("redirect:/home.htm");
    }    
}
