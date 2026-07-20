package com.transsion.airtransfer.filetransfer.protos;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface SendFileInfoRequestOrBuilder extends MessageLiteOrBuilder {
    String getExtend();

    ByteString getExtendBytes();

    SendFileInfoRequest.FileInfo getFiles(int i10);

    int getFilesCount();

    List<SendFileInfoRequest.FileInfo> getFilesList();

    long getTaskId();
}
