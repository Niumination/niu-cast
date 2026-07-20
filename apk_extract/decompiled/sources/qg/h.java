package qg;

import af.r5;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.channels.ClosedChannelException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import k3.nd;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import li.l2;
import se.n3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final void a(b bVar, mg.b bVar2, Throwable exception) {
        String string;
        try {
            Object objG = bVar2.k().g();
            if (objG == null) {
                objG = "Unhandled";
            }
            try {
                try {
                    vg.c cVarG = bVar2.g();
                    Intrinsics.checkNotNullParameter(cVarG, "<this>");
                    StringBuilder sb2 = new StringBuilder();
                    Intrinsics.checkNotNullParameter(cVarG, "<this>");
                    sb2.append(((zf.x) ((r5) ug.f.a(cVarG)).f560h).f11559a);
                    sb2.append(" - ");
                    sb2.append(m3.k.c(cVarG));
                    string = sb2.toString();
                } catch (Throwable th2) {
                    string = "(request error: " + th2 + ')';
                }
                String str = objG + ": " + string + ". Exception " + Reflection.getOrCreateKotlinClass(exception.getClass()) + ": " + exception.getMessage();
                if (!(exception instanceof CancellationException) && !(exception instanceof ClosedChannelException) && !(exception instanceof ah.b) && !(exception instanceof IOException) && !(exception instanceof ug.a) && !(exception instanceof ug.e) && !(exception instanceof ug.g) && !(exception instanceof ug.h)) {
                    bVar.f9064b.error(objG + ": " + string, exception);
                    return;
                }
                bVar.f9064b.debug(str, exception);
            } catch (OutOfMemoryError unused) {
                PrintStream printStream = System.err;
                printStream.print((Object) "OutOfMemoryError: ");
                printStream.print((Object) exception.getMessage());
                printStream.print((Object) "\n");
            }
        } catch (OutOfMemoryError unused2) {
            vj.b bVar3 = bVar.f9064b;
            Intrinsics.checkNotNullParameter(bVar3, "<this>");
            Intrinsics.checkNotNullParameter(exception, "exception");
            String message = exception.getMessage();
            if (message == null) {
                message = "Exception of type " + Reflection.getOrCreateKotlinClass(exception.getClass());
            }
            bVar3.error(message, exception);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(hh.f fVar, ContinuationImpl continuationImpl) {
        g gVar;
        KType kTypeTypeOf;
        if (continuationImpl instanceof g) {
            gVar = (g) continuationImpl;
            int i8 = gVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                gVar.label = i8 - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuationImpl);
            }
        } else {
            gVar = new g(continuationImpl);
        }
        Object obj = gVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = gVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            zf.r rVarA = ((mg.r) fVar.f5401a).g().a();
            String[] strArr = zf.v.f11551a;
            List listB = rVarA.b("Host");
            if (listB == null) {
                return Unit.INSTANCE;
            }
            if (listB.size() > 1) {
                mg.r rVar = (mg.r) fVar.f5401a;
                zf.z zVar = zf.z.f11573o;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zf.z.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(zf.z.class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                ih.a aVar = new ih.a(orCreateKotlinClass, kTypeTypeOf);
                gVar.L$0 = fVar;
                gVar.label = 1;
                if (rVar.B(zVar, aVar, gVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i9 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        fVar = (hh.f) gVar.L$0;
        ResultKt.throwOnFailure(obj);
        fVar.b();
        return Unit.INSTANCE;
    }

    public static final Set c(ClassLoader classLoader) {
        Set setEmptySet;
        Method method;
        Intrinsics.checkNotNullParameter(classLoader, "<this>");
        ClassLoader parent = classLoader.getParent();
        if (parent == null || (setEmptySet = c(parent)) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        if (classLoader instanceof URLClassLoader) {
            URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
            Intrinsics.checkNotNullExpressionValue(uRLs, "getURLs(...)");
            return SetsKt.plus(CollectionsKt.toSet(ArraysKt.filterNotNull(uRLs)), (Iterable) setEmptySet);
        }
        Iterable iterableJ = null;
        try {
            try {
                Field fieldE = e(classLoader.getClass());
                if (fieldE != null) {
                    fieldE.setAccessible(true);
                    Object obj = fieldE.get(classLoader);
                    if (obj != null && (method = obj.getClass().getMethod("getURLs", null)) != null) {
                        method.setAccessible(true);
                        URL[] urlArr = (URL[]) method.invoke(obj, null);
                        if (urlArr != null) {
                            iterableJ = ArraysKt.toList(urlArr);
                        }
                    }
                }
            } catch (Throwable unused) {
                iterableJ = j(classLoader);
            }
        } catch (Throwable unused2) {
        }
        return iterableJ == null ? setEmptySet : SetsKt.plus(setEmptySet, iterableJ);
    }

    public static p0 d(li.g0 g0Var, n3 module) {
        ng.a factory = ng.a.f8235a;
        List watchPaths = CollectionsKt.listOf(x0.f9125a);
        EmptyCoroutineContext parentCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Intrinsics.checkNotNullParameter(g0Var, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter("0.0.0.0", "host");
        Intrinsics.checkNotNullParameter(watchPaths, "watchPaths");
        Intrinsics.checkNotNullParameter(parentCoroutineContext, "parentCoroutineContext");
        Intrinsics.checkNotNullParameter(module, "module");
        q0 q0Var = new q0();
        q0Var.f9106c = 0;
        Intrinsics.checkNotNullParameter("0.0.0.0", "<set-?>");
        q0Var.f9105b = "0.0.0.0";
        Unit unit = Unit.INSTANCE;
        r0[] connectors = (r0[]) Arrays.copyOf(new r0[]{q0Var}, 1);
        Intrinsics.checkNotNullParameter(g0Var, "<this>");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(connectors, "connectors");
        Intrinsics.checkNotNullParameter(watchPaths, "watchPaths");
        Intrinsics.checkNotNullParameter(parentCoroutineContext, "parentCoroutineContext");
        Intrinsics.checkNotNullParameter(module, "module");
        ag.b block = new ag.b(29);
        Intrinsics.checkNotNullParameter(block, "block");
        a aVar = new a();
        ClassLoader classLoader = a.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
        vj.b bVarB = vj.d.b("io.ktor.server.Application");
        Intrinsics.checkNotNullExpressionValue(bVarB, "getLogger(...)");
        aVar.f9062a = bVarB;
        pg.b bVar = new pg.b();
        block.invoke(aVar);
        b environment = new b(classLoader, aVar.f9062a, bVar);
        mg.t block2 = new mg.t(2, g0Var, parentCoroutineContext, watchPaths, module);
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(block2, "block");
        mg.c0 c0Var = new mg.c0(environment);
        block2.invoke(c0Var);
        mg.b0 rootConfig = new mg.b0(environment, c0Var.f8058a, c0Var.f8059b, c0Var.f8060c, c0Var.f8061d, c0Var.e);
        ag.d0 configure = new ag.d0(connectors, 26);
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(rootConfig, "rootConfig");
        Intrinsics.checkNotNullParameter(configure, "configure");
        return new p0(rootConfig, configure);
    }

    public static final Field e(Class cls) {
        Field field;
        Field fieldE;
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        int length = declaredFields.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                field = null;
                break;
            }
            field = declaredFields[i8];
            if (Intrinsics.areEqual(field.getName(), "ucp") && Intrinsics.areEqual(field.getType().getSimpleName(), "URLClassPath")) {
                break;
            }
            i8++;
        }
        if (field != null) {
            return field;
        }
        Class superclass = cls.getSuperclass();
        if (superclass == null || (fieldE = e(superclass)) == null) {
            return null;
        }
        return fieldE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, mg.b, mg.r] */
    /* JADX WARN: Type inference failed for: r6v1, types: [mg.b] */
    /* JADX WARN: Type inference failed for: r6v6, types: [mg.b] */
    public static final Object f(mg.r rVar, Throwable cause, ContinuationImpl continuationImpl) {
        y yVar;
        zf.z zVar;
        if (continuationImpl instanceof y) {
            yVar = (y) continuationImpl;
            int i8 = yVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                yVar.label = i8 - Integer.MIN_VALUE;
            } else {
                yVar = new y(continuationImpl);
            }
        } else {
            yVar = new y(continuationImpl);
        }
        Object obj = yVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = yVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                cause = (Throwable) yVar.L$1;
                rVar = (mg.b) yVar.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        yVar.L$0 = rVar;
        yVar.L$1 = cause;
        yVar.label = 1;
        nd.a(rVar.getApplication());
        Object objInvoke = new z(rVar, cause, null).invoke(yVar);
        if (objInvoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objInvoke = Unit.INSTANCE;
        }
        if (objInvoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objInvoke = Unit.INSTANCE;
        }
        if (objInvoke == coroutine_suspended) {
            return coroutine_suspended;
        }
        Intrinsics.checkNotNullParameter(cause, "cause");
        if (cause instanceof ug.a) {
            zVar = zf.z.f11573o;
        } else if (cause instanceof ug.e) {
            zVar = zf.z.p;
        } else if (cause instanceof ug.h) {
            zVar = zf.z.u;
        } else if (cause instanceof ug.g) {
            zVar = zf.z.f11576t;
        } else {
            zVar = ((cause instanceof TimeoutException) || (cause instanceof l2)) ? zf.z.f11579x : null;
        }
        if (zVar == null) {
            zVar = zf.z.f11578w;
        }
        yVar.L$0 = null;
        yVar.L$1 = null;
        yVar.label = 2;
        if (i(rVar, zVar, yVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    public static final ag.j g(hh.f fVar, jh.o rc2) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(rc2, "rc");
        vg.e eVarG = ((mg.r) fVar.f5401a).g();
        String[] strArr = zf.v.f11551a;
        String strB = m3.k.b(eVarG, "Content-Type");
        if (strB == null) {
            throw new IllegalStateException("Content-Type header is required for multipart processing");
        }
        mg.r rVar = (mg.r) fVar.f5401a;
        String strB2 = m3.k.b(rVar.g(), "Content-Length");
        Long lValueOf = strB2 != null ? Long.valueOf(Long.parseLong(strB2)) : null;
        CoroutineContext coroutineContextPlus = fVar.getCoroutineContext().plus(li.v0.f7500c);
        zg.a aVar = vg.a.f10585a;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Long l4 = (Long) rVar.i().d(vg.a.f10585a);
        return new ag.j(coroutineContextPlus, rc2, strB, lValueOf, l4 != null ? l4.longValue() : 52428800L);
    }

    public static final String h(final wi.k kVar, Charset charset) {
        Function0 cVar;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        if (kVar instanceof wi.f) {
            cVar = new MutablePropertyReference0Impl(kVar) { // from class: wi.m
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return Boolean.valueOf(((f) this.receiver).f10772b);
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object obj) {
                    ((f) this.receiver).f10772b = ((Boolean) obj).booleanValue();
                }
            };
        } else {
            if (!(kVar instanceof wi.a)) {
                throw new NoWhenBranchMatchedException();
            }
            cVar = new ob.c(23);
        }
        return TextStreamsKt.readText(new InputStreamReader(new wi.l(cVar, kVar), charset));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object i(mg.b bVar, zf.z zVar, ContinuationImpl continuationImpl) {
        a0 a0Var;
        KType kTypeTypeOf;
        if (continuationImpl instanceof a0) {
            a0Var = (a0) continuationImpl;
            int i8 = a0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                a0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                a0Var = new a0(continuationImpl);
            }
        } else {
            a0Var = new a0(continuationImpl);
        }
        Object obj = a0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = a0Var.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(obj);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zf.z.class);
                try {
                    kTypeTypeOf = Reflection.typeOf(zf.z.class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                ih.a aVar = new ih.a(orCreateKotlinClass, kTypeTypeOf);
                a0Var.label = 1;
                if (bVar.B(zVar, aVar, a0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (o unused2) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00cc  */
    public static final ArrayList j(ClassLoader classLoader) throws IOException {
        Iterable iterableEmptyList;
        ArrayList arrayListA = new t(classLoader).a();
        ArrayList<String> arrayList = new ArrayList(CollectionsKt.i(arrayListA));
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt__StringsJVMKt.replace$default((String) it.next(), '.', '/', false, 4, (Object) null));
        }
        HashSet hashSet = new HashSet();
        for (String str : arrayList) {
            List listSplit$default = StringsKt__StringsKt.split$default(str, new char[]{'/'}, false, 0, 6, (Object) null);
            IntRange intRange = new IntRange(1, listSplit$default.size());
            ArrayList arrayList2 = new ArrayList(CollectionsKt.i(intRange));
            Iterator<Integer> it2 = intRange.iterator();
            while (it2.hasNext()) {
                arrayList2.add(CollectionsKt___CollectionsKt.joinToString$default(listSplit$default.subList(0, ((IntIterator) it2).nextInt()), "/", null, null, 0, null, null, 62, null));
            }
            CollectionsKt__MutableCollectionsKt.addAll(hashSet, CollectionsKt.plus((Collection<? extends String>) arrayList2, str));
        }
        List listPlus = CollectionsKt.plus((Collection<? extends String>) CollectionsKt.sortedWith(hashSet, new bb.o(2)), "");
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = listPlus.iterator();
        while (it3.hasNext()) {
            Enumeration<URL> resources = classLoader.getResources((String) it3.next());
            if (resources != null) {
                iterableEmptyList = Collections.list(resources);
                Intrinsics.checkNotNullExpressionValue(iterableEmptyList, "list(...)");
                if (iterableEmptyList == null) {
                    iterableEmptyList = CollectionsKt.emptyList();
                }
            } else {
                iterableEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList3, iterableEmptyList);
        }
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            String path = ((URL) obj).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            if (hashSet2.add(StringsKt__StringsKt.substringBefore$default(path, '!', (String) null, 2, (Object) null))) {
                arrayList4.add(obj);
            }
        }
        return arrayList4;
    }
}
