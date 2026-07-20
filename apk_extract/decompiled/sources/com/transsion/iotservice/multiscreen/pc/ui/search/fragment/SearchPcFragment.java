package com.transsion.iotservice.multiscreen.pc.ui.search.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.github.rubensousa.gravitysnaphelper.GravitySnapRecyclerView;
import com.transsion.core.log.LogUtils;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.adapter.SearchPcItemAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAssetList;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageResponse;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.bean.TextBean;
import com.transsion.iotservice.multiscreen.pc.bean.VapAssetList;
import com.transsion.iotservice.multiscreen.pc.databinding.FragmentSearchPcBinding;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.SearchDeviceLayoutManager;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.SearchPcFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchFragmentViewModel;
import eb.l2;
import eb.y;
import eb.z1;
import java.util.ArrayList;
import java.util.Locale;
import jb.g;
import k3.gc;
import k3.vb;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;
import li.v0;
import o.d;
import ob.b;
import sb.x;
import si.e;
import u6.a;
import yb.f;
import zb.i;
import zb.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/SearchPcFragment;", "Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/BaseSearchFragment;", "<init>", "()V", "yb/f", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchPcFragment extends BaseSearchFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SearchFragmentViewModel f2828d;
    public SharedViewModel e;

    @Override // com.transsion.base.arch.mvvm.DataBindingFragment
    public final ViewDataBinding b(LayoutInflater inflater, ViewGroup viewGroup) {
        RecyclerView.LayoutManager layoutManager;
        View viewA;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i8 = FragmentSearchPcBinding.f2583o;
        FragmentSearchPcBinding fragmentSearchPcBinding = (FragmentSearchPcBinding) ViewDataBinding.inflateInternal(inflater, R$layout.fragment_search_pc, viewGroup, false, DataBindingUtil.getDefaultComponent());
        GravitySnapRecyclerView gravitySnapRecyclerView = fragmentSearchPcBinding.f2587d;
        gravitySnapRecyclerView.setLayoutManager(new SearchDeviceLayoutManager());
        gravitySnapRecyclerView.setClipChildren(false);
        GravitySnapHelper snapHelper = gravitySnapRecyclerView.getSnapHelper();
        if (snapHelper.f1758a != 17) {
            snapHelper.f1758a = 17;
            RecyclerView recyclerView = snapHelper.f1765j;
            if (recyclerView != null && recyclerView.getLayoutManager() != null && (viewA = snapHelper.a((layoutManager = snapHelper.f1765j.getLayoutManager()), false)) != null) {
                int[] iArrCalculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(layoutManager, viewA);
                snapHelper.f1765j.scrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
            }
        }
        gravitySnapRecyclerView.getSnapHelper().f1761d = false;
        SearchFragmentViewModel searchFragmentViewModel = null;
        fragmentSearchPcBinding.f(BaseSearchFragment.d(this, "scan_device_window", null, 2));
        fragmentSearchPcBinding.e(new f(this));
        fragmentSearchPcBinding.d(new SearchPcItemAdapter(e()));
        fragmentSearchPcBinding.g(e());
        SharedViewModel sharedViewModel = this.e;
        if (sharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareVM");
            sharedViewModel = null;
        }
        fragmentSearchPcBinding.i(sharedViewModel);
        SearchFragmentViewModel searchFragmentViewModel2 = this.f2828d;
        if (searchFragmentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentViewModel");
        } else {
            searchFragmentViewModel = searchFragmentViewModel2;
        }
        fragmentSearchPcBinding.h(searchFragmentViewModel);
        Intrinsics.checkNotNullExpressionValue(fragmentSearchPcBinding, "apply(...)");
        return fragmentSearchPcBinding;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, com.transsion.base.arch.mvvm.DataBindingFragment
    public final void c() {
        super.c();
        a aVar = this.f2330a;
        this.f2828d = (SearchFragmentViewModel) aVar.D(this, SearchFragmentViewModel.class);
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(SharedViewModel.class, "modelClass");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        this.e = (SharedViewModel) aVar.C(fragmentActivityRequireActivity);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        e().getClass();
        DeviceViewModel.g();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        DeviceViewModel deviceViewModelE = e();
        deviceViewModelE.getClass();
        g0 viewModelScope = ViewModelKt.getViewModelScope(deviceViewModelE);
        v0 v0Var = v0.f7498a;
        l0.p(viewModelScope, e.f10118a, null, new i(null), 2);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x01b4  */
    @Override // com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        SearchPageResponse searchPageResponse;
        SearchPageText searchPageText;
        Intent intent;
        final int i8 = 1;
        final int i9 = 0;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        String strM = d.m("dealFromTag:", "SearchPcFragment", "tag", "log", e().f2838c);
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SearchPcFragment"), strM);
        }
        e().getClass();
        l2.d();
        if (e().f2838c == 4) {
            e().f2843j.postValue(Integer.valueOf(R$string.module_pc_swift_copy));
            y yVar = y.f4799a;
            y.f = 4;
            FragmentActivity fragmentActivityA = a();
            Intrinsics.checkNotNullParameter("textContent", "key");
            String stringExtra = (fragmentActivityA == null || (intent = fragmentActivityA.getIntent()) == null || !intent.hasExtra("textContent")) ? null : intent.getStringExtra("textContent");
            DeviceViewModel deviceViewModelE = e();
            x task = new x(stringExtra, i8);
            deviceViewModelE.getClass();
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(task, "task");
            l2.e.add(new z1(0, task));
        } else if (e().f2838c == 2) {
            e().f2843j.postValue(Integer.valueOf(R$string.module_pc_swift_send));
            y yVar2 = y.f4799a;
            y.f = 3;
            DeviceViewModel deviceViewModelE2 = e();
            Intent intent2 = requireActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
            deviceViewModelE2.getClass();
            final ArrayList arrayListE = DeviceViewModel.e(intent2);
            b.f8417b.t(arrayListE, 3, false);
            DeviceViewModel deviceViewModelE3 = e();
            Function0 task2 = new Function0(this) { // from class: yb.e

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ SearchPcFragment f11113b;

                {
                    this.f11113b = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    switch (i9) {
                        case 0:
                            DeviceViewModel deviceViewModelE4 = this.f11113b.e();
                            ArrayList arrayList = arrayListE;
                            deviceViewModelE4.getClass();
                            DeviceViewModel.c(3, arrayList);
                            break;
                        default:
                            DeviceViewModel deviceViewModelE5 = this.f11113b.e();
                            ArrayList arrayList2 = arrayListE;
                            deviceViewModelE5.getClass();
                            DeviceViewModel.c(5, arrayList2);
                            break;
                    }
                    return Unit.INSTANCE;
                }
            };
            deviceViewModelE3.getClass();
            Intrinsics.checkNotNullParameter(task2, "task");
            Intrinsics.checkNotNullParameter(task2, "task");
            l2.e.add(new z1(0, task2));
        } else if (e().f2838c == 3) {
            e().f2843j.postValue(Integer.valueOf(R$string.module_pc_swift_copy));
            y yVar3 = y.f4799a;
            y.f = 5;
            DeviceViewModel deviceViewModelE4 = e();
            Intent intent3 = requireActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, "getIntent(...)");
            deviceViewModelE4.getClass();
            final ArrayList arrayListE2 = DeviceViewModel.e(intent3);
            b.f8417b.t(arrayListE2, 5, false);
            DeviceViewModel deviceViewModelE5 = e();
            Function0 task3 = new Function0(this) { // from class: yb.e

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ SearchPcFragment f11113b;

                {
                    this.f11113b = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    switch (i8) {
                        case 0:
                            DeviceViewModel deviceViewModelE6 = this.f11113b.e();
                            ArrayList arrayList = arrayListE2;
                            deviceViewModelE6.getClass();
                            DeviceViewModel.c(3, arrayList);
                            break;
                        default:
                            DeviceViewModel deviceViewModelE7 = this.f11113b.e();
                            ArrayList arrayList2 = arrayListE2;
                            deviceViewModelE7.getClass();
                            DeviceViewModel.c(5, arrayList2);
                            break;
                    }
                    return Unit.INSTANCE;
                }
            };
            deviceViewModelE5.getClass();
            Intrinsics.checkNotNullParameter(task3, "task");
            Intrinsics.checkNotNullParameter(task3, "task");
            l2.e.add(new z1(0, task3));
        } else {
            y yVar4 = y.f4799a;
            y.f = 0;
            e().f2843j.postValue(Integer.valueOf(R$string.module_pc_connect));
        }
        SearchFragmentViewModel searchFragmentViewModel = this.f2828d;
        if (searchFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFragmentViewModel");
            searchFragmentViewModel = null;
        }
        searchFragmentViewModel.f2854a.setValue(LottieAssetList.getSEARCH_PC_LOTTIE());
        searchFragmentViewModel.f2856c.setValue(VapAssetList.getSEARCH_WATER_RIPPLE_VAP());
        MutableLiveData mutableLiveData = searchFragmentViewModel.e;
        jb.f.f6135a.getClass();
        g gVar = jb.f.f6136b;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
            gVar = null;
        }
        gVar.getClass();
        jb.f.a().f6134b.getClass();
        if (dc.b.f() < 0) {
            g gVar2 = jb.f.f6136b;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
                gVar2 = null;
            }
            searchPageText = gVar2.b();
        } else {
            jb.e eVarA = jb.f.a();
            eVarA.getClass();
            gc.c("CacheDataSource", "loadSearchPageResource");
            eVarA.f6134b.getClass();
            int iF = dc.b.f();
            if (iF == -1) {
                searchPageText = null;
            } else {
                String key = "sp_search_page_cache" + iF;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter("", "defaultVal");
                SharedPreferences sharedPreferences = vb.f6684a;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    sharedPreferences = null;
                }
                String string = sharedPreferences.getString(key, "");
                String str = string != null ? string : "";
                if (str.length() == 0) {
                    str = null;
                }
                if (str == null || (searchPageResponse = (SearchPageResponse) na.b.a(str, SearchPageResponse.class)) == null) {
                    searchPageText = null;
                } else if (Intrinsics.areEqual(searchPageResponse.getLang(), Locale.getDefault().toString())) {
                    searchPageText = new SearchPageText(new TextBean(null, searchPageResponse.getInfo()), new TextBean(null, searchPageResponse.getLink()), false);
                } else {
                    gc.b("CacheDataSource", "loadSearchPageResource: lang mismatch");
                    dc.b.b(iF);
                    searchPageText = null;
                }
            }
            if (searchPageText == null) {
                LogUtils.e("DataSourceRepository", "loadFunctionGuideResource: cache null");
                g gVar3 = jb.f.f6136b;
                if (gVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
                    gVar3 = null;
                }
                searchPageText = gVar3.b();
            }
        }
        mutableLiveData.setValue(searchPageText);
        if (!Intrinsics.areEqual(y.f4804h, new Initial())) {
            l0.p(LifecycleOwnerKt.getLifecycleScope(this), null, null, new yb.g(this, null), 3);
            return;
        }
        Intrinsics.checkNotNullParameter("SearchPcFragment", "tag");
        Intrinsics.checkNotNullParameter("isInitial,startScanDevice", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SearchPcFragment"), "isInitial,startScanDevice");
        }
        DeviceViewModel deviceViewModelE6 = e();
        deviceViewModelE6.getClass();
        g0 viewModelScope = ViewModelKt.getViewModelScope(deviceViewModelE6);
        v0 v0Var = v0.f7498a;
        l0.p(viewModelScope, e.f10118a, null, new k(deviceViewModelE6, null), 2);
    }
}
