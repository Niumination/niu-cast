package c3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;
import k3.pd;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iS = pd.s(parcel);
        int iN = 0;
        int iN2 = 0;
        int iN3 = 0;
        int iN4 = 0;
        boolean zK = false;
        long jO = 0;
        long jO2 = 0;
        long jO3 = 0;
        String strF = null;
        ArrayList<String> arrayList = null;
        String strF2 = null;
        String strF3 = null;
        String strF4 = null;
        String strF5 = null;
        float f = 0.0f;
        while (parcel.dataPosition() < iS) {
            int i8 = parcel.readInt();
            switch ((char) i8) {
                case 1:
                    iN = pd.n(parcel, i8);
                    break;
                case 2:
                    jO = pd.o(parcel, i8);
                    break;
                case 3:
                case 7:
                case '\t':
                default:
                    pd.r(parcel, i8);
                    break;
                case 4:
                    strF = pd.f(parcel, i8);
                    break;
                case 5:
                    iN3 = pd.n(parcel, i8);
                    break;
                case 6:
                    int iQ = pd.q(parcel, i8);
                    int iDataPosition = parcel.dataPosition();
                    if (iQ != 0) {
                        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                        parcel.setDataPosition(iDataPosition + iQ);
                        arrayList = arrayListCreateStringArrayList;
                    } else {
                        arrayList = null;
                    }
                    break;
                case '\b':
                    jO2 = pd.o(parcel, i8);
                    break;
                case '\n':
                    strF3 = pd.f(parcel, i8);
                    break;
                case 11:
                    iN2 = pd.n(parcel, i8);
                    break;
                case '\f':
                    strF2 = pd.f(parcel, i8);
                    break;
                case '\r':
                    strF4 = pd.f(parcel, i8);
                    break;
                case 14:
                    iN4 = pd.n(parcel, i8);
                    break;
                case 15:
                    pd.t(parcel, i8, 4);
                    f = parcel.readFloat();
                    break;
                case 16:
                    jO3 = pd.o(parcel, i8);
                    break;
                case 17:
                    strF5 = pd.f(parcel, i8);
                    break;
                case 18:
                    zK = pd.k(parcel, i8);
                    break;
            }
        }
        pd.j(parcel, iS);
        return new WakeLockEvent(iN, jO, iN2, strF, iN3, arrayList, strF2, jO2, iN4, strF3, strF4, f, jO3, strF5, zK);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new WakeLockEvent[i8];
    }
}
