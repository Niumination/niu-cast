package ze;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11327b = new a("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final af.l f11328c = new af.l(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11329a;

    public q2 a(y0 y0Var) {
        List list = y0Var.f11477a;
        if (!list.isEmpty() || b()) {
            int i8 = this.f11329a;
            this.f11329a = i8 + 1;
            if (i8 == 0) {
                d(y0Var);
            }
            this.f11329a = 0;
            return q2.e;
        }
        q2 q2VarH = q2.f11411n.h("NameResolver returned no usable address. addrs=" + list + ", attrs=" + y0Var.f11478b);
        c(q2VarH);
        return q2VarH;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(q2 q2Var);

    public void d(y0 y0Var) {
        int i8 = this.f11329a;
        this.f11329a = i8 + 1;
        if (i8 == 0) {
            a(y0Var);
        }
        this.f11329a = 0;
    }

    public void e() {
    }

    public abstract void f();
}
