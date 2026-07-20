package yn;

import eo.h1;
import eo.w0;
import eo.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import os.l;
import os.m;
import tn.u;
import vp.f0;
import xn.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class g<M extends Member> implements d<M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final d<M> f21491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final a f21493c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final tn.l f21494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final Method[] f21495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m
        public final Method f21496c;

        public a(@l tn.l lVar, @l Method[] methodArr, @m Method method) {
            l0.p(lVar, "argumentRange");
            l0.p(methodArr, "unbox");
            this.f21494a = lVar;
            this.f21495b = methodArr;
            this.f21496c = method;
        }

        @l
        public final tn.l a() {
            return this.f21494a;
        }

        @l
        public final Method[] b() {
            return this.f21495b;
        }

        @m
        public final Method c() {
            return this.f21496c;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0055  */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@l eo.b bVar, @l d<? extends M> dVar, boolean z10) {
        a aVar;
        Class<?> clsI;
        l0.p(bVar, "descriptor");
        l0.p(dVar, "caller");
        this.f21491a = dVar;
        this.f21492b = z10;
        f0 returnType = bVar.getReturnType();
        l0.m(returnType);
        l0.o(returnType, "descriptor.returnType!!");
        Class<?> clsI2 = h.i(returnType);
        Method methodD = clsI2 == null ? null : h.d(clsI2, bVar);
        int i10 = 0;
        if (hp.f.a(bVar)) {
            tn.l.f15918e.getClass();
            aVar = new a(tn.l.f15919f, new Method[0], methodD);
        } else {
            int i11 = -1;
            if (!(dVar instanceof e.h.c)) {
                if (bVar instanceof eo.l) {
                    if (!(dVar instanceof c)) {
                        i11 = 0;
                    }
                } else if (bVar.O() == null || (dVar instanceof c)) {
                    i11 = 0;
                } else {
                    eo.m mVarB = bVar.b();
                    l0.o(mVarB, "descriptor.containingDeclaration");
                    if (hp.f.b(mVarB)) {
                        i11 = 0;
                    } else {
                        i11 = 1;
                    }
                }
            }
            int i12 = (z10 ? 2 : 0) + (((bVar instanceof y) && ((y) bVar).isSuspend()) ? 1 : 0);
            ArrayList arrayList = new ArrayList();
            w0 w0VarR = bVar.R();
            f0 type = w0VarR == null ? null : w0VarR.getType();
            if (type != null) {
                arrayList.add(type);
            } else if (bVar instanceof eo.l) {
                eo.e eVarC0 = ((eo.l) bVar).c0();
                l0.o(eVarC0, "descriptor.constructedClass");
                if (eVarC0.l()) {
                    arrayList.add(((eo.e) eVarC0.b()).q());
                }
            } else {
                eo.m mVarB2 = bVar.b();
                l0.o(mVarB2, "descriptor.containingDeclaration");
                if ((mVarB2 instanceof eo.e) && hp.f.b(mVarB2)) {
                    arrayList.add(((eo.e) mVarB2).q());
                }
            }
            List<h1> listH = bVar.h();
            l0.o(listH, "descriptor.valueParameters");
            Iterator<T> it = listH.iterator();
            while (it.hasNext()) {
                arrayList.add(((h1) it.next()).getType());
            }
            int size = arrayList.size() + i11 + i12;
            if (f.a(this) != size) {
                throw new xn.y("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a(this) + " != " + size + "\nCalling: " + bVar + "\nParameter types: " + this.f21491a.a() + ")\nDefault: " + this.f21492b);
            }
            tn.l lVarW1 = u.W1(Math.max(i11, 0), arrayList.size() + i11);
            Method[] methodArr = new Method[size];
            while (i10 < size) {
                methodArr[i10] = (i10 > lVarW1.f15912b || lVarW1.f15911a > i10 || (clsI = h.i((f0) arrayList.get(i10 - i11))) == null) ? null : h.f(clsI, bVar);
                i10++;
            }
            aVar = new a(lVarW1, methodArr, methodD);
        }
        this.f21493c = aVar;
    }

    @Override // yn.d
    @l
    public List<Type> a() {
        return this.f21491a.a();
    }

    @Override // yn.d
    public M b() {
        return (M) this.f21491a.b();
    }

    @Override // yn.d
    @m
    public Object call(@l Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke;
        l0.p(objArr, d6.a.F);
        a aVar = this.f21493c;
        tn.l lVar = aVar.f21494a;
        Method[] methodArr = aVar.f21495b;
        Method method = aVar.f21496c;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        l0.o(objArrCopyOf, "copyOf(this, size)");
        int i10 = lVar.f15911a;
        int i11 = lVar.f15912b;
        if (i10 <= i11) {
            while (true) {
                int i12 = i10 + 1;
                Method method2 = methodArr[i10];
                Object objG = objArr[i10];
                if (method2 != null) {
                    if (objG != null) {
                        objG = method2.invoke(objG, null);
                    } else {
                        Class<?> returnType = method2.getReturnType();
                        l0.o(returnType, "method.returnType");
                        objG = h0.g(returnType);
                    }
                }
                objArrCopyOf[i10] = objG;
                if (i10 == i11) {
                    break;
                }
                i10 = i12;
            }
        }
        Object objCall = this.f21491a.call(objArrCopyOf);
        return (method == null || (objInvoke = method.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    @Override // yn.d
    @l
    public Type getReturnType() {
        return this.f21491a.getReturnType();
    }
}
