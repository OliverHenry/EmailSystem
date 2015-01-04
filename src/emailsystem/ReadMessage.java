
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReadMessage extends JFrame
        implements ActionListener {

    private String id; // Creates a string called "id" being private means it can only be used in this class "ReadMessage"
    private JTextField priority = new JTextField(2); // Create a text field called "priority" with the text space of 2 characters
    private JButton update = new JButton("Update"); // Creates a button called "update" which has the text "Update" on the button
    private JButton close = new JButton("Close"); // Creates a button called "close" which has the text "Close" on the button
    private JTextArea textArea = new JTextArea(); // Creates a text area called "textArea"
    private JScrollPane scrollPane = new JScrollPane(textArea); // Creates a scroll bar called "scrollPane"

    public ReadMessage(String id) {
        this.id = id;

        setLayout(new BorderLayout()); // Sets the lay out of the window in the BorderLayout
        setSize(500, 250); // Sets the size of the window 500 long on the X axis, 250 high on the Y axis
        setResizable(false); // Makes the window unable to be resized once the window is open
        setTitle("Message Details"); // Sets the title on top of the window "Message Details"

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Makes the window close upon clicking the x in the top corner of the window
        JPanel top = new JPanel(); // Selects the top part of the border layout
        top.add(new JLabel("Enter Priority (1-5):")); // Adds a label in the top section of the border layout
        top.add(priority); // Adds the "priority" textfield to the top of the window with the border layout
        top.add(update); // Adds the "update" button to the top of the window with the border layout
        update.addActionListener(this); // Gives the "update" button an actionListener
        top.add(close); // Adds the "close" button to the top of the window with the border layout
        close.addActionListener(this); // Gives the "close" button an actionListener
        add("North", top); // Names the top section of the border layout "North"

        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12)); // Sets the font and font size in side the text area thats named "textArea"
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(450, 150)); // Sets the size of the text area
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Sets the scroll bar to vertical
        scrollPane.setPreferredSize(new Dimension(450, 150)); // Sets the size of the scroll bar

        JPanel middle = new JPanel(); // Selects the middle part of the border layout
        middle.add(scrollPane); // Adds the scroll bar called "scrollPane" to the middle of the window with the border layout
        add("Center", middle); // Names the middle section of the border layout "Center"

        displayMessage();
        
        setVisible(true); // Sets the window to be visable
    }

    public void actionPerformed(ActionEvent e) { // Creates the "actionPerformed" method
        if (e.getSource() == update) { // The start of an if statement "if the "update" button is pressed..."
            int priorityValue = Integer.parseInt(priority.getText()); // Updates the "priorityValue" variable by taking the text in the "priority" text field converting it to an Int then putting the Int inside the "priorityValue variable"
            MessageData.setPriority(id, priorityValue);
            displayMessage();
        } else if (e.getSource() == close) { // The second part of the if statement "else if the "close" button is pressed..."
            dispose(); // Closes the window when the "close" button is pressed
        }
    }

    private void displayMessage() { // Creates the "displayMessage" method
        String subject = MessageData.getSubject(id); // Fills the "subject" String with the value inside the "id" varible
        if (subject == null) { // The start of an if statement "if "subject" has no value then..."
            textArea.setText("No such message"); // The text in "textArea" is set to "No such message"
        } else { // The second part of the if statement "if the first criteria of the statement is not met then..."
            textArea.setText("Subject: " + subject); // Sets the text in the textArea to "Subject: " + the value of the variable "subject"
            textArea.setText("From: " + MessageData.getSender(id));  // Sets the text in the textArea to "From: " + the value of the sender's "id"
            textArea.append("\nTo: " + MessageData.getRecipient(id)); // Sets the text in the textArea to "To: " + the value of the recipient's "id" all on a new line
            textArea.append("\nPriority: " + MessageData.stars(MessageData.getPriority(id))); // Sets the text in the textArea to "Priority: " + the value of the variable "id" all on a new line
            textArea.append("\n\n" + MessageData.getMessage(id)); // Sets the text in the textArea to the value of the variable "id" down two lines
        }
    }
}