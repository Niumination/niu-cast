package y2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import java.util.ArrayList;
import k3.pd;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = pd.s(parcel);
        ArrayList arrayListI = null;
        String strF = null;
        boolean zK = false;
        String strF2 = null;
        while (parcel.dataPosition() < iS) {
            int i8 = parcel.readInt();
            char c9 = (char) i8;
            if (c9 == 1) {
                arrayListI = pd.i(parcel, i8, Feature.CREATOR);
            } else if (c9 == 2) {
                zK = pd.k(parcel, i8);
            } else if (c9 == 3) {
                strF2 = pd.f(parcel, i8);
            } else if (c9 != 4) {
                pd.r(parcel, i8);
            } else {
                strF = pd.f(parcel, i8);
            }
        }
        pd.j(parcel, iS);
        return new ApiFeatureRequest(arrayListI, zK, strF2, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new ApiFeatureRequest[i8];
    }
}
