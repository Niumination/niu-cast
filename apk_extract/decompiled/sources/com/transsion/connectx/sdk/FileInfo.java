package com.transsion.connectx.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class FileInfo implements Parcelable {
    public static final Parcelable.Creator<FileInfo> CREATOR = new Parcelable.Creator<FileInfo>() { // from class: com.transsion.connectx.sdk.FileInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileInfo createFromParcel(Parcel parcel) {
            return new FileInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileInfo[] newArray(int i8) {
            return new FileInfo[i8];
        }
    };
    private long fileSize;
    private String format;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f2335id;
    private String name;
    private String thumbnail;
    private int type;
    private String uri;

    public FileInfo(String str, String str2, String str3, String str4, String str5, int i8, long j8) {
        this.f2335id = str;
        this.uri = str2;
        this.thumbnail = str3;
        this.name = str4;
        this.format = str5;
        this.type = i8;
        this.fileSize = j8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFormat() {
        return this.format;
    }

    public String getId() {
        return this.f2335id;
    }

    public String getName() {
        return this.name;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public int getType() {
        return this.type;
    }

    public String getUri() {
        return this.uri;
    }

    public void setFileSize(long j8) {
        this.fileSize = j8;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setId(String str) {
        this.f2335id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public void setType(int i8) {
        this.type = i8;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String toString() {
        return "FileInfo{id='" + this.f2335id + "', uri='" + this.uri + "', name='" + this.name + "', format='" + this.format + "', type=" + this.type + ", fileSize=" + this.fileSize + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f2335id);
        parcel.writeString(this.uri);
        parcel.writeString(this.thumbnail);
        parcel.writeString(this.name);
        parcel.writeString(this.format);
        parcel.writeInt(this.type);
        parcel.writeLong(this.fileSize);
    }

    public FileInfo(Parcel parcel) {
        this.f2335id = parcel.readString();
        this.uri = parcel.readString();
        this.thumbnail = parcel.readString();
        this.name = parcel.readString();
        this.format = parcel.readString();
        this.type = parcel.readInt();
        this.fileSize = parcel.readLong();
    }
}
