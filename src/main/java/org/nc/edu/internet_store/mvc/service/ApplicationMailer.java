package org.nc.edu.internet_store.mvc.service;

/**
 * Created by Беспарольный on 17.12.2017.
 */
public interface ApplicationMailer {

    public void sendMail(String to, String subject, String body);

    public void sendPreConfiguredMail(String message);
}
