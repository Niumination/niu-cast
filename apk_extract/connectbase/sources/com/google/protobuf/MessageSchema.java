package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import c0.a;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* JADX INFO: renamed from: com.google.protobuf.MessageSchema$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] buffer, Object[] objects, int minFieldNumber, int maxFieldNumber, MessageLite defaultInstance, ProtoSyntax syntax, boolean useCachedSizeField, int[] intArray, int checkInitialized, int mapFieldPositions, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = buffer;
        this.objects = objects;
        this.minFieldNumber = minFieldNumber;
        this.maxFieldNumber = maxFieldNumber;
        this.lite = defaultInstance instanceof GeneratedMessageLite;
        this.syntax = syntax;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(defaultInstance);
        this.useCachedSizeField = useCachedSizeField;
        this.intArray = intArray;
        this.checkInitializedCount = checkInitialized;
        this.repeatedFieldOffsetStart = mapFieldPositions;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T message, T other, int pos) {
        return isFieldPresent(message, pos) == isFieldPresent(other, pos);
    }

    private static <T> boolean booleanAt(T message, long offset) {
        return UnsafeUtil.getBoolean(message, offset);
    }

    private static void checkMutable(Object message) {
        if (!isMutable(message)) {
            throw new IllegalArgumentException(a.a("Mutating immutable message: ", message));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] data, int position, int limit, MapEntryLite.Metadata<K, V> metadata, Map<K, V> target, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32;
        int iDecodeVarint33 = ArrayDecoders.decodeVarint32(data, position, registers);
        int i10 = registers.int1;
        if (i10 < 0 || i10 > limit - iDecodeVarint33) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i11 = iDecodeVarint33 + i10;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint33 < i11) {
            int i12 = iDecodeVarint33 + 1;
            int i13 = data[iDecodeVarint33];
            if (i13 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i13, data, i12, registers);
                i13 = registers.int1;
            } else {
                iDecodeVarint32 = i12;
            }
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i14 != 1) {
                if (i14 == 2 && i15 == metadata.valueType.getWireType()) {
                    iDecodeVarint33 = decodeMapEntryValue(data, iDecodeVarint32, limit, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint33 = ArrayDecoders.skipField(i13, data, iDecodeVarint32, limit, registers);
                }
            } else if (i15 == metadata.keyType.getWireType()) {
                iDecodeVarint33 = decodeMapEntryValue(data, iDecodeVarint32, limit, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint33 = ArrayDecoders.skipField(i13, data, iDecodeVarint32, limit, registers);
            }
        }
        if (iDecodeVarint33 != i11) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        target.put(obj, obj2);
        return i11;
    }

    private int decodeMapEntryValue(byte[] data, int position, int limit, WireFormat.FieldType fieldType, Class<?> messageType, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(data, position, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(data, position));
                return position + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(data, position));
                return position + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(data, position));
                return position + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(data, position));
                return position + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(data, position, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint65;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) messageType), data, position, limit, registers);
            case 15:
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(data, position, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint33;
            case 16:
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint66;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(data, position, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T message, long offset) {
        return UnsafeUtil.getDouble(message, offset);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i10, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i10);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i10)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i10)) == null) ? ub2 : (UB) filterUnknownEnumMap(i10, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub2, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i10, int i11, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub2, i11, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    private static <T> float floatAt(T message, long offset) {
        return UnsafeUtil.getFloat(message, offset);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int pos) {
        return (Internal.EnumVerifier) this.objects[((pos / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int pos) {
        return this.objects[(pos / 3) * 2];
    }

    private Schema getMessageFieldSchema(int pos) {
        int i10 = (pos / 3) * 2;
        Schema schema = (Schema) this.objects[i10];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i10 + 1]);
        this.objects[i10] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object message) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        return schema.getSerializedSize(schema.getFromMessage(message));
    }

    private static <T> int intAt(T message, long offset) {
        return UnsafeUtil.getInt(message, offset);
    }

    private static boolean isEnforceUtf8(int value) {
        return (value & 536870912) != 0;
    }

    private boolean isFieldPresent(T message, int pos, int presenceFieldOffset, int presenceField, int presenceMask) {
        if (presenceFieldOffset == 1048575) {
            return isFieldPresent(message, pos);
        }
        return (presenceField & presenceMask) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int value) {
        return (value & Integer.MIN_VALUE) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object message, int typeAndOffset, int pos) {
        List list = (List) UnsafeUtil.getObject(message, offset(typeAndOffset));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!messageFieldSchema.isInitialized(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean isMapInitialized(T t10, int i10, int i11) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t10, offset(i10)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i11)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            if (SchemaFor == 0) {
                SchemaFor = SchemaFor;
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            SchemaFor = SchemaFor;
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object message) {
        if (message == null) {
            return false;
        }
        if (message instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) message).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T message, T other, int pos) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos) & 1048575;
        return UnsafeUtil.getInt(message, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(other, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T message, int fieldNumber, int pos) {
        return UnsafeUtil.getInt(message, (long) (presenceMaskAndOffsetAt(pos) & 1048575)) == fieldNumber;
    }

    private static boolean isRequired(int value) {
        return (value & REQUIRED_MASK) != 0;
    }

    private static <T> long longAt(T message, long offset) {
        return UnsafeUtil.getLong(message, offset);
    }

    /* JADX WARN: Code duplicated, block: B:172:0x064f A[Catch: all -> 0x0675, TRY_LEAVE, TryCatch #6 {all -> 0x0675, blocks: (B:170:0x0649, B:172:0x064f, B:184:0x0679, B:185:0x067e), top: B:213:0x0649 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x065c A[LOOP:2: B:175:0x0658->B:177:0x065c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:179:0x0671  */
    /* JADX WARN: Code duplicated, block: B:183:0x0677 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:184:0x0679 A[Catch: all -> 0x0675, TRY_ENTER, TryCatch #6 {all -> 0x0675, blocks: (B:170:0x0649, B:172:0x064f, B:184:0x0679, B:185:0x067e), top: B:213:0x0649 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x068b A[LOOP:3: B:188:0x0687->B:190:0x068b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:192:0x06a0  */
    /* JADX WARN: Code duplicated, block: B:200:0x06b5 A[LOOP:4: B:198:0x06b1->B:200:0x06b5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:202:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:231:0x0655 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x0684 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:245:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:246:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws Throwable {
        UnknownFieldSchema unknownFieldSchema2;
        T t10;
        int i10;
        Object objFilterMapUnknownEnumValues;
        T t11;
        Object mutableExtensions;
        ExtensionRegistryLite extensionRegistryLite;
        int i11;
        Object objFilterMapUnknownEnumValues2;
        int i12;
        Object objFilterMapUnknownEnumValues3;
        Object obj;
        UnknownFieldSchema unknownFieldSchema3 = unknownFieldSchema;
        T t12 = message;
        ExtensionRegistryLite extensionRegistryLite2 = extensionRegistry;
        Object builderFromMessage = null;
        Object obj2 = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    t10 = t12;
                    try {
                        int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                        try {
                            switch (type(iTypeAndOffsetAt)) {
                                case 0:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putDouble(t10, offset(iTypeAndOffsetAt), reader.readDouble());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 1:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putFloat(t10, offset(iTypeAndOffsetAt), reader.readFloat());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 2:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t10, offset(iTypeAndOffsetAt), reader.readInt64());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 3:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t10, offset(iTypeAndOffsetAt), reader.readUInt64());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 4:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t10, offset(iTypeAndOffsetAt), reader.readInt32());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 5:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t10, offset(iTypeAndOffsetAt), reader.readFixed64());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 6:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t10, offset(iTypeAndOffsetAt), reader.readFixed32());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 7:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putBoolean(t10, offset(iTypeAndOffsetAt), reader.readBool());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 8:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readString(t10, iTypeAndOffsetAt, reader);
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 9:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    MessageLite messageLite = (MessageLite) mutableMessageFieldForMerge(t10, iPositionForFieldNumber);
                                    reader.mergeMessageField(messageLite, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    storeMessageField(t10, iPositionForFieldNumber, messageLite);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 10:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), reader.readBytes());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 11:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t10, offset(iTypeAndOffsetAt), reader.readUInt32());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 12:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    int i13 = reader.readEnum();
                                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i13)) {
                                        UnsafeUtil.putInt(t10, offset(iTypeAndOffsetAt), i13);
                                        setFieldPresent(t10, iPositionForFieldNumber);
                                        builderFromMessage = obj;
                                    } else {
                                        builderFromMessage = SchemaUtil.storeUnknownEnum(t10, fieldNumber, i13, obj, unknownFieldSchema2);
                                    }
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 13:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t10, offset(iTypeAndOffsetAt), reader.readSFixed32());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 14:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t10, offset(iTypeAndOffsetAt), reader.readSFixed64());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 15:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t10, offset(iTypeAndOffsetAt), reader.readSInt32());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 16:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t10, offset(iTypeAndOffsetAt), reader.readSInt64());
                                    setFieldPresent(t10, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 17:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    MessageLite messageLite2 = (MessageLite) mutableMessageFieldForMerge(t10, iPositionForFieldNumber);
                                    reader.mergeGroupField(messageLite2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    storeMessageField(t10, iPositionForFieldNumber, messageLite2);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 18:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readDoubleList(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 19:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFloatList(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 20:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 21:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 22:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 23:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 24:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 25:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBoolList(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 26:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readStringList(t10, iTypeAndOffsetAt, reader);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 27:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readMessageList(message, iTypeAndOffsetAt, reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistry);
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 28:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBytesList(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 29:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 30:
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    List<Integer> listMutableListAt = this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt));
                                    reader.readEnumList(listMutableListAt);
                                    builderFromMessage = SchemaUtil.filterUnknownEnumList(message, fieldNumber, listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 31:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 32:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 33:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 34:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 35:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readDoubleList(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 36:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFloatList(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 37:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 38:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 39:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 40:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 41:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 42:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBoolList(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 43:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 44:
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    List<Integer> listMutableListAt2 = this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt));
                                    reader.readEnumList(listMutableListAt2);
                                    builderFromMessage = SchemaUtil.filterUnknownEnumList(message, fieldNumber, listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 45:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 46:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 47:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt32List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 48:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt64List(this.listFieldSchema.mutableListAt(t10, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    try {
                                        readGroupList(message, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistry);
                                        builderFromMessage = obj;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                        builderFromMessage = obj;
                                        try {
                                            if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t10);
                                                }
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                                    objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                    for (i11 = this.checkInitializedCount; i11 < this.repeatedFieldOffsetStart; i11++) {
                                                        objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(message, this.intArray[i11], objFilterMapUnknownEnumValues2, unknownFieldSchema, message);
                                                    }
                                                    if (objFilterMapUnknownEnumValues2 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (!reader.skipField()) {
                                                objFilterMapUnknownEnumValues3 = builderFromMessage;
                                                for (i12 = this.checkInitializedCount; i12 < this.repeatedFieldOffsetStart; i12++) {
                                                    objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(message, this.intArray[i12], objFilterMapUnknownEnumValues3, unknownFieldSchema, message);
                                                }
                                                if (objFilterMapUnknownEnumValues3 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues3);
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        builderFromMessage = obj;
                                        objFilterMapUnknownEnumValues = builderFromMessage;
                                        for (i10 = this.checkInitializedCount; i10 < this.repeatedFieldOffsetStart; i10++) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(message, this.intArray[i10], objFilterMapUnknownEnumValues, unknownFieldSchema, message);
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues);
                                        }
                                        throw th;
                                    }
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 50:
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    try {
                                        mergeMap(message, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistry, reader);
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                        if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            if (builderFromMessage == null) {
                                                builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t10);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                                objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                while (i11 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(message, this.intArray[i11], objFilterMapUnknownEnumValues2, unknownFieldSchema, message);
                                                }
                                                if (objFilterMapUnknownEnumValues2 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues2);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!reader.skipField()) {
                                            objFilterMapUnknownEnumValues3 = builderFromMessage;
                                            while (i12 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(message, this.intArray[i12], objFilterMapUnknownEnumValues3, unknownFieldSchema, message);
                                            }
                                            if (objFilterMapUnknownEnumValues3 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues3);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                        objFilterMapUnknownEnumValues = builderFromMessage;
                                        while (i10 < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(message, this.intArray[i10], objFilterMapUnknownEnumValues, unknownFieldSchema, message);
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues);
                                        }
                                        throw th;
                                    }
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 51:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Double.valueOf(reader.readDouble()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 52:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Float.valueOf(reader.readFloat()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Long.valueOf(reader.readInt64()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 54:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Long.valueOf(reader.readUInt64()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readInt32()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 56:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Long.valueOf(reader.readFixed64()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 57:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readFixed32()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 58:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Boolean.valueOf(reader.readBool()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 59:
                                    readString(t10, iTypeAndOffsetAt, reader);
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 60:
                                    MessageLite messageLite3 = (MessageLite) mutableOneofMessageFieldForMerge(t10, fieldNumber, iPositionForFieldNumber);
                                    reader.mergeMessageField(messageLite3, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                    storeOneofMessageField(t10, fieldNumber, iPositionForFieldNumber, messageLite3);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 61:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), reader.readBytes());
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 62:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readUInt32()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 63:
                                    int i14 = reader.readEnum();
                                    Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                                    if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(i14)) {
                                        builderFromMessage = SchemaUtil.storeUnknownEnum(t10, fieldNumber, i14, builderFromMessage, unknownFieldSchema3);
                                        extensionRegistryLite = extensionRegistryLite2;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        t12 = t10;
                                        extensionRegistryLite2 = extensionRegistryLite;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                    }
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Integer.valueOf(i14));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 64:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSFixed32()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSFixed64()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSInt32()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                    UnsafeUtil.putObject(t10, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSInt64()));
                                    setOneofPresent(t10, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 68:
                                    MessageLite messageLite4 = (MessageLite) mutableOneofMessageFieldForMerge(t10, fieldNumber, iPositionForFieldNumber);
                                    reader.mergeGroupField(messageLite4, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                    storeOneofMessageField(t10, fieldNumber, iPositionForFieldNumber, messageLite4);
                                    obj = builderFromMessage;
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                default:
                                    if (builderFromMessage == null) {
                                        try {
                                            builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t10);
                                            break;
                                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                            extensionRegistryLite = extensionRegistryLite2;
                                            unknownFieldSchema2 = unknownFieldSchema3;
                                            if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t10);
                                                }
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                                    objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                    while (i11 < this.repeatedFieldOffsetStart) {
                                                        objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(message, this.intArray[i11], objFilterMapUnknownEnumValues2, unknownFieldSchema, message);
                                                    }
                                                    if (objFilterMapUnknownEnumValues2 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (!reader.skipField()) {
                                                objFilterMapUnknownEnumValues3 = builderFromMessage;
                                                while (i12 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(message, this.intArray[i12], objFilterMapUnknownEnumValues3, unknownFieldSchema, message);
                                                }
                                                if (objFilterMapUnknownEnumValues3 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues3);
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            unknownFieldSchema2 = unknownFieldSchema3;
                                            objFilterMapUnknownEnumValues = builderFromMessage;
                                            while (i10 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(message, this.intArray[i10], objFilterMapUnknownEnumValues, unknownFieldSchema, message);
                                            }
                                            if (objFilterMapUnknownEnumValues != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader)) {
                                        Object objFilterMapUnknownEnumValues4 = builderFromMessage;
                                        for (int i15 = this.checkInitializedCount; i15 < this.repeatedFieldOffsetStart; i15++) {
                                            objFilterMapUnknownEnumValues4 = filterMapUnknownEnumValues(message, this.intArray[i15], objFilterMapUnknownEnumValues4, unknownFieldSchema, message);
                                        }
                                        if (objFilterMapUnknownEnumValues4 != null) {
                                            unknownFieldSchema3.setBuilderToMessage(t10, objFilterMapUnknownEnumValues4);
                                            return;
                                        }
                                        return;
                                    }
                                    extensionRegistryLite = extensionRegistryLite2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    t12 = t10;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    if (fieldNumber == Integer.MAX_VALUE) {
                        Object objFilterMapUnknownEnumValues5 = builderFromMessage;
                        for (int i16 = this.checkInitializedCount; i16 < this.repeatedFieldOffsetStart; i16++) {
                            objFilterMapUnknownEnumValues5 = filterMapUnknownEnumValues(message, this.intArray[i16], objFilterMapUnknownEnumValues5, unknownFieldSchema, message);
                        }
                        if (objFilterMapUnknownEnumValues5 != null) {
                            unknownFieldSchema3.setBuilderToMessage(t12, objFilterMapUnknownEnumValues5);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objFindExtensionByNumber = !this.hasExtensions ? null : extensionSchema.findExtensionByNumber(extensionRegistryLite2, this.defaultInstance, fieldNumber);
                        if (objFindExtensionByNumber != null) {
                            if (obj2 == null) {
                                try {
                                    mutableExtensions = extensionSchema.getMutableExtensions(message);
                                } catch (Throwable th7) {
                                    th = th7;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    t10 = t12;
                                    objFilterMapUnknownEnumValues = builderFromMessage;
                                    while (i10 < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(message, this.intArray[i10], objFilterMapUnknownEnumValues, unknownFieldSchema, message);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                            } else {
                                mutableExtensions = obj2;
                            }
                            t11 = t12;
                            try {
                                builderFromMessage = extensionSchema.parseExtension(message, reader, objFindExtensionByNumber, extensionRegistry, mutableExtensions, builderFromMessage, unknownFieldSchema);
                                obj2 = mutableExtensions;
                            } catch (Throwable th8) {
                                th = th8;
                                t10 = t11;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                objFilterMapUnknownEnumValues = builderFromMessage;
                                while (i10 < this.repeatedFieldOffsetStart) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(message, this.intArray[i10], objFilterMapUnknownEnumValues, unknownFieldSchema, message);
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                    unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues);
                                }
                                throw th;
                            }
                        } else {
                            t11 = t12;
                            if (!unknownFieldSchema3.shouldDiscardUnknownFields(reader)) {
                                if (builderFromMessage == null) {
                                    builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t11);
                                }
                                if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader)) {
                                }
                            } else if (!reader.skipField()) {
                            }
                        }
                        t12 = t11;
                    } catch (Throwable th9) {
                        th = th9;
                        t10 = t12;
                    }
                }
            } catch (Throwable th10) {
                th = th10;
            }
            objFilterMapUnknownEnumValues = builderFromMessage;
            while (i10 < this.repeatedFieldOffsetStart) {
                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(message, this.intArray[i10], objFilterMapUnknownEnumValues, unknownFieldSchema, message);
            }
            if (objFilterMapUnknownEnumValues != null) {
                unknownFieldSchema2.setBuilderToMessage(t10, objFilterMapUnknownEnumValues);
            }
            throw th;
        }
        int i17 = this.checkInitializedCount;
        Object objFilterMapUnknownEnumValues6 = builderFromMessage;
        while (i17 < this.repeatedFieldOffsetStart) {
            objFilterMapUnknownEnumValues6 = filterMapUnknownEnumValues(message, this.intArray[i17], objFilterMapUnknownEnumValues6, unknownFieldSchema, message);
            i17++;
            t11 = t11;
        }
        T t13 = t11;
        if (objFilterMapUnknownEnumValues6 != null) {
            unknownFieldSchema3.setBuilderToMessage(t13, objFilterMapUnknownEnumValues6);
        }
    }

    private final <K, V> void mergeMap(Object message, int pos, Object mapDefaultEntry, ExtensionRegistryLite extensionRegistry, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(pos));
        Object object = UnsafeUtil.getObject(message, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(mapDefaultEntry);
            UnsafeUtil.putObject(message, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(message, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(mapDefaultEntry), extensionRegistry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T targetParent, T sourceParent, int pos) {
        if (isFieldPresent(sourceParent, pos)) {
            long jOffset = offset(typeAndOffsetAt(pos));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(sourceParent, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
            }
            Schema messageFieldSchema = getMessageFieldSchema(pos);
            if (!isFieldPresent(targetParent, pos)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(targetParent, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(targetParent, jOffset, object);
                }
                setFieldPresent(targetParent, pos);
                return;
            }
            Object object2 = unsafe.getObject(targetParent, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(targetParent, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T targetParent, T sourceParent, int pos) {
        int iNumberAt = numberAt(pos);
        if (isOneofPresent(sourceParent, iNumberAt, pos)) {
            long jOffset = offset(typeAndOffsetAt(pos));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(sourceParent, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
            }
            Schema messageFieldSchema = getMessageFieldSchema(pos);
            if (!isOneofPresent(targetParent, iNumberAt, pos)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(targetParent, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(targetParent, jOffset, object);
                }
                setOneofPresent(targetParent, iNumberAt, pos);
                return;
            }
            Object object2 = unsafe.getObject(targetParent, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(targetParent, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T message, T other, int pos) {
        int iTypeAndOffsetAt = typeAndOffsetAt(pos);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(pos);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putDouble(message, jOffset, UnsafeUtil.getDouble(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 1:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putFloat(message, jOffset, UnsafeUtil.getFloat(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 2:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 3:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 4:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 5:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 6:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 7:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putBoolean(message, jOffset, UnsafeUtil.getBoolean(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 8:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putObject(message, jOffset, UnsafeUtil.getObject(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 9:
                mergeMessage(message, other, pos);
                break;
            case 10:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putObject(message, jOffset, UnsafeUtil.getObject(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 11:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 12:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 13:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 14:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 15:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 16:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 17:
                mergeMessage(message, other, pos);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                this.listFieldSchema.mergeListsAt(message, other, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, message, other, jOffset);
                break;
            case 51:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(other, iNumberAt, pos)) {
                    UnsafeUtil.putObject(message, jOffset, UnsafeUtil.getObject(other, jOffset));
                    setOneofPresent(message, iNumberAt, pos);
                }
                break;
            case 60:
                mergeOneofMessage(message, other, pos);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (isOneofPresent(other, iNumberAt, pos)) {
                    UnsafeUtil.putObject(message, jOffset, UnsafeUtil.getObject(other, jOffset));
                    setOneofPresent(message, iNumberAt, pos);
                }
                break;
            case 68:
                mergeOneofMessage(message, other, pos);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T message, int pos) {
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        long jOffset = offset(typeAndOffsetAt(pos));
        if (!isFieldPresent(message, pos)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(message, jOffset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T message, int fieldNumber, int pos) {
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        if (!isOneofPresent(message, fieldNumber, pos)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(message, offset(typeAndOffsetAt(pos)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> messageClass, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        FieldInfo[] fields = messageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i10 = 0;
        int i11 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i10++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i11++;
            }
        }
        int[] iArr2 = i10 > 0 ? new int[i10] : null;
        int[] iArr3 = i11 > 0 ? new int[i11] : null;
        int[] checkInitialized = messageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i12 < fields.length) {
            FieldInfo fieldInfo2 = fields[i12];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i13, objArr);
            if (i14 < checkInitialized.length && checkInitialized[i14] == fieldNumber3) {
                checkInitialized[i14] = i13;
                i14++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i15] = i13;
                i15++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    iArr3[i16] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i16++;
                }
                i12++;
                i13 += 3;
            }
            i12++;
            i13 += 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, messageInfo.getDefaultInstance(), messageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0249  */
    /* JADX WARN: Code duplicated, block: B:123:0x024e  */
    /* JADX WARN: Code duplicated, block: B:126:0x0264  */
    /* JADX WARN: Code duplicated, block: B:127:0x0267  */
    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i10;
        int iCharAt;
        int iCharAt2;
        int i11;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int i15;
        int i16;
        char cCharAt;
        int i17;
        char cCharAt2;
        int i18;
        char cCharAt3;
        int i19;
        char cCharAt4;
        int i20;
        char cCharAt5;
        int i21;
        char cCharAt6;
        int i22;
        char cCharAt7;
        int i23;
        char cCharAt8;
        int i24;
        int i25;
        int i26;
        int i27;
        int iObjectFieldOffset;
        int i28;
        int i29;
        int iObjectFieldOffset2;
        java.lang.reflect.Field fieldReflectField;
        int i30;
        char cCharAt9;
        int i31;
        int i32;
        int i33;
        Object obj;
        java.lang.reflect.Field fieldReflectField2;
        int i34;
        Object obj2;
        java.lang.reflect.Field fieldReflectField3;
        int i35;
        char cCharAt10;
        int i36;
        char cCharAt11;
        int i37;
        char cCharAt12;
        int i38;
        char cCharAt13;
        String stringInfo = messageInfo.getStringInfo();
        int length = stringInfo.length();
        char c10 = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i39 = 1;
            while (true) {
                i10 = i39 + 1;
                if (stringInfo.charAt(i39) < 55296) {
                    break;
                }
                i39 = i10;
            }
        } else {
            i10 = 1;
        }
        int i40 = i10 + 1;
        int iCharAt3 = stringInfo.charAt(i10);
        if (iCharAt3 >= 55296) {
            int i41 = iCharAt3 & 8191;
            int i42 = 13;
            while (true) {
                i38 = i40 + 1;
                cCharAt13 = stringInfo.charAt(i40);
                if (cCharAt13 < 55296) {
                    break;
                }
                i41 |= (cCharAt13 & 8191) << i42;
                i42 += 13;
                i40 = i38;
            }
            iCharAt3 = i41 | (cCharAt13 << i42);
            i40 = i38;
        }
        if (iCharAt3 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            i14 = 0;
            i15 = 0;
            i11 = 0;
            i13 = 0;
            iArr = EMPTY_INT_ARRAY;
            i12 = 0;
        } else {
            int i43 = i40 + 1;
            int iCharAt4 = stringInfo.charAt(i40);
            if (iCharAt4 >= 55296) {
                int i44 = iCharAt4 & 8191;
                int i45 = 13;
                while (true) {
                    i23 = i43 + 1;
                    cCharAt8 = stringInfo.charAt(i43);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt8 & 8191) << i45;
                    i45 += 13;
                    i43 = i23;
                }
                iCharAt4 = i44 | (cCharAt8 << i45);
                i43 = i23;
            }
            int i46 = i43 + 1;
            int iCharAt5 = stringInfo.charAt(i43);
            if (iCharAt5 >= 55296) {
                int i47 = iCharAt5 & 8191;
                int i48 = 13;
                while (true) {
                    i22 = i46 + 1;
                    cCharAt7 = stringInfo.charAt(i46);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt7 & 8191) << i48;
                    i48 += 13;
                    i46 = i22;
                }
                iCharAt5 = i47 | (cCharAt7 << i48);
                i46 = i22;
            }
            int i49 = i46 + 1;
            int iCharAt6 = stringInfo.charAt(i46);
            if (iCharAt6 >= 55296) {
                int i50 = iCharAt6 & 8191;
                int i51 = 13;
                while (true) {
                    i21 = i49 + 1;
                    cCharAt6 = stringInfo.charAt(i49);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt6 & 8191) << i51;
                    i51 += 13;
                    i49 = i21;
                }
                iCharAt6 = i50 | (cCharAt6 << i51);
                i49 = i21;
            }
            int i52 = i49 + 1;
            int iCharAt7 = stringInfo.charAt(i49);
            if (iCharAt7 >= 55296) {
                int i53 = iCharAt7 & 8191;
                int i54 = 13;
                while (true) {
                    i20 = i52 + 1;
                    cCharAt5 = stringInfo.charAt(i52);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt5 & 8191) << i54;
                    i54 += 13;
                    i52 = i20;
                }
                iCharAt7 = i53 | (cCharAt5 << i54);
                i52 = i20;
            }
            int i55 = i52 + 1;
            iCharAt = stringInfo.charAt(i52);
            if (iCharAt >= 55296) {
                int i56 = iCharAt & 8191;
                int i57 = 13;
                while (true) {
                    i19 = i55 + 1;
                    cCharAt4 = stringInfo.charAt(i55);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt4 & 8191) << i57;
                    i57 += 13;
                    i55 = i19;
                }
                iCharAt = i56 | (cCharAt4 << i57);
                i55 = i19;
            }
            int i58 = i55 + 1;
            iCharAt2 = stringInfo.charAt(i55);
            if (iCharAt2 >= 55296) {
                int i59 = iCharAt2 & 8191;
                int i60 = 13;
                while (true) {
                    i18 = i58 + 1;
                    cCharAt3 = stringInfo.charAt(i58);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i59 |= (cCharAt3 & 8191) << i60;
                    i60 += 13;
                    i58 = i18;
                }
                iCharAt2 = i59 | (cCharAt3 << i60);
                i58 = i18;
            }
            int i61 = i58 + 1;
            int iCharAt8 = stringInfo.charAt(i58);
            if (iCharAt8 >= 55296) {
                int i62 = iCharAt8 & 8191;
                int i63 = 13;
                while (true) {
                    i17 = i61 + 1;
                    cCharAt2 = stringInfo.charAt(i61);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i62 |= (cCharAt2 & 8191) << i63;
                    i63 += 13;
                    i61 = i17;
                }
                iCharAt8 = i62 | (cCharAt2 << i63);
                i61 = i17;
            }
            int i64 = i61 + 1;
            int iCharAt9 = stringInfo.charAt(i61);
            if (iCharAt9 >= 55296) {
                int i65 = iCharAt9 & 8191;
                int i66 = 13;
                while (true) {
                    i16 = i64 + 1;
                    cCharAt = stringInfo.charAt(i64);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i65 |= (cCharAt & 8191) << i66;
                    i66 += 13;
                    i64 = i16;
                }
                iCharAt9 = i65 | (cCharAt << i66);
                i64 = i16;
            }
            i11 = (iCharAt4 * 2) + iCharAt5;
            i12 = iCharAt4;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i13 = iCharAt9;
            i40 = i64;
            i14 = iCharAt6;
            i15 = iCharAt7;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = messageInfo.getObjects();
        Class<?> cls = messageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[iCharAt * 2];
        int i67 = i13 + iCharAt2;
        int i68 = i13;
        int i69 = i67;
        int i70 = 0;
        int i71 = 0;
        while (i40 < length) {
            int i72 = i40 + 1;
            int iCharAt10 = stringInfo.charAt(i40);
            if (iCharAt10 >= c10) {
                int i73 = iCharAt10 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i37 = i74 + 1;
                    cCharAt12 = stringInfo.charAt(i74);
                    if (cCharAt12 < c10) {
                        break;
                    }
                    i73 |= (cCharAt12 & 8191) << i75;
                    i75 += 13;
                    i74 = i37;
                }
                iCharAt10 = i73 | (cCharAt12 << i75);
                i24 = i37;
            } else {
                i24 = i72;
            }
            int i76 = i24 + 1;
            int iCharAt11 = stringInfo.charAt(i24);
            if (iCharAt11 >= c10) {
                int i77 = iCharAt11 & 8191;
                int i78 = i76;
                int i79 = 13;
                while (true) {
                    i36 = i78 + 1;
                    cCharAt11 = stringInfo.charAt(i78);
                    if (cCharAt11 < c10) {
                        break;
                    }
                    i77 |= (cCharAt11 & 8191) << i79;
                    i79 += 13;
                    i78 = i36;
                }
                iCharAt11 = i77 | (cCharAt11 << i79);
                i25 = i36;
            } else {
                i25 = i76;
            }
            int i80 = iCharAt11 & 255;
            int i81 = length;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i70] = i71;
                i70++;
            }
            int i82 = i70;
            if (i80 >= 51) {
                int i83 = i25 + 1;
                int iCharAt12 = stringInfo.charAt(i25);
                char c11 = 55296;
                if (iCharAt12 >= 55296) {
                    int i84 = iCharAt12 & 8191;
                    int i85 = 13;
                    while (true) {
                        i35 = i83 + 1;
                        cCharAt10 = stringInfo.charAt(i83);
                        if (cCharAt10 < c11) {
                            break;
                        }
                        i84 |= (cCharAt10 & 8191) << i85;
                        i85 += 13;
                        i83 = i35;
                        c11 = 55296;
                    }
                    iCharAt12 = i84 | (cCharAt10 << i85);
                    i83 = i35;
                }
                int i86 = i80 - 51;
                int i87 = i83;
                if (i86 == 9 || i86 == 17) {
                    i32 = i11 + 1;
                    objArr[((i71 / 3) * 2) + 1] = objects[i11];
                } else {
                    if (i86 == 12 && (messageInfo.getSyntax().equals(ProtoSyntax.PROTO2) || (iCharAt11 & 2048) != 0)) {
                        i32 = i11 + 1;
                        objArr[((i71 / 3) * 2) + 1] = objects[i11];
                    }
                    i33 = iCharAt12 * 2;
                    obj = objects[i33];
                    if (obj instanceof java.lang.reflect.Field) {
                        fieldReflectField2 = (java.lang.reflect.Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i33] = fieldReflectField2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    i34 = i33 + 1;
                    obj2 = objects[i34];
                    if (obj2 instanceof java.lang.reflect.Field) {
                        fieldReflectField3 = (java.lang.reflect.Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i34] = fieldReflectField3;
                    }
                    i27 = i15;
                    i26 = i11;
                    i28 = i87;
                    stringInfo = stringInfo;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    i29 = 0;
                }
                i11 = i32;
                i33 = iCharAt12 * 2;
                obj = objects[i33];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i33] = fieldReflectField2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                i34 = i33 + 1;
                obj2 = objects[i34];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i34] = fieldReflectField3;
                }
                i27 = i15;
                i26 = i11;
                i28 = i87;
                stringInfo = stringInfo;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField3);
                i29 = 0;
            } else {
                i26 = i11 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i11]);
                if (i80 == 9 || i80 == 17) {
                    i27 = i15;
                    objArr[((i71 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i80 == 27 || i80 == 49) {
                        i27 = i15;
                        i31 = i11 + 2;
                        objArr[((i71 / 3) * 2) + 1] = objects[i26];
                    } else if (i80 == 12 || i80 == 30 || i80 == 44) {
                        i27 = i15;
                        if (messageInfo.getSyntax() == ProtoSyntax.PROTO2 || (iCharAt11 & 2048) != 0) {
                            i31 = i11 + 2;
                            objArr[((i71 / 3) * 2) + 1] = objects[i26];
                        }
                    } else {
                        if (i80 == 50) {
                            int i88 = i68 + 1;
                            iArr[i68] = i71;
                            int i89 = (i71 / 3) * 2;
                            int i90 = i11 + 2;
                            objArr[i89] = objects[i26];
                            if ((iCharAt11 & 2048) != 0) {
                                i26 = i11 + 3;
                                objArr[i89 + 1] = objects[i90];
                                i68 = i88;
                            } else {
                                i68 = i88;
                                i26 = i90;
                            }
                        }
                        i27 = i15;
                    }
                    i26 = i31;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt11 & 4096) == 0 || i80 > 17) {
                    iObjectFieldOffset = 1048575;
                    i28 = i25;
                    i29 = 0;
                } else {
                    i28 = i25 + 1;
                    int iCharAt13 = stringInfo.charAt(i25);
                    if (iCharAt13 >= 55296) {
                        int i91 = iCharAt13 & 8191;
                        int i92 = 13;
                        while (true) {
                            i30 = i28 + 1;
                            cCharAt9 = stringInfo.charAt(i28);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i91 |= (cCharAt9 & 8191) << i92;
                            i92 += 13;
                            i28 = i30;
                        }
                        iCharAt13 = i91 | (cCharAt9 << i92);
                        i28 = i30;
                    }
                    int i93 = (iCharAt13 / 32) + (i12 * 2);
                    Object obj3 = objects[i93];
                    if (obj3 instanceof java.lang.reflect.Field) {
                        fieldReflectField = (java.lang.reflect.Field) obj3;
                    } else {
                        fieldReflectField = reflectField(cls, (String) obj3);
                        objects[i93] = fieldReflectField;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField);
                    i29 = iCharAt13 % 32;
                }
                if (i80 >= 18 && i80 <= 49) {
                    iArr[i69] = iObjectFieldOffset3;
                    i69++;
                }
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i94 = i71 + 1;
            iArr2[i71] = iCharAt10;
            int i95 = i71 + 2;
            int i96 = i12;
            iArr2[i94] = iObjectFieldOffset2 | (i80 << 20) | ((iCharAt11 & 256) != 0 ? REQUIRED_MASK : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0);
            i71 += 3;
            iArr2[i95] = iObjectFieldOffset | (i29 << 20);
            i40 = i28;
            stringInfo = stringInfo;
            i11 = i26;
            length = i81;
            i15 = i27;
            i70 = i82;
            i12 = i96;
            i14 = i14;
            c10 = 55296;
        }
        return new MessageSchema<>(iArr2, objArr, i14, i15, messageInfo.getDefaultInstance(), messageInfo.getSyntax(), false, iArr, i13, i67, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int pos) {
        return this.buffer[pos];
    }

    private static long offset(int value) {
        return value & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T message, long offset) {
        return ((Boolean) UnsafeUtil.getObject(message, offset)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T message, long offset) {
        return ((Double) UnsafeUtil.getObject(message, offset)).doubleValue();
    }

    private static <T> float oneofFloatAt(T message, long offset) {
        return ((Float) UnsafeUtil.getObject(message, offset)).floatValue();
    }

    private static <T> int oneofIntAt(T message, long offset) {
        return ((Integer) UnsafeUtil.getObject(message, offset)).intValue();
    }

    private static <T> long oneofLongAt(T message, long offset) {
        return ((Long) UnsafeUtil.getObject(message, offset)).longValue();
    }

    private <K, V> int parseMapField(T message, byte[] data, int position, int limit, int bufferPosition, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(bufferPosition);
        Object object = unsafe.getObject(message, fieldOffset);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(message, fieldOffset, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(data, position, limit, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int typeAndOffset, int fieldType, long fieldOffset, int bufferPosition, ArrayDecoders.Registers registers) throws IOException {
        int iMergeMessageField;
        Unsafe unsafe = UNSAFE;
        long j10 = this.buffer[bufferPosition + 2] & 1048575;
        switch (fieldType) {
            case 51:
                if (wireType != 1) {
                    return position;
                }
                unsafe.putObject(message, fieldOffset, Double.valueOf(ArrayDecoders.decodeDouble(data, position)));
                int i10 = position + 8;
                unsafe.putInt(message, j10, number);
                return i10;
            case 52:
                if (wireType != 5) {
                    return position;
                }
                unsafe.putObject(message, fieldOffset, Float.valueOf(ArrayDecoders.decodeFloat(data, position)));
                int i11 = position + 4;
                unsafe.putInt(message, j10, number);
                return i11;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 54:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(data, position, registers);
                unsafe.putObject(message, fieldOffset, Long.valueOf(registers.long1));
                unsafe.putInt(message, j10, number);
                return iDecodeVarint64;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 62:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(data, position, registers);
                unsafe.putObject(message, fieldOffset, Integer.valueOf(registers.int1));
                unsafe.putInt(message, j10, number);
                return iDecodeVarint32;
            case 56:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                if (wireType != 1) {
                    return position;
                }
                unsafe.putObject(message, fieldOffset, Long.valueOf(ArrayDecoders.decodeFixed64(data, position)));
                int i12 = position + 8;
                unsafe.putInt(message, j10, number);
                return i12;
            case 57:
            case 64:
                if (wireType != 5) {
                    return position;
                }
                unsafe.putObject(message, fieldOffset, Integer.valueOf(ArrayDecoders.decodeFixed32(data, position)));
                int i13 = position + 4;
                unsafe.putInt(message, j10, number);
                return i13;
            case 58:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(data, position, registers);
                unsafe.putObject(message, fieldOffset, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(message, j10, number);
                return iDecodeVarint65;
            case 59:
                if (wireType != 2) {
                    return position;
                }
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(data, position, registers);
                int i14 = registers.int1;
                if (i14 == 0) {
                    unsafe.putObject(message, fieldOffset, "");
                } else {
                    if ((typeAndOffset & 536870912) != 0 && !Utf8.isValidUtf8(data, iDecodeVarint33, iDecodeVarint33 + i14)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(message, fieldOffset, new String(data, iDecodeVarint33, i14, Internal.UTF_8));
                    iDecodeVarint33 += i14;
                }
                unsafe.putInt(message, j10, number);
                return iDecodeVarint33;
            case 60:
                if (wireType != 2) {
                    return position;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
                iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(bufferPosition), data, position, limit, registers);
                storeOneofMessageField(message, number, bufferPosition, objMutableOneofMessageFieldForMerge);
                break;
                break;
            case 61:
                if (wireType != 2) {
                    return position;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(data, position, registers);
                unsafe.putObject(message, fieldOffset, registers.object1);
                unsafe.putInt(message, j10, number);
                return iDecodeBytes;
            case 63:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint34 = ArrayDecoders.decodeVarint32(data, position, registers);
                int i15 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(bufferPosition);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i15)) {
                    unsafe.putObject(message, fieldOffset, Integer.valueOf(i15));
                    unsafe.putInt(message, j10, number);
                } else {
                    getMutableUnknownFields(message).storeField(tag, Long.valueOf(i15));
                }
                return iDecodeVarint34;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint35 = ArrayDecoders.decodeVarint32(data, position, registers);
                unsafe.putObject(message, fieldOffset, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(message, j10, number);
                return iDecodeVarint35;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(data, position, registers);
                unsafe.putObject(message, fieldOffset, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(message, j10, number);
                return iDecodeVarint66;
            case 68:
                if (wireType != 3) {
                    return position;
                }
                Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
                iMergeMessageField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(bufferPosition), data, position, limit, (tag & (-8)) | 4, registers);
                storeOneofMessageField(message, number, bufferPosition, objMutableOneofMessageFieldForMerge2);
                break;
                break;
            default:
                return position;
        }
        return iMergeMessageField;
    }

    private int parseRepeatedField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int bufferPosition, long typeAndOffset, int fieldType, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(message, fieldOffset);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(message, fieldOffset, protobufListMutableCopyWithCapacity2);
        }
        switch (fieldType) {
            case 18:
            case 35:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedDoubleList(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 1 ? ArrayDecoders.decodeDoubleList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 19:
            case 36:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFloatList(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 5 ? ArrayDecoders.decodeFloatList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 20:
            case 21:
            case 37:
            case 38:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedVarint64List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeVarint64List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 22:
            case 29:
            case 39:
            case 43:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedVarint32List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeVarint32List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 23:
            case 32:
            case 40:
            case 46:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFixed64List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 1 ? ArrayDecoders.decodeFixed64List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 24:
            case 31:
            case 41:
            case 45:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFixed32List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 5 ? ArrayDecoders.decodeFixed32List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 25:
            case 42:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedBoolList(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeBoolList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 26:
                if (wireType == 2) {
                    return (typeAndOffset & 536870912) == 0 ? ArrayDecoders.decodeStringList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : ArrayDecoders.decodeStringListRequireUtf8(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers);
                }
                return position;
            case 27:
                return wireType == 2 ? ArrayDecoders.decodeMessageList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 28:
                return wireType == 2 ? ArrayDecoders.decodeBytesList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 30:
            case 44:
                if (wireType == 2) {
                    iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(data, position, protobufListMutableCopyWithCapacity2, registers);
                } else {
                    if (wireType != 0) {
                        return position;
                    }
                    iDecodeVarint32List = ArrayDecoders.decodeVarint32List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) message, number, (List<Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(bufferPosition), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedSInt32List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeSInt32List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 34:
            case 48:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedSInt64List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeSInt64List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                return wireType == 3 ? ArrayDecoders.decodeGroupList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            default:
                return position;
        }
    }

    private int positionForFieldNumber(final int number) {
        if (number < this.minFieldNumber || number > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(number, 0);
    }

    private int presenceMaskAndOffsetAt(int pos) {
        return this.buffer[pos + 2];
    }

    private <E> void readGroupList(Object message, long offset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(message, offset), schema, extensionRegistry);
    }

    private <E> void readMessageList(Object message, int typeAndOffset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)), schema, extensionRegistry);
    }

    private void readString(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset)) {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readString());
        } else {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readBytes());
        }
    }

    private void readStringList(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> messageClass, String fieldName) {
        try {
            return messageClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = messageClass.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (fieldName.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbA = e.a.a("Field ", fieldName, " for ");
            sbA.append(messageClass.getName());
            sbA.append(" not found. Known fields are ");
            sbA.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbA.toString());
        }
    }

    private void setFieldPresent(T message, int pos) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos);
        long j10 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j10 == 1048575) {
            return;
        }
        UnsafeUtil.putInt(message, j10, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(message, j10));
    }

    private void setOneofPresent(T message, int fieldNumber, int pos) {
        UnsafeUtil.putInt(message, presenceMaskAndOffsetAt(pos) & 1048575, fieldNumber);
    }

    private int slowPositionForFieldNumber(final int number, int min) {
        int length = (this.buffer.length / 3) - 1;
        while (min <= length) {
            int i10 = (length + min) >>> 1;
            int i11 = i10 * 3;
            int iNumberAt = numberAt(i11);
            if (number == iNumberAt) {
                return i11;
            }
            if (number < iNumberAt) {
                length = i10 - 1;
            } else {
                min = i10 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007a  */
    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x009e  */
    /* JADX WARN: Code duplicated, block: B:30:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:31:0x00af  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    private static void storeFieldData(FieldInfo fi2, int[] buffer, int bufferIndex, Object[] objects) {
        int iObjectFieldOffset;
        int iId;
        long jObjectFieldOffset;
        int iObjectFieldOffset2;
        int iNumberOfTrailingZeros;
        int i10;
        Class<?> messageFieldClass;
        int i11;
        OneofInfo oneof = fi2.getOneof();
        if (oneof == null) {
            FieldType type = fi2.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fi2.getField());
            iId = type.id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fi2.getPresenceField();
                iObjectFieldOffset2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fi2.getPresenceMask());
            } else if (fi2.getCachedSizeField() == null) {
                iObjectFieldOffset2 = 0;
                iNumberOfTrailingZeros = 0;
            } else {
                jObjectFieldOffset = UnsafeUtil.objectFieldOffset(fi2.getCachedSizeField());
            }
            buffer[bufferIndex] = fi2.getFieldNumber();
            int i12 = bufferIndex + 1;
            if (fi2.isEnforceUtf8()) {
                i10 = 536870912;
            } else {
                i10 = 0;
            }
            buffer[i12] = (fi2.isRequired() ? REQUIRED_MASK : 0) | i10 | (iId << 20) | iObjectFieldOffset;
            buffer[bufferIndex + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
            messageFieldClass = fi2.getMessageFieldClass();
            if (fi2.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fi2.getEnumVerifier() != null) {
                        objects[((bufferIndex / 3) * 2) + 1] = fi2.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            i11 = (bufferIndex / 3) * 2;
            objects[i11] = fi2.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objects[i11 + 1] = messageFieldClass;
            } else if (fi2.getEnumVerifier() != null) {
                objects[i11 + 1] = fi2.getEnumVerifier();
            }
        }
        iId = fi2.getType().id() + 51;
        iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
        jObjectFieldOffset = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        iObjectFieldOffset2 = (int) jObjectFieldOffset;
        iNumberOfTrailingZeros = 0;
        buffer[bufferIndex] = fi2.getFieldNumber();
        int i13 = bufferIndex + 1;
        if (fi2.isEnforceUtf8()) {
            i10 = 536870912;
        } else {
            i10 = 0;
        }
        buffer[i13] = (fi2.isRequired() ? REQUIRED_MASK : 0) | i10 | (iId << 20) | iObjectFieldOffset;
        buffer[bufferIndex + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
        messageFieldClass = fi2.getMessageFieldClass();
        if (fi2.getMapDefaultEntry() != null) {
            if (messageFieldClass != null) {
                objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
                return;
            } else {
                if (fi2.getEnumVerifier() != null) {
                    objects[((bufferIndex / 3) * 2) + 1] = fi2.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i11 = (bufferIndex / 3) * 2;
        objects[i11] = fi2.getMapDefaultEntry();
        if (messageFieldClass != null) {
            objects[i11 + 1] = messageFieldClass;
        } else if (fi2.getEnumVerifier() != null) {
            objects[i11 + 1] = fi2.getEnumVerifier();
        }
    }

    private void storeMessageField(T message, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setFieldPresent(message, pos);
    }

    private void storeOneofMessageField(T message, int fieldNumber, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setOneofPresent(message, fieldNumber, pos);
    }

    private static int type(int value) {
        return (value & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int pos) {
        return this.buffer[pos + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    private void writeFieldsInAscendingOrder(T message, Writer writer) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator it;
        int i10;
        Map.Entry<?, ?> entry2;
        int i11;
        int i12;
        Map.Entry<?, ?> entry3;
        boolean z10;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(message);
            if (extensions.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator it2 = extensions.iterator();
                entry = (Map.Entry) it2.next();
                it = it2;
            }
        } else {
            entry = null;
            it = null;
        }
        int length = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i13 = 1048575;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        while (i16 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i16);
            int iNumberAt = numberAt(i16);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                int i17 = this.buffer[i16 + 2];
                int i18 = i17 & i13;
                if (i18 != i14) {
                    i15 = i18 == i13 ? 0 : unsafe.getInt(message, i18);
                    i14 = i18;
                } else {
                    entry = entry;
                }
                int i19 = 1 << (i17 >>> 20);
                i10 = i14;
                i11 = i19;
                entry2 = entry;
            } else {
                i10 = i14;
                entry2 = entry;
                i11 = 0;
            }
            int i20 = i15;
            while (entry2 != null && this.extensionSchema.extensionNumber(entry2) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeDouble(iNumberAt, doubleAt(message, jOffset));
                    }
                    break;
                case 1:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeFloat(iNumberAt, floatAt(message, jOffset));
                    }
                    break;
                case 2:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(message, jOffset));
                    }
                    break;
                case 3:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(message, jOffset));
                    }
                    break;
                case 4:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(message, jOffset));
                    }
                    break;
                case 5:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(message, jOffset));
                    }
                    break;
                case 6:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(message, jOffset));
                    }
                    break;
                case 7:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeBool(iNumberAt, booleanAt(message, jOffset));
                    }
                    break;
                case 8:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writeString(iNumberAt, unsafe.getObject(message, jOffset), writer);
                    }
                    break;
                case 9:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                    }
                    break;
                case 10:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(message, jOffset));
                    }
                    break;
                case 11:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(message, jOffset));
                    }
                    break;
                case 12:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(message, jOffset));
                    }
                    break;
                case 13:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(message, jOffset));
                    }
                    break;
                case 14:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(message, jOffset));
                    }
                    break;
                case 15:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(message, jOffset));
                    }
                    break;
                case 16:
                    i12 = length;
                    entry3 = entry2;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(message, jOffset));
                    }
                    break;
                case 17:
                    entry3 = entry2;
                    i12 = length;
                    if (isFieldPresent(message, i16, i10, i20, i11)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                    }
                    break;
                case 18:
                    z10 = false;
                    SchemaUtil.writeDoubleList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 19:
                    z10 = false;
                    SchemaUtil.writeFloatList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 20:
                    z10 = false;
                    SchemaUtil.writeInt64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 21:
                    z10 = false;
                    SchemaUtil.writeUInt64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 22:
                    z10 = false;
                    SchemaUtil.writeInt32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 23:
                    z10 = false;
                    SchemaUtil.writeFixed64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 24:
                    z10 = false;
                    SchemaUtil.writeFixed32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 25:
                    z10 = false;
                    SchemaUtil.writeBoolList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, getMessageFieldSchema(i16));
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 29:
                    z10 = false;
                    SchemaUtil.writeUInt32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 30:
                    z10 = false;
                    SchemaUtil.writeEnumList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 31:
                    z10 = false;
                    SchemaUtil.writeSFixed32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 32:
                    z10 = false;
                    SchemaUtil.writeSFixed64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 33:
                    z10 = false;
                    SchemaUtil.writeSInt32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 34:
                    z10 = false;
                    SchemaUtil.writeSInt64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, false);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, true);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    SchemaUtil.writeGroupList(numberAt(i16), (List) unsafe.getObject(message, jOffset), writer, getMessageFieldSchema(i16));
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(message, jOffset), i16);
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writeString(iNumberAt, unsafe.getObject(message, jOffset), writer);
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                    }
                    i12 = length;
                    entry3 = entry2;
                    break;
                default:
                    i12 = length;
                    entry3 = entry2;
                    break;
            }
            i16 += 3;
            i14 = i10;
            entry = entry3;
            i15 = i20;
            length = i12;
            i13 = 1048575;
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void writeFieldsInDescendingOrder(T message, Writer writer) throws IOException {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(message);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        } else {
            itDescendingIterator = null;
            entry = null;
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(message, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(message, length)) {
                        writer.writeFloat(iNumberAt, floatAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(message, length)) {
                        writer.writeInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(message, length)) {
                        writer.writeUInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(message, length)) {
                        writer.writeInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(message, length)) {
                        writer.writeFixed64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(message, length)) {
                        writer.writeFixed32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(message, length)) {
                        writer.writeBool(iNumberAt, booleanAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(message, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(message, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(message, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(message, length)) {
                        writer.writeUInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(message, length)) {
                        writer.writeEnum(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(message, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(message, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(message, length)) {
                        writer.writeSInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(message, length)) {
                        writer.writeSInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(message, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int number, Object mapField, int pos) throws IOException {
        if (mapField != null) {
            writer.writeMap(number, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(pos)), this.mapFieldSchema.forMapData(mapField));
        }
    }

    private void writeString(int fieldNumber, Object value, Writer writer) throws IOException {
        if (value instanceof String) {
            writer.writeString(fieldNumber, (String) value);
        } else {
            writer.writeBytes(fieldNumber, (ByteString) value);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> schema, T message, Writer writer) throws IOException {
        schema.writeTo(schema.getFromMessage(message), writer);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T message, T other) {
        int length = this.buffer.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!equals(message, other, i10)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(message).equals(this.unknownFieldSchema.getFromMessage(other))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:27:0x0079 A[PHI: r12
      0x0079: PHI (r12v4 int) = 
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v8 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v9 int)
      (r12v1 int)
      (r12v10 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v11 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v1 int)
      (r12v12 int)
      (r12v1 int)
     binds: [B:21:0x0060, B:227:0x0563, B:224:0x054d, B:218:0x0525, B:215:0x0506, B:212:0x04e9, B:209:0x04ce, B:206:0x04b3, B:203:0x049b, B:200:0x0485, B:197:0x046b, B:194:0x0450, B:191:0x042f, B:167:0x0331, B:161:0x0313, B:155:0x02f5, B:149:0x02d7, B:143:0x02b9, B:137:0x029b, B:131:0x027d, B:125:0x025f, B:119:0x0241, B:113:0x0224, B:107:0x0207, B:101:0x01ea, B:95:0x01cd, B:93:0x01be, B:88:0x01ac, B:83:0x0178, B:80:0x016c, B:77:0x015c, B:74:0x014c, B:71:0x013c, B:68:0x0130, B:65:0x0124, B:62:0x0118, B:59:0x0109, B:55:0x00f9, B:53:0x00f3, B:51:0x00e5, B:48:0x00d4, B:45:0x00c5, B:42:0x00b6, B:40:0x00b0, B:38:0x00a9, B:35:0x009e, B:32:0x008f, B:29:0x0080, B:26:0x0078, B:24:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T message) {
        int i10;
        int i11;
        int i12;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        int iComputeSFixed32Size;
        boolean z10;
        int iComputeSizeFixed32List;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i13 = 1048575;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i16 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i16);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i16);
            int i18 = this.buffer[i16 + 2];
            int i19 = i18 & i13;
            if (iType <= 17) {
                if (i19 != i14) {
                    i15 = i19 == i13 ? 0 : unsafe.getInt(message, i19);
                    i14 = i19;
                }
                i10 = i14;
                i11 = i15;
                i12 = 1 << (i18 >>> 20);
            } else {
                i10 = i14;
                i11 = i15;
                i12 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            if (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) {
                i19 = 0;
            }
            switch (iType) {
                case 0:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i17 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i17 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(message, jOffset));
                        i17 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(message, jOffset));
                        i17 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(message, jOffset));
                        i17 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i17 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i17 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        Object object = unsafe.getObject(message, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        i17 = iComputeBytesSize + i17;
                    }
                    break;
                case 9:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                        i17 += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i17 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(message, i16, i10, i11, i12)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeMessage;
                    break;
                case 19:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 20:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 21:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 22:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 23:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 24:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 25:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(message, jOffset));
                    i17 += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                    i17 += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(message, jOffset));
                    i17 += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeMessage;
                    break;
                case 30:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 31:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 32:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 33:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 34:
                    z10 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i17 += iComputeSizeFixed32List;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i19, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i17 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                    i17 += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(message, jOffset), getMapFieldDefaultEntry(i16));
                    i17 += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i17 += iComputeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        Object object2 = unsafe.getObject(message, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        i17 = iComputeBytesSize + i17;
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                        i17 += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i17 += iComputeSFixed32Size;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i17 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i17 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, i16)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(message, jOffset), getMessageFieldSchema(i16));
                        i17 += iComputeBoolSize;
                    }
                    break;
                default:
                    break;
            }
            i16 += 3;
            i14 = i10;
            i15 = i11;
            i13 = 1048575;
        }
        int unknownFieldsSerializedSize = i17 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(message).getSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T message) {
        int i10;
        int iHashLong;
        int i11;
        int iOneofIntAt;
        int length = this.buffer.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i13);
            int iNumberAt = numberAt(i13);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i10 = i12 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(message, jOffset)));
                    i12 = iHashLong + i10;
                    break;
                case 1:
                    i10 = i12 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(message, jOffset));
                    i12 = iHashLong + i10;
                    break;
                case 2:
                    i10 = i12 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i12 = iHashLong + i10;
                    break;
                case 3:
                    i10 = i12 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i12 = iHashLong + i10;
                    break;
                case 4:
                    i11 = i12 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(message, jOffset);
                    i12 = i11 + iOneofIntAt;
                    break;
                case 5:
                    i10 = i12 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i12 = iHashLong + i10;
                    break;
                case 6:
                    i11 = i12 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(message, jOffset);
                    i12 = i11 + iOneofIntAt;
                    break;
                case 7:
                    i10 = i12 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(message, jOffset));
                    i12 = iHashLong + i10;
                    break;
                case 8:
                    i10 = i12 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(message, jOffset)).hashCode();
                    i12 = iHashLong + i10;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(message, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 10:
                    i10 = i12 * 53;
                    iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                    i12 = iHashLong + i10;
                    break;
                case 11:
                    i11 = i12 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(message, jOffset);
                    i12 = i11 + iOneofIntAt;
                    break;
                case 12:
                    i11 = i12 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(message, jOffset);
                    i12 = i11 + iOneofIntAt;
                    break;
                case 13:
                    i11 = i12 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(message, jOffset);
                    i12 = i11 + iOneofIntAt;
                    break;
                case 14:
                    i10 = i12 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i12 = iHashLong + i10;
                    break;
                case 15:
                    i11 = i12 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(message, jOffset);
                    i12 = i11 + iOneofIntAt;
                    break;
                case 16:
                    i10 = i12 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i12 = iHashLong + i10;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(message, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i10 = i12 * 53;
                    iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                    i12 = iHashLong + i10;
                    break;
                case 50:
                    i10 = i12 * 53;
                    iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                    i12 = iHashLong + i10;
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(message, jOffset)));
                        i12 = iHashLong + i10;
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(message, jOffset));
                        i12 = iHashLong + i10;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i12 = iHashLong + i10;
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i12 = iHashLong + i10;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i11 = i12 * 53;
                        iOneofIntAt = oneofIntAt(message, jOffset);
                        i12 = i11 + iOneofIntAt;
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i12 = iHashLong + i10;
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i11 = i12 * 53;
                        iOneofIntAt = oneofIntAt(message, jOffset);
                        i12 = i11 + iOneofIntAt;
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(message, jOffset));
                        i12 = iHashLong + i10;
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(message, jOffset)).hashCode();
                        i12 = iHashLong + i10;
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                        i12 = iHashLong + i10;
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                        i12 = iHashLong + i10;
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i11 = i12 * 53;
                        iOneofIntAt = oneofIntAt(message, jOffset);
                        i12 = i11 + iOneofIntAt;
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i11 = i12 * 53;
                        iOneofIntAt = oneofIntAt(message, jOffset);
                        i12 = i11 + iOneofIntAt;
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i11 = i12 * 53;
                        iOneofIntAt = oneofIntAt(message, jOffset);
                        i12 = i11 + iOneofIntAt;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i12 = iHashLong + i10;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i11 = i12 * 53;
                        iOneofIntAt = oneofIntAt(message, jOffset);
                        i12 = i11 + iOneofIntAt;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i12 = iHashLong + i10;
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, i13)) {
                        i10 = i12 * 53;
                        iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                        i12 = iHashLong + i10;
                    }
                    break;
            }
        }
        int iHashCode2 = this.unknownFieldSchema.getFromMessage(message).hashCode() + (i12 * 53);
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(message).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:58:0x008f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa A[SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T message) {
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.checkInitializedCount) {
            int i15 = this.intArray[i14];
            int iNumberAt = numberAt(i15);
            int iTypeAndOffsetAt = typeAndOffsetAt(i15);
            int i16 = this.buffer[i15 + 2];
            int i17 = i16 & 1048575;
            int i18 = 1 << (i16 >>> 20);
            if (i17 != i12) {
                if (i17 != 1048575) {
                    i13 = UNSAFE.getInt(message, i17);
                }
                i11 = i13;
                i10 = i17;
            } else {
                i10 = i12;
                i11 = i13;
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(message, i15, i10, i11, i18)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(message, i15, i10, i11, i18) && !isInitialized(message, iTypeAndOffsetAt, getMessageFieldSchema(i15))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(message, iTypeAndOffsetAt, i15)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(message, iNumberAt, i15) && !isInitialized(message, iTypeAndOffsetAt, getMessageFieldSchema(i15))) {
                    return false;
                }
            } else if (iType != 49) {
                if (iType == 50 && !isMapInitialized(message, iTypeAndOffsetAt, i15)) {
                    return false;
                }
            } else if (!isListInitialized(message, iTypeAndOffsetAt, i15)) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(message).isInitialized();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x007c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public void makeImmutable(T message) {
        if (isMutable(message)) {
            if (message instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i10);
                long jOffset = offset(iTypeAndOffsetAt);
                int iType = type(iTypeAndOffsetAt);
                if (iType != 9) {
                    if (iType != 60 && iType != 68) {
                        switch (iType) {
                            case 17:
                                if (isFieldPresent(message, i10)) {
                                    getMessageFieldSchema(i10).makeImmutable(UNSAFE.getObject(message, jOffset));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.listFieldSchema.makeImmutableListAt(message, jOffset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(message, jOffset);
                                if (object != null) {
                                    unsafe.putObject(message, jOffset, this.mapFieldSchema.toImmutable(object));
                                }
                                break;
                        }
                    } else if (isOneofPresent(message, numberAt(i10), i10)) {
                        getMessageFieldSchema(i10).makeImmutable(UNSAFE.getObject(message, jOffset));
                    }
                } else if (isFieldPresent(message, i10)) {
                    getMessageFieldSchema(i10).makeImmutable(UNSAFE.getObject(message, jOffset));
                }
            }
            this.unknownFieldSchema.makeImmutable(message);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(message);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T message, T other) {
        checkMutable(message);
        other.getClass();
        for (int i10 = 0; i10 < this.buffer.length; i10 += 3) {
            mergeSingleField(message, other, i10);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x009a. Please report as an issue. */
    @CanIgnoreReturnValue
    public int parseMessage(T message, byte[] data, int position, int limit, int endDelimited, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        MessageSchema<T> messageSchema;
        int i10;
        int i11;
        int i12;
        int i13;
        T t10;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        byte[] bArr;
        int i21;
        int i22;
        byte b10;
        byte[] bArr2;
        int iDecodeVarint64;
        int i23;
        int i24;
        MessageSchema<T> messageSchema2 = this;
        T t11 = message;
        byte[] bArr3 = data;
        limit = limit;
        endDelimited = endDelimited;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(message);
        Unsafe unsafe2 = UNSAFE;
        int iDecodeUnknownField = position;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = -1;
        int i29 = 1048575;
        while (true) {
            if (iDecodeUnknownField < limit) {
                int i30 = iDecodeUnknownField + 1;
                byte b11 = bArr3[iDecodeUnknownField];
                if (b11 < 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(b11, bArr3, i30, registers2);
                    i14 = registers2.int1;
                    i30 = iDecodeVarint32;
                } else {
                    i14 = b11;
                }
                int i31 = i14 >>> 3;
                int i32 = i14 & 7;
                int iPositionForFieldNumber = i31 > i28 ? messageSchema2.positionForFieldNumber(i31, i25 / 3) : messageSchema2.positionForFieldNumber(i31);
                if (iPositionForFieldNumber == -1) {
                    i15 = i31;
                    i16 = i30;
                    i11 = i14;
                    i17 = i27;
                    i18 = i29;
                    unsafe = unsafe2;
                    endDelimited = endDelimited;
                    i19 = 0;
                } else {
                    int i33 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i33);
                    long jOffset = offset(i33);
                    int i34 = i14;
                    if (iType <= 17) {
                        int i35 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i36 = 1 << (i35 >>> 20);
                        int i37 = 1048575;
                        int i38 = i35 & 1048575;
                        if (i38 != i29) {
                            if (i29 != 1048575) {
                                unsafe2.putInt(t11, i29, i27);
                                i37 = 1048575;
                            }
                            i18 = i38;
                            i20 = i38 == i37 ? 0 : unsafe2.getInt(t11, i38);
                        } else {
                            i20 = i27;
                            i18 = i29;
                        }
                        switch (iType) {
                            case 0:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 1) {
                                    UnsafeUtil.putDouble(t11, jOffset, ArrayDecoders.decodeDouble(bArr, i30));
                                    iDecodeUnknownField = i30 + 8;
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 1:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 5) {
                                    UnsafeUtil.putFloat(t11, jOffset, ArrayDecoders.decodeFloat(bArr, i30));
                                    iDecodeUnknownField = i30 + 4;
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 2:
                            case 3:
                                bArr2 = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i30, registers2);
                                    unsafe2.putLong(message, jOffset, registers2.long1);
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr2;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i30, registers2);
                                    unsafe2.putInt(t11, jOffset, registers2.int1);
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 1) {
                                    unsafe2.putLong(message, jOffset, ArrayDecoders.decodeFixed64(bArr, i30));
                                    iDecodeUnknownField = i30 + 8;
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 5) {
                                    unsafe2.putInt(t11, jOffset, ArrayDecoders.decodeFixed32(bArr, i30));
                                    iDecodeUnknownField = i30 + 4;
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 7:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr, i30, registers2);
                                    UnsafeUtil.putBoolean(t11, jOffset, registers2.long1 != 0);
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 8:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 2) {
                                    iDecodeUnknownField = isEnforceUtf8(i33) ? ArrayDecoders.decodeStringRequireUtf8(bArr, i30, registers2) : ArrayDecoders.decodeString(bArr, i30, registers2);
                                    unsafe2.putObject(t11, jOffset, registers2.object1);
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 9:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 2) {
                                    Object objMutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t11, i21);
                                    iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i21), data, i30, limit, registers);
                                    messageSchema2.storeMessageField(t11, i21, objMutableMessageFieldForMerge);
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 10:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 2) {
                                    iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr, i30, registers2);
                                    unsafe2.putObject(t11, jOffset, registers2.object1);
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 12:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i30, registers2);
                                    int i39 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i21);
                                    if (!isLegacyEnumIsClosed(i33) || enumFieldVerifier == null || enumFieldVerifier.isInRange(i39)) {
                                        unsafe2.putInt(t11, jOffset, i39);
                                        i27 = i20 | i36;
                                        i25 = i21;
                                        bArr3 = bArr;
                                        i26 = i22;
                                        i29 = i18;
                                        i28 = i15;
                                    } else {
                                        getMutableUnknownFields(message).storeField(i22, Long.valueOf(i39));
                                        endDelimited = endDelimited;
                                        i25 = i21;
                                        i27 = i20;
                                        i26 = i22;
                                        i29 = i18;
                                        i28 = i15;
                                        bArr3 = bArr;
                                    }
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 15:
                                bArr = data;
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                if (i32 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i30, registers2);
                                    unsafe2.putInt(t11, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 16:
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                bArr2 = data;
                                if (i32 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i30, registers2);
                                    unsafe2.putLong(message, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                    i27 = i20 | i36;
                                    i25 = i21;
                                    bArr3 = bArr2;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            case 17:
                                if (i32 == 3) {
                                    Object objMutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t11, iPositionForFieldNumber);
                                    i15 = i31;
                                    i22 = i34;
                                    iDecodeUnknownField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), data, i30, limit, (i31 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t11, iPositionForFieldNumber, objMutableMessageFieldForMerge2);
                                    i27 = i20 | i36;
                                    bArr3 = data;
                                    i25 = iPositionForFieldNumber;
                                    i26 = i22;
                                    i29 = i18;
                                    i28 = i15;
                                } else {
                                    i15 = i31;
                                    i22 = i34;
                                    b10 = -1;
                                    i21 = iPositionForFieldNumber;
                                    endDelimited = endDelimited;
                                    i16 = i30;
                                    i19 = i21;
                                    unsafe = unsafe2;
                                    i17 = i20;
                                    i11 = i22;
                                }
                                break;
                            default:
                                i15 = i31;
                                i21 = iPositionForFieldNumber;
                                i22 = i34;
                                b10 = -1;
                                endDelimited = endDelimited;
                                i16 = i30;
                                i19 = i21;
                                unsafe = unsafe2;
                                i17 = i20;
                                i11 = i22;
                                break;
                        }
                    } else {
                        i15 = i31;
                        int i40 = i29;
                        i17 = i27;
                        if (iType != 27) {
                            i18 = i40;
                            if (iType <= 49) {
                                int i41 = i30;
                                unsafe = unsafe2;
                                i19 = iPositionForFieldNumber;
                                i24 = i34;
                                iDecodeUnknownField = parseRepeatedField(message, data, i30, limit, i34, i15, i32, iPositionForFieldNumber, i33, iType, jOffset, registers);
                                if (iDecodeUnknownField != i41) {
                                    messageSchema2 = this;
                                    t11 = message;
                                    bArr3 = data;
                                    endDelimited = endDelimited;
                                    registers2 = registers;
                                    i26 = i24;
                                    i27 = i17;
                                    i25 = i19;
                                    i29 = i18;
                                    i28 = i15;
                                    unsafe2 = unsafe;
                                } else {
                                    i16 = iDecodeUnknownField;
                                    i11 = i24;
                                }
                            } else {
                                i23 = i30;
                                unsafe = unsafe2;
                                i19 = iPositionForFieldNumber;
                                i24 = i34;
                                if (iType != 50) {
                                    iDecodeUnknownField = parseOneofField(message, data, i23, limit, i24, i15, i32, i33, iType, jOffset, i19, registers);
                                    if (iDecodeUnknownField != i23) {
                                        messageSchema2 = this;
                                        t11 = message;
                                        bArr3 = data;
                                        endDelimited = endDelimited;
                                        registers2 = registers;
                                        i26 = i24;
                                        i27 = i17;
                                        i25 = i19;
                                        i29 = i18;
                                        i28 = i15;
                                        unsafe2 = unsafe;
                                    } else {
                                        i16 = iDecodeUnknownField;
                                        i11 = i24;
                                    }
                                } else if (i32 == 2) {
                                    iDecodeUnknownField = parseMapField(message, data, i23, limit, i19, jOffset, registers);
                                    if (iDecodeUnknownField != i23) {
                                        messageSchema2 = this;
                                        t11 = message;
                                        bArr3 = data;
                                        endDelimited = endDelimited;
                                        registers2 = registers;
                                        i26 = i24;
                                        i27 = i17;
                                        i25 = i19;
                                        i29 = i18;
                                        i28 = i15;
                                        unsafe2 = unsafe;
                                    } else {
                                        i16 = iDecodeUnknownField;
                                        i11 = i24;
                                    }
                                }
                            }
                        } else if (i32 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t11, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t11, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), i34, data, i30, limit, protobufListMutableCopyWithCapacity2, registers);
                            endDelimited = endDelimited;
                            i25 = iPositionForFieldNumber;
                            i26 = i34;
                            i27 = i17;
                            i29 = i40;
                            i28 = i15;
                            bArr3 = data;
                        } else {
                            i18 = i40;
                            i23 = i30;
                            unsafe = unsafe2;
                            i19 = iPositionForFieldNumber;
                            i24 = i34;
                        }
                        i16 = i23;
                        i11 = i24;
                    }
                }
                if (i11 != endDelimited || endDelimited == 0) {
                    iDecodeUnknownField = (!this.hasExtensions || registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) ? ArrayDecoders.decodeUnknownField(i11, data, i16, limit, getMutableUnknownFields(message), registers) : ArrayDecoders.decodeExtensionOrUnknownField(i11, data, i16, limit, message, this.defaultInstance, this.unknownFieldSchema, registers);
                    t11 = message;
                    bArr3 = data;
                    i26 = i11;
                    messageSchema2 = this;
                    registers2 = registers;
                    i27 = i17;
                    i25 = i19;
                    i29 = i18;
                    i28 = i15;
                    unsafe2 = unsafe;
                    endDelimited = endDelimited;
                } else {
                    i13 = 1048575;
                    messageSchema = this;
                    i10 = i16;
                    i27 = i17;
                    i12 = i18;
                }
            } else {
                int i42 = i29;
                unsafe = unsafe2;
                endDelimited = endDelimited;
                messageSchema = messageSchema2;
                i10 = iDecodeUnknownField;
                i11 = i26;
                i12 = i42;
                i13 = 1048575;
            }
        }
        if (i12 != i13) {
            t10 = message;
            unsafe.putInt(t10, i12, i27);
        } else {
            t10 = message;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i43 = messageSchema.checkInitializedCount; i43 < messageSchema.repeatedFieldOffsetStart; i43++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(message, messageSchema.intArray[i43], unknownFieldSetLite, messageSchema.unknownFieldSchema, message);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t10, unknownFieldSetLite);
        }
        if (endDelimited == 0) {
            if (i10 != limit) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i10 > limit || i11 != endDelimited) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i10;
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(message, writer);
        } else {
            writeFieldsInAscendingOrder(message, writer);
        }
    }

    private boolean isFieldPresent(T message, int pos) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos);
        long j10 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j10 != 1048575) {
            return ((1 << (iPresenceMaskAndOffsetAt >>> 20)) & UnsafeUtil.getInt(message, j10)) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(pos);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(message, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(message, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(message, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(message, jOffset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(message, jOffset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(message, jOffset));
            case 11:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(message, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private int positionForFieldNumber(final int number, final int min) {
        if (number < this.minFieldNumber || number > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(number, min);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws Throwable {
        extensionRegistry.getClass();
        checkMutable(message);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    private boolean equals(T message, T other, int pos) {
        int iTypeAndOffsetAt = typeAndOffsetAt(pos);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(message, other, pos) && Double.doubleToLongBits(UnsafeUtil.getDouble(message, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(other, jOffset));
            case 1:
                return arePresentForEquals(message, other, pos) && Float.floatToIntBits(UnsafeUtil.getFloat(message, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(other, jOffset));
            case 2:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 3:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 4:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 5:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 6:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 7:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getBoolean(message, jOffset) == UnsafeUtil.getBoolean(other, jOffset);
            case 8:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 9:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 10:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 11:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 12:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 13:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 14:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 15:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 16:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 17:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 51:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 68:
                return isOneofCaseEqual(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            default:
                return true;
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(message, data, position, limit, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object message, int typeAndOffset, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(message, offset(typeAndOffset)));
    }
}
