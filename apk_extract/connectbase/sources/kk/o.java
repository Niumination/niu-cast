package kk;

import ik.p0;
import java.nio.ByteBuffer;
import kn.l0;
import tl.d1;
import tl.n0;
import tl.r0;
import tl.s;
import tl.s0;
import tl.v;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final s f9241a = w0.b(0, 1, null);

    public static /* synthetic */ void d(o oVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        oVar.c(bArr, i10, i11);
    }

    @os.l
    public final v a() {
        return this.f9241a.z2();
    }

    public final void b(@os.l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, t2.a.f15437d);
        r0.a(this.f9241a, byteBuffer);
    }

    public final void c(@os.l byte[] bArr, int i10, int i11) {
        l0.p(bArr, t2.a.f15437d);
        s0.j(this.f9241a, bArr, i10, i11);
    }

    public final void e() throws n0 {
        this.f9241a.d1((byte) 13);
        this.f9241a.d1((byte) 10);
    }

    public final void f(@os.l CharSequence charSequence, @os.l CharSequence charSequence2) throws n0 {
        l0.p(charSequence, "name");
        l0.p(charSequence2, "value");
        this.f9241a.u2(charSequence);
        this.f9241a.u2(": ");
        this.f9241a.u2(charSequence2);
        this.f9241a.d1((byte) 13);
        this.f9241a.d1((byte) 10);
    }

    public final void g(@os.l CharSequence charSequence) throws n0 {
        l0.p(charSequence, "line");
        this.f9241a.u2(charSequence);
        this.f9241a.d1((byte) 13);
        this.f9241a.d1((byte) 10);
    }

    public final void h() {
        this.f9241a.close();
    }

    public final void i(@os.l p0 p0Var, @os.l CharSequence charSequence, @os.l CharSequence charSequence2) throws n0 {
        l0.p(p0Var, "method");
        l0.p(charSequence, "uri");
        l0.p(charSequence2, lb.f.f9782f);
        d1.Y(this.f9241a, p0Var.f8144a, 0, 0, null, 14, null);
        this.f9241a.d1((byte) 32);
        d1.Y(this.f9241a, charSequence, 0, 0, null, 14, null);
        this.f9241a.d1((byte) 32);
        d1.Y(this.f9241a, charSequence2, 0, 0, null, 14, null);
        this.f9241a.d1((byte) 13);
        this.f9241a.d1((byte) 10);
    }

    public final void j(@os.l CharSequence charSequence, int i10, @os.l CharSequence charSequence2) throws n0 {
        l0.p(charSequence, lb.f.f9782f);
        l0.p(charSequence2, "statusText");
        d1.Y(this.f9241a, charSequence, 0, 0, null, 14, null);
        this.f9241a.d1((byte) 32);
        d1.Y(this.f9241a, String.valueOf(i10), 0, 0, null, 14, null);
        this.f9241a.d1((byte) 32);
        d1.Y(this.f9241a, charSequence2, 0, 0, null, 14, null);
        this.f9241a.d1((byte) 13);
        this.f9241a.d1((byte) 10);
    }
}
