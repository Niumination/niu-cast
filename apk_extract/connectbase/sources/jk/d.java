package jk;

import el.b0;
import ik.q;
import io.netty.util.internal.StringUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import jq.e0;
import jq.h0;
import jq.j0;
import jq.m0;
import jq.p;
import jq.r;
import kl.f;
import kn.l0;
import kn.n0;
import kn.w;
import n1.e;
import nm.k0;
import nm.o1;
import nm.v0;
import os.l;
import os.m;
import tn.u;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final Set<Character> f8739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final Set<Character> f8740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final r f8741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final r f8742d;

    public static final class a extends n0 implements jn.l<p, CharSequence> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @l
        public final CharSequence invoke(@l p pVar) {
            l0.p(pVar, "it");
            return j0.X8(pVar.getValue(), 1);
        }
    }

    static {
        Character chValueOf = Character.valueOf(m0.f8865c);
        Character chValueOf2 = Character.valueOf(m0.f8866d);
        Character chValueOf3 = Character.valueOf(f.f9277j);
        Character chValueOf4 = Character.valueOf(e.f11183c);
        f8739a = o1.u('!', '#', chValueOf, '%', chValueOf2, '\'', chValueOf3, '+', '-', chValueOf4, '^', '_', '`', '|', '~');
        f8740b = o1.u('-', chValueOf4, '_', '~', '+', Character.valueOf(b0.f4502a));
        f8741c = new r("[a-zA-Z0-9\\-._~+/]+=*");
        f8742d = new r("\\\\.");
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void e() {
    }

    public static final boolean f(char c10) {
        return ('a' <= c10 && c10 < '{') || ('A' <= c10 && c10 < '[') || q.c(c10) || f8739a.contains(Character.valueOf(c10));
    }

    public static final boolean g(char c10) {
        return ('a' <= c10 && c10 < '{') || ('A' <= c10 && c10 < '[') || q.c(c10) || f8740b.contains(Character.valueOf(c10));
    }

    public static final int h(String str, int i10, Map<String, String> map) {
        int i11;
        int iM = m(str, i10);
        int i12 = iM;
        while (i12 < str.length() && f(str.charAt(i12))) {
            i12++;
        }
        String strI5 = h0.i5(str, u.W1(iM, i12));
        int iM2 = m(str, i12);
        if (iM2 >= str.length() || str.charAt(iM2) != '=') {
            throw new ok.l("Expected `=` after parameter key '" + strI5 + "': " + str, null, 2, null);
        }
        boolean z10 = true;
        int iM3 = m(str, iM2 + 1);
        if (str.charAt(iM3) == '\"') {
            iM3++;
            i11 = iM3;
            boolean z11 = false;
            while (i11 < str.length() && (str.charAt(i11) != '\"' || z11)) {
                z11 = !z11 && str.charAt(i11) == '\\';
                i11++;
            }
            if (i11 == str.length()) {
                throw new ok.l("Expected closing quote'\"' in parameter: " + str + ' ', null, 2, null);
            }
        } else {
            i11 = iM3;
            while (i11 < str.length() && str.charAt(i11) != ' ' && str.charAt(i11) != ',') {
                i11++;
            }
            z10 = false;
        }
        String strI6 = h0.i5(str, u.W1(iM3, i11));
        if (z10) {
            strI6 = n(strI6);
        }
        map.put(strI5, strI6);
        return z10 ? i11 + 1 : i11;
    }

    public static final Map<String, String> i(String str, int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (i10 > 0 && i10 < str.length()) {
            i10 = l(str, h(str, i10, linkedHashMap), StringUtil.COMMA);
        }
        return linkedHashMap;
    }

    public static final String j(String str, int i10) {
        int i11 = i10;
        while (i11 < str.length() && g(str.charAt(i11))) {
            i11++;
        }
        while (i11 < str.length() && str.charAt(i11) == '=') {
            i11++;
        }
        Iterable iterableW1 = u.W1(i11, str.length());
        if (!(iterableW1 instanceof Collection) || !((Collection) iterableW1).isEmpty()) {
            Iterator it = iterableW1.iterator();
            while (it.hasNext()) {
                if (str.charAt(((v0) it).nextInt()) != ' ') {
                    return null;
                }
            }
        }
        return h0.i5(str, u.W1(i10, i11));
    }

    @m
    public static final c k(@l String str) {
        l0.p(str, "headerValue");
        int iM = m(str, 0);
        int i10 = iM;
        while (i10 < str.length() && f(str.charAt(i10))) {
            i10++;
        }
        String strI5 = h0.i5(str, u.W1(iM, i10));
        int iM2 = m(str, i10);
        if (e0.S1(strI5)) {
            return null;
        }
        if (str.length() == iM2) {
            return new c.b(strI5, k0.INSTANCE, (b) null, 4, (w) null);
        }
        String strJ = j(str, iM2);
        if (strJ != null) {
            return new c.d(strI5, strJ);
        }
        return new c.b(strI5, i(str, iM2), (b) null, 4, (w) null);
    }

    public static final int l(String str, int i10, char c10) {
        int iM = m(str, i10);
        while (iM < str.length() && str.charAt(iM) != c10) {
            iM++;
        }
        if (iM == str.length()) {
            return -1;
        }
        return m(str, iM + 1);
    }

    public static final int m(String str, int i10) {
        while (i10 < str.length() && str.charAt(i10) == ' ') {
            i10++;
        }
        return i10;
    }

    public static final String n(String str) {
        return f8742d.replace(str, a.INSTANCE);
    }
}
