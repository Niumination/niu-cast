package sf;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements qf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10090a = new c();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qf.a
    public final void a(jf.d client, SuspendLambda suspendLambda) throws hh.c {
        Function3 handler = (Function3) suspendLambda;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(handler, "handler");
        client.f6261j.p(wf.a.f10740k, new b(handler, null));
    }
}
