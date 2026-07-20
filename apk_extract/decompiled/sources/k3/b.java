package k3;

import android.os.Parcel;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;

/* JADX INFO: loaded from: classes.dex */
public final class b extends h3.a {
    public final zzu[] l(f3.b bVar, zzan zzanVar) {
        Parcel parcelI = i();
        t.a(parcelI, bVar);
        parcelI.writeInt(1);
        zzanVar.writeToParcel(parcelI, 0);
        Parcel parcelJ = j(parcelI, 1);
        zzu[] zzuVarArr = (zzu[]) parcelJ.createTypedArray(zzu.CREATOR);
        parcelJ.recycle();
        return zzuVarArr;
    }
}
