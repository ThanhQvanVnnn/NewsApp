package com.example.apptintuc.Object;

import java.util.Date;

public class TinTuc {
    private int id_tin;
    private String tieude;
    private String mota;
    private String img;
    private String noidung;
    private String ngaydangtin;
    private String tacgia;
    private int solanxem;
    private int tinhot;
    private int trangthai;
    private String id_loaitin;

    public TinTuc(int id_tin, String tieude, String mota, String img, String noidung, String ngaydangtin, String tacgia, int solanxem, int tinhot, int trangthai, String id_loaitin) {
        this.id_tin = id_tin;
        this.tieude = tieude;
        this.mota = mota;
        this.img = img;
        this.noidung = noidung;
        this.ngaydangtin = ngaydangtin;
        this.tacgia = tacgia;
        this.solanxem = solanxem;
        this.tinhot = tinhot;
        this.trangthai = trangthai;
        this.id_loaitin = id_loaitin;
    }

    public int getId_tin() {
        return id_tin;
    }

    public String getTieude() {
        return tieude;
    }

    public String getMota() {
        return mota;
    }

    public String getImg() {
        return img;
    }

    public String getNoidung() {
        return noidung;
    }

    public String getNgaydangtin() {
        return ngaydangtin;
    }

    public String getTacgia() {
        return tacgia;
    }

    public int getSolanxem() {
        return solanxem;
    }

    public int getTinhot() {
        return tinhot;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public String getId_loaitin() {
        return id_loaitin;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public void setNgaydangtin(String ngaydangtin) {
        this.ngaydangtin = ngaydangtin;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public void setSolanxem(int solanxem) {
        this.solanxem = solanxem;
    }

    public void setTinhot(int tinhot) {
        this.tinhot = tinhot;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public void setId_loaitin(String id_loaitin) {
        this.id_loaitin = id_loaitin;
    }
}
