package qf;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import pf.f0;
import pf.y0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f9058b = new h(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f9059c = new h(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f9060d = new h(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9061a;

    public /* synthetic */ h(int i8) {
        this.f9061a = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qf.a
    public final void a(jf.d client, SuspendLambda suspendLambda) throws hh.c {
        switch (this.f9061a) {
            case 0:
                Function3 handler = (Function3) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler, "handler");
                y0 y0Var = (y0) f0.a(client, y0.f8879b);
                g block = new g(handler, client, null);
                Intrinsics.checkNotNullParameter(block, "block");
                y0Var.f8881a.add(block);
                break;
            case 1:
                Function2 handler2 = (Function2) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler2, "handler");
                client.e.p(vf.f.f10567i, new i(handler2, null));
                break;
            default:
                Function5 handler3 = (Function5) suspendLambda;
                Intrinsics.checkNotNullParameter(client, "client");
                Intrinsics.checkNotNullParameter(handler3, "handler");
                client.f6259h.p(wf.f.f10746k, new k(handler3, null));
                break;
        }
    }
}
