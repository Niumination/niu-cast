package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import ag.a;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.ui.search.SearchActivity;
import dc.b;
import eb.l2;
import eb.y;
import eb.y0;
import java.util.Locale;
import k3.gc;
import k3.pb;
import k3.vb;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.g2;
import li.l0;
import li.v0;
import ob.c;
import sb.q;
import sb.s;
import si.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/PcRequestConnectViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PcRequestConnectViewModel extends ViewModel {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f2746j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f2747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2750d;
    public final MutableLiveData e;
    public a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g2 f2751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f2753i;

    public PcRequestConnectViewModel() {
        Lazy lazy = LazyKt.lazy(new c(11));
        this.f2747a = lazy;
        this.f2748b = new MutableLiveData((String) lazy.getValue());
        this.f2749c = new MutableLiveData("");
        this.f2750d = "";
        this.e = new MutableLiveData(Boolean.FALSE);
        this.f2752h = 3;
        q qVar = new q(this, 1);
        this.f2753i = qVar;
        f2746j = true;
        y0.f4821k.observeForever(qVar);
        g0 viewModelScope = ViewModelKt.getViewModelScope(this);
        v0 v0Var = v0.f7498a;
        this.f2751g = l0.p(viewModelScope, e.f10118a, null, new s(this, null), 2);
    }

    public final void a(Intent intent) {
        if (intent == null || !intent.hasExtra("key_device_brand")) {
            return;
        }
        String stringExtra = intent.getStringExtra("key_device_name");
        if (stringExtra == null) {
            stringExtra = "unkonw device";
        }
        this.f2749c.setValue(pb.a().getResources().getString(R$string.module_pc_is_accept_match_request, stringExtra));
        String stringExtra2 = intent.getStringExtra("key_device_mac");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.f2750d = stringExtra2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(int i8) {
        g2 g2Var = this.f2751g;
        this.f2752h = i8;
        SharedPreferences sharedPreferences = null;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return;
                }
                c();
                return;
            } else {
                if (g2Var != null) {
                    g2Var.h(null);
                }
                c();
                return;
            }
        }
        Intrinsics.checkNotNullParameter("PcRequestConnectViewModel", "tag");
        Intrinsics.checkNotNullParameter("clickAccept", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PcRequestConnectViewModel"), "clickAccept");
        }
        Boolean bool = (Boolean) this.e.getValue();
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        b.g(this.f2750d, zBooleanValue);
        if (g2Var != null) {
            g2Var.h(null);
        }
        String deviceKey = this.f2750d;
        Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
        String key = deviceKey.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(key, "toUpperCase(...)");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferences2 = vb.f6684a;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        } else {
            sharedPreferences = sharedPreferences2;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(key, zBooleanValue);
        editorEdit.apply();
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
        l2.a(true);
        a aVar = this.f;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void c() {
        Intrinsics.checkNotNullParameter("PcRequestConnectViewModel", "tag");
        Intrinsics.checkNotNullParameter("onUserReject", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PcRequestConnectViewModel"), "onUserReject");
        }
        y yVar = y.f4799a;
        y.o(true);
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
        l2.a(false);
        String deviceKey = this.f2750d;
        Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
        String key = deviceKey.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(key, "toUpperCase(...)");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(key, false);
        editorEdit.apply();
        int i8 = SearchActivity.f2817s;
        Intent intentA = q5.a.a(0, 3);
        intentA.putExtra("KEY_DELAY_SCAN", true);
        intentA.putExtra("intent_key_is_from_reject", true);
        intentA.setFlags(268435456);
        pb.a().startActivity(intentA);
        a aVar = this.f;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        String requestConStatus;
        f2746j = false;
        y0.f4821k.removeObserver(this.f2753i);
        ob.b bVar = ob.b.f8417b;
        int i8 = this.f2752h;
        if (i8 == 1) {
            requestConStatus = "accept";
        } else {
            requestConStatus = i8 == 2 ? "decline" : "other";
        }
        String isRememberDevice = Intrinsics.areEqual((Boolean) this.e.getValue(), Boolean.TRUE) ? "select_trust" : "not_select_trust";
        bVar.getClass();
        Intrinsics.checkNotNullParameter(requestConStatus, "requestConStatus");
        Intrinsics.checkNotNullParameter(isRememberDevice, "isRememberDevice");
        bVar.f8437a.r(requestConStatus, isRememberDevice);
        super.onCleared();
    }
}
