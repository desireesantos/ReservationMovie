package units;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: dsantos
 * Date: 6/5/13  - Time: 5:53 PM
 */
public class LoginTest {

    Login login = new Login();
    Client client = new Client();


    @Test
    public void hasExistClient() {

        client.setName("admin");
        client.setPassord("admin");

        Assert.assertTrue(login.execute(client));
    }

    @Test
    public void hasNOTExistClient() {

        client.setName("Paulo");
        client.setPassord("Bla");

        Assert.assertFalse(login.execute(client));

    }

}
