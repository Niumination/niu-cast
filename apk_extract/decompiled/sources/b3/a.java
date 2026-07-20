package b3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import k3.pd;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = pd.s(parcel);
        int iN = 0;
        int iN2 = 0;
        boolean zK = false;
        int iN3 = 0;
        boolean zK2 = false;
        int iN4 = 0;
        String strF = null;
        String strF2 = null;
        zaa zaaVar = null;
        while (parcel.dataPosition() < iS) {
            int i8 = parcel.readInt();
            switch ((char) i8) {
                case 1:
                    iN = pd.n(parcel, i8);
                    break;
                case 2:
                    iN2 = pd.n(parcel, i8);
                    break;
                case 3:
                    zK = pd.k(parcel, i8);
                    break;
                case 4:
                    iN3 = pd.n(parcel, i8);
                    break;
                case 5:
                    zK2 = pd.k(parcel, i8);
                    break;
                case 6:
                    strF = pd.f(parcel, i8);
                    break;
                case 7:
                    iN4 = pd.n(parcel, i8);
                    break;
                case '\b':
                    strF2 = pd.f(parcel, i8);
                    break;
                case '\t':
                    zaaVar = (zaa) pd.e(parcel, i8, zaa.CREATOR);
                    break;
                default:
                    pd.r(parcel, i8);
                    break;
            }
        }
        pd.j(parcel, iS);
        return new FastJsonResponse$Field(iN, iN2, zK, iN3, zK2, strF, iN4, strF2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new FastJsonResponse$Field[i8];
    }
}
