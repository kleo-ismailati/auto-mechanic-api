package com.codemonkeys.car_mechanic.email.service;

import com.codemonkeys.car_mechanic.email.model.EmailDetails;

public interface EmailService {

    void sendSimpleMail(EmailDetails details);
}
