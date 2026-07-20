package cf;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import k3.qc;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends af.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qj.f f1645a;

    public v(qj.f fVar) {
        this.f1645a = fVar;
    }

    @Override // af.d, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1645a.a();
    }

    @Override // af.d
    public final af.d h(int i8) {
        qj.f fVar = new qj.f();
        fVar.k0(this.f1645a, i8);
        return new v(fVar);
    }

    @Override // af.d
    public final void i(OutputStream out, int i8) throws IOException {
        long j8 = i8;
        qj.f fVar = this.f1645a;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(out, "out");
        qc.b(fVar.f9195b, 0L, j8);
        qj.u uVar = fVar.f9194a;
        while (j8 > 0) {
            Intrinsics.checkNotNull(uVar);
            int iMin = (int) Math.min(j8, uVar.f9226c - uVar.f9225b);
            out.write(uVar.f9224a, uVar.f9225b, iMin);
            int i9 = uVar.f9225b + iMin;
            uVar.f9225b = i9;
            long j10 = iMin;
            fVar.f9195b -= j10;
            j8 -= j10;
            if (i9 == uVar.f9226c) {
                qj.u uVarA = uVar.a();
                fVar.f9194a = uVarA;
                qj.v.a(uVar);
                uVar = uVarA;
            }
        }
    }

    @Override // af.d
    public final void k(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // af.d
    public final void l(byte[] bArr, int i8, int i9) {
        while (i9 > 0) {
            int i10 = this.f1645a.read(bArr, i8, i9);
            if (i10 == -1) {
                throw new IndexOutOfBoundsException(h0.a.h(i9, "EOF trying to read ", " bytes"));
            }
            i9 -= i10;
            i8 += i10;
        }
    }

    @Override // af.d
    public final int m() {
        try {
            return this.f1645a.readByte() & UByte.MAX_VALUE;
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    @Override // af.d
    public final int o() {
        return (int) this.f1645a.f9195b;
    }

    @Override // af.d
    public final void t(int i8) {
        try {
            this.f1645a.A(i8);
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }
}
