package j1;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public final class e0 extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Mac f8366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Key f8367b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8370g;

    public static final class b extends j1.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Mac f8371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8372c;

        @Override // j1.s
        public q i() {
            o();
            this.f8372c = true;
            return q.fromBytesNoCopy(this.f8371b.doFinal());
        }

        @Override // j1.a
        public void k(byte b10) {
            o();
            this.f8371b.update(b10);
        }

        @Override // j1.a
        public void l(ByteBuffer bytes) {
            o();
            bytes.getClass();
            this.f8371b.update(bytes);
        }

        @Override // j1.a
        public void m(byte[] b10) {
            o();
            this.f8371b.update(b10);
        }

        @Override // j1.a
        public void n(byte[] b10, int off, int len) {
            o();
            this.f8371b.update(b10, off, len);
        }

        public final void o() {
            c1.h0.h0(!this.f8372c, "Cannot re-use a Hasher after calling hash() on it");
        }

        public b(Mac mac) {
            this.f8371b = mac;
        }
    }

    public e0(String algorithmName, Key key, String toString) {
        Mac macA = a(algorithmName, key);
        this.f8366a = macA;
        key.getClass();
        this.f8367b = key;
        toString.getClass();
        this.f8368e = toString;
        this.f8369f = macA.getMacLength() * 8;
        this.f8370g = b(macA);
    }

    public static Mac a(String algorithmName, Key key) {
        try {
            Mac mac = Mac.getInstance(algorithmName);
            mac.init(key);
            return mac;
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static boolean b(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // j1.r
    public int bits() {
        return this.f8369f;
    }

    @Override // j1.r
    public s newHasher() {
        if (this.f8370g) {
            try {
                return new b((Mac) this.f8366a.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.f8366a.getAlgorithm(), this.f8367b));
    }

    public String toString() {
        return this.f8368e;
    }
}
