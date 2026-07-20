package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import li.v0;
import org.json.JSONException;
import org.json.JSONObject;
import qg.y0;
import se.e3;
import se.f1;
import se.i3;
import se.o2;
import se.t3;
import se.u3;
import se.v3;
import se.w3;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends we.g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final se.k f4184k = new se.k(e3.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f4185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f4186d;
    public i3 e;
    public t3 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashSet f4187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f4188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f4189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final qi.c f4190j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, m mVar) {
        super(false, "NearLanManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f4185c = context;
        this.f4187g = new LinkedHashSet();
        this.f4188h = new LinkedHashSet();
        this.f4189i = new LinkedHashMap();
        v0 v0Var = v0.f7498a;
        this.f4190j = li.h0.a(si.e.f10118a);
        this.f4186d = mVar;
    }

    public static int j(p pVar) {
        o2 socketMethod = o2.WebSocket;
        pVar.getClass();
        Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
        int i8 = u3.$EnumSwitchMapping$0[socketMethod.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            t3 t3Var = pVar.f;
            if (t3Var != null) {
                return t3Var.f10000a;
            }
            return 0;
        }
        i3 i3Var = pVar.e;
        if (i3Var != null) {
            return i3Var.f9803g;
        }
        if (i3Var != null) {
            return i3Var.f9799a;
        }
        return 0;
    }

    public static boolean l(p pVar) {
        boolean zIsEmpty;
        o2 socketMethod = o2.WebSocket;
        pVar.getClass();
        Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
        int i8 = u3.$EnumSwitchMapping$0[socketMethod.ordinal()];
        if (i8 == 1) {
            i3 i3Var = pVar.e;
            if (i3Var == null) {
                return false;
            }
            zIsEmpty = i3Var.e.isEmpty();
        } else {
            if (i8 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            t3 t3Var = pVar.f;
            if (t3Var == null) {
                return false;
            }
            zIsEmpty = t3Var.f10001b.isEmpty();
        }
        return !zIsEmpty;
    }

    public static boolean m(p pVar) {
        o2 socketMethod = o2.WebSocket;
        pVar.getClass();
        Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
        int i8 = u3.$EnumSwitchMapping$0[socketMethod.ordinal()];
        if (i8 == 1) {
            i3 i3Var = pVar.e;
            if (i3Var != null) {
                return i3Var.f;
            }
            return false;
        }
        if (i8 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        t3 t3Var = pVar.f;
        if (t3Var != null) {
            return t3Var.f;
        }
        return false;
    }

    public static void w(p pVar) {
        o2 socketMethod = o2.WebSocket;
        pVar.getClass();
        Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
        int i8 = u3.$EnumSwitchMapping$0[socketMethod.ordinal()];
        if (i8 == 1) {
            i3 i3Var = pVar.e;
            if (i3Var != null) {
                i3Var.n();
                return;
            }
            return;
        }
        if (i8 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        t3 t3Var = pVar.f;
        if (t3Var != null) {
            t3Var.f();
        }
    }

    @Override // we.g
    public final void b(Message msg) throws JSONException {
        o2 o2Var;
        p pVar;
        m mVar;
        String strS;
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i8 = msg.what;
        LinkedHashSet<f1> linkedHashSet = this.f4188h;
        LinkedHashSet linkedHashSet2 = this.f4187g;
        switch (i8) {
            case 24576:
                int i9 = msg.arg1;
                for (f1 f1Var : linkedHashSet) {
                    switch (f1Var.f9738a) {
                        case 0:
                            break;
                        default:
                            m mVar2 = (m) f1Var.f9739b;
                            mVar2.getClass();
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 20481;
                            messageObtain.arg1 = i9;
                            Intrinsics.checkNotNull(messageObtain);
                            mVar2.i(messageObtain);
                            break;
                    }
                }
                return;
            case 24577:
                for (f1 f1Var2 : linkedHashSet) {
                    switch (f1Var2.f9738a) {
                        case 0:
                            break;
                        default:
                            m mVar3 = (m) f1Var2.f9739b;
                            mVar3.getClass();
                            Message messageObtain2 = Message.obtain();
                            messageObtain2.what = 20482;
                            Intrinsics.checkNotNull(messageObtain2);
                            mVar3.i(messageObtain2);
                            break;
                    }
                }
                return;
            case 24578:
                String string = msg.getData().getString("address");
                if (string != null) {
                    linkedHashSet2.add(string);
                    return;
                }
                return;
            case 24579:
                String string2 = msg.getData().getString("address");
                Iterator<o2> it = o2.getEntries().iterator();
                while (true) {
                    if (it.hasNext()) {
                        o2 next = it.next();
                        if (next.ordinal() == msg.arg1) {
                            o2Var = next;
                        }
                    } else {
                        o2Var = null;
                    }
                }
                o2 o2Var2 = o2Var;
                if (o2Var2 == null) {
                    o2Var2 = o2.WebSocket;
                }
                if (string2 != null) {
                    linkedHashSet2.remove(string2);
                    pVar = this;
                    NearDevice nearDevice = (NearDevice) pVar.f4189i.remove(string2);
                    if (nearDevice != null && (strS = nearDevice.s()) != null) {
                        pVar.q(strS, nearDevice.l(), nearDevice);
                    }
                } else {
                    pVar = this;
                }
                if (!linkedHashSet2.isEmpty() || (mVar = pVar.f4186d) == null || mVar.f4180n) {
                    return;
                }
                int i10 = u3.$EnumSwitchMapping$0[o2Var2.ordinal()];
                if (i10 == 1) {
                    we.h.h("NearLanTcpServer", "Advertising has been stopped?, TcpServer server stop");
                    i3 i3Var = pVar.e;
                    if (i3Var != null) {
                        i3Var.n();
                        return;
                    }
                    return;
                }
                if (i10 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                we.h.h("NearLanTcpServer", "Advertising has been stopped?, WebSocket server stop");
                t3 t3Var = pVar.f;
                if (t3Var != null) {
                    t3Var.f();
                    return;
                }
                return;
            case 24580:
                String string3 = msg.getData().getString("remoteAddress");
                String string4 = msg.getData().getString("localAddress");
                byte[] byteArray = msg.getData().getByteArray("data");
                we.h.h("NearLanTcpServer", "Received data: " + byteArray);
                if (byteArray != null) {
                    if (string3 == null || string4 == null) {
                        we.h.c("NearLanTcpServer", h0.a.k("Received data without address: ", string3, " -> ", string4), null);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(new String(byteArray, Charsets.UTF_8));
                        String string5 = jSONObject.getString("Version");
                        int i11 = jSONObject.getInt("Encrypt");
                        int i12 = jSONObject.getInt("ReqType");
                        Intrinsics.checkNotNull(string5);
                        List listSplit$default = StringsKt__StringsKt.split$default("1.0", new String[]{"."}, false, 0, 6, (Object) null);
                        ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
                        Iterator it2 = listSplit$default.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
                        }
                        List listSplit$default2 = StringsKt__StringsKt.split$default(string5, new String[]{"."}, false, 0, 6, (Object) null);
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(listSplit$default2));
                        Iterator it3 = listSplit$default2.iterator();
                        while (it3.hasNext()) {
                            arrayList2.add(Integer.valueOf(Integer.parseInt((String) it3.next())));
                        }
                        if (((Number) arrayList.get(0)).intValue() <= ((Number) arrayList2.get(0)).intValue() && (((Number) arrayList.get(0)).intValue() != ((Number) arrayList2.get(0)).intValue() || ((Number) arrayList.get(1)).intValue() < ((Number) arrayList2.get(1)).intValue())) {
                            Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
                            Intrinsics.checkNotNullParameter("Unsupported version or encrypt", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearLanTcpServer", "TransConnect:Unsupported version or encrypt", null);
                            }
                            CollectionsKt.emptyList();
                            v3 v3Var = new v3(this, string3, "1.0", i11, i12 & 255, 5);
                            ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                            we.m.a(1536, 10L, a(), v3Var);
                            return;
                        }
                        if (Intrinsics.areEqual(string5, "1.0") && i11 == 0) {
                            o.d.z("Received connect request: version: ", string5, "NearLanTcpServer");
                            s(jSONObject, string5, i11, string3, string4);
                            return;
                        }
                        if (Intrinsics.areEqual(string5, "2.0") && i11 == 0) {
                            o.d.z("Received connect request: version: ", string5, "NearLanTcpServer");
                            s(jSONObject, string5, i11, string3, string4);
                            return;
                        }
                        Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
                        Intrinsics.checkNotNullParameter("Unsupported version or encrypt", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearLanTcpServer", "TransConnect:Unsupported version or encrypt", null);
                        }
                        CollectionsKt.emptyList();
                        v3 v3Var2 = new v3(this, string3, string5, i11, i12 & 255, 6);
                        ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
                        we.m.a(1536, 10L, a(), v3Var2);
                        return;
                    } catch (Exception e) {
                        String mes = "parseIncomingRequest: " + e;
                        Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c >= 1) {
                            h0.a.x("TransConnect:", mes, "NearLanTcpServer", null);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 24581:
                linkedHashSet2.clear();
                return;
            default:
                String strM = o.d.m("Unknown message: ", "NearLanTcpServer", "tag", "mes", i8);
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", strM, "NearLanTcpServer", null);
                    return;
                }
                return;
        }
    }

    public final void k(String str, String str2, ConnectRequest connectRequest) {
        LanNetworkInfo lanNetworkInfo = new LanNetworkInfo(str, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4092);
        Iterator it = this.f4188h.iterator();
        while (it.hasNext()) {
            ((f1) it.next()).a(lanNetworkInfo, connectRequest);
        }
    }

    public final void n(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        we.h.h("NearLanTcpServer", "Device connected: ".concat(address));
        Message messageD = d();
        messageD.what = 24578;
        messageD.getData().putString("address", address);
        i(messageD);
    }

    public final void o(String address, o2 socketMethod) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
        we.h.h("NearLanTcpServer", "Device disconnected: ".concat(address));
        Message messageD = d();
        messageD.what = 24579;
        messageD.arg1 = socketMethod.ordinal();
        messageD.getData().putString("address", address);
        i(messageD);
    }

    public final void p(String remoteAddress, String localAddress, byte[] data) {
        Intrinsics.checkNotNullParameter(remoteAddress, "remoteAddress");
        Intrinsics.checkNotNullParameter(localAddress, "localAddress");
        Intrinsics.checkNotNullParameter(data, "data");
        Message messageD = d();
        messageD.what = 24580;
        messageD.getData().putString("remoteAddress", remoteAddress);
        messageD.getData().putString("localAddress", localAddress);
        messageD.getData().putByteArray("data", data);
        i(messageD);
    }

    public final void q(String str, String str2, NearDevice nearDevice) {
        LanNetworkInfo lanNetworkInfo = new LanNetworkInfo(str, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4092);
        Iterator it = this.f4188h.iterator();
        while (it.hasNext()) {
            ((f1) it.next()).c(lanNetworkInfo, nearDevice, -255);
        }
    }

    public final void r(int i8, int i9) {
        we.h.h("NearLanTcpServer", "Server started on port " + i8 + " and " + i9);
        Message messageD = d();
        messageD.what = 24576;
        messageD.arg1 = i8;
        messageD.arg2 = i9;
        i(messageD);
    }

    public final void s(JSONObject jSONObject, String str, int i8, String str2, String str3) throws JSONException {
        String string;
        int i9;
        String string2;
        long j8;
        String string3;
        String string4;
        String string5;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        String string6;
        String string7;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        String string8;
        String str4;
        int iM254constructorimpl;
        int i20;
        String string9 = "";
        int i21 = jSONObject.getInt("ReqType");
        try {
            string = jSONObject.getString("DeviceId");
        } catch (Exception unused) {
            string = "";
        }
        try {
            i9 = jSONObject.getInt("FileCount");
        } catch (Exception unused2) {
            i9 = 0;
        }
        try {
            string2 = jSONObject.getString("FileName");
        } catch (Exception unused3) {
            string2 = "";
        }
        Intrinsics.checkNotNull(string2);
        List listSplit$default = StringsKt__StringsKt.split$default(string2, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt__StringsKt.trim((CharSequence) ((String) it.next())).toString());
        }
        try {
            j8 = jSONObject.getLong("TotalFileSize");
        } catch (Exception unused4) {
            j8 = 0;
        }
        try {
            string3 = jSONObject.getString("Ssid");
        } catch (Exception unused5) {
            string3 = "";
        }
        try {
            string4 = jSONObject.getString("Pwd");
        } catch (Exception unused6) {
            string4 = "";
        }
        try {
            string5 = jSONObject.getString("Mac");
        } catch (Exception unused7) {
            string5 = "";
        }
        try {
            jSONObject.getString("GoIpAddr");
        } catch (Exception unused8) {
        }
        try {
            i10 = jSONObject.getInt("Chan");
        } catch (Exception unused9) {
            i10 = -1;
        }
        int i22 = i10;
        try {
            i11 = jSONObject.getInt("Freq");
        } catch (Exception unused10) {
            i11 = 0;
        }
        try {
            i12 = jSONObject.getInt("Port");
        } catch (Exception unused11) {
            i12 = 8100;
        }
        try {
            i13 = jSONObject.getInt("MessagePort");
        } catch (Exception unused12) {
            i13 = 8100;
        }
        try {
            i14 = jSONObject.getInt("ClientP2pMode");
        } catch (Exception unused13) {
            i14 = 0;
        }
        try {
            string6 = jSONObject.getString("DeviceName");
        } catch (Exception unused14) {
            string6 = "";
        }
        try {
            string7 = jSONObject.getString("DeviceMac");
        } catch (Exception unused15) {
            string7 = "";
        }
        try {
            i15 = jSONObject.getInt("ProductSubType");
        } catch (Exception unused16) {
            i15 = 0;
        }
        try {
            i16 = jSONObject.getInt("ProductBrandName");
        } catch (Exception unused17) {
            i16 = 0;
        }
        try {
            string9 = jSONObject.getString("ProductNameCode");
        } catch (Exception unused18) {
        }
        try {
            i17 = jSONObject.getInt("ServiceType");
        } catch (Exception unused19) {
            i17 = 0;
        }
        try {
            i18 = jSONObject.getInt("SubCapability");
        } catch (Exception unused20) {
            i18 = 0;
        }
        try {
            i19 = jSONObject.getInt("Protocol");
        } catch (Exception unused21) {
            i19 = 0;
        }
        try {
            string8 = jSONObject.getString("ServiceData");
        } catch (Exception unused22) {
            string8 = null;
        }
        byte[] bArrDecode = string8 != null ? Base64.decode(string8, 0) : null;
        try {
            str4 = jSONObject.getString("BandSupport");
        } catch (Exception unused23) {
            str4 = new String();
        }
        Intrinsics.checkNotNull(str4);
        List listSplit$default2 = StringsKt__StringsKt.split$default(new Regex("\\s+").replace(str4, " "), new String[]{" "}, false, 0, 6, (Object) null);
        if (m.f4170t.d(str)) {
            long jOptLong = jSONObject.optLong("TargetService", 0L);
            int iM254constructorimpl2 = UInt.m254constructorimpl((int) (jOptLong & 4294967295L));
            iM254constructorimpl = UInt.m254constructorimpl((int) ((jOptLong >> 32) & 4294967295L));
            i20 = iM254constructorimpl2;
        } else {
            iM254constructorimpl = 0;
            i20 = 0;
        }
        ConnectRequest connectRequest = new ConnectRequest(str, i8, i21, string, i9, arrayList, j8, string3, string4, string5, i22, i11, i12, i13, i14, string6, string7, i15, i16, string9, i17, i18, i19, bArrDecode, listSplit$default2, UInt.m248boximpl(i20), UInt.m248boximpl(iM254constructorimpl), 402653184);
        if (i21 != 0 && i21 != 1 && i21 != 4 && i21 != 5 && i21 != 8 && i21 != 251) {
            if (i21 != 253) {
                switch (i21) {
                }
            }
            we.h.b("NearLanTcpServer", "Received connect Invite request: " + connectRequest);
            k(str2, str2, connectRequest);
            return;
        }
        we.h.b("NearLanTcpServer", "Received connect request: " + connectRequest);
        k(str2, str3, connectRequest);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00de  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:57:0x011a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x011b  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x011b -> B:59:0x011d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object t(java.lang.String r11, byte[] r12, int r13, se.o2 r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.welink.protocol.nfbd.p.t(java.lang.String, byte[], int, se.o2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    public final Object u(String str, String str2, int i8, int i9, int i10, String str3, String str4, int i11, NearDevice nearDevice, boolean z2, ContinuationImpl continuationImpl) throws JSONException {
        o oVar;
        if (continuationImpl instanceof o) {
            oVar = (o) continuationImpl;
            int i12 = oVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                oVar.label = i12 - Integer.MIN_VALUE;
            } else {
                oVar = new o(this, continuationImpl);
            }
        } else {
            oVar = new o(this, continuationImpl);
        }
        Object objT = oVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i13 = oVar.label;
        if (i13 == 0) {
            ResultKt.throwOnFailure(objT);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Version", str2);
            jSONObject.put("Encrypt", i8);
            if (i8 != 0) {
                Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
                Intrinsics.checkNotNullParameter("Encrypt is not supported", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearLanTcpServer", "TransConnect:Encrypt is not supported", null);
                }
                return Boxing.boxBoolean(false);
            }
            jSONObject.put("ReqType", i9 | (i10 & 255));
            jSONObject.put("DeviceId", str3 == null ? "" : str3);
            jSONObject.put("Mac", str4 != null ? str4 : "");
            jSONObject.put("state", i11);
            if (m.f4170t.d(str2) && i11 == 2) {
                jSONObject.put("Trust", z2);
            }
            Integer numBoxInt = nearDevice != null ? Boxing.boxInt(nearDevice.p) : null;
            if ((numBoxInt != null && numBoxInt.intValue() == 1) || numBoxInt == null || numBoxInt.intValue() == 2) {
                jSONObject.put("ServerP2pMode", 0);
            } else {
                jSONObject.put("ServerP2pMode", 0);
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            if (!this.f4187g.contains(str)) {
                String strN = o.d.n("Device not registered for notifications: ", str, "NearLanTcpServer", "tag", "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", strN, "NearLanTcpServer", null);
                }
                return Boxing.boxBoolean(false);
            }
            oVar.label = 1;
            objT = t(str, bytes, 1, o2.WebSocket, oVar);
            if (objT == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objT);
        }
        return Boxing.boxBoolean(((Boolean) objT).booleanValue());
    }

    public final void v(NearDevice nearDevice, int i8, boolean z2) {
        String strJoinToString$default;
        WirelessDevice wirelessDevice = nearDevice.f3896s;
        if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Wlan)) {
            Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
            Intrinsics.checkNotNullParameter("Wireless device is null or not Wlan type", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearLanTcpServer", "TransConnect:Wireless device is null or not Wlan type", null);
                return;
            }
            return;
        }
        WirelessDevice.Wlan wlan = (WirelessDevice.Wlan) wirelessDevice;
        String str = wlan.f4026c;
        String str2 = wlan.f4025b;
        if (str2 == null) {
            Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
            Intrinsics.checkNotNullParameter("Wireless device remote address is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearLanTcpServer", "TransConnect:Wireless device remote address is null", null);
                return;
            }
            return;
        }
        String str3 = nearDevice.f3894o;
        if (str3 == null) {
            str3 = "1.0";
        }
        String str4 = str3;
        Map map = h.f4132a;
        int iD = h.d(nearDevice.e);
        BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
        byte[] bArrM = ne.b.m();
        if (bArrM != null) {
            Intrinsics.checkNotNullParameter(bArrM, "<this>");
            Intrinsics.checkNotNullParameter(":", "separator");
            strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(bArrM, (CharSequence) ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new y0(16), 30, (Object) null);
        } else {
            strJoinToString$default = null;
        }
        LinkedHashMap linkedHashMap = this.f4189i;
        if (!linkedHashMap.containsKey(str2)) {
            linkedHashMap.put(str2, nearDevice);
        }
        li.l0.p(this.f4190j, null, null, new w3(this, str2, str4, iD, strJoinToString$default, i8, nearDevice, z2, str, null), 3);
    }
}
