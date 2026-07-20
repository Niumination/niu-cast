package af;

import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public static final k2 e = new k2(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f541d;

    public r() {
        k2 k2Var = k2.f377c;
        this.f539b = d6.n();
        this.f540c = d6.n();
        this.f541d = d6.n();
        this.f538a = k2Var;
    }

    public void a(ze.q2 q2Var) {
        synchronized (this.f538a) {
            try {
                if (((ze.q2) this.f540c) != null) {
                    return;
                }
                this.f540c = q2Var;
                boolean zIsEmpty = ((HashSet) this.f539b).isEmpty();
                if (zIsEmpty) {
                    ((j3) this.f541d).D.c(q2Var);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(boolean z2) {
        if (z2) {
            ((s2) this.f540c).e();
        } else {
            ((s2) this.f541d).e();
        }
    }

    public r(l6 l6Var, a3 a3Var) {
        this.f541d = l6Var;
        this.f538a = a3Var;
        ze.d1 d1Var = (ze.d1) l6Var.f446b;
        String str = (String) l6Var.f447c;
        ze.c1 c1VarB = d1Var.b(str);
        this.f540c = c1VarB;
        if (c1VarB != null) {
            this.f539b = c1VarB.d(a3Var);
            return;
        }
        throw new IllegalStateException(h0.a.j("Could not find policy '", str, "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files."));
    }

    public r(j3 j3Var) {
        this.f541d = j3Var;
        this.f538a = new Object();
        this.f539b = new HashSet();
    }
}
