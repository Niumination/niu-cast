package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Build;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
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
public final class a2 implements b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.j f9641a;

    public a2(com.welink.protocol.nfbd.j jVar) {
        this.f9641a = jVar;
    }

    @Override // se.b4
    public final void a(int i8) {
        h4.q.getClass();
        we.h.h("NearGattClient", "onNotifyRemoveGroupSuccess: moduleId: ".concat(u0.c(i8)));
        com.welink.protocol.nfbd.j jVar = this.f9641a;
        if (jVar.f4147t) {
            we.h.j("NearGattClient", "onNotifyRemoveGroupSuccess: mP2pDirectRecovering ignore");
            return;
        }
        if (i8 != 320098817) {
            h4 h4Var = jVar.f4146s;
            we.h.h("P2pConnectController", "onNotifyRemoveGroupSuccess: tryCancelSuspendP2pConnectTimer: " + (h4Var != null ? Boolean.valueOf(h4Var.H(320098817, "NearGattClient")) : null));
        }
    }

    @Override // se.b4
    public final void b(boolean z2, int i8, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice) {
        String str;
        we.h.h("NearGattClient", "onNotifyDisconnected: isSelf: " + z2 + ", reasonCode: " + i8 + ", device: " + bluetoothDevice + ", p2pOwnerDevice: " + wifiP2pDevice + ", nearDevice: " + nearDevice);
        com.welink.protocol.nfbd.j jVar = this.f9641a;
        synchronized (jVar) {
            try {
                if (!jVar.f4144o.isEmpty()) {
                    Iterator it = jVar.f4144o.entrySet().iterator();
                    while (it.hasNext()) {
                        z1 z1Var = (z1) ((Map.Entry) it.next()).getValue();
                        Iterator it2 = jVar.f4136g.iterator();
                        while (it2.hasNext()) {
                            ((w) it2.next()).e(z1Var.f10077a, (WifiP2pDevice) z1Var.f10078b.get(0), z2, z1Var.f10079c);
                        }
                    }
                    jVar.f4144o.clear();
                } else if (!jVar.f4141l.isEmpty()) {
                    for (Map.Entry entry : jVar.f4141l.entrySet()) {
                        h2 h2Var = (h2) entry.getValue();
                        Iterator it3 = jVar.f4136g.iterator();
                        while (it3.hasNext()) {
                            ((w) it3.next()).e(h2Var.f9759a, h2Var.f9760b, z2, h2Var.f9761c);
                        }
                    }
                    jVar.f4141l.clear();
                } else if (!jVar.f4140k.isEmpty()) {
                    for (Map.Entry entry2 : jVar.f4140k.entrySet()) {
                        String str2 = (String) entry2.getKey();
                        g2 g2Var = (g2) entry2.getValue();
                        if (jVar.f4137h.contains(g2Var.f9743a)) {
                            we.h.j("NearGattClient", "P2P connect failed, Bluetooth connected?))");
                        } else {
                            we.h.j("NearGattClient", "P2P connect failed, Bluetooth disconnected?))");
                        }
                        if (i8 == 104) {
                            if (jVar.f4147t) {
                                we.h.j("NearGattClient", "P2P GC occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattClient", "P2P GC connect group removed, try check running timer");
                            h4 h4Var = jVar.f4146s;
                            if (h4Var != null && h4Var.l()) {
                                we.h.h("NearGattClient", "P2P GC connect timer will be cancelled");
                                return;
                            }
                        } else if (i8 != 107) {
                            switch (i8) {
                                case 100:
                                    if (jVar.f4147t) {
                                        we.h.j("NearGattClient", "P2P GC connect recovery 3, wait for timeout");
                                        return;
                                    }
                                    we.h.b("NearGattClient", "P2P connect timeout, report to upper layer");
                                    break;
                                case 101:
                                    we.h.b("NearGattClient", "P2P connect failed, report to upper layer");
                                    break;
                                case 102:
                                    we.h.j("NearGattClient", "P2P connect recovery, wait for timeout");
                                    return;
                                default:
                                    if (jVar.f4147t) {
                                        we.h.j("NearGattClient", "P2P GC connect recovery 2, wait for timeout");
                                        return;
                                    }
                                    we.h.b("NearGattClient", "P2P connect internal failed, report to upper layer");
                                    break;
                            }
                        } else {
                            if (jVar.f4147t) {
                                we.h.j("NearGattClient", "P2P GC occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattClient", "P2P connect occupied by other(GO), report to upper layer");
                        }
                        for (w wVar : jVar.f4136g) {
                            BluetoothDevice bluetoothDevice2 = g2Var.f9743a;
                            i2 i2Var = jVar.f4139j;
                            wVar.i(bluetoothDevice2, null, i8, i2Var != null ? i2Var.f9797g : null);
                        }
                        x1 x1Var = (x1) jVar.f4134c.get(str2);
                        if (x1Var != null) {
                            we.h.b("NearGattClient", "P2P connect timeout, close the connection");
                            x1Var.f10056b.disconnect();
                        }
                    }
                    jVar.f4140k.clear();
                    jVar.f4148v = null;
                } else if (jVar.f4142m.isEmpty()) {
                    we.h.j("NearGattClient", "Nothing Done");
                } else {
                    Iterator it4 = jVar.f4142m.entrySet().iterator();
                    do {
                        if (!it4.hasNext()) {
                            str = null;
                            break;
                        }
                        str = (String) ((Map.Entry) it4.next()).getKey();
                    } while (str == null);
                    x1 x1Var2 = (x1) jVar.f4134c.get(str);
                    BluetoothDevice bluetoothDevice3 = x1Var2 != null ? x1Var2.f10055a : null;
                    if (i8 == 100) {
                        if (jVar.f4147t) {
                            we.h.j("NearGattClient", "P2P GO connect recovery 3, wait for timeout");
                            return;
                        }
                        we.h.b("NearGattClient", "P2P GO connect timeout, report to upper layer");
                    } else if (i8 == 101) {
                        we.h.b("NearGattClient", "P2P GO connect failed, report to upper layer");
                    } else {
                        if (i8 == 103) {
                            we.h.j("NearGattClient", "P2P GO connect recovery, wait for timeout");
                            return;
                        }
                        if (i8 == 104) {
                            if (jVar.f4147t) {
                                we.h.j("NearGattClient", "P2P GO occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattClient", "P2P GO connect group removed, try check running timer");
                            h4 h4Var2 = jVar.f4146s;
                            if (h4Var2 != null && h4Var2.l()) {
                                we.h.h("NearGattClient", "P2P GO connect timer will be cancelled");
                                return;
                            }
                        } else if (i8 != 107) {
                            if (jVar.f4147t) {
                                we.h.j("NearGattClient", "P2P GO connect recovery 2, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattClient", "P2P GO connect internal failed, report to upper layer");
                        } else {
                            if (jVar.f4147t) {
                                we.h.j("NearGattClient", "P2P GO occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("NearGattClient", "P2P connect occupied by other(GO), report to upper layer");
                        }
                    }
                    if (bluetoothDevice3 != null && jVar.f4134c.get(bluetoothDevice3.getAddress()) != null) {
                        if (nearDevice != null) {
                            nearDevice.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
                        }
                        x1 x1Var3 = (x1) jVar.f4134c.get(bluetoothDevice3.getAddress());
                        if (x1Var3 != null) {
                            x1Var3.f10056b.disconnect();
                        }
                    }
                    jVar.f4143n.clear();
                    jVar.f4142m.clear();
                    jVar.f4148v = null;
                    for (w wVar2 : jVar.f4136g) {
                        if (wifiP2pDevice != null) {
                            wVar2.e(bluetoothDevice, wifiP2pDevice, z2, nearDevice);
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
        StringBuilder sbP = h0.a.p("onNotifyGroupOwnerAvailable: ssid: ", networkName, ", password: ", passphrase, ", freq: ");
        sbP.append(frequency);
        sbP.append(", ownerDevice: ");
        sbP.append(owner);
        sbP.append(", goHostAddress: ");
        sbP.append(strValueOf);
        we.h.h("NearGattClient", sbP.toString());
        com.welink.protocol.nfbd.j jVar = this.f9641a;
        if (jVar.f4142m.isEmpty()) {
            Intrinsics.checkNotNull(networkName);
            Intrinsics.checkNotNull(passphrase);
            Intrinsics.checkNotNull(owner);
            this.f9641a.x(strValueOf, networkName, passphrase, frequency, owner);
            return;
        }
        Iterator it = jVar.f4142m.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                entry = null;
                break;
            }
            entry = (Map.Entry) it.next();
        } while (entry == null);
        if (entry == null) {
            Intrinsics.checkNotNullParameter("NearGattClient", "tag");
            Intrinsics.checkNotNullParameter("mPendingCreateGroupOwnerRequest is empty", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearGattClient", "TransConnect:mPendingCreateGroupOwnerRequest is empty", null);
                return;
            }
            return;
        }
        Map map = (Map) entry.getValue();
        BluetoothGatt bluetoothGatt = (BluetoothGatt) CollectionsKt.first(map.keySet());
        Intrinsics.checkNotNull(networkName);
        Intrinsics.checkNotNull(passphrase);
        Intrinsics.checkNotNull(owner);
        this.f9641a.x(strValueOf, networkName, passphrase, frequency, owner);
        if (jVar.f4143n.isEmpty()) {
            return;
        }
        for (Map.Entry entry3 : jVar.f4143n.entrySet()) {
            if (entry3 != null) {
                entry2 = entry3;
                break;
            }
        }
        if (entry2 == null || !Intrinsics.areEqual(((BluetoothGatt) CollectionsKt.first(((Map) entry2.getValue()).keySet())).getDevice(), bluetoothGatt.getDevice())) {
            return;
        }
        Map mutableMap = MapsKt.toMutableMap((Map) entry2.getValue());
        mutableMap.put(bluetoothGatt, owner);
        jVar.f4143n.put(entry2.getKey(), mutableMap);
    }

    @Override // se.b4
    public final void d() {
        we.h.h("NearGattClient", "onNotifyCreateGroupSuccess");
    }

    @Override // se.b4
    public final void e() {
        com.welink.protocol.nfbd.j jVar = this.f9641a;
        synchronized (jVar) {
            try {
                we.h.h("NearGattClient", "onNotifyCreateGroupFailed");
                Iterator it = jVar.f4142m.entrySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Map) ((Map.Entry) it.next()).getValue()).entrySet().iterator();
                    while (it2.hasNext()) {
                        ((BluetoothGatt) ((Map.Entry) it2.next()).getKey()).disconnect();
                    }
                }
                jVar.f4143n.clear();
                jVar.f4142m.clear();
                jVar.f4148v = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void f(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        String hostAddress;
        BluetoothDevice bluetoothDevice;
        String hostAddress2;
        String hostAddress3;
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        com.welink.protocol.nfbd.j jVar = this.f9641a;
        synchronized (jVar) {
            try {
                we.h.h("NearGattClient", "onNotifyConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                if (wifiP2pGroup != null && !wifiP2pGroup.isGroupOwner() && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    InetAddress inetAddress = wifiP2pInfo.groupOwnerAddress;
                    String string = (inetAddress == null || (hostAddress3 = inetAddress.getHostAddress()) == null) ? null : hostAddress3.toString();
                    Inet4Address inet4AddressD = jVar.f4138i != null ? ye.d.d(wifiP2pGroup) : null;
                    String string2 = (inet4AddressD == null || (hostAddress2 = inet4AddressD.getHostAddress()) == null) ? null : hostAddress2.toString();
                    WifiP2pDevice owner = wifiP2pGroup.getOwner();
                    String networkName = wifiP2pGroup.getNetworkName();
                    com.welink.protocol.nfbd.j.j(jVar);
                    Iterator it = jVar.f4140k.entrySet().iterator();
                    do {
                        if (!it.hasNext()) {
                            bluetoothDevice = null;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        g2 g2Var = (g2) entry.getValue();
                        bluetoothDevice = jVar.f4137h.contains(g2Var.f9743a) ? g2Var.f9743a : null;
                    } while (bluetoothDevice == null);
                    if (bluetoothDevice != null) {
                        LinkedHashMap linkedHashMap = jVar.f4141l;
                        String str = owner.deviceAddress;
                        Intrinsics.checkNotNull(owner);
                        i2 i2Var = jVar.f4139j;
                        linkedHashMap.put(str, new h2(bluetoothDevice, owner, i2Var != null ? i2Var.f9797g : null));
                    }
                    Intrinsics.checkNotNull(owner);
                    jVar.v(string, string2, owner, networkName);
                } else if (wifiP2pGroup == null && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    com.welink.protocol.nfbd.j.j(jVar);
                    InetAddress inetAddress2 = wifiP2pInfo.groupOwnerAddress;
                    String string3 = (inetAddress2 == null || (hostAddress = inetAddress2.getHostAddress()) == null) ? null : hostAddress.toString();
                    Iterator it2 = clientList.iterator();
                    while (it2.hasNext()) {
                        WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) it2.next();
                        we.h.h("NearGattClient", "onConnected clientList: Client address:" + wifiP2pDevice.deviceAddress.toString());
                        if (Build.VERSION.SDK_INT < 35) {
                            jVar.w(wifiP2pDevice, string3 == null ? "192.168.49.1" : string3, null);
                        } else if (wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner) {
                            String str2 = string3 == null ? "192.168.49.1" : string3;
                            InetAddress ipAddress = wifiP2pDevice.getIpAddress();
                            jVar.w(wifiP2pDevice, str2, String.valueOf(ipAddress != null ? ipAddress.getHostAddress() : null));
                        } else {
                            jVar.w(wifiP2pDevice, string3 == null ? "192.168.49.1" : string3, null);
                        }
                    }
                } else {
                    we.h.h("NearGattClient", "onNotifyConnected failed: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void g() {
        we.h.h("NearGattClient", "onResetRecoveryState");
        com.welink.protocol.nfbd.j jVar = this.f9641a;
        if (jVar.f4147t) {
            jVar.f4147t = false;
            we.h.h("NearGattClient", "onResetRecoveryState, P2p direct recovering reset");
        }
    }

    @Override // se.b4
    public final void h(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        com.welink.protocol.nfbd.j jVar = this.f9641a;
        synchronized (jVar) {
            try {
                we.h.h("NearGattClient", "onNotifyOtherDeviceConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                Iterator it = jVar.f4136g.iterator();
                while (it.hasNext()) {
                    ((w) it.next()).k(wifiP2pGroup, wifiP2pInfo, clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        we.h.h("NearGattClient", "onNotifyOtherDeviceConnected: " + clientList);
    }

    @Override // se.b4
    public final void i() {
        we.h.h("NearGattClient", "onNotifyConnectionSuccess");
        com.welink.protocol.nfbd.j.j(this.f9641a);
    }
}
