package com.imbir.cinema.entities;

import java.io.Serializable;


public class Seat implements Serializable {
    private int rowNumber;
    private int seatNumber;
    private boolean taken;

    public Seat() {
        int rowNumber = 0;
        int seatNumber = 0;
        boolean taken = false;
    }

    public Seat(int rowNumber, int seatNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.taken = false;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isTaken() {
        return taken;
    }

    public void book() {
        if (!isTaken()) taken = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else {
            return obj instanceof Seat &&
                   ((Seat) obj).rowNumber == rowNumber &&
                   ((Seat) obj).seatNumber == seatNumber;
        }
    }
}
