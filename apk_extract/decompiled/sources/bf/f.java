package bf;

import com.google.protobuf.GeneratedMessageLite;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GeneratedMessageLite f1280a;

    public f(GeneratedMessageLite generatedMessageLite) {
        this.f1280a = generatedMessageLite;
    }

    @Override // bf.g
    public final Object a(ze.j jVar, t tVar, Continuation continuation) {
        jVar.e(this.f1280a);
        return Unit.INSTANCE;
    }
}
