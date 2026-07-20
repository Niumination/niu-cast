package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class n4 implements b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o4 f9891a;

    public n4(o4 o4Var) {
        this.f9891a = o4Var;
    }

    @Override // se.b4
    public final void a(int i8) {
        Boolean boolValueOf;
        o4 o4Var = this.f9891a;
        String strI = h0.a.i("P2pConnectController-", o4Var.f9912c);
        h4.q.getClass();
        we.h.h(strI, "onNotifyRemoveGroupSuccess: moduleId: ".concat(u0.c(i8)));
        boolean z2 = o4Var.f9921n;
        String str = o4Var.f9912c;
        if (z2) {
            we.h.j("P2pConnectController-" + str, "onNotifyRemoveGroupSuccess: mP2pDirectRecovering ignore");
            return;
        }
        int i9 = o4Var.f9913d;
        if (i8 != i9) {
            h4 h4Var = o4Var.f9914g;
            if (h4Var != null) {
                boolValueOf = Boolean.valueOf(h4Var.H(i9, "P2pConnectController-" + str));
            } else {
                boolValueOf = null;
            }
            we.h.h(h0.a.i("P2pConnectController-", str), "onNotifyRemoveGroupSuccess: tryCancelSuspendP2pConnectTimer: " + boolValueOf);
        }
    }

    @Override // se.b4
    public final void b(boolean z2, int i8, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice) {
        i2 i2Var;
        NearDevice nearDevice2;
        we.h.h(h0.a.i("P2pConnectController-", this.f9891a.f9912c), "onNotifyDisconnected: isSelf: " + z2 + ", reasonCode: " + i8 + ", device: " + bluetoothDevice + ", p2pOwnerDevice: " + wifiP2pDevice + ", nearDevice: " + nearDevice);
        o4 o4Var = this.f9891a;
        synchronized (o4Var) {
            try {
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = i8;
                if (o4Var.c(o4Var.f9924s)) {
                    o4Var.h(o4Var.f9924s);
                    intRef.element = 4;
                }
                if (!o4Var.f9920m.isEmpty()) {
                    Iterator it = o4Var.f9920m.entrySet().iterator();
                    while (it.hasNext()) {
                        m4 m4Var = (m4) ((Map.Entry) it.next()).getValue();
                        Iterator it2 = o4Var.f9916i.iterator();
                        while (it2.hasNext()) {
                            ((w) it2.next()).e(null, (WifiP2pDevice) m4Var.f9872a.get(0), z2, m4Var.f9873b);
                        }
                    }
                    o4Var.f9920m.clear();
                } else if (!o4Var.f9919l.isEmpty()) {
                    for (Map.Entry entry : o4Var.f9919l.entrySet()) {
                        l4 l4Var = (l4) entry.getValue();
                        Iterator it3 = o4Var.f9916i.iterator();
                        while (it3.hasNext()) {
                            ((w) it3.next()).e(null, l4Var.f9859a, z2, l4Var.f9860b);
                        }
                    }
                    o4Var.f9919l.clear();
                } else if (!o4Var.f9917j.isEmpty()) {
                    for (i2 i2Var2 : o4Var.f9917j) {
                        if (i8 != 107) {
                            switch (i8) {
                                case 100:
                                    if (o4Var.f9921n) {
                                        we.h.j("P2pConnectController-" + o4Var.f9912c, "P2P GC connect recovery 3, wait for timeout");
                                        return;
                                    }
                                    we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P connect timeout, report to upper layer");
                                    break;
                                case 101:
                                    we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P connect failed, report to upper layer");
                                    break;
                                case 102:
                                    we.h.j("P2pConnectController-" + o4Var.f9912c, "P2P connect recovery, wait for timeout");
                                    return;
                                default:
                                    if (o4Var.f9921n) {
                                        we.h.j("P2pConnectController-" + o4Var.f9912c, "P2P GC connect recovery 2, wait for timeout");
                                        return;
                                    }
                                    we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P connect internal failed, report to upper layer");
                                    break;
                            }
                        } else {
                            if (o4Var.f9921n) {
                                we.h.j("P2pConnectController-" + o4Var.f9912c, "P2P GO occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P connect occupied by other(GC), report to upper layer");
                        }
                        for (w wVar : o4Var.f9916i) {
                            int i9 = intRef.element;
                            NearDevice nearDevice3 = i2Var2.f9797g;
                            if (nearDevice3 == null) {
                                nearDevice3 = o4Var.f9915h;
                            }
                            wVar.i(null, null, i9, nearDevice3);
                        }
                    }
                    o4Var.f9917j.clear();
                } else if (o4Var.f9918k.isEmpty()) {
                    we.h.j("P2pConnectController-" + o4Var.f9912c, "Nothing Done");
                } else {
                    Iterator it4 = o4Var.f9918k.iterator();
                    do {
                        if (!it4.hasNext()) {
                            i2Var = null;
                            break;
                        }
                        i2Var = (i2) it4.next();
                    } while (i2Var == null);
                    if (i2Var == null || (nearDevice2 = i2Var.f9797g) == null) {
                        nearDevice2 = o4Var.f9915h;
                    }
                    if (i8 == 100) {
                        if (o4Var.f9921n) {
                            we.h.j("P2pConnectController-" + o4Var.f9912c, "P2P GO connect recovery 3, wait for timeout");
                            return;
                        }
                        o4Var.q = false;
                        we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P GO connect timeout, report to upper layer");
                    } else if (i8 == 101) {
                        we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P GO connect failed, report to upper layer");
                    } else {
                        if (i8 == 103) {
                            we.h.j("P2pConnectController-" + o4Var.f9912c, "P2P GO connect recovery, wait for timeout");
                            return;
                        }
                        if (i8 == 104) {
                            we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P GO connect group removed by others?, report to upper layer");
                        } else if (i8 != 107) {
                            if (o4Var.f9921n) {
                                we.h.j("P2pConnectController-" + o4Var.f9912c, "P2P GO connect recovery 2, wait for timeout");
                                return;
                            }
                            we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P GO connect internal failed, report to upper layer");
                        } else {
                            if (o4Var.f9921n) {
                                we.h.j("P2pConnectController-" + o4Var.f9912c, "P2P GO occupy from other, wait for timeout");
                                return;
                            }
                            we.h.b("P2pConnectController-" + o4Var.f9912c, "P2P connect occupied by other(GO), report to upper layer");
                        }
                    }
                    if (nearDevice2 != null && nearDevice != null) {
                        nearDevice.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
                    }
                    if (o4Var.f9916i.isEmpty()) {
                        we.h.j("P2pConnectController-" + o4Var.f9912c, "P2p listener is null, try find timer");
                        h4 h4Var = o4Var.f9914g;
                        if (Intrinsics.areEqual(h4Var != null ? Boolean.valueOf(h4Var.k()) : null, Boolean.FALSE)) {
                            we.h.j("P2pConnectController-" + o4Var.f9912c, "P2p owner connect timer not found, clear pending request");
                            o4Var.f9918k.clear();
                        }
                    } else {
                        for (w wVar2 : o4Var.f9916i) {
                            if (wifiP2pDevice != null) {
                                o4Var.f9918k.clear();
                                o4Var.q = false;
                                wVar2.i(null, wifiP2pDevice, intRef.element, nearDevice);
                            } else {
                                we.h.j("P2pConnectController-" + o4Var.f9912c, "P2p owner device is null, try find timer");
                                h4 h4Var2 = o4Var.f9914g;
                                Boolean boolValueOf = h4Var2 != null ? Boolean.valueOf(h4Var2.k()) : null;
                                h4 h4Var3 = o4Var.f9914g;
                                Boolean boolValueOf2 = h4Var3 != null ? Boolean.valueOf(h4Var3.G()) : null;
                                Boolean bool = Boolean.FALSE;
                                if (Intrinsics.areEqual(boolValueOf, bool) && Intrinsics.areEqual(boolValueOf2, bool)) {
                                    we.h.j("P2pConnectController-" + o4Var.f9912c, "P2p owner connect timer not found, clear pending request");
                                    if (o4Var.q) {
                                        we.h.j("P2pConnectController-" + o4Var.f9912c, "P2p owner connect timeout is running, waiting");
                                    } else {
                                        o4Var.f9918k.clear();
                                    }
                                } else {
                                    we.h.j("P2pConnectController-" + o4Var.f9912c, "P2p owner connect timer found, waiting");
                                    o4Var.q = true;
                                }
                            }
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
        i2 i2Var;
        InetAddress inetAddress;
        Intrinsics.checkNotNullParameter(wifiP2pGroupInfo, "wifiP2pGroupInfo");
        String networkName = wifiP2pGroupInfo.getNetworkName();
        String passphrase = wifiP2pGroupInfo.getPassphrase();
        int frequency = wifiP2pGroupInfo.getFrequency();
        WifiP2pDevice owner = wifiP2pGroupInfo.getOwner();
        String strValueOf = String.valueOf((wifiP2pInfo == null || (inetAddress = wifiP2pInfo.groupOwnerAddress) == null) ? null : inetAddress.getHostAddress());
        o4 o4Var = this.f9891a;
        String strI = h0.a.i("P2pConnectController-", o4Var.f9912c);
        StringBuilder sbP = h0.a.p("onNotifyGroupOwnerAvailable: ssid: ", networkName, ", password: ", passphrase, ", freq: ");
        sbP.append(frequency);
        sbP.append(", ownerDevice: ");
        sbP.append(owner);
        sbP.append(", goHostAddress: ");
        sbP.append(strValueOf);
        we.h.h(strI, sbP.toString());
        if (o4Var.f9918k.isEmpty()) {
            Intrinsics.checkNotNull(networkName);
            Intrinsics.checkNotNull(passphrase);
            Intrinsics.checkNotNull(owner);
            o4.k(this.f9891a, strValueOf, networkName, passphrase, frequency, owner, wifiP2pGroupInfo);
            return;
        }
        Iterator it = o4Var.f9918k.iterator();
        do {
            if (!it.hasNext()) {
                i2Var = null;
                break;
            }
            i2Var = (i2) it.next();
        } while (i2Var == null);
        if (i2Var != null) {
            Intrinsics.checkNotNull(networkName);
            Intrinsics.checkNotNull(passphrase);
            Intrinsics.checkNotNull(owner);
            o4.k(this.f9891a, strValueOf, networkName, passphrase, frequency, owner, wifiP2pGroupInfo);
            return;
        }
        String tag = "P2pConnectController-" + o4Var.f9912c;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter("mPendingCreateGroupOwnerRequest is empty", "mes");
        if (lb.f6529c >= 1) {
            Log.e(tag, "TransConnect:mPendingCreateGroupOwnerRequest is empty", null);
        }
    }

    @Override // se.b4
    public final void d() {
        we.h.h("P2pConnectController-" + this.f9891a.f9912c, "onNotifyCreateGroupSuccess");
    }

    @Override // se.b4
    public final void e() {
        we.h.h("P2pConnectController-" + this.f9891a.f9912c, "onNotifyCreateGroupFailed");
        synchronized (this.f9891a) {
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // se.b4
    public final void f(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        String hostAddress;
        String hostAddress2;
        String hostAddress3;
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        o4 o4Var = this.f9891a;
        synchronized (o4Var) {
            try {
                we.h.h("P2pConnectController-" + o4Var.f9912c, "onNotifyConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                String string = null;
                NearDevice nearDevice = null;
                string = null;
                if (wifiP2pGroup != null && !wifiP2pGroup.isGroupOwner() && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    InetAddress inetAddress = wifiP2pInfo.groupOwnerAddress;
                    String string2 = (inetAddress == null || (hostAddress3 = inetAddress.getHostAddress()) == null) ? null : hostAddress3.toString();
                    Inet4Address inet4AddressD = o4Var.e != null ? ye.d.d(wifiP2pGroup) : null;
                    String string3 = (inet4AddressD == null || (hostAddress2 = inet4AddressD.getHostAddress()) == null) ? null : hostAddress2.toString();
                    WifiP2pDevice owner = wifiP2pGroup.getOwner();
                    String networkName = wifiP2pGroup.getNetworkName();
                    Iterator it = o4Var.f9917j.iterator();
                    while (it.hasNext()) {
                        NearDevice nearDevice2 = ((i2) it.next()).f9797g;
                        if (nearDevice2 == null) {
                            nearDevice2 = o4Var.f9915h;
                        }
                        if (nearDevice2 != null) {
                            nearDevice = nearDevice2;
                            break;
                        }
                    }
                    if (nearDevice != null) {
                        LinkedHashMap linkedHashMap = o4Var.f9919l;
                        String str = owner.deviceAddress;
                        Intrinsics.checkNotNull(owner);
                        linkedHashMap.put(str, new l4(owner, nearDevice));
                    }
                    Intrinsics.checkNotNull(owner);
                    o4.j(o4Var, string2, string3, owner, networkName, wifiP2pGroup);
                } else if (wifiP2pGroup == null && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    InetAddress inetAddress2 = wifiP2pInfo.groupOwnerAddress;
                    if (inetAddress2 != null && (hostAddress = inetAddress2.getHostAddress()) != null) {
                        string = hostAddress.toString();
                    }
                    Iterator it2 = clientList.iterator();
                    while (it2.hasNext()) {
                        WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) it2.next();
                        String string4 = wifiP2pDevice.deviceAddress.toString();
                        we.h.h("P2pConnectController-" + o4Var.f9912c, "onConnected clientList: Client address:" + string4);
                        o4Var.s(wifiP2pDevice, string == null ? "192.168.49.1" : string);
                    }
                } else {
                    we.h.h("P2pConnectController-" + o4Var.f9912c, "onNotifyConnected failed: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void g() {
        o4 o4Var = this.f9891a;
        we.h.h("P2pConnectController-" + o4Var.f9912c, "onResetRecoveryState");
        boolean z2 = o4Var.f9921n;
        String str = o4Var.f9912c;
        if (!z2) {
            we.h.h("P2pConnectController-" + str, "onResetRecoveryState: P2p reset by other module");
        } else {
            o4Var.f9921n = false;
            we.h.h("P2pConnectController-" + str, "onResetRecoveryState: P2p direct recovering reset");
        }
    }

    @Override // se.b4
    public final void h(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        o4 o4Var = this.f9891a;
        synchronized (o4Var) {
            try {
                we.h.h("P2pConnectController-" + o4Var.f9912c, "onNotifyOtherDeviceConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                Iterator it = o4Var.f9916i.iterator();
                while (it.hasNext()) {
                    ((w) it.next()).k(wifiP2pGroup, wifiP2pInfo, clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        we.h.h(h0.a.i("P2pConnectController-", this.f9891a.f9912c), "onNotifyOtherDeviceConnected: " + clientList);
    }

    @Override // se.b4
    public final void i() {
        we.h.h("P2pConnectController-" + this.f9891a.f9912c, "onNotifyConnectionSuccess");
    }
}
