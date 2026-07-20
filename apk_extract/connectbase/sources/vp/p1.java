package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p1 extends f0 {
    @Override // vp.f0
    @os.l
    public List<c1> F0() {
        return K0().F0();
    }

    @Override // vp.f0
    @os.l
    public a1 G0() {
        return K0().G0();
    }

    @Override // vp.f0
    public boolean H0() {
        return K0().H0();
    }

    @Override // vp.f0
    @os.l
    public final n1 J0() {
        f0 f0VarK0 = K0();
        while (f0VarK0 instanceof p1) {
            f0VarK0 = ((p1) f0VarK0).K0();
        }
        return (n1) f0VarK0;
    }

    @os.l
    public abstract f0 K0();

    public boolean L0() {
        return true;
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        return K0().getAnnotations();
    }

    @Override // vp.f0
    @os.l
    public op.h o() {
        return K0().o();
    }

    @os.l
    public String toString() {
        return L0() ? K0().toString() : "<Not computed yet>";
    }
}
