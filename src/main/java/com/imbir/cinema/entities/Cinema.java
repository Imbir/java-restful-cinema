package com.imbir.cinema.entities;

import act.db.morphia.MorphiaModel;
import org.mongodb.morphia.annotations.Entity;


@Entity("cinema")
public class Cinema extends MorphiaModel<Cinema> {
    private String name;

    public Cinema(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else {
            return obj instanceof Cinema &&
                   ((Cinema) obj).name.equals(name);
        }
    }
}
