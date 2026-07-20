package com.google.protobuf;

import c1.c;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class ArrayDecoders {

    /* JADX INFO: renamed from: com.google.protobuf.ArrayDecoders$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    private ArrayDecoders() {
    }

    public static int decodeBoolList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        int iDecodeVarint64 = decodeVarint64(data, position, registers);
        booleanArrayList.addBoolean(registers.long1 != 0);
        while (iDecodeVarint64 < limit) {
            int iDecodeVarint32 = decodeVarint32(data, iDecodeVarint64, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(data, iDecodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        return iDecodeVarint64;
    }

    public static int decodeBytes(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 > data.length - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i10 == 0) {
            registers.object1 = ByteString.EMPTY;
            return iDecodeVarint32;
        }
        registers.object1 = ByteString.copyFrom(data, iDecodeVarint32, i10);
        return iDecodeVarint32 + i10;
    }

    public static int decodeBytesList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 > data.length - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i10 == 0) {
            list.add(ByteString.EMPTY);
        } else {
            list.add(ByteString.copyFrom(data, iDecodeVarint32, i10));
            iDecodeVarint32 += i10;
        }
        while (iDecodeVarint32 < limit) {
            int iDecodeVarint33 = decodeVarint32(data, iDecodeVarint32, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(data, iDecodeVarint33, registers);
            int i11 = registers.int1;
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i11 > data.length - iDecodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i11 == 0) {
                list.add(ByteString.EMPTY);
            } else {
                list.add(ByteString.copyFrom(data, iDecodeVarint32, i11));
                iDecodeVarint32 += i11;
            }
        }
        return iDecodeVarint32;
    }

    public static double decodeDouble(byte[] data, int position) {
        return Double.longBitsToDouble(decodeFixed64(data, position));
    }

    public static int decodeDoubleList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        doubleArrayList.addDouble(decodeDouble(data, position));
        int i10 = position + 8;
        while (i10 < limit) {
            int iDecodeVarint32 = decodeVarint32(data, i10, registers);
            if (tag != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(decodeDouble(data, iDecodeVarint32));
            i10 = iDecodeVarint32 + 8;
        }
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int decodeExtension(int tag, byte[] data, int position, int limit, GeneratedMessageLite.ExtendableMessage<?, ?> message, GeneratedMessageLite.GeneratedExtension<?, ?> extension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = message.extensions;
        int i10 = tag >>> 3;
        if (extension.descriptor.isRepeated() && extension.descriptor.isPacked()) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extension.getLiteType().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    int iDecodePackedDoubleList = decodePackedDoubleList(data, position, doubleArrayList, registers);
                    fieldSet.setField(extension.descriptor, doubleArrayList);
                    return iDecodePackedDoubleList;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    int iDecodePackedFloatList = decodePackedFloatList(data, position, floatArrayList, registers);
                    fieldSet.setField(extension.descriptor, floatArrayList);
                    return iDecodePackedFloatList;
                case 3:
                case 4:
                    LongArrayList longArrayList = new LongArrayList();
                    int iDecodePackedVarint64List = decodePackedVarint64List(data, position, longArrayList, registers);
                    fieldSet.setField(extension.descriptor, longArrayList);
                    return iDecodePackedVarint64List;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    int iDecodePackedVarint32List = decodePackedVarint32List(data, position, intArrayList, registers);
                    fieldSet.setField(extension.descriptor, intArrayList);
                    return iDecodePackedVarint32List;
                case 7:
                case 8:
                    LongArrayList longArrayList2 = new LongArrayList();
                    int iDecodePackedFixed64List = decodePackedFixed64List(data, position, longArrayList2, registers);
                    fieldSet.setField(extension.descriptor, longArrayList2);
                    return iDecodePackedFixed64List;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    int iDecodePackedFixed32List = decodePackedFixed32List(data, position, intArrayList2, registers);
                    fieldSet.setField(extension.descriptor, intArrayList2);
                    return iDecodePackedFixed32List;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    int iDecodePackedBoolList = decodePackedBoolList(data, position, booleanArrayList, registers);
                    fieldSet.setField(extension.descriptor, booleanArrayList);
                    return iDecodePackedBoolList;
                case 12:
                    IntArrayList intArrayList3 = new IntArrayList();
                    int iDecodePackedSInt32List = decodePackedSInt32List(data, position, intArrayList3, registers);
                    fieldSet.setField(extension.descriptor, intArrayList3);
                    return iDecodePackedSInt32List;
                case 13:
                    LongArrayList longArrayList3 = new LongArrayList();
                    int iDecodePackedSInt64List = decodePackedSInt64List(data, position, longArrayList3, registers);
                    fieldSet.setField(extension.descriptor, longArrayList3);
                    return iDecodePackedSInt64List;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    int iDecodePackedVarint32List2 = decodePackedVarint32List(data, position, intArrayList4, registers);
                    SchemaUtil.filterUnknownEnumList((Object) message, i10, (List<Integer>) intArrayList4, extension.descriptor.getEnumType(), (Object) null, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                    fieldSet.setField(extension.descriptor, intArrayList4);
                    return iDecodePackedVarint32List2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + extension.descriptor.getLiteType());
            }
        }
        Object objValueOf = null;
        if (extension.getLiteType() == WireFormat.FieldType.ENUM) {
            position = decodeVarint32(data, position, registers);
            if (extension.descriptor.getEnumType().findValueByNumber(registers.int1) == null) {
                SchemaUtil.storeUnknownEnum(message, i10, registers.int1, null, unknownFieldSchema);
                return position;
            }
            objValueOf = Integer.valueOf(registers.int1);
        } else {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extension.getLiteType().ordinal()]) {
                case 1:
                    objValueOf = Double.valueOf(decodeDouble(data, position));
                    position += 8;
                    break;
                case 2:
                    objValueOf = Float.valueOf(decodeFloat(data, position));
                    position += 4;
                    break;
                case 3:
                case 4:
                    position = decodeVarint64(data, position, registers);
                    objValueOf = Long.valueOf(registers.long1);
                    break;
                case 5:
                case 6:
                    position = decodeVarint32(data, position, registers);
                    objValueOf = Integer.valueOf(registers.int1);
                    break;
                case 7:
                case 8:
                    objValueOf = Long.valueOf(decodeFixed64(data, position));
                    position += 8;
                    break;
                case 9:
                case 10:
                    objValueOf = Integer.valueOf(decodeFixed32(data, position));
                    position += 4;
                    break;
                case 11:
                    position = decodeVarint64(data, position, registers);
                    objValueOf = Boolean.valueOf(registers.long1 != 0);
                    break;
                case 12:
                    position = decodeVarint32(data, position, registers);
                    objValueOf = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                    break;
                case 13:
                    position = decodeVarint64(data, position, registers);
                    objValueOf = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    position = decodeBytes(data, position, registers);
                    objValueOf = registers.object1;
                    break;
                case 16:
                    position = decodeString(data, position, registers);
                    objValueOf = registers.object1;
                    break;
                case 17:
                    int i11 = (i10 << 3) | 4;
                    Schema schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) extension.getMessageDefaultInstance().getClass());
                    if (extension.isRepeated()) {
                        int iDecodeGroupField = decodeGroupField(schemaSchemaFor, data, position, limit, i11, registers);
                        fieldSet.addRepeatedField(extension.descriptor, registers.object1);
                        return iDecodeGroupField;
                    }
                    Object field = fieldSet.getField(extension.descriptor);
                    if (field == null) {
                        field = schemaSchemaFor.newInstance();
                        fieldSet.setField(extension.descriptor, field);
                    }
                    return mergeGroupField(field, schemaSchemaFor, data, position, limit, i11, registers);
                case 18:
                    Schema schemaSchemaFor2 = Protobuf.getInstance().schemaFor((Class) extension.getMessageDefaultInstance().getClass());
                    if (extension.isRepeated()) {
                        int iDecodeMessageField = decodeMessageField(schemaSchemaFor2, data, position, limit, registers);
                        fieldSet.addRepeatedField(extension.descriptor, registers.object1);
                        return iDecodeMessageField;
                    }
                    Object field2 = fieldSet.getField(extension.descriptor);
                    if (field2 == null) {
                        field2 = schemaSchemaFor2.newInstance();
                        fieldSet.setField(extension.descriptor, field2);
                    }
                    return mergeMessageField(field2, schemaSchemaFor2, data, position, limit, registers);
            }
        }
        if (extension.isRepeated()) {
            fieldSet.addRepeatedField(extension.descriptor, objValueOf);
        } else {
            fieldSet.setField(extension.descriptor, objValueOf);
        }
        return position;
    }

    public static int decodeExtensionOrUnknownField(int tag, byte[] data, int position, int limit, Object message, MessageLite defaultInstance, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtensionFindLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(defaultInstance, tag >>> 3);
        if (generatedExtensionFindLiteExtensionByNumber == null) {
            return decodeUnknownField(tag, data, position, limit, MessageSchema.getMutableUnknownFields(message), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) message;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(tag, data, position, limit, extendableMessage, generatedExtensionFindLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    public static int decodeFixed32(byte[] data, int position) {
        return ((data[position + 3] & 255) << 24) | (data[position] & 255) | ((data[position + 1] & 255) << 8) | ((data[position + 2] & 255) << 16);
    }

    public static int decodeFixed32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) list;
        intArrayList.addInt(decodeFixed32(data, position));
        int i10 = position + 4;
        while (i10 < limit) {
            int iDecodeVarint32 = decodeVarint32(data, i10, registers);
            if (tag != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(data, iDecodeVarint32));
            i10 = iDecodeVarint32 + 4;
        }
        return i10;
    }

    public static long decodeFixed64(byte[] data, int position) {
        return ((((long) data[position + 7]) & 255) << 56) | (((long) data[position]) & 255) | ((((long) data[position + 1]) & 255) << 8) | ((((long) data[position + 2]) & 255) << 16) | ((((long) data[position + 3]) & 255) << 24) | ((((long) data[position + 4]) & 255) << 32) | ((((long) data[position + 5]) & 255) << 40) | ((((long) data[position + 6]) & 255) << 48);
    }

    public static int decodeFixed64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) list;
        longArrayList.addLong(decodeFixed64(data, position));
        int i10 = position + 8;
        while (i10 < limit) {
            int iDecodeVarint32 = decodeVarint32(data, i10, registers);
            if (tag != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(data, iDecodeVarint32));
            i10 = iDecodeVarint32 + 8;
        }
        return i10;
    }

    public static float decodeFloat(byte[] data, int position) {
        return Float.intBitsToFloat(decodeFixed32(data, position));
    }

    public static int decodeFloatList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) list;
        floatArrayList.addFloat(decodeFloat(data, position));
        int i10 = position + 4;
        while (i10 < limit) {
            int iDecodeVarint32 = decodeVarint32(data, i10, registers);
            if (tag != registers.int1) {
                break;
            }
            floatArrayList.addFloat(decodeFloat(data, iDecodeVarint32));
            i10 = iDecodeVarint32 + 4;
        }
        return i10;
    }

    public static int decodeGroupField(Schema schema, byte[] data, int position, int limit, int endGroup, Registers registers) throws IOException {
        Object objNewInstance = schema.newInstance();
        int iMergeGroupField = mergeGroupField(objNewInstance, schema, data, position, limit, endGroup, registers);
        schema.makeImmutable(objNewInstance);
        registers.object1 = objNewInstance;
        return iMergeGroupField;
    }

    public static int decodeGroupList(Schema schema, int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        int i10 = (tag & (-8)) | 4;
        int iDecodeGroupField = decodeGroupField(schema, data, position, limit, i10, registers);
        list.add(registers.object1);
        while (iDecodeGroupField < limit) {
            int iDecodeVarint32 = decodeVarint32(data, iDecodeGroupField, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeGroupField = decodeGroupField(schema, data, iDecodeVarint32, limit, i10, registers);
            list.add(registers.object1);
        }
        return iDecodeGroupField;
    }

    public static int decodeMessageField(Schema schema, byte[] data, int position, int limit, Registers registers) throws IOException {
        Object objNewInstance = schema.newInstance();
        int iMergeMessageField = mergeMessageField(objNewInstance, schema, data, position, limit, registers);
        schema.makeImmutable(objNewInstance);
        registers.object1 = objNewInstance;
        return iMergeMessageField;
    }

    public static int decodeMessageList(Schema<?> schema, int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        int iDecodeMessageField = decodeMessageField(schema, data, position, limit, registers);
        list.add(registers.object1);
        while (iDecodeMessageField < limit) {
            int iDecodeVarint32 = decodeVarint32(data, iDecodeMessageField, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeMessageField = decodeMessageField(schema, data, iDecodeVarint32, limit, registers);
            list.add(registers.object1);
        }
        return iDecodeMessageField;
    }

    public static int decodePackedBoolList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            iDecodeVarint32 = decodeVarint64(data, iDecodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            doubleArrayList.addDouble(decodeDouble(data, iDecodeVarint32));
            iDecodeVarint32 += 8;
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            intArrayList.addInt(decodeFixed32(data, iDecodeVarint32));
            iDecodeVarint32 += 4;
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            longArrayList.addLong(decodeFixed64(data, iDecodeVarint32));
            iDecodeVarint32 += 8;
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            floatArrayList.addFloat(decodeFloat(data, iDecodeVarint32));
            iDecodeVarint32 += 4;
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            iDecodeVarint32 = decodeVarint32(data, iDecodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            iDecodeVarint32 = decodeVarint64(data, iDecodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            iDecodeVarint32 = decodeVarint32(data, iDecodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] data, int position, Internal.ProtobufList<?> list, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i10) {
            iDecodeVarint32 = decodeVarint64(data, iDecodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (iDecodeVarint32 == i10) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (iDecodeVarint32 < limit) {
            int iDecodeVarint33 = decodeVarint32(data, iDecodeVarint32, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(data, iDecodeVarint33, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return iDecodeVarint32;
    }

    public static int decodeSInt64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) list;
        int iDecodeVarint64 = decodeVarint64(data, position, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (iDecodeVarint64 < limit) {
            int iDecodeVarint32 = decodeVarint32(data, iDecodeVarint64, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(data, iDecodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return iDecodeVarint64;
    }

    public static int decodeString(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 == 0) {
            registers.object1 = "";
            return iDecodeVarint32;
        }
        registers.object1 = new String(data, iDecodeVarint32, i10, Internal.UTF_8);
        return iDecodeVarint32 + i10;
    }

    public static int decodeStringList(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 == 0) {
            list.add("");
        } else {
            list.add(new String(data, iDecodeVarint32, i10, Internal.UTF_8));
            iDecodeVarint32 += i10;
        }
        while (iDecodeVarint32 < limit) {
            int iDecodeVarint33 = decodeVarint32(data, iDecodeVarint32, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(data, iDecodeVarint33, registers);
            int i11 = registers.int1;
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i11 == 0) {
                list.add("");
            } else {
                list.add(new String(data, iDecodeVarint32, i11, Internal.UTF_8));
                iDecodeVarint32 += i11;
            }
        }
        return iDecodeVarint32;
    }

    public static int decodeStringListRequireUtf8(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 == 0) {
            list.add("");
        } else {
            int i11 = iDecodeVarint32 + i10;
            if (!Utf8.isValidUtf8(data, iDecodeVarint32, i11)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            list.add(new String(data, iDecodeVarint32, i10, Internal.UTF_8));
            iDecodeVarint32 = i11;
        }
        while (iDecodeVarint32 < limit) {
            int iDecodeVarint33 = decodeVarint32(data, iDecodeVarint32, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(data, iDecodeVarint33, registers);
            int i12 = registers.int1;
            if (i12 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i12 == 0) {
                list.add("");
            } else {
                int i13 = iDecodeVarint32 + i12;
                if (!Utf8.isValidUtf8(data, iDecodeVarint32, i13)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                list.add(new String(data, iDecodeVarint32, i12, Internal.UTF_8));
                iDecodeVarint32 = i13;
            }
        }
        return iDecodeVarint32;
    }

    public static int decodeStringRequireUtf8(byte[] data, int position, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        int i10 = registers.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 == 0) {
            registers.object1 = "";
            return iDecodeVarint32;
        }
        registers.object1 = Utf8.decodeUtf8(data, iDecodeVarint32, i10);
        return iDecodeVarint32 + i10;
    }

    public static int decodeUnknownField(int tag, byte[] data, int position, int limit, UnknownFieldSetLite unknownFields, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(tag) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            int iDecodeVarint64 = decodeVarint64(data, position, registers);
            unknownFields.storeField(tag, Long.valueOf(registers.long1));
            return iDecodeVarint64;
        }
        if (tagWireType == 1) {
            unknownFields.storeField(tag, Long.valueOf(decodeFixed64(data, position)));
            return position + 8;
        }
        if (tagWireType == 2) {
            int iDecodeVarint32 = decodeVarint32(data, position, registers);
            int i10 = registers.int1;
            if (i10 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i10 > data.length - iDecodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i10 == 0) {
                unknownFields.storeField(tag, ByteString.EMPTY);
            } else {
                unknownFields.storeField(tag, ByteString.copyFrom(data, iDecodeVarint32, i10));
            }
            return iDecodeVarint32 + i10;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            unknownFields.storeField(tag, Integer.valueOf(decodeFixed32(data, position)));
            return position + 4;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        int i11 = (tag & (-8)) | 4;
        int i12 = 0;
        while (position < limit) {
            int iDecodeVarint33 = decodeVarint32(data, position, registers);
            int i13 = registers.int1;
            if (i13 == i11) {
                i12 = i13;
                position = iDecodeVarint33;
                break;
            }
            i12 = i13;
            position = decodeUnknownField(i13, data, iDecodeVarint33, limit, unknownFieldSetLiteNewInstance, registers);
        }
        if (position > limit || i12 != i11) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        unknownFields.storeField(tag, unknownFieldSetLiteNewInstance);
        return position;
    }

    public static int decodeVarint32(byte[] data, int position, Registers registers) {
        int i10 = position + 1;
        byte b10 = data[position];
        if (b10 < 0) {
            return decodeVarint32(b10, data, i10, registers);
        }
        registers.int1 = b10;
        return i10;
    }

    public static int decodeVarint32List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) list;
        int iDecodeVarint32 = decodeVarint32(data, position, registers);
        intArrayList.addInt(registers.int1);
        while (iDecodeVarint32 < limit) {
            int iDecodeVarint33 = decodeVarint32(data, iDecodeVarint32, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(data, iDecodeVarint33, registers);
            intArrayList.addInt(registers.int1);
        }
        return iDecodeVarint32;
    }

    public static int decodeVarint64(byte[] data, int position, Registers registers) {
        int i10 = position + 1;
        long j10 = data[position];
        if (j10 < 0) {
            return decodeVarint64(j10, data, i10, registers);
        }
        registers.long1 = j10;
        return i10;
    }

    public static int decodeVarint64List(int tag, byte[] data, int position, int limit, Internal.ProtobufList<?> list, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) list;
        int iDecodeVarint64 = decodeVarint64(data, position, registers);
        longArrayList.addLong(registers.long1);
        while (iDecodeVarint64 < limit) {
            int iDecodeVarint32 = decodeVarint32(data, iDecodeVarint64, registers);
            if (tag != registers.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(data, iDecodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        return iDecodeVarint64;
    }

    public static int mergeGroupField(Object msg, Schema schema, byte[] data, int position, int limit, int endGroup, Registers registers) throws IOException {
        int message = ((MessageSchema) schema).parseMessage(msg, data, position, limit, endGroup, registers);
        registers.object1 = msg;
        return message;
    }

    public static int mergeMessageField(Object msg, Schema schema, byte[] data, int position, int limit, Registers registers) throws IOException {
        int iDecodeVarint32 = position + 1;
        int i10 = data[position];
        if (i10 < 0) {
            iDecodeVarint32 = decodeVarint32(i10, data, iDecodeVarint32, registers);
            i10 = registers.int1;
        }
        int i11 = iDecodeVarint32;
        if (i10 < 0 || i10 > limit - i11) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i12 = i10 + i11;
        schema.mergeFrom(msg, data, i11, i12, registers);
        registers.object1 = msg;
        return i12;
    }

    public static int skipField(int tag, byte[] data, int position, int limit, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(tag) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            return decodeVarint64(data, position, registers);
        }
        if (tagWireType == 1) {
            return position + 8;
        }
        if (tagWireType == 2) {
            return decodeVarint32(data, position, registers) + registers.int1;
        }
        if (tagWireType != 3) {
            if (tagWireType == 5) {
                return position + 4;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        int i10 = (tag & (-8)) | 4;
        int i11 = 0;
        while (position < limit) {
            position = decodeVarint32(data, position, registers);
            i11 = registers.int1;
            if (i11 == i10) {
                break;
            }
            position = skipField(i11, data, position, limit, registers);
        }
        if (position > limit || i11 != i10) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return position;
    }

    public static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        public Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        public Registers(ExtensionRegistryLite extensionRegistry) {
            extensionRegistry.getClass();
            this.extensionRegistry = extensionRegistry;
        }
    }

    public static int decodeVarint32(int firstByte, byte[] data, int position, Registers registers) {
        int i10 = firstByte & 127;
        int i11 = position + 1;
        byte b10 = data[position];
        if (b10 >= 0) {
            registers.int1 = i10 | (b10 << 7);
            return i11;
        }
        int i12 = i10 | ((b10 & 127) << 7);
        int i13 = position + 2;
        byte b11 = data[i11];
        if (b11 >= 0) {
            registers.int1 = i12 | (b11 << c.f1122p);
            return i13;
        }
        int i14 = i12 | ((b11 & 127) << 14);
        int i15 = position + 3;
        byte b12 = data[i13];
        if (b12 >= 0) {
            registers.int1 = i14 | (b12 << c.f1131y);
            return i15;
        }
        int i16 = i14 | ((b12 & 127) << 21);
        int i17 = position + 4;
        byte b13 = data[i15];
        if (b13 >= 0) {
            registers.int1 = i16 | (b13 << c.F);
            return i17;
        }
        int i18 = i16 | ((b13 & 127) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (data[i17] >= 0) {
                registers.int1 = i18;
                return i19;
            }
            i17 = i19;
        }
    }

    public static int decodeVarint64(long firstByte, byte[] data, int position, Registers registers) {
        int i10 = position + 1;
        byte b10 = data[position];
        long j10 = (firstByte & 127) | (((long) (b10 & 127)) << 7);
        int i11 = 7;
        while (b10 < 0) {
            int i12 = i10 + 1;
            byte b11 = data[i10];
            i11 += 7;
            j10 |= ((long) (b11 & 127)) << i11;
            i10 = i12;
            b10 = b11;
        }
        registers.long1 = j10;
        return i10;
    }
}
