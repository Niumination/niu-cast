package yc;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.pcconnect.invoke.bridge.Device;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        String string2 = parcel.readString();
        if (string2 == null) {
            string2 = "";
        }
        String string3 = parcel.readString();
        if (string3 == null) {
            string3 = "";
        }
        String string4 = parcel.readString();
        return new Device(string, string2, string3, string4 != null ? string4 : "");
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new Device[i8];
    }
}
