package uk;

import el.b0;
import gk.u0;
import ik.i;
import ik.i0;
import ik.j0;
import ik.j1;
import ik.k;
import ik.k1;
import ik.p0;
import ik.x;
import java.nio.charset.Charset;
import java.util.List;
import jq.e0;
import jq.h0;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    @m
    public static final String a(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return q(dVar, j0.f8050b);
    }

    @m
    public static final String b(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return q(dVar, j0.f8052c);
    }

    @l
    public static final List<x> c(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return i0.c(q(dVar, j0.f8052c));
    }

    @m
    public static final String d(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return q(dVar, j0.f8054d);
    }

    @l
    public static final List<x> e(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return i0.c(q(dVar, j0.f8054d));
    }

    @l
    public static final List<x> f(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return i0.b(q(dVar, j0.f8050b));
    }

    @m
    public static final String g(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return q(dVar, j0.f8056e);
    }

    @l
    public static final List<x> h(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return i0.c(q(dVar, j0.f8056e));
    }

    @m
    public static final String i(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return q(dVar, j0.f8068k);
    }

    @m
    public static final String j(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return q(dVar, j0.f8070l);
    }

    @m
    public static final Charset k(@l d dVar) {
        l0.p(dVar, "<this>");
        return k.a(l(dVar));
    }

    @l
    public static final i l(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        String strQ = q(dVar, j0.f8086t);
        i iVarB = strQ == null ? null : i.f7981f.b(strQ);
        if (iVarB != null) {
            return iVarB;
        }
        i.f7981f.getClass();
        return i.f7982g;
    }

    @l
    public static final String m(@l d dVar) {
        l0.p(dVar, "<this>");
        return h0.q5(v(dVar), b0.f4502a, null, 2, null);
    }

    @l
    public static final p0 n(@l d dVar) {
        l0.p(dVar, "<this>");
        return u0.e(dVar).getMethod();
    }

    @l
    public static final String o(@l d dVar) {
        l0.p(dVar, "<this>");
        return u0.e(dVar).getVersion();
    }

    @l
    public static final String p(@l d dVar) {
        l0.p(dVar, "<this>");
        return u0.e(dVar).getUri();
    }

    @m
    public static final String q(@l d dVar, @l String str) {
        l0.p(dVar, "<this>");
        l0.p(str, "name");
        return dVar.b().get(str);
    }

    @l
    public static final String r(@l d dVar) {
        l0.p(dVar, "<this>");
        return u0.e(dVar).b();
    }

    public static final boolean s(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        String strQ = q(dVar, j0.f8095x0);
        return strQ != null && e0.r1(strQ, "chunked", true) == 0;
    }

    public static final boolean t(@l d dVar) {
        l0.p(dVar, "<this>");
        i iVarL = l(dVar);
        i.f.f8020a.getClass();
        return iVarL.h(i.f.f8021b);
    }

    @m
    public static final String u(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return q(dVar, j0.P);
    }

    @l
    public static final String v(@l d dVar) {
        l0.p(dVar, "<this>");
        return h0.u5(u0.e(dVar).getUri(), '?', null, 2, null);
    }

    public static final int w(@l d dVar) {
        l0.p(dVar, "<this>");
        return u0.e(dVar).a();
    }

    @l
    public static final String x(@l d dVar) {
        l0.p(dVar, "<this>");
        return h0.k5(u0.e(dVar).getUri(), '?', "");
    }

    @m
    public static final k1 y(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        String strQ = q(dVar, j0.f8061g0);
        if (strQ == null) {
            return null;
        }
        return j1.b(strQ);
    }

    @m
    public static final String z(@l d dVar) {
        l0.p(dVar, "<this>");
        j0.f8048a.getClass();
        return q(dVar, j0.f8099z0);
    }
}
