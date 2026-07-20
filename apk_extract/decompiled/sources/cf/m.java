package cf;

import af.h6;
import af.k2;
import af.l1;
import af.l4;
import af.l6;
import af.m4;
import af.p1;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import k3.v8;
import k3.w8;
import ze.k1;
import ze.n1;
import ze.q2;
import ze.t0;
import ze.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends p1 implements k0 {
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public final e E;
    public final o0 F;
    public final q G;
    public boolean H;
    public final ph.c I;
    public l0 J;
    public int K;
    public final /* synthetic */ n L;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f1590v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f1591w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList f1592x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final qj.f f1593y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1594z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, int i8, h6 h6Var, Object obj, e eVar, o0 o0Var, q qVar, int i9) {
        super(i8, h6Var, nVar.f195c);
        this.L = nVar;
        this.f498s = h4.f.f5248b;
        this.f1593y = new qj.f();
        this.f1594z = false;
        this.A = false;
        this.B = false;
        this.H = true;
        this.K = -1;
        v8.i(obj, "lock");
        this.f1591w = obj;
        this.E = eVar;
        this.F = o0Var;
        this.G = qVar;
        this.C = i9;
        this.D = i9;
        this.f1590v = i9;
        ph.b.f8887a.getClass();
        this.I = ph.a.f8885a;
    }

    public static void v(m mVar, ze.p1 p1Var, String str) {
        n nVar = mVar.L;
        String str2 = nVar.f1599m;
        boolean z2 = nVar.q;
        q qVar = mVar.G;
        boolean z3 = qVar.B == null;
        ef.d dVar = f.f1525a;
        v8.i(p1Var, "headers");
        v8.i(str, "defaultPath");
        v8.i(str2, "authority");
        p1Var.a(l1.f417j);
        p1Var.a(l1.f418k);
        k1 k1Var = l1.f419l;
        p1Var.a(k1Var);
        ArrayList arrayList = new ArrayList(p1Var.f11400b + 7);
        if (z3) {
            arrayList.add(f.f1526b);
        } else {
            arrayList.add(f.f1525a);
        }
        if (z2) {
            arrayList.add(f.f1528d);
        } else {
            arrayList.add(f.f1527c);
        }
        arrayList.add(new ef.d(str2, ef.d.f4911h));
        arrayList.add(new ef.d(str, ef.d.f));
        arrayList.add(new ef.d(k1Var.f11380a, nVar.f1597k));
        arrayList.add(f.e);
        arrayList.add(f.f);
        f.a(arrayList, p1Var);
        mVar.f1592x = arrayList;
        q2 q2Var = qVar.f1627v;
        if (q2Var != null) {
            nVar.f1600n.r(q2Var, af.c0.MISCARRIED, true, new ze.p1());
            return;
        }
        if (qVar.f1622n.size() < qVar.C) {
            qVar.t(nVar);
            return;
        }
        qVar.D.add(nVar);
        if (!qVar.f1631z) {
            qVar.f1631z = true;
            af.q2 q2Var2 = qVar.F;
            if (q2Var2 != null) {
                q2Var2.b();
            }
        }
        if (nVar.e) {
            qVar.M.l(nVar, true);
        }
    }

    public static void w(m mVar, qj.f fVar, boolean z2, boolean z3) {
        if (mVar.B) {
            return;
        }
        if (!mVar.H) {
            v8.n(mVar.K != -1, "streamId should be set");
            mVar.F.a(z2, mVar.J, fVar, z3);
        } else {
            mVar.f1593y.k0(fVar, (int) fVar.f9195b);
            mVar.f1594z |= z2;
            mVar.A |= z3;
        }
    }

    public final void A(ArrayList arrayList, boolean z2) throws EOFException {
        q2 q2VarU;
        StringBuilder sb2;
        q2 q2VarA;
        n1 n1Var = p1.u;
        if (z2) {
            byte[][] bArrA = p0.a(arrayList);
            int length = bArrA.length / 2;
            ze.p1 p1Var = new ze.p1();
            p1Var.f11400b = length;
            p1Var.f11399a = bArrA;
            if (this.q == null && !this.f499t) {
                q2 q2VarU2 = p1.u(p1Var);
                this.q = q2VarU2;
                if (q2VarU2 != null) {
                    this.f497r = p1Var;
                }
            }
            q2 q2Var = this.q;
            if (q2Var != null) {
                q2 q2VarA2 = q2Var.a("trailers: " + p1Var);
                this.q = q2VarA2;
                x(q2VarA2, this.f497r, false);
                return;
            }
            n1 n1Var2 = v0.f11452b;
            q2 q2Var2 = (q2) p1Var.c(n1Var2);
            if (q2Var2 != null) {
                q2VarA = q2Var2.h((String) p1Var.c(v0.f11451a));
            } else if (this.f499t) {
                q2VarA = q2.f11404g.h("missing GRPC status in response");
            } else {
                Integer num = (Integer) p1Var.c(n1Var);
                q2VarA = (num != null ? l1.h(num.intValue()) : q2.f11410m.h("missing HTTP status code")).a("missing GRPC status, inferred error from HTTP status code");
            }
            p1Var.a(n1Var);
            p1Var.a(n1Var2);
            p1Var.a(v0.f11451a);
            if (this.f160o) {
                af.c.f194i.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{q2VarA, p1Var});
                return;
            }
            for (ze.n nVar : this.f153h.f312a) {
                nVar.e(p1Var);
            }
            s(q2VarA, p1Var, false);
            return;
        }
        byte[][] bArrA2 = p0.a(arrayList);
        Charset charset = t0.f11435a;
        int length2 = bArrA2.length / 2;
        ze.p1 p1Var2 = new ze.p1();
        p1Var2.f11400b = length2;
        p1Var2.f11399a = bArrA2;
        q2 q2Var3 = this.q;
        if (q2Var3 != null) {
            this.q = q2Var3.a("headers: " + p1Var2);
            return;
        }
        try {
            if (this.f499t) {
                q2VarU = q2.f11410m.h("Received headers twice");
                this.q = q2VarU;
                sb2 = new StringBuilder("headers: ");
            } else {
                Integer num2 = (Integer) p1Var2.c(n1Var);
                if (num2 == null || num2.intValue() < 100 || num2.intValue() >= 200) {
                    this.f499t = true;
                    q2VarU = p1.u(p1Var2);
                    this.q = q2VarU;
                    if (q2VarU != null) {
                        sb2 = new StringBuilder("headers: ");
                    } else {
                        p1Var2.a(n1Var);
                        p1Var2.a(v0.f11452b);
                        p1Var2.a(v0.f11451a);
                        q(p1Var2);
                        q2VarU = this.q;
                        if (q2VarU == null) {
                            return;
                        } else {
                            sb2 = new StringBuilder("headers: ");
                        }
                    }
                } else {
                    q2VarU = this.q;
                    if (q2VarU == null) {
                        return;
                    } else {
                        sb2 = new StringBuilder("headers: ");
                    }
                }
            }
            sb2.append(p1Var2);
            this.q = q2VarU.a(sb2.toString());
            this.f497r = p1Var2;
            this.f498s = p1.t(p1Var2);
        } catch (Throwable th2) {
            q2 q2Var4 = this.q;
            if (q2Var4 != null) {
                this.q = q2Var4.a("headers: " + p1Var2);
                this.f497r = p1Var2;
                this.f498s = p1.t(p1Var2);
            }
            throw th2;
        }
    }

    @Override // af.h
    public final void h(int i8) {
        int i9 = this.D - i8;
        this.D = i9;
        float f = i9;
        int i10 = this.f1590v;
        if (f <= i10 * 0.5f) {
            int i11 = i10 - i9;
            this.C += i11;
            this.D = i9 + i11;
            this.E.d(this.K, i11);
        }
    }

    @Override // af.h
    public final void j(Throwable th2) throws EOFException {
        x(q2.d(th2), new ze.p1(), true);
    }

    @Override // af.h
    public final void k(boolean z2) {
        if (this.f159n) {
            this.G.k(this.K, null, af.c0.PROCESSED, false, null, null);
        } else {
            this.G.k(this.K, null, af.c0.PROCESSED, false, ef.a.CANCEL, null);
        }
        v8.n(this.f160o, "status should have been reported on deframer closed");
        this.f157l = true;
        if (this.p && z2) {
            s(q2.f11410m.h("Encountered end-of-stream mid-frame"), new ze.p1(), true);
        }
        af.a aVar = this.f158m;
        if (aVar != null) {
            aVar.run();
            this.f158m = null;
        }
    }

    @Override // af.h
    public final void o(Runnable runnable) {
        synchronized (this.f1591w) {
            runnable.run();
        }
    }

    public final void x(q2 q2Var, ze.p1 p1Var, boolean z2) throws EOFException {
        if (this.B) {
            return;
        }
        this.B = true;
        if (!this.H) {
            this.G.k(this.K, q2Var, af.c0.PROCESSED, z2, ef.a.CANCEL, p1Var);
            return;
        }
        q qVar = this.G;
        LinkedList linkedList = qVar.D;
        n nVar = this.L;
        linkedList.remove(nVar);
        qVar.o(nVar);
        this.f1592x = null;
        this.f1593y.a();
        this.H = false;
        if (p1Var == null) {
            p1Var = new ze.p1();
        }
        s(q2Var, p1Var, true);
    }

    public final void y(int i8) {
        if (!(this.K == -1)) {
            throw new IllegalStateException(w8.a("the stream has been started with id %s", Integer.valueOf(i8)));
        }
        this.K = i8;
        o0 o0Var = this.F;
        this.J = new l0(o0Var, i8, o0Var.f1603a, this);
        n nVar = this.L;
        m mVar = nVar.f1600n;
        super.n();
        l6 l6Var = mVar.f303c;
        l6Var.getClass();
        ((k2) l6Var.f446b).g();
        if (this.H) {
            this.E.O(this.f1592x, this.K, nVar.q);
            for (ze.n nVar2 : nVar.f1598l.f312a) {
                nVar2.h();
            }
            this.f1592x = null;
            qj.f fVar = this.f1593y;
            if (fVar.f9195b > 0) {
                o0Var.a(this.f1594z, this.J, fVar, this.A);
            }
            this.H = false;
        }
    }

    public final void z(int i8, qj.f fVar, boolean z2) throws Throwable {
        long j8 = fVar.f9195b;
        int i9 = this.C - (((int) j8) + i8);
        this.C = i9;
        this.D -= i8;
        if (i9 < 0) {
            this.E.f(this.K, ef.a.FLOW_CONTROL_ERROR);
            this.G.k(this.K, q2.f11410m.h("Received data size exceeded our receiving window size"), af.c0.PROCESSED, false, null, null);
            return;
        }
        v vVar = new v(fVar);
        q2 q2Var = this.q;
        boolean z3 = false;
        if (q2Var != null) {
            Charset charset = this.f498s;
            l4 l4Var = m4.f457a;
            v8.i(charset, "charset");
            int i10 = (int) fVar.f9195b;
            byte[] bArr = new byte[i10];
            vVar.l(bArr, 0, i10);
            this.q = q2Var.a("DATA-----------------------------\n".concat(new String(bArr, charset)));
            vVar.close();
            if (this.q.f11414b.length() > 1000 || z2) {
                x(this.q, this.f497r, false);
                return;
            }
            return;
        }
        if (!this.f499t) {
            x(q2.f11410m.h("headers not received before payload"), new ze.p1(), false);
            return;
        }
        int i11 = (int) j8;
        try {
            if (this.f160o) {
                af.c.f194i.log(Level.INFO, "Received data on closed stream");
                vVar.close();
            } else {
                try {
                    this.f301a.a(vVar);
                } catch (Throwable th2) {
                    try {
                        j(th2);
                    } catch (Throwable th3) {
                        th = th3;
                        if (z3) {
                            vVar.close();
                        }
                        throw th;
                    }
                }
            }
            if (z2) {
                if (i11 > 0) {
                    this.q = q2.f11410m.h("Received unexpected EOS on non-empty DATA frame from server");
                } else {
                    this.q = q2.f11410m.h("Received unexpected EOS on empty DATA frame from server");
                }
                ze.p1 p1Var = new ze.p1();
                this.f497r = p1Var;
                s(this.q, p1Var, false);
            }
        } catch (Throwable th4) {
            th = th4;
            z3 = true;
        }
    }
}
