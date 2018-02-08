package com.example.jameedean.e_ideas.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by JameeDean on 12/11/2017.
 */

@IgnoreExtraProperties
public class AgencyModel {
    private String name;
    private String email;
    private String logoUrl;
    private long createdAt;

    public AgencyModel() {}

    public AgencyModel(String name, String email, long createdAt) {
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name   = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String description) {
        this.email = email;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}


