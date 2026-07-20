package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.lb;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.f f9947a;

    public q0(com.welink.protocol.nfbd.f fVar) {
        this.f9947a = fVar;
    }

    @Override // se.b4
    public final void a(int i8) {
        h4.q.getClass();
        we.h.h("NearBluetoothServer", "onNotifyRemoveGroupSuccess: moduleId: ".concat(u0.c(i8)));
        com.welink.protocol.nfbd.f fVar = this.f9947a;
        if (fVar.f4110o) {
            we.h.j("NearBluetoothServer", "onNotifyRemoveGroupSuccess: mP2pDirectRecovering ignore");
            return;
        }
        if (i8 != 320098820) {
            h4 h4Var = fVar.f4100c;
            we.h.h("NearBluetoothServer", "onNotifyRemoveGroupSuccess: tryCancelSuspendP2pConnectTimer: " + (h4Var != null ? Boolean.valueOf(h4Var.H(320098820, "NearBluetoothServer")) : null));
        }
    }

    @Override // se.b4
    public final void b(boolean z2, int i8, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice) {
        we.h.h("NearBluetoothServer", "onNotifyDisconnected: isSelf: " + z2 + ", reasonCode: " + i8 + ", device: " + bluetoothDevice + ", p2pOwnerDevice: " + wifiP2pDevice + ", nearDevice: " + nearDevice);
        com.welink.protocol.nfbd.f fVar = this.f9947a;
        synchronized (fVar) {
            try {
                if (!fVar.f4103h.isEmpty()) {
                    for (Map.Entry entry : fVar.f4103h.entrySet()) {
                        h2 h2Var = (h2) entry.getValue();
                        Iterator it = fVar.f.iterator();
                        while (it.hasNext()) {
                            ((a0) it.next()).e(h2Var.f9759a, h2Var.f9760b, z2, h2Var.f9761c);
                        }
                    }
                    fVar.f4103h.clear();
                } else if (!fVar.f4104i.isEmpty()) {
                    Iterator it2 = fVar.f4104i.entrySet().iterator();
                    while (it2.hasNext()) {
                        z1 z1Var = (z1) ((Map.Entry) it2.next()).getValue();
                        for (a0 a0Var : fVar.f) {
                            BluetoothDevice bluetoothDevice2 = z1Var.f10077a;
                            Object obj = z1Var.f10078b.get(0);
                            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                            a0Var.e(bluetoothDevice2, (WifiP2pDevice) obj, z2, z1Var.f10079c);
                        }
                    }
                    fVar.f4104i.clear();
                } else if (!fVar.f4102g.isEmpty()) {
                    for (Map.Entry entry2 : fVar.f4102g.entrySet()) {
                        g2 g2Var = (g2) entry2.getValue();
                        if (fVar.f4109n.contains(g2Var.f9743a)) {
                            if (i8 == 104) {
                                if (fVar.f4110o) {
                                    we.h.j("NearBluetoothServer", "P2P GO occupy from other, wait for timeout");
                                    return;
                                }
                                we.h.b("NearBluetoothServer", "P2P GO connect group removed, try check running timer");
                                h4 h4Var = fVar.f4100c;
                                if (h4Var != null && h4Var.l()) {
                                    we.h.h("NearBluetoothServer", "P2P GO connect timer will be cancelled");
                                    return;
                                }
                            } else if (i8 != 107) {
                                switch (i8) {
                                    case 100:
                                        if (fVar.f4110o) {
                                            we.h.j("NearBluetoothServer", "P2P connect recovery 3, wait for timeout");
                                            return;
                                        }
                                        we.h.b("NearBluetoothServer", "P2P connect timeout, report to upper layer");
                                        break;
                                    case 101:
                                        we.h.b("NearBluetoothServer", "P2P connect failed, report to upper layer");
                                        break;
                                    case 102:
                                        we.h.j("NearBluetoothServer", "P2P connect recovery, wait for timeout");
                                        return;
                                    default:
                                        if (fVar.f4110o) {
                                            we.h.j("NearBluetoothServer", "P2P connect recovery 2, wait for timeout");
                                            return;
                                        }
                                        we.h.b("NearBluetoothServer", "P2P connect internal failed, report to upper layer");
                                        break;
                                }
                            } else {
                                if (fVar.f4110o) {
                                    we.h.j("NearBluetoothServer", "P2P GC occupy from other, wait for timeout");
                                    return;
                                }
                                we.h.b("NearBluetoothServer", "P2P connect occupied by other(GO), report to upper layer");
                            }
                            for (a0 a0Var2 : fVar.f) {
                                BluetoothDevice bluetoothDevice3 = g2Var.f9743a;
                                i2 i2Var = fVar.f4107l;
                                a0Var2.g(i8, bluetoothDevice3, i2Var != null ? i2Var.f9797g : null);
                            }
                            pe.d dVar = fVar.e;
                            if (dVar != null) {
                                dVar.n(g2Var.f9743a);
                            }
                        }
                    }
                    fVar.f4102g.clear();
                } else if (fVar.f4105j.isEmpty()) {
                    we.h.j("NearBluetoothServer", "Nothing Done");
                } else {
                    if (i8 == 100) {
                        if (fVar.f4110o) {
                            we.h.j("NearBluetoothServer", "P2P GO connect recovery 3, wait for timeout");
                            return;
                        }
                        we.h.b("NearBluetoothServer", "P2P GO connect timeout, report to upper layer");
                    } else if (i8 == 101) {
                        we.h.b("NearBluetoothServer", "P2P GO connect failed, report to upper layer");
                    } else {
                        if (i8 == 103) {
                            we.h.j("NearBluetoothServer", "P2P GO connect recovery, wait for timeout");
                            return;
                        }
                        if (i8 == 104) {
                            if (fVar.f4110o) {
                                we.h.j("NearBluetoothServer", "P2P GO occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("NearBluetoothServer", "P2P GO connect group removed, try check running timer");
                            h4 h4Var2 = fVar.f4100c;
                            if (h4Var2 != null && h4Var2.l()) {
                                we.h.h("NearBluetoothServer", "P2P GO connect timer will be cancelled");
                                return;
                            }
                        } else if (i8 != 107) {
                            if (fVar.f4110o) {
                                we.h.j("NearBluetoothServer", "P2P GO connect recovery 2, wait for timeout");
                                return;
                            }
                            we.h.b("NearBluetoothServer", "P2P GO connect internal failed, report to upper layer");
                        } else {
                            if (fVar.f4110o) {
                                we.h.j("NearBluetoothServer", "P2P GO occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("NearBluetoothServer", "P2P connect occupied by other(GO), report to upper layer");
                        }
                    }
                    Iterator it3 = fVar.f4105j.entrySet().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Map) ((Map.Entry) it3.next()).getValue()).entrySet().iterator();
                        while (it4.hasNext()) {
                            BluetoothDevice bluetoothDevice4 = (BluetoothDevice) ((Map.Entry) it4.next()).getKey();
                            pe.d dVar2 = fVar.e;
                            if (dVar2 != null) {
                                dVar2.n(bluetoothDevice4);
                            }
                        }
                    }
                    fVar.f4105j.clear();
                    for (a0 a0Var3 : fVar.f) {
                        if (wifiP2pDevice != null) {
                            a0Var3.e(bluetoothDevice, wifiP2pDevice, z2, nearDevice);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void c(WifiP2pGroup wifiP2pGroupInfo, WifiP2pInfo wifiP2pInfo) {
        Map.Entry entry;
        InetAddress inetAddress;
        Intrinsics.checkNotNullParameter(wifiP2pGroupInfo, "wifiP2pGroupInfo");
        String networkName = wifiP2pGroupInfo.getNetworkName();
        String passphrase = wifiP2pGroupInfo.getPassphrase();
        int frequency = wifiP2pGroupInfo.getFrequency();
        WifiP2pDevice owner = wifiP2pGroupInfo.getOwner();
        String strValueOf = String.valueOf((wifiP2pInfo == null || (inetAddress = wifiP2pInfo.groupOwnerAddress) == null) ? null : inetAddress.getHostAddress());
        StringBuilder sbP = h0.a.p("Group Owner Created: GO SSID:", networkName, ", Password:", passphrase, ", Freq:");
        sbP.append(frequency);
        sbP.append(", GO IP address:");
        sbP.append(strValueOf);
        sbP.append(", GO MAC address:");
        sbP.append(owner);
        we.h.b("NearBluetoothServer", sbP.toString());
        com.welink.protocol.nfbd.f fVar = this.f9947a;
        if (fVar.f4105j.isEmpty()) {
            Intrinsics.checkNotNull(networkName);
            Intrinsics.checkNotNull(passphrase);
            Intrinsics.checkNotNull(owner);
            com.welink.protocol.nfbd.f.l(this.f9947a, null, null, strValueOf, networkName, passphrase, frequency, owner);
            return;
        }
        Iterator it = fVar.f4105j.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                entry = null;
                break;
            }
            entry = (Map.Entry) it.next();
        } while (entry == null);
        if (entry == null) {
            Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
            Intrinsics.checkNotNullParameter("mPendingCreateGroupOwnerRequest is empty", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearBluetoothServer", "TransConnect:mPendingCreateGroupOwnerRequest is empty", null);
                return;
            }
            return;
        }
        Map map = (Map) entry.getValue();
        BluetoothDevice bluetoothDevice = (BluetoothDevice) CollectionsKt.first(map.keySet());
        NearDevice nearDevice = (NearDevice) CollectionsKt.first(map.values());
        Intrinsics.checkNotNull(networkName);
        Intrinsics.checkNotNull(passphrase);
        Intrinsics.checkNotNull(owner);
        com.welink.protocol.nfbd.f.l(this.f9947a, bluetoothDevice, nearDevice, strValueOf, networkName, passphrase, frequency, owner);
    }

    @Override // se.b4
    public final void d() {
        we.h.h("NearBluetoothServer", "onNotifyCreateGroupSuccess");
    }

    @Override // se.b4
    public final void e() {
        com.welink.protocol.nfbd.f fVar = this.f9947a;
        synchronized (fVar) {
            try {
                Iterator it = fVar.f4105j.entrySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Map) ((Map.Entry) it.next()).getValue()).entrySet().iterator();
                    while (it2.hasNext()) {
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) ((Map.Entry) it2.next()).getKey();
                        pe.d dVar = fVar.e;
                        if (dVar != null) {
                            dVar.n(bluetoothDevice);
                        }
                    }
                }
                fVar.f4105j.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void f(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        BluetoothDevice bluetoothDevice;
        String hostAddress;
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        com.welink.protocol.nfbd.f fVar = this.f9947a;
        synchronized (fVar) {
            try {
                we.h.h("NearBluetoothServer", "onNotifyConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                String string = null;
                if (wifiP2pGroup != null && !wifiP2pGroup.isGroupOwner() && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    String hostAddress2 = wifiP2pInfo.groupOwnerAddress.getHostAddress();
                    String string2 = hostAddress2 != null ? hostAddress2.toString() : null;
                    Inet4Address inet4AddressD = fVar.f4106k != null ? ye.d.d(wifiP2pGroup) : null;
                    String string3 = (inet4AddressD == null || (hostAddress = inet4AddressD.getHostAddress()) == null) ? null : hostAddress.toString();
                    WifiP2pDevice owner = wifiP2pGroup.getOwner();
                    String networkName = wifiP2pGroup.getNetworkName();
                    Iterator it = fVar.f4102g.entrySet().iterator();
                    do {
                        if (!it.hasNext()) {
                            bluetoothDevice = null;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        g2 g2Var = (g2) entry.getValue();
                        if (!fVar.f4109n.contains(g2Var.f9743a)) {
                            we.h.h("NearBluetoothServer", "Connected Bluetooth Device was not found, disconnected earlier?");
                        }
                        bluetoothDevice = g2Var.f9743a;
                    } while (bluetoothDevice == null);
                    if (bluetoothDevice != null) {
                        LinkedHashMap linkedHashMap = fVar.f4103h;
                        String str = owner.deviceAddress;
                        Intrinsics.checkNotNull(owner);
                        i2 i2Var = fVar.f4107l;
                        linkedHashMap.put(str, new h2(bluetoothDevice, owner, i2Var != null ? i2Var.f9797g : null));
                    }
                    Intrinsics.checkNotNull(owner);
                    com.welink.protocol.nfbd.f.j(fVar, string2, string3, owner, networkName);
                } else if (wifiP2pGroup == null && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    InetAddress inetAddress = wifiP2pInfo.groupOwnerAddress;
                    if (inetAddress != null) {
                        String hostAddress3 = inetAddress.getHostAddress();
                        string = hostAddress3 != null ? hostAddress3.toString() : null;
                        we.h.h("NearBluetoothServer", "onConnected: GO Addr:" + ((Object) string));
                    }
                    Iterator it2 = clientList.iterator();
                    while (it2.hasNext()) {
                        WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) it2.next();
                        we.h.h("NearBluetoothServer", "onConnected clientList: Client Addr:" + wifiP2pDevice.deviceAddress.toString());
                        com.welink.protocol.nfbd.f.k(fVar, wifiP2pDevice, string == null ? "192.168.49.1" : string);
                    }
                } else {
                    we.h.h("NearBluetoothServer", "onNotifyConnected failed: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void g() {
        we.h.h("NearBluetoothServer", "onResetRecoveryState");
        com.welink.protocol.nfbd.f fVar = this.f9947a;
        if (fVar.f4110o) {
            fVar.f4110o = false;
            we.h.h("NearBluetoothServer", "onResetRecoveryState: P2p direct recovering reset");
        }
    }

    @Override // se.b4
    public final void h(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        we.h.b("NearBluetoothServer", "onNotifyOtherDeviceConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
        com.welink.protocol.nfbd.f fVar = this.f9947a;
        synchronized (fVar) {
            try {
                Iterator it = fVar.f.iterator();
                while (it.hasNext()) {
                    ((a0) it.next()).j(clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void i() {
        we.h.h("NearBluetoothServer", "onNotifyConnectionSuccess");
    }
}
