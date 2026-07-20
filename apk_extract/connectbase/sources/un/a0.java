package un;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.r1;
import lm.j0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,230:1\n1549#2:231\n1620#2,3:232\n37#3,2:235\n26#4:237\n26#4:238\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n*L\n116#1:231\n116#1:232,3\n116#1:235,2\n134#1:237\n137#1:238\n*E\n"})
@lm.r
public final class a0 implements TypeVariable<GenericDeclaration>, y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final t f16338a;

    public a0(@os.l t tVar) {
        l0.p(tVar, "typeParameter");
        this.f16338a = tVar;
    }

    @os.m
    public final <T extends Annotation> T a(@os.l Class<T> cls) {
        l0.p(cls, "annotationClass");
        return null;
    }

    @os.l
    public final Annotation[] b() {
        return new Annotation[0];
    }

    @os.l
    public final Annotation[] c() {
        return new Annotation[0];
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (l0.g(this.f16338a.getName(), typeVariable.getName()) && l0.g(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    @os.l
    public Type[] getBounds() {
        List<s> upperBounds = this.f16338a.getUpperBounds();
        ArrayList arrayList = new ArrayList(nm.z.b0(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(b0.c((s) it.next(), true));
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    @os.l
    public GenericDeclaration getGenericDeclaration() {
        throw new j0(m.a.a("An operation is not implemented: ", "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f16338a));
    }

    @Override // java.lang.reflect.TypeVariable
    @os.l
    public String getName() {
        return this.f16338a.getName();
    }

    @Override // java.lang.reflect.Type, un.y
    @os.l
    public String getTypeName() {
        return this.f16338a.getName();
    }

    public int hashCode() {
        return getGenericDeclaration().hashCode() ^ this.f16338a.getName().hashCode();
    }

    @os.l
    public String toString() {
        return this.f16338a.getName();
    }
}
