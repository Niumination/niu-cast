package pf;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends cg.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zf.i f8849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8851c;

    public j(zf.i iVar, Object obj) {
        this.f8851c = obj;
        if (iVar == null) {
            zf.i iVar2 = zf.f.f11498a;
            iVar = zf.f.f11498a;
        }
        this.f8849a = iVar;
        this.f8850b = ((byte[]) obj).length;
    }

    @Override // cg.j
    public final Long a() {
        return Long.valueOf(this.f8850b);
    }

    @Override // cg.j
    public final zf.i b() {
        return this.f8849a;
    }

    @Override // cg.f
    public final byte[] e() {
        return (byte[]) this.f8851c;
    }
}
