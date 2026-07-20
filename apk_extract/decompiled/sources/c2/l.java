package c2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class l extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f1413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f1415d;
    public final String e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f1416g;

    public l(long j8, Integer num, long j10, byte[] bArr, String str, long j11, o oVar) {
        this.f1412a = j8;
        this.f1413b = num;
        this.f1414c = j10;
        this.f1415d = bArr;
        this.e = str;
        this.f = j11;
        this.f1416g = oVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        l lVar = (l) sVar;
        if (this.f1412a == lVar.f1412a && ((num = this.f1413b) != null ? num.equals(lVar.f1413b) : lVar.f1413b == null)) {
            if (this.f1414c == lVar.f1414c) {
                if (Arrays.equals(this.f1415d, sVar instanceof l ? ((l) sVar).f1415d : lVar.f1415d)) {
                    String str = lVar.e;
                    String str2 = this.e;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        if (this.f == lVar.f) {
                            o oVar = lVar.f1416g;
                            o oVar2 = this.f1416g;
                            if (oVar2 == null) {
                                if (oVar == null) {
                                    return true;
                                }
                            } else if (oVar2.equals(oVar)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j8 = this.f1412a;
        int i8 = (((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f1413b;
        int iHashCode = (i8 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j10 = this.f1414c;
        int iHashCode2 = (((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f1415d)) * 1000003;
        String str = this.e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j11 = this.f;
        int i9 = (iHashCode3 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        o oVar = this.f1416g;
        return i9 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f1412a + ", eventCode=" + this.f1413b + ", eventUptimeMs=" + this.f1414c + ", sourceExtension=" + Arrays.toString(this.f1415d) + ", sourceExtensionJsonProto3=" + this.e + ", timezoneOffsetSeconds=" + this.f + ", networkConnectionInfo=" + this.f1416g + "}";
    }
}
