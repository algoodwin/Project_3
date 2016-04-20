package com.example.michael.animalchain;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.widget.ImageView;
import java.util.Random;
//private Bitmap spritesheet;
//private int score;
//private Animation animation = new Animation();
//private long startTime;

/**
 * Created by alyssiagoodwin on 4/18/16.
 */
public class Shrimp {

    private int ii =0;
    private int x;
    private int y;

    public void randShrimp(Bitmap res, int w, int h, int numFrames) {

        while (ii < 5) //Change number for how many shrimp will show up
        {
            int wid = 100;
            Random r = new Random();
            x = (r.nextInt(50) + 10); //Starts at 10 goes to 50
            y = (r.nextInt(50) + 10);
            ii++;

        }
    }
    private Animation animation = new Animation();
    private Bitmap spritesheet;
    private long startTime;
    public Shrimp(Bitmap res, int x, int y, int w, int h, int numFrames)
    {
        x = 100;
        y = GamePanel.HEIGHT/2;
        int width = w, height = h;

        Bitmap[] image  = new Bitmap[numFrames];
        spritesheet = res;

        for(int i = 0; i < image.length; i++)
        {
            image[i] = Bitmap.createBitmap(spritesheet ,i*width, 0,width, height);

        }

        animation.setFrames(image);
        animation.setDelay(10);
        startTime = System.nanoTime();
    }
        public void draw(Canvas canvas)
        {
            canvas.drawBitmap(animation.getImage(), x,y, null);
        }

    }






