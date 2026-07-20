package mg;

import java.util.List;
import jh.o0;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import se.n3;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8080d;
    public final /* synthetic */ Object e;

    public /* synthetic */ t(int i8, Object obj, Object obj2, Object obj3, Object obj4) {
        this.f8077a = i8;
        this.f8078b = obj;
        this.f8079c = obj2;
        this.f8080d = obj3;
        this.e = obj4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f8077a) {
            case 0:
                hh.e pipeline = (hh.e) obj;
                Intrinsics.checkNotNullParameter(pipeline, "pipeline");
                pipeline.p((hh.h) this.f8078b, new y((z) this.f8079c, "onCall", (w) this.f8080d, (u) this.e, null));
                return Unit.INSTANCE;
            case 1:
                jh.k kVar = (jh.k) this.f8078b;
                jh.k kVar2 = (jh.k) this.f8079c;
                gg.m mVar = (gg.m) this.f8080d;
                nf.p pVar = (nf.p) this.e;
                Throwable th2 = (Throwable) obj;
                Throwable thA = th2 != null ? xf.a.a(th2) : null;
                try {
                    kVar.b(thA);
                    o0.a(kVar2, thA);
                    mVar.f5186a.close();
                    break;
                } catch (Throwable th3) {
                    try {
                        nf.s.f8234a.debug("An error occurred while closing connection", th3);
                    } finally {
                        pVar.s();
                    }
                    break;
                }
                return Unit.INSTANCE;
            default:
                c0 serverConfig = (c0) obj;
                Intrinsics.checkNotNullParameter(serverConfig, "$this$serverConfig");
                CoroutineContext coroutineContextPlus = ((g0) this.f8078b).getCoroutineContext().plus((CoroutineContext) this.f8079c);
                serverConfig.getClass();
                Intrinsics.checkNotNullParameter(coroutineContextPlus, "<set-?>");
                serverConfig.e = coroutineContextPlus;
                List list = (List) this.f8080d;
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                serverConfig.f8059b = list;
                n3 body = (n3) this.e;
                Intrinsics.checkNotNullParameter(body, "body");
                serverConfig.f8058a.add(body);
                return Unit.INSTANCE;
        }
    }
}
