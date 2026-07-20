package zb;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModelKt;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectDialog;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import com.transsion.iotservice.scan.bean.ScannedDevice;
import eb.y;
import java.util.ArrayList;
import java.util.Locale;
import k3.gc;
import k3.pb;
import k3.vb;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;
import li.v0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeviceViewModel f11273b;

    public /* synthetic */ b(DeviceViewModel deviceViewModel, int i8) {
        this.f11272a = i8;
        this.f11273b = deviceViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String deviceBrand;
        DeviceViewModel deviceViewModel = this.f11273b;
        SharedPreferences sharedPreferences = null;
        switch (this.f11272a) {
            case 0:
                ScannedDevice scannedDevice = (ScannedDevice) obj;
                Intrinsics.checkNotNullParameter(scannedDevice, "scannedDevice");
                l0.p(ViewModelKt.getViewModelScope(deviceViewModel), null, null, new j(deviceViewModel, scannedDevice, null), 3);
                break;
            case 1:
                ArrayList it = (ArrayList) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                g0 viewModelScope = ViewModelKt.getViewModelScope(deviceViewModel);
                v0 v0Var = v0.f7498a;
                l0.p(viewModelScope, si.e.f10118a, null, new d(it, deviceViewModel, null), 2);
                break;
            default:
                hc.b it2 = (hc.b) obj;
                Intrinsics.checkNotNullParameter(it2, "it");
                gc.c("DeviceViewModel", "pc connect callback:" + it2);
                ob.b.f8417b.getClass();
                Intrinsics.checkNotNullParameter("start_from_pc", "startFrom");
                ob.b.f8422i = "start_from_pc";
                if (!it2.f5279a) {
                    Integer num = (Integer) deviceViewModel.f2840g.getValue();
                    if (num != null && num.intValue() == 0 && Intrinsics.areEqual(y.f4804h, new Initial())) {
                        l0.p(ViewModelKt.getViewModelScope(deviceViewModel), null, null, new g(deviceViewModel, null), 3);
                    }
                    gc.c("DeviceViewModel", "PassiveConnect: other state: " + it2);
                } else {
                    deviceViewModel.getClass();
                    gc.c("DeviceViewModel", "PassiveConnect:STATE_CONNECTED observerPcConnectState");
                    String deviceMac = it2.f5281c;
                    Intrinsics.checkNotNullParameter(deviceMac, "deviceKey");
                    String key = deviceMac.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(key, "toUpperCase(...)");
                    Intrinsics.checkNotNullParameter(key, "key");
                    SharedPreferences sharedPreferences2 = vb.f6684a;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    } else {
                        sharedPreferences = sharedPreferences2;
                    }
                    if (!sharedPreferences.getBoolean(key, false)) {
                        int i8 = PcRequestConnectDialog.f2742h;
                        int i9 = Integer.parseInt("03");
                        int i10 = it2.e;
                        if (i10 == i9) {
                            deviceBrand = "Tecno";
                        } else if (i10 == Integer.parseInt("04")) {
                            deviceBrand = "Infinix";
                        } else {
                            deviceBrand = i10 == Integer.parseInt("02") ? "Itel" : "UNKONW";
                        }
                        Intrinsics.checkNotNullParameter(deviceBrand, "deviceBrand");
                        String deviceName = it2.f;
                        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
                        Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
                        Intent intent = new Intent(pb.a(), (Class<?>) PcRequestConnectDialog.class);
                        intent.putExtra("key_device_brand", deviceBrand);
                        intent.putExtra("key_device_name", deviceName);
                        intent.putExtra("key_device_mac", deviceMac);
                        intent.setFlags(268435456);
                        pb.a().startActivity(intent);
                    }
                    Intrinsics.checkNotNullParameter("phone_accept_pc_connect", "conType");
                    ob.b.f8423j = "phone_accept_pc_connect";
                    gc.c("DeviceViewModel", "PassiveConnect:STATE_CONNECTED ");
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
