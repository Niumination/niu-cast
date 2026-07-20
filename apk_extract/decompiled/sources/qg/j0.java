package qg;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f9089d;

    public /* synthetic */ j0(ClassLoader classLoader, String str, mg.a aVar) {
        this.f9086a = 1;
        this.f9087b = classLoader;
        this.f9089d = str;
        this.f9088c = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0242  */
    /* JADX WARN: Code duplicated, block: B:104:0x0256  */
    /* JADX WARN: Code duplicated, block: B:106:0x026b  */
    /* JADX WARN: Code duplicated, block: B:165:0x022e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x021a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x0227 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0208 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x0208 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0132 A[Catch: NoSuchMethodError -> 0x0178, TryCatch #1 {NoSuchMethodError -> 0x0178, blocks: (B:47:0x012a, B:49:0x0132, B:51:0x0147, B:52:0x015e, B:53:0x0177), top: B:137:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0147 A[Catch: NoSuchMethodError -> 0x0178, TryCatch #1 {NoSuchMethodError -> 0x0178, blocks: (B:47:0x012a, B:49:0x0132, B:51:0x0147, B:52:0x015e, B:53:0x0177), top: B:137:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:52:0x015e A[Catch: NoSuchMethodError -> 0x0178, TryCatch #1 {NoSuchMethodError -> 0x0178, blocks: (B:47:0x012a, B:49:0x0132, B:51:0x0147, B:52:0x015e, B:53:0x0177), top: B:137:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0178  */
    /* JADX WARN: Code duplicated, block: B:59:0x018c  */
    /* JADX WARN: Code duplicated, block: B:61:0x018f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0194  */
    /* JADX WARN: Code duplicated, block: B:64:0x0197  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:74:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x0204  */
    /* JADX WARN: Code duplicated, block: B:88:0x020e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0238  */
    /* JADX WARN: Instruction removed from duplicated block: B:102:0x0242, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:104:0x0256, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x026b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x015e, please report this as an issue */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Method javaMethod;
        Class<?> clsLoadClass;
        Metadata metadata;
        KClass kotlinClass;
        KFunction kFunctionA;
        Object objectInstance;
        ArrayList arrayList;
        KFunction kFunctionA2;
        List<KParameter> parameters;
        Iterator<T> it;
        KParameter parameter;
        KFunction kFunction;
        Constructor constructor;
        switch (this.f9086a) {
            case 0:
                p0 p0Var = (p0) this.f9089d;
                Iterator it2 = p0Var.f9100l.iterator();
                while (true) {
                    boolean zHasNext = it2.hasNext();
                    ClassLoader classLoader = (ClassLoader) this.f9087b;
                    mg.a aVar = (mg.a) this.f9088c;
                    if (!zHasNext) {
                        for (Function1 function1 : (ArrayList) p0Var.f9091a.f8048c) {
                            Intrinsics.checkNotNullParameter(function1, "<this>");
                            KFunction kFunction2 = function1 instanceof KFunction ? (KFunction) function1 : null;
                            try {
                                p0.e(classLoader, (kFunction2 == null || (javaMethod = ReflectJvmMapping.getJavaMethod(kFunction2)) == null) ? function1.getClass().getName().concat(".invoke") : javaMethod.getDeclaringClass().getName() + '.' + javaMethod.getName(), aVar);
                            } catch (rg.d unused) {
                                function1.invoke(aVar);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    p0.e(classLoader, (String) it2.next(), aVar);
                }
                break;
            case 1:
                ClassLoader classLoader2 = (ClassLoader) this.f9087b;
                Intrinsics.checkNotNullParameter(classLoader2, "classLoader");
                String fqName = (String) this.f9089d;
                Intrinsics.checkNotNullParameter(fqName, "fqName");
                mg.a application = (mg.a) this.f9088c;
                Intrinsics.checkNotNullParameter(application, "application");
                char[] charArray = ".#".toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
                int iLastIndexOfAny$default = StringsKt__StringsKt.lastIndexOfAny$default(fqName, charArray, 0, false, 6, (Object) null);
                if (iLastIndexOfAny$default == -1) {
                    throw new rg.d("Module function cannot be found for the fully qualified name '" + fqName + '\'');
                }
                String name = fqName.substring(0, iLastIndexOfAny$default);
                Intrinsics.checkNotNullExpressionValue(name, "substring(...)");
                String strSubstring = fqName.substring(iLastIndexOfAny$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                ThreadLocal threadLocal = rg.a.f9434a;
                Intrinsics.checkNotNullParameter(classLoader2, "<this>");
                Intrinsics.checkNotNullParameter(name, "name");
                try {
                    clsLoadClass = classLoader2.loadClass(name);
                    break;
                } catch (ClassNotFoundException unused2) {
                    clsLoadClass = null;
                }
                if (clsLoadClass == null) {
                    throw new rg.d("Module function cannot be found for the fully qualified name '" + fqName + '\'');
                }
                Method[] methods = clsLoadClass.getMethods();
                Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
                ArrayList<Method> arrayList2 = new ArrayList();
                for (Method method : methods) {
                    if (Intrinsics.areEqual(method.getName(), strSubstring) && Modifier.isStatic(method.getModifiers())) {
                        arrayList2.add(method);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Method method2 : arrayList2) {
                    Intrinsics.checkNotNull(method2);
                    KFunction<?> kotlinFunction = ReflectJvmMapping.getKotlinFunction(method2);
                    if (kotlinFunction != null) {
                        arrayList3.add(kotlinFunction);
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj : arrayList3) {
                    if (rg.a.b((KFunction) obj)) {
                        arrayList4.add(obj);
                    }
                }
                KFunction kFunctionA3 = rg.a.a(arrayList4);
                if (kFunctionA3 != null) {
                    List<KParameter> parameters2 = kFunctionA3.getParameters();
                    if (!(parameters2 instanceof Collection) || !parameters2.isEmpty()) {
                        Iterator<T> it3 = parameters2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (((KParameter) it3.next()).getKind() != KParameter.Kind.INSTANCE) {
                                }
                                try {
                                    if (Function1.class.isAssignableFrom(clsLoadClass)) {
                                        Constructor<?>[] declaredConstructors = clsLoadClass.getDeclaredConstructors();
                                        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "getDeclaredConstructors(...)");
                                        constructor = (Constructor) ArraysKt.single(declaredConstructors);
                                        if (constructor.getParameterCount() == 0) {
                                            throw new rg.d("Module function with captured variables cannot be instantiated '" + fqName + '\'');
                                        }
                                        constructor.setAccessible(true);
                                        Object objNewInstance = constructor.newInstance(null);
                                        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Function1<io.ktor.server.application.Application, kotlin.Unit>");
                                        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(objNewInstance, 1)).invoke(application);
                                    } else {
                                        Intrinsics.checkNotNullParameter(clsLoadClass, "<this>");
                                        metadata = (Metadata) clsLoadClass.getAnnotation(Metadata.class);
                                        if (metadata != null || metadata.k() != 1) {
                                            metadata = null;
                                        }
                                        if (metadata != null) {
                                            kotlinClass = JvmClassMappingKt.getKotlinClass(clsLoadClass);
                                        } else {
                                            kotlinClass = null;
                                        }
                                        if (kotlinClass != null) {
                                            throw new rg.d("Module function cannot be found for the fully qualified name '" + fqName + '\'');
                                        }
                                        Collection<KFunction<?>> functions = KClasses.getFunctions(kotlinClass);
                                        ArrayList arrayList5 = new ArrayList();
                                        for (Object obj2 : functions) {
                                            kFunction = (KFunction) obj2;
                                            if (!Intrinsics.areEqual(kFunction.getName(), strSubstring) && rg.a.b(kFunction)) {
                                                arrayList5.add(obj2);
                                            }
                                        }
                                        kFunctionA = rg.a.a(arrayList5);
                                        if (kFunctionA != null) {
                                            throw new ClassNotFoundException("Module function cannot be found for the fully qualified name '" + fqName + '\'');
                                        }
                                        objectInstance = kotlinClass.getObjectInstance();
                                        if (objectInstance == null) {
                                            Collection constructors = kotlinClass.getConstructors();
                                            arrayList = new ArrayList();
                                            for (Object obj3 : constructors) {
                                                parameters = ((KFunction) obj3).getParameters();
                                                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                                                    it = parameters.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            parameter = (KParameter) it.next();
                                                            if (!parameter.isOptional()) {
                                                                Intrinsics.checkNotNullParameter(parameter, "parameter");
                                                                if (rg.a.d(parameter, rg.a.f9435b) && !rg.a.c(parameter)) {
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                arrayList.add(obj3);
                                            }
                                            kFunctionA2 = rg.a.a(arrayList);
                                            if (kFunctionA2 != null) {
                                                throw new RuntimeException("There are no applicable constructors found in class " + kotlinClass);
                                            }
                                            objectInstance = rg.b.a(null, kFunctionA2, application);
                                        }
                                        rg.b.a(objectInstance, kFunctionA, application);
                                    }
                                } catch (NoSuchMethodError unused3) {
                                }
                            }
                        }
                    }
                    rg.b.a(null, kFunctionA3, application);
                } else if (Function1.class.isAssignableFrom(clsLoadClass)) {
                    Constructor<?>[] declaredConstructors2 = clsLoadClass.getDeclaredConstructors();
                    Intrinsics.checkNotNullExpressionValue(declaredConstructors2, "getDeclaredConstructors(...)");
                    constructor = (Constructor) ArraysKt.single(declaredConstructors2);
                    if (constructor.getParameterCount() == 0) {
                        throw new rg.d("Module function with captured variables cannot be instantiated '" + fqName + '\'');
                    }
                    constructor.setAccessible(true);
                    Object objNewInstance2 = constructor.newInstance(null);
                    Intrinsics.checkNotNull(objNewInstance2, "null cannot be cast to non-null type kotlin.Function1<io.ktor.server.application.Application, kotlin.Unit>");
                    ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(objNewInstance2, 1)).invoke(application);
                } else {
                    Intrinsics.checkNotNullParameter(clsLoadClass, "<this>");
                    metadata = (Metadata) clsLoadClass.getAnnotation(Metadata.class);
                    if (metadata != null) {
                        metadata = null;
                    } else {
                        metadata = null;
                    }
                    if (metadata != null) {
                        kotlinClass = JvmClassMappingKt.getKotlinClass(clsLoadClass);
                    } else {
                        kotlinClass = null;
                    }
                    if (kotlinClass != null) {
                        throw new rg.d("Module function cannot be found for the fully qualified name '" + fqName + '\'');
                    }
                    Collection<KFunction<?>> functions2 = KClasses.getFunctions(kotlinClass);
                    ArrayList arrayList6 = new ArrayList();
                    while (r2.hasNext()) {
                        kFunction = (KFunction) obj2;
                        if (!Intrinsics.areEqual(kFunction.getName(), strSubstring)) {
                        }
                    }
                    kFunctionA = rg.a.a(arrayList6);
                    if (kFunctionA != null) {
                        throw new ClassNotFoundException("Module function cannot be found for the fully qualified name '" + fqName + '\'');
                    }
                    objectInstance = kotlinClass.getObjectInstance();
                    if (objectInstance == null) {
                        Collection constructors2 = kotlinClass.getConstructors();
                        arrayList = new ArrayList();
                        while (r3.hasNext()) {
                            parameters = ((KFunction) obj3).getParameters();
                            if (!(parameters instanceof Collection)) {
                                it = parameters.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        arrayList.add(obj3);
                                    }
                                    parameter = (KParameter) it.next();
                                    if (!parameter.isOptional()) {
                                        Intrinsics.checkNotNullParameter(parameter, "parameter");
                                        if (rg.a.d(parameter, rg.a.f9435b)) {
                                            continue;
                                        }
                                    }
                                }
                            } else {
                                it = parameters.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        arrayList.add(obj3);
                                    }
                                    parameter = (KParameter) it.next();
                                    if (!parameter.isOptional()) {
                                        Intrinsics.checkNotNullParameter(parameter, "parameter");
                                        if (rg.a.d(parameter, rg.a.f9435b)) {
                                            continue;
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        kFunctionA2 = rg.a.a(arrayList);
                        if (kFunctionA2 != null) {
                            throw new RuntimeException("There are no applicable constructors found in class " + kotlinClass);
                        }
                        objectInstance = rg.b.a(null, kFunctionA2, application);
                    }
                    rg.b.a(objectInstance, kFunctionA, application);
                }
                return Unit.INSTANCE;
            default:
                String str = QrScanActivity.f2804c;
                FragmentActivity fragmentActivity = (FragmentActivity) this.f9089d;
                String str2 = (String) this.f9087b;
                eb.y yVar = eb.y.f4799a;
                eb.y.f = 0;
                Intent intent = new Intent(fragmentActivity, (Class<?>) QrScanActivity.class);
                QrScanActivity.f2804c = str2;
                fragmentActivity.startActivity(intent);
                ((Function1) this.f9088c).invoke(Boolean.TRUE);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ j0(Object obj, int i8, Object obj2, Object obj3) {
        this.f9086a = i8;
        this.f9089d = obj;
        this.f9087b = obj2;
        this.f9088c = obj3;
    }
}
