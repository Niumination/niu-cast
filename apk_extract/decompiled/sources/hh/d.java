package hh;

import java.util.ArrayList;
import java.util.List;
import k3.c9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final ArrayList e = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f5393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c9 f5394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f5395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5396d;

    public d(h phase, c9 relation, List interceptors) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.f5393a = phase;
        this.f5394b = relation;
        this.f5395c = interceptors;
        this.f5396d = true;
    }

    public final void a(List destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        List list = this.f5395c;
        if (destination instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) destination;
            arrayList.ensureCapacity(list.size() + arrayList.size());
        }
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            destination.add(list.get(i8));
        }
    }

    public final String toString() {
        return "Phase `" + this.f5393a.f5403a + "`, " + this.f5395c.size() + " handlers";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(h phase, c9 relation) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(relation, "relation");
        ArrayList arrayList = e;
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableList<@[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.Unit>>");
        this(phase, relation, TypeIntrinsics.asMutableList(arrayList));
        if (!arrayList.isEmpty()) {
            throw new IllegalStateException("The shared empty array list has been modified");
        }
    }
}
