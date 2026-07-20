package ze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11384b;

    public m2(tc.d dVar) {
        String str = (String) dVar.f10209a;
        this.f11383a = str;
        ArrayList<r1> arrayList = (ArrayList) dVar.f10210b;
        HashSet hashSet = new HashSet(arrayList.size());
        for (r1 r1Var : arrayList) {
            v8.i(r1Var, "method");
            String str2 = r1Var.f11424c;
            v8.g(str.equals(str2), "service names %s != %s", str2, str);
            String str3 = r1Var.f11423b;
            v8.d("duplicate name %s", hashSet.add(str3), str3);
        }
        this.f11384b = Collections.unmodifiableList(new ArrayList(arrayList));
    }

    public static tc.d a(String str) {
        tc.d dVar = new tc.d();
        dVar.f10210b = new ArrayList();
        v8.i(str, "name");
        dVar.f10209a = str;
        return dVar;
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f11383a, "name");
        aVarA.d(null, "schemaDescriptor");
        aVarA.d(this.f11384b, "methods");
        aVarA.f8408c = true;
        return aVarA.toString();
    }
}
