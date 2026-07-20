package ag;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.welink.protocol.nfbd.NearDevice;
import eb.p1;
import eb.q1;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import k3.ab;
import k3.gc;
import k3.pb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import li.g2;
import li.h1;
import pf.a1;
import pf.d1;
import pf.k1;
import pf.r0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f754a;

    public /* synthetic */ b(int i8) {
        this.f754a = i8;
    }

    /* JADX WARN: Code duplicated, block: B:83:0x02ae  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i8 = 2;
        switch (this.f754a) {
            case 0:
                CharSequence it = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            case 1:
                Pair it2 = (Pair) obj;
                Intrinsics.checkNotNullParameter(it2, "it");
                return Integer.valueOf(((String) it2.getFirst()).length());
            case 2:
                return Integer.valueOf(((Integer) obj).intValue() * 8);
            case 3:
                CharSequence it3 = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(it3, "it");
                return Integer.valueOf(it3.length());
            case 4:
                zf.x it4 = (zf.x) obj;
                Intrinsics.checkNotNullParameter(it4, "it");
                return Integer.valueOf(it4.f11559a.length());
            case 5:
                Intrinsics.checkNotNullParameter((bj.a) obj, "<this>");
                return Unit.INSTANCE;
            case 6:
                if (((Boolean) obj).booleanValue()) {
                    li.l0.p(eb.y.f4800b, null, null, new eb.k(null), 3);
                }
                return Unit.INSTANCE;
            case 7:
                q1 it5 = (q1) obj;
                Intrinsics.checkNotNullParameter(it5, "it");
                it5.getClass();
                Intrinsics.checkNotNullParameter("ScreenOffTimer", "tag");
                Intrinsics.checkNotNullParameter("onScreenOff", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("ScreenOffTimer"), "onScreenOff");
                }
                it5.f4786a = li.l0.p(it5.f4787b, null, null, new p1(it5, null), 3);
                return Unit.INSTANCE;
            case 8:
                q1 it6 = (q1) obj;
                Intrinsics.checkNotNullParameter(it6, "it");
                it6.getClass();
                Intrinsics.checkNotNullParameter("ScreenOffTimer", "tag");
                Intrinsics.checkNotNullParameter("onScreenOn", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("ScreenOffTimer"), "onScreenOn");
                }
                g2 g2Var = it6.f4786a;
                if (g2Var != null) {
                    g2Var.h(null);
                }
                return Unit.INSTANCE;
            case 9:
                if (((Integer) obj).intValue() == 2) {
                    Application context = pb.a();
                    String string = pb.a().getResources().getString(R$string.module_pc_get_our_pc_connect_www);
                    Intrinsics.checkNotNullParameter(context, "context");
                    ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(context, ClipboardManager.class);
                    ClipData clipDataNewPlainText = ClipData.newPlainText("text", string);
                    Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
                    if (clipboardManager != null) {
                        clipboardManager.setPrimaryClip(clipDataNewPlainText);
                    }
                }
                return Unit.INSTANCE;
            case 10:
                wi.j sendHandshakeRecord = (wi.j) obj;
                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                X509Certificate[] certificates = new X509Certificate[0];
                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "<this>");
                Intrinsics.checkNotNullParameter(certificates, "certificates");
                wi.a aVar = new wi.a();
                int iE = (int) lh.a.e(aVar);
                wi.a aVar2 = (wi.a) sendHandshakeRecord;
                aVar2.s((byte) ((iE >>> 16) & 255));
                aVar2.t((short) (iE & 65535));
                lh.a.m(sendHandshakeRecord, aVar);
                return Unit.INSTANCE;
            case 11:
                Intrinsics.checkNotNullParameter((wi.j) obj, "<this>");
                return Unit.INSTANCE;
            case 12:
                jf.d install = (jf.d) obj;
                Intrinsics.checkNotNullParameter(install, "$this$install");
                vj.b bVar = pf.o.f8860a;
                Intrinsics.checkNotNullParameter(install, "<this>");
                install.e.p(vf.f.f10570l, new pf.l(null));
                hh.h hVar = wf.f.f10745j;
                pf.n nVar = new pf.n(install, null);
                wf.f fVar = install.f6259h;
                fVar.p(hVar, nVar);
                Intrinsics.checkNotNullParameter(install, "<this>");
                fVar.p(hVar, new pf.p(null));
                return Unit.INSTANCE;
            case 13:
                Intrinsics.checkNotNullParameter((nf.f) obj, "<this>");
                return Unit.INSTANCE;
            case 14:
                Intrinsics.checkNotNullParameter(obj, "<this>");
                return Unit.INSTANCE;
            case 15:
                Intrinsics.checkNotNullParameter((jf.e) obj, "<this>");
                return Unit.INSTANCE;
            case 16:
                CoroutineContext.Element element = (CoroutineContext.Element) obj;
                if (element instanceof li.a0) {
                    return (li.a0) element;
                }
                return null;
            case 17:
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj;
                if (element2 instanceof h1) {
                    return (h1) element2;
                }
                return null;
            case 18:
                NearDevice device = (NearDevice) obj;
                Intrinsics.checkNotNullParameter(device, "device");
                hc.c cVar = new hc.c();
                String str = device.f3885c;
                if (str == null) {
                    str = "";
                }
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                cVar.f5288c = str;
                String strH = device.h();
                int iHashCode = strH.hashCode();
                if (iHashCode != -685065131) {
                    if (iHashCode != 2289458) {
                        if (iHashCode == 80683315 && strH.equals("Tecno")) {
                            i8 = 3;
                        } else {
                            i8 = -1;
                        }
                    } else if (!strH.equals("Itel")) {
                        i8 = -1;
                    }
                } else if (strH.equals("Infinix")) {
                    i8 = 4;
                } else {
                    i8 = -1;
                }
                cVar.f5289d = i8;
                String str2 = device.f3884b;
                String str3 = str2 != null ? str2 : "";
                Intrinsics.checkNotNullParameter(str3, "<set-?>");
                cVar.f5287b = str3;
                String strR = device.r();
                Intrinsics.checkNotNullParameter(strR, "<set-?>");
                cVar.f5286a = strR;
                Intrinsics.checkNotNullParameter("BleConnectFromPeer", "tag");
                Intrinsics.checkNotNullParameter("accept with ble, pre build p2p connection", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("BleConnectFromPeer"), "accept with ble, pre build p2p connection");
                }
                bb.s sVar = ma.a.f7954c;
                if (sVar != null) {
                    sVar.invoke();
                }
                ma.a.f7952a = cVar;
                return Unit.INSTANCE;
            case 19:
                Byte b9 = (Byte) obj;
                b9.byteValue();
                return o.d.q(new Object[]{b9}, 1, "%02x", "format(...)");
            case 20:
                return Long.valueOf(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            case 21:
                qf.b createClientPlugin = (qf.b) obj;
                Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
                createClientPlugin.a(pf.b.f8826c, new pf.d(null));
                createClientPlugin.a(pf.b.f8825b, new pf.e(null));
                return Unit.INSTANCE;
            case 22:
                pf.t HttpResponseValidator = (pf.t) obj;
                Intrinsics.checkNotNullParameter(HttpResponseValidator, "$this$HttpResponseValidator");
                HttpResponseValidator.f8872c = false;
                pf.h block = new pf.h(null);
                Intrinsics.checkNotNullParameter(block, "block");
                HttpResponseValidator.f8870a.add(block);
                return Unit.INSTANCE;
            case 23:
                qf.b createClientPlugin2 = (qf.b) obj;
                Intrinsics.checkNotNullParameter(createClientPlugin2, "$this$createClientPlugin");
                ((k1) createClientPlugin2.f9043b).getClass();
                createClientPlugin2.f9042a.f6261j.p(wf.a.f10738i, new pf.r(false, null));
                return Unit.INSTANCE;
            case 24:
                qf.b createClientPlugin3 = (qf.b) obj;
                Intrinsics.checkNotNullParameter(createClientPlugin3, "$this$createClientPlugin");
                List listReversed = CollectionsKt.reversed(((pf.t) createClientPlugin3.f9043b).f8870a);
                pf.t tVar = (pf.t) createClientPlugin3.f9043b;
                List listReversed2 = CollectionsKt.reversed(tVar.f8871b);
                createClientPlugin3.a(qf.h.f9059c, new pf.w(tVar.f8872c, null));
                createClientPlugin3.a(qf.h.f9058b, new pf.x(listReversed, null));
                createClientPlugin3.a(pf.b.f8828h, new pf.y(listReversed2, null));
                createClientPlugin3.a(pf.b.f8827d, new pf.z(listReversed2, null));
                return Unit.INSTANCE;
            case 25:
                qf.b createClientPlugin4 = (qf.b) obj;
                Intrinsics.checkNotNullParameter(createClientPlugin4, "$this$createClientPlugin");
                List<Pair> listSortedWith = CollectionsKt.sortedWith(MapsKt.toList(((pf.g0) createClientPlugin4.f9043b).f8845b), new pf.k0(1));
                pf.g0 g0Var = (pf.g0) createClientPlugin4.f9043b;
                Charset charset = g0Var.f8846c;
                LinkedHashSet linkedHashSet = g0Var.f8844a;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : linkedHashSet) {
                    if (!g0Var.f8845b.containsKey((Charset) obj2)) {
                        arrayList.add(obj2);
                    }
                }
                List<Charset> listSortedWith2 = CollectionsKt.sortedWith(arrayList, new pf.k0(0));
                StringBuilder sb2 = new StringBuilder();
                for (Charset charset2 : listSortedWith2) {
                    if (sb2.length() > 0) {
                        sb2.append(",");
                    }
                    sb2.append(ab.b(charset2));
                }
                for (Pair pair : listSortedWith) {
                    Charset charset3 = (Charset) pair.component1();
                    float fFloatValue = ((Number) pair.component2()).floatValue();
                    if (sb2.length() > 0) {
                        sb2.append(",");
                    }
                    double d7 = fFloatValue;
                    if (0.0d > d7 || d7 > 1.0d) {
                        throw new IllegalStateException("Check failed.");
                    }
                    sb2.append(ab.b(charset3) + ";q=" + (((double) MathKt.roundToInt(100 * fFloatValue)) / 100.0d));
                }
                if (sb2.length() == 0) {
                    sb2.append(ab.b(charset));
                }
                String string2 = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                Charset charset4 = (Charset) CollectionsKt.firstOrNull(listSortedWith2);
                if (charset4 == null) {
                    Pair pair2 = (Pair) CollectionsKt.firstOrNull(listSortedWith);
                    charset4 = pair2 != null ? (Charset) pair2.getFirst() : null;
                    if (charset4 == null) {
                        charset4 = Charsets.UTF_8;
                    }
                }
                createClientPlugin4.a(pf.b.e, new pf.i0(string2, charset4, null));
                pf.j0 block2 = new pf.j0(charset, null);
                Intrinsics.checkNotNullParameter(block2, "block");
                createClientPlugin4.a(qf.h.f9060d, block2);
                return Unit.INSTANCE;
            case 26:
                qf.b createClientPlugin5 = (qf.b) obj;
                Intrinsics.checkNotNullParameter(createClientPlugin5, "$this$createClientPlugin");
                ((pf.m0) createClientPlugin5.f9043b).getClass();
                ((pf.m0) createClientPlugin5.f9043b).getClass();
                createClientPlugin5.a(qf.h.f9058b, new pf.o0(true, false, createClientPlugin5, null));
                return Unit.INSTANCE;
            case 27:
                qf.b createClientPlugin6 = (qf.b) obj;
                Intrinsics.checkNotNullParameter(createClientPlugin6, "$this$createClientPlugin");
                createClientPlugin6.a(pf.b.f8829i, new r0(createClientPlugin6, null));
                return Unit.INSTANCE;
            case 28:
                qf.b createClientPlugin7 = (qf.b) obj;
                Intrinsics.checkNotNullParameter(createClientPlugin7, "$this$createClientPlugin");
                a1 a1Var = (a1) createClientPlugin7.f9043b;
                createClientPlugin7.a(qf.h.f9058b, new d1(a1Var.f8822a, a1Var.f8823b, a1Var.f8824c, null));
                return Unit.INSTANCE;
            default:
                qg.a applicationEnvironment = (qg.a) obj;
                Intrinsics.checkNotNullParameter(applicationEnvironment, "$this$applicationEnvironment");
                vj.b bVarA = k3.g2.a("io.ktor.server.Application");
                applicationEnvironment.getClass();
                Intrinsics.checkNotNullParameter(bVarA, "<set-?>");
                applicationEnvironment.f9062a = bVarA;
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ b(jf.e eVar) {
        this.f754a = 22;
    }
}
