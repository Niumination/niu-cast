package u2;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class x extends h3.a implements y {
    @Override // u2.y
    public final int c() {
        Parcel parcelG = g(i(), 2);
        int i8 = parcelG.readInt();
        parcelG.recycle();
        return i8;
    }

    @Override // u2.y
    public final f3.a d() {
        Parcel parcelG = g(i(), 1);
        f3.a aVarK = f3.b.k(parcelG.readStrongBinder());
        parcelG.recycle();
        return aVarK;
    }
}
