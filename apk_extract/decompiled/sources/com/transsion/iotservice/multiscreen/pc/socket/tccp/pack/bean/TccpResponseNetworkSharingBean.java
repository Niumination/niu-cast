package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TccpResponseNetworkSharingBean;", "Ljava/io/Serializable;", "isSuccess", "", "statusCode", "", "<init>", "(ZI)V", "()Z", "setSuccess", "(Z)V", "getStatusCode", "()I", "setStatusCode", "(I)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TccpResponseNetworkSharingBean implements Serializable {
    public static final int LOCAL_SWITCH_CLOSED = 1;
    public static final int SUCCEEDED = 0;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("statusCode")
    private int statusCode;

    public TccpResponseNetworkSharingBean(boolean z2, int i8) {
        this.isSuccess = z2;
        this.statusCode = i8;
    }

    public static /* synthetic */ TccpResponseNetworkSharingBean copy$default(TccpResponseNetworkSharingBean tccpResponseNetworkSharingBean, boolean z2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            z2 = tccpResponseNetworkSharingBean.isSuccess;
        }
        if ((i9 & 2) != 0) {
            i8 = tccpResponseNetworkSharingBean.statusCode;
        }
        return tccpResponseNetworkSharingBean.copy(z2, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    public final TccpResponseNetworkSharingBean copy(boolean isSuccess, int statusCode) {
        return new TccpResponseNetworkSharingBean(isSuccess, statusCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TccpResponseNetworkSharingBean)) {
            return false;
        }
        TccpResponseNetworkSharingBean tccpResponseNetworkSharingBean = (TccpResponseNetworkSharingBean) other;
        return this.isSuccess == tccpResponseNetworkSharingBean.isSuccess && this.statusCode == tccpResponseNetworkSharingBean.statusCode;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        return Integer.hashCode(this.statusCode) + (Boolean.hashCode(this.isSuccess) * 31);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setStatusCode(int i8) {
        this.statusCode = i8;
    }

    public final void setSuccess(boolean z2) {
        this.isSuccess = z2;
    }

    public String toString() {
        return "TccpResponseNetworkSharingBean(isSuccess=" + this.isSuccess + ", statusCode=" + this.statusCode + ")";
    }

    public /* synthetic */ TccpResponseNetworkSharingBean(boolean z2, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, (i9 & 2) != 0 ? 0 : i8);
    }
}
