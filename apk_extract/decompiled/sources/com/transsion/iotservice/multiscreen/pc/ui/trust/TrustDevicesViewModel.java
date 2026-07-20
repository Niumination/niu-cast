package com.transsion.iotservice.multiscreen.pc.ui.trust;

import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import bc.e;
import bc.f;
import java.util.List;
import java.util.Map;
import k3.gc;
import k3.pb;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import o.d;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/trust/TrustDevicesViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nTrustDevicesViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TrustDevicesViewModel.kt\ncom/transsion/iotservice/multiscreen/pc/ui/trust/TrustDevicesViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
public final class TrustDevicesViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f2889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData f2892d;
    public final ObservableInt e;
    public final q f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f2893g;

    public TrustDevicesViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f2889a = mutableLiveData;
        this.f2890b = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.f2891c = mutableLiveData2;
        this.f2892d = mutableLiveData2;
        this.e = new ObservableInt(8);
        this.f = new q();
        f fVar = new f(this, new Handler(Looper.getMainLooper()), 0);
        this.f2893g = fVar;
        pb.a().getContentResolver().registerContentObserver(Settings.Global.getUriFor("multi_device_connection.trust_devices"), false, fVar);
    }

    public final void a() {
        List listEmptyList;
        ObservableInt observableInt = this.e;
        MutableLiveData mutableLiveData = this.f2889a;
        try {
            String string = Settings.Global.getString(pb.a().getContentResolver(), "multi_device_connection.trust_devices");
            if (string == null) {
                string = "[]";
            }
            String log = "trust value: ".concat(string);
            Intrinsics.checkNotNullParameter("TrustDevicesViewModel", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("TrustDevicesViewModel"), log);
            }
            if (StringsKt.isBlank(string) || Intrinsics.areEqual(string, "[]")) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                try {
                    Object objFromJson = this.f.fromJson(string, new e().getType());
                    Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                    listEmptyList = (List) ((Map) objFromJson).get("trust_devices");
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                } catch (Exception e) {
                    String log2 = "Failed to parse trust device data: " + e.getMessage();
                    Intrinsics.checkNotNullParameter("TrustDevicesViewModel", "tag");
                    Intrinsics.checkNotNullParameter(log2, "log");
                    if (gc.f6462a <= 6) {
                        Log.e(gc.f6463b.concat("TrustDevicesViewModel"), log2);
                    }
                    listEmptyList = CollectionsKt.emptyList();
                }
            }
            mutableLiveData.setValue(listEmptyList);
            observableInt.set(listEmptyList.isEmpty() ? 0 : 8);
            String log3 = "Loaded " + listEmptyList.size() + " trust devices";
            Intrinsics.checkNotNullParameter("TrustDevicesViewModel", "tag");
            Intrinsics.checkNotNullParameter(log3, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("TrustDevicesViewModel"), log3);
            }
        } catch (Exception e4) {
            String strN = d.n("Error loading trust devices: ", e4.getMessage(), "TrustDevicesViewModel", "tag", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("TrustDevicesViewModel"), strN);
            }
            mutableLiveData.setValue(CollectionsKt.emptyList());
            observableInt.set(0);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        pb.a().getContentResolver().unregisterContentObserver(this.f2893g);
        Intrinsics.checkNotNullParameter("TrustDevicesViewModel", "tag");
        Intrinsics.checkNotNullParameter("ViewModel cleared, unregistered settings observer", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("TrustDevicesViewModel"), "ViewModel cleared, unregistered settings observer");
        }
    }
}
