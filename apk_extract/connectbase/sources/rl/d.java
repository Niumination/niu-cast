package rl;

import java.nio.ByteBuffer;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final int a(@l ByteBuffer byteBuffer, @l char[] cArr, int i10, int i11) {
        l0.p(byteBuffer, "<this>");
        l0.p(cArr, "out");
        return byteBuffer.hasArray() ? e(byteBuffer, cArr, i10, i11) : g(byteBuffer, cArr, i10, i11);
    }

    public static final int b(@l ByteBuffer byteBuffer, @l char[] cArr, int i10, int i11, @l jn.l<? super Character, Boolean> lVar) {
        int i12;
        int i13;
        l0.p(byteBuffer, "<this>");
        l0.p(cArr, "out");
        l0.p(lVar, "predicate");
        if (!byteBuffer.hasArray()) {
            int i14 = i11 + i10;
            boolean z10 = false;
            if (i14 <= cArr.length) {
                i12 = i10;
                while (byteBuffer.hasRemaining()) {
                    byte b10 = byteBuffer.get();
                    if (b10 >= 0 && i12 < i14) {
                        char c10 = (char) b10;
                        if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                            cArr[i12] = c10;
                            i12++;
                        }
                    }
                    z10 = true;
                }
            } else {
                i12 = i10;
            }
            if (z10) {
                byteBuffer.position(byteBuffer.position() - 1);
            }
            return i12 - i10;
        }
        int i15 = i11 + i10;
        byte[] bArrArray = byteBuffer.array();
        l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining() + iPosition;
        if (i15 > cArr.length || iRemaining > bArrArray.length) {
            i13 = i10;
        } else {
            i13 = i10;
            while (iPosition < iRemaining && i13 < i15) {
                byte b11 = bArrArray[iPosition];
                if (b11 < 0) {
                    break;
                }
                char c11 = (char) b11;
                if (!lVar.invoke(Character.valueOf(c11)).booleanValue()) {
                    iPosition--;
                    break;
                }
                cArr[i13] = c11;
                i13++;
                iPosition++;
            }
            byteBuffer.position(iPosition - byteBuffer.arrayOffset());
        }
        return i13 - i10;
    }

    public static /* synthetic */ int c(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        return a(byteBuffer, cArr, i10, i11);
    }

    public static /* synthetic */ int d(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, jn.l lVar, int i12, Object obj) {
        int i13;
        int i14;
        boolean z10 = false;
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        l0.p(byteBuffer, "<this>");
        l0.p(cArr, "out");
        l0.p(lVar, "predicate");
        if (!byteBuffer.hasArray()) {
            int i15 = i11 + i10;
            if (i15 <= cArr.length) {
                i13 = i10;
                while (byteBuffer.hasRemaining()) {
                    byte b10 = byteBuffer.get();
                    if (b10 >= 0 && i13 < i15) {
                        char c10 = (char) b10;
                        if (((Boolean) lVar.invoke(Character.valueOf(c10))).booleanValue()) {
                            cArr[i13] = c10;
                            i13++;
                        }
                    }
                    z10 = true;
                }
            } else {
                i13 = i10;
            }
            if (z10) {
                byteBuffer.position(byteBuffer.position() - 1);
            }
            return i13 - i10;
        }
        int i16 = i11 + i10;
        byte[] bArrArray = byteBuffer.array();
        l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining() + iPosition;
        if (i16 > cArr.length || iRemaining > bArrArray.length) {
            i14 = i10;
        } else {
            i14 = i10;
            while (iPosition < iRemaining && i14 < i16) {
                byte b11 = bArrArray[iPosition];
                if (b11 < 0) {
                    break;
                }
                char c11 = (char) b11;
                if (!((Boolean) lVar.invoke(Character.valueOf(c11))).booleanValue()) {
                    iPosition--;
                    break;
                }
                cArr[i14] = c11;
                i14++;
                iPosition++;
            }
            byteBuffer.position(iPosition - byteBuffer.arrayOffset());
        }
        return i14 - i10;
    }

    public static final int e(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) {
        int i12;
        int i13 = i11 + i10;
        byte[] bArrArray = byteBuffer.array();
        l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining() + iPosition;
        if (i13 > cArr.length || iRemaining > bArrArray.length) {
            i12 = i10;
        } else {
            i12 = i10;
            while (iPosition < iRemaining && i12 < i13) {
                byte b10 = bArrArray[iPosition];
                if (b10 < 0) {
                    break;
                }
                cArr[i12] = (char) b10;
                i12++;
                iPosition++;
            }
            byteBuffer.position(iPosition - byteBuffer.arrayOffset());
        }
        return i12 - i10;
    }

    public static final int f(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, jn.l<? super Character, Boolean> lVar) {
        int i12;
        int i13 = i11 + i10;
        byte[] bArrArray = byteBuffer.array();
        l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining() + iPosition;
        if (i13 > cArr.length || iRemaining > bArrArray.length) {
            i12 = i10;
        } else {
            i12 = i10;
            while (iPosition < iRemaining && i12 < i13) {
                byte b10 = bArrArray[iPosition];
                if (b10 < 0) {
                    break;
                }
                char c10 = (char) b10;
                if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                    iPosition--;
                    break;
                }
                cArr[i12] = c10;
                i12++;
                iPosition++;
            }
            byteBuffer.position(iPosition - byteBuffer.arrayOffset());
        }
        return i12 - i10;
    }

    public static final int g(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) {
        int i12;
        int i13 = i11 + i10;
        boolean z10 = false;
        if (i13 <= cArr.length) {
            i12 = i10;
            while (byteBuffer.hasRemaining()) {
                byte b10 = byteBuffer.get();
                if (b10 < 0 || i12 >= i13) {
                    z10 = true;
                    break;
                }
                cArr[i12] = (char) b10;
                i12++;
            }
        } else {
            i12 = i10;
        }
        if (z10) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i12 - i10;
    }

    public static final int h(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, jn.l<? super Character, Boolean> lVar) {
        int i12;
        int i13 = i11 + i10;
        boolean z10 = false;
        if (i13 <= cArr.length) {
            i12 = i10;
            while (byteBuffer.hasRemaining()) {
                byte b10 = byteBuffer.get();
                if (b10 >= 0 && i12 < i13) {
                    char c10 = (char) b10;
                    if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                        cArr[i12] = c10;
                        i12++;
                    }
                }
                z10 = true;
            }
        } else {
            i12 = i10;
        }
        if (z10) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i12 - i10;
    }
}
