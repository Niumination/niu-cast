package a3;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kn.l0;
import kn.r1;
import os.l;
import y2.b;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nDataProcessorManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataProcessorManager.kt\ncom/transsion/airtransfer/filetransfer/process/DataProcessorManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n1855#2,2:36\n1855#2,2:38\n*S KotlinDebug\n*F\n+ 1 DataProcessorManager.kt\ncom/transsion/airtransfer/filetransfer/process/DataProcessorManager\n*L\n23#1:36,2\n30#1:38,2\n*E\n"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f42a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final Set<b<?, ?>> f43b = new LinkedHashSet();

    public final void a(@l b<?, ?> bVar) {
        l0.p(bVar, "dataProcessor");
        f43b.add(bVar);
    }

    public final synchronized void b() {
        v2.b.f16500a.a();
        Iterator<T> it = f43b.iterator();
        while (it.hasNext()) {
            ((b) it.next()).start();
        }
    }

    public final synchronized void c() {
        try {
            Iterator<T> it = f43b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).stop();
            }
            f43b.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
