package tl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final int a(@os.l e eVar, @os.l e eVar2, int i10) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(eVar2, "other");
        m mVar = eVar2.f15821b;
        int iMin = Math.min(mVar.f15874c - mVar.f15873b, i10);
        m mVar2 = eVar.f15821b;
        if (mVar2.f15872a - mVar2.f15874c <= iMin) {
            b(eVar, iMin);
        }
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar3 = eVar.f15821b;
        int i11 = mVar3.f15874c;
        int i12 = mVar3.f15872a;
        ByteBuffer byteBuffer2 = eVar2.f15820a;
        m mVar4 = eVar2.f15821b;
        int i13 = mVar4.f15873b;
        int i14 = mVar4.f15874c;
        ql.f.d(byteBuffer2, byteBuffer, i13, iMin, i11);
        eVar2.h(iMin);
        eVar.b(iMin);
        return iMin;
    }

    public static final void b(e eVar, int i10) {
        m mVar = eVar.f15821b;
        int i11 = mVar.f15872a;
        int i12 = mVar.f15874c;
        if ((eVar.f15822c - i11) + (i11 - i12) < i10) {
            throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
        }
        if ((i12 + i10) - i11 > 0) {
            eVar.j0();
        }
    }

    public static final int c(@os.l e eVar, @os.l e eVar2) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(eVar2, "other");
        m mVar = eVar2.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15873b;
        int i12 = i10 - i11;
        int i13 = eVar.f15821b.f15873b;
        if (i13 < i12) {
            throw new IllegalArgumentException("Not enough space in the beginning to prepend bytes");
        }
        int i14 = i13 - i12;
        ql.f.d(eVar2.f15820a, eVar.f15820a, i11, i12, i14);
        eVar2.h(i12);
        eVar.l0(i14);
        return i12;
    }
}
