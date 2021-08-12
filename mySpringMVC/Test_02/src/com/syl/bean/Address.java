package com.syl.bean;

public class Address {

    private String State;
    private String County;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    @Override
    public String toString() {
        return "Address{" +
                "State='" + State + '\'' +
                ", County='" + County + '\'' +
                '}';
    }
}
