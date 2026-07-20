package com.transsion.iotservice.multiscreen.pc.ui.search.viewModel;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import zb.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/viewModel/SearchFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchFragmentViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f2854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData f2857d;
    public final MutableLiveData e;
    public final MutableLiveData f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f2858g;

    public SearchFragmentViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f2854a = mutableLiveData;
        this.f2855b = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.f2856c = mutableLiveData2;
        this.f2857d = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.e = mutableLiveData3;
        this.f = mutableLiveData3;
        this.f2858g = LazyKt.lazy(new l(2));
    }
}
