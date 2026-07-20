package com.transsion.iotservice.multiscreen.pc.ui.search;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import bb.q;
import bb.r;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.receiver.HomeKeyReceiver;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.multiscreen.pc.ui.search.SearchActivity;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.SearchActivityViewModel;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseCloseBottomSheetDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import eb.g0;
import eb.y0;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.pb;
import k3.sb;
import k3.ub;
import k3.wb;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import li.v0;
import na.k;
import pd.d;
import sb.h;
import si.e;
import tj.w;
import u6.a;
import xb.b;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/SearchActivity;", "Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseCloseBottomSheetDialog;", "<init>", "()V", "q5/a", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchActivity extends OSBaseCloseBottomSheetDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f2817s = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DeviceViewModel f2818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SearchActivityViewModel f2819l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HomeKeyReceiver f2820m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f2821n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f2822o;
    public final a p = new a(12, false);
    public final Lazy q = LazyKt.lazy(new xb.a(this, 0));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f2823r = LazyKt.lazy(new xb.a(this, 1));

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [androidx.lifecycle.Observer, xb.b] */
    /* JADX WARN: Type inference failed for: r0v33, types: [androidx.lifecycle.Observer, xb.b] */
    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i8;
        final int i9 = 2;
        final int i10 = 0;
        final int i11 = 1;
        if (sb.b()) {
            d.c(this, pb.a());
        }
        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
        Intrinsics.checkNotNullParameter("onCreate", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SearchActivity"), "onCreate");
        }
        super.onCreate(bundle);
        s(true);
        a aVar = this.p;
        this.f2819l = (SearchActivityViewModel) aVar.A(this, SearchActivityViewModel.class);
        DeviceViewModel deviceViewModel = (DeviceViewModel) aVar.A(this, DeviceViewModel.class);
        deviceViewModel.f2840g.observe(this, new h(1, new Function1(this) { // from class: xb.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SearchActivity f10911b;

            {
                this.f10911b = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SearchActivity searchActivity = this.f10911b;
                switch (i10) {
                    case 0:
                        Integer num = (Integer) obj;
                        int i12 = SearchActivity.f2817s;
                        String log = "device state: " + num;
                        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                        Intrinsics.checkNotNullParameter(log, "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("SearchActivity"), log);
                        }
                        SearchActivityViewModel searchActivityViewModel = searchActivity.f2819l;
                        if (searchActivityViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSearchActivityVM");
                            searchActivityViewModel = null;
                        }
                        FragmentManager fragmentManager = searchActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(fragmentManager, "getSupportFragmentManager(...)");
                        Intrinsics.checkNotNull(num);
                        int iIntValue = num.intValue();
                        searchActivityViewModel.getClass();
                        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
                        Fragment fragment = (Fragment) searchActivityViewModel.f2849b.get(num);
                        if (fragment == null) {
                            String strM = o.d.m("replaceFragment:ill state ", "SearchActivityViewModel", "tag", "log", iIntValue);
                            if (gc.f6462a <= 6) {
                                Log.e(gc.f6463b.concat("SearchActivityViewModel"), strM);
                            }
                        } else {
                            fragmentManager.beginTransaction().replace(R$id.fl_container, fragment).commitNowAllowingStateLoss();
                        }
                        break;
                    case 1:
                        Integer num2 = (Integer) obj;
                        int i13 = SearchActivity.f2817s;
                        OSPageView oSPageView = (OSPageView) searchActivity.f2823r.getValue();
                        Resources resources = pb.a().getResources();
                        Intrinsics.checkNotNull(num2);
                        String string = resources.getString(num2.intValue());
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        oSPageView.f(string);
                        ((OSPageView) searchActivity.f2823r.getValue()).requestLayout();
                        break;
                    default:
                        OnBackPressedCallback addCallback = (OnBackPressedCallback) obj;
                        int i14 = SearchActivity.f2817s;
                        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                        searchActivity.finishAndRemoveTask();
                        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                        Intrinsics.checkNotNullParameter("onBackPressed", "log");
                        if (gc.f6462a <= 5) {
                            Log.w(gc.f6463b.concat("SearchActivity"), "onBackPressed");
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        }));
        deviceViewModel.f2844k.observe(this, new h(1, new Function1(this) { // from class: xb.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SearchActivity f10911b;

            {
                this.f10911b = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SearchActivity searchActivity = this.f10911b;
                switch (i11) {
                    case 0:
                        Integer num = (Integer) obj;
                        int i12 = SearchActivity.f2817s;
                        String log = "device state: " + num;
                        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                        Intrinsics.checkNotNullParameter(log, "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("SearchActivity"), log);
                        }
                        SearchActivityViewModel searchActivityViewModel = searchActivity.f2819l;
                        if (searchActivityViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSearchActivityVM");
                            searchActivityViewModel = null;
                        }
                        FragmentManager fragmentManager = searchActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(fragmentManager, "getSupportFragmentManager(...)");
                        Intrinsics.checkNotNull(num);
                        int iIntValue = num.intValue();
                        searchActivityViewModel.getClass();
                        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
                        Fragment fragment = (Fragment) searchActivityViewModel.f2849b.get(num);
                        if (fragment == null) {
                            String strM = o.d.m("replaceFragment:ill state ", "SearchActivityViewModel", "tag", "log", iIntValue);
                            if (gc.f6462a <= 6) {
                                Log.e(gc.f6463b.concat("SearchActivityViewModel"), strM);
                            }
                        } else {
                            fragmentManager.beginTransaction().replace(R$id.fl_container, fragment).commitNowAllowingStateLoss();
                        }
                        break;
                    case 1:
                        Integer num2 = (Integer) obj;
                        int i13 = SearchActivity.f2817s;
                        OSPageView oSPageView = (OSPageView) searchActivity.f2823r.getValue();
                        Resources resources = pb.a().getResources();
                        Intrinsics.checkNotNull(num2);
                        String string = resources.getString(num2.intValue());
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        oSPageView.f(string);
                        ((OSPageView) searchActivity.f2823r.getValue()).requestLayout();
                        break;
                    default:
                        OnBackPressedCallback addCallback = (OnBackPressedCallback) obj;
                        int i14 = SearchActivity.f2817s;
                        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                        searchActivity.finishAndRemoveTask();
                        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                        Intrinsics.checkNotNullParameter("onBackPressed", "log");
                        if (gc.f6462a <= 5) {
                            Log.w(gc.f6463b.concat("SearchActivity"), "onBackPressed");
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        }));
        this.f2818k = deviceViewModel;
        ((OSPageView) this.f2823r.getValue()).requestLayout();
        int intExtra = getIntent().getIntExtra("INTENT_FROM_PATH", 1);
        SearchActivityViewModel searchActivityViewModel = null;
        if (DeviceConnectState.INSTANCE.isConnected()) {
            Intrinsics.checkNotNullParameter("SearchActivity", "tag");
            Intrinsics.checkNotNullParameter("dealAlreadyConnectEvent:", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SearchActivity"), "dealAlreadyConnectEvent:");
            }
            ob.b bVar = ob.b.f8417b;
            bVar.f8437a.getClass();
            Bundle bundleD = w.D();
            g0 g0Var = g0.f4753a;
            bundleD.putString("connected_device_name", g0.b());
            bundleD.putString("connected_device_pid", g0.c());
            bundleD.putString("content_type", "files");
            bundleD.putString("connected_device", w.F());
            w.X("iot_multi_con_text_or_files_copied", bundleD);
            DeviceViewModel deviceViewModel2 = this.f2818k;
            if (deviceViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDeviceVM");
                deviceViewModel2 = null;
            }
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            deviceViewModel2.getClass();
            ArrayList arrayListE = DeviceViewModel.e(intent);
            if (intExtra == 2) {
                bVar.t(arrayListE, 3, true);
                DeviceViewModel deviceViewModel3 = this.f2818k;
                if (deviceViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDeviceVM");
                    deviceViewModel3 = null;
                }
                deviceViewModel3.getClass();
                DeviceViewModel.c(3, arrayListE);
            }
            if (intExtra == 3) {
                bVar.t(arrayListE, 5, true);
                DeviceViewModel deviceViewModel4 = this.f2818k;
                if (deviceViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDeviceVM");
                    deviceViewModel4 = null;
                }
                deviceViewModel4.getClass();
                DeviceViewModel.c(5, arrayListE);
            }
            finishAndRemoveTask();
        }
        SearchActivityViewModel searchActivityViewModel2 = this.f2819l;
        if (searchActivityViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchActivityVM");
            searchActivityViewModel2 = null;
        }
        int i12 = searchActivityViewModel2.f2848a;
        if ((i12 == 1 || i12 == 6) && ub.b()) {
            k kVar = k.f8141a;
            Application applicationA = pb.a();
            String string = pb.a().getResources().getString(R$string.module_pc_close_hotspot_conn_toast);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            kVar.d(applicationA, string);
            finish();
            return;
        }
        Intrinsics.checkNotNullParameter(this, "context");
        try {
            i8 = Settings.Secure.getInt(getApplicationContext().getContentResolver(), "navigation_mode", 0);
        } catch (Exception e) {
            e.printStackTrace();
            i8 = 0;
        }
        if (i8 == 2) {
            SearchActivityViewModel searchActivityViewModel3 = this.f2819l;
            if (searchActivityViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchActivityVM");
                searchActivityViewModel3 = null;
            }
            searchActivityViewModel3.f2853h = wb.a(44.0f);
        } else {
            SearchActivityViewModel searchActivityViewModel4 = this.f2819l;
            if (searchActivityViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchActivityVM");
                searchActivityViewModel4 = null;
            }
            searchActivityViewModel4.f2853h = wb.a(8.0f);
        }
        DeviceViewModel deviceViewModel5 = this.f2818k;
        if (deviceViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeviceVM");
            deviceViewModel5 = null;
        }
        deviceViewModel5.f2838c = intExtra;
        li.g0 viewModelScope = ViewModelKt.getViewModelScope(deviceViewModel5);
        r rVar = new r(viewModelScope);
        deviceViewModel5.e = rVar;
        zb.b scanResultCallback = new zb.b(deviceViewModel5, i11);
        Intrinsics.checkNotNullParameter(scanResultCallback, "scanResultCallback");
        rVar.f1247i = scanResultCallback;
        Intrinsics.checkNotNullParameter("BleScanDataFilterHelper", "tag");
        Intrinsics.checkNotNullParameter("onStartScan", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("BleScanDataFilterHelper"), "onStartScan");
        }
        rVar.f1245g = true;
        rVar.f1246h = false;
        rVar.f1243c.clear();
        rVar.f1244d.clear();
        v0 v0Var = v0.f7498a;
        l0.p(viewModelScope, e.f10118a, null, new q(rVar, null), 2);
        ob.b bVar2 = ob.b.f8417b;
        bVar2.getClass();
        DeviceConnectState deviceConnectState = DeviceConnectState.INSTANCE;
        if (!deviceConnectState.isConnected()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ob.b.f = jElapsedRealtime;
            ob.b.f8420g = jElapsedRealtime;
            String triggerScene = "swift_copy";
            switch (intExtra) {
                case 1:
                    triggerScene = "shortcut_open_click";
                    break;
                case 2:
                    triggerScene = "swift_transfer";
                    break;
                case 3:
                case 4:
                    break;
                case 5:
                    triggerScene = "cast_gesture";
                    break;
                case 6:
                    triggerScene = "setting_open_click";
                    break;
                default:
                    triggerScene = "";
                    break;
            }
            ob.b.f8418c = triggerScene;
            Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
            bVar2.f8437a.w(triggerScene);
        }
        l0.p(ViewModelKt.getViewModelScope(deviceViewModel5), null, null, new f(deviceViewModel5, null), 3);
        Intrinsics.checkNotNullParameter(this, "<this>");
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullParameter(this, "<this>");
        insetsController.setAppearanceLightNavigationBars(!((getResources().getConfiguration().uiMode & 48) == 32));
        Intrinsics.checkNotNullParameter(this, "<this>");
        setRequestedOrientation((!sb.b() || na.d.a()) ? 13 : 1);
        if (na.d.a()) {
            getWindow().setGravity(80);
        }
        getWindow().setStatusBarColor(0);
        getWindow().setDecorFitsSystemWindows(false);
        overridePendingTransition(0, 0);
        va.b.b(this, false);
        getWindow().addFlags(512);
        Intrinsics.checkNotNullParameter(this, "activity");
        Object systemService = getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (keyguardManager.isKeyguardLocked()) {
            keyguardManager.requestDismissKeyguard(this, new w7.b(null));
        }
        SearchActivityViewModel searchActivityViewModel5 = this.f2819l;
        if (searchActivityViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchActivityVM");
        } else {
            searchActivityViewModel = searchActivityViewModel5;
        }
        searchActivityViewModel.a(intExtra);
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), null, false, new Function1(this) { // from class: xb.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SearchActivity f10911b;

            {
                this.f10911b = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SearchActivity searchActivity = this.f10911b;
                switch (i9) {
                    case 0:
                        Integer num = (Integer) obj;
                        int i13 = SearchActivity.f2817s;
                        String log = "device state: " + num;
                        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                        Intrinsics.checkNotNullParameter(log, "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("SearchActivity"), log);
                        }
                        SearchActivityViewModel searchActivityViewModel6 = searchActivity.f2819l;
                        if (searchActivityViewModel6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSearchActivityVM");
                            searchActivityViewModel6 = null;
                        }
                        FragmentManager fragmentManager = searchActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(fragmentManager, "getSupportFragmentManager(...)");
                        Intrinsics.checkNotNull(num);
                        int iIntValue = num.intValue();
                        searchActivityViewModel6.getClass();
                        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
                        Fragment fragment = (Fragment) searchActivityViewModel6.f2849b.get(num);
                        if (fragment == null) {
                            String strM = o.d.m("replaceFragment:ill state ", "SearchActivityViewModel", "tag", "log", iIntValue);
                            if (gc.f6462a <= 6) {
                                Log.e(gc.f6463b.concat("SearchActivityViewModel"), strM);
                            }
                        } else {
                            fragmentManager.beginTransaction().replace(R$id.fl_container, fragment).commitNowAllowingStateLoss();
                        }
                        break;
                    case 1:
                        Integer num2 = (Integer) obj;
                        int i14 = SearchActivity.f2817s;
                        OSPageView oSPageView = (OSPageView) searchActivity.f2823r.getValue();
                        Resources resources = pb.a().getResources();
                        Intrinsics.checkNotNull(num2);
                        String string2 = resources.getString(num2.intValue());
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        oSPageView.f(string2);
                        ((OSPageView) searchActivity.f2823r.getValue()).requestLayout();
                        break;
                    default:
                        OnBackPressedCallback addCallback = (OnBackPressedCallback) obj;
                        int i15 = SearchActivity.f2817s;
                        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                        searchActivity.finishAndRemoveTask();
                        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                        Intrinsics.checkNotNullParameter("onBackPressed", "log");
                        if (gc.f6462a <= 5) {
                            Log.w(gc.f6463b.concat("SearchActivity"), "onBackPressed");
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        }, 3, null);
        HomeKeyReceiver homeKeyReceiver = new HomeKeyReceiver(new xb.a(this, i9));
        va.b.f(this, homeKeyReceiver, "android.intent.action.CLOSE_SYSTEM_DIALOGS", false);
        this.f2820m = homeKeyReceiver;
        ?? r7 = new Observer(this) { // from class: xb.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SearchActivity f10909b;

            {
                this.f10909b = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchActivity searchActivity = this.f10909b;
                switch (i10) {
                    case 0:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i13 = SearchActivity.f2817s;
                        if (!zBooleanValue) {
                            Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                            Intrinsics.checkNotNullParameter("onChanged: pc connect icon close", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("SearchActivity"), "onChanged: pc connect icon close");
                            }
                            MutableLiveData mutableLiveData = y0.f4816d;
                            b bVar3 = searchActivity.f2821n;
                            Intrinsics.checkNotNull(bVar3);
                            mutableLiveData.removeObserver(bVar3);
                            searchActivity.finishAndRemoveTask();
                            break;
                        }
                        break;
                    default:
                        int iIntValue = ((Integer) obj).intValue();
                        int i14 = SearchActivity.f2817s;
                        String strM = o.d.m("onChanged: castState = ", "SearchActivity", "tag", "log", iIntValue);
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("SearchActivity"), strM);
                        }
                        if (iIntValue == 3 || iIntValue == 4 || iIntValue == 6) {
                            searchActivity.finishAndRemoveTask();
                            searchActivity.finishAndRemoveTask();
                        }
                        break;
                }
            }
        };
        y0.f4816d.observeForever(r7);
        this.f2821n = r7;
        ?? r10 = new Observer(this) { // from class: xb.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SearchActivity f10909b;

            {
                this.f10909b = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchActivity searchActivity = this.f10909b;
                switch (i11) {
                    case 0:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i13 = SearchActivity.f2817s;
                        if (!zBooleanValue) {
                            Intrinsics.checkNotNullParameter("SearchActivity", "tag");
                            Intrinsics.checkNotNullParameter("onChanged: pc connect icon close", "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("SearchActivity"), "onChanged: pc connect icon close");
                            }
                            MutableLiveData mutableLiveData = y0.f4816d;
                            b bVar3 = searchActivity.f2821n;
                            Intrinsics.checkNotNull(bVar3);
                            mutableLiveData.removeObserver(bVar3);
                            searchActivity.finishAndRemoveTask();
                            break;
                        }
                        break;
                    default:
                        int iIntValue = ((Integer) obj).intValue();
                        int i14 = SearchActivity.f2817s;
                        String strM = o.d.m("onChanged: castState = ", "SearchActivity", "tag", "log", iIntValue);
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("SearchActivity"), strM);
                        }
                        if (iIntValue == 3 || iIntValue == 4 || iIntValue == 6) {
                            searchActivity.finishAndRemoveTask();
                            searchActivity.finishAndRemoveTask();
                        }
                        break;
                }
            }
        };
        deviceConnectState.getCastState().observeForever(r10);
        this.f2822o = r10;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        y0.f4819i.observe(this, new h(1, new Function1() { // from class: xb.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SearchActivity searchActivity = this;
                AtomicBoolean atomicBoolean3 = atomicBoolean;
                Boolean bool = (Boolean) obj;
                switch (i10) {
                    case 0:
                        int i13 = SearchActivity.f2817s;
                        if (!atomicBoolean3.compareAndSet(true, false)) {
                            if (!bool.booleanValue()) {
                                searchActivity.finishAndRemoveTask();
                            }
                        }
                        break;
                    default:
                        int i14 = SearchActivity.f2817s;
                        if (!atomicBoolean3.compareAndSet(true, false)) {
                            if (!bool.booleanValue()) {
                                searchActivity.finishAndRemoveTask();
                            }
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        }));
        y0.f4817g.observe(this, new h(1, new Function1() { // from class: xb.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SearchActivity searchActivity = this;
                AtomicBoolean atomicBoolean3 = atomicBoolean2;
                Boolean bool = (Boolean) obj;
                switch (i11) {
                    case 0:
                        int i13 = SearchActivity.f2817s;
                        if (!atomicBoolean3.compareAndSet(true, false)) {
                            if (!bool.booleanValue()) {
                                searchActivity.finishAndRemoveTask();
                            }
                        }
                        break;
                    default:
                        int i14 = SearchActivity.f2817s;
                        if (!atomicBoolean3.compareAndSet(true, false)) {
                            if (!bool.booleanValue()) {
                                searchActivity.finishAndRemoveTask();
                            }
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        }));
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
        Intrinsics.checkNotNullParameter("onDestroy", "log");
        if (gc.f6462a <= 5) {
            Log.w(gc.f6463b.concat("SearchActivity"), "onDestroy");
        }
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        int i8 = ob.b.f8427n;
        String triggerScene = ob.b.f8418c;
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        bVar.f8437a.L(i8, triggerScene);
        ob.b.f8427n = 0;
        ob.b.f8426m = 0;
        HomeKeyReceiver homeKeyReceiver = this.f2820m;
        if (homeKeyReceiver != null) {
            unregisterReceiver(homeKeyReceiver);
            this.f2820m = null;
        }
        b bVar2 = this.f2821n;
        if (bVar2 != null) {
            y0.f4816d.removeObserver(bVar2);
            this.f2821n = null;
        }
        b bVar3 = this.f2822o;
        if (bVar3 != null) {
            DeviceConnectState.INSTANCE.getCastState().removeObserver(bVar3);
            this.f2822o = null;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
        Intrinsics.checkNotNullParameter("onNewIntent()", "log");
        if (gc.f6462a <= 5) {
            Log.w(gc.f6463b.concat("SearchActivity"), "onNewIntent()");
        }
        int intExtra = getIntent().getIntExtra("INTENT_FROM_PATH", 1);
        SearchActivityViewModel searchActivityViewModel = this.f2819l;
        if (searchActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchActivityVM");
            searchActivityViewModel = null;
        }
        searchActivityViewModel.a(intExtra);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
        Intrinsics.checkNotNullParameter("onPause", "log");
        if (gc.f6462a <= 5) {
            Log.w(gc.f6463b.concat("SearchActivity"), "onPause");
        }
        za.a.f11266a = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Intrinsics.checkNotNullParameter("SearchActivity", "tag");
        Intrinsics.checkNotNullParameter("onResume", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SearchActivity"), "onResume");
        }
        za.a.f11266a = false;
        getIntent().getStringExtra("entry");
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean u() {
        return false;
    }
}
