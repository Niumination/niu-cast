package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/RoundedCardData;", "", "titleResId", "", "contentResId", "lightLottiePath", "", "darkLottiePath", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getTitleResId", "()I", "getContentResId", "getLightLottiePath", "()Ljava/lang/String;", "getDarkLottiePath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class RoundedCardData {

    @SerializedName("contentResId")
    private final int contentResId;

    @SerializedName("darkLottiePath")
    private final String darkLottiePath;

    @SerializedName("lightLottiePath")
    private final String lightLottiePath;

    @SerializedName("titleResId")
    private final int titleResId;

    public RoundedCardData(int i8, int i9, String lightLottiePath, String darkLottiePath) {
        Intrinsics.checkNotNullParameter(lightLottiePath, "lightLottiePath");
        Intrinsics.checkNotNullParameter(darkLottiePath, "darkLottiePath");
        this.titleResId = i8;
        this.contentResId = i9;
        this.lightLottiePath = lightLottiePath;
        this.darkLottiePath = darkLottiePath;
    }

    public static /* synthetic */ RoundedCardData copy$default(RoundedCardData roundedCardData, int i8, int i9, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = roundedCardData.titleResId;
        }
        if ((i10 & 2) != 0) {
            i9 = roundedCardData.contentResId;
        }
        if ((i10 & 4) != 0) {
            str = roundedCardData.lightLottiePath;
        }
        if ((i10 & 8) != 0) {
            str2 = roundedCardData.darkLottiePath;
        }
        return roundedCardData.copy(i8, i9, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitleResId() {
        return this.titleResId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getContentResId() {
        return this.contentResId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLightLottiePath() {
        return this.lightLottiePath;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDarkLottiePath() {
        return this.darkLottiePath;
    }

    public final RoundedCardData copy(int titleResId, int contentResId, String lightLottiePath, String darkLottiePath) {
        Intrinsics.checkNotNullParameter(lightLottiePath, "lightLottiePath");
        Intrinsics.checkNotNullParameter(darkLottiePath, "darkLottiePath");
        return new RoundedCardData(titleResId, contentResId, lightLottiePath, darkLottiePath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoundedCardData)) {
            return false;
        }
        RoundedCardData roundedCardData = (RoundedCardData) other;
        return this.titleResId == roundedCardData.titleResId && this.contentResId == roundedCardData.contentResId && Intrinsics.areEqual(this.lightLottiePath, roundedCardData.lightLottiePath) && Intrinsics.areEqual(this.darkLottiePath, roundedCardData.darkLottiePath);
    }

    public final int getContentResId() {
        return this.contentResId;
    }

    public final String getDarkLottiePath() {
        return this.darkLottiePath;
    }

    public final String getLightLottiePath() {
        return this.lightLottiePath;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public int hashCode() {
        return this.darkLottiePath.hashCode() + a.e(a.c(this.contentResId, Integer.hashCode(this.titleResId) * 31, 31), 31, this.lightLottiePath);
    }

    public String toString() {
        int i8 = this.titleResId;
        int i9 = this.contentResId;
        String str = this.lightLottiePath;
        String str2 = this.darkLottiePath;
        StringBuilder sbR = d.r(i8, i9, "RoundedCardData(titleResId=", ", contentResId=", ", lightLottiePath=");
        sbR.append(str);
        sbR.append(", darkLottiePath=");
        sbR.append(str2);
        sbR.append(")");
        return sbR.toString();
    }
}
