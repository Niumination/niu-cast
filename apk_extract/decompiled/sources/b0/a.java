package b0;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraX;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraController;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1171b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f1170a = i8;
        this.f1171b = obj;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        switch (this.f1170a) {
            case 0:
                return ((CameraController) this.f1171b).enableTorch(((Boolean) obj).booleanValue());
            case 1:
                return ((CameraController) this.f1171b).setLinearZoom(((Float) obj).floatValue());
            case 2:
                return ((CameraController) this.f1171b).setZoomRatio(((Float) obj).floatValue());
            default:
                return ProcessCameraProvider.lambda$getInstance$0((Context) this.f1171b, (CameraX) obj);
        }
    }
}
