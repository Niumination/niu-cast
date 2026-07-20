package k3;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class pd {
    public static BigDecimal a(Parcel parcel, int i8) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i9 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iQ);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i9);
    }

    public static Bundle b(Parcel parcel, int i8) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iQ);
        return bundle;
    }

    public static byte[] c(Parcel parcel, int i8) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iQ);
        return bArrCreateByteArray;
    }

    public static int[] d(Parcel parcel, int i8) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iQ);
        return iArrCreateIntArray;
    }

    public static Parcelable e(Parcel parcel, int i8, Parcelable.Creator creator) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iQ);
        return parcelable;
    }

    public static String f(Parcel parcel, int i8) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iQ);
        return string;
    }

    public static String[] g(Parcel parcel, int i8) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iQ);
        return strArrCreateStringArray;
    }

    public static Object[] h(Parcel parcel, int i8, Parcelable.Creator creator) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iQ);
        return objArrCreateTypedArray;
    }

    public static ArrayList i(Parcel parcel, int i8, Parcelable.Creator creator) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iQ);
        return arrayListCreateTypedArrayList;
    }

    public static void j(Parcel parcel, int i8) {
        if (parcel.dataPosition() != i8) {
            throw new v2.a(a1.a.o(i8, "Overread allowed size end="), parcel);
        }
    }

    public static boolean k(Parcel parcel, int i8) {
        t(parcel, i8, 4);
        return parcel.readInt() != 0;
    }

    public static double l(Parcel parcel, int i8) {
        t(parcel, i8, 8);
        return parcel.readDouble();
    }

    public static IBinder m(Parcel parcel, int i8) {
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (iQ == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iQ);
        return strongBinder;
    }

    public static int n(Parcel parcel, int i8) {
        t(parcel, i8, 4);
        return parcel.readInt();
    }

    public static long o(Parcel parcel, int i8) {
        t(parcel, i8, 8);
        return parcel.readLong();
    }

    public static Long p(Parcel parcel, int i8) {
        int iQ = q(parcel, i8);
        if (iQ == 0) {
            return null;
        }
        if (iQ == 8) {
            return Long.valueOf(parcel.readLong());
        }
        throw new v2.a("Expected size 8 got " + iQ + " (0x" + Integer.toHexString(iQ) + ")", parcel);
    }

    public static int q(Parcel parcel, int i8) {
        return (i8 & SupportMenu.CATEGORY_MASK) != -65536 ? (char) (i8 >> 16) : parcel.readInt();
    }

    public static void r(Parcel parcel, int i8) {
        parcel.setDataPosition(parcel.dataPosition() + q(parcel, i8));
    }

    public static int s(Parcel parcel) {
        int i8 = parcel.readInt();
        int iQ = q(parcel, i8);
        int iDataPosition = parcel.dataPosition();
        if (((char) i8) != 20293) {
            throw new v2.a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i8))), parcel);
        }
        int i9 = iQ + iDataPosition;
        if (i9 < iDataPosition || i9 > parcel.dataSize()) {
            throw new v2.a(o.d.f(iDataPosition, i9, "Size read is invalid start=", " end="), parcel);
        }
        return i9;
    }

    public static void t(Parcel parcel, int i8, int i9) {
        int iQ = q(parcel, i8);
        if (iQ == i9) {
            return;
        }
        throw new v2.a(h0.a.n(o.d.r(i9, iQ, "Expected size ", " got ", " (0x"), Integer.toHexString(iQ), ")"), parcel);
    }
}
