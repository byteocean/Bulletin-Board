package gui;

//import ensemble.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class messageProcessing {
    private String reveivedMsg;
    private String messagePack;
    private String timeStamp;
    
    private String[] parseCondition = { ".*(?=Content:)",
	    "(?<=Content:).*(?=Time:)", "(?<=Time:).*" };
    private String[] parsedMsg = { "Subject", "Content", "Time" };

    public messageProcessing() {

    }

    private void setMessagePack(String msgPack) {
	messagePack = msgPack;
    }

    private void parseMsg(String msg) {
	System.out.print(msg);
	System.out.print("\n");

	for (int i = 0; i < 3; i++) {
	    Pattern p = Pattern.compile(parseCondition[i]);
	    Matcher m = p.matcher(msg);
	    if (m.find()) {
		System.out.print("parse\n");
		parsedMsg[i] = m.group();
		System.out.print(parsedMsg[i] + "\n");
	    }
	}

    }

    public String codeMessage(String subject, String content) {
	SimpleDateFormat f=new SimpleDateFormat("yyyy-mm-dd:hh:mm:ss");
	this.timeStamp=f.format(new Date());
	setMessagePack("Re:" + subject + " Content:" + content + " Time:"
		+ this.timeStamp);
	return messagePack;
    }

    public String[] decodeMessage(String receivedMsg) {
	this.reveivedMsg=receivedMsg;
	parseMsg(this.reveivedMsg);
	return parsedMsg;
    }

}
