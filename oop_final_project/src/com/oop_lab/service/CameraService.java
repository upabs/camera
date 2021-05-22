package com.oop_lab.service;

import com.oop_lab.model.Camera;
import com.oop_lab.model.DoVat;
import com.oop_lab.model.Room;
import com.oop_lab.model.khong_gian.*;

import java.util.ArrayList;
import java.util.List;

public class CameraService {

    public Camera createCamera(ToaDo toaDo, float gocCao, float gocRong) {
        if (cameraHopLe(gocCao, gocRong))
            return new Camera(toaDo, gocCao, gocRong);
        return null;
    }

    public boolean cameraHopLe(float gocCao, float gocRong) {
        return (gocCao > 0 && gocRong > 0);
    }

    public float theTichNhinThay(Camera camera) {
        return camera.getVungNhin().theTich();
    }

    public boolean diemNamTrongVungNhinDuocCuaCamera(Camera camera, ToaDo toaDo) {
        return camera.getVungNhin().chuaDiem(toaDo);
    }

    public List<ToaDo> toaDoChieuCameraLenOxy(Camera camera, Room room) {
        List<ToaDo> dsGiaoDiem = new ArrayList<ToaDo>();
        ToaDo dinhE = camera.getToaDo();
        ToaDo dinhB = camera.getVungNhin().getCacDinh().get(HinhChop.DINH_B);
        ToaDo dinhD = camera.getVungNhin().getCacDinh().get(HinhChop.DINH_D);
        ToaDo tmp;

        DoanThang EB = new DoanThang(dinhE, dinhB);
        tmp = dinhE.diemGanNhat(EB.giaoDiemVoiHinhHopChuNhat(room));
        ToaDo dinhB_ = tmp == null ? dinhB : tmp;

        DoanThang ED = new DoanThang(dinhE, dinhD);
        tmp = dinhE.diemGanNhat(ED.giaoDiemVoiHinhHopChuNhat(room));
        ToaDo dinhD_ = tmp == null ? dinhD : tmp;

        if (dinhB_ == null || dinhD_ == null)
            return null;

        Vector vectorB_D_ = new Vector(dinhB_, dinhD_);
        float B_D_ = dinhB_.khoangCach(dinhD_);
        float k = B_D_ / (40 - 1);

        tmp = dinhB_.clone();
        while (tmp.khoangCach(dinhB_) < B_D_) {
            DoanThang doanThang = new DoanThang(dinhE, tmp);
            List<ToaDo> cacUngCuVien = new ArrayList<ToaDo>();
            for (DoVat doVat : room.getDanhSachDoVat()) {
                List<ToaDo> cacGiaoDiem = doanThang.giaoDiemVoiHinhHopChuNhat(doVat);
                ToaDo ganNhat = dinhE.diemGanNhat(cacGiaoDiem);
                if (ganNhat != null) {
                    cacUngCuVien.add(ganNhat);
                }
            }
            if (cacUngCuVien.isEmpty()) {
                dsGiaoDiem.add(tmp.clone());
            } else if (dinhE.diemGanNhat(cacUngCuVien) != null) {
                dsGiaoDiem.add(dinhE.diemGanNhat(cacUngCuVien).clone());
            }

            tmp.tinhTien(vectorB_D_.nhanFloat(k));
        }
        // tranh sai so -> lam rieng voi D_
        DoanThang doanThang = new DoanThang(dinhE, dinhD_);
        List<ToaDo> cacUngCuVien = new ArrayList<ToaDo>();
        for (DoVat doVat : room.getDanhSachDoVat()) {
            List<ToaDo> cacGiaoDiem = doanThang.giaoDiemVoiHinhHopChuNhat(doVat);
            ToaDo ganNhat = dinhE.diemGanNhat(cacGiaoDiem);
            if (ganNhat != null) {
                cacUngCuVien.add(ganNhat);
            }
        }
        if (cacUngCuVien.isEmpty())
            dsGiaoDiem.add(dinhD_.clone());
        else if (dinhE.diemGanNhat(cacUngCuVien) != null) {
            dsGiaoDiem.add(dinhE.diemGanNhat(cacUngCuVien).clone());
        }

        return dsGiaoDiem;
    }
}
