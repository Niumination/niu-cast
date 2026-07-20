package af;

/* JADX INFO: loaded from: classes3.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f181c;

    public b2(int i8) {
        switch (i8) {
            case 2:
                this.f181c = new b2[256];
                this.f179a = 0;
                this.f180b = 0;
                break;
            default:
                this.f181c = new b2[256];
                this.f179a = 0;
                this.f180b = 0;
                break;
        }
    }

    public void a() {
        this.f179a = 0;
        this.f180b = 0;
    }

    public b2(int i8, int i9, int i10) {
        switch (i10) {
            case 2:
                this.f181c = null;
                this.f179a = i8;
                int i11 = i9 & 7;
                this.f180b = i11 == 0 ? 8 : i11;
                break;
            default:
                this.f181c = null;
                this.f179a = i8;
                int i12 = i9 & 7;
                this.f180b = i12 == 0 ? 8 : i12;
                break;
        }
    }
}
