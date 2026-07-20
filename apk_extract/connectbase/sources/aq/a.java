package aq;

import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f676b;

    public a(T t10, T t11) {
        this.f675a = t10;
        this.f676b = t11;
    }

    public final T a() {
        return this.f675a;
    }

    public final T b() {
        return this.f676b;
    }

    public final T c() {
        return this.f675a;
    }

    public final T d() {
        return this.f676b;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return l0.g(this.f675a, aVar.f675a) && l0.g(this.f676b, aVar.f676b);
    }

    public int hashCode() {
        T t10 = this.f675a;
        int iHashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        T t11 = this.f676b;
        return iHashCode + (t11 != null ? t11.hashCode() : 0);
    }

    @l
    public String toString() {
        return "ApproximationBounds(lower=" + this.f675a + ", upper=" + this.f676b + ')';
    }
}
