package bi;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f900c;

    public t(String str, boolean z10) {
        this.f899b = false;
        this.f900c = true;
        this.f898a = str.split("\\.");
        this.f899b = str.indexOf(42) >= 0;
        this.f900c = z10;
    }

    public boolean a() {
        return this.f900c;
    }

    public boolean b(s sVar) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < sVar.c()) {
            String str = sVar.b().get(i10);
            String[] strArr = this.f898a;
            if (i11 >= strArr.length || !strArr[i11].equals("*")) {
                String[] strArr2 = this.f898a;
                if (i11 >= strArr2.length || !strArr2[i11].equals(str)) {
                    int i12 = i11 - 1;
                    if (i12 < 0 || !this.f898a[i12].equals("*")) {
                        return false;
                    }
                    i10++;
                } else {
                    i10++;
                }
            }
            i11++;
        }
        if (i11 <= 0 || !this.f898a[i11 - 1].equals("*")) {
            return i10 >= sVar.c() && sVar.c() > 0;
        }
        return i10 >= sVar.c() && i11 >= this.f898a.length;
    }

    public boolean c() {
        return this.f899b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f898a, ((t) obj).f898a);
    }

    public int hashCode() {
        String[] strArr = this.f898a;
        if (strArr != null) {
            return Arrays.hashCode(strArr);
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        int i10 = 0;
        while (true) {
            String[] strArr = this.f898a;
            if (i10 >= strArr.length) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(strArr[i10]);
            if (i10 < this.f898a.length - 1) {
                sb2.append(ks.g.f9491d);
            }
            i10++;
        }
    }
}
