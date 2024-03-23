package com.transport.bus_service.util;

import lombok.Getter;

import java.util.List;

@Getter
public class MailConstant {

    enum Host{

        GMAIL("Gmail" , "http://www.gmail.com" , "smtp.gmail.com" , 25 , "smtp");

        private String label;
        private String value;
        private String host;
        private int port;
        private String protocal;
        Host(String gmail, String gmail1, String s, int i, String smtp) {
        }
    }

    private List<Host> hosts;
    public static final String CONNECTION_URL="http://www.google.com";


}
