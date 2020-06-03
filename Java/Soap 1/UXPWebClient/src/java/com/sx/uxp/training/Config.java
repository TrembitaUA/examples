package com.sx.uxp.training;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private static final String SERVER_IP = "ServerIP";
    private static final String ROAD_INSTANCE = "RoadInstance";
    private static final String MEMBER = "Member";
    private static final String MEMBER_CLASS = "MemberClass";

    private static Config instance = null;

    private String serverIP;
    private String roadInstance;
    private String member;
    private String memberClass;

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private Config() {
        try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties p = new Properties();
            p.load(inputStream);
            serverIP = p.getProperty(SERVER_IP);
            roadInstance = p.getProperty(ROAD_INSTANCE);
            member = p.getProperty(MEMBER);
            memberClass = p.getProperty(MEMBER_CLASS);
        } catch (IOException e) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public String getServerIP() {
        return serverIP;
    }

    public String getRoadInstance() {
        return roadInstance;
    }

    public String getMember() {
        return member;
    }

    public String getMemberClass() {
        return memberClass;
    }
    
}
