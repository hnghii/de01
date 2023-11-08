package com.example.baovemon.models;

public class XE {
    private int maxe;
    private String tenxe;
    private Integer giaban;
    private String hangxe;
    private Integer trangthai;

    public XE(int maxe, String tenxe, Integer giaban, String hangxe, Integer trangthai) {
        this.maxe = maxe;
        this.tenxe = tenxe;
        this.giaban = giaban;
        this.hangxe = hangxe;
        this.trangthai = trangthai;
    }

    public int getMaxe() {
        return maxe;
    }

    public void setMaxe(int maxe) {
        this.maxe = maxe;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public Integer getGiaban() {
        return giaban;
    }

    public void setGiaban(Integer giaban) {
        this.giaban = giaban;
    }

    public String getHangxe() {
        return hangxe;
    }

    public void setHangxe(String hangxe) {
        this.hangxe = hangxe;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }
}
