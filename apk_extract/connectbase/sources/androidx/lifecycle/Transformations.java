package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import in.i;
import jn.l;
import kn.k1;
import kn.l0;
import kn.n0;
import lm.k;
import lm.l2;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@i(name = "Transformations")
public final class Transformations {

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$distinctUntilChanged$1, reason: invalid class name */
    public static final class AnonymousClass1<X> extends n0 implements l<X, l2> {
        final /* synthetic */ k1.a $firstTime;
        final /* synthetic */ MediatorLiveData<X> $outputLiveData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MediatorLiveData<X> mediatorLiveData, k1.a aVar) {
            super(1);
            this.$outputLiveData = mediatorLiveData;
            this.$firstTime = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke2(obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x10) {
            X value = this.$outputLiveData.getValue();
            if (this.$firstTime.element || ((value == null && x10 != null) || !(value == null || l0.g(value, x10)))) {
                this.$firstTime.element = false;
                this.$outputLiveData.setValue(x10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$map$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06261<X> extends n0 implements l<X, l2> {
        final /* synthetic */ MediatorLiveData<Y> $result;
        final /* synthetic */ l<X, Y> $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06261(MediatorLiveData<Y> mediatorLiveData, l<X, Y> lVar) {
            super(1);
            this.$result = mediatorLiveData;
            this.$transform = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke2(obj);
            return l2.f10208a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x10) {
            this.$result.setValue((Y) this.$transform.invoke(x10));
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$map$2, reason: invalid class name */
    public static final class AnonymousClass2 extends n0 implements l<Object, l2> {
        final /* synthetic */ Function<Object, Object> $mapFunction;
        final /* synthetic */ MediatorLiveData<Object> $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MediatorLiveData<Object> mediatorLiveData, Function<Object, Object> function) {
            super(1);
            this.$result = mediatorLiveData;
            this.$mapFunction = function;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke2(obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            this.$result.setValue(this.$mapFunction.apply(obj));
        }
    }

    @i(name = "distinctUntilChanged")
    @CheckResult
    @MainThread
    @os.l
    public static final <X> LiveData<X> distinctUntilChanged(@os.l LiveData<X> liveData) {
        l0.p(liveData, "<this>");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        k1.a aVar = new k1.a();
        aVar.element = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            aVar.element = false;
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(mediatorLiveData, aVar)));
        return mediatorLiveData;
    }

    @i(name = "map")
    @CheckResult
    @MainThread
    @os.l
    public static final <X, Y> LiveData<Y> map(@os.l LiveData<X> liveData, @os.l l<X, Y> lVar) {
        l0.p(liveData, "<this>");
        l0.p(lVar, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C06261(mediatorLiveData, lVar)));
        return mediatorLiveData;
    }

    @i(name = "switchMap")
    @CheckResult
    @MainThread
    @os.l
    public static final <X, Y> LiveData<Y> switchMap(@os.l LiveData<X> liveData, @os.l final l<X, LiveData<Y>> lVar) {
        l0.p(liveData, "<this>");
        l0.p(lVar, "transform");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.switchMap.1

            @m
            private LiveData<Y> liveData;

            @m
            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x10) {
                LiveData<Y> liveData2 = (LiveData) lVar.invoke(x10);
                Object obj = this.liveData;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    MediatorLiveData<Y> mediatorLiveData2 = mediatorLiveData;
                    l0.m(obj);
                    mediatorLiveData2.removeSource(obj);
                }
                this.liveData = liveData2;
                if (liveData2 != 0) {
                    MediatorLiveData<Y> mediatorLiveData3 = mediatorLiveData;
                    l0.m(liveData2);
                    mediatorLiveData3.addSource(liveData2, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$1$onChanged$1(mediatorLiveData)));
                }
            }

            public final void setLiveData(@m LiveData<Y> liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }

    @i(name = "map")
    @CheckResult
    @k(level = lm.m.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function function) {
        l0.p(liveData, "<this>");
        l0.p(function, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(mediatorLiveData, function)));
        return mediatorLiveData;
    }

    @i(name = "switchMap")
    @CheckResult
    @k(level = lm.m.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, final Function function) {
        l0.p(liveData, "<this>");
        l0.p(function, "switchMapFunction");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<Object>() { // from class: androidx.lifecycle.Transformations.switchMap.2

            @m
            private LiveData<Object> liveData;

            @m
            public final LiveData<Object> getLiveData() {
                return this.liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                LiveData<Object> liveDataApply = function.apply(obj);
                LiveData<Object> liveData2 = this.liveData;
                if (liveData2 == liveDataApply) {
                    return;
                }
                if (liveData2 != null) {
                    MediatorLiveData<Object> mediatorLiveData2 = mediatorLiveData;
                    l0.m(liveData2);
                    mediatorLiveData2.removeSource(liveData2);
                }
                this.liveData = liveDataApply;
                if (liveDataApply != null) {
                    MediatorLiveData<Object> mediatorLiveData3 = mediatorLiveData;
                    l0.m(liveDataApply);
                    mediatorLiveData3.addSource(liveDataApply, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$2$onChanged$1(mediatorLiveData)));
                }
            }

            public final void setLiveData(@m LiveData<Object> liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }
}
