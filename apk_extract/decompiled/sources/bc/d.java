package bc;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.TrustDeviceBean;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesActivity;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesViewModel;
import java.util.Collection;
import java.util.List;
import k3.gc;
import k3.pb;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ld.k;
import ld.n;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrustDevicesActivity f1266a;

    public d(TrustDevicesActivity trustDevicesActivity) {
        this.f1266a = trustDevicesActivity;
    }

    public final void a(final TrustDeviceBean device) {
        int i8 = 0;
        Intrinsics.checkNotNullParameter(device, "device");
        String strN = o.d.n("onDeleteDevice: ", device.getDeviceId(), "TrustDevicesActivity", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("TrustDevicesActivity"), strN);
        }
        int i9 = TrustDevicesActivity.f2883j;
        final TrustDevicesActivity trustDevicesActivity = this.f1266a;
        trustDevicesActivity.getClass();
        k kVar = new k(trustDevicesActivity);
        String string = trustDevicesActivity.getString(R$string.bkp_tip);
        n nVar = kVar.f7400b;
        nVar.f7403b = string;
        nVar.f7405d = trustDevicesActivity.getString(R$string.md_trust_device6, new Object[]{device.getDeviceName()});
        nVar.f7410k = false;
        kVar.c(trustDevicesActivity.getString(R$string.bkp_sure), new DialogInterface.OnClickListener() { // from class: bc.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                List mutableList;
                TrustDevicesViewModel trustDevicesViewModel = trustDevicesActivity.f2884b;
                Object obj = null;
                if (trustDevicesViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTrustDevicesVM");
                    trustDevicesViewModel = null;
                }
                String deviceId = device.getDeviceId();
                trustDevicesViewModel.getClass();
                Intrinsics.checkNotNullParameter(deviceId, "deviceId");
                String strN2 = o.d.n("deleteDevice: ", deviceId, "TrustDevicesViewModel", "tag", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("TrustDevicesViewModel"), strN2);
                }
                ob.b.f8417b.f8437a.getClass();
                w.X("iot_multi_con_phonepad_trust_device_delete_device", w.D());
                MutableLiveData mutableLiveData = trustDevicesViewModel.f2889a;
                List list = (List) mutableLiveData.getValue();
                if (list != null && (mutableList = CollectionsKt.toMutableList((Collection) list)) != null) {
                    for (Object obj2 : mutableList) {
                        if (Intrinsics.areEqual(((TrustDeviceBean) obj2).getDeviceId(), deviceId)) {
                            obj = obj2;
                            break;
                        }
                    }
                    TrustDeviceBean trustDeviceBean = (TrustDeviceBean) obj;
                    if (trustDeviceBean != null) {
                        mutableList.remove(trustDeviceBean);
                        if (mutableList.isEmpty()) {
                            Settings.Global.putString(pb.a().getContentResolver(), "multi_device_connection.trust_devices", "");
                            Intrinsics.checkNotNullParameter("TrustDevicesViewModel", "tag");
                            Intrinsics.checkNotNullParameter("Trust devices setting cleared", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("TrustDevicesViewModel"), "Trust devices setting cleared");
                            }
                        } else {
                            try {
                                Settings.Global.putString(pb.a().getContentResolver(), "multi_device_connection.trust_devices", trustDevicesViewModel.f.toJson(MapsKt.mapOf(TuplesKt.to("trust_devices", mutableList))));
                            } catch (Exception e) {
                                String strN3 = o.d.n("Error saving trust devices: ", e.getMessage(), "TrustDevicesViewModel", "tag", "log");
                                if (gc.f6462a <= 6) {
                                    Log.e(gc.f6463b.concat("TrustDevicesViewModel"), strN3);
                                }
                            }
                        }
                        mutableLiveData.setValue(mutableList);
                        trustDevicesViewModel.e.set(mutableList.isEmpty() ? 0 : 8);
                        String log = "Device " + trustDeviceBean.getDeviceName() + " deleted successfully";
                        Intrinsics.checkNotNullParameter("TrustDevicesViewModel", "tag");
                        Intrinsics.checkNotNullParameter(log, "log");
                        if (gc.f6462a <= 3) {
                            Log.d(gc.f6463b.concat("TrustDevicesViewModel"), log);
                        }
                    } else {
                        String log2 = "Device " + deviceId + " not found";
                        Intrinsics.checkNotNullParameter("TrustDevicesViewModel", "tag");
                        Intrinsics.checkNotNullParameter(log2, "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("TrustDevicesViewModel"), log2);
                        }
                    }
                }
                ob.b.f8417b.f8437a.getClass();
                Bundle bundle = new Bundle();
                bundle.putString("my_device_type", w.B());
                w.X("iot_multi_con_phonepad_trust_delete", bundle);
                dialogInterface.dismiss();
            }
        });
        kVar.b(trustDevicesActivity.getString(R$string.bkp_cancel), new c(i8));
        kVar.e();
    }
}
