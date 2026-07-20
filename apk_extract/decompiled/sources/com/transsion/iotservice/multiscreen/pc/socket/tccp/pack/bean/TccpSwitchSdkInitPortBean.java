package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import a1.a;
import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.provider.Settings;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import k3.pb;
import k3.sb;
import k3.tb;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ma.b;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TccpSwitchSdkInitPortBean;", "", "port", "", "brandName", "", "deviceName", "mac", "connectType", "modelId", "deviceType", "modelName", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPort", "()I", "getBrandName", "()Ljava/lang/String;", "getDeviceName", "getMac", "getConnectType", "getModelId", "getDeviceType", "getModelName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TccpSwitchSdkInitPortBean {

    @SerializedName("brandName")
    private final String brandName;

    @SerializedName("connectType")
    private final int connectType;

    @SerializedName("deviceName")
    private final String deviceName;

    @SerializedName("deviceType")
    private final String deviceType;

    @SerializedName("mac")
    private final String mac;

    @SerializedName("modelId")
    private final String modelId;

    @SerializedName("modelName")
    private final String modelName;

    @SerializedName("port")
    private final int port;

    public TccpSwitchSdkInitPortBean(int i8, String brandName, String deviceName, String mac, int i9, String modelId, String deviceType, String modelName) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        this.port = i8;
        this.brandName = brandName;
        this.deviceName = deviceName;
        this.mac = mac;
        this.connectType = i9;
        this.modelId = modelId;
        this.deviceType = deviceType;
        this.modelName = modelName;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBrandName() {
        return this.brandName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMac() {
        return this.mac;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getConnectType() {
        return this.connectType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    public final TccpSwitchSdkInitPortBean copy(int port, String brandName, String deviceName, String mac, int connectType, String modelId, String deviceType, String modelName) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        return new TccpSwitchSdkInitPortBean(port, brandName, deviceName, mac, connectType, modelId, deviceType, modelName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TccpSwitchSdkInitPortBean)) {
            return false;
        }
        TccpSwitchSdkInitPortBean tccpSwitchSdkInitPortBean = (TccpSwitchSdkInitPortBean) other;
        return this.port == tccpSwitchSdkInitPortBean.port && Intrinsics.areEqual(this.brandName, tccpSwitchSdkInitPortBean.brandName) && Intrinsics.areEqual(this.deviceName, tccpSwitchSdkInitPortBean.deviceName) && Intrinsics.areEqual(this.mac, tccpSwitchSdkInitPortBean.mac) && this.connectType == tccpSwitchSdkInitPortBean.connectType && Intrinsics.areEqual(this.modelId, tccpSwitchSdkInitPortBean.modelId) && Intrinsics.areEqual(this.deviceType, tccpSwitchSdkInitPortBean.deviceType) && Intrinsics.areEqual(this.modelName, tccpSwitchSdkInitPortBean.modelName);
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final int getConnectType() {
        return this.connectType;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getMac() {
        return this.mac;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final int getPort() {
        return this.port;
    }

    public int hashCode() {
        return this.modelName.hashCode() + a.e(a.e(a.c(this.connectType, a.e(a.e(a.e(Integer.hashCode(this.port) * 31, 31, this.brandName), 31, this.deviceName), 31, this.mac), 31), 31, this.modelId), 31, this.deviceType);
    }

    public String toString() {
        int i8 = this.port;
        String str = this.brandName;
        String str2 = this.deviceName;
        String str3 = this.mac;
        int i9 = this.connectType;
        String str4 = this.modelId;
        String str5 = this.deviceType;
        String str6 = this.modelName;
        StringBuilder sb2 = new StringBuilder("TccpSwitchSdkInitPortBean(port=");
        sb2.append(i8);
        sb2.append(", brandName=");
        sb2.append(str);
        sb2.append(", deviceName=");
        d.A(sb2, str2, ", mac=", str3, ", connectType=");
        sb2.append(i9);
        sb2.append(", modelId=");
        sb2.append(str4);
        sb2.append(", deviceType=");
        sb2.append(str5);
        sb2.append(", modelName=");
        sb2.append(str6);
        sb2.append(")");
        return sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TccpSwitchSdkInitPortBean(int i8, String str, String str2, String str3, int i9, String str4, String str5, String str6, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        String strE;
        String strB;
        String address;
        String str7 = (i10 & 2) != 0 ? Build.BRAND : str;
        String string = (i10 & 4) != 0 ? Settings.Global.getString(pb.a().getContentResolver(), "device_name") : str2;
        if ((i10 & 8) != 0) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            strE = (defaultAdapter == null || (address = defaultAdapter.getAddress()) == null) ? b.f7956b.f7957a.e() : address;
        } else {
            strE = str3;
        }
        if ((i10 & 32) != 0) {
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            strB = tb.b(BRAND);
        } else {
            strB = str4;
        }
        this(i8, str7, string, strE, i9, strB, (i10 & 64) != 0 ? sb.a(pb.a()) : str5, (i10 & 128) != 0 ? Build.MODEL : str6);
    }
}
