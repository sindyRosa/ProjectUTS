package com.example.projectuts.models;

import java.util.List;
//milik cart
public class TeamMain {
    public int gbr;
    public String name;

    public TeamMain(int gbr, String name) {
        this.gbr = gbr;
        this.name = name;
    }

    public static void add(List<TeamMenu> teams) {
    }

    public int getLogo() {
        return gbr;
    }

    public void setLogo(int gambar) {
        this.gbr = gambar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
