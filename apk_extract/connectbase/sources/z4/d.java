package z4;

import com.google.gson.annotations.SerializedName;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class d<T> {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final T data;

    public d(T t10, int i10) {
        this.data = t10;
        this.code = i10;
    }

    public static d d(d dVar, Object obj, int i10, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = dVar.data;
        }
        if ((i11 & 2) != 0) {
            i10 = dVar.code;
        }
        dVar.getClass();
        return new d(obj, i10);
    }

    public final T a() {
        return this.data;
    }

    public final int b() {
        return this.code;
    }

    @os.l
    public final d<T> c(T t10, int i10) {
        return new d<>(t10, i10);
    }

    public final int e() {
        return this.code;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return l0.g(this.data, dVar.data) && this.code == dVar.code;
    }

    public final T f() {
        return this.data;
    }

    public int hashCode() {
        T t10 = this.data;
        return Integer.hashCode(this.code) + ((t10 == null ? 0 : t10.hashCode()) * 31);
    }

    @os.l
    public String toString() {
        return "ExtendMirrorMsg(data=" + this.data + ", code=" + this.code + ")";
    }
}
