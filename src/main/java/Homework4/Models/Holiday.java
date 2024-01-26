package Homework4.Models;

import java.time.Year;
import java.util.Date;

public enum Holiday {
    NEW_YEAR(new Date(Year.now().getValue(), 1, 1)),
    MARCH_8 (new Date(Year.now().getValue(), 3, 8)),
    FEBRUARY_23 (new Date(Year.now().getValue(), 2, 23)),
    NONE (new Date());
    private Date date;

    Holiday(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
