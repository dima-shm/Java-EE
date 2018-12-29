package stafftag;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;

public class Submit extends TagSupport {

	String value;
	
	public void setValue(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public int doStartTag()
	{
		JspWriter out = pageContext.getOut();
		try {
			out.println("<input type=\"submit\" name=\"press\" value=\"OK\" size=\"20\">" +
					"                <input type=\"submit\" name=\"press\" value=\"Cancel\" size=\"20\">");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
}
