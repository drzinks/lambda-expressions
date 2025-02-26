package com.drzinks.recruitment_tasks.visit_count_per_user;

import java.util.Optional;


public class UserStats {
    public Optional<Long> visitCount;

    public UserStats(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}
