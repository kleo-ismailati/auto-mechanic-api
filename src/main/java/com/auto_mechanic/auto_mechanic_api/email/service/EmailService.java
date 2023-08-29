package com.auto_mechanic.auto_mechanic_api.email.service;

import com.auto_mechanic.auto_mechanic_api.email.model.EmailDetails;

public interface EmailService {

    void sendSimpleMail(EmailDetails details);
}
