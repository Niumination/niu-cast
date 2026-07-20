package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class PickVisualMediaRequest {

    @l
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

    public static final class Builder {

        @l
        private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

        @l
        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
            pickVisualMediaRequest.setMediaType$activity_release(this.mediaType);
            return pickVisualMediaRequest;
        }

        @l
        public final Builder setMediaType(@l ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
            l0.p(visualMediaType, "mediaType");
            this.mediaType = visualMediaType;
            return this;
        }
    }

    @l
    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType$activity_release(@l ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        l0.p(visualMediaType, "<set-?>");
        this.mediaType = visualMediaType;
    }
}
