package com.transsion.iotcardsdk.bean;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.a;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b0\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0091\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010#\u001a\u00020\u0010\u0012 \b\u0002\u0010$\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%0%¢\u0006\u0002\u0010&J\b\u0010Q\u001a\u00020\u0004H\u0016J\b\u0010R\u001a\u00020\u0010H\u0016J\b\u0010S\u001a\u00020\u0007H\u0016R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0019\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010\"\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010!\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u00103\"\u0004\b<\u00105R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00107\"\u0004\bB\u00109R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010/\"\u0004\bD\u00101R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010/\"\u0004\bF\u00101R\u001a\u0010\u001c\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010/\"\u0004\bL\u00101R\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010/\"\u0004\bN\u00101R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010/\"\u0004\bP\u00101¨\u0006U"}, d2 = {"Lcom/transsion/iotcardsdk/bean/SwitchTemplateBean;", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "Ljava/io/Serializable;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "controlId", "", "packageName", "title", "mCustomIcon", "Landroid/graphics/drawable/Icon;", "newCustomIcon", "", "subTitle", "deviceTypeId", "", "pid", "deviceConnectedStatus", "", "deviceConnectedDesc", "deviceLastConnectedTime", "", "targetPackageName", "targetClassName", SwitchTemplateBean.KEY_DEVICE_SWITCH, "isSupportClickCard", "clickCardBundle", SwitchTemplateBean.KEY_SWITCH_ACTION_TYPE, "deviceSingleId", "deviceShowLevel", "cardDisplayType", "Lcom/transsion/iotcardsdk/bean/DisplayType;", "displayMessage", "displayCustomIcon", "sortLevel", "deviceServiceMap", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Icon;[BLjava/lang/String;ILjava/lang/String;ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZLandroid/os/Bundle;ILjava/lang/String;ILcom/transsion/iotcardsdk/bean/DisplayType;Ljava/lang/String;[BILjava/util/Map;)V", "getCardDisplayType", "()Lcom/transsion/iotcardsdk/bean/DisplayType;", "setCardDisplayType", "(Lcom/transsion/iotcardsdk/bean/DisplayType;)V", "getClickCardBundle", "()Landroid/os/Bundle;", "setClickCardBundle", "getDeviceConnectedDesc", "()Ljava/lang/String;", "setDeviceConnectedDesc", "(Ljava/lang/String;)V", "getDeviceSwitch", "()Z", "setDeviceSwitch", "(Z)V", "getDisplayCustomIcon", "()[B", "setDisplayCustomIcon", "([B)V", "getDisplayMessage", "setDisplayMessage", "setSupportClickCard", "getMCustomIcon", "()Landroid/graphics/drawable/Icon;", "setMCustomIcon", "(Landroid/graphics/drawable/Icon;)V", "getNewCustomIcon", "setNewCustomIcon", "getPid", "setPid", "getSubTitle", "setSubTitle", "getSwitchActionType", "()I", "setSwitchActionType", "(I)V", "getTargetClassName", "setTargetClassName", "getTargetPackageName", "setTargetPackageName", "getTitle", "setTitle", "getDataBundle", "getTemplateType", "toString", "Companion", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwitchTemplateBean extends IotCardTemplateBean implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEVICE_TYPE = 1;
    public static final String KEY_CARD_DISPLAY_TYPE = "cardDisplayType";
    public static final String KEY_CLICK_CARD_BUNDLE = "clickCardBundle";
    public static final String KEY_CONTROL_ID = "controlId";
    public static final String KEY_CUSTOM_ICON = "mCustomIcon";
    public static final String KEY_DEVICE_CONNECTED_DESC = "deviceConnectedDesc";
    public static final String KEY_DEVICE_CONNECTED_STATUS = "deviceConnectedStatus";
    public static final String KEY_DEVICE_LAST_CONNECTED_TIME = "deviceLastConnectedTime";
    public static final String KEY_DEVICE_PID = "pid";
    public static final String KEY_DEVICE_SHOW_LEVEL = "deviceShowLevel";
    public static final String KEY_DEVICE_SINGLE_ID = "deviceSingleId";
    public static final String KEY_DEVICE_SWITCH = "deviceSwitch";
    public static final String KEY_DEVICE_TYPE_ID = "deviceTypeId";
    public static final String KEY_DISPLAY_CUSTOM_ICON = "displayCustomIcon";
    public static final String KEY_DISPLAY_MESSAGE = "displayMessage";
    public static final String KEY_IS_SUPPORT_CLICK_CARD = "isSupportClickCard";
    public static final String KEY_NEW_CUSTOM_ICON = "newCustomIcon";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_SORT_LEVEL = "sortLevel";
    public static final String KEY_SUBTITLE = "subTitle";
    public static final String KEY_SWITCH_ACTION_TYPE = "switchActionType";
    public static final String KEY_TARGET_CLASS_NAME = "targetClassName";
    public static final String KEY_TARGET_PACKAGE_NAME = "targetPackageName";
    public static final String KEY_TITLE = "title";
    private DisplayType cardDisplayType;
    private Bundle clickCardBundle;
    private String deviceConnectedDesc;
    private boolean deviceSwitch;
    private byte[] displayCustomIcon;
    private String displayMessage;
    private boolean isSupportClickCard;
    private Icon mCustomIcon;
    private byte[] newCustomIcon;
    private String pid;
    private String subTitle;
    private int switchActionType;
    private String targetClassName;
    private String targetPackageName;
    private String title;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/transsion/iotcardsdk/bean/SwitchTemplateBean$Companion;", "", "()V", "DEVICE_TYPE", "", "getDEVICE_TYPE$annotations", "KEY_CARD_DISPLAY_TYPE", "", "KEY_CLICK_CARD_BUNDLE", "KEY_CONTROL_ID", "KEY_CUSTOM_ICON", "KEY_DEVICE_CONNECTED_DESC", "KEY_DEVICE_CONNECTED_STATUS", "KEY_DEVICE_LAST_CONNECTED_TIME", "KEY_DEVICE_PID", "KEY_DEVICE_SHOW_LEVEL", "KEY_DEVICE_SINGLE_ID", "KEY_DEVICE_SWITCH", "KEY_DEVICE_TYPE_ID", "KEY_DISPLAY_CUSTOM_ICON", "KEY_DISPLAY_MESSAGE", "KEY_IS_SUPPORT_CLICK_CARD", "KEY_NEW_CUSTOM_ICON", "KEY_PACKAGE_NAME", "KEY_SORT_LEVEL", "KEY_SUBTITLE", "KEY_SWITCH_ACTION_TYPE", "KEY_TARGET_CLASS_NAME", "KEY_TARGET_PACKAGE_NAME", "KEY_TITLE", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEVICE_TYPE$annotations() {
        }

        private Companion() {
        }
    }

    public /* synthetic */ SwitchTemplateBean(String str, String str2, String str3, Icon icon, byte[] bArr, String str4, int i8, String str5, boolean z2, String str6, long j8, String str7, String str8, boolean z3, boolean z5, Bundle bundle, int i9, String str9, int i10, DisplayType displayType, String str10, byte[] bArr2, int i11, Map map, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i12 & 4) != 0 ? "" : str3, (i12 & 8) != 0 ? null : icon, (i12 & 16) != 0 ? null : bArr, (i12 & 32) != 0 ? "" : str4, i8, str5, (i12 & 256) != 0 ? false : z2, (i12 & 512) != 0 ? "" : str6, j8, str7, (i12 & 4096) != 0 ? "" : str8, (i12 & 8192) != 0 ? false : z3, (i12 & 16384) != 0 ? true : z5, (32768 & i12) != 0 ? null : bundle, i9, (131072 & i12) != 0 ? "" : str9, (262144 & i12) != 0 ? 0 : i10, (524288 & i12) != 0 ? null : displayType, (1048576 & i12) != 0 ? null : str10, (2097152 & i12) != 0 ? null : bArr2, (4194304 & i12) != 0 ? 0 : i11, (i12 & 8388608) != 0 ? MapsKt.emptyMap() : map);
    }

    public final DisplayType getCardDisplayType() {
        return this.cardDisplayType;
    }

    public final Bundle getClickCardBundle() {
        return this.clickCardBundle;
    }

    @Override // com.transsion.iotcardsdk.bean.IotCardTemplateBean
    public Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putString("controlId", getControlId());
        dataBundle.putString("packageName", getPackageName());
        dataBundle.putString("title", this.title);
        dataBundle.putParcelable("mCustomIcon", this.mCustomIcon);
        dataBundle.putString("subTitle", this.subTitle);
        dataBundle.putInt("deviceTypeId", getDeviceTypeId());
        dataBundle.putString("pid", this.pid);
        dataBundle.putBoolean("deviceConnectedStatus", getDeviceConnectedStatus());
        dataBundle.putString("deviceConnectedDesc", this.deviceConnectedDesc);
        dataBundle.putLong("deviceLastConnectedTime", getDeviceLastConnectedTime());
        dataBundle.putString("targetPackageName", this.targetPackageName);
        dataBundle.putString("targetClassName", this.targetClassName);
        dataBundle.putBoolean(KEY_DEVICE_SWITCH, this.deviceSwitch);
        dataBundle.putBoolean("isSupportClickCard", this.isSupportClickCard);
        dataBundle.putBundle("clickCardBundle", this.clickCardBundle);
        dataBundle.putString("deviceSingleId", getDeviceSingleId());
        dataBundle.putInt("deviceShowLevel", getDeviceShowLevel());
        dataBundle.putInt(KEY_SWITCH_ACTION_TYPE, this.switchActionType);
        dataBundle.putByteArray("newCustomIcon", this.newCustomIcon);
        dataBundle.putSerializable("cardDisplayType", this.cardDisplayType);
        dataBundle.putString("displayMessage", this.displayMessage);
        dataBundle.putByteArray("displayCustomIcon", this.displayCustomIcon);
        dataBundle.putInt("sortLevel", getSortLevel());
        return dataBundle;
    }

    public final String getDeviceConnectedDesc() {
        return this.deviceConnectedDesc;
    }

    public final boolean getDeviceSwitch() {
        return this.deviceSwitch;
    }

    public final byte[] getDisplayCustomIcon() {
        return this.displayCustomIcon;
    }

    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    public final Icon getMCustomIcon() {
        return this.mCustomIcon;
    }

    public final byte[] getNewCustomIcon() {
        return this.newCustomIcon;
    }

    public final String getPid() {
        return this.pid;
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

    @Override // com.transsion.iotcardsdk.bean.IotCardTemplateBean
    public int getTemplateType() {
        return 1;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isSupportClickCard, reason: from getter */
    public final boolean getIsSupportClickCard() {
        return this.isSupportClickCard;
    }

    public final void setCardDisplayType(DisplayType displayType) {
        this.cardDisplayType = displayType;
    }

    public final void setClickCardBundle(Bundle bundle) {
        this.clickCardBundle = bundle;
    }

    public final void setDeviceConnectedDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceConnectedDesc = str;
    }

    public final void setDeviceSwitch(boolean z2) {
        this.deviceSwitch = z2;
    }

    public final void setDisplayCustomIcon(byte[] bArr) {
        this.displayCustomIcon = bArr;
    }

    public final void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public final void setMCustomIcon(Icon icon) {
        this.mCustomIcon = icon;
    }

    public final void setNewCustomIcon(byte[] bArr) {
        this.newCustomIcon = bArr;
    }

    public final void setPid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pid = str;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final void setSupportClickCard(boolean z2) {
        this.isSupportClickCard = z2;
    }

    public final void setSwitchActionType(int i8) {
        this.switchActionType = i8;
    }

    public final void setTargetClassName(String str) {
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
        String controlId = getControlId();
        String packageName = getPackageName();
        String str = this.title;
        Icon icon = this.mCustomIcon;
        String str2 = this.subTitle;
        int deviceTypeId = getDeviceTypeId();
        String str3 = this.pid;
        boolean deviceConnectedStatus = getDeviceConnectedStatus();
        String str4 = this.deviceConnectedDesc;
        long deviceLastConnectedTime = getDeviceLastConnectedTime();
        String str5 = this.targetPackageName;
        String str6 = this.targetClassName;
        boolean z2 = this.deviceSwitch;
        boolean z3 = this.isSupportClickCard;
        String deviceSingleId = getDeviceSingleId();
        int deviceShowLevel = getDeviceShowLevel();
        DisplayType displayType = this.cardDisplayType;
        String str7 = this.displayMessage;
        byte[] bArr = this.displayCustomIcon;
        int sortLevel = getSortLevel();
        Map<String, Map<String, String>> deviceServiceMap = getDeviceServiceMap();
        StringBuilder sbP = a.p("SwitchTemplateBean(controlId='", controlId, "',packageName='", packageName, "'，title='");
        sbP.append(str);
        sbP.append("', mCustomIcon=");
        sbP.append(icon);
        sbP.append(", subTitle=");
        sbP.append(str2);
        sbP.append(", deviceTypeId=");
        sbP.append(deviceTypeId);
        sbP.append(",devicePid = ");
        sbP.append(str3);
        sbP.append(", deviceConnectedStatus=");
        sbP.append(deviceConnectedStatus);
        sbP.append(", deviceConnectedDesc='");
        sbP.append(str4);
        sbP.append("', deviceLastConnectedTime=");
        sbP.append(deviceLastConnectedTime);
        d.A(sbP, ", targetPackageName=", str5, ", targetClassName=", str6);
        sbP.append(", deviceSwitch=");
        sbP.append(z2);
        sbP.append(",isSupportClickCard=");
        sbP.append(z3);
        sbP.append(",deviceSingleId=");
        sbP.append(deviceSingleId);
        sbP.append(",deviceShowLevel=");
        sbP.append(deviceShowLevel);
        sbP.append("),cardDisplay=");
        sbP.append(displayType);
        sbP.append(",displayMessage=");
        sbP.append(str7);
        sbP.append(", displayCustomIcon=");
        sbP.append(bArr);
        sbP.append(",sortLevel=");
        sbP.append(sortLevel);
        sbP.append(", deviceServiceMap:");
        sbP.append(deviceServiceMap);
        return sbP.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchTemplateBean(String controlId, String packageName, String title, Icon icon, byte[] bArr, String str, int i8, String pid, boolean z2, String deviceConnectedDesc, long j8, String targetPackageName, String str2, boolean z3, boolean z5, Bundle bundle, int i9, String str3, int i10, DisplayType displayType, String str4, byte[] bArr2, int i11, Map<String, ? extends Map<String, String>> deviceServiceMap) {
        super(controlId, packageName, str3, i10, z2, i8, j8, i11, null, 256, null);
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(deviceConnectedDesc, "deviceConnectedDesc");
        Intrinsics.checkNotNullParameter(targetPackageName, "targetPackageName");
        Intrinsics.checkNotNullParameter(deviceServiceMap, "deviceServiceMap");
        this.title = title;
        this.mCustomIcon = icon;
        this.newCustomIcon = bArr;
        this.subTitle = str;
        this.pid = pid;
        this.deviceConnectedDesc = deviceConnectedDesc;
        this.targetPackageName = targetPackageName;
        this.targetClassName = str2;
        this.deviceSwitch = z3;
        this.isSupportClickCard = z5;
        this.clickCardBundle = bundle;
        this.switchActionType = i9;
        this.cardDisplayType = displayType;
        this.displayMessage = str4;
        this.displayCustomIcon = bArr2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchTemplateBean(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("controlId", "");
        Intrinsics.checkNotNull(string);
        String string2 = bundle.getString("packageName", "");
        Intrinsics.checkNotNull(string2);
        String string3 = bundle.getString("title", "");
        Intrinsics.checkNotNullExpressionValue(string3, "bundle.getString(KEY_TITLE, \"\")");
        Icon icon = (Icon) bundle.getParcelable("mCustomIcon");
        byte[] byteArray = bundle.getByteArray("newCustomIcon");
        String string4 = bundle.getString("subTitle", "");
        int i8 = bundle.getInt("deviceTypeId", -1);
        String string5 = bundle.getString("pid", "");
        Intrinsics.checkNotNullExpressionValue(string5, "bundle.getString(KEY_DEVICE_PID, \"\")");
        boolean z2 = bundle.getBoolean("deviceConnectedStatus", false);
        String string6 = bundle.getString("deviceConnectedDesc", "");
        Intrinsics.checkNotNullExpressionValue(string6, "bundle.getString(KEY_DEVICE_CONNECTED_DESC, \"\")");
        long j8 = bundle.getLong("deviceLastConnectedTime", 0L);
        String string7 = bundle.getString("targetPackageName", "");
        Intrinsics.checkNotNullExpressionValue(string7, "bundle.getString(KEY_TARGET_PACKAGE_NAME, \"\")");
        String string8 = bundle.getString("targetClassName", "");
        boolean z3 = bundle.getBoolean(KEY_DEVICE_SWITCH, false);
        boolean z5 = bundle.getBoolean("isSupportClickCard", false);
        Bundle bundle2 = bundle.getBundle("clickCardBundle");
        int i9 = bundle.getInt(KEY_SWITCH_ACTION_TYPE, 0);
        String string9 = bundle.getString("deviceSingleId", "");
        int i10 = bundle.getInt("deviceShowLevel", 0);
        Serializable serializable = bundle.getSerializable("cardDisplayType");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.transsion.iotcardsdk.bean.DisplayType");
        this(string, string2, string3, icon, byteArray, string4, i8, string5, z2, string6, j8, string7, string8, z3, z5, bundle2, i9, string9, i10, (DisplayType) serializable, bundle.getString("displayMessage", null), bundle.getByteArray("displayCustomIcon"), bundle.getInt("sortLevel"), null, 8388608, null);
    }
}
