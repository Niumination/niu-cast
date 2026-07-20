package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JH\u0010\u001a\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/SettingItem;", "", "data", "Ljava/util/ArrayList;", "Lcom/transsion/iotservice/multiscreen/pc/bean/LottieItem;", "Lkotlin/collections/ArrayList;", "title", "", "desc", "enableSwitchStateFromParentView", "", "<init>", "(Ljava/util/ArrayList;ILjava/lang/Integer;Z)V", "getData", "()Ljava/util/ArrayList;", "getTitle", "()I", "getDesc", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableSwitchStateFromParentView", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/ArrayList;ILjava/lang/Integer;Z)Lcom/transsion/iotservice/multiscreen/pc/bean/SettingItem;", "equals", "other", "hashCode", "toString", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class SettingItem {

    @SerializedName("data")
    private final ArrayList<LottieItem> data;

    @SerializedName("desc")
    private final Integer desc;

    @SerializedName("enableSwitchStateFromParentView")
    private final boolean enableSwitchStateFromParentView;

    @SerializedName("title")
    private final int title;

    public SettingItem(ArrayList<LottieItem> data, @StringRes int i8, @StringRes Integer num, boolean z2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.title = i8;
        this.desc = num;
        this.enableSwitchStateFromParentView = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingItem copy$default(SettingItem settingItem, ArrayList arrayList, int i8, Integer num, boolean z2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            arrayList = settingItem.data;
        }
        if ((i9 & 2) != 0) {
            i8 = settingItem.title;
        }
        if ((i9 & 4) != 0) {
            num = settingItem.desc;
        }
        if ((i9 & 8) != 0) {
            z2 = settingItem.enableSwitchStateFromParentView;
        }
        return settingItem.copy(arrayList, i8, num, z2);
    }

    public final ArrayList<LottieItem> component1() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getEnableSwitchStateFromParentView() {
        return this.enableSwitchStateFromParentView;
    }

    public final SettingItem copy(ArrayList<LottieItem> data, @StringRes int title, @StringRes Integer desc, boolean enableSwitchStateFromParentView) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new SettingItem(data, title, desc, enableSwitchStateFromParentView);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingItem)) {
            return false;
        }
        SettingItem settingItem = (SettingItem) other;
        return Intrinsics.areEqual(this.data, settingItem.data) && this.title == settingItem.title && Intrinsics.areEqual(this.desc, settingItem.desc) && this.enableSwitchStateFromParentView == settingItem.enableSwitchStateFromParentView;
    }

    public final ArrayList<LottieItem> getData() {
        return this.data;
    }

    public final Integer getDesc() {
        return this.desc;
    }

    public final boolean getEnableSwitchStateFromParentView() {
        return this.enableSwitchStateFromParentView;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iC = a.c(this.title, this.data.hashCode() * 31, 31);
        Integer num = this.desc;
        return Boolean.hashCode(this.enableSwitchStateFromParentView) + ((iC + (num == null ? 0 : num.hashCode())) * 31);
    }

    public String toString() {
        return "SettingItem(data=" + this.data + ", title=" + this.title + ", desc=" + this.desc + ", enableSwitchStateFromParentView=" + this.enableSwitchStateFromParentView + ")";
    }

    public /* synthetic */ SettingItem(ArrayList arrayList, int i8, Integer num, boolean z2, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, i8, (i9 & 4) != 0 ? null : num, (i9 & 8) != 0 ? true : z2);
    }
}
