package com.transsion.iotcardsdk.bean;

import android.graphics.drawable.Icon;
import android.os.Bundle;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b8\u0018\u0000 `2\u00020\u0001:\u0001`B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B×\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\u000f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010&\u001a\u00020\u000f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012 \b\u0002\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060)0)¢\u0006\u0002\u0010*J\b\u0010]\u001a\u00020\u0003H\u0016J\b\u0010^\u001a\u00020\u000fH\u0016J\b\u0010_\u001a\u00020\u0006H\u0016R\u001c\u0010'\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R\u001c\u0010%\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010,\"\u0004\b?\u0010.R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010,\"\u0004\bE\u0010.R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR\u001a\u0010\u001e\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010H\"\u0004\bI\u0010JR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010A\"\u0004\bL\u0010CR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00109\"\u0004\bN\u0010;R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00109\"\u0004\bP\u0010;R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00109\"\u0004\bR\u0010;R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010,\"\u0004\bT\u0010.R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010,\"\u0004\bV\u0010.R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010,\"\u0004\bX\u0010.R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010,\"\u0004\bZ\u0010.R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010,\"\u0004\b\\\u0010.¨\u0006a"}, d2 = {"Lcom/transsion/iotcardsdk/bean/DisplayTemplateBean;", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "controlId", "", "packageName", "title", "mCustomIcon", "Landroid/graphics/drawable/Icon;", "newCustomIcon", "", "subTitle", "deviceTypeId", "", "pid", "deviceConnectedStatus", "", "deviceConnectedDesc", DisplayTemplateBean.KEY_EXTRA_INFO_ONE_ICON, DisplayTemplateBean.KEY_NEW_EXTRA_INFO_ONE_ICON, DisplayTemplateBean.KEY_EXTRA_INFO_ONE_DESC, DisplayTemplateBean.KEY_EXTRA_INFO_TWO_ICON, DisplayTemplateBean.KEY_NEW_EXTRA_INFO_TWO_ICON, DisplayTemplateBean.KEY_EXTRA_INFO_TWO_DESC, "deviceLastConnectedTime", "", "targetPackageName", "targetClassName", "isSupportClickCard", "clickCardBundle", "deviceSingleId", "deviceShowLevel", "cardDisplayType", "Lcom/transsion/iotcardsdk/bean/DisplayType;", "displayMessage", "displayCustomIcon", "sortLevel", DisplayTemplateBean.KEY_BOX_BATTERY, "deviceServiceMap", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Icon;[BLjava/lang/String;ILjava/lang/String;ZLjava/lang/String;Landroid/graphics/drawable/Icon;[BLjava/lang/String;Landroid/graphics/drawable/Icon;[BLjava/lang/String;JLjava/lang/String;Ljava/lang/String;ZLandroid/os/Bundle;Ljava/lang/String;ILcom/transsion/iotcardsdk/bean/DisplayType;Ljava/lang/String;[BILjava/lang/String;Ljava/util/Map;)V", "getBoxBattery", "()Ljava/lang/String;", "setBoxBattery", "(Ljava/lang/String;)V", "getCardDisplayType", "()Lcom/transsion/iotcardsdk/bean/DisplayType;", "setCardDisplayType", "(Lcom/transsion/iotcardsdk/bean/DisplayType;)V", "getClickCardBundle", "()Landroid/os/Bundle;", "setClickCardBundle", "getDeviceConnectedDesc", "setDeviceConnectedDesc", "getDisplayCustomIcon", "()[B", "setDisplayCustomIcon", "([B)V", "getDisplayMessage", "setDisplayMessage", "getExtraInfoOneDesc", "setExtraInfoOneDesc", "getExtraInfoOneIcon", "()Landroid/graphics/drawable/Icon;", "setExtraInfoOneIcon", "(Landroid/graphics/drawable/Icon;)V", "getExtraInfoTwoDesc", "setExtraInfoTwoDesc", "getExtraInfoTwoIcon", "setExtraInfoTwoIcon", "()Z", "setSupportClickCard", "(Z)V", "getMCustomIcon", "setMCustomIcon", "getNewCustomIcon", "setNewCustomIcon", "getNewExtraInfoOneIcon", "setNewExtraInfoOneIcon", "getNewExtraInfoTwoIcon", "setNewExtraInfoTwoIcon", "getPid", "setPid", "getSubTitle", "setSubTitle", "getTargetClassName", "setTargetClassName", "getTargetPackageName", "setTargetPackageName", "getTitle", "setTitle", "getDataBundle", "getTemplateType", "toString", "Companion", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DisplayTemplateBean extends IotCardTemplateBean {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEVICE_TYPE = 0;
    public static final String KEY_BOX_BATTERY = "boxBattery";
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
    public static final String KEY_DEVICE_TYPE_ID = "deviceTypeId";
    public static final String KEY_DISPLAY_CUSTOM_ICON = "displayCustomIcon";
    public static final String KEY_DISPLAY_MESSAGE = "displayMessage";
    public static final String KEY_EXTRA_INFO_ONE_DESC = "extraInfoOneDesc";
    public static final String KEY_EXTRA_INFO_ONE_ICON = "extraInfoOneIcon";
    public static final String KEY_EXTRA_INFO_TWO_DESC = "extraInfoTwoDesc";
    public static final String KEY_EXTRA_INFO_TWO_ICON = "extraInfoTwoIcon";
    public static final String KEY_IS_SUPPORT_CLICK_CARD = "isSupportClickCard";
    public static final String KEY_NEW_CUSTOM_ICON = "newCustomIcon";
    public static final String KEY_NEW_EXTRA_INFO_ONE_ICON = "newExtraInfoOneIcon";
    public static final String KEY_NEW_EXTRA_INFO_TWO_ICON = "newExtraInfoTwoIcon";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_SORT_LEVEL = "sortLevel";
    public static final String KEY_SUBTITLE = "subTitle";
    public static final String KEY_TARGET_CLASS_NAME = "targetClassName";
    public static final String KEY_TARGET_PACKAGE_NAME = "targetPackageName";
    public static final String KEY_TITLE = "title";
    private String boxBattery;
    private DisplayType cardDisplayType;
    private Bundle clickCardBundle;
    private String deviceConnectedDesc;
    private byte[] displayCustomIcon;
    private String displayMessage;
    private String extraInfoOneDesc;
    private Icon extraInfoOneIcon;
    private String extraInfoTwoDesc;
    private Icon extraInfoTwoIcon;
    private boolean isSupportClickCard;
    private Icon mCustomIcon;
    private byte[] newCustomIcon;
    private byte[] newExtraInfoOneIcon;
    private byte[] newExtraInfoTwoIcon;
    private String pid;
    private String subTitle;
    private String targetClassName;
    private String targetPackageName;
    private String title;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/transsion/iotcardsdk/bean/DisplayTemplateBean$Companion;", "", "()V", "DEVICE_TYPE", "", "getDEVICE_TYPE$annotations", "KEY_BOX_BATTERY", "", "KEY_CARD_DISPLAY_TYPE", "KEY_CLICK_CARD_BUNDLE", "KEY_CONTROL_ID", "KEY_CUSTOM_ICON", "KEY_DEVICE_CONNECTED_DESC", "KEY_DEVICE_CONNECTED_STATUS", "KEY_DEVICE_LAST_CONNECTED_TIME", "KEY_DEVICE_PID", "KEY_DEVICE_SHOW_LEVEL", "KEY_DEVICE_SINGLE_ID", "KEY_DEVICE_TYPE_ID", "KEY_DISPLAY_CUSTOM_ICON", "KEY_DISPLAY_MESSAGE", "KEY_EXTRA_INFO_ONE_DESC", "KEY_EXTRA_INFO_ONE_ICON", "KEY_EXTRA_INFO_TWO_DESC", "KEY_EXTRA_INFO_TWO_ICON", "KEY_IS_SUPPORT_CLICK_CARD", "KEY_NEW_CUSTOM_ICON", "KEY_NEW_EXTRA_INFO_ONE_ICON", "KEY_NEW_EXTRA_INFO_TWO_ICON", "KEY_PACKAGE_NAME", "KEY_SORT_LEVEL", "KEY_SUBTITLE", "KEY_TARGET_CLASS_NAME", "KEY_TARGET_PACKAGE_NAME", "KEY_TITLE", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEVICE_TYPE$annotations() {
        }

        private Companion() {
        }
    }

    public /* synthetic */ DisplayTemplateBean(String str, String str2, String str3, Icon icon, byte[] bArr, String str4, int i8, String str5, boolean z2, String str6, Icon icon2, byte[] bArr2, String str7, Icon icon3, byte[] bArr3, String str8, long j8, String str9, String str10, boolean z3, Bundle bundle, String str11, int i9, DisplayType displayType, String str12, byte[] bArr4, int i10, String str13, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? null : icon, (i11 & 16) != 0 ? null : bArr, (i11 & 32) != 0 ? "" : str4, i8, str5, (i11 & 256) != 0 ? false : z2, (i11 & 512) != 0 ? "" : str6, (i11 & 1024) != 0 ? null : icon2, (i11 & 2048) != 0 ? null : bArr2, (i11 & 4096) != 0 ? "" : str7, (i11 & 8192) != 0 ? null : icon3, (i11 & 16384) != 0 ? null : bArr3, (32768 & i11) != 0 ? "" : str8, j8, (131072 & i11) != 0 ? "" : str9, (262144 & i11) != 0 ? "" : str10, (524288 & i11) != 0 ? true : z3, (1048576 & i11) != 0 ? null : bundle, (2097152 & i11) != 0 ? "" : str11, (4194304 & i11) != 0 ? 0 : i9, (8388608 & i11) != 0 ? null : displayType, (16777216 & i11) != 0 ? null : str12, (33554432 & i11) != 0 ? null : bArr4, (67108864 & i11) != 0 ? 0 : i10, (134217728 & i11) != 0 ? null : str13, (i11 & 268435456) != 0 ? MapsKt.emptyMap() : map);
    }

    public final String getBoxBattery() {
        return this.boxBattery;
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
        dataBundle.putByteArray("newCustomIcon", this.newCustomIcon);
        dataBundle.putString("subTitle", this.subTitle);
        dataBundle.putInt("deviceTypeId", getDeviceTypeId());
        dataBundle.putString("pid", this.pid);
        dataBundle.putBoolean("deviceConnectedStatus", getDeviceConnectedStatus());
        dataBundle.putString("deviceConnectedDesc", this.deviceConnectedDesc);
        dataBundle.putParcelable(KEY_EXTRA_INFO_ONE_ICON, this.extraInfoOneIcon);
        dataBundle.putByteArray(KEY_NEW_EXTRA_INFO_ONE_ICON, this.newExtraInfoOneIcon);
        dataBundle.putString(KEY_EXTRA_INFO_ONE_DESC, this.extraInfoOneDesc);
        dataBundle.putParcelable(KEY_EXTRA_INFO_TWO_ICON, this.extraInfoTwoIcon);
        dataBundle.putByteArray(KEY_NEW_EXTRA_INFO_TWO_ICON, this.newExtraInfoTwoIcon);
        dataBundle.putString(KEY_EXTRA_INFO_TWO_DESC, this.extraInfoTwoDesc);
        dataBundle.putLong("deviceLastConnectedTime", getDeviceLastConnectedTime());
        dataBundle.putString("targetPackageName", this.targetPackageName);
        dataBundle.putString("targetClassName", this.targetClassName);
        dataBundle.putBoolean("isSupportClickCard", this.isSupportClickCard);
        dataBundle.putBundle("clickCardBundle", this.clickCardBundle);
        dataBundle.putString("deviceSingleId", getDeviceSingleId());
        dataBundle.putInt("deviceShowLevel", getDeviceShowLevel());
        dataBundle.putSerializable("cardDisplayType", this.cardDisplayType);
        dataBundle.putString("displayMessage", this.displayMessage);
        dataBundle.putByteArray("displayCustomIcon", this.displayCustomIcon);
        dataBundle.putInt("sortLevel", getSortLevel());
        dataBundle.putString(KEY_BOX_BATTERY, this.boxBattery);
        return dataBundle;
    }

    public final String getDeviceConnectedDesc() {
        return this.deviceConnectedDesc;
    }

    public final byte[] getDisplayCustomIcon() {
        return this.displayCustomIcon;
    }

    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    public final String getExtraInfoOneDesc() {
        return this.extraInfoOneDesc;
    }

    public final Icon getExtraInfoOneIcon() {
        return this.extraInfoOneIcon;
    }

    public final String getExtraInfoTwoDesc() {
        return this.extraInfoTwoDesc;
    }

    public final Icon getExtraInfoTwoIcon() {
        return this.extraInfoTwoIcon;
    }

    public final Icon getMCustomIcon() {
        return this.mCustomIcon;
    }

    public final byte[] getNewCustomIcon() {
        return this.newCustomIcon;
    }

    public final byte[] getNewExtraInfoOneIcon() {
        return this.newExtraInfoOneIcon;
    }

    public final byte[] getNewExtraInfoTwoIcon() {
        return this.newExtraInfoTwoIcon;
    }

    public final String getPid() {
        return this.pid;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTargetClassName() {
        return this.targetClassName;
    }

    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    @Override // com.transsion.iotcardsdk.bean.IotCardTemplateBean
    public int getTemplateType() {
        return 0;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isSupportClickCard, reason: from getter */
    public final boolean getIsSupportClickCard() {
        return this.isSupportClickCard;
    }

    public final void setBoxBattery(String str) {
        this.boxBattery = str;
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

    public final void setDisplayCustomIcon(byte[] bArr) {
        this.displayCustomIcon = bArr;
    }

    public final void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public final void setExtraInfoOneDesc(String str) {
        this.extraInfoOneDesc = str;
    }

    public final void setExtraInfoOneIcon(Icon icon) {
        this.extraInfoOneIcon = icon;
    }

    public final void setExtraInfoTwoDesc(String str) {
        this.extraInfoTwoDesc = str;
    }

    public final void setExtraInfoTwoIcon(Icon icon) {
        this.extraInfoTwoIcon = icon;
    }

    public final void setMCustomIcon(Icon icon) {
        this.mCustomIcon = icon;
    }

    public final void setNewCustomIcon(byte[] bArr) {
        this.newCustomIcon = bArr;
    }

    public final void setNewExtraInfoOneIcon(byte[] bArr) {
        this.newExtraInfoOneIcon = bArr;
    }

    public final void setNewExtraInfoTwoIcon(byte[] bArr) {
        this.newExtraInfoTwoIcon = bArr;
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

    public final void setTargetClassName(String str) {
        this.targetClassName = str;
    }

    public final void setTargetPackageName(String str) {
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
        Icon icon2 = this.extraInfoOneIcon;
        String str5 = this.extraInfoOneDesc;
        Icon icon3 = this.extraInfoTwoIcon;
        String str6 = this.extraInfoTwoDesc;
        long deviceLastConnectedTime = getDeviceLastConnectedTime();
        String str7 = this.targetPackageName;
        String str8 = this.targetClassName;
        boolean z2 = this.isSupportClickCard;
        String deviceSingleId = getDeviceSingleId();
        int deviceShowLevel = getDeviceShowLevel();
        DisplayType displayType = this.cardDisplayType;
        String str9 = this.displayMessage;
        byte[] bArr = this.displayCustomIcon;
        int sortLevel = getSortLevel();
        String str10 = this.boxBattery;
        Map<String, Map<String, String>> deviceServiceMap = getDeviceServiceMap();
        StringBuilder sbP = a.p("DisplayTemplateBean(controlId='", controlId, "',packageName='", packageName, "'，title='");
        sbP.append(str);
        sbP.append("', mCustomIcon=");
        sbP.append(icon);
        sbP.append(", subTitle=");
        sbP.append(str2);
        sbP.append(", deviceTypeId=");
        sbP.append(deviceTypeId);
        sbP.append(", pid = ");
        sbP.append(str3);
        sbP.append(",deviceConnectedStatus=");
        sbP.append(deviceConnectedStatus);
        sbP.append(", deviceConnectedDesc='");
        sbP.append(str4);
        sbP.append("', extraInfoOneIcon=");
        sbP.append(icon2);
        sbP.append(", extraInfoOneDesc=");
        sbP.append(str5);
        sbP.append(", extraInfoTwoIcon=");
        sbP.append(icon3);
        sbP.append(", extraInfoTwoDesc=");
        sbP.append(str6);
        sbP.append(", deviceLastConnectedTime=");
        sbP.append(deviceLastConnectedTime);
        d.A(sbP, ", targetPackageName=", str7, ", targetClassName=", str8);
        sbP.append(",isSupportClickCard=");
        sbP.append(z2);
        sbP.append(",deviceSingleId=");
        sbP.append(deviceSingleId);
        sbP.append(",deviceShowLevel=");
        sbP.append(deviceShowLevel);
        sbP.append("),cardDisplay=");
        sbP.append(displayType);
        sbP.append(",displayMessage=");
        sbP.append(str9);
        sbP.append(",displayCustomIcon=");
        sbP.append(bArr);
        sbP.append(", sortLevel=");
        sbP.append(sortLevel);
        sbP.append(", boxBattery:");
        sbP.append(str10);
        sbP.append(", deviceServiceMap:");
        sbP.append(deviceServiceMap);
        return sbP.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayTemplateBean(String controlId, String packageName, String title, Icon icon, byte[] bArr, String str, int i8, String pid, boolean z2, String deviceConnectedDesc, Icon icon2, byte[] bArr2, String str2, Icon icon3, byte[] bArr3, String str3, long j8, String str4, String str5, boolean z3, Bundle bundle, String str6, int i9, DisplayType displayType, String str7, byte[] bArr4, int i10, String str8, Map<String, ? extends Map<String, String>> deviceServiceMap) {
        super(controlId, packageName, str6, i9, z2, i8, j8, i10, deviceServiceMap);
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(deviceConnectedDesc, "deviceConnectedDesc");
        Intrinsics.checkNotNullParameter(deviceServiceMap, "deviceServiceMap");
        this.title = title;
        this.mCustomIcon = icon;
        this.newCustomIcon = bArr;
        this.subTitle = str;
        this.pid = pid;
        this.deviceConnectedDesc = deviceConnectedDesc;
        this.extraInfoOneIcon = icon2;
        this.newExtraInfoOneIcon = bArr2;
        this.extraInfoOneDesc = str2;
        this.extraInfoTwoIcon = icon3;
        this.newExtraInfoTwoIcon = bArr3;
        this.extraInfoTwoDesc = str3;
        this.targetPackageName = str4;
        this.targetClassName = str5;
        this.isSupportClickCard = z3;
        this.clickCardBundle = bundle;
        this.cardDisplayType = displayType;
        this.displayMessage = str7;
        this.displayCustomIcon = bArr4;
        this.boxBattery = str8;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DisplayTemplateBean(Bundle bundle) {
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
        Icon icon2 = (Icon) bundle.getParcelable(KEY_EXTRA_INFO_ONE_ICON);
        byte[] byteArray2 = bundle.getByteArray(KEY_NEW_EXTRA_INFO_ONE_ICON);
        String string7 = bundle.getString(KEY_EXTRA_INFO_ONE_DESC, "");
        Icon icon3 = (Icon) bundle.getParcelable(KEY_EXTRA_INFO_TWO_ICON);
        byte[] byteArray3 = bundle.getByteArray(KEY_NEW_EXTRA_INFO_TWO_ICON);
        String string8 = bundle.getString(KEY_EXTRA_INFO_TWO_DESC, "");
        long j8 = bundle.getLong("deviceLastConnectedTime", 0L);
        String string9 = bundle.getString("targetPackageName", "");
        String string10 = bundle.getString("targetClassName", "");
        boolean z3 = bundle.getBoolean("isSupportClickCard", false);
        Bundle bundle2 = bundle.getBundle("clickCardBundle");
        String string11 = bundle.getString("deviceSingleId", "");
        int i9 = bundle.getInt("deviceShowLevel", 0);
        Serializable serializable = bundle.getSerializable("cardDisplayType");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.transsion.iotcardsdk.bean.DisplayType");
        this(string, string2, string3, icon, byteArray, string4, i8, string5, z2, string6, icon2, byteArray2, string7, icon3, byteArray3, string8, j8, string9, string10, z3, bundle2, string11, i9, (DisplayType) serializable, bundle.getString("displayMessage", null), bundle.getByteArray("displayCustomIcon"), bundle.getInt("sortLevel"), bundle.getString(KEY_BOX_BATTERY), null, 268435456, null);
    }
}
