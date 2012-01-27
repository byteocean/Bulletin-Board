package gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMessage {
    private String reveivedMsg;
    private String[] parseCondition = { ".*(?=Content:)",
	    "(?<=Content:).*(?=Time:)", "(?<=Time:).*" };
    private String[] parsedMsg = { "Subject", "Content", "Time" };

    public ParseMessage(String msg) {
	this.reveivedMsg = msg;
	parseMsg(reveivedMsg);
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

    public String[] getParsedMsg() {
	return parsedMsg;
    }

}
