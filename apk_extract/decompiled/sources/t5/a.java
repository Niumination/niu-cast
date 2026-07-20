package t5;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u5.a f10166a;

    public a(u5.a aVar, Matrix matrix) {
        this.f10166a = aVar;
        Rect rectG = aVar.g();
        if (rectG != null && matrix != null) {
            RectF rectF = new RectF(rectG);
            matrix.mapRect(rectF);
            rectG.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
        Point[] pointArrL = aVar.l();
        if (pointArrL == null || matrix == null) {
            return;
        }
        int length = pointArrL.length;
        float[] fArr = new float[length + length];
        for (int i8 = 0; i8 < pointArrL.length; i8++) {
            Point point = pointArrL[i8];
            int i9 = i8 + i8;
            fArr[i9] = point.x;
            fArr[i9 + 1] = point.y;
        }
        matrix.mapPoints(fArr);
        for (int i10 = 0; i10 < pointArrL.length; i10++) {
            int i11 = i10 + i10;
            pointArrL[i10].set((int) fArr[i11], (int) fArr[i11 + 1]);
        }
    }
}
