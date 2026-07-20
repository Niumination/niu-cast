package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends f1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final eo.e1[] f17670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final c1[] f17671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17672e;

    public d0(@os.l eo.e1[] e1VarArr, @os.l c1[] c1VarArr, boolean z10) {
        kn.l0.p(e1VarArr, "parameters");
        kn.l0.p(c1VarArr, "arguments");
        this.f17670c = e1VarArr;
        this.f17671d = c1VarArr;
        this.f17672e = z10;
        int length = e1VarArr.length;
        int length2 = c1VarArr.length;
    }

    @Override // vp.f1
    public boolean b() {
        return this.f17672e;
    }

    @Override // vp.f1
    @os.m
    public c1 e(@os.l f0 f0Var) {
        kn.l0.p(f0Var, cb.b.c.f1408o);
        eo.h hVarD = f0Var.G0().d();
        eo.e1 e1Var = hVarD instanceof eo.e1 ? (eo.e1) hVarD : null;
        if (e1Var == null) {
            return null;
        }
        int iF = e1Var.f();
        eo.e1[] e1VarArr = this.f17670c;
        if (iF >= e1VarArr.length || !kn.l0.g(e1VarArr[iF].i(), e1Var.i())) {
            return null;
        }
        return this.f17671d[iF];
    }

    @Override // vp.f1
    public boolean f() {
        return this.f17671d.length == 0;
    }

    @os.l
    public final c1[] i() {
        return this.f17671d;
    }

    @os.l
    public final eo.e1[] j() {
        return this.f17670c;
    }

    public /* synthetic */ d0(eo.e1[] e1VarArr, c1[] c1VarArr, boolean z10, int i10, kn.w wVar) {
        this(e1VarArr, c1VarArr, (i10 & 4) != 0 ? false : z10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d0(@os.l List<? extends eo.e1> list, @os.l List<? extends c1> list2) {
        kn.l0.p(list, "parameters");
        kn.l0.p(list2, "argumentsList");
        Object[] array = list.toArray(new eo.e1[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        eo.e1[] e1VarArr = (eo.e1[]) array;
        Object[] array2 = list2.toArray(new c1[0]);
        if (array2 != null) {
            this(e1VarArr, (c1[]) array2, false, 4, null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
