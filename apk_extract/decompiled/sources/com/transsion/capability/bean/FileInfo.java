package com.transsion.capability.bean;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import com.transsion.message.bank.MessageBank;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/transsion/capability/bean/FileInfo;", "Landroid/os/Parcelable;", "", "id", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "uri", "getUri", "setUri", "thumbnail", "getThumbnail", "setThumbnail", "name", "f", "setName", "format", "d", "setFormat", "", MessageBank.KEY_TYPE, "I", "getType", "()I", "setType", "(I)V", "", "fileSize", "J", "b", "()J", "setFileSize", "(J)V", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FileInfo implements Parcelable {

    @JvmField
    public static final Parcelable.Creator<FileInfo> CREATOR = new a(26);

    @SerializedName("fileSize")
    private long fileSize;

    @SerializedName("format")
    private String format;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName(MessageBank.KEY_TYPE)
    private int type;

    @SerializedName("uri")
    private String uri;

    public FileInfo(String str, String str2, String str3, String str4, int i8, long j8) {
        this.id = "";
        this.uri = str;
        this.thumbnail = str2;
        this.name = str3;
        this.format = str4;
        this.type = i8;
        this.fileSize = j8;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final void g(String str) {
        this.id = str;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0028  */
    public final String toString() {
        String strSubstring;
        String str = this.thumbnail;
        if (str == null || str.length() <= 0) {
            strSubstring = this.thumbnail;
        } else {
            String str2 = this.thumbnail;
            if ((str2 != null ? str2.length() : 0) > 5) {
                String str3 = this.thumbnail;
                if (str3 != null) {
                    strSubstring = str3.substring(0, 5);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                } else {
                    strSubstring = null;
                }
            } else {
                strSubstring = this.thumbnail;
            }
        }
        String str4 = this.uri;
        String str5 = this.name;
        String str6 = this.format;
        int i8 = this.type;
        long j8 = this.fileSize;
        StringBuilder sbP = h0.a.p("TransferRequestContent{uri='", str4, "', thumbnail=", strSubstring, ", name=");
        d.A(sbP, str5, ", format=", str6, ", type=");
        sbP.append(i8);
        sbP.append(", fileSize=");
        sbP.append(j8);
        sbP.append("}");
        return sbP.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.uri);
        parcel.writeString(this.thumbnail);
        parcel.writeString(this.name);
        parcel.writeString(this.format);
        parcel.writeInt(this.type);
        parcel.writeLong(this.fileSize);
    }

    public FileInfo(Parcel in) {
        Intrinsics.checkNotNullParameter(in, "in");
        this.id = "";
        this.id = in.readString();
        this.uri = in.readString();
        this.thumbnail = in.readString();
        this.name = in.readString();
        this.format = in.readString();
        this.type = in.readInt();
        this.fileSize = in.readLong();
    }
}
