package wl;

import java.nio.ByteBuffer;
import jq.d0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final int a(@os.l String str, int i10) {
        String property;
        Integer numX0;
        l0.p(str, "name");
        try {
            property = System.getProperty(l0.C("io.ktor.utils.io.", str));
        } catch (SecurityException unused) {
            property = null;
        }
        return (property == null || (numX0 = d0.X0(property)) == null) ? i10 : numX0.intValue();
    }

    public static final int b(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2) {
        l0.p(byteBuffer, "<this>");
        l0.p(byteBuffer2, "sub");
        int iPosition = byteBuffer2.position();
        int iRemaining = byteBuffer2.remaining();
        byte b10 = byteBuffer2.get(iPosition);
        int iLimit = byteBuffer.limit();
        int iPosition2 = byteBuffer.position();
        while (iPosition2 < iLimit) {
            int i10 = iPosition2 + 1;
            if (byteBuffer.get(iPosition2) == b10) {
                int i11 = 1;
                while (true) {
                    if (i11 < iRemaining) {
                        int i12 = i11 + 1;
                        int i13 = iPosition2 + i11;
                        if (i13 != iLimit) {
                            if (byteBuffer.get(i13) != byteBuffer2.get(i11 + iPosition)) {
                                break;
                            }
                            i11 = i12;
                        }
                    }
                    return iPosition2 - byteBuffer.position();
                }
            }
            iPosition2 = i10;
        }
        return -1;
    }

    public static final boolean c(@os.l ByteBuffer byteBuffer) {
        l0.p(byteBuffer, "<this>");
        return !byteBuffer.hasRemaining();
    }

    public static final int d(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, int i10) {
        l0.p(byteBuffer, "<this>");
        l0.p(byteBuffer2, "src");
        int iRemaining = byteBuffer.remaining();
        int iRemaining2 = byteBuffer2.remaining();
        if (iRemaining2 > iRemaining || iRemaining2 > i10) {
            iRemaining2 = Math.min(iRemaining, Math.min(iRemaining2, i10));
            int i11 = 1;
            if (1 <= iRemaining2) {
                while (true) {
                    int i12 = i11 + 1;
                    byteBuffer.put(byteBuffer2.get());
                    if (i11 == iRemaining2) {
                        break;
                    }
                    i11 = i12;
                }
            }
        } else {
            byteBuffer.put(byteBuffer2);
        }
        return iRemaining2;
    }

    public static /* synthetic */ int e(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = byteBuffer2.remaining();
        }
        return d(byteBuffer, byteBuffer2, i10);
    }

    public static final int f(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, int i10) {
        l0.p(byteBuffer, "<this>");
        l0.p(byteBuffer2, "src");
        return d(byteBuffer, byteBuffer2, i10 - byteBuffer2.position());
    }

    public static /* synthetic */ int g(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = byteBuffer.limit();
        }
        return f(byteBuffer, byteBuffer2, i10);
    }

    public static final boolean h(@os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, int i10) {
        l0.p(byteBuffer, "<this>");
        l0.p(byteBuffer2, "prefix");
        int iMin = Math.min(byteBuffer.remaining(), byteBuffer2.remaining() - i10);
        if (iMin <= 0) {
            return false;
        }
        int iPosition = byteBuffer.position();
        int iPosition2 = byteBuffer2.position() + i10;
        int i11 = 0;
        while (i11 < iMin) {
            int i12 = i11 + 1;
            if (byteBuffer.get(iPosition + i11) != byteBuffer2.get(i11 + iPosition2)) {
                return false;
            }
            i11 = i12;
        }
        return true;
    }

    public static /* synthetic */ boolean i(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return h(byteBuffer, byteBuffer2, i10);
    }
}
