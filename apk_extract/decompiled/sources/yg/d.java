package yg;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m3.y;
import xg.u;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f11206c;

    public /* synthetic */ d(String str, g gVar, int i8) {
        this.f11204a = i8;
        this.f11205b = str;
        this.f11206c = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i8 = 1;
        String str = this.f11205b;
        g handler = this.f11206c;
        xg.k route = (xg.k) obj;
        switch (this.f11204a) {
            case 0:
                Intrinsics.checkNotNullParameter(route, "$this$route");
                Intrinsics.checkNotNullParameter(route, "<this>");
                Intrinsics.checkNotNullParameter(handler, "handler");
                bd.b bVar = q.f11216h;
                u uVar = (u) route;
                uVar.getClass();
                bd.b plugin = q.f11216h;
                Intrinsics.checkNotNullParameter(plugin, "plugin");
                Intrinsics.checkNotNull(uVar, "null cannot be cast to non-null type io.ktor.server.application.ApplicationCallPipeline");
                mg.e.c(uVar);
                String[] strArr = v.f11551a;
                y.a(uVar, "Connection", "Upgrade", new d(str, handler, i8));
                break;
            case 1:
                Intrinsics.checkNotNullParameter(route, "$this$header");
                String[] strArr2 = v.f11551a;
                y.a(route, "Upgrade", "websocket", new d(str, handler, 2));
                break;
            default:
                Intrinsics.checkNotNullParameter(route, "$this$header");
                if (str == null) {
                    Intrinsics.checkNotNullParameter(route, "$this$webSocketProtocol");
                    ((u) route).t(new i(str, true, handler, null));
                    Unit unit = Unit.INSTANCE;
                } else {
                    u webSocketProtocol = ((u) route).s(new k(str));
                    Intrinsics.checkNotNullParameter(webSocketProtocol, "$this$webSocketProtocol");
                    webSocketProtocol.t(new i(str, true, handler, null));
                    Unit unit2 = Unit.INSTANCE;
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
