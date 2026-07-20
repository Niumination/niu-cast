package r1;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public enum v {
    BUTT,
    ROUND,
    UNKNOWN;

    public Paint.Cap toPaintCap() {
        int i8 = u.f9302a[ordinal()];
        if (i8 != 1) {
            return i8 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
        }
        return Paint.Cap.BUTT;
    }
}
