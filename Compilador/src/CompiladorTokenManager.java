/* Generated By:JavaCC: Do not edit this line. CompiladorTokenManager.java */
import java.io.*;
import minhasclasses.*;

/** Token Manager. */
public class CompiladorTokenManager implements CompiladorConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 40:
         return jjStopAtPos(0, 19);
      case 41:
         return jjStopAtPos(0, 20);
      case 42:
         return jjStopAtPos(0, 22);
      case 43:
         return jjStopAtPos(0, 24);
      case 44:
         return jjStopAtPos(0, 51);
      case 45:
         return jjStopAtPos(0, 25);
      case 47:
         jjmatchedKind = 23;
         return jjMoveStringLiteralDfa1_0(0x120L);
      case 59:
         return jjStopAtPos(0, 50);
      case 60:
         jjmatchedKind = 27;
         return jjMoveStringLiteralDfa1_0(0x20000000L);
      case 61:
         jjmatchedKind = 14;
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 62:
         jjmatchedKind = 26;
         return jjMoveStringLiteralDfa1_0(0x10000000L);
      case 79:
         return jjMoveStringLiteralDfa1_0(0x800000000L);
      case 94:
         return jjStopAtPos(0, 21);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x800000000000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x20000000000L);
      case 101:
         jjmatchedKind = 32;
         return jjMoveStringLiteralDfa1_0(0x110000008000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x2288000000000L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x400020000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x40200000000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x1400000000000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x7000040000L);
      default :
         return jjMoveNfa_0(2, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      case 47:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(1, 8);
         break;
      case 61:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 28);
         else if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 29);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(1, 31);
         break;
      case 85:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(1, 35);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x1420400000000L);
      case 101:
         if ((active0 & 0x1000000000L) != 0L)
         {
            jjmatchedKind = 36;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x6000010000L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x2288000000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000000L);
      case 115:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000040000L);
      case 117:
         if ((active0 & 0x200000000L) != 0L)
         {
            jjmatchedKind = 33;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x40000020000L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L);
      case 101:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(2, 47);
         break;
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x18000L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x2288000020000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x6000000000L);
      case 111:
         if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(2, 34);
         break;
      case 113:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000040000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x1020000000000L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 69:
         return jjMoveStringLiteralDfa4_0(active0, 0x280000000000L);
      case 80:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000000000L);
      case 83:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000L);
      case 97:
         if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(3, 16);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(3, 46);
         return jjMoveStringLiteralDfa4_0(active0, 0x6000000000L);
      case 98:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000L);
      case 111:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStopAtPos(3, 41);
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000000L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x2100000000000L);
      case 101:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(4, 15);
         else if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(4, 39);
         break;
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000040000L);
      case 111:
         if ((active0 & 0x4000000000L) != 0L)
         {
            jjmatchedKind = 38;
            jjmatchedPos = 4;
         }
         else if ((active0 & 0x1000000000000L) != 0L)
            return jjStopAtPos(4, 48);
         return jjMoveStringLiteralDfa5_0(active0, 0x42000000000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
      case 115:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 83:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000000L);
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x80000000000L);
      case 103:
         if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(5, 18);
         break;
      case 104:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000000L);
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x100000000000L);
      case 111:
         if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(5, 17);
         break;
      case 113:
         return jjMoveStringLiteralDfa6_0(active0, 0x200000000000L);
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000000000L);
      case 115:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStopAtPos(5, 42);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStopAtPos(6, 40);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStopAtPos(6, 49);
         break;
      case 101:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStopAtPos(6, 37);
         break;
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x80000000000L);
      case 116:
         return jjMoveStringLiteralDfa7_0(active0, 0x100000000000L);
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x200000000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa8_0(active0, 0x200000000000L);
      case 108:
         return jjMoveStringLiteralDfa8_0(active0, 0x80000000000L);
      case 111:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStopAtPos(7, 44);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 104:
         return jjMoveStringLiteralDfa9_0(active0, 0x80000000000L);
      case 110:
         return jjMoveStringLiteralDfa9_0(active0, 0x200000000000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStopAtPos(9, 43);
         break;
      case 116:
         return jjMoveStringLiteralDfa10_0(active0, 0x200000000000L);
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static private int jjMoveStringLiteralDfa10_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(8, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0);
      return 10;
   }
   switch(curChar)
   {
      case 111:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(10, 45);
         break;
      default :
         break;
   }
   return jjStartNfa_0(9, active0);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 9;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(3, 4);
                  else if (curChar == 46)
                     jjCheckNAdd(1);
                  break;
               case 0:
                  if (curChar == 46)
                     jjCheckNAdd(1);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(1);
                  break;
               case 3:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(3, 4);
                  break;
               case 4:
                  if (curChar == 34 && kind > 12)
                     kind = 12;
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 8:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddStates(0, 2);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if (curChar == 95)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 3:
                  jjAddStates(3, 4);
                  break;
               case 6:
               case 7:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 13)
                     kind = 13;
                  jjCheckNAdd(7);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(3, 4);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 9 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static private int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 10:
         return jjStopAtPos(0, 9);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_1(0x40L);
      default :
         return 1;
   }
}
static private int jjMoveStringLiteralDfa1_1(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   0, 1, 8, 3, 4, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, "\75", "\145\170\151\142\145", "\154\145\151\141", "\156\165\155\145\162\157", 
"\163\164\162\151\156\147", "\50", "\51", "\136", "\52", "\57", "\53", "\55", "\76", "\74", "\76\75", 
"\74\75", "\41\75", "\75\75", "\145", "\157\165", "\156\141\157", "\117\125", 
"\163\145", "\163\145\156\141\157\123\145", "\163\145\156\141\157", 
"\146\151\155\123\145", "\145\163\143\157\154\150\141", "\143\141\163\157", 
"\157\165\164\162\157\163", "\146\151\155\105\163\143\157\154\150\141", 
"\145\156\161\165\141\156\164\157", "\146\151\155\105\156\161\165\141\156\164\157", "\160\141\162\141", 
"\141\164\145", "\160\141\163\163\157", "\146\151\155\120\141\162\141", "\73", "\54", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "comentarioCompleto",
   "comentarioLinha",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, 1, 0, -1, 2, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffffff801L, 
};
static final long[] jjtoSkip = {
   0x7feL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[9];
static private final int[] jjstateSet = new int[18];
static protected char curChar;
/** Constructor. */
public CompiladorTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public CompiladorTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 9; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   switch(curLexState)
   {
     case 0:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       break;
     case 1:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos == 0 && jjmatchedKind > 7)
       {
          jjmatchedKind = 7;
       }
       break;
     case 2:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_2();
       if (jjmatchedPos == 0 && jjmatchedKind > 10)
       {
          jjmatchedKind = 10;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
