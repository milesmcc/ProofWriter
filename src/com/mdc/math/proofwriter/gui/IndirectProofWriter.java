package com.mdc.math.proofwriter.gui;

import com.mdc.math.proofwriter.util.Convert;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Main on 5/4/16.
 */
public class IndirectProofWriter {
    private JPanel panel1;
    private JTextArea givenThatTriABCTextArea;
    private JTextArea textArea1;
    private JButton copyFormattedProofButton;

    public JPanel getPanel1(){
        return panel1;
    }

    public void copyProofToClipboard(){
        StringSelection selection = new StringSelection(textArea1.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    public IndirectProofWriter(){
        Font niceAssFont = new Font("Georgia", Font.LAYOUT_LEFT_TO_RIGHT, 12);
        givenThatTriABCTextArea.setFont(niceAssFont);
        textArea1.setFont(niceAssFont);
        copyFormattedProofButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyProofToClipboard();
            }
        });
        givenThatTriABCTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performConversion();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performConversion();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performConversion();
            }

            public void performConversion(){
                {
                    String text = givenThatTriABCTextArea.getText();
                    Convert convert = new Convert();
                    String formattedText = convert.convert(text);
                    StyledDocument document = new DefaultStyledDocument();
                    try {
                        document.insertString(0, formattedText, new SimpleAttributeSet());

                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    textArea1.setDocument(document);
                }
            }
        });
    }
}
