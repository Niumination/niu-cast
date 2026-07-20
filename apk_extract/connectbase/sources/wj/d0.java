package wj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements r1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vj.c3 f18456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f18457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f18458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f18459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r1.a f18460h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @hm.a("lock")
    public vj.y2 f18462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @gm.j
    @hm.a("lock")
    public vj.o1.k f18463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @hm.a("lock")
    public long f18464l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.c1 f18453a = vj.c1.a(d0.class, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18454b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @hm.a("lock")
    @gm.i
    public Collection<e> f18461i = new LinkedHashSet();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r1.a f18465a;

        public a(r1.a aVar) {
            this.f18465a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18465a.c(true);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r1.a f18467a;

        public b(r1.a aVar) {
            this.f18467a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18467a.c(false);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r1.a f18469a;

        public c(r1.a aVar) {
            this.f18469a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18469a.a();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.y2 f18471a;

        public d(vj.y2 y2Var) {
            this.f18471a = y2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.f18460h.d(this.f18471a);
        }
    }

    public class e extends e0 {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final vj.o1.h f18473k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final vj.w f18474l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final vj.n[] f18475m;

        public /* synthetic */ e(d0 d0Var, vj.o1.h hVar, vj.n[] nVarArr, a aVar) {
            this(hVar, nVarArr);
        }

        @Override // wj.e0
        public void E(vj.y2 y2Var) {
            for (vj.n nVar : this.f18475m) {
                nVar.i(y2Var);
            }
        }

        public final Runnable K(u uVar) {
            vj.w wVarC = this.f18474l.c();
            try {
                return G(uVar.k(this.f18473k.c(), this.f18473k.b(), this.f18473k.a(), this.f18475m));
            } finally {
                this.f18474l.q(wVarC);
            }
        }

        @Override // wj.e0, wj.s
        public void a(vj.y2 y2Var) {
            super.a(y2Var);
            synchronized (d0.this.f18454b) {
                try {
                    d0 d0Var = d0.this;
                    if (d0Var.f18459g != null) {
                        boolean zRemove = d0Var.f18461i.remove(this);
                        if (!d0.this.t() && zRemove) {
                            d0 d0Var2 = d0.this;
                            d0Var2.f18456d.b(d0Var2.f18458f);
                            d0 d0Var3 = d0.this;
                            if (d0Var3.f18462j != null) {
                                d0Var3.f18456d.b(d0Var3.f18459g);
                                d0.this.f18459g = null;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            d0.this.f18456d.a();
        }

        @Override // wj.e0, wj.s
        public void x(b1 b1Var) {
            if (this.f18473k.a().m()) {
                b1Var.a("wait_for_ready");
            }
            super.x(b1Var);
        }

        public e(vj.o1.h hVar, vj.n[] nVarArr) {
            this.f18474l = vj.w.o();
            this.f18473k = hVar;
            this.f18475m = nVarArr;
        }
    }

    public d0(Executor executor, vj.c3 c3Var) {
        this.f18455c = executor;
        this.f18456d = c3Var;
    }

    @Override // wj.r1
    public final void a(vj.y2 y2Var) {
        Collection<e> collection;
        Runnable runnable;
        n(y2Var);
        synchronized (this.f18454b) {
            try {
                collection = this.f18461i;
                runnable = this.f18459g;
                this.f18459g = null;
                if (!collection.isEmpty()) {
                    this.f18461i = Collections.emptyList();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (runnable != null) {
            for (e eVar : collection) {
                Runnable runnableG = eVar.G(new i0(y2Var, t.a.REFUSED, eVar.f18475m));
                if (runnableG != null) {
                    runnableG.run();
                }
            }
            this.f18456d.execute(runnable);
        }
    }

    @Override // wj.u
    public final void d(u.a aVar, Executor executor) {
        throw new UnsupportedOperationException("This method is not expected to be called");
    }

    @Override // vj.m1
    public vj.c1 e() {
        return this.f18453a;
    }

    @Override // wj.r1
    public final Runnable f(r1.a aVar) {
        this.f18460h = aVar;
        this.f18457e = new a(aVar);
        this.f18458f = new b(aVar);
        this.f18459g = new c(aVar);
        return null;
    }

    @Override // vj.a1
    public q1.s1<vj.v0.l> j() {
        q1.l2 l2VarF = q1.l2.F();
        l2VarF.B(null);
        return l2VarF;
    }

    @Override // wj.u
    public final s k(vj.w1<?, ?> w1Var, vj.v1 v1Var, vj.e eVar, vj.n[] nVarArr) {
        s i0Var;
        try {
            g2 g2Var = new g2(w1Var, v1Var, eVar);
            vj.o1.k kVar = null;
            long j10 = -1;
            while (true) {
                synchronized (this.f18454b) {
                    if (this.f18462j == null) {
                        vj.o1.k kVar2 = this.f18463k;
                        if (kVar2 != null) {
                            if (kVar != null && j10 == this.f18464l) {
                                i0Var = r(g2Var, nVarArr);
                                break;
                            }
                            j10 = this.f18464l;
                            u uVarN = v0.n(kVar2.a(g2Var), eVar.m());
                            if (uVarN != null) {
                                i0Var = uVarN.k(g2Var.f18697c, g2Var.f18696b, g2Var.f18695a, nVarArr);
                                break;
                            }
                            kVar = kVar2;
                        } else {
                            i0Var = r(g2Var, nVarArr);
                            break;
                        }
                    } else {
                        i0Var = new i0(this.f18462j, nVarArr);
                        break;
                    }
                }
            }
            this.f18456d.a();
            return i0Var;
        } catch (Throwable th2) {
            this.f18456d.a();
            throw th2;
        }
    }

    @Override // wj.r1
    public final void n(vj.y2 y2Var) {
        Runnable runnable;
        synchronized (this.f18454b) {
            try {
                if (this.f18462j != null) {
                    return;
                }
                this.f18462j = y2Var;
                this.f18456d.b(new d(y2Var));
                if (!t() && (runnable = this.f18459g) != null) {
                    this.f18456d.b(runnable);
                    this.f18459g = null;
                }
                this.f18456d.a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @hm.a("lock")
    public final e r(vj.o1.h hVar, vj.n[] nVarArr) {
        e eVar = new e(hVar, nVarArr);
        this.f18461i.add(eVar);
        if (s() == 1) {
            this.f18456d.b(this.f18457e);
        }
        for (vj.n nVar : nVarArr) {
            nVar.j();
        }
        return eVar;
    }

    @b1.e
    public final int s() {
        int size;
        synchronized (this.f18454b) {
            size = this.f18461i.size();
        }
        return size;
    }

    public final boolean t() {
        boolean z10;
        synchronized (this.f18454b) {
            z10 = !this.f18461i.isEmpty();
        }
        return z10;
    }

    public final void u(@gm.j vj.o1.k kVar) {
        Runnable runnable;
        synchronized (this.f18454b) {
            this.f18463k = kVar;
            this.f18464l++;
            if (kVar != null && t()) {
                ArrayList<e> arrayList = new ArrayList(this.f18461i);
                ArrayList arrayList2 = new ArrayList();
                for (e eVar : arrayList) {
                    vj.o1.g gVarA = kVar.a(eVar.f18473k);
                    vj.e eVarA = eVar.f18473k.a();
                    u uVarN = v0.n(gVarA, eVarA.m());
                    if (uVarN != null) {
                        Executor executor = this.f18455c;
                        Executor executor2 = eVarA.f17087b;
                        if (executor2 != null) {
                            executor = executor2;
                        }
                        Runnable runnableK = eVar.K(uVarN);
                        if (runnableK != null) {
                            executor.execute(runnableK);
                        }
                        arrayList2.add(eVar);
                    }
                }
                synchronized (this.f18454b) {
                    try {
                        if (t()) {
                            this.f18461i.removeAll(arrayList2);
                            if (this.f18461i.isEmpty()) {
                                this.f18461i = new LinkedHashSet();
                            }
                            if (!t()) {
                                this.f18456d.b(this.f18458f);
                                if (this.f18462j != null && (runnable = this.f18459g) != null) {
                                    this.f18456d.b(runnable);
                                    this.f18459g = null;
                                }
                            }
                            this.f18456d.a();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }
}
