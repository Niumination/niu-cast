package yb;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanActivity;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.BaseSearchFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;
import li.v0;
import m3.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseSearchFragment f11109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f11110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f11111c;

    public b(BaseSearchFragment baseSearchFragment, Function0 function0, String str) {
        this.f11109a = baseSearchFragment;
        this.f11110b = function0;
        this.f11111c = str;
    }

    public final void a() {
        BaseSearchFragment baseSearchFragment = this.f11109a;
        g0 viewModelScope = ViewModelKt.getViewModelScope(baseSearchFragment.e());
        v0 v0Var = v0.f7498a;
        l0.p(viewModelScope, si.e.f10118a, null, new a(baseSearchFragment, this.f11110b, null), 2);
    }

    public final void b() {
        String str = QrScanActivity.f2804c;
        BaseSearchFragment baseSearchFragment = this.f11109a;
        FragmentActivity fragmentActivityRequireActivity = baseSearchFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        ActivityResultLauncher activityResultLauncher = baseSearchFragment.f2825c;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissionLauncher");
            activityResultLauncher = null;
        }
        n.a(fragmentActivityRequireActivity, this.f11111c, activityResultLauncher, new sb.a(baseSearchFragment, 9));
    }
}
