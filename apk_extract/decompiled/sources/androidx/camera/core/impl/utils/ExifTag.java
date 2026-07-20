package androidx.camera.core.impl.utils;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    public ExifTag(String str, int i8, int i9) {
        this.name = str;
        this.number = i8;
        this.primaryFormat = i9;
        this.secondaryFormat = -1;
    }

    public boolean isFormatCompatible(int i8) {
        int i9;
        int i10 = this.primaryFormat;
        if (i10 == 7 || i8 == 7 || i10 == i8 || (i9 = this.secondaryFormat) == i8) {
            return true;
        }
        if ((i10 == 4 || i9 == 4) && i8 == 3) {
            return true;
        }
        if ((i10 == 9 || i9 == 9) && i8 == 8) {
            return true;
        }
        return (i10 == 12 || i9 == 12) && i8 == 11;
    }

    public ExifTag(String str, int i8, int i9, int i10) {
        this.name = str;
        this.number = i8;
        this.primaryFormat = i9;
        this.secondaryFormat = i10;
    }
}
