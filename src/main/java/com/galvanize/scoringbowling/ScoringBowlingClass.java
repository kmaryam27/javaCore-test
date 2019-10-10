package com.galvanize.scoringbowling;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ScoringBowlingClass {

    private int frame;
    private int pinFirst;
    private int pinSecond;
    private int pinTotal;

//    private List<gameDetails> gameList = new LinkedList<>();

    public ScoringBowlingClass() {
        this.setFrame(10);
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public int getPinFirst() {
        return pinFirst;
    }

    public void setPinFirst(int pinFirst) {
        this.pinFirst = pinFirst;
    }

    public int getPinSecond() {
        return pinSecond;
    }

    public void setPinSecond(int pinSecond) {
        this.pinSecond = pinSecond;
    }

    public int getPinTotal() {
        return pinTotal;
    }

    public void setPinTotal() {
        int totalpin = 0;
        for (int i = 0; i < this.getFrame(); i++){
//            totalpin =
        }
        this.pinTotal = pinTotal;
    }

    public boolean isExist() {
        return true;
    }
}
