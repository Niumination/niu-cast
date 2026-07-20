package m;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements ImageReaderProxy.OnImageAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7550b;

    public /* synthetic */ g(Object obj, int i8) {
        this.f7549a = i8;
        this.f7550b = obj;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        int i8 = this.f7549a;
        Object obj = this.f7550b;
        switch (i8) {
            case 0:
                ImageCapture.lambda$takePictureInternal$6((CallbackToFutureAdapter.Completer) obj, imageReaderProxy);
                break;
            default:
                ((MetadataImageReader) obj).lambda$new$0(imageReaderProxy);
                break;
        }
    }
}
