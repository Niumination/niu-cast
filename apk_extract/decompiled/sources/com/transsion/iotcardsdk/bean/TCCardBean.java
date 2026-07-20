package com.transsion.iotcardsdk.bean;

import a1.a;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\bZ\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0099\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012 \b\u0002\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 0 ¢\u0006\u0002\u0010!J\u0011\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\u0000H\u0096\u0002J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0010HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u000bHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010g\u001a\u00020\bHÆ\u0003J\t\u0010h\u001a\u00020\bHÆ\u0003J\t\u0010i\u001a\u00020\bHÆ\u0003J\t\u0010j\u001a\u00020\u000bHÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\bHÆ\u0003J\t\u0010m\u001a\u00020\u000bHÆ\u0003J\t\u0010n\u001a\u00020\bHÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J!\u0010q\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 0 HÆ\u0003J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\bHÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u000bHÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\u009d\u0002\u0010y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032 \b\u0002\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 0 HÆ\u0001J\u0013\u0010z\u001a\u00020\u000b2\b\u0010_\u001a\u0004\u0018\u00010{HÖ\u0003J\t\u0010|\u001a\u00020\bHÖ\u0001J\t\u0010}\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0018\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R2\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010'\"\u0004\bE\u0010)R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010#\"\u0004\bK\u0010%R\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u00105\"\u0004\bL\u00107R\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00105\"\u0004\bM\u00107R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010#\"\u0004\bO\u0010%R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010#\"\u0004\bQ\u0010%R\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010'\"\u0004\bS\u0010)R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010#\"\u0004\bU\u0010%R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010'\"\u0004\bW\u0010)R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010#\"\u0004\b[\u0010%R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010#\"\u0004\b]\u0010%¨\u0006~"}, d2 = {"Lcom/transsion/iotcardsdk/bean/TCCardBean;", "", "controlId", "", "packageName", "title", "subTitle", "deviceTypeId", "", "pid", "deviceConnectedStatus", "", "deviceConnectedDesc", DisplayTemplateBean.KEY_EXTRA_INFO_ONE_DESC, DisplayTemplateBean.KEY_EXTRA_INFO_TWO_DESC, "deviceLastConnectedTime", "", "targetPackageName", "targetClassName", "isSupportClickCard", "clickCardBundle", "Landroid/os/Bundle;", "deviceShowLevel", "sortLevel", "cardType", SwitchTemplateBean.KEY_DEVICE_SWITCH, SwitchTemplateBean.KEY_SWITCH_ACTION_TYPE, "isAppDisconnected", "cardDisplayType", "displayMessage", DisplayTemplateBean.KEY_BOX_BATTERY, "deviceServiceMap", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZLandroid/os/Bundle;IIIZIZILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBoxBattery", "()Ljava/lang/String;", "setBoxBattery", "(Ljava/lang/String;)V", "getCardDisplayType", "()I", "setCardDisplayType", "(I)V", "getCardType", "setCardType", "getClickCardBundle", "()Landroid/os/Bundle;", "setClickCardBundle", "(Landroid/os/Bundle;)V", "getControlId", "setControlId", "getDeviceConnectedDesc", "setDeviceConnectedDesc", "getDeviceConnectedStatus", "()Z", "setDeviceConnectedStatus", "(Z)V", "getDeviceLastConnectedTime", "()J", "setDeviceLastConnectedTime", "(J)V", "getDeviceServiceMap", "()Ljava/util/Map;", "setDeviceServiceMap", "(Ljava/util/Map;)V", "getDeviceShowLevel", "setDeviceShowLevel", "getDeviceSwitch", "setDeviceSwitch", "getDeviceTypeId", "setDeviceTypeId", "getDisplayMessage", "setDisplayMessage", "getExtraInfoOneDesc", "setExtraInfoOneDesc", "getExtraInfoTwoDesc", "setExtraInfoTwoDesc", "setAppDisconnected", "setSupportClickCard", "getPackageName", "setPackageName", "getPid", "setPid", "getSortLevel", "setSortLevel", "getSubTitle", "setSubTitle", "getSwitchActionType", "setSwitchActionType", "getTargetClassName", "setTargetClassName", "getTargetPackageName", "setTargetPackageName", "getTitle", "setTitle", "compareTo", "other", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "hashCode", "toString", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TCCardBean implements Comparable<TCCardBean> {
    private String boxBattery;
    private int cardDisplayType;
    private int cardType;
    private Bundle clickCardBundle;
    private String controlId;
    private String deviceConnectedDesc;
    private boolean deviceConnectedStatus;
    private long deviceLastConnectedTime;
    private Map<String, ? extends Map<String, String>> deviceServiceMap;
    private int deviceShowLevel;
    private boolean deviceSwitch;
    private int deviceTypeId;
    private String displayMessage;
    private String extraInfoOneDesc;
    private String extraInfoTwoDesc;
    private boolean isAppDisconnected;
    private boolean isSupportClickCard;
    private String packageName;
    private String pid;
    private int sortLevel;
    private String subTitle;
    private int switchActionType;
    private String targetClassName;
    private String targetPackageName;
    private String title;

    public TCCardBean() {
        this(null, null, null, null, 0, null, false, null, null, null, 0L, null, null, false, null, 0, 0, 0, false, 0, false, 0, null, null, null, 33554431, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getControlId() {
        return this.controlId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getExtraInfoTwoDesc() {
        return this.extraInfoTwoDesc;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getDeviceLastConnectedTime() {
        return this.deviceLastConnectedTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getTargetClassName() {
        return this.targetClassName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsSupportClickCard() {
        return this.isSupportClickCard;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Bundle getClickCardBundle() {
        return this.clickCardBundle;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getDeviceShowLevel() {
        return this.deviceShowLevel;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getSortLevel() {
        return this.sortLevel;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getCardType() {
        return this.cardType;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getDeviceSwitch() {
        return this.deviceSwitch;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getSwitchActionType() {
        return this.switchActionType;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getIsAppDisconnected() {
        return this.isAppDisconnected;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getCardDisplayType() {
        return this.cardDisplayType;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getBoxBattery() {
        return this.boxBattery;
    }

    public final Map<String, Map<String, String>> component25() {
        return this.deviceServiceMap;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDeviceTypeId() {
        return this.deviceTypeId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPid() {
        return this.pid;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDeviceConnectedStatus() {
        return this.deviceConnectedStatus;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDeviceConnectedDesc() {
        return this.deviceConnectedDesc;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getExtraInfoOneDesc() {
        return this.extraInfoOneDesc;
    }

    public final TCCardBean copy(String controlId, String packageName, String title, String subTitle, int deviceTypeId, String pid, boolean deviceConnectedStatus, String deviceConnectedDesc, String extraInfoOneDesc, String extraInfoTwoDesc, long deviceLastConnectedTime, String targetPackageName, String targetClassName, boolean isSupportClickCard, Bundle clickCardBundle, int deviceShowLevel, int sortLevel, int cardType, boolean deviceSwitch, int switchActionType, boolean isAppDisconnected, int cardDisplayType, String displayMessage, String boxBattery, Map<String, ? extends Map<String, String>> deviceServiceMap) {
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(deviceConnectedDesc, "deviceConnectedDesc");
        Intrinsics.checkNotNullParameter(extraInfoOneDesc, "extraInfoOneDesc");
        Intrinsics.checkNotNullParameter(extraInfoTwoDesc, "extraInfoTwoDesc");
        Intrinsics.checkNotNullParameter(targetPackageName, "targetPackageName");
        Intrinsics.checkNotNullParameter(targetClassName, "targetClassName");
        Intrinsics.checkNotNullParameter(displayMessage, "displayMessage");
        Intrinsics.checkNotNullParameter(boxBattery, "boxBattery");
        Intrinsics.checkNotNullParameter(deviceServiceMap, "deviceServiceMap");
        return new TCCardBean(controlId, packageName, title, subTitle, deviceTypeId, pid, deviceConnectedStatus, deviceConnectedDesc, extraInfoOneDesc, extraInfoTwoDesc, deviceLastConnectedTime, targetPackageName, targetClassName, isSupportClickCard, clickCardBundle, deviceShowLevel, sortLevel, cardType, deviceSwitch, switchActionType, isAppDisconnected, cardDisplayType, displayMessage, boxBattery, deviceServiceMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TCCardBean)) {
            return false;
        }
        TCCardBean tCCardBean = (TCCardBean) other;
        return Intrinsics.areEqual(this.controlId, tCCardBean.controlId) && Intrinsics.areEqual(this.packageName, tCCardBean.packageName) && Intrinsics.areEqual(this.title, tCCardBean.title) && Intrinsics.areEqual(this.subTitle, tCCardBean.subTitle) && this.deviceTypeId == tCCardBean.deviceTypeId && Intrinsics.areEqual(this.pid, tCCardBean.pid) && this.deviceConnectedStatus == tCCardBean.deviceConnectedStatus && Intrinsics.areEqual(this.deviceConnectedDesc, tCCardBean.deviceConnectedDesc) && Intrinsics.areEqual(this.extraInfoOneDesc, tCCardBean.extraInfoOneDesc) && Intrinsics.areEqual(this.extraInfoTwoDesc, tCCardBean.extraInfoTwoDesc) && this.deviceLastConnectedTime == tCCardBean.deviceLastConnectedTime && Intrinsics.areEqual(this.targetPackageName, tCCardBean.targetPackageName) && Intrinsics.areEqual(this.targetClassName, tCCardBean.targetClassName) && this.isSupportClickCard == tCCardBean.isSupportClickCard && Intrinsics.areEqual(this.clickCardBundle, tCCardBean.clickCardBundle) && this.deviceShowLevel == tCCardBean.deviceShowLevel && this.sortLevel == tCCardBean.sortLevel && this.cardType == tCCardBean.cardType && this.deviceSwitch == tCCardBean.deviceSwitch && this.switchActionType == tCCardBean.switchActionType && this.isAppDisconnected == tCCardBean.isAppDisconnected && this.cardDisplayType == tCCardBean.cardDisplayType && Intrinsics.areEqual(this.displayMessage, tCCardBean.displayMessage) && Intrinsics.areEqual(this.boxBattery, tCCardBean.boxBattery) && Intrinsics.areEqual(this.deviceServiceMap, tCCardBean.deviceServiceMap);
    }

    public final String getBoxBattery() {
        return this.boxBattery;
    }

    public final int getCardDisplayType() {
        return this.cardDisplayType;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final Bundle getClickCardBundle() {
        return this.clickCardBundle;
    }

    public final String getControlId() {
        return this.controlId;
    }

    public final String getDeviceConnectedDesc() {
        return this.deviceConnectedDesc;
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

    public final boolean getDeviceSwitch() {
        return this.deviceSwitch;
    }

    public final int getDeviceTypeId() {
        return this.deviceTypeId;
    }

    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    public final String getExtraInfoOneDesc() {
        return this.extraInfoOneDesc;
    }

    public final String getExtraInfoTwoDesc() {
        return this.extraInfoTwoDesc;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPid() {
        return this.pid;
    }

    public final int getSortLevel() {
        return this.sortLevel;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final int getSwitchActionType() {
        return this.switchActionType;
    }

    public final String getTargetClassName() {
        return this.targetClassName;
    }

    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iE = a.e(a.c(this.deviceTypeId, a.e(a.e(a.e(this.controlId.hashCode() * 31, 31, this.packageName), 31, this.title), 31, this.subTitle), 31), 31, this.pid);
        boolean z2 = this.deviceConnectedStatus;
        ?? r7 = z2;
        if (z2) {
            r7 = 1;
        }
        int iE2 = a.e(a.e(a.f(this.deviceLastConnectedTime, a.e(a.e(a.e((iE + r7) * 31, 31, this.deviceConnectedDesc), 31, this.extraInfoOneDesc), 31, this.extraInfoTwoDesc), 31), 31, this.targetPackageName), 31, this.targetClassName);
        boolean z3 = this.isSupportClickCard;
        ?? r10 = z3;
        if (z3) {
            r10 = 1;
        }
        int i8 = (iE2 + r10) * 31;
        Bundle bundle = this.clickCardBundle;
        int iC = a.c(this.cardType, a.c(this.sortLevel, a.c(this.deviceShowLevel, (i8 + (bundle == null ? 0 : bundle.hashCode())) * 31, 31), 31), 31);
        boolean z5 = this.deviceSwitch;
        ?? r11 = z5;
        if (z5) {
            r11 = 1;
        }
        int iC2 = a.c(this.switchActionType, (iC + r11) * 31, 31);
        boolean z10 = this.isAppDisconnected;
        return this.deviceServiceMap.hashCode() + a.e(a.e(a.c(this.cardDisplayType, (iC2 + (z10 ? 1 : z10)) * 31, 31), 31, this.displayMessage), 31, this.boxBattery);
    }

    public final boolean isAppDisconnected() {
        return this.isAppDisconnected;
    }

    public final boolean isSupportClickCard() {
        return this.isSupportClickCard;
    }

    public final void setAppDisconnected(boolean z2) {
        this.isAppDisconnected = z2;
    }

    public final void setBoxBattery(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.boxBattery = str;
    }

    public final void setCardDisplayType(int i8) {
        this.cardDisplayType = i8;
    }

    public final void setCardType(int i8) {
        this.cardType = i8;
    }

    public final void setClickCardBundle(Bundle bundle) {
        this.clickCardBundle = bundle;
    }

    public final void setControlId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.controlId = str;
    }

    public final void setDeviceConnectedDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceConnectedDesc = str;
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

    public final void setDeviceSwitch(boolean z2) {
        this.deviceSwitch = z2;
    }

    public final void setDeviceTypeId(int i8) {
        this.deviceTypeId = i8;
    }

    public final void setDisplayMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayMessage = str;
    }

    public final void setExtraInfoOneDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extraInfoOneDesc = str;
    }

    public final void setExtraInfoTwoDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extraInfoTwoDesc = str;
    }

    public final void setPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void setPid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pid = str;
    }

    public final void setSortLevel(int i8) {
        this.sortLevel = i8;
    }

    public final void setSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final void setSupportClickCard(boolean z2) {
        this.isSupportClickCard = z2;
    }

    public final void setSwitchActionType(int i8) {
        this.switchActionType = i8;
    }

    public final void setTargetClassName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetClassName = str;
    }

    public final void setTargetPackageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetPackageName = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        String str = this.controlId;
        String str2 = this.packageName;
        String str3 = this.title;
        String str4 = this.subTitle;
        int i8 = this.deviceTypeId;
        String str5 = this.pid;
        boolean z2 = this.deviceConnectedStatus;
        String str6 = this.deviceConnectedDesc;
        String str7 = this.extraInfoOneDesc;
        String str8 = this.extraInfoTwoDesc;
        long j8 = this.deviceLastConnectedTime;
        String str9 = this.targetPackageName;
        String str10 = this.targetClassName;
        boolean z3 = this.isSupportClickCard;
        Bundle bundle = this.clickCardBundle;
        int i9 = this.deviceShowLevel;
        int i10 = this.sortLevel;
        int i11 = this.cardType;
        boolean z5 = this.deviceSwitch;
        int i12 = this.switchActionType;
        boolean z10 = this.isAppDisconnected;
        int i13 = this.cardDisplayType;
        String str11 = this.displayMessage;
        String str12 = this.boxBattery;
        Map<String, ? extends Map<String, String>> map = this.deviceServiceMap;
        StringBuilder sbP = h0.a.p("TCCardBean(controlId=", str, ", packageName=", str2, ", title=");
        d.A(sbP, str3, ", subTitle=", str4, ", deviceTypeId=");
        sbP.append(i8);
        sbP.append(", pid=");
        sbP.append(str5);
        sbP.append(", deviceConnectedStatus=");
        sbP.append(z2);
        sbP.append(", deviceConnectedDesc=");
        sbP.append(str6);
        sbP.append(", extraInfoOneDesc=");
        d.A(sbP, str7, ", extraInfoTwoDesc=", str8, ", deviceLastConnectedTime=");
        sbP.append(j8);
        sbP.append(", targetPackageName=");
        sbP.append(str9);
        sbP.append(", targetClassName=");
        sbP.append(str10);
        sbP.append(", isSupportClickCard=");
        sbP.append(z3);
        sbP.append(", clickCardBundle=");
        sbP.append(bundle);
        sbP.append(", deviceShowLevel=");
        sbP.append(i9);
        sbP.append(", sortLevel=");
        sbP.append(i10);
        sbP.append(", cardType=");
        sbP.append(i11);
        sbP.append(", deviceSwitch=");
        sbP.append(z5);
        sbP.append(", switchActionType=");
        sbP.append(i12);
        sbP.append(", isAppDisconnected=");
        sbP.append(z10);
        sbP.append(", cardDisplayType=");
        sbP.append(i13);
        d.A(sbP, ", displayMessage=", str11, ", boxBattery=", str12);
        sbP.append(", deviceServiceMap=");
        sbP.append(map);
        sbP.append(")");
        return sbP.toString();
    }

    public TCCardBean(String controlId, String packageName, String title, String subTitle, int i8, String pid, boolean z2, String deviceConnectedDesc, String extraInfoOneDesc, String extraInfoTwoDesc, long j8, String targetPackageName, String targetClassName, boolean z3, Bundle bundle, int i9, int i10, int i11, boolean z5, int i12, boolean z10, int i13, String displayMessage, String boxBattery, Map<String, ? extends Map<String, String>> deviceServiceMap) {
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(deviceConnectedDesc, "deviceConnectedDesc");
        Intrinsics.checkNotNullParameter(extraInfoOneDesc, "extraInfoOneDesc");
        Intrinsics.checkNotNullParameter(extraInfoTwoDesc, "extraInfoTwoDesc");
        Intrinsics.checkNotNullParameter(targetPackageName, "targetPackageName");
        Intrinsics.checkNotNullParameter(targetClassName, "targetClassName");
        Intrinsics.checkNotNullParameter(displayMessage, "displayMessage");
        Intrinsics.checkNotNullParameter(boxBattery, "boxBattery");
        Intrinsics.checkNotNullParameter(deviceServiceMap, "deviceServiceMap");
        this.controlId = controlId;
        this.packageName = packageName;
        this.title = title;
        this.subTitle = subTitle;
        this.deviceTypeId = i8;
        this.pid = pid;
        this.deviceConnectedStatus = z2;
        this.deviceConnectedDesc = deviceConnectedDesc;
        this.extraInfoOneDesc = extraInfoOneDesc;
        this.extraInfoTwoDesc = extraInfoTwoDesc;
        this.deviceLastConnectedTime = j8;
        this.targetPackageName = targetPackageName;
        this.targetClassName = targetClassName;
        this.isSupportClickCard = z3;
        this.clickCardBundle = bundle;
        this.deviceShowLevel = i9;
        this.sortLevel = i10;
        this.cardType = i11;
        this.deviceSwitch = z5;
        this.switchActionType = i12;
        this.isAppDisconnected = z10;
        this.cardDisplayType = i13;
        this.displayMessage = displayMessage;
        this.boxBattery = boxBattery;
        this.deviceServiceMap = deviceServiceMap;
    }

    @Override // java.lang.Comparable
    public int compareTo(TCCardBean other) {
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

    public /* synthetic */ TCCardBean(String str, String str2, String str3, String str4, int i8, String str5, boolean z2, String str6, String str7, String str8, long j8, String str9, String str10, boolean z3, Bundle bundle, int i9, int i10, int i11, boolean z5, int i12, boolean z10, int i13, String str11, String str12, Map map, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? "" : str, (i14 & 2) != 0 ? "" : str2, (i14 & 4) != 0 ? "" : str3, (i14 & 8) != 0 ? "" : str4, (i14 & 16) != 0 ? 0 : i8, (i14 & 32) != 0 ? "" : str5, (i14 & 64) != 0 ? false : z2, (i14 & 128) != 0 ? "" : str6, (i14 & 256) != 0 ? "" : str7, (i14 & 512) != 0 ? "" : str8, (i14 & 1024) != 0 ? 0L : j8, (i14 & 2048) != 0 ? "" : str9, (i14 & 4096) != 0 ? "" : str10, (i14 & 8192) != 0 ? true : z3, (i14 & 16384) != 0 ? null : bundle, (i14 & 32768) != 0 ? 0 : i9, (i14 & 65536) != 0 ? 0 : i10, (i14 & 131072) != 0 ? 0 : i11, (i14 & 262144) != 0 ? false : z5, (i14 & 524288) != 0 ? 0 : i12, (i14 & 1048576) == 0 ? z10 : true, (i14 & 2097152) != 0 ? 0 : i13, (i14 & 4194304) != 0 ? "" : str11, (i14 & 8388608) != 0 ? "" : str12, (i14 & 16777216) != 0 ? MapsKt.emptyMap() : map);
    }
}
