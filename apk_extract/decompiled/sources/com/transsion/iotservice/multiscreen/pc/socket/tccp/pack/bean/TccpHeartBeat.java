package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TccpHeartBeat;", "", "heartbeatInterval", "", "<init>", "(J)V", "getHeartbeatInterval", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TccpHeartBeat {

    @SerializedName("heartbeatInterval")
    private final long heartbeatInterval;

    public TccpHeartBeat(long j8) {
        this.heartbeatInterval = j8;
    }

    public static /* synthetic */ TccpHeartBeat copy$default(TccpHeartBeat tccpHeartBeat, long j8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j8 = tccpHeartBeat.heartbeatInterval;
        }
        return tccpHeartBeat.copy(j8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getHeartbeatInterval() {
        return this.heartbeatInterval;
    }

    public final TccpHeartBeat copy(long heartbeatInterval) {
        return new TccpHeartBeat(heartbeatInterval);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TccpHeartBeat) && this.heartbeatInterval == ((TccpHeartBeat) other).heartbeatInterval;
    }

    public final long getHeartbeatInterval() {
        return this.heartbeatInterval;
    }

    public int hashCode() {
        return Long.hashCode(this.heartbeatInterval);
    }

    public String toString() {
        return "TccpHeartBeat(heartbeatInterval=" + this.heartbeatInterval + ")";
    }
}
