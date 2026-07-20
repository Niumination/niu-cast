package jk;

import fl.a0;
import fl.h;
import fl.p0;
import ik.e;
import ik.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jq.e0;
import kn.l0;
import kn.n0;
import kn.w;
import lm.i0;
import nm.h0;
import nm.k0;
import nm.z;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f8719b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final String f8720a;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static b c(a aVar, String str, String str2, List list, String str3, Boolean bool, String str4, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = a0.c();
            }
            String str5 = str2;
            if ((i10 & 4) != 0) {
                list = k0.INSTANCE;
            }
            List list2 = list;
            String str6 = (i10 & 8) != 0 ? null : str3;
            Boolean bool2 = (i10 & 16) != 0 ? null : bool;
            if ((i10 & 32) != 0) {
                str4 = "MD5";
            }
            return aVar.b(str, str5, list2, str6, bool2, str4);
        }

        @l
        public final b a(@l String str, @m Charset charset) {
            l0.p(str, C0226c.f8725b);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(C0226c.f8725b, str);
            if (charset != null) {
                linkedHashMap.put("charset", rl.a.p(charset));
            }
            return new b(jk.a.f8713b, linkedHashMap, (jk.b) null, 4, (w) null);
        }

        @l
        public final b b(@l String str, @l String str2, @l List<String> list, @m String str3, @m Boolean bool, @l String str4) {
            l0.p(str, C0226c.f8725b);
            l0.p(str2, "nonce");
            l0.p(list, "domain");
            l0.p(str4, "algorithm");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(C0226c.f8725b, str);
            linkedHashMap.put("nonce", str2);
            if (!list.isEmpty()) {
                linkedHashMap.put("domain", h0.m3(list, " ", null, null, 0, null, null, 62, null));
            }
            if (str3 != null) {
                linkedHashMap.put("opaque", str3);
            }
            if (bool != null) {
                linkedHashMap.put("stale", bool.toString());
            }
            linkedHashMap.put("algorithm", str4);
            return new b(jk.a.f8714c, linkedHashMap, jk.b.QUOTED_ALWAYS);
        }

        public a(w wVar) {
        }
    }

    /* JADX INFO: renamed from: jk.c$c, reason: collision with other inner class name */
    public static final class C0226c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final C0226c f8724a = new C0226c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public static final String f8725b = "realm";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public static final String f8726c = "charset";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @l
        public static final String f8727d = "oauth_callback";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @l
        public static final String f8728e = "oauth_consumer_key";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @l
        public static final String f8729f = "oauth_nonce";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @l
        public static final String f8730g = "oauth_token";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @l
        public static final String f8731h = "oauth_token_secret";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @l
        public static final String f8732i = "oauth_verifier";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @l
        public static final String f8733j = "oauth_signature_method";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @l
        public static final String f8734k = "oauth_timestamp";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @l
        public static final String f8735l = "oauth_version";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @l
        public static final String f8736m = "oauth_signature";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @l
        public static final String f8737n = "oauth_callback_confirmed";
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public final String f8738c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@l String str, @l String str2) {
            super(str);
            l0.p(str, "authScheme");
            l0.p(str2, "blob");
            this.f8738c = str2;
            if (!jk.d.f8741c.matches(str2)) {
                throw new ok.l(l0.C("Invalid blob value: it should be token68, but instead it is ", str2), null, 2, null);
            }
        }

        @Override // jk.c
        @l
        public String b() {
            return this.f8720a + ' ' + this.f8738c;
        }

        @Override // jk.c
        @l
        public String c(@l jk.b bVar) {
            l0.p(bVar, "encoding");
            return b();
        }

        @l
        public final String d() {
            return this.f8738c;
        }

        public boolean equals(@m Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return e0.K1(dVar.f8720a, this.f8720a, true) && e0.K1(dVar.f8738c, this.f8738c, true);
        }

        public int hashCode() {
            p0 p0Var = p0.f6086a;
            String lowerCase = this.f8720a.toLowerCase();
            l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
            String lowerCase2 = this.f8738c.toLowerCase();
            l0.o(lowerCase2, "this as java.lang.String).toLowerCase()");
            return p0Var.a(lowerCase, lowerCase2);
        }
    }

    public /* synthetic */ c(String str, w wVar) {
        this(str);
    }

    @l
    public final String a() {
        return this.f8720a;
    }

    @l
    public abstract String b();

    @l
    public abstract String c(@l jk.b bVar);

    @l
    public String toString() {
        return b();
    }

    public c(String str) {
        this.f8720a = str;
        if (!jk.d.f8741c.matches(str)) {
            throw new ok.l(l0.C("Invalid authScheme value: it should be token, but instead it is ", str), null, 2, null);
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public final List<y> f8721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @l
        public final jk.b f8722d;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f8723a;

            static {
                int[] iArr = new int[jk.b.values().length];
                iArr[jk.b.QUOTED_WHEN_REQUIRED.ordinal()] = 1;
                iArr[jk.b.QUOTED_ALWAYS.ordinal()] = 2;
                iArr[jk.b.URI_ENCODE.ordinal()] = 3;
                f8723a = iArr;
            }
        }

        /* JADX INFO: renamed from: jk.c$b$b, reason: collision with other inner class name */
        public static final class C0225b extends n0 implements jn.l<y, CharSequence> {
            final /* synthetic */ jk.b $encoding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0225b(jk.b bVar) {
                super(1);
                this.$encoding = bVar;
            }

            @Override // jn.l
            @l
            public final CharSequence invoke(@l y yVar) {
                l0.p(yVar, "it");
                return yVar.f8206a + h.f6043c + b.this.e(yVar.f8207b, this.$encoding);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@l String str, @l List<y> list, @l jk.b bVar) {
            super(str);
            l0.p(str, "authScheme");
            l0.p(list, "parameters");
            l0.p(bVar, "encoding");
            this.f8721c = list;
            this.f8722d = bVar;
            for (y yVar : list) {
                if (!jk.d.f8741c.matches(yVar.f8206a)) {
                    throw new ok.l(l0.C("parameter name should be a token but it is ", yVar.f8206a), null, 2, null);
                }
            }
        }

        @Override // jk.c
        @l
        public String b() {
            return c(this.f8722d);
        }

        @Override // jk.c
        @l
        public String c(@l jk.b bVar) {
            l0.p(bVar, "encoding");
            return h0.m3(this.f8721c, ", ", l0.C(this.f8720a, " "), null, 0, null, new C0225b(bVar), 28, null);
        }

        public final String e(String str, jk.b bVar) {
            int i10 = a.f8723a[bVar.ordinal()];
            if (i10 == 1) {
                return ik.a0.d(str);
            }
            if (i10 == 2) {
                return ik.a0.h(str);
            }
            if (i10 == 3) {
                return e.n(str, false, 1, null);
            }
            throw new i0();
        }

        public boolean equals(@m Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return e0.K1(bVar.f8720a, this.f8720a, true) && l0.g(bVar.f8721c, this.f8721c);
        }

        @l
        public final jk.b f() {
            return this.f8722d;
        }

        @l
        public final List<y> g() {
            return this.f8721c;
        }

        @m
        public final String h(@l String str) {
            Object next;
            l0.p(str, "name");
            Iterator<T> it = this.f8721c.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!l0.g(((y) next).f8206a, str));
            y yVar = (y) next;
            if (yVar == null) {
                return null;
            }
            return yVar.f8207b;
        }

        public int hashCode() {
            p0 p0Var = p0.f6086a;
            String lowerCase = this.f8720a.toLowerCase();
            l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
            return p0Var.a(lowerCase, this.f8721c);
        }

        @l
        public final b i(@l String str, @l String str2) {
            l0.p(str, "name");
            l0.p(str2, "value");
            return new b(this.f8720a, (List<y>) h0.F4(this.f8721c, new y(str, str2)), this.f8722d);
        }

        @l
        public final b j(@l String str, @l String str2) {
            l0.p(str, "name");
            l0.p(str2, "value");
            Iterator<y> it = this.f8721c.iterator();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                }
                if (l0.g(it.next().f8206a, str)) {
                    break;
                }
                i10++;
            }
            if (i10 == -1) {
                return i(str, str2);
            }
            List<y> list = this.f8721c;
            ArrayList arrayList = new ArrayList();
            for (y yVar : list) {
                if (l0.g(yVar.f8206a, str)) {
                    if (z10) {
                        yVar = null;
                    } else {
                        yVar = new y(str, str2);
                        z10 = true;
                    }
                }
                if (yVar != null) {
                    arrayList.add(yVar);
                }
            }
            return new b(this.f8720a, arrayList, this.f8722d);
        }

        public /* synthetic */ b(String str, List list, jk.b bVar, int i10, w wVar) {
            this(str, (List<y>) list, (i10 & 4) != 0 ? jk.b.QUOTED_WHEN_REQUIRED : bVar);
        }

        public /* synthetic */ b(String str, Map map, jk.b bVar, int i10, w wVar) {
            this(str, (Map<String, String>) map, (i10 & 4) != 0 ? jk.b.QUOTED_WHEN_REQUIRED : bVar);
        }

        public b(@l String str, @l Map<String, String> map, @l jk.b bVar) {
            l0.p(str, "authScheme");
            l0.p(map, "parameters");
            l0.p(bVar, "encoding");
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            ArrayList arrayList = new ArrayList(z.b0(setEntrySet, 10));
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                arrayList.add(new y((String) entry.getKey(), (String) entry.getValue()));
            }
            this(str, arrayList, bVar);
        }
    }
}
