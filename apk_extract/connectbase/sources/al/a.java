package al;

import io.netty.util.concurrent.Future;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import kn.l0;
import kn.n0;
import lm.c1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final jn.p<Throwable, um.d<?>, l2> f325a = C0007a.INSTANCE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final jn.p<Throwable, um.d<?>, l2> f326b = b.INSTANCE;

    /* JADX INFO: renamed from: al.a$a, reason: collision with other inner class name */
    public static final class C0007a extends n0 implements jn.p<Throwable, um.d<?>, l2> {
        public static final C0007a INSTANCE = new C0007a();

        public C0007a() {
            super(2);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2, um.d<?> dVar) {
            invoke2(th2, dVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Throwable th2, @os.l um.d<?> dVar) {
            l0.p(th2, "t");
            l0.p(dVar, "c");
            c1.a aVar = c1.Companion;
            w.a.a(th2, dVar);
        }
    }

    public static final class b extends n0 implements jn.p<Throwable, um.d<?>, l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(2);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2, um.d<?> dVar) {
            invoke2(th2, dVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l Throwable th2, @os.l um.d<?> dVar) {
            l0.p(th2, "t");
            l0.p(dVar, "c");
            if (!(th2 instanceof IOException)) {
                c1.a aVar = c1.Companion;
                w.a.a(th2, dVar);
            } else {
                gl.e eVar = new gl.e("Write operation future failed", th2);
                c1.a aVar2 = c1.Companion;
                dVar.resumeWith(c1.m59constructorimpl(d1.a(eVar)));
            }
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void c() {
    }

    @os.m
    public static final <T> Object d(@os.l Future<T> future, @os.l jn.p<? super Throwable, ? super um.d<? super T>, l2> pVar, @os.l um.d<? super T> dVar) throws Throwable {
        if (future.isDone()) {
            try {
                return future.get();
            } catch (Throwable th2) {
                throw g(th2);
            }
        }
        nq.q qVar = new nq.q(wm.c.e(dVar), 1);
        qVar.F();
        future.addListener(new al.b(future, qVar, pVar));
        Object objZ = qVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objZ;
    }

    @os.m
    public static final <T> Object e(@os.l Future<T> future, @os.l um.d<? super T> dVar) {
        return d(future, f325a, dVar);
    }

    @os.m
    public static final <T> Object f(@os.l Future<T> future, @os.l um.d<? super T> dVar) {
        return d(future, f326b, dVar);
    }

    public static final Throwable g(Throwable th2) {
        while ((th2 instanceof ExecutionException) && th2.getCause() != null) {
            th2 = th2.getCause();
            l0.m(th2);
        }
        return th2;
    }
}
