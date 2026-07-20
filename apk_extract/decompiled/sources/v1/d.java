package v1;

import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Closeable {
    public static final String[] e = new String[128];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f10460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f10461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f10462d;

    static {
        for (int i8 = 0; i8 <= 31; i8++) {
            e[i8] = String.format("\\u%04x", Integer.valueOf(i8));
        }
        String[] strArr = e;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract void A();

    public abstract void B();

    public final void E(String str) throws b {
        StringBuilder sbT = o.d.t(str, " at path ");
        sbT.append(getPath());
        throw new b(sbT.toString());
    }

    public abstract void a();

    public abstract void c();

    public abstract void g();

    public final String getPath() {
        int i8 = this.f10459a;
        int[] iArr = this.f10460b;
        String[] strArr = this.f10461c;
        int[] iArr2 = this.f10462d;
        StringBuilder sb2 = new StringBuilder("$");
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = iArr[i9];
            if (i10 == 1 || i10 == 2) {
                sb2.append('[');
                sb2.append(iArr2[i9]);
                sb2.append(']');
            } else if (i10 == 3 || i10 == 4 || i10 == 5) {
                sb2.append('.');
                String str = strArr[i9];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }

    public abstract void h();

    public abstract boolean i();

    public abstract boolean k();

    public abstract double l();

    public abstract int m();

    public abstract String o();

    public abstract c s();

    public final void t(int i8) {
        int i9 = this.f10459a;
        int[] iArr = this.f10460b;
        if (i9 == iArr.length) {
            if (i9 == 256) {
                throw new a("Nesting too deep at " + getPath());
            }
            this.f10460b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f10461c;
            this.f10461c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f10462d;
            this.f10462d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f10460b;
        int i10 = this.f10459a;
        this.f10459a = i10 + 1;
        iArr3[i10] = i8;
    }

    public abstract int w(f5.a aVar);
}
