package wl;

import java.nio.ByteBuffer;
import kn.l0;
import pl.j0;
import tl.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final pl.a f19704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public o0 f19706d;

    public g(@os.l pl.a aVar) {
        l0.p(aVar, "channel");
        this.f19704b = aVar;
        o0.H.getClass();
        this.f19706d = o0.L;
    }

    public final void a() {
        o0.H.getClass();
        c(o0.L);
    }

    @Override // pl.f0
    @os.m
    public o0 b(int i10) {
        ByteBuffer byteBufferB = this.f19704b.b(0, i10);
        if (byteBufferB == null) {
            return null;
        }
        o0 o0Var = new o0(byteBufferB);
        o0Var.u0();
        c(o0Var);
        return o0Var;
    }

    @Override // pl.f0
    public int b0(int i10) {
        a();
        int iMin = Math.min(this.f19704b.d(), i10);
        this.f19704b.b0(iMin);
        return iMin;
    }

    public final void c(o0 o0Var) {
        int i10 = this.f19705c;
        tl.m mVar = this.f19706d.f15821b;
        int i11 = i10 - (mVar.f15874c - mVar.f15873b);
        if (i11 > 0) {
            this.f19704b.b0(i11);
        }
        this.f19706d = o0Var;
        tl.m mVar2 = o0Var.f15821b;
        this.f19705c = mVar2.f15874c - mVar2.f15873b;
    }

    @Override // pl.f0
    public int d() {
        return this.f19704b.d();
    }

    @Override // pl.j0
    @os.m
    public Object w(int i10, @os.l um.d<? super Boolean> dVar) {
        a();
        return this.f19704b.w(i10, dVar);
    }
}
