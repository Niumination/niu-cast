package com.welink.protocol.libspp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pe.e;
import pe.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/welink/protocol/libspp/BluetoothController$discoveryBroadcast$1", "Landroid/content/BroadcastReceiver;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothController.kt\ncom/welink/protocol/libspp/BluetoothController$discoveryBroadcast$1\n+ 2 IntentExtension.kt\ncom/welink/protocol/utils/IntentExtensionKt\n*L\n1#1,499:1\n10#2,6:500\n*S KotlinDebug\n*F\n+ 1 BluetoothController.kt\ncom/welink/protocol/libspp/BluetoothController$discoveryBroadcast$1\n*L\n385#1:500,6\n*E\n"})
public final class BluetoothController$discoveryBroadcast$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3858b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3859a;

    public BluetoothController$discoveryBroadcast$1(f fVar) {
        this.f3859a = fVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        BluetoothDevice bluetoothDevice;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null || Intrinsics.areEqual(action, "")) {
            return;
        }
        boolean zAreEqual = Intrinsics.areEqual(action, "android.bluetooth.device.action.FOUND");
        f fVar = this.f3859a;
        if (zAreEqual && (bluetoothDevice = (BluetoothDevice) ((Parcelable) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class))) != null && bluetoothDevice.getName() != null && bluetoothDevice.getAddress() != null && bluetoothDevice.getBondState() != 12) {
            fVar.f(new d(fVar, bluetoothDevice, intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) -50), 3));
        }
        if (Intrinsics.areEqual(action, "android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
            fVar.f(new e(fVar, 1));
        }
        if (Intrinsics.areEqual(action, "android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
            BluetoothAdapter bluetoothAdapter = f.f8813l;
            fVar.k(false);
            fVar.f(new e(fVar, 2));
        }
    }
}
