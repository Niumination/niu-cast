package dj;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f4588j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f4589k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f4590l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f4591m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4595d;
    public final String e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4598i;

    public k(String str, String str2, long j8, String str3, String str4, boolean z2, boolean z3, boolean z5, boolean z10) {
        this.f4592a = str;
        this.f4593b = str2;
        this.f4594c = j8;
        this.f4595d = str3;
        this.e = str4;
        this.f = z2;
        this.f4596g = z3;
        this.f4597h = z5;
        this.f4598i = z10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (Intrinsics.areEqual(kVar.f4592a, this.f4592a) && Intrinsics.areEqual(kVar.f4593b, this.f4593b) && kVar.f4594c == this.f4594c && Intrinsics.areEqual(kVar.f4595d, this.f4595d) && Intrinsics.areEqual(kVar.e, this.e) && kVar.f == this.f && kVar.f4596g == this.f4596g && kVar.f4597h == this.f4597h && kVar.f4598i == this.f4598i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f4598i) + a1.a.g(this.f4597h, a1.a.g(this.f4596g, a1.a.g(this.f, a1.a.e(a1.a.e(a1.a.f(this.f4594c, a1.a.e(a1.a.e(527, 31, this.f4592a), 31, this.f4593b), 31), 31, this.f4595d), 31, this.e), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f4592a);
        sb2.append('=');
        sb2.append(this.f4593b);
        if (this.f4597h) {
            long j8 = this.f4594c;
            if (j8 == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                Date toHttpDateString = new Date(j8);
                g3.h hVar = ij.c.f5876a;
                Intrinsics.checkNotNullParameter(toHttpDateString, "$this$toHttpDateString");
                String str = ((DateFormat) ij.c.f5876a.get()).format(toHttpDateString);
                Intrinsics.checkNotNullExpressionValue(str, "STANDARD_DATE_FORMAT.get().format(this)");
                sb2.append(str);
            }
        }
        if (!this.f4598i) {
            sb2.append("; domain=");
            sb2.append(this.f4595d);
        }
        sb2.append("; path=");
        sb2.append(this.e);
        if (this.f) {
            sb2.append("; secure");
        }
        if (this.f4596g) {
            sb2.append("; httponly");
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString()");
        return string;
    }
}
