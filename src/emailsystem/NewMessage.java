import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NewMessage extends JFrame
        implements ActionListener {

    JLabel toLabel = new JLabel("To:");
    JTextField toTxt = new JTextField(30);
    JLabel subjectLabel = new JLabel("Subject:");
    JTextField subjectTxt = new JTextField(30);
    JButton sendBtn = new JButton("Send");
    JButton cancelBtn = new JButton("Cancel");
    JLabel messageLabel = new JLabel("Message:");
    JTextArea messageTxt = new JTextArea(15, 30);
    JPanel top = new JPanel();
    JPanel middle = new JPanel();
    JPanel bottom = new JPanel();

    public static void main(String[] args) {
        NewMessage jf = new NewMessage();
    }

    public NewMessage() {
        setLayout(new BorderLayout());
        setSize(450, 350);
        setTitle("New Message");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        top.setLayout(new FlowLayout());
        top.add(toLabel);
        top.add(toTxt);
        
        middle.setLayout(new FlowLayout());
        middle.add(subjectLabel);
        middle.add(subjectTxt);
        middle.add(messageLabel);
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
