package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.models.Stats;
import org.springframework.http.ResponseEntity;

public interface StatsService {
    ResponseEntity<Stats> getStats();
}
