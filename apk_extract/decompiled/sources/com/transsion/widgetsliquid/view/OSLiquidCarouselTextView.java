package com.transsion.widgetsliquid.view;

import a4.c;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.widget.OsPressSmoothCornerDrawable;
import com.transsion.widgetsliquid.effect.OSLiquidContainerRootLayout;
import hd.a;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
public class OSLiquidCarouselTextView extends OSLiquidContainerRootLayout {
    private static final String TAG = "OSLiquidCarouselTextView";
    private static final int TOOLBOTTOM_BACKGROUND_MARGIN_VERTICAL_DP = 4;
    private int childWidth;
    boolean isFrst;
    private CarouselTextView mCarouselTextView;
    private Context mContext;
    private OsPressSmoothCornerDrawable osPressSmoothCornerDrawable;

    public OSLiquidCarouselTextView(Context context) {
        super(context);
        this.childWidth = 0;
        this.isFrst = true;
        this.mContext = context;
        this.mCarouselTextView = new CarouselTextView(context);
        init();
    }

    private void init() {
        setDialogMixLevel(3);
        setBackgroundColor(Color.parseColor("#00000000"));
        this.mCarouselTextView.setBackgroundColor(Color.parseColor("#00000000"));
        OsPressSmoothCornerDrawable osPressSmoothCornerDrawable = this.osPressSmoothCornerDrawable;
        Context context = this.mContext;
        String[] strArr = j.f8764a;
        osPressSmoothCornerDrawable.setBackgroundLeftRightMargin(a.a(context, 4));
        this.mCarouselTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.widgetsliquid.view.OSLiquidCarouselTextView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    OSLiquidCarouselTextView.this.osPressSmoothCornerDrawable.b();
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    OSLiquidCarouselTextView.this.osPressSmoothCornerDrawable.a();
                    OSLiquidCarouselTextView.this.mCarouselTextView.performClick();
                }
                return true;
            }
        });
        this.mCarouselTextView.setOnWidthChangedListener(new CarouselTextView.OnWidthChangedListener() { // from class: com.transsion.widgetsliquid.view.OSLiquidCarouselTextView.2
            @Override // com.transsion.widgetsliquid.view.CarouselTextView.OnWidthChangedListener
            public void onWidthChanged(int i8) {
                OSLiquidCarouselTextView.this.childWidth = i8;
                OSLiquidCarouselTextView.this.requestLayout();
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = a.a(this.mContext, 12);
        layoutParams.rightMargin = a.a(this.mContext, 12);
        addView(this.osPressSmoothCornerDrawable);
        addView(this.mCarouselTextView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$0() {
        CarouselTextView carouselTextView = this.mCarouselTextView;
        if (carouselTextView != null) {
            carouselTextView.forceScrollCheck();
        }
    }

    public CarouselTextView getCarouselTextView() {
        return this.mCarouselTextView;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new c(this, 29));
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        CarouselTextView carouselTextView;
        int size = View.MeasureSpec.getSize(i8);
        View.MeasureSpec.getMode(i8);
        if (this.isFrst && (carouselTextView = this.mCarouselTextView) != null && size > 0 && (carouselTextView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCarouselTextView.getLayoutParams();
            this.mCarouselTextView._setMaxWidth(Math.max(0, (size - layoutParams.leftMargin) - layoutParams.rightMargin));
            this.isFrst = false;
        }
        super.onMeasure(i8, i9);
        CarouselTextView carouselTextView2 = this.mCarouselTextView;
        if (carouselTextView2 == null || !(carouselTextView2.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCarouselTextView.getLayoutParams();
        int i10 = this.childWidth + layoutParams2.leftMargin + layoutParams2.rightMargin;
        Log.d(TAG, "getMeasuredWidth = " + getMeasuredWidth());
        if (i10 != getMeasuredWidth()) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY), i9);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.mCarouselTextView.setEnabled(z2);
        setAlpha(z2 ? 1.0f : 0.4f);
    }

    public OSLiquidCarouselTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.childWidth = 0;
        this.isFrst = true;
        this.mContext = context;
        this.mCarouselTextView = new CarouselTextView(context, attributeSet);
        this.osPressSmoothCornerDrawable = new OsPressSmoothCornerDrawable(context, attributeSet);
        init();
    }

    public OSLiquidCarouselTextView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.childWidth = 0;
        this.isFrst = true;
        this.mCarouselTextView = new CarouselTextView(context, attributeSet, i8);
        this.osPressSmoothCornerDrawable = new OsPressSmoothCornerDrawable(context, attributeSet, i8);
        this.mContext = context;
        init();
    }
}
