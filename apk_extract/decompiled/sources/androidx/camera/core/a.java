package androidx.camera.core;

import android.net.Uri;
import androidx.camera.core.impl.ImageReaderProxy;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f940c;

    public /* synthetic */ a(int i8, Object obj, Object obj2) {
        this.f938a = i8;
        this.f939b = obj;
        this.f940c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f938a) {
            case 0:
                ((AndroidImageReaderProxy) this.f939b).lambda$setOnImageAvailableListener$0((ImageReaderProxy.OnImageAvailableListener) this.f940c);
                break;
            case 1:
                ((ImageCapture.ImageCaptureRequest) this.f939b).lambda$dispatchImage$0((SettableImageProxy) this.f940c);
                break;
            case 2:
                ((ImageSaver) this.f939b).lambda$run$0((File) this.f940c);
                break;
            default:
                ((ImageSaver) this.f939b).lambda$postSuccess$1((Uri) this.f940c);
                break;
        }
    }
}
