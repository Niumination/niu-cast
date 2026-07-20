package com.transsion.iotservice.pc.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import com.transsion.message.bank.MessageBank;
import ec.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001>BW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0018J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J\u0010\u0010\u001c\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0016J\u0010\u0010\u001d\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0018J`\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0018J\u0010\u0010#\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b#\u0010\u0016J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010,R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010)\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010,R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010)\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010,R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010)\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010,R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u00103\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u00106R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u00107\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010:R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010)\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010,¨\u0006?"}, d2 = {"Lcom/transsion/iotservice/pc/bean/ThumbBean;", "Landroid/os/Parcelable;", "", "uri", "thumbnail", "name", "format", "", MessageBank.KEY_TYPE, "", "fileSize", "textContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()J", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)Lcom/transsion/iotservice/pc/bean/ThumbBean;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUri", "setUri", "(Ljava/lang/String;)V", "getThumbnail", "setThumbnail", "getName", "setName", "getFormat", "setFormat", "I", "getType", "setType", "(I)V", "J", "getFileSize", "setFileSize", "(J)V", "getTextContent", "setTextContent", "CREATOR", "ec/a", "filetransfersdk_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class ThumbBean implements Parcelable {
    public static final a CREATOR = new a();

    @SerializedName("fileSize")
    private long fileSize;

    @SerializedName("format")
    private String format;

    @SerializedName("name")
    private String name;

    @SerializedName("textContent")
    private String textContent;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName(MessageBank.KEY_TYPE)
    private int type;

    @SerializedName("uri")
    private String uri;

    public ThumbBean() {
        this(null, null, null, null, 0, 0L, null, 127, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }

    public final ThumbBean copy(String uri, String thumbnail, String name, String format, int type, long fileSize, String textContent) {
        return new ThumbBean(uri, thumbnail, name, format, type, fileSize, textContent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbBean)) {
            return false;
        }
        ThumbBean thumbBean = (ThumbBean) other;
        return Intrinsics.areEqual(this.uri, thumbBean.uri) && Intrinsics.areEqual(this.thumbnail, thumbBean.thumbnail) && Intrinsics.areEqual(this.name, thumbBean.name) && Intrinsics.areEqual(this.format, thumbBean.format) && this.type == thumbBean.type && this.fileSize == thumbBean.fileSize && Intrinsics.areEqual(this.textContent, thumbBean.textContent);
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        String str = this.uri;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.thumbnail;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.format;
        int iF = a1.a.f(this.fileSize, a1.a.c(this.type, (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31, 31), 31);
        String str5 = this.textContent;
        return iF + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setFileSize(long j8) {
        this.fileSize = j8;
    }

    public final void setFormat(String str) {
        this.format = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setTextContent(String str) {
        this.textContent = str;
    }

    public final void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public final void setType(int i8) {
        this.type = i8;
    }

    public final void setUri(String str) {
        this.uri = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ThumbBean(uri=");
        sb2.append(this.uri);
        sb2.append(", thumbnail=");
        sb2.append(this.thumbnail);
        sb2.append(", name=");
        sb2.append(this.name);
        sb2.append(", format=");
        sb2.append(this.format);
        sb2.append(", type=");
        sb2.append(this.type);
        sb2.append(", fileSize=");
        sb2.append(this.fileSize);
        sb2.append(", textContent=");
        return a1.a.s(sb2, this.textContent, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uri);
        parcel.writeString(this.thumbnail);
        parcel.writeString(this.name);
        parcel.writeString(this.format);
        parcel.writeInt(this.type);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.textContent);
    }

    public ThumbBean(String str, String str2, String str3, String str4, int i8, long j8, String str5) {
        this.uri = str;
        this.thumbnail = str2;
        this.name = str3;
        this.format = str4;
        this.type = i8;
        this.fileSize = j8;
        this.textContent = str5;
    }

    public /* synthetic */ ThumbBean(String str, String str2, String str3, String str4, int i8, long j8, String str5, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? null : str, (i9 & 2) != 0 ? "" : str2, (i9 & 4) != 0 ? null : str3, (i9 & 8) != 0 ? null : str4, (i9 & 16) != 0 ? 0 : i8, (i9 & 32) != 0 ? 0L : j8, (i9 & 64) != 0 ? null : str5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThumbBean(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
