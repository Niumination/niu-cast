package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ we.g f9640b;

    public /* synthetic */ a0(we.g gVar, int i8) {
        this.f9639a = i8;
        this.f9640b = gVar;
    }

    public final void a(final BluetoothDevice device) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                we.h.h("NearBleManager", "onClientDeviceConnected: " + device);
                for (final Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    final int i8 = 0;
                    ((Executor) pair.getFirst()).execute(new Runnable() { // from class: se.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i8) {
                                case 0:
                                    ((e1) pair.getSecond()).f(device, null);
                                    break;
                                default:
                                    ((e1) pair.getSecond()).f(device, null);
                                    break;
                            }
                        }
                    });
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                we.h.h("NearBluetoothManager", "onClientDeviceConnected: " + device);
                for (final Pair pair2 : ((com.welink.protocol.nfbd.d) this.f9640b).f4096h) {
                    final int i9 = 1;
                    ((Executor) pair2.getFirst()).execute(new Runnable() { // from class: se.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i9) {
                                case 0:
                                    ((e1) pair2.getSecond()).f(device, null);
                                    break;
                                default:
                                    ((e1) pair2.getSecond()).f(device, null);
                                    break;
                            }
                        }
                    });
                }
                break;
        }
    }

    public final void b(int i8, BluetoothDevice device, NearDevice nearDevice) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                we.h.h("NearBleManager", "onClientDeviceDisConnected: " + device);
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new s(pair, device, nearDevice, i8, 1));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                we.h.h("NearBluetoothManager", "onClientDeviceDisConnected: " + device);
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f9640b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new s(pair2, device, nearDevice, i8, 5));
                }
                break;
        }
    }

    public final void c(BluetoothDevice device, WifiP2pDevice p2pDevice, NearDevice nearDevice, String str, String str2) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new m(pair, device, p2pDevice, nearDevice, str, str2, 1));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f9640b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new m(pair2, device, p2pDevice, nearDevice, str, str2, 3));
                }
                break;
        }
    }

    public final void d(BluetoothDevice device, WifiP2pDevice p2pOwnerDevice, String str, String str2, String str3, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo, NearDevice nearDevice) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(p2pOwnerDevice, "p2pOwnerDevice");
                StringBuilder sb2 = new StringBuilder("onClientDeviceP2pConnected: ");
                sb2.append(device);
                sb2.append(", ");
                sb2.append(p2pOwnerDevice);
                sb2.append(", ");
                o.d.A(sb2, str, ", ", str2, ", ");
                sb2.append(str3);
                we.h.b("NearBleManager", sb2.toString());
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new t(pair, device, p2pOwnerDevice, str, str2, str3, tranConnectionController$P2pDeviceInfo, nearDevice, 1));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(p2pOwnerDevice, "p2pOwnerDevice");
                StringBuilder sb3 = new StringBuilder("onClientDeviceP2pConnected: ");
                sb3.append(device);
                sb3.append(", ");
                sb3.append(p2pOwnerDevice);
                sb3.append(", ");
                o.d.A(sb3, str, ", ", str2, ", ");
                sb3.append(str3);
                we.h.b("NearBluetoothManager", sb3.toString());
                for (Iterator it = ((com.welink.protocol.nfbd.d) this.f9640b).f4096h.iterator(); it.hasNext(); it = it) {
                    Pair pair2 = (Pair) it.next();
                    ((Executor) pair2.getFirst()).execute(new t(pair2, device, p2pOwnerDevice, str, str2, str3, tranConnectionController$P2pDeviceInfo, nearDevice, 3));
                }
                break;
        }
    }

    public final void e(BluetoothDevice bluetoothDevice, WifiP2pDevice p2pDevice, boolean z2, NearDevice nearDevice) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new n(pair, bluetoothDevice, p2pDevice, z2, nearDevice, 1));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f9640b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new n(pair2, bluetoothDevice, p2pDevice, z2, nearDevice, 3));
                }
                break;
        }
    }

    public final void f(BluetoothDevice device, WifiP2pDevice owner, NearDevice nearDevice) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(owner, "owner");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new v(pair, device, owner, nearDevice, 1));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(owner, "owner");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f9640b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new v(pair2, device, owner, nearDevice, 3));
                }
                break;
        }
    }

    public final void g(int i8, BluetoothDevice device, NearDevice nearDevice) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new s(pair, device, i8, nearDevice, 2));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f9640b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new s(pair2, device, i8, nearDevice, 4));
                }
                break;
        }
    }

    public final void h(BluetoothDevice device, ConnectRequest connectRequest, NearDevice nearDevice) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new u(pair, device, connectRequest, nearDevice, 1));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f9640b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new u(pair2, device, connectRequest, nearDevice, 3));
                }
                break;
        }
    }

    public final void i(final BluetoothDevice device, final ConnectRequest connectRequest) {
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                we.h.h("NearBleManager", "onConnectRequestReceived: " + device);
                for (final Pair pair : ((com.welink.protocol.nfbd.a) this.f9640b).f4031h) {
                    final int i8 = 0;
                    ((Executor) pair.getFirst()).execute(new Runnable() { // from class: se.z
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i8) {
                                case 0:
                                    ((e1) pair.getSecond()).c(device, connectRequest, null);
                                    break;
                                default:
                                    ((e1) pair.getSecond()).c(device, connectRequest, null);
                                    break;
                            }
                        }
                    });
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                we.h.h("NearBluetoothManager", "onConnectRequestReceived: " + device);
                for (final Pair pair2 : ((com.welink.protocol.nfbd.d) this.f9640b).f4096h) {
                    final int i9 = 1;
                    ((Executor) pair2.getFirst()).execute(new Runnable() { // from class: se.z
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i9) {
                                case 0:
                                    ((e1) pair2.getSecond()).c(device, connectRequest, null);
                                    break;
                                default:
                                    ((e1) pair2.getSecond()).c(device, connectRequest, null);
                                    break;
                            }
                        }
                    });
                }
                break;
        }
    }

    public final void j(Collection clientList) {
        h4 h4Var;
        h4 h4Var2;
        pe.d dVar;
        switch (this.f9639a) {
            case 0:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.j jVar = ((com.welink.protocol.nfbd.a) this.f9640b).f4029d;
                if (jVar != null) {
                    LinkedHashSet linkedHashSet = jVar.f4137h;
                    boolean z2 = !linkedHashSet.isEmpty() || ((h4Var = jVar.f4146s) != null && h4Var.s(jVar.f4149w) && (h4Var2 = jVar.f4146s) != null && h4Var2.q());
                    if (z2) {
                        we.h.b("NearGattClient", "Client is running");
                        if (!linkedHashSet.isEmpty()) {
                            h0.a.C(linkedHashSet.size(), "Connected devices: ", "NearGattClient");
                        }
                        h4 h4Var3 = jVar.f4146s;
                        if (h4Var3 != null && (!(h4Var3.f9765h instanceof p6))) {
                            we.h.b("NearGattClient", "P2p group owner is not in disconnected");
                        }
                        h4 h4Var4 = jVar.f4146s;
                        if (h4Var4 != null && h4Var4.r()) {
                            we.h.b("NearGattClient", "P2p group client is not in disconnected");
                        }
                    }
                    if (!z2) {
                        we.h.b("NearBleManager", "onOtherDeviceP2pConnected: ignored, server mode not running");
                    }
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.c cVar = ((com.welink.protocol.nfbd.d) this.f9640b).f4093c;
                if (cVar != null) {
                    pe.d dVar2 = cVar.f;
                    if (dVar2 == null || !dVar2.q() || (dVar = cVar.f) == null || dVar.f8806l != 0) {
                        we.h.b("NearBluetoothManager", "onOtherDeviceP2pConnected: ignored, server mode not running");
                        break;
                    }
                }
                break;
        }
    }
}
