package com.company;

import utils.ArrayUtils;
import utils.JTableUtils;
import utils.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class Form extends JFrame{

    private JButton openButton;
    private JButton saveButton;
    private JButton chengeButton;
    private JPanel jPanel;
    private JList list1;
    private JList list2;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public Form() {
        this.setTitle("");
        this.setContentPane(jPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();

        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

       // JTableUtils.writeArrayToJTable(table1, arr);
        //ArrayUtils.readFileJList(list1, list);
        this.pack();
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserOpen.showOpenDialog(jPanel) == JFileChooser.APPROVE_OPTION) {
                        List<Integer> list = ArrayUtils.readListFromFile(fileChooserOpen.getSelectedFile().getPath());
                       ArrayUtils.readFileJList(list1, list);

                    }
                } catch (Exception e1 )
                {
                    SwingUtils.showErrorMessageBox(e1);
                }
            }
        });
        chengeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Integer> list = ArrayUtils.readListFromFile(fileChooserOpen.getSelectedFile().getPath());
                    List<Integer> rList = Logic. process(list);
                    ArrayUtils.readFileJList(list2, rList);

                } catch (Exception e1) {
                    SwingUtils.showErrorMessageBox(e1);
                }}
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserSave.showSaveDialog(jPanel) == JFileChooser.APPROVE_OPTION) {
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }

                        ListModel rList = list2.getModel();
                        String str =  rList.toString();
                        ArrayUtils.writeArrayToFile2(file,str);




                    }
                } catch (Exception e1) {
                    SwingUtils.showErrorMessageBox(e1);
                }
            }
        });
    }
}
