package com.transsion.connectx.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import rs.f;
import u.a;

/* JADX INFO: loaded from: classes2.dex */
public class FileInfoSyncRequest implements Parcelable {
    public static final Parcelable.Creator<FileInfoSyncRequest> CREATOR = new Parcelable.Creator<FileInfoSyncRequest>() { // from class: com.transsion.connectx.sdk.FileInfoSyncRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileInfoSyncRequest createFromParcel(Parcel parcel) {
            return new FileInfoSyncRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileInfoSyncRequest[] newArray(int i10) {
            return new FileInfoSyncRequest[i10];
        }
    };
    public static final int RESP_CONFIRM = 1;
    public static final int RESP_DECLINE = 2;
    private ArrayList<FileInfo> fileInfo;
    private String packageName;
    private int type;

    public FileInfoSyncRequest(ArrayList<FileInfo> arrayList, String str, int i10) {
        this.fileInfo = arrayList;
        this.packageName = str;
        this.type = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<FileInfo> getFileInfo() {
        return this.fileInfo;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getType() {
        return this.type;
    }

    public void setFileInfo(ArrayList<FileInfo> arrayList) {
        this.fileInfo = arrayList;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TransferRequest{pfd=");
        sb2.append(this.fileInfo);
        sb2.append("packageName=");
        sb2.append(this.packageName);
        sb2.append("type=");
        return a.a(sb2, this.type, f.f14860b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.fileInfo);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.type);
    }

    public FileInfoSyncRequest(Parcel parcel) {
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        this.fileInfo = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
        this.packageName = parcel.readString();
        this.type = parcel.readInt();
    }
}
