package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: com.google.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i8, boolean z2, V v3, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(i8, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z2), v3));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z2), v3);
    }

    private <V> void writeDeterministicIntegerMap(int i8, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i9 = 0;
        while (it.hasNext()) {
            iArr[i9] = it.next().intValue();
            i9++;
        }
        Arrays.sort(iArr);
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = iArr[i10];
            V v3 = map.get(Integer.valueOf(i11));
            this.output.writeTag(i8, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i11), v3));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i11), v3);
        }
    }

    private <V> void writeDeterministicLongMap(int i8, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i9 = 0;
        while (it.hasNext()) {
            jArr[i9] = it.next().longValue();
            i9++;
        }
        Arrays.sort(jArr);
        for (int i10 = 0; i10 < size; i10++) {
            long j8 = jArr[i10];
            V v3 = map.get(Long.valueOf(j8));
            this.output.writeTag(i8, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j8), v3));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j8), v3);
        }
    }

    private <K, V> void writeDeterministicMap(int i8, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v3 = map.get(Boolean.FALSE);
                if (v3 != null) {
                    writeDeterministicBooleanMapEntry(i8, false, v3, metadata);
                }
                V v8 = map.get(Boolean.TRUE);
                if (v8 != null) {
                    writeDeterministicBooleanMapEntry(i8, true, v8, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i8, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i8, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i8, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i8, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i9 = 0;
        while (it.hasNext()) {
            strArr[i9] = it.next();
            i9++;
        }
        Arrays.sort(strArr);
        for (int i10 = 0; i10 < size; i10++) {
            String str = strArr[i10];
            V v3 = map.get(str);
            this.output.writeTag(i8, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v3));
            MapEntryLite.writeTo(this.output, metadata, str, v3);
        }
    }

    private void writeLazyString(int i8, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(i8, (String) obj);
        } else {
            this.output.writeBytes(i8, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int i8, boolean z2) throws IOException {
        this.output.writeBool(i8, z2);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int i8, List<Boolean> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeBool(i8, list.get(i9).booleanValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeBoolSizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(list.get(i10).booleanValue());
        }
        this.output.writeUInt32NoTag(iComputeBoolSizeNoTag);
        while (i9 < list.size()) {
            this.output.writeBoolNoTag(list.get(i9).booleanValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int i8, ByteString byteString) throws IOException {
        this.output.writeBytes(i8, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int i8, List<ByteString> list) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            this.output.writeBytes(i8, list.get(i9));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int i8, double d7) throws IOException {
        this.output.writeDouble(i8, d7);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int i8, List<Double> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeDouble(i8, list.get(i9).doubleValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeDoubleSizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(list.get(i10).doubleValue());
        }
        this.output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
        while (i9 < list.size()) {
            this.output.writeDoubleNoTag(list.get(i9).doubleValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i8) throws IOException {
        this.output.writeTag(i8, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int i8, int i9) throws IOException {
        this.output.writeEnum(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int i8, List<Integer> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeEnum(i8, list.get(i9).intValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeEnumSizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeEnumSizeNoTag);
        while (i9 < list.size()) {
            this.output.writeEnumNoTag(list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int i8, int i9) throws IOException {
        this.output.writeFixed32(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int i8, List<Integer> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeFixed32(i8, list.get(i9).intValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeFixed32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeFixed32NoTag(list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int i8, long j8) throws IOException {
        this.output.writeFixed64(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int i8, List<Long> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeFixed64(i8, list.get(i9).longValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeFixed64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeFixed64NoTag(list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int i8, float f) throws IOException {
        this.output.writeFloat(i8, f);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int i8, List<Float> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeFloat(i8, list.get(i9).floatValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeFloatSizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(list.get(i10).floatValue());
        }
        this.output.writeUInt32NoTag(iComputeFloatSizeNoTag);
        while (i9 < list.size()) {
            this.output.writeFloatNoTag(list.get(i9).floatValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroup(int i8, Object obj) throws IOException {
        this.output.writeGroup(i8, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeGroupList(int i8, List<?> list) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            writeGroup(i8, list.get(i9));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int i8, int i9) throws IOException {
        this.output.writeInt32(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int i8, List<Integer> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeInt32(i8, list.get(i9).intValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeInt32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeInt32SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeInt32NoTag(list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int i8, long j8) throws IOException {
        this.output.writeInt64(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int i8, List<Long> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeInt64(i8, list.get(i9).longValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeInt64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeInt64SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeInt64NoTag(list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int i8, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i8, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i8, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i8, Object obj) throws IOException {
        this.output.writeMessage(i8, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i8, List<?> list) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            writeMessage(i8, list.get(i9));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i8, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i8, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i8, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int i8, int i9) throws IOException {
        this.output.writeSFixed32(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int i8, List<Integer> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeSFixed32(i8, list.get(i9).intValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeSFixed32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeSFixed32NoTag(list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int i8, long j8) throws IOException {
        this.output.writeSFixed64(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int i8, List<Long> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeSFixed64(i8, list.get(i9).longValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeSFixed64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeSFixed64NoTag(list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int i8, int i9) throws IOException {
        this.output.writeSInt32(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int i8, List<Integer> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeSInt32(i8, list.get(i9).intValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeSInt32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeSInt32NoTag(list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int i8, long j8) throws IOException {
        this.output.writeSInt64(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int i8, List<Long> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeSInt64(i8, list.get(i9).longValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeSInt64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeSInt64NoTag(list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i8) throws IOException {
        this.output.writeTag(i8, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int i8, String str) throws IOException {
        this.output.writeString(i8, str);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int i8, List<String> list) throws IOException {
        int i9 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i9 < list.size()) {
                this.output.writeString(i8, list.get(i9));
                i9++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i9 < list.size()) {
                writeLazyString(i8, lazyStringList.getRaw(i9));
                i9++;
            }
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int i8, int i9) throws IOException {
        this.output.writeUInt32(i8, i9);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int i8, List<Integer> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeUInt32(i8, list.get(i9).intValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i10).intValue());
        }
        this.output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeUInt32NoTag(list.get(i9).intValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int i8, long j8) throws IOException {
        this.output.writeUInt64(i8, j8);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int i8, List<Long> list, boolean z2) throws IOException {
        int i9 = 0;
        if (!z2) {
            while (i9 < list.size()) {
                this.output.writeUInt64(i8, list.get(i9).longValue());
                i9++;
            }
            return;
        }
        this.output.writeTag(i8, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i10).longValue());
        }
        this.output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i9 < list.size()) {
            this.output.writeUInt64NoTag(list.get(i9).longValue());
            i9++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int i8, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(i8, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i8, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i8, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int i8, List<?> list, Schema schema) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            writeGroup(i8, list.get(i9), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i8, List<?> list, Schema schema) throws IOException {
        for (int i9 = 0; i9 < list.size(); i9++) {
            writeMessage(i8, list.get(i9), schema);
        }
    }
}
