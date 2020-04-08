package com.example.projectuts.models;

import java.util.List;

public class TeamMenu {
    public int image;
    public String name;
    public int harga;
    private List<TeamMenu> teamMenus;
    public int jumlahPesan;

    public TeamMenu(int logo, String name, int harga) {
        this.image = logo;
        this.name = name;
        this.harga = harga;
    }

    public int getLogo() {
        return image;
    }

    public void setLogo(int logo) {
        this.image = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    public List<TeamMenu> getTeamMenu() {
        return teamMenus;

    }

    public int getJumlahPesan() {
        return jumlahPesan;
    }

    public void setJumlahPesan(int jumlahPesan) {
        this.jumlahPesan = jumlahPesan;
    }

    public void setTeamMenus(List<TeamMenu> teamMenus) {
        this.teamMenus = teamMenus;
    }

    public void addCart(TeamMenu teamMenu){
        this.teamMenus.add(teamMenu);
    }
}
