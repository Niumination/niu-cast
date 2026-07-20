package com.transsion.iotservice.multiscreen.pc.ui.trust;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import bb.c;
import bc.a;
import bc.d;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.adapter.TrustDevicesAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAssetList;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityTrustDevicesBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivity;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ob.b;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/trust/TrustDevicesActivity;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class TrustDevicesActivity extends BaseActivity {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f2883j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TrustDevicesViewModel f2884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedViewModel f2885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActivityTrustDevicesBinding f2886d;
    public TrustDevicesAdapter e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f2888i = new d(this);

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final ViewDataBinding j() {
        ActivityTrustDevicesBinding activityTrustDevicesBinding = (ActivityTrustDevicesBinding) DataBindingUtil.setContentView(this, R$layout.activity_trust_devices);
        TrustDevicesViewModel trustDevicesViewModel = this.f2884b;
        SharedViewModel sharedViewModel = null;
        if (trustDevicesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrustDevicesVM");
            trustDevicesViewModel = null;
        }
        activityTrustDevicesBinding.e(trustDevicesViewModel);
        SharedViewModel sharedViewModel2 = this.f2885c;
        if (sharedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareVM");
        } else {
            sharedViewModel = sharedViewModel2;
        }
        activityTrustDevicesBinding.d(sharedViewModel);
        a aVar = new a(this, 0);
        OSLiquidToolBar oSLiquidToolBar = activityTrustDevicesBinding.f2509b;
        oSLiquidToolBar.setOnLeftIconClickListener(aVar);
        oSLiquidToolBar.setMaskVisibility(8);
        oSLiquidToolBar.setLeftIconFillColor(0);
        this.f2886d = activityTrustDevicesBinding;
        return activityTrustDevicesBinding;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final void k() {
        u6.a aVar = this.f2329a;
        this.f2884b = (TrustDevicesViewModel) aVar.A(this, TrustDevicesViewModel.class);
        this.f2885c = (SharedViewModel) aVar.C(this);
        TrustDevicesViewModel trustDevicesViewModel = this.f2884b;
        TrustDevicesViewModel trustDevicesViewModel2 = null;
        if (trustDevicesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrustDevicesVM");
            trustDevicesViewModel = null;
        }
        trustDevicesViewModel.a();
        TrustDevicesViewModel trustDevicesViewModel3 = this.f2884b;
        if (trustDevicesViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrustDevicesVM");
        } else {
            trustDevicesViewModel2 = trustDevicesViewModel3;
        }
        trustDevicesViewModel2.f2891c.setValue(LottieAssetList.INSTANCE.getTrustDevice());
    }

    public final void l() {
        if (this.f2887h) {
            return;
        }
        this.f2887h = true;
        TrustDevicesViewModel trustDevicesViewModel = this.f2884b;
        if (trustDevicesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrustDevicesVM");
            trustDevicesViewModel = null;
        }
        List list = (List) trustDevicesViewModel.f2890b.getValue();
        int size = list != null ? list.size() : 0;
        b.f8417b.f8437a.getClass();
        Bundle bundleD = w.D();
        bundleD.putInt("number", size);
        w.X("iot_multi_con_phonepad_trust_device_page_exit", bundleD);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        l();
        super.onBackPressed();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivity, com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        va.b.e(this);
        this.e = new TrustDevicesAdapter(this.f2888i);
        ActivityTrustDevicesBinding activityTrustDevicesBinding = this.f2886d;
        TrustDevicesViewModel trustDevicesViewModel = null;
        if (activityTrustDevicesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTrustDevicesBinding = null;
        }
        RecyclerView recyclerView = activityTrustDevicesBinding.f2511d;
        TrustDevicesAdapter trustDevicesAdapter = this.e;
        if (trustDevicesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            trustDevicesAdapter = null;
        }
        recyclerView.setAdapter(trustDevicesAdapter);
        TrustDevicesViewModel trustDevicesViewModel2 = this.f2884b;
        if (trustDevicesViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTrustDevicesVM");
        } else {
            trustDevicesViewModel = trustDevicesViewModel2;
        }
        trustDevicesViewModel.f2890b.observe(this, new c(new a(this, 1)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        l();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        onBackPressed();
        return true;
    }
}
