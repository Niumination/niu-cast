package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    public WritableFileSection(@NonNull FileSectionType fileSectionType, int i8, @NonNull byte[] bArr, boolean z2) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i8;
        this.mContents = bArr;
        this.mNeedsCompression = z2;
    }
}
