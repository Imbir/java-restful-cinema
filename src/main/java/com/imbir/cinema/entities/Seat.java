package com.imbir.cinema.entities;


public class Seat {
    private int rowNumber;
    private int seatNumber;
    private boolean taken;

    public Seat() {
        rowNumber = 0;
        seatNumber = 0;
        taken = false;
    }

    public Seat(int rowNumber, int seatNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.taken = false;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
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
