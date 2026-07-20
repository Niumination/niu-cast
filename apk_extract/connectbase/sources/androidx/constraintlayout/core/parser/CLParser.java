package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public class CLParser {
    static boolean DEBUG = false;
    private boolean hasComment = false;
    private int lineNumber;
    private String mContent;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.parser.CLParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE;

        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = iArr;
            try {
                iArr[TYPE.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i10, TYPE type, boolean z10, char[] cArr) {
        CLElement cLElementAllocate;
        if (DEBUG) {
            System.out.println("CREATE " + type + " at " + cArr[i10]);
        }
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[type.ordinal()]) {
            case 1:
                cLElementAllocate = CLObject.allocate(cArr);
                i10++;
                break;
            case 2:
                cLElementAllocate = CLArray.allocate(cArr);
                i10++;
                break;
            case 3:
                cLElementAllocate = CLString.allocate(cArr);
                break;
            case 4:
                cLElementAllocate = CLNumber.allocate(cArr);
                break;
            case 5:
                cLElementAllocate = CLKey.allocate(cArr);
                break;
            case 6:
                cLElementAllocate = CLToken.allocate(cArr);
                break;
            default:
                cLElementAllocate = null;
                break;
        }
        if (cLElementAllocate == null) {
            return null;
        }
        cLElementAllocate.setLine(this.lineNumber);
        if (z10) {
            cLElementAllocate.setStart(i10);
        }
        if (cLElement instanceof CLContainer) {
            cLElementAllocate.setContainer((CLContainer) cLElement);
        }
        return cLElementAllocate;
    }

    private CLElement getNextJsonElement(int i10, char c10, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\r' || c10 == ' ') {
            return cLElement;
        }
        if (c10 == '\"' || c10 == '\'') {
            return cLElement instanceof CLObject ? createElement(cLElement, i10, TYPE.KEY, true, cArr) : createElement(cLElement, i10, TYPE.STRING, true, cArr);
        }
        if (c10 == '[') {
            return createElement(cLElement, i10, TYPE.ARRAY, true, cArr);
        }
        if (c10 != ']') {
            if (c10 == '{') {
                return createElement(cLElement, i10, TYPE.OBJECT, true, cArr);
            }
            if (c10 != '}') {
                switch (c10) {
                    case '+':
                    case '-':
                    case '.':
                    case '0':
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    case '2':
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    case '4':
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    case '6':
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    case '8':
                    case '9':
                        return createElement(cLElement, i10, TYPE.NUMBER, true, cArr);
                    case ',':
                    case ':':
                        return cLElement;
                    case '/':
                        int i11 = i10 + 1;
                        if (i11 >= cArr.length || cArr[i11] != '/') {
                            return cLElement;
                        }
                        this.hasComment = true;
                        return cLElement;
                    default:
                        if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                            return createElement(cLElement, i10, TYPE.KEY, true, cArr);
                        }
                        CLElement cLElementCreateElement = createElement(cLElement, i10, TYPE.TOKEN, true, cArr);
                        CLToken cLToken = (CLToken) cLElementCreateElement;
                        if (cLToken.validate(c10, i10)) {
                            return cLElementCreateElement;
                        }
                        throw new CLParsingException("incorrect token <" + c10 + "> at line " + this.lineNumber, cLToken);
                }
            }
        }
        cLElement.setEnd(i10 - 1);
        CLElement container = cLElement.getContainer();
        container.setEnd(i10);
        return container;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0149 A[EDGE_INSN: B:106:0x0149->B:116:? BREAK  A[LOOP:1: B:14:0x0036->B:86:0x0143], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x0059  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0092  */
    /* JADX WARN: Code duplicated, block: B:42:0x009e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00de  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:76:0x0118  */
    /* JADX WARN: Code duplicated, block: B:78:0x0123  */
    public CLObject parse() throws CLParsingException {
        boolean z10;
        long j10;
        char c10;
        long j11;
        CLToken cLToken;
        long j12;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i10 = 1;
        this.lineNumber = 1;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            char c11 = charArray[i11];
            if (c11 == '{') {
                break;
            }
            if (c11 == '\n') {
                this.lineNumber++;
            }
            i11++;
        }
        if (i11 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject cLObjectAllocate = CLObject.allocate(charArray);
        cLObjectAllocate.setLine(this.lineNumber);
        cLObjectAllocate.setStart(i11);
        int i12 = i11 + 1;
        CLElement container = cLObjectAllocate;
        while (i12 < length) {
            char c12 = charArray[i12];
            if (c12 == '\n') {
                this.lineNumber += i10;
            }
            if (this.hasComment) {
                if (c12 == '\n') {
                    this.hasComment = z11;
                    if (container == null) {
                        break;
                        break;
                    }
                    if (container.isDone()) {
                        container = getNextJsonElement(i12, c12, container, charArray);
                    } else if (container instanceof CLObject) {
                        if (c12 == '}') {
                            container.setEnd(i12 - 1);
                        } else {
                            container = getNextJsonElement(i12, c12, container, charArray);
                        }
                    } else if (container instanceof CLArray) {
                        z10 = container instanceof CLString;
                        if (z10) {
                            j12 = container.start;
                            if (charArray[(int) j12] == c12) {
                                container.setStart(j12 + 1);
                                container.setEnd(i12 - 1);
                            }
                        } else {
                            if (container instanceof CLToken) {
                                cLToken = (CLToken) container;
                                if (!cLToken.validate(c12, i12)) {
                                    throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.lineNumber, cLToken);
                                }
                            }
                            if (container instanceof CLKey) {
                                j10 = container.start;
                                c10 = charArray[(int) j10];
                                if (c10 != '\'') {
                                    container.setStart(j10 + 1);
                                    container.setEnd(i12 - 1);
                                } else {
                                    container.setStart(j10 + 1);
                                    container.setEnd(i12 - 1);
                                }
                            } else {
                                j10 = container.start;
                                c10 = charArray[(int) j10];
                                if (c10 != '\'') {
                                    container.setStart(j10 + 1);
                                    container.setEnd(i12 - 1);
                                } else {
                                    container.setStart(j10 + 1);
                                    container.setEnd(i12 - 1);
                                }
                            }
                            if (!container.isDone()) {
                                j11 = i12 - 1;
                                container.setEnd(j11);
                                if (c12 != '}') {
                                    container = container.getContainer();
                                    container.setEnd(j11);
                                    if (container instanceof CLKey) {
                                        container = container.getContainer();
                                        container.setEnd(j11);
                                    }
                                } else {
                                    container = container.getContainer();
                                    container.setEnd(j11);
                                    if (container instanceof CLKey) {
                                        container = container.getContainer();
                                        container.setEnd(j11);
                                    }
                                }
                            }
                        }
                    } else if (c12 == ']') {
                        container.setEnd(i12 - 1);
                    } else {
                        container = getNextJsonElement(i12, c12, container, charArray);
                    }
                    if (!container.isDone()) {
                    }
                } else {
                    continue;
                }
            } else {
                if (container == null) {
                    break;
                }
                if (container.isDone()) {
                    container = getNextJsonElement(i12, c12, container, charArray);
                } else if (container instanceof CLObject) {
                    if (c12 == '}') {
                        container.setEnd(i12 - 1);
                    } else {
                        container = getNextJsonElement(i12, c12, container, charArray);
                    }
                } else if (container instanceof CLArray) {
                    z10 = container instanceof CLString;
                    if (z10) {
                        j12 = container.start;
                        if (charArray[(int) j12] == c12) {
                            container.setStart(j12 + 1);
                            container.setEnd(i12 - 1);
                        }
                    } else {
                        if (container instanceof CLToken) {
                            cLToken = (CLToken) container;
                            if (!cLToken.validate(c12, i12)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.lineNumber, cLToken);
                            }
                        }
                        if ((container instanceof CLKey) || z10) {
                            j10 = container.start;
                            c10 = charArray[(int) j10];
                            if ((c10 != '\'' || c10 == '\"') && c10 == c12) {
                                container.setStart(j10 + 1);
                                container.setEnd(i12 - 1);
                            }
                        }
                        if (!container.isDone() && (c12 == '}' || c12 == ']' || c12 == ',' || c12 == ' ' || c12 == '\t' || c12 == '\r' || c12 == '\n' || c12 == ':')) {
                            j11 = i12 - 1;
                            container.setEnd(j11);
                            if (c12 != '}' || c12 == ']') {
                                container = container.getContainer();
                                container.setEnd(j11);
                                if (container instanceof CLKey) {
                                    container = container.getContainer();
                                    container.setEnd(j11);
                                }
                            }
                        }
                    }
                } else if (c12 == ']') {
                    container.setEnd(i12 - 1);
                } else {
                    container = getNextJsonElement(i12, c12, container, charArray);
                }
                if (!container.isDone() && (!(container instanceof CLKey) || ((CLKey) container).mElements.size() > 0)) {
                    container = container.getContainer();
                }
            }
            i12++;
            i10 = 1;
            z11 = false;
        }
        while (container != null && !container.isDone()) {
            if (container instanceof CLString) {
                container.setStart(((int) container.start) + 1);
            }
            container.setEnd(length - 1);
            container = container.getContainer();
        }
        if (DEBUG) {
            System.out.println("Root: " + cLObjectAllocate.toJSON());
        }
        return cLObjectAllocate;
    }
}
