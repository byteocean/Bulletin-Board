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

import static gui.SwingConsole.*;

public class PostFrame extends JFrame {
    protected static final String subjectFieldString = "Subject";
    protected static final String contentAreaString = "Content";//

    public JTextField subjectField;
    JTextArea contentArea;
    
    
    class SendButtonListener implements ActionListener{//
	@Override
	public void actionPerformed(ActionEvent sendMsg) {
	    // TODO Auto-generated method stub
	   String subjectString=subjectField.getText();
	    //String content=contentArea.getText();
	    System.out.print("dfsf");
//	    PostMessage postMsg=new PostMessage(subject,content);
	    
	}
	
    }
    private SendButtonListener sendListener=new SendButtonListener();

    class AbortButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent abortSending) {
	    // TODO Auto-generated method stub
	    
	}
	
    }
    private AbortButtonListener abortListener = new AbortButtonListener();

    public PostFrame() {
	//create buttons
	JButton sendButton = new JButton("Send"),
		abortButton = new JButton("Abort");
	sendButton.addActionListener(sendListener);
	abortButton.addActionListener(abortListener);
	
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new FlowLayout());
	buttonPanel.add(sendButton);
	buttonPanel.add(abortButton);

	// create subjectField
	JTextField subjectField = new JTextField(30);
	subjectField.setFont(new Font("New Time Roman",Font.BOLD,15));
//	subjectField.setActionCommand(subjectFieldString);
	//create label for subjectField
	JLabel subjectFieldLabel = new JLabel(subjectFieldString + ":");
	subjectFieldLabel.setLabelFor(subjectField);
	//layout label and subjectField	
	JPanel subjectPanel = new JPanel();
	subjectPanel.add(BorderLayout.WEST, subjectFieldLabel);//
	subjectPanel.add(BorderLayout.CENTER, subjectField);//

	//create content area
	JTextArea contentArea = new JTextArea(20, 30);
	contentArea.setFont(new Font("New Time Roman",Font.BOLD,13));
	contentArea.setLineWrap(true);
	//create scroll pane for contentArea
	JScrollPane contentScrollArea = new JScrollPane(contentArea);
	contentScrollArea
		.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	//create label for contentArea
	JPanel contentPanel = new JPanel();
	JLabel contentAreaLabel = new JLabel(contentAreaString + ":");
	contentAreaLabel.setLabelFor(contentArea);
	//layout label and contentArea
	contentPanel.add(BorderLayout.WEST, contentAreaLabel);
	contentPanel.add(BorderLayout.CENTER, contentScrollArea);

	//layout panels
	add(BorderLayout.NORTH, subjectPanel);
	add(BorderLayout.CENTER, contentPanel);
	add(BorderLayout.SOUTH, buttonPanel);

    }
    
    public void actionPerformed(ActionEvent e){
	
    }

    public static void main(String[] args) {
	run(new PostFrame(), 800, 500);

    }

}
