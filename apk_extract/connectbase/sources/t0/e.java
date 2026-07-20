package t0;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements m<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a1.a<PointF>> f15416a;

    public e() {
        this.f15416a = Collections.singletonList(new a1.a(new PointF(0.0f, 0.0f)));
    }

    @Override // t0.m
    public boolean k() {
        return this.f15416a.size() == 1 && this.f15416a.get(0).h();
    }

    @Override // t0.m
    public q0.a<PointF, PointF> l() {
        return this.f15416a.get(0).h() ? new q0.j(this.f15416a) : new q0.i(this.f15416a);
    }

    @Override // t0.m
    public List<a1.a<PointF>> m() {
        return this.f15416a;
    }

    public e(List<a1.a<PointF>> list) {
        this.f15416a = list;
    }
}
