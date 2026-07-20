package ko;

import java.util.ArrayList;
import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends f implements uo.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Object[] f9423c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@os.m dp.f fVar, @os.l Object[] objArr) {
        super(fVar);
        l0.p(objArr, "values");
        this.f9423c = objArr;
    }

    @Override // uo.e
    @os.l
    public List<f> c() {
        Object[] objArr = this.f9423c;
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            Object obj = objArr[i10];
            i10++;
            f.a aVar = f.f9420b;
            l0.m(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
