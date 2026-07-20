package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class PickVisualMediaRequestKt {
    @l
    public static final PickVisualMediaRequest PickVisualMediaRequest(@l ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        l0.p(visualMediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(visualMediaType).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        return PickVisualMediaRequest(visualMediaType);
    }
}
