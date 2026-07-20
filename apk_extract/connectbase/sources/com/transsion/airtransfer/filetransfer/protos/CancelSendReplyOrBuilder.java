package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface CancelSendReplyOrBuilder extends MessageLiteOrBuilder {
    ReplyState getState();

    int getStateValue();

    long getTaskId();
}
