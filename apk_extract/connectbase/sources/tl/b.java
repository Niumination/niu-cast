package tl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public ul.b f15798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public ByteBuffer f15799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f15802e;

    public b(@os.l ul.b bVar, long j10) {
        kn.l0.p(bVar, "head");
        this.f15798a = bVar;
        this.f15799b = bVar.f15820a;
        m mVar = bVar.f15821b;
        int i10 = mVar.f15873b;
        this.f15800c = i10;
        int i11 = mVar.f15874c;
        this.f15801d = i11;
        this.f15802e = j10 - ((long) (i11 - i10));
    }

    @os.l
    public final ul.b a() {
        return this.f15798a;
    }

    public final int b() {
        return this.f15801d;
    }

    @os.l
    public final ByteBuffer c() {
        return this.f15799b;
    }

    public final int d() {
        return this.f15800c;
    }

    public final long e() {
        return this.f15802e;
    }

    public final void f(@os.l ul.b bVar) {
        kn.l0.p(bVar, "<set-?>");
        this.f15798a = bVar;
    }

    public final void g(int i10) {
        this.f15801d = i10;
    }

    public final void h(@os.l ByteBuffer byteBuffer) {
        kn.l0.p(byteBuffer, "<set-?>");
        this.f15799b = byteBuffer;
    }

    public final void i(int i10) {
        this.f15800c = i10;
    }

    public final void j(long j10) {
        this.f15802e = j10;
    }
}
