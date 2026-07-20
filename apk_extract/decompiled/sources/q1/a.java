package q1;

import af.s1;
import java.util.List;
import m1.f;
import m1.j;
import m1.n;

/* JADX INFO: loaded from: classes.dex */
public final class a extends s1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8930c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(List list, int i8) {
        super(list);
        this.f8930c = i8;
    }

    @Override // q1.e
    public final m1.e g() {
        switch (this.f8930c) {
            case 0:
                return new f((List) this.f574b, 0);
            case 1:
                return new j((List) this.f574b, 0);
            case 2:
                return new f((List) this.f574b, 1);
            case 3:
                return new j((List) this.f574b, 1);
            case 4:
                return new j((List) this.f574b, 2);
            case 5:
                return new n((List) this.f574b);
            default:
                return new f((List) this.f574b, 2);
        }
    }
}
