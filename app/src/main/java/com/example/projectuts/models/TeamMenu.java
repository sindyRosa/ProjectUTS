package com.example.projectuts.models;

public class TeamMenu {
    public String image;
    public String name;

    public TeamMenu(String logo, String name) {
        this.image = logo;
        this.name = name;
    }

    public String getLogo() {
        return image;
    }

    public void setLogo(String logo) {
        this.image = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
