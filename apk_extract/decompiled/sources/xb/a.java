package xb;

import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivitySearchBinding;
import com.transsion.iotservice.multiscreen.pc.ui.search.SearchActivity;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import k3.gc;
import k3.pb;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f10907b;

    public /* synthetic */ a(SearchActivity searchActivity, int i8) {
        this.f10906a = i8;
        this.f10907b = searchActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        DeviceViewModel deviceViewModel = null;
        SearchActivity searchActivity = this.f10907b;
        switch (this.f10906a) {
            case 0:
                int i8 = SearchActivity.f2817s;
                LayoutInflater layoutInflater = searchActivity.getLayoutInflater();
                int i9 = ActivitySearchBinding.f2505b;
                ActivitySearchBinding activitySearchBinding = (ActivitySearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_search, null, false, DataBindingUtil.getDefaultComponent());
                Intrinsics.checkNotNullExpressionValue(activitySearchBinding, "inflate(...)");
                return activitySearchBinding;
            case 1:
                View root = ((ActivitySearchBinding) searchActivity.q.getValue()).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                OSPageView oSPageViewJ = searchActivity.j(root);
                DeviceViewModel deviceViewModel2 = searchActivity.f2818k;
                if (deviceViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDeviceVM");
                } else {
                    deviceViewModel = deviceViewModel2;
                }
                deviceViewModel.getClass();
                Resources resources = pb.a().getResources();
                Integer num = (Integer) deviceViewModel.f2844k.getValue();
                String string = resources.getString(num != null ? num.intValue() : R$string.module_pc_connect);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                oSPageViewJ.f(string);
                oSPageViewJ.d(new ce.a(searchActivity, 12));
                return oSPageViewJ;
            default:
                int i10 = SearchActivity.f2817s;
                Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                Intrinsics.checkNotNullParameter("onHomePressed", "log");
                if (gc.f6462a <= 5) {
                    Log.w(gc.f6463b.concat("SearchActivity"), "onHomePressed");
                }
                searchActivity.finishAndRemoveTask();
                return Unit.INSTANCE;
        }
    }
}
