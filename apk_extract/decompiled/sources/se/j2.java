package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattServer;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Build;
import android.util.Log;
import com.transsion.iotcardsdk.bean.DeviceType;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j2 implements b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.l f9831a;

    public j2(com.welink.protocol.nfbd.l lVar) {
        this.f9831a = lVar;
    }

    @Override // se.b4
    public final void a(int i8) {
        h4.q.getClass();
        we.h.h("NearGattService", "onNotifyRemoveGroupSuccess: moduleId: ".concat(u0.c(i8)));
        com.welink.protocol.nfbd.l lVar = this.f9831a;
        if (lVar.u) {
            we.h.j("NearGattService", "onNotifyRemoveGroupSuccess: mP2pDirectRecovering ignore");
            return;
        }
        if (i8 != 320098818) {
            h4 h4Var = lVar.f4164t;
            we.h.h("NearGattService", "onNotifyRemoveGroupSuccess: tryCancelSuspendP2pConnectTimer: " + (h4Var != null ? Boolean.valueOf(h4Var.H(320098818, "NearGattService")) : null));
        }
    }

    @Override // se.b4
    public final void b(boolean z2, int i8, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice) {
        we.h.h("NearGattService", "onNotifyDisconnected: isSelf: " + z2 + ", reasonCode: " + i8 + ", device: " + bluetoothDevice + ", p2pOwnerDevice: " + wifiP2pDevice + ", nearDevice: " + nearDevice);
        com.welink.protocol.nfbd.l lVar = this.f9831a;
        synchronized (lVar) {
            try {
                if (!lVar.f4159m.isEmpty()) {
                    for (Map.Entry entry : lVar.f4159m.entrySet()) {
                        h2 h2Var = (h2) entry.getValue();
                        Iterator it = lVar.f4157k.iterator();
                        while (it.hasNext()) {
                            ((a0) it.next()).e(h2Var.f9759a, h2Var.f9760b, z2, h2Var.f9761c);
                        }
                    }
                    lVar.f4159m.clear();
                } else if (!lVar.f4160n.isEmpty()) {
                    Iterator it2 = lVar.f4160n.entrySet().iterator();
                    while (it2.hasNext()) {
                        z1 z1Var = (z1) ((Map.Entry) it2.next()).getValue();
                        for (a0 a0Var : lVar.f4157k) {
                            BluetoothDevice bluetoothDevice2 = z1Var.f10077a;
                            Object obj = z1Var.f10078b.get(0);
                            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                            a0Var.e(bluetoothDevice2, (WifiP2pDevice) obj, z2, z1Var.f10079c);
                        }
                    }
                    lVar.f4160n.clear();
                } else if (!lVar.f4158l.isEmpty()) {
                    for (Map.Entry entry2 : lVar.f4158l.entrySet()) {
                        g2 g2Var = (g2) entry2.getValue();
                        if (lVar.f4155i.contains(g2Var.f9743a)) {
                            we.h.j("NearGattService", "P2P connect failed, Bluetooth connected?))");
                        } else {
                            we.h.j("NearGattService", "P2P connect failed, Bluetooth disconnected?))");
                        }
                        if (i8 != 100) {
                            if (i8 == 102) {
                                we.h.b("NearGattService", "P2P connect client recovery, wait for timeout");
                                return;
                            }
                            if (i8 == 104) {
                                if (lVar.u) {
                                    we.h.j("NearGattService", "P2P GC occupy from other, wait for timeout");
                                    return;
                                }
                                we.h.b("NearGattService", "P2P GC connect group removed, try check running timer");
                                h4 h4Var = lVar.f4164t;
                                if (h4Var != null && h4Var.l()) {
                                    we.h.h("NearGattService", "P2P GC connect timer will be cancelled");
                                    return;
                                }
                            } else if (i8 != 107) {
                                if (lVar.u) {
                                    we.h.j("NearGattService", "P2P GC connect recovery 2, wait for timeout");
                                    return;
                                }
                                we.h.b("NearGattService", "P2P connect internal failed, report to upper layer");
                            } else {
                                if (lVar.u) {
                                    we.h.j("NearGattService", "P2P GC occupy from other, wait for timeout");
                                    return;
                                }
                                we.h.b("NearGattService", "P2P connect occupied by other(GO), report to upper layer");
                            }
                        } else {
                            if (lVar.u) {
                                we.h.j("NearGattService", "P2P GC connect recovery 3, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattService", "P2P connect timeout, report to upper layer");
                        }
                        for (a0 a0Var2 : lVar.f4157k) {
                            BluetoothDevice bluetoothDevice3 = g2Var.f9743a;
                            i2 i2Var = lVar.f4162r;
                            a0Var2.g(i8, bluetoothDevice3, i2Var != null ? i2Var.f9797g : null);
                        }
                        BluetoothGattServer bluetoothGattServer = lVar.e;
                        if (bluetoothGattServer != null) {
                            bluetoothGattServer.cancelConnection(g2Var.f9743a);
                        }
                    }
                    lVar.f4158l.clear();
                } else if (lVar.f4161o.isEmpty()) {
                    we.h.j("NearGattService", "Nothing Done");
                } else {
                    switch (i8) {
                        case 100:
                            if (lVar.u) {
                                we.h.j("NearGattService", "P2P GO connect recovery 3, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattService", "P2P GO connect timeout, report to upper layer");
                            break;
                        case 101:
                            we.h.b("NearGattService", "P2P GO connect failed, report to upper layer");
                            break;
                        case 102:
                        default:
                            if (lVar.u) {
                                we.h.j("NearGattService", "P2P GO connect recovery 2, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattService", "P2P GO connect internal failed, report to upper layer");
                            break;
                        case DeviceType.INFRARED_TV_BOX /* 103 */:
                            we.h.j("NearGattService", "P2P GO connect recovery, wait for timeout");
                            return;
                        case 104:
                            if (lVar.u) {
                                we.h.j("NearGattService", "P2P GO occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattService", "P2P GO connect group removed, try check running timer");
                            h4 h4Var2 = lVar.f4164t;
                            if (h4Var2 != null && h4Var2.l()) {
                                we.h.h("NearGattService", "P2P GO connect timer will be cancelled");
                                return;
                            }
                            break;
                        case DeviceType.INFRARED_AIR_CONDITION /* 105 */:
                            we.h.b("NearGattService", "P2P GO connect permission reject, report to upper layer");
                            break;
                        case DeviceType.INFRARED_PROJECTOR /* 106 */:
                            we.h.b("NearGattService", "P2P GO connect cancel by user, report to upper layer");
                            break;
                        case DeviceType.INFRARED_AMPLIFIER /* 107 */:
                            if (lVar.u) {
                                we.h.j("NearGattService", "P2P GO occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattService", "P2P connect occupied by other(GO), report to upper layer");
                            break;
                    }
                    Iterator it3 = lVar.f4161o.entrySet().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Map) ((Map.Entry) it3.next()).getValue()).entrySet().iterator();
                        while (it4.hasNext()) {
                            BluetoothDevice bluetoothDevice4 = (BluetoothDevice) ((Map.Entry) it4.next()).getKey();
                            BluetoothGattServer bluetoothGattServer2 = lVar.e;
                            if (bluetoothGattServer2 != null) {
                                bluetoothGattServer2.cancelConnection(bluetoothDevice4);
                            }
                        }
                    }
                    lVar.p.clear();
                    lVar.f4161o.clear();
                    for (a0 a0Var3 : lVar.f4157k) {
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
        Map.Entry entry2 = null;
        String strValueOf = String.valueOf((wifiP2pInfo == null || (inetAddress = wifiP2pInfo.groupOwnerAddress) == null) ? null : inetAddress.getHostAddress());
        wifiP2pGroupInfo.getInterface();
        we.h.b("NearGattService", "Group Owner Created: GO SSID:" + networkName + ", Password:" + passphrase + ", Freq:" + frequency + ", GO IP address:" + strValueOf + ", GO MAC address:" + owner);
        com.welink.protocol.nfbd.l lVar = this.f9831a;
        if (lVar.f4161o.isEmpty()) {
            Intrinsics.checkNotNull(networkName);
            Intrinsics.checkNotNull(passphrase);
            Intrinsics.checkNotNull(owner);
            this.f9831a.y(null, null, strValueOf, networkName, passphrase, frequency, owner);
            return;
        }
        Iterator it = lVar.f4161o.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                entry = null;
                break;
            }
            entry = (Map.Entry) it.next();
        } while (entry == null);
        if (entry == null) {
            Intrinsics.checkNotNullParameter("NearGattService", "tag");
            Intrinsics.checkNotNullParameter("mPendingCreateGroupOwnerRequest is empty", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearGattService", "TransConnect:mPendingCreateGroupOwnerRequest is empty", null);
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
        this.f9831a.y(bluetoothDevice, nearDevice, strValueOf, networkName, passphrase, frequency, owner);
        if (lVar.p.isEmpty()) {
            return;
        }
        for (Map.Entry entry3 : lVar.p.entrySet()) {
            if (entry3 != null) {
                entry2 = entry3;
                break;
            }
        }
        if (entry2 == null || !Intrinsics.areEqual(CollectionsKt.first(((Map) entry2.getValue()).keySet()), bluetoothDevice)) {
            return;
        }
        Map mutableMap = MapsKt.toMutableMap((Map) entry2.getValue());
        mutableMap.put(bluetoothDevice, owner);
        lVar.p.put(entry2.getKey(), mutableMap);
    }

    @Override // se.b4
    public final void d() {
        we.h.h("NearGattService", "onNotifyCreateGroupSuccess");
    }

    @Override // se.b4
    public final void e() {
        com.welink.protocol.nfbd.l lVar = this.f9831a;
        synchronized (lVar) {
            try {
                Iterator it = lVar.f4161o.entrySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Map) ((Map.Entry) it.next()).getValue()).entrySet().iterator();
                    while (it2.hasNext()) {
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) ((Map.Entry) it2.next()).getKey();
                        BluetoothGattServer bluetoothGattServer = lVar.e;
                        if (bluetoothGattServer != null) {
                            bluetoothGattServer.cancelConnection(bluetoothDevice);
                        }
                    }
                }
                lVar.p.clear();
                lVar.f4161o.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void f(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        String string;
        BluetoothDevice bluetoothDevice;
        String hostAddress;
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        com.welink.protocol.nfbd.l lVar = this.f9831a;
        synchronized (lVar) {
            try {
                we.h.h("NearGattService", "onNotifyConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                if (wifiP2pGroup != null && !wifiP2pGroup.isGroupOwner() && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    String hostAddress2 = wifiP2pInfo.groupOwnerAddress.getHostAddress();
                    String string2 = hostAddress2 != null ? hostAddress2.toString() : null;
                    Inet4Address inet4AddressD = lVar.q != null ? ye.d.d(wifiP2pGroup) : null;
                    String string3 = (inet4AddressD == null || (hostAddress = inet4AddressD.getHostAddress()) == null) ? null : hostAddress.toString();
                    WifiP2pDevice owner = wifiP2pGroup.getOwner();
                    String networkName = wifiP2pGroup.getNetworkName();
                    Iterator it = lVar.f4158l.entrySet().iterator();
                    do {
                        if (!it.hasNext()) {
                            bluetoothDevice = null;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        g2 g2Var = (g2) entry.getValue();
                        if (!lVar.f4155i.contains(g2Var.f9743a)) {
                            we.h.h("NearGattService", "Connected Bluetooth Device was not found, disconnected earlier?");
                        }
                        bluetoothDevice = g2Var.f9743a;
                    } while (bluetoothDevice == null);
                    if (bluetoothDevice != null) {
                        LinkedHashMap linkedHashMap = lVar.f4159m;
                        String str = owner.deviceAddress;
                        Intrinsics.checkNotNull(owner);
                        i2 i2Var = lVar.f4162r;
                        linkedHashMap.put(str, new h2(bluetoothDevice, owner, i2Var != null ? i2Var.f9797g : null));
                    }
                    Intrinsics.checkNotNull(owner);
                    lVar.w(string2, string3, owner, networkName);
                } else if (wifiP2pGroup == null && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    InetAddress inetAddress = wifiP2pInfo.groupOwnerAddress;
                    if (inetAddress != null) {
                        String hostAddress3 = inetAddress.getHostAddress();
                        string = hostAddress3 != null ? hostAddress3.toString() : null;
                        we.h.h("NearGattService", "onConnected: GO Addr:" + ((Object) string));
                    } else {
                        string = null;
                    }
                    Iterator it2 = clientList.iterator();
                    while (it2.hasNext()) {
                        WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) it2.next();
                        we.h.h("NearGattService", "onConnected clientList: Client Addr:" + wifiP2pDevice.deviceAddress.toString());
                        if (Build.VERSION.SDK_INT < 35) {
                            lVar.x(wifiP2pDevice, string == null ? "192.168.49.1" : string, null);
                        } else if (wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner) {
                            String str2 = string == null ? "192.168.49.1" : string;
                            InetAddress ipAddress = wifiP2pDevice.getIpAddress();
                            lVar.x(wifiP2pDevice, str2, String.valueOf(ipAddress != null ? ipAddress.getHostAddress() : null));
                        } else {
                            lVar.x(wifiP2pDevice, string == null ? "192.168.49.1" : string, null);
                        }
                    }
                } else {
                    we.h.h("NearGattService", "onNotifyConnected failed: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void g() {
        we.h.h("NearGattService", "onResetRecoveryState");
        com.welink.protocol.nfbd.l lVar = this.f9831a;
        if (lVar.u) {
            lVar.u = false;
            we.h.h("NearGattService", "onResetRecoveryState: reset recovery state");
        }
    }

    @Override // se.b4
    public final void h(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        we.h.b("NearGattService", "onNotifyOtherDeviceConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
        com.welink.protocol.nfbd.l lVar = this.f9831a;
        synchronized (lVar) {
            try {
                Iterator it = lVar.f4157k.iterator();
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
        we.h.h("NearGattService", "onNotifyConnectionSuccess");
    }
}
