package ik;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 extends z {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f8208a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final String f8209b = "rel";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final String f8210c = "anchor";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final String f8211d = "Rev";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final String f8212e = "hreflang";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public static final String f8213f = "media";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final String f8214g = "title";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public static final String f8215h = "type";
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final b f8216a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final String f8217b = "stylesheet";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final String f8218c = "prefetch";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final String f8219d = "dns-prefetch";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final String f8220e = "preconnect";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public static final String f8221f = "preload";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final String f8222g = "prerender";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public static final String f8223h = "next";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(@os.l String str, @os.l List<y> list) {
        super(l.a.a(new StringBuilder("<"), str, jq.m0.f8868f), list);
        kn.l0.p(str, "uri");
        kn.l0.p(list, "params");
    }

    @os.l
    public final String d() {
        return jq.h0.g4(jq.h0.a4(this.f8235a, "<"), ">");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y0(@os.l String str, @os.l String str2) {
        this(str, (List<y>) nm.x.k(new y(a.f8209b, str2)));
        kn.l0.p(str, "uri");
        kn.l0.p(str2, a.f8209b);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y0(@os.l String str, @os.l String... strArr) {
        this(str, (List<y>) nm.x.k(new y(a.f8209b, nm.r.lh(strArr, " ", null, null, 0, null, null, 62, null))));
        kn.l0.p(str, "uri");
        kn.l0.p(strArr, a.f8209b);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y0(@os.l String str, @os.l List<String> list, @os.l i iVar) {
        this(str, (List<y>) nm.y.O(new y(a.f8209b, nm.h0.m3(list, " ", null, null, 0, null, null, 62, null)), new y(a.f8215h, iVar.toString())));
        kn.l0.p(str, "uri");
        kn.l0.p(list, a.f8209b);
        kn.l0.p(iVar, a.f8215h);
    }
}
