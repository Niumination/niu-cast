package se;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import androidx.work.WorkRequest;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.ConnectedDevice;
import com.transsion.iotservice.multiscreen.pc.socket.EventListener;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TCCPPacket;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpDisConnectSocketBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpRequestConnectBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpRequestNetworkSharingBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpResponseConnectBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpResponseNetworkSharingBean;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpSwitchAbilityBean;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.CapabilitySocketConnected;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.DialogUtilActivity;
import com.transsion.pcconnect.invoke.bridge.Device;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.nfbd.WirelessDevice;
import com.welink.protocol.utils.DeviceInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import k3.gc;
import k3.lb;
import k3.pb;
import k3.qb;
import k3.sb;
import k3.vb;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements f, EventListener, f2.b, j5.b, pf.e0, mg.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9741a;

    public /* synthetic */ g(int i8) {
        this.f9741a = i8;
    }

    @Override // j5.b
    public Object a(e5.j jVar) {
        return Integer.valueOf(jVar.getCountryCode());
    }

    @Override // se.f
    public boolean e(NearDevice device, com.welink.protocol.nfbd.z manager, Function1 function1) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Log.d("DisconnectedState", "ignore disconnect");
        return false;
    }

    @Override // se.f
    public boolean f(NearDevice device, com.welink.protocol.nfbd.z manager, ConnectRequest request, r6 r6Var) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(request, "request");
        return false;
    }

    @Override // yh.a
    public Object get() {
        n5.a aVar = new n5.a();
        HashMap map = new HashMap();
        a2.c cVar = a2.c.DEFAULT;
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(cVar, new i2.c(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, 86400000L, setEmptySet));
        a2.c cVar2 = a2.c.HIGHEST;
        Set setEmptySet2 = Collections.emptySet();
        if (setEmptySet2 == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(cVar2, new i2.c(1000L, 86400000L, setEmptySet2));
        a2.c cVar3 = a2.c.VERY_LOW;
        if (Collections.emptySet() == null) {
            throw new NullPointerException("Null flags");
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(i2.f.NETWORK_UNMETERED, i2.f.DEVICE_IDLE)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(cVar3, new i2.c(86400000L, 86400000L, setUnmodifiableSet));
        if (map.keySet().size() < a2.c.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new i2.b(aVar, map);
    }

    @Override // pf.e0
    public zg.a getKey() {
        switch (this.f9741a) {
            case 5:
                return uf.m.e;
            default:
                return xg.n0.A;
        }
    }

    @Override // se.f
    public boolean h(NearDevice device, com.welink.protocol.nfbd.z manager) {
        String str;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        a8.a resultCallback = new a8.a(device);
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        manager.getClass();
        int iHashCode = device.hashCode();
        HashMap map = manager.f4208j;
        if (map.get(Integer.valueOf(iHashCode)) == manager.f4205g) {
            manager.f4205g = null;
        } else if (map.get(Integer.valueOf(iHashCode)) == manager.f4206h) {
            manager.f4206h = null;
        } else {
            we.h.j("TranConnectionManager", "FlushDevice: device callback not found");
        }
        if (map.get(Integer.valueOf(iHashCode)) != null) {
            map.remove(Integer.valueOf(iHashCode));
        }
        Intent intent = new Intent();
        intent.setAction("com.welink.protocol.nfbd.action.ACTION_FLUSH_DEVICE");
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", new NearDevice(device.f3883a, device.f3884b, device.f3885c, device.f3886d, device.f3892m, device.f3889j, device.e, device.f3887h, device.f3890k, device.f3891l, device.f3893n, device.f3894o, device.p, device.q, device.f3898v, device.f3899w, device.f3900x, device.f3901y, device.f3895r, device.f3888i, device.f3902z, device.A, device.f3896s, device.f3897t, device.u, device.C, device.D, device.E, 0, null, null));
        com.welink.protocol.nfbd.g gVar = manager.f4207i;
        if (gVar != null) {
            gVar.w(intent, 0);
        }
        WirelessDevice wirelessDevice = device.f3896s;
        boolean z2 = wirelessDevice instanceof WirelessDevice.Bluetooth;
        int i8 = device.e;
        int i9 = device.f3889j;
        if (z2) {
            BluetoothDevice bluetoothDevice = ((WirelessDevice.Bluetooth) wirelessDevice).f4011d;
            TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo((String) null, 29, 0, 0, 0, new NearDeviceDataParcel(device, bluetoothDevice));
            Map map2 = com.welink.protocol.nfbd.h.f4132a;
            DeviceInfo deviceInfo = new DeviceInfo(com.welink.protocol.nfbd.h.e(i9), com.welink.protocol.nfbd.h.g(device.h()), bluetoothDevice != null ? bluetoothDevice.getName() : null, bluetoothDevice != null ? bluetoothDevice.getAddress() : null, (Boolean) null, (EarBudsInfo) null, 0, com.welink.protocol.nfbd.h.d(i8), device.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096640);
            String name = device.f3884b;
            if (name != null) {
                str = name;
            } else if (bluetoothDevice != null) {
                name = bluetoothDevice.getName();
                str = name;
            } else {
                str = null;
            }
            manager.q(new TranConnectionController$MessageInfo(null, 0, 0, str, 29, deviceInfo, tranConnectionController$EventInfo, bluetoothDevice != null ? new NearDeviceDataParcel(bluetoothDevice, device) : null), device);
            we.h.h("TranConnectionManager", "LE Device flushed");
        } else if (wirelessDevice instanceof WirelessDevice.P2p) {
            TranConnectionController$EventInfo tranConnectionController$EventInfo2 = new TranConnectionController$EventInfo((String) null, 29, 0, 0, 0, new NearDeviceDataParcel(device, null));
            Map map3 = com.welink.protocol.nfbd.h.f4132a;
            byte bE = com.welink.protocol.nfbd.h.e(i9);
            byte bG = com.welink.protocol.nfbd.h.g(device.h());
            String str2 = device.f3884b;
            if (str2 == null) {
                str2 = ((WirelessDevice.P2p) wirelessDevice).f4013a;
            }
            String str3 = str2;
            String str4 = device.f3883a;
            if (str4 == null) {
                str4 = ((WirelessDevice.P2p) wirelessDevice).f4014b;
            }
            DeviceInfo deviceInfo2 = new DeviceInfo(bE, bG, str3, str4, (Boolean) null, (EarBudsInfo) null, 3, com.welink.protocol.nfbd.h.d(i8), device.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096640);
            String str5 = device.f3884b;
            if (str5 == null) {
                str5 = ((WirelessDevice.P2p) wirelessDevice).f4013a;
            }
            manager.q(new TranConnectionController$MessageInfo(null, 0, 0, str5, 29, deviceInfo2, tranConnectionController$EventInfo2, new NearDeviceDataParcel(wirelessDevice, device)), device);
            we.h.h("TranConnectionManager", "P2P Device flushed");
        } else if (wirelessDevice instanceof WirelessDevice.Wlan) {
            WirelessDevice.Wlan wlan = (WirelessDevice.Wlan) wirelessDevice;
            TranConnectionController$EventInfo tranConnectionController$EventInfo3 = new TranConnectionController$EventInfo(wlan.f4025b, 29, 0, 0, 0, new NearDeviceDataParcel(device, null));
            Map map4 = com.welink.protocol.nfbd.h.f4132a;
            byte bE2 = com.welink.protocol.nfbd.h.e(i9);
            byte bG2 = com.welink.protocol.nfbd.h.g(device.h());
            int iD = com.welink.protocol.nfbd.h.d(i8);
            String str6 = wlan.f4024a;
            DeviceInfo deviceInfo3 = new DeviceInfo(bE2, bG2, str6, wlan.f4025b, (Boolean) null, (EarBudsInfo) null, 10, iD, device.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096640);
            String str7 = wlan.f4026c;
            String str8 = device.f3884b;
            manager.q(new TranConnectionController$MessageInfo(str7, 0, 0, str8 == null ? str6 : str8, 29, deviceInfo3, tranConnectionController$EventInfo3, new NearDeviceDataParcel(wirelessDevice, device)), device);
            we.h.h("TranConnectionManager", "WLAN Device flushed");
        } else {
            Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
            Intrinsics.checkNotNullParameter("onDeviceFlushed: wirelessDevice is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("TranConnectionManager", "TransConnect:onDeviceFlushed: wirelessDevice is null", null);
            }
        }
        return true;
    }

    @Override // se.f
    public boolean i(NearDevice device, com.welink.protocol.nfbd.z manager, g5 g5Var, Function1 function1) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        device.A(PointerIconCompat.TYPE_HELP);
        a8.a aVar = new a8.a(device);
        if (g5Var != null) {
            device.e(manager, g5Var, aVar, function1);
        } else {
            device.e(manager, null, aVar, function1);
        }
        e newState = new e(device, function1);
        Intrinsics.checkNotNullParameter(newState, "newState");
        device.I = newState;
        return true;
    }

    @Override // se.f
    public boolean j(NearDevice device, com.welink.protocol.nfbd.z manager, int i8, int i9, r6 r6Var) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        return false;
    }

    @Override // mg.f
    public Object m(hh.e eVar, Function1 configure) throws hh.c {
        mg.a pipeline = (mg.a) eVar;
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        Intrinsics.checkNotNullParameter(configure, "configure");
        xg.n0 n0Var = new xg.n0(pipeline);
        configure.invoke(n0Var);
        pipeline.p(mg.c.f8053o, new xg.j0(n0Var, null));
        return n0Var;
    }

    @Override // pf.e0
    public void o(Object obj, jf.d scope) throws hh.c {
        uf.m plugin = (uf.m) obj;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        nf.e eVar = scope.f6255a;
        boolean zContains = eVar.e.contains(uf.i.f10430a);
        scope.e.p(vf.f.f10570l, new uf.k(zContains, plugin, null));
        scope.f6259h.p(wf.f.f10746k, new uf.l(plugin, zContains, null));
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.EventListener
    public void onConnected() {
        li.g2 g2Var = eb.l2.f4773b;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (g2Var != null) {
            g2Var.h(null);
        }
        li.g2 g2Var2 = eb.l2.f;
        if (g2Var2 != null) {
            g2Var2.h(null);
        }
        int i8 = 0;
        DialogUtilActivity.f2733j = false;
        DialogUtilActivity.f2734k = false;
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("exChangeAbility", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "exChangeAbility");
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = eb.l2.f4772a;
        if (tCCPHandshakeSocketServer != null) {
            tCCPHandshakeSocketServer.sendRequest(TccpConfig.INSTANCE.getSWITCH_ABILITY_FLAG(), new TccpSwitchAbilityBean(eb.a.a(), i8, 2, defaultConstructorMarker));
        }
        eb.y yVar = eb.y.f4799a;
        eb.y.i("sendConnectMainSocketSuccessEvent");
        li.l0.p(eb.y.f4800b, null, null, new eb.n(null), 3);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.EventListener
    public void onDisconnected() {
        eb.y yVar = eb.y.f4799a;
        gc.c("SocketServerManager", "onDisconnected " + eb.y.f4804h);
        if (eb.y.f4804h.compareTo((BaseState) new CapabilitySocketConnected()) >= 0) {
            li.l0.p(eb.l2.f4774c, null, null, new eb.f2(null), 3);
            return;
        }
        if (o7.a.c("com.transsion.heartbeat")) {
            eb.y.m();
            return;
        }
        gc.c("SocketServerManager", "handshake release without long alive");
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = eb.l2.f4772a;
        if (tCCPHandshakeSocketServer != null) {
            tCCPHandshakeSocketServer.releaseServer(true);
        }
        eb.l2.f4772a = null;
        eb.g0 g0Var = eb.g0.f4753a;
        eb.g0.g();
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.EventListener
    public void onReceiveRequest(TCCPPacket request) {
        Pair pair;
        li.g2 g2Var;
        Intrinsics.checkNotNullParameter(request, "request");
        String log = "onReceiveRequest:" + request;
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), log);
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = eb.l2.f4772a;
        int iA = qb.a(request.getOperationFlag());
        TccpConfig tccpConfig = TccpConfig.INSTANCE;
        if (iA == qb.a(tccpConfig.getNEW_HOTSPOT_OPEN_CLOSE_FLAG())) {
            TccpRequestNetworkSharingBean tccpRequestNetworkSharingBean = (TccpRequestNetworkSharingBean) request.getPayload(TccpRequestNetworkSharingBean.class);
            if (tccpRequestNetworkSharingBean != null) {
                u7.c cVar = sb.b() ? (u7.c) o7.a.b("com.transsion.network_sharing") : (u7.c) o7.a.b("com.transsion.pad_network_sharing");
                if (cVar == null) {
                    Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                    Intrinsics.checkNotNullParameter("handleOnNetworkSharingReq networkSharingCap not support", "log");
                    if (gc.f6462a <= 6) {
                        Log.e(gc.f6463b.concat("SocketServerManager"), "handleOnNetworkSharingReq networkSharingCap not support");
                        return;
                    }
                    return;
                }
                u7.e eVar = u7.e.f10405a;
                boolean z2 = u7.e.f10411i.get();
                if (tccpRequestNetworkSharingBean.getEnable() && z2) {
                    Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                    Intrinsics.checkNotNullParameter("Local network sharing switch is enabled", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("SocketServerManager"), "Local network sharing switch is enabled");
                    }
                    eb.g0 g0Var = eb.g0.f4753a;
                    eb.g0.a(ConnectedDevice.INSTANCE.getSUBTITLE_SHARE_NETWORK(), true);
                    Intrinsics.checkNotNullParameter("NetworkSharingCapabilityV0", "tag");
                    Intrinsics.checkNotNullParameter("isEnableNetworkSharing true", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("NetworkSharingCapabilityV0"), "isEnableNetworkSharing true");
                    }
                    cVar.f10404c = true;
                    String downLinkName = cVar.f10403b;
                    synchronized (eVar) {
                        Intrinsics.checkNotNullParameter(downLinkName, "downLinkName");
                        u7.e.f.compareAndSet(false, true);
                        u7.e.f10406b = downLinkName;
                        if (Intrinsics.areEqual("usb", downLinkName)) {
                            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                            li.g2 g2Var2 = u7.e.f10410h;
                            if (g2Var2 != null && g2Var2.a() && (g2Var = u7.e.f10410h) != null) {
                                g2Var.h(null);
                            }
                            u7.e.f10410h = li.l0.p(li.j1.f7459a, null, null, new u7.d(booleanRef, null), 3);
                        } else {
                            eVar.c();
                            Lazy lazy = u7.a.f10398a;
                            u7.a.a((ConnectivityManager.NetworkCallback) u7.e.f10412j.getValue());
                        }
                    }
                    pair = TuplesKt.to(0, Boolean.TRUE);
                } else if (!tccpRequestNetworkSharingBean.getEnable() || z2) {
                    Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                    Intrinsics.checkNotNullParameter("Remote network sharing switch is disabled", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("SocketServerManager"), "Remote network sharing switch is disabled");
                    }
                    eb.g0 g0Var2 = eb.g0.f4753a;
                    eb.g0.a(ConnectedDevice.INSTANCE.getSUBTITLE_SHARE_NETWORK(), false);
                    cVar.c();
                    pair = TuplesKt.to(0, Boolean.TRUE);
                } else {
                    Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                    Intrinsics.checkNotNullParameter("Local network sharing switch is disabled", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("SocketServerManager"), "Local network sharing switch is disabled");
                    }
                    cVar.c();
                    pair = TuplesKt.to(1, Boolean.FALSE);
                }
                int iIntValue = ((Number) pair.component1()).intValue();
                boolean zBooleanValue = ((Boolean) pair.component2()).booleanValue();
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = eb.l2.f4772a;
                if (tCCPHandshakeSocketServer2 != null) {
                    tCCPHandshakeSocketServer2.sendResponse(tccpConfig.getNEW_HOTSPOT_OPEN_CLOSE_FLAG(), new TccpResponseNetworkSharingBean(zBooleanValue, iIntValue));
                    return;
                }
                return;
            }
            return;
        }
        if (iA == qb.a(tccpConfig.getSCAN_CONFIRM_FLAG())) {
            TccpRequestConnectBean tccpRequestConnectBean = (TccpRequestConnectBean) request.getPayload(TccpRequestConnectBean.class);
            if (tccpRequestConnectBean == null) {
                Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                Intrinsics.checkNotNullParameter(" onPeerConnectReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketServerManager"), " onPeerConnectReq payload is null.");
                    return;
                }
                return;
            }
            String log2 = "handlePeerConnectReq " + tccpRequestConnectBean;
            Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketServerManager"), log2);
            }
            eb.l2.f4778i = tccpRequestConnectBean.getDeviceName();
            eb.g0 g0Var3 = eb.g0.f4753a;
            eb.g0.f();
            li.l0.p(eb.l2.f4774c, null, null, new eb.e2(tccpRequestConnectBean, null), 3);
            return;
        }
        if (iA == qb.a(tccpConfig.getDISCONNECT_SOCKET())) {
            TccpDisConnectSocketBean tccpDisConnectSocketBean = (TccpDisConnectSocketBean) request.getPayload(TccpDisConnectSocketBean.class);
            if (tccpDisConnectSocketBean != null) {
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer3 = eb.l2.f4772a;
                if (tCCPHandshakeSocketServer3 != null) {
                    tCCPHandshakeSocketServer3.sendResponse(tccpConfig.getDISCONNECT_SOCKET(), new TccpDisConnectSocketBean(tccpDisConnectSocketBean.isDisconnect()));
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
            Intrinsics.checkNotNullParameter("handlePeerChannelConfigReq payload is null.", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("SocketServerManager"), "handlePeerChannelConfigReq payload is null.");
                return;
            }
            return;
        }
        if (iA == qb.a(tccpConfig.getWIFI_FREQUENCY_STATE())) {
            Boolean bool = (Boolean) request.getPayload(Boolean.TYPE);
            if (bool == null) {
                Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                Intrinsics.checkNotNullParameter("handleWifiStateReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketServerManager"), "handleWifiStateReq payload is null.");
                    return;
                }
                return;
            }
            String log3 = "handleWifiStateReq payload : " + bool;
            Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
            Intrinsics.checkNotNullParameter(log3, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketServerManager"), log3);
            }
            boolean z3 = DialogUtilActivity.f2733j;
            DialogUtilActivity.f2734k = bool.booleanValue();
            return;
        }
        if (iA == qb.a(tccpConfig.getREQUEST_DISCONNECT())) {
            String log4 = "handleRequestDisconnectReq:" + request;
            Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
            Intrinsics.checkNotNullParameter(log4, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketServerManager"), log4);
            }
            Intrinsics.checkNotNullParameter("InvokeBridgeProvider", "tag");
            Intrinsics.checkNotNullParameter("onDisconnect", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("InvokeBridgeProvider"), "onDisconnect");
            }
            Device device = eb.g0.f;
            if (device != null) {
                cb.b.c(device, "CONNECT", false, "");
            }
            eb.l2.j();
        }
    }

    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext, li.j0] */
    /* JADX WARN: Type inference failed for: r1v23 */
    @Override // com.transsion.iotservice.multiscreen.pc.socket.EventListener
    public void onReceiveResponse(TCCPPacket response) {
        int i8;
        ?? r7;
        int i9;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        boolean z2;
        Intrinsics.checkNotNullParameter(response, "response");
        gc.c("SocketServerManager", "onReceiveResponse:" + response);
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = eb.l2.f4772a;
        int iA = qb.a(response.getOperationFlag());
        TccpConfig tccpConfig = TccpConfig.INSTANCE;
        int iA2 = qb.a(tccpConfig.getSWITCH_ABILITY_FLAG());
        qi.c cVar = eb.l2.f4774c;
        if (iA == iA2) {
            TccpSwitchAbilityBean tccpSwitchAbilityBean = (TccpSwitchAbilityBean) response.getPayload(TccpSwitchAbilityBean.class);
            if (tccpSwitchAbilityBean == null) {
                Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                Intrinsics.checkNotNullParameter("handleOnExchangeAbilityResp:result is null", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketServerManager"), "handleOnExchangeAbilityResp:result is null");
                    return;
                }
                return;
            }
            String log = "handleOnExchangeAbilityResp:" + response;
            Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketServerManager"), log);
            }
            li.l0.p(cVar, null, null, new eb.c2(tccpSwitchAbilityBean, null), 3);
            return;
        }
        if (iA == qb.a(tccpConfig.getSDK_INIT_PORT())) {
            TccpResponseConnectBean tccpResponseConnectBean = (TccpResponseConnectBean) response.getPayload(TccpResponseConnectBean.class);
            if (tccpResponseConnectBean == null) {
                Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                Intrinsics.checkNotNullParameter("handlePeerSdkInitReq payload is null.", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("SocketServerManager"), "handlePeerSdkInitReq payload is null.");
                }
            }
            gc.c("SocketServerManager", "handlePeerSdkInitResp:" + tccpResponseConnectBean);
            String str = eb.k1.f4766b;
            if (Intrinsics.areEqual(str, "ble") || Intrinsics.areEqual(str, "cable")) {
                gc.a("SocketServerManager", "sendPhoneToPCRequest");
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = eb.l2.f4772a;
                if (tCCPHandshakeSocketServer2 != null) {
                    byte[] scan_confirm_flag = tccpConfig.getSCAN_CONFIRM_FLAG();
                    String BRAND = Build.BRAND;
                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                    String string = Settings.Global.getString(pb.a().getContentResolver(), "device_name");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String address = BluetoothAdapter.getDefaultAdapter().getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                    Intrinsics.checkNotNullParameter("is_first_time_connect", "key");
                    SharedPreferences sharedPreferences3 = vb.f6684a;
                    if (sharedPreferences3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        z2 = true;
                        sharedPreferences2 = null;
                    } else {
                        sharedPreferences2 = sharedPreferences3;
                        z2 = true;
                    }
                    tCCPHandshakeSocketServer2.sendRequest(scan_confirm_flag, new TccpRequestConnectBean(BRAND, string, address, sharedPreferences2.getBoolean("is_first_time_connect", z2), 0, 16, null));
                    return;
                }
                return;
            }
            return;
        }
        if (iA != qb.a(tccpConfig.getSCAN_CONFIRM_FLAG())) {
            if (iA == qb.a(tccpConfig.getHEARTBEAT_TCCP())) {
                eb.l2.f4779j.updateHeartbeat();
                return;
            }
            if (iA == qb.a(tccpConfig.getDISCONNECT_SOCKET())) {
                TccpDisConnectSocketBean tccpDisConnectSocketBean = (TccpDisConnectSocketBean) response.getPayload(TccpDisConnectSocketBean.class);
                if (tccpDisConnectSocketBean == null) {
                    Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                    Intrinsics.checkNotNullParameter("handleDisconnectSocketResp payload is null.", "log");
                    if (gc.f6462a <= 6) {
                        Log.e(gc.f6463b.concat("SocketServerManager"), "handleDisconnectSocketResp payload is null.");
                        return;
                    }
                    return;
                }
                if (tccpDisConnectSocketBean.isDisconnect()) {
                    Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                    Intrinsics.checkNotNullParameter("handleDisconnectSocketResp:disconnect", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("SocketServerManager"), "handleDisconnectSocketResp:disconnect");
                    }
                    eb.l2.h("remote accept disconnect");
                    return;
                }
                return;
            }
            return;
        }
        TccpResponseConnectBean tccpResponseConnectBean2 = (TccpResponseConnectBean) response.getPayload(TccpResponseConnectBean.class);
        if (tccpResponseConnectBean2 == null) {
            Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
            Intrinsics.checkNotNullParameter("handleOnPcResponseConnect:parse error", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("SocketServerManager"), "handleOnPcResponseConnect:parse error");
                return;
            }
            return;
        }
        gc.c("SocketServerManager", "handleOnPcResponseConnect:" + tccpResponseConnectBean2);
        eb.l2.f4778i = tccpResponseConnectBean2.getDeviceName();
        eb.g0 g0Var = eb.g0.f4753a;
        eb.g0.f();
        if (tccpResponseConnectBean2.getMac() != null) {
            String mac = tccpResponseConnectBean2.getMac();
            Locale locale = Locale.ROOT;
            String mac2 = mac.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(mac2, "toUpperCase(...)");
            Intrinsics.checkNotNullParameter(mac2, "mac");
            String deviceKey = h0.a.B(mac2, "from PC");
            boolean zIsRemember = tccpResponseConnectBean2.isRemember();
            Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
            String key = deviceKey.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(key, "toUpperCase(...)");
            Intrinsics.checkNotNullParameter(key, "key");
            SharedPreferences sharedPreferences4 = vb.f6684a;
            if (sharedPreferences4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences4 = null;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences4.edit();
            editorEdit.putBoolean(key, zIsRemember);
            editorEdit.apply();
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer3 = eb.l2.f4772a;
        if (tCCPHandshakeSocketServer3 != null) {
            i8 = 1;
            tCCPHandshakeSocketServer3.sendRequest(tccpConfig.getDISCONNECT_SOCKET(), new TccpDisConnectSocketBean(tccpResponseConnectBean2.getConnectCheck() != 1));
        } else {
            i8 = 1;
        }
        if (tccpResponseConnectBean2.getConnectCheck() == i8) {
            if (Intrinsics.areEqual(eb.k1.f4766b, "ble")) {
                li.l0.p(cVar, null, null, new eb.g2(false, null), 3);
            }
            Intrinsics.checkNotNullParameter("is_first_time_connect", "key");
            SharedPreferences sharedPreferences5 = vb.f6684a;
            if (sharedPreferences5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences = null;
            } else {
                sharedPreferences = sharedPreferences5;
            }
            SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
            editorEdit2.putBoolean("is_first_time_connect", false);
            editorEdit2.apply();
            gc.c("SocketServerManager", "PC accept cast do nothing");
            eb.l2.k(tccpResponseConnectBean2.getDeviceName(), tccpResponseConnectBean2.getMac());
            return;
        }
        gc.c("SocketServerManager", "PC reject cast");
        if (Intrinsics.areEqual(eb.k1.f4766b, "ble")) {
            r7 = 0;
            i9 = 3;
            li.l0.p(cVar, null, null, new eb.d2(null), 3);
        } else {
            r7 = 0;
            i9 = 3;
        }
        if (Intrinsics.areEqual(eb.k1.f4766b, "ble")) {
            li.l0.p(cVar, r7, r7, new eb.g2(true, r7), i9);
        }
        if (Intrinsics.areEqual(eb.k1.f4766b, "cable")) {
            gc.b("SocketServerManager", "PC reject cast1");
            na.k kVar = na.k.f8141a;
            Application applicationA = pb.a();
            String string2 = pb.a().getString(R$string.module_pc_decline);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            kVar.b(applicationA, string2);
        }
        eb.l2.i(true);
    }

    @Override // pf.e0
    public Object r(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        uf.j jVar = new uf.j();
        block.invoke(jVar);
        return new uf.m(jVar.f10432b, jVar.f10433c, jVar.f10431a);
    }

    public g(ne.f fVar) {
        this.f9741a = 4;
    }
}
