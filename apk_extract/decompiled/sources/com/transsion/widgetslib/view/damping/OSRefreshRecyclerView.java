package com.transsion.widgetslib.view.damping;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.transsion.widgetslib.view.OSLoadingView;
import rd.g;
import rd.h;
import rd.i;
import rd.j;
import sd.a;

/* JADX INFO: loaded from: classes2.dex */
public class OSRefreshRecyclerView extends RecyclerView implements Runnable, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f3216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3217b;

    public OSRefreshRecyclerView(@NonNull Context context) {
        super(context);
        g gVar = new g(getContext());
        this.f3217b = gVar;
        gVar.setMinHeight(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f3217b.a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // rd.i
    public g getHeaderHelper() {
        return this.f3217b;
    }

    @Override // rd.i
    public OSLoadingView getLoadingView() {
        return this.f3217b.getLoadingView();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3217b.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        RecyclerView.Adapter adapter = getAdapter();
        if (this.f3216a == null || adapter == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new j(this, adapter, gridLayoutManager.getSpanCount(), gridLayoutManager.getSpanSizeLookup()));
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int itemCount = adapter.getItemCount();
            for (int i8 = 0; i8 < itemCount; i8++) {
                View childAt = getChildAt(i8);
                g gVar = this.f3217b;
                if (gVar != null && childAt != null && childAt == gVar.getLayoutHeader() && (layoutParams = (StaggeredGridLayoutManager.LayoutParams) childAt.getLayoutParams()) != null) {
                    layoutParams.setFullSpan(true);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof a) {
            a aVar = (a) adapter;
            this.f3216a = aVar;
            aVar.setRefreshLayout(this);
            post(this);
        }
    }

    @Override // rd.i
    public void setOnRefreshListener(h hVar) {
        this.f3217b.setOnRefreshListener(hVar);
    }

    @Override // rd.i
    public void setTextColor(@ColorInt int i8) {
        this.f3217b.setTextColor(i8);
    }

    public OSRefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g gVar = new g(getContext());
        this.f3217b = gVar;
        gVar.setMinHeight(1);
    }

    public OSRefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        g gVar = new g(getContext());
        this.f3217b = gVar;
        gVar.setMinHeight(1);
    }
}
