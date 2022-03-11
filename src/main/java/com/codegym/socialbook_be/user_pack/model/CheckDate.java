package com.codegym.socialbook_be.user_pack.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CheckDate {
    public LocalDateTime getTimePost() {
        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        return today;
    }

}