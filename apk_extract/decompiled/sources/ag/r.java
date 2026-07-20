package ag;

import com.transsion.widgetsliquid.view.OSLiquidSearchBar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k3.c1;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public static final r e;
    public static final se.e f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f787d;

    static {
        boolean z2 = true;
        boolean z3 = false;
        r rVar = new r(z2, z3, z3, 14);
        r rVar2 = new r(z3, z2, z3, 13);
        e = rVar2;
        f = c1.a(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("close", rVar), TuplesKt.to("keep-alive", rVar2), TuplesKt.to("upgrade", new r(z3, z3, z2, 11))}), new b(1), new q(0));
    }

    public r(boolean z2, boolean z3, boolean z5, List extraOptions) {
        Intrinsics.checkNotNullParameter(extraOptions, "extraOptions");
        this.f784a = z2;
        this.f785b = z3;
        this.f786c = z5;
        this.f787d = extraOptions;
    }

    public final String a() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        List list = this.f787d;
        ArrayList arrayList = new ArrayList(list.size() + 3);
        if (this.f784a) {
            arrayList.add("close");
        }
        if (this.f785b) {
            arrayList.add("keep-alive");
        }
        if (this.f786c) {
            arrayList.add("Upgrade");
        }
        List list2 = list;
        if (!list2.isEmpty()) {
            arrayList.addAll(list2);
        }
        CollectionsKt___CollectionsKt.joinTo(arrayList, sb2, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 2) != 0 ? ", " : null, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 4) != 0 ? "" : null, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 8) == 0 ? null : "", (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 16) != 0 ? -1 : 0, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 32) != 0 ? "..." : null, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 64) != 0 ? null : null);
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.f784a == rVar.f784a && this.f785b == rVar.f785b && this.f786c == rVar.f786c && Intrinsics.areEqual(this.f787d, rVar.f787d);
    }

    public final int hashCode() {
        return this.f787d.hashCode() + a1.a.g(this.f786c, a1.a.g(this.f785b, Boolean.hashCode(this.f784a) * 31, 31), 31);
    }

    public final String toString() {
        if (!this.f787d.isEmpty()) {
            return a();
        }
        boolean z2 = this.f786c;
        boolean z3 = this.f785b;
        boolean z5 = this.f784a;
        if (z5 && !z3 && !z2) {
            return "close";
        }
        if (z5 || !z3 || z2) {
            return (!z5 && z3 && z2) ? "keep-alive, Upgrade" : a();
        }
        return "keep-alive";
    }

    public /* synthetic */ r(boolean z2, boolean z3, boolean z5, int i8) {
        this((i8 & 1) != 0 ? false : z2, (i8 & 2) != 0 ? false : z3, (i8 & 4) != 0 ? false : z5, CollectionsKt.emptyList());
    }
}
