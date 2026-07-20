package tj;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f15569a;

    public a0(k1 k1Var) {
        this.f15569a = k1Var;
    }

    @Override // tj.a
    public Collection<k1> a() {
        return Collections.singletonList(this.f15569a);
    }

    public k1 b() {
        return this.f15569a;
    }

    public d c() {
        if (n1.p(this.f15569a)) {
            return n1.i(this.f15569a);
        }
        k1 k1Var = this.f15569a;
        if (k1Var instanceof n1.f) {
            return new g0.b(k1Var.d(), n1.h(this.f15569a));
        }
        if (!(k1Var instanceof n1.e)) {
            throw new sj.c.d("ConfigNodeSimpleValue did not contain a valid value token");
        }
        return new f0(this.f15569a.d(), new j1(r0.e(n1.g(k1Var).iterator(), this.f15569a.d()), n1.f(this.f15569a)), 0);
    }
}
