package com.oop_lab.service;

import com.oop_lab.model.DoVat;
import com.oop_lab.model.khong_gian.ToaDo;

import java.util.List;

public class DoVatService {

    public DoVat createDoVat(List<ToaDo> cacDinh) {
        if (doVatLaHinhHopChuNhat(cacDinh))
            return new DoVat(cacDinh);

        return null;
    }

    public boolean doVatLaHinhHopChuNhat(List<ToaDo> cacDinh) {
        // TO DO
        return true;
    }

    public boolean diemNamTrongDoVat(DoVat doVat, ToaDo toaDo) {
        return doVat.chuaDiem(toaDo);
    }
}
