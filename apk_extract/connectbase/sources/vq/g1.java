package vq;

import nq.n3;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public final um.g f17844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Object[] f17845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final n3<Object>[] f17846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17847d;

    public g1(@os.l um.g gVar, int i10) {
        this.f17844a = gVar;
        this.f17845b = new Object[i10];
        this.f17846c = new n3[i10];
    }

    public final void a(@os.l n3<?> n3Var, @os.m Object obj) {
        Object[] objArr = this.f17845b;
        int i10 = this.f17847d;
        objArr[i10] = obj;
        n3<Object>[] n3VarArr = this.f17846c;
        this.f17847d = i10 + 1;
        kn.l0.n(n3Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        n3VarArr[i10] = n3Var;
    }

    public final void b(@os.l um.g gVar) {
        int length = this.f17846c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            n3<Object> n3Var = this.f17846c[length];
            kn.l0.m(n3Var);
            n3Var.D1(gVar, this.f17845b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
