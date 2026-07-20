package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import cb.b;
import in.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.r1;
import kn.w;
import lm.t0;
import nm.d1;
import nm.p1;
import os.l;
import os.m;
import sq.a0;
import sq.f0;
import sq.u0;
import sq.w0;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
public final class SavedStateHandle {

    @l
    private static final String KEYS = "keys";

    @l
    private static final String VALUES = "values";

    @l
    private final Map<String, f0<Object>> flows;

    @l
    private final Map<String, SavingStateLiveData<?>> liveDatas;

    @l
    private final Map<String, Object> regular;

    @l
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;

    @l
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    @l
    public static final Companion Companion = new Companion(null);

    @l
    private static final Class<? extends Object>[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        @n
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @l
        public final SavedStateHandle createHandle(@m Bundle bundle, @m Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new SavedStateHandle();
                }
                HashMap map = new HashMap();
                for (String str : bundle2.keySet()) {
                    l0.o(str, b.c.f1408o);
                    map.put(str, bundle2.get(str));
                }
                return new SavedStateHandle(map);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(SavedStateHandle.KEYS);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(SavedStateHandle.VALUES);
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = parcelableArrayList.get(i10);
                l0.n(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
            }
            return new SavedStateHandle(linkedHashMap);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(@m Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.ACCEPTABLE_CLASSES) {
                l0.m(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    public SavedStateHandle(@l Map<String, ? extends Object> map) {
        l0.p(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.regular = linkedHashMap;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: g0.g
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                return SavedStateHandle.savedStateProvider$lambda$0(this.f6346a);
            }
        };
        linkedHashMap.putAll(map);
    }

    @n
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @l
    public static final SavedStateHandle createHandle(@m Bundle bundle, @m Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z10, T t10) {
        SavingStateLiveData<?> savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2 = this.liveDatas.get(str);
        SavingStateLiveData<?> savingStateLiveData3 = savingStateLiveData2 instanceof MutableLiveData ? savingStateLiveData2 : null;
        if (savingStateLiveData3 != null) {
            return savingStateLiveData3;
        }
        if (this.regular.containsKey(str)) {
            savingStateLiveData = new SavingStateLiveData<>(this, str, this.regular.get(str));
        } else if (z10) {
            this.regular.put(str, t10);
            savingStateLiveData = new SavingStateLiveData<>(this, str, t10);
        } else {
            savingStateLiveData = new SavingStateLiveData<>(this, str);
        }
        this.liveDatas.put(str, savingStateLiveData);
        return savingStateLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandle savedStateHandle) {
        l0.p(savedStateHandle, "this$0");
        for (Map.Entry entry : d1.F0(savedStateHandle.savedStateProviders).entrySet()) {
            savedStateHandle.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
        }
        Set<String> setKeySet = savedStateHandle.regular.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(savedStateHandle.regular.get(str));
        }
        return BundleKt.bundleOf(new t0(KEYS, arrayList), new t0(VALUES, arrayList2));
    }

    @MainThread
    public final void clearSavedStateProvider(@l String str) {
        l0.p(str, b.c.f1408o);
        this.savedStateProviders.remove(str);
    }

    @MainThread
    public final boolean contains(@l String str) {
        l0.p(str, b.c.f1408o);
        return this.regular.containsKey(str);
    }

    @m
    @MainThread
    public final <T> T get(@l String str) {
        l0.p(str, b.c.f1408o);
        try {
            return (T) this.regular.get(str);
        } catch (ClassCastException unused) {
            remove(str);
            return null;
        }
    }

    @MainThread
    @l
    public final <T> MutableLiveData<T> getLiveData(@l String str) {
        l0.p(str, b.c.f1408o);
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(str, false, null);
        l0.n(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    @MainThread
    @l
    public final <T> u0<T> getStateFlow(@l String str, T t10) {
        l0.p(str, b.c.f1408o);
        Map<String, f0<Object>> map = this.flows;
        f0<Object> f0VarA = map.get(str);
        if (f0VarA == null) {
            if (!this.regular.containsKey(str)) {
                this.regular.put(str, t10);
            }
            f0VarA = w0.a(this.regular.get(str));
            this.flows.put(str, f0VarA);
            map.put(str, f0VarA);
        }
        u0<T> u0VarB = a0.b(f0VarA);
        l0.n(u0VarB, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return u0VarB;
    }

    @MainThread
    @l
    public final Set<String> keys() {
        return p1.D(p1.D(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    @m
    @MainThread
    public final <T> T remove(@l String str) {
        l0.p(str, b.c.f1408o);
        T t10 = (T) this.regular.remove(str);
        SavingStateLiveData<?> savingStateLiveDataRemove = this.liveDatas.remove(str);
        if (savingStateLiveDataRemove != null) {
            savingStateLiveDataRemove.detach();
        }
        this.flows.remove(str);
        return t10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @l
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(@l String str, @m T t10) {
        l0.p(str, b.c.f1408o);
        if (!Companion.validateValue(t10)) {
            StringBuilder sb2 = new StringBuilder("Can't put value with type ");
            l0.m(t10);
            sb2.append(t10.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(str);
        SavingStateLiveData<?> savingStateLiveData2 = savingStateLiveData instanceof MutableLiveData ? savingStateLiveData : null;
        if (savingStateLiveData2 != null) {
            savingStateLiveData2.setValue(t10);
        } else {
            this.regular.put(str, t10);
        }
        f0<Object> f0Var = this.flows.get(str);
        if (f0Var == null) {
            return;
        }
        f0Var.setValue(t10);
    }

    @MainThread
    public final void setSavedStateProvider(@l String str, @l SavedStateRegistry.SavedStateProvider savedStateProvider) {
        l0.p(str, b.c.f1408o);
        l0.p(savedStateProvider, "provider");
        this.savedStateProviders.put(str, savedStateProvider);
    }

    @MainThread
    @l
    public final <T> MutableLiveData<T> getLiveData(@l String str, T t10) {
        l0.p(str, b.c.f1408o);
        return getLiveDataInternal(str, true, t10);
    }

    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {

        @m
        private SavedStateHandle handle;

        @l
        private String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(@m SavedStateHandle savedStateHandle, @l String str, T t10) {
            super(t10);
            l0.p(str, b.c.f1408o);
            this.key = str;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t10) {
            SavedStateHandle savedStateHandle = this.handle;
            if (savedStateHandle != null) {
                savedStateHandle.regular.put(this.key, t10);
                f0 f0Var = (f0) savedStateHandle.flows.get(this.key);
                if (f0Var != null) {
                    f0Var.setValue(t10);
                }
            }
            super.setValue(t10);
        }

        public SavingStateLiveData(@m SavedStateHandle savedStateHandle, @l String str) {
            l0.p(str, b.c.f1408o);
            this.key = str;
            this.handle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: g0.g
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                return SavedStateHandle.savedStateProvider$lambda$0(this.f6346a);
            }
        };
    }
}
