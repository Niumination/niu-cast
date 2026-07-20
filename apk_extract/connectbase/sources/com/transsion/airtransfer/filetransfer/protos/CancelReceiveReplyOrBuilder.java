package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface CancelReceiveReplyOrBuilder extends MessageLiteOrBuilder {
    long getFileId();

    long getSentLength();

    long getTaskId();
}
