package com.neumeyer.perfectnumber.application.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Log4j2
public class RemoteAddressUtils {

    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public InetAddress getClientIp() {

        InetAddress ip = null;

        if (request != null) {
            try {
                ip = InetAddress.getByName(request.getRemoteAddr());
            } catch (UnknownHostException ex) {
                log.error("Failed trying to get client remote address: {} - {}", ex.getMessage(), ex.getCause());
            }
        }

        return ip;
    }
}
