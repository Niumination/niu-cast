package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\f\b\u0000\u0010\u0003*\u00020\u0001*\u00020\u0002*\n\b\u0001\u0010\u0004*\u0004\u0018\u00010\u00022\u00020\u0002¨\u0006\u0005"}, d2 = {"Lcom/welink/protocol/nfbd/NearDeviceDataParcel;", "", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "D", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NearDeviceDataParcel<T extends Parcelable, D extends Parcelable> implements Parcelable {

    @JvmField
    public static final Parcelable.Creator<NearDeviceDataParcel<?, ?>> CREATOR = new s8.b(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parcelable f3904b;

    public NearDeviceDataParcel(Object data, Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f3903a = data;
        this.f3904b = parcelable;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Object getF3903a() {
        return this.f3903a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable((Parcelable) this.f3903a, i8);
        parcel.writeParcelable(this.f3904b, i8);
    }
}
