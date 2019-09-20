package com.abhishek;

public class Player {
    public String name;
    public int currentPosition;

    public Player(String Name, int pos)
    {
        name = Name;
        currentPosition = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
