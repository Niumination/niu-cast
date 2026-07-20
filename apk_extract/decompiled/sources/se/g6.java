package se;

import android.net.MacAddress;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import com.welink.protocol.nfbd.TranP2pConnectHelper$mP2pStateReceiver$1;
import com.welink.protocol.wifi.P2pTool$mP2pReceiver$1;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import k3.lb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import m3.q;
import se.g4;
import se.h4;
import se.l6;
import se.m6;
import se.n6;
import se.o6;
import se.p6;
import se.r;
import we.m;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g6 implements WifiP2pManager.GroupInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9751a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetworkInfo f9752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9753c;

    public /* synthetic */ g6(NetworkInfo networkInfo, mg.b0 b0Var) {
        this.f9752b = networkInfo;
        this.f9753c = b0Var;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
    public final void onGroupInfoAvailable(final WifiP2pGroup wifiP2pGroup) {
        switch (this.f9751a) {
            case 0:
                int i8 = TranP2pConnectHelper$mP2pStateReceiver$1.f3984b;
                we.h.g("requestGroupInfo wifiP2pGroup: " + wifiP2pGroup);
                final mg.b0 b0Var = (mg.b0) this.f9753c;
                if (wifiP2pGroup == null) {
                    we.h.g("no connection or Group remove, ignore");
                    b0Var.getClass();
                    return;
                }
                if (wifiP2pGroup.getClientList().isEmpty() && wifiP2pGroup.isGroupOwner()) {
                    we.h.g("no device connected");
                    return;
                }
                we.h.g("new device connected。");
                NetworkInfo networkInfo = this.f9752b;
                if (networkInfo == null || !networkInfo.isConnected()) {
                    we.h.g("WIFI_P2P_CONNECTION_CHANGED_ACTION: Disconnected P2P device");
                    b0Var.getClass();
                    return;
                }
                WifiP2pManager wifiP2pManager = (WifiP2pManager) b0Var.f8048c;
                if (wifiP2pManager != null) {
                    wifiP2pManager.requestConnectionInfo((WifiP2pManager.Channel) b0Var.f8049d, new WifiP2pManager.ConnectionInfoListener() { // from class: se.h6
                        @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
                        public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
                            Inet4Address inet4Address;
                            int i9 = TranP2pConnectHelper$mP2pStateReceiver$1.f3984b;
                            if (wifiP2pInfo.groupFormed) {
                                WifiP2pGroup wifiP2pGroup2 = wifiP2pGroup;
                                if (!wifiP2pGroup2.isGroupOwner()) {
                                    String hostAddress = wifiP2pInfo.groupOwnerAddress.getHostAddress();
                                    b0Var.getClass();
                                    try {
                                        NetworkInterface byName = NetworkInterface.getByName(wifiP2pGroup2.getInterface());
                                        Intrinsics.checkNotNull(byName);
                                        Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
                                        Intrinsics.checkNotNullExpressionValue(inetAddresses, "getInetAddresses(...)");
                                        while (true) {
                                            if (!inetAddresses.hasMoreElements()) {
                                                String mes = "Could not obtain address of network interface " + wifiP2pGroup2.getInterface() + " because it had no IPv4 addresses.";
                                                Intrinsics.checkNotNullParameter(mes, "mes");
                                                if (lb.f6529c >= 2) {
                                                    Log.w("welinkBLE", mes, null);
                                                }
                                                inet4Address = null;
                                                break;
                                            }
                                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                                            if (inetAddressNextElement instanceof Inet4Address) {
                                                inet4Address = (Inet4Address) inetAddressNextElement;
                                                break;
                                            }
                                        }
                                    } catch (SocketException e) {
                                        String mes2 = "Could not obtain address of network interface " + wifiP2pGroup2.getInterface();
                                        Intrinsics.checkNotNullParameter(mes2, "mes");
                                        if (lb.f6529c >= 2) {
                                            Log.w("welinkBLE", mes2, null);
                                        }
                                        e.printStackTrace();
                                    }
                                    we.h.g("WIFI_P2P_CONNECTION_CHANGED_ACTION: GC P2P device, GC Addr:" + (inet4Address != null ? inet4Address.getHostAddress() : null) + ", GO Addr:" + hostAddress);
                                    return;
                                }
                            }
                            we.h.g("WIFI_P2P_CONNECTION_CHANGED_ACTION: GO P2P device");
                        }
                    });
                }
                we.h.g("WIFI_P2P_CONNECTION_CHANGED_ACTION: Connected P2P device");
                return;
            default:
                int i9 = P2pTool$mP2pReceiver$1.f4249b;
                we.h.g("requestGroupInfo wifiP2pGroup: " + wifiP2pGroup);
                final ye.d dVar = (ye.d) this.f9753c;
                if (wifiP2pGroup == null) {
                    if (dVar.f11184o != 2) {
                        g4 g4Var = dVar.f11174c;
                        if (g4Var != null) {
                            h4 h4Var = g4Var.f9745a;
                            synchronized (g4Var) {
                                h4.x(h4Var, 0, 30);
                                Unit unit = Unit.INSTANCE;
                            }
                            return;
                        }
                        return;
                    }
                    dVar.f11184o = 0;
                    dVar.f11180k = null;
                    dVar.p = null;
                    we.h.g("wifiP2pGroup: null report disconnect");
                    g4 g4Var2 = dVar.f11174c;
                    if (g4Var2 != null) {
                        g4Var2.d(true);
                        return;
                    }
                    return;
                }
                final Collection<WifiP2pDevice> clientList = wifiP2pGroup.getClientList();
                if (clientList.isEmpty()) {
                    we.h.g("没有设备连接。。。。。。。");
                    if (dVar.f11184o == 2 && wifiP2pGroup.isGroupOwner()) {
                        we.h.g("没有设备连接 当前设备断开");
                        dVar.f11184o = 0;
                        dVar.p = null;
                        if (!dVar.a(wifiP2pGroup)) {
                            g4 g4Var3 = dVar.f11174c;
                            if (g4Var3 != null) {
                                g4Var3.d(false);
                                return;
                            }
                            return;
                        }
                        dVar.f11180k = null;
                        g4 g4Var4 = dVar.f11174c;
                        if (g4Var4 != null) {
                            g4Var4.d(true);
                            return;
                        }
                        return;
                    }
                } else {
                    we.h.g("有设备连接上了。。。。。。。");
                }
                NetworkInfo networkInfo2 = this.f9752b;
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    WifiP2pManager wifiP2pManager2 = dVar.f11172a;
                    if (wifiP2pManager2 != null) {
                        wifiP2pManager2.requestConnectionInfo(dVar.f11173b, new WifiP2pManager.ConnectionInfoListener() { // from class: ye.c
                            /* JADX WARN: Code duplicated, block: B:203:0x0202 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            /* JADX WARN: Code duplicated, block: B:81:0x01b4  */
                            /* JADX WARN: Code duplicated, block: B:88:0x01d4  */
                            /* JADX WARN: Code duplicated, block: B:91:0x01df  */
                            /* JADX WARN: Code duplicated, block: B:93:0x01f0  */
                            /* JADX WARN: Code duplicated, block: B:99:0x0213 A[Catch: all -> 0x0235, LOOP:2: B:97:0x020d->B:99:0x0213, LOOP_END, TryCatch #2 {all -> 0x0235, blocks: (B:96:0x0202, B:97:0x020d, B:99:0x0213, B:102:0x0237), top: B:203:0x0202 }] */
                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r0v42, types: [T, java.lang.String] */
                            @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
                            public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
                                h4 h4Var2;
                                ka.d dVar2;
                                ConcurrentHashMap.KeySetView executorListenerPairs;
                                h4 h4Var3;
                                MacAddress macAddress;
                                String string;
                                String hostAddress;
                                List listSplit$default;
                                String hostAddress2;
                                List listSplit$default2;
                                InetAddress inetAddress;
                                d dVar3 = dVar;
                                WifiP2pGroup wifiP2pGroup2 = wifiP2pGroup;
                                Collection clientList2 = clientList;
                                int i10 = P2pTool$mP2pReceiver$1.f4249b;
                                dVar3.f11184o = 2;
                                dVar3.f11180k = wifiP2pGroup2.getInterface();
                                g4 g4Var5 = dVar3.f11174c;
                                if (g4Var5 != null) {
                                    Intrinsics.checkNotNull(clientList2);
                                    Intrinsics.checkNotNullParameter(clientList2, "clientList");
                                    h4 h4Var4 = g4Var5.f9745a;
                                    if (!h4Var4.e || !(h4Var4.f9765h instanceof m6)) {
                                        Intrinsics.checkNotNullParameter("NearP2pManager", "tag");
                                        Intrinsics.checkNotNullParameter("mGroupOwnerCreatingRequest is empty or mP2pGroupOwnerConnectionState is not TransConnectP2pConnectingState", "mes");
                                        if (lb.f6529c >= 1) {
                                            Log.e("NearP2pManager", "TransConnect:mGroupOwnerCreatingRequest is empty or mP2pGroupOwnerConnectionState is not TransConnectP2pConnectingState", null);
                                        }
                                    } else if (wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                                        InetAddress inetAddress2 = wifiP2pInfo.groupOwnerAddress;
                                        if (inetAddress2 != null) {
                                            String hostAddress3 = inetAddress2.getHostAddress();
                                            we.h.h("NearP2pManager", "onConnected: GO address: " + ((Object) (hostAddress3 != null ? hostAddress3.toString() : null)));
                                        }
                                        h4Var4.v(wifiP2pInfo, clientList2);
                                    }
                                }
                                wifiP2pGroup2.getNetworkId();
                                if (wifiP2pGroup2.isGroupOwner()) {
                                    g4 g4Var6 = dVar3.f11174c;
                                    if (g4Var6 != null) {
                                        Intrinsics.checkNotNull(clientList2);
                                        Intrinsics.checkNotNullParameter(clientList2, "clientList");
                                        if (wifiP2pInfo != null && wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner) {
                                            InetAddress inetAddress3 = wifiP2pInfo.groupOwnerAddress;
                                            String strValueOf = String.valueOf(inetAddress3 != null ? inetAddress3.getHostAddress() : null);
                                            we.h.h("NearP2pManager", "GroupOwnerCreated, GO Address:".concat(strValueOf));
                                            h4 h4Var5 = g4Var6.f9745a;
                                            if (h4Var5.e && (h4Var5.f9765h instanceof o6)) {
                                                String networkName = wifiP2pGroup2.getNetworkName();
                                                String passphrase = wifiP2pGroup2.getPassphrase();
                                                int frequency = wifiP2pGroup2.getFrequency();
                                                WifiP2pDevice owner = wifiP2pGroup2.getOwner();
                                                StringBuilder sbP = h0.a.p("Group Owner Created: GO SSID:", networkName, ", Password:", passphrase, ", Freq:");
                                                sbP.append(frequency);
                                                sbP.append(", GO IP address:");
                                                sbP.append(strValueOf);
                                                sbP.append(", GO MAC address:");
                                                sbP.append(owner);
                                                we.h.b("NearP2pManager", sbP.toString());
                                                h4 h4Var6 = g4Var6.f9745a;
                                                if (h4Var6.e || (h4Var6.f9765h instanceof o6)) {
                                                    we.h.h("NearP2pManager", "sendWifiDirectGroupOwnerAvailableNotify");
                                                    ka.d dVar4 = h4Var6.f9766i;
                                                    if (dVar4 != null) {
                                                        we.h.b((String) dVar4.f6817b, "GroupOwnerAvailableResult success=true");
                                                        h4 h4Var7 = (h4) dVar4.f6816a;
                                                        if (h4Var7 != null) {
                                                            m6 newState = new m6();
                                                            Intrinsics.checkNotNullParameter(newState, "newState");
                                                            h4Var7.f9765h = newState;
                                                        }
                                                    }
                                                    ConcurrentHashMap.KeySetView executorListenerPairs2 = h4Var6.f9767j;
                                                    Intrinsics.checkNotNullExpressionValue(executorListenerPairs2, "executorListenerPairs");
                                                    synchronized (executorListenerPairs2) {
                                                        try {
                                                            ConcurrentHashMap.KeySetView<Pair> executorListenerPairs3 = h4Var6.f9767j;
                                                            Intrinsics.checkNotNullExpressionValue(executorListenerPairs3, "executorListenerPairs");
                                                            for (Pair pair : executorListenerPairs3) {
                                                                ((Executor) pair.getFirst()).execute(new a0.g(pair, 16, wifiP2pGroup2, wifiP2pInfo));
                                                            }
                                                            Unit unit2 = Unit.INSTANCE;
                                                        } catch (Throwable th2) {
                                                            throw th2;
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (h4Var5.f9765h instanceof p6) {
                                                    h4.j(h4Var5, wifiP2pGroup2, wifiP2pInfo, clientList2);
                                                }
                                                we.h.c("NearP2pManager", "mGroupOwnerCreatingRequest is false or mP2pGroupOwnerConnectionState is not TransConnectP2pCreatingGroupOwnerState", null);
                                            }
                                        } else {
                                            we.h.b("NearP2pManager", "GroupOwnerCreated error GC P2P device?");
                                            g4Var6.f9745a.y(true, wifiP2pGroup2);
                                        }
                                    }
                                } else {
                                    g4 g4Var7 = dVar3.f11174c;
                                    if (g4Var7 != null) {
                                        Intrinsics.checkNotNull(clientList2);
                                        Intrinsics.checkNotNullParameter(clientList2, "clientList");
                                        h4 h4Var8 = g4Var7.f9745a;
                                        if (!h4Var8.f) {
                                            n6 n6Var = h4Var8.f9764g;
                                            if (!(n6Var instanceof m6)) {
                                                if (n6Var instanceof p6) {
                                                    h4.j(h4Var8, wifiP2pGroup2, wifiP2pInfo, clientList2);
                                                }
                                                Intrinsics.checkNotNullParameter("NearP2pManager", "tag");
                                                Intrinsics.checkNotNullParameter("mGroupClientConnectingRequest is false or mP2pGroupClientConnectionState is not TransConnectP2pConnectingState", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("NearP2pManager", "TransConnect:mGroupClientConnectingRequest is false or mP2pGroupClientConnectionState is not TransConnectP2pConnectingState", null);
                                                }
                                            } else if (!wifiP2pGroup2.isGroupOwner() && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                                                h4Var2 = g4Var7.f9745a;
                                                h4Var2.getClass();
                                                we.h.h("NearP2pManager", "sendWifiDirectGroupClientAvailableNotify");
                                                if (m.e(256)) {
                                                    m.c(256);
                                                }
                                                h4Var2.f9763d = null;
                                                h4Var2.f = false;
                                                dVar2 = h4Var2.f9766i;
                                                if (dVar2 != null) {
                                                    we.h.b((String) dVar2.f6817b, "GroupClientConnectedResult result=true");
                                                    h4Var3 = (h4) dVar2.f6816a;
                                                    if (h4Var3 != null) {
                                                        l6 newState2 = new l6();
                                                        Intrinsics.checkNotNullParameter(newState2, "newState");
                                                        h4Var3.f9764g = newState2;
                                                    }
                                                }
                                                executorListenerPairs = h4Var2.f9767j;
                                                Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
                                                synchronized (executorListenerPairs) {
                                                    try {
                                                        ConcurrentHashMap.KeySetView<Pair> executorListenerPairs4 = h4Var2.f9767j;
                                                        Intrinsics.checkNotNullExpressionValue(executorListenerPairs4, "executorListenerPairs");
                                                        for (Pair pair2 : executorListenerPairs4) {
                                                            ((Executor) pair2.getFirst()).execute(new r(pair2, wifiP2pGroup2, wifiP2pInfo, clientList2, 5));
                                                        }
                                                        Unit unit3 = Unit.INSTANCE;
                                                    } catch (Throwable th3) {
                                                        throw th3;
                                                    }
                                                }
                                            }
                                        } else if (!wifiP2pGroup2.isGroupOwner()) {
                                            h4Var2 = g4Var7.f9745a;
                                            h4Var2.getClass();
                                            we.h.h("NearP2pManager", "sendWifiDirectGroupClientAvailableNotify");
                                            if (m.e(256)) {
                                                m.c(256);
                                            }
                                            h4Var2.f9763d = null;
                                            h4Var2.f = false;
                                            dVar2 = h4Var2.f9766i;
                                            if (dVar2 != null) {
                                                we.h.b((String) dVar2.f6817b, "GroupClientConnectedResult result=true");
                                                h4Var3 = (h4) dVar2.f6816a;
                                                if (h4Var3 != null) {
                                                    l6 newState3 = new l6();
                                                    Intrinsics.checkNotNullParameter(newState3, "newState");
                                                    h4Var3.f9764g = newState3;
                                                }
                                            }
                                            executorListenerPairs = h4Var2.f9767j;
                                            Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
                                            synchronized (executorListenerPairs) {
                                                ConcurrentHashMap.KeySetView<Pair> executorListenerPairs5 = h4Var2.f9767j;
                                                Intrinsics.checkNotNullExpressionValue(executorListenerPairs5, "executorListenerPairs");
                                                while (r14.hasNext()) {
                                                    ((Executor) pair2.getFirst()).execute(new r(pair2, wifiP2pGroup2, wifiP2pInfo, clientList2, 5));
                                                }
                                                Unit unit4 = Unit.INSTANCE;
                                            }
                                        }
                                    }
                                }
                                if (wifiP2pInfo.groupFormed && !wifiP2pGroup2.isGroupOwner() && (inetAddress = wifiP2pInfo.groupOwnerAddress) != null) {
                                    String hostAddress4 = inetAddress.getHostAddress();
                                    Inet4Address inet4AddressD = d.d(wifiP2pGroup2);
                                    String hostAddress5 = inet4AddressD != null ? inet4AddressD.getHostAddress() : null;
                                    we.h.g("WIFI_P2P_CONNECTION_CHANGED_ACTION: GC P2P device, GC Addr:" + hostAddress5 + ", GO Addr:" + hostAddress4);
                                    g4 g4Var8 = dVar3.f11174c;
                                    Intrinsics.checkNotNull(g4Var8);
                                    g4Var8.b(hostAddress4, hostAddress5);
                                    return;
                                }
                                if (!wifiP2pGroup2.isGroupOwner() && wifiP2pInfo.groupFormed) {
                                    WifiP2pDevice owner2 = wifiP2pGroup2.getOwner();
                                    if (owner2 != null) {
                                        String str = owner2.deviceAddress;
                                        Inet6Address inet6AddressE = d.e(wifiP2pGroup2);
                                        String str2 = (inet6AddressE == null || (hostAddress2 = inet6AddressE.getHostAddress()) == null || (listSplit$default2 = StringsKt__StringsKt.split$default(hostAddress2, new String[]{"%"}, false, 0, 6, (Object) null)) == null) ? null : (String) listSplit$default2.get(0);
                                        String strE = "";
                                        if (str == null || str.length() == 0) {
                                            String mes = "WIFI_P2P_CONNECTION_CHANGED_ACTION: Local GC P2P device " + str2 + ", Remote Go Ipv6 Addr: null";
                                            Intrinsics.checkNotNullParameter(mes, "mes");
                                            if (lb.f6529c >= 2) {
                                                Log.w("welinkBLE", mes, null);
                                            }
                                        } else {
                                            strE = q.e(str);
                                            we.h.g("WIFI_P2P_CONNECTION_CHANGED_ACTION: Local GC P2P device " + str2 + ", Remote Go Ipv6 Addr:" + strE);
                                        }
                                        g4 g4Var9 = dVar3.f11174c;
                                        Intrinsics.checkNotNull(g4Var9);
                                        g4Var9.b(strE, str2);
                                    }
                                } else if (wifiP2pGroup2.isGroupOwner() && wifiP2pInfo.groupFormed) {
                                    Inet6Address inet6AddressE2 = d.e(wifiP2pGroup2);
                                    String str3 = (inet6AddressE2 == null || (hostAddress = inet6AddressE2.getHostAddress()) == null || (listSplit$default = StringsKt__StringsKt.split$default(hostAddress, new String[]{"%"}, false, 0, 6, (Object) null)) == null) ? null : (String) listSplit$default.get(0);
                                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                    objectRef.element = "";
                                    Collection<WifiP2pDevice> clientList3 = wifiP2pGroup2.getClientList();
                                    Intrinsics.checkNotNullExpressionValue(clientList3, "getClientList(...)");
                                    for (WifiP2pDevice device : clientList3) {
                                        if (device.deviceAddress != null) {
                                            Intrinsics.checkNotNull(device);
                                            Intrinsics.checkNotNullParameter(device, "device");
                                            try {
                                                Method declaredMethod = WifiP2pDevice.class.getDeclaredMethod("getInterfaceMacAddress", null);
                                                Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
                                                declaredMethod.setAccessible(true);
                                                Object objInvoke = declaredMethod.invoke(device, null);
                                                macAddress = objInvoke instanceof MacAddress ? (MacAddress) objInvoke : null;
                                            } catch (IllegalAccessException e) {
                                                Intrinsics.checkNotNullParameter("Cannot access getInterfaceMacAddress()", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("welinkBLE", "Cannot access getInterfaceMacAddress()", e);
                                                }
                                            } catch (NoSuchMethodException e4) {
                                                Intrinsics.checkNotNullParameter("Method getInterfaceMacAddress() does not exist", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("welinkBLE", "Method getInterfaceMacAddress() does not exist", e4);
                                                }
                                                macAddress = null;
                                            } catch (Exception e10) {
                                                Intrinsics.checkNotNullParameter("Reflection failed", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("welinkBLE", "Reflection failed", e10);
                                                }
                                            }
                                            T tE = (macAddress == null || (string = macAddress.toString()) == null) ? 0 : q.e(string);
                                            objectRef.element = tE;
                                            if (tE == 0) {
                                                objectRef.element = q.e(device.deviceAddress.toString());
                                            }
                                            String mes2 = "WIFI_P2P_CONNECTION_CHANGED_ACTION: Local GO P2P device " + str3 + ", Remote Gc Ipv6 Addr: " + objectRef.element;
                                            Intrinsics.checkNotNullParameter(mes2, "mes");
                                            if (lb.f6529c >= 2) {
                                                Log.w("welinkBLE", mes2, null);
                                            }
                                            g4 g4Var10 = dVar3.f11174c;
                                            Intrinsics.checkNotNull(g4Var10);
                                            g4Var10.b(str3, (String) objectRef.element);
                                        }
                                    }
                                } else {
                                    Intrinsics.checkNotNullParameter("WIFI_P2P_CONNECTION_CHANGED_ACTION: No connection info available", "mes");
                                    if (lb.f6529c >= 2) {
                                        Log.w("welinkBLE", "WIFI_P2P_CONNECTION_CHANGED_ACTION: No connection info available", null);
                                    }
                                }
                                Intrinsics.checkNotNullParameter("WIFI_P2P_CONNECTION_CHANGED_ACTION: Probably IPv6 static address is used, ignore", "mes");
                                if (lb.f6529c >= 2) {
                                    Log.w("welinkBLE", "WIFI_P2P_CONNECTION_CHANGED_ACTION: Probably IPv6 static address is used, ignore", null);
                                }
                            }
                        });
                    }
                    we.h.g("WIFI_P2P_CONNECTION_CHANGED_ACTION: 已连接p2p设备, onConnectionInfoAvailable");
                    return;
                }
                dVar.f11184o = 0;
                dVar.p = null;
                if (dVar.a(wifiP2pGroup)) {
                    dVar.f11180k = null;
                    g4 g4Var5 = dVar.f11174c;
                    if (g4Var5 != null) {
                        g4Var5.d(true);
                    }
                } else {
                    g4 g4Var6 = dVar.f11174c;
                    if (g4Var6 != null) {
                        g4Var6.d(false);
                    }
                }
                we.h.g("WIFI_P2P_CONNECTION_CHANGED_ACTION: 与p2p设备已断开连接");
                return;
        }
    }

    public /* synthetic */ g6(ye.d dVar, NetworkInfo networkInfo) {
        this.f9753c = dVar;
        this.f9752b = networkInfo;
    }
}
