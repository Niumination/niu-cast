package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import com.welink.protocol.nfbd.NearDevice;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 implements b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9758b;

    public /* synthetic */ h1(Object obj, int i8) {
        this.f9757a = i8;
        this.f9758b = obj;
    }

    @Override // se.b4
    public final void a(int i8) {
        Object obj = this.f9758b;
        switch (this.f9757a) {
            case 0:
                h4.q.getClass();
                we.h.b("NearConnectionService", "onNotifyRemoveGroupSuccess, ".concat(u0.c(i8)));
                break;
            case 1:
                h4.q.getClass();
                we.h.h("TranFileReceiveController", "onNotifyRemoveGroupSuccess: moduleId: ".concat(u0.c(i8)));
                com.welink.protocol.nfbd.a0 a0Var = (com.welink.protocol.nfbd.a0) obj;
                if (a0Var.D) {
                    we.h.j("TranFileReceiveController", "onNotifyRemoveGroupSuccess: mP2pDirectRecovering ignore");
                } else if (i8 != 320098824) {
                    h4 h4Var = a0Var.C;
                    we.h.h("TranFileReceiveController", "onNotifyRemoveGroupSuccess: tryCancelSuspendP2pConnectTimer: " + (h4Var != null ? Boolean.valueOf(h4Var.H(320098824, "TranFileReceiveController")) : null));
                }
                break;
            default:
                int i9 = com.welink.protocol.nfbd.b0.Q;
                h4.q.getClass();
                we.h.h("TranFileSendController", "onNotifyRemoveGroupSuccess: moduleId: ".concat(u0.c(i8)));
                com.welink.protocol.nfbd.b0 b0Var = (com.welink.protocol.nfbd.b0) obj;
                if (b0Var.f4065s) {
                    we.h.j("TranFileSendController", "onNotifyRemoveGroupSuccess: mP2pDirectRecovering ignore");
                } else if (i8 != 320098823) {
                    h4 h4Var2 = b0Var.f4064r;
                    we.h.h("TranFileSendController", "onNotifyRemoveGroupSuccess: tryCancelSuspendP2pConnectTimer: " + (h4Var2 != null ? Boolean.valueOf(h4Var2.H(320098823, "TranFileSendController")) : null));
                }
                break;
        }
    }

    @Override // se.b4
    public final void b(boolean z2, int i8, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice) {
        NearDevice nearDevice2;
        NearDevice nearDevice3;
        switch (this.f9757a) {
            case 0:
                we.h.b("NearConnectionService", "onNotifyDisconnected");
                return;
            case 1:
                we.h.h("TranFileReceiveController", "onNotifyDisconnected: isSelf: " + z2 + ", reasonCode: " + i8 + ", device: " + bluetoothDevice + ", p2pOwnerDevice: " + wifiP2pDevice + ", nearDevice: " + nearDevice);
                com.welink.protocol.nfbd.a0 a0Var = (com.welink.protocol.nfbd.a0) this.f9758b;
                synchronized (a0Var) {
                    try {
                        if (!a0Var.f4048v.isEmpty()) {
                            for (Map.Entry entry : a0Var.f4048v.entrySet()) {
                                h2 h2Var = (h2) entry.getValue();
                                for (w wVar : a0Var.A) {
                                    BluetoothDevice bluetoothDevice2 = h2Var.f9759a;
                                    WifiP2pDevice wifiP2pDevice2 = h2Var.f9760b;
                                    NearDevice nearDevice4 = h2Var.f9761c;
                                    if (nearDevice4 == null) {
                                        nearDevice4 = a0Var.F;
                                    }
                                    wVar.e(bluetoothDevice2, wifiP2pDevice2, z2, nearDevice4);
                                }
                            }
                            a0Var.f4048v.clear();
                            if (a0Var.c(a0Var.L)) {
                                a0Var.h(a0Var.L);
                            }
                            if (a0Var.c(a0Var.K)) {
                                a0Var.h(a0Var.K);
                            }
                            a0Var.f4035d = 0;
                        } else if (a0Var.u.isEmpty()) {
                            we.h.j("TranFileReceiveController", "Nothing Done");
                        } else {
                            for (Map.Entry entry2 : a0Var.u.entrySet()) {
                                g2 g2Var = (g2) entry2.getValue();
                                if (i8 != 107) {
                                    switch (i8) {
                                        case 100:
                                            if (a0Var.D) {
                                                we.h.j("TranFileReceiveController", "P2P GC connect recovery 3, wait for timeout");
                                                return;
                                            }
                                            we.h.b("TranFileReceiveController", "P2P connect timeout, report to upper layer");
                                            break;
                                        case 101:
                                            we.h.b("TranFileReceiveController", "P2P connect failed, report to upper layer");
                                            break;
                                        case 102:
                                            we.h.j("TranFileReceiveController", "P2P connect recovery, wait for timeout");
                                            return;
                                        default:
                                            if (a0Var.D) {
                                                we.h.j("TranFileReceiveController", "P2P GC connect recovery 2, wait for timeout");
                                                return;
                                            }
                                            we.h.b("TranFileReceiveController", "P2P connect internal failed, report to upper layer");
                                            break;
                                    }
                                } else {
                                    if (a0Var.D) {
                                        we.h.j("TranFileReceiveController", "P2P GC occupy from other, wait for timeout");
                                        return;
                                    }
                                    we.h.b("TranFileReceiveController", "P2P connect occupied by other(GO), report to upper layer");
                                }
                                for (w wVar2 : a0Var.A) {
                                    BluetoothDevice bluetoothDevice3 = g2Var.f9743a;
                                    i2 i2Var = a0Var.G;
                                    if (i2Var == null || (nearDevice2 = i2Var.f9797g) == null) {
                                        nearDevice2 = a0Var.F;
                                    }
                                    wVar2.i(bluetoothDevice3, null, i8, nearDevice2);
                                    a0Var.m();
                                }
                            }
                            a0Var.u.clear();
                            if (a0Var.c(a0Var.L)) {
                                a0Var.h(a0Var.L);
                            }
                            if (a0Var.c(a0Var.K)) {
                                a0Var.h(a0Var.K);
                            }
                            a0Var.f4035d = 0;
                        }
                        Unit unit = Unit.INSTANCE;
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            default:
                int i9 = com.welink.protocol.nfbd.b0.Q;
                we.h.h("TranFileSendController", "onNotifyDisconnected: isSelf: " + z2 + ", reasonCode: " + i8 + ", device: " + bluetoothDevice + ", p2pOwnerDevice: " + wifiP2pDevice + ", nearDevice: " + nearDevice);
                com.welink.protocol.nfbd.b0 b0Var = (com.welink.protocol.nfbd.b0) this.f9758b;
                synchronized (b0Var) {
                    try {
                        if (!b0Var.f4055g.isEmpty()) {
                            for (Map.Entry entry3 : b0Var.f4055g.entrySet()) {
                                h2 h2Var2 = (h2) entry3.getValue();
                                for (w wVar3 : b0Var.p) {
                                    BluetoothDevice bluetoothDevice4 = h2Var2.f9759a;
                                    WifiP2pDevice wifiP2pDevice3 = h2Var2.f9760b;
                                    NearDevice nearDevice5 = h2Var2.f9761c;
                                    if (nearDevice5 == null) {
                                        nearDevice5 = b0Var.u;
                                    }
                                    wVar3.e(bluetoothDevice4, wifiP2pDevice3, z2, nearDevice5);
                                }
                            }
                            b0Var.f4055g.clear();
                            if (b0Var.c(b0Var.L)) {
                                b0Var.h(b0Var.L);
                            }
                            if (b0Var.c(b0Var.J)) {
                                b0Var.h(b0Var.J);
                            }
                            b0Var.f4054d = 0;
                        } else if (b0Var.f4056h.isEmpty()) {
                            we.h.j("TranFileSendController", "Nothing Done");
                        } else {
                            for (Map.Entry entry4 : b0Var.f4056h.entrySet()) {
                                g2 g2Var2 = (g2) entry4.getValue();
                                if (i8 != 107) {
                                    switch (i8) {
                                        case 100:
                                            we.h.b("TranFileSendController", "P2P connect timeout, report to upper layer");
                                            break;
                                        case 101:
                                            we.h.b("TranFileSendController", "P2P connect failed, report to upper layer");
                                            break;
                                        case 102:
                                            we.h.j("TranFileSendController", "P2P connect recovery, wait for timeout");
                                            return;
                                        default:
                                            if (b0Var.f4065s) {
                                                we.h.j("TranFileSendController", "P2P GC connect recovery 2, wait for timeout");
                                                return;
                                            }
                                            we.h.b("TranFileSendController", "P2P connect internal failed, report to upper layer");
                                            break;
                                    }
                                } else {
                                    if (b0Var.f4065s) {
                                        we.h.j("TranFileSendController", "P2P GC occupy from other, wait for timeout");
                                        return;
                                    }
                                    we.h.b("TranFileSendController", "P2P connect occupied by other(GO), report to upper layer");
                                }
                                for (w wVar4 : b0Var.p) {
                                    BluetoothDevice bluetoothDevice5 = g2Var2.f9743a;
                                    i2 i2Var2 = b0Var.f4067v;
                                    if (i2Var2 == null || (nearDevice3 = i2Var2.f9797g) == null) {
                                        nearDevice3 = b0Var.u;
                                    }
                                    wVar4.i(bluetoothDevice5, null, i8, nearDevice3);
                                    b0Var.l();
                                }
                            }
                            b0Var.f4056h.clear();
                            if (b0Var.c(b0Var.L)) {
                                b0Var.h(b0Var.L);
                            }
                            if (b0Var.c(b0Var.J)) {
                                b0Var.h(b0Var.J);
                            }
                            b0Var.f4054d = 0;
                        }
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
        }
    }

    @Override // se.b4
    public final void c(WifiP2pGroup wifiP2pGroupInfo, WifiP2pInfo wifiP2pInfo) {
        int i8 = this.f9757a;
        Intrinsics.checkNotNullParameter(wifiP2pGroupInfo, "wifiP2pGroupInfo");
        switch (i8) {
            case 0:
                we.h.b("NearConnectionService", "onNotifyGroupOwnerAvailable");
                break;
            case 1:
                we.h.h("TranFileReceiveController", "onNotifyGroupOwnerAvailable");
                break;
            default:
                int i9 = com.welink.protocol.nfbd.b0.Q;
                we.h.h("TranFileSendController", "onNotifyGroupOwnerAvailable");
                break;
        }
    }

    @Override // se.b4
    public final void d() {
        switch (this.f9757a) {
            case 0:
                we.h.b("NearConnectionService", "onNotifyCreateGroupSuccess");
                break;
            case 1:
                we.h.h("TranFileReceiveController", "onNotifyCreateGroupSuccess");
                break;
            default:
                int i8 = com.welink.protocol.nfbd.b0.Q;
                we.h.h("TranFileSendController", "onNotifyCreateGroupSuccess");
                break;
        }
    }

    @Override // se.b4
    public final void e() {
        switch (this.f9757a) {
            case 0:
                we.h.b("NearConnectionService", "onNotifyCreateGroupFailed");
                break;
            case 1:
                we.h.h("TranFileReceiveController", "onNotifyCreateGroupFailed");
                break;
            default:
                int i8 = com.welink.protocol.nfbd.b0.Q;
                we.h.h("TranFileSendController", "onNotifyCreateGroupFailed");
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008b A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:6:0x0015, B:8:0x003a, B:11:0x0042, B:13:0x0046, B:15:0x004a, B:17:0x0050, B:21:0x0059, B:22:0x006b, B:24:0x0071, B:29:0x008b, B:31:0x0098, B:32:0x009a, B:33:0x00a0, B:35:0x00c8, B:34:0x00a7), top: B:87:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0098 A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:6:0x0015, B:8:0x003a, B:11:0x0042, B:13:0x0046, B:15:0x004a, B:17:0x0050, B:21:0x0059, B:22:0x006b, B:24:0x0071, B:29:0x008b, B:31:0x0098, B:32:0x009a, B:33:0x00a0, B:35:0x00c8, B:34:0x00a7), top: B:87:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x016a A[Catch: all -> 0x011b, TryCatch #1 {all -> 0x011b, blocks: (B:42:0x00dc, B:44:0x00ff, B:47:0x0107, B:49:0x010b, B:51:0x010f, B:53:0x0115, B:57:0x011f, B:59:0x0123, B:62:0x012b, B:64:0x0131, B:66:0x0138, B:67:0x014a, B:69:0x0150, B:74:0x016a, B:76:0x0177, B:77:0x0179, B:78:0x017f, B:80:0x01a9, B:79:0x0188), top: B:89:0x00dc }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0177 A[Catch: all -> 0x011b, TryCatch #1 {all -> 0x011b, blocks: (B:42:0x00dc, B:44:0x00ff, B:47:0x0107, B:49:0x010b, B:51:0x010f, B:53:0x0115, B:57:0x011f, B:59:0x0123, B:62:0x012b, B:64:0x0131, B:66:0x0138, B:67:0x014a, B:69:0x0150, B:74:0x016a, B:76:0x0177, B:77:0x0179, B:78:0x017f, B:80:0x01a9, B:79:0x0188), top: B:89:0x00dc }] */
    @Override // se.b4
    public final void f(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        BluetoothDevice bluetoothDevice;
        String hostAddress;
        String hostAddress2;
        BluetoothDevice bluetoothDevice2;
        String hostAddress3;
        switch (this.f9757a) {
            case 0:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                we.h.b("NearConnectionService", "onNotifyConnected");
                return;
            case 1:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.a0 a0Var = (com.welink.protocol.nfbd.a0) this.f9758b;
                synchronized (a0Var) {
                    try {
                        we.h.h("TranFileReceiveController", "onNotifyConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                        if (wifiP2pGroup == null || wifiP2pGroup.isGroupOwner() || wifiP2pInfo == null || !wifiP2pInfo.groupFormed) {
                            we.h.h("TranFileReceiveController", "onNotifyConnected failed: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                        } else {
                            InetAddress inetAddress = wifiP2pInfo.groupOwnerAddress;
                            String string = (inetAddress == null || (hostAddress2 = inetAddress.getHostAddress()) == null) ? null : hostAddress2.toString();
                            Inet4Address inet4AddressD = a0Var.H != null ? ye.d.d(wifiP2pGroup) : null;
                            String string2 = (inet4AddressD == null || (hostAddress = inet4AddressD.getHostAddress()) == null) ? null : hostAddress.toString();
                            WifiP2pDevice owner = wifiP2pGroup.getOwner();
                            String networkName = wifiP2pGroup.getNetworkName();
                            Iterator it = a0Var.u.entrySet().iterator();
                            do {
                                if (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    bluetoothDevice = ((g2) entry.getValue()).f9743a;
                                } else {
                                    bluetoothDevice = null;
                                }
                                if (bluetoothDevice != null) {
                                    LinkedHashMap linkedHashMap = a0Var.f4048v;
                                    String str = owner.deviceAddress;
                                    Intrinsics.checkNotNull(owner);
                                    i2 i2Var = a0Var.G;
                                    linkedHashMap.put(str, new h2(bluetoothDevice, owner, i2Var != null ? i2Var.f9797g : null));
                                }
                                Intrinsics.checkNotNull(owner);
                                com.welink.protocol.nfbd.a0.k(a0Var, string, string2, owner, networkName, wifiP2pGroup);
                            } while (bluetoothDevice == null);
                            if (bluetoothDevice != null) {
                                LinkedHashMap linkedHashMap2 = a0Var.f4048v;
                                String str2 = owner.deviceAddress;
                                Intrinsics.checkNotNull(owner);
                                i2 i2Var2 = a0Var.G;
                                linkedHashMap2.put(str2, new h2(bluetoothDevice, owner, i2Var2 != null ? i2Var2.f9797g : null));
                            }
                            Intrinsics.checkNotNull(owner);
                            com.welink.protocol.nfbd.a0.k(a0Var, string, string2, owner, networkName, wifiP2pGroup);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            default:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.b0 b0Var = (com.welink.protocol.nfbd.b0) this.f9758b;
                synchronized (b0Var) {
                    try {
                        int i8 = com.welink.protocol.nfbd.b0.Q;
                        we.h.h("TranFileSendController", "onNotifyConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                        if (wifiP2pGroup == null || wifiP2pGroup.isGroupOwner() || wifiP2pInfo == null || !wifiP2pInfo.groupFormed) {
                            we.h.h("TranFileSendController", "onNotifyConnected failed: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                        } else {
                            InetAddress inetAddress2 = wifiP2pInfo.groupOwnerAddress;
                            String string3 = (inetAddress2 == null || (hostAddress3 = inetAddress2.getHostAddress()) == null) ? null : hostAddress3.toString();
                            WifiP2pDevice owner2 = wifiP2pGroup.getOwner();
                            String networkName2 = wifiP2pGroup.getNetworkName();
                            Iterator it2 = b0Var.f4056h.entrySet().iterator();
                            do {
                                if (it2.hasNext()) {
                                    Map.Entry entry2 = (Map.Entry) it2.next();
                                    bluetoothDevice2 = ((g2) entry2.getValue()).f9743a;
                                } else {
                                    bluetoothDevice2 = null;
                                }
                                if (bluetoothDevice2 != null) {
                                    LinkedHashMap linkedHashMap3 = b0Var.f4055g;
                                    String str3 = owner2.deviceAddress;
                                    Intrinsics.checkNotNull(owner2);
                                    i2 i2Var3 = b0Var.f4067v;
                                    linkedHashMap3.put(str3, new h2(bluetoothDevice2, owner2, i2Var3 != null ? i2Var3.f9797g : null));
                                }
                                Intrinsics.checkNotNull(owner2);
                                com.welink.protocol.nfbd.b0.j(b0Var, string3, owner2, networkName2, wifiP2pGroup);
                            } while (bluetoothDevice2 == null);
                            if (bluetoothDevice2 != null) {
                                LinkedHashMap linkedHashMap4 = b0Var.f4055g;
                                String str4 = owner2.deviceAddress;
                                Intrinsics.checkNotNull(owner2);
                                i2 i2Var4 = b0Var.f4067v;
                                linkedHashMap4.put(str4, new h2(bluetoothDevice2, owner2, i2Var4 != null ? i2Var4.f9797g : null));
                            }
                            Intrinsics.checkNotNull(owner2);
                            com.welink.protocol.nfbd.b0.j(b0Var, string3, owner2, networkName2, wifiP2pGroup);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
        }
    }

    @Override // se.b4
    public final void g() {
        Object obj = this.f9758b;
        switch (this.f9757a) {
            case 0:
                we.h.b("NearConnectionService", "onResetRecoveryState");
                break;
            case 1:
                we.h.h("TranFileReceiveController", "onResetRecoveryState");
                com.welink.protocol.nfbd.a0 a0Var = (com.welink.protocol.nfbd.a0) obj;
                if (a0Var.D) {
                    a0Var.D = false;
                    we.h.h("TranFileReceiveController", "onResetRecoveryState: P2p direct recovering reset");
                }
                break;
            default:
                int i8 = com.welink.protocol.nfbd.b0.Q;
                we.h.h("TranFileSendController", "onResetRecoveryState");
                com.welink.protocol.nfbd.b0 b0Var = (com.welink.protocol.nfbd.b0) obj;
                if (b0Var.f4065s) {
                    b0Var.f4065s = false;
                    we.h.h("TranFileSendController", "onResetRecoveryState: P2p direct recovering reset");
                }
                break;
        }
    }

    @Override // se.b4
    public final void h(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        switch (this.f9757a) {
            case 0:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.g.b((com.welink.protocol.nfbd.g) this.f9758b, wifiP2pGroup, wifiP2pInfo, clientList);
                return;
            case 1:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.a0 a0Var = (com.welink.protocol.nfbd.a0) this.f9758b;
                synchronized (a0Var) {
                    try {
                        we.h.h("TranFileReceiveController", "onNotifyOtherDeviceConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                        Iterator it = a0Var.A.iterator();
                        while (it.hasNext()) {
                            ((w) it.next()).k(wifiP2pGroup, wifiP2pInfo, clientList);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                we.h.h("TranFileReceiveController", "onNotifyOtherDeviceConnected: " + clientList);
                return;
            default:
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.b0 b0Var = (com.welink.protocol.nfbd.b0) this.f9758b;
                synchronized (b0Var) {
                    try {
                        int i8 = com.welink.protocol.nfbd.b0.Q;
                        we.h.h("TranFileSendController", "onNotifyOtherDeviceConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                        Iterator it2 = b0Var.p.iterator();
                        while (it2.hasNext()) {
                            ((w) it2.next()).k(wifiP2pGroup, wifiP2pInfo, clientList);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                int i9 = com.welink.protocol.nfbd.b0.Q;
                we.h.h("TranFileSendController", "onNotifyOtherDeviceConnected: " + clientList);
                return;
        }
    }

    @Override // se.b4
    public final void i() {
        switch (this.f9757a) {
            case 0:
                we.h.b("NearConnectionService", "onNotifyConnectionSuccess");
                break;
            case 1:
                we.h.h("TranFileReceiveController", "onNotifyConnectionSuccess");
                break;
            default:
                int i8 = com.welink.protocol.nfbd.b0.Q;
                we.h.h("TranFileSendController", "onNotifyConnectionSuccess");
                break;
        }
    }
}
