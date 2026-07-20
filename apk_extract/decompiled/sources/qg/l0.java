package qg;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l0 extends FunctionReferenceImpl implements Function0 {
    public l0(Object obj) {
        super(0, obj, p0.class, "currentApplication", "currentApplication()Lio/ktor/server/application/Application;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final mg.a invoke() {
        return ((p0) this.receiver).b();
    }
}
