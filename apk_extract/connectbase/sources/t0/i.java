package t0;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i implements m<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f15417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f15418b;

    public i(b bVar, b bVar2) {
        this.f15417a = bVar;
        this.f15418b = bVar2;
    }

    @Override // t0.m
    public boolean k() {
        return this.f15417a.k() && this.f15418b.k();
    }

    @Override // t0.m
    public q0.a<PointF, PointF> l() {
        return new q0.m(this.f15417a.l(), this.f15418b.l());
    }

    @Override // t0.m
    public List<a1.a<PointF>> m() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
}
