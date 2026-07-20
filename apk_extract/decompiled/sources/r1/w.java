package r1;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public enum w {
    MITER,
    ROUND,
    BEVEL;

    public Paint.Join toPaintJoin() {
        int i8 = u.f9303b[ordinal()];
        if (i8 == 1) {
            return Paint.Join.BEVEL;
        }
        if (i8 == 2) {
            return Paint.Join.MITER;
        }
        if (i8 != 3) {
            return null;
        }
        return Paint.Join.ROUND;
    }
}
