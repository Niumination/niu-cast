package t6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10181d;
    public final long e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f10183h;

    public c(long j8, String str, ArrayList arrayList, long j10, long j11, int i8, int i9, boolean z2) {
        this.f10178a = j8;
        this.f10180c = arrayList;
        this.f10179b = str;
        this.f10181d = j10;
        this.e = j11;
        this.f = i8;
        this.f10182g = i9;
        this.f10183h = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.f10178a == ((c) obj).f10178a;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f10178a), this.f10180c, Long.valueOf(this.f10181d), Long.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.f10182g), Boolean.valueOf(this.f10183h));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.f10180c.iterator();
        while (it.hasNext()) {
            sb2.append(((b) it.next()).toString());
        }
        StringBuilder sb3 = new StringBuilder("TidEventSet{tid=");
        sb3.append(this.f10178a);
        sb3.append(", event='");
        sb3.append(this.f10179b);
        sb3.append("', eventList=");
        sb3.append((Object) sb2);
        sb3.append(", eventCount=");
        return a1.a.r(sb3, this.f, '}');
    }
}
