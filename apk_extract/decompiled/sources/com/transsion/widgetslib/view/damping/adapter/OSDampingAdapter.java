package com.transsion.widgetslib.view.damping.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import rd.i;
import sd.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OSDampingAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f3250a;

    public static final class HeaderHolder extends RecyclerView.ViewHolder {
    }

    @Override // sd.a
    public int getHeaderCount() {
        return 1;
    }

    @Override // sd.a
    public i getRefreshLayout() {
        return this.f3250a;
    }

    @Override // sd.a
    public void setRefreshLayout(i iVar) {
        this.f3250a = iVar;
    }
}
