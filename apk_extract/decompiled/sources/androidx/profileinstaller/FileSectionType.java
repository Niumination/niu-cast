package androidx.profileinstaller;

import o.d;

/* JADX INFO: loaded from: classes.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j8) {
        this.mValue = j8;
    }

    public static FileSectionType fromValue(long j8) {
        FileSectionType[] fileSectionTypeArrValues = values();
        for (int i8 = 0; i8 < fileSectionTypeArrValues.length; i8++) {
            if (fileSectionTypeArrValues[i8].getValue() == j8) {
                return fileSectionTypeArrValues[i8];
            }
        }
        throw new IllegalArgumentException(d.j("Unsupported FileSection Type ", j8));
    }

    public long getValue() {
        return this.mValue;
    }
}
