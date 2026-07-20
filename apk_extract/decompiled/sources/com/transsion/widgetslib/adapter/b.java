package com.transsion.widgetslib.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerAdapter f3049b;

    public b(RecyclerAdapter recyclerAdapter, View view, Object obj, int i8) {
        this.f3049b = recyclerAdapter;
        this.f3048a = obj;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f3049b.getClass();
        return false;
    }
}
