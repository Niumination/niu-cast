package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TccpSwitchAbilityBean;", "", "contents", "", "Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/AbilityBean;", "protocolVersion", "", "<init>", "(Ljava/util/List;I)V", "getContents", "()Ljava/util/List;", "getProtocolVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TccpSwitchAbilityBean {

    @SerializedName("contents")
    private final List<AbilityBean> contents;

    @SerializedName("protocolVersion")
    private final int protocolVersion;

    public TccpSwitchAbilityBean(List<AbilityBean> contents, int i8) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        this.contents = contents;
        this.protocolVersion = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TccpSwitchAbilityBean copy$default(TccpSwitchAbilityBean tccpSwitchAbilityBean, List list, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            list = tccpSwitchAbilityBean.contents;
        }
        if ((i9 & 2) != 0) {
            i8 = tccpSwitchAbilityBean.protocolVersion;
        }
        return tccpSwitchAbilityBean.copy(list, i8);
    }

    public final List<AbilityBean> component1() {
        return this.contents;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final TccpSwitchAbilityBean copy(List<AbilityBean> contents, int protocolVersion) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        return new TccpSwitchAbilityBean(contents, protocolVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TccpSwitchAbilityBean)) {
            return false;
        }
        TccpSwitchAbilityBean tccpSwitchAbilityBean = (TccpSwitchAbilityBean) other;
        return Intrinsics.areEqual(this.contents, tccpSwitchAbilityBean.contents) && this.protocolVersion == tccpSwitchAbilityBean.protocolVersion;
    }

    public final List<AbilityBean> getContents() {
        return this.contents;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public int hashCode() {
        return Integer.hashCode(this.protocolVersion) + (this.contents.hashCode() * 31);
    }

    public String toString() {
        return "TccpSwitchAbilityBean(contents=" + this.contents + ", protocolVersion=" + this.protocolVersion + ")";
    }

    public /* synthetic */ TccpSwitchAbilityBean(List list, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i9 & 2) != 0 ? 0 : i8);
    }
}
