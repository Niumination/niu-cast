package gi;

import af.z4;
import android.content.Context;
import bb.w;
import cg.j;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrConnectViewModel;
import gg.n;
import hg.o0;
import hh.h;
import i2.e;
import java.util.ArrayList;
import java.util.TimeZone;
import jf.d;
import jh.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt___SequencesKt;
import li.r;
import li.r1;
import mg.l;
import mi.c;
import nf.f;
import nf.p;
import qg.b0;
import qg.d0;
import qg.e0;
import qg.g0;
import qg.h1;
import qg.i1;
import qg.p0;
import qg.t0;
import qg.y0;
import wf.b;
import zf.s;
import zf.t;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5210c;

    public /* synthetic */ a(int i8, Object obj, Object obj2) {
        this.f5208a = i8;
        this.f5209b = obj;
        this.f5210c = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object obj2 = this.f5210c;
        Object obj3 = this.f5209b;
        switch (this.f5208a) {
            case 0:
                return Boolean.valueOf(SequencesKt___SequencesKt.C00831.iterator$lambda$0((Ref.BooleanRef) obj3, obj2, obj));
            case 1:
                Intrinsics.checkNotNullParameter(obj, "<this>");
                Function1 function1 = (Function1) obj3;
                if (function1 != null) {
                    function1.invoke(obj);
                }
                ((Function1) obj2).invoke(obj);
                return Unit.INSTANCE;
            case 2:
                f fVar = (f) obj;
                Intrinsics.checkNotNullParameter(fVar, "<this>");
                ((Function1) obj3).invoke(fVar);
                ((y0) obj2).invoke(fVar);
                return Unit.INSTANCE;
            case 3:
                if (((Throwable) obj) != null) {
                    ((d) obj3).f6263l.a(xf.a.e, (b) obj2);
                }
                return Unit.INSTANCE;
            case 4:
                s buildHeaders = (s) obj;
                Intrinsics.checkNotNullParameter(buildHeaders, "$this$buildHeaders");
                buildHeaders.e((t) obj3);
                buildHeaders.e(((j) obj2).c());
                return Unit.INSTANCE;
            case 5:
                ((c) obj3).f8093a.removeCallbacks((e) obj2);
                return Unit.INSTANCE;
            case 6:
                o0 tls = (o0) obj;
                Intrinsics.checkNotNullParameter(tls, "$this$tls");
                o0 other = ((p) obj3).f8225d.f8215b;
                Intrinsics.checkNotNullParameter(tls, "<this>");
                Intrinsics.checkNotNullParameter(other, "other");
                CollectionsKt__MutableCollectionsKt.addAll(tls.f5374a, other.f5374a);
                ArrayList arrayList = other.f5375b;
                Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
                tls.f5375b = arrayList;
                String hostName = other.f5376c;
                tls.f5376c = hostName;
                if (hostName == null) {
                    hostName = ((n) obj2).f5189a.getHostName();
                    Intrinsics.checkNotNullExpressionValue(hostName, "getHostName(...)");
                }
                tls.f5376c = hostName;
                return Unit.INSTANCE;
            case 7:
                Throwable th2 = (Throwable) obj;
                if (th2 != null) {
                    ((r) obj2).s0(th2);
                }
                ((r1) obj3).r0();
                return Unit.INSTANCE;
            case 8:
                mg.a it = (mg.a) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                z4 z4Var = (z4) obj3;
                if (!z4Var.f750b) {
                    TimeZone timeZone = ch.a.f1686a;
                    z4Var.f751c = System.currentTimeMillis();
                }
                t0 t0Var = (t0) obj2;
                it.f8056j.q(t0Var.f9117i);
                wg.b bVar = t0Var.f9118j;
                wg.b bVar2 = it.f8057k;
                bVar2.q(bVar);
                vj.b bVar3 = g0.f9071a;
                vg.b bVar4 = it.f8056j;
                Intrinsics.checkNotNullParameter(bVar4, "<this>");
                h hVar = vg.b.f10587j;
                bVar4.p(hVar, new d0(null));
                h hVar2 = new h("AfterTransform");
                bVar4.m(hVar, hVar2);
                bVar4.p(hVar2, new e0(null));
                Intrinsics.checkNotNullParameter(bVar2, "<this>");
                h hVar3 = wg.b.f10754k;
                bVar2.p(hVar3, new b0(null));
                it.p(mg.c.p, new qg.c(null));
                it.p(mg.c.f8053o, new qg.d(null));
                it.p(mg.c.f8052n, new qg.e(null));
                h hVar4 = new h("BodyTransformationCheckPostRender");
                bVar2.m(hVar3, hVar4);
                bVar2.p(hVar4, new qg.f(null));
                return Unit.INSTANCE;
            case 9:
                Intrinsics.checkNotNullParameter((mg.a) obj, "it");
                TimeZone timeZone2 = ch.a.f1686a;
                z4 z4Var2 = (z4) obj3;
                double dCurrentTimeMillis = (System.currentTimeMillis() - z4Var2.f751c) / 1000.0d;
                boolean z2 = z4Var2.f750b;
                vj.b bVar5 = ((qg.b) obj2).f9064b;
                if (z2) {
                    bVar5.info("Application started in " + dCurrentTimeMillis + " seconds.");
                    z4Var2.f750b = false;
                } else {
                    bVar5.info("Application auto-reloaded in " + dCurrentTimeMillis + " seconds.");
                }
                return Unit.INSTANCE;
            case 10:
                Intrinsics.checkNotNullParameter((mg.a) obj, "it");
                boolean z3 = i1.f9082a;
                p0 p0Var = (p0) obj3;
                Intrinsics.checkNotNullParameter(p0Var, "<this>");
                ag.a stop = (ag.a) obj2;
                Intrinsics.checkNotNullParameter(stop, "stop");
                h1 h1Var = new h1(stop);
                p0Var.f9092b.b(l.e, new ag.d0(h1Var, 27));
                Runtime.getRuntime().addShutdownHook(h1Var);
                return Unit.INSTANCE;
            case 11:
                Intrinsics.checkNotNullParameter((String) obj, "it");
                w wVar = (w) obj3;
                if (wVar != null) {
                    String remotetext = ((SearchPageText) obj2).getLink().getRemotetext();
                    if (remotetext == null) {
                        remotetext = "";
                    }
                    wVar.d(remotetext);
                }
                return Unit.INSTANCE;
            case 12:
                ((vi.c) obj3).e(((vi.b) obj2).f10593b);
                return Unit.INSTANCE;
            case 13:
                Intrinsics.checkNotNullParameter((Context) obj, "it");
                ((QrConnectViewModel) obj3).e((ArrayList) obj2);
                return Unit.INSTANCE;
            default:
                Throwable th3 = (Throwable) obj;
                if (th3 == null) {
                    return Unit.INSTANCE;
                }
                ((k) obj3).b(th3);
                ((k) obj2).b(th3);
                return Unit.INSTANCE;
        }
    }
}
