package com.transsion.iotservice.iotcard.proto;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.transsion.iotcardsdk.bean.DisplayTemplateBean;
import com.transsion.iotcardsdk.bean.SwitchTemplateBean;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IotcardBeanKt;", "", "()V", "Dsl", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IotcardBeanKt {
    public static final IotcardBeanKt INSTANCE = new IotcardBeanKt();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0080\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010c\u001a\u00020dH\u0001J\u0006\u0010e\u001a\u00020fJ\u0006\u0010g\u001a\u00020fJ\u0006\u0010h\u001a\u00020fJ\u0006\u0010i\u001a\u00020fJ\u0006\u0010j\u001a\u00020fJ\u0006\u0010k\u001a\u00020fJ\u0006\u0010l\u001a\u00020fJ\u0006\u0010m\u001a\u00020fJ\u0006\u0010n\u001a\u00020fJ\u0006\u0010o\u001a\u00020fJ\u0006\u0010p\u001a\u00020fJ\u0006\u0010q\u001a\u00020fJ\u0006\u0010r\u001a\u00020fJ\u0006\u0010s\u001a\u00020fJ\u0006\u0010t\u001a\u00020fJ\u0006\u0010u\u001a\u00020fJ\u0006\u0010v\u001a\u00020fJ\u0006\u0010w\u001a\u00020fJ\u0006\u0010x\u001a\u00020fJ\u0006\u0010y\u001a\u00020fJ\u0006\u0010z\u001a\u00020fJ\u0006\u0010{\u001a\u00020fJ\u0006\u0010|\u001a\u00020fJ\u0006\u0010}\u001a\u00020fJ\u0006\u0010~\u001a\u00020fJ\u0006\u0010\u007f\u001a\u00020fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR$\u0010*\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R$\u0010-\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R$\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR$\u00104\u001a\u0002032\u0006\u0010\u0005\u001a\u0002038G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R$\u0010<\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R$\u0010?\u001a\u0002032\u0006\u0010\u0005\u001a\u0002038G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u00106\"\u0004\bA\u00108R$\u0010B\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R$\u0010E\u001a\u0002032\u0006\u0010\u0005\u001a\u0002038G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u00106\"\u0004\bG\u00108R$\u0010H\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010 R$\u0010K\u001a\u0002032\u0006\u0010\u0005\u001a\u0002038G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u00106\"\u0004\bM\u00108R$\u0010N\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\u0012\"\u0004\bP\u0010\u0014R$\u0010Q\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\u0012\"\u0004\bS\u0010\u0014R$\u0010T\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010\u0012\"\u0004\bV\u0010\u0014R$\u0010W\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010\t\"\u0004\bY\u0010\u000bR$\u0010Z\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010\u0012\"\u0004\b\\\u0010\u0014R$\u0010]\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u0012\"\u0004\b_\u0010\u0014R$\u0010`\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u0012\"\u0004\bb\u0010\u0014¨\u0006\u0081\u0001"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IotcardBeanKt$Dsl;", "", "_builder", "Lcom/transsion/iotservice/iotcard/proto/IotcardBean$Builder;", "(Lcom/transsion/iotservice/iotcard/proto/IotcardBean$Builder;)V", "value", "", "cardDisplayType", "getCardDisplayType", "()I", "setCardDisplayType", "(I)V", "cardType", "getCardType", "setCardType", "", "clickCardBundle", "getClickCardBundle", "()Ljava/lang/String;", "setClickCardBundle", "(Ljava/lang/String;)V", "controlId", "getControlId", "setControlId", "deviceConnectedDesc", "getDeviceConnectedDesc", "setDeviceConnectedDesc", "", "deviceConnectedStatus", "getDeviceConnectedStatus", "()Z", "setDeviceConnectedStatus", "(Z)V", "", "deviceLastConnectedTime", "getDeviceLastConnectedTime", "()J", "setDeviceLastConnectedTime", "(J)V", "deviceShowLevel", "getDeviceShowLevel", "setDeviceShowLevel", "deviceSingleId", "getDeviceSingleId", "setDeviceSingleId", SwitchTemplateBean.KEY_DEVICE_SWITCH, "getDeviceSwitch", "setDeviceSwitch", "deviceTypeId", "getDeviceTypeId", "setDeviceTypeId", "Lcom/google/protobuf/ByteString;", "displayCustomIcon", "getDisplayCustomIcon", "()Lcom/google/protobuf/ByteString;", "setDisplayCustomIcon", "(Lcom/google/protobuf/ByteString;)V", "displayMessage", "getDisplayMessage", "setDisplayMessage", DisplayTemplateBean.KEY_EXTRA_INFO_ONE_DESC, "getExtraInfoOneDesc", "setExtraInfoOneDesc", DisplayTemplateBean.KEY_EXTRA_INFO_ONE_ICON, "getExtraInfoOneIcon", "setExtraInfoOneIcon", DisplayTemplateBean.KEY_EXTRA_INFO_TWO_DESC, "getExtraInfoTwoDesc", "setExtraInfoTwoDesc", DisplayTemplateBean.KEY_EXTRA_INFO_TWO_ICON, "getExtraInfoTwoIcon", "setExtraInfoTwoIcon", "isSupportClickCard", "getIsSupportClickCard", "setIsSupportClickCard", "mCustomIcon", "getMCustomIcon", "setMCustomIcon", "packageName", "getPackageName", "setPackageName", "pid", "getPid", "setPid", "subTitle", "getSubTitle", "setSubTitle", SwitchTemplateBean.KEY_SWITCH_ACTION_TYPE, "getSwitchActionType", "setSwitchActionType", "targetClassName", "getTargetClassName", "setTargetClassName", "targetPackageName", "getTargetPackageName", "setTargetPackageName", "title", "getTitle", "setTitle", "_build", "Lcom/transsion/iotservice/iotcard/proto/IotcardBean;", "clearCardDisplayType", "", "clearCardType", "clearClickCardBundle", "clearControlId", "clearDeviceConnectedDesc", "clearDeviceConnectedStatus", "clearDeviceLastConnectedTime", "clearDeviceShowLevel", "clearDeviceSingleId", "clearDeviceSwitch", "clearDeviceTypeId", "clearDisplayCustomIcon", "clearDisplayMessage", "clearExtraInfoOneDesc", "clearExtraInfoOneIcon", "clearExtraInfoTwoDesc", "clearExtraInfoTwoIcon", "clearIsSupportClickCard", "clearMCustomIcon", "clearPackageName", "clearPid", "clearSubTitle", "clearSwitchActionType", "clearTargetClassName", "clearTargetPackageName", "clearTitle", "Companion", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final IotcardBean.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/transsion/iotservice/iotcard/proto/IotcardBeanKt$Dsl$Companion;", "", "()V", "_create", "Lcom/transsion/iotservice/iotcard/proto/IotcardBeanKt$Dsl;", "builder", "Lcom/transsion/iotservice/iotcard/proto/IotcardBean$Builder;", "iotcardprotoco_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(IotcardBean.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(IotcardBean.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ IotcardBean _build() {
            IotcardBean iotcardBeanBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(iotcardBeanBuild, "_builder.build()");
            return iotcardBeanBuild;
        }

        public final void clearCardDisplayType() {
            this._builder.clearCardDisplayType();
        }

        public final void clearCardType() {
            this._builder.clearCardType();
        }

        public final void clearClickCardBundle() {
            this._builder.clearClickCardBundle();
        }

        public final void clearControlId() {
            this._builder.clearControlId();
        }

        public final void clearDeviceConnectedDesc() {
            this._builder.clearDeviceConnectedDesc();
        }

        public final void clearDeviceConnectedStatus() {
            this._builder.clearDeviceConnectedStatus();
        }

        public final void clearDeviceLastConnectedTime() {
            this._builder.clearDeviceLastConnectedTime();
        }

        public final void clearDeviceShowLevel() {
            this._builder.clearDeviceShowLevel();
        }

        public final void clearDeviceSingleId() {
            this._builder.clearDeviceSingleId();
        }

        public final void clearDeviceSwitch() {
            this._builder.clearDeviceSwitch();
        }

        public final void clearDeviceTypeId() {
            this._builder.clearDeviceTypeId();
        }

        public final void clearDisplayCustomIcon() {
            this._builder.clearDisplayCustomIcon();
        }

        public final void clearDisplayMessage() {
            this._builder.clearDisplayMessage();
        }

        public final void clearExtraInfoOneDesc() {
            this._builder.clearExtraInfoOneDesc();
        }

        public final void clearExtraInfoOneIcon() {
            this._builder.clearExtraInfoOneIcon();
        }

        public final void clearExtraInfoTwoDesc() {
            this._builder.clearExtraInfoTwoDesc();
        }

        public final void clearExtraInfoTwoIcon() {
            this._builder.clearExtraInfoTwoIcon();
        }

        public final void clearIsSupportClickCard() {
            this._builder.clearIsSupportClickCard();
        }

        public final void clearMCustomIcon() {
            this._builder.clearMCustomIcon();
        }

        public final void clearPackageName() {
            this._builder.clearPackageName();
        }

        public final void clearPid() {
            this._builder.clearPid();
        }

        public final void clearSubTitle() {
            this._builder.clearSubTitle();
        }

        public final void clearSwitchActionType() {
            this._builder.clearSwitchActionType();
        }

        public final void clearTargetClassName() {
            this._builder.clearTargetClassName();
        }

        public final void clearTargetPackageName() {
            this._builder.clearTargetPackageName();
        }

        public final void clearTitle() {
            this._builder.clearTitle();
        }

        @JvmName(name = "getCardDisplayType")
        public final int getCardDisplayType() {
            return this._builder.getCardDisplayType();
        }

        @JvmName(name = "getCardType")
        public final int getCardType() {
            return this._builder.getCardType();
        }

        @JvmName(name = "getClickCardBundle")
        public final String getClickCardBundle() {
            String clickCardBundle = this._builder.getClickCardBundle();
            Intrinsics.checkNotNullExpressionValue(clickCardBundle, "_builder.getClickCardBundle()");
            return clickCardBundle;
        }

        @JvmName(name = "getControlId")
        public final String getControlId() {
            String controlId = this._builder.getControlId();
            Intrinsics.checkNotNullExpressionValue(controlId, "_builder.getControlId()");
            return controlId;
        }

        @JvmName(name = "getDeviceConnectedDesc")
        public final String getDeviceConnectedDesc() {
            String deviceConnectedDesc = this._builder.getDeviceConnectedDesc();
            Intrinsics.checkNotNullExpressionValue(deviceConnectedDesc, "_builder.getDeviceConnectedDesc()");
            return deviceConnectedDesc;
        }

        @JvmName(name = "getDeviceConnectedStatus")
        public final boolean getDeviceConnectedStatus() {
            return this._builder.getDeviceConnectedStatus();
        }

        @JvmName(name = "getDeviceLastConnectedTime")
        public final long getDeviceLastConnectedTime() {
            return this._builder.getDeviceLastConnectedTime();
        }

        @JvmName(name = "getDeviceShowLevel")
        public final int getDeviceShowLevel() {
            return this._builder.getDeviceShowLevel();
        }

        @JvmName(name = "getDeviceSingleId")
        public final String getDeviceSingleId() {
            String deviceSingleId = this._builder.getDeviceSingleId();
            Intrinsics.checkNotNullExpressionValue(deviceSingleId, "_builder.getDeviceSingleId()");
            return deviceSingleId;
        }

        @JvmName(name = "getDeviceSwitch")
        public final boolean getDeviceSwitch() {
            return this._builder.getDeviceSwitch();
        }

        @JvmName(name = "getDeviceTypeId")
        public final int getDeviceTypeId() {
            return this._builder.getDeviceTypeId();
        }

        @JvmName(name = "getDisplayCustomIcon")
        public final ByteString getDisplayCustomIcon() {
            ByteString displayCustomIcon = this._builder.getDisplayCustomIcon();
            Intrinsics.checkNotNullExpressionValue(displayCustomIcon, "_builder.getDisplayCustomIcon()");
            return displayCustomIcon;
        }

        @JvmName(name = "getDisplayMessage")
        public final String getDisplayMessage() {
            String displayMessage = this._builder.getDisplayMessage();
            Intrinsics.checkNotNullExpressionValue(displayMessage, "_builder.getDisplayMessage()");
            return displayMessage;
        }

        @JvmName(name = "getExtraInfoOneDesc")
        public final String getExtraInfoOneDesc() {
            String extraInfoOneDesc = this._builder.getExtraInfoOneDesc();
            Intrinsics.checkNotNullExpressionValue(extraInfoOneDesc, "_builder.getExtraInfoOneDesc()");
            return extraInfoOneDesc;
        }

        @JvmName(name = "getExtraInfoOneIcon")
        public final ByteString getExtraInfoOneIcon() {
            ByteString extraInfoOneIcon = this._builder.getExtraInfoOneIcon();
            Intrinsics.checkNotNullExpressionValue(extraInfoOneIcon, "_builder.getExtraInfoOneIcon()");
            return extraInfoOneIcon;
        }

        @JvmName(name = "getExtraInfoTwoDesc")
        public final String getExtraInfoTwoDesc() {
            String extraInfoTwoDesc = this._builder.getExtraInfoTwoDesc();
            Intrinsics.checkNotNullExpressionValue(extraInfoTwoDesc, "_builder.getExtraInfoTwoDesc()");
            return extraInfoTwoDesc;
        }

        @JvmName(name = "getExtraInfoTwoIcon")
        public final ByteString getExtraInfoTwoIcon() {
            ByteString extraInfoTwoIcon = this._builder.getExtraInfoTwoIcon();
            Intrinsics.checkNotNullExpressionValue(extraInfoTwoIcon, "_builder.getExtraInfoTwoIcon()");
            return extraInfoTwoIcon;
        }

        @JvmName(name = "getIsSupportClickCard")
        public final boolean getIsSupportClickCard() {
            return this._builder.getIsSupportClickCard();
        }

        @JvmName(name = "getMCustomIcon")
        public final ByteString getMCustomIcon() {
            ByteString mCustomIcon = this._builder.getMCustomIcon();
            Intrinsics.checkNotNullExpressionValue(mCustomIcon, "_builder.getMCustomIcon()");
            return mCustomIcon;
        }

        @JvmName(name = "getPackageName")
        public final String getPackageName() {
            String packageName = this._builder.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "_builder.getPackageName()");
            return packageName;
        }

        @JvmName(name = "getPid")
        public final String getPid() {
            String pid = this._builder.getPid();
            Intrinsics.checkNotNullExpressionValue(pid, "_builder.getPid()");
            return pid;
        }

        @JvmName(name = "getSubTitle")
        public final String getSubTitle() {
            String subTitle = this._builder.getSubTitle();
            Intrinsics.checkNotNullExpressionValue(subTitle, "_builder.getSubTitle()");
            return subTitle;
        }

        @JvmName(name = "getSwitchActionType")
        public final int getSwitchActionType() {
            return this._builder.getSwitchActionType();
        }

        @JvmName(name = "getTargetClassName")
        public final String getTargetClassName() {
            String targetClassName = this._builder.getTargetClassName();
            Intrinsics.checkNotNullExpressionValue(targetClassName, "_builder.getTargetClassName()");
            return targetClassName;
        }

        @JvmName(name = "getTargetPackageName")
        public final String getTargetPackageName() {
            String targetPackageName = this._builder.getTargetPackageName();
            Intrinsics.checkNotNullExpressionValue(targetPackageName, "_builder.getTargetPackageName()");
            return targetPackageName;
        }

        @JvmName(name = "getTitle")
        public final String getTitle() {
            String title = this._builder.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "_builder.getTitle()");
            return title;
        }

        @JvmName(name = "setCardDisplayType")
        public final void setCardDisplayType(int i8) {
            this._builder.setCardDisplayType(i8);
        }

        @JvmName(name = "setCardType")
        public final void setCardType(int i8) {
            this._builder.setCardType(i8);
        }

        @JvmName(name = "setClickCardBundle")
        public final void setClickCardBundle(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setClickCardBundle(value);
        }

        @JvmName(name = "setControlId")
        public final void setControlId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setControlId(value);
        }

        @JvmName(name = "setDeviceConnectedDesc")
        public final void setDeviceConnectedDesc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDeviceConnectedDesc(value);
        }

        @JvmName(name = "setDeviceConnectedStatus")
        public final void setDeviceConnectedStatus(boolean z2) {
            this._builder.setDeviceConnectedStatus(z2);
        }

        @JvmName(name = "setDeviceLastConnectedTime")
        public final void setDeviceLastConnectedTime(long j8) {
            this._builder.setDeviceLastConnectedTime(j8);
        }

        @JvmName(name = "setDeviceShowLevel")
        public final void setDeviceShowLevel(int i8) {
            this._builder.setDeviceShowLevel(i8);
        }

        @JvmName(name = "setDeviceSingleId")
        public final void setDeviceSingleId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDeviceSingleId(value);
        }

        @JvmName(name = "setDeviceSwitch")
        public final void setDeviceSwitch(boolean z2) {
            this._builder.setDeviceSwitch(z2);
        }

        @JvmName(name = "setDeviceTypeId")
        public final void setDeviceTypeId(int i8) {
            this._builder.setDeviceTypeId(i8);
        }

        @JvmName(name = "setDisplayCustomIcon")
        public final void setDisplayCustomIcon(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDisplayCustomIcon(value);
        }

        @JvmName(name = "setDisplayMessage")
        public final void setDisplayMessage(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDisplayMessage(value);
        }

        @JvmName(name = "setExtraInfoOneDesc")
        public final void setExtraInfoOneDesc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtraInfoOneDesc(value);
        }

        @JvmName(name = "setExtraInfoOneIcon")
        public final void setExtraInfoOneIcon(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtraInfoOneIcon(value);
        }

        @JvmName(name = "setExtraInfoTwoDesc")
        public final void setExtraInfoTwoDesc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtraInfoTwoDesc(value);
        }

        @JvmName(name = "setExtraInfoTwoIcon")
        public final void setExtraInfoTwoIcon(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtraInfoTwoIcon(value);
        }

        @JvmName(name = "setIsSupportClickCard")
        public final void setIsSupportClickCard(boolean z2) {
            this._builder.setIsSupportClickCard(z2);
        }

        @JvmName(name = "setMCustomIcon")
        public final void setMCustomIcon(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMCustomIcon(value);
        }

        @JvmName(name = "setPackageName")
        public final void setPackageName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPackageName(value);
        }

        @JvmName(name = "setPid")
        public final void setPid(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPid(value);
        }

        @JvmName(name = "setSubTitle")
        public final void setSubTitle(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSubTitle(value);
        }

        @JvmName(name = "setSwitchActionType")
        public final void setSwitchActionType(int i8) {
            this._builder.setSwitchActionType(i8);
        }

        @JvmName(name = "setTargetClassName")
        public final void setTargetClassName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setTargetClassName(value);
        }

        @JvmName(name = "setTargetPackageName")
        public final void setTargetPackageName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setTargetPackageName(value);
        }

        @JvmName(name = "setTitle")
        public final void setTitle(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setTitle(value);
        }

        private Dsl(IotcardBean.Builder builder) {
            this._builder = builder;
        }
    }

    private IotcardBeanKt() {
    }
}
