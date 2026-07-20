package com.transsion.widgetslib.widget.tablayout;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabLayout.TabView f3735b;

    public d(TabLayout.TabView tabView, View view) {
        this.f3735b = tabView;
        this.f3734a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        View view2 = this.f3734a;
        if (view2.getVisibility() == 0) {
            int i16 = TabLayout.TabView.p;
            this.f3735b.g(view2);
        }
    }
}
