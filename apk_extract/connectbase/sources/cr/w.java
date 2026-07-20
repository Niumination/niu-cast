package cr;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3484h = 8192;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3485i = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f3491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w f3492g;

    public w() {
        this.f3486a = new byte[8192];
        this.f3490e = true;
        this.f3489d = false;
    }

    public final void a() {
        w wVar = this.f3492g;
        if (wVar == this) {
            throw new IllegalStateException();
        }
        if (wVar.f3490e) {
            int i10 = this.f3488c - this.f3487b;
            if (i10 > (8192 - wVar.f3488c) + (wVar.f3489d ? 0 : wVar.f3487b)) {
                return;
            }
            g(wVar, i10);
            b();
            x.a(this);
        }
    }

    @gm.j
    public final w b() {
        w wVar = this.f3491f;
        w wVar2 = wVar != this ? wVar : null;
        w wVar3 = this.f3492g;
        wVar3.f3491f = wVar;
        this.f3491f.f3492g = wVar3;
        this.f3491f = null;
        this.f3492g = null;
        return wVar2;
    }

    public final w c(w wVar) {
        wVar.f3492g = this;
        wVar.f3491f = this.f3491f;
        this.f3491f.f3492g = wVar;
        this.f3491f = wVar;
        return wVar;
    }

    public final w d() {
        this.f3489d = true;
        return new w(this.f3486a, this.f3487b, this.f3488c, true, false);
    }

    public final w e(int i10) {
        w wVarB;
        if (i10 <= 0 || i10 > this.f3488c - this.f3487b) {
            throw new IllegalArgumentException();
        }
        if (i10 >= 1024) {
            wVarB = d();
        } else {
            wVarB = x.b();
            System.arraycopy(this.f3486a, this.f3487b, wVarB.f3486a, 0, i10);
        }
        wVarB.f3488c = wVarB.f3487b + i10;
        this.f3487b += i10;
        this.f3492g.c(wVarB);
        return wVarB;
    }

    public final w f() {
        return new w((byte[]) this.f3486a.clone(), this.f3487b, this.f3488c, false, true);
    }

    public final void g(w wVar, int i10) {
        if (!wVar.f3490e) {
            throw new IllegalArgumentException();
        }
        int i11 = wVar.f3488c;
        if (i11 + i10 > 8192) {
            if (wVar.f3489d) {
                throw new IllegalArgumentException();
            }
            int i12 = wVar.f3487b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = wVar.f3486a;
            System.arraycopy(bArr, i12, bArr, 0, i11 - i12);
            wVar.f3488c -= wVar.f3487b;
            wVar.f3487b = 0;
        }
        System.arraycopy(this.f3486a, this.f3487b, wVar.f3486a, wVar.f3488c, i10);
        wVar.f3488c += i10;
        this.f3487b += i10;
    }

    public w(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        this.f3486a = bArr;
        this.f3487b = i10;
        this.f3488c = i11;
        this.f3489d = z10;
        this.f3490e = z11;
    }
}
