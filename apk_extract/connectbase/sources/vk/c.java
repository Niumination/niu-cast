package vk;

import ik.c0;
import ik.g0;
import ik.i1;
import ik.j0;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;
import kn.l0;
import os.l;
import os.m;
import tn.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final void a(@l c0 c0Var, @l ik.d dVar) {
        l0.p(c0Var, "<this>");
        l0.p(dVar, "value");
        j0.f8048a.getClass();
        c0Var.v(j0.f8070l, dVar.toString());
    }

    public static final void b(@l a aVar, @l ik.d dVar) {
        l0.p(aVar, "<this>");
        l0.p(dVar, "value");
        j0.f8048a.getClass();
        m(aVar, j0.f8070l, dVar.toString());
    }

    public static final void c(@l c0 c0Var, @m o oVar, @m Long l10, @l String str) {
        l0.p(c0Var, "<this>");
        l0.p(str, "unit");
        j0.f8048a.getClass();
        c0Var.a(j0.f8084s, ik.h.b(oVar, l10, str));
    }

    public static final void d(@l a aVar, @m o oVar, @m Long l10, @l i1 i1Var) {
        l0.p(aVar, "<this>");
        l0.p(i1Var, "unit");
        e(aVar, oVar, l10, i1Var.getUnitToken());
    }

    public static final void e(@l a aVar, @m o oVar, @m Long l10, @l String str) {
        l0.p(aVar, "<this>");
        l0.p(str, "unit");
        j0.f8048a.getClass();
        m(aVar, j0.f8084s, ik.h.b(oVar, l10, str));
    }

    public static /* synthetic */ void f(c0 c0Var, o oVar, Long l10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            str = i1.Bytes.getUnitToken();
        }
        c(c0Var, oVar, l10, str);
    }

    public static /* synthetic */ void g(a aVar, o oVar, Long l10, i1 i1Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        d(aVar, oVar, l10, i1Var);
    }

    public static /* synthetic */ void h(a aVar, o oVar, Long l10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            str = i1.Bytes.getUnitToken();
        }
        e(aVar, oVar, l10, str);
    }

    public static final void i(@l a aVar, @l String str) {
        l0.p(aVar, "<this>");
        l0.p(str, "value");
        j0.f8048a.getClass();
        m(aVar, j0.A, str);
    }

    public static final void j(@l a aVar, @l LocalDateTime localDateTime) {
        l0.p(aVar, "<this>");
        l0.p(localDateTime, "value");
        j0.f8048a.getClass();
        n(aVar, j0.C, localDateTime);
    }

    public static final void k(@l a aVar, @l String str, int i10) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        g.c(aVar.b(), str, String.valueOf(i10), false, 4, null);
    }

    public static final void l(@l a aVar, @l String str, long j10) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        g.c(aVar.b(), str, String.valueOf(j10), false, 4, null);
    }

    public static final void m(@l a aVar, @l String str, @l String str2) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(str2, "value");
        g.c(aVar.b(), str, str2, false, 4, null);
    }

    public static final void n(@l a aVar, @l String str, @l Temporal temporal) {
        l0.p(aVar, "<this>");
        l0.p(str, "name");
        l0.p(temporal, "date");
        g.c(aVar.b(), str, g0.c(temporal), false, 4, null);
    }

    public static final void o(@l a aVar, @l ZonedDateTime zonedDateTime) {
        l0.p(aVar, "<this>");
        l0.p(zonedDateTime, "dateTime");
        j0.f8048a.getClass();
        n(aVar, j0.O, zonedDateTime);
    }
}
