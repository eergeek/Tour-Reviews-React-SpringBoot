package com.eergeek.simpleconfiguration;

public class MyBean {
    private String username;
    private int score;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}
