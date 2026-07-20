package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FocusMeteringControl f929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f930c;

    public /* synthetic */ v(int i8, long j8, FocusMeteringControl focusMeteringControl) {
        this.f928a = i8;
        this.f929b = focusMeteringControl;
        this.f930c = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f928a) {
            case 0:
                this.f929b.lambda$executeMeteringAction$4(this.f930c);
                break;
            case 1:
                this.f929b.lambda$executeMeteringAction$6(this.f930c);
                break;
            case 2:
                this.f929b.lambda$executeMeteringAction$5(this.f930c);
                break;
            default:
                this.f929b.lambda$executeMeteringAction$3(this.f930c);
                break;
        }
    }
}
