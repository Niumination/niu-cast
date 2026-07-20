package hj;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public c() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Bitmap A(Bitmap bitmap, float f10, float f11) {
        return z0(bitmap, f10, f11, false);
    }

    public static Bitmap A0(Bitmap bitmap, int i10, int i11) {
        return B0(bitmap, i10, i11, false);
    }

    public static Bitmap B(Bitmap bitmap, float f10, float f11, boolean z10) {
        return z0(bitmap, f10, f11, z10);
    }

    public static Bitmap B0(Bitmap bitmap, int i10, int i11, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, true);
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap C(Bitmap bitmap, int i10, int i11) {
        return B0(bitmap, i10, i11, false);
    }

    public static Bitmap C0(Bitmap bitmap, float f10, float f11) {
        return E0(bitmap, f10, f11, 0.0f, 0.0f, false);
    }

    public static Bitmap D(Bitmap bitmap, int i10, int i11, boolean z10) {
        return B0(bitmap, i10, i11, z10);
    }

    public static Bitmap D0(Bitmap bitmap, float f10, float f11, float f12, float f13) {
        return E0(bitmap, f10, f11, f12, f13, false);
    }

    public static Bitmap E(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        canvas.drawBitmap(bitmapCreateBitmap2, new Rect(0, 0, bitmapCreateBitmap2.getWidth(), bitmapCreateBitmap2.getHeight()), new Rect(0, 0, width, height), (Paint) null);
        return bitmapCreateBitmap;
    }

    public static Bitmap E0(Bitmap bitmap, float f10, float f11, float f12, float f13, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setSkew(f10, f11, f12, f13);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static boolean F(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !G(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static Bitmap F0(Bitmap bitmap, float f10, float f11, boolean z10) {
        return E0(bitmap, f10, f11, 0.0f, 0.0f, z10);
    }

    public static boolean G(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static Bitmap G0(Bitmap bitmap, int i10) {
        return H0(bitmap, i10, false);
    }

    public static Bitmap H(@NonNull Bitmap bitmap, @ColorInt int i10) {
        return I(bitmap, i10, false);
    }

    public static Bitmap H0(Bitmap bitmap, int i10, boolean z10) {
        Bitmap bitmapCopy = z10 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        int i11 = i10 < 1 ? 1 : i10;
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i12 = width * height;
        int[] iArr = new int[i12];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i13 = width - 1;
        int i14 = height - 1;
        int i15 = i11 + i11;
        int i16 = i15 + 1;
        int[] iArr2 = new int[i12];
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[i12];
        int[] iArr5 = new int[Math.max(width, height)];
        int i17 = (i15 + 2) >> 1;
        int i18 = i17 * i17;
        int i19 = i18 * 256;
        int[] iArr6 = new int[i19];
        for (int i20 = 0; i20 < i19; i20++) {
            iArr6[i20] = i20 / i18;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i16, 3);
        int i21 = i11 + 1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i22 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i25 = height;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = -i11;
            int i35 = 0;
            while (i34 <= i11) {
                int i36 = i14;
                int[] iArr8 = iArr5;
                int i37 = iArr[Math.min(i13, Math.max(i34, 0)) + i23];
                int[] iArr9 = iArr7[i34 + i11];
                iArr9[0] = (i37 & 16711680) >> 16;
                iArr9[1] = (i37 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i37 & 255;
                int iAbs = i21 - Math.abs(i34);
                int i38 = iArr9[0];
                i35 += i38 * iAbs;
                int i39 = iArr9[1];
                i26 = (i39 * iAbs) + i26;
                int i40 = iArr9[2];
                i27 = (iAbs * i40) + i27;
                if (i34 > 0) {
                    i31 += i38;
                    i32 += i39;
                    i33 += i40;
                } else {
                    i28 += i38;
                    i29 += i39;
                    i30 += i40;
                }
                i34++;
                i14 = i36;
                iArr5 = iArr8;
            }
            int i41 = i14;
            int[] iArr10 = iArr5;
            int i42 = i35;
            int i43 = i11;
            int i44 = 0;
            while (i44 < width) {
                iArr2[i23] = iArr6[i42];
                iArr3[i23] = iArr6[i26];
                iArr4[i23] = iArr6[i27];
                int i45 = i42 - i28;
                int i46 = i26 - i29;
                int i47 = i27 - i30;
                int[] iArr11 = iArr7[((i43 - i11) + i16) % i16];
                int i48 = i28 - iArr11[0];
                int i49 = i29 - iArr11[1];
                int i50 = i30 - iArr11[2];
                if (i22 == 0) {
                    iArr10[i44] = Math.min(i44 + i11 + 1, i13);
                }
                int i51 = iArr[i24 + iArr10[i44]];
                int i52 = (i51 & 16711680) >> 16;
                iArr11[0] = i52;
                int i53 = (i51 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[1] = i53;
                int i54 = i51 & 255;
                iArr11[2] = i54;
                int i55 = i31 + i52;
                int i56 = i32 + i53;
                int i57 = i33 + i54;
                i42 = i45 + i55;
                i26 = i46 + i56;
                i27 = i47 + i57;
                i43 = (i43 + 1) % i16;
                int[] iArr12 = iArr7[i43 % i16];
                int i58 = iArr12[0];
                i28 = i48 + i58;
                int i59 = iArr12[1];
                i29 = i49 + i59;
                int i60 = iArr12[2];
                i30 = i50 + i60;
                i31 = i55 - i58;
                i32 = i56 - i59;
                i33 = i57 - i60;
                i23++;
                i44++;
                iArr6 = iArr6;
            }
            i24 += width;
            i22++;
            bitmapCopy = bitmap2;
            height = i25;
            i14 = i41;
            iArr5 = iArr10;
        }
        int[] iArr13 = iArr6;
        Bitmap bitmap3 = bitmapCopy;
        int i61 = i14;
        int[] iArr14 = iArr5;
        int i62 = height;
        int i63 = 0;
        while (i63 < width) {
            int i64 = -i11;
            int i65 = i16;
            int[] iArr15 = iArr;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = i64;
            int i74 = i64 * width;
            int i75 = 0;
            int i76 = 0;
            while (i73 <= i11) {
                int i77 = width;
                int iMax = Math.max(0, i74) + i63;
                int[] iArr16 = iArr7[i73 + i11];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr4[iMax];
                int iAbs2 = i21 - Math.abs(i73);
                i75 = (iArr2[iMax] * iAbs2) + i75;
                i76 = (iArr3[iMax] * iAbs2) + i76;
                i66 = (iArr4[iMax] * iAbs2) + i66;
                if (i73 > 0) {
                    i70 += iArr16[0];
                    i71 += iArr16[1];
                    i72 += iArr16[2];
                } else {
                    i67 += iArr16[0];
                    i68 += iArr16[1];
                    i69 += iArr16[2];
                }
                int i78 = i61;
                if (i73 < i78) {
                    i74 += i77;
                }
                i73++;
                i61 = i78;
                width = i77;
            }
            int i79 = width;
            int i80 = i61;
            int i81 = i63;
            int i82 = i11;
            int i83 = i62;
            int i84 = 0;
            while (i84 < i83) {
                iArr15[i81] = (iArr15[i81] & ViewCompat.MEASURED_STATE_MASK) | (iArr13[i75] << 16) | (iArr13[i76] << 8) | iArr13[i66];
                int i85 = i75 - i67;
                int i86 = i76 - i68;
                int i87 = i66 - i69;
                int[] iArr17 = iArr7[((i82 - i11) + i65) % i65];
                int i88 = i67 - iArr17[0];
                int i89 = i68 - iArr17[1];
                int i90 = i69 - iArr17[2];
                int i91 = i11;
                if (i63 == 0) {
                    iArr14[i84] = Math.min(i84 + i21, i80) * i79;
                }
                int i92 = iArr14[i84] + i63;
                int i93 = iArr2[i92];
                iArr17[0] = i93;
                int i94 = iArr3[i92];
                iArr17[1] = i94;
                int i95 = iArr4[i92];
                iArr17[2] = i95;
                int i96 = i70 + i93;
                int i97 = i71 + i94;
                int i98 = i72 + i95;
                i75 = i85 + i96;
                i76 = i86 + i97;
                i66 = i87 + i98;
                i82 = (i82 + 1) % i65;
                int[] iArr18 = iArr7[i82];
                int i99 = iArr18[0];
                i67 = i88 + i99;
                int i100 = iArr18[1];
                i68 = i89 + i100;
                int i101 = iArr18[2];
                i69 = i90 + i101;
                i70 = i96 - i99;
                i71 = i97 - i100;
                i72 = i98 - i101;
                i81 += i79;
                i84++;
                i11 = i91;
            }
            i63++;
            i61 = i80;
            i62 = i83;
            i16 = i65;
            iArr = iArr15;
            width = i79;
        }
        int i102 = width;
        bitmap3.setPixels(iArr, 0, i102, 0, 0, i102, i62);
        return bitmap3;
    }

    public static Bitmap I(@NonNull Bitmap bitmap, @ColorInt int i10, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        if (!z10) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        new Canvas(bitmap).drawColor(i10, PorterDuff.Mode.DARKEN);
        return bitmap;
    }

    public static Bitmap I0(Bitmap bitmap) {
        return J0(bitmap, Boolean.FALSE);
    }

    public static Bitmap J(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap J0(Bitmap bitmap, Boolean bool) {
        if (j0(bitmap)) {
            return null;
        }
        Bitmap bitmapExtractAlpha = bitmap.extractAlpha();
        if (bool.booleanValue() && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapExtractAlpha;
    }

    public static byte[] K(Drawable drawable, Bitmap.CompressFormat compressFormat) {
        if (drawable == null) {
            return null;
        }
        return l(J(drawable), compressFormat);
    }

    public static Bitmap K0(Bitmap bitmap) {
        return L0(bitmap, false);
    }

    @Nullable
    public static Bitmap L(@Nullable Drawable drawable, int i10, int i11) {
        Bitmap bitmapCreateBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (i10 > 0 || i11 > 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        } else {
            bitmapCreateBitmap = (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        bitmapCreateBitmap.eraseColor(Color.parseColor("#FFFFFF"));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap L0(Bitmap bitmap, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap M(Context context, Bitmap bitmap, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d) float f10, @FloatRange(from = 0.0d, fromInclusive = false, to = 25.0d) float f11) {
        return N(context, bitmap, f10, f11, false);
    }

    public static Bitmap M0(Bitmap bitmap) {
        return O0(bitmap, 0, 0, false);
    }

    public static Bitmap N(Context context, Bitmap bitmap, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d) float f10, @FloatRange(from = 0.0d, fromInclusive = false, to = 25.0d) float f11, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f10);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Paint paint = new Paint(3);
        Canvas canvas = new Canvas();
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.scale(f10, f10);
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        Bitmap bitmapR0 = r0(context, bitmapCreateBitmap, f11, z10);
        if (f10 == 1.0f) {
            if (z10 && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return bitmapR0;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapR0, width, height, true);
        if (!bitmapR0.isRecycled()) {
            bitmapR0.recycle();
        }
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap N0(Bitmap bitmap, @IntRange(from = 0) int i10, @ColorInt int i11) {
        return O0(bitmap, i10, i11, false);
    }

    public static Bitmap O(Context context, @DrawableRes int i10) {
        Drawable drawable = ContextCompat.getDrawable(context, i10);
        Canvas canvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap O0(Bitmap bitmap, @IntRange(from = 0) int i10, @ColorInt int i11, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        Paint paint = new Paint(1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        float f10 = iMin;
        float f11 = f10 / 2.0f;
        float f12 = width;
        float f13 = height;
        RectF rectF = new RectF(0.0f, 0.0f, f12, f13);
        rectF.inset((width - iMin) / 2.0f, (height - iMin) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.setTranslate(rectF.left, rectF.top);
        matrix.preScale(f10 / f12, f10 / f13);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawRoundRect(rectF, f11, f11, paint);
        if (i10 > 0) {
            paint.setShader(null);
            paint.setColor(i11);
            paint.setStyle(Paint.Style.STROKE);
            float f14 = i10;
            paint.setStrokeWidth(f14);
            canvas.drawCircle(f12 / 2.0f, f13 / 2.0f, f11 - (f14 / 2.0f), paint);
        }
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap P(Context context, @DrawableRes int i10, int i11, int i12) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources resources = context.getResources();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i10, options);
        options.inSampleSize = p(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i10, options);
    }

    public static Bitmap P0(Bitmap bitmap, boolean z10) {
        return O0(bitmap, 0, 0, z10);
    }

    public static Bitmap Q(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static Bitmap Q0(Bitmap bitmap, float f10) {
        return S0(bitmap, f10, 0, 0, false);
    }

    public static Bitmap R(File file, int i10, int i11) {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = p(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    public static Bitmap R0(Bitmap bitmap, float f10, @IntRange(from = 0) int i10, @ColorInt int i11) {
        return S0(bitmap, f10, i10, i11, false);
    }

    public static Bitmap S(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            return null;
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    public static Bitmap S0(Bitmap bitmap, float f10, @IntRange(from = 0) int i10, @ColorInt int i11, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint(1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        float f11 = i10;
        float f12 = f11 / 2.0f;
        rectF.inset(f12, f12);
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (i10 > 0) {
            paint.setShader(null);
            paint.setColor(i11);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f11);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawRoundRect(rectF, f10, f10, paint);
        }
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap T(FileDescriptor fileDescriptor, int i10, int i11) {
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = p(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static Bitmap T0(Bitmap bitmap, float f10, boolean z10) {
        return S0(bitmap, f10, 0, 0, z10);
    }

    public static Bitmap U(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap U0(View view) {
        if (view == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap V(InputStream inputStream, int i10, int i11) {
        if (inputStream == null) {
            return null;
        }
        return Z(h0(inputStream), 0, i10, i11);
    }

    public static Bitmap W(String str) {
        if (p0(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap X(String str, int i10, int i11) {
        if (p0(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = p(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap Y(byte[] bArr, int i10) {
        if (bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, i10, bArr.length);
    }

    public static Bitmap Z(byte[] bArr, int i10, int i11, int i12) {
        if (bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i10, bArr.length, options);
        options.inSampleSize = p(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, i10, bArr.length, options);
    }

    public static Bitmap a(Bitmap bitmap, @IntRange(from = 1) int i10, @ColorInt int i11, boolean z10, float f10, boolean z11) {
        if (j0(bitmap)) {
            return null;
        }
        if (!z11) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(i11);
        paint.setStyle(Paint.Style.STROKE);
        float f11 = i10;
        paint.setStrokeWidth(f11);
        if (z10) {
            canvas.drawCircle(width / 2.0f, height / 2.0f, (Math.min(width, height) / 2.0f) - (f11 / 2.0f), paint);
        } else {
            int i12 = i10 >> 1;
            float f12 = i12;
            canvas.drawRoundRect(new RectF(f12, f12, width - i12, height - i12), f10, f10, paint);
        }
        return bitmap;
    }

    public static File a0(String str) {
        if (p0(str)) {
            return null;
        }
        return new File(str);
    }

    public static Bitmap b(Bitmap bitmap, @IntRange(from = 1) int i10, @ColorInt int i11) {
        return a(bitmap, i10, i11, true, 0.0f, false);
    }

    public static String b0(String str) {
        if (p0(str)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || str.lastIndexOf(File.separator) >= iLastIndexOf) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static Bitmap c(Bitmap bitmap, @IntRange(from = 1) int i10, @ColorInt int i11, boolean z10) {
        return a(bitmap, i10, i11, true, 0.0f, z10);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String c0(File file) throws Throwable {
        Throwable th2;
        FileInputStream fileInputStream;
        IOException e10;
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        String strD0 = d0(fileInputStream);
                        if (strD0 == null) {
                            fileInputStream.close();
                            return b0(file.getAbsolutePath()).toUpperCase();
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        return strD0;
                    } catch (IOException e12) {
                        e10 = e12;
                        e10.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return b0(file.getAbsolutePath()).toUpperCase();
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    throw th2;
                }
            } catch (IOException e14) {
                fileInputStream = null;
                e10 = e14;
            } catch (Throwable th4) {
                th2 = th4;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th2;
            }
        } catch (IOException e15) {
            e15.printStackTrace();
        }
    }

    public static Bitmap d(Bitmap bitmap, @IntRange(from = 1) int i10, @ColorInt int i11, @FloatRange(from = 0.0d) float f10) {
        return a(bitmap, i10, i11, false, f10, false);
    }

    public static String d0(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[8];
            if (inputStream.read(bArr, 0, 8) != -1) {
                return f0(bArr);
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Bitmap e(Bitmap bitmap, @IntRange(from = 1) int i10, @ColorInt int i11, @FloatRange(from = 0.0d) float f10, boolean z10) {
        return a(bitmap, i10, i11, false, f10, z10);
    }

    public static String e0(String str) {
        return c0(a0(str));
    }

    public static Bitmap f(Bitmap bitmap, Bitmap bitmap2, int i10, int i11, int i12) {
        return g(bitmap, bitmap2, i10, i11, i12, false);
    }

    public static String f0(byte[] bArr) {
        if (n0(bArr)) {
            return "JPEG";
        }
        if (k0(bArr)) {
            return "GIF";
        }
        if (o0(bArr)) {
            return "PNG";
        }
        if (i0(bArr)) {
            return "BMP";
        }
        return null;
    }

    public static Bitmap g(Bitmap bitmap, Bitmap bitmap2, int i10, int i11, int i12, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        if (!j0(bitmap2)) {
            Paint paint = new Paint(1);
            Canvas canvas = new Canvas(bitmapCopy);
            paint.setAlpha(i12);
            canvas.drawBitmap(bitmap2, i10, i11, paint);
        }
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCopy;
    }

    public static int g0(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static Bitmap h(Bitmap bitmap, int i10) {
        return i(bitmap, i10, false);
    }

    public static byte[] h0(InputStream inputStream) {
        try {
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = inputStream.read(bArr, 0, 1024);
                if (i10 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static Bitmap i(Bitmap bitmap, int i10, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, height - i10, width, i10, matrix, false);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width, height + i10, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f10 = height;
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, f10, (Paint) null);
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(0.0f, height, 0.0f, bitmapCreateBitmap2.getHeight(), 1895825407, 16777215, Shader.TileMode.MIRROR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f10, width, bitmapCreateBitmap2.getHeight(), paint);
        if (!bitmapCreateBitmap.isRecycled()) {
            bitmapCreateBitmap.recycle();
        }
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap2;
    }

    public static boolean i0(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 66 && bArr[1] == 77;
    }

    public static Bitmap j(Bitmap bitmap, String str, float f10, @ColorInt int i10, float f11, float f12, boolean z10) {
        if (j0(bitmap) || str == null) {
            return null;
        }
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        Canvas canvas = new Canvas(bitmapCopy);
        paint.setColor(i10);
        paint.setTextSize(f10);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f11, f12 + f10, paint);
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCopy;
    }

    public static boolean j0(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static Bitmap k(Bitmap bitmap, String str, int i10, @ColorInt int i11, float f10, float f11) {
        return j(bitmap, str, i10, i11, f10, f11, false);
    }

    public static boolean k0(byte[] bArr) {
        if (bArr.length < 6 || bArr[0] != 71 || bArr[1] != 73 || bArr[2] != 70 || bArr[3] != 56) {
            return false;
        }
        byte b10 = bArr[4];
        return (b10 == 55 || b10 == 57) && bArr[5] == 97;
    }

    public static byte[] l(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean l0(File file) {
        return file != null && m0(file.getPath());
    }

    public static Drawable m(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static boolean m0(String str) {
        String upperCase = str.toUpperCase();
        return upperCase.endsWith(".PNG") || upperCase.endsWith(".JPG") || upperCase.endsWith(".JPEG") || upperCase.endsWith(".BMP") || upperCase.endsWith(".GIF") || upperCase.endsWith(".WEBP");
    }

    public static Bitmap n(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static boolean n0(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == -1 && bArr[1] == -40;
    }

    public static Drawable o(Context context, byte[] bArr) {
        return m(context, n(bArr));
    }

    public static boolean o0(byte[] bArr) {
        return bArr.length >= 8 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    public static int p(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        while (true) {
            i13 >>= 1;
            if (i13 < i10 || (i12 = i12 >> 1) < i11) {
                break;
            }
            i14 <<= 1;
        }
        return i14;
    }

    public static boolean p0(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static Bitmap q(Bitmap bitmap, int i10, int i11, int i12, int i13) {
        return r(bitmap, i10, i11, i12, i13, false);
    }

    @RequiresApi(17)
    public static Bitmap q0(Context context, Bitmap bitmap, @FloatRange(from = 0.0d, fromInclusive = false, to = 25.0d) float f10) {
        return r0(context, bitmap, f10, false);
    }

    public static Bitmap r(Bitmap bitmap, int i10, int i11, int i12, int i13, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i10, i11, i12, i13);
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    @RequiresApi(17)
    public static Bitmap r0(Context context, Bitmap bitmap, @FloatRange(from = 0.0d, fromInclusive = false, to = 25.0d) float f10, boolean z10) {
        if (!z10) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        RenderScript renderScriptCreate = null;
        try {
            renderScriptCreate = RenderScript.create(context.getApplicationContext());
            renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(f10);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmap);
            renderScriptCreate.destroy();
            return bitmap;
        } catch (Throwable th2) {
            if (renderScriptCreate != null) {
                renderScriptCreate.destroy();
            }
            throw th2;
        }
    }

    public static Bitmap s(Bitmap bitmap, @IntRange(from = 0, to = r5.a.f14285d) int i10) {
        return t(bitmap, i10, false);
    }

    public static Bitmap s0(Bitmap bitmap, int i10, float f10, float f11) {
        return t0(bitmap, i10, f10, f11, false);
    }

    public static Bitmap t(Bitmap bitmap, @IntRange(from = 0, to = r5.a.f14285d) int i10, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap t0(Bitmap bitmap, int i10, float f10, float f11, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        if (i10 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i10, f10, f11);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap u(Bitmap bitmap, long j10) {
        return v(bitmap, j10, false);
    }

    public static boolean u0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return v0(bitmap, file, compressFormat, false);
    }

    public static Bitmap v(Bitmap bitmap, long j10, boolean z10) {
        byte[] byteArray;
        if (j0(bitmap) || j10 <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        int i10 = 100;
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.size() <= j10) {
            byteArray = byteArrayOutputStream.toByteArray();
        } else {
            byteArrayOutputStream.reset();
            bitmap.compress(compressFormat, 0, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= j10) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                int i11 = 0;
                int i12 = 0;
                while (i11 < i10) {
                    i12 = (i11 + i10) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i12, byteArrayOutputStream);
                    long size = byteArrayOutputStream.size();
                    if (size == j10) {
                        break;
                    }
                    if (size > j10) {
                        i10 = i12 - 1;
                    } else {
                        i11 = i12 + 1;
                    }
                }
                if (i10 == i12 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream);
                }
                byteArray = byteArrayOutputStream.toByteArray();
            }
        }
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static boolean v0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z10) throws Throwable {
        boolean zCompress = false;
        if (j0(bitmap) || !F(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        zCompress = bitmap.compress(compressFormat, 100, bufferedOutputStream2);
                        if (z10 && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream2.close();
                    } catch (IOException e10) {
                        e = e10;
                        bufferedOutputStream = bufferedOutputStream2;
                        e.printStackTrace();
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return zCompress;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            } catch (IOException e13) {
                e = e13;
            }
            return zCompress;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static Bitmap w(Bitmap bitmap, int i10) {
        return z(bitmap, i10, false);
    }

    public static boolean w0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return v0(bitmap, a0(str), compressFormat, false);
    }

    public static Bitmap x(Bitmap bitmap, int i10, int i11) {
        return y(bitmap, i10, i11, false);
    }

    public static boolean x0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z10) {
        return v0(bitmap, a0(str), compressFormat, z10);
    }

    public static Bitmap y(Bitmap bitmap, int i10, int i11, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        options.inSampleSize = p(options, i10, i11);
        options.inJustDecodeBounds = false;
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap y0(Bitmap bitmap, float f10, float f11) {
        return z0(bitmap, f10, f11, false);
    }

    public static Bitmap z(Bitmap bitmap, int i10, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap z0(Bitmap bitmap, float f10, float f11, boolean z10) {
        if (j0(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }
}
