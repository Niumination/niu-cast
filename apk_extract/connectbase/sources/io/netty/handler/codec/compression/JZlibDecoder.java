package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class JZlibDecoder extends ZlibDecoder {
    private byte[] dictionary;
    private volatile boolean finished;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Inflater f8312z;

    public JZlibDecoder() {
        this(ZlibWrapper.ZLIB, 0);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            return;
        }
        try {
            this.f8312z.avail_in = i10;
            if (byteBuf.hasArray()) {
                this.f8312z.next_in = byteBuf.array();
                this.f8312z.next_in_index = byteBuf.arrayOffset() + byteBuf.readerIndex();
            } else {
                byte[] bArr = new byte[i10];
                byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                this.f8312z.next_in = bArr;
                this.f8312z.next_in_index = 0;
            }
            int i11 = this.f8312z.next_in_index;
            ByteBuf byteBufPrepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, null, i10 << 1);
            while (true) {
                try {
                    byteBufPrepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, byteBufPrepareDecompressBuffer, this.f8312z.avail_in << 1);
                    this.f8312z.avail_out = byteBufPrepareDecompressBuffer.writableBytes();
                    this.f8312z.next_out = byteBufPrepareDecompressBuffer.array();
                    this.f8312z.next_out_index = byteBufPrepareDecompressBuffer.arrayOffset() + byteBufPrepareDecompressBuffer.writerIndex();
                    int i12 = this.f8312z.next_out_index;
                    int iInflate = this.f8312z.inflate(2);
                    int i13 = this.f8312z.next_out_index - i12;
                    if (i13 > 0) {
                        byteBufPrepareDecompressBuffer.writerIndex(byteBufPrepareDecompressBuffer.writerIndex() + i13);
                    }
                    if (iInflate != -5) {
                        if (iInflate != 0) {
                            if (iInflate == 1) {
                                this.finished = true;
                                this.f8312z.inflateEnd();
                                break;
                            } else if (iInflate != 2) {
                                ZlibUtil.fail(this.f8312z, "decompression failure", iInflate);
                            } else {
                                byte[] bArr2 = this.dictionary;
                                if (bArr2 == null) {
                                    ZlibUtil.fail(this.f8312z, "decompression failure", iInflate);
                                } else {
                                    int iInflateSetDictionary = this.f8312z.inflateSetDictionary(bArr2, bArr2.length);
                                    if (iInflateSetDictionary != 0) {
                                        ZlibUtil.fail(this.f8312z, "failed to set the dictionary", iInflateSetDictionary);
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    } else if (this.f8312z.avail_in <= 0) {
                        break;
                    }
                } catch (Throwable th2) {
                    byteBuf.skipBytes(this.f8312z.next_in_index - i11);
                    if (byteBufPrepareDecompressBuffer.isReadable()) {
                        list.add(byteBufPrepareDecompressBuffer);
                    } else {
                        byteBufPrepareDecompressBuffer.release();
                    }
                    throw th2;
                }
            }
            byteBuf.skipBytes(this.f8312z.next_in_index - i11);
            if (byteBufPrepareDecompressBuffer.isReadable()) {
                list.add(byteBufPrepareDecompressBuffer);
            } else {
                byteBufPrepareDecompressBuffer.release();
            }
            this.f8312z.next_in = null;
            this.f8312z.next_out = null;
        } catch (Throwable th3) {
            this.f8312z.next_in = null;
            this.f8312z.next_out = null;
            throw th3;
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public void decompressionBufferExhausted(ByteBuf byteBuf) {
        this.finished = true;
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    public JZlibDecoder(int i10) {
        this(ZlibWrapper.ZLIB, i10);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 0);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper, int i10) {
        super(i10);
        Inflater inflater = new Inflater();
        this.f8312z = inflater;
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        int iInit = inflater.init(ZlibUtil.convertWrapperType(zlibWrapper));
        if (iInit != 0) {
            ZlibUtil.fail(inflater, "initialization failure", iInit);
        }
    }

    public JZlibDecoder(byte[] bArr) {
        this(bArr, 0);
    }

    public JZlibDecoder(byte[] bArr, int i10) {
        super(i10);
        Inflater inflater = new Inflater();
        this.f8312z = inflater;
        this.dictionary = (byte[]) ObjectUtil.checkNotNull(bArr, "dictionary");
        int iInflateInit = inflater.inflateInit(JZlib.W_ZLIB);
        if (iInflateInit != 0) {
            ZlibUtil.fail(inflater, "initialization failure", iInflateInit);
        }
    }
}
