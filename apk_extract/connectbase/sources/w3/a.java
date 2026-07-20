package w3;

import java.util.List;
import n2.k0;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<C0466a> f17906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f17907d;

    /* JADX INFO: renamed from: w3.a$a, reason: collision with other inner class name */
    public static class C0466a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f17910c;

        public C0466a(int i10, int i11, long j10) {
            this.f17908a = i10;
            this.f17909b = i11;
            this.f17910c = j10;
        }

        public String a() {
            return this.f17909b + "-" + this.f17910c;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{appId=");
            sb2.append(this.f17908a);
            sb2.append(", type=");
            sb2.append(this.f17909b);
            sb2.append(", version=");
            return k0.a(sb2, this.f17910c, rs.f.f14860b);
        }
    }

    public a() {
    }

    public a(String str) {
        this.f17907d = str;
    }
}
