package wl;

import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final int a(@os.l ByteBuffer byteBuffer, @os.l char[] cArr, int i10, int i11) {
        l0.p(byteBuffer, "<this>");
        l0.p(cArr, "out");
        return byteBuffer.hasArray() ? c(byteBuffer, cArr, i10, i11) : e(byteBuffer, cArr, i10, i11);
    }

    public static /* synthetic */ int b(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        return a(byteBuffer, cArr, i10, i11);
    }

    public static final int c(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) {
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

    public static final long d(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, jn.l<? super Character, Boolean> lVar) {
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
            while (iPosition < iRemaining) {
                byte b10 = bArrArray[iPosition];
                if (b10 < 0) {
                    break;
                }
                char c10 = (char) b10;
                if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                    return rl.g.a(byteBuffer, iPosition, i12, i10, -1);
                }
                if (i12 >= i13) {
                    break;
                }
                cArr[i12] = c10;
                i12++;
                iPosition++;
            }
            byteBuffer.position(iPosition - byteBuffer.arrayOffset());
        }
        return rl.h.j(i12 - i10, 0);
    }

    public static final int e(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) {
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

    /* JADX WARN: Code duplicated, block: B:20:0x0038  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    public static final long f(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, jn.l<? super Character, Boolean> lVar) {
        int i12;
        boolean z10;
        boolean z11;
        int i13 = i11 + i10;
        if (i13 <= cArr.length) {
            i12 = i10;
            while (true) {
                if (byteBuffer.hasRemaining()) {
                    byte b10 = byteBuffer.get();
                    if (b10 >= 0) {
                        char c10 = (char) b10;
                        if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                            z10 = true;
                            z11 = z10;
                        } else if (i12 < i13) {
                            cArr[i12] = c10;
                            i12++;
                        }
                    }
                    z10 = true;
                    z11 = false;
                }
                if (z10) {
                    byteBuffer.position(byteBuffer.position() - 1);
                }
                return rl.h.j(i12 - i10, z11 ? -1 : 0);
            }
        }
        i12 = i10;
        z10 = false;
        z11 = z10;
        if (z10) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return rl.h.j(i12 - i10, z11 ? -1 : 0);
    }

    public static final long g(@os.l ByteBuffer byteBuffer, @os.l char[] cArr, int i10, int i11) {
        l0.p(byteBuffer, "<this>");
        l0.p(cArr, "out");
        return byteBuffer.hasArray() ? i(byteBuffer, cArr, i10, i11) : j(byteBuffer, cArr, i10, i11);
    }

    public static /* synthetic */ long h(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        return g(byteBuffer, cArr, i10, i11);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0045 A[LOOP:0: B:7:0x0023->B:25:0x0045, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x007c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0081  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:47:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x004c A[SYNTHETIC] */
    public static final long i(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) {
        int i12;
        boolean z10;
        long j10;
        int i13;
        int i14;
        boolean z11;
        int i15 = i11 + i10;
        byte[] bArrArray = byteBuffer.array();
        l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining() + iPosition;
        if (i15 > cArr.length || iRemaining > bArrArray.length) {
            i12 = i10;
            z10 = false;
        } else {
            i12 = i10;
            z10 = false;
            while (true) {
                if (iPosition < iRemaining) {
                    byte b10 = bArrArray[iPosition];
                    if (b10 >= 0) {
                        char c10 = (char) b10;
                        if (c10 != '\r') {
                            if (c10 == '\n') {
                                z10 = false;
                            } else {
                                z11 = !z10;
                            }
                            if (!z11) {
                                j10 = rl.g.a(byteBuffer, iPosition, i12, i10, -1);
                            } else if (i12 >= i15) {
                                cArr[i12] = c10;
                                i12++;
                                iPosition++;
                            }
                            if (((int) (4294967295L & j10)) == -1) {
                                i13 = (int) (j10 >> 32);
                                if (z10) {
                                    return rl.h.j(i13 - 1, -1);
                                }
                                byteBuffer.position(byteBuffer.position() + 1);
                                if (i13 > 0) {
                                    i14 = i13 - 1;
                                    if (cArr[i14] == '\r') {
                                        return rl.h.j(i14, -1);
                                    }
                                }
                            } else if (z10) {
                                return rl.f.a(byteBuffer, 1, (int) (j10 >> 32), 1, 2);
                            }
                            return j10;
                        }
                        z10 = true;
                        z11 = z10;
                        if (!z11) {
                            j10 = rl.g.a(byteBuffer, iPosition, i12, i10, -1);
                        } else if (i12 >= i15) {
                            cArr[i12] = c10;
                            i12++;
                            iPosition++;
                        }
                        if (((int) (4294967295L & j10)) == -1) {
                            i13 = (int) (j10 >> 32);
                            if (z10) {
                                return rl.h.j(i13 - 1, -1);
                            }
                            byteBuffer.position(byteBuffer.position() + 1);
                            if (i13 > 0) {
                                i14 = i13 - 1;
                                if (cArr[i14] == '\r') {
                                    return rl.h.j(i14, -1);
                                }
                            }
                        } else if (z10) {
                            return rl.f.a(byteBuffer, 1, (int) (j10 >> 32), 1, 2);
                        }
                        return j10;
                    }
                }
                byteBuffer.position(iPosition - byteBuffer.arrayOffset());
            }
        }
        j10 = rl.h.j(i12 - i10, 0);
        if (((int) (4294967295L & j10)) == -1) {
            i13 = (int) (j10 >> 32);
            if (z10) {
                return rl.h.j(i13 - 1, -1);
            }
            byteBuffer.position(byteBuffer.position() + 1);
            if (i13 > 0) {
                i14 = i13 - 1;
                if (cArr[i14] == '\r') {
                    return rl.h.j(i14, -1);
                }
            }
        } else if (z10) {
            return rl.f.a(byteBuffer, 1, (int) (j10 >> 32), 1, 2);
        }
        return j10;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x002f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032 A[LOOP:0: B:5:0x000a->B:25:0x0032, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x002c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0016 A[SYNTHETIC] */
    public static final long j(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i12 = i11 + i10;
        int i13 = i10;
        if (i12 <= cArr.length) {
            z11 = false;
            while (true) {
                if (byteBuffer.hasRemaining()) {
                    byte b10 = byteBuffer.get();
                    if (b10 >= 0) {
                        char c10 = (char) b10;
                        if (c10 == '\r') {
                            z11 = true;
                        } else {
                            if (c10 == '\n') {
                                z11 = false;
                            } else {
                                z13 = !z11;
                            }
                            if (!z13) {
                                z10 = true;
                            } else if (i13 >= i12) {
                                cArr[i13] = c10;
                                i13++;
                            }
                        }
                        z13 = z11;
                        if (!z13) {
                            z10 = true;
                        } else if (i13 >= i12) {
                            cArr[i13] = c10;
                            i13++;
                        }
                    }
                    z10 = true;
                    z12 = false;
                } else {
                    z10 = false;
                }
                z12 = z10;
            }
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
        }
        if (z10) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        long j10 = rl.h.j(i13 - i10, z12 ? -1 : 0);
        if (((int) (4294967295L & j10)) == -1) {
            int i14 = (int) (j10 >> 32);
            if (z11) {
                return rl.h.j(i14 - 1, -1);
            }
            byteBuffer.position(byteBuffer.position() + 1);
            if (i14 > 0) {
                int i15 = i14 - 1;
                if (cArr[i15] == '\r') {
                    return rl.h.j(i15, -1);
                }
            }
        } else if (z11) {
            return rl.f.a(byteBuffer, 1, (int) (j10 >> 32), 1, 2);
        }
        return j10;
    }
}
