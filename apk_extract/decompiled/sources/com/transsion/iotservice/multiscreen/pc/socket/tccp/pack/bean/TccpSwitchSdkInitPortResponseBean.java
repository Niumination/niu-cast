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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TccpSwitchSdkInitPortResponseBean;", "", "brandName", "", "deviceName", "mac", "modelId", "deviceType", "modelName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandName", "()Ljava/lang/String;", "getDeviceName", "getMac", "getModelId", "getDeviceType", "getModelName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TccpSwitchSdkInitPortResponseBean {

    @SerializedName("brandName")
    private final String brandName;

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

    public TccpSwitchSdkInitPortResponseBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ TccpSwitchSdkInitPortResponseBean copy$default(TccpSwitchSdkInitPortResponseBean tccpSwitchSdkInitPortResponseBean, String str, String str2, String str3, String str4, String str5, String str6, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = tccpSwitchSdkInitPortResponseBean.brandName;
        }
        if ((i8 & 2) != 0) {
            str2 = tccpSwitchSdkInitPortResponseBean.deviceName;
        }
        String str7 = str2;
        if ((i8 & 4) != 0) {
            str3 = tccpSwitchSdkInitPortResponseBean.mac;
        }
        String str8 = str3;
        if ((i8 & 8) != 0) {
            str4 = tccpSwitchSdkInitPortResponseBean.modelId;
        }
        String str9 = str4;
        if ((i8 & 16) != 0) {
            str5 = tccpSwitchSdkInitPortResponseBean.deviceType;
        }
        String str10 = str5;
        if ((i8 & 32) != 0) {
            str6 = tccpSwitchSdkInitPortResponseBean.modelName;
        }
        return tccpSwitchSdkInitPortResponseBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBrandName() {
        return this.brandName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMac() {
        return this.mac;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    public final TccpSwitchSdkInitPortResponseBean copy(String brandName, String deviceName, String mac, String modelId, String deviceType, String modelName) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        return new TccpSwitchSdkInitPortResponseBean(brandName, deviceName, mac, modelId, deviceType, modelName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TccpSwitchSdkInitPortResponseBean)) {
            return false;
        }
        TccpSwitchSdkInitPortResponseBean tccpSwitchSdkInitPortResponseBean = (TccpSwitchSdkInitPortResponseBean) other;
        return Intrinsics.areEqual(this.brandName, tccpSwitchSdkInitPortResponseBean.brandName) && Intrinsics.areEqual(this.deviceName, tccpSwitchSdkInitPortResponseBean.deviceName) && Intrinsics.areEqual(this.mac, tccpSwitchSdkInitPortResponseBean.mac) && Intrinsics.areEqual(this.modelId, tccpSwitchSdkInitPortResponseBean.modelId) && Intrinsics.areEqual(this.deviceType, tccpSwitchSdkInitPortResponseBean.deviceType) && Intrinsics.areEqual(this.modelName, tccpSwitchSdkInitPortResponseBean.modelName);
    }

    public final String getBrandName() {
        return this.brandName;
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

    public int hashCode() {
        return this.modelName.hashCode() + a.e(a.e(a.e(a.e(this.brandName.hashCode() * 31, 31, this.deviceName), 31, this.mac), 31, this.modelId), 31, this.deviceType);
    }

    public String toString() {
        String str = this.brandName;
        String str2 = this.deviceName;
        String str3 = this.mac;
        String str4 = this.modelId;
        String str5 = this.deviceType;
        String str6 = this.modelName;
        StringBuilder sbP = h0.a.p("TccpSwitchSdkInitPortResponseBean(brandName=", str, ", deviceName=", str2, ", mac=");
        d.A(sbP, str3, ", modelId=", str4, ", deviceType=");
        sbP.append(str5);
        sbP.append(", modelName=");
        sbP.append(str6);
        sbP.append(")");
        return sbP.toString();
    }

    public TccpSwitchSdkInitPortResponseBean(String brandName, String deviceName, String mac, String modelId, String deviceType, String modelName) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        this.brandName = brandName;
        this.deviceName = deviceName;
        this.mac = mac;
        this.modelId = modelId;
        this.deviceType = deviceType;
        this.modelName = modelName;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TccpSwitchSdkInitPortResponseBean(String str, String str2, String str3, String str4, String str5, String str6, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        String address;
        str = (i8 & 1) != 0 ? Build.BRAND : str;
        String string = (i8 & 2) != 0 ? Settings.Global.getString(pb.a().getContentResolver(), "device_name") : str2;
        if ((i8 & 4) != 0) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            str3 = (defaultAdapter == null || (address = defaultAdapter.getAddress()) == null) ? b.f7956b.f7957a.e() : address;
        }
        String str7 = str3;
        if ((i8 & 8) != 0) {
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            str4 = tb.b(BRAND);
        }
        this(str, string, str7, str4, (i8 & 16) != 0 ? sb.a(pb.a()) : str5, (i8 & 32) != 0 ? Build.MODEL : str6);
    }
}
