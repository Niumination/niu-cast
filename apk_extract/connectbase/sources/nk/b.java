package nk;

import ik.r0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends s.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final byte[] f11507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final ik.i f11508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final r0 f11509d;

    public /* synthetic */ b(byte[] bArr, ik.i iVar, r0 r0Var, int i10, kn.w wVar) {
        this(bArr, (i10 & 2) != 0 ? null : iVar, (i10 & 4) != 0 ? null : r0Var);
    }

    @Override // nk.s
    @os.l
    public Long b() {
        return Long.valueOf(this.f11507b.length);
    }

    @Override // nk.s
    @os.m
    public ik.i c() {
        return this.f11508c;
    }

    @Override // nk.s
    @os.m
    public r0 g() {
        return this.f11509d;
    }

    @Override // nk.s.a
    @os.l
    public byte[] j() {
        return this.f11507b;
    }

    public b(@os.l byte[] bArr, @os.m ik.i iVar, @os.m r0 r0Var) {
        l0.p(bArr, "bytes");
        this.f11507b = bArr;
        this.f11508c = iVar;
        this.f11509d = r0Var;
    }
}
