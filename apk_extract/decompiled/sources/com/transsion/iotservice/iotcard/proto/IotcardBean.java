package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class IotcardBean extends GeneratedMessageLite<IotcardBean, Builder> implements IotcardBeanOrBuilder {
    public static final int CARD_DISPLAY_TYPE_FIELD_NUMBER = 24;
    public static final int CARD_TYPE_FIELD_NUMBER = 21;
    public static final int CLICK_CARD_BUNDLE_FIELD_NUMBER = 18;
    public static final int CONTROL_ID_FIELD_NUMBER = 1;
    private static final IotcardBean DEFAULT_INSTANCE;
    public static final int DEVICE_CONNECTED_DESC_FIELD_NUMBER = 9;
    public static final int DEVICE_CONNECTED_STATUS_FIELD_NUMBER = 8;
    public static final int DEVICE_LAST_CONNECTED_TIME_FIELD_NUMBER = 14;
    public static final int DEVICE_SHOW_LEVEL_FIELD_NUMBER = 20;
    public static final int DEVICE_SINGLE_ID_FIELD_NUMBER = 19;
    public static final int DEVICE_SWITCH_FIELD_NUMBER = 22;
    public static final int DEVICE_TYPE_ID_FIELD_NUMBER = 6;
    public static final int DISPLAY_CUSTOM_ICON_FIELD_NUMBER = 26;
    public static final int DISPLAY_MESSAGE_FIELD_NUMBER = 25;
    public static final int EXTRA_INFO_ONE_DESC_FIELD_NUMBER = 11;
    public static final int EXTRA_INFO_ONE_ICON_FIELD_NUMBER = 10;
    public static final int EXTRA_INFO_TWO_DESC_FIELD_NUMBER = 13;
    public static final int EXTRA_INFO_TWO_ICON_FIELD_NUMBER = 12;
    public static final int IS_SUPPORT_CLICK_CARD_FIELD_NUMBER = 17;
    public static final int M_CUSTOM_ICON_FIELD_NUMBER = 4;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 2;
    private static volatile Parser<IotcardBean> PARSER = null;
    public static final int PID_FIELD_NUMBER = 7;
    public static final int SUB_TITLE_FIELD_NUMBER = 5;
    public static final int SWITCH_ACTION_TYPE_FIELD_NUMBER = 23;
    public static final int TARGET_CLASS_NAME_FIELD_NUMBER = 16;
    public static final int TARGET_PACKAGE_NAME_FIELD_NUMBER = 15;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int cardDisplayType_;
    private int cardType_;
    private String clickCardBundle_;
    private String deviceConnectedDesc_;
    private boolean deviceConnectedStatus_;
    private long deviceLastConnectedTime_;
    private int deviceShowLevel_;
    private String deviceSingleId_;
    private boolean deviceSwitch_;
    private int deviceTypeId_;
    private ByteString displayCustomIcon_;
    private String displayMessage_;
    private String extraInfoOneDesc_;
    private ByteString extraInfoOneIcon_;
    private String extraInfoTwoDesc_;
    private ByteString extraInfoTwoIcon_;
    private boolean isSupportClickCard_;
    private ByteString mCustomIcon_;
    private String pid_;
    private String subTitle_;
    private int switchActionType_;
    private String targetClassName_;
    private String targetPackageName_;
    private String controlId_ = "";
    private String packageName_ = "";
    private String title_ = "";

    /* JADX INFO: renamed from: com.transsion.iotservice.iotcard.proto.IotcardBean$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<IotcardBean, Builder> implements IotcardBeanOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCardDisplayType() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearCardDisplayType();
            return this;
        }

        public Builder clearCardType() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearCardType();
            return this;
        }

        public Builder clearClickCardBundle() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearClickCardBundle();
            return this;
        }

        public Builder clearControlId() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearControlId();
            return this;
        }

        public Builder clearDeviceConnectedDesc() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDeviceConnectedDesc();
            return this;
        }

        public Builder clearDeviceConnectedStatus() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDeviceConnectedStatus();
            return this;
        }

        public Builder clearDeviceLastConnectedTime() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDeviceLastConnectedTime();
            return this;
        }

        public Builder clearDeviceShowLevel() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDeviceShowLevel();
            return this;
        }

        public Builder clearDeviceSingleId() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDeviceSingleId();
            return this;
        }

        public Builder clearDeviceSwitch() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDeviceSwitch();
            return this;
        }

        public Builder clearDeviceTypeId() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDeviceTypeId();
            return this;
        }

        public Builder clearDisplayCustomIcon() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDisplayCustomIcon();
            return this;
        }

        public Builder clearDisplayMessage() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearDisplayMessage();
            return this;
        }

        public Builder clearExtraInfoOneDesc() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearExtraInfoOneDesc();
            return this;
        }

        public Builder clearExtraInfoOneIcon() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearExtraInfoOneIcon();
            return this;
        }

        public Builder clearExtraInfoTwoDesc() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearExtraInfoTwoDesc();
            return this;
        }

        public Builder clearExtraInfoTwoIcon() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearExtraInfoTwoIcon();
            return this;
        }

        public Builder clearIsSupportClickCard() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearIsSupportClickCard();
            return this;
        }

        public Builder clearMCustomIcon() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearMCustomIcon();
            return this;
        }

        public Builder clearPackageName() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearPackageName();
            return this;
        }

        public Builder clearPid() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearPid();
            return this;
        }

        public Builder clearSubTitle() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearSubTitle();
            return this;
        }

        public Builder clearSwitchActionType() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearSwitchActionType();
            return this;
        }

        public Builder clearTargetClassName() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearTargetClassName();
            return this;
        }

        public Builder clearTargetPackageName() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearTargetPackageName();
            return this;
        }

        public Builder clearTitle() {
            copyOnWrite();
            ((IotcardBean) this.instance).clearTitle();
            return this;
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public int getCardDisplayType() {
            return ((IotcardBean) this.instance).getCardDisplayType();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public int getCardType() {
            return ((IotcardBean) this.instance).getCardType();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getClickCardBundle() {
            return ((IotcardBean) this.instance).getClickCardBundle();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getClickCardBundleBytes() {
            return ((IotcardBean) this.instance).getClickCardBundleBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getControlId() {
            return ((IotcardBean) this.instance).getControlId();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getControlIdBytes() {
            return ((IotcardBean) this.instance).getControlIdBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getDeviceConnectedDesc() {
            return ((IotcardBean) this.instance).getDeviceConnectedDesc();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getDeviceConnectedDescBytes() {
            return ((IotcardBean) this.instance).getDeviceConnectedDescBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public boolean getDeviceConnectedStatus() {
            return ((IotcardBean) this.instance).getDeviceConnectedStatus();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public long getDeviceLastConnectedTime() {
            return ((IotcardBean) this.instance).getDeviceLastConnectedTime();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public int getDeviceShowLevel() {
            return ((IotcardBean) this.instance).getDeviceShowLevel();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getDeviceSingleId() {
            return ((IotcardBean) this.instance).getDeviceSingleId();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getDeviceSingleIdBytes() {
            return ((IotcardBean) this.instance).getDeviceSingleIdBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public boolean getDeviceSwitch() {
            return ((IotcardBean) this.instance).getDeviceSwitch();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public int getDeviceTypeId() {
            return ((IotcardBean) this.instance).getDeviceTypeId();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getDisplayCustomIcon() {
            return ((IotcardBean) this.instance).getDisplayCustomIcon();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getDisplayMessage() {
            return ((IotcardBean) this.instance).getDisplayMessage();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getDisplayMessageBytes() {
            return ((IotcardBean) this.instance).getDisplayMessageBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getExtraInfoOneDesc() {
            return ((IotcardBean) this.instance).getExtraInfoOneDesc();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getExtraInfoOneDescBytes() {
            return ((IotcardBean) this.instance).getExtraInfoOneDescBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getExtraInfoOneIcon() {
            return ((IotcardBean) this.instance).getExtraInfoOneIcon();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getExtraInfoTwoDesc() {
            return ((IotcardBean) this.instance).getExtraInfoTwoDesc();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getExtraInfoTwoDescBytes() {
            return ((IotcardBean) this.instance).getExtraInfoTwoDescBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getExtraInfoTwoIcon() {
            return ((IotcardBean) this.instance).getExtraInfoTwoIcon();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public boolean getIsSupportClickCard() {
            return ((IotcardBean) this.instance).getIsSupportClickCard();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getMCustomIcon() {
            return ((IotcardBean) this.instance).getMCustomIcon();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getPackageName() {
            return ((IotcardBean) this.instance).getPackageName();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getPackageNameBytes() {
            return ((IotcardBean) this.instance).getPackageNameBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getPid() {
            return ((IotcardBean) this.instance).getPid();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getPidBytes() {
            return ((IotcardBean) this.instance).getPidBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getSubTitle() {
            return ((IotcardBean) this.instance).getSubTitle();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getSubTitleBytes() {
            return ((IotcardBean) this.instance).getSubTitleBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public int getSwitchActionType() {
            return ((IotcardBean) this.instance).getSwitchActionType();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getTargetClassName() {
            return ((IotcardBean) this.instance).getTargetClassName();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getTargetClassNameBytes() {
            return ((IotcardBean) this.instance).getTargetClassNameBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getTargetPackageName() {
            return ((IotcardBean) this.instance).getTargetPackageName();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getTargetPackageNameBytes() {
            return ((IotcardBean) this.instance).getTargetPackageNameBytes();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public String getTitle() {
            return ((IotcardBean) this.instance).getTitle();
        }

        @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
        public ByteString getTitleBytes() {
            return ((IotcardBean) this.instance).getTitleBytes();
        }

        public Builder setCardDisplayType(int i8) {
            copyOnWrite();
            ((IotcardBean) this.instance).setCardDisplayType(i8);
            return this;
        }

        public Builder setCardType(int i8) {
            copyOnWrite();
            ((IotcardBean) this.instance).setCardType(i8);
            return this;
        }

        public Builder setClickCardBundle(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setClickCardBundle(str);
            return this;
        }

        public Builder setClickCardBundleBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setClickCardBundleBytes(byteString);
            return this;
        }

        public Builder setControlId(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setControlId(str);
            return this;
        }

        public Builder setControlIdBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setControlIdBytes(byteString);
            return this;
        }

        public Builder setDeviceConnectedDesc(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceConnectedDesc(str);
            return this;
        }

        public Builder setDeviceConnectedDescBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceConnectedDescBytes(byteString);
            return this;
        }

        public Builder setDeviceConnectedStatus(boolean z2) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceConnectedStatus(z2);
            return this;
        }

        public Builder setDeviceLastConnectedTime(long j8) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceLastConnectedTime(j8);
            return this;
        }

        public Builder setDeviceShowLevel(int i8) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceShowLevel(i8);
            return this;
        }

        public Builder setDeviceSingleId(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceSingleId(str);
            return this;
        }

        public Builder setDeviceSingleIdBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceSingleIdBytes(byteString);
            return this;
        }

        public Builder setDeviceSwitch(boolean z2) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceSwitch(z2);
            return this;
        }

        public Builder setDeviceTypeId(int i8) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDeviceTypeId(i8);
            return this;
        }

        public Builder setDisplayCustomIcon(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDisplayCustomIcon(byteString);
            return this;
        }

        public Builder setDisplayMessage(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDisplayMessage(str);
            return this;
        }

        public Builder setDisplayMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setDisplayMessageBytes(byteString);
            return this;
        }

        public Builder setExtraInfoOneDesc(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setExtraInfoOneDesc(str);
            return this;
        }

        public Builder setExtraInfoOneDescBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setExtraInfoOneDescBytes(byteString);
            return this;
        }

        public Builder setExtraInfoOneIcon(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setExtraInfoOneIcon(byteString);
            return this;
        }

        public Builder setExtraInfoTwoDesc(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setExtraInfoTwoDesc(str);
            return this;
        }

        public Builder setExtraInfoTwoDescBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setExtraInfoTwoDescBytes(byteString);
            return this;
        }

        public Builder setExtraInfoTwoIcon(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setExtraInfoTwoIcon(byteString);
            return this;
        }

        public Builder setIsSupportClickCard(boolean z2) {
            copyOnWrite();
            ((IotcardBean) this.instance).setIsSupportClickCard(z2);
            return this;
        }

        public Builder setMCustomIcon(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setMCustomIcon(byteString);
            return this;
        }

        public Builder setPackageName(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setPackageName(str);
            return this;
        }

        public Builder setPackageNameBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setPackageNameBytes(byteString);
            return this;
        }

        public Builder setPid(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setPid(str);
            return this;
        }

        public Builder setPidBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setPidBytes(byteString);
            return this;
        }

        public Builder setSubTitle(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setSubTitle(str);
            return this;
        }

        public Builder setSubTitleBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setSubTitleBytes(byteString);
            return this;
        }

        public Builder setSwitchActionType(int i8) {
            copyOnWrite();
            ((IotcardBean) this.instance).setSwitchActionType(i8);
            return this;
        }

        public Builder setTargetClassName(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setTargetClassName(str);
            return this;
        }

        public Builder setTargetClassNameBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setTargetClassNameBytes(byteString);
            return this;
        }

        public Builder setTargetPackageName(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setTargetPackageName(str);
            return this;
        }

        public Builder setTargetPackageNameBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setTargetPackageNameBytes(byteString);
            return this;
        }

        public Builder setTitle(String str) {
            copyOnWrite();
            ((IotcardBean) this.instance).setTitle(str);
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            copyOnWrite();
            ((IotcardBean) this.instance).setTitleBytes(byteString);
            return this;
        }

        private Builder() {
            super(IotcardBean.DEFAULT_INSTANCE);
        }
    }

    static {
        IotcardBean iotcardBean = new IotcardBean();
        DEFAULT_INSTANCE = iotcardBean;
        GeneratedMessageLite.registerDefaultInstance(IotcardBean.class, iotcardBean);
    }

    private IotcardBean() {
        ByteString byteString = ByteString.EMPTY;
        this.mCustomIcon_ = byteString;
        this.subTitle_ = "";
        this.pid_ = "";
        this.deviceConnectedDesc_ = "";
        this.extraInfoOneIcon_ = byteString;
        this.extraInfoOneDesc_ = "";
        this.extraInfoTwoIcon_ = byteString;
        this.extraInfoTwoDesc_ = "";
        this.targetPackageName_ = "";
        this.targetClassName_ = "";
        this.clickCardBundle_ = "";
        this.deviceSingleId_ = "";
        this.displayMessage_ = "";
        this.displayCustomIcon_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCardDisplayType() {
        this.cardDisplayType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCardType() {
        this.cardType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClickCardBundle() {
        this.clickCardBundle_ = getDefaultInstance().getClickCardBundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearControlId() {
        this.controlId_ = getDefaultInstance().getControlId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceConnectedDesc() {
        this.deviceConnectedDesc_ = getDefaultInstance().getDeviceConnectedDesc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceConnectedStatus() {
        this.deviceConnectedStatus_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceLastConnectedTime() {
        this.deviceLastConnectedTime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceShowLevel() {
        this.deviceShowLevel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceSingleId() {
        this.deviceSingleId_ = getDefaultInstance().getDeviceSingleId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceSwitch() {
        this.deviceSwitch_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceTypeId() {
        this.deviceTypeId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayCustomIcon() {
        this.displayCustomIcon_ = getDefaultInstance().getDisplayCustomIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayMessage() {
        this.displayMessage_ = getDefaultInstance().getDisplayMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtraInfoOneDesc() {
        this.extraInfoOneDesc_ = getDefaultInstance().getExtraInfoOneDesc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtraInfoOneIcon() {
        this.extraInfoOneIcon_ = getDefaultInstance().getExtraInfoOneIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtraInfoTwoDesc() {
        this.extraInfoTwoDesc_ = getDefaultInstance().getExtraInfoTwoDesc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtraInfoTwoIcon() {
        this.extraInfoTwoIcon_ = getDefaultInstance().getExtraInfoTwoIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsSupportClickCard() {
        this.isSupportClickCard_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMCustomIcon() {
        this.mCustomIcon_ = getDefaultInstance().getMCustomIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPackageName() {
        this.packageName_ = getDefaultInstance().getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPid() {
        this.pid_ = getDefaultInstance().getPid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubTitle() {
        this.subTitle_ = getDefaultInstance().getSubTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSwitchActionType() {
        this.switchActionType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetClassName() {
        this.targetClassName_ = getDefaultInstance().getTargetClassName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetPackageName() {
        this.targetPackageName_ = getDefaultInstance().getTargetPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static IotcardBean getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static IotcardBean parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (IotcardBean) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IotcardBean parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<IotcardBean> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardDisplayType(int i8) {
        this.cardDisplayType_ = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardType(int i8) {
        this.cardType_ = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickCardBundle(String str) {
        str.getClass();
        this.clickCardBundle_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickCardBundleBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.clickCardBundle_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControlId(String str) {
        str.getClass();
        this.controlId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControlIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.controlId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceConnectedDesc(String str) {
        str.getClass();
        this.deviceConnectedDesc_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceConnectedDescBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.deviceConnectedDesc_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceConnectedStatus(boolean z2) {
        this.deviceConnectedStatus_ = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceLastConnectedTime(long j8) {
        this.deviceLastConnectedTime_ = j8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceShowLevel(int i8) {
        this.deviceShowLevel_ = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceSingleId(String str) {
        str.getClass();
        this.deviceSingleId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceSingleIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.deviceSingleId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceSwitch(boolean z2) {
        this.deviceSwitch_ = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceTypeId(int i8) {
        this.deviceTypeId_ = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayCustomIcon(ByteString byteString) {
        byteString.getClass();
        this.displayCustomIcon_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayMessage(String str) {
        str.getClass();
        this.displayMessage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayMessageBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.displayMessage_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraInfoOneDesc(String str) {
        str.getClass();
        this.extraInfoOneDesc_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraInfoOneDescBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.extraInfoOneDesc_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraInfoOneIcon(ByteString byteString) {
        byteString.getClass();
        this.extraInfoOneIcon_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraInfoTwoDesc(String str) {
        str.getClass();
        this.extraInfoTwoDesc_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraInfoTwoDescBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.extraInfoTwoDesc_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraInfoTwoIcon(ByteString byteString) {
        byteString.getClass();
        this.extraInfoTwoIcon_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsSupportClickCard(boolean z2) {
        this.isSupportClickCard_ = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMCustomIcon(ByteString byteString) {
        byteString.getClass();
        this.mCustomIcon_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageName(String str) {
        str.getClass();
        this.packageName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.packageName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPid(String str) {
        str.getClass();
        this.pid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPidBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.pid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubTitle(String str) {
        str.getClass();
        this.subTitle_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubTitleBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.subTitle_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwitchActionType(int i8) {
        this.switchActionType_ = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetClassName(String str) {
        str.getClass();
        this.targetClassName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetClassNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.targetClassName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetPackageName(String str) {
        str.getClass();
        this.targetPackageName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetPackageNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.targetPackageName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.title_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new IotcardBean();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u001a\u0000\u0000\u0001\u001a\u001a\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\n\u0005Ȉ\u0006\u0004\u0007Ȉ\b\u0007\tȈ\n\n\u000bȈ\f\n\rȈ\u000e\u0002\u000fȈ\u0010Ȉ\u0011\u0007\u0012Ȉ\u0013Ȉ\u0014\u0004\u0015\u0004\u0016\u0007\u0017\u0004\u0018\u0004\u0019Ȉ\u001a\n", new Object[]{"controlId_", "packageName_", "title_", "mCustomIcon_", "subTitle_", "deviceTypeId_", "pid_", "deviceConnectedStatus_", "deviceConnectedDesc_", "extraInfoOneIcon_", "extraInfoOneDesc_", "extraInfoTwoIcon_", "extraInfoTwoDesc_", "deviceLastConnectedTime_", "targetPackageName_", "targetClassName_", "isSupportClickCard_", "clickCardBundle_", "deviceSingleId_", "deviceShowLevel_", "cardType_", "deviceSwitch_", "switchActionType_", "cardDisplayType_", "displayMessage_", "displayCustomIcon_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<IotcardBean> defaultInstanceBasedParser = PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (IotcardBean.class) {
                        try {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public int getCardDisplayType() {
        return this.cardDisplayType_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public int getCardType() {
        return this.cardType_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getClickCardBundle() {
        return this.clickCardBundle_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getClickCardBundleBytes() {
        return ByteString.copyFromUtf8(this.clickCardBundle_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getControlId() {
        return this.controlId_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getControlIdBytes() {
        return ByteString.copyFromUtf8(this.controlId_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getDeviceConnectedDesc() {
        return this.deviceConnectedDesc_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getDeviceConnectedDescBytes() {
        return ByteString.copyFromUtf8(this.deviceConnectedDesc_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public boolean getDeviceConnectedStatus() {
        return this.deviceConnectedStatus_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public long getDeviceLastConnectedTime() {
        return this.deviceLastConnectedTime_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public int getDeviceShowLevel() {
        return this.deviceShowLevel_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getDeviceSingleId() {
        return this.deviceSingleId_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getDeviceSingleIdBytes() {
        return ByteString.copyFromUtf8(this.deviceSingleId_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public boolean getDeviceSwitch() {
        return this.deviceSwitch_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public int getDeviceTypeId() {
        return this.deviceTypeId_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getDisplayCustomIcon() {
        return this.displayCustomIcon_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getDisplayMessage() {
        return this.displayMessage_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getDisplayMessageBytes() {
        return ByteString.copyFromUtf8(this.displayMessage_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getExtraInfoOneDesc() {
        return this.extraInfoOneDesc_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getExtraInfoOneDescBytes() {
        return ByteString.copyFromUtf8(this.extraInfoOneDesc_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getExtraInfoOneIcon() {
        return this.extraInfoOneIcon_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getExtraInfoTwoDesc() {
        return this.extraInfoTwoDesc_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getExtraInfoTwoDescBytes() {
        return ByteString.copyFromUtf8(this.extraInfoTwoDesc_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getExtraInfoTwoIcon() {
        return this.extraInfoTwoIcon_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public boolean getIsSupportClickCard() {
        return this.isSupportClickCard_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getMCustomIcon() {
        return this.mCustomIcon_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getPackageName() {
        return this.packageName_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getPackageNameBytes() {
        return ByteString.copyFromUtf8(this.packageName_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getPid() {
        return this.pid_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getPidBytes() {
        return ByteString.copyFromUtf8(this.pid_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getSubTitle() {
        return this.subTitle_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getSubTitleBytes() {
        return ByteString.copyFromUtf8(this.subTitle_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public int getSwitchActionType() {
        return this.switchActionType_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getTargetClassName() {
        return this.targetClassName_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getTargetClassNameBytes() {
        return ByteString.copyFromUtf8(this.targetClassName_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getTargetPackageName() {
        return this.targetPackageName_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getTargetPackageNameBytes() {
        return ByteString.copyFromUtf8(this.targetPackageName_);
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public String getTitle() {
        return this.title_;
    }

    @Override // com.transsion.iotservice.iotcard.proto.IotcardBeanOrBuilder
    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    public static Builder newBuilder(IotcardBean iotcardBean) {
        return DEFAULT_INSTANCE.createBuilder(iotcardBean);
    }

    public static IotcardBean parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardBean) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static IotcardBean parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static IotcardBean parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static IotcardBean parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static IotcardBean parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IotcardBean parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static IotcardBean parseFrom(InputStream inputStream) throws IOException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IotcardBean parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static IotcardBean parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static IotcardBean parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (IotcardBean) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
