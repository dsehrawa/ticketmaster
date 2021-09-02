package com.xyz.ticketmaster.repository;

import com.xyz.ticketmaster.entity.PreBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreBookingRepository extends JpaRepository<PreBooking, Integer> {
}
