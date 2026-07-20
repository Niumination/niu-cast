package h1;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.window.layout.adapter.sidecar.SidecarCompat;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5229c;

    public /* synthetic */ a(int i8, Object obj, Object obj2) {
        this.f5227a = i8;
        this.f5228b = obj;
        this.f5229c = obj2;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f5227a) {
            case 0:
                SidecarCompat.registerConfigurationChangeListener$lambda$0((SidecarCompat) this.f5228b, (Activity) this.f5229c, (Configuration) obj);
                break;
            case 1:
                CameraUseCaseAdapter.lambda$createExtraPreview$0((Surface) this.f5228b, (SurfaceTexture) this.f5229c, (SurfaceRequest.Result) obj);
                break;
            case 2:
                ((DefaultSurfaceProcessor) this.f5228b).lambda$onOutputSurface$2((SurfaceOutput) this.f5229c, (SurfaceOutput.Event) obj);
                break;
            default:
                ((Recorder) this.f5228b).lambda$initEncoderAndAudioSourceCallbacks$11((CallbackToFutureAdapter.Completer) this.f5229c, (Throwable) obj);
                break;
        }
    }
}
