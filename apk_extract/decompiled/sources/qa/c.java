package qa;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends GeneratedMessageLite implements MessageLiteOrBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile GeneratedMessageLite.DefaultInstanceBasedParser f8968b;

    static {
        c cVar = new c();
        f8967a = cVar;
        GeneratedMessageLite.registerDefaultInstance(c.class, cVar);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (a.f8966a[methodToInvoke.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new b(f8967a);
            case 3:
                return GeneratedMessageLite.newMessageInfo(f8967a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"packageNameReply_"});
            case 4:
                return f8967a;
            case 5:
                GeneratedMessageLite.DefaultInstanceBasedParser defaultInstanceBasedParser = f8968b;
                if (defaultInstanceBasedParser == null) {
                    synchronized (c.class) {
                        try {
                            defaultInstanceBasedParser = f8968b;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(f8967a);
                                f8968b = defaultInstanceBasedParser;
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
