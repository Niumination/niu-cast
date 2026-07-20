package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TccpDisConnectSocketBean;", "", "isDisconnect", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TccpDisConnectSocketBean {

    @SerializedName("isDisconnect")
    private final boolean isDisconnect;

    public TccpDisConnectSocketBean() {
        this(false, 1, null);
    }

    public static /* synthetic */ TccpDisConnectSocketBean copy$default(TccpDisConnectSocketBean tccpDisConnectSocketBean, boolean z2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z2 = tccpDisConnectSocketBean.isDisconnect;
        }
        return tccpDisConnectSocketBean.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsDisconnect() {
        return this.isDisconnect;
    }

    public final TccpDisConnectSocketBean copy(boolean isDisconnect) {
        return new TccpDisConnectSocketBean(isDisconnect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TccpDisConnectSocketBean) && this.isDisconnect == ((TccpDisConnectSocketBean) other).isDisconnect;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isDisconnect);
    }

    public final boolean isDisconnect() {
        return this.isDisconnect;
    }

    public String toString() {
        return "TccpDisConnectSocketBean(isDisconnect=" + this.isDisconnect + ")";
    }

    public TccpDisConnectSocketBean(boolean z2) {
        this.isDisconnect = z2;
    }

    public /* synthetic */ TccpDisConnectSocketBean(boolean z2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z2);
    }
}
