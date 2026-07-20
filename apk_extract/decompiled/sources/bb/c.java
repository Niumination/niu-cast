package bb;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Observer, FunctionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1229a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f1230b;

    public c(a function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f1230b = function;
    }

    public final boolean equals(Object obj) {
        switch (this.f1229a) {
            case 0:
                if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
                    return false;
                }
                return Intrinsics.areEqual((a) this.f1230b, ((FunctionAdapter) obj).getFunctionDelegate());
            case 1:
                if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual((f) this.f1230b, ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            case 2:
                if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual((bc.a) this.f1230b, ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            case 3:
                if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual((sb.a) this.f1230b, ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            default:
                if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual((sb.a) this.f1230b, ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
        }
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        switch (this.f1229a) {
            case 0:
                return (a) this.f1230b;
            case 1:
                return (f) this.f1230b;
            case 2:
                return (bc.a) this.f1230b;
            case 3:
                return (sb.a) this.f1230b;
            default:
                return (sb.a) this.f1230b;
        }
    }

    public final int hashCode() {
        switch (this.f1229a) {
            case 0:
                return ((a) this.f1230b).hashCode();
            case 1:
                return ((f) this.f1230b).hashCode();
            case 2:
                return ((bc.a) this.f1230b).hashCode();
            case 3:
                return ((sb.a) this.f1230b).hashCode();
            default:
                return ((sb.a) this.f1230b).hashCode();
        }
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        switch (this.f1229a) {
            case 0:
                ((a) this.f1230b).invoke(obj);
                break;
            case 1:
                ((f) this.f1230b).invoke(obj);
                break;
            case 2:
                ((bc.a) this.f1230b).invoke(obj);
                break;
            case 3:
                ((sb.a) this.f1230b).invoke(obj);
                break;
            default:
                ((sb.a) this.f1230b).invoke(obj);
                break;
        }
    }

    public c(f function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f1230b = function;
    }

    public c(bc.a function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f1230b = function;
    }

    public c(sb.a function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f1230b = function;
    }

    public c(sb.a function, byte b9) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f1230b = function;
    }
}
