package se;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n3 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t3 f9890b;

    public /* synthetic */ n3(t3 t3Var, int i8) {
        this.f9889a = i8;
        this.f9890b = t3Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        t3 t3Var = this.f9890b;
        int i8 = 8;
        switch (this.f9889a) {
            case 0:
                mg.a aVar = (mg.a) obj;
                mg.e.b(aVar, yg.q.f11216h, new qg.y0(i8));
                n3 configuration = new n3(t3Var, 1);
                zg.a aVar2 = xg.o0.f10979a;
                Intrinsics.checkNotNullParameter(aVar, "<this>");
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                g gVar = xg.n0.f10974x;
                xg.n0 n0Var = (xg.n0) mg.e.d(aVar, gVar);
                if (n0Var != null) {
                    configuration.invoke(n0Var);
                }
                break;
            default:
                xg.k kVar = (xg.o) obj;
                o3 body = new o3(null);
                Intrinsics.checkNotNullParameter(kVar, "<this>");
                Intrinsics.checkNotNullParameter("/ping", "path");
                Intrinsics.checkNotNullParameter(body, "body");
                zf.x xVar = zf.x.f11553b;
                m3.y.b(kVar, "/ping", xVar, new sb.a(body, i8));
                p3 handler = new p3(t3Var, null);
                Intrinsics.checkNotNullParameter(kVar, "<this>");
                Intrinsics.checkNotNullParameter("/ws", "path");
                Intrinsics.checkNotNullParameter(handler, "handler");
                yg.g handler2 = new yg.g(handler, null);
                Intrinsics.checkNotNullParameter(kVar, "<this>");
                Intrinsics.checkNotNullParameter("/ws", "path");
                Intrinsics.checkNotNullParameter(handler2, "handler");
                bd.b bVar = yg.q.f11216h;
                xg.u uVar = (xg.u) kVar;
                uVar.getClass();
                bd.b plugin = yg.q.f11216h;
                Intrinsics.checkNotNullParameter(plugin, "plugin");
                Intrinsics.checkNotNull(uVar, "null cannot be cast to non-null type io.ktor.server.application.ApplicationCallPipeline");
                mg.e.c(uVar);
                m3.y.b(uVar, "/ws", xVar, new yg.d(null, handler2, 0));
                break;
        }
        return Unit.INSTANCE;
    }
}
