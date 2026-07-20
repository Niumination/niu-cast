package ik;

import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final Set<String> f8131a = nm.o1.u("max-age", "expires", "domain", "path", "secure", "httponly", "$x-enc");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final jq.r f8132b = new jq.r("(^|;)\\s*([^()<>@;:/\\\\\"\\[\\]\\?=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final Set<Character> f8133c = nm.o1.u(';', Character.valueOf(StringUtil.COMMA), '\"');

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8134a;

        static {
            int[] iArr = new int[o.values().length];
            iArr[o.RAW.ordinal()] = 1;
            iArr[o.DQUOTES.ordinal()] = 2;
            iArr[o.BASE64_ENCODING.ordinal()] = 3;
            iArr[o.URI_ENCODING.ordinal()] = 4;
            f8134a = iArr;
        }
    }

    public static final class b extends kn.n0 implements jn.l<jq.p, lm.t0<? extends String, ? extends String>> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final lm.t0<String, String> invoke(@os.l jq.p pVar) {
            String str;
            String str2;
            kn.l0.p(pVar, "it");
            jq.m mVar = pVar.d().get(2);
            String str3 = "";
            if (mVar == null || (str = mVar.f8861a) == null) {
                str = "";
            }
            jq.m mVar2 = pVar.d().get(4);
            if (mVar2 != null && (str2 = mVar2.f8861a) != null) {
                str3 = str2;
            }
            return new lm.t0<>(str, str3);
        }
    }

    public static final class c extends kn.n0 implements jn.l<lm.t0<? extends String, ? extends String>, Boolean> {
        final /* synthetic */ boolean $skipEscaped;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z10) {
            super(1);
            this.$skipEscaped = z10;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001a  */
        @os.l
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(@os.l lm.t0<String, String> t0Var) {
            boolean z10;
            kn.l0.p(t0Var, "it");
            if (this.$skipEscaped) {
                z10 = jq.e0.s2(t0Var.getFirst(), "$", false, 2, null) ? false : true;
            }
            return Boolean.valueOf(z10);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Boolean invoke(lm.t0<? extends String, ? extends String> t0Var) {
            return invoke2((lm.t0<String, String>) t0Var);
        }
    }

    public static final class d extends kn.n0 implements jn.l<lm.t0<? extends String, ? extends String>, lm.t0<? extends String, ? extends String>> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.t0<? extends String, ? extends String> invoke(lm.t0<? extends String, ? extends String> t0Var) {
            return invoke2((lm.t0<String, String>) t0Var);
        }

        @os.l
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final lm.t0<String, String> invoke2(@os.l lm.t0<String, String> t0Var) {
            kn.l0.p(t0Var, "cookie");
            return (jq.e0.s2(t0Var.getSecond(), "\"", false, 2, null) && jq.e0.J1(t0Var.getSecond(), "\"", false, 2, null)) ? lm.t0.copy$default(t0Var, null, jq.h0.j4(t0Var.getSecond(), "\""), 1, null) : t0Var;
        }
    }

    public static final String a(String str) {
        int i10 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            i10++;
            if (r(cCharAt)) {
                throw new IllegalArgumentException(kn.l0.C("Cookie name is not valid: ", str));
            }
        }
        return str;
    }

    public static final String b(String str, Object obj, o oVar) {
        if (obj == null) {
            return "";
        }
        return str + fl.h.f6043c + g(obj.toString(), oVar);
    }

    public static final String c(String str, String str2, o oVar) {
        if (str2 == null) {
            return str;
        }
        return str + fl.h.f6043c + g(str2.toString(), oVar);
    }

    public static final String d(String str, boolean z10) {
        return z10 ? str : "";
    }

    public static final String e(String str, Object obj) {
        if (obj == null) {
            return "";
        }
        return str + fl.h.f6043c + obj;
    }

    @os.l
    public static final String f(@os.l String str, @os.l o oVar) {
        kn.l0.p(str, "encodedValue");
        kn.l0.p(oVar, "encoding");
        int i10 = a.f8134a[oVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return (jq.e0.s2(jq.h0.O5(str).toString(), "\"", false, 2, null) && jq.e0.J1(jq.h0.I5(str).toString(), "\"", false, 2, null)) ? jq.h0.j4(jq.h0.C5(str).toString(), "\"") : str;
        }
        if (i10 == 3) {
            return fl.h.f(str);
        }
        if (i10 == 4) {
            return e.k(str, 0, 0, true, null, 11, null);
        }
        throw new lm.i0();
    }

    @os.l
    public static final String g(@os.l String str, @os.l o oVar) {
        kn.l0.p(str, "value");
        kn.l0.p(oVar, "encoding");
        int i10 = a.f8134a[oVar.ordinal()];
        int i11 = 0;
        if (i10 == 1) {
            while (i11 < str.length()) {
                char cCharAt = str.charAt(i11);
                i11++;
                if (r(cCharAt)) {
                    throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in RAW format.  Consider URL_ENCODING mode");
                }
            }
            return str;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return fl.h.g(str);
            }
            if (i10 == 4) {
                return e.r(str, true, true, null, 4, null);
            }
            throw new lm.i0();
        }
        if (jq.h0.S2(str, '\"', false, 2, null)) {
            throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in DQUOTES format. Consider URL_ENCODING mode");
        }
        while (i11 < str.length()) {
            char cCharAt2 = str.charAt(i11);
            i11++;
            if (r(cCharAt2)) {
                return "\"" + str + '\"';
            }
        }
        return str;
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void j() {
    }

    @os.l
    public static final Map<String, String> k(@os.l String str, boolean z10) {
        kn.l0.p(str, "cookiesHeader");
        return nm.d1.B0(gq.v.k1(gq.v.p0(gq.v.k1(jq.r.findAll$default(f8132b, str, 0, 2, null), b.INSTANCE), new c(z10)), d.INSTANCE));
    }

    public static /* synthetic */ Map l(String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return k(str, z10);
    }

    @os.l
    public static final l m(@os.l String str) {
        kn.l0.p(str, "cookiesHeader");
        Map<String, String> mapK = k(str, false);
        Iterator<T> it = mapK.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!jq.e0.s2((String) entry.getKey(), "$", false, 2, null)) {
                String str2 = mapK.get("$x-enc");
                o oVarValueOf = str2 == null ? null : o.valueOf(str2);
                if (oVarValueOf == null) {
                    oVarValueOf = o.RAW;
                }
                o oVar = oVarValueOf;
                LinkedHashMap linkedHashMap = new LinkedHashMap(nm.c1.j(mapK.size()));
                Iterator<T> it2 = mapK.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    linkedHashMap.put(fl.t1.e((String) entry2.getKey()), entry2.getValue());
                }
                String str3 = (String) entry.getKey();
                String strF = f((String) entry.getValue(), oVar);
                String str4 = (String) linkedHashMap.get("max-age");
                int iS = str4 != null ? s(str4) : 0;
                String str5 = (String) linkedHashMap.get("expires");
                kl.d dVarA = str5 != null ? r.a(str5) : null;
                String str6 = (String) linkedHashMap.get("domain");
                String str7 = (String) linkedHashMap.get("path");
                boolean zContainsKey = linkedHashMap.containsKey("secure");
                boolean zContainsKey2 = linkedHashMap.containsKey("httponly");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<String, String> entry3 : mapK.entrySet()) {
                    String key = entry3.getKey();
                    if (!f8131a.contains(fl.t1.e(key)) && !kn.l0.g(key, entry.getKey())) {
                        linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                    }
                }
                return new l(str3, strF, oVar, iS, dVarA, str6, str7, zContainsKey, zContainsKey2, linkedHashMap2);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @os.l
    public static final String n(@os.l l lVar) {
        kn.l0.p(lVar, "cookie");
        return lVar.f8102a + fl.h.f6043c + g(lVar.f8103b, lVar.f8104c);
    }

    @os.l
    public static final String o(@os.l l lVar) {
        kn.l0.p(lVar, "cookie");
        return q(lVar.f8102a, lVar.f8103b, lVar.f8104c, lVar.f8105d, lVar.f8106e, lVar.f8107f, lVar.f8108g, lVar.f8109h, lVar.f8110i, lVar.f8111j, false, 1024, null);
    }

    @os.l
    public static final String p(@os.l String str, @os.l String str2, @os.l o oVar, int i10, @os.m kl.d dVar, @os.m String str3, @os.m String str4, boolean z10, boolean z11, @os.l Map<String, String> map, boolean z12) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        kn.l0.p(oVar, "encoding");
        kn.l0.p(map, "extensions");
        String str5 = a(str) + fl.h.f6043c + g(str2.toString(), oVar);
        Integer numValueOf = i10 > 0 ? Integer.valueOf(i10) : null;
        String str6 = "";
        String str7 = numValueOf != null ? "Max-Age=" + numValueOf : "";
        String strE = dVar != null ? r.e(dVar) : null;
        String str8 = strE != null ? "Expires=" + ((Object) strE) : "";
        o oVar2 = o.RAW;
        List listO = nm.y.O(str5, str7, str8, str3 != null ? "Domain=" + g(str3.toString(), oVar2) : "", str4 != null ? "Path=" + g(str4.toString(), oVar2) : "", z10 ? CookieHeaderNames.SECURE : "", z11 ? "HttpOnly" : "");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strA = a(entry.getKey());
            String value = entry.getValue();
            if (value != null) {
                strA = strA + fl.h.f6043c + g(value.toString(), oVar);
            }
            arrayList.add(strA);
        }
        List listE4 = nm.h0.E4(listO, arrayList);
        if (z12) {
            String strName = oVar.name();
            str6 = strName == null ? "$x-enc" : "$x-enc=" + g(strName.toString(), o.RAW);
        }
        List listF4 = nm.h0.F4(listE4, str6);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listF4) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        return nm.h0.m3(arrayList2, "; ", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String q(String str, String str2, o oVar, int i10, kl.d dVar, String str3, String str4, boolean z10, boolean z11, Map map, boolean z12, int i11, Object obj) {
        return p(str, str2, (i11 & 4) != 0 ? o.URI_ENCODING : oVar, (i11 & 8) != 0 ? 0 : i10, (i11 & 16) != 0 ? null : dVar, (i11 & 32) != 0 ? null : str3, (i11 & 64) == 0 ? str4 : null, (i11 & 128) != 0 ? false : z10, (i11 & 256) == 0 ? z11 : false, (i11 & 512) != 0 ? nm.d1.z() : map, (i11 & 1024) != 0 ? true : z12);
    }

    public static final boolean r(char c10) {
        return jq.d.r(c10) || kn.l0.t(c10, 32) < 0 || f8133c.contains(Character.valueOf(c10));
    }

    public static final int s(String str) {
        return (int) tn.u.K(Long.parseLong(str), 0L, 2147483647L);
    }
}
