package io.netty.handler.codec.http.multipart;

import fl.h;
import ik.f;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryFileUpload extends AbstractMemoryHttpData implements FileUpload {
    private String contentTransferEncoding;
    private String contentType;
    private String filename;

    public MemoryFileUpload(String str, String str2, String str3, String str4, Charset charset, long j10) {
        super(str, charset, j10);
        setFilename(str2);
        setContentType(str3);
        setContentTransferEncoding(str4);
    }

    public boolean equals(Object obj) {
        return (obj instanceof FileUpload) && FileUploadUtil.equals(this, (FileUpload) obj);
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getContentTransferEncoding() {
        return this.contentTransferEncoding;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getContentType() {
        return this.contentType;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getFilename() {
        return this.filename;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.FileUpload;
    }

    public int hashCode() {
        return FileUploadUtil.hashCode(this);
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setContentTransferEncoding(String str) {
        this.contentTransferEncoding = str;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setContentType(String str) {
        this.contentType = (String) ObjectUtil.checkNotNull(str, "contentType");
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setFilename(String str) {
        this.filename = (String) ObjectUtil.checkNotNull(str, f.b.f7967b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) HttpHeaderNames.CONTENT_DISPOSITION);
        sb2.append(": ");
        sb2.append((Object) HttpHeaderValues.FORM_DATA);
        sb2.append("; ");
        sb2.append((Object) HttpHeaderValues.NAME);
        sb2.append("=\"");
        sb2.append(getName());
        sb2.append("\"; ");
        sb2.append((Object) HttpHeaderValues.FILENAME);
        sb2.append("=\"");
        sb2.append(this.filename);
        sb2.append("\"\r\n");
        sb2.append((Object) HttpHeaderNames.CONTENT_TYPE);
        sb2.append(": ");
        sb2.append(this.contentType);
        String str = "\r\n";
        if (getCharset() != null) {
            str = "; " + ((Object) HttpHeaderValues.CHARSET) + h.f6043c + getCharset().name() + "\r\n";
        }
        sb2.append(str);
        sb2.append((Object) HttpHeaderNames.CONTENT_LENGTH);
        sb2.append(": ");
        sb2.append(length());
        sb2.append("\r\nCompleted: ");
        sb2.append(isCompleted());
        sb2.append("\r\nIsInMemory: ");
        sb2.append(isInMemory());
        return sb2.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof FileUpload) {
            return compareTo((FileUpload) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload copy() {
        ByteBuf byteBufContent = content();
        if (byteBufContent != null) {
            byteBufContent = byteBufContent.copy();
        }
        return replace(byteBufContent);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload duplicate() {
        ByteBuf byteBufContent = content();
        if (byteBufContent != null) {
            byteBufContent = byteBufContent.duplicate();
        }
        return replace(byteBufContent);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload replace(ByteBuf byteBuf) {
        MemoryFileUpload memoryFileUpload = new MemoryFileUpload(getName(), getFilename(), getContentType(), getContentTransferEncoding(), getCharset(), this.size);
        if (byteBuf != null) {
            try {
                memoryFileUpload.setContent(byteBuf);
            } catch (IOException e10) {
                throw new ChannelException(e10);
            }
        }
        memoryFileUpload.setCompleted(isCompleted());
        return memoryFileUpload;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload retainedDuplicate() {
        ByteBuf byteBufContent = content();
        if (byteBufContent != null) {
            ByteBuf byteBufRetainedDuplicate = byteBufContent.retainedDuplicate();
            try {
                return replace(byteBufRetainedDuplicate);
            } catch (Throwable th2) {
                byteBufRetainedDuplicate.release();
                throw th2;
            }
        }
        return replace((ByteBuf) null);
    }

    public int compareTo(FileUpload fileUpload) {
        return FileUploadUtil.compareTo(this, fileUpload);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMemoryHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload retain(int i10) {
        super.retain(i10);
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractMemoryHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public FileUpload touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
