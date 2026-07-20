package qg;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import m3.c6;
import m3.d6;
import m3.y5;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    public d0(Continuation<? super d0> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        d0 d0Var = new d0(continuation);
        d0Var.L$0 = fVar;
        d0Var.L$1 = obj;
        return d0Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0082  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cb A[Catch: a -> 0x0155, TRY_LEAVE, TryCatch #0 {a -> 0x0155, blocks: (B:33:0x00b2, B:35:0x00c3, B:37:0x00cb), top: B:88:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0187  */
    /* JADX WARN: Code duplicated, block: B:82:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:84:0x020a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x020b  */
    /* JADX WARN: Instruction removed from duplicated block: B:82:0x01bd, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:85:0x020b, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        hh.f fVar;
        Object obj2;
        Object objG;
        hh.f fVar2;
        Object objR;
        zf.i iVarA;
        zf.e0 e0VarA;
        Object obj3;
        zf.i iVarA2;
        Object objA;
        int i8 = 0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = this.label;
        if (i9 != 0) {
            if (i9 != 1) {
                if (i9 == 2) {
                    Object obj4 = this.L$1;
                    fVar = (hh.f) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj4;
                    objA = obj;
                    objR = d6.b(0, 14, (String) objA);
                    fVar2 = fVar;
                    if (objR != null) {
                        g0.f9071a.trace("Transformed " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " to " + Reflection.getOrCreateKotlinClass(objR.getClass()) + " for " + m3.k.a(((mg.r) fVar2.f5401a).g()));
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (fVar2.f(objR, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        g0.f9071a.trace("No Default Transformations found for " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " and expected type " + mg.s.a((mg.r) fVar2.f5401a) + " for call " + m3.k.a(((mg.r) fVar2.f5401a).g()));
                        Unit unit = Unit.INSTANCE;
                    }
                } else if (i9 == 3) {
                    e0VarA = (zf.e0) this.L$2;
                    obj3 = this.L$1;
                    fVar = (hh.f) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objR = e0VarA.build();
                    obj2 = obj3;
                    fVar2 = fVar;
                    if (objR != null) {
                        g0.f9071a.trace("Transformed " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " to " + Reflection.getOrCreateKotlinClass(objR.getClass()) + " for " + m3.k.a(((mg.r) fVar2.f5401a).g()));
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (fVar2.f(objR, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        g0.f9071a.trace("No Default Transformations found for " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " and expected type " + mg.s.a((mg.r) fVar2.f5401a) + " for call " + m3.k.a(((mg.r) fVar2.f5401a).g()));
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else if (i9 != 4) {
                    if (i9 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
            Object obj5 = this.L$1;
            fVar2 = (hh.f) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj5;
            objR = obj;
            if (objR != null) {
                g0.f9071a.trace("Transformed " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " to " + Reflection.getOrCreateKotlinClass(objR.getClass()) + " for " + m3.k.a(((mg.r) fVar2.f5401a).g()));
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 5;
                if (fVar2.f(objR, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                g0.f9071a.trace("No Default Transformations found for " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " and expected type " + mg.s.a((mg.r) fVar2.f5401a) + " for call " + m3.k.a(((mg.r) fVar2.f5401a).g()));
                Unit unit3 = Unit.INSTANCE;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            fVar = (hh.f) this.L$0;
            obj2 = this.L$1;
            boolean z2 = obj2 instanceof jh.o;
            jh.o oVar = z2 ? (jh.o) obj2 : null;
            if (oVar == null) {
                return Unit.INSTANCE;
            }
            ih.a aVarA = mg.s.a((mg.r) fVar.f5401a);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(jh.o.class);
            KClass kClass = aVarA.f5872a;
            if (Intrinsics.areEqual(kClass, orCreateKotlinClass)) {
                fVar2 = fVar;
                objR = null;
            } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                this.L$0 = fVar;
                this.L$1 = obj2;
                this.label = 1;
                objR = jh.g0.r(oVar, this);
                if (objR == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fVar2 = fVar;
            } else {
                boolean zAreEqual = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(zf.d0.class));
                Object obj6 = fVar.f5401a;
                if (zAreEqual) {
                    mg.r rVar = (mg.r) obj6;
                    try {
                        vg.e eVarG = ((mg.r) obj6).g();
                        Intrinsics.checkNotNullParameter(eVarG, "<this>");
                        String[] strArr = zf.v.f11551a;
                        String strB = m3.k.b(eVarG, "Content-Type");
                        if (strB != null) {
                            zf.i iVar = zf.i.f11505h;
                            iVarA = m3.l0.a(strB);
                            if (iVarA == null) {
                                iVarA = zf.i.f11505h;
                            }
                        } else {
                            iVarA = zf.i.f11505h;
                        }
                        if (iVarA.k(zf.f.f11499b)) {
                            vg.e eVarG2 = rVar.g();
                            Intrinsics.checkNotNullParameter(eVarG2, "<this>");
                            Intrinsics.checkNotNullParameter(eVarG2, "<this>");
                            String strB2 = m3.k.b(eVarG2, "Content-Type");
                            if (strB2 == null || (iVarA2 = m3.l0.a(strB2)) == null) {
                                iVarA2 = zf.i.f11505h;
                            }
                            Charset charsetA = y5.a(iVarA2);
                            if (charsetA == null) {
                                charsetA = Charsets.UTF_8;
                            }
                            this.L$0 = fVar;
                            this.L$1 = obj2;
                            this.label = 2;
                            objA = g0.a(oVar, charsetA, this);
                            if (objA == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objR = d6.b(0, 14, (String) objA);
                            fVar2 = fVar;
                        } else if (iVarA.k(zf.g.f11500a)) {
                            zf.q qVar = zf.d0.f11496b;
                            e0VarA = c6.a();
                            ag.j jVarG = h.g(fVar, oVar);
                            c0 c0Var = new c0(e0VarA, null);
                            this.L$0 = fVar;
                            this.L$1 = obj2;
                            this.L$2 = e0VarA;
                            this.label = 3;
                            Intrinsics.checkNotNullParameter(jVarG, "<this>");
                            Object objA2 = new oi.b0(new cg.c(jVarG, null)).a(new cg.d(c0Var), this);
                            if (objA2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                objA2 = Unit.INSTANCE;
                            }
                            if (objA2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj3 = obj2;
                            objR = e0VarA.build();
                            obj2 = obj3;
                            fVar2 = fVar;
                        } else {
                            fVar2 = fVar;
                            objR = null;
                        }
                    } catch (zf.a e) {
                        StringBuilder sb2 = new StringBuilder("Illegal Content-Type header format: ");
                        zf.r rVarA = rVar.g().a();
                        String[] strArr2 = zf.v.f11551a;
                        sb2.append(rVarA.get("Content-Type"));
                        throw new ug.a(sb2.toString(), e);
                    }
                } else {
                    this.L$0 = fVar;
                    this.L$1 = obj2;
                    this.label = 4;
                    jh.o oVar2 = z2 ? (jh.o) obj2 : null;
                    if (oVar2 == null) {
                        objG = null;
                    } else {
                        ih.a aVarA2 = mg.s.a((mg.r) obj6);
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(InputStream.class);
                        KClass kClass2 = aVarA2.f5872a;
                        if (Intrinsics.areEqual(kClass2, orCreateKotlinClass2)) {
                            Intrinsics.checkNotNullParameter(oVar2, "<this>");
                            objG = new mh.b(oVar2, i8);
                        } else if (Intrinsics.areEqual(kClass2, Reflection.getOrCreateKotlinClass(cg.b.class))) {
                            objG = h.g(fVar, oVar2);
                        } else {
                            objG = null;
                        }
                    }
                    if (objG == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fVar2 = fVar;
                    objR = objG;
                }
            }
            if (objR != null) {
                g0.f9071a.trace("Transformed " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " to " + Reflection.getOrCreateKotlinClass(objR.getClass()) + " for " + m3.k.a(((mg.r) fVar2.f5401a).g()));
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 5;
                if (fVar2.f(objR, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                g0.f9071a.trace("No Default Transformations found for " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " and expected type " + mg.s.a((mg.r) fVar2.f5401a) + " for call " + m3.k.a(((mg.r) fVar2.f5401a).g()));
                Unit unit4 = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
