package g2;

import android.media.MediaDataSource;
import kn.l0;
import kn.l1;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@b.b(23)
public final class e extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final byte[] f6388a;

    public e(@l byte[] bArr) {
        l0.p(bArr, "bytes");
        this.f6388a = bArr;
    }

    @l
    public final byte[] b() {
        return this.f6388a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        long length;
        synchronized (l1.d(e.class)) {
            length = this.f6388a.length;
        }
        return length;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j10, @l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "buffer");
        synchronized (l1.d(e.class)) {
            byte[] bArr2 = this.f6388a;
            int length = bArr2.length;
            long j11 = length;
            if (j10 >= j11) {
                return -1;
            }
            long j12 = ((long) i11) + j10;
            if (j12 > j11) {
                i11 -= ((int) j12) - length;
            }
            System.arraycopy(bArr2, (int) j10, bArr, i10, i11);
            return i11;
        }
    }
}
