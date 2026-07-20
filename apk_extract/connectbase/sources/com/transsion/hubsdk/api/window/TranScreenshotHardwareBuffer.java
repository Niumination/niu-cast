package com.transsion.hubsdk.api.window;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranScreenshotHardwareBuffer implements Parcelable {
    public static final Parcelable.Creator<TranScreenshotHardwareBuffer> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f2267f = "TranScreenshotHardwareBuffer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HardwareBuffer f2268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorSpace f2269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f2272e;

    public class a implements Parcelable.Creator<TranScreenshotHardwareBuffer> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranScreenshotHardwareBuffer createFromParcel(Parcel parcel) {
            return new TranScreenshotHardwareBuffer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranScreenshotHardwareBuffer[] newArray(int i10) {
            return new TranScreenshotHardwareBuffer[i10];
        }
    }

    public TranScreenshotHardwareBuffer() {
    }

    public Bitmap a() {
        return this.f2272e;
    }

    public boolean b() {
        return this.f2271d;
    }

    public boolean c() {
        return this.f2270c;
    }

    public ColorSpace d() {
        return this.f2269b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HardwareBuffer e() {
        return this.f2268a;
    }

    public void f(Bitmap bitmap) {
        this.f2272e = bitmap;
    }

    public void g(ColorSpace colorSpace) {
        this.f2269b = colorSpace;
    }

    public void h(boolean z10) {
        this.f2271d = z10;
    }

    public void i(boolean z10) {
        this.f2270c = z10;
    }

    public void j(HardwareBuffer hardwareBuffer) {
        this.f2268a = hardwareBuffer;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f2268a, i10);
        parcel.writeInt(this.f2269b.getId());
        parcel.writeByte(this.f2270c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2271d ? (byte) 1 : (byte) 0);
    }

    public TranScreenshotHardwareBuffer(HardwareBuffer hardwareBuffer, ColorSpace colorSpace, boolean z10, boolean z11) {
        this.f2268a = hardwareBuffer;
        this.f2269b = colorSpace;
        this.f2270c = z10;
        this.f2271d = z11;
    }

    public TranScreenshotHardwareBuffer(Parcel parcel) {
        ColorSpace colorSpace;
        this.f2268a = (HardwareBuffer) parcel.readParcelable(HardwareBuffer.class.getClassLoader());
        int i10 = parcel.readInt();
        if (i10 >= 0 && i10 < ColorSpace.Named.values().length) {
            colorSpace = ColorSpace.get(ColorSpace.Named.values()[i10]);
        } else {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        this.f2269b = colorSpace;
        this.f2270c = parcel.readByte() != 0;
        this.f2271d = parcel.readByte() != 0;
    }
}
