package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface SwitchClickActionOrBuilder extends MessageLiteOrBuilder {
    String getControlId();

    ByteString getControlIdBytes();

    boolean getDeviceSwitch();

    String getPackageName();

    ByteString getPackageNameBytes();

    String getPid();

    ByteString getPidBytes();
}
