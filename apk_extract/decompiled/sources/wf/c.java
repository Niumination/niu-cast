package wf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ih.a f10742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10743b;

    public c(ih.a expectedType, Object response) {
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        Intrinsics.checkNotNullParameter(response, "response");
        this.f10742a = expectedType;
        this.f10743b = response;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.f10742a, cVar.f10742a) && Intrinsics.areEqual(this.f10743b, cVar.f10743b);
    }

    public final int hashCode() {
        return this.f10743b.hashCode() + (this.f10742a.hashCode() * 31);
    }

    public final String toString() {
        return "HttpResponseContainer(expectedType=" + this.f10742a + ", response=" + this.f10743b + ')';
    }
}
