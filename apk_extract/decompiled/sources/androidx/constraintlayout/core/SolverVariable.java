package androidx.constraintlayout.core;

import androidx.exifinterface.media.ExifInterface;
import h0.a;
import java.util.Arrays;
import java.util.HashSet;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f1075id;
    public boolean inGoal;
    HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    boolean isSynonym;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    int synonym;
    float synonymDelta;
    public int usageInRowCount;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.SolverVariable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.f1075id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            StringBuilder sbS = d.s(str);
            sbS.append(uniqueErrorId);
            return sbS.toString();
        }
        int i8 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[type.ordinal()];
        if (i8 == 1) {
            StringBuilder sb2 = new StringBuilder("U");
            int i9 = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i9;
            sb2.append(i9);
            return sb2.toString();
        }
        if (i8 == 2) {
            StringBuilder sb3 = new StringBuilder("C");
            int i10 = uniqueConstantId + 1;
            uniqueConstantId = i10;
            sb3.append(i10);
            return sb3.toString();
        }
        if (i8 == 3) {
            StringBuilder sb4 = new StringBuilder(ExifInterface.LATITUDE_SOUTH);
            int i11 = uniqueSlackId + 1;
            uniqueSlackId = i11;
            sb4.append(i11);
            return sb4.toString();
        }
        if (i8 == 4) {
            StringBuilder sb5 = new StringBuilder("e");
            int i12 = uniqueErrorId + 1;
            uniqueErrorId = i12;
            sb5.append(i12);
            return sb5.toString();
        }
        if (i8 != 5) {
            throw new AssertionError(type.name());
        }
        StringBuilder sb6 = new StringBuilder(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i13 = uniqueId + 1;
        uniqueId = i13;
        sb6.append(i13);
        return sb6.toString();
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i8 = 0;
        while (true) {
            int i9 = this.mClientEquationsCount;
            if (i8 >= i9) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i9 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i10 = this.mClientEquationsCount;
                arrayRowArr2[i10] = arrayRow;
                this.mClientEquationsCount = i10 + 1;
                return;
            }
            if (this.mClientEquations[i8] == arrayRow) {
                return;
            } else {
                i8++;
            }
        }
    }

    public void clearStrengths() {
        for (int i8 = 0; i8 < 9; i8++) {
            this.strengthVector[i8] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i8 = this.mClientEquationsCount;
        int i9 = 0;
        while (i9 < i8) {
            if (this.mClientEquations[i9] == arrayRow) {
                while (i9 < i8 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i10 = i9 + 1;
                    arrayRowArr[i9] = arrayRowArr[i10];
                    i9 = i10;
                }
                this.mClientEquationsCount--;
                return;
            }
            i9++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f1075id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i8 = this.mClientEquationsCount;
        for (int i9 = 0; i9 < i8; i9++) {
            this.mClientEquations[i9] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int i8 = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i9 = 0; i9 < i8; i9++) {
            this.mClientEquations[i9].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f) {
        this.isSynonym = true;
        this.synonym = solverVariable.f1075id;
        this.synonymDelta = f;
        int i8 = this.mClientEquationsCount;
        this.definitionId = -1;
        for (int i9 = 0; i9 < i8; i9++) {
            this.mClientEquations[i9].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String strB = this + "[";
        int i8 = 0;
        boolean z2 = false;
        boolean z3 = true;
        while (i8 < this.strengthVector.length) {
            StringBuilder sbS = d.s(strB);
            sbS.append(this.strengthVector[i8]);
            String string = sbS.toString();
            float[] fArr = this.strengthVector;
            float f = fArr[i8];
            if (f > 0.0f) {
                z2 = false;
            } else if (f < 0.0f) {
                z2 = true;
            }
            if (f != 0.0f) {
                z3 = false;
            }
            strB = i8 < fArr.length - 1 ? a.B(string, ", ") : a.B(string, "] ");
            i8++;
        }
        if (z2) {
            strB = a.B(strB, " (-)");
        }
        return z3 ? a.B(strB, " (*)") : strB;
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.f1075id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i8 = this.mClientEquationsCount;
        for (int i9 = 0; i9 < i8; i9++) {
            this.mClientEquations[i9].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(SolverVariable solverVariable) {
        return this.f1075id - solverVariable.f1075id;
    }

    public SolverVariable(Type type, String str) {
        this.f1075id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = type;
    }
}
