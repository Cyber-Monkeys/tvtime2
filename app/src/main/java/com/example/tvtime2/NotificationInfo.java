package com.example.tvtime2;

public class NotificationInfo {

    int image;
    String accomplishment;
    String day;

    public NotificationInfo(int image, String accomplishment, String day) {
        this.image = image;
        this.accomplishment = accomplishment;
        this.day = day;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAccomplishment() {
        return accomplishment;
    }

    public void setAccomplishment(String accomplishment) {
        this.accomplishment = accomplishment;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
