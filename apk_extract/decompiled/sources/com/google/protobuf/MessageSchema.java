package com.google.protobuf;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
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

    private MessageSchema(int[] iArr, Object[] objArr, int i8, int i9, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z2, int[] iArr2, int i10, int i11, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i8;
        this.maxFieldNumber = i9;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.syntax = protoSyntax;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i10;
        this.repeatedFieldOffsetStart = i11;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t3, T t8, int i8) {
        return isFieldPresent(t3, i8) == isFieldPresent(t8, i8);
    }

    private static <T> boolean booleanAt(T t3, long j8) {
        return UnsafeUtil.getBoolean(t3, j8);
    }

    private static void checkMutable(Object obj) {
        if (!isMutable(obj)) {
            throw new IllegalArgumentException(a.p(obj, "Mutating immutable message: "));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i8, int i9, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32;
        int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i8, registers);
        int i10 = registers.int1;
        if (i10 < 0 || i10 > i9 - iDecodeVarint33) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i11 = iDecodeVarint33 + i10;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint33 < i11) {
            int i12 = iDecodeVarint33 + 1;
            int i13 = bArr[iDecodeVarint33];
            if (i13 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i13, bArr, i12, registers);
                i13 = registers.int1;
            } else {
                iDecodeVarint32 = i12;
            }
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i14 != 1) {
                if (i14 == 2 && i15 == metadata.valueType.getWireType()) {
                    iDecodeVarint33 = decodeMapEntryValue(bArr, iDecodeVarint32, i9, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint33 = ArrayDecoders.skipField(i13, bArr, iDecodeVarint32, i9, registers);
                }
            } else if (i15 == metadata.keyType.getWireType()) {
                iDecodeVarint33 = decodeMapEntryValue(bArr, iDecodeVarint32, i9, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint33 = ArrayDecoders.skipField(i13, bArr, iDecodeVarint32, i9, registers);
            }
        }
        if (iDecodeVarint33 != i11) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i11;
    }

    private int decodeMapEntryValue(byte[] bArr, int i8, int i9, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i8, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i8, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i8));
                return i8 + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i8));
                return i8 + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i8));
                return i8 + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i8));
                return i8 + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i8, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i8, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint65;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i8, i9, registers);
            case 15:
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i8, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint33;
            case 16:
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i8, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint66;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i8, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t3, long j8) {
        return UnsafeUtil.getDouble(t3, j8);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i8, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i8);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i8)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i8)) == null) ? ub2 : (UB) filterUnknownEnumMap(i8, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub2, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i8, int i9, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i8));
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
                    unknownFieldSchema.addLengthDelimited(ub2, i9, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub2;
    }

    private static <T> float floatAt(T t3, long j8) {
        return UnsafeUtil.getFloat(t3, j8);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i8) {
        return (Internal.EnumVerifier) this.objects[((i8 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i8) {
        return this.objects[(i8 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i8) {
        int i9 = (i8 / 3) * 2;
        Schema schema = (Schema) this.objects[i9];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i9 + 1]);
        this.objects[i9] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t3));
    }

    private static <T> int intAt(T t3, long j8) {
        return UnsafeUtil.getInt(t3, j8);
    }

    private static boolean isEnforceUtf8(int i8) {
        return (i8 & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t3, int i8, int i9, int i10, int i11) {
        if (i9 == 1048575) {
            return isFieldPresent(t3, i8);
        }
        return (i10 & i11) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int i8) {
        return (i8 & Integer.MIN_VALUE) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i8, int i9) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i8));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i9);
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
    private boolean isMapInitialized(T t3, int i8, int i9) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t3, offset(i8)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i9)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
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

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t3, T t8, int i8) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i8) & 1048575;
        return UnsafeUtil.getInt(t3, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t8, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t3, int i8, int i9) {
        return UnsafeUtil.getInt(t3, (long) (presenceMaskAndOffsetAt(i9) & 1048575)) == i8;
    }

    private static boolean isRequired(int i8) {
        return (i8 & REQUIRED_MASK) != 0;
    }

    private static <T> long longAt(T t3, long j8) {
        return UnsafeUtil.getLong(t3, j8);
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
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        UnknownFieldSchema unknownFieldSchema2;
        T t8;
        int i8;
        Object objFilterMapUnknownEnumValues;
        T t10;
        Object mutableExtensions;
        ExtensionRegistryLite extensionRegistryLite2;
        int i9;
        Object objFilterMapUnknownEnumValues2;
        int i10;
        Object objFilterMapUnknownEnumValues3;
        Object obj;
        UnknownFieldSchema unknownFieldSchema3 = unknownFieldSchema;
        T t11 = t3;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite;
        Object builderFromMessage = null;
        Object obj2 = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    t8 = t11;
                    try {
                        int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                        try {
                            switch (type(iTypeAndOffsetAt)) {
                                case 0:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putDouble(t8, offset(iTypeAndOffsetAt), reader.readDouble());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 1:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putFloat(t8, offset(iTypeAndOffsetAt), reader.readFloat());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 2:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t8, offset(iTypeAndOffsetAt), reader.readInt64());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 3:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t8, offset(iTypeAndOffsetAt), reader.readUInt64());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 4:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t8, offset(iTypeAndOffsetAt), reader.readInt32());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 5:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t8, offset(iTypeAndOffsetAt), reader.readFixed64());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 6:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t8, offset(iTypeAndOffsetAt), reader.readFixed32());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 7:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putBoolean(t8, offset(iTypeAndOffsetAt), reader.readBool());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 8:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readString(t8, iTypeAndOffsetAt, reader);
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 9:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    MessageLite messageLite = (MessageLite) mutableMessageFieldForMerge(t8, iPositionForFieldNumber);
                                    reader.mergeMessageField(messageLite, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                    storeMessageField(t8, iPositionForFieldNumber, messageLite);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 10:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), reader.readBytes());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 11:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t8, offset(iTypeAndOffsetAt), reader.readUInt32());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 12:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    int i11 = reader.readEnum();
                                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i11)) {
                                        UnsafeUtil.putInt(t8, offset(iTypeAndOffsetAt), i11);
                                        setFieldPresent(t8, iPositionForFieldNumber);
                                        builderFromMessage = obj;
                                    } else {
                                        builderFromMessage = SchemaUtil.storeUnknownEnum(t8, fieldNumber, i11, obj, unknownFieldSchema2);
                                    }
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 13:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t8, offset(iTypeAndOffsetAt), reader.readSFixed32());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 14:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t8, offset(iTypeAndOffsetAt), reader.readSFixed64());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 15:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putInt(t8, offset(iTypeAndOffsetAt), reader.readSInt32());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 16:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    UnsafeUtil.putLong(t8, offset(iTypeAndOffsetAt), reader.readSInt64());
                                    setFieldPresent(t8, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 17:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    MessageLite messageLite2 = (MessageLite) mutableMessageFieldForMerge(t8, iPositionForFieldNumber);
                                    reader.mergeGroupField(messageLite2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                    storeMessageField(t8, iPositionForFieldNumber, messageLite2);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 18:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readDoubleList(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 19:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFloatList(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 20:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 21:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 22:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 23:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 24:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 25:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBoolList(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 26:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readStringList(t8, iTypeAndOffsetAt, reader);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 27:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    readMessageList(t3, iTypeAndOffsetAt, reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 28:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBytesList(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 29:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    List<Integer> listMutableListAt = this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt));
                                    reader.readEnumList(listMutableListAt);
                                    builderFromMessage = SchemaUtil.filterUnknownEnumList(t3, fieldNumber, listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 31:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 32:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 33:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 34:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 35:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readDoubleList(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 36:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFloatList(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 37:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 38:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 39:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readInt32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 40:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 41:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readFixed32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 42:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readBoolList(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 43:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readUInt32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 44:
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    List<Integer> listMutableListAt2 = this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt));
                                    reader.readEnumList(listMutableListAt2);
                                    builderFromMessage = SchemaUtil.filterUnknownEnumList(t3, fieldNumber, listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 45:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 46:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSFixed64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 47:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt32List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    reader.readSInt64List(this.listFieldSchema.mutableListAt(t8, offset(iTypeAndOffsetAt)));
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    try {
                                        readGroupList(t3, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                        builderFromMessage = obj;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                        builderFromMessage = obj;
                                        try {
                                            if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t8);
                                                }
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                                    objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                    for (i9 = this.checkInitializedCount; i9 < this.repeatedFieldOffsetStart; i9++) {
                                                        objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t3, this.intArray[i9], objFilterMapUnknownEnumValues2, unknownFieldSchema, t3);
                                                    }
                                                    if (objFilterMapUnknownEnumValues2 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (!reader.skipField()) {
                                                objFilterMapUnknownEnumValues3 = builderFromMessage;
                                                for (i10 = this.checkInitializedCount; i10 < this.repeatedFieldOffsetStart; i10++) {
                                                    objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t3, this.intArray[i10], objFilterMapUnknownEnumValues3, unknownFieldSchema, t3);
                                                }
                                                if (objFilterMapUnknownEnumValues3 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues3);
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
                                        for (i8 = this.checkInitializedCount; i8 < this.repeatedFieldOffsetStart; i8++) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t3, this.intArray[i8], objFilterMapUnknownEnumValues, unknownFieldSchema, t3);
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues);
                                        }
                                        throw th;
                                    }
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 50:
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    try {
                                        mergeMap(t3, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite, reader);
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                        if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            if (builderFromMessage == null) {
                                                builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t8);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                                objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                while (i9 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t3, this.intArray[i9], objFilterMapUnknownEnumValues2, unknownFieldSchema, t3);
                                                }
                                                if (objFilterMapUnknownEnumValues2 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues2);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!reader.skipField()) {
                                            objFilterMapUnknownEnumValues3 = builderFromMessage;
                                            while (i10 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t3, this.intArray[i10], objFilterMapUnknownEnumValues3, unknownFieldSchema, t3);
                                            }
                                            if (objFilterMapUnknownEnumValues3 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues3);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        builderFromMessage = obj;
                                        objFilterMapUnknownEnumValues = builderFromMessage;
                                        while (i8 < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t3, this.intArray[i8], objFilterMapUnknownEnumValues, unknownFieldSchema, t3);
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues);
                                        }
                                        throw th;
                                    }
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 51:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Double.valueOf(reader.readDouble()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Float.valueOf(reader.readFloat()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Long.valueOf(reader.readInt64()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Long.valueOf(reader.readUInt64()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readInt32()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 56:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Long.valueOf(reader.readFixed64()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 57:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readFixed32()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 58:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Boolean.valueOf(reader.readBool()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 59:
                                    readString(t8, iTypeAndOffsetAt, reader);
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 60:
                                    MessageLite messageLite3 = (MessageLite) mutableOneofMessageFieldForMerge(t8, fieldNumber, iPositionForFieldNumber);
                                    reader.mergeMessageField(messageLite3, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                    storeOneofMessageField(t8, fieldNumber, iPositionForFieldNumber, messageLite3);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 61:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), reader.readBytes());
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 62:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readUInt32()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                    int i12 = reader.readEnum();
                                    Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                                    if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(i12)) {
                                        builderFromMessage = SchemaUtil.storeUnknownEnum(t8, fieldNumber, i12, builderFromMessage, unknownFieldSchema3);
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        t11 = t8;
                                        extensionRegistryLite3 = extensionRegistryLite2;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                    }
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Integer.valueOf(i12));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 64:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSFixed32()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSFixed64()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSInt32()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                                    UnsafeUtil.putObject(t8, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSInt64()));
                                    setOneofPresent(t8, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                case 68:
                                    MessageLite messageLite4 = (MessageLite) mutableOneofMessageFieldForMerge(t8, fieldNumber, iPositionForFieldNumber);
                                    reader.mergeGroupField(messageLite4, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                    storeOneofMessageField(t8, fieldNumber, iPositionForFieldNumber, messageLite4);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                    break;
                                default:
                                    if (builderFromMessage == null) {
                                        try {
                                            builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t8);
                                            break;
                                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                            extensionRegistryLite2 = extensionRegistryLite3;
                                            unknownFieldSchema2 = unknownFieldSchema3;
                                            if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                                if (builderFromMessage == null) {
                                                    builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t8);
                                                }
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                                    objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                    while (i9 < this.repeatedFieldOffsetStart) {
                                                        objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t3, this.intArray[i9], objFilterMapUnknownEnumValues2, unknownFieldSchema, t3);
                                                    }
                                                    if (objFilterMapUnknownEnumValues2 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues2);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (!reader.skipField()) {
                                                objFilterMapUnknownEnumValues3 = builderFromMessage;
                                                while (i10 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t3, this.intArray[i10], objFilterMapUnknownEnumValues3, unknownFieldSchema, t3);
                                                }
                                                if (objFilterMapUnknownEnumValues3 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues3);
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            unknownFieldSchema2 = unknownFieldSchema3;
                                            objFilterMapUnknownEnumValues = builderFromMessage;
                                            while (i8 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t3, this.intArray[i8], objFilterMapUnknownEnumValues, unknownFieldSchema, t3);
                                            }
                                            if (objFilterMapUnknownEnumValues != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader)) {
                                        Object objFilterMapUnknownEnumValues4 = builderFromMessage;
                                        for (int i13 = this.checkInitializedCount; i13 < this.repeatedFieldOffsetStart; i13++) {
                                            objFilterMapUnknownEnumValues4 = filterMapUnknownEnumValues(t3, this.intArray[i13], objFilterMapUnknownEnumValues4, unknownFieldSchema, t3);
                                        }
                                        if (objFilterMapUnknownEnumValues4 != null) {
                                            unknownFieldSchema3.setBuilderToMessage(t8, objFilterMapUnknownEnumValues4);
                                            return;
                                        }
                                        return;
                                    }
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    t11 = t8;
                                    extensionRegistryLite3 = extensionRegistryLite2;
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
                        for (int i14 = this.checkInitializedCount; i14 < this.repeatedFieldOffsetStart; i14++) {
                            objFilterMapUnknownEnumValues5 = filterMapUnknownEnumValues(t3, this.intArray[i14], objFilterMapUnknownEnumValues5, unknownFieldSchema, t3);
                        }
                        if (objFilterMapUnknownEnumValues5 != null) {
                            unknownFieldSchema3.setBuilderToMessage(t11, objFilterMapUnknownEnumValues5);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objFindExtensionByNumber = !this.hasExtensions ? null : extensionSchema.findExtensionByNumber(extensionRegistryLite3, this.defaultInstance, fieldNumber);
                        if (objFindExtensionByNumber != null) {
                            if (obj2 == null) {
                                try {
                                    mutableExtensions = extensionSchema.getMutableExtensions(t3);
                                } catch (Throwable th7) {
                                    th = th7;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    t8 = t11;
                                    objFilterMapUnknownEnumValues = builderFromMessage;
                                    while (i8 < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t3, this.intArray[i8], objFilterMapUnknownEnumValues, unknownFieldSchema, t3);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                            } else {
                                mutableExtensions = obj2;
                            }
                            t10 = t11;
                            try {
                                builderFromMessage = extensionSchema.parseExtension(t3, reader, objFindExtensionByNumber, extensionRegistryLite, mutableExtensions, builderFromMessage, unknownFieldSchema);
                                obj2 = mutableExtensions;
                            } catch (Throwable th8) {
                                th = th8;
                                t8 = t10;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                objFilterMapUnknownEnumValues = builderFromMessage;
                                while (i8 < this.repeatedFieldOffsetStart) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t3, this.intArray[i8], objFilterMapUnknownEnumValues, unknownFieldSchema, t3);
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                    unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues);
                                }
                                throw th;
                            }
                        } else {
                            t10 = t11;
                            if (!unknownFieldSchema3.shouldDiscardUnknownFields(reader)) {
                                if (builderFromMessage == null) {
                                    builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t10);
                                }
                                if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader)) {
                                }
                            } else if (!reader.skipField()) {
                            }
                        }
                        t11 = t10;
                    } catch (Throwable th9) {
                        th = th9;
                        t8 = t11;
                    }
                }
            } catch (Throwable th10) {
                th = th10;
            }
            objFilterMapUnknownEnumValues = builderFromMessage;
            while (i8 < this.repeatedFieldOffsetStart) {
                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t3, this.intArray[i8], objFilterMapUnknownEnumValues, unknownFieldSchema, t3);
            }
            if (objFilterMapUnknownEnumValues != null) {
                unknownFieldSchema2.setBuilderToMessage(t8, objFilterMapUnknownEnumValues);
            }
            throw th;
        }
        int i15 = this.checkInitializedCount;
        Object objFilterMapUnknownEnumValues6 = builderFromMessage;
        while (i15 < this.repeatedFieldOffsetStart) {
            objFilterMapUnknownEnumValues6 = filterMapUnknownEnumValues(t3, this.intArray[i15], objFilterMapUnknownEnumValues6, unknownFieldSchema, t3);
            i15++;
            t10 = t10;
        }
        T t12 = t10;
        if (objFilterMapUnknownEnumValues6 != null) {
            unknownFieldSchema3.setBuilderToMessage(t12, objFilterMapUnknownEnumValues6);
        }
    }

    private final <K, V> void mergeMap(Object obj, int i8, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(i8));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t3, T t8, int i8) {
        if (isFieldPresent(t8, i8)) {
            long jOffset = offset(typeAndOffsetAt(i8));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t8, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i8) + " is present but null: " + t8);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i8);
            if (!isFieldPresent(t3, i8)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t3, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t3, jOffset, object);
                }
                setFieldPresent(t3, i8);
                return;
            }
            Object object2 = unsafe.getObject(t3, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t3, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t3, T t8, int i8) {
        int iNumberAt = numberAt(i8);
        if (isOneofPresent(t8, iNumberAt, i8)) {
            long jOffset = offset(typeAndOffsetAt(i8));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t8, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i8) + " is present but null: " + t8);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i8);
            if (!isOneofPresent(t3, iNumberAt, i8)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t3, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t3, jOffset, object);
                }
                setOneofPresent(t3, iNumberAt, i8);
                return;
            }
            Object object2 = unsafe.getObject(t3, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t3, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t3, T t8, int i8) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i8);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i8);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putDouble(t3, jOffset, UnsafeUtil.getDouble(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 1:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putFloat(t3, jOffset, UnsafeUtil.getFloat(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 2:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putLong(t3, jOffset, UnsafeUtil.getLong(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 3:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putLong(t3, jOffset, UnsafeUtil.getLong(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 4:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putInt(t3, jOffset, UnsafeUtil.getInt(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 5:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putLong(t3, jOffset, UnsafeUtil.getLong(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 6:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putInt(t3, jOffset, UnsafeUtil.getInt(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 7:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putBoolean(t3, jOffset, UnsafeUtil.getBoolean(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 8:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putObject(t3, jOffset, UnsafeUtil.getObject(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 9:
                mergeMessage(t3, t8, i8);
                break;
            case 10:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putObject(t3, jOffset, UnsafeUtil.getObject(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 11:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putInt(t3, jOffset, UnsafeUtil.getInt(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 12:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putInt(t3, jOffset, UnsafeUtil.getInt(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 13:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putInt(t3, jOffset, UnsafeUtil.getInt(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 14:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putLong(t3, jOffset, UnsafeUtil.getLong(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 15:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putInt(t3, jOffset, UnsafeUtil.getInt(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 16:
                if (isFieldPresent(t8, i8)) {
                    UnsafeUtil.putLong(t3, jOffset, UnsafeUtil.getLong(t8, jOffset));
                    setFieldPresent(t3, i8);
                }
                break;
            case 17:
                mergeMessage(t3, t8, i8);
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                this.listFieldSchema.mergeListsAt(t3, t8, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t3, t8, jOffset);
                break;
            case 51:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t8, iNumberAt, i8)) {
                    UnsafeUtil.putObject(t3, jOffset, UnsafeUtil.getObject(t8, jOffset));
                    setOneofPresent(t3, iNumberAt, i8);
                }
                break;
            case 60:
                mergeOneofMessage(t3, t8, i8);
                break;
            case 61:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (isOneofPresent(t8, iNumberAt, i8)) {
                    UnsafeUtil.putObject(t3, jOffset, UnsafeUtil.getObject(t8, jOffset));
                    setOneofPresent(t3, iNumberAt, i8);
                }
                break;
            case 68:
                mergeOneofMessage(t3, t8, i8);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t3, int i8) {
        Schema messageFieldSchema = getMessageFieldSchema(i8);
        long jOffset = offset(typeAndOffsetAt(i8));
        if (!isFieldPresent(t3, i8)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t3, jOffset);
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
    private Object mutableOneofMessageFieldForMerge(T t3, int i8, int i9) {
        Schema messageFieldSchema = getMessageFieldSchema(i9);
        if (!isOneofPresent(t3, i8, i9)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t3, offset(typeAndOffsetAt(i9)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        FieldInfo[] fields = structuralMessageInfo.getFields();
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
        int i8 = 0;
        int i9 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i8++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i9++;
            }
        }
        int[] iArr2 = i8 > 0 ? new int[i8] : null;
        int[] iArr3 = i9 > 0 ? new int[i9] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i10 < fields.length) {
            FieldInfo fieldInfo2 = fields[i10];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i11, objArr);
            if (i12 < checkInitialized.length && checkInitialized[i12] == fieldNumber3) {
                checkInitialized[i12] = i11;
                i12++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i13] = i11;
                i13++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    iArr3[i14] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i14++;
                }
                i10++;
                i11 += 3;
            }
            i10++;
            i11 += 3;
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
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), structuralMessageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0249  */
    /* JADX WARN: Code duplicated, block: B:123:0x024e  */
    /* JADX WARN: Code duplicated, block: B:126:0x0264  */
    /* JADX WARN: Code duplicated, block: B:127:0x0267  */
    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i8;
        int iCharAt;
        int iCharAt2;
        int i9;
        int i10;
        int[] iArr;
        int i11;
        int i12;
        int i13;
        int i14;
        char cCharAt;
        int i15;
        char cCharAt2;
        int i16;
        char cCharAt3;
        int i17;
        char cCharAt4;
        int i18;
        char cCharAt5;
        int i19;
        char cCharAt6;
        int i20;
        char cCharAt7;
        int i21;
        char cCharAt8;
        int i22;
        int i23;
        int i24;
        int i25;
        int iObjectFieldOffset;
        int i26;
        int i27;
        int iObjectFieldOffset2;
        java.lang.reflect.Field fieldReflectField;
        int i28;
        char cCharAt9;
        int i29;
        int i30;
        int i31;
        Object obj;
        java.lang.reflect.Field fieldReflectField2;
        int i32;
        Object obj2;
        java.lang.reflect.Field fieldReflectField3;
        int i33;
        char cCharAt10;
        int i34;
        char cCharAt11;
        int i35;
        char cCharAt12;
        int i36;
        char cCharAt13;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        char c9 = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i37 = 1;
            while (true) {
                i8 = i37 + 1;
                if (stringInfo.charAt(i37) < 55296) {
                    break;
                }
                i37 = i8;
            }
        } else {
            i8 = 1;
        }
        int i38 = i8 + 1;
        int iCharAt3 = stringInfo.charAt(i8);
        if (iCharAt3 >= 55296) {
            int i39 = iCharAt3 & 8191;
            int i40 = 13;
            while (true) {
                i36 = i38 + 1;
                cCharAt13 = stringInfo.charAt(i38);
                if (cCharAt13 < 55296) {
                    break;
                }
                i39 |= (cCharAt13 & 8191) << i40;
                i40 += 13;
                i38 = i36;
            }
            iCharAt3 = i39 | (cCharAt13 << i40);
            i38 = i36;
        }
        if (iCharAt3 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            i12 = 0;
            i13 = 0;
            i9 = 0;
            i11 = 0;
            iArr = EMPTY_INT_ARRAY;
            i10 = 0;
        } else {
            int i41 = i38 + 1;
            int iCharAt4 = stringInfo.charAt(i38);
            if (iCharAt4 >= 55296) {
                int i42 = iCharAt4 & 8191;
                int i43 = 13;
                while (true) {
                    i21 = i41 + 1;
                    cCharAt8 = stringInfo.charAt(i41);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt8 & 8191) << i43;
                    i43 += 13;
                    i41 = i21;
                }
                iCharAt4 = i42 | (cCharAt8 << i43);
                i41 = i21;
            }
            int i44 = i41 + 1;
            int iCharAt5 = stringInfo.charAt(i41);
            if (iCharAt5 >= 55296) {
                int i45 = iCharAt5 & 8191;
                int i46 = 13;
                while (true) {
                    i20 = i44 + 1;
                    cCharAt7 = stringInfo.charAt(i44);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt7 & 8191) << i46;
                    i46 += 13;
                    i44 = i20;
                }
                iCharAt5 = i45 | (cCharAt7 << i46);
                i44 = i20;
            }
            int i47 = i44 + 1;
            int iCharAt6 = stringInfo.charAt(i44);
            if (iCharAt6 >= 55296) {
                int i48 = iCharAt6 & 8191;
                int i49 = 13;
                while (true) {
                    i19 = i47 + 1;
                    cCharAt6 = stringInfo.charAt(i47);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt6 & 8191) << i49;
                    i49 += 13;
                    i47 = i19;
                }
                iCharAt6 = i48 | (cCharAt6 << i49);
                i47 = i19;
            }
            int i50 = i47 + 1;
            int iCharAt7 = stringInfo.charAt(i47);
            if (iCharAt7 >= 55296) {
                int i51 = iCharAt7 & 8191;
                int i52 = 13;
                while (true) {
                    i18 = i50 + 1;
                    cCharAt5 = stringInfo.charAt(i50);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt5 & 8191) << i52;
                    i52 += 13;
                    i50 = i18;
                }
                iCharAt7 = i51 | (cCharAt5 << i52);
                i50 = i18;
            }
            int i53 = i50 + 1;
            iCharAt = stringInfo.charAt(i50);
            if (iCharAt >= 55296) {
                int i54 = iCharAt & 8191;
                int i55 = 13;
                while (true) {
                    i17 = i53 + 1;
                    cCharAt4 = stringInfo.charAt(i53);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt4 & 8191) << i55;
                    i55 += 13;
                    i53 = i17;
                }
                iCharAt = i54 | (cCharAt4 << i55);
                i53 = i17;
            }
            int i56 = i53 + 1;
            iCharAt2 = stringInfo.charAt(i53);
            if (iCharAt2 >= 55296) {
                int i57 = iCharAt2 & 8191;
                int i58 = 13;
                while (true) {
                    i16 = i56 + 1;
                    cCharAt3 = stringInfo.charAt(i56);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt3 & 8191) << i58;
                    i58 += 13;
                    i56 = i16;
                }
                iCharAt2 = i57 | (cCharAt3 << i58);
                i56 = i16;
            }
            int i59 = i56 + 1;
            int iCharAt8 = stringInfo.charAt(i56);
            if (iCharAt8 >= 55296) {
                int i60 = iCharAt8 & 8191;
                int i61 = 13;
                while (true) {
                    i15 = i59 + 1;
                    cCharAt2 = stringInfo.charAt(i59);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt2 & 8191) << i61;
                    i61 += 13;
                    i59 = i15;
                }
                iCharAt8 = i60 | (cCharAt2 << i61);
                i59 = i15;
            }
            int i62 = i59 + 1;
            int iCharAt9 = stringInfo.charAt(i59);
            if (iCharAt9 >= 55296) {
                int i63 = iCharAt9 & 8191;
                int i64 = 13;
                while (true) {
                    i14 = i62 + 1;
                    cCharAt = stringInfo.charAt(i62);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i63 |= (cCharAt & 8191) << i64;
                    i64 += 13;
                    i62 = i14;
                }
                iCharAt9 = i63 | (cCharAt << i64);
                i62 = i14;
            }
            i9 = (iCharAt4 * 2) + iCharAt5;
            i10 = iCharAt4;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i11 = iCharAt9;
            i38 = i62;
            i12 = iCharAt6;
            i13 = iCharAt7;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[iCharAt * 2];
        int i65 = i11 + iCharAt2;
        int i66 = i11;
        int i67 = i65;
        int i68 = 0;
        int i69 = 0;
        while (i38 < length) {
            int i70 = i38 + 1;
            int iCharAt10 = stringInfo.charAt(i38);
            if (iCharAt10 >= c9) {
                int i71 = iCharAt10 & 8191;
                int i72 = i70;
                int i73 = 13;
                while (true) {
                    i35 = i72 + 1;
                    cCharAt12 = stringInfo.charAt(i72);
                    if (cCharAt12 < c9) {
                        break;
                    }
                    i71 |= (cCharAt12 & 8191) << i73;
                    i73 += 13;
                    i72 = i35;
                }
                iCharAt10 = i71 | (cCharAt12 << i73);
                i22 = i35;
            } else {
                i22 = i70;
            }
            int i74 = i22 + 1;
            int iCharAt11 = stringInfo.charAt(i22);
            if (iCharAt11 >= c9) {
                int i75 = iCharAt11 & 8191;
                int i76 = i74;
                int i77 = 13;
                while (true) {
                    i34 = i76 + 1;
                    cCharAt11 = stringInfo.charAt(i76);
                    if (cCharAt11 < c9) {
                        break;
                    }
                    i75 |= (cCharAt11 & 8191) << i77;
                    i77 += 13;
                    i76 = i34;
                }
                iCharAt11 = i75 | (cCharAt11 << i77);
                i23 = i34;
            } else {
                i23 = i74;
            }
            int i78 = iCharAt11 & 255;
            int i79 = length;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i68] = i69;
                i68++;
            }
            int i80 = i68;
            if (i78 >= 51) {
                int i81 = i23 + 1;
                int iCharAt12 = stringInfo.charAt(i23);
                char c10 = 55296;
                if (iCharAt12 >= 55296) {
                    int i82 = iCharAt12 & 8191;
                    int i83 = 13;
                    while (true) {
                        i33 = i81 + 1;
                        cCharAt10 = stringInfo.charAt(i81);
                        if (cCharAt10 < c10) {
                            break;
                        }
                        i82 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i81 = i33;
                        c10 = 55296;
                    }
                    iCharAt12 = i82 | (cCharAt10 << i83);
                    i81 = i33;
                }
                int i84 = i78 - 51;
                int i85 = i81;
                if (i84 == 9 || i84 == 17) {
                    i30 = i9 + 1;
                    objArr[((i69 / 3) * 2) + 1] = objects[i9];
                } else {
                    if (i84 == 12 && (rawMessageInfo.getSyntax().equals(ProtoSyntax.PROTO2) || (iCharAt11 & 2048) != 0)) {
                        i30 = i9 + 1;
                        objArr[((i69 / 3) * 2) + 1] = objects[i9];
                    }
                    i31 = iCharAt12 * 2;
                    obj = objects[i31];
                    if (obj instanceof java.lang.reflect.Field) {
                        fieldReflectField2 = (java.lang.reflect.Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i31] = fieldReflectField2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    i32 = i31 + 1;
                    obj2 = objects[i32];
                    if (obj2 instanceof java.lang.reflect.Field) {
                        fieldReflectField3 = (java.lang.reflect.Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i32] = fieldReflectField3;
                    }
                    i25 = i13;
                    i24 = i9;
                    i26 = i85;
                    stringInfo = stringInfo;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    i27 = 0;
                }
                i9 = i30;
                i31 = iCharAt12 * 2;
                obj = objects[i31];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i31] = fieldReflectField2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                i32 = i31 + 1;
                obj2 = objects[i32];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i32] = fieldReflectField3;
                }
                i25 = i13;
                i24 = i9;
                i26 = i85;
                stringInfo = stringInfo;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField3);
                i27 = 0;
            } else {
                i24 = i9 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i9]);
                if (i78 == 9 || i78 == 17) {
                    i25 = i13;
                    objArr[((i69 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i78 == 27 || i78 == 49) {
                        i25 = i13;
                        i29 = i9 + 2;
                        objArr[((i69 / 3) * 2) + 1] = objects[i24];
                    } else if (i78 == 12 || i78 == 30 || i78 == 44) {
                        i25 = i13;
                        if (rawMessageInfo.getSyntax() == ProtoSyntax.PROTO2 || (iCharAt11 & 2048) != 0) {
                            i29 = i9 + 2;
                            objArr[((i69 / 3) * 2) + 1] = objects[i24];
                        }
                    } else {
                        if (i78 == 50) {
                            int i86 = i66 + 1;
                            iArr[i66] = i69;
                            int i87 = (i69 / 3) * 2;
                            int i88 = i9 + 2;
                            objArr[i87] = objects[i24];
                            if ((iCharAt11 & 2048) != 0) {
                                i24 = i9 + 3;
                                objArr[i87 + 1] = objects[i88];
                                i66 = i86;
                            } else {
                                i66 = i86;
                                i24 = i88;
                            }
                        }
                        i25 = i13;
                    }
                    i24 = i29;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt11 & 4096) == 0 || i78 > 17) {
                    iObjectFieldOffset = 1048575;
                    i26 = i23;
                    i27 = 0;
                } else {
                    i26 = i23 + 1;
                    int iCharAt13 = stringInfo.charAt(i23);
                    if (iCharAt13 >= 55296) {
                        int i89 = iCharAt13 & 8191;
                        int i90 = 13;
                        while (true) {
                            i28 = i26 + 1;
                            cCharAt9 = stringInfo.charAt(i26);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i89 |= (cCharAt9 & 8191) << i90;
                            i90 += 13;
                            i26 = i28;
                        }
                        iCharAt13 = i89 | (cCharAt9 << i90);
                        i26 = i28;
                    }
                    int i91 = (iCharAt13 / 32) + (i10 * 2);
                    Object obj3 = objects[i91];
                    if (obj3 instanceof java.lang.reflect.Field) {
                        fieldReflectField = (java.lang.reflect.Field) obj3;
                    } else {
                        fieldReflectField = reflectField(cls, (String) obj3);
                        objects[i91] = fieldReflectField;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField);
                    i27 = iCharAt13 % 32;
                }
                if (i78 >= 18 && i78 <= 49) {
                    iArr[i67] = iObjectFieldOffset3;
                    i67++;
                }
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i92 = i69 + 1;
            iArr2[i69] = iCharAt10;
            int i93 = i69 + 2;
            int i94 = i10;
            iArr2[i92] = iObjectFieldOffset2 | (i78 << 20) | ((iCharAt11 & 256) != 0 ? REQUIRED_MASK : 0) | ((iCharAt11 & 512) != 0 ? ENFORCE_UTF8_MASK : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0);
            i69 += 3;
            iArr2[i93] = iObjectFieldOffset | (i27 << 20);
            i38 = i26;
            stringInfo = stringInfo;
            i9 = i24;
            length = i79;
            i13 = i25;
            i68 = i80;
            i10 = i94;
            i12 = i12;
            c9 = 55296;
        }
        return new MessageSchema<>(iArr2, objArr, i12, i13, rawMessageInfo.getDefaultInstance(), rawMessageInfo.getSyntax(), false, iArr, i11, i65, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int i8) {
        return this.buffer[i8];
    }

    private static long offset(int i8) {
        return i8 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t3, long j8) {
        return ((Boolean) UnsafeUtil.getObject(t3, j8)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t3, long j8) {
        return ((Double) UnsafeUtil.getObject(t3, j8)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t3, long j8) {
        return ((Float) UnsafeUtil.getObject(t3, j8)).floatValue();
    }

    private static <T> int oneofIntAt(T t3, long j8) {
        return ((Integer) UnsafeUtil.getObject(t3, j8)).intValue();
    }

    private static <T> long oneofLongAt(T t3, long j8) {
        return ((Long) UnsafeUtil.getObject(t3, j8)).longValue();
    }

    private <K, V> int parseMapField(T t3, byte[] bArr, int i8, int i9, int i10, long j8, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i10);
        Object object = unsafe.getObject(t3, j8);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t3, j8, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i8, i9, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t3, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j8, int i15, ArrayDecoders.Registers registers) throws IOException {
        int iMergeMessageField;
        Unsafe unsafe = UNSAFE;
        long j10 = this.buffer[i15 + 2] & 1048575;
        switch (i14) {
            case 51:
                if (i12 != 1) {
                    return i8;
                }
                unsafe.putObject(t3, j8, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i8)));
                int i16 = i8 + 8;
                unsafe.putInt(t3, j10, i11);
                return i16;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                if (i12 != 5) {
                    return i8;
                }
                unsafe.putObject(t3, j8, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i8)));
                int i17 = i8 + 4;
                unsafe.putInt(t3, j10, i11);
                return i17;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                if (i12 != 0) {
                    return i8;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i8, registers);
                unsafe.putObject(t3, j8, Long.valueOf(registers.long1));
                unsafe.putInt(t3, j10, i11);
                return iDecodeVarint64;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 62:
                if (i12 != 0) {
                    return i8;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i8, registers);
                unsafe.putObject(t3, j8, Integer.valueOf(registers.int1));
                unsafe.putInt(t3, j10, i11);
                return iDecodeVarint32;
            case 56:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                if (i12 != 1) {
                    return i8;
                }
                unsafe.putObject(t3, j8, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i8)));
                int i18 = i8 + 8;
                unsafe.putInt(t3, j10, i11);
                return i18;
            case 57:
            case 64:
                if (i12 != 5) {
                    return i8;
                }
                unsafe.putObject(t3, j8, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i8)));
                int i19 = i8 + 4;
                unsafe.putInt(t3, j10, i11);
                return i19;
            case 58:
                if (i12 != 0) {
                    return i8;
                }
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i8, registers);
                unsafe.putObject(t3, j8, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t3, j10, i11);
                return iDecodeVarint65;
            case 59:
                if (i12 != 2) {
                    return i8;
                }
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i8, registers);
                int i20 = registers.int1;
                if (i20 == 0) {
                    unsafe.putObject(t3, j8, "");
                } else {
                    if ((i13 & ENFORCE_UTF8_MASK) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint33, iDecodeVarint33 + i20)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t3, j8, new String(bArr, iDecodeVarint33, i20, Internal.UTF_8));
                    iDecodeVarint33 += i20;
                }
                unsafe.putInt(t3, j10, i11);
                return iDecodeVarint33;
            case 60:
                if (i12 != 2) {
                    return i8;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t3, i11, i15);
                iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(i15), bArr, i8, i9, registers);
                storeOneofMessageField(t3, i11, i15, objMutableOneofMessageFieldForMerge);
                break;
                break;
            case 61:
                if (i12 != 2) {
                    return i8;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i8, registers);
                unsafe.putObject(t3, j8, registers.object1);
                unsafe.putInt(t3, j10, i11);
                return iDecodeBytes;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                if (i12 != 0) {
                    return i8;
                }
                int iDecodeVarint34 = ArrayDecoders.decodeVarint32(bArr, i8, registers);
                int i21 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i15);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i21)) {
                    unsafe.putObject(t3, j8, Integer.valueOf(i21));
                    unsafe.putInt(t3, j10, i11);
                } else {
                    getMutableUnknownFields(t3).storeField(i10, Long.valueOf(i21));
                }
                return iDecodeVarint34;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (i12 != 0) {
                    return i8;
                }
                int iDecodeVarint35 = ArrayDecoders.decodeVarint32(bArr, i8, registers);
                unsafe.putObject(t3, j8, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t3, j10, i11);
                return iDecodeVarint35;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (i12 != 0) {
                    return i8;
                }
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i8, registers);
                unsafe.putObject(t3, j8, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t3, j10, i11);
                return iDecodeVarint66;
            case 68:
                if (i12 != 3) {
                    return i8;
                }
                Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t3, i11, i15);
                iMergeMessageField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(i15), bArr, i8, i9, (i10 & (-8)) | 4, registers);
                storeOneofMessageField(t3, i11, i15, objMutableOneofMessageFieldForMerge2);
                break;
                break;
            default:
                return i8;
        }
        return iMergeMessageField;
    }

    private int parseRepeatedField(T t3, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, long j8, int i14, long j10, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t3, j10);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t3, j10, protobufListMutableCopyWithCapacity2);
        }
        switch (i14) {
            case 18:
            case 35:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 1 ? ArrayDecoders.decodeDoubleList(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 19:
            case 36:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 5 ? ArrayDecoders.decodeFloatList(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 0 ? ArrayDecoders.decodeVarint64List(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 0 ? ArrayDecoders.decodeVarint32List(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 1 ? ArrayDecoders.decodeFixed64List(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 5 ? ArrayDecoders.decodeFixed32List(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 25:
            case 42:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 0 ? ArrayDecoders.decodeBoolList(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 26:
                if (i12 == 2) {
                    return (j8 & 536870912) == 0 ? ArrayDecoders.decodeStringList(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : ArrayDecoders.decodeStringListRequireUtf8(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers);
                }
                return i8;
            case 27:
                return i12 == 2 ? ArrayDecoders.decodeMessageList(getMessageFieldSchema(i13), i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 28:
                return i12 == 2 ? ArrayDecoders.decodeBytesList(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
            case 44:
                if (i12 == 2) {
                    iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                } else {
                    if (i12 != 0) {
                        return i8;
                    }
                    iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) t3, i11, (List<Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(i13), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 0 ? ArrayDecoders.decodeSInt32List(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case 34:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i8, protobufListMutableCopyWithCapacity2, registers);
                }
                return i12 == 0 ? ArrayDecoders.decodeSInt64List(i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                return i12 == 3 ? ArrayDecoders.decodeGroupList(getMessageFieldSchema(i13), i10, bArr, i8, i9, protobufListMutableCopyWithCapacity2, registers) : i8;
            default:
                return i8;
        }
    }

    private int positionForFieldNumber(int i8) {
        if (i8 < this.minFieldNumber || i8 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i8, 0);
    }

    private int presenceMaskAndOffsetAt(int i8) {
        return this.buffer[i8 + 2];
    }

    private <E> void readGroupList(Object obj, long j8, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j8), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i8, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i8)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i8, Reader reader) throws IOException {
        if (isEnforceUtf8(i8)) {
            UnsafeUtil.putObject(obj, offset(i8), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i8), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i8), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i8, Reader reader) throws IOException {
        if (isEnforceUtf8(i8)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i8)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i8)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbY = a.y("Field ", str, " for ");
            sbY.append(cls.getName());
            sbY.append(" not found. Known fields are ");
            sbY.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbY.toString());
        }
    }

    private void setFieldPresent(T t3, int i8) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i8);
        long j8 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j8 == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t3, j8, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t3, j8));
    }

    private void setOneofPresent(T t3, int i8, int i9) {
        UnsafeUtil.putInt(t3, presenceMaskAndOffsetAt(i9) & 1048575, i8);
    }

    private int slowPositionForFieldNumber(int i8, int i9) {
        int length = (this.buffer.length / 3) - 1;
        while (i9 <= length) {
            int i10 = (length + i9) >>> 1;
            int i11 = i10 * 3;
            int iNumberAt = numberAt(i11);
            if (i8 == iNumberAt) {
                return i11;
            }
            if (i8 < iNumberAt) {
                length = i10 - 1;
            } else {
                i9 = i10 + 1;
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
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i8, Object[] objArr) {
        int iObjectFieldOffset;
        int iId;
        long jObjectFieldOffset;
        int iObjectFieldOffset2;
        int iNumberOfTrailingZeros;
        int i9;
        Class<?> messageFieldClass;
        int i10;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof == null) {
            FieldType type = fieldInfo.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            iId = type.id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fieldInfo.getPresenceField();
                iObjectFieldOffset2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
            } else if (fieldInfo.getCachedSizeField() == null) {
                iObjectFieldOffset2 = 0;
                iNumberOfTrailingZeros = 0;
            } else {
                jObjectFieldOffset = UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
            }
            iArr[i8] = fieldInfo.getFieldNumber();
            int i11 = i8 + 1;
            if (fieldInfo.isEnforceUtf8()) {
                i9 = ENFORCE_UTF8_MASK;
            } else {
                i9 = 0;
            }
            iArr[i11] = (fieldInfo.isRequired() ? REQUIRED_MASK : 0) | i9 | (iId << 20) | iObjectFieldOffset;
            iArr[i8 + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
            messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[((i8 / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[((i8 / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            i10 = (i8 / 3) * 2;
            objArr[i10] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i10 + 1] = messageFieldClass;
            } else if (fieldInfo.getEnumVerifier() != null) {
                objArr[i10 + 1] = fieldInfo.getEnumVerifier();
            }
        }
        iId = fieldInfo.getType().id() + 51;
        iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
        jObjectFieldOffset = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        iObjectFieldOffset2 = (int) jObjectFieldOffset;
        iNumberOfTrailingZeros = 0;
        iArr[i8] = fieldInfo.getFieldNumber();
        int i12 = i8 + 1;
        if (fieldInfo.isEnforceUtf8()) {
            i9 = ENFORCE_UTF8_MASK;
        } else {
            i9 = 0;
        }
        iArr[i12] = (fieldInfo.isRequired() ? REQUIRED_MASK : 0) | i9 | (iId << 20) | iObjectFieldOffset;
        iArr[i8 + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
        messageFieldClass = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
            if (messageFieldClass != null) {
                objArr[((i8 / 3) * 2) + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[((i8 / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i10 = (i8 / 3) * 2;
        objArr[i10] = fieldInfo.getMapDefaultEntry();
        if (messageFieldClass != null) {
            objArr[i10 + 1] = messageFieldClass;
        } else if (fieldInfo.getEnumVerifier() != null) {
            objArr[i10 + 1] = fieldInfo.getEnumVerifier();
        }
    }

    private void storeMessageField(T t3, int i8, Object obj) {
        UNSAFE.putObject(t3, offset(typeAndOffsetAt(i8)), obj);
        setFieldPresent(t3, i8);
    }

    private void storeOneofMessageField(T t3, int i8, int i9, Object obj) {
        UNSAFE.putObject(t3, offset(typeAndOffsetAt(i9)), obj);
        setOneofPresent(t3, i8, i9);
    }

    private static int type(int i8) {
        return (i8 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i8) {
        return this.buffer[i8 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    private void writeFieldsInAscendingOrder(T t3, Writer writer) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator it;
        int i8;
        Map.Entry<?, ?> entry2;
        int i9;
        int i10;
        Map.Entry<?, ?> entry3;
        boolean z2;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t3);
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
        int i11 = 1048575;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i14);
            int iNumberAt = numberAt(i14);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                int i15 = this.buffer[i14 + 2];
                int i16 = i15 & i11;
                if (i16 != i12) {
                    i13 = i16 == i11 ? 0 : unsafe.getInt(t3, i16);
                    i12 = i16;
                } else {
                    entry = entry;
                }
                int i17 = 1 << (i15 >>> 20);
                i8 = i12;
                i9 = i17;
                entry2 = entry;
            } else {
                i8 = i12;
                entry2 = entry;
                i9 = 0;
            }
            int i18 = i13;
            while (entry2 != null && this.extensionSchema.extensionNumber(entry2) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry2);
                entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeDouble(iNumberAt, doubleAt(t3, jOffset));
                    }
                    break;
                case 1:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeFloat(iNumberAt, floatAt(t3, jOffset));
                    }
                    break;
                case 2:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t3, jOffset));
                    }
                    break;
                case 3:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t3, jOffset));
                    }
                    break;
                case 4:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t3, jOffset));
                    }
                    break;
                case 5:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t3, jOffset));
                    }
                    break;
                case 6:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t3, jOffset));
                    }
                    break;
                case 7:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeBool(iNumberAt, booleanAt(t3, jOffset));
                    }
                    break;
                case 8:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writeString(iNumberAt, unsafe.getObject(t3, jOffset), writer);
                    }
                    break;
                case 9:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                    }
                    break;
                case 10:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t3, jOffset));
                    }
                    break;
                case 11:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t3, jOffset));
                    }
                    break;
                case 12:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t3, jOffset));
                    }
                    break;
                case 13:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t3, jOffset));
                    }
                    break;
                case 14:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t3, jOffset));
                    }
                    break;
                case 15:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t3, jOffset));
                    }
                    break;
                case 16:
                    i10 = length;
                    entry3 = entry2;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t3, jOffset));
                    }
                    break;
                case 17:
                    entry3 = entry2;
                    i10 = length;
                    if (isFieldPresent(t3, i14, i8, i18, i9)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                    }
                    break;
                case 18:
                    z2 = false;
                    SchemaUtil.writeDoubleList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 19:
                    z2 = false;
                    SchemaUtil.writeFloatList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 20:
                    z2 = false;
                    SchemaUtil.writeInt64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 21:
                    z2 = false;
                    SchemaUtil.writeUInt64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 22:
                    z2 = false;
                    SchemaUtil.writeInt32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 23:
                    z2 = false;
                    SchemaUtil.writeFixed64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 24:
                    z2 = false;
                    SchemaUtil.writeFixed32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 25:
                    z2 = false;
                    SchemaUtil.writeBoolList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, getMessageFieldSchema(i14));
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 29:
                    z2 = false;
                    SchemaUtil.writeUInt32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    z2 = false;
                    SchemaUtil.writeEnumList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 31:
                    z2 = false;
                    SchemaUtil.writeSFixed32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 32:
                    z2 = false;
                    SchemaUtil.writeSFixed64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 33:
                    z2 = false;
                    SchemaUtil.writeSInt32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 34:
                    z2 = false;
                    SchemaUtil.writeSInt64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, false);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    SchemaUtil.writeSInt64List(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, true);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    SchemaUtil.writeGroupList(numberAt(i14), (List) unsafe.getObject(t3, jOffset), writer, getMessageFieldSchema(i14));
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(t3, jOffset), i14);
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 51:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 56:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 57:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 58:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 59:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writeString(iNumberAt, unsafe.getObject(t3, jOffset), writer);
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 60:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 61:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 62:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 64:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t3, jOffset));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                case 68:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                    }
                    i10 = length;
                    entry3 = entry2;
                    break;
                default:
                    i10 = length;
                    entry3 = entry2;
                    break;
            }
            i14 += 3;
            i12 = i8;
            entry = entry3;
            i13 = i18;
            length = i10;
            i11 = 1048575;
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t3, writer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void writeFieldsInDescendingOrder(T t3, Writer writer) throws IOException {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t3, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t3);
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
                    if (isFieldPresent(t3, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t3, length)) {
                        writer.writeFloat(iNumberAt, floatAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t3, length)) {
                        writer.writeInt64(iNumberAt, longAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t3, length)) {
                        writer.writeUInt64(iNumberAt, longAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t3, length)) {
                        writer.writeInt32(iNumberAt, intAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t3, length)) {
                        writer.writeFixed64(iNumberAt, longAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t3, length)) {
                        writer.writeFixed32(iNumberAt, intAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t3, length)) {
                        writer.writeBool(iNumberAt, booleanAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t3, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t3, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t3, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t3, length)) {
                        writer.writeUInt32(iNumberAt, intAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t3, length)) {
                        writer.writeEnum(iNumberAt, intAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t3, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t3, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t3, length)) {
                        writer.writeSInt32(iNumberAt, intAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t3, length)) {
                        writer.writeSInt64(iNumberAt, longAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t3, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t3, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t3, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t3, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i8, Object obj, int i9) throws IOException {
        if (obj != null) {
            writer.writeMap(i8, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i9)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i8, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i8, (String) obj);
        } else {
            writer.writeBytes(i8, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t3), writer);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t3, T t8) {
        int length = this.buffer.length;
        for (int i8 = 0; i8 < length; i8 += 3) {
            if (!equals(t3, t8, i8)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t3).equals(this.unknownFieldSchema.getFromMessage(t8))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t3).equals(this.extensionSchema.getExtensions(t8));
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
    public int getSerializedSize(T t3) {
        int i8;
        int i9;
        int i10;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        int iComputeSFixed32Size;
        boolean z2;
        int iComputeSizeFixed32List;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i11 = 1048575;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i14 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i14);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i14);
            int i16 = this.buffer[i14 + 2];
            int i17 = i16 & i11;
            if (iType <= 17) {
                if (i17 != i12) {
                    i13 = i17 == i11 ? 0 : unsafe.getInt(t3, i17);
                    i12 = i17;
                }
                i8 = i12;
                i9 = i13;
                i10 = 1 << (i16 >>> 20);
            } else {
                i8 = i12;
                i9 = i13;
                i10 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            if (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) {
                i17 = 0;
            }
            switch (iType) {
                case 0:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t3, jOffset));
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t3, jOffset));
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t3, jOffset));
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i15 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        Object object = unsafe.getObject(t3, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        i15 = iComputeBytesSize + i15;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                        i15 += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t3, i14, i8, i9, i10)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeMessage;
                    break;
                case 19:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 20:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 21:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 22:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 23:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 24:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 25:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t3, jOffset));
                    i15 += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                    i15 += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t3, jOffset));
                    i15 += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeMessage;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 31:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 32:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 33:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 34:
                    z2 = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t3, jOffset), false);
                    i15 += iComputeSizeFixed32List;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t3, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t3, i17, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i15 += iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                    i15 += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t3, jOffset), getMapFieldDefaultEntry(i14));
                    i15 += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        Object object2 = unsafe.getObject(t3, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        i15 = iComputeBytesSize + i15;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                        i15 += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i15 += iComputeSFixed32Size;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i15 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t3, jOffset));
                        i15 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t3, iNumberAt, i14)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t3, jOffset), getMessageFieldSchema(i14));
                        i15 += iComputeBoolSize;
                    }
                    break;
                default:
                    break;
            }
            i14 += 3;
            i12 = i8;
            i13 = i9;
            i11 = 1048575;
        }
        int unknownFieldsSerializedSize = i15 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t3);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t3).getSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t3) {
        int i8;
        int iHashLong;
        int i9;
        int iOneofIntAt;
        int length = this.buffer.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i11);
            int iNumberAt = numberAt(i11);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i8 = i10 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t3, jOffset)));
                    i10 = iHashLong + i8;
                    break;
                case 1:
                    i8 = i10 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t3, jOffset));
                    i10 = iHashLong + i8;
                    break;
                case 2:
                    i8 = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t3, jOffset));
                    i10 = iHashLong + i8;
                    break;
                case 3:
                    i8 = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t3, jOffset));
                    i10 = iHashLong + i8;
                    break;
                case 4:
                    i9 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t3, jOffset);
                    i10 = i9 + iOneofIntAt;
                    break;
                case 5:
                    i8 = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t3, jOffset));
                    i10 = iHashLong + i8;
                    break;
                case 6:
                    i9 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t3, jOffset);
                    i10 = i9 + iOneofIntAt;
                    break;
                case 7:
                    i8 = i10 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t3, jOffset));
                    i10 = iHashLong + i8;
                    break;
                case 8:
                    i8 = i10 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t3, jOffset)).hashCode();
                    i10 = iHashLong + i8;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t3, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i10 = (i10 * 53) + iHashCode;
                    break;
                case 10:
                    i8 = i10 * 53;
                    iHashLong = UnsafeUtil.getObject(t3, jOffset).hashCode();
                    i10 = iHashLong + i8;
                    break;
                case 11:
                    i9 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t3, jOffset);
                    i10 = i9 + iOneofIntAt;
                    break;
                case 12:
                    i9 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t3, jOffset);
                    i10 = i9 + iOneofIntAt;
                    break;
                case 13:
                    i9 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t3, jOffset);
                    i10 = i9 + iOneofIntAt;
                    break;
                case 14:
                    i8 = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t3, jOffset));
                    i10 = iHashLong + i8;
                    break;
                case 15:
                    i9 = i10 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t3, jOffset);
                    i10 = i9 + iOneofIntAt;
                    break;
                case 16:
                    i8 = i10 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t3, jOffset));
                    i10 = iHashLong + i8;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t3, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i10 = (i10 * 53) + iHashCode;
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
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
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
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i8 = i10 * 53;
                    iHashLong = UnsafeUtil.getObject(t3, jOffset).hashCode();
                    i10 = iHashLong + i8;
                    break;
                case 50:
                    i8 = i10 * 53;
                    iHashLong = UnsafeUtil.getObject(t3, jOffset).hashCode();
                    i10 = iHashLong + i8;
                    break;
                case 51:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t3, jOffset)));
                        i10 = iHashLong + i8;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t3, jOffset));
                        i10 = iHashLong + i8;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t3, jOffset));
                        i10 = iHashLong + i8;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t3, jOffset));
                        i10 = iHashLong + i8;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i9 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t3, jOffset);
                        i10 = i9 + iOneofIntAt;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t3, jOffset));
                        i10 = iHashLong + i8;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i9 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t3, jOffset);
                        i10 = i9 + iOneofIntAt;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t3, jOffset));
                        i10 = iHashLong + i8;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t3, jOffset)).hashCode();
                        i10 = iHashLong + i8;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = UnsafeUtil.getObject(t3, jOffset).hashCode();
                        i10 = iHashLong + i8;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = UnsafeUtil.getObject(t3, jOffset).hashCode();
                        i10 = iHashLong + i8;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i9 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t3, jOffset);
                        i10 = i9 + iOneofIntAt;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i9 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t3, jOffset);
                        i10 = i9 + iOneofIntAt;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i9 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t3, jOffset);
                        i10 = i9 + iOneofIntAt;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t3, jOffset));
                        i10 = iHashLong + i8;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i9 = i10 * 53;
                        iOneofIntAt = oneofIntAt(t3, jOffset);
                        i10 = i9 + iOneofIntAt;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t3, jOffset));
                        i10 = iHashLong + i8;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t3, iNumberAt, i11)) {
                        i8 = i10 * 53;
                        iHashLong = UnsafeUtil.getObject(t3, jOffset).hashCode();
                        i10 = iHashLong + i8;
                    }
                    break;
            }
        }
        int iHashCode2 = this.unknownFieldSchema.getFromMessage(t3).hashCode() + (i10 * 53);
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t3).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:58:0x008f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa A[SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t3) {
        int i8;
        int i9;
        int i10 = 1048575;
        int i11 = 0;
        int i12 = 0;
        while (i12 < this.checkInitializedCount) {
            int i13 = this.intArray[i12];
            int iNumberAt = numberAt(i13);
            int iTypeAndOffsetAt = typeAndOffsetAt(i13);
            int i14 = this.buffer[i13 + 2];
            int i15 = i14 & 1048575;
            int i16 = 1 << (i14 >>> 20);
            if (i15 != i10) {
                if (i15 != 1048575) {
                    i11 = UNSAFE.getInt(t3, i15);
                }
                i9 = i11;
                i8 = i15;
            } else {
                i8 = i10;
                i9 = i11;
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t3, i13, i8, i9, i16)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(t3, i13, i8, i9, i16) && !isInitialized(t3, iTypeAndOffsetAt, getMessageFieldSchema(i13))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(t3, iTypeAndOffsetAt, i13)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(t3, iNumberAt, i13) && !isInitialized(t3, iTypeAndOffsetAt, getMessageFieldSchema(i13))) {
                    return false;
                }
            } else if (iType != 49) {
                if (iType == 50 && !isMapInitialized(t3, iTypeAndOffsetAt, i13)) {
                    return false;
                }
            } else if (!isListInitialized(t3, iTypeAndOffsetAt, i13)) {
                return false;
            }
            i12++;
            i10 = i8;
            i11 = i9;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t3).isInitialized();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x007c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t3) {
        if (isMutable(t3)) {
            if (t3 instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t3;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i8 = 0; i8 < length; i8 += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i8);
                long jOffset = offset(iTypeAndOffsetAt);
                int iType = type(iTypeAndOffsetAt);
                if (iType != 9) {
                    if (iType != 60 && iType != 68) {
                        switch (iType) {
                            case 17:
                                if (isFieldPresent(t3, i8)) {
                                    getMessageFieldSchema(i8).makeImmutable(UNSAFE.getObject(t3, jOffset));
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
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
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
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.listFieldSchema.makeImmutableListAt(t3, jOffset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t3, jOffset);
                                if (object != null) {
                                    unsafe.putObject(t3, jOffset, this.mapFieldSchema.toImmutable(object));
                                }
                                break;
                        }
                    } else if (isOneofPresent(t3, numberAt(i8), i8)) {
                        getMessageFieldSchema(i8).makeImmutable(UNSAFE.getObject(t3, jOffset));
                    }
                } else if (isFieldPresent(t3, i8)) {
                    getMessageFieldSchema(i8).makeImmutable(UNSAFE.getObject(t3, jOffset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t3);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t3);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t3, T t8) {
        checkMutable(t3);
        t8.getClass();
        for (int i8 = 0; i8 < this.buffer.length; i8 += 3) {
            mergeSingleField(t3, t8, i8);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t3, t8);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t3, t8);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x009a. Please report as an issue. */
    @CanIgnoreReturnValue
    public int parseMessage(T t3, byte[] bArr, int i8, int i9, int i10, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        MessageSchema<T> messageSchema;
        int i11;
        int i12;
        int i13;
        int i14;
        T t8;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        byte[] bArr2;
        int i22;
        int i23;
        byte b9;
        byte[] bArr3;
        int iDecodeVarint64;
        int i24;
        int i25;
        MessageSchema<T> messageSchema2 = this;
        T t10 = t3;
        byte[] bArr4 = bArr;
        i9 = i9;
        i10 = i10;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(t3);
        Unsafe unsafe2 = UNSAFE;
        int iDecodeUnknownField = i8;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = -1;
        int i30 = 1048575;
        while (true) {
            if (iDecodeUnknownField < i9) {
                int i31 = iDecodeUnknownField + 1;
                byte b10 = bArr4[iDecodeUnknownField];
                if (b10 < 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(b10, bArr4, i31, registers2);
                    i15 = registers2.int1;
                    i31 = iDecodeVarint32;
                } else {
                    i15 = b10;
                }
                int i32 = i15 >>> 3;
                int i33 = i15 & 7;
                int iPositionForFieldNumber = i32 > i29 ? messageSchema2.positionForFieldNumber(i32, i26 / 3) : messageSchema2.positionForFieldNumber(i32);
                if (iPositionForFieldNumber == -1) {
                    i16 = i32;
                    i17 = i31;
                    i12 = i15;
                    i18 = i28;
                    i19 = i30;
                    unsafe = unsafe2;
                    i10 = i10;
                    i20 = 0;
                } else {
                    int i34 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i34);
                    long jOffset = offset(i34);
                    int i35 = i15;
                    if (iType <= 17) {
                        int i36 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i37 = 1 << (i36 >>> 20);
                        int i38 = 1048575;
                        int i39 = i36 & 1048575;
                        if (i39 != i30) {
                            if (i30 != 1048575) {
                                unsafe2.putInt(t10, i30, i28);
                                i38 = 1048575;
                            }
                            i19 = i39;
                            i21 = i39 == i38 ? 0 : unsafe2.getInt(t10, i39);
                        } else {
                            i21 = i28;
                            i19 = i30;
                        }
                        switch (iType) {
                            case 0:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 1) {
                                    UnsafeUtil.putDouble(t10, jOffset, ArrayDecoders.decodeDouble(bArr2, i31));
                                    iDecodeUnknownField = i31 + 8;
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 1:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 5) {
                                    UnsafeUtil.putFloat(t10, jOffset, ArrayDecoders.decodeFloat(bArr2, i31));
                                    iDecodeUnknownField = i31 + 4;
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr3, i31, registers2);
                                    unsafe2.putLong(t3, jOffset, registers2.long1);
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr3;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i31, registers2);
                                    unsafe2.putInt(t10, jOffset, registers2.int1);
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 1) {
                                    unsafe2.putLong(t3, jOffset, ArrayDecoders.decodeFixed64(bArr2, i31));
                                    iDecodeUnknownField = i31 + 8;
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 5) {
                                    unsafe2.putInt(t10, jOffset, ArrayDecoders.decodeFixed32(bArr2, i31));
                                    iDecodeUnknownField = i31 + 4;
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 7:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr2, i31, registers2);
                                    UnsafeUtil.putBoolean(t10, jOffset, registers2.long1 != 0);
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 8:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 2) {
                                    iDecodeUnknownField = isEnforceUtf8(i34) ? ArrayDecoders.decodeStringRequireUtf8(bArr2, i31, registers2) : ArrayDecoders.decodeString(bArr2, i31, registers2);
                                    unsafe2.putObject(t10, jOffset, registers2.object1);
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 9:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 2) {
                                    Object objMutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t10, i22);
                                    iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i22), bArr, i31, i9, registers);
                                    messageSchema2.storeMessageField(t10, i22, objMutableMessageFieldForMerge);
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 10:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 2) {
                                    iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr2, i31, registers2);
                                    unsafe2.putObject(t10, jOffset, registers2.object1);
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 12:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i31, registers2);
                                    int i40 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i22);
                                    if (!isLegacyEnumIsClosed(i34) || enumFieldVerifier == null || enumFieldVerifier.isInRange(i40)) {
                                        unsafe2.putInt(t10, jOffset, i40);
                                        i28 = i21 | i37;
                                        i26 = i22;
                                        bArr4 = bArr2;
                                        i27 = i23;
                                        i30 = i19;
                                        i29 = i16;
                                    } else {
                                        getMutableUnknownFields(t3).storeField(i23, Long.valueOf(i40));
                                        i10 = i10;
                                        i26 = i22;
                                        i28 = i21;
                                        i27 = i23;
                                        i30 = i19;
                                        i29 = i16;
                                        bArr4 = bArr2;
                                    }
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                if (i33 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i31, registers2);
                                    unsafe2.putInt(t10, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr2;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 16:
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                bArr3 = bArr;
                                if (i33 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr3, i31, registers2);
                                    unsafe2.putLong(t3, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                    i28 = i21 | i37;
                                    i26 = i22;
                                    bArr4 = bArr3;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            case 17:
                                if (i33 == 3) {
                                    Object objMutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t10, iPositionForFieldNumber);
                                    i16 = i32;
                                    i23 = i35;
                                    iDecodeUnknownField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i31, i9, (i32 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t10, iPositionForFieldNumber, objMutableMessageFieldForMerge2);
                                    i28 = i21 | i37;
                                    bArr4 = bArr;
                                    i26 = iPositionForFieldNumber;
                                    i27 = i23;
                                    i30 = i19;
                                    i29 = i16;
                                } else {
                                    i16 = i32;
                                    i23 = i35;
                                    b9 = -1;
                                    i22 = iPositionForFieldNumber;
                                    i10 = i10;
                                    i17 = i31;
                                    i20 = i22;
                                    unsafe = unsafe2;
                                    i18 = i21;
                                    i12 = i23;
                                }
                                break;
                            default:
                                i16 = i32;
                                i22 = iPositionForFieldNumber;
                                i23 = i35;
                                b9 = -1;
                                i10 = i10;
                                i17 = i31;
                                i20 = i22;
                                unsafe = unsafe2;
                                i18 = i21;
                                i12 = i23;
                                break;
                        }
                    } else {
                        i16 = i32;
                        int i41 = i30;
                        i18 = i28;
                        if (iType != 27) {
                            i19 = i41;
                            if (iType <= 49) {
                                int i42 = i31;
                                unsafe = unsafe2;
                                i20 = iPositionForFieldNumber;
                                i25 = i35;
                                iDecodeUnknownField = parseRepeatedField(t3, bArr, i31, i9, i35, i16, i33, iPositionForFieldNumber, i34, iType, jOffset, registers);
                                if (iDecodeUnknownField != i42) {
                                    messageSchema2 = this;
                                    t10 = t3;
                                    bArr4 = bArr;
                                    i10 = i10;
                                    registers2 = registers;
                                    i27 = i25;
                                    i28 = i18;
                                    i26 = i20;
                                    i30 = i19;
                                    i29 = i16;
                                    unsafe2 = unsafe;
                                } else {
                                    i17 = iDecodeUnknownField;
                                    i12 = i25;
                                }
                            } else {
                                i24 = i31;
                                unsafe = unsafe2;
                                i20 = iPositionForFieldNumber;
                                i25 = i35;
                                if (iType != 50) {
                                    iDecodeUnknownField = parseOneofField(t3, bArr, i24, i9, i25, i16, i33, i34, iType, jOffset, i20, registers);
                                    if (iDecodeUnknownField != i24) {
                                        messageSchema2 = this;
                                        t10 = t3;
                                        bArr4 = bArr;
                                        i10 = i10;
                                        registers2 = registers;
                                        i27 = i25;
                                        i28 = i18;
                                        i26 = i20;
                                        i30 = i19;
                                        i29 = i16;
                                        unsafe2 = unsafe;
                                    } else {
                                        i17 = iDecodeUnknownField;
                                        i12 = i25;
                                    }
                                } else if (i33 == 2) {
                                    iDecodeUnknownField = parseMapField(t3, bArr, i24, i9, i20, jOffset, registers);
                                    if (iDecodeUnknownField != i24) {
                                        messageSchema2 = this;
                                        t10 = t3;
                                        bArr4 = bArr;
                                        i10 = i10;
                                        registers2 = registers;
                                        i27 = i25;
                                        i28 = i18;
                                        i26 = i20;
                                        i30 = i19;
                                        i29 = i16;
                                        unsafe2 = unsafe;
                                    } else {
                                        i17 = iDecodeUnknownField;
                                        i12 = i25;
                                    }
                                }
                            }
                        } else if (i33 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t10, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t10, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), i35, bArr, i31, i9, protobufListMutableCopyWithCapacity2, registers);
                            i10 = i10;
                            i26 = iPositionForFieldNumber;
                            i27 = i35;
                            i28 = i18;
                            i30 = i41;
                            i29 = i16;
                            bArr4 = bArr;
                        } else {
                            i19 = i41;
                            i24 = i31;
                            unsafe = unsafe2;
                            i20 = iPositionForFieldNumber;
                            i25 = i35;
                        }
                        i17 = i24;
                        i12 = i25;
                    }
                }
                if (i12 != i10 || i10 == 0) {
                    iDecodeUnknownField = (!this.hasExtensions || registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) ? ArrayDecoders.decodeUnknownField(i12, bArr, i17, i9, getMutableUnknownFields(t3), registers) : ArrayDecoders.decodeExtensionOrUnknownField(i12, bArr, i17, i9, t3, this.defaultInstance, this.unknownFieldSchema, registers);
                    t10 = t3;
                    bArr4 = bArr;
                    i27 = i12;
                    messageSchema2 = this;
                    registers2 = registers;
                    i28 = i18;
                    i26 = i20;
                    i30 = i19;
                    i29 = i16;
                    unsafe2 = unsafe;
                    i10 = i10;
                } else {
                    i14 = 1048575;
                    messageSchema = this;
                    i11 = i17;
                    i28 = i18;
                    i13 = i19;
                }
            } else {
                int i43 = i30;
                unsafe = unsafe2;
                i10 = i10;
                messageSchema = messageSchema2;
                i11 = iDecodeUnknownField;
                i12 = i27;
                i13 = i43;
                i14 = 1048575;
            }
        }
        if (i13 != i14) {
            t8 = t3;
            unsafe.putInt(t8, i13, i28);
        } else {
            t8 = t3;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i44 = messageSchema.checkInitializedCount; i44 < messageSchema.repeatedFieldOffsetStart; i44++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(t3, messageSchema.intArray[i44], unknownFieldSetLite, messageSchema.unknownFieldSchema, t3);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t8, unknownFieldSetLite);
        }
        if (i10 == 0) {
            if (i11 != i9) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i11 > i9 || i12 != i10) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i11;
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t3, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t3, writer);
        } else {
            writeFieldsInAscendingOrder(t3, writer);
        }
    }

    private boolean isFieldPresent(T t3, int i8) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i8);
        long j8 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j8 != 1048575) {
            return ((1 << (iPresenceMaskAndOffsetAt >>> 20)) & UnsafeUtil.getInt(t3, j8)) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i8);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t3, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t3, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t3, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(t3, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(t3, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(t3, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(t3, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t3, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(t3, jOffset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(t3, jOffset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t3, jOffset));
            case 11:
                return UnsafeUtil.getInt(t3, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(t3, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(t3, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(t3, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(t3, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(t3, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(t3, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private int positionForFieldNumber(int i8, int i9) {
        if (i8 < this.minFieldNumber || i8 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i8, i9);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        checkMutable(t3);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t3, reader, extensionRegistryLite);
    }

    private boolean equals(T t3, T t8, int i8) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i8);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t3, t8, i8) && Double.doubleToLongBits(UnsafeUtil.getDouble(t3, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t8, jOffset));
            case 1:
                return arePresentForEquals(t3, t8, i8) && Float.floatToIntBits(UnsafeUtil.getFloat(t3, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t8, jOffset));
            case 2:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getLong(t3, jOffset) == UnsafeUtil.getLong(t8, jOffset);
            case 3:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getLong(t3, jOffset) == UnsafeUtil.getLong(t8, jOffset);
            case 4:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getInt(t3, jOffset) == UnsafeUtil.getInt(t8, jOffset);
            case 5:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getLong(t3, jOffset) == UnsafeUtil.getLong(t8, jOffset);
            case 6:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getInt(t3, jOffset) == UnsafeUtil.getInt(t8, jOffset);
            case 7:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getBoolean(t3, jOffset) == UnsafeUtil.getBoolean(t8, jOffset);
            case 8:
                return arePresentForEquals(t3, t8, i8) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, jOffset), UnsafeUtil.getObject(t8, jOffset));
            case 9:
                return arePresentForEquals(t3, t8, i8) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, jOffset), UnsafeUtil.getObject(t8, jOffset));
            case 10:
                return arePresentForEquals(t3, t8, i8) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, jOffset), UnsafeUtil.getObject(t8, jOffset));
            case 11:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getInt(t3, jOffset) == UnsafeUtil.getInt(t8, jOffset);
            case 12:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getInt(t3, jOffset) == UnsafeUtil.getInt(t8, jOffset);
            case 13:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getInt(t3, jOffset) == UnsafeUtil.getInt(t8, jOffset);
            case 14:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getLong(t3, jOffset) == UnsafeUtil.getLong(t8, jOffset);
            case 15:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getInt(t3, jOffset) == UnsafeUtil.getInt(t8, jOffset);
            case 16:
                return arePresentForEquals(t3, t8, i8) && UnsafeUtil.getLong(t3, jOffset) == UnsafeUtil.getLong(t8, jOffset);
            case 17:
                return arePresentForEquals(t3, t8, i8) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, jOffset), UnsafeUtil.getObject(t8, jOffset));
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
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
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, jOffset), UnsafeUtil.getObject(t8, jOffset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, jOffset), UnsafeUtil.getObject(t8, jOffset));
            case 51:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 68:
                return isOneofCaseEqual(t3, t8, i8) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t3, jOffset), UnsafeUtil.getObject(t8, jOffset));
            default:
                return true;
        }
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t3, byte[] bArr, int i8, int i9, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(t3, bArr, i8, i9, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i8, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i8)));
    }
}
