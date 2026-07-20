package com.transsion.widgetthemes.util;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes3.dex */
public class Point {
    public float radius;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3836x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f3837x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3838y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f3839y1;

    public Point() {
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawCircle(this.f3836x, this.f3838y, this.radius, paint);
    }

    public void setDestPos(int i8, int i9) {
        this.f3837x1 = i8;
        this.f3839y1 = i9;
    }

    public void setStartPos(int i8, int i9, float f) {
        this.f3836x = i8;
        this.f3838y = i9;
        this.radius = f;
    }

    public String toString() {
        return "Point::x=" + this.f3836x + ", y=" + this.f3838y + ", x1=" + this.f3837x1 + ", y1=" + this.f3839y1 + ", radius=" + this.radius;
    }

    public Point(int i8, int i9, float f) {
        this.f3837x1 = i8;
        this.f3836x = i8;
        this.f3839y1 = i9;
        this.f3838y = i9;
        this.radius = f;
    }
}
