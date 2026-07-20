package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    public abstract int extensionNumber(Map.Entry<?, ?> extension);

    public abstract Object findExtensionByNumber(ExtensionRegistryLite extensionRegistry, MessageLite defaultInstance, int number);

    public abstract FieldSet<T> getExtensions(Object message);

    public abstract FieldSet<T> getMutableExtensions(Object message);

    public abstract boolean hasExtensions(MessageLite prototype);

    public abstract void makeImmutable(Object message);

    public abstract <UT, UB> UB parseExtension(Object containerMessage, Reader reader, Object extension, ExtensionRegistryLite extensionRegistry, FieldSet<T> extensions, UB unknownFields, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException;

    public abstract void parseLengthPrefixedMessageSetItem(Reader reader, Object extension, ExtensionRegistryLite extensionRegistry, FieldSet<T> extensions) throws IOException;

    public abstract void parseMessageSetItem(ByteString data, Object extension, ExtensionRegistryLite extensionRegistry, FieldSet<T> extensions) throws IOException;

    public abstract void serializeExtension(Writer writer, Map.Entry<?, ?> extension) throws IOException;

    public abstract void setExtensions(Object message, FieldSet<T> extensions);
}
