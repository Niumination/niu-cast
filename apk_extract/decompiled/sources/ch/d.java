package ch;

import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Comparable<d> {
    public static final c Companion = new c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final aj.a[] f1688l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f1692d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f1694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f1696k;

    static {
        h[] values = h.values();
        Intrinsics.checkNotNullParameter("io.ktor.util.date.WeekDay", "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        cj.e eVar = new cj.e("io.ktor.util.date.WeekDay", values);
        f[] values2 = f.values();
        Intrinsics.checkNotNullParameter("io.ktor.util.date.Month", "serialName");
        Intrinsics.checkNotNullParameter(values2, "values");
        f1688l = new aj.a[]{null, null, null, eVar, null, null, new cj.e("io.ktor.util.date.Month", values2), null, null};
        Calendar calendar = Calendar.getInstance(a.f1686a, Locale.ROOT);
        Intrinsics.checkNotNull(calendar);
        a.a(calendar, 0L);
    }

    public d(int i8, int i9, int i10, h dayOfWeek, int i11, int i12, f month, int i13, long j8) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        Intrinsics.checkNotNullParameter(month, "month");
        this.f1689a = i8;
        this.f1690b = i9;
        this.f1691c = i10;
        this.f1692d = dayOfWeek;
        this.e = i11;
        this.f1693h = i12;
        this.f1694i = month;
        this.f1695j = i13;
        this.f1696k = j8;
    }

    @Override // java.lang.Comparable
    public final int compareTo(d dVar) {
        d other = dVar;
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.f1696k, other.f1696k);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f1689a == dVar.f1689a && this.f1690b == dVar.f1690b && this.f1691c == dVar.f1691c && this.f1692d == dVar.f1692d && this.e == dVar.e && this.f1693h == dVar.f1693h && this.f1694i == dVar.f1694i && this.f1695j == dVar.f1695j && this.f1696k == dVar.f1696k;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1696k) + a1.a.c(this.f1695j, (this.f1694i.hashCode() + a1.a.c(this.f1693h, a1.a.c(this.e, (this.f1692d.hashCode() + a1.a.c(this.f1691c, a1.a.c(this.f1690b, Integer.hashCode(this.f1689a) * 31, 31), 31)) * 31, 31), 31)) * 31, 31);
    }

    public final String toString() {
        return "GMTDate(seconds=" + this.f1689a + ", minutes=" + this.f1690b + ", hours=" + this.f1691c + ", dayOfWeek=" + this.f1692d + ", dayOfMonth=" + this.e + ", dayOfYear=" + this.f1693h + ", month=" + this.f1694i + ", year=" + this.f1695j + ", timestamp=" + this.f1696k + ')';
    }
}
