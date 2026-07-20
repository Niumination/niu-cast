package j1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@l
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f8456a = jq.j.f8821a.toCharArray();

    public static final class a extends q implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        public a(byte[] bytes) {
            bytes.getClass();
            this.bytes = bytes;
        }

        @Override // j1.q
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // j1.q
        public int asInt() {
            byte[] bArr = this.bytes;
            c1.h0.n0(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.bytes;
            return ((bArr2[3] & 255) << 24) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        @Override // j1.q
        public long asLong() {
            byte[] bArr = this.bytes;
            c1.h0.n0(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return padToLong();
        }

        @Override // j1.q
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // j1.q
        public boolean equalsSameBits(q that) {
            if (this.bytes.length != that.getBytesInternal().length) {
                return false;
            }
            boolean z10 = true;
            int i10 = 0;
            while (true) {
                byte[] bArr = this.bytes;
                if (i10 >= bArr.length) {
                    return z10;
                }
                z10 &= bArr[i10] == that.getBytesInternal()[i10];
                i10++;
            }
        }

        @Override // j1.q
        public byte[] getBytesInternal() {
            return this.bytes;
        }

        @Override // j1.q
        public long padToLong() {
            long j10 = this.bytes[0] & 255;
            for (int i10 = 1; i10 < Math.min(this.bytes.length, 8); i10++) {
                j10 |= (((long) this.bytes[i10]) & 255) << (i10 * 8);
            }
            return j10;
        }

        @Override // j1.q
        public void writeBytesToImpl(byte[] dest, int offset, int maxLength) {
            System.arraycopy(this.bytes, 0, dest, offset, maxLength);
        }
    }

    public static final class b extends q implements Serializable {
        private static final long serialVersionUID = 0;
        final int hash;

        public b(int hash) {
            this.hash = hash;
        }

        @Override // j1.q
        public byte[] asBytes() {
            int i10 = this.hash;
            return new byte[]{(byte) i10, (byte) (i10 >> 8), (byte) (i10 >> 16), (byte) (i10 >> 24)};
        }

        @Override // j1.q
        public int asInt() {
            return this.hash;
        }

        @Override // j1.q
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // j1.q
        public int bits() {
            return 32;
        }

        @Override // j1.q
        public boolean equalsSameBits(q that) {
            return this.hash == that.asInt();
        }

        @Override // j1.q
        public long padToLong() {
            return ((long) this.hash) & 4294967295L;
        }

        @Override // j1.q
        public void writeBytesToImpl(byte[] dest, int offset, int maxLength) {
            for (int i10 = 0; i10 < maxLength; i10++) {
                dest[offset + i10] = (byte) (this.hash >> (i10 * 8));
            }
        }
    }

    public static final class c extends q implements Serializable {
        private static final long serialVersionUID = 0;
        final long hash;

        public c(long hash) {
            this.hash = hash;
        }

        @Override // j1.q
        public byte[] asBytes() {
            long j10 = this.hash;
            return new byte[]{(byte) j10, (byte) (j10 >> 8), (byte) (j10 >> 16), (byte) (j10 >> 24), (byte) (j10 >> 32), (byte) (j10 >> 40), (byte) (j10 >> 48), (byte) (j10 >> 56)};
        }

        @Override // j1.q
        public int asInt() {
            return (int) this.hash;
        }

        @Override // j1.q
        public long asLong() {
            return this.hash;
        }

        @Override // j1.q
        public int bits() {
            return 64;
        }

        @Override // j1.q
        public boolean equalsSameBits(q that) {
            return this.hash == that.asLong();
        }

        @Override // j1.q
        public long padToLong() {
            return this.hash;
        }

        @Override // j1.q
        public void writeBytesToImpl(byte[] dest, int offset, int maxLength) {
            for (int i10 = 0; i10 < maxLength; i10++) {
                dest[offset + i10] = (byte) (this.hash >> (i10 * 8));
            }
        }
    }

    public static int a(char ch2) {
        if (ch2 >= '0' && ch2 <= '9') {
            return ch2 - '0';
        }
        if (ch2 >= 'a' && ch2 <= 'f') {
            return ch2 - 'W';
        }
        throw new IllegalArgumentException("Illegal hexadecimal character: " + ch2);
    }

    public static q fromBytes(byte[] bytes) {
        c1.h0.e(bytes.length >= 1, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) bytes.clone());
    }

    public static q fromBytesNoCopy(byte[] bytes) {
        return new a(bytes);
    }

    public static q fromInt(int hash) {
        return new b(hash);
    }

    public static q fromLong(long hash) {
        return new c(hash);
    }

    public static q fromString(String string) {
        c1.h0.u(string.length() >= 2, "input string (%s) must have at least 2 characters", string);
        c1.h0.u(string.length() % 2 == 0, "input string (%s) must have an even number of characters", string);
        byte[] bArr = new byte[string.length() / 2];
        for (int i10 = 0; i10 < string.length(); i10 += 2) {
            bArr[i10 / 2] = (byte) ((a(string.charAt(i10)) << 4) + a(string.charAt(i10 + 1)));
        }
        return fromBytesNoCopy(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(@gm.a Object object) {
        if (!(object instanceof q)) {
            return false;
        }
        q qVar = (q) object;
        return bits() == qVar.bits() && equalsSameBits(qVar);
    }

    public abstract boolean equalsSameBits(q that);

    public byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] bytesInternal = getBytesInternal();
        int i10 = bytesInternal[0] & 255;
        for (int i11 = 1; i11 < bytesInternal.length; i11++) {
            i10 |= (bytesInternal[i11] & 255) << (i11 * 8);
        }
        return i10;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] bytesInternal = getBytesInternal();
        StringBuilder sb2 = new StringBuilder(bytesInternal.length * 2);
        for (byte b10 : bytesInternal) {
            char[] cArr = f8456a;
            sb2.append(cArr[(b10 >> 4) & 15]);
            sb2.append(cArr[b10 & c1.c.f1123q]);
        }
        return sb2.toString();
    }

    @t1.a
    public int writeBytesTo(byte[] dest, int offset, int maxLength) {
        int iU = o1.l.u(maxLength, bits() / 8);
        c1.h0.f0(offset, offset + iU, dest.length);
        writeBytesToImpl(dest, offset, iU);
        return iU;
    }

    public abstract void writeBytesToImpl(byte[] dest, int offset, int maxLength);
}
