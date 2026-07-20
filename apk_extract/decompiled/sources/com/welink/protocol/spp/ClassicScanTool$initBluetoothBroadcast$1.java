package com.welink.protocol.spp;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/welink/protocol/spp/ClassicScanTool$initBluetoothBroadcast$1", "Landroid/content/BroadcastReceiver;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ClassicScanTool$initBluetoothBroadcast$1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!StringsKt__StringsJVMKt.equals$default(intent.getAction(), "android.bluetooth.device.action.FOUND", false, 2, null)) {
            if (StringsKt__StringsJVMKt.equals$default(intent.getAction(), "android.bluetooth.adapter.action.DISCOVERY_STARTED", false, 2, null)) {
                h.g("扫描已开始");
                return;
            } else {
                if (StringsKt__StringsJVMKt.equals$default(intent.getAction(), "android.bluetooth.adapter.action.DISCOVERY_FINISHED", false, 2, null)) {
                    h.g("扫描已结束");
                    throw null;
                }
                return;
            }
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            h.g("扫描到的蓝牙设备为null");
            return;
        }
        h.g("扫描到蓝牙设备: " + bluetoothDevice + ", 设备名称：" + bluetoothDevice.getName());
        intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) -50);
        throw null;
    }
}
