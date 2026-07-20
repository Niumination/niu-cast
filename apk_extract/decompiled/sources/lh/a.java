package lh;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import k3.ab;
import k3.bb;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import wi.b;
import wi.h;
import wi.j;
import wi.k;
import wi.p;
import wi.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wi.a f7428a = new wi.a();

    public static void a(wi.a aVar, String value) {
        int length = value.length();
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        n(aVar, value, 0, length, 8);
    }

    public static final wi.a b(j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        wi.a aVar = (wi.a) jVar;
        aVar.getClass();
        return aVar;
    }

    public static final wi.a c(wi.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        aVar.getClass();
        wi.a aVar2 = new wi.a();
        if (aVar.f10764c != 0) {
            h hVar = aVar.f10762a;
            Intrinsics.checkNotNull(hVar);
            h hVarE = hVar.e();
            aVar2.f10762a = hVarE;
            aVar2.f10763b = hVarE;
            for (h hVar2 = hVar.f; hVar2 != null; hVar2 = hVar2.f) {
                h hVar3 = aVar2.f10763b;
                Intrinsics.checkNotNull(hVar3);
                h hVarE2 = hVar2.e();
                hVar3.d(hVarE2);
                aVar2.f10763b = hVarE2;
            }
            aVar2.f10764c = aVar.f10764c;
        }
        return aVar2;
    }

    public static final void d(k kVar, long j8) throws EOFException {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        kVar.request(j8);
        kVar.getBuffer().h(Math.min(j8, e(kVar)));
    }

    public static final long e(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        return kVar.getBuffer().f10764c;
    }

    public static final int f(j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        wi.a aVar = (wi.a) jVar;
        aVar.getClass();
        return (int) aVar.f10764c;
    }

    public static final void g(k kVar, Function1 block) throws EOFException {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        wi.a buffer = kVar.getBuffer();
        if (buffer.T()) {
            throw new IllegalArgumentException("Buffer is empty");
        }
        h hVar = buffer.f10762a;
        Intrinsics.checkNotNull(hVar);
        byte[] bArr = hVar.f10776a;
        int i8 = hVar.f10777b;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i8, hVar.f10778c - i8);
        Intrinsics.checkNotNull(byteBufferWrap);
        block.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - i8;
        if (iPosition != 0) {
            if (iPosition < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (iPosition > hVar.b()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            buffer.h(iPosition);
        }
    }

    public static String h(k kVar, Charset charset, int i8) {
        if ((i8 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return Intrinsics.areEqual(charset, Charsets.UTF_8) ? p.b(kVar) : bb.a(charset.newDecoder(), kVar, Integer.MAX_VALUE);
    }

    public static final byte[] i(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return Intrinsics.areEqual(charset, Charsets.UTF_8) ? StringsKt__StringsJVMKt.encodeToByteArray$default(str, 0, 0, true, 3, null) : ab.a(charset.newEncoder(), str, 0, str.length());
    }

    public static final void j(wi.a aVar, ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        b.a(aVar, buffer);
    }

    public static final void k(j jVar, byte[] buffer, int i8, int i9) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ((wi.a) jVar).o(buffer, i8, i9 + i8);
    }

    public static final void m(j jVar, k packet) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        ((wi.a) jVar).k(packet);
    }

    public static void n(wi.a aVar, CharSequence text, int i8, int i9, int i10) {
        int i11;
        long j8;
        int i12 = (i10 & 2) != 0 ? 0 : i8;
        int length = (i10 & 4) != 0 ? text.length() : i9;
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String string = text.toString();
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        q.a(string.length(), i12, length);
        aVar.getClass();
        while (i12 < length) {
            Ref.IntRef intRef = new Ref.IntRef();
            char cCharAt = string.charAt(i12);
            intRef.element = cCharAt;
            if (cCharAt < 128) {
                h segment = aVar.l(1);
                int i13 = -i12;
                int iMin = Math.min(length, segment.a() + i12);
                int i14 = i12 + 1;
                byte b9 = (byte) intRef.element;
                Intrinsics.checkNotNullParameter(segment, "segment");
                int i15 = segment.f10778c + i12 + i13;
                byte[] bArr = segment.f10776a;
                bArr[i15] = b9;
                while (i14 < iMin) {
                    char cCharAt2 = string.charAt(i14);
                    intRef.element = cCharAt2;
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    Intrinsics.checkNotNullParameter(segment, "segment");
                    bArr[segment.f10778c + i14 + i13] = (byte) cCharAt2;
                    i14++;
                }
                int i16 = i13 + i14;
                if (i16 == 1) {
                    segment.f10778c += i16;
                    aVar.f10764c += (long) i16;
                } else {
                    if (i16 < 0 || i16 > segment.a()) {
                        StringBuilder sbU = a1.a.u(i16, "Invalid number of bytes written: ", ". Should be in 0..");
                        sbU.append(segment.a());
                        throw new IllegalStateException(sbU.toString().toString());
                    }
                    if (i16 != 0) {
                        segment.f10778c += i16;
                        aVar.f10764c += (long) i16;
                    } else if (q.d(segment)) {
                        aVar.g();
                    }
                }
                i12 = i14;
            } else {
                if (cCharAt < 2048) {
                    i11 = 2;
                    h segment2 = aVar.l(2);
                    int i17 = intRef.element;
                    Intrinsics.checkNotNullParameter(segment2, "segment");
                    int i18 = segment2.f10778c;
                    byte[] bArr2 = segment2.f10776a;
                    bArr2[i18] = (byte) ((i17 >> 6) | 192);
                    bArr2[i18 + 1] = (byte) ((i17 & 63) | 128);
                    segment2.f10778c = i18 + 2;
                    j8 = aVar.f10764c;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i11 = 3;
                    h segment3 = aVar.l(3);
                    int i19 = intRef.element;
                    Intrinsics.checkNotNullParameter(segment3, "segment");
                    int i20 = segment3.f10778c;
                    byte[] bArr3 = segment3.f10776a;
                    bArr3[i20] = (byte) ((i19 >> 12) | 224);
                    bArr3[i20 + 1] = (byte) (((i19 >> 6) & 63) | 128);
                    bArr3[i20 + 2] = (byte) ((i19 & 63) | 128);
                    segment3.f10778c = i20 + 3;
                    j8 = aVar.f10764c;
                } else {
                    int i21 = i12 + 1;
                    char cCharAt3 = i21 < length ? string.charAt(i21) : (char) 0;
                    int i22 = intRef.element;
                    if (i22 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        aVar.s((byte) 63);
                        i12 = i21;
                    } else {
                        int i23 = (((i22 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        h segment4 = aVar.l(4);
                        Intrinsics.checkNotNullParameter(segment4, "segment");
                        int i24 = segment4.f10778c;
                        byte[] bArr4 = segment4.f10776a;
                        bArr4[i24] = (byte) ((i23 >> 18) | 240);
                        bArr4[i24 + 1] = (byte) (((i23 >> 12) & 63) | 128);
                        bArr4[i24 + 2] = (byte) (((i23 >> 6) & 63) | 128);
                        bArr4[i24 + 3] = (byte) ((i23 & 63) | 128);
                        segment4.f10778c = i24 + 4;
                        aVar.f10764c += (long) 4;
                        i12 += 2;
                    }
                }
                aVar.f10764c = j8 + ((long) i11);
                i12++;
            }
        }
    }
}
