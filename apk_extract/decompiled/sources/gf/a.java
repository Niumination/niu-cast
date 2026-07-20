package gf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import ze.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends InputStream implements w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageLite f5177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parser f5178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f5179c;

    public a(MessageLite messageLite, Parser parser) {
        this.f5177a = messageLite;
        this.f5178b = parser;
    }

    @Override // java.io.InputStream
    public final int available() {
        MessageLite messageLite = this.f5177a;
        if (messageLite != null) {
            return messageLite.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.f5179c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f5177a != null) {
            this.f5179c = new ByteArrayInputStream(this.f5177a.toByteArray());
            this.f5177a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f5179c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i8, int i9) throws IOException {
        MessageLite messageLite = this.f5177a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            if (serializedSize == 0) {
                this.f5177a = null;
                this.f5179c = null;
                return -1;
            }
            if (i9 >= serializedSize) {
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bArr, i8, serializedSize);
                this.f5177a.writeTo(codedOutputStreamNewInstance);
                codedOutputStreamNewInstance.flush();
                codedOutputStreamNewInstance.checkNoSpaceLeft();
                this.f5177a = null;
                this.f5179c = null;
                return serializedSize;
            }
            this.f5179c = new ByteArrayInputStream(this.f5177a.toByteArray());
            this.f5177a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f5179c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i8, i9);
        }
        return -1;
    }
}
