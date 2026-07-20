package ec;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.iotservice.pc.bean.ThumbBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new ThumbBean(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new ThumbBean[i8];
    }
}
