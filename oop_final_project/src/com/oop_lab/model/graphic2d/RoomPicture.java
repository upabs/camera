package com.oop_lab.model.graphic2d;

import com.oop_lab.model.Room;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.*;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class RoomPicture extends JFrame {
    private Room room;

    public RoomPicture(Room room, int phongTo) {
        this.room = room;
        this.setSize(
                (int) this.room.getChieuDai() * phongTo + 100,
                (int) this.room.getChieuRong()  * phongTo + 100
        );
        this.setLocationRelativeTo(null);
        RoomDrawer meow = new RoomDrawer(this.room, phongTo);
        this.setContentPane(meow);
    }
    
    public void Print(Room room, int phongTo, String fileName, String type) {
        this.room = room;
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        boolean useCSS = false; // we want to use CSS style attributes

        String File = fileName + "." + type;
        RoomDrawer test = new RoomDrawer(this.room, phongTo);
        test.paintComponent(svgGenerator);
        try {
            OutputStream outputStream = new FileOutputStream(File);
            Writer outputStreamWriter = new OutputStreamWriter(outputStream);
            svgGenerator.stream(outputStreamWriter, useCSS);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }       
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
