package rn;

import java.util.Random;
import kn.l0;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nPlatformRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformRandom.kt\nkotlin/random/AbstractPlatformRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
public abstract class a extends f {
    @l
    public abstract Random getImpl();

    @Override // rn.f
    public int nextBits(int i10) {
        return g.j(getImpl().nextInt(), i10);
    }

    @Override // rn.f
    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    @Override // rn.f
    @l
    public byte[] nextBytes(@l byte[] bArr) {
        l0.p(bArr, dc.d.f3685p);
        getImpl().nextBytes(bArr);
        return bArr;
    }

    @Override // rn.f
    public double nextDouble() {
        return getImpl().nextDouble();
    }

    @Override // rn.f
    public float nextFloat() {
        return getImpl().nextFloat();
    }

    @Override // rn.f
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // rn.f
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // rn.f
    public int nextInt(int i10) {
        return getImpl().nextInt(i10);
    }
}
