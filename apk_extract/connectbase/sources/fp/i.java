package fp;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends fp.a implements Serializable {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6240a;

        static {
            int[] iArr = new int[z.c.values().length];
            f6240a = iArr;
            try {
                iArr[z.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6240a[z.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static abstract class b<MessageType extends i, BuilderType extends b> extends fp.a.AbstractC0147a<BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public fp.d f6241a = fp.d.f6202a;

        @Override // fp.a.AbstractC0147a
        /* JADX INFO: renamed from: e */
        public BuilderType l() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        @Override // fp.r
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public abstract MessageType getDefaultInstanceForType();

        public final fp.d g() {
            return this.f6241a;
        }

        public abstract BuilderType h(MessageType messagetype);

        public final BuilderType i(fp.d dVar) {
            this.f6241a = dVar;
            return this;
        }
    }

    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements e<MessageType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h<f> f6242b = h.g();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6243c;

        public final h<f> k() {
            this.f6242b.q();
            this.f6243c = false;
            return this.f6242b;
        }

        @Override // fp.i.b
        public BuilderType l() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final void m() {
            if (this.f6243c) {
                return;
            }
            this.f6242b = this.f6242b.clone();
            this.f6243c = true;
        }

        public boolean n() {
            return this.f6242b.n();
        }

        public final void o(MessageType messagetype) {
            m();
            this.f6242b.r(((d) messagetype).extensions);
        }
    }

    public interface e<MessageType extends d> extends r {
    }

    public static final class f implements h.b<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j.b<?> f6248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z.b f6250c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f6251d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f6252e;

        public f(j.b<?> bVar, int i10, z.b bVar2, boolean z10, boolean z11) {
            this.f6248a = bVar;
            this.f6249b = i10;
            this.f6250c = bVar2;
            this.f6251d = z10;
            this.f6252e = z11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(f fVar) {
            return this.f6249b - fVar.f6249b;
        }

        public j.b<?> b() {
            return this.f6248a;
        }

        @Override // fp.h.b
        public q.a g(q.a aVar, q qVar) {
            return ((b) aVar).h((i) qVar);
        }

        @Override // fp.h.b
        public z.c getLiteJavaType() {
            return this.f6250c.getJavaType();
        }

        @Override // fp.h.b
        public z.b getLiteType() {
            return this.f6250c;
        }

        @Override // fp.h.b
        public int getNumber() {
            return this.f6249b;
        }

        @Override // fp.h.b
        public boolean isPacked() {
            return this.f6252e;
        }

        @Override // fp.h.b
        public boolean isRepeated() {
            return this.f6251d;
        }
    }

    public static class g<ContainingType extends q, Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContainingType f6253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f6254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final q f6255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final f f6256d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Class f6257e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f6258f;

        public g(ContainingType containingtype, Type type, q qVar, f fVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (fVar.f6250c == z.b.MESSAGE && qVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f6253a = containingtype;
            this.f6254b = type;
            this.f6255c = qVar;
            this.f6256d = fVar;
            this.f6257e = cls;
            if (j.a.class.isAssignableFrom(cls)) {
                this.f6258f = i.getMethodOrDie(cls, "valueOf", Integer.TYPE);
            } else {
                this.f6258f = null;
            }
        }

        public Object a(Object obj) {
            f fVar = this.f6256d;
            if (!fVar.f6251d) {
                return e(obj);
            }
            if (fVar.f6250c.getJavaType() != z.c.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(e(it.next()));
            }
            return arrayList;
        }

        public ContainingType b() {
            return this.f6253a;
        }

        public q c() {
            return this.f6255c;
        }

        public int d() {
            return this.f6256d.f6249b;
        }

        public Object e(Object obj) {
            return this.f6256d.f6250c.getJavaType() == z.c.ENUM ? i.invokeOrDie(this.f6258f, null, (Integer) obj) : obj;
        }

        public Object f(Object obj) {
            return this.f6256d.f6250c.getJavaType() == z.c.ENUM ? Integer.valueOf(((j.a) obj).getNumber()) : obj;
        }
    }

    public i() {
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000e  */
    public static <MessageType extends q> boolean a(h<f> hVar, MessageType messagetype, fp.e eVar, fp.f fVar, fp.g gVar, int i10) throws IOException {
        boolean z10;
        boolean z11;
        Object objBuild;
        q qVar;
        int iB = z.b(i10);
        g gVarB = gVar.b(messagetype, i10 >>> 3);
        if (gVarB == null) {
            z11 = false;
            z10 = true;
        } else if (iB == h.l(gVarB.f6256d.f6250c, false)) {
            z10 = false;
            z11 = false;
        } else {
            f fVar2 = gVarB.f6256d;
            if (fVar2.f6251d && fVar2.f6250c.isPackable() && iB == h.l(gVarB.f6256d.f6250c, true)) {
                z10 = false;
                z11 = true;
            } else {
                z11 = false;
                z10 = true;
            }
        }
        if (z10) {
            return eVar.P(i10, fVar);
        }
        if (z11) {
            int iJ = eVar.j(eVar.A());
            if (gVarB.f6256d.f6250c == z.b.ENUM) {
                while (eVar.e() > 0) {
                    j.a aVarFindValueByNumber = gVarB.f6256d.f6248a.findValueByNumber(eVar.A());
                    if (aVarFindValueByNumber == null) {
                        return true;
                    }
                    hVar.a(gVarB.f6256d, gVarB.f(aVarFindValueByNumber));
                }
            } else {
                while (eVar.e() > 0) {
                    hVar.a(gVarB.f6256d, h.u(eVar, gVarB.f6256d.f6250c, false));
                }
            }
            eVar.i(iJ);
        } else {
            int i11 = a.f6240a[gVarB.f6256d.f6250c.getJavaType().ordinal()];
            if (i11 == 1) {
                f fVar3 = gVarB.f6256d;
                q.a builder = (fVar3.f6251d || (qVar = (q) hVar.h(fVar3)) == null) ? null : qVar.toBuilder();
                if (builder == null) {
                    builder = gVarB.c().newBuilderForType();
                }
                if (gVarB.f6256d.f6250c == z.b.GROUP) {
                    eVar.r(gVarB.d(), builder, gVar);
                } else {
                    eVar.v(builder, gVar);
                }
                objBuild = builder.build();
            } else if (i11 != 2) {
                objBuild = h.u(eVar, gVarB.f6256d.f6250c, false);
            } else {
                int iA = eVar.A();
                j.a aVarFindValueByNumber2 = gVarB.f6256d.f6248a.findValueByNumber(iA);
                if (aVarFindValueByNumber2 == null) {
                    fVar.o0(i10);
                    fVar.o0(iA);
                    return true;
                }
                objBuild = aVarFindValueByNumber2;
            }
            f fVar4 = gVarB.f6256d;
            if (fVar4.f6251d) {
                hVar.a(fVar4, gVarB.f(objBuild));
            } else {
                hVar.v(fVar4, gVarB.f(objBuild));
            }
        }
        return true;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            String name = cls.getName();
            String strValueOf = String.valueOf(str);
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + name.length() + 45);
            sb2.append("Generated message class \"");
            sb2.append(name);
            sb2.append("\" missing method \"");
            sb2.append(strValueOf);
            sb2.append("\".");
            throw new RuntimeException(sb2.toString(), e10);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static <ContainingType extends q, Type> g<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, q qVar, j.b<?> bVar, int i10, z.b bVar2, boolean z10, Class cls) {
        return new g<>(containingtype, Collections.emptyList(), qVar, new f(bVar, i10, bVar2, true, z10), cls);
    }

    public static <ContainingType extends q, Type> g<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, q qVar, j.b<?> bVar, int i10, z.b bVar2, Class cls) {
        return new g<>(containingtype, type, qVar, new f(bVar, i10, bVar2, false, false), cls);
    }

    @Override // fp.q
    public s<? extends q> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public void makeExtensionsImmutable() {
    }

    public boolean parseUnknownField(fp.e eVar, fp.f fVar, fp.g gVar, int i10) throws IOException {
        return eVar.P(i10, fVar);
    }

    public static abstract class d<MessageType extends d<MessageType>> extends i implements e<MessageType> {
        private final h<f> extensions;

        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<Map.Entry<f, Object>> f6244a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Map.Entry<f, Object> f6245b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f6246c;

            public /* synthetic */ a(d dVar, boolean z10, a aVar) {
                this(z10);
            }

            public void a(int i10, fp.f fVar) throws IOException {
                while (true) {
                    Map.Entry<f, Object> entry = this.f6245b;
                    if (entry == null || entry.getKey().f6249b >= i10) {
                        return;
                    }
                    f key = this.f6245b.getKey();
                    if (this.f6246c && key.f6250c.getJavaType() == z.c.MESSAGE && !key.f6251d) {
                        fVar.f0(key.f6249b, (q) this.f6245b.getValue());
                    } else {
                        h.z(key, this.f6245b.getValue(), fVar);
                    }
                    if (this.f6244a.hasNext()) {
                        this.f6245b = this.f6244a.next();
                    } else {
                        this.f6245b = null;
                    }
                }
            }

            public a(boolean z10) {
                Iterator<Map.Entry<f, Object>> itP = d.this.extensions.p();
                this.f6244a = itP;
                if (itP.hasNext()) {
                    this.f6245b = itP.next();
                }
                this.f6246c = z10;
            }
        }

        public d() {
            this.extensions = h.t();
        }

        public final void b(g<MessageType, ?> gVar) {
            if (gVar.b() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.n();
        }

        public int extensionsSerializedSize() {
            return this.extensions.k();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(g<MessageType, Type> gVar) {
            b(gVar);
            Object objH = this.extensions.h(gVar.f6256d);
            return objH == null ? gVar.f6254b : (Type) gVar.a(objH);
        }

        public final <Type> int getExtensionCount(g<MessageType, List<Type>> gVar) {
            b(gVar);
            return this.extensions.j(gVar.f6256d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(g<MessageType, Type> gVar) {
            b(gVar);
            return this.extensions.m(gVar.f6256d);
        }

        @Override // fp.i
        public void makeExtensionsImmutable() {
            this.extensions.q();
        }

        public d<MessageType>.a newExtensionWriter() {
            return new a(false);
        }

        @Override // fp.i
        public boolean parseUnknownField(fp.e eVar, fp.f fVar, fp.g gVar, int i10) throws IOException {
            return i.a(this.extensions, getDefaultInstanceForType(), eVar, fVar, gVar, i10);
        }

        public d(c<MessageType, ?> cVar) {
            this.extensions = cVar.k();
        }

        public final <Type> Type getExtension(g<MessageType, List<Type>> gVar, int i10) {
            b(gVar);
            return (Type) gVar.e(this.extensions.i(gVar.f6256d, i10));
        }
    }

    public i(b bVar) {
    }
}
