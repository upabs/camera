package com.oop_lab.model.graphic2d;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.*;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class RoomPicture extends JFrame {
    private RoomDrawer roomDrawer;

    public RoomPicture(RoomDrawer roomDrawer) {
        this.setSize(
                roomDrawer.getWidth() + 100,
                roomDrawer.getHeight() + 100
        );
        this.setLocationRelativeTo(null);
        this.setContentPane(roomDrawer);
        this.roomDrawer = roomDrawer;
    }
    
    public void exportSVGFile(String fileName) {
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

        this.roomDrawer.paintComponent(svgGenerator);
        try {
            OutputStream outputStream = new FileOutputStream(fileName+".svg");
            Writer outputStreamWriter = new OutputStreamWriter(outputStream);
            svgGenerator.stream(outputStreamWriter, false);
        } catch (Exception e1) {
            e1.printStackTrace();
        }       
    }

    public RoomDrawer getRoomDrawer() {
        return roomDrawer;
    }

    public void setRoomDrawer(RoomDrawer roomDrawer) {
        this.roomDrawer = roomDrawer;
    }
}
