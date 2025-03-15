package com.prueba.dto;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public class DateRangeRequest {
    @NotNull
    private Instant from;
    @NotNull
    private Instant to;

    public Instant getFrom() {
        return from;
    }

    public void setFrom(Instant from) {
        this.from = from;
    }

    public Instant getTo() {
        return to;
    }

    public void setTo(Instant to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "DateRangeRequest{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
