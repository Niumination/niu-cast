package ze;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class w1 implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11463c;

    public /* synthetic */ w1(int i8, Object obj, Object obj2) {
        this.f11461a = i8;
        this.f11462b = obj;
        this.f11463c = obj2;
    }

    @Override // ze.y1
    public final Object a(sj.a aVar, int i8, int i9) {
        switch (this.f11461a) {
            case 0:
                int i10 = 0;
                while (true) {
                    Object[] objArr = (Object[]) this.f11462b;
                    if (i10 >= objArr.length) {
                        return null;
                    }
                    if (objArr[i10] == aVar) {
                        return ((Object[]) this.f11463c)[i10];
                    }
                    i10++;
                }
                break;
            default:
                if (((sj.a) this.f11462b) == aVar) {
                    return this.f11463c;
                }
                return null;
        }
    }

    @Override // ze.y1
    public final y1 b(sj.a aVar, Object obj, int i8, int i9) {
        w1 w1Var;
        switch (this.f11461a) {
            case 0:
                Object[] objArr = (Object[]) this.f11462b;
                int i10 = 0;
                int iHashCode = objArr[0].hashCode();
                if (iHashCode != i8) {
                    return x1.c(new w1(1, aVar, obj), i8, this, iHashCode, i9);
                }
                while (true) {
                    if (i10 >= objArr.length) {
                        i10 = -1;
                    } else if (objArr[i10] != aVar) {
                        i10++;
                    }
                }
                Object[] objArr2 = (Object[]) this.f11463c;
                if (i10 != -1) {
                    Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    Object[] objArrCopyOf2 = Arrays.copyOf(objArr2, objArr.length);
                    objArrCopyOf[i10] = aVar;
                    objArrCopyOf2[i10] = obj;
                    w1Var = new w1(0, objArrCopyOf, objArrCopyOf2);
                } else {
                    Object[] objArrCopyOf3 = Arrays.copyOf(objArr, objArr.length + 1);
                    Object[] objArrCopyOf4 = Arrays.copyOf(objArr2, objArr.length + 1);
                    objArrCopyOf3[objArr.length] = aVar;
                    objArrCopyOf4[objArr.length] = obj;
                    w1Var = new w1(0, objArrCopyOf3, objArrCopyOf4);
                }
                return w1Var;
            default:
                sj.a aVar2 = (sj.a) this.f11462b;
                int iHashCode2 = aVar2.hashCode();
                if (iHashCode2 != i8) {
                    return x1.c(new w1(1, aVar, obj), i8, this, iHashCode2, i9);
                }
                if (aVar2 == aVar) {
                    return new w1(1, aVar, obj);
                }
                return new w1(0, new Object[]{aVar2, aVar}, new Object[]{this.f11463c, obj});
        }
    }

    @Override // ze.y1
    public final int size() {
        switch (this.f11461a) {
            case 0:
                return ((Object[]) this.f11463c).length;
            default:
                return 1;
        }
    }

    public final String toString() {
        switch (this.f11461a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("CollisionLeaf(");
                int i8 = 0;
                while (true) {
                    Object[] objArr = (Object[]) this.f11463c;
                    if (i8 >= objArr.length) {
                        sb2.append(")");
                        return sb2.toString();
                    }
                    sb2.append("(key=");
                    sb2.append(((Object[]) this.f11462b)[i8]);
                    sb2.append(" value=");
                    sb2.append(objArr[i8]);
                    sb2.append(") ");
                    i8++;
                }
                break;
            default:
                return String.format("Leaf(key=%s value=%s)", (sj.a) this.f11462b, this.f11463c);
        }
    }
}
