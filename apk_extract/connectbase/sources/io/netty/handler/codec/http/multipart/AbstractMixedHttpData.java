package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.multipart.HttpData;
import io.netty.util.AbstractReferenceCounted;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractMixedHttpData<D extends HttpData> extends AbstractReferenceCounted implements HttpData {
    final String baseDir;
    final boolean deleteOnExit;
    private final long limitSize;
    D wrapped;

    public AbstractMixedHttpData(long j10, String str, boolean z10, D d10) {
        this.limitSize = j10;
        this.wrapped = d10;
        this.baseDir = str;
        this.deleteOnExit = z10;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z10) throws IOException {
        D d10 = this.wrapped;
        if (d10 instanceof AbstractMemoryHttpData) {
            try {
                checkSize(d10.length() + ((long) byteBuf.readableBytes()));
                if (this.wrapped.length() + ((long) byteBuf.readableBytes()) > this.limitSize) {
                    D d11 = (D) makeDiskData();
                    ByteBuf byteBuf2 = ((AbstractMemoryHttpData) this.wrapped).getByteBuf();
                    if (byteBuf2 != null && byteBuf2.isReadable()) {
                        d11.addContent(byteBuf2.retain(), false);
                    }
                    this.wrapped.release();
                    this.wrapped = d11;
                }
            } catch (IOException e10) {
                byteBuf.release();
                throw e10;
            }
        }
        this.wrapped.addContent(byteBuf, z10);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void checkSize(long j10) throws IOException {
        this.wrapped.checkSize(j10);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.wrapped.content();
    }

    @Override // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
        delete();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long definedLength() {
        return this.wrapped.definedLength();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        this.wrapped.delete();
    }

    public boolean equals(Object obj) {
        return this.wrapped.equals(obj);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() throws IOException {
        return this.wrapped.get();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() throws IOException {
        return this.wrapped.getByteBuf();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public Charset getCharset() {
        return this.wrapped.getCharset();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i10) throws IOException {
        return this.wrapped.getChunk(i10);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        return this.wrapped.getFile();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return this.wrapped.getHttpDataType();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long getMaxSize() {
        return this.wrapped.getMaxSize();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public String getName() {
        return this.wrapped.getName();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() throws IOException {
        return this.wrapped.getString();
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isCompleted() {
        return this.wrapped.isCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return this.wrapped.isInMemory();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long length() {
        return this.wrapped.length();
    }

    public abstract D makeDiskData();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean renameTo(File file) throws IOException {
        return this.wrapped.renameTo(file);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setCharset(Charset charset) {
        this.wrapped.setCharset(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        try {
            checkSize(byteBuf.readableBytes());
            if (byteBuf.readableBytes() > this.limitSize) {
                D d10 = this.wrapped;
                if (d10 instanceof AbstractMemoryHttpData) {
                    d10.release();
                    this.wrapped = (D) makeDiskData();
                }
            }
            this.wrapped.setContent(byteBuf);
        } catch (IOException e10) {
            byteBuf.release();
            throw e10;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setMaxSize(long j10) {
        this.wrapped.setMaxSize(j10);
    }

    public String toString() {
        return "Mixed: " + this.wrapped;
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        return this.wrapped.compareTo(interfaceHttpData);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public D copy() {
        return (D) this.wrapped.copy();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public D duplicate() {
        return (D) this.wrapped.duplicate();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) throws IOException {
        return this.wrapped.getString(charset);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public D replace(ByteBuf byteBuf) {
        return (D) this.wrapped.replace(byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public D retainedDuplicate() {
        return (D) this.wrapped.retainedDuplicate();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public D retain() {
        return (D) super.retain();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public D touch() {
        this.wrapped.touch();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public D retain(int i10) {
        return (D) super.retain(i10);
    }

    @Override // io.netty.util.ReferenceCounted
    public D touch(Object obj) {
        this.wrapped.touch(obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        checkSize(file.length());
        if (file.length() > this.limitSize) {
            D d10 = this.wrapped;
            if (d10 instanceof AbstractMemoryHttpData) {
                d10.release();
                this.wrapped = (D) makeDiskData();
            }
        }
        this.wrapped.setContent(file);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        D d10 = this.wrapped;
        if (d10 instanceof AbstractMemoryHttpData) {
            d10.release();
            this.wrapped = (D) makeDiskData();
        }
        this.wrapped.setContent(inputStream);
    }
}
