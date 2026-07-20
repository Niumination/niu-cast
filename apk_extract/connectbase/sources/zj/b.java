package zj;

import b1.e;
import c1.h0;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import vj.a3;
import vj.e0;
import vj.n1;
import vj.v1;
import vj.w1;
import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
@e0("Will remain experimental as protobuf lite API is not stable")
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ExtensionRegistryLite f21934a = ExtensionRegistryLite.getEmptyRegistry();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21935b = 8192;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @e
    public static final int f21936c = 4194304;

    public static final class a<T extends MessageLite> implements w1.e<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ThreadLocal<Reference<byte[]>> f21937d = new ThreadLocal<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Parser<T> f21938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f21939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21940c;

        public a(T t10, int i10) {
            this.f21939b = (T) h0.F(t10, "defaultInstance cannot be null");
            this.f21938a = (Parser<T>) t10.getParserForType();
            this.f21940c = i10;
        }

        @Override // vj.w1.f
        public Class<T> b() {
            return (Class<T>) this.f21939b.getClass();
        }

        @Override // vj.w1.e
        public Object d() {
            return this.f21939b;
        }

        public T e() {
            return this.f21939b;
        }

        @Override // vj.w1.c
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public T c(InputStream inputStream) {
            CodedInputStream codedInputStreamNewInstance;
            byte[] bArr;
            if ((inputStream instanceof zj.a) && ((zj.a) inputStream).f21932b == this.f21938a) {
                try {
                    return (T) ((zj.a) inputStream).c();
                } catch (IllegalStateException unused) {
                }
            }
            try {
                if (inputStream instanceof n1) {
                    int iAvailable = inputStream.available();
                    if (iAvailable <= 0 || iAvailable > 4194304) {
                        if (iAvailable == 0) {
                            return this.f21939b;
                        }
                        codedInputStreamNewInstance = null;
                    } else {
                        ThreadLocal<Reference<byte[]>> threadLocal = f21937d;
                        Reference<byte[]> reference = threadLocal.get();
                        if (reference == null || (bArr = reference.get()) == null || bArr.length < iAvailable) {
                            bArr = new byte[iAvailable];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i10 = iAvailable;
                        while (i10 > 0) {
                            int i11 = inputStream.read(bArr, iAvailable - i10, i10);
                            if (i11 == -1) {
                                break;
                            }
                            i10 -= i11;
                        }
                        if (i10 != 0) {
                            throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i10));
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
                int i12 = this.f21940c;
                if (i12 >= 0) {
                    codedInputStreamNewInstance.setRecursionLimit(i12);
                }
                try {
                    return (T) g(codedInputStreamNewInstance);
                } catch (InvalidProtocolBufferException e10) {
                    y2 y2VarT = y2.f17562s.u("Invalid protobuf byte sequence").t(e10);
                    y2VarT.getClass();
                    throw new a3(y2VarT);
                }
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        public final T g(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
            T from = this.f21938a.parseFrom(codedInputStream, b.f21934a);
            try {
                codedInputStream.checkLastTagWas(0);
                return from;
            } catch (InvalidProtocolBufferException e10) {
                e10.setUnfinishedMessage(from);
                throw e10;
            }
        }

        @Override // vj.w1.c
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public InputStream a(T t10) {
            return new zj.a(t10, this.f21938a);
        }
    }

    /* JADX INFO: renamed from: zj.b$b, reason: collision with other inner class name */
    public static final class C0605b<T extends MessageLite> implements v1.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f21941a;

        public C0605b(T t10) {
            this.f21941a = t10;
        }

        @Override // vj.v1.f
        public byte[] a(Object obj) {
            return ((MessageLite) obj).toByteArray();
        }

        @Override // vj.v1.f
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public T b(byte[] bArr) {
            try {
                return (T) this.f21941a.getParserForType().parseFrom(bArr, b.f21934a);
            } catch (InvalidProtocolBufferException e10) {
                throw new IllegalArgumentException(e10);
            }
        }

        public byte[] d(T t10) {
            return t10.toByteArray();
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        h0.F(inputStream, "inputStream cannot be null!");
        h0.F(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, i10);
            j10 += (long) i10;
        }
    }

    public static <T extends MessageLite> w1.c<T> b(T t10) {
        return new a(t10, -1);
    }

    @e0("https://github.com/grpc/grpc-java/issues/10108")
    public static <T extends MessageLite> w1.c<T> c(T t10, int i10) {
        return new a(t10, i10);
    }

    public static <T extends MessageLite> v1.f<T> d(T t10) {
        return new C0605b(t10);
    }

    public static void e(ExtensionRegistryLite extensionRegistryLite) {
        f21934a = (ExtensionRegistryLite) h0.F(extensionRegistryLite, "newRegistry");
    }
}
