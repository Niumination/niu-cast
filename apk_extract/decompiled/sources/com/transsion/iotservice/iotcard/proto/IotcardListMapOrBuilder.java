package com.transsion.iotservice.iotcard.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IotcardListMapOrBuilder extends MessageLiteOrBuilder {
    boolean containsDisplayTemplates(String str);

    @Deprecated
    Map<String, IotcardList> getDisplayTemplates();

    int getDisplayTemplatesCount();

    Map<String, IotcardList> getDisplayTemplatesMap();

    IotcardList getDisplayTemplatesOrDefault(String str, IotcardList iotcardList);

    IotcardList getDisplayTemplatesOrThrow(String str);
}
