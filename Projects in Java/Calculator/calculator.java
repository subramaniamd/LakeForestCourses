//********************************************************************
// calculator.java
// https://www.geeksforgeeks.org/java-swing-simple-calculator/
// lightly modified by SJZ
//
// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements
//********************************************************************


//
package com.mkyong.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener {

    // attributes -- frame, text display
    static JFrame f;
    static JTextField display;
    String first_input, second_input, third_input;

    // default constrcutor
    calculator()
    {
        first_input = second_input = third_input = "";
    }

    //-----------------------------------------------------------------
    // Creates JFrame and calculator
    //-----------------------------------------------------------------
    public static void main(String args[])
    {
        // create a frame
        f = new JFrame("calculator");

        try {
            // set look and feel
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // create a object of class
        calculator c = new calculator();

        // create a textfield
        display = new JTextField(30);

        // set the textfield to non editable
        display.setEditable(false);
        //
        // create a panel
        JPanel p = new JPanel();



        // here we shuffle an array by temporarily converting it into a list. Used the COllections class found on java api
                Integer[] intAlphabetArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
                List<Integer> intAlphabetList = Arrays.asList(intAlphabetArray);
                Collections.shuffle(intAlphabetList);
        		    intAlphabetList.toArray(intAlphabetArray);
        // here we make an array of just 7 things
                List<Integer> bagOfLetters = new ArrayList<Integer>();
                for (int index = 0; index < 7; index++)
                {
                    bagOfLetters.add(intAlphabetArray[index]);
                }


                if (bagOfLetters.contains( 1) ) {
                JButton a1 = new JButton("a");
                a1.addActionListener(c);
                p.add(a1);

                JButton a2 = new JButton("a");
                a2.addActionListener(c);
                p.add(a2);

                JButton a3 = new JButton("a");
                a3.addActionListener(c);
                p.add(a3);
                }
                else{};



        // create number buttons
        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");

        // equals button
        JButton equals = new JButton("=");

        // create operator buttons
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JButton multiply = new JButton("*");
        JButton clear = new JButton("C");

        // create . button
        JButton decimal = new JButton(".");



        // add action listeners
        multiply.addActionListener(c);
        divide.addActionListener(c);
        minus.addActionListener(c);
        plus.addActionListener(c);
        nine.addActionListener(c);
        eight.addActionListener(c);
        seven.addActionListener(c);
        six.addActionListener(c);
        five.addActionListener(c);
        four.addActionListener(c);
        three.addActionListener(c);
        two.addActionListener(c);
        one.addActionListener(c);
        zero.addActionListener(c);
        decimal.addActionListener(c);
        clear.addActionListener(c);
        equals.addActionListener(c);

        // add elements to panel
        p.add(display);
        p.add(plus);
        p.add(one);
        p.add(two);
        p.add(three);

        p.add(minus);
        p.add(four);
        p.add(five);
        p.add(six);

        p.add(multiply);
        p.add(seven);
        p.add(eight);
        p.add(nine);
        p.add(divide);
        p.add(decimal);

        p.add(zero);
        p.add(clear);
        p.add(equals);


        //
        JLabel headerLabel = new JLabel("Create a word with the buttons available!");
        p.add(headerLabel);
        // set Background of panel
        Color pale_mint = new Color(193,242,206);
        p.setBackground(pale_mint);

        // add panel to frame
        f.add(p);

        f.setSize(350, 450);
        f.setVisible(true);
        //f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //-----------------------------------------------------------------
    // Performs calculations
    //-----------------------------------------------------------------
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!second_input.equals(""))
                third_input = third_input + s;
            else
                first_input = first_input + s;

            // set the value of text
            display.setText(first_input + second_input + third_input);
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            first_input = second_input = third_input = "";

            // set the value of text
            display.setText(first_input + second_input + third_input);
        }
        else if (s.charAt(0) == '=') {

            double te;

            // store the value in 1st
            if (second_input.equals("+"))
                te = (Double.parseDouble(first_input) +
                      Double.parseDouble(third_input));
            else if (second_input.equals("-"))
                te = (Double.parseDouble(first_input) -
                      Double.parseDouble(third_input));
            else if (second_input.equals("/"))
                te = (Double.parseDouble(first_input) /
                      Double.parseDouble(third_input));
            else
                te = (Double.parseDouble(first_input) *
                      Double.parseDouble(third_input));

            // set the value of text
            display.setText(first_input + second_input +
                              third_input + "=" + te);

            // convert it to string
            first_input = Double.toString(te);

            second_input = third_input = "";
        }
        else {
            // if there was no operand
            if (second_input.equals("") || third_input.equals(""))
                second_input = s;
            // else evaluate
            else {
                double te;

                // store the value in 1st
                if (second_input.equals("+"))
                    te = (Double.parseDouble(first_input) +
                          Double.parseDouble(third_input));
                else if (second_input.equals("-"))
                    te = (Double.parseDouble(first_input) -
                          Double.parseDouble(third_input));
                else if (second_input.equals("/"))
                    te = (Double.parseDouble(first_input) /
                          Double.parseDouble(third_input));
                else
                    te = (Double.parseDouble(first_input) *
                          Double.parseDouble(third_input));

                // convert it to string
                first_input = Double.toString(te);

                // place the operator
                second_input = s;

                // make the operand blank
                third_input = "";
            }

            // set the value of text
            display.setText(first_input + second_input + third_input);
        }
    }
}
