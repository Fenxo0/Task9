package com.company;

import utils.ArrayUtils;
import utils.SwingUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);
        if (args.length != 2 && args.length != 3){
            System.err.println("Введены неправильные аргументы");
            return;
        }
        if (!"console".equals(args[0]) & !"window".equals(args[0])){
            System.err.println("Выберите вид программы");
            return;
        }

        List<Integer> list = ArrayUtils.readListFromFile(args[1]);

        if (list.isEmpty() ) {
            System.err.println("В исходном файле не содержится массив");
            return;
        }

        if ("console".equals(args[0])) {
            Console console = new Console();
            console.play(args[2], list);

        } else if ("window".equals(args[0])) {
            SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    (new Form()).setVisible(true);
                }
            });
        }
    }
}
