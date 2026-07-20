package ng;

import ag.o0;
import java.net.InetSocketAddress;
import jh.j0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import m3.j6;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g0, mg.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mg.a f8244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zg.h f8245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f8246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f8247d;
    public final a0 e;

    public b(mg.a application, o0 _request, jh.o input, j0 output, li.a0 engineDispatcher, li.a0 appDispatcher, li.q qVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(_request, "_request");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(engineDispatcher, "engineDispatcher");
        Intrinsics.checkNotNullParameter(appDispatcher, "appDispatcher");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(application, "application");
        this.f8244a = application;
        zg.h hVarA = j6.a(false);
        this.f8245b = hVarA;
        this.f8246c = coroutineContext;
        this.f8247d = new r(this, inetSocketAddress, inetSocketAddress2, input, _request);
        a0 response = new a0(this, output, input, engineDispatcher, appDispatcher, qVar);
        this.e = response;
        Intrinsics.checkNotNullParameter(response, "response");
        hVarA.e(qg.s.f9107h, response);
    }

    @Override // mg.b
    public final Object B(Object obj, ih.a aVar, ContinuationImpl continuationImpl) {
        return mg.l.a(this, obj, aVar, continuationImpl);
    }

    @Override // mg.b
    public final vg.c g() {
        return this.f8247d;
    }

    @Override // mg.b
    public final mg.a getApplication() {
        return this.f8244a;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f8246c;
    }

    @Override // mg.b
    public final zf.d0 getParameters() {
        return this.f8247d.s();
    }

    @Override // mg.b
    public final zg.h i() {
        return this.f8245b;
    }

    @Override // mg.b
    public final wg.a k() {
        return this.e;
    }

    @Override // mg.r, mg.b
    public final vg.e g() {
        return this.f8247d;
    }

    @Override // mg.r, mg.b
    public final wg.c k() {
        return this.e;
    }
}
