import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class OutServlet {
    protected InputStream inputStream;
    protected ServletOutputStream outputStream;

    public OutServlet(ServletOutputStream outputStream, InputStream inputStream) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    public void perform() throws IOException {
        int buf;
        while ((buf = this.inputStream.read()) > 0)
            this.outputStream.write(buf);
        this.outputStream.flush();
    }
}