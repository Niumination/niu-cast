package k3;

/* JADX INFO: loaded from: classes.dex */
public final class a1 implements q4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6348b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6349c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q4.c f6350d;
    public final q4.e e;

    public /* synthetic */ a1(q4.e eVar, int i8) {
        this.f6347a = i8;
        this.e = eVar;
    }

    @Override // q4.g
    public final q4.g c(String str) {
        switch (this.f6347a) {
            case 0:
                if (this.f6348b) {
                    throw new q4.b("Cannot encode a second value in the ValueEncoderContext");
                }
                this.f6348b = true;
                ((z0) this.e).c(this.f6350d, str, this.f6349c);
                return this;
            default:
                if (this.f6348b) {
                    throw new q4.b("Cannot encode a second value in the ValueEncoderContext");
                }
                this.f6348b = true;
                ((m3.h) this.e).c(this.f6350d, str, this.f6349c);
                return this;
        }
    }

    @Override // q4.g
    public final q4.g d(boolean z2) {
        switch (this.f6347a) {
            case 0:
                if (this.f6348b) {
                    throw new q4.b("Cannot encode a second value in the ValueEncoderContext");
                }
                this.f6348b = true;
                ((z0) this.e).d(this.f6350d, z2 ? 1 : 0, this.f6349c);
                return this;
            default:
                if (this.f6348b) {
                    throw new q4.b("Cannot encode a second value in the ValueEncoderContext");
                }
                this.f6348b = true;
                ((m3.h) this.e).d(this.f6350d, z2 ? 1 : 0, this.f6349c);
                return this;
        }
    }
}
