package tl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {
    public static final int a(ByteBuffer byteBuffer, jn.l<? super Byte, Boolean> lVar, int i10, byte[] bArr, int i11, int i12) {
        int i13;
        byte[] bArrArray = byteBuffer.array();
        kn.l0.m(bArrArray);
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position() + i10;
        int iMin = Math.min(i12, byteBuffer.remaining()) + iArrayOffset;
        if (iMin <= bArrArray.length) {
            i13 = iArrayOffset;
            while (i13 < iMin && !lVar.invoke(Byte.valueOf(bArrArray[i13])).booleanValue()) {
                i13++;
            }
        } else {
            i13 = iArrayOffset;
        }
        int i14 = i13 - iArrayOffset;
        System.arraycopy(bArrArray, iArrayOffset, bArr, i11, i14);
        return i14;
    }

    public static final int b(e eVar, jn.l<? super Byte, Boolean> lVar, q0 q0Var) {
        int i10;
        ByteBuffer byteBuffer = eVar.f15820a;
        byte[] bArrArray = byteBuffer.array();
        kn.l0.m(bArrArray);
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position() + eVar.f15821b.f15873b;
        int iArrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.position() + eVar.f15821b.f15874c;
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        int i11 = 0;
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) + iArrayOffset, iArrayOffset2);
                if (iMin <= bArrArray.length) {
                    i10 = iArrayOffset;
                    while (i10 < iMin && !lVar.invoke(Byte.valueOf(bArrArray[i10])).booleanValue()) {
                        i10++;
                    }
                } else {
                    i10 = iArrayOffset;
                }
                int i12 = i10 - iArrayOffset;
                l.x0(bVarO, bArrArray, iArrayOffset, i12);
                i11 += i12;
                m mVar2 = bVarO.f15821b;
                if (mVar2.f15872a > mVar2.f15874c || i10 >= iArrayOffset2) {
                    break;
                    break;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
                iArrayOffset = i10;
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
        ul.k.b(q0Var, bVarO);
        eVar.n(i10);
        return i11;
    }

    @lm.k(message = "Rewrite to Memory.copyTo")
    public static final int c(ByteBuffer byteBuffer, jn.l<? super Byte, Boolean> lVar, byte[] bArr, int i10, int i11) {
        int iPosition = byteBuffer.position();
        int i12 = i11 + iPosition;
        int i13 = iPosition;
        while (i13 < byteBuffer.limit() && i13 < i12 && !lVar.invoke(Byte.valueOf(byteBuffer.get(i13))).booleanValue()) {
            i13++;
        }
        int i14 = i13 - iPosition;
        byteBuffer.get(bArr, i10, i14);
        return i14;
    }

    public static final int d(@os.l e eVar, byte b10) {
        kn.l0.p(eVar, "<this>");
        return p.e(eVar) ? e(eVar, b10) : a1.d(eVar, b10);
    }

    public static final int e(e eVar, byte b10) {
        int i10;
        ByteBuffer byteBuffer = eVar.f15820a;
        byte[] bArrArray = byteBuffer.array();
        kn.l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        m mVar = eVar.f15821b;
        int i11 = mVar.f15873b;
        int i12 = iPosition + i11;
        int i13 = (mVar.f15874c - i11) + i12;
        if (i13 <= bArrArray.length) {
            i10 = i12;
            while (i10 < i13 && bArrArray[i10] != b10) {
                i10++;
            }
        } else {
            i10 = i12;
        }
        eVar.n(i10);
        return i10 - i12;
    }

    public static final int f(@os.l e eVar, byte b10, byte b11) {
        kn.l0.p(eVar, "<this>");
        return p.e(eVar) ? g(eVar, b10, b11) : a1.f(eVar, b10, b11);
    }

    public static final int g(e eVar, byte b10, byte b11) {
        int i10;
        ByteBuffer byteBuffer = eVar.f15820a;
        byte[] bArrArray = byteBuffer.array();
        kn.l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        m mVar = eVar.f15821b;
        int i11 = mVar.f15873b;
        int i12 = iPosition + i11;
        int i13 = (mVar.f15874c - i11) + i12;
        if (i13 <= bArrArray.length) {
            i10 = i12;
            while (i10 < i13) {
                byte b12 = bArrArray[i10];
                if (b12 == b10 || b12 == b11) {
                    break;
                }
                i10++;
            }
        } else {
            i10 = i12;
        }
        eVar.n(i10);
        return i10 - i12;
    }

    public static final int h(@os.l e eVar, byte b10, @os.l q0 q0Var) {
        int i10;
        kn.l0.p(eVar, "<this>");
        kn.l0.p(q0Var, "dst");
        ByteBuffer byteBuffer = eVar.f15820a;
        byte[] bArrArray = byteBuffer.array();
        kn.l0.m(bArrArray);
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position() + eVar.f15821b.f15873b;
        int iArrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.position() + eVar.f15821b.f15874c;
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        int i11 = 0;
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) + iArrayOffset, iArrayOffset2);
                if (iMin <= bArrArray.length) {
                    i10 = iArrayOffset;
                    while (i10 < iMin && bArrArray[i10] != b10) {
                        i10++;
                    }
                } else {
                    i10 = iArrayOffset;
                }
                int i12 = i10 - iArrayOffset;
                l.x0(bVarO, bArrArray, iArrayOffset, i12);
                i11 += i12;
                m mVar2 = bVarO.f15821b;
                if (mVar2.f15872a > mVar2.f15874c || i10 >= iArrayOffset2) {
                    break;
                    break;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
                iArrayOffset = i10;
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
        ul.k.b(q0Var, bVarO);
        eVar.n(i10);
        return i11;
    }

    public static final int i(e eVar, byte b10, byte[] bArr, int i10, int i11) {
        int i12;
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i13 = mVar.f15873b;
        int iMin = Math.min(i11, mVar.f15874c - i13);
        byte[] bArrArray = byteBuffer.array();
        kn.l0.m(bArrArray);
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position() + i13;
        int iMin2 = Math.min(iMin, byteBuffer.remaining()) + iArrayOffset;
        if (iMin2 <= bArrArray.length) {
            i12 = iArrayOffset;
            while (i12 < iMin2 && bArrArray[i12] != b10) {
                i12++;
            }
        } else {
            i12 = iArrayOffset;
        }
        int i14 = i12 - iArrayOffset;
        System.arraycopy(bArrArray, iArrayOffset, bArr, i10, i14);
        eVar.h(i14);
        return i14;
    }

    public static final int j(@os.l e eVar, byte b10, @os.l q0 q0Var) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(q0Var, "dst");
        m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        ByteBuffer byteBuffer = eVar.f15820a;
        while (i10 != i11 && byteBuffer.get(i10) != b10) {
            i10++;
        }
        int i12 = i10 - eVar.f15821b.f15873b;
        s0.h(q0Var, eVar, i12);
        return i12;
    }

    public static final int k(e eVar, byte b10, byte[] bArr, int i10, int i11) {
        m mVar = eVar.f15821b;
        int i12 = mVar.f15873b;
        int iMin = Math.min(mVar.f15874c, i11 + i12);
        ByteBuffer byteBuffer = eVar.f15820a;
        int i13 = i12;
        while (i13 < iMin) {
            int i14 = i13 + 1;
            if (byteBuffer.get(i13) == b10) {
                iMin = i13;
                break;
            }
            i13 = i14;
        }
        int i15 = iMin - i12;
        ql.i.a(byteBuffer, bArr, i12, i15, i10);
        eVar.h(i15);
        return i15;
    }

    public static final int l(@os.l e eVar, byte b10, @os.l q0 q0Var) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(q0Var, "dst");
        return p.e(eVar) ? h(eVar, b10, q0Var) : j(eVar, b10, q0Var);
    }

    public static final int m(@os.l e eVar, byte b10, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(bArr, "dst");
        int length = bArr.length;
        return p.e(eVar) ? i(eVar, b10, bArr, i10, i11) : k(eVar, b10, bArr, i10, i11);
    }

    public static final int n(@os.l e eVar, byte b10, byte b11, @os.l q0 q0Var) {
        int i10;
        kn.l0.p(eVar, "<this>");
        kn.l0.p(q0Var, "dst");
        ByteBuffer byteBuffer = eVar.f15820a;
        byte[] bArrArray = byteBuffer.array();
        kn.l0.m(bArrArray);
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position() + eVar.f15821b.f15873b;
        int iArrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.position() + eVar.f15821b.f15874c;
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        int i11 = 0;
        while (true) {
            try {
                m mVar = bVarO.f15821b;
                int iMin = Math.min((mVar.f15872a - mVar.f15874c) + iArrayOffset, iArrayOffset2);
                if (iMin <= bArrArray.length) {
                    i10 = iArrayOffset;
                    while (i10 < iMin) {
                        byte b12 = bArrArray[i10];
                        if (b12 == b10 || b12 == b11) {
                            break;
                            break;
                        }
                        i10++;
                    }
                } else {
                    i10 = iArrayOffset;
                }
                int i12 = i10 - iArrayOffset;
                l.x0(bVarO, bArrArray, iArrayOffset, i12);
                i11 += i12;
                m mVar2 = bVarO.f15821b;
                if (mVar2.f15872a > mVar2.f15874c || i10 >= iArrayOffset2) {
                    break;
                    break;
                }
                bVarO = ul.k.o(q0Var, 1, bVarO);
                iArrayOffset = i10;
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
        ul.k.b(q0Var, bVarO);
        eVar.n(i10);
        return i11;
    }

    public static final int o(e eVar, byte b10, byte b11, byte[] bArr, int i10, int i11) {
        int i12;
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i13 = mVar.f15873b;
        int iMin = Math.min(i11, mVar.f15874c - i13);
        byte[] bArrArray = byteBuffer.array();
        kn.l0.m(bArrArray);
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position() + i13;
        int iMin2 = Math.min(iMin, byteBuffer.remaining()) + iArrayOffset;
        if (iMin2 <= bArrArray.length) {
            i12 = iArrayOffset;
            while (i12 < iMin2) {
                byte b12 = bArrArray[i12];
                if (b12 == b10 || b12 == b11) {
                    break;
                }
                i12++;
            }
        } else {
            i12 = iArrayOffset;
        }
        int i14 = i12 - iArrayOffset;
        System.arraycopy(bArrArray, iArrayOffset, bArr, i10, i14);
        eVar.h(i14);
        return i14;
    }

    public static final int p(@os.l e eVar, byte b10, byte b11, @os.l q0 q0Var) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(q0Var, "dst");
        m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        ByteBuffer byteBuffer = eVar.f15820a;
        while (i10 != i11) {
            byte b12 = byteBuffer.get(i10);
            if (b12 == b10 || b12 == b11) {
                break;
            }
            i10++;
        }
        int i12 = i10 - eVar.f15821b.f15873b;
        s0.h(q0Var, eVar, i12);
        return i12;
    }

    public static final int q(e eVar, byte b10, byte b11, byte[] bArr, int i10, int i11) {
        m mVar = eVar.f15821b;
        int i12 = mVar.f15873b;
        int iMin = Math.min(mVar.f15874c, i11 + i12);
        ByteBuffer byteBuffer = eVar.f15820a;
        int i13 = i12;
        while (i13 < iMin) {
            int i14 = i13 + 1;
            byte b12 = byteBuffer.get(i13);
            if (b12 == b10 || b12 == b11) {
                iMin = i13;
                break;
            }
            i13 = i14;
        }
        int i15 = iMin - i12;
        ql.i.a(byteBuffer, bArr, i12, i15, i10);
        eVar.h(i15);
        return i15;
    }

    public static final int r(@os.l e eVar, byte b10, byte b11, @os.l q0 q0Var) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(q0Var, "dst");
        return p.e(eVar) ? n(eVar, b10, b11, q0Var) : p(eVar, b10, b11, q0Var);
    }

    public static final int s(@os.l e eVar, byte b10, byte b11, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(bArr, "dst");
        int length = bArr.length;
        return p.e(eVar) ? o(eVar, b10, b11, bArr, i10, i11) : q(eVar, b10, b11, bArr, i10, i11);
    }
}
