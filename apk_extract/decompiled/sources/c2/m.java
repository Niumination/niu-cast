package c2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f1419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f1420d;
    public final String e;
    public final ArrayList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f1421g;

    public m(long j8, long j10, j jVar, Integer num, String str, ArrayList arrayList, x xVar) {
        this.f1417a = j8;
        this.f1418b = j10;
        this.f1419c = jVar;
        this.f1420d = num;
        this.e = str;
        this.f = arrayList;
        this.f1421g = xVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        m mVar = (m) ((t) obj);
        if (this.f1417a == mVar.f1417a) {
            if (this.f1418b == mVar.f1418b) {
                if (this.f1419c.equals(mVar.f1419c)) {
                    Integer num = mVar.f1420d;
                    Integer num2 = this.f1420d;
                    if (num2 != null ? num2.equals(num) : num == null) {
                        String str = mVar.e;
                        String str2 = this.e;
                        if (str2 != null ? str2.equals(str) : str == null) {
                            if (this.f.equals(mVar.f)) {
                                x xVar = mVar.f1421g;
                                x xVar2 = this.f1421g;
                                if (xVar2 == null) {
                                    if (xVar == null) {
                                        return true;
                                    }
                                } else if (xVar2.equals(xVar)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j8 = this.f1417a;
        long j10 = this.f1418b;
        int iHashCode = (((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003) ^ this.f1419c.hashCode()) * 1000003;
        Integer num = this.f1420d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        int iHashCode3 = (((iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f.hashCode()) * 1000003;
        x xVar = this.f1421g;
        return iHashCode3 ^ (xVar != null ? xVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f1417a + ", requestUptimeMs=" + this.f1418b + ", clientInfo=" + this.f1419c + ", logSource=" + this.f1420d + ", logSourceName=" + this.e + ", logEvents=" + this.f + ", qosTier=" + this.f1421g + "}";
    }
}
