package com.xyz.ticketmaster.dto;

import java.time.LocalDateTime;


public interface MovieShowView {

    LocalDateTime getStartTime();

    LocalDateTime getEndtime();

    String getCinema_hall_name();

    String getCinema_name();

    String getCity_name();

}
