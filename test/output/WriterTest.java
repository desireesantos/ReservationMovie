package output;

import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * User: dsantos
 * Date: 4/3/13  - Time: 11:12 AM
 */
public class WriterTest {


    List<String> writerList = new ArrayList<String>();
    String lineValue = " ";
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Writer output;

    public WriterTest() {
        output = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))){

            @Override
            public String readLine() {
                return lineValue;
            }
        });
    }


    @Test
    public void hasNoInformationToPrint() throws IOException {
        lineValue = "";
        Assert.assertThat(outputStream.toString(), equalTo(""));

    }

    @Test
    public void testWriterResultMenu() throws Exception {
        writerList.add("Book Thinking Java");

        Assert.assertThat(writerList.get(0).toString(),equalTo("Book Thinking Java"));
    }
}
