package tl;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {
    @lm.z0
    public static final void a(@os.l a aVar, int i10, @os.l jn.l<? super e, l2> lVar) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarI2 = aVar.i2(i10);
        if (bVarI2 == null) {
            throw pl.h.a(i10);
        }
        int i11 = bVarI2.f15821b.f15873b;
        try {
            lVar.invoke(bVarI2);
            m mVar = bVarI2.f15821b;
            int i12 = mVar.f15873b;
            if (i12 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i12 == mVar.f15874c) {
                aVar.E(bVarI2);
            } else {
                aVar.f15790b.f15800c = i12;
            }
        } catch (Throwable th2) {
            int i13 = bVarI2.f15821b.f15873b;
            if (i13 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i13 == bVarI2.f15821b.f15874c) {
                aVar.E(bVarI2);
            } else {
                aVar.f15790b.f15800c = i13;
            }
            throw th2;
        }
    }

    public static void b(a aVar, int i10, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        kn.l0.p(aVar, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarI2 = aVar.i2(i10);
        if (bVarI2 == null) {
            throw pl.h.a(i10);
        }
        int i12 = bVarI2.f15821b.f15873b;
        try {
            lVar.invoke(bVarI2);
            m mVar = bVarI2.f15821b;
            int i13 = mVar.f15873b;
            if (i13 < i12) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i13 == mVar.f15874c) {
                aVar.E(bVarI2);
            } else {
                aVar.f15790b.f15800c = i13;
            }
        } catch (Throwable th2) {
            int i14 = bVarI2.f15821b.f15873b;
            if (i14 < i12) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i14 == bVarI2.f15821b.f15874c) {
                aVar.E(bVarI2);
            } else {
                aVar.f15790b.f15800c = i14;
            }
            throw th2;
        }
    }
}
