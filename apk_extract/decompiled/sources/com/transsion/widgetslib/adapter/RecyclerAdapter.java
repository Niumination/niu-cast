package com.transsion.widgetslib.adapter;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.adapter.RecyclerAdapter.Holder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RecyclerAdapter<T, VH extends Holder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdapterView.OnItemClickListener f3041b;

    public static abstract class Holder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3043b;

        public void setSetOnClickListener(boolean z2) {
            this.f3042a = z2;
        }

        public void setSetOnLongClickListener(boolean z2) {
            this.f3043b = z2;
        }
    }

    public RecyclerAdapter(List list) {
        this.f3040a = list;
    }

    public abstract void a(Holder holder, int i8, Object obj);

    public List<T> getDataList() {
        return this.f3040a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List list = this.f3040a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i8) {
        Holder holder = (Holder) viewHolder;
        Object obj = this.f3040a.get(i8);
        if (obj == null) {
            return;
        }
        a(holder, i8, obj);
        View view = holder.itemView;
        if (holder.f3042a) {
            view.setOnClickListener(new a(this, view, obj, i8));
        }
        if (holder.f3043b) {
            view.setOnLongClickListener(new b(this, view, obj, i8));
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f3041b = onItemClickListener;
    }
}
