package l;

import android.view.View;
import androidx.camera.camera2.interop.Camera2CameraControl;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7078c;

    public /* synthetic */ c(Object obj, boolean z2, int i8) {
        this.f7076a = i8;
        this.f7078c = obj;
        this.f7077b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7076a) {
            case 0:
                ((Camera2CameraControl) this.f7078c).lambda$setActive$7(this.f7077b);
                break;
            default:
                ViewUtils.showKeyboard((View) this.f7078c, this.f7077b);
                break;
        }
    }
}
