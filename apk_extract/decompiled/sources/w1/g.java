package w1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import g3.h;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10647a = new h(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f10648b = new h(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f10649c = new h(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f10650d = new h(5);
    public static final float e = (float) (Math.sqrt(2.0d) / 2.0d);

    public static void a(Path path, float f, float f4, float f10) {
        j1.a aVar = j1.d.f5945a;
        PathMeasure pathMeasure = (PathMeasure) f10647a.get();
        Path path2 = (Path) f10648b.get();
        Path path3 = (Path) f10649c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (!(f == 1.0f && f4 == 0.0f) && length >= 1.0f && Math.abs((f4 - f) - 1.0f) >= 0.01d) {
            float f11 = f * length;
            float f12 = f4 * length;
            float f13 = f10 * length;
            float fMin = Math.min(f11, f12) + f13;
            float fMax = Math.max(f11, f12) + f13;
            if (fMin >= length && fMax >= length) {
                fMin = f.c(fMin, length);
                fMax = f.c(fMax, length);
            }
            if (fMin < 0.0f) {
                fMin = f.c(fMin, length);
            }
            if (fMax < 0.0f) {
                fMax = f.c(fMax, length);
            }
            if (fMin == fMax) {
                path.reset();
                return;
            }
            if (fMin >= fMax) {
                fMin -= length;
            }
            path2.reset();
            pathMeasure.getSegment(fMin, fMax, path2, true);
            if (fMax > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, fMax % length, path3, true);
                path2.addPath(path3);
            } else if (fMin < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(fMin + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
        }
    }

    public static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e4) {
            throw e4;
        } catch (Exception unused) {
        }
    }

    public static float c() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static Bitmap d(Bitmap bitmap, int i8, int i9) {
        if (bitmap.getWidth() == i8 && bitmap.getHeight() == i9) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i8, i9, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static void e(Canvas canvas, RectF rectF, Paint paint) {
        j1.a aVar = j1.d.f5945a;
        canvas.saveLayer(rectF, paint);
    }
}
