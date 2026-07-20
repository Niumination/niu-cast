package com.transsion.iotservice.multiscreen.pc.ui.search.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.databinding.FragmentFaiOrRefuselBinding;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/FailOrRefuseFragment;", "Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/BaseSearchFragment;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FailOrRefuseFragment extends BaseSearchFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SearchActivityViewModel f2827d;

    /* JADX WARN: Code duplicated, block: B:9:0x0057  */
    @Override // com.transsion.base.arch.mvvm.DataBindingFragment
    public final ViewDataBinding b(LayoutInflater inflater, ViewGroup viewGroup) {
        int dimensionPixelSize;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i8 = FragmentFaiOrRefuselBinding.f2571k;
        FragmentFaiOrRefuselBinding fragmentFaiOrRefuselBinding = (FragmentFaiOrRefuselBinding) ViewDataBinding.inflateInternal(inflater, R$layout.fragment_fai_or_refusel, viewGroup, false, DataBindingUtil.getDefaultComponent());
        ConstraintLayout constraintLayout = fragmentFaiOrRefuselBinding.f2574c;
        Context context = requireContext();
        Intrinsics.checkNotNullExpressionValue(context, "requireContext(...)");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        int identifier = context.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier <= 0 || !context.getResources().getBoolean(identifier)) {
            dimensionPixelSize = 0;
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            int identifier2 = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier2 != 0) {
                dimensionPixelSize = resources.getDimensionPixelSize(identifier2);
            } else {
                dimensionPixelSize = 0;
            }
        }
        if (constraintLayout != null) {
            constraintLayout.setPadding(0, 0, 0, dimensionPixelSize - 15);
        }
        ImageView ivConnectFail = fragmentFaiOrRefuselBinding.f2573b;
        Intrinsics.checkNotNullExpressionValue(ivConnectFail, "ivConnectFail");
        int i9 = R$drawable.connect_fail_xos;
        int i10 = R$drawable.connect_fail;
        Intrinsics.checkNotNullParameter(ivConnectFail, "<this>");
        if (c.a()) {
            ivConnectFail.setImageResource(i9);
        } else {
            ivConnectFail.setImageResource(i10);
        }
        SearchActivityViewModel searchActivityViewModel = null;
        fragmentFaiOrRefuselBinding.d(BaseSearchFragment.d(this, "wireless_connect_failed", null, 2));
        fragmentFaiOrRefuselBinding.e(e());
        SearchActivityViewModel searchActivityViewModel2 = this.f2827d;
        if (searchActivityViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchVM");
        } else {
            searchActivityViewModel = searchActivityViewModel2;
        }
        fragmentFaiOrRefuselBinding.f(searchActivityViewModel);
        Intrinsics.checkNotNullExpressionValue(fragmentFaiOrRefuselBinding, "apply(...)");
        return fragmentFaiOrRefuselBinding;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, com.transsion.base.arch.mvvm.DataBindingFragment
    public final void c() {
        super.c();
        this.f2827d = (SearchActivityViewModel) this.f2330a.B(this, SearchActivityViewModel.class);
    }
}
