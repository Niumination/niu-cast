package og;

import java.net.InetSocketAddress;
import jh.j0;
import jh.o;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.q;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f8470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f8471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f8472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InetSocketAddress f8473d;
    public final InetSocketAddress e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f8474h;

    public k(CoroutineContext coroutineContext, o input, j0 output, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, q qVar) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        this.f8470a = coroutineContext;
        this.f8471b = input;
        this.f8472c = output;
        this.f8473d = inetSocketAddress;
        this.e = inetSocketAddress2;
        this.f8474h = qVar;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f8470a;
    }
}
