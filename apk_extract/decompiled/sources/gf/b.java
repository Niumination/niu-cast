package gf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import k3.v8;
import ze.q2;
import ze.s2;
import ze.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f5180d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parser f5181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GeneratedMessageLite f5182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5183c;

    public b(GeneratedMessageLite generatedMessageLite) {
        v8.i(generatedMessageLite, "defaultInstance cannot be null");
        this.f5182b = generatedMessageLite;
        this.f5181a = generatedMessageLite.getParserForType();
        this.f5183c = -1;
    }

    public final MessageLite a(InputStream inputStream) {
        CodedInputStream codedInputStreamNewInstance;
        byte[] bArr;
        if ((inputStream instanceof a) && ((a) inputStream).f5178b == this.f5181a) {
            try {
                MessageLite messageLite = ((a) inputStream).f5177a;
                if (messageLite != null) {
                    return messageLite;
                }
                throw new IllegalStateException("message not available");
            } catch (IllegalStateException unused) {
            }
        }
        try {
            if (inputStream instanceof w0) {
                int iAvailable = inputStream.available();
                if (iAvailable <= 0 || iAvailable > 4194304) {
                    if (iAvailable == 0) {
                        return this.f5182b;
                    }
                    codedInputStreamNewInstance = null;
                } else {
                    ThreadLocal threadLocal = f5180d;
                    Reference reference = (Reference) threadLocal.get();
                    if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < iAvailable) {
                        bArr = new byte[iAvailable];
                        threadLocal.set(new WeakReference(bArr));
                    }
                    int i8 = iAvailable;
                    while (i8 > 0) {
                        int i9 = inputStream.read(bArr, iAvailable - i8, i8);
                        if (i9 == -1) {
                            break;
                        }
                        i8 -= i9;
                    }
                    if (i8 != 0) {
                        throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i8));
                    }
                    codedInputStreamNewInstance = CodedInputStream.newInstance(bArr, 0, iAvailable);
                }
            } else {
                codedInputStreamNewInstance = null;
            }
            if (codedInputStreamNewInstance == null) {
                codedInputStreamNewInstance = CodedInputStream.newInstance(inputStream);
            }
            codedInputStreamNewInstance.setSizeLimit(Integer.MAX_VALUE);
            int i10 = this.f5183c;
            if (i10 >= 0) {
                codedInputStreamNewInstance.setRecursionLimit(i10);
            }
            try {
                MessageLite messageLite2 = (MessageLite) this.f5181a.parseFrom(codedInputStreamNewInstance, c.f5184a);
                try {
                    codedInputStreamNewInstance.checkLastTagWas(0);
                    return messageLite2;
                } catch (InvalidProtocolBufferException e) {
                    e.setUnfinishedMessage(messageLite2);
                    throw e;
                }
            } catch (InvalidProtocolBufferException e4) {
                throw new s2(q2.f11410m.h("Invalid protobuf byte sequence").g(e4));
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }
}
