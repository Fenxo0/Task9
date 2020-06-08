package com.company;

import utils.ArrayUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Console {
    private static Scanner scanConsole = new Scanner(System.in);

    public void play(String outFile, List<Integer> list) throws FileNotFoundException {
        for(int i = 0; i < list.size(); i++) {
            System.out.print( list.get(i)+" ");
        }
        System.out.println();
        list = Logic.process(list);
        System.out.println();
        System.out.print("Последовательность : ");
        for(int i = 0; i < list.size(); i++) {
            System.out.print( list.get(i)+" ");
        }


        ArrayUtils.writeArrayToFile1(outFile,list);
        System.out.println();
        System.out.println("Список записан в файл " + outFile + " ");
        System.out.println();

    }
}
