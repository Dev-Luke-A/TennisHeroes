package com.game.tennisheroes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

//import static com.game.tennisheroes.MainGameActivity.angle;
import static com.game.tennisheroes.MainGameActivity.mxpos;
import static com.game.tennisheroes.MainGameActivity.mypos;
import static com.game.tennisheroes.MainGameActivity.progress;
import static com.game.tennisheroes.MainGameActivity.startx;
import static com.game.tennisheroes.MainGameActivity.starty;
import static com.game.tennisheroes.MainGameActivity.touch;
import static com.game.tennisheroes.MainGameActivity.x;

class PaintView extends View {
    Paint paint = new Paint();
    float xsplit = 0;
    float ysplit = 0;
    float splx = 0;

    float sply = 0;

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void onDraw(Canvas canvas) {

        if(MainGameActivity.ynpaint){

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(50f);
        if(progress > 0) {
            if (progress < 300) {
                xsplit = progress / 300;
                ysplit = progress / 300;
//                splx = (startx + mxpos) * (xsplit);
//                sply = (starty + mypos) * (ysplit);
                splx = ((mxpos + (xsplit * ((startx - mxpos)))));
                sply = ((mypos + (ysplit * ((starty - mypos)))));
            } else {
                progress = 300;
                splx = ((mxpos + (xsplit * ((startx - mxpos)))));
                sply = ((mypos + (ysplit * ((starty - mypos)))));
            }

        }
        paint.setColor(Color.RED);
        canvas.drawLine(startx, starty, mxpos , mypos , paint);
//        angle = (float)Math.acos((startx - mxpos)/(starty -mypos));
        paint.setColor(Color.GREEN);
        canvas.drawLine(mxpos , mypos, splx, sply, paint);
        }

        invalidate();
    }

}
