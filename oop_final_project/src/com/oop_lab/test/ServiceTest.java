package com.oop_lab.test;

import java.util.ArrayList;
import java.util.List;

import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.ToaDo;
import com.oop_lab.service.DoVatService;
import com.oop_lab.service.RoomService;


public class ServiceTest {
    public static void main(String[] args) {
        RoomService rs = new RoomService();
        DoVatService dvS = new DoVatService();

        // room
        List<ToaDo> dsDinh = new ArrayList<ToaDo>();
        dsDinh.add(new ToaDo(0, 0, 0));
        dsDinh.add(new ToaDo(5, 0, 0));
        dsDinh.add(new ToaDo(5, 5, 0));
        dsDinh.add(new ToaDo(0, 5, 0));
        dsDinh.add(new ToaDo(0, 0, 5));
        dsDinh.add(new ToaDo(5, 0, 5));
        dsDinh.add(new ToaDo(5, 5, 5));
        dsDinh.add(new ToaDo(0, 5, 5));

        // room 1
        List<ToaDo> dsDinh1 = new ArrayList<ToaDo>();
        dsDinh1.add(new ToaDo(1, 0, 0));
        dsDinh1.add(new ToaDo(0, 1, 0));
        dsDinh1.add(new ToaDo(2, 3, 0));
        dsDinh1.add(new ToaDo(3, 2, 0));
        dsDinh1.add(new ToaDo(1, 0, 1));
        dsDinh1.add(new ToaDo(0, 1, 1));
        dsDinh1.add(new ToaDo(2, 3, 1));
        dsDinh1.add(new ToaDo(3, 2, 1));
        
        // vat1
        List<ToaDo> cacDinh1 = new ArrayList<ToaDo>();
        cacDinh1.add(new ToaDo(0.5f, 0.25f, 0));
        cacDinh1.add(new ToaDo(0.75f, 0.25f, 0));
        cacDinh1.add(new ToaDo(0.75f, 0.5f, 0));
        cacDinh1.add(new ToaDo(0.5f, 0.5f, 0));
        cacDinh1.add(new ToaDo(0.5f, 0.25f, 1));
        cacDinh1.add(new ToaDo(0.75f, 0.25f, 1));
        cacDinh1.add(new ToaDo(0.75f, 0.5f, 1));
        cacDinh1.add(new ToaDo(0.5f, 0.5f, 1));

        List<ToaDo> cacDinh2 = new ArrayList<ToaDo>();
        cacDinh2.add(new ToaDo(0.5f, 0.25f, 0));
        cacDinh2.add(new ToaDo(0.75f, 0.25f, 0));
        cacDinh2.add(new ToaDo(0.75f, 0.5f, 0));
        cacDinh2.add(new ToaDo(0.5f, 0.5f, 0));
        cacDinh2.add(new ToaDo(0.5f, 0.5f, 1));
        cacDinh2.add(new ToaDo(0.75f, 0.5f, 1));
        cacDinh2.add(new ToaDo(0.75f, 0.75f, 1));
        cacDinh2.add(new ToaDo(0.5f, 0.75f, 1));

        // Room room = rs.createRoom(dsDinh);
        // Room room1 = rs.createRoom(dsDinh1);
        
        // DoVat vat1 = dvS.createDoVat(cacDinh1);
        // DoVat vat2 = dvS.createDoVat(dsDinh1);
        

        System.out.println("room " + rs.roomLaHinhHopChuNhat(dsDinh));
        System.out.println("room1 " + rs.roomLaHinhHopChuNhat(dsDinh1));
        System.out.println("Vat1 " + dvS.doVatLaHinhHopChuNhat(cacDinh1));
        System.out.println("Vat2 " + dvS.doVatLaHinhHopChuNhat(dsDinh1));
        System.out.println("vat3 " + dvS.doVatLaHinhHopChuNhat(cacDinh2));

        
        // System.out.println("vat1 ko cham room: " + rs.doVatKhongChamTran(room, vat1));
        // System.out.println("vat1 trong room: " + rs.doVatNamTrongPhong(room, vat1));
        // System.out.println("vat1 day or vat khac: " + rs.doVatNamTrenSanHoacTrenVatKhac(room, vat1));
        // System.out.println("them vat1 trong room: " + rs.themDoVat(room, vat1));

        // System.out.println("\nvat2 ko cham room: " + rs.doVatKhongChamTran(room, vat2));
        // System.out.println("vat2 trong room: " + rs.doVatNamTrongPhong(room, vat2));
        // System.out.println("vat2 day or vat khac: " + rs.doVatNamTrenSanHoacTrenVatKhac(room, vat2));
        // System.out.println("vat 2 ko bi vuong: " + rs.doVatKhongBiVuong(room, vat2));
        // System.out.println("\nthem vat2 trong room; " + rs.themDoVat(room, vat2));
        // for(ToaDo p : vat1.getCacDinh().values()) {
        //     System.out.println(p.toString());
        //     System.out.println(room.chuaDiem(p));

        //     System.out.println((p.khoangCachDenMatPhang(room.getCacMat().get(Room.MAT_AEFB))
        //     + p.khoangCachDenMatPhang(room.getCacMat().get(Room.MAT_CDHG))));

        //     System.out.println((p.khoangCachDenMatPhang(room.getCacMat().get(Room.MAT_ADHE))
        //     + p.khoangCachDenMatPhang(room.getCacMat().get(Room.MAT_BCGF))));

        //     System.out.println((p.khoangCachDenMatPhang(room.getCacMat().get(Room.MAT_DAY_DUOI_ABCD))
        //     + p.khoangCachDenMatPhang(room.getCacMat().get(Room.MAT_DAY_TREN_EFGH))));
            
        //     System.out.println();
        // }

        // List<ToaDo> a = new ArrayList<>();
        // for (ToaDo p : a) {
        //     System.out.println("ddd");
        // }
    }
}
