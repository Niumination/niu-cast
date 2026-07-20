package rn;

import java.util.Random;
import kn.l0;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends Random {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f14589a = new a();
    private static final long serialVersionUID = 0;

    @l
    private final f impl;
    private boolean seedInitialized;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public c(@l f fVar) {
        l0.p(fVar, "impl");
        this.impl = fVar;
    }

    @l
    public final f getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    public int next(int i10) {
        return this.impl.nextBits(i10);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(@l byte[] bArr) {
        l0.p(bArr, "bytes");
        this.impl.nextBytes(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j10) {
        if (this.seedInitialized) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.seedInitialized = true;
    }

    @Override // java.util.Random
    public int nextInt(int i10) {
        return this.impl.nextInt(i10);
    }
}
