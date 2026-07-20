package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.ReplaceWith;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {

    @RequiresApi(27)
    public static class Api27Impl {
        private Api27Impl() {
        }

        public static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            return bitmap.copy(Api31Impl.getHardwareBitmapConfig(bitmap), true);
        }

        public static Bitmap createBitmapWithSourceColorspace(int i8, int i9, Bitmap bitmap, boolean z2) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z2 && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                config = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return Bitmap.createBitmap(i8, i9, config, bitmap.hasAlpha(), colorSpace);
        }

        public static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        public static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            return bitmap.getHardwareBuffer().getFormat() == 22 ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    @NonNull
    public static Bitmap createScaledBitmap(@NonNull Bitmap bitmap, int i8, int i9, @Nullable Rect rect, boolean z2) {
        Bitmap bitmap2;
        int i10;
        int i11;
        if (i8 <= 0 || i9 <= 0) {
            throw new IllegalArgumentException("dstW and dstH must be > 0!");
        }
        if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
            throw new IllegalArgumentException("srcRect must be contained by srcBm!");
        }
        Bitmap bitmapCopyBitmapIfHardware = Api27Impl.copyBitmapIfHardware(bitmap);
        int iWidth = rect != null ? rect.width() : bitmap.getWidth();
        int iHeight = rect != null ? rect.height() : bitmap.getHeight();
        float f = i8 / iWidth;
        float f4 = i9 / iHeight;
        int i12 = rect != null ? rect.left : 0;
        int i13 = rect != null ? rect.top : 0;
        if (i12 == 0 && i13 == 0 && i8 == bitmap.getWidth() && i9 == bitmap.getHeight()) {
            return (bitmap.isMutable() && bitmap == bitmapCopyBitmapIfHardware) ? bitmap.copy(bitmap.getConfig(), true) : bitmapCopyBitmapIfHardware;
        }
        Paint paint = new Paint(1);
        paint.setFilterBitmap(true);
        Api29Impl.setPaintBlendMode(paint);
        if (iWidth == i8 && iHeight == i9) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i8, i9, bitmapCopyBitmapIfHardware.getConfig());
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCopyBitmapIfHardware, -i12, -i13, paint);
            return bitmapCreateBitmap;
        }
        double dLog = Math.log(2.0d);
        int iCeil = (int) (f > 1.0f ? Math.ceil(Math.log(f) / dLog) : Math.floor(Math.log(f) / dLog));
        int iCeil2 = (int) (f4 > 1.0f ? Math.ceil(Math.log(f4) / dLog) : Math.floor(Math.log(f4) / dLog));
        if (!z2 || Api27Impl.isAlreadyF16AndLinear(bitmap)) {
            bitmap2 = null;
            i10 = i12;
            i11 = 0;
        } else {
            Bitmap bitmapCreateBitmapWithSourceColorspace = Api27Impl.createBitmapWithSourceColorspace(iCeil > 0 ? sizeAtStep(iWidth, i8, 1, iCeil) : iWidth, iCeil2 > 0 ? sizeAtStep(iHeight, i9, 1, iCeil2) : iHeight, bitmap, true);
            new Canvas(bitmapCreateBitmapWithSourceColorspace).drawBitmap(bitmapCopyBitmapIfHardware, -i12, -i13, paint);
            i11 = 1;
            i13 = 0;
            i10 = 0;
            bitmap2 = bitmapCopyBitmapIfHardware;
            bitmapCopyBitmapIfHardware = bitmapCreateBitmapWithSourceColorspace;
        }
        Rect rect2 = new Rect(i10, i13, iWidth, iHeight);
        Rect rect3 = new Rect();
        int i14 = iCeil;
        int i15 = iCeil2;
        while (true) {
            if (i14 == 0 && i15 == 0) {
                break;
            }
            if (i14 < 0) {
                i14++;
            } else if (i14 > 0) {
                i14--;
            }
            if (i15 < 0) {
                i15++;
            } else if (i15 > 0) {
                i15--;
            }
            Bitmap bitmap3 = bitmapCopyBitmapIfHardware;
            Paint paint2 = paint;
            rect3.set(0, 0, sizeAtStep(iWidth, i8, i14, iCeil), sizeAtStep(iHeight, i9, i15, iCeil2));
            boolean z3 = i14 == 0 && i15 == 0;
            boolean z5 = bitmap2 != null && bitmap2.getWidth() == i8 && bitmap2.getHeight() == i9;
            if (bitmap2 == null || bitmap2 == bitmap || ((z2 && !Api27Impl.isAlreadyF16AndLinear(bitmap2)) || (z3 && !(z5 && i11 == 0)))) {
                if (bitmap2 != bitmap && bitmap2 != null) {
                    bitmap2.recycle();
                }
                bitmapCopyBitmapIfHardware = Api27Impl.createBitmapWithSourceColorspace(sizeAtStep(iWidth, i8, i14 > 0 ? i11 : i14, iCeil), sizeAtStep(iHeight, i9, i15 > 0 ? i11 : i15, iCeil2), bitmap, z2 && !z3);
            } else {
                bitmapCopyBitmapIfHardware = bitmap2;
            }
            new Canvas(bitmapCopyBitmapIfHardware).drawBitmap(bitmap3, rect2, rect3, paint2);
            rect2.set(rect3);
            bitmap2 = bitmap3;
            paint = paint2;
        }
        if (bitmap2 != bitmap && bitmap2 != null) {
            bitmap2.recycle();
        }
        return bitmapCopyBitmapIfHardware;
    }

    @ReplaceWith(expression = "bitmap.getAllocationByteCount()")
    @Deprecated
    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    @ReplaceWith(expression = "bitmap.hasMipMap()")
    @Deprecated
    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    @ReplaceWith(expression = "bitmap.setHasMipMap(hasMipMap)")
    @Deprecated
    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z2) {
        bitmap.setHasMipMap(z2);
    }

    @VisibleForTesting
    public static int sizeAtStep(int i8, int i9, int i10, int i11) {
        if (i10 == 0) {
            return i9;
        }
        return i10 > 0 ? i8 * (1 << (i11 - i10)) : i9 << ((-i10) - 1);
    }
}
