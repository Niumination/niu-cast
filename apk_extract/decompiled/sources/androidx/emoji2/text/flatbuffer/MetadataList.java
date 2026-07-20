package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataList extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i8, int i9, ByteBuffer byteBuffer) {
            __reset(i8, i9, byteBuffer);
            return this;
        }

        public MetadataList get(int i8) {
            return get(new MetadataList(), i8);
        }

        public MetadataList get(MetadataList metadataList, int i8) {
            return metadataList.__assign(Table.__indirect(__element(i8), this.f1135bb), this.f1135bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addList(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.addOffset(1, i8, 0);
    }

    public static void addSourceSha(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.addOffset(2, i8, 0);
    }

    public static void addVersion(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.addInt(0, i8, 0);
    }

    public static int createListVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMetadataList(FlatBufferBuilder flatBufferBuilder, int i8, int i9, int i10) {
        flatBufferBuilder.startTable(3);
        addSourceSha(flatBufferBuilder, i10);
        addList(flatBufferBuilder, i9);
        addVersion(flatBufferBuilder, i8);
        return endMetadataList(flatBufferBuilder);
    }

    public static int endMetadataList(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishMetadataListBuffer(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.finish(i8);
    }

    public static void finishSizePrefixedMetadataListBuffer(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.finishSizePrefixed(i8);
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer) {
        return getRootAsMetadataList(byteBuffer, new MetadataList());
    }

    public static void startListVector(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.startVector(4, i8, 4);
    }

    public static void startMetadataList(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public MetadataList __assign(int i8, ByteBuffer byteBuffer) {
        __init(i8, byteBuffer);
        return this;
    }

    public void __init(int i8, ByteBuffer byteBuffer) {
        __reset(i8, byteBuffer);
    }

    public MetadataItem list(int i8) {
        return list(new MetadataItem(), i8);
    }

    public int listLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public MetadataItem.Vector listVector() {
        return listVector(new MetadataItem.Vector());
    }

    public String sourceSha() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer sourceShaAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer sourceShaInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public int version() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f1141bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.__assign(byteBuffer.position() + byteBuffer.getInt(byteBuffer.position()), byteBuffer);
    }

    public MetadataItem list(MetadataItem metadataItem, int i8) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return null;
        }
        return metadataItem.__assign(__indirect((i8 * 4) + __vector(i__offset)), this.f1141bb);
    }

    public MetadataItem.Vector listVector(MetadataItem.Vector vector) {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return vector.__assign(__vector(i__offset), 4, this.f1141bb);
        }
        return null;
    }
}
