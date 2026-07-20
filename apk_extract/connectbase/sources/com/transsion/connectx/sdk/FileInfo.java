package com.transsion.connectx.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import n2.k0;
import rs.f;

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
        public FileInfo[] newArray(int i10) {
            return new FileInfo[i10];
        }
    };
    private long fileSize;
    private String format;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f2196id;
    private String name;
    private String thumbnail;
    private int type;
    private String uri;

    public FileInfo(String str, String str2, String str3, String str4, String str5, int i10, long j10) {
        this.f2196id = str;
        this.uri = str2;
        this.thumbnail = str3;
        this.name = str4;
        this.format = str5;
        this.type = i10;
        this.fileSize = j10;
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
        return this.f2196id;
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

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setId(String str) {
        this.f2196id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FileInfo{id='");
        sb2.append(this.f2196id);
        sb2.append("', uri='");
        sb2.append(this.uri);
        sb2.append("', name='");
        sb2.append(this.name);
        sb2.append("', format='");
        sb2.append(this.format);
        sb2.append("', type=");
        sb2.append(this.type);
        sb2.append(", fileSize=");
        return k0.a(sb2, this.fileSize, f.f14860b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2196id);
        parcel.writeString(this.uri);
        parcel.writeString(this.thumbnail);
        parcel.writeString(this.name);
        parcel.writeString(this.format);
        parcel.writeInt(this.type);
        parcel.writeLong(this.fileSize);
    }

    public FileInfo(Parcel parcel) {
        this.f2196id = parcel.readString();
        this.uri = parcel.readString();
        this.thumbnail = parcel.readString();
        this.name = parcel.readString();
        this.format = parcel.readString();
        this.type = parcel.readInt();
        this.fileSize = parcel.readLong();
    }
}
