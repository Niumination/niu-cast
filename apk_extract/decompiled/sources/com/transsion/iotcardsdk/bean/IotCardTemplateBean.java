package com.transsion.iotcardsdk.bean;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u000234Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00100\u0010¢\u0006\u0002\u0010\u0011J\u0011\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0000H\u0096\u0002J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\bH&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR2\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00100\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%¨\u00065"}, d2 = {"Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "", "Ljava/io/Serializable;", "controlId", "", "packageName", "deviceSingleId", "deviceShowLevel", "", "deviceConnectedStatus", "", "deviceTypeId", "deviceLastConnectedTime", "", "sortLevel", "deviceServiceMap", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZIJILjava/util/Map;)V", "getControlId", "()Ljava/lang/String;", "setControlId", "(Ljava/lang/String;)V", "getDeviceConnectedStatus", "()Z", "setDeviceConnectedStatus", "(Z)V", "getDeviceLastConnectedTime", "()J", "setDeviceLastConnectedTime", "(J)V", "getDeviceServiceMap", "()Ljava/util/Map;", "setDeviceServiceMap", "(Ljava/util/Map;)V", "getDeviceShowLevel", "()I", "setDeviceShowLevel", "(I)V", "getDeviceSingleId", "setDeviceSingleId", "getDeviceTypeId", "setDeviceTypeId", "getPackageName", "setPackageName", "getSortLevel", "setSortLevel", "compareTo", "other", "getDataBundle", "Landroid/os/Bundle;", "getTemplateType", "Companion", "TemplateType", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class IotCardTemplateBean implements Comparable<IotCardTemplateBean>, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_TEMPLATE_ID = "key_control_id";
    public static final String KEY_TEMPLATE_TYPE = "key_template_type";
    public static final String TAG = "IotCardTemplateBean";
    public static final int TYPE_DISPLAY = 0;
    public static final int TYPE_EMPTY = 3;
    public static final int TYPE_ERROR = -1;
    public static final int TYPE_SWITCH = 1;
    private String controlId;
    private boolean deviceConnectedStatus;
    private long deviceLastConnectedTime;
    private Map<String, ? extends Map<String, String>> deviceServiceMap;
    private int deviceShowLevel;
    private String deviceSingleId;
    private int deviceTypeId;
    private String packageName;
    private int sortLevel;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean$Companion;", "", "()V", "KEY_TEMPLATE_ID", "", "KEY_TEMPLATE_TYPE", "TAG", "TYPE_DISPLAY", "", "TYPE_EMPTY", "TYPE_ERROR", "TYPE_SWITCH", "createTemplateFromBundle", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "bundle", "Landroid/os/Bundle;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RequiresApi(23)
        public final IotCardTemplateBean createTemplateFromBundle(Bundle bundle) {
            IotCardTemplateBean displayTemplateBean;
            if (bundle == null) {
                Log.e(IotCardTemplateBean.TAG, "Null bundle");
                return null;
            }
            int i8 = bundle.getInt(IotCardTemplateBean.KEY_TEMPLATE_TYPE, -1);
            try {
                if (i8 == 0) {
                    displayTemplateBean = new DisplayTemplateBean(bundle);
                } else if (i8 == 1) {
                    displayTemplateBean = new SwitchTemplateBean(bundle);
                } else {
                    if (i8 != 3) {
                        return null;
                    }
                    displayTemplateBean = new EmptyTemplateBean(bundle);
                }
                return displayTemplateBean;
            } catch (Exception e) {
                Log.e(IotCardTemplateBean.TAG, "Error creating template", e);
                return null;
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean$TemplateType;", "", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
    @Retention(RetentionPolicy.SOURCE)
    public @interface TemplateType {
    }

    public IotCardTemplateBean(String controlId, String packageName, String str, int i8, boolean z2, int i9, long j8, int i10, Map<String, ? extends Map<String, String>> deviceServiceMap) {
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(deviceServiceMap, "deviceServiceMap");
        this.controlId = controlId;
        this.packageName = packageName;
        this.deviceSingleId = str;
        this.deviceShowLevel = i8;
        this.deviceConnectedStatus = z2;
        this.deviceTypeId = i9;
        this.deviceLastConnectedTime = j8;
        this.sortLevel = i10;
        this.deviceServiceMap = deviceServiceMap;
    }

    public final String getControlId() {
        return this.controlId;
    }

    public Bundle getDataBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TEMPLATE_TYPE, getTemplateType());
        bundle.putString(KEY_TEMPLATE_ID, this.controlId);
        return bundle;
    }

    public final boolean getDeviceConnectedStatus() {
        return this.deviceConnectedStatus;
    }

    public final long getDeviceLastConnectedTime() {
        return this.deviceLastConnectedTime;
    }

    public final Map<String, Map<String, String>> getDeviceServiceMap() {
        return this.deviceServiceMap;
    }

    public final int getDeviceShowLevel() {
        return this.deviceShowLevel;
    }

    public final String getDeviceSingleId() {
        return this.deviceSingleId;
    }

    public final int getDeviceTypeId() {
        return this.deviceTypeId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getSortLevel() {
        return this.sortLevel;
    }

    public abstract int getTemplateType();

    public final void setControlId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.controlId = str;
    }

    public final void setDeviceConnectedStatus(boolean z2) {
        this.deviceConnectedStatus = z2;
    }

    public final void setDeviceLastConnectedTime(long j8) {
        this.deviceLastConnectedTime = j8;
    }

    public final void setDeviceServiceMap(Map<String, ? extends Map<String, String>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.deviceServiceMap = map;
    }

    public final void setDeviceShowLevel(int i8) {
        this.deviceShowLevel = i8;
    }

    public final void setDeviceSingleId(String str) {
        this.deviceSingleId = str;
    }

    public final void setDeviceTypeId(int i8) {
        this.deviceTypeId = i8;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void setSortLevel(int i8) {
        this.sortLevel = i8;
    }

    @Override // java.lang.Comparable
    public int compareTo(IotCardTemplateBean other) {
        Intrinsics.checkNotNullParameter(other, "other");
        boolean z2 = this.deviceConnectedStatus;
        boolean z3 = other.deviceConnectedStatus;
        if (z2 != z3) {
            return Boolean.compare(z3, z2);
        }
        int i8 = other.sortLevel;
        int i9 = this.sortLevel;
        return i8 == i9 ? Intrinsics.compare(other.deviceLastConnectedTime, this.deviceLastConnectedTime) : Intrinsics.compare(i9, i8);
    }

    public /* synthetic */ IotCardTemplateBean(String str, String str2, String str3, int i8, boolean z2, int i9, long j8, int i10, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? 0 : i8, (i11 & 16) != 0 ? false : z2, (i11 & 32) != 0 ? 0 : i9, (i11 & 64) != 0 ? 0L : j8, (i11 & 128) != 0 ? 0 : i10, (i11 & 256) != 0 ? MapsKt.emptyMap() : map);
    }
}
