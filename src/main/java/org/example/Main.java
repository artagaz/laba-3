package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1
//        Button A = new Button();
//        A.init();

        //2
//        Balance A = new Balance();
//        A.init();

        //3
//        Bell A = new Bell();
//        A.sound(A.called);
//        A.sound(A.called);
//        A.sound(A.called);
//        A.sound(A.called);

        //4
//        OddEvenSeparator A = new OddEvenSeparator();
//        for (int i = 0; i < 10; i++) {
//            A.addNumber();
//        }
//
//        System.out.println(A.even());
//        System.out.println(A.odd());

        //5
        Table A = new Table(10, 15);

        A.setValue(5, 11, 123);
        System.out.println(A.getValue(5, 11));

        System.out.println(A.rows());
        System.out.println(A.cols());
        System.out.println(A.ToString());
        System.out.println(A.average());
    }
}

//1
class Button {
    int count = 0;

    void click() {
        count++;
        System.out.println("Button was clicked " + count + " times");
    }

    void init() {
        JFrame frame = new JFrame("");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Нажми меня!");
        button.addActionListener(click ->
        {
            click();
        });


        frame.getContentPane().add(button);
        frame.setVisible(true);
    }

}

//2
class Balance {
    double leftWeight = 0;
    double rightWeight = 0;

    void addLeft(double w) {
        leftWeight += w;
    }

    void addRight(double w) {
        rightWeight += w;
    }

    String result(double l, double r) {
        if (l > r)
            return "Left";
        else if (r > l)
            return "Right";
        else return "=";
    }

    void init() {
        Font bigFont = new Font("TimesRoman", Font.BOLD, 60);
        Font smallFont = new Font("TimesRoman", Font.BOLD, 15);

        JFrame frame = new JFrame("");
        frame.setSize(620, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea input = new JTextArea("input");
        input.setPreferredSize(new Dimension(600, 50));

        JButton AddLeft = new JButton("Add Left");
        AddLeft.setPreferredSize(new Dimension(200, 300));

        JButton Result = new JButton("result");
        Result.setPreferredSize(new Dimension(200, 300));
        Result.setFont(smallFont);

        JButton AddRight = new JButton("Add Right");
        AddRight.setPreferredSize(new Dimension(200, 300));

        AddLeft.addActionListener(e -> {
            String txt = input.getText();
            try {
                addLeft(Double.parseDouble(txt));
                AddLeft.setText("Add Left " + leftWeight);
                Result.setText("Result");
                Result.setFont(smallFont);
            } catch (NumberFormatException err) {
                Result.setFont(smallFont);
                Result.setText("wrong input");
            }
        });

        AddRight.addActionListener(e -> {
            String txt = input.getText();
            try {
                addRight(Double.parseDouble(txt));
                AddRight.setText("Add Right " + rightWeight);
                Result.setText("Result");
                Result.setFont(smallFont);
            } catch (NumberFormatException err) {
                Result.setFont(smallFont);
                Result.setText("wrong input");
            }
        });

        Result.addActionListener(e -> {
            Result.setFont(bigFont);
            Result.setText(result(leftWeight, rightWeight));

        });

        frame.add(input);
        frame.add(AddLeft);
        frame.add(Result);
        frame.add(AddRight);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
    }

}

//3
class Bell {
    boolean called = false;

    void sound(boolean c) {
        if (!c) System.out.println("ding");
        else System.out.println("dong");
        called = !called;
    }
}

//4
class OddEvenSeparator {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Integer> numbers = new ArrayList<>();

    void addNumber() {
        String input = scanner.nextLine();
        try {
            numbers.add(Integer.parseInt(input));
        } catch (NumberFormatException err) {
            System.out.println("Wrong input");
        }
    }

    ArrayList<Integer> even() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) result.add(number);
        }
        return result;
    }

    ArrayList<Integer> odd() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 1) result.add(number);
        }
        return result;
    }
}

//5
class Table {
    int[][] table;

    Table(int rows, int cols) {
        table = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = 0;
            }
        }
    }

    int getValue(int row, int col) {
        return table[row][col];
    }

    void setValue(int row, int col, int value) {
        table[row][col] = value;
    }

    int rows() {
        return table.length;
    }

    int cols() {
        return table[0].length;
    }

    String ToString() {
        return Arrays.deepToString(table);
    }

    double average() {
        int size = table.length * table[0].length;
        int sum = 0;
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                sum += table[i][j];
            }
        }
        return (double) sum / size;
    }
}