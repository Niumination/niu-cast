package com.transsion.iotservice.multiscreen.pc.http.entity;

import a1.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0003J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/http/entity/PhoneDataEntity;", "Landroid/os/Parcelable;", "dataVersion", "", "<init>", "(I)V", "getDataVersion", "()I", "data", "", "Lcom/transsion/iotservice/multiscreen/pc/http/entity/PhoneDataEntity$PhoneInfo;", "getData$annotations", "()V", "getData", "()Ljava/util/List;", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "PhoneInfo", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class PhoneDataEntity implements Parcelable {
    public static final Parcelable.Creator<PhoneDataEntity> CREATOR = new Creator();

    @SerializedName("data")
    private final List<PhoneInfo> data;
    private final int dataVersion;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Creator implements Parcelable.Creator<PhoneDataEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneDataEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhoneDataEntity(parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneDataEntity[] newArray(int i8) {
            return new PhoneDataEntity[i8];
        }
    }

    @Keep
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006#"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/http/entity/PhoneDataEntity$PhoneInfo;", "Landroid/os/Parcelable;", "model", "", "series", "modelId", "imageUrl", "brand", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getSeries", "getModelId", "getImageUrl", "getBrand", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class PhoneInfo implements Parcelable {
        public static final Parcelable.Creator<PhoneInfo> CREATOR = new Creator();

        @SerializedName("brand")
        private final String brand;

        @SerializedName("imageUrl")
        private final String imageUrl;

        @SerializedName("model")
        private final String model;

        @SerializedName("modelId")
        private final String modelId;

        @SerializedName("series")
        private final String series;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Creator implements Parcelable.Creator<PhoneInfo> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PhoneInfo createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PhoneInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PhoneInfo[] newArray(int i8) {
                return new PhoneInfo[i8];
            }
        }

        public PhoneInfo(String str, String str2, String modelId, String str3, String str4) {
            Intrinsics.checkNotNullParameter(modelId, "modelId");
            this.model = str;
            this.series = str2;
            this.modelId = modelId;
            this.imageUrl = str3;
            this.brand = str4;
        }

        public static /* synthetic */ PhoneInfo copy$default(PhoneInfo phoneInfo, String str, String str2, String str3, String str4, String str5, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = phoneInfo.model;
            }
            if ((i8 & 2) != 0) {
                str2 = phoneInfo.series;
            }
            String str6 = str2;
            if ((i8 & 4) != 0) {
                str3 = phoneInfo.modelId;
            }
            String str7 = str3;
            if ((i8 & 8) != 0) {
                str4 = phoneInfo.imageUrl;
            }
            String str8 = str4;
            if ((i8 & 16) != 0) {
                str5 = phoneInfo.brand;
            }
            return phoneInfo.copy(str, str6, str7, str8, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSeries() {
            return this.series;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getModelId() {
            return this.modelId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        public final PhoneInfo copy(String model, String series, String modelId, String imageUrl, String brand) {
            Intrinsics.checkNotNullParameter(modelId, "modelId");
            return new PhoneInfo(model, series, modelId, imageUrl, brand);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PhoneInfo)) {
                return false;
            }
            PhoneInfo phoneInfo = (PhoneInfo) other;
            return Intrinsics.areEqual(this.model, phoneInfo.model) && Intrinsics.areEqual(this.series, phoneInfo.series) && Intrinsics.areEqual(this.modelId, phoneInfo.modelId) && Intrinsics.areEqual(this.imageUrl, phoneInfo.imageUrl) && Intrinsics.areEqual(this.brand, phoneInfo.brand);
        }

        public final String getBrand() {
            return this.brand;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getModel() {
            return this.model;
        }

        public final String getModelId() {
            return this.modelId;
        }

        public final String getSeries() {
            return this.series;
        }

        public int hashCode() {
            String str = this.model;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.series;
            int iE = a.e((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.modelId);
            String str3 = this.imageUrl;
            int iHashCode2 = (iE + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.brand;
            return iHashCode2 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            String str = this.model;
            String str2 = this.series;
            String str3 = this.modelId;
            String str4 = this.imageUrl;
            String str5 = this.brand;
            StringBuilder sbP = h0.a.p("PhoneInfo(model=", str, ", series=", str2, ", modelId=");
            d.A(sbP, str3, ", imageUrl=", str4, ", brand=");
            return h0.a.n(sbP, str5, ")");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.model);
            dest.writeString(this.series);
            dest.writeString(this.modelId);
            dest.writeString(this.imageUrl);
            dest.writeString(this.brand);
        }
    }

    public PhoneDataEntity(int i8) {
        this.dataVersion = i8;
    }

    public static /* synthetic */ PhoneDataEntity copy$default(PhoneDataEntity phoneDataEntity, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = phoneDataEntity.dataVersion;
        }
        return phoneDataEntity.copy(i8);
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDataVersion() {
        return this.dataVersion;
    }

    public final PhoneDataEntity copy(int dataVersion) {
        return new PhoneDataEntity(dataVersion);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PhoneDataEntity) && this.dataVersion == ((PhoneDataEntity) other).dataVersion;
    }

    public final List<PhoneInfo> getData() {
        return this.data;
    }

    public final int getDataVersion() {
        return this.dataVersion;
    }

    public int hashCode() {
        return Integer.hashCode(this.dataVersion);
    }

    public String toString() {
        return h0.a.h(this.dataVersion, "PhoneDataEntity(dataVersion=", ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.dataVersion);
    }
}
