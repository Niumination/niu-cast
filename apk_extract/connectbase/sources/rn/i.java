package rn;

import java.io.Serializable;
import kn.r1;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nXorWowRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XorWowRandom.kt\nkotlin/random/XorWowRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class i extends f implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final a f14592b = new a();
    private static final long serialVersionUID = 0;
    private int addend;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f14593v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f14594w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f14595x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f14596y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f14597z;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public i(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f14595x = i10;
        this.f14596y = i11;
        this.f14597z = i12;
        this.f14594w = i13;
        this.f14593v = i14;
        this.addend = i15;
        if ((i10 | i11 | i12 | i13 | i14) == 0) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.");
        }
        for (int i16 = 0; i16 < 64; i16++) {
            nextInt();
        }
    }

    @Override // rn.f
    public int nextBits(int i10) {
        return g.j(nextInt(), i10);
    }

    @Override // rn.f
    public int nextInt() {
        int i10 = this.f14595x;
        int i11 = i10 ^ (i10 >>> 2);
        this.f14595x = this.f14596y;
        this.f14596y = this.f14597z;
        this.f14597z = this.f14594w;
        int i12 = this.f14593v;
        this.f14594w = i12;
        int i13 = ((i11 ^ (i11 << 1)) ^ i12) ^ (i12 << 4);
        this.f14593v = i13;
        int i14 = this.addend + 362437;
        this.addend = i14;
        return i13 + i14;
    }

    public i(int i10, int i11) {
        this(i10, i11, 0, 0, ~i10, (i10 << 10) ^ (i11 >>> 4));
    }
}
