package com.auto_mechanic.auto_mechanic_api.v1.services;

import com.auto_mechanic.auto_mechanic_api.v1.models.EmailDetails;

public interface EmailService {

    void sendSimpleMail(EmailDetails details);
}
