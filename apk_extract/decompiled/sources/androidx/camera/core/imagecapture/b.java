package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.processing.Node;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Node f964b;

    public /* synthetic */ b(Node node, int i8) {
        this.f963a = i8;
        this.f964b = node;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        int i8 = this.f963a;
        Node node = this.f964b;
        switch (i8) {
            case 0:
                ((CaptureNode) node).onRequestAvailable((ProcessingRequest) obj);
                break;
            case 1:
                ((CaptureNode) node).sendCaptureError((ImageCaptureException) obj);
                break;
            default:
                ((ProcessingNode) node).lambda$transform$1((ProcessingNode.InputPacket) obj);
                break;
        }
    }
}
