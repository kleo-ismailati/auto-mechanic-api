package com.auto_mechanic.auto_mechanic_api.v1.models;

import lombok.Data;

@Data
public class Stats {

    long totalRepairBookingsActive;
    long totalClients;
    long totalIncome;
    long totalAutos;

}