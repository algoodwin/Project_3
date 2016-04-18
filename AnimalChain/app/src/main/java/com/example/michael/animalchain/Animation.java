package com.example.michael.animalchain;

import android.graphics.Bitmap;

/**
 * Created by michael on 4/16/16.
 */
public class Animation {

    private Bitmap[] frames;
    private int currentFrame;
    private long startTime;
    private long delay;
    private boolean playedOnce;

    public void setFrames(Bitmap[] frames)
    {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }
    public void setDelay(long d) {delay = d;}
    public void setFrames(int i) {currentFrame = i;}

    public void update() {
        long elapse = (System.nanoTime() - startTime) / 1000000;

        if (elapse > delay) {
            currentFrame++;
            startTime = System.nanoTime();
        }

        if(currentFrame == frames.length)
        {
            currentFrame = 0;
            playedOnce = true;
        }
    }

    public  Bitmap getImage()
    {
        return frames[currentFrame];
    }
        public int getFrame() {return currentFrame;}
        public boolean playedOnce() {return playedOnce;}

}
