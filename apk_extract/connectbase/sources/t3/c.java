package t3;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import n2.k0;
import rs.f;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<a> f15459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f15461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15464h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f15466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15468d;

        public a(String str, long j10, int i10, String str2) {
            this.f15465a = str;
            this.f15466b = j10;
            this.f15468d = i10;
            this.f15467c = str2;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("TidEvent{event='");
            sb2.append(this.f15465a);
            sb2.append("', ts=");
            return k0.a(sb2, this.f15466b, f.f14860b);
        }
    }

    public c(long j10, String str, List<a> list, long j11, long j12, int i10, int i11, boolean z10) {
        this.f15457a = j10;
        this.f15459c = list;
        this.f15458b = str;
        this.f15460d = j11;
        this.f15461e = j12;
        this.f15462f = i10;
        this.f15463g = i11;
        this.f15464h = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f15457a == ((c) obj).f15457a;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f15457a), this.f15459c, Long.valueOf(this.f15460d), Long.valueOf(this.f15461e), Integer.valueOf(this.f15462f), Integer.valueOf(this.f15463g), Boolean.valueOf(this.f15464h));
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<a> it = this.f15459c.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
        }
        StringBuilder sb3 = new StringBuilder("TidEventSet{tid=");
        sb3.append(this.f15457a);
        sb3.append(", event='");
        sb3.append(this.f15458b);
        sb3.append("', eventList=");
        sb3.append((Object) sb2);
        sb3.append(", eventCount=");
        return u.a.a(sb3, this.f15462f, f.f14860b);
    }
}
