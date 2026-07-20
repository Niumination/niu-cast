package zj;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import gm.j;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import vj.c0;
import vj.n1;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends InputStream implements c0, n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @j
    public MessageLite f21931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parser<?> f21932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @j
    public ByteArrayInputStream f21933c;

    public a(MessageLite messageLite, Parser<?> parser) {
        this.f21931a = messageLite;
        this.f21932b = parser;
    }

    @Override // java.io.InputStream, vj.n1
    public int available() {
        MessageLite messageLite = this.f21931a;
        if (messageLite != null) {
            return messageLite.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.f21933c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // vj.c0
    public int b(OutputStream outputStream) throws IOException {
        MessageLite messageLite = this.f21931a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            this.f21931a.writeTo(outputStream);
            this.f21931a = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.f21933c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int iA = (int) b.a(byteArrayInputStream, outputStream);
        this.f21933c = null;
        return iA;
    }

    public MessageLite c() {
        MessageLite messageLite = this.f21931a;
        if (messageLite != null) {
            return messageLite;
        }
        throw new IllegalStateException("message not available");
    }

    public Parser<?> d() {
        return this.f21932b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f21931a != null) {
            this.f21933c = new ByteArrayInputStream(this.f21931a.toByteArray());
            this.f21931a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f21933c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        MessageLite messageLite = this.f21931a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            if (serializedSize == 0) {
                this.f21931a = null;
                this.f21933c = null;
                return -1;
            }
            if (i11 >= serializedSize) {
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bArr, i10, serializedSize);
                this.f21931a.writeTo(codedOutputStreamNewInstance);
                codedOutputStreamNewInstance.flush();
                codedOutputStreamNewInstance.checkNoSpaceLeft();
                this.f21931a = null;
                this.f21933c = null;
                return serializedSize;
            }
            this.f21933c = new ByteArrayInputStream(this.f21931a.toByteArray());
            this.f21931a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f21933c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i10, i11);
        }
        return -1;
    }
}
