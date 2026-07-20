package com.github.rubensousa.gravitysnaphelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import z1.d;

/* JADX INFO: loaded from: classes.dex */
public class OrientationAwareRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f1769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1770c;

    public OrientationAwareRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean zCanScrollVertically = true;
        if (actionMasked == 0) {
            this.f1768a = motionEvent.getX();
            this.f1769b = motionEvent.getY();
            if (this.f1770c) {
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.setAction(1);
                return super.onInterceptTouchEvent(motionEventObtain);
            }
        } else if (actionMasked == 2) {
            zCanScrollVertically = Math.abs(motionEvent.getY() - this.f1769b) > Math.abs(motionEvent.getX() - this.f1768a) ? layoutManager.canScrollVertically() : layoutManager.canScrollHorizontally();
        }
        if (zCanScrollVertically) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public OrientationAwareRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrientationAwareRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f1768a = 0.0f;
        this.f1769b = 0.0f;
        this.f1770c = false;
        addOnScrollListener(new d(this));
    }
}
