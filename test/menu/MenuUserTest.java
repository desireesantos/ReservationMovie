package menu;

import menu.MenuUser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * User: dsantos
 * Date: 5/29/13  - Time: 4:45 PM
 */
public class MenuUserTest {

    private MenuUser menu = new MenuUser();
    List<String> result = new ArrayList<String>();

    @Test
    public void shouldChooseOption1(){
      result =  menu.commandUser(1);
        Assert.assertThat(result.get(3).toString(),equalTo("Padrões de Software - Reserved: false"));
    }

    @Test
    public void shouldChooseOption2(){
        result =  menu.commandUser(2);
        Assert.assertThat(result.get(3).toString(),equalTo("Padrões de Software"));
    }

    @Test
    public void shouldChooseOption3(){
        result =  menu.commandUser(3);
        Assert.assertThat(result.get(2).toString(),equalTo("Agile Samurai"));
    }


    @Test
    public void shouldChooseOption4(){
        result =  menu.commandUser(4);
        Assert.assertThat(result.get(2).toString(),equalTo("Nome Completo: Paulo Cesar Santos"));
    }



}
