package com.syl.inter;

public class UpperLetter implements ChangeLetter {

    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String Change() {
        // lower to upper
//        System.out.println(string.toUpperCase());
        return string.toUpperCase();
    }
}
