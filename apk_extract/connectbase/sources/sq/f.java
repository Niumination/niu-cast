package sq;

import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class f<T> extends tq.e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.p<pq.d0<? super T>, um.d<? super l2>, Object> f15269d;

    public /* synthetic */ f(jn.p pVar, um.g gVar, int i10, pq.i iVar, int i11, kn.w wVar) {
        this(pVar, (i11 & 2) != 0 ? um.i.INSTANCE : gVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? pq.i.SUSPEND : iVar);
    }

    public static <T> Object o(f<T> fVar, pq.d0<? super T> d0Var, um.d<? super l2> dVar) {
        Object objInvoke = fVar.f15269d.invoke(d0Var, dVar);
        return objInvoke == wm.a.COROUTINE_SUSPENDED ? objInvoke : l2.f10208a;
    }

    @Override // tq.e
    @os.m
    public Object i(@os.l pq.d0<? super T> d0Var, @os.l um.d<? super l2> dVar) {
        return o(this, d0Var, dVar);
    }

    @Override // tq.e
    @os.l
    public tq.e<T> j(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return new f(this.f15269d, gVar, i10, iVar);
    }

    @Override // tq.e
    @os.l
    public String toString() {
        return "block[" + this.f15269d + "] -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@os.l jn.p<? super pq.d0<? super T>, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.g gVar, int i10, @os.l pq.i iVar) {
        super(gVar, i10, iVar);
        this.f15269d = pVar;
    }
}
