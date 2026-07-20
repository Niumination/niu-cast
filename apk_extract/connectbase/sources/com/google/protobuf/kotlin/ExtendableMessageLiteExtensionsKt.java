package com.google.protobuf.kotlin;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessageLite;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class ExtendableMessageLiteExtensionsKt {
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, ?>, MorBT extends GeneratedMessageLite.ExtendableMessageOrBuilder<M, ?>> boolean contains(@l MorBT morbt, @l ExtensionLite<M, ?> extensionLite) {
        l0.p(morbt, "<this>");
        l0.p(extensionLite, "extension");
        return morbt.hasExtension(extensionLite);
    }

    @l
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, ?>, MOrBT extends GeneratedMessageLite.ExtendableMessageOrBuilder<M, ?>, T> T get(@l MOrBT morbt, @l ExtensionLite<M, T> extensionLite) {
        l0.p(morbt, "<this>");
        l0.p(extensionLite, "extension");
        T t10 = (T) morbt.getExtension(extensionLite);
        l0.o(t10, "getExtension(extension)");
        return t10;
    }

    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, B>, B extends GeneratedMessageLite.ExtendableBuilder<M, B>, T> void set(@l B b10, @l ExtensionLite<M, T> extensionLite, @l T t10) {
        l0.p(b10, "<this>");
        l0.p(extensionLite, "extension");
        l0.p(t10, "value");
        b10.setExtension(extensionLite, t10);
    }
}
