package com.transsion.iotservice.multiscreen.pc.adapter;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideBean;
import com.transsion.iotservice.multiscreen.pc.databinding.LayoutFunctionGuideItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/adapter/FunctionGuideAdapter;", "Lcom/transsion/iotservice/multiscreen/pc/adapter/BaseDataBindingAdapter;", "Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideBean;", "Lcom/transsion/iotservice/multiscreen/pc/databinding/LayoutFunctionGuideItemBinding;", "sa/g", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FunctionGuideAdapter extends BaseDataBindingAdapter<FunctionGuideBean, LayoutFunctionGuideItemBinding> {
    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter
    public final int a() {
        return R$layout.layout_function_guide_item;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter
    public final void b(ViewDataBinding viewDataBinding, Object obj, RecyclerView.ViewHolder holder) {
        LayoutFunctionGuideItemBinding binding = (LayoutFunctionGuideItemBinding) viewDataBinding;
        FunctionGuideBean item = (FunctionGuideBean) obj;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        binding.d(item);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i8) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return super.onCreateViewHolder(parent, i8);
    }
}
