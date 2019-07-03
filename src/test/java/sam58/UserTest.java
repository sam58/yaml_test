package sam58;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void outLog() {
        User user = new User();
        assertNotNull(user.outLog());
    }
}