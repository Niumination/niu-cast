package ff;

import df.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5033c;

    public a(m mVar) {
        int i8;
        String str = (String) mVar.f4458b;
        this.f5031a = (String) mVar.f4460d;
        int i9 = mVar.f4459c;
        if (i9 == -1) {
            if (str.equals("http")) {
                i8 = 80;
            } else if (str.equals("https")) {
                i8 = 443;
            } else {
                i9 = -1;
            }
            i9 = i8;
        }
        this.f5032b = i9;
        this.f5033c = mVar.toString();
    }

    public static int a(char c9) {
        if (c9 >= '0' && c9 <= '9') {
            return c9 - '0';
        }
        if (c9 >= 'a' && c9 <= 'f') {
            return c9 - 'W';
        }
        if (c9 < 'A' || c9 > 'F') {
            return -1;
        }
        return c9 - '7';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f5033c.equals(this.f5033c);
    }

    public final int hashCode() {
        return this.f5033c.hashCode();
    }

    public final String toString() {
        return this.f5033c;
    }
}
