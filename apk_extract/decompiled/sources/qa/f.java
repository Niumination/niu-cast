package qa;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends GeneratedMessageLite implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f8970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile GeneratedMessageLite.DefaultInstanceBasedParser f8971c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8972a = "";

    static {
        f fVar = new f();
        f8970b = fVar;
        GeneratedMessageLite.registerDefaultInstance(f.class, fVar);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (d.f8969a[methodToInvoke.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return new e(f8970b);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f8970b, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"packageNameRequest_"});
            case 4:
                return f8970b;
            case 5:
                GeneratedMessageLite.DefaultInstanceBasedParser defaultInstanceBasedParser = f8971c;
                if (defaultInstanceBasedParser == null) {
                    synchronized (f.class) {
                        try {
                            defaultInstanceBasedParser = f8971c;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(f8970b);
                                f8971c = defaultInstanceBasedParser;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
