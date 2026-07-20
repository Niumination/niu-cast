package y0;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f20566a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f20567b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f20568c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f20569d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f20570e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f20571f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f20572g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f20573h = 8;

    public static String a(int i10, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb2 = new StringBuilder("$");
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11];
            if (i12 == 1 || i12 == 2) {
                sb2.append(ks.a.f9445d);
                sb2.append(iArr2[i11]);
                sb2.append(']');
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append(n1.e.f11183c);
                String str = strArr[i11];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }
}
