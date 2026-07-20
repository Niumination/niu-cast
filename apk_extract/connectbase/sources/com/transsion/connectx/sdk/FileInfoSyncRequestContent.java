package com.transsion.connectx.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import j.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class FileInfoSyncRequestContent implements Parcelable {
    public static final Parcelable.Creator<FileInfoSyncRequestContent> CREATOR = new Parcelable.Creator<FileInfoSyncRequestContent>() { // from class: com.transsion.connectx.sdk.FileInfoSyncRequestContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileInfoSyncRequestContent createFromParcel(Parcel parcel) {
            return new FileInfoSyncRequestContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileInfoSyncRequestContent[] newArray(int i10) {
            return new FileInfoSyncRequestContent[i10];
        }
    };
    public static final int TYPE_AIR_COPY_TRANSFER = 5;
    public static final int TYPE_FILE_DIRECT_TRANSFER = 2;
    public static final int TYPE_FILE_DRAG_TRANSFER = 1;
    public static final int TYPE_GESTURE_DIRECT_TRANSFER = 3;
    public static final int TYPE_SCREEN_SHOT_TRANSFER = 6;
    public static final int TYPE_SHARE_DIRECT_TRANSFER = 4;
    private ArrayList<FileInfo> contents;
    private String packageName;
    private int type;

    public FileInfoSyncRequestContent(int i10, ArrayList<FileInfo> arrayList, String str) {
        this.type = i10;
        this.contents = arrayList;
        this.packageName = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<FileInfo> getContents() {
        return this.contents;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getType() {
        return this.type;
    }

    public void setContents(ArrayList<FileInfo> arrayList) {
        this.contents = arrayList;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FileInfoSyncRequestContent{type=");
        sb2.append(this.type);
        sb2.append(", contents=");
        sb2.append(this.contents);
        sb2.append(", packageName='");
        return c.a(sb2, this.packageName, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.contents);
        parcel.writeInt(this.type);
        parcel.writeString(this.packageName);
    }

    public FileInfoSyncRequestContent(Parcel parcel) {
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        this.contents = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
        this.type = parcel.readInt();
        this.packageName = parcel.readString();
    }
}
