package androidx.camera.camera2.internal;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f880c;

    public /* synthetic */ f(Camera2CameraImpl camera2CameraImpl, ArrayList arrayList, int i8) {
        this.f878a = i8;
        this.f879b = camera2CameraImpl;
        this.f880c = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f878a) {
            case 0:
                this.f879b.lambda$detachUseCases$12(this.f880c);
                break;
            default:
                this.f879b.lambda$attachUseCases$11(this.f880c);
                break;
        }
    }
}
