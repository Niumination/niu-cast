package com.github.rubensousa.gravitysnaphelper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import z1.c;

/* JADX INFO: loaded from: classes.dex */
public class GravitySnapRecyclerView extends OrientationAwareRecyclerView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GravitySnapHelper f1767d;
    public final boolean e;

    public GravitySnapRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public int getCurrentSnappedPosition() {
        View viewA;
        GravitySnapHelper gravitySnapHelper = this.f1767d;
        RecyclerView recyclerView = gravitySnapHelper.f1765j;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || (viewA = gravitySnapHelper.a(gravitySnapHelper.f1765j.getLayoutManager(), true)) == null) {
            return -1;
        }
        return gravitySnapHelper.f1765j.getChildAdapterPosition(viewA);
    }

    @NonNull
    public GravitySnapHelper getSnapHelper() {
        return this.f1767d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void scrollToPosition(int i8) {
        if (this.e) {
            GravitySnapHelper gravitySnapHelper = this.f1767d;
            boolean zE = false;
            if (i8 == -1) {
                gravitySnapHelper.getClass();
            } else {
                zE = gravitySnapHelper.e(i8, false);
            }
            if (zE) {
                return;
            }
        }
        super.scrollToPosition(i8);
    }

    public void setSnapListener(@Nullable c cVar) {
        this.f1767d.getClass();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void smoothScrollToPosition(int i8) {
        boolean zE;
        if (this.e) {
            GravitySnapHelper gravitySnapHelper = this.f1767d;
            if (i8 == -1) {
                gravitySnapHelper.getClass();
                zE = false;
            } else {
                zE = gravitySnapHelper.e(i8, true);
            }
            if (zE) {
                return;
            }
        }
        super.smoothScrollToPosition(i8);
    }

    public GravitySnapRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GravitySnapRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.e = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GravitySnapRecyclerView, i8, 0);
        int i9 = typedArrayObtainStyledAttributes.getInt(R$styleable.GravitySnapRecyclerView_snapGravity, 0);
        if (i9 == 0) {
            this.f1767d = new GravitySnapHelper(GravityCompat.START);
        } else if (i9 == 1) {
            this.f1767d = new GravitySnapHelper(48);
        } else if (i9 == 2) {
            this.f1767d = new GravitySnapHelper(GravityCompat.END);
        } else if (i9 == 3) {
            this.f1767d = new GravitySnapHelper(80);
        } else if (i9 == 4) {
            this.f1767d = new GravitySnapHelper(17);
        } else {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
        }
        this.f1767d.f1761d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.GravitySnapRecyclerView_snapToPadding, false);
        this.f1767d.f1760c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.GravitySnapRecyclerView_snapLastItem, false);
        GravitySnapHelper gravitySnapHelper = this.f1767d;
        float f = typedArrayObtainStyledAttributes.getFloat(R$styleable.GravitySnapRecyclerView_snapMaxFlingSizeFraction, -1.0f);
        gravitySnapHelper.f = -1;
        gravitySnapHelper.f1762g = f;
        this.f1767d.e = typedArrayObtainStyledAttributes.getFloat(R$styleable.GravitySnapRecyclerView_snapScrollMsPerInch, 100.0f);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.GravitySnapRecyclerView_snapEnabled, true);
        GravitySnapHelper gravitySnapHelper2 = this.f1767d;
        if (z2) {
            gravitySnapHelper2.attachToRecyclerView(this);
        } else {
            gravitySnapHelper2.attachToRecyclerView(null);
        }
        this.e = z2;
        typedArrayObtainStyledAttributes.recycle();
    }
}
