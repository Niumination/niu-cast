package sk;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import lm.l2;
import nq.r2;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x<S extends SelectableChannel & ByteChannel> extends rk.i implements y, s0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final S f15161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final rk.j f15162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public final bm.h<ByteBuffer> f15163g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public final e0.e f15164i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final AtomicBoolean f15165n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final AtomicReference<pl.h0> f15166p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final AtomicReference<pl.l0> f15167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final nq.b0 f15168w;

    public static final class a extends kn.n0 implements jn.l<Throwable, l2> {
        final /* synthetic */ x<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(x<? extends S> xVar) {
            super(1);
            this.this$0 = xVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) throws IllegalAccessException, InvocationTargetException {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) throws IllegalAccessException, InvocationTargetException {
            this.this$0.l0();
        }
    }

    public static final class b extends kn.n0 implements jn.a<pl.l0> {
        final /* synthetic */ pl.c $channel;
        final /* synthetic */ x<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(x<? extends S> xVar, pl.c cVar) {
            super(0);
            this.this$0 = xVar;
            this.$channel = cVar;
        }

        @Override // jn.a
        @os.l
        public final pl.l0 invoke() {
            x<S> xVar = this.this$0;
            if (xVar.f15163g != null) {
                pl.c cVar = this.$channel;
                ReadableByteChannel readableByteChannel = (ReadableByteChannel) xVar.a();
                x<S> xVar2 = this.this$0;
                return i.e(xVar, cVar, readableByteChannel, xVar2, xVar2.f15162f, xVar2.f15163g, xVar2.f15164i);
            }
            pl.c cVar2 = this.$channel;
            ReadableByteChannel readableByteChannel2 = (ReadableByteChannel) xVar.a();
            x<S> xVar3 = this.this$0;
            return i.c(xVar, cVar2, readableByteChannel2, xVar3, xVar3.f15162f, xVar3.f15164i);
        }
    }

    public static final class c extends kn.n0 implements jn.a<pl.h0> {
        final /* synthetic */ pl.c $channel;
        final /* synthetic */ x<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(x<? extends S> xVar, pl.c cVar) {
            super(0);
            this.this$0 = xVar;
            this.$channel = cVar;
        }

        @Override // jn.a
        @os.l
        public final pl.h0 invoke() {
            x<S> xVar = this.this$0;
            pl.c cVar = this.$channel;
            WritableByteChannel writableByteChannel = (WritableByteChannel) xVar.a();
            x<S> xVar2 = this.this$0;
            return j.a(xVar, cVar, writableByteChannel, xVar2, xVar2.f15162f, xVar2.f15164i);
        }
    }

    public /* synthetic */ x(SelectableChannel selectableChannel, rk.j jVar, bm.h hVar, e0.e eVar, int i10, kn.w wVar) {
        this(selectableChannel, jVar, hVar, (i10 & 8) != 0 ? null : eVar);
    }

    public static /* synthetic */ void O0(AtomicReference atomicReference) {
    }

    @Override // sk.d
    @os.l
    /* JADX INFO: renamed from: D1, reason: merged with bridge method [inline-methods] */
    public nq.b0 O1() {
        return this.f15168w;
    }

    @os.m
    public final bm.h<ByteBuffer> P0() {
        return this.f15163g;
    }

    @os.l
    public final rk.j S0() {
        return this.f15162f;
    }

    @Override // rk.i, rk.h
    @os.l
    public S a() {
        return this.f15161e;
    }

    @Override // sk.c
    @os.l
    public final pl.l0 b(@os.l pl.c cVar) {
        kn.l0.p(cVar, "channel");
        return (pl.l0) k0("reading", cVar, this.f15167v, new b(this, cVar));
    }

    @Override // rk.i, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        pl.n nVarMo70a;
        if (this.f15165n.compareAndSet(false, true)) {
            pl.h0 h0Var = this.f15166p.get();
            if (h0Var != null && (nVarMo70a = h0Var.mo70a()) != null) {
                pl.o.a(nVarMo70a);
            }
            pl.l0 l0Var = this.f15167v.get();
            if (l0Var != null) {
                nq.l2.a.b(l0Var, null, 1, null);
            }
            l0();
        }
    }

    @Override // rk.i, nq.n1
    public void dispose() {
        close();
    }

    public final Throwable g0() {
        try {
            ((ByteChannel) a()).close();
            super.close();
            this.f15162f.R1(this);
            return null;
        } catch (Throwable th2) {
            this.f15162f.R1(this);
            return th2;
        }
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return O1();
    }

    public final <J extends nq.l2> J k0(String str, pl.c cVar, AtomicReference<J> atomicReference, jn.a<? extends J> aVar) throws Throwable {
        if (this.f15165n.get()) {
            Throwable closedChannelException = new ClosedChannelException();
            cVar.f(closedChannelException);
            throw closedChannelException;
        }
        J jInvoke = aVar.invoke();
        if (!g0.e.a(atomicReference, null, jInvoke)) {
            IllegalStateException illegalStateException = new IllegalStateException(kn.l0.C(str, " channel has already been set"));
            nq.l2.a.b(jInvoke, null, 1, null);
            throw illegalStateException;
        }
        if (!this.f15165n.get()) {
            cVar.j(jInvoke);
            jInvoke.k0(new a(this));
            return jInvoke;
        }
        Throwable closedChannelException2 = new ClosedChannelException();
        nq.l2.a.b(jInvoke, null, 1, null);
        cVar.f(closedChannelException2);
        throw closedChannelException2;
    }

    public final void l0() throws IllegalAccessException, InvocationTargetException {
        if (this.f15165n.get() && u0(this.f15166p) && u0(this.f15167v)) {
            Throwable thY0 = y0(this.f15166p);
            Throwable thY1 = y0(this.f15167v);
            Throwable thQ0 = q0(q0(thY0, thY1), g0());
            nq.b0 b0VarO1 = O1();
            if (thQ0 == null) {
                b0VarO1.complete();
            } else {
                b0VarO1.k(thQ0);
            }
        }
    }

    @Override // sk.e
    @os.l
    public final pl.h0 p(@os.l pl.c cVar) {
        kn.l0.p(cVar, "channel");
        return (pl.h0) k0("writing", cVar, this.f15166p, new c(this, cVar));
    }

    public final Throwable q0(Throwable th2, Throwable th3) throws IllegalAccessException, InvocationTargetException {
        if (th2 == null) {
            return th3;
        }
        if (th3 == null || th2 == th3) {
            return th2;
        }
        lm.p.a(th2, th3);
        return th2;
    }

    public final boolean u0(AtomicReference<? extends nq.l2> atomicReference) {
        nq.l2 l2Var = atomicReference.get();
        return l2Var == null || l2Var.isCompleted();
    }

    public final Throwable y0(AtomicReference<? extends nq.l2> atomicReference) {
        CancellationException cancellationExceptionO;
        nq.l2 l2Var = atomicReference.get();
        if (l2Var == null) {
            return null;
        }
        if (!l2Var.isCancelled()) {
            l2Var = null;
        }
        if (l2Var == null || (cancellationExceptionO = l2Var.O()) == null) {
            return null;
        }
        return cancellationExceptionO.getCause();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@os.l S s10, @os.l rk.j jVar, @os.m bm.h<ByteBuffer> hVar, @os.m e0.e eVar) {
        super(s10);
        kn.l0.p(s10, "channel");
        kn.l0.p(jVar, "selector");
        this.f15161e = s10;
        this.f15162f = jVar;
        this.f15163g = hVar;
        this.f15164i = eVar;
        this.f15165n = new AtomicBoolean();
        this.f15166p = new AtomicReference<>();
        this.f15167v = new AtomicReference<>();
        this.f15168w = r2.c(null, 1, null);
    }
}
