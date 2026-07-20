package se;

import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceExtension;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.LinkedHashMap;
import java.util.List;
import k3.lb;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f9656a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9657b = 6000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jf.d f9658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d3 f9659d;

    public b3(d3 d3Var) {
        this.f9659d = d3Var;
        jf.d dVarA = jf.h.a(nf.a.f8204a, new u2(this, 0));
        this.f9658c = dVarA;
        we.h.h("WebSocketKtorClient", "WebSocketKtorClient init, supported capabilities: " + dVarA.f6255a.e);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0090 A[Catch: all -> 0x0215, Exception -> 0x0217, TRY_LEAVE, TryCatch #9 {Exception -> 0x0217, all -> 0x0215, blocks: (B:21:0x008c, B:23:0x0090), top: B:114:0x008c }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cd A[Catch: all -> 0x00f4, Exception -> 0x00f6, TryCatch #10 {Exception -> 0x00f6, all -> 0x00f4, blocks: (B:30:0x00c2, B:32:0x00cd, B:39:0x00f8, B:41:0x010a), top: B:112:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f8 A[Catch: all -> 0x00f4, Exception -> 0x00f6, TryCatch #10 {Exception -> 0x00f6, all -> 0x00f4, blocks: (B:30:0x00c2, B:32:0x00cd, B:39:0x00f8, B:41:0x010a), top: B:112:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x010a A[Catch: all -> 0x00f4, Exception -> 0x00f6, TRY_LEAVE, TryCatch #10 {Exception -> 0x00f6, all -> 0x00f4, blocks: (B:30:0x00c2, B:32:0x00cd, B:39:0x00f8, B:41:0x010a), top: B:112:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x011b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0125 A[Catch: all -> 0x016f, Exception -> 0x0173, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0173, all -> 0x016f, blocks: (B:44:0x011d, B:47:0x0125), top: B:116:0x011d }] */
    /* JADX WARN: Code duplicated, block: B:51:0x012e  */
    /* JADX WARN: Code duplicated, block: B:54:0x014d A[Catch: all -> 0x0161, Exception -> 0x0168, TryCatch #12 {Exception -> 0x0168, all -> 0x0161, blocks: (B:52:0x012f, B:54:0x014d, B:55:0x015d, B:65:0x017b, B:67:0x017f, B:71:0x0188, B:73:0x01a4, B:74:0x01b4, B:75:0x01b7, B:77:0x01bb, B:81:0x01c5, B:83:0x01e1, B:84:0x01f1), top: B:108:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0177  */
    /* JADX WARN: Code duplicated, block: B:67:0x017f A[Catch: all -> 0x0161, Exception -> 0x0168, TryCatch #12 {Exception -> 0x0168, all -> 0x0161, blocks: (B:52:0x012f, B:54:0x014d, B:55:0x015d, B:65:0x017b, B:67:0x017f, B:71:0x0188, B:73:0x01a4, B:74:0x01b4, B:75:0x01b7, B:77:0x01bb, B:81:0x01c5, B:83:0x01e1, B:84:0x01f1), top: B:108:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0185  */
    /* JADX WARN: Code duplicated, block: B:70:0x0186  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a4 A[Catch: all -> 0x0161, Exception -> 0x0168, TryCatch #12 {Exception -> 0x0168, all -> 0x0161, blocks: (B:52:0x012f, B:54:0x014d, B:55:0x015d, B:65:0x017b, B:67:0x017f, B:71:0x0188, B:73:0x01a4, B:74:0x01b4, B:75:0x01b7, B:77:0x01bb, B:81:0x01c5, B:83:0x01e1, B:84:0x01f1), top: B:108:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01bb A[Catch: all -> 0x0161, Exception -> 0x0168, TryCatch #12 {Exception -> 0x0168, all -> 0x0161, blocks: (B:52:0x012f, B:54:0x014d, B:55:0x015d, B:65:0x017b, B:67:0x017f, B:71:0x0188, B:73:0x01a4, B:74:0x01b4, B:75:0x01b7, B:77:0x01bb, B:81:0x01c5, B:83:0x01e1, B:84:0x01f1), top: B:108:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e1 A[Catch: all -> 0x0161, Exception -> 0x0168, TryCatch #12 {Exception -> 0x0168, all -> 0x0161, blocks: (B:52:0x012f, B:54:0x014d, B:55:0x015d, B:65:0x017b, B:67:0x017f, B:71:0x0188, B:73:0x01a4, B:74:0x01b4, B:75:0x01b7, B:77:0x01bb, B:81:0x01c5, B:83:0x01e1, B:84:0x01f1), top: B:108:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01f5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ae -> B:110:0x00b6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(se.b3 r20, com.welink.protocol.nfbd.NearDevice r21, java.lang.String r22, uf.d r23, kotlin.coroutines.jvm.internal.ContinuationImpl r24) {
        /*
            Method dump skipped, instruction units count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.b3.a(se.b3, com.welink.protocol.nfbd.NearDevice, java.lang.String, uf.d, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final void b(b3 b3Var, NearDevice nearDevice) {
        String strS;
        List<Pair> list;
        LinkedHashMap linkedHashMap = b3Var.f9656a;
        uf.d dVar = (uf.d) linkedHashMap.get(nearDevice.s());
        if (linkedHashMap.containsKey(nearDevice.s())) {
            TypeIntrinsics.asMutableMap(linkedHashMap).remove(nearDevice.s());
        }
        NearDeviceExtension nearDeviceExtension = nearDevice.u;
        LanNetworkInfo lanNetworkInfo = nearDeviceExtension != null ? nearDeviceExtension.f3909h : null;
        if (lanNetworkInfo == null || (strS = lanNetworkInfo.f4237a) == null) {
            strS = nearDevice.s();
        }
        if (lanNetworkInfo != null && (list = lanNetworkInfo.f4247n) != null) {
            for (Pair pair : list) {
                if (StringsKt__StringsJVMKt.equals((String) pair.getFirst(), "HandShake", true)) {
                    ((Number) pair.getSecond()).intValue();
                }
            }
        }
        if (strS == null) {
            Intrinsics.checkNotNullParameter("WebSocketKtorClient", "tag");
            Intrinsics.checkNotNullParameter("remoteIp or remotePort is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("WebSocketKtorClient", "TransConnect:remoteIp or remotePort is null", null);
                return;
            }
            return;
        }
        d3 d3Var = b3Var.f9659d;
        if (dVar != null && d3Var.f9714m.containsKey(strS)) {
            LinkedHashMap linkedHashMap2 = d3Var.f9714m;
            li.p1 p1Var = (li.p1) linkedHashMap2.get(strS);
            if (p1Var != null) {
                p1Var.h(null);
            }
            linkedHashMap2.remove(strS);
        }
        d3Var.o(nearDevice, null, 22);
    }

    public final void c(NearDevice device, uf.d dVar) {
        Intrinsics.checkNotNullParameter(device, "device");
        String strS = device.s();
        h0.a.D("disconnect, remoteIp: ", strS, "WebSocketKtorClient");
        if (strS == null) {
            we.h.c("WebSocketKtorClient", "remoteIp is null, ignore disconnect", null);
            return;
        }
        if (dVar == null) {
            dVar = (uf.d) this.f9656a.remove(strS);
        }
        if (dVar == null) {
            we.h.c("WebSocketKtorClient", "session is null", null);
            return;
        }
        d3 d3Var = this.f9659d;
        li.p1 p1Var = (li.p1) d3Var.f9714m.get(strS);
        if (p1Var != null) {
            p1Var.h(null);
        }
        d3Var.f9714m.remove(strS);
        li.v0 v0Var = li.v0.f7498a;
        li.l0.p(li.h0.a(si.e.f10118a), null, null, new y2(dVar, this, device, null), 3);
    }
}
