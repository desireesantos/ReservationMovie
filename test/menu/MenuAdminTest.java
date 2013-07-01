package menu;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * User: dsantos
 * Date: 6/9/13  - Time: 11:05 PM
 */
public class MenuAdminTest {

    private MenuAdmin menu = new MenuAdmin();
    List<String> result = new ArrayList<String>();

    @Test
    public void shouldChooseOption1(){
        result =  menu.commandAdmin(1);
        Assert.assertThat(result.get(3).toString(), equalTo("Padrões de Software - Reserved: false"));
    }

    @Test
    public void shouldChooseOption2(){
        result =  menu.commandAdmin(2);
        Assert.assertThat(result.get(3).toString(),equalTo("Padrões de Software"));
    }

    @Test
    public void shouldChooseOption3(){
        result =  menu.commandAdmin(3);
        Assert.assertThat(result.get(2).toString(),equalTo("Agile Samurai"));
    }


    @Test
    public void shouldChooseOption4(){
        result =  menu.commandAdmin(4);
        Assert.assertThat(result.get(2).toString(),equalTo("Nome Completo: Paulo Cesar Santos"));
    }

}
