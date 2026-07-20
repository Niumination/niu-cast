package jp;

import eo.h0;
import kn.l0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f8774a;

    public g(T t10) {
        this.f8774a = t10;
    }

    @os.l
    public abstract f0 a(@os.l h0 h0Var);

    public T b() {
        return this.f8774a;
    }

    public boolean equals(@os.m Object obj) {
        if (this != obj) {
            T tB = b();
            g gVar = obj instanceof g ? (g) obj : null;
            if (!l0.g(tB, gVar != null ? gVar.b() : null)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        T tB = b();
        if (tB == null) {
            return 0;
        }
        return tB.hashCode();
    }

    @os.l
    public String toString() {
        return String.valueOf(b());
    }
}
