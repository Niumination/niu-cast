package tk;

import io.netty.handler.codec.rtsp.RtspHeaders;
import jn.p;
import kn.l0;
import lm.d1;
import lm.l2;
import nq.d4;
import nq.k;
import nq.r0;
import nq.s0;
import os.l;
import os.m;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final String f15781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final jn.a<Long> f15783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final s0 f15784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final jn.l<um.d<? super l2>, Object> f15785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public nq.l2 f15786f;

    @l
    volatile /* synthetic */ int isStarted;

    @l
    volatile /* synthetic */ long lastActivityTime;

    @f(c = "io.ktor.network.util.Timeout$initTimeoutJob$1", f = "Utils.kt", i = {}, l = {57, 59, 60}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends o implements p<s0, um.d<? super l2>, Object> {
        int label;

        public a(um.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return d.this.new a(dVar);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0073 A[RETURN] */
        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            long jLongValue;
            jn.l<um.d<? super l2>, Object> lVar;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0 || i10 == 1) {
                    d1.n(obj);
                    do {
                        if (d.this.isStarted == 0) {
                            d dVar = d.this;
                            dVar.lastActivityTime = dVar.f15783c.invoke().longValue();
                        }
                        long j10 = d.this.lastActivityTime;
                        d dVar2 = d.this;
                        jLongValue = (j10 + dVar2.f15782b) - dVar2.f15783c.invoke().longValue();
                        if (jLongValue > 0 || d.this.isStarted == 0) {
                            this.label = 1;
                        } else {
                            this.label = 2;
                            if (d4.a(this) == aVar) {
                                return aVar;
                            }
                            lVar = d.this.f15785e;
                            this.label = 3;
                            if (lVar.invoke(this) == aVar) {
                                return aVar;
                            }
                        }
                    } while (nq.d1.b(jLongValue, this) != aVar);
                    return aVar;
                }
                if (i10 == 2) {
                    d1.n(obj);
                    lVar = d.this.f15785e;
                    this.label = 3;
                    if (lVar.invoke(this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
            } catch (Throwable unused) {
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@l String str, long j10, @l jn.a<Long> aVar, @l s0 s0Var, @l jn.l<? super um.d<? super l2>, ? extends Object> lVar) {
        l0.p(str, "name");
        l0.p(aVar, RtspHeaders.Values.CLOCK);
        l0.p(s0Var, "scope");
        l0.p(lVar, "onTimeout");
        this.f15781a = str;
        this.f15782b = j10;
        this.f15783c = aVar;
        this.f15784d = s0Var;
        this.f15785e = lVar;
        this.lastActivityTime = 0L;
        this.isStarted = 0;
        this.f15786f = e();
    }

    public final void d() {
        nq.l2 l2Var = this.f15786f;
        if (l2Var == null) {
            return;
        }
        nq.l2.a.b(l2Var, null, 1, null);
    }

    public final nq.l2 e() {
        if (this.f15782b == Long.MAX_VALUE) {
            return null;
        }
        s0 s0Var = this.f15784d;
        return k.f(s0Var, s0Var.getCoroutineContext().plus(new r0(l0.C("Timeout ", this.f15781a))), null, new a(null), 2, null);
    }

    public final void f() {
        this.lastActivityTime = this.f15783c.invoke().longValue();
        this.isStarted = 1;
    }

    public final void g() {
        this.isStarted = 0;
    }
}
