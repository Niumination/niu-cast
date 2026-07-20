package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface FieldMaskOrBuilder extends MessageOrBuilder {
    String getPaths(int i8);

    ByteString getPathsBytes(int i8);

    int getPathsCount();

    List<String> getPathsList();
}
