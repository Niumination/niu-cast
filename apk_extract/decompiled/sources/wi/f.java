package wi;

import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f10771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f10773c;

    public f(d source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f10771a = source;
        this.f10773c = new a();
    }

    @Override // wi.k
    public final long D(j sink) {
        a aVar;
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j8 = 0;
        while (true) {
            d dVar = this.f10771a;
            aVar = this.f10773c;
            if (dVar.d0(aVar, 8192L) == -1) {
                break;
            }
            long j10 = aVar.f10764c;
            if (j10 == 0) {
                j10 = 0;
            } else {
                h hVar = aVar.f10763b;
                Intrinsics.checkNotNull(hVar);
                int i8 = hVar.f10778c;
                if (i8 < 8192 && hVar.e) {
                    j10 -= (long) (i8 - hVar.f10777b);
                }
            }
            if (j10 > 0) {
                j8 += j10;
                ((a) sink).m(aVar, j10);
            }
        }
        long j11 = aVar.f10764c;
        if (j11 <= 0) {
            return j8;
        }
        long j12 = j8 + j11;
        ((a) sink).m(aVar, j11);
        return j12;
    }

    @Override // wi.k
    public final void G(j sink, long j8) throws EOFException {
        a aVar = this.f10773c;
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            K(j8);
            aVar.G(sink, j8);
        } catch (EOFException e) {
            ((a) sink).m(aVar, aVar.f10764c);
            throw e;
        }
    }

    @Override // wi.k
    public final void K(long j8) throws EOFException {
        if (request(j8)) {
            return;
        }
        throw new EOFException("Source doesn't contain required number of bytes (" + j8 + ").");
    }

    @Override // wi.k
    public final boolean T() {
        if (this.f10772b) {
            throw new IllegalStateException("Source is closed.");
        }
        a aVar = this.f10773c;
        return aVar.T() && this.f10771a.d0(aVar, 8192L) == -1;
    }

    @Override // wi.k
    public final int U(byte[] sink, int i8, int i9) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        q.a(sink.length, i8, i9);
        a aVar = this.f10773c;
        if (aVar.f10764c == 0 && this.f10771a.d0(aVar, 8192L) == -1) {
            return -1;
        }
        return aVar.U(sink, i8, ((int) Math.min(i9 - i8, aVar.f10764c)) + i8);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws EOFException {
        if (this.f10772b) {
            return;
        }
        this.f10772b = true;
        this.f10771a.e = true;
        a aVar = this.f10773c;
        aVar.h(aVar.f10764c);
    }

    @Override // wi.e
    public final long d0(a sink, long j8) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.f10772b) {
            throw new IllegalStateException("Source is closed.");
        }
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount: ", j8).toString());
        }
        a aVar = this.f10773c;
        if (aVar.f10764c == 0 && this.f10771a.d0(aVar, 8192L) == -1) {
            return -1L;
        }
        return aVar.d0(sink, Math.min(j8, aVar.f10764c));
    }

    @Override // wi.k
    public final a getBuffer() {
        return this.f10773c;
    }

    @Override // wi.k
    public final f peek() {
        if (this.f10772b) {
            throw new IllegalStateException("Source is closed.");
        }
        d dVar = new d(this);
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        return new f(dVar);
    }

    @Override // wi.k
    public final byte readByte() throws EOFException {
        K(1L);
        return this.f10773c.readByte();
    }

    @Override // wi.k
    public final int readInt() throws EOFException {
        K(4L);
        return this.f10773c.readInt();
    }

    @Override // wi.k
    public final long readLong() throws EOFException {
        K(8L);
        return this.f10773c.readLong();
    }

    @Override // wi.k
    public final boolean request(long j8) {
        a aVar;
        if (this.f10772b) {
            throw new IllegalStateException("Source is closed.");
        }
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount: ", j8).toString());
        }
        do {
            aVar = this.f10773c;
            if (aVar.f10764c >= j8) {
                return true;
            }
        } while (this.f10771a.d0(aVar, 8192L) != -1);
        return false;
    }

    public final String toString() {
        return "buffered(" + this.f10771a + ')';
    }
}
