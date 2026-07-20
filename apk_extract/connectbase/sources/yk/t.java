package yk;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import kn.l0;
import kn.n0;
import nq.o0;
import nq.r0;

/* JADX INFO: loaded from: classes2.dex */
@v
public final class t implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.a<ps.a> f21433a;

    public static final class a extends n0 implements jn.a<ps.a> {
        final /* synthetic */ ps.a $logger;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ps.a aVar) {
            super(0);
            this.$logger = aVar;
        }

        @Override // jn.a
        @os.l
        public final ps.a invoke() {
            return this.$logger;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(@os.l jn.a<? extends ps.a> aVar) {
        l0.p(aVar, "logger");
        this.f21433a = aVar;
    }

    @Override // um.g.b, um.g
    public <R> R fold(R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
        return (R) um.g.b.a.a(this, r10, pVar);
    }

    @Override // nq.o0
    public void g0(@os.l um.g gVar, @os.l Throwable th2) {
        l0.p(gVar, "context");
        l0.p(th2, "exception");
        if ((th2 instanceof CancellationException) || (th2 instanceof IOException)) {
            return;
        }
        Object string = (r0) gVar.get(r0.f11910b);
        if (string == null) {
            string = gVar.toString();
        }
        this.f21433a.invoke().error(l0.C("Unhandled exception caught for ", string), th2);
    }

    @Override // um.g.b, um.g
    @os.m
    public <E extends um.g.b> E get(@os.l um.g.c<E> cVar) {
        return (E) um.g.b.a.b(this, cVar);
    }

    @Override // um.g.b
    @os.l
    public um.g.c<?> getKey() {
        return o0.f11887j;
    }

    @Override // um.g.b, um.g
    @os.l
    public um.g minusKey(@os.l um.g.c<?> cVar) {
        return um.g.b.a.c(this, cVar);
    }

    @Override // um.g
    @os.l
    public um.g plus(@os.l um.g gVar) {
        return um.g.b.a.d(this, gVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(@os.l ps.a aVar) {
        this(new a(aVar));
        l0.p(aVar, "logger");
    }
}
