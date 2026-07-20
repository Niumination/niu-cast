package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface IotcardBeanOrBuilder extends MessageLiteOrBuilder {
    int getCardDisplayType();

    int getCardType();

    String getClickCardBundle();

    ByteString getClickCardBundleBytes();

    String getControlId();

    ByteString getControlIdBytes();

    String getDeviceConnectedDesc();

    ByteString getDeviceConnectedDescBytes();

    boolean getDeviceConnectedStatus();

    long getDeviceLastConnectedTime();

    int getDeviceShowLevel();

    String getDeviceSingleId();

    ByteString getDeviceSingleIdBytes();

    boolean getDeviceSwitch();

    int getDeviceTypeId();

    ByteString getDisplayCustomIcon();

    String getDisplayMessage();

    ByteString getDisplayMessageBytes();

    String getExtraInfoOneDesc();

    ByteString getExtraInfoOneDescBytes();

    ByteString getExtraInfoOneIcon();

    String getExtraInfoTwoDesc();

    ByteString getExtraInfoTwoDescBytes();

    ByteString getExtraInfoTwoIcon();

    boolean getIsSupportClickCard();

    ByteString getMCustomIcon();

    String getPackageName();

    ByteString getPackageNameBytes();

    String getPid();

    ByteString getPidBytes();

    String getSubTitle();

    ByteString getSubTitleBytes();

    int getSwitchActionType();

    String getTargetClassName();

    ByteString getTargetClassNameBytes();

    String getTargetPackageName();

    ByteString getTargetPackageNameBytes();

    String getTitle();

    ByteString getTitleBytes();
}
