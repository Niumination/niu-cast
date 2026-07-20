package lq;

import kn.l0;
import kn.w;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.9")
@p2(markerClass = {l.class})
public final class t<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f10269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10270b;

    public /* synthetic */ t(Object obj, long j10, w wVar) {
        this(obj, j10);
    }

    public static t d(t tVar, Object obj, long j10, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = tVar.f10269a;
        }
        if ((i10 & 2) != 0) {
            j10 = tVar.f10270b;
        }
        tVar.getClass();
        return new t(obj, j10);
    }

    public final T a() {
        return this.f10269a;
    }

    public final long b() {
        return this.f10270b;
    }

    @os.l
    public final t<T> c(T t10, long j10) {
        return new t<>(t10, j10);
    }

    public final long e() {
        return this.f10270b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return l0.g(this.f10269a, tVar.f10269a) && e.s(this.f10270b, tVar.f10270b);
    }

    public final T f() {
        return this.f10269a;
    }

    public int hashCode() {
        T t10 = this.f10269a;
        return e.a0(this.f10270b) + ((t10 == null ? 0 : t10.hashCode()) * 31);
    }

    @os.l
    public String toString() {
        return "TimedValue(value=" + this.f10269a + ", duration=" + ((Object) e.v0(this.f10270b)) + ')';
    }

    public t(T t10, long j10) {
        this.f10269a = t10;
        this.f10270b = j10;
    }
}
