package yk;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String[] f21379a;

    static {
        String[] strArr = new String[1024];
        for (int i10 = 0; i10 < 1024; i10++) {
            strArr[i10] = String.valueOf(i10);
        }
        f21379a = strArr;
    }

    @os.l
    public static final String a(long j10) {
        return (0 > j10 || j10 >= va.q.f16820o) ? String.valueOf(j10) : f21379a[(int) j10];
    }
}
