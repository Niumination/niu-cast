package com.transsion.hubsdk.api.window;

import a3.a;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranScreenshotHardwareBuffer implements Parcelable {
    public static final Parcelable.Creator<TranScreenshotHardwareBuffer> CREATOR = new a(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HardwareBuffer f2378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorSpace f2379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2381d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeParcelable(this.f2378a, i8);
        parcel.writeInt(this.f2379b.getId());
        parcel.writeByte(this.f2380c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2381d ? (byte) 1 : (byte) 0);
    }
}
