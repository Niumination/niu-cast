package af;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class l6 implements d0, ze.a1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k2 f444d = new k2(21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f447c;

    public /* synthetic */ l6(int i8, Object obj, Object obj2) {
        this.f445a = i8;
        this.f447c = obj;
        this.f446b = obj2;
    }

    @Override // ze.a1
    public void a(ze.r rVar) {
        ze.z0 f4Var;
        ze.z0 e4Var;
        g4 g4Var = (g4) this.f447c;
        g4Var.getClass();
        ze.q qVar = rVar.f11416a;
        if (qVar == ze.q.SHUTDOWN) {
            return;
        }
        ze.q qVar2 = ze.q.TRANSIENT_FAILURE;
        ze.f0 f0Var = g4Var.f292d;
        if (qVar == qVar2 || qVar == ze.q.IDLE) {
            f0Var.l();
        }
        if (g4Var.f == qVar2) {
            if (qVar == ze.q.CONNECTING) {
                return;
            }
            if (qVar == ze.q.IDLE) {
                g4Var.e();
                return;
            }
        }
        int i8 = c4.f203a[qVar.ordinal()];
        ze.i iVar = (ze.i) this.f446b;
        if (i8 != 1) {
            if (i8 == 2) {
                e4Var = new e4(ze.x0.e);
            } else if (i8 == 3) {
                f4Var = new e4(ze.x0.b(iVar, null));
            } else {
                if (i8 != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + qVar);
                }
                e4Var = new e4(ze.x0.a(rVar.f11417b));
            }
            g4Var.f = qVar;
            f0Var.m(qVar, e4Var);
        }
        f4Var = new f4(g4Var, iVar);
        e4Var = f4Var;
        g4Var.f = qVar;
        f0Var.m(qVar, e4Var);
    }

    @Override // af.d0
    public void i(ze.p1 p1Var) {
        AtomicInteger atomicInteger;
        int i8;
        int i9;
        switch (this.f445a) {
            case 2:
                ((d0) this.f446b).i(p1Var);
                break;
            default:
                if (((e5) this.f446b).f248d > 0) {
                    ze.k1 k1Var = x2.E;
                    p1Var.a(k1Var);
                    p1Var.f(k1Var, String.valueOf(((e5) this.f446b).f248d));
                }
                x2 x2Var = (x2) this.f447c;
                e5 e5Var = (e5) this.f446b;
                ze.k1 k1Var2 = x2.E;
                r4 r4VarN = x2Var.n(e5Var);
                if (r4VarN != null) {
                    x2Var.f684b.execute(r4VarN);
                }
                if (((x2) this.f447c).f695o.f == ((e5) this.f446b)) {
                    f5 f5Var = ((x2) this.f447c).f693m;
                    if (f5Var != null) {
                        do {
                            atomicInteger = f5Var.f288d;
                            i8 = atomicInteger.get();
                            i9 = f5Var.f285a;
                            if (i8 == i9) {
                            }
                        } while (!atomicInteger.compareAndSet(i8, Math.min(f5Var.f287c + i8, i9)));
                    }
                    ((x2) this.f447c).f685c.execute(new e(23, this, p1Var));
                }
                break;
        }
    }

    @Override // af.j6
    public void j(a8.a aVar) {
        switch (this.f445a) {
            case 2:
                ((d0) this.f446b).j(aVar);
                break;
            default:
                b5 b5Var = ((x2) this.f447c).f695o;
                v8.n(b5Var.f != null, "Headers should be received prior to messages.");
                if (b5Var.f == ((e5) this.f446b)) {
                    ((x2) this.f447c).f685c.execute(new e(24, this, aVar));
                } else {
                    Logger logger = l1.f410a;
                    while (true) {
                        InputStream inputStreamF = aVar.f();
                        if (inputStreamF != null) {
                            l1.b(inputStreamF);
                        }
                    }
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x022f  */
    @Override // af.d0
    public void l(ze.q2 q2Var, c0 c0Var, ze.p1 p1Var) {
        boolean z2;
        z4 z4Var;
        x2 x2Var;
        d2 d2Var;
        switch (this.f445a) {
            case 2:
                ((z1) this.f447c).f746b.f139b.b(q2Var.e());
                ((d0) this.f446b).l(q2Var, c0Var, p1Var);
                return;
            default:
                synchronized (((x2) this.f447c).f689i) {
                    x2 x2Var2 = (x2) this.f447c;
                    x2Var2.f695o = x2Var2.f695o.d((e5) this.f446b);
                    ((x2) this.f447c).f694n.f594b.add(String.valueOf(q2Var.f11413a));
                    break;
                }
                if (((x2) this.f447c).f696r.decrementAndGet() == Integer.MIN_VALUE) {
                    ((x2) this.f447c).f685c.execute(new d5(this, 0));
                    return;
                }
                e5 e5Var = (e5) this.f446b;
                if (e5Var.f247c) {
                    x2 x2Var3 = (x2) this.f447c;
                    r4 r4VarN = x2Var3.n(e5Var);
                    if (r4VarN != null) {
                        x2Var3.f684b.execute(r4VarN);
                    }
                    if (((x2) this.f447c).f695o.f == ((e5) this.f446b)) {
                        ((x2) this.f447c).t(q2Var, c0Var, p1Var);
                        return;
                    }
                    return;
                }
                c0 c0Var2 = c0.MISCARRIED;
                if (c0Var == c0Var2 && ((x2) this.f447c).q.incrementAndGet() > 1000) {
                    x2 x2Var4 = (x2) this.f447c;
                    r4 r4VarN2 = x2Var4.n((e5) this.f446b);
                    if (r4VarN2 != null) {
                        x2Var4.f684b.execute(r4VarN2);
                    }
                    if (((x2) this.f447c).f695o.f == ((e5) this.f446b)) {
                        ((x2) this.f447c).t(ze.q2.f11410m.h("Too many transparent retries. Might be a bug in gRPC").g(new ze.s2(q2Var)), c0Var, p1Var);
                        return;
                    }
                    return;
                }
                if (((x2) this.f447c).f695o.f == null) {
                    if (c0Var == c0Var2 || (c0Var == c0.REFUSED && ((x2) this.f447c).p.compareAndSet(false, true))) {
                        e5 e5VarO = ((x2) this.f447c).o(((e5) this.f446b).f248d, true);
                        if (e5VarO == null) {
                            return;
                        }
                        x2 x2Var5 = (x2) this.f447c;
                        if (x2Var5.f688h) {
                            synchronized (x2Var5.f689i) {
                                x2 x2Var6 = (x2) this.f447c;
                                x2Var6.f695o = x2Var6.f695o.c((e5) this.f446b, e5VarO);
                                break;
                            }
                        }
                        ((x2) this.f447c).f684b.execute(new c5(this, e5VarO, 1));
                        return;
                    }
                    if (c0Var != c0.DROPPED) {
                        ((x2) this.f447c).p.set(true);
                        x2 x2Var7 = (x2) this.f447c;
                        Integer numValueOf = null;
                        if (!x2Var7.f688h) {
                            g5 g5Var = x2Var7.f;
                            long nanos = 0;
                            if (g5Var == null) {
                                z4Var = new z4(0L, false);
                            } else {
                                boolean zContains = g5Var.f.contains(q2Var.f11413a);
                                String str = (String) p1Var.c(x2.F);
                                if (str != null) {
                                    try {
                                        numValueOf = Integer.valueOf(str);
                                    } catch (NumberFormatException unused) {
                                        numValueOf = -1;
                                    }
                                }
                                boolean z3 = (x2Var7.f693m == null || (!zContains && (numValueOf == null || numValueOf.intValue() >= 0))) ? false : !x2Var7.f693m.a();
                                if (x2Var7.f.f293a <= ((e5) this.f446b).f248d + 1 || z3) {
                                    z2 = false;
                                } else if (numValueOf == null) {
                                    if (zContains) {
                                        nanos = (long) (x2.H.nextDouble() * x2Var7.f701x);
                                        double d7 = x2Var7.f701x;
                                        g5 g5Var2 = x2Var7.f;
                                        x2Var7.f701x = Math.min((long) (d7 * g5Var2.f296d), g5Var2.f295c);
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                } else if (numValueOf.intValue() >= 0) {
                                    nanos = TimeUnit.MILLISECONDS.toNanos(numValueOf.intValue());
                                    x2Var7.f701x = x2Var7.f.f294b;
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                z4Var = new z4(nanos, z2);
                            }
                            if (z4Var.f750b) {
                                e5 e5VarO2 = ((x2) this.f447c).o(((e5) this.f446b).f248d + 1, false);
                                if (e5VarO2 == null) {
                                    return;
                                }
                                synchronized (((x2) this.f447c).f689i) {
                                    x2Var = (x2) this.f447c;
                                    d2Var = new d2(x2Var.f689i);
                                    x2Var.f699v = d2Var;
                                    break;
                                }
                                d2Var.g(x2Var.f686d.schedule(new c5(this, e5VarO2, 0), z4Var.f751c, TimeUnit.NANOSECONDS));
                                return;
                            }
                            break;
                        } else {
                            String str2 = (String) p1Var.c(x2.F);
                            if (str2 != null) {
                                try {
                                    numValueOf = Integer.valueOf(str2);
                                } catch (NumberFormatException unused2) {
                                    numValueOf = -1;
                                }
                            }
                            x2 x2Var8 = (x2) this.f447c;
                            boolean zContains2 = x2Var8.f687g.f482c.contains(q2Var.f11413a);
                            boolean z5 = (x2Var8.f693m == null || (!zContains2 && (numValueOf == null || numValueOf.intValue() >= 0))) ? false : !x2Var8.f693m.a();
                            if (zContains2 && !z5 && !q2Var.e() && numValueOf != null && numValueOf.intValue() > 0) {
                                numValueOf = 0;
                            }
                            boolean z10 = zContains2 && !z5;
                            if (z10) {
                                x2.l((x2) this.f447c, numValueOf);
                            }
                            synchronized (((x2) this.f447c).f689i) {
                                try {
                                    x2 x2Var9 = (x2) this.f447c;
                                    x2Var9.f695o = x2Var9.f695o.b((e5) this.f446b);
                                    if (z10) {
                                        x2 x2Var10 = (x2) this.f447c;
                                        if (!x2Var10.s(x2Var10.f695o)) {
                                            if (!((x2) this.f447c).f695o.f189d.isEmpty()) {
                                            }
                                        }
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                    } else {
                        x2 x2Var11 = (x2) this.f447c;
                        if (x2Var11.f688h) {
                            x2Var11.r();
                        }
                    }
                    break;
                }
                x2 x2Var12 = (x2) this.f447c;
                r4 r4VarN3 = x2Var12.n((e5) this.f446b);
                if (r4VarN3 != null) {
                    x2Var12.f684b.execute(r4VarN3);
                }
                if (((x2) this.f447c).f695o.f == ((e5) this.f446b)) {
                    ((x2) this.f447c).t(q2Var, c0Var, p1Var);
                    return;
                }
                return;
        }
    }

    @Override // af.j6
    public void q() {
        switch (this.f445a) {
            case 2:
                ((d0) this.f446b).q();
                break;
            default:
                x2 x2Var = (x2) this.f447c;
                if (x2Var.isReady()) {
                    x2Var.f685c.execute(new d5(this, 1));
                    break;
                }
                break;
        }
    }

    public String toString() {
        switch (this.f445a) {
            case 2:
                o6.a aVarA = t8.a(this);
                aVarA.d((d0) this.f446b, "delegate");
                return aVarA.toString();
            default:
                return super.toString();
        }
    }

    public l6() {
        this.f445a = 0;
        k2 k2Var = k2.f377c;
        this.f447c = d6.n();
        this.f446b = k2Var;
    }

    public l6(String str) {
        this.f445a = 1;
        ze.d1 d1VarA = ze.d1.a();
        v8.i(d1VarA, "registry");
        this.f446b = d1VarA;
        v8.i(str, "defaultPolicy");
        this.f447c = str;
    }
}
