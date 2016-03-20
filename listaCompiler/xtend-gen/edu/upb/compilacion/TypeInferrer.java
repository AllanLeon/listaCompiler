package edu.upb.compilacion;

import edu.upb.compilacion.HugeException;
import edu.upb.compilacion.MismatchedTypeException;
import edu.upb.compilacion.listaCompiler.BracketExpression;
import edu.upb.compilacion.listaCompiler.CastedType;
import edu.upb.compilacion.listaCompiler.CastedVariable;
import edu.upb.compilacion.listaCompiler.Expression;
import edu.upb.compilacion.listaCompiler.FirstLevelExp;
import edu.upb.compilacion.listaCompiler.FirstLevelOp;
import edu.upb.compilacion.listaCompiler.FourthLevelExp;
import edu.upb.compilacion.listaCompiler.FourthLevelOp;
import edu.upb.compilacion.listaCompiler.FunctionCall;
import edu.upb.compilacion.listaCompiler.FunctionDefinition;
import edu.upb.compilacion.listaCompiler.IfControlFlow;
import edu.upb.compilacion.listaCompiler.List;
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
import edu.upb.compilacion.listaCompiler.Term;
import edu.upb.compilacion.listaCompiler.ThirdLevelExp;
import edu.upb.compilacion.listaCompiler.ThirdLevelOp;
import edu.upb.compilacion.listaCompiler.UserDefFunctionCall;
import edu.upb.compilacion.listaCompiler.Variable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TypeInferrer {
  public enum DataType {
    INT,
    
    STRING,
    
    BOOL,
    
    LIST,
    
    VOID,
    
    VAR,
    
    GLOBAL,
    
    CONCAT;
  }
  
  private static HashMap<String, HashMap<String, TypeInferrer.DataType>> functionParams = new HashMap<String, HashMap<String, TypeInferrer.DataType>>();
  
  private static HashMap<String, TypeInferrer.DataType> functionTypes = new HashMap<String, TypeInferrer.DataType>();
  
  private static String currentFunction = "";
  
  public static String resetCurrentFunction() {
    return TypeInferrer.currentFunction = "";
  }
  
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
  
  public static void inferDataType(final FunctionDefinition fd) {
    String _name = fd.getName();
    TypeInferrer.currentFunction = _name;
    String _name_1 = fd.getName();
    HashMap<String, TypeInferrer.DataType> _hashMap = new HashMap<String, TypeInferrer.DataType>();
    TypeInferrer.functionParams.put(_name_1, _hashMap);
    Expression _return = fd.getReturn();
    FirstLevelExp _exp = _return.getExp();
    String _name_2 = fd.getName();
    TypeInferrer.inferDataType(_exp, _name_2);
  }
  
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
  
  public static void inferDataType(final Term term, final String fdName) {
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
            TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.LIST);
          } else {
            if ((term instanceof MyVariable)) {
              TypeInferrer.inferDataType(((MyVariable) term), fdName);
            } else {
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
          }
        }
      }
    }
  }
  
  public static void inferDataType(final MyVariable variable, final String fdName) {
    if ((variable instanceof Variable)) {
      TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.VAR);
    } else {
      if ((variable instanceof CastedVariable)) {
        CastedType _type = ((CastedVariable) variable).getType();
        TypeInferrer.DataType _dataTypeFromCast = TypeInferrer.getDataTypeFromCast(_type);
        TypeInferrer.setFunctionType(fdName, _dataTypeFromCast);
      }
    }
  }
  
  public static void inferDataType(final MyInteger myInt, final String fdName) {
    TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.INT);
    if ((myInt instanceof NegInteger)) {
      final Term exp = ((NegInteger) myInt).getVal();
      if ((exp instanceof BracketExpression)) {
        Expression _exp = ((BracketExpression) exp).getExp();
        FirstLevelExp _exp_1 = _exp.getExp();
        TypeInferrer.inferDataType(_exp_1, fdName);
      }
    }
  }
  
  public static void inferDataType(final MyBool myBool, final String fdName) {
    TypeInferrer.setFunctionType(fdName, TypeInferrer.DataType.BOOL);
    if ((myBool instanceof NegBool)) {
      final Term exp = ((NegBool) myBool).getVal();
      if ((exp instanceof BracketExpression)) {
        Expression _exp = ((BracketExpression) exp).getExp();
        FirstLevelExp _exp_1 = _exp.getExp();
        TypeInferrer.inferDataType(_exp_1, fdName);
      }
    }
  }
  
  public static void inferDataType(final FunctionCall fcall, final String fdName) {
    if ((fcall instanceof PreDefFunctionCall)) {
      TypeInferrer.inferDataType(((PreDefFunctionCall) fcall), fdName);
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        TypeInferrer.inferDataType(((UserDefFunctionCall) fcall), fdName);
      }
    }
  }
  
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
  }
  
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
  }
  
  /**
   * def inferDataType(IfControlFlow ifCF, String fdName) {
   * return ifCF.iftrue.getDataType;
   * }
   */
  public static TypeInferrer.DataType getDataType(final Expression exp) {
    FirstLevelExp _exp = exp.getExp();
    return TypeInferrer.getDataType(_exp);
  }
  
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
  
  public static TypeInferrer.DataType getDataType(final Term term) {
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
            if ((term instanceof MyVariable)) {
              return TypeInferrer.getDataType(((MyVariable) term));
            } else {
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
            }
          }
        }
      }
    }
    return null;
  }
  
  public static TypeInferrer.DataType getDataType(final MyVariable variable) {
    if ((variable instanceof Variable)) {
      return TypeInferrer.getDataType(((Variable) variable));
    } else {
      if ((variable instanceof CastedVariable)) {
        final CastedVariable cvar = ((CastedVariable) variable);
        CastedType _type = cvar.getType();
        final TypeInferrer.DataType type = TypeInferrer.getDataTypeFromCast(_type);
        HashMap<String, TypeInferrer.DataType> _get = TypeInferrer.functionParams.get(TypeInferrer.currentFunction);
        String _var = cvar.getVar();
        _get.put(_var, type);
        CastedType _type_1 = cvar.getType();
        return TypeInferrer.getDataTypeFromCast(_type_1);
      }
    }
    return null;
  }
  
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
  
  public static TypeInferrer.DataType getDataType(final IfControlFlow ifCF) {
    Expression _iftrue = ifCF.getIftrue();
    return TypeInferrer.getDataType(_iftrue);
  }
  
  public static TypeInferrer.DataType checkDataType(final Expression exp) {
    FirstLevelExp _exp = exp.getExp();
    return TypeInferrer.checkDataType(_exp);
  }
  
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
              return TypeInferrer.compareEquals(exp);
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
              return TypeInferrer.checkStringConcat(exp);
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
  
  public static TypeInferrer.DataType checkStringConcat(final ThirdLevelExp exp) {
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
          String _literal = SecondLevelOp.EQ.getLiteral();
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
          String _literal_1 = SecondLevelOp.EQ.getLiteral();
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
  
  public static TypeInferrer.DataType checkDataType(final Term term) {
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
            return TypeInferrer.DataType.LIST;
          } else {
            if ((term instanceof MyVariable)) {
              return TypeInferrer.getDataType(((MyVariable) term));
            } else {
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
            }
          }
        }
      }
    }
    return null;
  }
  
  public static TypeInferrer.DataType checkDataType(final MyInteger myInt) {
    try {
      if ((myInt instanceof NegInteger)) {
        final Term exp = ((NegInteger) myInt).getVal();
        if ((exp instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) exp).getExp();
          final TypeInferrer.DataType expType = TypeInferrer.checkDataType(_exp);
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
  
  public static TypeInferrer.DataType checkDataType(final MyBool myBool) {
    try {
      if ((myBool instanceof NegBool)) {
        final Term exp = ((NegBool) myBool).getVal();
        if ((exp instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) exp).getExp();
          final TypeInferrer.DataType expType = TypeInferrer.checkDataType(_exp);
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
  
  public static TypeInferrer.DataType checkDataType(final PreDefFunctionCall fcall) {
    try {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      ArrayList<TypeInferrer.DataType> paramsTypes = new ArrayList<TypeInferrer.DataType>();
      PDFunction _function = fcall.getFunction();
      if (_function != null) {
        switch (_function) {
          case SHOW:
            expected = TypeInferrer.DataType.VOID;
            paramsTypes.add(TypeInferrer.DataType.GLOBAL);
            break;
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
              String _plus_1 = ("Argument type should be " + _get_2);
              throw new MismatchedTypeException(_plus_1);
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
        EList<String> _params = _function_2.getParams();
        for (final String current : _params) {
          {
            boolean _containsKey_1 = params.containsKey(current);
            if (_containsKey_1) {
              Expression _get = args.get(i);
              TypeInferrer.DataType _checkDataType = TypeInferrer.checkDataType(_get);
              TypeInferrer.DataType _get_1 = params.get(current);
              boolean _equals = _checkDataType.equals(_get_1);
              boolean _not = (!_equals);
              if (_not) {
                TypeInferrer.DataType _get_2 = params.get(current);
                String _plus = ("Argument type should be " + _get_2);
                throw new MismatchedTypeException(_plus);
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
  
  public static TypeInferrer.DataType compareEquals(final SecondLevelExp exp) {
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
  
  public static String getVariable(final FirstLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    EList<EObject> _args_1 = ((SecondLevelExp) _get).getArgs();
    EObject _get_1 = _args_1.get(0);
    EList<EObject> _args_2 = ((ThirdLevelExp) _get_1).getArgs();
    EObject _get_2 = _args_2.get(0);
    EList<EObject> _args_3 = ((FourthLevelExp) _get_2).getArgs();
    EObject _get_3 = _args_3.get(0);
    return TypeInferrer.getVariable(((Term) _get_3));
  }
  
  public static String getVariable(final SecondLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    EList<EObject> _args_1 = ((ThirdLevelExp) _get).getArgs();
    EObject _get_1 = _args_1.get(0);
    EList<EObject> _args_2 = ((FourthLevelExp) _get_1).getArgs();
    EObject _get_2 = _args_2.get(0);
    return TypeInferrer.getVariable(((Term) _get_2));
  }
  
  public static String getVariable(final ThirdLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    EList<EObject> _args_1 = ((FourthLevelExp) _get).getArgs();
    EObject _get_1 = _args_1.get(0);
    return TypeInferrer.getVariable(((Term) _get_1));
  }
  
  public static String getVariable(final FourthLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    return TypeInferrer.getVariable(((Term) _get));
  }
  
  public static String getVariable(final Term term) {
    if ((term instanceof MyVariable)) {
      return TypeInferrer.getVariable(((MyVariable) term));
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
  
  public static TypeInferrer.DataType getDataTypeFromCast(final CastedType ct) {
    if (ct != null) {
      switch (ct) {
        case BOOL:
          return TypeInferrer.DataType.BOOL;
        case INT:
          return TypeInferrer.DataType.INT;
        case STRING:
          return TypeInferrer.DataType.STRING;
        default:
          break;
      }
    }
    return null;
  }
  
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
  
  public static String getFunctionString(final FunctionDefinition fd) {
    final String name = fd.getName();
    TypeInferrer.DataType _get = TypeInferrer.functionTypes.get(name);
    String res = ((name + "->") + _get);
    HashMap<String, TypeInferrer.DataType> _get_1 = TypeInferrer.functionParams.get(name);
    Set<String> _keySet = _get_1.keySet();
    for (final String cur : _keySet) {
      String _res = res;
      HashMap<String, TypeInferrer.DataType> _get_2 = TypeInferrer.functionParams.get(name);
      TypeInferrer.DataType _get_3 = _get_2.get(cur);
      String _plus = ((("\n" + cur) + ":") + _get_3);
      res = (_res + _plus);
    }
    return res;
  }
  
  public static HashMap<String, TypeInferrer.DataType> getFunctionTypes() {
    return TypeInferrer.functionTypes;
  }
  
  public static HashMap<String, HashMap<String, TypeInferrer.DataType>> getFunctionParams() {
    return TypeInferrer.functionParams;
  }
}
