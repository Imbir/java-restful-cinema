package com.imbir.cinema;

import act.controller.Controller;
import act.db.morphia.MorphiaDao;
import com.imbir.cinema.entities.Cinema;
import com.imbir.cinema.entities.CinemaHall;
import com.imbir.cinema.entities.Seat;
import org.bson.types.ObjectId;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PostAction;
import org.osgl.mvc.annotation.PutAction;
import java.util.ArrayList;


public class CinemaHallController extends Controller.Util {
    private MorphiaDao<Cinema> cinemaDao = Cinema.dao();
    private MorphiaDao<CinemaHall> hallDao = CinemaHall.dao();

    @GetAction("/hall")
    public Iterable<CinemaHall> getAllHalls() {
        return hallDao.findAll();
    }

    @GetAction("/hall/{id}")
    public CinemaHall getHall(String id) {
        return hallDao.findById(new ObjectId(id));
    }

    @GetAction("/halls/{cinemaId}")
    public Iterable<CinemaHall> getCinemaHalls(String cinemaId) {
        Cinema cinema = cinemaDao.findById(new ObjectId(cinemaId));
        notFoundIfNull(cinema, "Specified cinema not found");
        return hallDao.findBy("cinemaId", new ObjectId(cinemaId));
    }

    @PostAction("/hall/{cinemaId}")
    public CinemaHall createHall(String cinemaId, int rows, int rowSeats) {
        Cinema cinema = cinemaDao.findById(new ObjectId(cinemaId));
        notFoundIfNull(cinema, "Specified cinema not found");
        return hallDao.save(new CinemaHall(rows, rowSeats, cinema._id()));
    }

    @PutAction("/book/{hallId}")
    public CinemaHall bookSeats(String hallId, ArrayList<Seat> booking) {
        CinemaHall hall = hallDao.findById(new ObjectId(hallId));
        notFoundIfNull(hall, "Specified hall not found");
        hall.book(booking);
        return hallDao.save(hall);
    }
}
