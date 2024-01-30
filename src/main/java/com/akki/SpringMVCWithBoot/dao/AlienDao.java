package com.akki.SpringMVCWithBoot.dao;

import com.akki.SpringMVCWithBoot.model.Alien;
import com.akki.SpringMVCWithBoot.repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlienDao {

    @Autowired
    AlienRepo repo;

    public void addAlien(Alien alien) {
        repo.save(alien);
    }

    public List<Alien> showAliens() {
        List<Alien> aliens = repo.findAll();
        return aliens;
    }

    public Alien showAlien(int aid) {
        Alien alien = repo.findById(aid).orElse(new Alien(0, ""));
//        Alien alien = repo.getOne(aid);   // another way
        return alien;
    }

    public List<Alien> showAlienByName(String aname) {
//        List<Alien> aliens = repo.findByAnameOrderByAidDesc(aname);
        List<Alien> aliens = repo.findAllTargetAliensOrderedDescending(aname);  // another way by using JPQL
        return aliens;
    }
}
