package kj;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d[] f6913d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final qj.f f6916i;

    public f(qj.f out) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.f6915h = true;
        this.f6916i = out;
        this.f6910a = Integer.MAX_VALUE;
        this.f6912c = 4096;
        this.f6913d = new d[8];
        this.e = 7;
    }

    public final void a(int i8) {
        int i9;
        if (i8 > 0) {
            int length = this.f6913d.length - 1;
            int i10 = 0;
            while (true) {
                i9 = this.e;
                if (length < i9 || i8 <= 0) {
                    break;
                }
                d dVar = this.f6913d[length];
                Intrinsics.checkNotNull(dVar);
                i8 -= dVar.f6899a;
                int i11 = this.f6914g;
                d dVar2 = this.f6913d[length];
                Intrinsics.checkNotNull(dVar2);
                this.f6914g = i11 - dVar2.f6899a;
                this.f--;
                i10++;
                length--;
            }
            d[] dVarArr = this.f6913d;
            int i12 = i9 + 1;
            System.arraycopy(dVarArr, i12, dVarArr, i12 + i10, this.f);
            d[] dVarArr2 = this.f6913d;
            int i13 = this.e + 1;
            Arrays.fill(dVarArr2, i13, i13 + i10, (Object) null);
            this.e += i10;
        }
    }

    public final void b(d dVar) {
        int i8 = this.f6912c;
        int i9 = dVar.f6899a;
        if (i9 > i8) {
            ArraysKt___ArraysJvmKt.fill$default(this.f6913d, (Object) null, 0, 0, 6, (Object) null);
            this.e = this.f6913d.length - 1;
            this.f = 0;
            this.f6914g = 0;
            return;
        }
        a((this.f6914g + i9) - i8);
        int i10 = this.f + 1;
        d[] dVarArr = this.f6913d;
        if (i10 > dVarArr.length) {
            d[] dVarArr2 = new d[dVarArr.length * 2];
            System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
            this.e = this.f6913d.length - 1;
            this.f6913d = dVarArr2;
        }
        int i11 = this.e;
        this.e = i11 - 1;
        this.f6913d[i11] = dVar;
        this.f++;
        this.f6914g += i9;
    }

    public final void c(qj.j source) throws EOFException {
        Intrinsics.checkNotNullParameter(source, "data");
        qj.f fVar = this.f6916i;
        if (this.f6915h) {
            int[] iArr = c0.f6892a;
            Intrinsics.checkNotNullParameter(source, "bytes");
            int size = source.size();
            long j8 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                byte b9 = source.getByte(i8);
                byte[] bArr = ej.b.f4964a;
                j8 += (long) c0.f6893b[b9 & UByte.MAX_VALUE];
            }
            if (((int) ((j8 + ((long) 7)) >> 3)) < source.size()) {
                qj.f sink = new qj.f();
                int[] iArr2 = c0.f6892a;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(sink, "sink");
                int size2 = source.size();
                long j10 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < size2; i10++) {
                    byte b10 = source.getByte(i10);
                    byte[] bArr2 = ej.b.f4964a;
                    int i11 = b10 & UByte.MAX_VALUE;
                    int i12 = c0.f6892a[i11];
                    byte b11 = c0.f6893b[i11];
                    j10 = (j10 << b11) | ((long) i12);
                    i9 += b11;
                    while (i9 >= 8) {
                        i9 -= 8;
                        sink.S((int) (j10 >> i9));
                    }
                }
                if (i9 > 0) {
                    sink.S((int) ((255 >>> i9) | (j10 << (8 - i9))));
                }
                qj.j jVarO = sink.o(sink.f9195b);
                e(jVarO.size(), 127, 128);
                fVar.I(jVarO);
                return;
            }
        }
        e(source.size(), 127, 0);
        fVar.I(source);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006e  */
    public final void d(ArrayList headerBlock) throws EOFException {
        int length;
        int length2;
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (this.f6911b) {
            int i8 = this.f6910a;
            if (i8 < this.f6912c) {
                e(i8, 31, 32);
            }
            this.f6911b = false;
            this.f6910a = Integer.MAX_VALUE;
            e(this.f6912c, 31, 32);
        }
        int size = headerBlock.size();
        for (int i9 = 0; i9 < size; i9++) {
            d dVar = (d) headerBlock.get(i9);
            qj.j asciiLowercase = dVar.f6900b.toAsciiLowercase();
            Integer num = (Integer) g.f6918b.get(asciiLowercase);
            qj.j jVar = dVar.f6901c;
            if (num != null) {
                int iIntValue = num.intValue();
                length2 = iIntValue + 1;
                if (2 <= length2 && 7 >= length2) {
                    d[] dVarArr = g.f6917a;
                    if (Intrinsics.areEqual(dVarArr[iIntValue].f6901c, jVar)) {
                        length = length2;
                    } else if (Intrinsics.areEqual(dVarArr[length2].f6901c, jVar)) {
                        length2 = iIntValue + 2;
                        length = length2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                } else {
                    length = length2;
                    length2 = -1;
                }
            } else {
                length = -1;
                length2 = -1;
            }
            if (length2 == -1) {
                int length3 = this.f6913d.length;
                for (int i10 = this.e + 1; i10 < length3; i10++) {
                    d dVar2 = this.f6913d[i10];
                    Intrinsics.checkNotNull(dVar2);
                    if (Intrinsics.areEqual(dVar2.f6900b, asciiLowercase)) {
                        d dVar3 = this.f6913d[i10];
                        Intrinsics.checkNotNull(dVar3);
                        if (Intrinsics.areEqual(dVar3.f6901c, jVar)) {
                            length2 = g.f6917a.length + (i10 - this.e);
                            break;
                        } else if (length == -1) {
                            length = (i10 - this.e) + g.f6917a.length;
                        }
                    }
                }
            }
            if (length2 != -1) {
                e(length2, 127, 128);
            } else if (length == -1) {
                this.f6916i.S(64);
                c(asciiLowercase);
                c(jVar);
                b(dVar);
            } else if (!asciiLowercase.startsWith(d.f6895d) || Intrinsics.areEqual(d.f6898i, asciiLowercase)) {
                e(length, 63, 64);
                c(jVar);
                b(dVar);
            } else {
                e(length, 15, 0);
                c(jVar);
            }
        }
    }

    public final void e(int i8, int i9, int i10) {
        qj.f fVar = this.f6916i;
        if (i8 < i9) {
            fVar.S(i8 | i10);
            return;
        }
        fVar.S(i10 | i9);
        int i11 = i8 - i9;
        while (i11 >= 128) {
            fVar.S(128 | (i11 & 127));
            i11 >>>= 7;
        }
        fVar.S(i11);
    }
}
