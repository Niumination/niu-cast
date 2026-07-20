package cj;

import android.widget.ListView;
import dc.n;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ld.m;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1697a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1700d;

    public /* synthetic */ b(int i8, String str, c cVar) {
        this.f1698b = i8;
        this.f1699c = str;
        this.f1700d = cVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f1697a) {
            case 0:
                int i8 = this.f1698b;
                bj.d[] dVarArr = new bj.d[i8];
                for (int i9 = 0; i9 < i8; i9++) {
                    String serialName = ((String) this.f1699c) + '.' + ((c) this.f1700d).e[i9];
                    bj.i kind = bj.i.f1353c;
                    bj.d[] typeParameters = new bj.d[0];
                    ag.b builder = new ag.b(5);
                    Intrinsics.checkNotNullParameter(serialName, "serialName");
                    Intrinsics.checkNotNullParameter(kind, "kind");
                    Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    if (StringsKt.isBlank(serialName)) {
                        throw new IllegalArgumentException("Blank serial names are prohibited");
                    }
                    if (Intrinsics.areEqual(kind, bj.i.f1352b)) {
                        throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
                    }
                    bj.a aVar = new bj.a(serialName);
                    builder.invoke(aVar);
                    dVarArr[i9] = new bj.e(serialName, aVar.f1335b.size(), ArraysKt.toList(typeParameters), aVar);
                }
                return dVarArr;
            case 1:
                ListView listView = (ListView) this.f1699c;
                int i10 = this.f1698b;
                listView.setItemChecked(i10, true);
                ((bb.d) this.f1700d).invoke(Integer.valueOf(i10));
                m mVar = n.f4427a;
                if (mVar != null) {
                    mVar.dismiss();
                }
                return Unit.INSTANCE;
            default:
                return ((Regex) this.f1699c).find((CharSequence) this.f1700d, this.f1698b);
        }
    }

    public /* synthetic */ b(ListView listView, int i8, bb.d dVar) {
        this.f1699c = listView;
        this.f1698b = i8;
        this.f1700d = dVar;
    }

    public /* synthetic */ b(Regex regex, CharSequence charSequence, int i8) {
        this.f1699c = regex;
        this.f1700d = charSequence;
        this.f1698b = i8;
    }
}
