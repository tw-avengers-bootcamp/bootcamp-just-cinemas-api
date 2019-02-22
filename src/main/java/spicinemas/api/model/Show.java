package spicinemas.api.model;

import spicinemas.api.db.entities.MovieLocationEntity;

import java.sql.Timestamp;

public class Show {
    private Long id;
    private Timestamp showDate;
    private Long maxSeats;
    private Long amount;


    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setShowDate(Timestamp showDate) {
        this.showDate = showDate;
    }


    public void setMovieLocation(MovieLocationEntity movieLocation) {

    }

    public void setMaxSeats(Long maxSeats) {
        this.maxSeats = maxSeats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getShowDate() {
        return showDate;
    }

    public Long getMaxSeats() {
        return maxSeats;
    }
}
