package z4;

import com.google.gson.annotations.SerializedName;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    @SerializedName("data")
    @os.m
    private final c data;

    @SerializedName("code")
    @os.l
    private final String funcType;

    public i(@os.m c cVar, @os.l String str) {
        l0.p(str, "funcType");
        this.data = cVar;
        this.funcType = str;
    }

    public static /* synthetic */ i d(i iVar, c cVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cVar = iVar.data;
        }
        if ((i10 & 2) != 0) {
            str = iVar.funcType;
        }
        return iVar.c(cVar, str);
    }

    @os.m
    public final c a() {
        return this.data;
    }

    @os.l
    public final String b() {
        return this.funcType;
    }

    @os.l
    public final i c(@os.m c cVar, @os.l String str) {
        l0.p(str, "funcType");
        return new i(cVar, str);
    }

    @os.m
    public final c e() {
        return this.data;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return l0.g(this.data, iVar.data) && l0.g(this.funcType, iVar.funcType);
    }

    @os.l
    public final String f() {
        return this.funcType;
    }

    public int hashCode() {
        c cVar = this.data;
        return this.funcType.hashCode() + ((cVar == null ? 0 : cVar.hashCode()) * 31);
    }

    @os.l
    public String toString() {
        return "PadMsg(data=" + this.data + ", funcType=" + this.funcType + ")";
    }
}
