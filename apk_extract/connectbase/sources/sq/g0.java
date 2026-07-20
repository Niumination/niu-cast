package sq;

import java.util.List;
import nq.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class g0<T> implements j0<T>, c<T>, tq.r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final l2 f15276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0<T> f15277b;

    /* JADX WARN: Multi-variable type inference failed */
    public g0(@os.l j0<? extends T> j0Var, @os.m l2 l2Var) {
        this.f15276a = l2Var;
        this.f15277b = j0Var;
    }

    @Override // sq.j0, sq.i
    @os.m
    public Object a(@os.l j<? super T> jVar, @os.l um.d<?> dVar) {
        return this.f15277b.a(jVar, dVar);
    }

    @Override // tq.r
    @os.l
    public i<T> c(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return l0.e(this, gVar, i10, iVar);
    }

    @Override // sq.j0
    @os.l
    public List<T> e() {
        return this.f15277b.e();
    }
}
