package dj;

import java.io.EOFException;
import java.util.List;
import java.util.regex.Pattern;
import k3.w1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends h0 {
    public static final x e;
    public static final x f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f4647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f4648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f4649i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f4650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qj.j f4652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f4653d;

    static {
        Pattern pattern = x.f4641d;
        e = w1.a("multipart/mixed");
        w1.a("multipart/alternative");
        w1.a("multipart/digest");
        w1.a("multipart/parallel");
        f = w1.a("multipart/form-data");
        f4647g = new byte[]{(byte) 58, (byte) 32};
        f4648h = new byte[]{(byte) 13, (byte) 10};
        byte b9 = (byte) 45;
        f4649i = new byte[]{b9, b9};
    }

    public z(qj.j boundaryByteString, x type, List parts) {
        Intrinsics.checkNotNullParameter(boundaryByteString, "boundaryByteString");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parts, "parts");
        this.f4652c = boundaryByteString;
        this.f4653d = parts;
        Pattern pattern = x.f4641d;
        this.f4650a = w1.a(type + "; boundary=" + boundaryByteString.utf8());
        this.f4651b = -1L;
    }

    @Override // dj.h0
    public final long a() throws EOFException {
        long j8 = this.f4651b;
        if (j8 != -1) {
            return j8;
        }
        long jD = d(null, true);
        this.f4651b = jD;
        return jD;
    }

    @Override // dj.h0
    public final x b() {
        return this.f4650a;
    }

    @Override // dj.h0
    public final void c(qj.g sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        d(sink, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long d(qj.g gVar, boolean z2) throws EOFException {
        qj.f fVar;
        qj.g fVar2;
        if (z2) {
            fVar2 = new qj.f();
            fVar = fVar2;
        } else {
            fVar = 0;
            fVar2 = gVar;
        }
        List list = this.f4653d;
        int size = list.size();
        long j8 = 0;
        int i8 = 0;
        while (true) {
            qj.j jVar = this.f4652c;
            byte[] bArr = f4649i;
            byte[] bArr2 = f4648h;
            if (i8 >= size) {
                Intrinsics.checkNotNull(fVar2);
                fVar2.F(bArr);
                fVar2.z(jVar);
                fVar2.F(bArr);
                fVar2.F(bArr2);
                if (!z2) {
                    return j8;
                }
                Intrinsics.checkNotNull(fVar);
                long j10 = j8 + fVar.f9195b;
                fVar.a();
                return j10;
            }
            y yVar = (y) list.get(i8);
            s sVar = yVar.f4645a;
            Intrinsics.checkNotNull(fVar2);
            fVar2.F(bArr);
            fVar2.z(jVar);
            fVar2.F(bArr2);
            int size2 = sVar.size();
            for (int i9 = 0; i9 < size2; i9++) {
                fVar2.v(sVar.f(i9)).F(f4647g).v(sVar.h(i9)).F(bArr2);
            }
            h0 h0Var = yVar.f4646b;
            x xVarB = h0Var.b();
            if (xVarB != null) {
                fVar2.v("Content-Type: ").v(xVarB.f4642a).F(bArr2);
            }
            long jA = h0Var.a();
            if (jA != -1) {
                fVar2.v("Content-Length: ").M(jA).F(bArr2);
            } else if (z2) {
                Intrinsics.checkNotNull(fVar);
                fVar.a();
                return -1L;
            }
            fVar2.F(bArr2);
            if (z2) {
                j8 += jA;
            } else {
                h0Var.c(fVar2);
            }
            fVar2.F(bArr2);
            i8++;
        }
    }
}
