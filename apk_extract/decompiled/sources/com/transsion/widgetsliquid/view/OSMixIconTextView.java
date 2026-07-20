package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetthemes.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(36)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0014J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSMixIconTextView;", "Lcom/transsion/widgetsliquid/view/OSMixColorTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "isNeedRtl", "", "mDefaultSize", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setSupportRtl", "supportRtl", "Companion", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSMixIconTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSMixIconTextView.kt\ncom/transsion/widgetsliquid/view/OSMixIconTextView\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n*L\n1#1,112:1\n13#2,9:113\n*S KotlinDebug\n*F\n+ 1 OSMixIconTextView.kt\ncom/transsion/widgetsliquid/view/OSMixIconTextView\n*L\n42#1:113,9\n*E\n"})
public class OSMixIconTextView extends OSMixColorTextView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TTF_RES = "tossymbol.ttf";
    private final String TAG;
    private boolean isNeedRtl;
    private int mDefaultSize;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSMixIconTextView$Companion;", "", "()V", "TTF_RES", "", "getTTF_RES", "()Ljava/lang/String;", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTTF_RES() {
            return OSMixIconTextView.TTF_RES;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMixIconTextView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if ((View.MeasureSpec.getMode(widthMeasureSpec) == Integer.MIN_VALUE || View.MeasureSpec.getMode(widthMeasureSpec) == 0) && (View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE || View.MeasureSpec.getMode(heightMeasureSpec) == 0)) {
            widthMeasureSpec = getPaddingEnd() + getPaddingStart() + View.MeasureSpec.makeMeasureSpec(this.mDefaultSize, BasicMeasure.EXACTLY);
            heightMeasureSpec = getPaddingBottom() + getPaddingTop() + View.MeasureSpec.makeMeasureSpec(this.mDefaultSize, BasicMeasure.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setSupportRtl(boolean supportRtl) {
        this.isNeedRtl = supportRtl;
        if (supportRtl) {
            setRotationY(Utils.isRtl() ? 180.0f : 0.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMixIconTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMixIconTextView(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSMixIconTextView(Context context, AttributeSet attributeSet, int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet, (i10 & 4) != 0 ? 0 : i8, (i10 & 8) != 0 ? 0 : i9);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMixIconTextView(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "OSMixIconTextView";
        setTypeface(Typeface.createFromAsset(context.getAssets(), TTF_RES));
        setGravity(17);
        this.mDefaultSize = context.getResources().getDimensionPixelSize(R.dimen.os_icon_textview_default_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.textSize, android.R.attr.textColor, android.R.attr.clickable}, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (!typedArrayObtainStyledAttributes.getValue(0, new TypedValue())) {
            setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.os_icon_textview_default_text_size));
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(1);
            if (colorStateList != null) {
                setTextColor(colorStateList);
            } else {
                setTextColor(typedArrayObtainStyledAttributes.getColor(1, 0));
            }
        } else {
            setTextColor(context.getColorStateList(R.color.os_icon_tertiary_hios));
        }
        if (!typedArrayObtainStyledAttributes.hasValue(2)) {
            setClickable(true);
        }
        typedArrayObtainStyledAttributes.recycle();
        setVerticalScrollBarEnabled(false);
        setElegantTextHeight(false);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.OSIconTextView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes2, "context.obtainStyledAttr…styleable.OSIconTextView)");
        int indexCount = typedArrayObtainStyledAttributes2.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes2.getIndex(i10);
            if (index == R$styleable.OSIconTextView_os_icon_support_rtl) {
                this.isNeedRtl = typedArrayObtainStyledAttributes2.getBoolean(index, false);
            }
        }
        typedArrayObtainStyledAttributes2.recycle();
        setSupportRtl(this.isNeedRtl);
    }
}
