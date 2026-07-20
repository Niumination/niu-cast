package com.transsion.iotservice.multiscreen.pc.adapter;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.bean.LottieItem;
import com.transsion.iotservice.multiscreen.pc.databinding.ItemSettingLottieBinding;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sa.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/adapter/SettingsLottieAdapter;", "Lcom/transsion/iotservice/multiscreen/pc/adapter/BaseDataBindingAdapter;", "Lcom/transsion/iotservice/multiscreen/pc/bean/LottieItem;", "Lcom/transsion/iotservice/multiscreen/pc/databinding/ItemSettingLottieBinding;", "sa/j", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nSettingsLottieAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsLottieAdapter.kt\ncom/transsion/iotservice/multiscreen/pc/adapter/SettingsLottieAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class SettingsLottieAdapter extends BaseDataBindingAdapter<LottieItem, ItemSettingLottieBinding> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedViewModel f2396b;

    public SettingsLottieAdapter(SharedViewModel shareVM) {
        Intrinsics.checkNotNullParameter(shareVM, "shareVM");
        j diffCallback = new j();
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        super(diffCallback);
        this.f2396b = shareVM;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter
    public final int a() {
        return R$layout.item_setting_lottie;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter
    public final void b(ViewDataBinding viewDataBinding, Object obj, RecyclerView.ViewHolder holder) {
        ItemSettingLottieBinding binding = (ItemSettingLottieBinding) viewDataBinding;
        LottieItem item = (LottieItem) obj;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        binding.d(item);
        binding.e(this.f2396b);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i8) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return super.onCreateViewHolder(parent, i8);
    }
}
