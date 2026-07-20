package tj;

import tj.d;

/* JADX INFO: loaded from: classes2.dex */
public final class w0<V extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f15744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f15745b;

    public w0(u0 u0Var, V v10) {
        this.f15744a = u0Var;
        this.f15745b = v10;
    }

    public static <V extends d> w0<V> c(u0 u0Var, V v10) {
        return new w0<>(u0Var, v10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w0<c> a() {
        if (this.f15745b instanceof c) {
            return this;
        }
        throw new sj.c.d("Expecting a resolve result to be an object, but it was " + this.f15745b);
    }

    public w0<d> b() {
        return this;
    }

    public w0<V> d() {
        return new w0<>(this.f15744a.g(), this.f15745b);
    }

    public String toString() {
        return "ResolveResult(" + this.f15745b + ")";
    }
}
