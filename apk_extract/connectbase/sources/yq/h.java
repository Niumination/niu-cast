package yq;

import kn.w;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class h<Q> implements g<Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Object f21709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.q<Object, m<?>, Object, l2> f21710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.q<Object, Object, Object, Object> f21711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final jn.q<m<?>, Object, Object, jn.l<Throwable, l2>> f21712d;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@os.l Object obj, @os.l jn.q<Object, ? super m<?>, Object, l2> qVar, @os.l jn.q<Object, Object, Object, ? extends Object> qVar2, @os.m jn.q<? super m<?>, Object, Object, ? extends jn.l<? super Throwable, l2>> qVar3) {
        this.f21709a = obj;
        this.f21710b = qVar;
        this.f21711c = qVar2;
        this.f21712d = qVar3;
    }

    @Override // yq.k
    @os.l
    public jn.q<Object, m<?>, Object, l2> a() {
        return this.f21710b;
    }

    @Override // yq.k
    @os.m
    public jn.q<m<?>, Object, Object, jn.l<Throwable, l2>> b() {
        return this.f21712d;
    }

    @Override // yq.k
    @os.l
    public jn.q<Object, Object, Object, Object> c() {
        return this.f21711c;
    }

    @Override // yq.k
    @os.l
    public Object d() {
        return this.f21709a;
    }

    public /* synthetic */ h(Object obj, jn.q qVar, jn.q qVar2, jn.q qVar3, int i10, w wVar) {
        this(obj, qVar, qVar2, (i10 & 8) != 0 ? null : qVar3);
    }
}
