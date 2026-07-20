package com.transsion.hubsdk.api.window;

import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranTaskSnapshot implements Parcelable {
    public static final Parcelable.Creator<TranTaskSnapshot> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HardwareBuffer f2273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorSpace f2274b;

    public class a implements Parcelable.Creator<TranTaskSnapshot> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranTaskSnapshot createFromParcel(Parcel parcel) {
            return new TranTaskSnapshot(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranTaskSnapshot[] newArray(int i10) {
            return new TranTaskSnapshot[i10];
        }
    }

    public /* synthetic */ TranTaskSnapshot(Parcel parcel, a aVar) {
        this(parcel);
    }

    public ColorSpace a() {
        return this.f2274b;
    }

    public HardwareBuffer b() {
        return this.f2273a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        HardwareBuffer hardwareBuffer = this.f2273a;
        parcel.writeTypedObject((hardwareBuffer == null || hardwareBuffer.isClosed()) ? null : this.f2273a, 0);
        parcel.writeInt(this.f2274b.getId());
    }

    public TranTaskSnapshot() {
    }

    public TranTaskSnapshot(HardwareBuffer hardwareBuffer, ColorSpace colorSpace) {
        this.f2273a = hardwareBuffer;
        this.f2274b = colorSpace.getId() < 0 ? ColorSpace.get(ColorSpace.Named.SRGB) : colorSpace;
    }

    public TranTaskSnapshot(Parcel parcel) {
        ColorSpace colorSpace;
        this.f2273a = (HardwareBuffer) parcel.readTypedObject(HardwareBuffer.CREATOR);
        int i10 = parcel.readInt();
        if (i10 >= 0 && i10 < ColorSpace.Named.values().length) {
            colorSpace = ColorSpace.get(ColorSpace.Named.values()[i10]);
        } else {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        this.f2274b = colorSpace;
    }
}
