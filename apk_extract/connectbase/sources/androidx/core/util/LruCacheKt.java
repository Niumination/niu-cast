package androidx.core.util;

import android.util.LruCache;
import cb.b;
import jn.p;
import jn.r;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$1, reason: invalid class name */
    @r1({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$1\n*L\n1#1,54:1\n*E\n"})
    public static final class AnonymousClass1 extends n0 implements p<Object, Object, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.p
        @l
        public final Integer invoke(@l Object obj, @l Object obj2) {
            l0.p(obj, "<anonymous parameter 0>");
            l0.p(obj2, "<anonymous parameter 1>");
            return 1;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$2, reason: invalid class name */
    @r1({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$2\n*L\n1#1,54:1\n*E\n"})
    public static final class AnonymousClass2 extends n0 implements jn.l<Object, Object> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Object invoke(@l Object obj) {
            l0.p(obj, "it");
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$3, reason: invalid class name */
    @r1({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$3\n*L\n1#1,54:1\n*E\n"})
    public static final class AnonymousClass3 extends n0 implements r<Boolean, Object, Object, Object, l2> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        public final void invoke(boolean z10, @l Object obj, @l Object obj2, @m Object obj3) {
            l0.p(obj, "<anonymous parameter 1>");
            l0.p(obj2, "<anonymous parameter 2>");
        }

        @Override // jn.r
        public /* bridge */ /* synthetic */ l2 invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
            invoke(bool.booleanValue(), obj, obj2, obj3);
            return l2.f10208a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    @r1({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$4\n*L\n1#1,54:1\n*E\n"})
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ jn.l<K, V> $create;
        final /* synthetic */ r<Boolean, K, V, V, l2> $onEntryRemoved;
        final /* synthetic */ p<K, V, Integer> $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(int i10, p<? super K, ? super V, Integer> pVar, jn.l<? super K, ? extends V> lVar, r<? super Boolean, ? super K, ? super V, ? super V, l2> rVar) {
            super(i10);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
        }

        @Override // android.util.LruCache
        @m
        public V create(@l K k10) {
            l0.p(k10, b.c.f1408o);
            return this.$create.invoke(k10);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z10, @l K k10, @l V v10, @m V v11) {
            l0.p(k10, b.c.f1408o);
            l0.p(v10, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(z10), k10, v10, v11);
        }

        @Override // android.util.LruCache
        public int sizeOf(@l K k10, @l V v10) {
            l0.p(k10, b.c.f1408o);
            l0.p(v10, "value");
            return this.$sizeOf.invoke(k10, v10).intValue();
        }
    }

    @l
    public static final <K, V> LruCache<K, V> lruCache(int i10, @l p<? super K, ? super V, Integer> pVar, @l jn.l<? super K, ? extends V> lVar, @l r<? super Boolean, ? super K, ? super V, ? super V, l2> rVar) {
        l0.p(pVar, "sizeOf");
        l0.p(lVar, "create");
        l0.p(rVar, "onEntryRemoved");
        return new AnonymousClass4(i10, pVar, lVar, rVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i10, p pVar, jn.l lVar, r rVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        l0.p(pVar, "sizeOf");
        l0.p(lVar, "create");
        l0.p(rVar, "onEntryRemoved");
        return new AnonymousClass4(i10, pVar, lVar, rVar);
    }
}
