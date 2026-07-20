package com.transsion.connectx.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class AudioConfig implements Parcelable {
    public static final Parcelable.Creator<AudioConfig> CREATOR = new Parcelable.Creator<AudioConfig>() { // from class: com.transsion.connectx.sdk.AudioConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioConfig createFromParcel(Parcel parcel) {
            return new AudioConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioConfig[] newArray(int i10) {
            return new AudioConfig[i10];
        }
    };
    private int audioFormat;
    private int channelConfig;
    private String encodeType;
    private int sampleRate;

    public AudioConfig(int i10, int i11, int i12, String str) {
        this.sampleRate = i10;
        this.channelConfig = i11;
        this.audioFormat = i12;
        this.encodeType = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAudioFormat() {
        return this.audioFormat;
    }

    public int getChannelConfig() {
        return this.channelConfig;
    }

    public String getEncodeType() {
        return this.encodeType;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public void setAudioFormat(int i10) {
        this.audioFormat = i10;
    }

    public void setChannelConfig(int i10) {
        this.channelConfig = i10;
    }

    public void setEncodeType(String str) {
        this.encodeType = str;
    }

    public void setSampleRate(int i10) {
        this.sampleRate = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.channelConfig);
        parcel.writeInt(this.audioFormat);
        parcel.writeString(this.encodeType);
    }

    public AudioConfig(Parcel parcel) {
        this.sampleRate = parcel.readInt();
        this.channelConfig = parcel.readInt();
        this.audioFormat = parcel.readInt();
        this.encodeType = parcel.readString();
    }
}
