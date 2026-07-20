package androidx.camera.view;

import android.graphics.SurfaceTexture;
import androidx.camera.core.SurfaceRequest;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1063c;

    public /* synthetic */ h(int i8, Object obj, Object obj2) {
        this.f1061a = i8;
        this.f1063c = obj;
        this.f1062b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1061a) {
            case 0:
                ((PreviewView.AnonymousClass1) this.f1063c).lambda$onSurfaceRequested$0((SurfaceRequest) this.f1062b);
                break;
            case 1:
                ((TextureViewImplementation) this.f1063c).lambda$onSurfaceRequested$0((SurfaceRequest) this.f1062b);
                break;
            default:
                TextureViewImplementation.AnonymousClass1.lambda$onSurfaceTextureUpdated$0((PreviewView.OnFrameUpdateListener) this.f1063c, (SurfaceTexture) this.f1062b);
                break;
        }
    }
}
