package com.transsion.connectx.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import rs.f;
import u.a;

/* JADX INFO: loaded from: classes2.dex */
public class VideoConfig implements Parcelable {
    public static final Parcelable.Creator<VideoConfig> CREATOR = new Parcelable.Creator<VideoConfig>() { // from class: com.transsion.connectx.sdk.VideoConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoConfig createFromParcel(Parcel parcel) {
            return new VideoConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoConfig[] newArray(int i10) {
            return new VideoConfig[i10];
        }
    };
    private int bitrate;
    private int dpi;
    private String encodeType;
    private int frameRate;
    private int height;
    private int iFrameInterval;
    private String name;
    private int orientation;
    private int width;

    public VideoConfig(String str, int i10, int i11, int i12, int i13, int i14, int i15, String str2, int i16) {
        this.name = str;
        this.width = i10;
        this.height = i11;
        this.dpi = i12;
        this.bitrate = i13;
        this.frameRate = i14;
        this.iFrameInterval = i15;
        this.encodeType = str2;
        this.orientation = i16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getDpi() {
        return this.dpi;
    }

    public String getEncodeType() {
        return this.encodeType;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIFrameInterval() {
        return this.iFrameInterval;
    }

    public String getName() {
        return this.name;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBitrate(int i10) {
        this.bitrate = i10;
    }

    public void setDpi(int i10) {
        this.dpi = i10;
    }

    public void setEncodeType(String str) {
        this.encodeType = str;
    }

    public void setFrameRate(int i10) {
        this.frameRate = i10;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setIFrameInterval(int i10) {
        this.iFrameInterval = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrientation(int i10) {
        this.orientation = i10;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("VideoConfig{name='");
        sb2.append(this.name);
        sb2.append("', width=");
        sb2.append(this.width);
        sb2.append(", height=");
        sb2.append(this.height);
        sb2.append(", dpi=");
        sb2.append(this.dpi);
        sb2.append(", bitrate=");
        sb2.append(this.bitrate);
        sb2.append(", frameRate=");
        sb2.append(this.frameRate);
        sb2.append(", iFrameInterval=");
        sb2.append(this.iFrameInterval);
        sb2.append(", encodeType='");
        sb2.append(this.encodeType);
        sb2.append("', orientation=");
        return a.a(sb2, this.orientation, f.f14860b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.name);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.dpi);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.frameRate);
        parcel.writeInt(this.iFrameInterval);
        parcel.writeString(this.encodeType);
        parcel.writeInt(this.orientation);
    }

    public VideoConfig(Parcel parcel) {
        this.name = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.dpi = parcel.readInt();
        this.bitrate = parcel.readInt();
        this.frameRate = parcel.readInt();
        this.iFrameInterval = parcel.readInt();
        this.encodeType = parcel.readString();
        this.orientation = parcel.readInt();
    }
}
