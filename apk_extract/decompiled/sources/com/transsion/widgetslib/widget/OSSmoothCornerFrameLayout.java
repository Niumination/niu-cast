package com.transsion.widgetslib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ld.j;
import u8.b;
import u8.d;
import zd.s;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/transsion/widgetslib/widget/OSSmoothCornerFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", TypedValues.Custom.S_COLOR, "", "setFillColor", "(I)V", "Lld/j;", "a", "Lld/j;", "getDialogController", "()Lld/j;", "setDialogController", "(Lld/j;)V", "dialogController", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSSmoothCornerFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public j dialogController;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f3417d;
    public final d e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSmoothCornerFrameLayout(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
    }

    public final j getDialogController() {
        return this.dialogController;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        j jVar = this.dialogController;
        if (jVar != null && pd.j.f8772k) {
            Context context = jVar.f7378a;
            if ((!pd.j.t(context) || (pd.j.r(context) && !pd.j.m(context) && !pd.j.u(context))) && !pd.j.z(context) && !jVar.d() && context.getResources().getConfiguration().orientation == 1) {
                i9 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(View.MeasureSpec.getSize(i9), (getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R$dimen.os_dialog_top_margin)) - getContext().getResources().getDimensionPixelSize(R$dimen.os_dialog_bottom_margin)), View.MeasureSpec.getMode(i9));
            }
        }
        super.onMeasure(i8, i9);
        View.MeasureSpec.getSize(i9);
    }

    public final void setDialogController(j jVar) {
        this.dialogController = jVar;
    }

    public final void setFillColor(int color) {
        this.f3416c = color;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSmoothCornerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSSmoothCornerFrameLayout(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSmoothCornerFrameLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        b bVar = new b();
        Drawable drawable = context.getDrawable(R$drawable.os_dialog_bg);
        this.f3417d = drawable;
        this.e = new d();
        this.f3415b = context.getResources().getDimension(R$dimen.os_radius_xxl);
        int color = context.getColor(R$color.os_altitude_secondary_color);
        this.f3416c = color;
        if (drawable != null) {
            drawable.setTint(color);
        }
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f3416c);
        if (bVar.b(l9.a.f7350k).c()) {
            setClipToOutline(true);
            setOutlineProvider(new s(this));
        }
    }
}
