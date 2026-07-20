package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i8, int i9, ByteBuffer byteBuffer) {
            __reset(i8, i9, byteBuffer);
            return this;
        }

        public MetadataItem get(int i8) {
            return get(new MetadataItem(), i8);
        }

        public MetadataItem get(MetadataItem metadataItem, int i8) {
            return metadataItem.__assign(Table.__indirect(__element(i8), this.f1135bb), this.f1135bb);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addCodepoints(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.addOffset(6, i8, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder flatBufferBuilder, short s2) {
        flatBufferBuilder.addShort(3, s2, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder flatBufferBuilder, boolean z2) {
        flatBufferBuilder.addBoolean(1, z2, false);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, short s2) {
        flatBufferBuilder.addShort(5, s2, 0);
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.addInt(0, i8, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder flatBufferBuilder, short s2) {
        flatBufferBuilder.addShort(2, s2, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, short s2) {
        flatBufferBuilder.addShort(4, s2, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder flatBufferBuilder, int i8, boolean z2, short s2, short s3, short s10, short s11, int i9) {
        flatBufferBuilder.startTable(7);
        addCodepoints(flatBufferBuilder, i9);
        addId(flatBufferBuilder, i8);
        addHeight(flatBufferBuilder, s11);
        addWidth(flatBufferBuilder, s10);
        addCompatAdded(flatBufferBuilder, s3);
        addSdkAdded(flatBufferBuilder, s2);
        addEmojiStyle(flatBufferBuilder, z2);
        return endMetadataItem(flatBufferBuilder);
    }

    public static int endMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer) {
        return getRootAsMetadataItem(byteBuffer, new MetadataItem());
    }

    public static void startCodepointsVector(FlatBufferBuilder flatBufferBuilder, int i8) {
        flatBufferBuilder.startVector(4, i8, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public MetadataItem __assign(int i8, ByteBuffer byteBuffer) {
        __init(i8, byteBuffer);
        return this;
    }

    public void __init(int i8, ByteBuffer byteBuffer) {
        __reset(i8, byteBuffer);
    }

    public int codepoints(int i8) {
        int i__offset = __offset(16);
        if (i__offset == 0) {
            return 0;
        }
        return this.f1141bb.getInt((i8 * 4) + __vector(i__offset));
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return __vector_as_bytebuffer(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 16, 4);
    }

    public int codepointsLength() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public short compatAdded() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f1141bb.getShort(i__offset + this.bb_pos);
        }
        return (short) 0;
    }

    public boolean emojiStyle() {
        int i__offset = __offset(6);
        return (i__offset == 0 || this.f1141bb.get(i__offset + this.bb_pos) == 0) ? false : true;
    }

    public short height() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f1141bb.getShort(i__offset + this.bb_pos);
        }
        return (short) 0;
    }

    public int id() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f1141bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    public short sdkAdded() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f1141bb.getShort(i__offset + this.bb_pos);
        }
        return (short) 0;
    }

    public short width() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f1141bb.getShort(i__offset + this.bb_pos);
        }
        return (short) 0;
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer, MetadataItem metadataItem) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataItem.__assign(byteBuffer.position() + byteBuffer.getInt(byteBuffer.position()), byteBuffer);
    }

    public IntVector codepointsVector(IntVector intVector) {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return intVector.__assign(__vector(i__offset), this.f1141bb);
        }
        return null;
    }
}
