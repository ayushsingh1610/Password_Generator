package password;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static password.UIcomponent.*;
import static password.passLogic.getPassword2;

public class homepage extends JFrame implements ActionListener {
    JLabel tittle, length_label,num,capital, small, special, result;
    JTextField length_text;
    JCheckBox ch1, ch2, ch3,ch4;
    JButton submit_btn;
    JTextArea password;

    homepage()
    {
        setTitle("Password Generator");
        setLayout(null);
        int yPosition = 75;
        tittle = new JLabel("Password Generator");
        tittle.setFont(new Font("System",Font.BOLD,30));
        tittle.setBackground(Color.BLACK);
        tittle.setBounds(225,15,500,40);
        add(tittle);

        length_label = new JLabel("Enter the length of password = ");
        Comp(length_label, 100, yPosition);
        add(length_label);

        length_text = new JTextField();
        Comp(length_text,400,yPosition);
        add(length_text);

        num = new JLabel("Use numbers");
        Comp(num,100,2 * yPosition);
        add(num);

        ch1 = new JCheckBox();
        Comp(ch1,400,2*yPosition);
        ch1.addActionListener(this);
        add(ch1);

        capital = new JLabel("Use Capital Letters");
        Comp(capital,100,3*yPosition);
        add(capital);

        ch2 = new JCheckBox();
        Comp(ch2,400,3*yPosition);
        ch2.addActionListener(this);
        add(ch2);

        small = new JLabel("Use Small Letters");
        Comp(small,100,4*yPosition);
        add(small);

        ch3 = new JCheckBox();
        Comp(ch3,400,4*yPosition);
        ch3.addActionListener(this);
        add(ch3);

        special = new JLabel("Use Special characters");
        Comp(special,100,5*yPosition);
        add(special);

        ch4 = new JCheckBox();
        Comp(ch4,400,5*yPosition);
        ch4.addActionListener(this);
        add(ch4);

        submit_btn = new JButton("Submit ");
        Comp(submit_btn,200,6*yPosition);
        submit_btn.addActionListener(this);
        add(submit_btn);


        result = new JLabel();
        result.setVisible(false);
        result.setBounds(200,7*yPosition,600,50);
        result.setFont(getPlainFont());
        result.setBackground(Color.WHITE);
        result.setForeground(Color.BLACK);
        add(result);

        password = new JTextArea();
        password.setVisible(false);
        password.setEditable(false);
        password.setBounds(400,7*yPosition+10,250,30);
        password.setFont(getPlainFont());
//        password.setBackground(Color.WHITE);
        password.setForeground(Color.BLACK);
        add(password);



        setSize(800,800);
        setLocation(400,50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = Integer.parseInt(length_text.getText());
        if(n>20)
        {
            JOptionPane.showMessageDialog(null,"Please choose the length below 20");
        }
        else if(n<5)
        {
            JOptionPane.showMessageDialog(null,"Please choose the length above 5");
        }
        else if(!ch1.isSelected() && !ch2.isSelected() && !ch3.isSelected() && !ch4.isSelected())
        {
            JOptionPane.showMessageDialog(null,"Please choose any of the above options otherwise all cases are selected.");
        }
        if(e.getSource() == submit_btn)
        {
            result.setText("Your Password is = " );
            password.setText(getPassword2(n,ch1.isSelected(),ch2.isSelected(), ch3.isSelected(), ch4.isSelected()));
            result.setVisible(true);
            password.setVisible(true);
        }
    }
}
