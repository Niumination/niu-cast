package com.transsion.iotservice.multiscreen.pc.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.StringRes;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class Permission implements Parcelable {
    public static final Parcelable.Creator<Permission> CREATOR = new Parcelable.Creator<Permission>() { // from class: com.transsion.iotservice.multiscreen.pc.bean.Permission.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Permission createFromParcel(Parcel parcel) {
            return new Permission(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Permission[] newArray(int i8) {
            return new Permission[i8];
        }
    };

    @SerializedName("description")
    @StringRes
    private int description;

    @SerializedName("granted")
    private boolean granted;

    @SerializedName("name")
    private String name;

    @SerializedName("permissions")
    private ArrayList<String> permissions;

    public Permission(Parcel parcel) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.permissions = arrayList;
        parcel.readStringList(arrayList);
        this.name = parcel.readString();
        this.description = parcel.readInt();
        this.granted = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDescription() {
        return this.description;
    }

    public boolean getGranted() {
        return this.granted;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getPermissions() {
        return this.permissions;
    }

    public void setDescription(int i8) {
        this.description = i8;
    }

    public void setGranted(boolean z2) {
        this.granted = z2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPermissions(ArrayList<String> arrayList) {
        this.permissions = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeStringList(this.permissions);
        parcel.writeString(this.name);
        parcel.writeInt(this.description);
        parcel.writeByte(this.granted ? (byte) 1 : (byte) 0);
    }

    public Permission(ArrayList<String> arrayList, String str, int i8) {
        new ArrayList();
        this.permissions = arrayList;
        this.name = str;
        this.description = i8;
    }
}
