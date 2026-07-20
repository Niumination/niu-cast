package com.transsion.widgetsbottomsheet.bottomsheet;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import md.f;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/widgetsbottomsheet/bottomsheet/OSSmoothCornerLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widgetsbottomsheet_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSSmoothCornerLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f3023d;
    public final RectF e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSmoothCornerLinearLayout(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getContext();
        if (!j.f8768g) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        RectF rectF = this.e;
        rectF.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.f3023d;
        path.reset();
        float f = this.f3020a;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f3022c != j.a(getContext())) {
            this.f3022c = !this.f3022c;
            invalidate();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        if (this.f3022c) {
            setBackground(new f(getContext(), new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f3021b, this.f3020a));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSmoothCornerLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSSmoothCornerLinearLayout(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSmoothCornerLinearLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3023d = new Path();
        this.e = new RectF();
        this.f3020a = context.getResources().getDimension(R$dimen.os_radius_xxxl);
        this.f3021b = context.getColor(R$color.os_altitude_secondary_color);
        this.f3022c = j.t(context) && !j.s() && (!j.r(context) || j.m(context) || j.u(context));
    }
}
