package androidx.camera.core.impl;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface CamcorderProfileProvider {
    public static final CamcorderProfileProvider EMPTY = new CamcorderProfileProvider() { // from class: androidx.camera.core.impl.CamcorderProfileProvider.1
        @Override // androidx.camera.core.impl.CamcorderProfileProvider
        @Nullable
        public CamcorderProfileProxy get(int i8) {
            return null;
        }

        @Override // androidx.camera.core.impl.CamcorderProfileProvider
        public boolean hasProfile(int i8) {
            return false;
        }
    };

    @Nullable
    CamcorderProfileProxy get(int i8);

    boolean hasProfile(int i8);
}
