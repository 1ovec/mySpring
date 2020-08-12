package com.mylove.dfp;

import java.util.ArrayList;
import java.util.List;

public class FightQueryTask extends Thread implements FightQuery{

    String origin;
    String destination;
    List<String>flightList=new ArrayList<>();

    @Override
    public List<String> get() {
        return null;
    }

    @Override
    public void run() {
        super.run();
    }

    public FightQueryTask(String airline,String origin, String destination ) {

    }

    public static void main(String[] args) {
        String a ="Icon_5_4_03_NuoMiYe_01.png";
        String substring = a.substring(0, a.length() - 7).substring(12);
        System.out.println(substring);
    }
}
