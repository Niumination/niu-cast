package com.transsion.iotservice.multiscreen.pc.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import bc.d;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.bean.TrustDeviceBean;
import com.transsion.iotservice.multiscreen.pc.databinding.ItemTrustDeviceBinding;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetslistitemlayout.OSListItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sa.k;
import sa.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/adapter/TrustDevicesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/transsion/iotservice/multiscreen/pc/bean/TrustDeviceBean;", "Lcom/transsion/iotservice/multiscreen/pc/adapter/TrustDevicesAdapter$TrustDeviceViewHolder;", "TrustDeviceViewHolder", "sa/k", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TrustDevicesAdapter extends ListAdapter<TrustDeviceBean, TrustDeviceViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2397a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/adapter/TrustDevicesAdapter$TrustDeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class TrustDeviceViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f2398b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ItemTrustDeviceBinding f2399a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrustDeviceViewHolder(ItemTrustDeviceBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f2399a = binding;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrustDevicesAdapter(d clickProxy) {
        super(new k());
        Intrinsics.checkNotNullParameter(clickProxy, "clickProxy");
        this.f2397a = clickProxy;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i8) {
        OSIconTextView rightImageView;
        TrustDeviceViewHolder holder = (TrustDeviceViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        TrustDeviceBean item = getItem(i8);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        TrustDeviceBean device = item;
        int itemCount = getItemCount();
        holder.getClass();
        Intrinsics.checkNotNullParameter(device, "device");
        d clickProxy = this.f2397a;
        Intrinsics.checkNotNullParameter(clickProxy, "clickProxy");
        device.setPosition(i8);
        device.setTotalCount(itemCount);
        ItemTrustDeviceBinding itemTrustDeviceBinding = holder.f2399a;
        itemTrustDeviceBinding.e(device);
        itemTrustDeviceBinding.f(i8);
        itemTrustDeviceBinding.g(itemCount);
        itemTrustDeviceBinding.d(clickProxy);
        itemTrustDeviceBinding.executePendingBindings();
        OSListItemView oSListItemView = (OSListItemView) itemTrustDeviceBinding.getRoot().findViewById(R$id.os_list_item_view);
        if (oSListItemView == null || (rightImageView = oSListItemView.getRightImageView()) == null) {
            return;
        }
        rightImageView.setOnTouchListener(new l(0, clickProxy, device));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i8) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemTrustDeviceBinding itemTrustDeviceBinding = (ItemTrustDeviceBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R$layout.item_trust_device, parent, false);
        Intrinsics.checkNotNull(itemTrustDeviceBinding);
        return new TrustDeviceViewHolder(itemTrustDeviceBinding);
    }
}
