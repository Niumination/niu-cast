package l2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final b f9643a = new b();

    @os.l
    public final Bitmap a() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        l0.o(bitmapCreateBitmap, "createBitmap(16, 16, Bitmap.Config.ARGB_8888).apply {\n            eraseColor(Color.TRANSPARENT)\n        }");
        return bitmapCreateBitmap;
    }

    @os.l
    public final Bitmap b(@os.l j2.j jVar) {
        l0.p(jVar, "src");
        int i10 = jVar.f8534b;
        int i11 = jVar.f8535c;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, i10, i11);
        Rect rect2 = new Rect();
        TextPaint textPaint = new TextPaint();
        float f10 = i11;
        float f11 = 0.8f;
        textPaint.setTextSize(f10 * 0.8f);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        if (jVar.f8542j == j2.j.e.BOLD) {
            textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        }
        textPaint.setColor(jVar.f8543k);
        String str = jVar.f8541i;
        while (f11 > 0.1f) {
            textPaint.getTextBounds(str, 0, str.length(), rect2);
            if (rect2.width() <= rect.width()) {
                break;
            }
            f11 -= 0.1f;
            textPaint.setTextSize(f10 * f11);
        }
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        canvas.drawText(str, rect.centerX(), (rect.centerY() - (fontMetricsInt.top / 2)) - (fontMetricsInt.bottom / 2), textPaint);
        l0.o(bitmapCreateBitmap, "bitmap");
        return bitmapCreateBitmap;
    }
}
