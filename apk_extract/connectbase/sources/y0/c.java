package y0;

import cr.q;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f20556g = new String[128];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f20558b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f20559c = new String[32];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f20560d = new int[32];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20562f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f20563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f20564b;

        public a(String[] strArr, q qVar) {
            this.f20563a = strArr;
            this.f20564b = qVar;
        }

        public static a a(String... strArr) {
            try {
                cr.f[] fVarArr = new cr.f[strArr.length];
                cr.c cVar = new cr.c();
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    c.j0(cVar, strArr[i10]);
                    cVar.readByte();
                    fVarArr[i10] = cVar.v1();
                }
                return new a((String[]) strArr.clone(), q.e(fVarArr));
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f20556g[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f20556g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static c E(cr.e eVar) {
        return new e(eVar);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    public static void j0(cr.d dVar, String str) throws IOException {
        String str2;
        String[] strArr = f20556g;
        dVar.writeByte(34);
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i10 < i11) {
                        dVar.c0(str, i10, i11);
                    }
                    dVar.V(str2);
                    i10 = i11 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i10 < i11) {
                    dVar.c0(str, i10, i11);
                }
                dVar.V(str2);
                i10 = i11 + 1;
            }
        }
        if (i10 < length) {
            dVar.c0(str, i10, length);
        }
        dVar.writeByte(34);
    }

    public abstract String A() throws IOException;

    public abstract b O() throws IOException;

    public final void b0(int i10) {
        int i11 = this.f20557a;
        int[] iArr = this.f20558b;
        if (i11 == iArr.length) {
            if (i11 == 256) {
                throw new y0.a("Nesting too deep at " + n());
            }
            this.f20558b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f20559c;
            this.f20559c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f20560d;
            this.f20560d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f20558b;
        int i12 = this.f20557a;
        this.f20557a = i12 + 1;
        iArr3[i12] = i10;
    }

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract int e0(a aVar) throws IOException;

    public abstract void f0() throws IOException;

    public abstract void g0() throws IOException;

    public abstract void h() throws IOException;

    public abstract void k() throws IOException;

    public final y0.b k0(String str) throws y0.b {
        StringBuilder sbA = k.c.a(str, " at path ");
        sbA.append(n());
        throw new y0.b(sbA.toString());
    }

    public final String n() {
        return d.a(this.f20557a, this.f20558b, this.f20559c, this.f20560d);
    }

    public abstract boolean o() throws IOException;

    public abstract boolean p() throws IOException;

    public abstract double q() throws IOException;

    public abstract int t() throws IOException;

    public abstract String y() throws IOException;
}
