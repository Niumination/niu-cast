package ag;

import af.r5;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import com.transsion.iotservice.multiscreen.pc.ue.NFCTouchSelectorActivity;
import com.transsion.iotservice.multiscreen.pc.ue.PCConnectionHelperActivity;
import com.transsion.iotservice.multiscreen.pc.ui.copy.CopyPastActivity;
import eb.h1;
import eb.k1;
import hg.f1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k3.gc;
import k3.lb;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KFunction;
import kotlin.reflect.KTypeProjection;
import kotlin.text.MatcherMatchResult$groups$1;
import li.i2;
import li.r1;
import li.x0;
import pf.s0;
import qg.r0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f764b;

    public /* synthetic */ d0(Object obj, int i8) {
        this.f763a = i8;
        this.f764b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int iE = 0;
        Object obj2 = this.f764b;
        switch (this.f763a) {
            case 0:
                if (((Throwable) obj) != null) {
                    ((v) ((f0) obj2).f767a.O()).e();
                }
                return Unit.INSTANCE;
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                int i8 = BaseSettingActivity.f2662k;
                ((Function1) ((KFunction) obj2)).invoke(bool);
                return Unit.INSTANCE;
            case 2:
                int iIntValue = ((Integer) obj).intValue();
                StringBuilder sb2 = new StringBuilder();
                bj.e eVar = (bj.e) obj2;
                sb2.append(eVar.e[iIntValue]);
                sb2.append(": ");
                sb2.append(eVar.f[iIntValue].e());
                return sb2.toString();
            case 3:
                return TextStreamsKt.readLines$lambda$1((ArrayList) obj2, (String) obj);
            case 4:
                int iIntValue2 = ((Integer) obj).intValue();
                StringBuilder sb3 = new StringBuilder();
                cj.k kVar = (cj.k) obj2;
                sb3.append(kVar.e[iIntValue2]);
                sb3.append(": ");
                sb3.append(kVar.d(iIntValue2).e());
                return sb3.toString();
            case 5:
                ((bb.d) obj2).invoke(Boolean.valueOf(((Integer) obj).intValue() == 0));
                return Unit.INSTANCE;
            case 6:
                return TypeReference.asString$lambda$0((TypeReference) obj2, (KTypeProjection) obj);
            case 7:
                hc.b it = (hc.b) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                if (Intrinsics.areEqual(k1.f4766b, "ble_from_peer")) {
                    li.l0.p(k1.f, null, null, new h1(it, (zb.b) obj2, null), 3);
                    return Unit.INSTANCE;
                }
                Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
                Intrinsics.checkNotNullParameter("BleFromPeerConnect:ignore event.", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PhysicalConnectManager"), "BleFromPeerConnect:ignore event.");
                }
                return Unit.INSTANCE;
            case 8:
                return Boolean.valueOf(ArraysKt.contains((Object[]) obj2, obj));
            case 9:
                return Boolean.valueOf(((Collection) obj2).contains(obj));
            case 10:
                return Boolean.valueOf(((List) obj2).contains(obj));
            case 11:
                wi.j sendHandshakeRecord = (wi.j) obj;
                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "$this$sendHandshakeRecord");
                f1 version = f1.TLS12;
                hg.l0 l0Var = (hg.l0) obj2;
                r5 r5Var = l0Var.f5366a;
                ArrayList suites = (ArrayList) r5Var.e;
                byte[] sessionId = new byte[32];
                Intrinsics.checkNotNullParameter(sendHandshakeRecord, "<this>");
                Intrinsics.checkNotNullParameter(version, "version");
                Intrinsics.checkNotNullParameter(suites, "suites");
                byte[] random = l0Var.f5369d;
                Intrinsics.checkNotNullParameter(random, "random");
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                wi.a aVar = (wi.a) sendHandshakeRecord;
                aVar.t((short) version.getCode());
                lh.a.k(aVar, random, 0, random.length);
                aVar.s((byte) 32);
                lh.a.k(aVar, sessionId, 0, 32);
                aVar.t((short) (suites.size() * 2));
                Iterator it2 = suites.iterator();
                while (it2.hasNext()) {
                    aVar.t(((hg.c) it2.next()).f5334a);
                }
                aVar.s((byte) 1);
                aVar.s((byte) 0);
                ArrayList arrayList = new ArrayList();
                List<jg.c> list = jg.k.f6277a;
                wi.a aVar2 = new wi.a();
                aVar2.t(jg.n.SIGNATURE_ALGORITHMS.getCode());
                int size = list.size() * 2;
                aVar2.t((short) (size + 2));
                aVar2.t((short) size);
                for (jg.c cVar : list) {
                    aVar2.s(cVar.f6271a.getCode());
                    aVar2.s(cVar.f6272b.getCode());
                }
                arrayList.add(aVar2);
                List list2 = jg.f.f6275a;
                wi.a aVar3 = new wi.a();
                if (list2.size() > 16382) {
                    throw new IllegalArgumentException("Too many named curves provided: at most 16382 could be provided");
                }
                aVar3.t(jg.n.ELLIPTIC_CURVES.getCode());
                int size2 = list2.size() * 2;
                aVar3.t((short) (size2 + 2));
                aVar3.t((short) size2);
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    aVar3.t(((jg.e) it3.next()).getCode());
                }
                arrayList.add(aVar3);
                List list3 = jg.h.f6276a;
                wi.a aVar4 = new wi.a();
                aVar4.t(jg.n.EC_POINT_FORMAT.getCode());
                int size3 = list3.size();
                aVar4.t((short) (1 + size3));
                aVar4.s((byte) size3);
                Iterator it4 = list3.iterator();
                while (it4.hasNext()) {
                    aVar4.s(((jg.g) it4.next()).getCode());
                }
                arrayList.add(aVar4);
                String str = (String) r5Var.f560h;
                if (str != null) {
                    wi.a aVar5 = new wi.a();
                    if (str.length() >= 32762) {
                        throw new IllegalArgumentException("Server name length limit exceeded: at most 32762 characters allowed");
                    }
                    aVar5.t(jg.n.SERVER_NAME.getCode());
                    aVar5.t((short) (str.length() + 5));
                    aVar5.t((short) (str.length() + 3));
                    aVar5.s((byte) 0);
                    aVar5.t((short) str.length());
                    lh.a.n(aVar5, str, 0, 0, 14);
                    arrayList.add(aVar5);
                }
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    iE += (int) lh.a.e((wi.k) it5.next());
                }
                aVar.t((short) iE);
                Iterator it6 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it6, "iterator(...)");
                while (it6.hasNext()) {
                    Object next = it6.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    lh.a.m(aVar, (wi.k) next);
                }
                return Unit.INSTANCE;
            case 12:
                wi.j cipherLoop = (wi.j) obj;
                Intrinsics.checkNotNullParameter(cipherLoop, "$this$cipherLoop");
                byte[] iv = ((ig.a) obj2).f5858c.getIV();
                Intrinsics.checkNotNullExpressionValue(iv, "getIV(...)");
                lh.a.k(cipherLoop, iv, 0, iv.length);
                return Unit.INSTANCE;
            case 13:
                return ((MatcherMatchResult$groups$1) obj2).get(((Integer) obj).intValue());
            case 14:
                if (((Throwable) obj) != null) {
                    li.h0.b(((jf.d) obj2).f6255a, null);
                }
                return Unit.INSTANCE;
            case 15:
                jf.d scope = (jf.d) obj;
                Intrinsics.checkNotNullParameter(scope, "scope");
                zg.h hVar = (zg.h) scope.f6262k.a(pf.f0.f8843a, new bb.s(18));
                pf.e0 e0Var = (pf.e0) obj2;
                Object obj3 = scope.f6264m.f6266b.get(e0Var.getKey());
                Intrinsics.checkNotNull(obj3);
                Object objR = e0Var.r((Function1) obj3);
                e0Var.o(objR, scope);
                hVar.e(e0Var.getKey(), objR);
                return Unit.INSTANCE;
            case 16:
                ((nf.e) obj2).close();
                return Unit.INSTANCE;
            case 17:
                ((Integer) obj).getClass();
                Intrinsics.checkNotNullParameter("BleScanTool", "tag");
                Intrinsics.checkNotNullParameter("wifi auto connect to build area network error, now disconnect ble", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BleScanTool", "TransConnect:wifi auto connect to build area network error, now disconnect ble", null);
                }
                oe.e eVar2 = ((ne.f) obj2).f8201i;
                if (eVar2 != null) {
                    eVar2.b();
                }
                return Unit.INSTANCE;
            case 18:
                Throwable th2 = (Throwable) obj;
                ng.p pVar = (ng.p) obj2;
                if (th2 != null) {
                    pVar.f8267j.s0(th2);
                }
                if (th2 != null) {
                    pVar.f8266i.s0(th2);
                }
                return Unit.INSTANCE;
            case 19:
                ((fg.e) obj2).close();
                return Unit.INSTANCE;
            case 20:
                ((gg.s) obj2).close();
                return Unit.INSTANCE;
            case 21:
                ((r1) obj2).h(null);
                return Unit.INSTANCE;
            case 22:
                int i9 = NFCTouchSelectorActivity.f2680b;
                Intrinsics.checkNotNullParameter((Context) obj, "it");
                ((NFCTouchSelectorActivity) obj2).k();
                return Unit.INSTANCE;
            case 23:
                int i10 = PCConnectionHelperActivity.f2689i;
                Intrinsics.checkNotNullParameter((String) obj, "it");
                ob.b bVar = ob.b.f8417b;
                bVar.getClass();
                Intrinsics.checkNotNullParameter("help_page", "triggerScene");
                bVar.f8437a.s("help_page");
                PCConnectionHelperActivity context = (PCConnectionHelperActivity) obj2;
                String string = context.getResources().getString(R$string.module_pc_get_our_pc_connect_www);
                Intrinsics.checkNotNullParameter(context, "context");
                ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(context, ClipboardManager.class);
                ClipData clipDataNewPlainText = ClipData.newPlainText("text", string);
                Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(clipDataNewPlainText);
                }
                return Unit.INSTANCE;
            case 24:
                Throwable th3 = (Throwable) obj;
                vj.b bVar2 = s0.f8868a;
                i2 i2Var = (i2) obj2;
                if (th3 != null) {
                    bVar2.trace("Cancelling request because engine Job failed with error: " + th3);
                    li.l0.g("Engine failed", th3, i2Var);
                } else {
                    bVar2.trace("Cancelling request because engine Job completed");
                    i2Var.r0();
                }
                return Unit.INSTANCE;
            case 25:
                ((x0) obj2).dispose();
                return Unit.INSTANCE;
            case 26:
                ng.c cVar2 = (ng.c) obj;
                Intrinsics.checkNotNullParameter(cVar2, "<this>");
                CollectionsKt__MutableCollectionsKt.addAll(cVar2.f8252b, (r0[]) obj2);
                return Unit.INSTANCE;
            case 27:
                qg.h1 h1Var = (qg.h1) obj2;
                Intrinsics.checkNotNullParameter((mg.a) obj, "it");
                try {
                    Runtime.getRuntime().removeShutdownHook(h1Var);
                    break;
                } catch (IllegalStateException unused) {
                }
                return Unit.INSTANCE;
            case 28:
                int i11 = CopyPastActivity.f2703d;
                Intrinsics.checkNotNullParameter((View) obj, "it");
                ((CopyPastActivity) obj2).getOnBackPressedDispatcher().onBackPressed();
                return Unit.INSTANCE;
            default:
                Intrinsics.checkNotNullParameter((String) obj, "it");
                yb.b bVar3 = (yb.b) obj2;
                if (bVar3 != null) {
                    bVar3.b();
                }
                return Unit.INSTANCE;
        }
    }
}
