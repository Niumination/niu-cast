package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
interface CamcorderProfileHelper {
    CamcorderProfile get(int i8, int i9);

    boolean hasProfile(int i8, int i9);
}
