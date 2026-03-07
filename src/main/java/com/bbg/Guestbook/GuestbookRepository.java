package com.bbg.Guestbook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<Gusetbook, Long> {
    
}
