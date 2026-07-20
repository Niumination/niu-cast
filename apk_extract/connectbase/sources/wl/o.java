package wl;

import java.nio.ByteBuffer;
import kn.l0;
import lm.d1;
import lm.l2;
import lm.y;
import pl.p0;
import tl.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public pl.a f19730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public ByteBuffer f19731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public o0 f19732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public j f19733e;

    @xm.f(c = "io.ktor.utils.io.internal.WriteSessionImpl", f = "WriteSessionImpl.kt", i = {0}, l = {86}, m = "tryAwaitJoinSwitch", n = {"this"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return o.this.g(0, this);
        }
    }

    public o(@os.l pl.a aVar) {
        l0.p(aVar, "channel");
        this.f19730b = aVar.z2();
        o0.c cVar = o0.H;
        cVar.getClass();
        this.f19731c = o0.L.f15820a;
        cVar.getClass();
        this.f19732d = o0.L;
        this.f19733e = this.f19730b.t1().f19708b;
    }

    @Override // pl.n0
    public void a(int i10) {
        int i11;
        if (i10 < 0 || i10 > (i11 = this.f19729a)) {
            h(i10);
            throw new y();
        }
        this.f19729a = i11 - i10;
        this.f19730b.n1(this.f19731c, this.f19733e, i10);
    }

    @Override // pl.n0
    @os.m
    public o0 b(int i10) {
        int iU = this.f19733e.u(0) + this.f19729a;
        this.f19729a = iU;
        if (iU < i10) {
            return null;
        }
        this.f19730b.Q1(this.f19731c, iU);
        if (this.f19731c.remaining() < i10) {
            return null;
        }
        this.f19732d.M2(this.f19731c);
        return this.f19732d;
    }

    @Override // pl.p0
    @os.m
    public Object c(int i10, @os.l um.d<? super l2> dVar) throws Throwable {
        if (this.f19730b.C1() != null) {
            Object objG = g(i10, dVar);
            return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
        }
        int i11 = this.f19729a;
        if (i11 >= i10) {
            return l2.f10208a;
        }
        if (i11 > 0) {
            this.f19733e.a(i11);
            this.f19729a = 0;
        }
        Object objX2 = this.f19730b.X2(i10, dVar);
        return objX2 == wm.a.COROUTINE_SUSPENDED ? objX2 : l2.f10208a;
    }

    public final void e() {
        pl.a aVarZ2 = this.f19730b.z2();
        this.f19730b = aVarZ2;
        ByteBuffer byteBufferP2 = aVarZ2.P2();
        if (byteBufferP2 == null) {
            return;
        }
        this.f19731c = byteBufferP2;
        o0 o0Var = new o0(this.f19730b.t1().f19707a);
        this.f19732d = o0Var;
        o0Var.M2(this.f19731c);
        this.f19733e = this.f19730b.t1().f19708b;
    }

    public final void f() {
        int i10 = this.f19729a;
        if (i10 > 0) {
            this.f19733e.a(i10);
            this.f19729a = 0;
        }
        this.f19730b.C2();
        this.f19730b.U2();
    }

    @Override // pl.n0
    public void flush() {
        this.f19730b.flush();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(int i10, um.d<? super l2> dVar) throws Throwable {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i11 = aVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                aVar.label = i11 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i12 = aVar.label;
        if (i12 == 0) {
            d1.n(obj);
            int i13 = this.f19729a;
            if (i13 > 0) {
                this.f19733e.a(i13);
                this.f19729a = 0;
            }
            flush();
            this.f19730b.C2();
            this.f19730b.U2();
            pl.a aVar3 = this.f19730b;
            aVar.L$0 = this;
            aVar.label = 1;
            if (aVar3.X2(i10, aVar) == aVar2) {
                return aVar2;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (o) aVar.L$0;
            d1.n(obj);
        }
        pl.a aVarZ2 = this.f19730b.z2();
        this.f19730b = aVarZ2;
        ByteBuffer byteBufferP2 = aVarZ2.P2();
        if (byteBufferP2 != null) {
            this.f19731c = byteBufferP2;
            o0 o0Var = new o0(this.f19730b.t1().f19707a);
            this.f19732d = o0Var;
            o0Var.M2(this.f19731c);
            this.f19733e = this.f19730b.t1().f19708b;
        }
        return l2.f10208a;
    }

    public final Void h(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(l0.C("Written bytes count shouldn't be negative: ", Integer.valueOf(i10)));
        }
        throw new IllegalStateException(c.a.a(h.b.a("Unable to mark ", i10, " bytes as written: only "), this.f19729a, " were pre-locked."));
    }
}
