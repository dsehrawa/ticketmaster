package com.xyz.ticketmaster.repository;

import com.xyz.ticketmaster.entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    ShowSeat findByCinemaSeatIDAndShowID(int cinemaSeatID, int showID);
}
