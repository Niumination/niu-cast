package com.welink.protocol.spp.spec;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ve.a;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/welink/protocol/spp/spec/DeviceSpp$initBluetoothBroadcast$1", "Landroid/content/BroadcastReceiver;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nDeviceSpp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceSpp.kt\ncom/welink/protocol/spp/spec/DeviceSpp$initBluetoothBroadcast$1\n+ 2 IntentExtension.kt\ncom/welink/protocol/utils/IntentExtensionKt\n*L\n1#1,1220:1\n10#2,6:1221\n10#2,6:1227\n10#2,6:1233\n*S KotlinDebug\n*F\n+ 1 DeviceSpp.kt\ncom/welink/protocol/spp/spec/DeviceSpp$initBluetoothBroadcast$1\n*L\n658#1:1221,6\n674#1:1227,6\n682#1:1233,6\n*E\n"})
public final class DeviceSpp$initBluetoothBroadcast$1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        h.g("收到蓝牙广播，蓝牙的状态是" + intent.getAction());
        if (Intrinsics.areEqual("android.bluetooth.adapter.action.STATE_CHANGED", intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
            h.g("收到蓝牙状态广播，此时蓝牙的开关状态是" + intExtra);
            if (intExtra == 10) {
                throw null;
            }
            return;
        }
        if (Intrinsics.areEqual("android.bluetooth.adapter.action.DISCOVERY_STARTED", intent.getAction())) {
            h.g("收到蓝牙状态广播，已开启蓝牙DISCOVERY");
            return;
        }
        if (Intrinsics.areEqual("android.bluetooth.adapter.action.DISCOVERY_FINISHED", intent.getAction())) {
            h.g("收到蓝牙状态广播，已关闭蓝牙DISCOVERY");
            return;
        }
        if (Intrinsics.areEqual("android.bluetooth.device.action.ACL_CONNECTED", intent.getAction())) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) ((Parcelable) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class));
            h.g("收到蓝牙ACL连接广播,bluetoothDevice: " + bluetoothDevice);
            if (bluetoothDevice != null) {
                int i8 = a.f10551a;
                throw null;
            }
            int i9 = a.f10551a;
            throw null;
        }
        if (Intrinsics.areEqual("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED", intent.getAction())) {
            h.g("收到蓝牙ACL即将断开连接的广播");
            int i10 = a.f10551a;
            throw null;
        }
        if (Intrinsics.areEqual("android.bluetooth.device.action.ACL_DISCONNECTED", intent.getAction())) {
            try {
                h.g("收到蓝牙ACL断开连接广播");
                int i11 = a.f10551a;
                throw null;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual("android.bluetooth.device.action.BOND_STATE_CHANGED", intent.getAction())) {
            h.g("收到蓝牙设备配对状态发生变化广播");
            int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
            intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
            h.g("newBondState is " + intExtra2);
            return;
        }
        if (Intrinsics.areEqual("android.bluetooth.device.action.PAIRING_REQUEST", intent.getAction())) {
            try {
                h.g("收到蓝牙配对pin码请求广播");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
