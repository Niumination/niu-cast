package uk;

import ik.o;
import ik.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import lm.t0;
import nm.d1;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final d f16298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final hl.e<t0<o, String>, String> f16299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final d0 f16300c;

    public static final class a extends n0 implements jn.a<String> {
        final /* synthetic */ o $encoding;
        final /* synthetic */ String $rawValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, o oVar) {
            super(0);
            this.$rawValue = str;
            this.$encoding = oVar;
        }

        @Override // jn.a
        @l
        public final String invoke() {
            return p.f(this.$rawValue, this.$encoding);
        }
    }

    public static final class b extends n0 implements jn.a<Map<String, ? extends String>> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @l
        public final Map<String, ? extends String> invoke() {
            return h.this.a();
        }
    }

    public h(@l d dVar) {
        l0.p(dVar, "request");
        this.f16298a = dVar;
        this.f16299b = new hl.e<>(null, 0, 3, null);
        this.f16300c = f0.b(new b());
    }

    public static /* synthetic */ String c(h hVar, String str, o oVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i10 & 2) != 0) {
            oVar = o.URI_ENCODING;
        }
        return hVar.b(str, oVar);
    }

    @l
    public Map<String, String> a() {
        List<String> listB = this.f16298a.b().b("Cookie");
        if (listB == null) {
            return d1.z();
        }
        HashMap map = new HashMap(listB.size());
        Iterator<String> it = listB.iterator();
        while (it.hasNext()) {
            map.putAll(p.l(it.next(), false, 2, null));
        }
        return map;
    }

    @m
    public final String b(@l String str, @l o oVar) {
        l0.p(str, "name");
        l0.p(oVar, "encoding");
        String str2 = d().get(str);
        if (str2 == null) {
            return null;
        }
        return this.f16299b.l(new t0<>(oVar, str), new a(str2, oVar));
    }

    @l
    public final Map<String, String> d() {
        return (Map) this.f16300c.getValue();
    }

    @l
    public final d e() {
        return this.f16298a;
    }
}
