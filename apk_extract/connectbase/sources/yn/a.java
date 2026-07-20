package yn;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.w;
import nm.d1;
import nm.h0;
import nm.z;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Class<?> f21464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final List<String> f21465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final EnumC0551a f21466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final List<Method> f21467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final List<Type> f21468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public final List<Class<?>> f21469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final List<Object> f21470g;

    /* JADX INFO: renamed from: yn.a$a, reason: collision with other inner class name */
    public enum EnumC0551a {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    public enum b {
        JAVA,
        KOTLIN
    }

    public a(@l Class<?> cls, @l List<String> list, @l EnumC0551a enumC0551a, @l b bVar, @l List<Method> list2) {
        l0.p(cls, "jClass");
        l0.p(list, "parameterNames");
        l0.p(enumC0551a, "callMode");
        l0.p(bVar, n1.d.a.f11176d);
        l0.p(list2, "methods");
        this.f21464a = cls;
        this.f21465b = list;
        this.f21466c = enumC0551a;
        this.f21467d = list2;
        List<Method> list3 = list2;
        ArrayList arrayList = new ArrayList(z.b0(list3, 10));
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.f21468e = arrayList;
        List<Method> list4 = this.f21467d;
        ArrayList arrayList2 = new ArrayList(z.b0(list4, 10));
        Iterator<T> it2 = list4.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            l0.o(returnType, "it");
            Class<?> clsG = ko.d.g(returnType);
            if (clsG != null) {
                returnType = clsG;
            }
            arrayList2.add(returnType);
        }
        this.f21469f = arrayList2;
        List<Method> list5 = this.f21467d;
        ArrayList arrayList3 = new ArrayList(z.b0(list5, 10));
        Iterator<T> it3 = list5.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.f21470g = arrayList3;
        if (this.f21466c == EnumC0551a.POSITIONAL_CALL && bVar == b.JAVA && !h0.r4(this.f21465b, "value").isEmpty()) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // yn.d
    @l
    public List<Type> a() {
        return this.f21468e;
    }

    @Override // yn.d
    public Member b() {
        return null;
    }

    public void c(@l Object[] objArr) {
        d.a.a(this, objArr);
    }

    @Override // yn.d
    @m
    public Object call(@l Object[] objArr) {
        l0.p(objArr, d6.a.F);
        d.a.a(this, objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            Object obj = objArr[i10];
            i10++;
            int i12 = i11 + 1;
            Object objL = (obj == null && this.f21466c == EnumC0551a.CALL_BY_NAME) ? this.f21470g.get(i11) : yn.b.l(obj, this.f21469f.get(i11));
            if (objL == null) {
                yn.b.k(i11, this.f21465b.get(i11), this.f21469f.get(i11));
                throw null;
            }
            arrayList.add(objL);
            i11 = i12;
        }
        return yn.b.f(this.f21464a, d1.D0(h0.i6(this.f21465b, arrayList)), this.f21467d);
    }

    @m
    public Void d() {
        return null;
    }

    @Override // yn.d
    @l
    public Type getReturnType() {
        return this.f21464a;
    }

    public /* synthetic */ a(Class cls, List list, EnumC0551a enumC0551a, b bVar, List list2, int i10, w wVar) {
        List list3;
        if ((i10 & 16) != 0) {
            List list4 = list;
            ArrayList arrayList = new ArrayList(z.b0(list4, 10));
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list3 = arrayList;
        } else {
            list3 = list2;
        }
        this(cls, list, enumC0551a, bVar, list3);
    }
}
