package util;

import org.springframework.stereotype.Component;


public class MyExcetion extends RuntimeException {
    private String message;//不交给父类在控制台显示
    public MyExcetion(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
