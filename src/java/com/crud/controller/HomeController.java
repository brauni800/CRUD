
package com.crud.controller;

import com.crud.model.DBConnect;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {
    
    private JdbcTemplate jdbcTemplate;
    
    public HomeController() {
        DBConnect conexion = new DBConnect();
        this.jdbcTemplate = new JdbcTemplate(conexion.connect());
    }
    
    @RequestMapping("home.htm")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        String sql = "SELECT * FROM persona";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("home");
        return mav;
    }
}
