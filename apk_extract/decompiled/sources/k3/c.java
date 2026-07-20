package k3;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class c extends h3.a implements e {
    public final b l(f3.b bVar, zzah zzahVar) {
        b bVar2;
        Parcel parcelI = i();
        t.a(parcelI, bVar);
        parcelI.writeInt(1);
        zzahVar.writeToParcel(parcelI, 0);
        Parcel parcelJ = j(parcelI, 1);
        IBinder strongBinder = parcelJ.readStrongBinder();
        if (strongBinder == null) {
            bVar2 = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            bVar2 = iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new b(strongBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector", 2);
        }
        parcelJ.recycle();
        return bVar2;
    }
}
