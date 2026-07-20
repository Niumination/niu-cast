package g3;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class l extends h3.a {
    public final f3.a l(f3.b bVar, String str, int i8, f3.b bVar2) {
        Parcel parcelI = i();
        i3.a.c(parcelI, bVar);
        parcelI.writeString(str);
        parcelI.writeInt(i8);
        i3.a.c(parcelI, bVar2);
        Parcel parcelG = g(parcelI, 2);
        f3.a aVarK = f3.b.k(parcelG.readStrongBinder());
        parcelG.recycle();
        return aVarK;
    }

    public final f3.a m(f3.b bVar, String str, int i8, f3.b bVar2) {
        Parcel parcelI = i();
        i3.a.c(parcelI, bVar);
        parcelI.writeString(str);
        parcelI.writeInt(i8);
        i3.a.c(parcelI, bVar2);
        Parcel parcelG = g(parcelI, 3);
        f3.a aVarK = f3.b.k(parcelG.readStrongBinder());
        parcelG.recycle();
        return aVarK;
    }
}
