package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import b.a;
import kn.l0;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapKt {
    @l
    public static final Bitmap applyCanvas(@l Bitmap bitmap, @l jn.l<? super Canvas, l2> lVar) {
        l0.p(bitmap, "<this>");
        l0.p(lVar, "block");
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(@l Bitmap bitmap, @l Point point) {
        int i10;
        l0.p(bitmap, "<this>");
        l0.p(point, "p");
        int width = bitmap.getWidth();
        int i11 = point.x;
        return i11 >= 0 && i11 < width && (i10 = point.y) >= 0 && i10 < bitmap.getHeight();
    }

    @l
    public static final Bitmap createBitmap(int i10, int i11, @l Bitmap.Config config) {
        l0.p(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config);
        l0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        l0.p(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config);
        l0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static final int get(@l Bitmap bitmap, int i10, int i11) {
        l0.p(bitmap, "<this>");
        return bitmap.getPixel(i10, i11);
    }

    @l
    public static final Bitmap scale(@l Bitmap bitmap, int i10, int i11, boolean z10) {
        l0.p(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
        l0.o(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z10 = true;
        }
        l0.p(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
        l0.o(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void set(@l Bitmap bitmap, int i10, int i11, @ColorInt int i12) {
        l0.p(bitmap, "<this>");
        bitmap.setPixel(i10, i11, i12);
    }

    public static final boolean contains(@l Bitmap bitmap, @l PointF pointF) {
        l0.p(bitmap, "<this>");
        l0.p(pointF, "p");
        float f10 = pointF.x;
        if (f10 >= 0.0f && f10 < bitmap.getWidth()) {
            float f11 = pointF.y;
            if (f11 >= 0.0f && f11 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    @l
    public static final Bitmap createBitmap(int i10, int i11, @l Bitmap.Config config, boolean z10, @l ColorSpace colorSpace) {
        l0.p(config, "config");
        l0.p(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
        l0.o(bitmapCreateBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i10, int i11, Bitmap.Config config, boolean z10, ColorSpace colorSpace, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        if ((i12 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            l0.o(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        l0.p(config, "config");
        l0.p(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
        l0.o(bitmapCreateBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }
}
