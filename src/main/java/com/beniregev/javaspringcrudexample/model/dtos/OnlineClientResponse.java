package com.beniregev.javaspringcrudexample.model.dtos;

import com.beniregev.javaspringcrudexample.model.Client;
import lombok.Data;

import java.util.Date;

@Data
public class OnlineClientResponse {
    private String username;
    private Date loginTime;
    private Date lastUpdated;
    private String ip;

    public OnlineClientResponse(Client client) {
        this.username = client.getUsername();
        this.loginTime = client.getLoginTime();
        this.lastUpdated = client.getLastUpdated();
        this.ip = client.getIp();
    }
}
