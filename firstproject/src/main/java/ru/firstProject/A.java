package ru.firstProject;

import java.util.OptionalLong;
import java.util.stream.Stream;

/**
 * Created by Админ on 16.08.2017.
 */
public class A {
    private boolean x,y;
    public void calculate(){
        boolean a,b,c,d;
        a = true;
        b = true;
        c = true;
        d = true;

        if(b == true){
            if(c == true){
                if(a == true){
                    x = true;
                    if(d == true){
                        y = true;
                    }else{
                        y = false;
                    }
                }else{
                    x = false;
                }
            }else{
                x = false;
                y = false;
            }
        }else{
            x = false;
            y = false;
        }
    }
}

