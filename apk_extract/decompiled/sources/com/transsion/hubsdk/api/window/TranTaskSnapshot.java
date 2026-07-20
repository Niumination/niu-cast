package com.transsion.hubsdk.api.window;

import a3.a;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranTaskSnapshot implements Parcelable {
    public static final Parcelable.Creator<TranTaskSnapshot> CREATOR = new a(11);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HardwareBuffer f2382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorSpace f2383b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        HardwareBuffer hardwareBuffer = this.f2382a;
        if (hardwareBuffer == null || hardwareBuffer.isClosed()) {
            hardwareBuffer = null;
        }
        parcel.writeTypedObject(hardwareBuffer, 0);
        parcel.writeInt(this.f2383b.getId());
    }
}
