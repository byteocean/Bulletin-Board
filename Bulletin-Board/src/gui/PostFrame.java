package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import static gui.SwingConsole.*;

public class PostFrame extends JFrame {

    protected static final String subjectFieldString = "Subject";
    protected static final String contentAreaString = "Content";

    // create buttons
    private JButton sendButton = new JButton("Send"),
	    abortButton = new JButton("Abort");
    // create subjectField
    private JTextField subjectField = new JTextField(30);
    // create content area
    private JTextArea contentArea = new JTextArea(20, 30);

    class SendButtonListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	    String subject = subjectField.getText(), content = contentArea
		    .getText();
	    PostMessage postMsg = new PostMessage(subject, content);
	    System.out.print("return from send");
	    postMsg.castMessage();
	    dispose();
	}
    }

    class AbortButtonListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent abortSending) {
	    System.out.print("return from abort");
	    dispose();
	}

    }

    private SendButtonListener sendListener = new SendButtonListener();
    private AbortButtonListener abortListener = new AbortButtonListener();

    public PostFrame() {
	// add actionListeners to buttons
	sendButton.addActionListener(sendListener);
	abortButton.addActionListener(abortListener);
	// layout buttons
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new FlowLayout());
	buttonPanel.add(sendButton);
	buttonPanel.add(abortButton);

	// do some settings and create label for subjectField
	subjectField.setFont(new Font("New Time Roman", Font.BOLD, 15));
	JLabel subjectFieldLabel = new JLabel(subjectFieldString + ":");
	subjectFieldLabel.setLabelFor(subjectField);
	// layout label and subjectField
	JPanel subjectPanel = new JPanel();
	subjectPanel.add(BorderLayout.WEST, subjectFieldLabel);//
	subjectPanel.add(BorderLayout.CENTER, subjectField);//

	// do some settings and create label for contentArea
	contentArea.setFont(new Font("New Time Roman", Font.BOLD, 13));
	contentArea.setLineWrap(true);
	// create scroll pane for contentArea
	JScrollPane contentScrollArea = new JScrollPane(contentArea);
	contentScrollArea
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	// create label for contentArea
	JPanel contentPanel = new JPanel();
	JLabel contentAreaLabel = new JLabel(contentAreaString + ":");
	contentAreaLabel.setLabelFor(contentArea);
	// layout label and contentArea
	contentPanel.add(BorderLayout.WEST, contentAreaLabel);
	contentPanel.add(BorderLayout.CENTER, contentScrollArea);

	// layout panels
	add(BorderLayout.NORTH, subjectPanel);
	add(BorderLayout.CENTER, contentPanel);
	add(BorderLayout.SOUTH, buttonPanel);

    }

    public static void main(String[] args) {
	run(new PostFrame(), 800, 500);

    }

}
