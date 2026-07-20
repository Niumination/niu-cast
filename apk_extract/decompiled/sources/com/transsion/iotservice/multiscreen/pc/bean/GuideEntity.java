package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006'"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/GuideEntity;", "Landroid/os/Parcelable;", "order", "", "title", "", "desc", "url", "md5", "suppVer", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOrder", "()I", "getTitle", "()Ljava/lang/String;", "getDesc", "getUrl", "getMd5", "getSuppVer", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class GuideEntity implements Parcelable {
    public static final Parcelable.Creator<GuideEntity> CREATOR = new Creator();

    @SerializedName("desc")
    private final String desc;

    @SerializedName("md5")
    private final String md5;

    @SerializedName("order")
    private final int order;

    @SerializedName("suppVer")
    private final String suppVer;

    @SerializedName("title")
    private final String title;

    @SerializedName("url")
    private final String url;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Creator implements Parcelable.Creator<GuideEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuideEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuideEntity(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GuideEntity[] newArray(int i8) {
            return new GuideEntity[i8];
        }
    }

    public GuideEntity(int i8, String title, String desc, String url, String md5, String suppVer) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(suppVer, "suppVer");
        this.order = i8;
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.md5 = md5;
        this.suppVer = suppVer;
    }

    public static /* synthetic */ GuideEntity copy$default(GuideEntity guideEntity, int i8, String str, String str2, String str3, String str4, String str5, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = guideEntity.order;
        }
        if ((i9 & 2) != 0) {
            str = guideEntity.title;
        }
        String str6 = str;
        if ((i9 & 4) != 0) {
            str2 = guideEntity.desc;
        }
        String str7 = str2;
        if ((i9 & 8) != 0) {
            str3 = guideEntity.url;
        }
        String str8 = str3;
        if ((i9 & 16) != 0) {
            str4 = guideEntity.md5;
        }
        String str9 = str4;
        if ((i9 & 32) != 0) {
            str5 = guideEntity.suppVer;
        }
        return guideEntity.copy(i8, str6, str7, str8, str9, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSuppVer() {
        return this.suppVer;
    }

    public final GuideEntity copy(int order, String title, String desc, String url, String md5, String suppVer) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(suppVer, "suppVer");
        return new GuideEntity(order, title, desc, url, md5, suppVer);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuideEntity)) {
            return false;
        }
        GuideEntity guideEntity = (GuideEntity) other;
        return this.order == guideEntity.order && Intrinsics.areEqual(this.title, guideEntity.title) && Intrinsics.areEqual(this.desc, guideEntity.desc) && Intrinsics.areEqual(this.url, guideEntity.url) && Intrinsics.areEqual(this.md5, guideEntity.md5) && Intrinsics.areEqual(this.suppVer, guideEntity.suppVer);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getSuppVer() {
        return this.suppVer;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.suppVer.hashCode() + a.e(a.e(a.e(a.e(Integer.hashCode(this.order) * 31, 31, this.title), 31, this.desc), 31, this.url), 31, this.md5);
    }

    public String toString() {
        int i8 = this.order;
        String str = this.title;
        String str2 = this.desc;
        String str3 = this.url;
        String str4 = this.md5;
        String str5 = this.suppVer;
        StringBuilder sb2 = new StringBuilder("GuideEntity(order=");
        sb2.append(i8);
        sb2.append(", title=");
        sb2.append(str);
        sb2.append(", desc=");
        d.A(sb2, str2, ", url=", str3, ", md5=");
        sb2.append(str4);
        sb2.append(", suppVer=");
        sb2.append(str5);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.order);
        dest.writeString(this.title);
        dest.writeString(this.desc);
        dest.writeString(this.url);
        dest.writeString(this.md5);
        dest.writeString(this.suppVer);
    }
}
