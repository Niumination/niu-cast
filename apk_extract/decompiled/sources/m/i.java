package m;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements ForwardingImageProxy.OnImageCloseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageProxy f7554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageProxy f7555c;

    public /* synthetic */ i(ImageProxy imageProxy, ImageProxy imageProxy2, int i8) {
        this.f7553a = i8;
        this.f7554b = imageProxy;
        this.f7555c = imageProxy2;
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public final void onImageClose(ImageProxy imageProxy) {
        switch (this.f7553a) {
            case 0:
                ImageProcessingUtil.lambda$convertYUVToRGB$0(this.f7554b, this.f7555c, imageProxy);
                break;
            default:
                ImageProcessingUtil.lambda$rotateYUV$1(this.f7554b, this.f7555c, imageProxy);
                break;
        }
    }
}
