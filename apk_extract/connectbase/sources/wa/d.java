package wa;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f18239i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f18240j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f18241k = "private";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f18242l = "android.os.storage.extra.VOLUME_ID";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f18243m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f18244n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f18245o = 5;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f18246p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Comparator<d> f18247q = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f18249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f18252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wa.a f18254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18255h;

    public class a implements Comparator<d> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            if ("private".equals(dVar.e())) {
                return -1;
            }
            if (dVar.a() == null) {
                return 1;
            }
            if (dVar2.a() == null) {
                return -1;
            }
            return dVar.a().compareTo(dVar2.a());
        }
    }

    public d(String str, int i10, String str2, String str3) {
        this.f18255h = 0;
        this.f18251d = str;
        this.f18248a = i10;
        this.f18249b = str2;
        this.f18252e = str3;
    }

    public static Comparator<d> b() {
        return f18247q;
    }

    public String a() {
        return this.f18253f;
    }

    public wa.a c() {
        return this.f18254g;
    }

    public String d() {
        return this.f18249b;
    }

    public String e() {
        return this.f18251d;
    }

    public int f() {
        return this.f18255h;
    }

    public File g() {
        if (this.f18252e != null) {
            return new File(this.f18252e);
        }
        return null;
    }

    public int h() {
        return this.f18250c;
    }

    public int i() {
        return this.f18248a;
    }

    public boolean j() {
        int i10 = this.f18250c;
        return i10 == 2 || i10 == 3;
    }

    public boolean k() {
        return (this.f18255h & 1) != 0;
    }

    public void l(String str) {
        this.f18253f = str;
    }

    public void m(wa.a aVar) {
        this.f18254g = aVar;
    }

    public void n(String str) {
        this.f18249b = str;
    }

    public void o(int i10) {
        this.f18255h = i10;
    }

    public void p(int i10) {
        this.f18250c = i10;
    }

    public void q(int i10) {
        this.f18248a = i10;
    }

    public d(String str, int i10, int i11) {
        this.f18251d = str;
        this.f18248a = i10;
        this.f18255h = i11;
    }
}
