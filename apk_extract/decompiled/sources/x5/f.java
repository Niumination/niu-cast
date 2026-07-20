package x5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;
import k3.pd;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = pd.s(parcel);
        int iN = 0;
        int iN2 = 0;
        int iN3 = 0;
        int iN4 = 0;
        long jO = 0;
        while (parcel.dataPosition() < iS) {
            int i8 = parcel.readInt();
            char c9 = (char) i8;
            if (c9 == 1) {
                iN = pd.n(parcel, i8);
            } else if (c9 == 2) {
                iN2 = pd.n(parcel, i8);
            } else if (c9 == 3) {
                iN3 = pd.n(parcel, i8);
            } else if (c9 == 4) {
                jO = pd.o(parcel, i8);
            } else if (c9 != 5) {
                pd.r(parcel, i8);
            } else {
                iN4 = pd.n(parcel, i8);
            }
        }
        pd.j(parcel, iS);
        return new VisionImageMetadataParcel(iN, iN2, iN3, iN4, jO);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new VisionImageMetadataParcel[i8];
    }
}
