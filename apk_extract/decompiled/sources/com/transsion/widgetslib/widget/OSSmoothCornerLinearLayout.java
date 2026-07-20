package com.transsion.widgetslib.widget;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import md.f;
import u8.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/widgetslib/widget/OSSmoothCornerLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSSmoothCornerLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f3420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f3421d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSmoothCornerLinearLayout(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        b bVar = this.f3421d;
        bVar.getClass();
        if (bVar.b(l9.a.f7350k).c()) {
            setBackground(new f(getContext(), new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f3419b, this.f3418a));
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
        this.f3421d = new b();
        this.f3418a = context.getResources().getDimension(R$dimen.os_radius_m);
        int color = context.getColor(R$color.os_color_gray80);
        this.f3419b = color;
        Drawable drawable = context.getDrawable(R$drawable.os_snackbar_background);
        this.f3420c = drawable;
        if (drawable != null) {
            drawable.setTint(color);
        }
        setBackground(drawable);
    }
}
