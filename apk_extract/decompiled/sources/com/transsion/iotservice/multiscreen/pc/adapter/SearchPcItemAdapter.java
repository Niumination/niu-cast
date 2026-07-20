package com.transsion.iotservice.multiscreen.pc.adapter;

import a8.a;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.bean.PcBleScanedDeviceBean;
import com.transsion.iotservice.multiscreen.pc.bean.ViewLayoutParams;
import com.transsion.iotservice.multiscreen.pc.databinding.ModulePcItemPcNewBinding;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import java.util.List;
import k3.wb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na.c;
import sa.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/adapter/SearchPcItemAdapter;", "Lcom/transsion/iotservice/multiscreen/pc/adapter/BaseDataBindingAdapter;", "Lcom/transsion/iotservice/multiscreen/pc/bean/PcBleScanedDeviceBean;", "Lcom/transsion/iotservice/multiscreen/pc/databinding/ModulePcItemPcNewBinding;", "sa/h", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchPcItemAdapter extends BaseDataBindingAdapter<PcBleScanedDeviceBean, ModulePcItemPcNewBinding> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f2391g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DeviceViewModel f2392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewLayoutParams f2394d;
    public int e;
    public int f;

    public SearchPcItemAdapter(DeviceViewModel deviceVM) {
        Intrinsics.checkNotNullParameter(deviceVM, "deviceVM");
        h diffCallback = new h();
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        super(diffCallback);
        this.f2392b = deviceVM;
        a onItemClickListener = new a(this, 16);
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.f2389a = onItemClickListener;
        this.f2393c = c.a() ? R$drawable.module_pc_item_infinix : R$drawable.module_pc_item_tecno;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter
    public final int a() {
        return R$layout.module_pc_item_pc_new;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter
    public final void b(ViewDataBinding viewDataBinding, Object obj, RecyclerView.ViewHolder holder) {
        ModulePcItemPcNewBinding binding = (ModulePcItemPcNewBinding) viewDataBinding;
        PcBleScanedDeviceBean item = (PcBleScanedDeviceBean) obj;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.itemView.clearAnimation();
        int i8 = this.f;
        if (i8 <= 0 || this.e != 0) {
            int i9 = this.e;
            if (i9 != 1 || i8 <= 1) {
                if (i9 == 2 && i8 < 2) {
                    if (holder.getAdapterPosition() == 0) {
                        ScaleAnimation scaleAnimation = new ScaleAnimation(1.33f, 1.0f, 1.33f, 1.0f, 0.5f, 0.5f);
                        TranslateAnimation translateAnimation = new TranslateAnimation(wb.a(30.0f), 0.0f, 0.0f, 0.0f);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(scaleAnimation);
                        animationSet.setDuration(700L);
                        animationSet.setInterpolator(new dc.c(0.33f, 0.25f));
                        holder.itemView.startAnimation(animationSet);
                    } else {
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(wb.a(17.0f), 0.0f, 0.0f, 0.0f);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        AnimationSet animationSet2 = new AnimationSet(true);
                        animationSet2.addAnimation(translateAnimation2);
                        animationSet2.addAnimation(alphaAnimation);
                        animationSet2.setDuration(700L);
                        animationSet2.setInterpolator(new dc.c(0.75f, 0.46f));
                        holder.itemView.startAnimation(animationSet2);
                    }
                }
            } else if (holder.getAdapterPosition() == 0) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.33f, 1.0f, 1.33f, 0, 0.5f, 0, 0.5f);
                TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, wb.a(53.0f), 0.0f, -wb.a(5.0f));
                AnimationSet animationSet3 = new AnimationSet(true);
                animationSet3.addAnimation(translateAnimation3);
                animationSet3.addAnimation(scaleAnimation2);
                animationSet3.setDuration(700L);
                animationSet3.setFillAfter(true);
                animationSet3.setInterpolator(new dc.c(0.33f, 0.25f));
                holder.itemView.startAnimation(animationSet3);
            } else {
                TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, wb.a(30.0f), 0.0f, 0.0f);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                AnimationSet animationSet4 = new AnimationSet(true);
                animationSet4.addAnimation(translateAnimation4);
                animationSet4.addAnimation(alphaAnimation2);
                animationSet4.setDuration(700L);
                animationSet4.setFillAfter(true);
                animationSet4.setInterpolator(new dc.c(0.75f, 0.46f));
                holder.itemView.startAnimation(animationSet4);
            }
        } else {
            TranslateAnimation translateAnimation5 = new TranslateAnimation(0.0f, 0.0f, 0.0f, wb.a(30.0f));
            AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
            dc.c cVar = new dc.c(0.2f, 0.1f);
            AnimationSet animationSet5 = new AnimationSet(true);
            animationSet5.addAnimation(translateAnimation5);
            animationSet5.addAnimation(alphaAnimation3);
            animationSet5.setDuration(330L);
            animationSet5.setFillAfter(true);
            animationSet5.setInterpolator(cVar);
            holder.itemView.startAnimation(animationSet5);
        }
        binding.d(item);
        ViewLayoutParams viewLayoutParams = this.f2394d;
        if (viewLayoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPcImageLayoutParam");
            viewLayoutParams = null;
        }
        binding.f(viewLayoutParams);
        binding.e(Integer.valueOf(this.f2393c));
    }

    @Override // com.transsion.iotservice.multiscreen.pc.adapter.BaseDataBindingAdapter, androidx.recyclerview.widget.ListAdapter
    public final void submitList(List list) {
        int i8;
        int i9;
        f2391g = false;
        this.e = list != null ? list.size() : 0;
        List list2 = list;
        if (list2 != null && !list2.isEmpty() && (i8 = this.e) != (i9 = this.f)) {
            if (i9 == 1) {
                f2391g = true;
            }
            if (i9 > 1 && i8 == 1) {
                f2391g = true;
            }
            this.f2394d = list.size() == 1 ? new ViewLayoutParams(wb.a(154.0f), wb.a(94.0f)) : new ViewLayoutParams(wb.a(125.0f), wb.a(80.0f));
        }
        super.submitList(list);
        this.f = this.e;
    }
}
