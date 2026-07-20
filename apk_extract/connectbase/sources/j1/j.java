package j1;

import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public final class j extends c implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final x<? extends Checksum> checksumSupplier;
    private final String toString;

    public final class b extends j1.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Checksum f8397b;

        @Override // j1.s
        public q i() {
            long value = this.f8397b.getValue();
            return j.this.bits == 32 ? q.fromInt((int) value) : q.fromLong(value);
        }

        @Override // j1.a
        public void k(byte b10) {
            this.f8397b.update(b10);
        }

        @Override // j1.a
        public void n(byte[] bytes, int off, int len) {
            this.f8397b.update(bytes, off, len);
        }

        public b(Checksum checksum) {
            checksum.getClass();
            this.f8397b = checksum;
        }
    }

    public j(x<? extends Checksum> checksumSupplier, int bits, String toString) {
        checksumSupplier.getClass();
        this.checksumSupplier = checksumSupplier;
        c1.h0.k(bits == 32 || bits == 64, "bits (%s) must be either 32 or 64", bits);
        this.bits = bits;
        toString.getClass();
        this.toString = toString;
    }

    @Override // j1.r
    public int bits() {
        return this.bits;
    }

    @Override // j1.r
    public s newHasher() {
        return new b(this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
