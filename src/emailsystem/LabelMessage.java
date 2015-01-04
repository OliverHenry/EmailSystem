import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LabelMessage extends JFrame
        implements ActionListener {

    JLabel messageIDLabel = new JLabel("Message ID:");
    JTextField messageIDTxt = new JTextField(3);
    JLabel labelIDLabel = new JLabel("Label ID:");
    JTextField labelIDTxt = new JTextField(30);
    JButton sendBtn = new JButton("Send");
    JButton cancelBtn = new JButton("Cancel");
    JTextArea messageTxt = new JTextArea(15, 30);
    JPanel top = new JPanel();
    JPanel middle = new JPanel();
    JPanel bottom = new JPanel();

    public static void main(String[] args) {
        LabelMessage jf = new LabelMessage();
    }

    public LabelMessage() {
        setLayout(new BorderLayout());
        setSize(450, 350);
        setTitle("Label Message");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        top.setLayout(new FlowLayout());
        top.add(messageIDLabel);
        top.add(messageIDTxt);
        
        middle.setLayout(new FlowLayout());
        middle.add(labelIDLabel);
        middle.add(labelIDTxt);
        middle.add(messageTxt);

        bottom.setLayout(new FlowLayout());
        bottom.add(sendBtn);
        bottom.add(cancelBtn);
        add("North", top);
        add("Center", middle);
        add("South", bottom);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //put code here
    }
}
