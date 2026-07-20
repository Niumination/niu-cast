package we;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.utils.ArrayUtil$ServicePort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        return new ArrayUtil$ServicePort(string, parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new ArrayUtil$ServicePort[i8];
    }
}
