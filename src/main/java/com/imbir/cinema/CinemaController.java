package com.imbir.cinema;

import act.controller.Controller;
import act.db.morphia.MorphiaDao;
import com.imbir.cinema.entities.Cinema;
import org.bson.types.ObjectId;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PostAction;


public class CinemaController extends Controller.Util {
    private MorphiaDao<Cinema> cinemaDao = Cinema.dao();

    @GetAction("/cinema")
    public  Iterable<Cinema> getCinemaList() {
        return cinemaDao.findAll();
    }

    @GetAction("/cinema/{id}")
    public Cinema getCinema(String id) {
        return cinemaDao.findById(new ObjectId(id));
    }

    @PostAction("/cinema")
    public Cinema createCinema(String name) {
        return cinemaDao.save(new Cinema(name));
    }
}
