import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.BoxLayout.*;

public class PolView extends JFrame {
    private final JTextField text1 = new JTextField(20);//polynomial 1
    private final JTextField text2 = new JTextField(20);//polynomial 2
    private final JTextArea area1 = new JTextArea(3, 20);
    private final JTextArea area2 = new JTextArea(1, 20);
    private final JButton add = new JButton("Add");
    private final JButton multiply = new JButton("Multiply");
    private final JButton divide = new JButton("Divide");
    private final JButton subtract = new JButton("Subtract");
    private final JButton derivative = new JButton("Derivative");
    private final JButton integrate = new JButton("Integrate");
    private final JPanel four = new JPanel();

    public PolView() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(189, 218, 255));
        mainPanel.setLayout(new BoxLayout(mainPanel, Y_AXIS));

        JPanel spaceP = new JPanel();
        spaceP.setBackground(new Color(189, 218, 255));
        JLabel space = new JLabel("   ");
        spaceP.add(space);
        JPanel spaceP2 = new JPanel();
        spaceP2.setBackground(new Color(189, 218, 255));
        spaceP2.add(space);
        JPanel upPanel = new JPanel();
        upPanel.setBackground(new Color(189, 218, 255));
        JLabel text = new JLabel("Polynomial Calculator");
        text.setFont(new Font("Times new Roman", Font.BOLD, 25));
        upPanel.add(text);
        JPanel one = new JPanel();
        one.setBackground(new Color(189, 218, 255));
        JLabel label1 = new JLabel("First Polynomial = ");
        one.add(label1);
        one.add(text1);
        JPanel two = new JPanel();
        two.setBackground(new Color(189, 218, 255));
        JLabel label2 = new JLabel("Second Polynomial = ");
        two.add(label2);
        two.add(text2);
        JPanel three = new JPanel();
        three.setBackground(new Color(189, 218, 255));
        JLabel label3 = new JLabel("Result = ");
        three.add(label3);
        area1.setLineWrap(true);//to see the output in multiple lines if necessary
        area1.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(area1);
        three.add(scrollPane1);
        four.setBackground(new Color(189, 218, 255));
        JLabel label4 = new JLabel("Remainder = ");
        four.add(label4);
        area2.setLineWrap(true);//to see the output in multiple lines if necessary
        area2.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(area2);
        four.add(scrollPane2);
        four.setVisible(false);
        mainPanel.add(upPanel);//adding the title
        mainPanel.add(spaceP);//an empty space
        mainPanel.add(one); //polynomial 1
        mainPanel.add(two); //polynomial 2
        mainPanel.add(three); //the result/quotient
        mainPanel.add(four); //the remainder
        mainPanel.add(spaceP2);//an empty space

        //adding the buttons
        add.setBackground(new Color(128, 236, 247));
        multiply.setBackground(new Color(128, 236, 247));
        derivative.setBackground(new Color(128, 236, 247));
        integrate.setBackground(new Color(128, 236, 247));
        subtract.setBackground(new Color(128, 236, 247));
        divide.setBackground(new Color(128, 236, 247));
        JPanel buttons = new JPanel();
        JPanel left = new JPanel();
        left.setLayout(new GridLayout(3, 1));
        add.setPreferredSize(new Dimension(170, 40));
        left.add(add);
        left.add(multiply);
        left.add(derivative);
        JPanel right = new JPanel();
        right.setLayout(new GridLayout(3, 1));
        divide.setPreferredSize(new Dimension(170, 40));
        right.add(subtract);
        right.add(divide);
        right.add(integrate);
        buttons.add(left);
        buttons.add(right);
        buttons.setBackground(new Color(189, 218, 255));
        mainPanel.add(buttons);

        this.add(mainPanel);
        this.setSize(450, 400);
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getFirstPol() {
        return text1.getText();
    }

    public String getSecondPol() {
        return text2.getText();
    }

    public void setResult(String result) {
        area1.setText(result);
    }

    public void setResultRemainder(String result) {
        area2.setText(result);
    }

    public void addListener(ActionListener aml) {
        add.addActionListener(aml);
    }

    public void subListener(ActionListener sml) {
        subtract.addActionListener(sml);
    }

    public void mulListener(ActionListener mml) {
        multiply.addActionListener(mml);
    }

    public void divListener(ActionListener dml) {
        divide.addActionListener(dml);
    }

    public void derivativeListener(ActionListener derivative) {
        this.derivative.addActionListener(derivative);
    }

    public void integrateListener(ActionListener integrate) {
        this.integrate.addActionListener(integrate);
    }

    public void setRemainderVisible(boolean value) {
        four.setVisible(value);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
}
