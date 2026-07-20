package sb;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Observer, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f9610b;

    public h(int i8, Function1 function) {
        this.f9609a = i8;
        switch (i8) {
            case 1:
                Intrinsics.checkNotNullParameter(function, "function");
                this.f9610b = function;
                break;
            case 2:
                Intrinsics.checkNotNullParameter(function, "function");
                this.f9610b = function;
                break;
            default:
                Intrinsics.checkNotNullParameter(function, "function");
                this.f9610b = function;
                break;
        }
    }

    public final boolean equals(Object obj) {
        switch (this.f9609a) {
            case 0:
                if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(this.f9610b, ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            case 1:
                if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(this.f9610b, ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            default:
                if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(this.f9610b, ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
        }
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        switch (this.f9609a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.f9610b;
    }

    public final int hashCode() {
        switch (this.f9609a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.f9610b.hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        switch (this.f9609a) {
            case 0:
                this.f9610b.invoke(obj);
                break;
            case 1:
                this.f9610b.invoke(obj);
                break;
            default:
                this.f9610b.invoke(obj);
                break;
        }
    }
}
