package ze;

import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes3.dex */
public final class p2 implements o1, l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f11401b = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11402a;

    public /* synthetic */ p2(int i8) {
        this.f11402a = i8;
    }

    @Override // ze.l1
    public String a(Object obj) {
        return (String) obj;
    }

    public int b(Object obj) {
        switch (this.f11402a) {
            case 3:
                return ((c1) obj).b();
            case 4:
                return ((h1) obj).c();
            case 5:
            default:
                return ((i2) obj).c();
            case 6:
                return ((u1) obj).c();
        }
    }

    @Override // ze.l1
    public Object c(String str) {
        return str;
    }

    @Override // ze.o1
    public Object d(byte[] bArr) {
        int i8;
        byte b9;
        switch (this.f11402a) {
            case 0:
                for (int i9 = 0; i9 < bArr.length; i9++) {
                    byte b10 = bArr[i9];
                    if (b10 < 32 || b10 >= 126 || (b10 == 37 && i9 + 2 < bArr.length)) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
                        int i10 = 0;
                        while (i10 < bArr.length) {
                            if (bArr[i10] == 37 && i10 + 2 < bArr.length) {
                                try {
                                    byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i10 + 1, 2, h4.f.f5247a), 16));
                                    i10 += 3;
                                } catch (NumberFormatException unused) {
                                    byteBufferAllocate.put(bArr[i10]);
                                    i10++;
                                }
                            }
                            byteBufferAllocate.put(bArr[i10]);
                            i10++;
                        }
                        return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), h4.f.f5248b);
                    }
                }
                return new String(bArr, 0);
            default:
                char c9 = 0;
                if (bArr.length == 1 && bArr[0] == 48) {
                    return q2.e;
                }
                int length = bArr.length;
                if (length != 1) {
                    if (length == 2 && (b9 = bArr[0]) >= 48 && b9 <= 57) {
                        i8 = (b9 - 48) * 10;
                        c9 = 1;
                    }
                    return q2.f11404g.h("Unknown code ".concat(new String(bArr, h4.f.f5247a)));
                }
                i8 = 0;
                byte b11 = bArr[c9];
                if (b11 >= 48 && b11 <= 57) {
                    int i11 = (b11 - 48) + i8;
                    List list = q2.f11403d;
                    if (i11 < list.size()) {
                        return (q2) list.get(i11);
                    }
                }
                return q2.f11404g.h("Unknown code ".concat(new String(bArr, h4.f.f5247a)));
        }
    }

    public p2(SSLSession sSLSession) {
        this.f11402a = 2;
        sSLSession.getCipherSuite();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            Certificate certificate = localCertificates[0];
        }
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            if (peerCertificates != null) {
                Certificate certificate2 = peerCertificates[0];
            }
        } catch (SSLPeerUnverifiedException e) {
            o0.f.log(Level.FINE, "Peer cert not available for peerHost=" + sSLSession.getPeerHost(), (Throwable) e);
        }
    }

    @Override // ze.o1
    /* JADX INFO: renamed from: a */
    public byte[] mo1a(Object obj) {
        switch (this.f11402a) {
            case 0:
                byte[] bytes = ((String) obj).getBytes(h4.f.f5248b);
                int i8 = 0;
                while (i8 < bytes.length) {
                    byte b9 = bytes[i8];
                    if (b9 < 32 || b9 >= 126 || b9 == 37) {
                        byte[] bArr = new byte[((bytes.length - i8) * 3) + i8];
                        if (i8 != 0) {
                            System.arraycopy(bytes, 0, bArr, 0, i8);
                        }
                        int i9 = i8;
                        while (i8 < bytes.length) {
                            byte b10 = bytes[i8];
                            if (b10 < 32 || b10 >= 126 || b10 == 37) {
                                bArr[i9] = 37;
                                byte[] bArr2 = f11401b;
                                bArr[i9 + 1] = bArr2[(b10 >> 4) & 15];
                                bArr[i9 + 2] = bArr2[b10 & 15];
                                i9 += 3;
                            } else {
                                bArr[i9] = b10;
                                i9++;
                            }
                            i8++;
                        }
                        return Arrays.copyOf(bArr, i9);
                    }
                    i8++;
                }
                return bytes;
            default:
                return ((q2) obj).f11413a.valueAscii();
        }
    }
}
