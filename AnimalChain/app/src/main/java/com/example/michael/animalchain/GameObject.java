package com.example.michael.animalchain;

import android.graphics.Rect;

/**
 * Created by michael on 4/14/16.
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int dx; // x vector
    protected int dy; // y vector
    protected int width;
    protected int height;


    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }
    public Rect getRectangle()
    {
        return new Rect(x,y,x+width, y+height);
    }


}