package cr;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends f {
    final transient int[] directory;
    final transient byte[][] segments;

    public y(c cVar, int i10) {
        super(null);
        d0.b(cVar.f3404b, 0L, i10);
        w wVar = cVar.f3403a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = wVar.f3488c;
            int i15 = wVar.f3487b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            wVar = wVar.f3491f;
        }
        this.segments = new byte[i13][];
        this.directory = new int[i13 * 2];
        w wVar2 = cVar.f3403a;
        int i16 = 0;
        while (i11 < i10) {
            byte[][] bArr = this.segments;
            bArr[i16] = wVar2.f3486a;
            int i17 = wVar2.f3488c;
            int i18 = wVar2.f3487b;
            int i19 = (i17 - i18) + i11;
            i11 = i19 > i10 ? i10 : i19;
            int[] iArr = this.directory;
            iArr[i16] = i11;
            iArr[bArr.length + i16] = i18;
            wVar2.f3489d = true;
            i16++;
            wVar2 = wVar2.f3491f;
        }
    }

    private Object writeReplace() {
        return h();
    }

    @Override // cr.f
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // cr.f
    public String base64() {
        return h().base64();
    }

    @Override // cr.f
    public String base64Url() {
        return h().base64Url();
    }

    @Override // cr.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.size() == size() && rangeEquals(0, fVar, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int f(int i10) {
        int iBinarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i10 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // cr.f
    public byte getByte(int i10) {
        d0.b(this.directory[this.segments.length - 1], i10, 1L);
        int iF = f(i10);
        int i11 = iF == 0 ? 0 : this.directory[iF - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[iF][(i10 - i11) + iArr[bArr.length + iF]];
    }

    public final f h() {
        return new f(toByteArray());
    }

    @Override // cr.f
    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int length = this.segments.length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            byte[] bArr = this.segments[i11];
            int[] iArr = this.directory;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        this.hashCode = i12;
        return i12;
    }

    @Override // cr.f
    public String hex() {
        return h().hex();
    }

    @Override // cr.f
    public f hmacSha1(f fVar) {
        return h().hmacSha1(fVar);
    }

    @Override // cr.f
    public f hmacSha256(f fVar) {
        return h().hmacSha256(fVar);
    }

    @Override // cr.f
    public int indexOf(byte[] bArr, int i10) {
        return h().indexOf(bArr, i10);
    }

    @Override // cr.f
    public byte[] internalArray() {
        return toByteArray();
    }

    @Override // cr.f
    public int lastIndexOf(byte[] bArr, int i10) {
        return h().lastIndexOf(bArr, i10);
    }

    @Override // cr.f
    public f md5() {
        return h().md5();
    }

    @Override // cr.f
    public boolean rangeEquals(int i10, f fVar, int i11, int i12) {
        if (i10 < 0 || i10 > size() - i12) {
            return false;
        }
        int iF = f(i10);
        while (i12 > 0) {
            int i13 = iF == 0 ? 0 : this.directory[iF - 1];
            int iMin = Math.min(i12, ((this.directory[iF] - i13) + i13) - i10);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!fVar.rangeEquals(i11, bArr[iF], (i10 - i13) + iArr[bArr.length + iF], iMin)) {
                return false;
            }
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            iF++;
        }
        return true;
    }

    @Override // cr.f
    public f sha1() {
        return h().sha1();
    }

    @Override // cr.f
    public f sha256() {
        return h().sha256();
    }

    @Override // cr.f
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // cr.f
    public String string(Charset charset) {
        return h().string(charset);
    }

    @Override // cr.f
    public f substring(int i10) {
        return h().substring(i10);
    }

    @Override // cr.f
    public f toAsciiLowercase() {
        return h().toAsciiLowercase();
    }

    @Override // cr.f
    public f toAsciiUppercase() {
        return h().toAsciiUppercase();
    }

    @Override // cr.f
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr2 = this.directory;
            int i12 = iArr2[length + i10];
            int i13 = iArr2[i10];
            System.arraycopy(this.segments[i10], i12, bArr2, i11, i13 - i11);
            i10++;
            i11 = i13;
        }
        return bArr2;
    }

    @Override // cr.f
    public String toString() {
        return h().toString();
    }

    @Override // cr.f
    public String utf8() {
        return h().utf8();
    }

    @Override // cr.f
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.directory;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            outputStream.write(this.segments[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
    }

    @Override // cr.f
    public f substring(int i10, int i11) {
        return h().substring(i10, i11);
    }

    @Override // cr.f
    public void write(c cVar) {
        int length = this.segments.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.directory;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            w wVar = new w(this.segments[i10], i12, (i12 + i13) - i11, true, false);
            w wVar2 = cVar.f3403a;
            if (wVar2 == null) {
                wVar.f3492g = wVar;
                wVar.f3491f = wVar;
                cVar.f3403a = wVar;
            } else {
                wVar2.f3492g.c(wVar);
            }
            i10++;
            i11 = i13;
        }
        cVar.f3404b += (long) i11;
    }

    @Override // cr.f
    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        if (i10 < 0 || i10 > size() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int iF = f(i10);
        while (i12 > 0) {
            int i13 = iF == 0 ? 0 : this.directory[iF - 1];
            int iMin = Math.min(i12, ((this.directory[iF] - i13) + i13) - i10);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!d0.a(bArr2[iF], (i10 - i13) + iArr[bArr2.length + iF], bArr, i11, iMin)) {
                return false;
            }
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            iF++;
        }
        return true;
    }
}
