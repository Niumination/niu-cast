package fp;

import fp.q;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<MessageType extends q> implements s<MessageType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6196a = g.c();

    public final MessageType e(MessageType messagetype) throws k {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw f(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    public final w f(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).newUninitializedMessageException() : new w(messagetype);
    }

    @Override // fp.s
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public MessageType d(InputStream inputStream, g gVar) throws k {
        return (MessageType) e(j(inputStream, gVar));
    }

    @Override // fp.s
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public MessageType a(d dVar, g gVar) throws k {
        return (MessageType) e(k(dVar, gVar));
    }

    @Override // fp.s
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public MessageType b(InputStream inputStream, g gVar) throws k {
        return (MessageType) e(l(inputStream, gVar));
    }

    public MessageType j(InputStream inputStream, g gVar) throws k {
        try {
            int i10 = inputStream.read();
            if (i10 == -1) {
                return null;
            }
            return (MessageType) l(new a.AbstractC0147a.C0148a(inputStream, e.B(i10, inputStream)), gVar);
        } catch (IOException e10) {
            throw new k(e10.getMessage());
        }
    }

    public MessageType k(d dVar, g gVar) throws k {
        e eVarO = dVar.o();
        MessageType messagetypeC = c(eVarO, gVar);
        try {
            eVarO.a(0);
            return messagetypeC;
        } catch (k e10) {
            throw e10.setUnfinishedMessage(messagetypeC);
        }
    }

    public MessageType l(InputStream inputStream, g gVar) throws k {
        e eVar = new e(inputStream);
        MessageType messagetypeC = c(eVar, gVar);
        try {
            eVar.a(0);
            return messagetypeC;
        } catch (k e10) {
            throw e10.setUnfinishedMessage(messagetypeC);
        }
    }
}
