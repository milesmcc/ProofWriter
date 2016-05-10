package com.mdc.math.proofwriter;

import com.mdc.math.proofwriter.gui.DirectProofWriter;
import com.mdc.math.proofwriter.gui.IndirectProofWriter;
import com.mdc.math.proofwriter.util.Convert;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

/**
 * Created by Main on 5/4/16.
 */
public class ProofWriter extends Applet{
    public static void createProofWriter(String[] args){
        JFrame enter = new JFrame("Enter Proof");
        final TextInput textInput = new TextInput();
        enter.setContentPane(textInput.panel1);

        enter.setTitle("Proof Writer");
        enter.setSize(500, 500);

        JFrame out = new JFrame("Enter Proof");
        final TextOutput textOutput = new TextOutput();
        out.setContentPane(textOutput.panel1);

        out.setTitle("Proof Printer");
        out.setSize(500, 500);

        textInput.editorPane1.addKeyListener(new KeyListener() {
            Convert cvt = new Convert();

            @Override
            public void keyTyped(KeyEvent e) {
                update();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                update();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                update();
            }

            public void update(){
                textOutput.textPane1.setText(cvt.convert(textInput.editorPane1.getText()));
            }
        });

        out.setVisible(true);
        enter.setVisible(true);

        //JFrame frame2 = new JFrame();
        //frame2.setContentPane(new DirectProofWriter().getPanel1());
        //frame2.setVisible(true);
    }

    public void paint(Graphics g) {
        createProofWriter(null);
        g.drawString("A window will open with the proof writer momentarily...", 1, 50);
    }
}
