package com.transsion.iotservice.multiscreen.pc.adapter;

import a8.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/adapter/BaseDataBindingAdapter;", "M", "Landroidx/databinding/ViewDataBinding;", "B", "Landroidx/recyclerview/widget/ListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a8/a", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class BaseDataBindingAdapter<M, B extends ViewDataBinding> extends ListAdapter<M, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f2389a;

    public abstract int a();

    public abstract void b(ViewDataBinding viewDataBinding, Object obj, RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int i8) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
        if (binding != null) {
            b(binding, getItem(i8), holder);
            binding.executePendingBindings();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i8) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), a(), parent, false);
        Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(...)");
        View itemView = viewDataBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(itemView, "getRoot(...)");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        BaseBindingViewHolder baseBindingViewHolder = new BaseBindingViewHolder(itemView);
        baseBindingViewHolder.itemView.setOnClickListener(new d4.a(1, baseBindingViewHolder, this));
        return baseBindingViewHolder;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        super.submitList(list);
    }
}
