package com.oop_lab.test;

import com.oop_lab.model.khong_gian.DoanThang;
import com.oop_lab.model.khong_gian.DuongThang;
import com.oop_lab.model.khong_gian.MatPhang;
import com.oop_lab.model.khong_gian.ToaDo;
import com.oop_lab.model.khong_gian.Vector;

public class TestVector {
    public static void main(String[] args) {
        Vector a = new Vector(0, 1, 0);
        Vector b = new Vector(1, 0, 0);
        Vector c = new Vector(1, 1, 0);
        Vector d = new Vector(1, 1, 1);
        Vector e = new Vector(1, 1, 0);
        System.out.println(c.equals(e));

        ToaDo x = new ToaDo(0, 0, 0);
        ToaDo y = new ToaDo(5, 5, 5); 
        ToaDo z = new ToaDo(y);

        System.out.println(a.tichCoHuong(c).toString());
        System.out.println(d.nhanFloat(2.0f).toString());
        System.out.println(c.doDai());
        System.out.println(d.doDai());
        a.congVector(b);
        System.out.println(a.toString());
        a.setTo(d);
        System.out.println(a.toString());

        System.out.println(x.khoangCach(y));
        System.out.println(z.toString());

        DoanThang xy = new DoanThang(x, y);
        

        ToaDo p0 = new ToaDo (1,1,1);
        System.out.println(p0.khoangCach(x));
        System.out.println(p0.khoangCach(y));

        float i = xy.doDai();
        float j = p0.khoangCach(x) + p0.khoangCach(y);
        System.out.println(i == j);

        System.out.println("xy = " + xy.doDai());
        System.out.println("tong = " + (p0.khoangCach(x) + p0.khoangCach(y)));

        System.out.println(xy.chuaDiem(p0));

        MatPhang mp = new MatPhang(new Vector(5, -2, -3), new ToaDo(2,5,-7));
        System.out.println(mp.toString());
        System.out.println(mp.chuaDiem(new ToaDo(0, 0, -7)));
        System.out.println(mp.equals(new MatPhang(new ToaDo (2,5,-7), new ToaDo(1,-8, 0), new ToaDo(0, 0, -7))));


        System.out.println("\n\n/////////////////////////////////////");
        DuongThang d0 = new DuongThang(new ToaDo(0,0,-7), new Vector(5, -2, -3), true);
        System.out.println(d0.toString());

        System.out.println(mp.toString());
        System.out.println("chuaDiem: " + d0.chuaDiem(new ToaDo(5, -2, -10)));

        System.out.println(d0.vuongGocVoiMatPhang(mp));

    }
}
