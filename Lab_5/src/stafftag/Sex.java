package stafftag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;


public class Sex extends TagSupport {
    String radioButton1 = "<input type=\"radio\" name=\"sex\" value=\"male\" checked=\"checked\">male";
    String radioButton2 = "<input type=\"radio\" name=\"sex\" value=\"female\" checked=\"checked\">female";

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(radioButton1 + "<br>" + radioButton2);
        } catch (IOException e) {
        }
        return SKIP_BODY;
    }
}
