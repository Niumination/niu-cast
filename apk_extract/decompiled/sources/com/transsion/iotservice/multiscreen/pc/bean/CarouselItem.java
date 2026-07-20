package com.transsion.iotservice.multiscreen.pc.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/CarouselItem;", "", "id", "", "lottie", "Lcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;", "<init>", "(ILcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;)V", "getId", "()I", "getLottie", "()Lcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class CarouselItem {

    @SerializedName("id")
    private final int id;

    @SerializedName("lottie")
    private final LottieAsset lottie;

    public CarouselItem(int i8, LottieAsset lottie) {
        Intrinsics.checkNotNullParameter(lottie, "lottie");
        this.id = i8;
        this.lottie = lottie;
    }

    public static /* synthetic */ CarouselItem copy$default(CarouselItem carouselItem, int i8, LottieAsset lottieAsset, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = carouselItem.id;
        }
        if ((i9 & 2) != 0) {
            lottieAsset = carouselItem.lottie;
        }
        return carouselItem.copy(i8, lottieAsset);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LottieAsset getLottie() {
        return this.lottie;
    }

    public final CarouselItem copy(int id2, LottieAsset lottie) {
        Intrinsics.checkNotNullParameter(lottie, "lottie");
        return new CarouselItem(id2, lottie);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CarouselItem)) {
            return false;
        }
        CarouselItem carouselItem = (CarouselItem) other;
        return this.id == carouselItem.id && Intrinsics.areEqual(this.lottie, carouselItem.lottie);
    }

    public final int getId() {
        return this.id;
    }

    public final LottieAsset getLottie() {
        return this.lottie;
    }

    public int hashCode() {
        return this.lottie.hashCode() + (Integer.hashCode(this.id) * 31);
    }

    public String toString() {
        return "CarouselItem(id=" + this.id + ", lottie=" + this.lottie + ")";
    }
}
