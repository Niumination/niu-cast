package dj;

import java.util.ArrayList;
import java.util.Iterator;
import k3.v1;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4624a;

    public r(int i8) {
        switch (i8) {
            case 1:
                this.f4624a = new ArrayList();
                break;
            default:
                this.f4624a = new ArrayList(20);
                break;
        }
    }

    public void a(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        v1.a(name);
        v1.b(value, name);
        b(name, value);
    }

    public void b(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ArrayList arrayList = this.f4624a;
        arrayList.add(name);
        arrayList.add(StringsKt__StringsKt.trim((CharSequence) value).toString());
    }

    public s c() {
        Object[] array = this.f4624a.toArray(new String[0]);
        if (array != null) {
            return new s((String[]) array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public ArrayList d() {
        ArrayList arrayList = this.f4624a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((Function0) it.next()).invoke() != null) {
                throw new ClassCastException();
            }
            arrayList2.add(null);
        }
        return arrayList2;
    }

    public void e(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f4624a;
            if (i8 >= arrayList.size()) {
                return;
            }
            if (StringsKt__StringsJVMKt.equals(name, (String) arrayList.get(i8), true)) {
                arrayList.remove(i8);
                arrayList.remove(i8);
                i8 -= 2;
            }
            i8 += 2;
        }
    }
}
