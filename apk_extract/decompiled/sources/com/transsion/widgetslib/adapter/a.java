package com.transsion.widgetslib.adapter;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclerAdapter f3047d;

    public a(RecyclerAdapter recyclerAdapter, View view, Object obj, int i8) {
        this.f3047d = recyclerAdapter;
        this.f3044a = view;
        this.f3045b = obj;
        this.f3046c = i8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecyclerAdapter recyclerAdapter = this.f3047d;
        recyclerAdapter.getClass();
        AdapterView.OnItemClickListener onItemClickListener = recyclerAdapter.f3041b;
        if (onItemClickListener != null) {
            int i8 = this.f3046c;
            onItemClickListener.onItemClick(null, this.f3044a, i8, recyclerAdapter.getItemId(i8));
        }
    }
}
