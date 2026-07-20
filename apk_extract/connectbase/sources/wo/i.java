package wo;

import ik.y0;
import jq.e0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l<T> f19791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public T f19793c;

    public void a() {
    }

    public void b() {
        if (this.f19793c == null) {
            this.f19792b++;
        }
    }

    public void c(@os.l T t10) {
        l0.p(t10, "objectType");
        d(t10);
    }

    public final void d(@os.l T t10) {
        l0.p(t10, y0.a.f8215h);
        if (this.f19793c == null) {
            int i10 = this.f19792b;
            if (i10 > 0) {
                t10 = this.f19791a.a(l0.C(e0.e2("[", i10), this.f19791a.d(t10)));
            }
            this.f19793c = t10;
        }
    }

    public void e(@os.l dp.f fVar, @os.l T t10) {
        l0.p(fVar, "name");
        l0.p(t10, y0.a.f8215h);
        d(t10);
    }
}
