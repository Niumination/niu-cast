package sq;

import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class i0<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.p<j<? super T>, um.d<? super l2>, Object> f15281a;

    /* JADX WARN: Multi-variable type inference failed */
    public i0(@os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        this.f15281a = pVar;
    }

    @Override // sq.a
    @os.m
    public Object g(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) {
        Object objInvoke = this.f15281a.invoke(jVar, dVar);
        return objInvoke == wm.a.COROUTINE_SUSPENDED ? objInvoke : l2.f10208a;
    }
}
