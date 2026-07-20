package dj;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3704a = "dj.a";

    public static Bitmap a(Bitmap bitmap, float f10) {
        if (bitmap == null) {
            return null;
        }
        if (f10 == 1.0f) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f11 = 1.0f / f10;
        Matrix matrix = new Matrix();
        matrix.postScale(f11, f11);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap b(View view, int i10, int i11, float f10) {
        if (view == null) {
            return null;
        }
        float f11 = 1.0f / f10;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) ((view.getWidth() - i10) * f11), (int) ((view.getHeight() - i11) * f11), Bitmap.Config.ARGB_8888);
        if (view.getBackground() == null || !(view.getBackground() instanceof ColorDrawable)) {
            bitmapCreateBitmap.eraseColor(Color.parseColor("#f6f6f6"));
        } else {
            bitmapCreateBitmap.eraseColor(((ColorDrawable) view.getBackground()).getColor());
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate(-((int) (i10 * f11)), -((int) (i11 * f11)));
        if (f10 > 1.0f) {
            canvas.scale(f11, f11);
        }
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap c(Bitmap bitmap, int i10, int i11) {
        return (i10 == 0 && i11 == 0) ? bitmap : Bitmap.createBitmap(bitmap, i10, i11, bitmap.getWidth() - i10, bitmap.getHeight() - i11);
    }
}
