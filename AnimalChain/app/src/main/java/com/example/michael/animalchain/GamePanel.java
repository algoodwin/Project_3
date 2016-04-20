package com.example.michael.animalchain;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.michael.AnimalChain.R;

import java.util.Random;

import static android.graphics.BitmapFactory.decodeResource;

/**
 * Created by michael on 4/13/16.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 1366;
    public static final int HEIGHT = 768;
    public static final int MOVESPEED = -5;
    private MainThread thread;
    private Background bg;
    private SurfaceHolder holder;
    private int format;
    private int width;
    private int height;
    private Player player;
    private Shrimp shrimp;

    public GamePanel(Context context)
    {
        //Surfaceview super class
        super(context);

        //add the callback to the surfaceholder to intercept system
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        setFocusable(true);
        // make gamePanel focusable so it can handle events
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry;
        retry = true;
        while(retry)
        {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        bg = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.space));
        shrimp = new Shrimp(BitmapFactory.decodeResourceStream(getResources(), R.drawable.Shrimp),100,100,2);
        player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.ufo), 340, 215, 4);
        thread.setRunning(true);
        thread.start();

    }
    public void surfaceCreated(SurfaceHolder holder)
    {
        bg = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.space));

        shrimp = new Shrimp(BitmapFactory.decodeResource(getResources(), R.drawable.shrimp), 340, 215, 2);
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {

            if(!player.getPlaying())
            {
                player.setPlaying(true);
            }
            else
            {
                player.setUp(true);

            }
            return true;
        }
        if(event.getAction() == MotionEvent.ACTION_UP)
        {
            player.setUp(false);
            return true;

        }

        return super.onTouchEvent(event);
    }

    public void update()
    {
        if(player.getPlaying()) {
            bg.update();
            player.update();
        }

    }

    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth()/(WIDTH* 1.f);
        final float scaleFactorY = getHeight()/(HEIGHT* 1.f);
        if(canvas != null)
        {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            bg.draw(canvas);
            player.draw(canvas);
            shrimp.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }

}
