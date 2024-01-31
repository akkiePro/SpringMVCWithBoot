package com.akki.SpringMVCWithBoot.controller;

import com.akki.SpringMVCWithBoot.dao.AlienDao;
import com.akki.SpringMVCWithBoot.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("SpringMVCWithBoot")
public class AlienController {

    @Autowired
    private AlienDao dao;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("alien")
    public Alien addAlien(@RequestParam String aid, @RequestParam String aname) {
        Alien alien = new Alien();
        alien.setAid(Integer.parseInt(aid));
        alien.setAname(aname);
        dao.addAlien(alien);
        return alien;
    }

    @GetMapping("aliens")
    public List<Alien> getAliens() {
//        int num = 9 / 0;  // uncomment this line for @AfterThrowing(LoggingAspect.java:29)
        List<Alien> aliens = dao.showAliens();
        return aliens;
    }

    @GetMapping("alien/{aid}")
    public Alien getAlien(@PathVariable int aid) {
        Alien alien = dao.showAlien(aid);
        return alien;
    }

    @GetMapping("getAlienByName")
    public String getAlienByName(@RequestParam String aname, Model m) {
        List<Alien> alien = dao.showAlienByName(aname);
        m.addAttribute("result", alien);
        return "showAliens";
    }

}
