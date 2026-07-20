package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na.b;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\tHÆ\u0003J8\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\"R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TCCPPacket;", "", "isResp", "", "operationFlag", "", "stateCode", "", "payloadJson", "", "<init>", "(Z[BLjava/lang/Integer;Ljava/lang/String;)V", "()Z", "getOperationFlag", "()[B", "getStateCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPayloadJson", "()Ljava/lang/String;", "getPayload", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "copy", "(Z[BLjava/lang/Integer;Ljava/lang/String;)Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TCCPPacket;", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TCCPPacket {

    @SerializedName("isResp")
    private final boolean isResp;

    @SerializedName("operationFlag")
    private final byte[] operationFlag;

    @SerializedName("payloadJson")
    private final String payloadJson;

    @SerializedName("stateCode")
    private final Integer stateCode;

    public TCCPPacket(boolean z2, byte[] operationFlag, Integer num, String payloadJson) {
        Intrinsics.checkNotNullParameter(operationFlag, "operationFlag");
        Intrinsics.checkNotNullParameter(payloadJson, "payloadJson");
        this.isResp = z2;
        this.operationFlag = operationFlag;
        this.stateCode = num;
        this.payloadJson = payloadJson;
    }

    public static /* synthetic */ TCCPPacket copy$default(TCCPPacket tCCPPacket, boolean z2, byte[] bArr, Integer num, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z2 = tCCPPacket.isResp;
        }
        if ((i8 & 2) != 0) {
            bArr = tCCPPacket.operationFlag;
        }
        if ((i8 & 4) != 0) {
            num = tCCPPacket.stateCode;
        }
        if ((i8 & 8) != 0) {
            str = tCCPPacket.payloadJson;
        }
        return tCCPPacket.copy(z2, bArr, num, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsResp() {
        return this.isResp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getOperationFlag() {
        return this.operationFlag;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getStateCode() {
        return this.stateCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPayloadJson() {
        return this.payloadJson;
    }

    public final TCCPPacket copy(boolean isResp, byte[] operationFlag, Integer stateCode, String payloadJson) {
        Intrinsics.checkNotNullParameter(operationFlag, "operationFlag");
        Intrinsics.checkNotNullParameter(payloadJson, "payloadJson");
        return new TCCPPacket(isResp, operationFlag, stateCode, payloadJson);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(TCCPPacket.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TCCPPacket");
        TCCPPacket tCCPPacket = (TCCPPacket) other;
        return this.isResp == tCCPPacket.isResp && Arrays.equals(this.operationFlag, tCCPPacket.operationFlag) && Intrinsics.areEqual(this.stateCode, tCCPPacket.stateCode) && Intrinsics.areEqual(this.payloadJson, tCCPPacket.payloadJson);
    }

    public final byte[] getOperationFlag() {
        return this.operationFlag;
    }

    public final <T> T getPayload(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (TextUtils.isEmpty(this.payloadJson)) {
            return null;
        }
        q qVar = b.f8132a;
        return (T) b.a(this.payloadJson, clazz);
    }

    public final String getPayloadJson() {
        return this.payloadJson;
    }

    public final Integer getStateCode() {
        return this.stateCode;
    }

    public int hashCode() {
        int iHashCode = (Arrays.hashCode(this.operationFlag) + (Boolean.hashCode(this.isResp) * 31)) * 31;
        Integer num = this.stateCode;
        return this.payloadJson.hashCode() + ((iHashCode + (num != null ? num.intValue() : 0)) * 31);
    }

    public final boolean isResp() {
        return this.isResp;
    }

    public String toString() {
        boolean z2 = this.isResp;
        String string = Arrays.toString(this.operationFlag);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return "TccpResultBean(isResp=" + z2 + ", operationFlag=" + string + ", stateCode=" + this.stateCode + ", payloadJson=" + this.payloadJson + ")";
    }
}
