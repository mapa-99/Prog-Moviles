import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField input;
    String s0, s1, s2;

    Calculator() {
        s0 = s1 = s2 = "";
    }

    public static void main(String args[]) {

        frame = new JFrame("Calculator");

        // try {

        // nager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        // } catch (Exception e) {
        // em.err.println(e.getMessage());
        // }

        Calculator calc = new Calculator();

        input = new JTextField(20);

        input.setEditable(false);
        // input.setBounds( , 40 , 280, 80);
        input.setBackground(Color.white);

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bplus, bminus, bdivide, bmulti, bdot, berrase, beq1;

        // botones de números
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // botones de operaciones
        beq1 = new JButton("=");
        bplus = new JButton("+");
        bminus = new JButton("-");
        bdivide = new JButton("/");
        bmulti = new JButton("*");
        berrase = new JButton("C");
        bdot = new JButton(".");

        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        bmulti.addActionListener(calc);
        bdivide.addActionListener(calc);
        bminus.addActionListener(calc);
        bplus.addActionListener(calc);
        b9.addActionListener(calc);
        b8.addActionListener(calc);
        b7.addActionListener(calc);
        b6.addActionListener(calc);
        b5.addActionListener(calc);
        b4.addActionListener(calc);
        b3.addActionListener(calc);
        b2.addActionListener(calc);
        b1.addActionListener(calc);
        b0.addActionListener(calc);
        bdot.addActionListener(calc);
        berrase.addActionListener(calc);
        beq1.addActionListener(calc);

        p.add(input);
        p.add(berrase);
        p2.add(bplus);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(bminus);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(bmulti);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(bdivide);
        p2.add(bdot);
        p2.add(b0);
        p2.add(beq1);

        // p.setLayout(new GridLayout());
        p2.setLayout(new GridLayout(4,4,20,25));
        // p2.setLayout(new GridLayout(4, 4, 20, 25));
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.add(p);
        p3.add(p2);
        frame.add(p3);

        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            input.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            input.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {

            double te;

            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            // set the value of text
            input.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";
        } else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            // else evaluate
            else {
                double te;

                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                // convert it to string
                s0 = Double.toString(te);

                // place the operator
                s1 = s;

                // make the operand blank
                s2 = "";
            }

            // set the value of text
            input.setText(s0 + s1 + s2);
        }
    }
}