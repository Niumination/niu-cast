package com.transsion.widgetsbottomsheet.bottomsheet;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetsThemes.R$dimen;
import com.transsion.widgetsThemes.R$string;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import com.transsion.widgetsbottomsheet.databinding.OsBottomSheetTitleBinding;
import com.transsion.widgetsliquid.view.OSLiquidButton;
import com.transsion.widgetsliquid.view.OSLiquidTextButton;
import gd.n;
import gd.o;
import gd.p;
import hd.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/transsion/widgetsbottomsheet/bottomsheet/OSPageView;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "Lcom/transsion/widgetsliquid/view/OSLiquidButton;", "getBackImageView", "()Lcom/transsion/widgetsliquid/view/OSLiquidButton;", "getCloseImageView", "getLeftIconView", "getRightIconView", "Lcom/transsion/widgetsliquid/view/OSLiquidTextButton;", "getLeftButtonView", "()Lcom/transsion/widgetsliquid/view/OSLiquidTextButton;", "getRightButtonView", "getTitleView", "Landroid/widget/TextView;", "textView", "", "setTextExceedSize", "(Landroid/widget/TextView;)V", "Lcom/transsion/widgetsbottomsheet/databinding/OsBottomSheetTitleBinding;", "c", "Lkotlin/Lazy;", "getMDataBinding", "()Lcom/transsion/widgetsbottomsheet/databinding/OsBottomSheetTitleBinding;", "mDataBinding", "widgetsbottomsheet_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSPageView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSPageView.kt\ncom/transsion/widgetsbottomsheet/bottomsheet/OSPageView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,466:1\n260#2:467\n302#2:468\n281#2:469\n260#2:470\n302#2:471\n281#2:472\n260#2:473\n302#2:474\n281#2:475\n260#2:476\n302#2:477\n281#2:478\n260#2:479\n260#2:480\n260#2:481\n260#2:482\n260#2:483\n260#2:484\n260#2:485\n260#2:486\n260#2:487\n260#2:488\n*S KotlinDebug\n*F\n+ 1 OSPageView.kt\ncom/transsion/widgetsbottomsheet/bottomsheet/OSPageView\n*L\n185#1:467\n190#1:468\n190#1:469\n201#1:470\n206#1:471\n206#1:472\n216#1:473\n221#1:474\n221#1:475\n231#1:476\n236#1:477\n236#1:478\n251#1:479\n263#1:480\n276#1:481\n289#1:482\n302#1:483\n307#1:484\n312#1:485\n317#1:486\n404#1:487\n409#1:488\n*E\n"})
public final class OSPageView extends LinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f3015h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f3016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f3017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy mDataBinding;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3019d;
    public int e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSPageView(Context context) {
        this(context, null, 0, 14);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.text.Layout] */
    public static final void b(OSPageView oSPageView, TextView textView) {
        oSPageView.getClass();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? layout = textView.getLayout();
        if (layout == 0) {
            return;
        }
        objectRef.element = layout;
        Ref.IntRef intRef = new Ref.IntRef();
        int ellipsisCount = ((Layout) objectRef.element).getEllipsisCount(0);
        intRef.element = ellipsisCount;
        if (ellipsisCount > 0) {
            if (!oSPageView.f3019d) {
                float textSize = oSPageView.getMDataBinding().f3034i.getTextSize();
                String[] strArr = j.f8764a;
                String[] strArr2 = a.f5293a;
                float f = 2;
                oSPageView.getMDataBinding().f3034i.setTextSize(0, textSize - ((int) TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics())));
                oSPageView.getMDataBinding().f3033h.setTextSize(0, oSPageView.getMDataBinding().f3033h.getTextSize() - ((int) TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics())));
                oSPageView.f3019d = true;
            }
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new n(textView, objectRef, intRef, oSPageView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OsBottomSheetTitleBinding getMDataBinding() {
        return (OsBottomSheetTitleBinding) this.mDataBinding.getValue();
    }

    private final void setTextExceedSize(TextView textView) {
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new p(textView, this, 0));
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        this.f3017b = view;
        c();
        super.addView(view);
    }

    public final void c() {
        removeAllViews();
        super.addView(getMDataBinding().f3029a);
        OsBottomSheetTitleBinding mDataBinding = getMDataBinding();
        final int i8 = 0;
        mDataBinding.f3032d.setOnClickListener(new View.OnClickListener(this) { // from class: gd.m

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSPageView f5148b;

            {
                this.f5148b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OSPageView this$0 = this.f5148b;
                switch (i8) {
                    case 0:
                        int i9 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                    case 1:
                        int i10 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        View.OnClickListener onClickListener = this$0.f3016a;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                        break;
                    case 2:
                        int i11 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                    default:
                        int i12 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                }
            }
        });
        final int i9 = 1;
        mDataBinding.e.setOnClickListener(new View.OnClickListener(this) { // from class: gd.m

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSPageView f5148b;

            {
                this.f5148b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OSPageView this$0 = this.f5148b;
                switch (i9) {
                    case 0:
                        int i10 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                    case 1:
                        int i11 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        View.OnClickListener onClickListener = this$0.f3016a;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                        break;
                    case 2:
                        int i12 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                    default:
                        int i13 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                }
            }
        });
        final int i10 = 2;
        mDataBinding.f3030b.setOnClickListener(new View.OnClickListener(this) { // from class: gd.m

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSPageView f5148b;

            {
                this.f5148b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OSPageView this$0 = this.f5148b;
                switch (i10) {
                    case 0:
                        int i11 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                    case 1:
                        int i12 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        View.OnClickListener onClickListener = this$0.f3016a;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                        break;
                    case 2:
                        int i13 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                    default:
                        int i14 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                }
            }
        });
        final int i11 = 3;
        mDataBinding.f3031c.setOnClickListener(new View.OnClickListener(this) { // from class: gd.m

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSPageView f5148b;

            {
                this.f5148b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OSPageView this$0 = this.f5148b;
                switch (i11) {
                    case 0:
                        int i12 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                    case 1:
                        int i13 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        View.OnClickListener onClickListener = this$0.f3016a;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                        break;
                    case 2:
                        int i14 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                    default:
                        int i15 = OSPageView.f3015h;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.getClass();
                        break;
                }
            }
        });
    }

    public final void d(View.OnClickListener onTitleClickListener) {
        Intrinsics.checkNotNullParameter(onTitleClickListener, "onTitleClickListener");
        int i8 = R$string.os_close;
        Intrinsics.checkNotNullParameter(onTitleClickListener, "onTitleClickListener");
        this.f3016a = onTitleClickListener;
        getMDataBinding().e.setIcon(i8);
        getMDataBinding().e.setVisibility(0);
        this.e++;
        OSLiquidButton oSLiquidButton = getMDataBinding().e;
        Intrinsics.checkNotNullExpressionValue(oSLiquidButton, "mDataBinding.imgRight");
        if (this.e == 1) {
            if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3032d)) {
                getMDataBinding().e.setVisibility(4);
            } else if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().e)) {
                getMDataBinding().f3032d.setVisibility(4);
            } else if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3030b)) {
                getMDataBinding().f3031c.setVisibility(4);
                getMDataBinding().f3031c.setText(getMDataBinding().f3030b.getText());
            } else if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3031c)) {
                getMDataBinding().f3030b.setVisibility(4);
                getMDataBinding().f3030b.setText(getMDataBinding().f3031c.getText());
            }
        }
        if (this.e == 2) {
            if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3032d)) {
                OSLiquidTextButton oSLiquidTextButton = getMDataBinding().f3031c;
                Intrinsics.checkNotNullExpressionValue(oSLiquidTextButton, "mDataBinding.buttonRight");
                if (oSLiquidTextButton.getVisibility() == 0) {
                    getMDataBinding().f3030b.setVisibility(8);
                }
            } else if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().e)) {
                OSLiquidTextButton oSLiquidTextButton2 = getMDataBinding().f3030b;
                Intrinsics.checkNotNullExpressionValue(oSLiquidTextButton2, "mDataBinding.buttonLeft");
                if (oSLiquidTextButton2.getVisibility() == 0) {
                    getMDataBinding().f3031c.setVisibility(8);
                }
            } else if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3030b)) {
                OSLiquidButton oSLiquidButton2 = getMDataBinding().e;
                Intrinsics.checkNotNullExpressionValue(oSLiquidButton2, "mDataBinding.imgRight");
                if (oSLiquidButton2.getVisibility() == 0) {
                    getMDataBinding().f3032d.setVisibility(8);
                }
            } else if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3031c)) {
                OSLiquidButton oSLiquidButton3 = getMDataBinding().f3032d;
                Intrinsics.checkNotNullExpressionValue(oSLiquidButton3, "mDataBinding.imgLeft");
                if (oSLiquidButton3.getVisibility() == 0) {
                    getMDataBinding().e.setVisibility(8);
                }
            }
        }
        if (this.e == 0) {
            if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3032d)) {
                getMDataBinding().e.setVisibility(8);
                return;
            }
            if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().e)) {
                getMDataBinding().f3032d.setVisibility(8);
            } else if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3030b)) {
                getMDataBinding().f3031c.setVisibility(8);
            } else if (Intrinsics.areEqual(oSLiquidButton, getMDataBinding().f3031c)) {
                getMDataBinding().f3030b.setVisibility(8);
            }
        }
    }

    public final void e(int i8) {
        getMDataBinding().f3034i.setText(i8);
        TextView textView = getMDataBinding().f3034i;
        Intrinsics.checkNotNullExpressionValue(textView, "mDataBinding.tvTitle");
        setTextExceedSize(textView);
    }

    public final void f(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        getMDataBinding().f3034i.setText(title);
        TextView textView = getMDataBinding().f3034i;
        Intrinsics.checkNotNullExpressionValue(textView, "mDataBinding.tvTitle");
        setTextExceedSize(textView);
    }

    public final OSLiquidButton getBackImageView() {
        return getLeftIconView();
    }

    public final OSLiquidButton getCloseImageView() {
        return getRightIconView();
    }

    /* JADX INFO: renamed from: getContentView, reason: from getter */
    public final View getF3017b() {
        return this.f3017b;
    }

    public final OSLiquidTextButton getLeftButtonView() {
        OSLiquidTextButton oSLiquidTextButton = getMDataBinding().f3030b;
        Intrinsics.checkNotNullExpressionValue(oSLiquidTextButton, "mDataBinding.buttonLeft");
        return oSLiquidTextButton;
    }

    public final OSLiquidButton getLeftIconView() {
        OSLiquidButton oSLiquidButton = getMDataBinding().f3032d;
        Intrinsics.checkNotNullExpressionValue(oSLiquidButton, "mDataBinding.imgLeft");
        return oSLiquidButton;
    }

    public final OSLiquidTextButton getRightButtonView() {
        OSLiquidTextButton oSLiquidTextButton = getMDataBinding().f3031c;
        Intrinsics.checkNotNullExpressionValue(oSLiquidTextButton, "mDataBinding.buttonRight");
        return oSLiquidTextButton;
    }

    public final OSLiquidButton getRightIconView() {
        OSLiquidButton oSLiquidButton = getMDataBinding().e;
        Intrinsics.checkNotNullExpressionValue(oSLiquidButton, "mDataBinding.imgRight");
        return oSLiquidButton;
    }

    public final View getTitleView() {
        LinearLayout linearLayout = getMDataBinding().f3029a;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mDataBinding.root");
        return linearLayout;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSPageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 12);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSPageView(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 8);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OSPageView(Context context, AttributeSet attributeSet, int i8, int i9) {
        attributeSet = (i9 & 2) != 0 ? null : attributeSet;
        i8 = (i9 & 4) != 0 ? 0 : i8;
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i8, 0);
        this.mDataBinding = LazyKt.lazy(new o(context));
        setOrientation(1);
        setClipToPadding(false);
        setClipChildren(false);
        getMDataBinding().f3030b.setMaxWidth(R$dimen.os_liquid_button_max_width);
        getMDataBinding().f3031c.setMaxWidth(R$dimen.os_liquid_button_max_width);
        c();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f3017b = view;
        c();
        super.addView(view, layoutParams);
    }
}
