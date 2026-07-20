package com.transsion.iotservice.multiscreen.pc.ui.search.fragment;

import ag.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import com.transsion.iotservice.multiscreen.pc.R$dimen;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAssetList;
import com.transsion.iotservice.multiscreen.pc.databinding.FragmentConnectingBinding;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.ConnectingViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import na.c;
import va.e;
import yb.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/ConnectingFragment;", "Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/BaseSearchFragment;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ConnectingFragment extends BaseSearchFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConnectingViewModel f2826d;
    public SearchActivityViewModel e;

    @Override // com.transsion.base.arch.mvvm.DataBindingFragment
    public final ViewDataBinding b(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i8 = FragmentConnectingBinding.f2557o;
        FragmentConnectingBinding fragmentConnectingBinding = (FragmentConnectingBinding) ViewDataBinding.inflateInternal(inflater, R$layout.fragment_connecting, viewGroup, false, DataBindingUtil.getDefaultComponent());
        ConstraintLayout constraintLayout = fragmentConnectingBinding.e;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        e.a(constraintLayout, contextRequireContext);
        SearchActivityViewModel searchActivityViewModel = this.e;
        if (searchActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchVM");
            searchActivityViewModel = null;
        }
        fragmentConnectingBinding.e(searchActivityViewModel);
        ConnectingViewModel connectingViewModel = this.f2826d;
        if (connectingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConnectingViewModel");
            connectingViewModel = null;
        }
        fragmentConnectingBinding.f(connectingViewModel);
        e().getClass();
        fragmentConnectingBinding.f2560c.setImageResource(c.a() ? R$drawable.module_pc_item_infinix : R$drawable.module_pc_item_tecno);
        fragmentConnectingBinding.d(BaseSearchFragment.d(this, null, new a(this, 22), 1));
        Intrinsics.checkNotNullExpressionValue(fragmentConnectingBinding, "apply(...)");
        return fragmentConnectingBinding;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, com.transsion.base.arch.mvvm.DataBindingFragment
    public final void c() {
        super.c();
        u6.a aVar = this.f2330a;
        this.f2826d = (ConnectingViewModel) aVar.D(this, ConnectingViewModel.class);
        this.e = (SearchActivityViewModel) aVar.B(this, SearchActivityViewModel.class);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ConnectingViewModel connectingViewModel = this.f2826d;
        if (connectingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConnectingViewModel");
            connectingViewModel = null;
        }
        connectingViewModel.f2834g.setValue(LottieAssetList.INSTANCE.getConnectingLottie());
        ConnectingViewModel connectingViewModel2 = this.f2826d;
        if (connectingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConnectingViewModel");
            connectingViewModel2 = null;
        }
        float dimension = getResources().getDimension(R$dimen.connecting_waiting_translate_y);
        float dimension2 = getResources().getDimension(R$dimen.connecting_pc_item_translate_y);
        connectingViewModel2.getClass();
        l0.p(ViewModelKt.getViewModelScope(connectingViewModel2), null, null, new zb.a(connectingViewModel2, dimension, dimension2, null), 3);
        l0.p(LifecycleOwnerKt.getLifecycleScope(this), null, null, new d(this, null), 3);
    }
}
