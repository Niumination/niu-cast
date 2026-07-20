package sq;

import java.util.List;
import nq.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class h0<T> implements u0<T>, c<T>, tq.r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final l2 f15279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u0<T> f15280b;

    /* JADX WARN: Multi-variable type inference failed */
    public h0(@os.l u0<? extends T> u0Var, @os.m l2 l2Var) {
        this.f15279a = l2Var;
        this.f15280b = u0Var;
    }

    @Override // sq.j0, sq.i
    @os.m
    public Object a(@os.l j<? super T> jVar, @os.l um.d<?> dVar) {
        return this.f15280b.a(jVar, dVar);
    }

    @Override // tq.r
    @os.l
    public i<T> c(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return w0.d(this, gVar, i10, iVar);
    }

    @Override // sq.j0
    @os.l
    public List<T> e() {
        return this.f15280b.e();
    }

    @Override // sq.u0
    public T getValue() {
        return this.f15280b.getValue();
    }
}
