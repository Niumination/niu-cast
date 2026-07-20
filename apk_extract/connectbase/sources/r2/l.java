package r2;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class l<T> extends o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final T f14192g;

    public l(T t10) {
        super(0, 0L, 3, null);
        this.f14192g = t10;
    }

    public static l j(l lVar, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = lVar.f14192g;
        }
        lVar.getClass();
        return new l(obj);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && l0.g(this.f14192g, ((l) obj).f14192g);
    }

    public final T h() {
        return this.f14192g;
    }

    public int hashCode() {
        T t10 = this.f14192g;
        if (t10 == null) {
            return 0;
        }
        return t10.hashCode();
    }

    @os.l
    public final l<T> i(T t10) {
        return new l<>(t10);
    }

    public final T k() {
        return this.f14192g;
    }

    @os.l
    public String toString() {
        return "GrpcMessage(data=" + this.f14192g + ')';
    }
}
