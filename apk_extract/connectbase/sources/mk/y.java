package mk;

import java.util.List;
import jq.h0;
import kn.l0;
import kn.n0;
import lm.t0;

/* JADX INFO: loaded from: classes2.dex */
@f
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f10849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<String> f10850b;

    public static final class a extends n0 implements jn.l<String, t0<? extends String, ? extends String>> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final t0<String, String> invoke(@os.l String str) {
            l0.p(str, "it");
            int iO3 = h0.o3(str, fl.h.f6043c, 0, false, 6, null);
            String strSubstring = "";
            if (iO3 < 0) {
                return new t0<>(str, "");
            }
            String strI5 = h0.i5(str, tn.u.W1(0, iO3));
            int i10 = iO3 + 1;
            if (i10 < str.length()) {
                strSubstring = str.substring(i10);
                l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            }
            return new t0<>(strI5, strSubstring);
        }
    }

    public y(@os.l String str, @os.l List<String> list) {
        l0.p(str, "name");
        l0.p(list, "parameters");
        this.f10849a = str;
        this.f10850b = list;
    }

    @os.l
    public final String a() {
        return this.f10849a;
    }

    @os.l
    public final List<String> b() {
        return this.f10850b;
    }

    public final String c() {
        return this.f10850b.isEmpty() ? "" : l0.C(", ", nm.h0.m3(this.f10850b, ks.g.f9491d, null, null, 0, null, null, 62, null));
    }

    @os.l
    public final gq.m<t0<String, String>> d() {
        return gq.v.k1(nm.h0.A1(this.f10850b), a.INSTANCE);
    }

    @os.l
    public String toString() {
        return this.f10849a + ' ' + c();
    }
}
