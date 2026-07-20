package l3;

import android.os.BadParcelableException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends h implements l {
    public static l asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
        return iInterfaceQueryLocalInterface instanceof l ? (l) iInterfaceQueryLocalInterface : new j(iBinder);
    }

    @Override // l3.h
    public final boolean e(int i8, Parcel parcel, Parcel parcel2) {
        if (i8 != 1) {
            return false;
        }
        f3.a aVarK = f3.b.k(parcel.readStrongBinder());
        Parcelable.Creator<zzbc> creator = zzbc.CREATOR;
        int i9 = m.f7268a;
        zzbc zzbcVarCreateFromParcel = parcel.readInt() == 0 ? null : creator.createFromParcel(parcel);
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(a1.a.o(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
        IInterface iInterfaceNewBarcodeScanner = newBarcodeScanner(aVarK, zzbcVarCreateFromParcel);
        parcel2.writeNoException();
        if (iInterfaceNewBarcodeScanner == null) {
            parcel2.writeStrongBinder(null);
        } else {
            parcel2.writeStrongBinder(((h) iInterfaceNewBarcodeScanner).asBinder());
        }
        return true;
    }
}
