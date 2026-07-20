package k3;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class qd {
    public static void a(Parcel parcel, int i8, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i9 = i(parcel, i8);
        parcel.writeBundle(bundle);
        j(parcel, i9);
    }

    public static void b(Parcel parcel, int i8, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int i9 = i(parcel, i8);
        parcel.writeByteArray(bArr);
        j(parcel, i9);
    }

    public static void c(Parcel parcel, int i8, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int i9 = i(parcel, i8);
        parcel.writeStrongBinder(iBinder);
        j(parcel, i9);
    }

    public static void d(Parcel parcel, int i8, Parcelable parcelable, int i9) {
        if (parcelable == null) {
            return;
        }
        int i10 = i(parcel, i8);
        parcelable.writeToParcel(parcel, i9);
        j(parcel, i10);
    }

    public static void e(Parcel parcel, int i8, String str) {
        if (str == null) {
            return;
        }
        int i9 = i(parcel, i8);
        parcel.writeString(str);
        j(parcel, i9);
    }

    public static void f(Parcel parcel, int i8, String[] strArr) {
        if (strArr == null) {
            return;
        }
        int i9 = i(parcel, i8);
        parcel.writeStringArray(strArr);
        j(parcel, i9);
    }

    public static void g(Parcel parcel, int i8, Parcelable[] parcelableArr, int i9) {
        if (parcelableArr == null) {
            return;
        }
        int i10 = i(parcel, i8);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i9);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        j(parcel, i10);
    }

    public static void h(Parcel parcel, int i8, List list) {
        if (list == null) {
            return;
        }
        int i9 = i(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            Parcelable parcelable = (Parcelable) list.get(i10);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        j(parcel, i9);
    }

    public static int i(Parcel parcel, int i8) {
        parcel.writeInt(i8 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void j(Parcel parcel, int i8) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i8 - 4);
        parcel.writeInt(iDataPosition - i8);
        parcel.setDataPosition(iDataPosition);
    }

    public static void k(Parcel parcel, int i8, int i9) {
        parcel.writeInt(i8 | (i9 << 16));
    }
}
