package com.syl.inter;

public class XmlCheck implements UserCheck{
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public void userCheck() {
        System.out.println(this.string);
    }
}
