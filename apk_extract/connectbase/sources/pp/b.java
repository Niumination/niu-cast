package pp;

import os.l;
import os.m;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public class b extends a implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final eo.a f13232c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@l eo.a aVar, @l f0 f0Var, @m e eVar) {
        super(f0Var, eVar);
        if (aVar == null) {
            b(0);
        }
        if (f0Var == null) {
            b(1);
        }
        this.f13232c = aVar;
    }

    public static /* synthetic */ void b(int i10) {
        String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 2 ? 3 : 2];
        if (i10 == 1) {
            objArr[0] = "receiverType";
        } else if (i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i10 != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i10 != 2) {
            if (i10 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 == 2) {
            throw new IllegalStateException(str2);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.f13232c + "}";
    }
}
