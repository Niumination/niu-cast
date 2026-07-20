package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/TrustDeviceBean;", "", "deviceId", "", "deviceName", "deviceType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceName", "getDeviceType", "()I", "position", "getPosition", "setPosition", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "getDeviceIconResource", "getCornersAngleType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TrustDeviceBean {
    private static final int DEVICE_TYPE_LAPTOP = 3;
    private static final int DEVICE_TYPE_PHONE = 1;
    private static final int DEVICE_TYPE_TABLET = 2;
    private static final int DEVICE_TYPE_UNKNOWN = 0;

    @SerializedName("deviceId")
    private final String deviceId;

    @SerializedName("deviceName")
    private final String deviceName;

    @SerializedName("deviceType")
    private final int deviceType;
    private transient int position;
    private transient int totalCount;

    public TrustDeviceBean(String deviceId, String deviceName, int i8) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceType = i8;
    }

    public static /* synthetic */ TrustDeviceBean copy$default(TrustDeviceBean trustDeviceBean, String str, String str2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = trustDeviceBean.deviceId;
        }
        if ((i9 & 2) != 0) {
            str2 = trustDeviceBean.deviceName;
        }
        if ((i9 & 4) != 0) {
            i8 = trustDeviceBean.deviceType;
        }
        return trustDeviceBean.copy(str, str2, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDeviceType() {
        return this.deviceType;
    }

    public final TrustDeviceBean copy(String deviceId, String deviceName, int deviceType) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        return new TrustDeviceBean(deviceId, deviceName, deviceType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrustDeviceBean)) {
            return false;
        }
        TrustDeviceBean trustDeviceBean = (TrustDeviceBean) other;
        return Intrinsics.areEqual(this.deviceId, trustDeviceBean.deviceId) && Intrinsics.areEqual(this.deviceName, trustDeviceBean.deviceName) && this.deviceType == trustDeviceBean.deviceType;
    }

    public final String getCornersAngleType() {
        int i8 = this.totalCount;
        if (i8 == 1) {
            return "round";
        }
        if (i8 != 2 || this.position != 0) {
            if (i8 != 2 || this.position != 1) {
                int i9 = this.position;
                if (i9 != 0) {
                    if (i9 != i8 - 1) {
                        return "right";
                    }
                }
            }
            return "bottom_corners_round";
        }
        return "top_corners_round";
    }

    public final int getDeviceIconResource() {
        int i8 = this.deviceType;
        if (i8 == 1) {
            return R$drawable.icon_phone;
        }
        if (i8 != 2) {
            return i8 != 3 ? R$drawable.icon_pc : R$drawable.icon_pc;
        }
        return R$drawable.icon_pad;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        return Integer.hashCode(this.deviceType) + a.e(this.deviceId.hashCode() * 31, 31, this.deviceName);
    }

    public final void setPosition(int i8) {
        this.position = i8;
    }

    public final void setTotalCount(int i8) {
        this.totalCount = i8;
    }

    public String toString() {
        String str = this.deviceId;
        String str2 = this.deviceName;
        return h0.a.m(h0.a.p("TrustDeviceBean(deviceId=", str, ", deviceName=", str2, ", deviceType="), ")", this.deviceType);
    }
}
