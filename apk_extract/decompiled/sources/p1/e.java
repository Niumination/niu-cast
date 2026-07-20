package p1;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f8634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f8635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8636d;
    public final String e;

    public e(ArrayList arrayList, char c9, double d7, String str, String str2) {
        this.f8633a = arrayList;
        this.f8634b = c9;
        this.f8635c = d7;
        this.f8636d = str;
        this.e = str2;
    }

    public static int a(String str, char c9, String str2) {
        return str2.hashCode() + a1.a.e(c9 * 31, 31, str);
    }

    public final int hashCode() {
        return a(this.e, this.f8634b, this.f8636d);
    }
}
