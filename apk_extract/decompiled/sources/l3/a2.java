package l3;

/* JADX INFO: loaded from: classes.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f7200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f7202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7203d;

    public a2(q1 q1Var, String str, Object[] objArr) {
        this.f7200a = q1Var;
        this.f7201b = str;
        this.f7202c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f7203d = cCharAt;
            return;
        }
        int i8 = cCharAt & 8191;
        int i9 = 13;
        int i10 = 1;
        while (true) {
            int i11 = i10 + 1;
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 55296) {
                this.f7203d = i8 | (cCharAt2 << i9);
                return;
            } else {
                i8 |= (cCharAt2 & 8191) << i9;
                i9 += 13;
                i10 = i11;
            }
        }
    }

    public final q1 a() {
        return this.f7200a;
    }

    public final int b() {
        return (this.f7203d & 1) != 0 ? 1 : 2;
    }

    public final String c() {
        return this.f7201b;
    }

    public final Object[] d() {
        return this.f7202c;
    }
}
