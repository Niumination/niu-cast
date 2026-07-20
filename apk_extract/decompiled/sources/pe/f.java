package pe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import com.welink.protocol.libspp.BluetoothController$discoveryBroadcast$1;
import com.welink.protocol.libspp.BluetoothController$pairBroadcast$1;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.d;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import o5.c;
import pe.f;
import tj.x;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends we.g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static BluetoothAdapter f8813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f8814m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f8815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8816d;
    public boolean e;
    public x f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o5.c f8817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q5.a f8818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f8819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BluetoothController$pairBroadcast$1 f8820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BluetoothController$discoveryBroadcast$1 f8821k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.welink.protocol.libspp.BluetoothController$pairBroadcast$1] */
    public f(Context context) {
        super(false, "BluetoothController");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8815c = context;
        this.f8819i = new e(this, 0);
        this.f8820j = new BroadcastReceiver() { // from class: com.welink.protocol.libspp.BluetoothController$pairBroadcast$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                Object next;
                Object next2;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action == null || Intrinsics.areEqual(action, "") || !Intrinsics.areEqual(action, "android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                    return;
                }
                BluetoothDevice bluetoothDevice = (BluetoothDevice) ((Parcelable) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class));
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
                f fVar = this.f3860a;
                if (intExtra == 12 && intExtra2 == 11) {
                    f.j(fVar);
                    c cVar = fVar.f8817g;
                    if (cVar != null) {
                        h.b("NearBluetoothManager", "onDevicePaired: " + bluetoothDevice);
                        if (bluetoothDevice != null) {
                            d dVar = (d) cVar.f8405a;
                            Iterator it = dVar.f4097i.iterator();
                            do {
                                if (!it.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it.next();
                            } while (!Intrinsics.areEqual(((Pair) next2).getFirst(), bluetoothDevice));
                            Pair pair = (Pair) next2;
                            NearDevice nearDevice = pair != null ? (NearDevice) pair.getSecond() : null;
                            if (nearDevice != null) {
                                dVar.f4097i.remove(TuplesKt.to(bluetoothDevice, nearDevice));
                                pe.d dVar2 = dVar.e;
                                if (dVar2 != null) {
                                    dVar2.l(bluetoothDevice, true);
                                }
                            }
                        }
                    }
                }
                if (intExtra == 10 && intExtra2 == 11) {
                    f.j(fVar);
                    c cVar2 = fVar.f8817g;
                    if (cVar2 != null) {
                        h.b("NearBluetoothManager", "onCancelled: " + bluetoothDevice);
                        if (bluetoothDevice != null) {
                            d dVar3 = (d) cVar2.f8405a;
                            Iterator it2 = dVar3.f4097i.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it2.next();
                            } while (!Intrinsics.areEqual(((Pair) next).getFirst(), bluetoothDevice));
                            Pair pair2 = (Pair) next;
                            NearDevice nearDevice2 = pair2 != null ? (NearDevice) pair2.getSecond() : null;
                            if (nearDevice2 != null) {
                                dVar3.f4097i.remove(TuplesKt.to(bluetoothDevice, nearDevice2));
                            }
                        }
                    }
                }
            }
        };
        this.f8821k = new BluetoothController$discoveryBroadcast$1(this);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        f8813l = defaultAdapter;
        if (defaultAdapter != null) {
            f8814m = true;
        } else {
            f8814m = false;
        }
    }

    public static final void j(f fVar) {
        BluetoothController$pairBroadcast$1 bluetoothController$pairBroadcast$1 = fVar.f8820j;
        if (fVar.f8816d) {
            fVar.f8815c.unregisterReceiver(bluetoothController$pairBroadcast$1);
            fVar.f8816d = false;
        }
    }

    public final void k(boolean z2) {
        BluetoothController$discoveryBroadcast$1 bluetoothController$discoveryBroadcast$1 = this.f8821k;
        Context context = this.f8815c;
        if (!z2) {
            if (this.e) {
                context.unregisterReceiver(bluetoothController$discoveryBroadcast$1);
                this.e = false;
                return;
            }
            return;
        }
        if (this.e) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        context.registerReceiver(bluetoothController$discoveryBroadcast$1, intentFilter, 2);
        this.e = true;
    }
}
