package ze;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11397c = Logger.getLogger(p1.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p2 f11398d = new p2(5);
    public static final j4.c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f11399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11400b;

    static {
        j4.c cVar = j4.e.f6102c;
        if (cVar.f6104b != null) {
            cVar = new j4.c(cVar.f6103a, (Character) null);
        }
        e = cVar;
    }

    public final void a(m1 m1Var) {
        if (this.f11400b == 0) {
            return;
        }
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = this.f11400b;
            if (i8 >= i10) {
                Arrays.fill(this.f11399a, i9 * 2, i10 * 2, (Object) null);
                this.f11400b = i9;
                return;
            }
            if (!Arrays.equals(m1Var.f11381b, e(i8))) {
                byte[] bArrE = e(i8);
                Object[] objArr = this.f11399a;
                int i11 = i9 * 2;
                objArr[i11] = bArrE;
                Object obj = objArr[(i8 * 2) + 1];
                if (objArr instanceof byte[][]) {
                    b(objArr != null ? objArr.length : 0);
                }
                this.f11399a[i11 + 1] = obj;
                i9++;
            }
            i8++;
        }
    }

    public final void b(int i8) {
        Object[] objArr = new Object[i8];
        int i9 = this.f11400b;
        if (i9 != 0) {
            System.arraycopy(this.f11399a, 0, objArr, 0, i9 * 2);
        }
        this.f11399a = objArr;
    }

    public final Object c(m1 m1Var) {
        for (int i8 = this.f11400b - 1; i8 >= 0; i8--) {
            if (Arrays.equals(m1Var.f11381b, e(i8))) {
                Object obj = this.f11399a[(i8 * 2) + 1];
                if (obj instanceof byte[]) {
                    return m1Var.a((byte[]) obj);
                }
                throw o.d.d(obj);
            }
        }
        return null;
    }

    public final void d(p1 p1Var) {
        int i8 = p1Var.f11400b;
        if (i8 == 0) {
            return;
        }
        Object[] objArr = this.f11399a;
        int length = objArr != null ? objArr.length : 0;
        int i9 = this.f11400b;
        int i10 = length - (i9 * 2);
        if (i9 == 0 || i10 < i8 * 2) {
            b((i8 * 2) + (i9 * 2));
        }
        System.arraycopy(p1Var.f11399a, 0, this.f11399a, this.f11400b * 2, p1Var.f11400b * 2);
        this.f11400b += p1Var.f11400b;
    }

    public final byte[] e(int i8) {
        return (byte[]) this.f11399a[i8 * 2];
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    public final void f(m1 m1Var, Object obj) {
        v8.i(m1Var, "key");
        v8.i(obj, "value");
        int i8 = this.f11400b;
        int i9 = i8 * 2;
        if (i9 == 0) {
            b(Math.max(i8 * 4, 8));
        } else {
            Object[] objArr = this.f11399a;
            if (i9 == (objArr != null ? objArr.length : 0)) {
                b(Math.max(i8 * 4, 8));
            }
        }
        int i10 = this.f11400b;
        this.f11399a[i10 * 2] = m1Var.f11381b;
        this.f11399a[(i10 * 2) + 1] = m1Var.b(obj);
        this.f11400b++;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Metadata(");
        for (int i8 = 0; i8 < this.f11400b; i8++) {
            if (i8 != 0) {
                sb2.append(',');
            }
            byte[] bArrE = e(i8);
            Charset charset = h4.f.f5247a;
            String str = new String(bArrE, charset);
            sb2.append(str);
            sb2.append('=');
            if (str.endsWith("-bin")) {
                Object obj = this.f11399a[(i8 * 2) + 1];
                if (!(obj instanceof byte[])) {
                    o.d.y(obj);
                    throw null;
                }
                sb2.append(e.c((byte[]) obj));
            } else {
                Object obj2 = this.f11399a[(i8 * 2) + 1];
                if (!(obj2 instanceof byte[])) {
                    o.d.y(obj2);
                    throw null;
                }
                sb2.append(new String((byte[]) obj2, charset));
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
