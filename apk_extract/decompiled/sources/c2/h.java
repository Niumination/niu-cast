package c2;

/* JADX INFO: loaded from: classes.dex */
public final class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1397d;
    public final String e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f1401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f1403l;

    public h(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f1394a = num;
        this.f1395b = str;
        this.f1396c = str2;
        this.f1397d = str3;
        this.e = str4;
        this.f = str5;
        this.f1398g = str6;
        this.f1399h = str7;
        this.f1400i = str8;
        this.f1401j = str9;
        this.f1402k = str10;
        this.f1403l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        Integer num = this.f1394a;
        if (num != null ? num.equals(((h) aVar).f1394a) : ((h) aVar).f1394a == null) {
            String str = this.f1395b;
            if (str != null ? str.equals(((h) aVar).f1395b) : ((h) aVar).f1395b == null) {
                String str2 = this.f1396c;
                if (str2 != null ? str2.equals(((h) aVar).f1396c) : ((h) aVar).f1396c == null) {
                    String str3 = this.f1397d;
                    if (str3 != null ? str3.equals(((h) aVar).f1397d) : ((h) aVar).f1397d == null) {
                        String str4 = this.e;
                        if (str4 != null ? str4.equals(((h) aVar).e) : ((h) aVar).e == null) {
                            String str5 = this.f;
                            if (str5 != null ? str5.equals(((h) aVar).f) : ((h) aVar).f == null) {
                                String str6 = this.f1398g;
                                if (str6 != null ? str6.equals(((h) aVar).f1398g) : ((h) aVar).f1398g == null) {
                                    String str7 = this.f1399h;
                                    if (str7 != null ? str7.equals(((h) aVar).f1399h) : ((h) aVar).f1399h == null) {
                                        String str8 = this.f1400i;
                                        if (str8 != null ? str8.equals(((h) aVar).f1400i) : ((h) aVar).f1400i == null) {
                                            String str9 = this.f1401j;
                                            if (str9 != null ? str9.equals(((h) aVar).f1401j) : ((h) aVar).f1401j == null) {
                                                String str10 = this.f1402k;
                                                if (str10 != null ? str10.equals(((h) aVar).f1402k) : ((h) aVar).f1402k == null) {
                                                    String str11 = this.f1403l;
                                                    if (str11 == null) {
                                                        if (((h) aVar).f1403l == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(((h) aVar).f1403l)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
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
        Integer num = this.f1394a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f1395b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f1396c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f1397d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f1398g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f1399h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f1400i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f1401j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f1402k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f1403l;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb2.append(this.f1394a);
        sb2.append(", model=");
        sb2.append(this.f1395b);
        sb2.append(", hardware=");
        sb2.append(this.f1396c);
        sb2.append(", device=");
        sb2.append(this.f1397d);
        sb2.append(", product=");
        sb2.append(this.e);
        sb2.append(", osBuild=");
        sb2.append(this.f);
        sb2.append(", manufacturer=");
        sb2.append(this.f1398g);
        sb2.append(", fingerprint=");
        sb2.append(this.f1399h);
        sb2.append(", locale=");
        sb2.append(this.f1400i);
        sb2.append(", country=");
        sb2.append(this.f1401j);
        sb2.append(", mccMnc=");
        sb2.append(this.f1402k);
        sb2.append(", applicationBuild=");
        return h0.a.n(sb2, this.f1403l, "}");
    }
}
