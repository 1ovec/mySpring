package com.mylove.hahz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BController implements Runnable{

    private String getA(){
        return "zxczxczczcasdasdadsasfqwrqeqwe";
    }


    private String getB(){
        return "789545474897984513215465424651";
    }

    public void testC(){
        String a = getA();
        String b = getB();
        System.out.println(a+b);
    }

    public static void main(String[] args) throws InterruptedException {
        /*Collections.emptyList();
        List<String>list= new ArrayList<>();*/

        Thread s = new Thread(){
            @Override
            public void run() {
                try{
                    System.out.println("11111");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("2222");

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        s.start();
        System.out.println("3333");

        TimeUnit.SECONDS.sleep(12);
        System.out.println("4444");

        s.start();
        System.out.println("5555");


    }

    @Override
    public void run() {

    }
}
