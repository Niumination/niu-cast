package kj;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f6927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f6928b;

    public n(s sVar, w reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.f6928b = sVar;
        this.f6927a = reader;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        c cVar;
        s sVar = this.f6928b;
        w wVar = this.f6927a;
        c cVar2 = c.INTERNAL_ERROR;
        IOException e = null;
        try {
            wVar.c(this);
            while (wVar.a(false, this)) {
            }
            cVar = c.NO_ERROR;
            try {
                try {
                    sVar.a(cVar, c.CANCEL, null);
                } catch (IOException e4) {
                    e = e4;
                    c cVar3 = c.PROTOCOL_ERROR;
                    sVar.a(cVar3, cVar3, e);
                }
            } catch (Throwable th2) {
                th = th2;
                sVar.a(cVar, cVar2, e);
                ej.b.d(wVar);
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
        } catch (Throwable th3) {
            th = th3;
            cVar = cVar2;
            sVar.a(cVar, cVar2, e);
            ej.b.d(wVar);
            throw th;
        }
        ej.b.d(wVar);
        return Unit.INSTANCE;
    }
}
