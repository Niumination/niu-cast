package af;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 implements r3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ze.v2 f586d;
    public r0 e;
    public r0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r0 f587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public tj.x f588h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ze.q2 f590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ze.z0 f591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f592l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.r0 f583a = ze.r0.a(t0.class, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f584b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Collection f589i = new LinkedHashSet();

    public t0(Executor executor, ze.v2 v2Var) {
        this.f585c = executor;
        this.f586d = v2Var;
    }

    @Override // af.r3
    public final void a(ze.q2 q2Var) {
        Collection<s0> collection;
        r0 r0Var;
        c(q2Var);
        synchronized (this.f584b) {
            try {
                collection = this.f589i;
                r0Var = this.f587g;
                this.f587g = null;
                if (!collection.isEmpty()) {
                    this.f589i = Collections.emptyList();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (r0Var != null) {
            for (s0 s0Var : collection) {
                v0 v0VarP = s0Var.p(new e1(q2Var, c0.REFUSED, s0Var.f571l));
                if (v0VarP != null) {
                    v0VarP.run();
                }
            }
            this.f586d.execute(r0Var);
        }
    }

    public final s0 b(i4 i4Var, ze.n[] nVarArr) {
        int size;
        s0 s0Var = new s0(this, i4Var, nVarArr);
        this.f589i.add(s0Var);
        synchronized (this.f584b) {
            size = this.f589i.size();
        }
        if (size == 1) {
            this.f586d.b(this.e);
        }
        for (ze.n nVar : nVarArr) {
            nVar.a();
        }
        return s0Var;
    }

    @Override // af.r3
    public final void c(ze.q2 q2Var) {
        r0 r0Var;
        synchronized (this.f584b) {
            try {
                if (this.f590j != null) {
                    return;
                }
                this.f590j = q2Var;
                this.f586d.b(new e(6, this, q2Var));
                if (!e() && (r0Var = this.f587g) != null) {
                    this.f586d.b(r0Var);
                    this.f587g = null;
                }
                this.f586d.a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ze.q0
    public final ze.r0 d() {
        return this.f583a;
    }

    public final boolean e() {
        boolean z2;
        synchronized (this.f584b) {
            z2 = !this.f589i.isEmpty();
        }
        return z2;
    }

    @Override // af.e0
    public final b0 f(ze.r1 r1Var, ze.p1 p1Var, ze.f fVar, ze.n[] nVarArr) {
        b0 e1Var;
        try {
            i4 i4Var = new i4(r1Var, p1Var, fVar);
            ze.z0 z0Var = null;
            long j8 = -1;
            while (true) {
                synchronized (this.f584b) {
                    ze.q2 q2Var = this.f590j;
                    if (q2Var == null) {
                        ze.z0 z0Var2 = this.f591k;
                        if (z0Var2 != null) {
                            if (z0Var != null && j8 == this.f592l) {
                                e1Var = b(i4Var, nVarArr);
                                break;
                            }
                            j8 = this.f592l;
                            e0 e0VarG = l1.g(z0Var2.a(i4Var), Boolean.TRUE.equals(fVar.f));
                            if (e0VarG != null) {
                                e1Var = e0VarG.f(i4Var.f335c, i4Var.f334b, i4Var.f333a, nVarArr);
                                break;
                            }
                            z0Var = z0Var2;
                        } else {
                            e1Var = b(i4Var, nVarArr);
                            break;
                        }
                    } else {
                        e1Var = new e1(q2Var, nVarArr);
                        break;
                    }
                }
            }
            this.f586d.a();
            return e1Var;
        } catch (Throwable th2) {
            this.f586d.a();
            throw th2;
        }
    }

    @Override // af.r3
    public final Runnable g(q3 q3Var) {
        tj.x xVar = (tj.x) q3Var;
        this.f588h = xVar;
        this.e = new r0(xVar, 0);
        this.f = new r0(xVar, 1);
        this.f587g = new r0(xVar, 2);
        return null;
    }

    public final void h(ze.z0 z0Var) {
        r0 r0Var;
        synchronized (this.f584b) {
            this.f591k = z0Var;
            this.f592l++;
            if (z0Var != null && e()) {
                ArrayList<s0> arrayList = new ArrayList(this.f589i);
                ArrayList arrayList2 = new ArrayList();
                for (s0 s0Var : arrayList) {
                    ze.x0 x0VarA = z0Var.a(s0Var.f569j);
                    ze.f fVar = s0Var.f569j.f333a;
                    e0 e0VarG = l1.g(x0VarA, Boolean.TRUE.equals(fVar.f));
                    if (e0VarG != null) {
                        Executor executor = this.f585c;
                        Executor executor2 = fVar.f11348b;
                        if (executor2 != null) {
                            executor = executor2;
                        }
                        ze.y yVar = s0Var.f570k;
                        ze.y yVarC = yVar.c();
                        try {
                            i4 i4Var = s0Var.f569j;
                            b0 b0VarF = e0VarG.f(i4Var.f335c, i4Var.f334b, i4Var.f333a, s0Var.f571l);
                            yVar.k(yVarC);
                            v0 v0VarP = s0Var.p(b0VarF);
                            if (v0VarP != null) {
                                executor.execute(v0VarP);
                            }
                            arrayList2.add(s0Var);
                        } catch (Throwable th2) {
                            yVar.k(yVarC);
                            throw th2;
                        }
                    }
                }
                synchronized (this.f584b) {
                    try {
                        if (e()) {
                            this.f589i.removeAll(arrayList2);
                            if (this.f589i.isEmpty()) {
                                this.f589i = new LinkedHashSet();
                            }
                            if (!e()) {
                                this.f586d.b(this.f);
                                if (this.f590j != null && (r0Var = this.f587g) != null) {
                                    this.f586d.b(r0Var);
                                    this.f587g = null;
                                }
                            }
                            this.f586d.a();
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }
    }
}
