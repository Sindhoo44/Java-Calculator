import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cal extends JFrame implements ActionListener {

    JTextField textField = new JTextField();
    JButton[] numButtons = new JButton[10];
    JButton[] functionsButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, decButton, eqlButton, delButton, clrButton, negButton;
    JPanel panel;

    double num1, num2, result=0;
    char operator;

    Cal(){

        this.setSize(220,350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        textField.setBounds(10,10,200,30);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqlButton = new JButton("=");
        negButton = new JButton("(-)");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionsButton[0] = addButton;
        functionsButton[1] = subButton;
        functionsButton[2] = mulButton;
        functionsButton[3] = divButton;
        functionsButton[4] = decButton;
        functionsButton[5] = eqlButton;
        functionsButton[6] = delButton;
        functionsButton[7] = clrButton;
        functionsButton[8] = negButton;

        for (int i = 0; i < 9; i++){
            functionsButton[i].addActionListener(this);
            functionsButton[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(10,50,200,200);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);

        clrButton.setBounds(10,260,60,50);
        delButton.setBounds(80,260,60,50);
        negButton.setBounds(150,260,60,50);

        this.add(textField);
        this.add(panel);
        this.add(clrButton);
        this.add(delButton);
        this.add(negButton);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i<10; i++){
            if (e.getSource()== numButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource()==eqlButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;

        }
        if (e.getSource()==clrButton){
            textField.setText("");
        }
        if (e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for (int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource()==negButton){
            double temp = Double.parseDouble(textField.getText());
            temp*= -1;
            textField.setText(String.valueOf(temp));
        }
    }



}
