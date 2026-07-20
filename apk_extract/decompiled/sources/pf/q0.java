package pf;

import java.util.Set;
import k3.g2;
import k3.pc;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f8861a = SetsKt.setOf((Object[]) new zf.x[]{zf.x.f11553b, zf.x.f11556g});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vj.b f8862b = g2.a("io.ktor.client.plugins.HttpRedirect");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final yf.a f8863c = new yf.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final qf.c f8864d = pc.a("HttpRedirect", n0.INSTANCE, new ag.b(26));

    /* JADX WARN: Code duplicated, block: B:34:0x0160  */
    /* JADX WARN: Code duplicated, block: B:37:0x0167  */
    /* JADX WARN: Code duplicated, block: B:44:0x019a  */
    /* JADX WARN: Code duplicated, block: B:47:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:48:0x01df  */
    /* JADX WARN: Code duplicated, block: B:51:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:53:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [T] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r11v13, types: [pf.m1] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r12v11, types: [T, vf.c] */
    /* JADX WARN: Type inference failed for: r20v0, types: [T, java.lang.Object, kf.c] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, vf.c] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01df -> B:49:0x01e4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(qf.f r18, vf.c r19, kf.c r20, boolean r21, jf.d r22, kotlin.coroutines.jvm.internal.ContinuationImpl r23) {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pf.q0.a(qf.f, vf.c, kf.c, boolean, jf.d, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final boolean b(zf.z zVar) {
        int i8 = zVar.f11581a;
        zf.z zVar2 = zf.z.f11564c;
        return i8 == zf.z.f11567i.f11581a || i8 == zf.z.f11568j.f11581a || i8 == zf.z.f11571m.f11581a || i8 == zf.z.f11572n.f11581a || i8 == zf.z.f11569k.f11581a;
    }
}
