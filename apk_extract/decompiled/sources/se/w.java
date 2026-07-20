package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
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
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ we.g f10040b;

    public /* synthetic */ w(we.g gVar, int i8) {
        this.f10039a = i8;
        this.f10040b = gVar;
    }

    public final void a(final BluetoothDevice device, final NearDevice nearDevice) {
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
                for (final Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    final int i8 = 0;
                    ((Executor) pair.getFirst()).execute(new Runnable() { // from class: se.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i8) {
                                case 0:
                                    ((e1) pair.getSecond()).f(device, nearDevice);
                                    break;
                                case 1:
                                    ((e1) pair.getSecond()).f(device, nearDevice);
                                    break;
                                default:
                                    ((e1) pair.getSecond()).f(device, nearDevice);
                                    break;
                            }
                        }
                    });
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
                for (final Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    final int i9 = 1;
                    ((Executor) pair2.getFirst()).execute(new Runnable() { // from class: se.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i9) {
                                case 0:
                                    ((e1) pair2.getSecond()).f(device, nearDevice);
                                    break;
                                case 1:
                                    ((e1) pair2.getSecond()).f(device, nearDevice);
                                    break;
                                default:
                                    ((e1) pair2.getSecond()).f(device, nearDevice);
                                    break;
                            }
                        }
                    });
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
                for (final Pair pair3 : ((a4) this.f10040b).f9646h) {
                    final int i10 = 2;
                    ((Executor) pair3.getFirst()).execute(new Runnable() { // from class: se.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i10) {
                                case 0:
                                    ((e1) pair3.getSecond()).f(device, nearDevice);
                                    break;
                                case 1:
                                    ((e1) pair3.getSecond()).f(device, nearDevice);
                                    break;
                                default:
                                    ((e1) pair3.getSecond()).f(device, nearDevice);
                                    break;
                            }
                        }
                    });
                }
                break;
        }
    }

    public final void b(int i8, BluetoothDevice device, NearDevice nearDevice) {
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new s(pair, device, nearDevice, i8, 0));
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new s(pair2, device, nearDevice, i8, 3));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair3 : ((a4) this.f10040b).f9646h) {
                    ((Executor) pair3.getFirst()).execute(new s(pair3, device, nearDevice, i8, 6));
                }
                break;
        }
    }

    public final void c(BluetoothDevice bluetoothDevice, WifiP2pDevice p2pDevice, NearDevice nearDevice, String str, String str2) {
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new m(pair, bluetoothDevice, p2pDevice, nearDevice, str, str2, 0));
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new m(pair2, bluetoothDevice, p2pDevice, nearDevice, str, str2, 2));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                for (Pair pair3 : ((a4) this.f10040b).f9646h) {
                    ((Executor) pair3.getFirst()).execute(new m(pair3, bluetoothDevice, p2pDevice, nearDevice, str, str2, 4));
                }
                break;
        }
    }

    public final void d(BluetoothDevice bluetoothDevice, WifiP2pDevice owner, String str, String str2, String str3, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo, NearDevice nearDevice) {
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(owner, "owner");
                we.h.b("NearBleManager", "onClientDeviceP2pConnected: " + bluetoothDevice + ", " + owner + ", " + str + ", " + tranConnectionController$P2pDeviceInfo);
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new t(pair, bluetoothDevice, owner, str, str2, str3, tranConnectionController$P2pDeviceInfo, nearDevice, 0));
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(owner, "owner");
                we.h.b("NearBluetoothManager", "onClientDeviceP2pConnected: " + bluetoothDevice + ", " + owner + ", " + str + ", " + tranConnectionController$P2pDeviceInfo);
                for (Iterator it = ((com.welink.protocol.nfbd.d) this.f10040b).f4096h.iterator(); it.hasNext(); it = it) {
                    Pair pair2 = (Pair) it.next();
                    ((Executor) pair2.getFirst()).execute(new t(pair2, bluetoothDevice, owner, str, str2, str3, tranConnectionController$P2pDeviceInfo, nearDevice, 2));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(owner, "owner");
                we.h.b("NearLaptopManager", "onClientDeviceP2pConnected: " + bluetoothDevice + ", " + owner + ", " + str + ", " + tranConnectionController$P2pDeviceInfo);
                for (Iterator it2 = ((a4) this.f10040b).f9646h.iterator(); it2.hasNext(); it2 = it2) {
                    Pair pair3 = (Pair) it2.next();
                    ((Executor) pair3.getFirst()).execute(new t(pair3, bluetoothDevice, owner, str, str2, str3, tranConnectionController$P2pDeviceInfo, nearDevice, 4));
                }
                break;
        }
    }

    public final void e(BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, boolean z2, NearDevice nearDevice) {
        switch (this.f10039a) {
            case 0:
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new n(pair, bluetoothDevice, wifiP2pDevice, z2, nearDevice, 0));
                }
                break;
            case 1:
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new n(pair2, bluetoothDevice, wifiP2pDevice, z2, nearDevice, 2));
                }
                break;
            default:
                for (Pair pair3 : ((a4) this.f10040b).f9646h) {
                    ((Executor) pair3.getFirst()).execute(new n(pair3, bluetoothDevice, wifiP2pDevice, z2, nearDevice, 4));
                }
                break;
        }
    }

    public final void f(BluetoothDevice bluetoothDevice, WifiP2pDevice owner, NearDevice nearDevice, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo) {
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(owner, "owner");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new v(pair, bluetoothDevice, owner, nearDevice, 0));
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(owner, "owner");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new v(pair2, bluetoothDevice, owner, nearDevice, 2));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(owner, "owner");
                for (Pair pair3 : ((a4) this.f10040b).f9646h) {
                    ((Executor) pair3.getFirst()).execute(new j7.a(pair3, bluetoothDevice, owner, nearDevice, tranConnectionController$P2pDeviceInfo, 1));
                }
                break;
        }
    }

    public final void g(NearDevice device) {
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new o(pair, device, 0));
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new o(pair2, device, 1));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair3 : ((a4) this.f10040b).f9646h) {
                    ((Executor) pair3.getFirst()).execute(new o(pair3, device, 7));
                }
                break;
        }
    }

    public final void h(NearDevice device, boolean z2) {
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new p(pair, device, z2, 0));
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new p(pair2, device, z2, 1));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair3 : ((a4) this.f10040b).f9646h) {
                    ((Executor) pair3.getFirst()).execute(new p(pair3, device, z2, 3));
                }
                break;
        }
    }

    public final void i(final BluetoothDevice bluetoothDevice, final WifiP2pDevice wifiP2pDevice, final int i8, final NearDevice nearDevice) {
        switch (this.f10039a) {
            case 0:
                for (final Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    final int i9 = 0;
                    ((Executor) pair.getFirst()).execute(new Runnable() { // from class: se.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i9) {
                                case 0:
                                    ((e1) pair.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                                case 1:
                                    ((e1) pair.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                                default:
                                    ((e1) pair.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                            }
                        }
                    });
                }
                break;
            case 1:
                for (final Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    final int i10 = 1;
                    ((Executor) pair2.getFirst()).execute(new Runnable() { // from class: se.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i10) {
                                case 0:
                                    ((e1) pair2.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                                case 1:
                                    ((e1) pair2.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                                default:
                                    ((e1) pair2.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                            }
                        }
                    });
                }
                break;
            default:
                for (final Pair pair3 : ((a4) this.f10040b).f9646h) {
                    final int i11 = 2;
                    ((Executor) pair3.getFirst()).execute(new Runnable() { // from class: se.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i11) {
                                case 0:
                                    ((e1) pair3.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                                case 1:
                                    ((e1) pair3.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                                default:
                                    ((e1) pair3.getSecond()).j(bluetoothDevice, wifiP2pDevice, i8, nearDevice);
                                    break;
                            }
                        }
                    });
                }
                break;
        }
    }

    public final void j(BluetoothDevice device, ConnectRequest connectRequest, NearDevice nearDevice) {
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                for (Pair pair : ((com.welink.protocol.nfbd.a) this.f10040b).f4031h) {
                    ((Executor) pair.getFirst()).execute(new u(pair, device, connectRequest, nearDevice, 0));
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                for (Pair pair2 : ((com.welink.protocol.nfbd.d) this.f10040b).f4096h) {
                    ((Executor) pair2.getFirst()).execute(new u(pair2, device, connectRequest, nearDevice, 2));
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                for (Pair pair3 : ((a4) this.f10040b).f9646h) {
                    ((Executor) pair3.getFirst()).execute(new u(pair3, device, connectRequest, nearDevice, 5));
                }
                break;
        }
    }

    public final void k(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        h4 h4Var;
        h4 h4Var2;
        pe.d dVar;
        switch (this.f10039a) {
            case 0:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.a aVar = (com.welink.protocol.nfbd.a) this.f10040b;
                com.welink.protocol.nfbd.l lVar = aVar.f4028c;
                if (lVar != null) {
                    LinkedHashSet linkedHashSet = lVar.f4155i;
                    boolean z2 = !linkedHashSet.isEmpty() || ((h4Var = lVar.f4164t) != null && h4Var.s(lVar.f4168y) && (h4Var2 = lVar.f4164t) != null && h4Var2.q());
                    if (z2) {
                        we.h.b("NearGattService", "Server is running");
                        if (!linkedHashSet.isEmpty()) {
                            h0.a.C(linkedHashSet.size(), "Connected devices: ", "NearGattService");
                        }
                        h4 h4Var3 = lVar.f4164t;
                        if (h4Var3 != null && (!(h4Var3.f9765h instanceof p6))) {
                            we.h.b("NearGattService", "P2p group owner is not in disconnected");
                        }
                        h4 h4Var4 = lVar.f4164t;
                        if (h4Var4 != null && h4Var4.r()) {
                            we.h.b("NearGattService", "P2p group client is not in disconnected");
                        }
                    }
                    if (!z2) {
                        for (Pair pair : aVar.f4031h) {
                            ((Executor) pair.getFirst()).execute(new r(pair, wifiP2pGroup, wifiP2pInfo, clientList, 0));
                        }
                        we.h.b("NearBleManager", "onOtherDeviceP2pConnected: ignored, client mode not running");
                    }
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.d dVar2 = (com.welink.protocol.nfbd.d) this.f10040b;
                com.welink.protocol.nfbd.f fVar = dVar2.f4094d;
                if (fVar != null) {
                    pe.d dVar3 = fVar.e;
                    if (dVar3 == null || !dVar3.q() || (dVar = fVar.e) == null || dVar.f8806l != 1) {
                        for (Pair pair2 : dVar2.f4096h) {
                            ((Executor) pair2.getFirst()).execute(new r(pair2, wifiP2pGroup, wifiP2pInfo, clientList, 1));
                        }
                        we.h.b("NearBluetoothManager", "onOtherDeviceP2pConnected: ignored, client mode not running");
                        break;
                    }
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                for (Pair pair3 : ((a4) this.f10040b).f9646h) {
                    ((Executor) pair3.getFirst()).execute(new r(pair3, wifiP2pGroup, wifiP2pInfo, clientList, 2));
                }
                we.h.b("NearLaptopManager", "onOtherDeviceP2pConnected: ignored, client mode not running");
                break;
        }
    }
}
