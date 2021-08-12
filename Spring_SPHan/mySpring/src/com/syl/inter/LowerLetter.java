package com.syl.inter;

public class LowerLetter implements ChangeLetter {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String Change() {
        return string.toLowerCase();
    }
}
