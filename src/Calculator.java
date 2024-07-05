import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    int c;
    String s1, s2;
    Frame f;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, badd, bsub, bmul, bdiv, beq, bclr;
    Panel p;
    TextField t1;
    GridLayout g;
    Font boldFont = new Font("Arial", Font.BOLD, 12);
    Font regularFont = new Font("Arial", Font.PLAIN, 12);

    Calculator() {
        f = new Frame("Calculator");
        f.setLayout(new FlowLayout());
        p = new Panel();

        b0 = new Button("0");
        b0.addActionListener(this);

        b1 = new Button("1");
        b1.addActionListener(this);

        b2 = new Button("2");
        b2.addActionListener(this);

        b3 = new Button("3");
        b3.addActionListener(this);

        b4 = new Button("4");
        b4.addActionListener(this);

        b5 = new Button("5");
        b5.addActionListener(this);

        b6 = new Button("6");
        b6.addActionListener(this);

        b7 = new Button("7");
        b7.addActionListener(this);

        b8 = new Button("8");
        b8.addActionListener(this);

        b9 = new Button("9");
        b9.addActionListener(this);

        badd = new Button("+");
        badd.addActionListener(this);

        bsub = new Button("-");
        bsub.addActionListener(this);

        bmul = new Button("*");
        bmul.addActionListener(this);

        bdiv = new Button("/");
        bdiv.addActionListener(this);

        beq = new Button("=");
        beq.addActionListener(this);

        bclr = new Button("CLR");
        bclr.addActionListener(this);

        t1 = new TextField(20);
        f.add(t1);

        g = new GridLayout(4, 4);
        p.setLayout(g);

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(badd);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bsub);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bmul);
        p.add(bclr);
        p.add(b0);
        p.add(beq);
        p.add(bdiv);

        f.add(p);
        f.setSize(200, 250);
        f.setVisible(true);
        f.setBackground(Color.LIGHT_GRAY);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button source = (Button) e.getSource();

        if (source == b0) {
            t1.setText(t1.getText() + "0");
        } else if (source == b1) {
            t1.setText(t1.getText() + "1");
        } else if (source == b2) {
            t1.setText(t1.getText() + "2");
        } else if (source == b3) {
            t1.setText(t1.getText() + "3");
        } else if (source == b4) {
            t1.setText(t1.getText() + "4");
        } else if (source == b5) {
            t1.setText(t1.getText() + "5");
        } else if (source == b6) {
            t1.setText(t1.getText() + "6");
        } else if (source == b7) {
            t1.setText(t1.getText() + "7");
        } else if (source == b8) {
            t1.setText(t1.getText() + "8");
        } else if (source == b9) {
            t1.setText(t1.getText() + "9");
        } else if (source == badd) {
            s1 = t1.getText();
            t1.setText("");
            c = 1;
            resetButtonFonts();
            badd.setFont(boldFont);
        } else if (source == bsub) {
            s1 = t1.getText();
            t1.setText("");
            c = 2;
            resetButtonFonts();
            bsub.setFont(boldFont);
        } else if (source == bmul) {
            s1 = t1.getText();
            t1.setText("");
            c = 3;
            resetButtonFonts();
            bmul.setFont(boldFont);
        } else if (source == bdiv) {
            s1 = t1.getText();
            t1.setText("");
            c = 4;
            resetButtonFonts();
            bdiv.setFont(boldFont);
        } else if (source == beq) {
            s2 = t1.getText();
            double result = 0;
            switch (c) {
                case 1:
                    result = Double.parseDouble(s1) + Double.parseDouble(s2);
                    break;
                case 2:
                    result = Double.parseDouble(s1) - Double.parseDouble(s2);
                    break;
                case 3:
                    result = Double.parseDouble(s1) * Double.parseDouble(s2);
                    break;
                case 4:
                    result = Double.parseDouble(s1) / Double.parseDouble(s2);
                    break;
            }
            t1.setText(String.valueOf(result));
            resetButtonFonts();
        } else if (source == bclr) {
            t1.setText("");
            resetButtonFonts();
        }
    }

    private void resetButtonFonts() {
        badd.setFont(regularFont);
        bsub.setFont(regularFont);
        bmul.setFont(regularFont);
        bdiv.setFont(regularFont);
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
}
