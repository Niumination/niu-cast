package com.transsion.widgetslib.widget.shadow;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$styleable;
import fe.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/transsion/widgetslib/widget/shadow/OSShadowContainerView;", "Landroid/widget/FrameLayout;", "", "corner", "", "setShadowCorner", "(I)V", "level", "setShadowLevel", "shadowColor", "setShadowColor", "dy", "setShadowDy", "Landroid/graphics/Paint;", "c", "Lkotlin/Lazy;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSShadowContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f3640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy mPaint;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3643d;
    public final boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3647k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3648l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3649m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSShadowContainerView(Context context) {
        this(context, null, 0, 14);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Paint getMPaint() {
        return (Paint) this.mPaint.getValue();
    }

    public final void a() {
        int i8 = this.f3643d;
        boolean z2 = this.e;
        switch (i8) {
            case 0:
                this.f3644h = z2 ? getContext().getColor(R$color.os_shadow_color_level1_hios) : getContext().getColor(R$color.os_shadow_color_level1_xos);
                this.f3645i = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level1);
                this.f3646j = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level1);
                this.f3647k = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_hor_inset_level1);
                this.f3648l = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level1);
                this.f3649m = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_bottom_level1);
                break;
            case 1:
                this.f3644h = z2 ? getContext().getColor(R$color.os_shadow_color_level2_hios) : getContext().getColor(R$color.os_shadow_color_level2_xos);
                this.f3645i = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level2);
                this.f3646j = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level2);
                this.f3647k = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_hor_inset_level2);
                this.f3648l = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level2);
                this.f3649m = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_bottom_level2);
                break;
            case 2:
                this.f3644h = z2 ? getContext().getColor(R$color.os_shadow_color_level3_hios) : getContext().getColor(R$color.os_shadow_color_level3_xos);
                this.f3645i = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level3);
                this.f3646j = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level3);
                this.f3647k = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_hor_inset_level3);
                this.f3648l = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level3);
                this.f3649m = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_bottom_level3);
                break;
            case 3:
                this.f3644h = z2 ? getContext().getColor(R$color.os_shadow_color_level4_hios) : getContext().getColor(R$color.os_shadow_color_level4_xos);
                this.f3645i = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level4);
                this.f3646j = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level4);
                this.f3647k = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_hor_inset_level4);
                this.f3648l = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level4);
                this.f3649m = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_bottom_level4);
                break;
            case 4:
                this.f3644h = getContext().getColor(R$color.os_shadow_image_color_level1);
                this.f3645i = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level1);
                this.f3646j = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level1);
                this.f3647k = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_hor_inset_level1);
                this.f3648l = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level1);
                this.f3649m = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_bottom_level1);
                break;
            case 5:
                this.f3644h = getContext().getColor(R$color.os_shadow_image_color_level2);
                this.f3645i = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level2);
                this.f3646j = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level2);
                this.f3647k = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_hor_inset_level2);
                this.f3648l = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level2);
                this.f3649m = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_bottom_level2);
                break;
            case 6:
                this.f3644h = getContext().getColor(R$color.os_shadow_image_color_level3);
                this.f3645i = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level3);
                this.f3646j = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level3);
                this.f3647k = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_hor_inset_level3);
                this.f3648l = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level3);
                this.f3649m = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_bottom_level3);
                break;
            case 7:
                this.f3644h = getContext().getColor(R$color.os_shadow_image_color_level4);
                this.f3645i = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level4);
                this.f3646j = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level4);
                this.f3647k = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_hor_inset_level4);
                this.f3648l = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level4);
                this.f3649m = getContext().getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_bottom_level4);
                break;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getMPaint().setColor(getContext().getColor(R.color.transparent));
        getMPaint().setShadowLayer(this.f3645i, 0.0f, this.f3646j, this.f3644h);
        RectF rectF = this.f3640a;
        int i8 = this.f3641b;
        canvas.drawRoundRect(rectF, i8, i8, getMPaint());
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.f3640a.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        }
    }

    public final void setShadowColor(@ColorInt int shadowColor) {
        if (this.f3644h == shadowColor) {
            return;
        }
        this.f3644h = shadowColor;
        invalidate();
    }

    public final void setShadowCorner(int corner) {
        if (this.f3641b == corner) {
            return;
        }
        this.f3641b = corner;
        invalidate();
    }

    public final void setShadowDy(int dy) {
        this.f3646j = dy;
        invalidate();
    }

    public final void setShadowLevel(int level) {
        if (level == this.f3643d) {
            return;
        }
        this.f3643d = level;
        a();
        int i8 = this.f3647k;
        setPadding(i8, this.f3648l, i8, this.f3649m);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSShadowContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 12);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSShadowContainerView(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 8);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OSShadowContainerView(Context context, AttributeSet attributeSet, int i8, int i9) {
        attributeSet = (i9 & 2) != 0 ? null : attributeSet;
        i8 = (i9 & 4) != 0 ? 0 : i8;
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i8, 0);
        this.f3640a = new RectF();
        this.mPaint = LazyKt.lazy(d.INSTANCE);
        this.f3643d = 1;
        this.e = StringsKt__StringsJVMKt.equals(j.f8764a[0], j.getOsType(), true);
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSShadowStyle);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….styleable.OSShadowStyle)");
        this.f3643d = typedArrayObtainStyledAttributes.getInteger(R$styleable.OSShadowStyle_os_shadow_level, 1);
        this.f3641b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.OSShadowStyle_os_shadow_corner, 0);
        typedArrayObtainStyledAttributes.recycle();
        a();
        int i10 = this.f3647k;
        setPadding(i10, this.f3648l, i10, this.f3649m);
    }
}
