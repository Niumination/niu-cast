package vk;

import ik.o;
import ik.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn.l0;
import lm.k;
import nm.d1;
import nm.z;
import os.l;
import os.m;
import tn.u;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final a f17593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17594b;

    public f(@l a aVar, boolean z10) {
        l0.p(aVar, "response");
        this.f17593a = aVar;
        this.f17594b = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(f fVar, String str, String str2, o oVar, long j10, kl.d dVar, String str3, String str4, boolean z10, boolean z11, Map map, int i10, Object obj) {
        fVar.c(str, str2, (i10 & 4) != 0 ? o.URI_ENCODING : oVar, (i10 & 8) != 0 ? 0L : j10, (i10 & 16) != 0 ? null : dVar, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? false : z10, (i10 & 256) != 0 ? false : z11, (i10 & 512) != 0 ? d1.z() : map);
    }

    public static /* synthetic */ void g(f fVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        fVar.f(str, str2, str3);
    }

    public final void a(@l ik.l lVar) {
        l0.p(lVar, "item");
        if (lVar.f8109h && !this.f17594b) {
            throw new IllegalArgumentException("You should set secure cookie only via secure transport (HTTPS)");
        }
        g.c(this.f17593a.b(), "Set-Cookie", p.o(lVar), false, 4, null);
    }

    @k(message = "Convert maxAge to Long")
    public final void b(@l String str, @l String str2, @l o oVar, int i10, @m kl.d dVar, @m String str3, @m String str4, boolean z10, boolean z11, @l Map<String, String> map) {
        l0.p(str, "name");
        l0.p(str2, "value");
        l0.p(oVar, "encoding");
        l0.p(map, "extensions");
        c(str, str2, oVar, i10, dVar, str3, str4, z10, z11, map);
    }

    public final void c(@l String str, @l String str2, @l o oVar, long j10, @m kl.d dVar, @m String str3, @m String str4, boolean z10, boolean z11, @l Map<String, String> map) {
        l0.p(str, "name");
        l0.p(str2, "value");
        l0.p(oVar, "encoding");
        l0.p(map, "extensions");
        a(new ik.l(str, str2, oVar, (int) u.C(j10, 2147483647L), dVar, str3, str4, z10, z11, map));
    }

    public final void f(@l String str, @m String str2, @m String str3) {
        l0.p(str, "name");
        kl.d.f9252p.getClass();
        e(this, str, "", null, 0L, kl.d.f9253v, str2, str3, false, false, null, 908, null);
    }

    @m
    public final ik.l h(@l String str) {
        Object next;
        l0.p(str, "name");
        List<String> listI = this.f17593a.b().i("Set-Cookie");
        ArrayList arrayList = new ArrayList(z.b0(listI, 10));
        Iterator<T> it = listI.iterator();
        while (it.hasNext()) {
            arrayList.add(p.m((String) it.next()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            next = it2.next();
            if (l0.g(((ik.l) next).f8102a, str)) {
                return (ik.l) next;
            }
        }
        next = null;
        return (ik.l) next;
    }
}
