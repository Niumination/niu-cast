package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    public abstract void addFixed32(B fields, int number, int value);

    public abstract void addFixed64(B fields, int number, long value);

    public abstract void addGroup(B fields, int number, T subFieldSet);

    public abstract void addLengthDelimited(B fields, int number, ByteString value);

    public abstract void addVarint(B fields, int number, long value);

    public abstract B getBuilderFromMessage(Object message);

    public abstract T getFromMessage(Object message);

    public abstract int getSerializedSize(T unknowns);

    public abstract int getSerializedSizeAsMessageSet(T message);

    public abstract void makeImmutable(Object message);

    public abstract T merge(T destination, T source);

    public final void mergeFrom(B unknownFields, Reader reader) throws IOException {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(unknownFields, reader)) {
        }
    }

    public final boolean mergeOneFieldFrom(B unknownFields, Reader reader) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(unknownFields, tagFieldNumber, reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(unknownFields, tagFieldNumber, reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(unknownFields, tagFieldNumber, reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            addFixed32(unknownFields, tagFieldNumber, reader.readFixed32());
            return true;
        }
        B bNewBuilder = newBuilder();
        int iMakeTag = WireFormat.makeTag(tagFieldNumber, 4);
        mergeFrom(bNewBuilder, reader);
        if (iMakeTag != reader.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(unknownFields, tagFieldNumber, toImmutable(bNewBuilder));
        return true;
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object message, B builder);

    public abstract void setToMessage(Object message, T fields);

    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    public abstract T toImmutable(B fields);

    public abstract void writeAsMessageSetTo(T unknownFields, Writer writer) throws IOException;

    public abstract void writeTo(T unknownFields, Writer writer) throws IOException;
}
