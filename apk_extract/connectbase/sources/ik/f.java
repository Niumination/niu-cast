package ik;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f7961d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final f f7962e = new f("file", null, 2, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final f f7963f = new f("mixed", null, 2, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final f f7964g = new f("attachment", null, 2, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final f f7965h = new f("inline", null, 2, null);

    public static final class a {
        public a() {
        }

        @os.l
        public final f a() {
            return f.f7964g;
        }

        @os.l
        public final f b() {
            return f.f7962e;
        }

        @os.l
        public final f c() {
            return f.f7965h;
        }

        @os.l
        public final f d() {
            return f.f7963f;
        }

        @os.l
        public final f e(@os.l String str) {
            kn.l0.p(str, "value");
            z.a aVar = z.f8234c;
            x xVar = (x) nm.h0.h5(i0.e(str, false));
            return new f(xVar.f8200a, xVar.f8201b);
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final b f7966a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final String f7967b = "filename";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final String f7968c = "filename*";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final String f7969d = "name";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final String f7970e = "creation-date";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public static final String f7971f = "modification-date";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final String f7972g = "read-date";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public static final String f7973h = "size";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public static final String f7974i = "handling";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@os.l String str, @os.l List<y> list) {
        super(str, list);
        kn.l0.p(str, "disposition");
        kn.l0.p(list, "parameters");
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (kn.l0.g(this.f8235a, fVar.f8235a) && kn.l0.g(this.f8236b, fVar.f8236b)) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public final String h() {
        return this.f8235a;
    }

    public int hashCode() {
        return this.f8236b.hashCode() + (this.f8235a.hashCode() * 31);
    }

    @os.m
    public final String i() {
        return c("name");
    }

    @os.l
    public final f j(@os.l String str, @os.l String str2) {
        kn.l0.p(str, cb.b.c.f1408o);
        kn.l0.p(str2, "value");
        return new f(this.f8235a, nm.h0.F4(this.f8236b, new y(str, str2)));
    }

    @os.l
    public final f k(@os.l List<y> list) {
        kn.l0.p(list, "newParameters");
        return new f(this.f8235a, nm.h0.E4(this.f8236b, list));
    }

    public f(String str, List list, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? nm.k0.INSTANCE : list);
    }
}
