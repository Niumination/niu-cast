package nk;

import fl.f1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kn.l0;
import lm.d1;
import lm.l2;
import nm.h0;
import nm.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f11555a = "static-content-path-parameter";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final fl.b<File> f11556b = new fl.b<>("BaseFolder");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final fl.b<List<g>> f11557c = new fl.b<>("StaticContentCompressed");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final fl.b<String> f11558d = new fl.b<>("BasePackage");

    @xm.f(c = "io.ktor.http.content.StaticContentKt$default$1", f = "StaticContent.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        final /* synthetic */ List<g> $compressedTypes;
        final /* synthetic */ File $file;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(File file, List<? extends g> list, um.d<? super a> dVar) {
            super(3, dVar);
            this.$file = file;
            this.$compressedTypes = list;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            File file;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                dk.b bVar = (dk.b) ((nl.f) this.L$0).getContext();
                File file2 = this.$file;
                g gVarB = w.b(file2, uk.e.e(bVar.d()), this.$compressedTypes);
                if (gVarB != null) {
                    fl.c cVarC = bVar.c();
                    gk.l.f6660c.getClass();
                    cVarC.g(gk.l.f6661d, Boolean.TRUE);
                }
                if (gVarB == null || (file = gVarB.file(file2)) == null) {
                    file = file2;
                }
                if (file.isFile()) {
                    v vVar = new v(new n(file, ik.u.a(ik.i.f7981f, file2)), gVarB == null ? null : gVarB.getEncoding());
                    vk.d dVarC = bVar.e().c();
                    this.label = 1;
                    if (dVarC.g(bVar, vVar, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            a aVar = new a(this.$file, this.$compressedTypes, dVar);
            aVar.L$0 = fVar;
            return aVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.content.StaticContentKt$defaultResource$1", f = "StaticContent.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        final /* synthetic */ String $packageName;
        final /* synthetic */ String $resource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, um.d<? super b> dVar) {
            super(3, dVar);
            this.$resource = str;
            this.$packageName = str2;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                s sVarD = x.d((dk.b) fVar.getContext(), this.$resource, this.$packageName, null, null, 12, null);
                if (sVarD != null) {
                    dk.b bVar = (dk.b) fVar.getContext();
                    vk.d dVarC = bVar.e().c();
                    this.label = 1;
                    if (dVarC.g(bVar, sVarD, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            b bVar = new b(this.$resource, this.$packageName, dVar);
            bVar.L$0 = fVar;
            return bVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.content.StaticContentKt$file$1", f = "StaticContent.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        final /* synthetic */ List<g> $compressedTypes;
        final /* synthetic */ File $file;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(File file, List<? extends g> list, um.d<? super c> dVar) {
            super(3, dVar);
            this.$file = file;
            this.$compressedTypes = list;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            File file;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                dk.b bVar = (dk.b) ((nl.f) this.L$0).getContext();
                File file2 = this.$file;
                g gVarB = w.b(file2, uk.e.e(bVar.d()), this.$compressedTypes);
                if (gVarB != null) {
                    fl.c cVarC = bVar.c();
                    gk.l.f6660c.getClass();
                    cVarC.g(gk.l.f6661d, Boolean.TRUE);
                }
                if (gVarB == null || (file = gVarB.file(file2)) == null) {
                    file = file2;
                }
                if (file.isFile()) {
                    v vVar = new v(new n(file, ik.u.a(ik.i.f7981f, file2)), gVarB == null ? null : gVarB.getEncoding());
                    vk.d dVarC = bVar.e().c();
                    this.label = 1;
                    if (dVarC.g(bVar, vVar, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            c cVar = new c(this.$file, this.$compressedTypes, dVar);
            cVar.L$0 = fVar;
            return cVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.content.StaticContentKt$files$1", f = "StaticContent.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        final /* synthetic */ List<g> $compressedTypes;
        final /* synthetic */ File $dir;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(File file, List<? extends g> list, um.d<? super d> dVar) {
            super(3, dVar);
            this.$dir = file;
            this.$compressedTypes = list;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            String strM3;
            File file;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                List<String> listB = ((dk.b) fVar.getContext()).getParameters().b(w.f11555a);
                if (listB == null) {
                    strM3 = null;
                } else {
                    String str = File.separator;
                    l0.o(str, "separator");
                    strM3 = h0.m3(listB, str, null, null, 0, null, null, 62, null);
                }
                if (strM3 == null) {
                    return l2.f10208a;
                }
                File fileB = f1.b(this.$dir, strM3);
                dk.b bVar = (dk.b) fVar.getContext();
                g gVarB = w.b(fileB, uk.e.e(bVar.d()), this.$compressedTypes);
                if (gVarB != null) {
                    fl.c cVarC = bVar.c();
                    gk.l.f6660c.getClass();
                    cVarC.g(gk.l.f6661d, Boolean.TRUE);
                }
                if (gVarB == null || (file = gVarB.file(fileB)) == null) {
                    file = fileB;
                }
                if (file.isFile()) {
                    v vVar = new v(new n(file, ik.u.a(ik.i.f7981f, fileB)), gVarB != null ? gVarB.getEncoding() : null);
                    vk.d dVarC = bVar.e().c();
                    this.label = 1;
                    if (dVarC.g(bVar, vVar, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            d dVar2 = new d(this.$dir, this.$compressedTypes, dVar);
            dVar2.L$0 = fVar;
            return dVar2.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.content.StaticContentKt$resource$1", f = "StaticContent.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        final /* synthetic */ String $packageName;
        final /* synthetic */ String $resource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, um.d<? super e> dVar) {
            super(3, dVar);
            this.$resource = str;
            this.$packageName = str2;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                s sVarD = x.d((dk.b) fVar.getContext(), this.$resource, this.$packageName, null, null, 12, null);
                if (sVarD != null) {
                    dk.b bVar = (dk.b) fVar.getContext();
                    vk.d dVarC = bVar.e().c();
                    this.label = 1;
                    if (dVarC.g(bVar, sVarD, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            e eVar = new e(this.$resource, this.$packageName, dVar);
            eVar.L$0 = fVar;
            return eVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.http.content.StaticContentKt$resources$1", f = "StaticContent.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        final /* synthetic */ String $packageName;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, um.d<? super f> dVar) {
            super(3, dVar);
            this.$packageName = str;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            String strM3;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                List<String> listB = ((dk.b) fVar.getContext()).getParameters().b(w.f11555a);
                if (listB == null) {
                    strM3 = null;
                } else {
                    String str = File.separator;
                    l0.o(str, "separator");
                    strM3 = h0.m3(listB, str, null, null, 0, null, null, 62, null);
                }
                String str2 = strM3;
                if (str2 == null) {
                    return l2.f10208a;
                }
                s sVarD = x.d((dk.b) fVar.getContext(), str2, this.$packageName, null, null, 12, null);
                if (sVarD != null) {
                    dk.b bVar = (dk.b) fVar.getContext();
                    vk.d dVarC = bVar.e().c();
                    this.label = 1;
                    if (dVarC.g(bVar, sVarD, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            f fVar2 = new f(this.$packageName, dVar);
            fVar2.L$0 = fVar;
            return fVar2.invokeSuspend(l2.f10208a);
        }
    }

    @os.l
    public static final wk.v A(@os.l wk.v vVar, @os.l jn.l<? super wk.v, l2> lVar) {
        l0.p(vVar, "<this>");
        l0.p(lVar, "configure");
        lVar.invoke(vVar);
        return vVar;
    }

    public static final g b(File file, List<ik.x> list, List<? extends g> list2) {
        List<ik.x> list3 = list;
        ArrayList arrayList = new ArrayList(nm.z.b0(list3, 10));
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(((ik.x) it.next()).f8200a);
        }
        Set setA6 = h0.a6(arrayList);
        Object obj = null;
        if (list2 == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (setA6.contains(((g) obj2).getEncoding())) {
                arrayList2.add(obj2);
            }
        }
        for (Object obj3 : arrayList2) {
            if (((g) obj3).file(file).isFile()) {
                obj = obj3;
                break;
            }
        }
        return (g) obj;
    }

    public static final File c(File file, File file2) {
        return file == null ? file2 : dn.q.h0(file, file2);
    }

    public static final String d(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) str);
        sb2.append(n1.e.f11183c);
        sb2.append((Object) str2);
        return sb2.toString();
    }

    public static final void e(@os.l wk.v vVar, @os.l File file) {
        l0.p(vVar, "<this>");
        l0.p(file, "localPath");
        wk.d0.g(vVar, new a(c(p(vVar), file), o(vVar), null));
    }

    public static final void f(@os.l wk.v vVar, @os.l String str) {
        l0.p(vVar, "<this>");
        l0.p(str, "localPath");
        e(vVar, new File(str));
    }

    public static final void g(@os.l wk.v vVar, @os.l String str, @os.m String str2) {
        l0.p(vVar, "<this>");
        l0.p(str, "resource");
        wk.d0.g(vVar, new b(str, d(n(vVar), str2), null));
    }

    public static /* synthetic */ void h(wk.v vVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        g(vVar, str, str2);
    }

    public static final void i(@os.l wk.v vVar, @os.l String str, @os.l File file) {
        l0.p(vVar, "<this>");
        l0.p(str, "remotePath");
        l0.p(file, "localPath");
        wk.d0.f(vVar, str, new c(c(p(vVar), file), o(vVar), null));
    }

    public static final void j(@os.l wk.v vVar, @os.l String str, @os.l String str2) {
        l0.p(vVar, "<this>");
        l0.p(str, "remotePath");
        l0.p(str2, "localPath");
        i(vVar, str, new File(str2));
    }

    public static /* synthetic */ void k(wk.v vVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        j(vVar, str, str2);
    }

    public static final void l(@os.l wk.v vVar, @os.l File file) {
        l0.p(vVar, "<this>");
        l0.p(file, "folder");
        wk.d0.f(vVar, "{static-content-path-parameter...}", new d(c(p(vVar), file), o(vVar), null));
    }

    public static final void m(@os.l wk.v vVar, @os.l String str) {
        l0.p(vVar, "<this>");
        l0.p(str, "folder");
        l(vVar, new File(str));
    }

    @os.m
    public static final String n(@os.l wk.v vVar) {
        l0.p(vVar, "<this>");
        String str = (String) vVar.f11582a.b(f11558d);
        if (str != null) {
            return str;
        }
        wk.v vVar2 = vVar.I;
        if (vVar2 == null) {
            return null;
        }
        return n(vVar2);
    }

    public static final List<g> o(wk.v vVar) {
        List<g> list = (List) vVar.f11582a.b(f11557c);
        if (list != null) {
            return list;
        }
        wk.v vVar2 = vVar.I;
        if (vVar2 == null) {
            return null;
        }
        return o(vVar2);
    }

    @os.m
    public static final File p(@os.l wk.v vVar) {
        l0.p(vVar, "<this>");
        File file = (File) vVar.f11582a.b(f11556b);
        if (file != null) {
            return file;
        }
        wk.v vVar2 = vVar.I;
        if (vVar2 == null) {
            return null;
        }
        return p(vVar2);
    }

    public static final void q(@os.l wk.v vVar, @os.l g[] gVarArr, @os.l jn.l<? super wk.v, l2> lVar) {
        l0.p(vVar, "<this>");
        l0.p(gVarArr, "types");
        l0.p(lVar, "configure");
        Collection collectionO = o(vVar);
        if (collectionO == null) {
            collectionO = k0.INSTANCE;
        }
        List listA2 = h0.a2(h0.E4(collectionO, nm.p.t(gVarArr)));
        fl.c cVar = vVar.f11582a;
        fl.b<List<g>> bVar = f11557c;
        cVar.g(bVar, listA2);
        lVar.invoke(vVar);
        vVar.f11582a.c(bVar);
    }

    public static /* synthetic */ void r(wk.v vVar, g[] gVarArr, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVarArr = g.values();
        }
        q(vVar, gVarArr, lVar);
    }

    public static final void s(@os.l wk.v vVar, @os.l String str, @os.l String str2, @os.m String str3) {
        l0.p(vVar, "<this>");
        l0.p(str, "remotePath");
        l0.p(str2, "resource");
        wk.d0.f(vVar, str, new e(str2, d(n(vVar), str3), null));
    }

    public static /* synthetic */ void t(wk.v vVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        s(vVar, str, str2, str3);
    }

    public static final void u(@os.l wk.v vVar, @os.m String str) {
        l0.p(vVar, "<this>");
        wk.d0.f(vVar, "{static-content-path-parameter...}", new f(d(n(vVar), str), null));
    }

    public static /* synthetic */ void v(wk.v vVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        u(vVar, str);
    }

    public static final Object w(dk.b bVar, File file, List<? extends g> list, um.d<? super l2> dVar) {
        File file2;
        g gVarB = b(file, uk.e.e(bVar.d()), list);
        if (gVarB != null) {
            fl.c cVarC = bVar.c();
            gk.l.f6660c.getClass();
            cVarC.g(gk.l.f6661d, Boolean.TRUE);
        }
        if (gVarB == null || (file2 = gVarB.file(file)) == null) {
            file2 = file;
        }
        if (!file2.isFile()) {
            return l2.f10208a;
        }
        bVar.e().c().g(bVar, new v(new n(file2, ik.u.a(ik.i.f7981f, file)), gVarB == null ? null : gVarB.getEncoding()), dVar);
        return l2.f10208a;
    }

    public static final void x(@os.l wk.v vVar, @os.m String str) {
        l0.p(vVar, "<this>");
        if (str != null) {
            vVar.f11582a.g(f11558d, str);
        } else {
            vVar.f11582a.c(f11558d);
        }
    }

    public static final void y(@os.l wk.v vVar, @os.m File file) {
        l0.p(vVar, "<this>");
        if (file != null) {
            vVar.f11582a.g(f11556b, file);
        } else {
            vVar.f11582a.c(f11556b);
        }
    }

    @os.l
    public static final wk.v z(@os.l wk.v vVar, @os.l String str, @os.l jn.l<? super wk.v, l2> lVar) {
        l0.p(vVar, "<this>");
        l0.p(str, "remotePath");
        l0.p(lVar, "configure");
        return wk.d0.D(vVar, str, lVar);
    }
}
