package wd;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.RequiresApi;
import k3.z8;
import kotlin.jvm.internal.Intrinsics;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f10713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f10716d;
    public final Paint e;
    public final Paint f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f10719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f10720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearGradient f10721k;

    public g(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f10713a = 90.0f;
        this.f10715c = true;
        this.f10716d = new RectF();
        Paint paint = new Paint(1);
        this.e = paint;
        Paint paint2 = new Paint(1);
        this.f = paint2;
        this.f10717g = -1;
        this.f10718h = -1;
        this.f10719i = new float[]{0.0f, 1.0f};
        this.f10720j = new int[]{872415231, 234881023};
        String[] strArr = j.f8764a;
        float fA = hd.a.a(mContext, 2);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(fA);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1);
        paint.setBlendMode(BlendMode.PLUS);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
    }

    public final float getCornerRadius() {
        return this.f10713a;
    }

    public final void setActualWidth(int i8) {
        this.f10717g = i8;
    }

    public final void setBgColor(int i8) {
    }

    public final void setCornerRadius(float f) {
        this.f10713a = f;
    }

    public final void setDefaultBgColor(int i8) {
        z8.b("OSLiquidDrawable", "setDefaultBgColor: " + Integer.toHexString(i8));
        this.f10714b = i8;
    }

    public final void setEndsLeftTop(float f) {
    }

    public final void setEndsRightBottom(float f) {
    }

    public final void setGradientStrokeColor(int[] iArr) {
        Intrinsics.checkNotNull(iArr);
        this.f10720j = iArr;
    }

    public final void setPositionsLT(float[] fArr) {
        Intrinsics.checkNotNull(fArr);
        this.f10719i = fArr;
    }

    public final void setRadius(float f) {
        this.f10713a = f;
    }

    public final void setShowBlendColor2(boolean z2) {
        z8.b("OSLiquidDrawable", "setShowBlendColor: mShowBlendColor2 = " + z2);
    }

    public final void setShowOutline(boolean z2) {
        this.f10715c = z2;
        z8.b("OSLiquidDrawable", "setShowOutline: mShowOutLine = " + z2);
    }

    public final void setShowOutlineMixColor(boolean z2) {
        z8.b("OSLiquidDrawable", "setShowOutline: mShowOutLineMixColor = " + z2);
    }

    @RequiresApi(29)
    public final void setStrokeBlendMode(BlendMode blendMode) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        this.e.setBlendMode(blendMode);
    }
}
