import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: rustoj01
 * Date: 03/10/2012
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public class MessageTest {

    String messageString = "This is a message";
    Date date = new Date();

    Message message = new Message(messageString, date);

    @Test
    public void setValidBody(){
        assertEquals(messageString, message.getName());
    }

    @Test
    public void setValidDate(){
        assertEquals(date, message.getDate());
    }

}
