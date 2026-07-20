package j1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public final class f0 extends j1.c implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    public static final class b extends j1.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MessageDigest f8376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8378d;

        private void o() {
            c1.h0.h0(!this.f8378d, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // j1.s
        public q i() {
            o();
            this.f8378d = true;
            return this.f8377c == this.f8376b.getDigestLength() ? q.fromBytesNoCopy(this.f8376b.digest()) : q.fromBytesNoCopy(Arrays.copyOf(this.f8376b.digest(), this.f8377c));
        }

        @Override // j1.a
        public void k(byte b10) {
            o();
            this.f8376b.update(b10);
        }

        @Override // j1.a
        public void l(ByteBuffer bytes) {
            o();
            this.f8376b.update(bytes);
        }

        @Override // j1.a
        public void n(byte[] b10, int off, int len) {
            o();
            this.f8376b.update(b10, off, len);
        }

        public b(MessageDigest digest, int bytes) {
            this.f8376b = digest;
            this.f8377c = bytes;
        }
    }

    public static final class c implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        private Object readResolve() {
            return new f0(this.algorithmName, this.bytes, this.toString);
        }

        public c(String algorithmName, int bytes, String toString) {
            this.algorithmName = algorithmName;
            this.bytes = bytes;
            this.toString = toString;
        }
    }

    public f0(String algorithmName, String toString) {
        MessageDigest messageDigestA = a(algorithmName);
        this.prototype = messageDigestA;
        this.bytes = messageDigestA.getDigestLength();
        toString.getClass();
        this.toString = toString;
        this.supportsClone = b(messageDigestA);
    }

    public static MessageDigest a(String algorithmName) {
        try {
            return MessageDigest.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    public static boolean b(MessageDigest digest) {
        try {
            digest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // j1.r
    public int bits() {
        return this.bytes * 8;
    }

    @Override // j1.r
    public s newHasher() {
        if (this.supportsClone) {
            try {
                return new b((MessageDigest) this.prototype.clone(), this.bytes);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(a(this.prototype.getAlgorithm()), this.bytes);
    }

    public String toString() {
        return this.toString;
    }

    public Object writeReplace() {
        return new c(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }

    public f0(String algorithmName, int bytes, String toString) {
        toString.getClass();
        this.toString = toString;
        MessageDigest messageDigestA = a(algorithmName);
        this.prototype = messageDigestA;
        int digestLength = messageDigestA.getDigestLength();
        c1.h0.m(bytes >= 4 && bytes <= digestLength, "bytes (%s) must be >= 4 and < %s", bytes, digestLength);
        this.bytes = bytes;
        this.supportsClone = b(messageDigestA);
    }
}
