package ef;

import af.b2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import k3.sc;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import qj.t;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f4916b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4915a = new ArrayList();
    public d[] e = new d[8];
    public int f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4919g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4920h = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4917c = 4096;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4918d = 4096;

    public f(i iVar) {
        this.f4916b = sc.b(iVar);
    }

    public final int a(int i8) {
        int i9;
        int i10 = 0;
        if (i8 > 0) {
            int length = this.e.length;
            while (true) {
                length--;
                i9 = this.f;
                if (length < i9 || i8 <= 0) {
                    break;
                }
                int i11 = this.e[length].f4914c;
                i8 -= i11;
                this.f4920h -= i11;
                this.f4919g--;
                i10++;
            }
            d[] dVarArr = this.e;
            System.arraycopy(dVarArr, i9 + 1, dVarArr, i9 + 1 + i10, this.f4919g);
            this.f += i10;
        }
        return i10;
    }

    public final qj.j b(int i8) throws IOException {
        if (i8 >= 0) {
            d[] dVarArr = h.f4926b;
            if (i8 <= dVarArr.length - 1) {
                return dVarArr[i8].f4912a;
            }
        }
        int length = this.f + 1 + (i8 - h.f4926b.length);
        if (length >= 0) {
            d[] dVarArr2 = this.e;
            if (length < dVarArr2.length) {
                return dVarArr2[length].f4912a;
            }
        }
        throw new IOException("Header index too large " + (i8 + 1));
    }

    public final void c(d dVar) {
        this.f4915a.add(dVar);
        int i8 = this.f4918d;
        int i9 = dVar.f4914c;
        if (i9 > i8) {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.f4919g = 0;
            this.f4920h = 0;
            return;
        }
        a((this.f4920h + i9) - i8);
        int i10 = this.f4919g + 1;
        d[] dVarArr = this.e;
        if (i10 > dVarArr.length) {
            d[] dVarArr2 = new d[dVarArr.length * 2];
            System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
            this.f = this.e.length - 1;
            this.e = dVarArr2;
        }
        int i11 = this.f;
        this.f = i11 - 1;
        this.e[i11] = dVar;
        this.f4919g++;
        this.f4920h += i9;
    }

    public final qj.j d() {
        int i8;
        t tVar = this.f4916b;
        byte b9 = tVar.readByte();
        int i9 = b9 & UByte.MAX_VALUE;
        boolean z2 = (b9 & ByteCompanionObject.MIN_VALUE) == 128;
        int iE = e(i9, 127);
        if (!z2) {
            return tVar.g(iE);
        }
        n nVar = n.f4949d;
        long j8 = iE;
        tVar.K(j8);
        byte[] bArrM = tVar.f9222b.m(j8);
        nVar.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b2 b2Var = nVar.f4950a;
        b2 b2Var2 = b2Var;
        int i10 = 0;
        int i11 = 0;
        for (byte b10 : bArrM) {
            i10 = (i10 << 8) | (b10 & UByte.MAX_VALUE);
            i11 += 8;
            while (i11 >= 8) {
                b2Var2 = ((b2[]) b2Var2.f181c)[(i10 >>> (i11 - 8)) & 255];
                if (((b2[]) b2Var2.f181c) == null) {
                    byteArrayOutputStream.write(b2Var2.f179a);
                    i11 -= b2Var2.f180b;
                    b2Var2 = b2Var;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            b2 b2Var3 = ((b2[]) b2Var2.f181c)[(i10 << (8 - i11)) & 255];
            if (((b2[]) b2Var3.f181c) != null || (i8 = b2Var3.f180b) > i11) {
                break;
            }
            byteArrayOutputStream.write(b2Var3.f179a);
            i11 -= i8;
            b2Var2 = b2Var;
        }
        return qj.j.of(byteArrayOutputStream.toByteArray());
    }

    public final int e(int i8, int i9) {
        int i10 = i8 & i9;
        if (i10 < i9) {
            return i10;
        }
        int i11 = 0;
        while (true) {
            byte b9 = this.f4916b.readByte();
            int i12 = b9 & UByte.MAX_VALUE;
            if ((b9 & ByteCompanionObject.MIN_VALUE) == 0) {
                return i9 + (i12 << i11);
            }
            i9 += (b9 & ByteCompanionObject.MAX_VALUE) << i11;
            i11 += 7;
        }
    }
}
