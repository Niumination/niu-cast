package jf;

import ag.d0;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.o1;
import li.p1;
import li.r1;
import m3.j6;
import pf.f0;
import pf.i;
import pf.l0;
import pf.q0;
import pf.s;
import pf.s0;
import pf.y0;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements g0, Closeable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6254n = AtomicIntegerFieldUpdater.newUpdater(d.class, "closed");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nf.e f6255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r1 f6257c;
    private volatile /* synthetic */ int closed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineContext f6258d;
    public final vf.f e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final wf.f f6259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vf.h f6260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final wf.a f6261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zg.h f6262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final yf.c f6263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f6264m;

    public d(nf.e engine, e other) throws hh.c {
        int i8 = 14;
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(other, "userConfig");
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(other, "userConfig");
        this.f6255a = engine;
        this.closed = 0;
        r1 r1Var = new r1((p1) engine.f8213k.get(o1.f7483a));
        this.f6257c = r1Var;
        this.f6258d = engine.f8213k.plus(r1Var);
        this.e = new vf.f();
        this.f6259h = new wf.f();
        vf.h hVar = new vf.h();
        this.f6260i = hVar;
        this.f6261j = new wf.a();
        this.f6262k = j6.a(true);
        this.f6263l = new yf.c();
        e eVar = new e();
        this.f6264m = eVar;
        if (this.f6256b) {
            r1Var.A(new d0(this, i8));
        }
        Intrinsics.checkNotNullParameter(this, "client");
        hVar.p(vf.h.f10581l, new mf.e(this, engine, null));
        hVar.p(vf.h.f10582m, new a(this, null));
        eVar.a(s0.f8869b, new ag.b(i8));
        eVar.a(pf.f.f8842c, new ag.b(i8));
        eVar.a(s.f8867c, new ag.b(i8));
        if (other.f) {
            ag.b block = new ag.b(12);
            Intrinsics.checkNotNullParameter("DefaultTransformers", "key");
            Intrinsics.checkNotNullParameter(block, "block");
            eVar.f6267c.put("DefaultTransformers", block);
        }
        eVar.a(y0.f8879b, new ag.b(i8));
        qf.c cVar = pf.d0.f8836b;
        eVar.a(cVar, new ag.b(i8));
        if (other.e) {
            eVar.a(q0.f8864d, new ag.b(i8));
        }
        Intrinsics.checkNotNullParameter(other, "other");
        eVar.e = other.e;
        eVar.f = other.f;
        eVar.f6265a.putAll(other.f6265a);
        eVar.f6266b.putAll(other.f6266b);
        eVar.f6267c.putAll(other.f6267c);
        if (other.f) {
            eVar.a(l0.f8859b, new ag.b(i8));
        }
        zg.a aVar = i.f8847a;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        ag.b block2 = new ag.b(eVar);
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Intrinsics.checkNotNullParameter(block2, "block");
        eVar.a(cVar, block2);
        Intrinsics.checkNotNullParameter(this, "client");
        Iterator it = eVar.f6265a.values().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this);
        }
        Iterator it2 = eVar.f6267c.values().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(this);
        }
        this.f6259h.p(wf.f.f10744i, new b(this, null));
        this.f6256b = true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(vf.c cVar, ContinuationImpl continuationImpl) {
        c cVar2;
        if (continuationImpl instanceof c) {
            cVar2 = (c) continuationImpl;
            int i8 = cVar2.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                cVar2.label = i8 - Integer.MIN_VALUE;
            } else {
                cVar2 = new c(this, continuationImpl);
            }
        } else {
            cVar2 = new c(this, continuationImpl);
        }
        Object objB = cVar2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = cVar2.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objB);
            this.f6263l.a(xf.a.f10919a, cVar);
            Object obj = cVar.f10560d;
            cVar2.label = 1;
            objB = this.e.b(cVar, obj, cVar2);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objB);
        }
        Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall");
        return (kf.c) objB;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (f6254n.compareAndSet(this, 0, 1)) {
            zg.h hVar = (zg.h) this.f6262k.b(f0.f8843a);
            for (zg.a aVar : CollectionsKt.toList(hVar.c().keySet())) {
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                Object objB = hVar.b(aVar);
                if (objB instanceof Closeable) {
                    ((Closeable) objB).close();
                }
            }
            this.f6257c.r0();
            if (this.f6256b) {
                this.f6255a.close();
            }
        }
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f6258d;
    }

    public final String toString() {
        return "HttpClient[" + this.f6255a + ']';
    }
}
