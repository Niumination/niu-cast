package com.transsion.iotservice.multiscreen.pc.ui.search.viewModel;

import android.content.res.Resources;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.ConnectingFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.FailOrRefuseFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.SearchPcFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.WaitAcceptFragment;
import eb.y0;
import java.util.HashMap;
import k3.gc;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na.d;
import ob.c;
import zb.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/viewModel/SearchActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchActivityViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2848a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2849b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f2850c = LazyKt.lazy(new c(29));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f2851d = LazyKt.lazy(new l(0));
    public final Lazy e = LazyKt.lazy(new l(1));
    public final MutableLiveData f = new MutableLiveData();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f2852g = new MutableLiveData();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2853h;

    public final void a(int i8) {
        HashMap map = this.f2849b;
        if (!map.isEmpty()) {
            Intrinsics.checkNotNullParameter("SearchActivityViewModel", "tag");
            Intrinsics.checkNotNullParameter("load: resource already loaded", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SearchActivityViewModel"), "load: resource already loaded");
                return;
            }
            return;
        }
        boolean zA = d.a();
        MutableLiveData mutableLiveData = this.f2852g;
        MutableLiveData mutableLiveData2 = this.f;
        if (zA) {
            mutableLiveData2.setValue(Integer.valueOf(R$drawable.dialog_bg));
            Resources system = Resources.getSystem();
            int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
            mutableLiveData.setValue(Integer.valueOf(identifier != 0 ? system.getDimensionPixelSize(identifier) : 0));
        } else {
            mutableLiveData.setValue(0);
            mutableLiveData2.setValue(Integer.valueOf(R$drawable.module_pc_bg_rec_24));
        }
        this.f2848a = i8;
        gc.c("SearchActivityViewModel", "load resource");
        y0 y0Var = y0.f4813a;
        if (!y0.e) {
            gc.c("SearchActivityViewModel", "load: open pc connect icon");
            y0.d("SearchActivityViewModel:load");
        }
        map.put(1, (WaitAcceptFragment) this.f2850c.getValue());
        map.put(2, (ConnectingFragment) this.e.getValue());
        Lazy lazy = this.f2851d;
        map.put(3, (FailOrRefuseFragment) lazy.getValue());
        map.put(4, (FailOrRefuseFragment) lazy.getValue());
        map.put(5, (FailOrRefuseFragment) lazy.getValue());
        String strM = o.d.m("initHomeFragment mIntentFrom: ", "SearchActivityViewModel", "tag", "log", this.f2848a);
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SearchActivityViewModel"), strM);
        }
        map.put(0, new SearchPcFragment());
    }
}
