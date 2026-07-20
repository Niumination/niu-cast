package m3;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.util.Log;
import java.lang.ref.WeakReference;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static boolean a() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            Intrinsics.checkNotNullParameter("mBluetoothAdapter为null，本机可能不支持蓝牙", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "mBluetoothAdapter为null，本机可能不支持蓝牙", null);
            }
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!defaultAdapter.isEnabled()) {
            we.h.g("蓝牙没打开，现在开启蓝牙......");
            boolean z2 = false;
            if (lb.f6527a == null) {
                Intrinsics.checkNotNullParameter("mContext is null, please execute InitProtocol.init() first", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "mContext is null, please execute InitProtocol.init() first", null);
                }
            } else {
                tc.d dVarH = tc.d.h();
                Context context = lb.f6527a;
                Intrinsics.checkNotNull(context);
                dVarH.getClass();
                int i8 = -1;
                if (j.a() != null) {
                    dVarH.f10210b = new WeakReference(context);
                    try {
                        if (!dVarH.k()) {
                            dVarH.j(context);
                            vc.a.b("KolunScannerManager", "getBleAssistorVersion init IKolunScanner ");
                        }
                        if (dVarH.k()) {
                            i8 = ((tc.a) ((tc.c) dVarH.f10209a)).i(dVarH.i());
                        }
                    } catch (Exception e) {
                        vc.a.a(5, "KolunScannerManager", "getBleAssistorVersion,err:", e);
                    }
                } else {
                    vc.a.b("KolunScannerManager", "kolun is not exists");
                }
                if (i8 >= 1) {
                    z2 = true;
                }
            }
            if (z2) {
                tc.d.h().g();
            } else {
                defaultAdapter.enable();
            }
        }
        int iCurrentTimeMillis = 0;
        while (!defaultAdapter.isEnabled() && iCurrentTimeMillis < 6) {
            iCurrentTimeMillis = (int) ((System.currentTimeMillis() - jCurrentTimeMillis) / ((long) 1000));
        }
        if (defaultAdapter.isEnabled() || iCurrentTimeMillis < 6) {
            we.h.g("蓝牙已开启！");
            return true;
        }
        Intrinsics.checkNotNullParameter("蓝牙开启超过6s，开启超时，退出！", "mes");
        if (lb.f6529c < 1) {
            return false;
        }
        Log.e("welinkBLE", "蓝牙开启超过6s，开启超时，退出！", null);
        return false;
    }
}
