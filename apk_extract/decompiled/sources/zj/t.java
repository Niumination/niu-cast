package zj;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends qj.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f11702b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, qj.h hVar) {
        super(hVar);
        this.f11702b = uVar;
    }

    @Override // qj.z
    public final long W(qj.f sink, long j8) throws IOException {
        try {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return this.f9198a.W(sink, j8);
        } catch (IOException e) {
            this.f11702b.f11706d = e;
            throw e;
        }
    }
}
