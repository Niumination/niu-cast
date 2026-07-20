package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/LottieItem;", "", "id", "", "title", "desc", "lottie", "Lcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;", "<init>", "(IIILcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;)V", "getId", "()I", "getTitle", "getDesc", "getLottie", "()Lcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class LottieItem {

    @SerializedName("desc")
    private final int desc;

    @SerializedName("id")
    private final int id;

    @SerializedName("lottie")
    private final LottieAsset lottie;

    @SerializedName("title")
    private final int title;

    public LottieItem(int i8, int i9, int i10, LottieAsset lottie) {
        Intrinsics.checkNotNullParameter(lottie, "lottie");
        this.id = i8;
        this.title = i9;
        this.desc = i10;
        this.lottie = lottie;
    }

    public static /* synthetic */ LottieItem copy$default(LottieItem lottieItem, int i8, int i9, int i10, LottieAsset lottieAsset, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i8 = lottieItem.id;
        }
        if ((i11 & 2) != 0) {
            i9 = lottieItem.title;
        }
        if ((i11 & 4) != 0) {
            i10 = lottieItem.desc;
        }
        if ((i11 & 8) != 0) {
            lottieAsset = lottieItem.lottie;
        }
        return lottieItem.copy(i8, i9, i10, lottieAsset);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final LottieAsset getLottie() {
        return this.lottie;
    }

    public final LottieItem copy(int id2, int title, int desc, LottieAsset lottie) {
        Intrinsics.checkNotNullParameter(lottie, "lottie");
        return new LottieItem(id2, title, desc, lottie);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LottieItem)) {
            return false;
        }
        LottieItem lottieItem = (LottieItem) other;
        return this.id == lottieItem.id && this.title == lottieItem.title && this.desc == lottieItem.desc && Intrinsics.areEqual(this.lottie, lottieItem.lottie);
    }

    public final int getDesc() {
        return this.desc;
    }

    public final int getId() {
        return this.id;
    }

    public final LottieAsset getLottie() {
        return this.lottie;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.lottie.hashCode() + a.c(this.desc, a.c(this.title, Integer.hashCode(this.id) * 31, 31), 31);
    }

    public String toString() {
        int i8 = this.id;
        int i9 = this.title;
        int i10 = this.desc;
        LottieAsset lottieAsset = this.lottie;
        StringBuilder sbR = d.r(i8, i9, "LottieItem(id=", ", title=", ", desc=");
        sbR.append(i10);
        sbR.append(", lottie=");
        sbR.append(lottieAsset);
        sbR.append(")");
        return sbR.toString();
    }
}
