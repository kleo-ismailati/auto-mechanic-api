package com.codemonkeys.carmechanicbackend.api.statistics.model;

import lombok.Data;

@Data
public class Stats {

    long totalRepairBookingsActive;
    long totalClients;
    long totalIncome;
    long totalCars;

}
