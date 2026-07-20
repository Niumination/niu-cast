package ko;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends t implements uo.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Field f9434a;

    public r(@os.l Field field) {
        l0.p(field, "member");
        this.f9434a = field;
    }

    @Override // uo.n
    public boolean G() {
        return this.f9434a.isEnumConstant();
    }

    @Override // uo.n
    public boolean L() {
        return false;
    }

    @Override // ko.t
    public Member Q() {
        return this.f9434a;
    }

    @os.l
    public Field S() {
        return this.f9434a;
    }

    @Override // uo.n
    @os.l
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public z getType() {
        z.a aVar = z.f9442a;
        Type genericType = this.f9434a.getGenericType();
        l0.o(genericType, "member.genericType");
        return aVar.a(genericType);
    }
}
