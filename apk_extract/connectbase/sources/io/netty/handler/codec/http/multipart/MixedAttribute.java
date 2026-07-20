package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class MixedAttribute extends AbstractMixedHttpData<Attribute> implements Attribute {
    public MixedAttribute(String str, long j10) {
        this(str, j10, HttpConstants.DEFAULT_CHARSET);
    }

    private static Attribute makeInitialAttributeFromValue(String str, String str2, long j10, Charset charset, String str3, boolean z10) {
        if (str2.length() <= j10) {
            try {
                return new MemoryAttribute(str, str2, charset);
            } catch (IOException e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        try {
            return new DiskAttribute(str, str2, charset, str3, z10);
        } catch (IOException e11) {
            try {
                return new MemoryAttribute(str, str2, charset);
            } catch (IOException unused) {
                throw new IllegalArgumentException(e11);
            }
        }
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ void addContent(ByteBuf byteBuf, boolean z10) throws IOException {
        super.addContent(byteBuf, z10);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ void checkSize(long j10) throws IOException {
        super.checkSize(j10);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData
    public /* bridge */ /* synthetic */ int compareTo(InterfaceHttpData interfaceHttpData) {
        return super.compareTo(interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.buffer.ByteBufHolder
    public /* bridge */ /* synthetic */ ByteBuf content() {
        return super.content();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ long definedLength() {
        return super.definedLength();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ void delete() {
        super.delete();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ byte[] get() throws IOException {
        return super.get();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ ByteBuf getByteBuf() throws IOException {
        return super.getByteBuf();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ Charset getCharset() {
        return super.getCharset();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ ByteBuf getChunk(int i10) throws IOException {
        return super.getChunk(i10);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ File getFile() throws IOException {
        return super.getFile();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.InterfaceHttpData
    public /* bridge */ /* synthetic */ InterfaceHttpData.HttpDataType getHttpDataType() {
        return super.getHttpDataType();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ long getMaxSize() {
        return super.getMaxSize();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.InterfaceHttpData
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ String getString() throws IOException {
        return super.getString();
    }

    @Override // io.netty.handler.codec.http.multipart.Attribute
    public String getValue() throws IOException {
        return ((Attribute) this.wrapped).getValue();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ boolean isCompleted() {
        return super.isCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ boolean isInMemory() {
        return super.isInMemory();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ long length() {
        return super.length();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ boolean renameTo(File file) throws IOException {
        return super.renameTo(file);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ void setCharset(Charset charset) {
        super.setCharset(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ void setContent(ByteBuf byteBuf) throws IOException {
        super.setContent(byteBuf);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ void setMaxSize(long j10) {
        super.setMaxSize(j10);
    }

    @Override // io.netty.handler.codec.http.multipart.Attribute
    public void setValue(String str) throws IOException {
        ((Attribute) this.wrapped).setValue(str);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public MixedAttribute(String str, long j10, long j11) {
        this(str, j10, j11, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ String getString(Charset charset) throws IOException {
        return super.getString(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData
    public Attribute makeDiskData() {
        DiskAttribute diskAttribute = new DiskAttribute(getName(), definedLength(), this.baseDir, this.deleteOnExit);
        diskAttribute.setMaxSize(getMaxSize());
        return diskAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ void setContent(File file) throws IOException {
        super.setContent(file);
    }

    public MixedAttribute(String str, long j10, Charset charset) {
        this(str, j10, charset, DiskAttribute.baseDirectory, DiskAttribute.deleteOnExitTemporaryFile);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute copy() {
        return (Attribute) super.copy();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute duplicate() {
        return (Attribute) super.duplicate();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute replace(ByteBuf byteBuf) {
        return (Attribute) super.replace(byteBuf);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute retainedDuplicate() {
        return (Attribute) super.retainedDuplicate();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.handler.codec.http.multipart.HttpData
    public /* bridge */ /* synthetic */ void setContent(InputStream inputStream) throws IOException {
        super.setContent(inputStream);
    }

    public MixedAttribute(String str, long j10, Charset charset, String str2, boolean z10) {
        this(str, 0L, j10, charset, str2, z10);
    }

    public MixedAttribute(String str, long j10, long j11, Charset charset) {
        this(str, j10, j11, charset, DiskAttribute.baseDirectory, DiskAttribute.deleteOnExitTemporaryFile);
    }

    public MixedAttribute(String str, long j10, long j11, Charset charset, String str2, boolean z10) {
        super(j11, str2, z10, new MemoryAttribute(str, j10, charset));
    }

    public MixedAttribute(String str, String str2, long j10) {
        this(str, str2, j10, HttpConstants.DEFAULT_CHARSET, DiskAttribute.baseDirectory, DiskFileUpload.deleteOnExitTemporaryFile);
    }

    public MixedAttribute(String str, String str2, long j10, Charset charset) {
        this(str, str2, j10, charset, DiskAttribute.baseDirectory, DiskFileUpload.deleteOnExitTemporaryFile);
    }

    public MixedAttribute(String str, String str2, long j10, Charset charset, String str3, boolean z10) {
        super(j10, str3, z10, makeInitialAttributeFromValue(str, str2, j10, charset, str3, z10));
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute retain() {
        return (Attribute) super.retain();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute touch() {
        return (Attribute) super.touch();
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute retain(int i10) {
        return (Attribute) super.retain(i10);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMixedHttpData, io.netty.util.ReferenceCounted
    public Attribute touch(Object obj) {
        return (Attribute) super.touch(obj);
    }
}
