package ik;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final c f7981f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final i f7982g = new i("*", "*", null, 4, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final String f7983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final String f7984e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f7985a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final i f7986b = new i(n1.i.f11236l, "*", null, 4, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final i f7987c = new i(n1.i.f11236l, "atom+xml", null, 4, null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final i f7988d = new i(n1.i.f11236l, "cbor", null, 4, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final i f7989e = new i(n1.i.f11236l, "json", null, 4, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public static final i f7990f = new i(n1.i.f11236l, "hal+json", null, 4, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final i f7991g = new i(n1.i.f11236l, "javascript", null, 4, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public static final i f7992h = new i(n1.i.f11236l, "octet-stream", null, 4, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public static final i f7993i = new i(n1.i.f11236l, "font-woff", null, 4, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.l
        public static final i f7994j = new i(n1.i.f11236l, "rss+xml", null, 4, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @os.l
        public static final i f7995k = new i(n1.i.f11236l, dc.d.f3688s, null, 4, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @os.l
        public static final i f7996l = new i(n1.i.f11236l, "xml-dtd", null, 4, null);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @os.l
        public static final i f7997m = new i(n1.i.f11236l, "zip", null, 4, null);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @os.l
        public static final i f7998n = new i(n1.i.f11236l, "gzip", null, 4, null);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @os.l
        public static final i f7999o = new i(n1.i.f11236l, "x-www-form-urlencoded", null, 4, null);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @os.l
        public static final i f8000p = new i(n1.i.f11236l, "pdf", null, 4, null);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @os.l
        public static final i f8001q = new i(n1.i.f11236l, "protobuf", null, 4, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @os.l
        public static final i f8002r = new i(n1.i.f11236l, "wasm", null, 4, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @os.l
        public static final i f8003s = new i(n1.i.f11236l, "problem+json", null, 4, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @os.l
        public static final i f8004t = new i(n1.i.f11236l, "problem+xml", null, 4, null);

        @os.l
        public final i a() {
            return f7986b;
        }

        @os.l
        public final i b() {
            return f7987c;
        }

        @os.l
        public final i c() {
            return f7988d;
        }

        @os.l
        public final i d() {
            return f7993i;
        }

        @os.l
        public final i e() {
            return f7999o;
        }

        @os.l
        public final i f() {
            return f7998n;
        }

        @os.l
        public final i g() {
            return f7990f;
        }

        @os.l
        public final i h() {
            return f7991g;
        }

        @os.l
        public final i i() {
            return f7989e;
        }

        @os.l
        public final i j() {
            return f7992h;
        }

        @os.l
        public final i k() {
            return f8000p;
        }

        @os.l
        public final i l() {
            return f8003s;
        }

        @os.l
        public final i m() {
            return f8004t;
        }

        @os.l
        public final i n() {
            return f8001q;
        }

        @os.l
        public final i o() {
            return f7994j;
        }

        @os.l
        public final i p() {
            return f8002r;
        }

        @os.l
        public final i q() {
            return f7995k;
        }

        @os.l
        public final i r() {
            return f7996l;
        }

        @os.l
        public final i s() {
            return f7997m;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final b f8005a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final i f8006b = new i("audio", "*", null, 4, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final i f8007c = new i("audio", "mp4", null, 4, null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final i f8008d = new i("audio", "mpeg", null, 4, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final i f8009e = new i("audio", "ogg", null, 4, null);

        @os.l
        public final i a() {
            return f8006b;
        }

        @os.l
        public final i b() {
            return f8007c;
        }

        @os.l
        public final i c() {
            return f8008d;
        }

        @os.l
        public final i d() {
            return f8009e;
        }
    }

    public static final class c {
        public c() {
        }

        @os.l
        public final i a() {
            return i.f7982g;
        }

        @os.l
        public final i b(@os.l String str) {
            kn.l0.p(str, "value");
            if (jq.e0.S1(str)) {
                return i.f7982g;
            }
            z.a aVar = z.f8234c;
            x xVar = (x) nm.h0.h5(i0.e(str, false));
            String str2 = xVar.f8200a;
            List<y> list = xVar.f8201b;
            int iO3 = jq.h0.o3(str2, el.b0.f4502a, 0, false, 6, null);
            if (iO3 == -1) {
                if (!kn.l0.g(jq.h0.C5(str2).toString(), "*")) {
                    throw new ik.c(str);
                }
                i.f7981f.getClass();
                return i.f7982g;
            }
            String strSubstring = str2.substring(0, iO3);
            kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String string = jq.h0.C5(strSubstring).toString();
            if (string.length() == 0) {
                throw new ik.c(str);
            }
            String strSubstring2 = str2.substring(iO3 + 1);
            kn.l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
            String string2 = jq.h0.C5(strSubstring2).toString();
            if (jq.h0.S2(string, ' ', false, 2, null) || jq.h0.S2(string2, ' ', false, 2, null)) {
                throw new ik.c(str);
            }
            if (string2.length() == 0 || jq.h0.S2(string2, el.b0.f4502a, false, 2, null)) {
                throw new ik.c(str);
            }
            return new i(string, string2, list);
        }

        public c(kn.w wVar) {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final d f8010a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final i f8011b = new i("image", "*", null, 4, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final i f8012c = new i("image", "gif", null, 4, null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final i f8013d = new i("image", "jpeg", null, 4, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final i f8014e = new i("image", "png", null, 4, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public static final i f8015f = new i("image", "svg+xml", null, 4, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final i f8016g = new i("image", "x-icon", null, 4, null);

        @os.l
        public final i a() {
            return f8011b;
        }

        @os.l
        public final i b() {
            return f8012c;
        }

        @os.l
        public final i c() {
            return f8013d;
        }

        @os.l
        public final i d() {
            return f8014e;
        }

        @os.l
        public final i e() {
            return f8015f;
        }

        @os.l
        public final i f() {
            return f8016g;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final e f8017a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final i f8018b = new i("message", "*", null, 4, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final i f8019c = new i("message", "http", null, 4, null);

        @os.l
        public final i a() {
            return f8018b;
        }

        @os.l
        public final i b() {
            return f8019c;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final f f8020a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final i f8021b = new i("multipart", "*", null, 4, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final i f8022c = new i("multipart", "mixed", null, 4, null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final i f8023d = new i("multipart", "alternative", null, 4, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final i f8024e = new i("multipart", "related", null, 4, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public static final i f8025f = new i("multipart", "form-data", null, 4, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final i f8026g = new i("multipart", "signed", null, 4, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public static final i f8027h = new i("multipart", "encrypted", null, 4, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public static final i f8028i = new i("multipart", "byteranges", null, 4, null);

        @os.l
        public final i a() {
            return f8023d;
        }

        @os.l
        public final i b() {
            return f8021b;
        }

        @os.l
        public final i c() {
            return f8028i;
        }

        @os.l
        public final i d() {
            return f8027h;
        }

        @os.l
        public final i e() {
            return f8025f;
        }

        @os.l
        public final i f() {
            return f8022c;
        }

        @os.l
        public final i g() {
            return f8024e;
        }

        @os.l
        public final i h() {
            return f8026g;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final g f8029a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final i f8030b = new i("text", "*", null, 4, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final i f8031c = new i("text", "plain", null, 4, null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final i f8032d = new i("text", "css", null, 4, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final i f8033e = new i("text", "csv", null, 4, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public static final i f8034f = new i("text", "html", null, 4, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public static final i f8035g = new i("text", "javascript", null, 4, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public static final i f8036h = new i("text", "vcard", null, 4, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public static final i f8037i = new i("text", dc.d.f3688s, null, 4, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.l
        public static final i f8038j = new i("text", "event-stream", null, 4, null);

        @os.l
        public final i a() {
            return f8030b;
        }

        @os.l
        public final i b() {
            return f8032d;
        }

        @os.l
        public final i c() {
            return f8033e;
        }

        @os.l
        public final i d() {
            return f8038j;
        }

        @os.l
        public final i e() {
            return f8034f;
        }

        @os.l
        public final i f() {
            return f8035g;
        }

        @os.l
        public final i g() {
            return f8031c;
        }

        @os.l
        public final i h() {
            return f8036h;
        }

        @os.l
        public final i i() {
            return f8037i;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final h f8039a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final i f8040b = new i("video", "*", null, 4, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final i f8041c = new i("video", "mpeg", null, 4, null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public static final i f8042d = new i("video", "mp4", null, 4, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public static final i f8043e = new i("video", "ogg", null, 4, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public static final i f8044f = new i("video", "quicktime", null, 4, null);

        @os.l
        public final i a() {
            return f8040b;
        }

        @os.l
        public final i b() {
            return f8042d;
        }

        @os.l
        public final i c() {
            return f8041c;
        }

        @os.l
        public final i d() {
            return f8043e;
        }

        @os.l
        public final i e() {
            return f8044f;
        }
    }

    public i(String str, String str2, String str3, List<y> list) {
        super(str3, list);
        this.f7983d = str;
        this.f7984e = str2;
    }

    @os.l
    public final String e() {
        return this.f7984e;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (jq.e0.K1(this.f7983d, iVar.f7983d, true) && jq.e0.K1(this.f7984e, iVar.f7984e, true) && kn.l0.g(this.f8236b, iVar.f8236b)) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public final String f() {
        return this.f7983d;
    }

    public final boolean g(String str, String str2) {
        int size = this.f8236b.size();
        if (size == 0) {
            return false;
        }
        if (size != 1) {
            List<y> list = this.f8236b;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            for (y yVar : list) {
                if (!jq.e0.K1(yVar.f8206a, str, true) || !jq.e0.K1(yVar.f8207b, str2, true)) {
                }
            }
            return false;
        }
        y yVar2 = this.f8236b.get(0);
        if (!jq.e0.K1(yVar2.f8206a, str, true) || !jq.e0.K1(yVar2.f8207b, str2, true)) {
            return false;
        }
        return true;
    }

    public final boolean h(@os.l i iVar) {
        boolean zK1;
        kn.l0.p(iVar, "pattern");
        if (!kn.l0.g(iVar.f7983d, "*") && !jq.e0.K1(iVar.f7983d, this.f7983d, true)) {
            return false;
        }
        if (!kn.l0.g(iVar.f7984e, "*") && !jq.e0.K1(iVar.f7984e, this.f7984e, true)) {
            return false;
        }
        for (y yVar : iVar.f8236b) {
            String str = yVar.f8206a;
            String str2 = yVar.f8207b;
            if (!kn.l0.g(str, "*")) {
                String strC = c(str);
                zK1 = kn.l0.g(str2, "*") ? strC != null : jq.e0.K1(strC, str2, true);
            } else if (!kn.l0.g(str2, "*")) {
                List<y> list = this.f8236b;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (jq.e0.K1(((y) it.next()).f8207b, str2, true)) {
                            }
                        }
                    }
                }
            }
            if (!zK1) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String lowerCase = this.f7983d.toLowerCase();
        kn.l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.f7984e.toLowerCase();
        kn.l0.o(lowerCase2, "this as java.lang.String).toLowerCase()");
        int iHashCode2 = lowerCase2.hashCode();
        return (this.f8236b.hashCode() * 31) + iHashCode2 + (iHashCode * 31) + iHashCode;
    }

    public final boolean i(@os.l String str) {
        kn.l0.p(str, "pattern");
        return h(f7981f.b(str));
    }

    @os.l
    public final i j(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        return g(str, str2) ? this : new i(this.f7983d, this.f7984e, this.f8235a, nm.h0.F4(this.f8236b, new y(str, str2)));
    }

    @os.l
    public final i k() {
        return this.f8236b.isEmpty() ? this : new i(this.f7983d, this.f7984e, null, 4, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(@os.l String str, @os.l String str2, @os.l List<y> list) {
        this(str, str2, str + el.b0.f4502a + str2, list);
        kn.l0.p(str, "contentType");
        kn.l0.p(str2, "contentSubtype");
        kn.l0.p(list, "parameters");
    }

    public i(String str, String str2, String str3, List list, int i10, kn.w wVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? nm.k0.INSTANCE : list);
    }

    public i(String str, String str2, List list, int i10, kn.w wVar) {
        this(str, str2, (i10 & 4) != 0 ? nm.k0.INSTANCE : list);
    }
}
