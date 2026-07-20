package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import com.transsion.message.bank.MessageBank;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/VapResource;", "", "path", "", "supportDayNight", "", MessageBank.KEY_TYPE, "", "name", "<init>", "(Ljava/lang/String;ZILjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getSupportDayNight", "()Z", "getType", "()I", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class VapResource {
    public static final int TYPE_ASSETS = 0;
    public static final int TYPE_FILE = 1;

    @SerializedName("name")
    private final String name;

    @SerializedName("path")
    private final String path;

    @SerializedName("supportDayNight")
    private final boolean supportDayNight;

    @SerializedName(MessageBank.KEY_TYPE)
    private final int type;

    public VapResource(String path, boolean z2, int i8, String name) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        this.path = path;
        this.supportDayNight = z2;
        this.type = i8;
        this.name = name;
    }

    public static /* synthetic */ VapResource copy$default(VapResource vapResource, String str, boolean z2, int i8, String str2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = vapResource.path;
        }
        if ((i9 & 2) != 0) {
            z2 = vapResource.supportDayNight;
        }
        if ((i9 & 4) != 0) {
            i8 = vapResource.type;
        }
        if ((i9 & 8) != 0) {
            str2 = vapResource.name;
        }
        return vapResource.copy(str, z2, i8, str2);
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
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final VapResource copy(String path, boolean supportDayNight, int type, String name) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        return new VapResource(path, supportDayNight, type, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VapResource)) {
            return false;
        }
        VapResource vapResource = (VapResource) other;
        return Intrinsics.areEqual(this.path, vapResource.path) && this.supportDayNight == vapResource.supportDayNight && this.type == vapResource.type && Intrinsics.areEqual(this.name, vapResource.name);
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean getSupportDayNight() {
        return this.supportDayNight;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.name.hashCode() + a.c(this.type, a.g(this.supportDayNight, this.path.hashCode() * 31, 31), 31);
    }

    public String toString() {
        return "VapResource(path=" + this.path + ", supportDayNight=" + this.supportDayNight + ", type=" + this.type + ", name=" + this.name + ")";
    }

    public /* synthetic */ VapResource(String str, boolean z2, int i8, String str2, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i9 & 2) != 0 ? true : z2, (i9 & 4) != 0 ? 0 : i8, (i9 & 8) != 0 ? "video.mp4" : str2);
    }
}
