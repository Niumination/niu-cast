package l3;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class u1 implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f7311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p2 f7312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f7314d;

    public u1(p2 p2Var, g0 g0Var, q1 q1Var) {
        this.f7312b = p2Var;
        this.f7313c = q1Var instanceof n0;
        this.f7314d = g0Var;
        this.f7311a = q1Var;
    }

    @Override // l3.f2
    public final Object a() {
        q1 q1Var = this.f7311a;
        return q1Var instanceof q0 ? (q0) ((q0) q1Var).n(4, null) : ((m0) ((q0) q1Var).n(5, null)).e();
    }

    @Override // l3.f2
    public final void b(Object obj) {
        this.f7312b.getClass();
        p2.c(obj);
        g0.c(obj);
    }

    @Override // l3.f2
    public final boolean c(q0 q0Var, Object obj) {
        this.f7312b.getClass();
        if (!q0Var.zzc.equals(((q0) obj).zzc)) {
            return false;
        }
        if (this.f7313c) {
            return ((n0) q0Var).zza.equals(((n0) obj).zza);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bc A[EDGE_INSN: B:51:0x00bc->B:35:0x00bc BREAK  A[LOOP:1: B:18:0x006d->B:26:0x0098], SYNTHETIC] */
    @Override // l3.f2
    public final void d(Object obj, byte[] bArr, int i8, int i9, t tVar) throws b1 {
        q0 q0Var = (q0) obj;
        o2 o2VarB = q0Var.zzc;
        if (o2VarB == o2.f) {
            o2VarB = o2.b();
            q0Var.zzc = o2VarB;
        }
        o2 o2Var = o2VarB;
        i0 i0VarO = ((n0) obj).o();
        int iM = i8;
        p0 p0VarA = null;
        while (iM < i9) {
            int iN = k2.n(bArr, iM, tVar);
            int i10 = tVar.f7294a;
            q1 q1Var = this.f7311a;
            int i11 = 2;
            f0 f0Var = tVar.f7297d;
            if (i10 == 11) {
                int i12 = 0;
                b0 b0Var = null;
                while (iN < i9) {
                    iN = k2.n(bArr, iN, tVar);
                    int i13 = tVar.f7294a;
                    int i14 = i13 >>> 3;
                    int i15 = i13 & 7;
                    if (i14 == i11) {
                        if (i15 != 0) {
                            if (i13 == 12) {
                                break;
                                break;
                            }
                            iN = k2.t(i13, bArr, iN, i9, tVar);
                        } else {
                            iN = k2.n(bArr, iN, tVar);
                            i12 = tVar.f7294a;
                            p0VarA = f0Var.a(q1Var, i12);
                        }
                    } else if (i14 != 3) {
                        if (i13 == 12) {
                            break;
                            break;
                        }
                        iN = k2.t(i13, bArr, iN, i9, tVar);
                    } else if (p0VarA == null) {
                        if (i15 != 2) {
                            if (i13 == 12) {
                                break;
                            } else {
                                iN = k2.t(i13, bArr, iN, i9, tVar);
                            }
                        } else {
                            iN = k2.a(bArr, iN, tVar);
                            b0Var = (b0) tVar.f7296c;
                        }
                    } else {
                        iN = k2.g(y1.f7325c.b(p0VarA.f7283a.getClass()), bArr, iN, i9, tVar);
                        i0VarO.f(p0VarA.f7284b, tVar.f7296c);
                    }
                    i11 = 2;
                }
                if (b0Var != null) {
                    o2Var.c((i12 << 3) | 2, b0Var);
                }
                iM = iN;
            } else if ((i10 & 7) == 2) {
                p0 p0VarA2 = f0Var.a(q1Var, i10 >>> 3);
                if (p0VarA2 != null) {
                    iM = k2.g(y1.f7325c.b(p0VarA2.f7283a.getClass()), bArr, iN, i9, tVar);
                    i0VarO.f(p0VarA2.f7284b, tVar.f7296c);
                } else {
                    iM = k2.m(i10, bArr, iN, i9, o2Var, tVar);
                }
                p0VarA = p0VarA2;
            } else {
                iM = k2.t(i10, bArr, iN, i9, tVar);
            }
        }
        if (iM != i9) {
            throw b1.zze();
        }
    }

    @Override // l3.f2
    public final void e(Object obj, l1 l1Var) {
        Iterator itD = ((n0) obj).zza.d();
        while (true) {
            m2 m2Var = (m2) itD;
            if (!m2Var.hasNext()) {
                this.f7312b.getClass();
                o2 o2Var = ((q0) obj).zzc;
                for (int i8 = 0; i8 < o2Var.f7279a; i8++) {
                    l1Var.q(o2Var.f7280b[i8] >>> 3, o2Var.f7281c[i8]);
                }
                return;
            }
            Map.Entry entry = (Map.Entry) m2Var.next();
            o0 o0Var = (o0) entry.getKey();
            if (o0Var.f7277b.zza() != b3.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            l1Var.q(o0Var.f7276a, entry.getValue());
        }
    }

    @Override // l3.f2
    public final void f(Object obj, Object obj2) {
        g2.c(this.f7312b, obj, obj2);
        if (this.f7313c) {
            g2.b(this.f7314d, obj, obj2);
        }
    }

    @Override // l3.f2
    public final int g(q0 q0Var) {
        this.f7312b.getClass();
        int iHashCode = q0Var.zzc.hashCode();
        if (!this.f7313c) {
            return iHashCode;
        }
        return ((n0) q0Var).zza.f7250a.hashCode() + (iHashCode * 53);
    }

    @Override // l3.f2
    public final int h(q0 q0Var) {
        h2 h2Var;
        this.f7312b.getClass();
        o2 o2Var = q0Var.zzc;
        int iC = o2Var.f7282d;
        int i8 = 0;
        if (iC == -1) {
            iC = 0;
            for (int i9 = 0; i9 < o2Var.f7279a; i9++) {
                int i10 = o2Var.f7280b[i9] >>> 3;
                b0 b0Var = (b0) o2Var.f7281c[i9];
                Logger logger = c0.e;
                int iZzd = b0Var.zzd();
                int iQ = c0.q(iZzd) + iZzd;
                int iQ2 = c0.q(16);
                int iQ3 = c0.q(i10);
                int iQ4 = c0.q(8);
                iC = h0.a.c(24, iQ, iQ2 + iQ3 + iQ4 + iQ4, iC);
            }
            o2Var.f7282d = iC;
        }
        if (!this.f7313c) {
            return iC;
        }
        i0 i0Var = ((n0) q0Var).zza;
        int iJ = 0;
        while (true) {
            h2Var = i0Var.f7250a;
            if (i8 >= h2Var.f7245b.size()) {
                break;
            }
            iJ += i0.j(h2Var.d(i8));
            i8++;
        }
        Iterator it = h2Var.b().iterator();
        while (it.hasNext()) {
            iJ += i0.j((Map.Entry) it.next());
        }
        return iC + iJ;
    }

    @Override // l3.f2
    public final boolean i(Object obj) {
        this.f7314d.getClass();
        return ((n0) obj).zza.g();
    }
}
