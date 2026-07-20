package yq;

import kn.w;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Object f21705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.q<Object, m<?>, Object, l2> f21706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final jn.q<m<?>, Object, Object, jn.l<Throwable, l2>> f21707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.q<Object, Object, Object, Object> f21708d;

    /* JADX WARN: Multi-variable type inference failed */
    public f(@os.l Object obj, @os.l jn.q<Object, ? super m<?>, Object, l2> qVar, @os.m jn.q<? super m<?>, Object, Object, ? extends jn.l<? super Throwable, l2>> qVar2) {
        this.f21705a = obj;
        this.f21706b = qVar;
        this.f21707c = qVar2;
        this.f21708d = o.f21732a;
    }

    @Override // yq.k
    @os.l
    public jn.q<Object, m<?>, Object, l2> a() {
        return this.f21706b;
    }

    @Override // yq.k
    @os.m
    public jn.q<m<?>, Object, Object, jn.l<Throwable, l2>> b() {
        return this.f21707c;
    }

    @Override // yq.k
    @os.l
    public jn.q<Object, Object, Object, Object> c() {
        return this.f21708d;
    }

    @Override // yq.k
    @os.l
    public Object d() {
        return this.f21705a;
    }

    public /* synthetic */ f(Object obj, jn.q qVar, jn.q qVar2, int i10, w wVar) {
        this(obj, qVar, (i10 & 4) != 0 ? null : qVar2);
    }
}
