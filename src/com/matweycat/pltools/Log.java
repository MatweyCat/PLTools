package com.matweycat.pltools;

public class Log {

    private long time;
    private String info;
    private Action action;
    private String name;

    public Log(String name, Action a, String info, long time) {
        this.name = name;
        this.action = a;
        this.info = info;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo() {
        this.info = info;
    }
}
