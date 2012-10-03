import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: rustoj01
 * Date: 03/10/2012
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class TopicTest {

    private final String TOPIC_NAME = "trains and boats";
    Topic topic = new Topic(TOPIC_NAME);

    @Test
    public void setValidName(){
        assertEquals(TOPIC_NAME,topic.getName());
    }

}
