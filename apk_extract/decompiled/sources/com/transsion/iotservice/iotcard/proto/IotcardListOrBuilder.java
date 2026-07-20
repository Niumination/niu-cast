package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IotcardListOrBuilder extends MessageLiteOrBuilder {
    IotcardBean getIotcardBean(int i8);

    int getIotcardBeanCount();

    List<IotcardBean> getIotcardBeanList();
}
