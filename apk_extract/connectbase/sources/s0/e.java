package s0;

import androidx.annotation.RestrictTo;
import java.util.List;
import u0.n;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f14904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f14905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f14906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f14907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f14908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f14909f;

    public e(List<n> list, char c10, double d10, double d11, String str, String str2) {
        this.f14904a = list;
        this.f14905b = c10;
        this.f14906c = d10;
        this.f14907d = d11;
        this.f14908e = str;
        this.f14909f = str2;
    }

    public static int e(char c10, String str, String str2) {
        return str2.hashCode() + b.a(str, c10 * s1.c.f14922b, 31);
    }

    public List<n> a() {
        return this.f14904a;
    }

    public double b() {
        return this.f14906c;
    }

    public String c() {
        return this.f14908e;
    }

    public double d() {
        return this.f14907d;
    }

    public int hashCode() {
        return e(this.f14905b, this.f14909f, this.f14908e);
    }
}
