package ef;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import qj.b0;
import qj.t;
import qj.z;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f4928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f4930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4931d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public short f4932h;

    public i(t tVar) {
        this.f4928a = tVar;
    }

    @Override // qj.z
    public final long W(qj.f fVar, long j8) throws IOException {
        int i8;
        int i9;
        do {
            int i10 = this.e;
            t tVar = this.f4928a;
            if (i10 != 0) {
                long jW = tVar.W(fVar, Math.min(j8, i10));
                if (jW == -1) {
                    return -1L;
                }
                this.e -= (int) jW;
                return jW;
            }
            tVar.m(this.f4932h);
            this.f4932h = (short) 0;
            if ((this.f4930c & 4) != 0) {
                return -1L;
            }
            i8 = this.f4931d;
            int iA = m.a(tVar);
            this.e = iA;
            this.f4929b = iA;
            byte b9 = (byte) (tVar.readByte() & UByte.MAX_VALUE);
            this.f4930c = (byte) (tVar.readByte() & UByte.MAX_VALUE);
            Logger logger = m.f4945a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(j.a(true, this.f4931d, this.f4929b, b9, this.f4930c));
            }
            i9 = tVar.readInt() & Integer.MAX_VALUE;
            this.f4931d = i9;
            if (b9 != 9) {
                m.c("%s != TYPE_CONTINUATION", Byte.valueOf(b9));
                throw null;
            }
        } while (i9 == i8);
        m.c("TYPE_CONTINUATION streamId changed", new Object[0]);
        throw null;
    }

    @Override // qj.z
    public final b0 b() {
        return this.f4928a.f9221a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
