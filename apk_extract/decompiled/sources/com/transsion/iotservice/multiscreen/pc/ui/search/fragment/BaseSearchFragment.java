package com.transsion.iotservice.multiscreen.pc.ui.search.fragment;

import ag.a;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.base.arch.mvvm.DataBindingFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yb.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/fragment/BaseSearchFragment;", "Lcom/transsion/base/arch/mvvm/DataBindingFragment;", "<init>", "()V", "yb/b", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class BaseSearchFragment extends DataBindingFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DeviceViewModel f2824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActivityResultLauncher f2825c;

    public static b d(BaseSearchFragment baseSearchFragment, String trackEntry, a aVar, int i8) {
        if ((i8 & 1) != 0) {
            trackEntry = "";
        }
        if ((i8 & 2) != 0) {
            aVar = null;
        }
        Intrinsics.checkNotNullParameter(trackEntry, "trackEntry");
        return new b(baseSearchFragment, aVar, trackEntry);
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingFragment
    public void c() {
        DeviceViewModel deviceViewModel = (DeviceViewModel) this.f2330a.B(this, DeviceViewModel.class);
        Intrinsics.checkNotNullParameter(deviceViewModel, "<set-?>");
        this.f2824b = deviceViewModel;
    }

    public final DeviceViewModel e() {
        DeviceViewModel deviceViewModel = this.f2824b;
        if (deviceViewModel != null) {
            return deviceViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDeviceVM");
        return null;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String log = "onCreate:" + this;
        Intrinsics.checkNotNullParameter("BaseSearchFragment", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSearchFragment"), log);
        }
        this.f2825c = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e0.b(26));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        String log = "onDestroy:" + this;
        Intrinsics.checkNotNullParameter("BaseSearchFragment", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSearchFragment"), log);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        String log = "onDestroyView:" + this;
        Intrinsics.checkNotNullParameter("BaseSearchFragment", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BaseSearchFragment"), log);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        String log = "onPause:" + this;
        Intrinsics.checkNotNullParameter("BaseSearchFragment", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSearchFragment"), log);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String log = "onResume:" + this;
        Intrinsics.checkNotNullParameter("BaseSearchFragment", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSearchFragment"), log);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        String log = "onStart:" + this;
        Intrinsics.checkNotNullParameter("BaseSearchFragment", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSearchFragment"), log);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        String log = "onViewCreated" + this;
        Intrinsics.checkNotNullParameter("BaseSearchFragment", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSearchFragment"), log);
        }
    }
}
