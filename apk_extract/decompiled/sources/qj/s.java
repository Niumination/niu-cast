package qj;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f9218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f9219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9220c;

    public s(x sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f9218a = sink;
        this.f9219b = new f();
    }

    @Override // qj.g
    public final g F(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f9219b;
        Intrinsics.checkNotNullParameter(source, "source");
        fVar.L(source, 0, source.length);
        a();
        return this;
    }

    @Override // qj.g
    public final g M(long j8) {
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        this.f9219b.X(j8);
        a();
        return this;
    }

    @Override // qj.g
    public final g Y(byte[] source, int i8, int i9) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        this.f9219b.L(source, i8, i9);
        a();
        return this;
    }

    public final g a() {
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f9219b;
        long jH = fVar.h();
        if (jH > 0) {
            this.f9218a.k0(fVar, jH);
        }
        return this;
    }

    @Override // qj.x
    public final b0 b() {
        return this.f9218a.b();
    }

    public final g c(int i8) {
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        this.f9219b.S(i8);
        a();
        return this;
    }

    @Override // qj.x, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        x xVar = this.f9218a;
        if (this.f9220c) {
            return;
        }
        f fVar = this.f9219b;
        long j8 = fVar.f9195b;
        if (j8 > 0) {
            xVar.k0(fVar, j8);
        }
        th = null;
        try {
            xVar.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f9220c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // qj.x, java.io.Flushable
    public final void flush() {
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f9219b;
        long j8 = fVar.f9195b;
        x xVar = this.f9218a;
        if (j8 > 0) {
            xVar.k0(fVar, j8);
        }
        xVar.flush();
    }

    public final g g(int i8) {
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        this.f9219b.b0(i8);
        a();
        return this;
    }

    @Override // qj.g
    public final f getBuffer() {
        return this.f9219b;
    }

    public final g h(int i8) {
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        f fVar = this.f9219b;
        u uVarH = fVar.H(2);
        int i9 = uVarH.f9226c;
        byte[] bArr = uVarH.f9224a;
        bArr[i9] = (byte) ((i8 >>> 8) & 255);
        bArr[i9 + 1] = (byte) (i8 & 255);
        uVarH.f9226c = i9 + 2;
        fVar.f9195b += 2;
        a();
        return this;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f9220c;
    }

    @Override // qj.x
    public final void k0(f source, long j8) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        this.f9219b.k0(source, j8);
        a();
    }

    public final String toString() {
        return "buffer(" + this.f9218a + ')';
    }

    @Override // qj.g
    public final g v(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        this.f9219b.m0(string);
        a();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f9219b.write(source);
        a();
        return iWrite;
    }

    @Override // qj.g
    public final g z(j byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (this.f9220c) {
            throw new IllegalStateException("closed");
        }
        this.f9219b.I(byteString);
        a();
        return this;
    }
}
