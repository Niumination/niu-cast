package androidx.camera.view;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1052b;

    public /* synthetic */ c(Object obj, int i8) {
        this.f1051a = i8;
        this.f1052b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f1051a;
        Object obj = this.f1052b;
        switch (i8) {
            case 0:
                ((CameraController.AnonymousClass1) obj).lambda$accept$0();
                break;
            default:
                ((PreviewViewImplementation.OnSurfaceNotInUseListener) obj).onSurfaceNotInUse();
                break;
        }
    }
}
