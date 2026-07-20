package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;

/* JADX INFO: loaded from: classes3.dex */
interface CompressionEncoderFactory {
    MessageToByteEncoder<ByteBuf> createEncoder();
}
