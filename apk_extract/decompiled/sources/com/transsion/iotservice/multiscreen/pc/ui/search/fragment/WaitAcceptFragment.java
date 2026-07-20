package com.transsion.iotservice.multiscreen.pc.ui.search.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.databinding.FragmentWaitAcceptBinding;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.WaitAcceptViewModel;
import k3.gc;
import k3.wb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import li.v0;
import na.c;
import u6.a;
import va.e;
import yb.i;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/WaitAcceptFragment;", "Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/BaseSearchFragment;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class WaitAcceptFragment extends BaseSearchFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WaitAcceptViewModel f2829d;
    public SearchActivityViewModel e;

    @Override // com.transsion.base.arch.mvvm.DataBindingFragment
    public final ViewDataBinding b(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i8 = FragmentWaitAcceptBinding.f2595j;
        FragmentWaitAcceptBinding fragmentWaitAcceptBinding = (FragmentWaitAcceptBinding) ViewDataBinding.inflateInternal(inflater, R$layout.fragment_wait_accept, viewGroup, false, DataBindingUtil.getDefaultComponent());
        ConstraintLayout constraintLayout = fragmentWaitAcceptBinding.f2598c;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        e.a(constraintLayout, contextRequireContext);
        e().getClass();
        fragmentWaitAcceptBinding.f2597b.setImageResource(c.a() ? R$drawable.module_pc_item_infinix : R$drawable.module_pc_item_tecno);
        WaitAcceptViewModel waitAcceptViewModel = null;
        fragmentWaitAcceptBinding.d(BaseSearchFragment.d(this, null, null, 3));
        SearchActivityViewModel searchActivityViewModel = this.e;
        if (searchActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchVM");
            searchActivityViewModel = null;
        }
        fragmentWaitAcceptBinding.e(searchActivityViewModel);
        WaitAcceptViewModel waitAcceptViewModel2 = this.f2829d;
        if (waitAcceptViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            waitAcceptViewModel = waitAcceptViewModel2;
        }
        fragmentWaitAcceptBinding.f(waitAcceptViewModel);
        Intrinsics.checkNotNullExpressionValue(fragmentWaitAcceptBinding, "apply(...)");
        return fragmentWaitAcceptBinding;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, com.transsion.base.arch.mvvm.DataBindingFragment
    public final void c() {
        super.c();
        a aVar = this.f2330a;
        this.e = (SearchActivityViewModel) aVar.B(this, SearchActivityViewModel.class);
        this.f2829d = (WaitAcceptViewModel) aVar.D(this, WaitAcceptViewModel.class);
        l0.p(LifecycleOwnerKt.getLifecycleScope(this), v0.f7499b, null, new i(this, null), 2);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        TranslateAnimation translateAnimation;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter("WaitAcceptFragment", "tag");
        Intrinsics.checkNotNullParameter("onViewCreated", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("WaitAcceptFragment"), "onViewCreated");
        }
        super.onViewCreated(view, bundle);
        e().f2836a = false;
        WaitAcceptViewModel waitAcceptViewModel = this.f2829d;
        if (waitAcceptViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            waitAcceptViewModel = null;
        }
        int i8 = e().f2837b;
        waitAcceptViewModel.getClass();
        String log = "loadAnimationData: mode = " + i8;
        Intrinsics.checkNotNullParameter("WaitAcceptViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("WaitAcceptViewModel"), log);
        }
        dc.c cVar = new dc.c(0.33f, 0.25f);
        MutableLiveData mutableLiveData = waitAcceptViewModel.f2861c;
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.setDuration(500L);
        animationSet.setInterpolator(cVar);
        mutableLiveData.setValue(animationSet);
        if (i8 == -1) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.75f, 1.0f, 0.75f, 1.0f, 0.5f, 0.5f);
        if (i8 != 0) {
            translateAnimation = i8 != 1 ? new TranslateAnimation(wb.a(50.0f), 0.0f, wb.a(25.0f), 0.0f) : new TranslateAnimation(wb.a(50.0f), 0.0f, wb.a(25.0f), 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(-wb.a(50.0f), 0.0f, wb.a(25.0f), 0.0f);
        }
        MutableLiveData mutableLiveData2 = waitAcceptViewModel.f2859a;
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation(translateAnimation);
        animationSet2.addAnimation(scaleAnimation);
        animationSet2.setDuration(500L);
        animationSet2.setInterpolator(cVar);
        animationSet2.setFillAfter(true);
        mutableLiveData2.setValue(animationSet2);
    }
}
