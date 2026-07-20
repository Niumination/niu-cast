package se;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q1 implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f9949b;

    public /* synthetic */ q1(int i8, Function1 function1) {
        this.f9948a = i8;
        this.f9949b = function1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f9948a) {
            case 0:
                return ((Boolean) ((sb.a) this.f9949b).invoke(obj)).booleanValue();
            case 1:
                return ((Boolean) ((sb.a) this.f9949b).invoke(obj)).booleanValue();
            default:
                return ((Boolean) ((hg.e) this.f9949b).invoke(obj)).booleanValue();
        }
    }
}
