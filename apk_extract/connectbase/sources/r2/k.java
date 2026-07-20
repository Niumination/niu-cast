package r2;

import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final a f14180f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14181g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14182h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f14183i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f14184j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f14185k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f14186l = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<x2.c> f14188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<j> f14189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final String f14190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14191e;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(long j10, @os.l List<? extends x2.c> list, @os.l List<j> list2, @os.m String str, int i10) {
        l0.p(list, "data");
        l0.p(list2, "fileInfos");
        this.f14187a = j10;
        this.f14188b = list;
        this.f14189c = list2;
        this.f14190d = str;
        this.f14191e = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ k g(k kVar, long j10, List list, List list2, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = kVar.f14187a;
        }
        long j11 = j10;
        if ((i11 & 2) != 0) {
            list = kVar.f14188b;
        }
        List list3 = list;
        if ((i11 & 4) != 0) {
            list2 = kVar.f14189c;
        }
        List list4 = list2;
        if ((i11 & 8) != 0) {
            str = kVar.f14190d;
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            i10 = kVar.f14191e;
        }
        return kVar.f(j11, list3, list4, str2, i10);
    }

    public final long a() {
        return this.f14187a;
    }

    @os.l
    public final List<x2.c> b() {
        return this.f14188b;
    }

    @os.l
    public final List<j> c() {
        return this.f14189c;
    }

    @os.m
    public final String d() {
        return this.f14190d;
    }

    public final int e() {
        return this.f14191e;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f14187a == kVar.f14187a && l0.g(this.f14188b, kVar.f14188b) && l0.g(this.f14189c, kVar.f14189c) && l0.g(this.f14190d, kVar.f14190d) && this.f14191e == kVar.f14191e;
    }

    @os.l
    public final k f(long j10, @os.l List<? extends x2.c> list, @os.l List<j> list2, @os.m String str, int i10) {
        l0.p(list, "data");
        l0.p(list2, "fileInfos");
        return new k(j10, list, list2, str, i10);
    }

    @os.l
    public final List<x2.c> h() {
        return this.f14188b;
    }

    public int hashCode() {
        int iHashCode = (this.f14189c.hashCode() + ((this.f14188b.hashCode() + (Long.hashCode(this.f14187a) * 31)) * 31)) * 31;
        String str = this.f14190d;
        return Integer.hashCode(this.f14191e) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    @os.m
    public final String i() {
        return this.f14190d;
    }

    @os.l
    public final List<j> j() {
        return this.f14189c;
    }

    public final int k() {
        return this.f14191e;
    }

    public final long l() {
        return this.f14187a;
    }

    public final boolean m() {
        return this.f14191e == 4;
    }

    public final boolean n() {
        int i10 = this.f14191e;
        return i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5;
    }

    public final boolean o() {
        return this.f14191e == 1;
    }

    public final boolean p() {
        return this.f14191e == 0;
    }

    public final void q(int i10) {
        this.f14191e = i10;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("FileTaskInfo(taskId=");
        sb2.append(this.f14187a);
        sb2.append(", data=");
        sb2.append(this.f14188b);
        sb2.append(", fileInfos=");
        sb2.append(this.f14189c);
        sb2.append(", extend=");
        sb2.append(this.f14190d);
        sb2.append(", state=");
        return u.a.a(sb2, this.f14191e, ')');
    }

    public /* synthetic */ k(long j10, List list, List list2, String str, int i10, int i11, kn.w wVar) {
        this(j10, list, list2, str, (i11 & 16) != 0 ? 0 : i10);
    }
}
