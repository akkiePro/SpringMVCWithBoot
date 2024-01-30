package com.akki.SpringMVCWithBoot.controller;

import com.akki.SpringMVCWithBoot.dao.AlienDao;
import com.akki.SpringMVCWithBoot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AlienDao dao;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("addAlien")
    public String addAlien(@ModelAttribute("result") Alien alien) {
        dao.addAlien(alien);
        return "result";
    }

    @GetMapping("getAliens")
    public String getAliens(Model m) {
        List<Alien> aliens = dao.showAliens();
        m.addAttribute("result", aliens);
        return "showAliens";
    }

    @GetMapping("getAlien")
    public String getAlien(@RequestParam int aid, Model m) {
        Alien alien = dao.showAlien(aid);
        m.addAttribute("result", alien);
        return "showAliens";
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam String aname, Model m) {
        List<Alien> alien = dao.showAlienByName(aname);
        m.addAttribute("result", alien);
        return "showAliens";
    }

}
