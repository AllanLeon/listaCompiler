/**
 * generated by Xtext
 */
package edu.upb.compilacion.generator;

import edu.upb.compilacion.TypeInferrer;
import edu.upb.compilacion.listaCompiler.Bool;
import edu.upb.compilacion.listaCompiler.BracketExpression;
import edu.upb.compilacion.listaCompiler.CastedVariable;
import edu.upb.compilacion.listaCompiler.ComplexTerm;
import edu.upb.compilacion.listaCompiler.Evaluation;
import edu.upb.compilacion.listaCompiler.Expression;
import edu.upb.compilacion.listaCompiler.FirstLevelExp;
import edu.upb.compilacion.listaCompiler.FirstLevelOp;
import edu.upb.compilacion.listaCompiler.FourthLevelExp;
import edu.upb.compilacion.listaCompiler.FourthLevelOp;
import edu.upb.compilacion.listaCompiler.FunctionCall;
import edu.upb.compilacion.listaCompiler.FunctionDefinition;
import edu.upb.compilacion.listaCompiler.IfControlFlow;
import edu.upb.compilacion.listaCompiler.List;
import edu.upb.compilacion.listaCompiler.ListElem;
import edu.upb.compilacion.listaCompiler.Lista;
import edu.upb.compilacion.listaCompiler.MyBool;
import edu.upb.compilacion.listaCompiler.MyInteger;
import edu.upb.compilacion.listaCompiler.MyString;
import edu.upb.compilacion.listaCompiler.MyVariable;
import edu.upb.compilacion.listaCompiler.NegBool;
import edu.upb.compilacion.listaCompiler.NegInteger;
import edu.upb.compilacion.listaCompiler.PDFunction;
import edu.upb.compilacion.listaCompiler.PosBool;
import edu.upb.compilacion.listaCompiler.PosInteger;
import edu.upb.compilacion.listaCompiler.PreDefFunctionCall;
import edu.upb.compilacion.listaCompiler.SecondLevelExp;
import edu.upb.compilacion.listaCompiler.SecondLevelOp;
import edu.upb.compilacion.listaCompiler.SimpleTerm;
import edu.upb.compilacion.listaCompiler.Term;
import edu.upb.compilacion.listaCompiler.ThirdLevelExp;
import edu.upb.compilacion.listaCompiler.ThirdLevelOp;
import edu.upb.compilacion.listaCompiler.UserDefFunctionCall;
import edu.upb.compilacion.listaCompiler.Variable;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class ListaCompilerGenerator implements IGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    final Lista lista = ((Lista) _get);
    CharSequence _generateComplementaryFile = this.generateComplementaryFile();
    fsa.generateFile("SEKsComplements.java", _generateComplementaryFile);
    CharSequence _generate = this.generate(lista);
    fsa.generateFile("SEKs.java", _generate);
  }
  
  /**
   * Complementary file that contains predefined LISTA methods.
   */
  public CharSequence generateComplementaryFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class SEKsComplements {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatePreDefFunctions = this.generatePreDefFunctions();
    _builder.append(_generatePreDefFunctions, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder;
  }
  
  public CharSequence generate(final Lista lista) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class SEKs {");
    _builder.newLine();
    _builder.append("\t");
    EList<Evaluation> _evaluations = lista.getEvaluations();
    CharSequence _generateMain = this.generateMain(_evaluations);
    _builder.append(_generateMain, "\t");
    _builder.append("\n\n", "\t");
    {
      EList<FunctionDefinition> _definitions = lista.getDefinitions();
      boolean _hasElements = false;
      for(final FunctionDefinition fd : _definitions) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n\n", "\t");
        }
        CharSequence _generate = this.generate(fd);
        _builder.append(_generate, "\t");
      }
    }
    _builder.append("\n", "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder;
  }
  
  /**
   * All Evaluations are inside a main method.
   */
  public CharSequence generateMain(final EList<Evaluation> evaluations) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t");
    {
      boolean _hasElements = false;
      for(final Evaluation eval : evaluations) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "\t");
        }
        CharSequence _generate = this.generate(eval);
        _builder.append(_generate, "\t");
        _builder.append(";");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder;
  }
  
  public CharSequence generate(final Evaluation ev) {
    StringConcatenation _builder = new StringConcatenation();
    Expression _return = ev.getReturn();
    CharSequence _generate = this.generate(_return);
    _builder.append(_generate, "");
    return _builder;
  }
  
  public CharSequence generate(final Expression exp) {
    StringConcatenation _builder = new StringConcatenation();
    FirstLevelExp _exp = exp.getExp();
    Object _generate = this.generate(_exp);
    _builder.append(_generate, "");
    return _builder;
  }
  
  public Object generate(final FirstLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final SecondLevelExp first = ((SecondLevelExp) _get);
    Object res = this.generate(first);
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      FirstLevelOp _op = exp.getOp();
      String _literal = _op.getLiteral();
      String _plus = (res + _literal);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      Object _generate = this.generate(((FirstLevelExp) _get_1));
      String _plus_1 = (_plus + _generate);
      res = _plus_1;
    }
    return res;
  }
  
  public Object generate(final SecondLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final ThirdLevelExp first = ((ThirdLevelExp) _get);
    Object res = this.generate(first);
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      SecondLevelOp _op = exp.getOp();
      String _literal = _op.getLiteral();
      String _plus = (res + _literal);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      Object _generate = this.generate(((SecondLevelExp) _get_1));
      String _plus_1 = (_plus + _generate);
      res = _plus_1;
    }
    return res;
  }
  
  public Object generate(final ThirdLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final FourthLevelExp first = ((FourthLevelExp) _get);
    Object res = this.generate(first);
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      ThirdLevelOp _op = exp.getOp();
      String op = _op.getLiteral();
      ThirdLevelOp _op_1 = exp.getOp();
      boolean _equals = _op_1.equals(ThirdLevelOp.CONCAT);
      if (_equals) {
        op = "+";
      }
      String _plus = (res + op);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      Object _generate = this.generate(((ThirdLevelExp) _get_1));
      String _plus_1 = (_plus + _generate);
      res = _plus_1;
    }
    return res;
  }
  
  public Object generate(final FourthLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final Term first = ((Term) _get);
    Object res = this.generate(first);
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      FourthLevelOp _op = exp.getOp();
      String _literal = _op.getLiteral();
      String _plus = (res + _literal);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      Object _generate = this.generate(((FourthLevelExp) _get_1));
      String _plus_1 = (_plus + _generate);
      res = _plus_1;
    }
    return res;
  }
  
  public Object generate(final Term term) {
    if ((term instanceof SimpleTerm)) {
      return this.generate(((SimpleTerm) term));
    } else {
      if ((term instanceof ComplexTerm)) {
        return this.generate(((ComplexTerm) term));
      }
    }
    return null;
  }
  
  public Object generate(final SimpleTerm term) {
    if ((term instanceof MyInteger)) {
      return this.generate(((MyInteger) term));
    } else {
      if ((term instanceof MyString)) {
        String _generate = this.generate(((MyString) term));
        String _plus = ("\"" + _generate);
        return (_plus + "\"");
      } else {
        if ((term instanceof MyBool)) {
          return this.generate(((MyBool) term));
        } else {
          if ((term instanceof List)) {
            return this.generate(((List) term));
          } else {
            if ((term instanceof MyVariable)) {
              return ((Variable) term).getVar();
            }
          }
        }
      }
    }
    return null;
  }
  
  public Object generate(final ComplexTerm term) {
    if ((term instanceof FunctionCall)) {
      return this.generate(((FunctionCall) term));
    } else {
      if ((term instanceof IfControlFlow)) {
        return this.generate(((IfControlFlow) term));
      } else {
        if ((term instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) term).getExp();
          return this.generate(_exp);
        }
      }
    }
    return null;
  }
  
  public Object generate(final MyInteger mi) {
    if ((mi instanceof PosInteger)) {
      int _val = ((PosInteger) mi).getVal();
      return Integer.valueOf(_val).toString();
    } else {
      if ((mi instanceof NegInteger)) {
        final Term exp = ((NegInteger) mi).getVal();
        if ((exp instanceof PosInteger)) {
          int _val_1 = ((PosInteger) exp).getVal();
          return Integer.valueOf(_val_1).toString();
        } else {
          if ((exp instanceof ComplexTerm)) {
            return this.generate(((ComplexTerm) exp));
          }
        }
      }
    }
    return null;
  }
  
  public Object generate(final MyBool mb) {
    if ((mb instanceof PosBool)) {
      Bool _val = ((PosBool) mb).getVal();
      return _val.toString();
    } else {
      if ((mb instanceof NegBool)) {
        final Term exp = ((NegBool) mb).getVal();
        if ((exp instanceof PosBool)) {
          Bool _val_1 = ((PosBool) exp).getVal();
          return _val_1.toString();
        } else {
          if ((exp instanceof ComplexTerm)) {
            return this.generate(((ComplexTerm) exp));
          }
        }
      }
    }
    return null;
  }
  
  public CharSequence generate(final List li) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new int[]{");
    {
      EList<ListElem> _elems = li.getElems();
      boolean _hasElements = false;
      for(final ListElem elm : _elems) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        Object _generate = this.generate(elm);
        _builder.append(_generate, "");
      }
    }
    _builder.append("}");
    return _builder;
  }
  
  public String generate(final MyVariable mv) {
    if ((mv instanceof Variable)) {
      return ((Variable) mv).getVar();
    } else {
      if ((mv instanceof CastedVariable)) {
        return ((CastedVariable) mv).getVar();
      }
    }
    return null;
  }
  
  public Object generate(final ListElem le) {
    if ((le instanceof MyInteger)) {
      return this.generate(((MyInteger) le));
    } else {
      if ((le instanceof MyVariable)) {
        return this.generate(((MyVariable) le));
      }
    }
    return null;
  }
  
  public CharSequence generate(final FunctionCall fc) {
    if ((fc instanceof PreDefFunctionCall)) {
      return this.generate(((PreDefFunctionCall) fc));
    } else {
      if ((fc instanceof UserDefFunctionCall)) {
        return this.generate(((UserDefFunctionCall) fc));
      }
    }
    return null;
  }
  
  /**
   * The predefined LISTA functions are static inside a SEKsComplements class. They are called
   * in a static form.
   */
  public CharSequence generate(final PreDefFunctionCall pdf) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("SEKsComplements.");
    PDFunction _function = pdf.getFunction();
    String _name = _function.getName();
    _builder.append(_name, "");
    _builder.append("(");
    {
      EList<Expression> _args = pdf.getArgs();
      boolean _hasElements = false;
      for(final Expression exp : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        Object _generate = this.generate(exp);
        _builder.append(_generate, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  /**
   * The predefined LISTA functions are static inside the generated SEKs class. They are called
   * in a static form.
   */
  public CharSequence generate(final UserDefFunctionCall udf) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("SEKs.");
    FunctionDefinition _function = udf.getFunction();
    String _name = _function.getName();
    _builder.append(_name, "");
    _builder.append("(");
    {
      EList<Expression> _args = udf.getArgs();
      boolean _hasElements = false;
      for(final Expression exp : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        Object _generate = this.generate(exp);
        _builder.append(_generate, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  /**
   * Short notation for if.
   */
  public CharSequence generate(final IfControlFlow icf) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    Expression _cond = icf.getCond();
    Object _generate = this.generate(_cond);
    _builder.append(_generate, "");
    _builder.append(") ? (");
    Expression _iftrue = icf.getIftrue();
    Object _generate_1 = this.generate(_iftrue);
    _builder.append(_generate_1, "");
    _builder.append(") : (");
    Expression _iffalse = icf.getIffalse();
    Object _generate_2 = this.generate(_iffalse);
    _builder.append(_generate_2, "");
    _builder.append("))");
    return _builder;
  }
  
  public String generate(final BracketExpression be) {
    Expression _exp = be.getExp();
    CharSequence _generate = this.generate(_exp);
    String _plus = ("(" + _generate);
    return (_plus + ")");
  }
  
  /**
   * Prints escape \n caracter.
   */
  public String generate(final MyString myStr) {
    String _val = myStr.getVal();
    return _val.replaceAll("\n", "\\\\n");
  }
  
  /**
   * Each user defined function is declared as a static function so it can be used on the
   * rest of the functions and the Evaluations.
   */
  public CharSequence generate(final FunctionDefinition funcd) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public static ");
    HashMap<String, TypeInferrer.DataType> _functionTypes = TypeInferrer.getFunctionTypes();
    String _name = funcd.getName();
    TypeInferrer.DataType _get = _functionTypes.get(_name);
    String _convertDTtoString = this.convertDTtoString(_get);
    _builder.append(_convertDTtoString, "");
    _builder.append(" ");
    String _name_1 = funcd.getName();
    _builder.append(_name_1, "");
    _builder.append("(");
    {
      EList<MyVariable> _params = funcd.getParams();
      boolean _hasElements = false;
      for(final MyVariable fp : _params) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        HashMap<String, HashMap<String, TypeInferrer.DataType>> _functionParams = TypeInferrer.getFunctionParams();
        String _name_2 = funcd.getName();
        HashMap<String, TypeInferrer.DataType> _get_1 = _functionParams.get(_name_2);
        String _generate = this.generate(fp);
        TypeInferrer.DataType _get_2 = _get_1.get(_generate);
        String _convertDTtoString_1 = this.convertDTtoString(_get_2);
        String _plus = (_convertDTtoString_1 + " ");
        String _generate_1 = this.generate(fp);
        String _plus_1 = (_plus + _generate_1);
        _builder.append(_plus_1, "");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      HashMap<String, TypeInferrer.DataType> _functionTypes_1 = TypeInferrer.getFunctionTypes();
      String _name_3 = funcd.getName();
      TypeInferrer.DataType _get_3 = _functionTypes_1.get(_name_3);
      boolean _equals = _get_3.equals(TypeInferrer.DataType.VOID);
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("return ", "\t");
      }
    }
    Expression _return = funcd.getReturn();
    FirstLevelExp _exp = _return.getExp();
    Object _generate_2 = this.generate(_exp);
    _builder.append(_generate_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder;
  }
  
  /**
   * Converts a DataType to it's java equivalent.
   */
  public String convertDTtoString(final TypeInferrer.DataType dt) {
    if (dt != null) {
      switch (dt) {
        case BOOL:
          return "boolean";
        case INT:
          String _name = dt.name();
          return _name.toLowerCase();
        case STRING:
          String _name_1 = dt.name();
          String _lowerCase = _name_1.toLowerCase();
          return StringExtensions.toFirstUpper(_lowerCase);
        case LIST:
          return "int[]";
        case VOID:
          return "void";
        default:
          return "int";
      }
    } else {
      return "int";
    }
  }
  
  /**
   * Complementary methods for predefined LISTA functions.
   */
  public CharSequence generatePreDefFunctions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public static int[] cons(int x, int[] l) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("int[] res = new int[l.length + 1];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("res[0] = x;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (int i = 1; i < l.length + 1; i++) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("res[i] = l[i - 1];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return res;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public static int car(int[] l) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return l[0];");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public static int[] cdr(int[] l) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("int[] res = new int[l.length - 1];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (int i = 1; i < l.length ; i++) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("res[i - 1] = l[i];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return res;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public static boolean isEmpty(int[] l) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return (l.length > 0) ? false : true;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public static int length(String s) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return s.length();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public static void show(int x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(x);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public static void show(String x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(x);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public static void show(boolean x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(x);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public static void show(int[] x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.print(\"[\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (int i = 0; i < x.length; i++) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (i > 0) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("System.out.print(\",\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.print(x[i]);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(\"]\");");
    _builder.newLine();
    _builder.append("}");
    return _builder;
  }
}
