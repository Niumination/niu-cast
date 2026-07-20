package qj;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import k3.qc;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient byte[][] f9232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int[] f9233d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(byte[][] segments, int[] directory) {
        super(j.EMPTY.getData$okio());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.f9232c = segments;
        this.f9233d = directory;
    }

    private final Object writeReplace() {
        j jVarA = a();
        Intrinsics.checkNotNull(jVarA, "null cannot be cast to non-null type java.lang.Object");
        return jVarA;
    }

    public final j a() {
        return new j(toByteArray());
    }

    @Override // qj.j
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override // qj.j
    public String base64() {
        return a().base64();
    }

    @Override // qj.j
    public String base64Url() {
        return a().base64Url();
    }

    @Override // qj.j
    public void copyInto(int i8, byte[] target, int i9, int i10) {
        Intrinsics.checkNotNullParameter(target, "target");
        long j8 = i10;
        qc.b(size(), i8, j8);
        qc.b(target.length, i9, j8);
        int i11 = i10 + i8;
        int iA = rj.c.a(this, i8);
        while (i8 < i11) {
            int i12 = iA == 0 ? 0 : getDirectory$okio()[iA - 1];
            int i13 = getDirectory$okio()[iA] - i12;
            int i14 = getDirectory$okio()[getSegments$okio().length + iA];
            int iMin = Math.min(i11, i13 + i12) - i8;
            int i15 = (i8 - i12) + i14;
            ArraysKt.copyInto(getSegments$okio()[iA], target, i9, i15, i15 + iMin);
            i9 += iMin;
            i8 += iMin;
            iA++;
        }
    }

    @Override // qj.j
    public j digest$okio(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            int i10 = getDirectory$okio()[length + i8];
            int i11 = getDirectory$okio()[i8];
            messageDigest.update(getSegments$okio()[i8], i10, i11 - i9);
            i8++;
            i9 = i11;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new j(digestBytes);
    }

    @Override // qj.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (jVar.size() == size() && rangeEquals(0, jVar, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.f9233d;
    }

    public final byte[][] getSegments$okio() {
        return this.f9232c;
    }

    @Override // qj.j
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // qj.j
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i8 = 0;
        int i9 = 1;
        int i10 = 0;
        while (i8 < length) {
            int i11 = getDirectory$okio()[length + i8];
            int i12 = getDirectory$okio()[i8];
            byte[] bArr = getSegments$okio()[i8];
            int i13 = (i12 - i10) + i11;
            while (i11 < i13) {
                i9 = (i9 * 31) + bArr[i11];
                i11++;
            }
            i8++;
            i10 = i12;
        }
        setHashCode$okio(i9);
        return i9;
    }

    @Override // qj.j
    public String hex() {
        return a().hex();
    }

    @Override // qj.j
    public j hmac$okio(String algorithm, j key) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i8 = 0;
            int i9 = 0;
            while (i8 < length) {
                int i10 = getDirectory$okio()[length + i8];
                int i11 = getDirectory$okio()[i8];
                mac.update(getSegments$okio()[i8], i10, i11 - i9);
                i8++;
                i9 = i11;
            }
            byte[] bArrDoFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "mac.doFinal()");
            return new j(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // qj.j
    public int indexOf(byte[] other, int i8) {
        Intrinsics.checkNotNullParameter(other, "other");
        return a().indexOf(other, i8);
    }

    @Override // qj.j
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // qj.j
    public byte internalGet$okio(int i8) {
        qc.b(getDirectory$okio()[getSegments$okio().length - 1], i8, 1L);
        int iA = rj.c.a(this, i8);
        return getSegments$okio()[iA][(i8 - (iA == 0 ? 0 : getDirectory$okio()[iA - 1])) + getDirectory$okio()[getSegments$okio().length + iA]];
    }

    @Override // qj.j
    public int lastIndexOf(byte[] other, int i8) {
        Intrinsics.checkNotNullParameter(other, "other");
        return a().lastIndexOf(other, i8);
    }

    @Override // qj.j
    public boolean rangeEquals(int i8, j other, int i9, int i10) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i8 < 0 || i8 > size() - i10) {
            return false;
        }
        int i11 = i10 + i8;
        int iA = rj.c.a(this, i8);
        while (i8 < i11) {
            int i12 = iA == 0 ? 0 : getDirectory$okio()[iA - 1];
            int i13 = getDirectory$okio()[iA] - i12;
            int i14 = getDirectory$okio()[getSegments$okio().length + iA];
            int iMin = Math.min(i11, i13 + i12) - i8;
            if (!other.rangeEquals(i9, getSegments$okio()[iA], (i8 - i12) + i14, iMin)) {
                return false;
            }
            i9 += iMin;
            i8 += iMin;
            iA++;
        }
        return true;
    }

    @Override // qj.j
    public String string(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return a().string(charset);
    }

    @Override // qj.j
    public j substring(int i8, int i9) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (i9 == -1234567890) {
            i9 = size();
        }
        if (i8 < 0) {
            throw new IllegalArgumentException(h0.a.h(i8, "beginIndex=", " < 0").toString());
        }
        if (i9 > size()) {
            StringBuilder sbU = a1.a.u(i9, "endIndex=", " > length(");
            sbU.append(size());
            sbU.append(')');
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        int i10 = i9 - i8;
        if (i10 < 0) {
            throw new IllegalArgumentException(o.d.f(i9, i8, "endIndex=", " < beginIndex=").toString());
        }
        if (i8 == 0 && i9 == size()) {
            return this;
        }
        if (i8 == i9) {
            return j.EMPTY;
        }
        int iA = rj.c.a(this, i8);
        int iA2 = rj.c.a(this, i9 - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(getSegments$okio(), iA, iA2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iA <= iA2) {
            int i11 = iA;
            int i12 = 0;
            while (true) {
                iArr[i12] = Math.min(getDirectory$okio()[i11] - i8, i10);
                int i13 = i12 + 1;
                iArr[i12 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i11];
                if (i11 == iA2) {
                    break;
                }
                i11++;
                i12 = i13;
            }
        }
        int i14 = iA != 0 ? getDirectory$okio()[iA - 1] : 0;
        int length = bArr.length;
        iArr[length] = (i8 - i14) + iArr[length];
        return new w(bArr, iArr);
    }

    @Override // qj.j
    public j toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // qj.j
    public j toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // qj.j
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < length) {
            int i11 = getDirectory$okio()[length + i8];
            int i12 = getDirectory$okio()[i8];
            int i13 = i12 - i9;
            ArraysKt.copyInto(getSegments$okio()[i8], bArr, i10, i11, i11 + i13);
            i10 += i13;
            i8++;
            i9 = i12;
        }
        return bArr;
    }

    @Override // qj.j
    public String toString() {
        return a().toString();
    }

    @Override // qj.j
    public void write(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        int length = getSegments$okio().length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            int i10 = getDirectory$okio()[length + i8];
            int i11 = getDirectory$okio()[i8];
            out.write(getSegments$okio()[i8], i10, i11 - i9);
            i8++;
            i9 = i11;
        }
    }

    @Override // qj.j
    public void write$okio(f buffer, int i8, int i9) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i10 = i8 + i9;
        int iA = rj.c.a(this, i8);
        while (i8 < i10) {
            int i11 = iA == 0 ? 0 : getDirectory$okio()[iA - 1];
            int i12 = getDirectory$okio()[iA] - i11;
            int i13 = getDirectory$okio()[getSegments$okio().length + iA];
            int iMin = Math.min(i10, i12 + i11) - i8;
            int i14 = (i8 - i11) + i13;
            u uVar = new u(getSegments$okio()[iA], i14, i14 + iMin, true);
            u uVar2 = buffer.f9194a;
            if (uVar2 == null) {
                uVar.f9228g = uVar;
                uVar.f = uVar;
                buffer.f9194a = uVar;
            } else {
                Intrinsics.checkNotNull(uVar2);
                u uVar3 = uVar2.f9228g;
                Intrinsics.checkNotNull(uVar3);
                uVar3.b(uVar);
            }
            i8 += iMin;
            iA++;
        }
        buffer.f9195b += (long) i9;
    }

    @Override // qj.j
    public boolean rangeEquals(int i8, byte[] other, int i9, int i10) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i8 < 0 || i8 > size() - i10 || i9 < 0 || i9 > other.length - i10) {
            return false;
        }
        int i11 = i10 + i8;
        int iA = rj.c.a(this, i8);
        while (i8 < i11) {
            int i12 = iA == 0 ? 0 : getDirectory$okio()[iA - 1];
            int i13 = getDirectory$okio()[iA] - i12;
            int i14 = getDirectory$okio()[getSegments$okio().length + iA];
            int iMin = Math.min(i11, i13 + i12) - i8;
            if (!qc.a(getSegments$okio()[iA], (i8 - i12) + i14, other, i9, iMin)) {
                return false;
            }
            i9 += iMin;
            i8 += iMin;
            iA++;
        }
        return true;
    }
}
