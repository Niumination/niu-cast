package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;", "", "path", "", "supportDayNight", "", "containImage", "<init>", "(Ljava/lang/String;ZZ)V", "getPath", "()Ljava/lang/String;", "getSupportDayNight", "()Z", "getContainImage", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class LottieAsset {

    @SerializedName("containImage")
    private final boolean containImage;

    @SerializedName("path")
    private final String path;

    @SerializedName("supportDayNight")
    private final boolean supportDayNight;

    public LottieAsset(String path, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.supportDayNight = z2;
        this.containImage = z3;
    }

    public static /* synthetic */ LottieAsset copy$default(LottieAsset lottieAsset, String str, boolean z2, boolean z3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = lottieAsset.path;
        }
        if ((i8 & 2) != 0) {
            z2 = lottieAsset.supportDayNight;
        }
        if ((i8 & 4) != 0) {
            z3 = lottieAsset.containImage;
        }
        return lottieAsset.copy(str, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSupportDayNight() {
        return this.supportDayNight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getContainImage() {
        return this.containImage;
    }

    public final LottieAsset copy(String path, boolean supportDayNight, boolean containImage) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new LottieAsset(path, supportDayNight, containImage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LottieAsset)) {
            return false;
        }
        LottieAsset lottieAsset = (LottieAsset) other;
        return Intrinsics.areEqual(this.path, lottieAsset.path) && this.supportDayNight == lottieAsset.supportDayNight && this.containImage == lottieAsset.containImage;
    }

    public final boolean getContainImage() {
        return this.containImage;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean getSupportDayNight() {
        return this.supportDayNight;
    }

    public int hashCode() {
        return Boolean.hashCode(this.containImage) + a.g(this.supportDayNight, this.path.hashCode() * 31, 31);
    }

    public String toString() {
        return "LottieAsset(path=" + this.path + ", supportDayNight=" + this.supportDayNight + ", containImage=" + this.containImage + ")";
    }

    public /* synthetic */ LottieAsset(String str, boolean z2, boolean z3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? true : z2, (i8 & 4) != 0 ? true : z3);
    }
}
