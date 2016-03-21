package edu.upb.compilacion;

import edu.upb.compilacion.HugeException;
import edu.upb.compilacion.MismatchedTypeException;
import edu.upb.compilacion.listaCompiler.BracketExpression;
import edu.upb.compilacion.listaCompiler.CastedType;
import edu.upb.compilacion.listaCompiler.CastedVariable;
import edu.upb.compilacion.listaCompiler.ComplexTerm;
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
import edu.upb.compilacion.listaCompiler.MyBool;
import edu.upb.compilacion.listaCompiler.MyInteger;
import edu.upb.compilacion.listaCompiler.MyString;
import edu.upb.compilacion.listaCompiler.MyVariable;
import edu.upb.compilacion.listaCompiler.NegBool;
import edu.upb.compilacion.listaCompiler.NegInteger;
import edu.upb.compilacion.listaCompiler.PDFunction;
import edu.upb.compilacion.listaCompiler.PreDefFunctionCall;
import edu.upb.compilacion.listaCompiler.SecondLevelExp;
import edu.upb.compilacion.listaCompiler.SecondLevelOp;
import edu.upb.compilacion.listaCompiler.SimpleTerm;
import edu.upb.compilacion.listaCompiler.Term;
import edu.upb.compilacion.listaCompiler.ThirdLevelExp;
import edu.upb.compilacion.listaCompiler.ThirdLevelOp;
import edu.upb.compilacion.listaCompiler.UserDefFunctionCall;
import edu.upb.compilacion.listaCompiler.Variable;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TypeInferrer {
  /**
   * DataTypes that a expression could have.
   */
  public enum DataType {
    INT,
    
    STRING,
    
    BOOL,
    
    LIST,
    
    VOID,
    
    VAR,
    
    GLOBAL;
  }
  
  /**
   * Represents the symbols table.
   */
  private static HashMap<String, HashMap<String, TypeInferrer.DataType>> functionParams = new HashMap<String, HashMap<String, TypeInferrer.DataType>>();
  
  private static HashMap<String, TypeInferrer.DataType> functionTypes = new HashMap<String, TypeInferrer.DataType>();
  
  private static String currentFunction = "";
  
  /**
   * Resets the currentFunction string so the next check doesn't try to get another function
   * type.
   */
  public static String resetCurrentFunction() {
    return TypeInferrer.currentFunction = "";
  }
  
  /**
   * Cleans the symbols table info of a function.
   */
  public static TypeInferrer.DataType removeFunctionInfo(final FunctionDefinition fd) {
    TypeInferrer.DataType _xblockexpression = null;
    {
      String _name = fd.getName();
      TypeInferrer.functionParams.remove(_name);
      String _name_1 = fd.getName();
      _xblockexpression = TypeInferrer.functionTypes.remove(_name_1);
    }
    return _xblockexpression;
  }
  
  /**
   * Infers the data type of a function and it's parameters if any.
   */
  public static void inferDataType(final FunctionDefinition fd) {
    String _name = fd.getName();
    TypeInferrer.currentFunction = _name;
    String _name_1 = fd.getName();
    HashMap<String, TypeInferrer.DataType> _hashMap = new HashMap<String, TypeInferrer.DataType>();
    TypeInferrer.functionParams.put(_name_1, _hashMap);
    TypeInferrer.searchCastedVariables(fd);
    Expression _return = fd.getReturn();
    FirstLevelExp _exp = _return.getExp();
    String _name_2 = fd.getName();
    TypeInferrer.inferDataType(_exp, _name_2);
  }
  
  /**
   * Automatically sets the type if a variable is casted.
   */
  public static void searchCastedVariables(final FunctionDefinition fd) {
    EList<MyVariable> _params = fd.getParams();
    for (final MyVariable mvar : _params) {
      if ((mvar instanceof CastedVariable)) {
        final CastedVariable cvar = ((CastedVariable) mvar);
        String _name = fd.getName();
        HashMap<String, TypeInferrer.DataType> _get = TypeInferrer.functionParams.get(_name);
        String _var = cvar.getVar();
        CastedType _type = cvar.getType();
        TypeInferrer.DataType _dataTypeFromCast = TypeInferrer.getDataTypeFromCast(_type);
        _get.put(_var, _dataTypeFromCast);
      }
    }
  }
  
  /**
   * Infers the type of a FirstLevelExp and then infers the type of both sides of it, the
   * variables types are inferred based on the operator. The types are saved on the current
   * function table.
   */
  public static void inferDataType(final FirstLevelExp exp, final String fdName) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final SecondLevelExp first = ((SecondLevelExp) _get);
    final TypeInferrer.DataType firstType = TypeInferrer.getDataType(first);
    final FirstLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case AND:
          case OR:
            expected = TypeInferrer.DataType.BOOL;
            break;
          default:
            expected = TypeInferrer.DataType.GLOBAL;
            break;
        }
      } else {
        expected = TypeInferrer.DataType.GLOBAL;
      }
      TypeInferrer.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final FirstLevelExp second = ((FirstLevelExp) _get_1);
      final TypeInferrer.DataType secondType = TypeInferrer.getDataType(second);
      boolean _equals = firstType.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        final String var1 = TypeInferrer.getVariable(first);
        HashMap<String, TypeInferrer.DataType> _get_2 = TypeInferrer.functionParams.get(fdName);
        _get_2.put(var1, expected);
      } else {
        TypeInferrer.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(TypeInferrer.DataType.VAR);
      if (_equals_1) {
        final String var2 = TypeInferrer.getVariable(second);
        HashMap<String, TypeInferrer.DataType> _get_3 = TypeInferrer.functionParams.get(fdName);
        _get_3.put(var2, expected);
      } else {
        TypeInferrer.inferDataType(second, fdName);
      }
    } else {
      TypeInferrer.inferDataType(first, fdName);
    }
  }
  
  /**
   * Infers the type of a SecondLevelExp and then infers the type of both sides of it, the
   * variables types are inferred based on the operator. The types are saved on the current
   * function table.
   */
  public static void inferDataType(final SecondLevelExp exp, final String fdName) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final ThirdLevelExp first = ((ThirdLevelExp) _get);
    final TypeInferrer.DataType firstType = TypeInferrer.getDataType(first);
    final SecondLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case GT:
          case LT:
            expected = TypeInferrer.DataType.INT;
            break;
          case EQ:
            expected = TypeInferrer.DataType.BOOL;
            break;
          default:
            expected = TypeInferrer.DataType.GLOBAL;
            break;
        }
      } else {
        expected = TypeInferrer.DataType.GLOBAL;
      }
      TypeInferrer.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final SecondLevelExp second = ((SecondLevelExp) _get_1);
      final TypeInferrer.DataType secondType = TypeInferrer.getDataType(second);
      boolean _equals = firstType.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        final String var1 = TypeInferrer.getVariable(first);
        HashMap<String, TypeInferrer.DataType> _get_2 = TypeInferrer.functionParams.get(fdName);
        _get_2.put(var1, expected);
      } else {
        TypeInferrer.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(TypeInferrer.DataType.VAR);
      if (_equals_1) {
        final String var2 = TypeInferrer.getVariable(second);
        HashMap<String, TypeInferrer.DataType> _get_3 = TypeInferrer.functionParams.get(fdName);
        _get_3.put(var2, expected);
      } else {
        TypeInferrer.inferDataType(second, fdName);
      }
    } else {
      TypeInferrer.inferDataType(first, fdName);
    }
  }
  
  /**
   * Infers the type of a ThirdLevelExp and then infers the type of both sides of it, the
   * variables types are inferred based on the operator. The types are saved on the current
   * function table.
   */
  public static void inferDataType(final ThirdLevelExp exp, final String fdName) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final FourthLevelExp first = ((FourthLevelExp) _get);
    final TypeInferrer.DataType firstType = TypeInferrer.getDataType(first);
    final ThirdLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case PLUS:
          case MINUS:
            expected = TypeInferrer.DataType.INT;
            break;
          case CONCAT:
            expected = TypeInferrer.DataType.STRING;
            break;
          default:
            expected = TypeInferrer.DataType.GLOBAL;
            break;
        }
      } else {
        expected = TypeInferrer.DataType.GLOBAL;
      }
      TypeInferrer.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final ThirdLevelExp second = ((ThirdLevelExp) _get_1);
      final TypeInferrer.DataType secondType = TypeInferrer.getDataType(second);
      boolean _equals = firstType.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        final String var1 = TypeInferrer.getVariable(first);
        HashMap<String, TypeInferrer.DataType> _get_2 = TypeInferrer.functionParams.get(fdName);
        _get_2.put(var1, expected);
      } else {
        TypeInferrer.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(TypeInferrer.DataType.VAR);
      if (_equals_1) {
        final String var2 = TypeInferrer.getVariable(second);
        HashMap<String, TypeInferrer.DataType> _get_3 = TypeInferrer.functionParams.get(fdName);
        _get_3.put(var2, expected);
      } else {
        TypeInferrer.inferDataType(second, fdName);
      }
    } else {
      TypeInferrer.inferDataType(first, fdName);
    }
  }
  
  /**
   * Infers the type of a FourthLevelExp and then infers the type of both sides of it, the
   * variables types are inferred based on the operator. The types are saved on the current
   * function table.
   */
  public static void inferDataType(final FourthLevelExp exp, final String fdName) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final Term first = ((Term) _get);
    final TypeInferrer.DataType firstType = TypeInferrer.getDataType(first);
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      TypeInferrer.DataType expected = TypeInferrer.DataType.INT;
      TypeInferrer.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final FourthLevelExp second = ((FourthLevelExp) _get_1);
      final TypeInferrer.DataType secondType = TypeInferrer.getDataType(second);
      boolean _equals = firstType.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        final String var1 = TypeInferrer.getVariable(first);
        HashMap<String, TypeInferrer.DataType> _get_2 = TypeInferrer.functionParams.get(fdName);
        _get_2.put(var1, expected);
      } else {
        TypeInferrer.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(TypeInferrer.DataType.VAR);
      if (_equals_1) {
        final String var2 = TypeInferrer.getVariable(second);
        HashMap<String, TypeInferrer.DataType> _get_3 = TypeInferrer.functionParams.get(fdName);
        _get_3.put(var2, expected);
      } else {
        TypeInferrer.inferDataType(second, fdName);
      }
    } else {
      TypeInferrer.inferDataType(first, fdName);
    }
  }
  
  /**
   * Infers the type of a Term.
   */
  public static void inferDataType(final Term term, final String fdName) {
    if ((term instanceof SimpleTerm)) {
      TypeInferrer.inferDataType(((SimpleTerm) term), fdName);
    } else {
      if ((term instanceof ComplexTerm)) {
        TypeInferrer.inferDataType(((ComplexTerm) term), fdName);
      }
    }
  }
  
  /**
   * Infers the type of a SimpleTerm, based of the instance of it.
   */
  public static void inferDataType(final SimpleTerm term, final String fdName) {
    if ((term instanceof MyInteger)) {
      TypeInferrer.inferDataType(((MyInteger) term), fdName);
    } else {
      if ((term instanceof MyString)) {
        TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.STRING);
      } else {
        if ((term instanceof MyBool)) {
          TypeInferrer.inferDataType(((MyBool) term), fdName);
        } else {
          if ((term instanceof List)) {
            TypeInferrer.inferDataType(((List) term), fdName);
          } else {
            if ((term instanceof Variable)) {
              TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.VAR);
            }
          }
        }
      }
    }
  }
  
  /**
   * Infers the type of a list and it's elements. Saves the variables types in the current
   * function table.
   */
  public static void inferDataType(final List li, final String fdName) {
    EList<ListElem> _elems = li.getElems();
    for (final ListElem el : _elems) {
      if ((el instanceof Variable)) {
        HashMap<String, TypeInferrer.DataType> _get = TypeInferrer.functionParams.get(fdName);
        String _var = ((Variable) el).getVar();
        _get.put(_var, TypeInferrer.DataType.INT);
      }
    }
    TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.LIST);
  }
  
  /**
   * Infers the type of a ComplexTerm, based of the instance of it.
   */
  public static void inferDataType(final ComplexTerm term, final String fdName) {
    if ((term instanceof FunctionCall)) {
      TypeInferrer.inferDataType(((FunctionCall) term), fdName);
    } else {
      if ((term instanceof IfControlFlow)) {
        Expression _iftrue = ((IfControlFlow) term).getIftrue();
        FirstLevelExp _exp = _iftrue.getExp();
        TypeInferrer.inferDataType(_exp, fdName);
        Expression _iffalse = ((IfControlFlow) term).getIffalse();
        FirstLevelExp _exp_1 = _iffalse.getExp();
        TypeInferrer.inferDataType(_exp_1, fdName);
        Expression _cond = ((IfControlFlow) term).getCond();
        FirstLevelExp _exp_2 = _cond.getExp();
        TypeInferrer.inferDataType(_exp_2, fdName);
      } else {
        if ((term instanceof BracketExpression)) {
          Expression _exp_3 = ((BracketExpression) term).getExp();
          FirstLevelExp _exp_4 = _exp_3.getExp();
          TypeInferrer.inferDataType(_exp_4, fdName);
        }
      }
    }
  }
  
  /**
   * Infers the type of a MyInteger, if it's a negation of a ComplexTerm, it's type is
   * inferred as well.
   */
  public static void inferDataType(final MyInteger myInt, final String fdName) {
    TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.INT);
    if ((myInt instanceof NegInteger)) {
      final Term exp = ((NegInteger) myInt).getVal();
      if ((exp instanceof ComplexTerm)) {
        TypeInferrer.inferDataType(((ComplexTerm) exp), fdName);
      }
    }
  }
  
  /**
   * Infers the type of a MyBool, if it's a negation of a ComplexTerm, it's type is
   * inferred as well.
   */
  public static void inferDataType(final MyBool myBool, final String fdName) {
    TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.BOOL);
    if ((myBool instanceof NegBool)) {
      final Term exp = ((NegBool) myBool).getVal();
      if ((exp instanceof ComplexTerm)) {
        TypeInferrer.inferDataType(((ComplexTerm) exp), fdName);
      }
    }
  }
  
  /**
   * Infers the type of a function call.
   */
  public static void inferDataType(final FunctionCall fcall, final String fdName) {
    if ((fcall instanceof PreDefFunctionCall)) {
      TypeInferrer.inferDataType(((PreDefFunctionCall) fcall), fdName);
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        TypeInferrer.inferDataType(((UserDefFunctionCall) fcall), fdName);
      }
    }
  }
  
  /**
   * If an Expression calls a predefined function, it gains it's type.
   */
  public static void inferDataType(final PreDefFunctionCall fcall, final String fdName) {
    PDFunction _function = fcall.getFunction();
    if (_function != null) {
      switch (_function) {
        case SHOW:
          TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.VOID);
          break;
        case LENGTH:
        case CAR:
          TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.INT);
          break;
        case CDR:
        case CONS:
          TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.LIST);
          break;
        case IS_EMPTY:
          TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.BOOL);
          break;
        default:
          break;
      }
    }
    EList<Expression> _args = fcall.getArgs();
    for (final Expression exp : _args) {
      FirstLevelExp _exp = exp.getExp();
      TypeInferrer.inferDataType(_exp, fdName);
    }
    TypeInferrer.inferPDFArgsDataType(fcall, fdName);
  }
  
  /**
   * Infers the arguments types of a predefined function.
   */
  public static void inferPDFArgsDataType(final PreDefFunctionCall fcall, final String fdName) {
    ArrayList<TypeInferrer.DataType> paramsTypes = new ArrayList<TypeInferrer.DataType>();
    PDFunction _function = fcall.getFunction();
    if (_function != null) {
      switch (_function) {
        case SHOW:
          paramsTypes.add(TypeInferrer.DataType.GLOBAL);
          break;
        case LENGTH:
          paramsTypes.add(TypeInferrer.DataType.STRING);
          break;
        case CAR:
          paramsTypes.add(TypeInferrer.DataType.LIST);
          break;
        case CDR:
          paramsTypes.add(TypeInferrer.DataType.LIST);
          break;
        case CONS:
          paramsTypes.add(TypeInferrer.DataType.INT);
          paramsTypes.add(TypeInferrer.DataType.LIST);
          break;
        case IS_EMPTY:
          paramsTypes.add(TypeInferrer.DataType.LIST);
          break;
        default:
          break;
      }
    }
    int i = 0;
    EList<Expression> _args = fcall.getArgs();
    for (final Expression exp : _args) {
      {
        int _size = paramsTypes.size();
        boolean _greaterEqualsThan = (i >= _size);
        if (_greaterEqualsThan) {
          return;
        }
        TypeInferrer.DataType _get = paramsTypes.get(i);
        boolean _equals = _get.equals(TypeInferrer.DataType.GLOBAL);
        boolean _not = (!_equals);
        if (_not) {
          TypeInferrer.DataType _dataType = TypeInferrer.getDataType(exp);
          boolean _equals_1 = _dataType.equals(TypeInferrer.DataType.VAR);
          if (_equals_1) {
            HashMap<String, TypeInferrer.DataType> _get_1 = TypeInferrer.functionParams.get(fdName);
            FirstLevelExp _exp = exp.getExp();
            String _variable = TypeInferrer.getVariable(_exp);
            TypeInferrer.DataType _get_2 = paramsTypes.get(i);
            _get_1.put(_variable, _get_2);
          }
        }
        i++;
      }
    }
  }
  
  /**
   * Infers the arguments types of an user defined function.
   */
  public static void inferUDFArgsDataType(final UserDefFunctionCall fcall, final String fdName) {
    FunctionDefinition _function = fcall.getFunction();
    String _name = _function.getName();
    boolean _containsKey = TypeInferrer.functionTypes.containsKey(_name);
    if (_containsKey) {
      final EList<Expression> args = fcall.getArgs();
      FunctionDefinition _function_1 = fcall.getFunction();
      String _name_1 = _function_1.getName();
      final HashMap<String, TypeInferrer.DataType> params = TypeInferrer.functionParams.get(_name_1);
      int i = 0;
      FunctionDefinition _function_2 = fcall.getFunction();
      EList<MyVariable> _params = _function_2.getParams();
      for (final MyVariable current : _params) {
        {
          int _size = args.size();
          boolean _greaterEqualsThan = (i >= _size);
          if (_greaterEqualsThan) {
            return;
          }
          String _variable = TypeInferrer.getVariable(current);
          boolean _containsKey_1 = params.containsKey(_variable);
          if (_containsKey_1) {
            Expression _get = args.get(i);
            TypeInferrer.DataType _dataType = TypeInferrer.getDataType(_get);
            boolean _equals = _dataType.equals(TypeInferrer.DataType.VAR);
            if (_equals) {
              HashMap<String, TypeInferrer.DataType> _get_1 = TypeInferrer.functionParams.get(fdName);
              Expression _get_2 = args.get(i);
              FirstLevelExp _exp = _get_2.getExp();
              String _variable_1 = TypeInferrer.getVariable(_exp);
              String _variable_2 = TypeInferrer.getVariable(current);
              TypeInferrer.DataType _get_3 = params.get(_variable_2);
              _get_1.put(_variable_1, _get_3);
            }
          }
          i++;
        }
      }
    }
  }
  
  /**
   * If an Expression calls an user defined function, it gains it's type.
   */
  public static void inferDataType(final UserDefFunctionCall fcall, final String fdName) {
    FunctionDefinition _function = fcall.getFunction();
    String _name = _function.getName();
    boolean _containsKey = TypeInferrer.functionTypes.containsKey(_name);
    if (_containsKey) {
      FunctionDefinition _function_1 = fcall.getFunction();
      String _name_1 = _function_1.getName();
      TypeInferrer.DataType _get = TypeInferrer.functionTypes.get(_name_1);
      TypeInferrer.setFunctionType(fdName, _get);
    } else {
      TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.VAR);
    }
    EList<Expression> _args = fcall.getArgs();
    for (final Expression exp : _args) {
      FirstLevelExp _exp = exp.getExp();
      TypeInferrer.inferDataType(_exp, fdName);
    }
    TypeInferrer.inferUDFArgsDataType(fcall, fdName);
  }
  
  /**
   * Returns the DataType of an Expression
   */
  public static TypeInferrer.DataType getDataType(final Expression exp) {
    FirstLevelExp _exp = exp.getExp();
    return TypeInferrer.getDataType(_exp);
  }
  
  /**
   * Returns the DataType of a FirstLevelExp, based on it's operator or on it't left side.
   */
  public static TypeInferrer.DataType getDataType(final FirstLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final TypeInferrer.DataType first = TypeInferrer.getDataType(((SecondLevelExp) _get));
    final FirstLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case AND:
          case OR:
            expected = TypeInferrer.DataType.BOOL;
            break;
          default:
            expected = TypeInferrer.DataType.GLOBAL;
            break;
        }
      } else {
        expected = TypeInferrer.DataType.GLOBAL;
      }
      return expected;
    } else {
      return first;
    }
  }
  
  /**
   * Returns the DataType of a SecondLevelExp, based on it's operator or on it't left side.
   */
  public static TypeInferrer.DataType getDataType(final SecondLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final TypeInferrer.DataType first = TypeInferrer.getDataType(((ThirdLevelExp) _get));
    final SecondLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case GT:
          case LT:
          case EQ:
            expected = TypeInferrer.DataType.BOOL;
            break;
          default:
            expected = TypeInferrer.DataType.GLOBAL;
            break;
        }
      } else {
        expected = TypeInferrer.DataType.GLOBAL;
      }
      return expected;
    } else {
      return first;
    }
  }
  
  /**
   * Returns the DataType of a ThirdLevelExp, based on it's operator or on it't left side.
   */
  public static TypeInferrer.DataType getDataType(final ThirdLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final TypeInferrer.DataType first = TypeInferrer.getDataType(((FourthLevelExp) _get));
    final ThirdLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case PLUS:
          case MINUS:
            expected = TypeInferrer.DataType.INT;
            break;
          case CONCAT:
            expected = TypeInferrer.DataType.STRING;
            break;
          default:
            expected = TypeInferrer.DataType.GLOBAL;
            break;
        }
      } else {
        expected = TypeInferrer.DataType.GLOBAL;
      }
      return expected;
    } else {
      return first;
    }
  }
  
  /**
   * Returns the DataType of a FourthLevelExp, based on it's operator or on it't left side.
   */
  public static TypeInferrer.DataType getDataType(final FourthLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final TypeInferrer.DataType first = TypeInferrer.getDataType(((Term) _get));
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      return TypeInferrer.DataType.INT;
    } else {
      return first;
    }
  }
  
  /**
   * Returns the DataType of a Term.
   */
  public static TypeInferrer.DataType getDataType(final Term term) {
    if ((term instanceof SimpleTerm)) {
      return TypeInferrer.getDataType(((SimpleTerm) term));
    } else {
      if ((term instanceof ComplexTerm)) {
        return TypeInferrer.getDataType(((ComplexTerm) term));
      }
    }
    return null;
  }
  
  /**
   * Returns the DataType of a SimpleTerm based on it's instance.
   */
  public static TypeInferrer.DataType getDataType(final SimpleTerm term) {
    if ((term instanceof MyInteger)) {
      return TypeInferrer.DataType.INT;
    } else {
      if ((term instanceof MyString)) {
        return TypeInferrer.DataType.STRING;
      } else {
        if ((term instanceof MyBool)) {
          return TypeInferrer.DataType.BOOL;
        } else {
          if ((term instanceof List)) {
            return TypeInferrer.DataType.LIST;
          } else {
            if ((term instanceof Variable)) {
              return TypeInferrer.getDataType(((Variable) term));
            }
          }
        }
      }
    }
    return null;
  }
  
  /**
   * Returns the DataType of a ComplexTerm based on it's instance.
   */
  public static TypeInferrer.DataType getDataType(final ComplexTerm term) {
    if ((term instanceof FunctionCall)) {
      return TypeInferrer.getDataType(((FunctionCall) term));
    } else {
      if ((term instanceof IfControlFlow)) {
        return TypeInferrer.getDataType(((IfControlFlow) term));
      } else {
        if ((term instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) term).getExp();
          return TypeInferrer.getDataType(_exp);
        }
      }
    }
    return null;
  }
  
  /**
   * Returns the DataType of a variable if it has been already inferred.
   */
  public static TypeInferrer.DataType getDataType(final Variable variable) {
    boolean _equals = TypeInferrer.currentFunction.equals("");
    boolean _not = (!_equals);
    if (_not) {
      HashMap<String, TypeInferrer.DataType> _get = TypeInferrer.functionParams.get(TypeInferrer.currentFunction);
      String _var = variable.getVar();
      boolean _containsKey = _get.containsKey(_var);
      if (_containsKey) {
        HashMap<String, TypeInferrer.DataType> _get_1 = TypeInferrer.functionParams.get(TypeInferrer.currentFunction);
        String _var_1 = variable.getVar();
        return _get_1.get(_var_1);
      }
    }
    return TypeInferrer.DataType.VAR;
  }
  
  /**
   * Returns the DataType of a function call.
   */
  public static TypeInferrer.DataType getDataType(final FunctionCall fcall) {
    if ((fcall instanceof PreDefFunctionCall)) {
      return TypeInferrer.getDataType(((PreDefFunctionCall) fcall));
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        return TypeInferrer.getDataType(((UserDefFunctionCall) fcall));
      }
    }
    return null;
  }
  
  /**
   * Returns the DataType of a predefined function call.
   */
  public static TypeInferrer.DataType getDataType(final PreDefFunctionCall fcall) {
    PDFunction _function = fcall.getFunction();
    if (_function != null) {
      switch (_function) {
        case SHOW:
          return TypeInferrer.DataType.VOID;
        case LENGTH:
        case CAR:
          return TypeInferrer.DataType.INT;
        case CDR:
        case CONS:
          return TypeInferrer.DataType.LIST;
        case IS_EMPTY:
          return TypeInferrer.DataType.BOOL;
        default:
          break;
      }
    }
    return null;
  }
  
  /**
   * Returns the DataType of an user defined function call.
   */
  public static TypeInferrer.DataType getDataType(final UserDefFunctionCall fcall) {
    FunctionDefinition _function = fcall.getFunction();
    String _name = _function.getName();
    boolean _containsKey = TypeInferrer.functionTypes.containsKey(_name);
    if (_containsKey) {
      FunctionDefinition _function_1 = fcall.getFunction();
      String _name_1 = _function_1.getName();
      return TypeInferrer.functionTypes.get(_name_1);
    } else {
      FunctionDefinition _function_2 = fcall.getFunction();
      Expression _return = _function_2.getReturn();
      return TypeInferrer.getDataType(_return);
    }
  }
  
  /**
   * Returns the DataType of an IfControlFlow.
   */
  public static TypeInferrer.DataType getDataType(final IfControlFlow ifCF) {
    Expression _iftrue = ifCF.getIftrue();
    return TypeInferrer.getDataType(_iftrue);
  }
  
  /**
   * Checks and returns the DataType of a Expression.
   */
  public static TypeInferrer.DataType checkDataType(final Expression exp) {
    FirstLevelExp _exp = exp.getExp();
    return TypeInferrer.checkDataType(_exp);
  }
  
  /**
   * Checks and returns the DataType of a FirstLevelExp.
   * Verifies that both sides of the expression have the type that it's operator accepts.
   */
  public static TypeInferrer.DataType checkDataType(final FirstLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = TypeInferrer.checkDataType(((SecondLevelExp) _get));
      final FirstLevelOp op = exp.getOp();
      EList<EObject> _args_1 = exp.getArgs();
      int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
        if (op != null) {
          switch (op) {
            case AND:
            case OR:
              expected = TypeInferrer.DataType.BOOL;
              break;
            default:
              expected = TypeInferrer.DataType.GLOBAL;
              break;
          }
        } else {
          expected = TypeInferrer.DataType.GLOBAL;
        }
        boolean _and = false;
        boolean _equals = first.equals(expected);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          TypeInferrer.DataType _checkDataType = TypeInferrer.checkDataType(((FirstLevelExp) _get_1));
          boolean _equals_1 = _checkDataType.equals(expected);
          _and = _equals_1;
        }
        if (_and) {
          return expected;
        } else {
          String _literal = op.getLiteral();
          String _plus = ("Mismatched data types for operator " + _literal);
          String _plus_1 = (_plus + ", arguments should be ");
          String _string = expected.toString();
          String _plus_2 = (_plus_1 + _string);
          String _plus_3 = (_plus_2 + ".");
          throw new MismatchedTypeException(_plus_3);
        }
      } else {
        return first;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the DataType of a SecondLevelExp.
   * Verifies that both sides of the expression have the type that it's operator accepts.
   */
  public static TypeInferrer.DataType checkDataType(final SecondLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = TypeInferrer.checkDataType(((ThirdLevelExp) _get));
      final SecondLevelOp op = exp.getOp();
      EList<EObject> _args_1 = exp.getArgs();
      int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        TypeInferrer.DataType expectedArgs = TypeInferrer.DataType.GLOBAL;
        TypeInferrer.DataType expectedReturn = TypeInferrer.DataType.GLOBAL;
        if (op != null) {
          switch (op) {
            case GT:
            case LT:
              expectedArgs = TypeInferrer.DataType.INT;
              expectedReturn = TypeInferrer.DataType.BOOL;
              break;
            case EQ:
              return TypeInferrer.checkEqualsDataType(exp);
            default:
              expectedReturn = TypeInferrer.DataType.GLOBAL;
              break;
          }
        } else {
          expectedReturn = TypeInferrer.DataType.GLOBAL;
        }
        boolean _and = false;
        boolean _equals = first.equals(expectedArgs);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          TypeInferrer.DataType _checkDataType = TypeInferrer.checkDataType(((SecondLevelExp) _get_1));
          boolean _equals_1 = _checkDataType.equals(expectedArgs);
          _and = _equals_1;
        }
        if (_and) {
          return expectedReturn;
        } else {
          String _literal = op.getLiteral();
          String _plus = ("Mismatched data types for operator " + _literal);
          String _plus_1 = (_plus + ", arguments should be ");
          String _string = expectedArgs.toString();
          String _plus_2 = (_plus_1 + _string);
          String _plus_3 = (_plus_2 + ".");
          throw new MismatchedTypeException(_plus_3);
        }
      } else {
        return first;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the DataType of a ThirdLevelExp.
   * Verifies that both sides of the expression have the type that it's operator accepts.
   */
  public static TypeInferrer.DataType checkDataType(final ThirdLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = TypeInferrer.checkDataType(((FourthLevelExp) _get));
      final ThirdLevelOp op = exp.getOp();
      EList<EObject> _args_1 = exp.getArgs();
      int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
        if (op != null) {
          switch (op) {
            case PLUS:
            case MINUS:
              expected = TypeInferrer.DataType.INT;
              break;
            case CONCAT:
              return TypeInferrer.checkConcatDataType(exp);
            default:
              expected = TypeInferrer.DataType.GLOBAL;
              break;
          }
        } else {
          expected = TypeInferrer.DataType.GLOBAL;
        }
        boolean _and = false;
        boolean _equals = first.equals(expected);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          TypeInferrer.DataType _checkDataType = TypeInferrer.checkDataType(((ThirdLevelExp) _get_1));
          boolean _equals_1 = _checkDataType.equals(expected);
          _and = _equals_1;
        }
        if (_and) {
          return expected;
        } else {
          String _literal = op.getLiteral();
          String _plus = ("Mismatched data types for operator " + _literal);
          String _plus_1 = (_plus + ", arguments should be ");
          String _string = expected.toString();
          String _plus_2 = (_plus_1 + _string);
          String _plus_3 = (_plus_2 + ".");
          throw new MismatchedTypeException(_plus_3);
        }
      } else {
        return first;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the DataType of a FourthLevelExp.
   * Verifies that both sides of the expression have the type that it's operator accepts.
   */
  public static TypeInferrer.DataType checkDataType(final FourthLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = TypeInferrer.checkDataType(((Term) _get));
      EList<EObject> _args_1 = exp.getArgs();
      int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        boolean _and = false;
        boolean _equals = first.equals(TypeInferrer.DataType.INT);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          TypeInferrer.DataType _checkDataType = TypeInferrer.checkDataType(((FourthLevelExp) _get_1));
          boolean _equals_1 = _checkDataType.equals(TypeInferrer.DataType.INT);
          _and = _equals_1;
        }
        if (_and) {
          return TypeInferrer.DataType.INT;
        } else {
          FourthLevelOp _op = exp.getOp();
          String _literal = _op.getLiteral();
          String _plus = ("Mismatched data types for operator " + _literal);
          String _plus_1 = (_plus + ", arguments should be INT.");
          throw new MismatchedTypeException(_plus_1);
        }
      } else {
        return first;
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the DataType of a ThirdLevelExp that uses a concat operator.
   * This operator can accept BOOL, INT and STRING types, and needs a different check.
   */
  public static TypeInferrer.DataType checkConcatDataType(final ThirdLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = TypeInferrer.checkDataType(((FourthLevelExp) _get));
      EList<EObject> _args_1 = exp.getArgs();
      EObject _get_1 = _args_1.get(1);
      final TypeInferrer.DataType second = TypeInferrer.checkDataType(((ThirdLevelExp) _get_1));
      boolean _equals = first.equals(TypeInferrer.DataType.STRING);
      if (_equals) {
        boolean _or = false;
        boolean _or_1 = false;
        boolean _equals_1 = second.equals(TypeInferrer.DataType.INT);
        if (_equals_1) {
          _or_1 = true;
        } else {
          boolean _equals_2 = second.equals(TypeInferrer.DataType.BOOL);
          _or_1 = _equals_2;
        }
        if (_or_1) {
          _or = true;
        } else {
          boolean _equals_3 = second.equals(TypeInferrer.DataType.STRING);
          _or = _equals_3;
        }
        if (_or) {
          return TypeInferrer.DataType.STRING;
        } else {
          String _literal = ThirdLevelOp.CONCAT.getLiteral();
          String _plus = (_literal + " only supports STRING, INT and BOOLEAN types.");
          throw new MismatchedTypeException(_plus);
        }
      }
      boolean _equals_4 = second.equals(TypeInferrer.DataType.STRING);
      if (_equals_4) {
        boolean _or_2 = false;
        boolean _or_3 = false;
        boolean _equals_5 = first.equals(TypeInferrer.DataType.INT);
        if (_equals_5) {
          _or_3 = true;
        } else {
          boolean _equals_6 = first.equals(TypeInferrer.DataType.BOOL);
          _or_3 = _equals_6;
        }
        if (_or_3) {
          _or_2 = true;
        } else {
          boolean _equals_7 = first.equals(TypeInferrer.DataType.STRING);
          _or_2 = _equals_7;
        }
        if (_or_2) {
          return TypeInferrer.DataType.STRING;
        } else {
          String _literal_1 = ThirdLevelOp.CONCAT.getLiteral();
          String _plus_1 = (_literal_1 + " only supports STRING, INT and BOOLEAN types.");
          throw new MismatchedTypeException(_plus_1);
        }
      }
      String _literal_2 = SecondLevelOp.EQ.getLiteral();
      String _plus_2 = ("At least one of the arguments in a " + _literal_2);
      String _plus_3 = (_plus_2 + " operation should be type STRING.");
      throw new MismatchedTypeException(_plus_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the DataType of a SecondLevelExp that uses an equals operator.
   * This operator can accept all types, and needs a different check.
   */
  public static TypeInferrer.DataType checkEqualsDataType(final SecondLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = TypeInferrer.checkDataType(((ThirdLevelExp) _get));
      EList<EObject> _args_1 = exp.getArgs();
      EObject _get_1 = _args_1.get(1);
      final TypeInferrer.DataType second = TypeInferrer.checkDataType(((SecondLevelExp) _get_1));
      boolean _equals = first.equals(second);
      if (_equals) {
        return TypeInferrer.DataType.BOOL;
      }
      String _name = SecondLevelOp.EQ.getName();
      String _plus = ("The two arguments being compared with " + _name);
      String _plus_1 = (_plus + " should have the same type.");
      throw new MismatchedTypeException(_plus_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the type of a Term.
   */
  public static TypeInferrer.DataType checkDataType(final Term term) {
    if ((term instanceof SimpleTerm)) {
      return TypeInferrer.checkDataType(((SimpleTerm) term));
    } else {
      if ((term instanceof ComplexTerm)) {
        return TypeInferrer.checkDataType(((ComplexTerm) term));
      }
    }
    return null;
  }
  
  /**
   * Checks and returns the type of a SimpleTerm, based on it's instance.
   */
  public static TypeInferrer.DataType checkDataType(final SimpleTerm term) {
    if ((term instanceof MyInteger)) {
      return TypeInferrer.checkDataType(((MyInteger) term));
    } else {
      if ((term instanceof MyString)) {
        return TypeInferrer.DataType.STRING;
      } else {
        if ((term instanceof MyBool)) {
          return TypeInferrer.checkDataType(((MyBool) term));
        } else {
          if ((term instanceof List)) {
            return TypeInferrer.checkDataType(((List) term));
          } else {
            if ((term instanceof Variable)) {
              return TypeInferrer.getDataType(((Variable) term));
            }
          }
        }
      }
    }
    return null;
  }
  
  /**
   * Checks and returns the type of a ComplexTerm, based on it's instance.
   */
  public static TypeInferrer.DataType checkDataType(final ComplexTerm term) {
    if ((term instanceof FunctionCall)) {
      return TypeInferrer.checkDataType(((FunctionCall) term));
    } else {
      if ((term instanceof IfControlFlow)) {
        return TypeInferrer.checkDataType(((IfControlFlow) term));
      } else {
        if ((term instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) term).getExp();
          return TypeInferrer.checkDataType(_exp);
        }
      }
    }
    return null;
  }
  
  /**
   * Checks and returns the type of a List and it's elements.
   */
  public static TypeInferrer.DataType checkDataType(final List li) {
    try {
      EList<ListElem> _elems = li.getElems();
      for (final ListElem el : _elems) {
        if ((el instanceof Variable)) {
          TypeInferrer.DataType _dataType = TypeInferrer.getDataType(((Variable) el));
          boolean _equals = _dataType.equals(TypeInferrer.DataType.INT);
          boolean _not = (!_equals);
          if (_not) {
            throw new MismatchedTypeException("List elements must be INT.");
          }
        }
      }
      return TypeInferrer.DataType.LIST;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the type of a MyInteger. If it's a negation of a ComplexTerm,
   * it's type is checked as well.
   */
  public static TypeInferrer.DataType checkDataType(final MyInteger myInt) {
    try {
      if ((myInt instanceof NegInteger)) {
        final Term exp = ((NegInteger) myInt).getVal();
        if ((exp instanceof ComplexTerm)) {
          final TypeInferrer.DataType expType = TypeInferrer.checkDataType(((ComplexTerm) exp));
          boolean _equals = expType.equals(TypeInferrer.DataType.INT);
          boolean _not = (!_equals);
          if (_not) {
            throw new MismatchedTypeException("Argument type should be INT.");
          }
        }
      }
      return TypeInferrer.DataType.INT;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the type of a MyBool. If it's a negation of a ComplexTerm,
   * it's type is checked as well.
   */
  public static TypeInferrer.DataType checkDataType(final MyBool myBool) {
    try {
      if ((myBool instanceof NegBool)) {
        final Term exp = ((NegBool) myBool).getVal();
        if ((exp instanceof ComplexTerm)) {
          final TypeInferrer.DataType expType = TypeInferrer.checkDataType(((ComplexTerm) exp));
          boolean _equals = expType.equals(TypeInferrer.DataType.BOOL);
          boolean _not = (!_equals);
          if (_not) {
            throw new MismatchedTypeException("Argument type should be BOOL.");
          }
        }
      }
      return TypeInferrer.DataType.BOOL;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the type of a FunctionCall.
   */
  public static TypeInferrer.DataType checkDataType(final FunctionCall fcall) {
    if ((fcall instanceof PreDefFunctionCall)) {
      return TypeInferrer.checkDataType(((PreDefFunctionCall) fcall));
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        return TypeInferrer.checkDataType(((UserDefFunctionCall) fcall));
      }
    }
    return null;
  }
  
  /**
   * Checks and returns the type of a predefined function call and it's arguments.
   */
  public static TypeInferrer.DataType checkDataType(final PreDefFunctionCall fcall) {
    try {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      ArrayList<TypeInferrer.DataType> paramsTypes = new ArrayList<TypeInferrer.DataType>();
      PDFunction _function = fcall.getFunction();
      if (_function != null) {
        switch (_function) {
          case SHOW:
            return TypeInferrer.checkShowDataType(fcall);
          case LENGTH:
            expected = TypeInferrer.DataType.INT;
            paramsTypes.add(TypeInferrer.DataType.STRING);
            break;
          case CAR:
            expected = TypeInferrer.DataType.INT;
            paramsTypes.add(TypeInferrer.DataType.LIST);
            break;
          case CDR:
            expected = TypeInferrer.DataType.LIST;
            paramsTypes.add(TypeInferrer.DataType.LIST);
            break;
          case CONS:
            expected = TypeInferrer.DataType.LIST;
            paramsTypes.add(TypeInferrer.DataType.INT);
            paramsTypes.add(TypeInferrer.DataType.LIST);
            break;
          case IS_EMPTY:
            expected = TypeInferrer.DataType.BOOL;
            paramsTypes.add(TypeInferrer.DataType.LIST);
            break;
          default:
            PDFunction _function_1 = fcall.getFunction();
            String _name = _function_1.getName();
            String _plus = (_name + " method is not predefined.");
            throw new HugeException(_plus);
        }
      } else {
        PDFunction _function_1 = fcall.getFunction();
        String _name = _function_1.getName();
        String _plus = (_name + " method is not predefined.");
        throw new HugeException(_plus);
      }
      int i = 0;
      EList<Expression> _args = fcall.getArgs();
      for (final Expression exp : _args) {
        {
          int _size = paramsTypes.size();
          boolean _greaterEqualsThan = (i >= _size);
          if (_greaterEqualsThan) {
            PDFunction _function_2 = fcall.getFunction();
            String _name_1 = _function_2.getName();
            String _plus_1 = ("Too many arguments in function " + _name_1);
            throw new MismatchedTypeException(_plus_1);
          }
          TypeInferrer.DataType _get = paramsTypes.get(i);
          boolean _equals = _get.equals(TypeInferrer.DataType.GLOBAL);
          boolean _not = (!_equals);
          if (_not) {
            TypeInferrer.DataType _checkDataType = TypeInferrer.checkDataType(exp);
            TypeInferrer.DataType _get_1 = paramsTypes.get(i);
            boolean _equals_1 = _checkDataType.equals(_get_1);
            boolean _not_1 = (!_equals_1);
            if (_not_1) {
              TypeInferrer.DataType _get_2 = paramsTypes.get(i);
              String _plus_2 = ("Argument type should be " + _get_2);
              throw new MismatchedTypeException(_plus_2);
            }
          }
          i++;
        }
      }
      return expected;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the type of an user defined function call and it's arguments.
   */
  public static TypeInferrer.DataType checkDataType(final UserDefFunctionCall fcall) {
    try {
      FunctionDefinition _function = fcall.getFunction();
      String _name = _function.getName();
      boolean _containsKey = TypeInferrer.functionTypes.containsKey(_name);
      if (_containsKey) {
        final EList<Expression> args = fcall.getArgs();
        FunctionDefinition _function_1 = fcall.getFunction();
        String _name_1 = _function_1.getName();
        final HashMap<String, TypeInferrer.DataType> params = TypeInferrer.functionParams.get(_name_1);
        int i = 0;
        FunctionDefinition _function_2 = fcall.getFunction();
        EList<MyVariable> _params = _function_2.getParams();
        for (final MyVariable current : _params) {
          {
            int _size = args.size();
            boolean _greaterEqualsThan = (i >= _size);
            if (_greaterEqualsThan) {
              FunctionDefinition _function_3 = fcall.getFunction();
              String _name_2 = _function_3.getName();
              String _plus = ("Too many arguments in function " + _name_2);
              throw new MismatchedTypeException(_plus);
            }
            final String name = TypeInferrer.getVariable(current);
            boolean _containsKey_1 = params.containsKey(name);
            if (_containsKey_1) {
              Expression _get = args.get(i);
              TypeInferrer.DataType _checkDataType = TypeInferrer.checkDataType(_get);
              TypeInferrer.DataType _get_1 = params.get(name);
              boolean _equals = _checkDataType.equals(_get_1);
              boolean _not = (!_equals);
              if (_not) {
                TypeInferrer.DataType _get_2 = params.get(name);
                String _plus_1 = ("Argument type should be " + _get_2);
                throw new MismatchedTypeException(_plus_1);
              }
            }
            i++;
          }
        }
        FunctionDefinition _function_3 = fcall.getFunction();
        String _name_2 = _function_3.getName();
        return TypeInferrer.functionTypes.get(_name_2);
      } else {
        FunctionDefinition _function_4 = fcall.getFunction();
        String _name_3 = _function_4.getName();
        String _plus = (_name_3 + " method was not defined.");
        throw new HugeException(_plus);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks that the argument of a show function call is BOOL, STRING, INT or LIST.
   */
  public static TypeInferrer.DataType checkShowDataType(final PreDefFunctionCall fcall) {
    try {
      EList<Expression> _args = fcall.getArgs();
      Expression _get = _args.get(0);
      final TypeInferrer.DataType arg = TypeInferrer.checkDataType(_get);
      boolean _or = false;
      boolean _or_1 = false;
      boolean _or_2 = false;
      boolean _equals = arg.equals(TypeInferrer.DataType.INT);
      if (_equals) {
        _or_2 = true;
      } else {
        boolean _equals_1 = arg.equals(TypeInferrer.DataType.STRING);
        _or_2 = _equals_1;
      }
      if (_or_2) {
        _or_1 = true;
      } else {
        boolean _equals_2 = arg.equals(TypeInferrer.DataType.BOOL);
        _or_1 = _equals_2;
      }
      if (_or_1) {
        _or = true;
      } else {
        boolean _equals_3 = arg.equals(TypeInferrer.DataType.LIST);
        _or = _equals_3;
      }
      boolean _not = (!_or);
      if (_not) {
        throw new MismatchedTypeException("Unknown data type to show");
      }
      return TypeInferrer.DataType.VOID;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Checks and returns the type of an IfControlFlow, and checks the types of it's condition,
   * if true return and if false return.
   */
  public static TypeInferrer.DataType checkDataType(final IfControlFlow ifCF) {
    try {
      Expression _cond = ifCF.getCond();
      final TypeInferrer.DataType cond = TypeInferrer.checkDataType(_cond);
      Expression _iftrue = ifCF.getIftrue();
      final TypeInferrer.DataType iftrue = TypeInferrer.checkDataType(_iftrue);
      Expression _iffalse = ifCF.getIffalse();
      final TypeInferrer.DataType iffalse = TypeInferrer.checkDataType(_iffalse);
      boolean _equals = cond.equals(TypeInferrer.DataType.BOOL);
      boolean _not = (!_equals);
      if (_not) {
        throw new MismatchedTypeException("Condition should be type BOOL.");
      }
      boolean _equals_1 = iftrue.equals(iffalse);
      boolean _not_1 = (!_equals_1);
      if (_not_1) {
        throw new MismatchedTypeException("Both statements should return the same type.");
      }
      return iftrue;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Return the variable name of a given FirstLevelExp.
   */
  public static String getVariable(final FirstLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    return TypeInferrer.getVariable(((SecondLevelExp) _get));
  }
  
  /**
   * Return the variable name of a given SecondLevelExp.
   */
  public static String getVariable(final SecondLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    return TypeInferrer.getVariable(((ThirdLevelExp) _get));
  }
  
  /**
   * Return the variable name of a given ThirdLevelExp.
   */
  public static String getVariable(final ThirdLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    return TypeInferrer.getVariable(((FourthLevelExp) _get));
  }
  
  /**
   * Return the variable name of a given FourthLevelExp.
   */
  public static String getVariable(final FourthLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    return TypeInferrer.getVariable(((Term) _get));
  }
  
  /**
   * Return the variable name of a given Term.
   */
  public static String getVariable(final Term term) {
    if ((term instanceof Variable)) {
      return ((Variable) term).getVar();
    } else {
      if ((term instanceof UserDefFunctionCall)) {
        FunctionDefinition _function = ((UserDefFunctionCall) term).getFunction();
        Expression _return = _function.getReturn();
        FirstLevelExp _exp = _return.getExp();
        return TypeInferrer.getVariable(_exp);
      } else {
        if ((term instanceof IfControlFlow)) {
          Expression _iftrue = ((IfControlFlow) term).getIftrue();
          FirstLevelExp _exp_1 = _iftrue.getExp();
          return TypeInferrer.getVariable(_exp_1);
        } else {
          if ((term instanceof BracketExpression)) {
            Expression _exp_2 = ((BracketExpression) term).getExp();
            FirstLevelExp _exp_3 = _exp_2.getExp();
            return TypeInferrer.getVariable(_exp_3);
          }
        }
      }
    }
    return null;
  }
  
  /**
   * Returns the variable name of a given MyVariable.
   */
  public static String getVariable(final MyVariable variable) {
    if ((variable instanceof Variable)) {
      return ((Variable) variable).getVar();
    } else {
      if ((variable instanceof CastedVariable)) {
        return ((CastedVariable) variable).getVar();
      }
    }
    return null;
  }
  
  /**
   * Converts a given CastedType to a DataType.
   */
  public static TypeInferrer.DataType getDataTypeFromCast(final CastedType ct) {
    if (ct != null) {
      switch (ct) {
        case BOOL:
          return TypeInferrer.DataType.BOOL;
        case INT:
          return TypeInferrer.DataType.INT;
        case STRING:
          return TypeInferrer.DataType.STRING;
        case LIST:
          return TypeInferrer.DataType.LIST;
        default:
          break;
      }
    }
    return null;
  }
  
  /**
   * Sets a function type if it's not already been set, or changes it if it wasn't inferred
   * yet.
   */
  public static void setFunctionType(final String name, final TypeInferrer.DataType type) {
    boolean _containsKey = TypeInferrer.functionTypes.containsKey(name);
    if (_containsKey) {
      TypeInferrer.DataType _get = TypeInferrer.functionTypes.get(name);
      boolean _equals = _get.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        TypeInferrer.functionTypes.put(name, type);
      }
    } else {
      TypeInferrer.functionTypes.put(name, type);
    }
  }
  
  /**
   * Returns the function types map (table).
   */
  public static HashMap<String, TypeInferrer.DataType> getFunctionTypes() {
    return TypeInferrer.functionTypes;
  }
  
  /**
   * Returns the function parameters types map (table).
   */
  public static HashMap<String, HashMap<String, TypeInferrer.DataType>> getFunctionParams() {
    return TypeInferrer.functionParams;
  }
}
