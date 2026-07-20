package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0003J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/FunctionGuideResponse;", "Landroid/os/Parcelable;", "count", "", "version", "info", "", "guide", "", "Lcom/transsion/iotservice/multiscreen/pc/bean/GuideEntity;", "<init>", "(IILjava/lang/String;Ljava/util/List;)V", "getCount", "()I", "getVersion", "getInfo", "()Ljava/lang/String;", "getGuide", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class FunctionGuideResponse implements Parcelable {
    public static final Parcelable.Creator<FunctionGuideResponse> CREATOR = new Creator();

    @SerializedName("count")
    private final int count;

    @SerializedName("guide")
    private final List<GuideEntity> guide;

    @SerializedName("info")
    private final String info;

    @SerializedName("version")
    private final int version;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Creator implements Parcelable.Creator<FunctionGuideResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FunctionGuideResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i8 = parcel.readInt();
            int i9 = parcel.readInt();
            String string = parcel.readString();
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                arrayList.add(GuideEntity.CREATOR.createFromParcel(parcel));
            }
            return new FunctionGuideResponse(i8, i9, string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FunctionGuideResponse[] newArray(int i8) {
            return new FunctionGuideResponse[i8];
        }
    }

    public FunctionGuideResponse(int i8, int i9, String info, List<GuideEntity> guide) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(guide, "guide");
        this.count = i8;
        this.version = i9;
        this.info = info;
        this.guide = guide;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FunctionGuideResponse copy$default(FunctionGuideResponse functionGuideResponse, int i8, int i9, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = functionGuideResponse.count;
        }
        if ((i10 & 2) != 0) {
            i9 = functionGuideResponse.version;
        }
        if ((i10 & 4) != 0) {
            str = functionGuideResponse.info;
        }
        if ((i10 & 8) != 0) {
            list = functionGuideResponse.guide;
        }
        return functionGuideResponse.copy(i8, i9, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    public final List<GuideEntity> component4() {
        return this.guide;
    }

    public final FunctionGuideResponse copy(int count, int version, String info, List<GuideEntity> guide) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(guide, "guide");
        return new FunctionGuideResponse(count, version, info, guide);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionGuideResponse)) {
            return false;
        }
        FunctionGuideResponse functionGuideResponse = (FunctionGuideResponse) other;
        return this.count == functionGuideResponse.count && this.version == functionGuideResponse.version && Intrinsics.areEqual(this.info, functionGuideResponse.info) && Intrinsics.areEqual(this.guide, functionGuideResponse.guide);
    }

    public final int getCount() {
        return this.count;
    }

    public final List<GuideEntity> getGuide() {
        return this.guide;
    }

    public final String getInfo() {
        return this.info;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.guide.hashCode() + a.e(a.c(this.version, Integer.hashCode(this.count) * 31, 31), 31, this.info);
    }

    public String toString() {
        int i8 = this.count;
        int i9 = this.version;
        String str = this.info;
        List<GuideEntity> list = this.guide;
        StringBuilder sbR = d.r(i8, i9, "FunctionGuideResponse(count=", ", version=", ", info=");
        sbR.append(str);
        sbR.append(", guide=");
        sbR.append(list);
        sbR.append(")");
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.count);
        dest.writeInt(this.version);
        dest.writeString(this.info);
        List<GuideEntity> list = this.guide;
        dest.writeInt(list.size());
        Iterator<GuideEntity> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }
}
