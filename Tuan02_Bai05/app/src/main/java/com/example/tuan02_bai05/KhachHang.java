package com.example.tuan02_bai05;

public class KhachHang {
    String name;
    int tt;
    boolean vip;

    public KhachHang(String name, int tt, boolean vip) {
        this.name = name;
        this.tt = tt;
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
