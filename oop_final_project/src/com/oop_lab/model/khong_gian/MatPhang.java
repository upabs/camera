package com.oop_lab.model.khong_gian;

import java.util.List;

public class MatPhang {
    private ToaDo vectorPhapTuyen;
    private ToaDo diemThuoc;

    private ToaDo[] capVectorChiPhuong = new ToaDo[2];

    public MatPhang() {

    }

    public MatPhang(ToaDo vectorPhapTuyen, ToaDo diemThuoc) {
        this.vectorPhapTuyen = vectorPhapTuyen;
        this.diemThuoc = diemThuoc;
    }

    public MatPhang(ToaDo diemThuoc, ToaDo... capVectorChiPhuong) {
        this.diemThuoc = diemThuoc;
        this.capVectorChiPhuong[0] = capVectorChiPhuong[0];
        this.capVectorChiPhuong[1] = capVectorChiPhuong[1];
        this.vectorPhapTuyen = this.capVectorChiPhuong[0].tichCoHuong(this.capVectorChiPhuong[1]);
    }

    public boolean chuaDiem(ToaDo toaDo) {
        return (
            this.getVectorPhapTuyen().getX() * toaDo.getX() +
            this.getVectorPhapTuyen().getY() * toaDo.getY() +
            this.getVectorPhapTuyen().getZ() * toaDo.getZ() +
            this.giaTriHangSoD() == 0
        );
    }

    public float giaTriHangSoD() {
        float A = this.vectorPhapTuyen.getX();
        float B = this.vectorPhapTuyen.getY();
        float C = this.vectorPhapTuyen.getZ();

        return - (A * this.diemThuoc.getX() + B * this.diemThuoc.getY() + C * this.diemThuoc.getZ());
    }

    public ToaDo getVectorPhapTuyen() {
        return vectorPhapTuyen;
    }

    public void setVectorPhapTuyen(ToaDo vectorPhapTuyen) {
        this.vectorPhapTuyen = vectorPhapTuyen;
    }

    public ToaDo getDiemThuoc() {
        return diemThuoc;
    }

    public void setDiemThuoc(ToaDo diemThuoc) {
        this.diemThuoc = diemThuoc;
    }

    public ToaDo[] getCapVectorChiPhuong() {
        return capVectorChiPhuong;
    }

    public void setCapVectorChiPhuong(ToaDo[] capVectorChiPhuong) {
        this.capVectorChiPhuong = capVectorChiPhuong;
    }
//////////////////////////////////
//    public static  Tugiac(List<ToaDo> toaDoList)
//    {
//
//    }
    public static boolean laHCN(List<ToaDo> toaDoList)
    {
        //ABCD
        int check = 0;
        ToaDo AB = new ToaDo();
        AB = ToaDo.vector(toaDoList.get(0),toaDoList.get(1));
        ToaDo DC = new ToaDo();
        DC = ToaDo.vector(toaDoList.get(3),toaDoList.get(2));
        if(AB.tichCoHuong(DC).equals(new ToaDo(0,0,0)) && (AB.doDaiVector() == DC.doDaiVector()))
        {
            check ++;
        }
        ToaDo AD = new ToaDo();
        AD = ToaDo.vector(toaDoList.get(0),toaDoList.get(3));
        if(AB.tichVoHuong(AD) == 0)
        {
            check++;
        }
        if(check == 2){
            return true;
        }
        else{
            return false;
        }

    }
    @Override
    public boolean equals(Object obj) {
        MatPhang other = (MatPhang) obj;
        ToaDo tichCoHuong = this.vectorPhapTuyen.tichCoHuong(other.getVectorPhapTuyen());
        return (
            other.chuaDiem(this.diemThuoc) &&
            tichCoHuong.getX() == 0 &&
            tichCoHuong.getY() == 0 &&
            tichCoHuong.getZ() == 0
        );
    }
}
