package t;

import androidx.camera.core.impl.DeferrableSurface;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f10159b;

    public /* synthetic */ c(DeferrableSurface deferrableSurface, int i8) {
        this.f10158a = i8;
        this.f10159b = deferrableSurface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f10158a;
        DeferrableSurface deferrableSurface = this.f10159b;
        switch (i8) {
            case 0:
                deferrableSurface.close();
                break;
            default:
                deferrableSurface.decrementUseCount();
                break;
        }
    }
}
