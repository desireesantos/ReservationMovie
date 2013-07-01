package exception;

import units.Message;

/**
 * User: dsantos
 * Date: 6/5/13  - Time: 1:07 PM
 */
public class WrongOptionException extends Throwable {

    private String msg = Message.ERROR_MESSAGE;

    public String getMessage(){
        return msg;
    }

}
