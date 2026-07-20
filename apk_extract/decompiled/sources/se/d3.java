package se;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceExtension;
import com.welink.protocol.nfbd.WirelessDevice;
import com.welink.protocol.utils.LanNetworkInfo;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.IllegalBlockingModeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import k3.lb;
import k3.yd;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d3 extends we.g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final k f9705n = new k(q2.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f9706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.welink.protocol.nfbd.m f9707d;
    public t2 e;
    public b3 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f9708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f9709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f9710i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f9711j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f9712k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CountDownLatch f9713l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f9714m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d3(Context context, com.welink.protocol.nfbd.m mVar) {
        super(false, "NearLanManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9706c = context;
        this.f9707d = mVar;
        this.f9708g = new ArrayList();
        this.f9709h = new LinkedHashMap();
        this.f9710i = new LinkedHashMap();
        this.f9711j = new LinkedHashMap();
        this.f9712k = new LinkedHashMap();
        new LinkedHashMap();
        this.f9714m = new LinkedHashMap();
        this.f9707d = mVar;
        this.e = new t2(this);
        this.f = new b3(this);
        we.h.h("NearLanTcpClient", "NearLanTcpClient init");
    }

    public static void k(d3 d3Var, String str) {
        o2 o2Var = o2.WebSocket;
        d3Var.getClass();
        int i8 = c3.$EnumSwitchMapping$0[o2Var.ordinal()];
        LinkedHashMap linkedHashMap = d3Var.f9709h;
        if (i8 == 1) {
            NearDevice nearDevice = (NearDevice) linkedHashMap.get(str);
            if (nearDevice != null) {
                d3Var.l(nearDevice, str, o2Var);
                return;
            }
            return;
        }
        if (i8 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        NearDevice nearDevice2 = (NearDevice) linkedHashMap.get(str);
        if (nearDevice2 != null) {
            d3Var.l(nearDevice2, str, o2Var);
        }
    }

    public static void q() {
        if (we.m.e(1793)) {
            we.m.c(1793);
            we.h.b("NearLanTcpClient", "Lan waiting service response timer canceled");
        }
    }

    /* JADX WARN: Code duplicated, block: B:144:0x0309  */
    /* JADX WARN: Code duplicated, block: B:148:0x0314  */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:577)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:603)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    @Override // we.g
    public final void b(Message msg) throws JSONException {
        int i8;
        String str;
        NearDeviceExtension nearDeviceExtension;
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i9 = msg.what;
        ArrayList<f1> arrayList = this.f9708g;
        LinkedHashMap linkedHashMap = this.f9709h;
        switch (i9) {
            case 28672:
                o2 o2Var = o2.getEntries().get(msg.arg1);
                String string = msg.getData().getString("remoteAddress");
                NearDevice device = (NearDevice) linkedHashMap.get(string);
                if (string == null || device == null) {
                    Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                    Intrinsics.checkNotNullParameter("device is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearLanTcpClient", "TransConnect:device is null", null);
                        return;
                    }
                    return;
                }
                int i10 = c3.$EnumSwitchMapping$0[o2Var.ordinal()];
                NearDeviceExtension nearDeviceExtension2 = device.u;
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (this.f == null) {
                        this.f = new b3(this);
                    }
                    b3 b3Var = this.f;
                    if (b3Var != null) {
                        Intrinsics.checkNotNullParameter(device, "device");
                        LanNetworkInfo lanNetworkInfo = nearDeviceExtension2 != null ? nearDeviceExtension2.f3909h : null;
                        if (lanNetworkInfo == null) {
                            Intrinsics.checkNotNullParameter("WebSocketKtorClient", "tag");
                            Intrinsics.checkNotNullParameter("LanNetworkInfo is null", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("WebSocketKtorClient", "TransConnect:LanNetworkInfo is null", null);
                                return;
                            }
                            return;
                        }
                        Ref.IntRef intRef = new Ref.IntRef();
                        List<Pair> list = lanNetworkInfo.f4247n;
                        if (list != null) {
                            for (Pair pair : list) {
                                if (StringsKt__StringsJVMKt.equals((String) pair.getFirst(), "HandShake", true)) {
                                    int iIntValue = ((Number) pair.getSecond()).intValue();
                                    intRef.element = iIntValue;
                                    we.h.h("WebSocketKtorClient", "Get remotePort: " + iIntValue + ", over " + pair.getFirst());
                                }
                            }
                        }
                        int i11 = intRef.element;
                        d3 d3Var = b3Var.f9659d;
                        if (i11 == 0) {
                            com.welink.protocol.nfbd.m mVar = d3Var.f9707d;
                            if (mVar == null) {
                                str = null;
                            } else {
                                int i12 = device.e;
                                if (i12 == 0) {
                                    str = "_tranCast._tcp";
                                } else if (i12 == 1) {
                                    str = "_tranFile._tcp";
                                } else if (i12 == 4 || i12 == 5) {
                                    str = "_tranUcHo._tcp";
                                } else if (i12 != 251) {
                                    switch (i12) {
                                        case 8:
                                            str = "_tranCast._tcp";
                                            break;
                                        case 9:
                                            str = "_tranExtendCast._tcp";
                                            break;
                                        case 10:
                                            str = "_tranAudioSink._tcp";
                                            break;
                                        case 11:
                                            str = "_tranKeyboardMouseShare._tcp";
                                            break;
                                        case 12:
                                            str = "_tranCallShare._tcp";
                                            break;
                                        case 13:
                                            str = "_tranCameraShare._tcp";
                                            break;
                                        default:
                                            str = null;
                                            break;
                                    }
                                } else {
                                    str = "_tran._tcp";
                                }
                            }
                            String strM = (str == null || mVar == null) ? null : com.welink.protocol.nfbd.m.m(str);
                            List<Pair> list2 = lanNetworkInfo.f4247n;
                            if (list2 != null) {
                                for (Pair pair2 : list2) {
                                    if (strM != null && StringsKt__StringsJVMKt.equals((String) pair2.getFirst(), strM, true)) {
                                        int iIntValue2 = ((Number) pair2.getSecond()).intValue();
                                        intRef.element = iIntValue2;
                                        we.h.h("WebSocketKtorClient", "Get remotePort: " + iIntValue2 + ", over " + pair2.getFirst());
                                    }
                                    strM = strM;
                                }
                            }
                        }
                        String str2 = lanNetworkInfo.f4237a;
                        if (str2 != null && intRef.element != 0) {
                            Ref.IntRef intRef2 = new Ref.IntRef();
                            intRef2.element = 14;
                            d3Var.f9714m.put(str2, li.l0.p(li.j1.f7459a, null, null, new x2(b3Var, str2, intRef, intRef2, device, null), 3));
                            return;
                        } else {
                            Intrinsics.checkNotNullParameter("WebSocketKtorClient", "tag");
                            Intrinsics.checkNotNullParameter("remoteIp or remotePort is null", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("WebSocketKtorClient", "TransConnect:remoteIp or remotePort is null", null);
                            }
                            d3Var.o(device, null, 13);
                            return;
                        }
                    }
                    return;
                }
                if (this.e == null) {
                    this.e = new t2(this);
                }
                t2 t2Var = this.e;
                if (t2Var != null) {
                    Intrinsics.checkNotNullParameter(device, "device");
                    LanNetworkInfo lanNetworkInfo2 = nearDeviceExtension2 != null ? nearDeviceExtension2.f3909h : null;
                    if (lanNetworkInfo2 == null) {
                        Intrinsics.checkNotNullParameter("TcpHskClient", "tag");
                        Intrinsics.checkNotNullParameter("LanNetworkInfo is null", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("TcpHskClient", "TransConnect:LanNetworkInfo is null", null);
                            return;
                        }
                        return;
                    }
                    List<Pair> list3 = lanNetworkInfo2.f4247n;
                    int iIntValue3 = 0;
                    if (list3 != null) {
                        for (Pair pair3 : list3) {
                            if (StringsKt__StringsJVMKt.equals((String) pair3.getFirst(), "HandShake", true)) {
                                iIntValue3 = ((Number) pair3.getSecond()).intValue();
                            }
                        }
                    }
                    String str3 = lanNetworkInfo2.f4237a;
                    if (str3 == null || iIntValue3 == 0) {
                        Intrinsics.checkNotNullParameter("TcpHskClient", "tag");
                        Intrinsics.checkNotNullParameter("remoteIp or remotePort is null", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("TcpHskClient", "TransConnect:remoteIp or remotePort is null", null);
                            return;
                        }
                        return;
                    }
                    Socket socket = new Socket();
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(str3, iIntValue3);
                    we.h.h("TcpHskClient", "connect to " + str3 + ":" + iIntValue3);
                    try {
                        try {
                            try {
                                socket.connect(inetSocketAddress, PathInterpolatorCompat.MAX_NUM_POINTS);
                                we.h.h("TcpHskClient", "connect success");
                                t2Var.d(device, socket);
                                if (!socket.isConnected()) {
                                    t2Var.e(device, socket, 14);
                                    return;
                                }
                            } catch (Throwable th2) {
                                if (socket.isConnected()) {
                                    t2Var.a(device, socket);
                                } else {
                                    t2Var.e(device, socket, 14);
                                }
                                throw th2;
                            }
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                            Intrinsics.checkNotNullParameter("TcpHskClient", "tag");
                            Intrinsics.checkNotNullParameter("connect illegal argument", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("TcpHskClient", "TransConnect:connect illegal argument", e);
                            }
                            if (!socket.isConnected()) {
                                i8 = 19;
                                t2Var.e(device, socket, i8);
                                return;
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            Intrinsics.checkNotNullParameter("TcpHskClient", "tag");
                            Intrinsics.checkNotNullParameter("connect exception failed", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("TcpHskClient", "TransConnect:connect exception failed", e4);
                            }
                            if (!socket.isConnected()) {
                                i8 = 17;
                                t2Var.e(device, socket, i8);
                                return;
                            }
                        }
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        Intrinsics.checkNotNullParameter("TcpHskClient", "tag");
                        Intrinsics.checkNotNullParameter("connect io error", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("TcpHskClient", "TransConnect:connect io error", e10);
                        }
                        if (!socket.isConnected()) {
                            i8 = 15;
                            t2Var.e(device, socket, i8);
                            return;
                        }
                    } catch (IllegalBlockingModeException e11) {
                        e11.printStackTrace();
                        Intrinsics.checkNotNullParameter("TcpHskClient", "tag");
                        Intrinsics.checkNotNullParameter("connect illegal blocking mode", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("TcpHskClient", "TransConnect:connect illegal blocking mode", e11);
                        }
                        if (!socket.isConnected()) {
                            i8 = 18;
                            t2Var.e(device, socket, i8);
                            return;
                        }
                    }
                    t2Var.a(device, socket);
                    return;
                }
                return;
            case 28673:
                o2 o2Var2 = o2.getEntries().get(msg.arg1);
                String string2 = msg.getData().getString("remoteAddress");
                NearDevice nearDevice = (NearDevice) linkedHashMap.get(string2);
                if (string2 != null && nearDevice != null) {
                    r(nearDevice, o2Var2);
                    return;
                }
                Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                Intrinsics.checkNotNullParameter("device is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearLanTcpClient", "TransConnect:device is null", null);
                    return;
                }
                return;
            case 28674:
                String string3 = msg.getData().getString("remoteAddress");
                msg.getData().getString("localAddress");
                NearDevice nearDevice2 = (NearDevice) linkedHashMap.get(string3);
                if (string3 == null || nearDevice2 == null) {
                    Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                    Intrinsics.checkNotNullParameter("device is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearLanTcpClient", "TransConnect:device is null", null);
                        return;
                    }
                    return;
                }
                for (f1 f1Var : arrayList) {
                    NearDeviceExtension nearDeviceExtension3 = nearDevice2.u;
                    f1Var.b(nearDeviceExtension3 != null ? nearDeviceExtension3.f3909h : null, nearDevice2);
                }
                return;
            case 28675:
                String string4 = msg.getData().getString("remoteAddress");
                msg.getData().getString("localAddress");
                NearDevice nearDevice3 = (NearDevice) TypeIntrinsics.asMutableMap(linkedHashMap).remove(string4);
                int i13 = msg.getData().getInt("reasonCode");
                if (i13 == -1) {
                    i13 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                } else if (i13 == 20 || i13 == 21) {
                    we.h.h("NearLanTcpClient", "Device LAN waiting response timeout, close the connection");
                    if (nearDevice3 != null) {
                        r(nearDevice3, o2.WebSocket);
                    }
                }
                if (string4 == null || nearDevice3 == null) {
                    we.h.j("NearLanTcpClient", "remote Ip or device is null");
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((f1) it.next()).c((nearDevice3 == null || (nearDeviceExtension = nearDevice3.u) == null) ? null : nearDeviceExtension.f3909h, nearDevice3, i13);
                }
                return;
            case 28676:
                String string5 = msg.getData().getString("remoteAddress");
                String string6 = msg.getData().getString("localAddress");
                byte[] byteArray = msg.getData().getByteArray("data");
                we.h.h("NearLanTcpClient", "Received data: " + byteArray);
                if (byteArray != null) {
                    if (string5 == null || string6 == null) {
                        we.h.c("NearLanTcpClient", h0.a.k("Received data without address: ", string5, " -> ", string6), null);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(new String(byteArray, Charsets.UTF_8));
                        String string7 = jSONObject.getString("Version");
                        jSONObject.getInt("Encrypt");
                        if (Intrinsics.areEqual(string7, "1.0")) {
                            p(jSONObject, string7, string5, string6);
                            return;
                        }
                        if (Intrinsics.areEqual(string7, "2.0")) {
                            p(jSONObject, string7, string5, string6);
                            return;
                        }
                        Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                        Intrinsics.checkNotNullParameter("parseIncomingRequest: version is not support", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearLanTcpClient", "TransConnect:parseIncomingRequest: version is not support", null);
                            return;
                        }
                        return;
                    } catch (Exception e12) {
                        String mes = "parseIncomingRequest: " + e12;
                        Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c >= 1) {
                            h0.a.x("TransConnect:", mes, "NearLanTcpClient", null);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 28677:
                String string8 = msg.getData().getString("remoteAddress");
                String string9 = msg.getData().getString("deviceId");
                boolean z2 = msg.getData().getBoolean("trust");
                NearDevice nearDevice4 = (NearDevice) linkedHashMap.get(string8);
                if (nearDevice4 == null || string9 == null || !Intrinsics.areEqual(string9, nearDevice4.f3885c) || !z2) {
                    return;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((f1) it2.next()).e(nearDevice4);
                }
                return;
            case 28678:
                String string10 = msg.getData().getString("remoteAddress");
                String string11 = msg.getData().getString("deviceId");
                NearDevice nearDevice5 = (NearDevice) linkedHashMap.get(string10);
                if (nearDevice5 == null || string11 == null || !Intrinsics.areEqual(string11, nearDevice5.f3885c)) {
                    return;
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((f1) it3.next()).d(nearDevice5);
                }
                return;
            default:
                return;
        }
    }

    public final byte[] j(NearDevice nearDevice, String str) {
        String str2;
        Map map = com.welink.protocol.nfbd.h.f4132a;
        int iD = com.welink.protocol.nfbd.h.d(nearDevice.e);
        if (str == null) {
            str2 = this.f9707d != null ? "1.0" : null;
        } else {
            str2 = str;
        }
        if (str != null) {
            LinkedHashMap linkedHashMap = this.f9712k;
            String strS = nearDevice.s();
            linkedHashMap.put(Integer.valueOf(strS != null ? strS.hashCode() : 0), str);
        }
        if (Intrinsics.areEqual(str2, "1.0")) {
            String string = m(iD, nearDevice, str2).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        if (Intrinsics.areEqual(str2, "2.0")) {
            String string2 = m(iD, nearDevice, str2).toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            byte[] bytes2 = string2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return bytes2;
        }
        Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
        Intrinsics.checkNotNullParameter("buildConnectRequest: matchedVersion is not support", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearLanTcpClient", "TransConnect:buildConnectRequest: matchedVersion is not support", null);
        }
        return null;
    }

    public final void l(NearDevice device, String str, o2 socketMethod) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
        NearDeviceExtension nearDeviceExtension = device.u;
        LanNetworkInfo lanNetworkInfo = nearDeviceExtension != null ? nearDeviceExtension.f3909h : null;
        if ((lanNetworkInfo != null ? lanNetworkInfo.f4247n : null) == null) {
            Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
            Intrinsics.checkNotNullParameter("wirelessNetworkInfo is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearLanTcpClient", "TransConnect:wirelessNetworkInfo is null", null);
                return;
            }
            return;
        }
        if (str == null) {
            str = lanNetworkInfo.f4237a;
        }
        List<Pair> list = lanNetworkInfo.f4247n;
        if (list != null) {
            for (Pair pair : list) {
                if (StringsKt__StringsJVMKt.equals((String) pair.getFirst(), "HandShake", true)) {
                    ((Number) pair.getSecond()).intValue();
                }
            }
        }
        if (str != null) {
            Message message = new Message();
            message.what = 28673;
            message.arg1 = socketMethod.ordinal();
            message.getData().putString("remoteAddress", str);
            i(message);
            return;
        }
        Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
        Intrinsics.checkNotNullParameter("remoteIp is null", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearLanTcpClient", "TransConnect:remoteIp is null", null);
        }
    }

    public final JSONObject m(int i8, NearDevice nearDevice, String version) throws JSONException {
        String strJoinToString$default;
        Byte bValueOf;
        Byte bValueOf2;
        String strConcat;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArrG;
        byte[] bArrK;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", version);
        jSONObject.put("Encrypt", 0);
        jSONObject.put("ReqType", i8);
        BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
        byte[] bArrM = ne.b.m();
        if (bArrM != null) {
            Intrinsics.checkNotNullParameter(bArrM, "<this>");
            Intrinsics.checkNotNullParameter(":", "separator");
            strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(bArrM, (CharSequence) ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new qg.y0(16), 30, (Object) null);
        } else {
            strJoinToString$default = null;
        }
        jSONObject.put("DeviceId", strJoinToString$default);
        jSONObject.put("ClientP2pMode", 0);
        jSONObject.put("ServerP2pMode", 0);
        jSONObject.put("FileCount", 0);
        jSONObject.put("FileName", "");
        jSONObject.put("TotalFileSize", 0);
        jSONObject.put("Ssid", "");
        jSONObject.put("Pwd", "");
        jSONObject.put("Mac", "");
        jSONObject.put("Chan", -1);
        jSONObject.put("Freq", 0);
        jSONObject.put("GoIpAddr", "");
        jSONObject.put("Port", 0);
        jSONObject.put("MessagePort", 0);
        jSONObject.put("DeviceName", ne.b.h(this.f9706c));
        jSONObject.put("DeviceMac", "02:00:00:00:00:00");
        com.welink.protocol.nfbd.m mVar = this.f9707d;
        if (mVar != null) {
            byte[] bArr3 = mVar.f4172d;
            bValueOf = Byte.valueOf(bArr3 != null ? bArr3[1] : (byte) 13);
        } else {
            bValueOf = null;
        }
        jSONObject.put("ProductSubType", bValueOf);
        if (mVar != null) {
            byte[] bArr4 = mVar.f4172d;
            bValueOf2 = Byte.valueOf(bArr4 != null ? bArr4[3] : (byte) -1);
        } else {
            bValueOf2 = null;
        }
        jSONObject.put("ProductBrandName", bValueOf2);
        if (mVar != null) {
            try {
                byte[] bArr5 = mVar.f4172d;
                byte b9 = bArr5 != null ? bArr5[7] : (byte) 0;
                byte b10 = bArr5 != null ? bArr5[8] : (byte) 1;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                strConcat = str.concat(str2);
            } catch (Exception e) {
                String mes = "getProductCode: " + e;
                Intrinsics.checkNotNullParameter("NearBleManager", "tag");
                Intrinsics.checkNotNullParameter(mes, "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", mes, "NearBleManager", null);
                }
                strConcat = "0001";
            }
        } else {
            strConcat = null;
        }
        jSONObject.put("ProductNameCode", strConcat);
        Map map = com.welink.protocol.nfbd.h.f4132a;
        jSONObject.put("ServiceType", com.welink.protocol.nfbd.h.d(nearDevice.e));
        jSONObject.put("SubCapability", nearDevice.f3887h);
        jSONObject.put("Protocol", 0);
        int i9 = nearDevice.e;
        if (mVar == null) {
            bArr = null;
        } else if (i9 == 0) {
            bArr = new byte[12];
            BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
            bArr[0] = (byte) ne.b.f();
            bArr[1] = 17;
        } else if (i9 == 1) {
            BluetoothAdapter bluetoothAdapter3 = ne.b.f8183a;
            bArr = new byte[]{(byte) ne.b.f(), 0};
        } else if (i9 != 4 && i9 != 5) {
            switch (i9) {
                case 8:
                    BluetoothAdapter bluetoothAdapter4 = ne.b.f8183a;
                    bArr = new byte[]{(byte) ne.b.f(), 0};
                    break;
                case 9:
                    BluetoothAdapter bluetoothAdapter5 = ne.b.f8183a;
                    bArr = new byte[]{(byte) ne.b.f(), 0};
                    break;
                case 10:
                    BluetoothAdapter bluetoothAdapter6 = ne.b.f8183a;
                    bArr = new byte[]{(byte) ne.b.f(), 0};
                    break;
                case 11:
                    BluetoothAdapter bluetoothAdapter7 = ne.b.f8183a;
                    bArr = new byte[]{(byte) ne.b.f(), 0};
                    break;
                case 12:
                    BluetoothAdapter bluetoothAdapter8 = ne.b.f8183a;
                    bArr = new byte[]{(byte) ne.b.f(), 0};
                    break;
                case 13:
                    BluetoothAdapter bluetoothAdapter9 = ne.b.f8183a;
                    bArr = new byte[]{(byte) ne.b.f(), 0};
                    break;
                default:
                    String strM = o.d.m("getServiceData: unknown service type: ", "NearBleManager", "tag", "mes", i9);
                    if (lb.f6529c >= 1) {
                        h0.a.x("TransConnect:", strM, "NearBleManager", null);
                    }
                    bArr = null;
                    break;
            }
        } else {
            BluetoothAdapter bluetoothAdapter10 = ne.b.f8183a;
            bArr = new byte[]{(byte) ne.b.f(), 0};
        }
        if (bArr != null) {
            jSONObject.put("ServiceData", Base64.encodeToString(bArr, 0));
        } else {
            if (mVar != null) {
                Intrinsics.checkNotNullParameter(version, "version");
                UInt uIntM248boximpl = UInt.m248boximpl(UInt.m254constructorimpl((int) (nearDevice.f3888i & 4294967295L)));
                if (i9 == 251) {
                    if (com.welink.protocol.nfbd.m.f4170t.d(version)) {
                        if (uIntM248boximpl == null || uIntM248boximpl.getData() == 0) {
                            bArrK = mVar.f4176j;
                            if (bArrK != null) {
                                Intrinsics.checkNotNull(bArrK);
                            } else {
                                bArrK = new byte[]{-1, -1};
                            }
                        } else {
                            BluetoothAdapter bluetoothAdapter11 = ne.b.f8183a;
                            bArrK = ne.b.k(uIntM248boximpl.getData());
                        }
                        BluetoothAdapter bluetoothAdapter12 = ne.b.f8183a;
                        bArrG = ne.b.g(bArrK);
                    } else {
                        bArrG = ne.b.g(null);
                    }
                    bArr2 = new byte[]{bArrG[0], bArrG[1]};
                } else {
                    String strH = o.d.h(i9, "getCapability: unknown service type: ", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", strH, null);
                    }
                    bArr2 = null;
                }
            } else {
                bArr2 = null;
            }
            if (bArr2 != null) {
                jSONObject.put("ServiceData", Base64.encodeToString(bArr2, 0));
            } else {
                jSONObject.put("ServiceData", "");
                we.h.j("NearLanTcpClient", "buildConnectRequest: serviceData and capability is null");
                Unit unit = Unit.INSTANCE;
            }
        }
        ArrayList arrayListE = mVar != null ? ye.h.e() : null;
        if (arrayListE != null) {
            jSONObject.put("BandSupport", CollectionsKt___CollectionsKt.joinToString$default(arrayListE, " ", null, null, 0, null, null, 62, null));
        }
        if (com.welink.protocol.nfbd.m.f4170t.d(version)) {
            long j8 = nearDevice.f3888i;
            if (j8 != 0) {
                jSONObject.put("TargetService", j8);
            }
        }
        return jSONObject;
    }

    public final void n(String remoteAddress, String localAddress, byte[] data) {
        Intrinsics.checkNotNullParameter(remoteAddress, "remoteAddress");
        Intrinsics.checkNotNullParameter(localAddress, "localAddress");
        Intrinsics.checkNotNullParameter(data, "data");
        Message messageD = d();
        messageD.what = 28676;
        messageD.getData().putString("remoteAddress", remoteAddress);
        messageD.getData().putString("localAddress", localAddress);
        messageD.getData().putByteArray("data", data);
        i(messageD);
    }

    public final void o(NearDevice nearDevice, String str, Integer num) {
        Message message = new Message();
        message.what = 28675;
        Bundle data = message.getData();
        if (str == null) {
            str = nearDevice.s();
        }
        data.putString("remoteAddress", str);
        Bundle data2 = message.getData();
        String strL = nearDevice.l();
        if (strL == null) {
            strL = "127.0.0.1";
        }
        data2.putString("localAddress", strL);
        message.getData().putInt("reasonCode", num != null ? num.intValue() : -1);
        i(message);
    }

    public final void p(JSONObject jSONObject, String str, String remoteAddress, String ipAddress) throws JSONException {
        String string;
        int i8 = jSONObject.getInt("ReqType");
        int iOptInt = jSONObject.optInt("state");
        int iOptInt2 = jSONObject.optInt("ServerP2pMode");
        int i9 = i8 & 255;
        try {
            string = jSONObject.getString("DeviceId");
        } catch (Exception unused) {
            string = "";
        }
        int i10 = i8 & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        if (i10 == 43520 || i10 == 47872 || i10 == 52224) {
            if (iOptInt == 16) {
                we.h.b("NearLanTcpClient", "Device send pc device ready, restart timer");
                t(remoteAddress, 35000L);
                return;
            }
            LinkedHashMap linkedHashMap = this.f9709h;
            switch (iOptInt) {
                case 0:
                    we.h.h("NearLanTcpClient", "Server Device idle response, send connection request");
                    if (i9 != 0 && i9 != 1 && i9 != 4 && i9 != 5 && i9 != 8 && i9 != 251) {
                        switch (i9) {
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                break;
                            default:
                                q();
                                k(this, remoteAddress);
                                we.h.b("NearLanTcpClient", "Unsupported request type: " + i9);
                                return;
                        }
                    }
                    we.h.b("NearLanTcpClient", "Supported scenario");
                    t(remoteAddress, 3000L);
                    return;
                case 1:
                    we.h.b("NearLanTcpClient", "Device is busy, ignore the request");
                    q();
                    k(this, remoteAddress);
                    return;
                case 2:
                    we.h.b("NearLanTcpClient", "Device accept the request, send connection response");
                    if (i9 != 0 && i9 != 1 && i9 != 4 && i9 != 5 && i9 != 8 && i9 != 251) {
                        switch (i9) {
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                break;
                            default:
                                q();
                                k(this, remoteAddress);
                                we.h.b("NearLanTcpClient", "Unsupported request type: " + i9);
                                return;
                        }
                    }
                    we.h.b("NearLanTcpClient", "Supported scenario");
                    if (iOptInt2 == 0) {
                        we.h.b("NearLanTcpClient", "Server mode is no P2P, unsupported");
                    } else if (iOptInt2 == 1) {
                        we.h.j("NearLanTcpClient", "Server mode is P2P GC, unsupported");
                    } else if (iOptInt2 != 2) {
                        h0.a.C(iOptInt2, "Unsupported server p2p mode: ", "NearLanTcpClient");
                    } else {
                        we.h.j("NearLanTcpClient", "Server mode is P2P GO, unsupported");
                    }
                    q();
                    NearDevice nearDevice = (NearDevice) linkedHashMap.get(remoteAddress);
                    if (nearDevice == null) {
                        we.h.c("NearLanTcpClient", "Device is null or socket is null, ignore the connection accept response", null);
                        k(this, remoteAddress);
                        return;
                    }
                    we.h.h("NearLanTcpClient", "onNotifyNearDeviceConnected: " + nearDevice.s());
                    if (nearDevice.l() == null) {
                        Intrinsics.checkNotNullParameter(ipAddress, "ipAddress");
                        WirelessDevice wirelessDevice = nearDevice.f3896s;
                        if (wirelessDevice instanceof WirelessDevice.Wlan) {
                            Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Wlan");
                            ((WirelessDevice.Wlan) wirelessDevice).f4026c = ipAddress;
                        }
                    }
                    Message message = new Message();
                    message.what = 28674;
                    message.getData().putString("remoteAddress", nearDevice.s());
                    message.getData().putString("localAddress", ipAddress);
                    i(message);
                    if (com.welink.protocol.nfbd.m.f4170t.d(str) && jSONObject.optBoolean("Trust")) {
                        we.h.b("NearLanTcpClient", "Device is trusted, send notification to upper layer");
                        Intrinsics.checkNotNull(string);
                        Message message2 = new Message();
                        message2.what = 28677;
                        message2.getData().putString("remoteAddress", remoteAddress);
                        message2.getData().putString("deviceId", string);
                        message2.getData().putBoolean("trust", true);
                        i(message2);
                        return;
                    }
                    return;
                case 3:
                    we.h.h("NearLanTcpClient", "Device reject the request due to user, close the connection");
                    q();
                    k(this, remoteAddress);
                    Intrinsics.checkNotNull(string);
                    Message message3 = new Message();
                    message3.what = 28678;
                    message3.getData().putString("remoteAddress", remoteAddress);
                    message3.getData().putString("deviceId", string);
                    i(message3);
                    return;
                case 4:
                    we.h.b("NearLanTcpClient", "Device send p2p info, ignore the request");
                    return;
                case 5:
                    we.h.j("NearLanTcpClient", "Remote device support max version is " + str);
                    q();
                    String str2 = this.f9707d != null ? "1.0" : null;
                    if (str2 != null) {
                        List listSplit$default = StringsKt__StringsKt.split$default(str2, new String[]{"."}, false, 0, 6, (Object) null);
                        ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
                        Iterator it = listSplit$default.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
                        }
                        List listSplit$default2 = StringsKt__StringsKt.split$default(str, new String[]{"."}, false, 0, 6, (Object) null);
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(listSplit$default2));
                        Iterator it2 = listSplit$default2.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
                        }
                        if (((Number) arrayList.get(0)).intValue() > ((Number) arrayList2.get(0)).intValue() || (((Number) arrayList.get(0)).intValue() == ((Number) arrayList2.get(0)).intValue() && ((Number) arrayList.get(1)).intValue() >= ((Number) arrayList2.get(1)).intValue())) {
                            we.h.b("NearLanTcpClient", "Remote device support max version, send connection request");
                            o2 socketMethod = o2.WebSocket;
                            Intrinsics.checkNotNullParameter(remoteAddress, "remoteAddress");
                            Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
                            int i11 = c3.$EnumSwitchMapping$0[socketMethod.ordinal()];
                            if (i11 == 1) {
                                NearDevice nearDevice2 = (NearDevice) linkedHashMap.get(remoteAddress);
                                Socket socket = (Socket) this.f9710i.get(remoteAddress);
                                if (nearDevice2 != null && socket != null) {
                                    yd ydVar = new yd(this, nearDevice2, socket, str, 2);
                                    ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                                    we.m.a(1792, 50L, a(), ydVar);
                                    return;
                                } else {
                                    Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                                    Intrinsics.checkNotNullParameter("Device is null or socket is null", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("NearLanTcpClient", "TransConnect:Device is null or socket is null", null);
                                    }
                                    k(this, remoteAddress);
                                    return;
                                }
                            }
                            if (i11 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            NearDevice nearDevice3 = (NearDevice) linkedHashMap.get(remoteAddress);
                            uf.d dVar = (uf.d) this.f9711j.get(remoteAddress);
                            if (nearDevice3 != null && dVar != null) {
                                af.r4 r4Var = new af.r4(this, nearDevice3, remoteAddress, dVar, str, 2);
                                ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
                                we.m.a(1792, 50L, a(), r4Var);
                                return;
                            } else {
                                Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                                Intrinsics.checkNotNullParameter("Device is null or session is null", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("NearLanTcpClient", "TransConnect:Device is null or session is null", null);
                                }
                                k(this, remoteAddress);
                                return;
                            }
                        }
                    }
                    we.h.j("NearLanTcpClient", "Unsupported version, close the connection");
                    q();
                    k(this, remoteAddress);
                    return;
                case 6:
                    we.h.j("NearLanTcpClient", "Remote device is not recognized, close the connection");
                    q();
                    k(this, remoteAddress);
                    return;
                case 7:
                    we.h.h("NearLanTcpClient", "Device reject the request due to timeout, close the connection");
                    q();
                    k(this, remoteAddress);
                    return;
                case 8:
                    we.h.h("NearLanTcpClient", "Device reject the request due to unavailable, close the connection");
                    q();
                    k(this, remoteAddress);
                    return;
                case 9:
                    we.h.h("NearLanTcpClient", "Device reject the request due to unknown, close the connection");
                    q();
                    k(this, remoteAddress);
                    return;
                default:
                    return;
            }
        }
    }

    public final void r(NearDevice nearDevice, o2 o2Var) {
        int i8 = c3.$EnumSwitchMapping$0[o2Var.ordinal()];
        if (i8 == 1) {
            t2 t2Var = this.e;
            if (t2Var != null) {
                t2Var.b(nearDevice, null);
                return;
            }
            return;
        }
        if (i8 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        b3 b3Var = this.f;
        if (b3Var != null) {
            b3Var.c(nearDevice, null);
        }
    }

    public final void s(NearDevice nearDevice, String str, Long l4) {
        af.m0 m0Var = new af.m0(this, nearDevice, str, 9, false);
        if (we.m.e(1793)) {
            we.h.b("NearLanTcpClient", "GATT waiting go created notify timer already started, update timer");
            we.m.h(1793, l4.longValue(), a(), m0Var);
        } else {
            we.h.b("NearLanTcpClient", "GATT waiting go created notify timer started");
            we.m.a(1793, l4.longValue(), a(), m0Var);
        }
    }

    public final void t(String str, long j8) {
        NearDevice nearDevice = (NearDevice) this.f9709h.get(str);
        if (nearDevice != null) {
            s(nearDevice, str, Long.valueOf(j8));
        }
    }
}
