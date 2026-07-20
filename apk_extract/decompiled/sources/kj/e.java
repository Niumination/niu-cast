package kj;

import af.b2;
import java.io.IOException;
import java.util.ArrayList;
import k3.sc;
import kotlin.UByte;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qj.t f6904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d[] f6905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6906d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6907g;

    public e(v source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f6907g = 4096;
        this.f6903a = new ArrayList();
        this.f6904b = sc.b(source);
        this.f6905c = new d[8];
        this.f6906d = 7;
    }

    public final int a(int i8) {
        int i9;
        int i10 = 0;
        if (i8 > 0) {
            int length = this.f6905c.length;
            while (true) {
                length--;
                i9 = this.f6906d;
                if (length < i9 || i8 <= 0) {
                    break;
                }
                d dVar = this.f6905c[length];
                Intrinsics.checkNotNull(dVar);
                int i11 = dVar.f6899a;
                i8 -= i11;
                this.f -= i11;
                this.e--;
                i10++;
            }
            d[] dVarArr = this.f6905c;
            System.arraycopy(dVarArr, i9 + 1, dVarArr, i9 + 1 + i10, this.e);
            this.f6906d += i10;
        }
        return i10;
    }

    public final qj.j b(int i8) throws IOException {
        if (i8 >= 0) {
            d[] dVarArr = g.f6917a;
            if (i8 <= dVarArr.length - 1) {
                return dVarArr[i8].f6900b;
            }
        }
        int length = this.f6906d + 1 + (i8 - g.f6917a.length);
        if (length >= 0) {
            d[] dVarArr2 = this.f6905c;
            if (length < dVarArr2.length) {
                d dVar = dVarArr2[length];
                Intrinsics.checkNotNull(dVar);
                return dVar.f6900b;
            }
        }
        throw new IOException("Header index too large " + (i8 + 1));
    }

    public final void c(d dVar) {
        this.f6903a.add(dVar);
        int i8 = this.f6907g;
        int i9 = dVar.f6899a;
        if (i9 > i8) {
            ArraysKt___ArraysJvmKt.fill$default(this.f6905c, (Object) null, 0, 0, 6, (Object) null);
            this.f6906d = this.f6905c.length - 1;
            this.e = 0;
            this.f = 0;
            return;
        }
        a((this.f + i9) - i8);
        int i10 = this.e + 1;
        d[] dVarArr = this.f6905c;
        if (i10 > dVarArr.length) {
            d[] dVarArr2 = new d[dVarArr.length * 2];
            System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
            this.f6906d = this.f6905c.length - 1;
            this.f6905c = dVarArr2;
        }
        int i11 = this.f6906d;
        this.f6906d = i11 - 1;
        this.f6905c[i11] = dVar;
        this.e++;
        this.f += i9;
    }

    public final qj.j d() {
        int i8;
        qj.t source = this.f6904b;
        byte b9 = source.readByte();
        byte[] bArr = ej.b.f4964a;
        int i9 = b9 & UByte.MAX_VALUE;
        int i10 = 0;
        boolean z2 = (b9 & ByteCompanionObject.MIN_VALUE) == 128;
        long jE = e(i9, 127);
        if (!z2) {
            return source.g(jE);
        }
        qj.f sink = new qj.f();
        int[] iArr = c0.f6892a;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        b2 b2Var = c0.f6894c;
        b2 b2Var2 = b2Var;
        int i11 = 0;
        for (long j8 = 0; j8 < jE; j8++) {
            byte b10 = source.readByte();
            byte[] bArr2 = ej.b.f4964a;
            i10 = (i10 << 8) | (b10 & UByte.MAX_VALUE);
            i11 += 8;
            while (i11 >= 8) {
                int i12 = i11 - 8;
                b2[] b2VarArr = (b2[]) b2Var2.f181c;
                Intrinsics.checkNotNull(b2VarArr);
                b2Var2 = b2VarArr[(i10 >>> i12) & 255];
                Intrinsics.checkNotNull(b2Var2);
                if (((b2[]) b2Var2.f181c) == null) {
                    sink.S(b2Var2.f179a);
                    i11 -= b2Var2.f180b;
                    b2Var2 = b2Var;
                } else {
                    i11 = i12;
                }
            }
        }
        while (i11 > 0) {
            b2[] b2VarArr2 = (b2[]) b2Var2.f181c;
            Intrinsics.checkNotNull(b2VarArr2);
            b2 b2Var3 = b2VarArr2[(i10 << (8 - i11)) & 255];
            Intrinsics.checkNotNull(b2Var3);
            if (((b2[]) b2Var3.f181c) != null || (i8 = b2Var3.f180b) > i11) {
                break;
            }
            sink.S(b2Var3.f179a);
            i11 -= i8;
            b2Var2 = b2Var;
        }
        return sink.o(sink.f9195b);
    }

    public final int e(int i8, int i9) {
        int i10 = i8 & i9;
        if (i10 < i9) {
            return i10;
        }
        int i11 = 0;
        while (true) {
            byte b9 = this.f6904b.readByte();
            byte[] bArr = ej.b.f4964a;
            int i12 = b9 & UByte.MAX_VALUE;
            if ((b9 & ByteCompanionObject.MIN_VALUE) == 0) {
                return i9 + (i12 << i11);
            }
            i9 += (b9 & ByteCompanionObject.MAX_VALUE) << i11;
            i11 += 7;
        }
    }
}
