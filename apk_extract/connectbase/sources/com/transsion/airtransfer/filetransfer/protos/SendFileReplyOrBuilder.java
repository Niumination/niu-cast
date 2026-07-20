package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface SendFileReplyOrBuilder extends MessageLiteOrBuilder {
    String getExtend();

    ByteString getExtendBytes();

    boolean getIsAccept();

    long getTaskId();
}
