import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NewMessage extends JFrame
        implements ActionListener {

    JLabel hoursLabel = new JLabel("Enter your hours worked:  ");
    JTextField hoursTxt = new JTextField(3);
    JLabel rateLabel = new JLabel("Move for your hourly rate:  ");
    JButton resetBtn = new JButton("Reset");
    JTextArea wageTxt = new JTextArea(2, 20);
    JLabel rateChosenLabel = new JLabel("Hourly rate:  ");
    JTextField rateTxt = new JTextField(3);
    JPanel top = new JPanel();
    JPanel middle = new JPanel();
    JPanel bottom = new JPanel();

    public static void main(String[] args) {
        NewMessage jf = new NewMessage();
    }

    public NewMessage() {
        setLayout(new BorderLayout());
        setSize(300, 200);
        setTitle("Scrolling Logic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        top.setLayout(new FlowLayout());
        top.add(resetBtn);
        resetBtn.addActionListener(this);
        middle.setLayout(new FlowLayout());
        middle.add(hoursLabel);
        middle.add(hoursTxt);
        middle.add(wageTxt);
        middle.add(rateChosenLabel);
        middle.add(rateTxt);

        bottom.setLayout(new FlowLayout());
        bottom.add(rateLabel);
        add("North", top);
        add("Center", middle);
        add("South", bottom);
        setResizable(false);
        hoursTxt.setText("0");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //put code here
    }
}
