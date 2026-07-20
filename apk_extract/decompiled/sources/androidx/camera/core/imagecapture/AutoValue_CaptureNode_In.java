package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.processing.Edge;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_CaptureNode_In extends CaptureNode.In {
    private final Edge<ImageCaptureException> errorEdge;
    private final int format;
    private final Edge<ProcessingRequest> requestEdge;
    private final Size size;

    public AutoValue_CaptureNode_In(Size size, int i8, Edge<ProcessingRequest> edge, Edge<ImageCaptureException> edge2) {
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        this.format = i8;
        if (edge == null) {
            throw new NullPointerException("Null requestEdge");
        }
        this.requestEdge = edge;
        if (edge2 == null) {
            throw new NullPointerException("Null errorEdge");
        }
        this.errorEdge = edge2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.In)) {
            return false;
        }
        CaptureNode.In in = (CaptureNode.In) obj;
        return this.size.equals(in.getSize()) && this.format == in.getFormat() && this.requestEdge.equals(in.getRequestEdge()) && this.errorEdge.equals(in.getErrorEdge());
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    @NonNull
    public Edge<ImageCaptureException> getErrorEdge() {
        return this.errorEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public int getFormat() {
        return this.format;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    @NonNull
    public Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Size getSize() {
        return this.size;
    }

    public int hashCode() {
        return this.errorEdge.hashCode() ^ ((((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.format) * 1000003) ^ this.requestEdge.hashCode()) * 1000003);
    }

    public String toString() {
        return "In{size=" + this.size + ", format=" + this.format + ", requestEdge=" + this.requestEdge + ", errorEdge=" + this.errorEdge + "}";
    }
}
