package com.transsion.connectx.sdk;

import a1.a;
import android.os.Parcel;
import android.os.Parcelable;

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
        public VideoConfig[] newArray(int i8) {
            return new VideoConfig[i8];
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

    public VideoConfig(String str, int i8, int i9, int i10, int i11, int i12, int i13, String str2, int i14) {
        this.name = str;
        this.width = i8;
        this.height = i9;
        this.dpi = i10;
        this.bitrate = i11;
        this.frameRate = i12;
        this.iFrameInterval = i13;
        this.encodeType = str2;
        this.orientation = i14;
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

    public void setBitrate(int i8) {
        this.bitrate = i8;
    }

    public void setDpi(int i8) {
        this.dpi = i8;
    }

    public void setEncodeType(String str) {
        this.encodeType = str;
    }

    public void setFrameRate(int i8) {
        this.frameRate = i8;
    }

    public void setHeight(int i8) {
        this.height = i8;
    }

    public void setIFrameInterval(int i8) {
        this.iFrameInterval = i8;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOrientation(int i8) {
        this.orientation = i8;
    }

    public void setWidth(int i8) {
        this.width = i8;
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
        return a.r(sb2, this.orientation, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
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
