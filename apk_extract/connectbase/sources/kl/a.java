package kl;

import fl.t0;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kn.l0;
import os.l;
import os.m;
import y1.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f9251a = TimeZone.getTimeZone("GMT");

    @l
    public static final d a(int i10, int i11, int i12, int i13, @l h hVar, int i14) {
        l0.p(hVar, o.r.f20670b);
        Calendar calendar = Calendar.getInstance(f9251a, Locale.ROOT);
        l0.m(calendar);
        calendar.set(1, i14);
        calendar.set(2, hVar.ordinal());
        calendar.set(5, i13);
        calendar.set(11, i12);
        calendar.set(12, i11);
        calendar.set(13, i10);
        calendar.set(14, 0);
        return e(calendar, null);
    }

    @l
    public static final d b(@m Long l10) {
        Calendar calendar = Calendar.getInstance(f9251a, Locale.ROOT);
        l0.m(calendar);
        return e(calendar, l10);
    }

    public static /* synthetic */ d c(Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = null;
        }
        return b(l10);
    }

    public static final long d() {
        return System.currentTimeMillis();
    }

    @t0
    @l
    public static final d e(@l Calendar calendar, @m Long l10) {
        l0.p(calendar, "<this>");
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        int i10 = calendar.get(13);
        int i11 = calendar.get(12);
        int i12 = calendar.get(11);
        int i13 = (calendar.get(7) + 5) % 7;
        i.Companion.getClass();
        i iVar = i.values()[i13];
        int i14 = calendar.get(5);
        int i15 = calendar.get(6);
        h.a aVar = h.Companion;
        int i16 = calendar.get(2);
        aVar.getClass();
        return new d(i10, i11, i12, iVar, i14, i15, h.values()[i16], calendar.get(1), calendar.getTimeInMillis());
    }

    @l
    public static final Date f(@l d dVar) {
        l0.p(dVar, "<this>");
        return new Date(dVar.f9262n);
    }
}
