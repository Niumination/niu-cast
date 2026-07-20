package pf;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements qf.a, e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8825b = new b(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8826c = new b(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f8827d = new b(2);
    public static final b e = new b(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f8828h = new b(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f8829i = new b(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8830a;

    public /* synthetic */ b(int i8) {
        this.f8830a = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qf.a
    public void a(jf.d client, SuspendLambda suspendLambda) throws hh.c {
        switch (this.f8830a) {
            case 0:
                Function2 handler = (Function2) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler, "handler");
                client.f6261j.p(wf.a.f10740k, new a(handler, null));
                break;
            case 1:
                Function3 handler2 = (Function3) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler2, "handler");
                hh.h hVar = new hh.h("ObservableContent");
                client.e.m(vf.f.f10570l, hVar);
                client.e.p(hVar, new c(handler2, null));
                break;
            case 2:
                Function3 handler3 = (Function3) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler3, "handler");
                hh.h hVar2 = new hh.h("BeforeReceive");
                client.f6259h.n(wf.f.f10744i, hVar2);
                client.f6259h.p(hVar2, new f1(handler3, null));
                break;
            case 3:
                Function3 handler4 = (Function3) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler4, "handler");
                client.e.p(vf.f.f10570l, new h1(handler4, null));
                break;
            case 4:
                Function3 handler5 = (Function3) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler5, "handler");
                client.e.p(vf.f.f10567i, new i1(handler5, null));
                break;
            default:
                Function3 handler6 = (Function3) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler6, "handler");
                client.e.p(vf.f.f10567i, new p1(handler6, null));
                break;
        }
    }

    @Override // pf.e0
    public zg.a getKey() {
        return y0.f8880c;
    }

    @Override // pf.e0
    public void o(Object obj, jf.d scope) throws hh.c {
        y0 plugin = (y0) obj;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        scope.e.p(vf.f.f10571m, new x0(plugin, scope, null));
    }

    @Override // pf.e0
    public Object r(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(new b(6));
        return new y0();
    }
}
