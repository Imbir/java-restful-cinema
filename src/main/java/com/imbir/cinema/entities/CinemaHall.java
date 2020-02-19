package com.imbir.cinema.entities;

import act.db.morphia.MorphiaModel;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import java.util.ArrayList;


@Entity("hall")
public class CinemaHall extends MorphiaModel<CinemaHall> {
    private ObjectId cinemaId;
    private ArrayList<Seat> hallLayout = new ArrayList<>();

    public CinemaHall(int rows, int seatsInRow, ObjectId cinemaId) {
        this.cinemaId = cinemaId;
        for (int row = 0; row < rows; row++) {
            for (int seat = 0; seat < seatsInRow; seat++) {
                hallLayout.add(new Seat(row + 1, seat + 1));
            }
        }
    }

    public void book(Iterable<Seat> seatsToBook) {
        seatsToBook.forEach((seat) -> hallLayout.get(hallLayout.indexOf(seat)).book());
    }

    public ObjectId getCinemaId() {
        return cinemaId;
    }

    public ArrayList<Seat> getHallLayout() {
        return hallLayout;
    }
}
