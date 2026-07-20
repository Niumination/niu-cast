package com.transsion.widgetslib.view.damping;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.view.OSLoadingView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import rd.f;
import rd.g;
import rd.h;
import rd.i;

/* JADX INFO: loaded from: classes2.dex */
public class OSDampingLayout extends OverBoundNestedScrollView implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f3215a;

    public OSDampingLayout(Context context) {
        super(context);
        this.f3215a = new g(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f3215a.a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // rd.i
    public g getHeaderHelper() {
        return this.f3215a;
    }

    @Override // rd.i
    public OSLoadingView getLoadingView() {
        return this.f3215a.getLoadingView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3215a.b();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) {
            return;
        }
        View childAt = getChildAt(0);
        childAt.setNestedScrollingEnabled(false);
        childAt.setVerticalScrollBarEnabled(false);
        setFillViewport(true);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        removeView(childAt);
        View viewInflate = FrameLayout.inflate(getContext(), R$layout.os_damping_layout_title2, null);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(viewInflate);
        linearLayout.addView(childAt, -1, -1);
        addView(linearLayout, layoutParams);
        g gVar = this.f3215a;
        if (viewInflate == null) {
            gVar.getClass();
            return;
        }
        gVar.f9411i = viewInflate;
        TextView textView = (TextView) viewInflate.findViewById(R$id.damping_text_loading);
        gVar.f9408d = textView;
        textView.setScaleX(0.0f);
        TextView textView2 = gVar.f9408d;
        textView2.setScaleY(textView2.getScaleX());
        gVar.f9408d.setAlpha(0.0f);
        gVar.f9408d.post(new f(gVar, 0));
        OSLoadingView oSLoadingView = (OSLoadingView) viewInflate.findViewById(R$id.os_loading_view);
        gVar.f9407c = oSLoadingView;
        oSLoadingView.setPivotX(gVar.f9406b / 2.0f);
        gVar.f9407c.setPivotY(0.0f);
        gVar.f9407c.setScaleX(0.2f);
        OSLoadingView oSLoadingView2 = gVar.f9407c;
        oSLoadingView2.setScaleY(oSLoadingView2.getScaleX());
        gVar.f9407c.setAlpha(0.0f);
        gVar.f9407c.setPullPercent(0.0f);
        gVar.d(gVar.f9414l);
    }

    @Override // rd.i
    public void setOnRefreshListener(h hVar) {
        this.f3215a.setOnRefreshListener(hVar);
    }

    @Override // rd.i
    public void setTextColor(int i8) {
        this.f3215a.setTextColor(i8);
    }

    public OSDampingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3215a = new g(getContext());
    }

    public OSDampingLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3215a = new g(getContext());
    }
}
