package com.example.durangoapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawView extends View {
    Paint paint = new Paint();
    ArrayList<Line> lines = new ArrayList<Line>();

    public DrawView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    //Función que dibuja la vista
    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    //Función que se ejecuta cuando la vista se dibuja
    @Override
    protected void onDraw(Canvas canvas) {
        for (Line l : lines) {
            canvas.drawLine(l.startX, l.startY, l.stopX, l.stopY, paint);
        }
    }

    //Función que e ejecuta cuando se clica en el mapa
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            lines.add(new Line(event.getX(), event.getY()));
            return true;
        } else if ((event.getAction() == MotionEvent.ACTION_MOVE || event
                .getAction() == MotionEvent.ACTION_UP) && lines.size() > 0) {
            Line current = lines.get(lines.size() - 1);
            current.stopX = event.getX();
            current.stopY = event.getY();
            invalidate();
            return true;
        } else {
            return false;
        }
    }
}
