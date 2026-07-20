package io.netty.handler.codec.http.multipart;

import fl.h;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class DiskAttribute extends AbstractDiskHttpData implements Attribute {
    public static String baseDirectory = null;
    public static boolean deleteOnExitTemporaryFile = true;
    public static final String postfix = ".att";
    public static final String prefix = "Attr_";
    private String baseDir;
    private boolean deleteOnExit;

    public DiskAttribute(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z10) throws IOException {
        long j10 = this.size + ((long) byteBuf.readableBytes());
        try {
            checkSize(j10);
            long j11 = this.definedSize;
            if (j11 > 0 && j11 < j10) {
                this.definedSize = j10;
            }
            super.addContent(byteBuf, z10);
        } catch (IOException e10) {
            byteBuf.release();
            throw e10;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    public boolean deleteOnExit() {
        return this.deleteOnExit;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Attribute) {
            return getName().equalsIgnoreCase(((Attribute) obj).getName());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    public String getBaseDirectory() {
        return this.baseDir;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    public String getDiskFilename() {
        return getName() + postfix;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.Attribute;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    public String getPostfix() {
        return postfix;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    public String getPrefix() {
        return prefix;
    }

    @Override // io.netty.handler.codec.http.multipart.Attribute
    public String getValue() throws IOException {
        return new String(get(), getCharset());
    }

    public int hashCode() {
        return getName().hashCode();
    }

    @Override // io.netty.handler.codec.http.multipart.Attribute
    public void setValue(String str) throws IOException {
        ObjectUtil.checkNotNull(str, "value");
        byte[] bytes = str.getBytes(getCharset());
        checkSize(bytes.length);
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(bytes);
        if (this.definedSize > 0) {
            this.definedSize = byteBufWrappedBuffer.readableBytes();
        }
        setContent(byteBufWrappedBuffer);
    }

    public String toString() {
        try {
            return getName() + h.f6043c + getValue();
        } catch (IOException e10) {
            return getName() + h.f6043c + e10;
        }
    }

    public DiskAttribute(String str, String str2, boolean z10) {
        this(str, HttpConstants.DEFAULT_CHARSET);
        this.baseDir = str2 == null ? baseDirectory : str2;
        this.deleteOnExit = z10;
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof Attribute) {
            return compareTo((Attribute) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute copy() {
        ByteBuf byteBufContent = content();
        return replace(byteBufContent != null ? byteBufContent.copy() : null);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute duplicate() {
        ByteBuf byteBufContent = content();
        return replace(byteBufContent != null ? byteBufContent.duplicate() : null);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute replace(ByteBuf byteBuf) {
        DiskAttribute diskAttribute = new DiskAttribute(getName(), this.baseDir, this.deleteOnExit);
        diskAttribute.setCharset(getCharset());
        if (byteBuf != null) {
            try {
                diskAttribute.setContent(byteBuf);
            } catch (IOException e10) {
                throw new ChannelException(e10);
            }
        }
        diskAttribute.setCompleted(isCompleted());
        return diskAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public Attribute retainedDuplicate() {
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

    public DiskAttribute(String str, long j10) {
        this(str, j10, HttpConstants.DEFAULT_CHARSET, baseDirectory, deleteOnExitTemporaryFile);
    }

    public DiskAttribute(String str, long j10, String str2, boolean z10) {
        this(str, j10, HttpConstants.DEFAULT_CHARSET);
        this.baseDir = str2 == null ? baseDirectory : str2;
        this.deleteOnExit = z10;
    }

    public int compareTo(Attribute attribute) {
        return getName().compareToIgnoreCase(attribute.getName());
    }

    public DiskAttribute(String str, Charset charset) {
        this(str, charset, baseDirectory, deleteOnExitTemporaryFile);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute retain(int i10) {
        super.retain(i10);
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute touch() {
        super.touch();
        return this;
    }

    public DiskAttribute(String str, Charset charset, String str2, boolean z10) {
        super(str, charset, 0L);
        this.baseDir = str2 == null ? baseDirectory : str2;
        this.deleteOnExit = z10;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public Attribute retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public Attribute touch(Object obj) {
        super.touch(obj);
        return this;
    }

    public DiskAttribute(String str, long j10, Charset charset) {
        this(str, j10, charset, baseDirectory, deleteOnExitTemporaryFile);
    }

    public DiskAttribute(String str, long j10, Charset charset, String str2, boolean z10) {
        super(str, charset, j10);
        this.baseDir = str2 == null ? baseDirectory : str2;
        this.deleteOnExit = z10;
    }

    public DiskAttribute(String str, String str2) throws IOException {
        this(str, str2, HttpConstants.DEFAULT_CHARSET);
    }

    public DiskAttribute(String str, String str2, Charset charset) throws IOException {
        this(str, str2, charset, baseDirectory, deleteOnExitTemporaryFile);
    }

    public DiskAttribute(String str, String str2, Charset charset, String str3, boolean z10) throws IOException {
        super(str, charset, 0L);
        setValue(str2);
        this.baseDir = str3 == null ? baseDirectory : str3;
        this.deleteOnExit = z10;
    }
}
