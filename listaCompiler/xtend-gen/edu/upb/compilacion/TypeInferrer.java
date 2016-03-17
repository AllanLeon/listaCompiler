package edu.upb.compilacion;

import edu.upb.compilacion.HugeException;
import edu.upb.compilacion.MismatchedTypeException;
import edu.upb.compilacion.listaCompiler.BracketExpression;
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
import edu.upb.compilacion.validation.ListaCompilerValidator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TypeInferrer {
  private static HashMap<String, HashMap<String, ListaCompilerValidator.DataType>> functionParams = new HashMap<String, HashMap<String, ListaCompilerValidator.DataType>>();
  
  private static HashMap<String, ListaCompilerValidator.DataType> functionTypes = new HashMap<String, ListaCompilerValidator.DataType>();
  
  private static String currentFunction = "";
  
  public static String resetFunction() {
    return TypeInferrer.currentFunction = "";
  }
  
  public static void inferDataType(final FunctionDefinition fd) {
    String _name = fd.getName();
    TypeInferrer.currentFunction = _name;
    String _name_1 = fd.getName();
    HashMap<String, ListaCompilerValidator.DataType> _hashMap = new HashMap<String, ListaCompilerValidator.DataType>();
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
    final ListaCompilerValidator.DataType firstType = TypeInferrer.getDataType(first);
    final FirstLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case AND:
          case OR:
            expected = ListaCompilerValidator.DataType.BOOL;
            break;
          default:
            expected = ListaCompilerValidator.DataType.GLOBAL;
            break;
        }
      } else {
        expected = ListaCompilerValidator.DataType.GLOBAL;
      }
      TypeInferrer.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final FirstLevelExp second = ((FirstLevelExp) _get_1);
      final ListaCompilerValidator.DataType secondType = TypeInferrer.getDataType(second);
      boolean _equals = firstType.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals) {
        final MyVariable var1 = TypeInferrer.getVariable(first);
        HashMap<String, ListaCompilerValidator.DataType> _get_2 = TypeInferrer.functionParams.get(fdName);
        String _var = var1.getVar();
        _get_2.put(_var, expected);
      } else {
        TypeInferrer.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals_1) {
        final MyVariable var2 = TypeInferrer.getVariable(second);
        HashMap<String, ListaCompilerValidator.DataType> _get_3 = TypeInferrer.functionParams.get(fdName);
        String _var_1 = var2.getVar();
        _get_3.put(_var_1, expected);
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
    final ListaCompilerValidator.DataType firstType = TypeInferrer.getDataType(first);
    final SecondLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case GT:
          case LT:
            expected = ListaCompilerValidator.DataType.INT;
            break;
          case EQ:
            expected = ListaCompilerValidator.DataType.BOOL;
            break;
          default:
            expected = ListaCompilerValidator.DataType.GLOBAL;
            break;
        }
      } else {
        expected = ListaCompilerValidator.DataType.GLOBAL;
      }
      TypeInferrer.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final SecondLevelExp second = ((SecondLevelExp) _get_1);
      final ListaCompilerValidator.DataType secondType = TypeInferrer.getDataType(second);
      boolean _equals = firstType.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals) {
        final MyVariable var1 = TypeInferrer.getVariable(first);
        HashMap<String, ListaCompilerValidator.DataType> _get_2 = TypeInferrer.functionParams.get(fdName);
        String _var = var1.getVar();
        _get_2.put(_var, expected);
      } else {
        TypeInferrer.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals_1) {
        final MyVariable var2 = TypeInferrer.getVariable(second);
        HashMap<String, ListaCompilerValidator.DataType> _get_3 = TypeInferrer.functionParams.get(fdName);
        String _var_1 = var2.getVar();
        _get_3.put(_var_1, expected);
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
    final ListaCompilerValidator.DataType firstType = TypeInferrer.getDataType(first);
    final ThirdLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case PLUS:
          case MINUS:
            expected = ListaCompilerValidator.DataType.INT;
            break;
          case CONCAT:
            expected = ListaCompilerValidator.DataType.STRING;
            break;
          default:
            expected = ListaCompilerValidator.DataType.GLOBAL;
            break;
        }
      } else {
        expected = ListaCompilerValidator.DataType.GLOBAL;
      }
      TypeInferrer.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final ThirdLevelExp second = ((ThirdLevelExp) _get_1);
      final ListaCompilerValidator.DataType secondType = TypeInferrer.getDataType(second);
      boolean _equals = firstType.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals) {
        final MyVariable var1 = TypeInferrer.getVariable(first);
        HashMap<String, ListaCompilerValidator.DataType> _get_2 = TypeInferrer.functionParams.get(fdName);
        String _var = var1.getVar();
        _get_2.put(_var, expected);
      } else {
        TypeInferrer.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals_1) {
        final MyVariable var2 = TypeInferrer.getVariable(second);
        HashMap<String, ListaCompilerValidator.DataType> _get_3 = TypeInferrer.functionParams.get(fdName);
        String _var_1 = var2.getVar();
        _get_3.put(_var_1, expected);
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
    final ListaCompilerValidator.DataType firstType = TypeInferrer.getDataType(first);
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.INT;
      TypeInferrer.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final FourthLevelExp second = ((FourthLevelExp) _get_1);
      final ListaCompilerValidator.DataType secondType = TypeInferrer.getDataType(second);
      boolean _equals = firstType.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals) {
        final MyVariable var1 = ((MyVariable) first);
        HashMap<String, ListaCompilerValidator.DataType> _get_2 = TypeInferrer.functionParams.get(fdName);
        String _var = var1.getVar();
        _get_2.put(_var, expected);
      } else {
        TypeInferrer.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals_1) {
        final MyVariable var2 = TypeInferrer.getVariable(second);
        HashMap<String, ListaCompilerValidator.DataType> _get_3 = TypeInferrer.functionParams.get(fdName);
        String _var_1 = var2.getVar();
        _get_3.put(_var_1, expected);
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
        TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.STRING);
      } else {
        if ((term instanceof MyBool)) {
          TypeInferrer.inferDataType(((MyBool) term), fdName);
        } else {
          if ((term instanceof List)) {
            TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.LIST);
          } else {
            if ((term instanceof MyVariable)) {
              TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.VAR);
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
  
  public static void inferDataType(final MyInteger myInt, final String fdName) {
    TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.INT);
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
    TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.BOOL);
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
          TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.STRING);
          break;
        case LENGTH:
        case CAR:
          TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.INT);
          break;
        case CDR:
        case CONS:
          TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.LIST);
          break;
        case IS_EMPTY:
          TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.BOOL);
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
      ListaCompilerValidator.DataType _get = TypeInferrer.functionTypes.get(_name_1);
      TypeInferrer.setFunctionType(fdName, _get);
    } else {
      TypeInferrer.setFunctionType(fdName, ListaCompilerValidator.DataType.VAR);
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
  public static ListaCompilerValidator.DataType getDataType(final Expression exp) {
    FirstLevelExp _exp = exp.getExp();
    return TypeInferrer.getDataType(_exp);
  }
  
  public static ListaCompilerValidator.DataType getDataType(final FirstLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final ListaCompilerValidator.DataType first = TypeInferrer.getDataType(((SecondLevelExp) _get));
    final FirstLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case AND:
          case OR:
            expected = ListaCompilerValidator.DataType.BOOL;
            break;
          default:
            expected = ListaCompilerValidator.DataType.GLOBAL;
            break;
        }
      } else {
        expected = ListaCompilerValidator.DataType.GLOBAL;
      }
      return expected;
    } else {
      return first;
    }
  }
  
  public static ListaCompilerValidator.DataType getDataType(final SecondLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final ListaCompilerValidator.DataType first = TypeInferrer.getDataType(((ThirdLevelExp) _get));
    final SecondLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case GT:
          case LT:
          case EQ:
            expected = ListaCompilerValidator.DataType.BOOL;
            break;
          default:
            expected = ListaCompilerValidator.DataType.GLOBAL;
            break;
        }
      } else {
        expected = ListaCompilerValidator.DataType.GLOBAL;
      }
      return expected;
    } else {
      return first;
    }
  }
  
  public static ListaCompilerValidator.DataType getDataType(final ThirdLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final ListaCompilerValidator.DataType first = TypeInferrer.getDataType(((FourthLevelExp) _get));
    final ThirdLevelOp op = exp.getOp();
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
      if (op != null) {
        switch (op) {
          case PLUS:
          case MINUS:
            expected = ListaCompilerValidator.DataType.INT;
            break;
          case CONCAT:
            expected = ListaCompilerValidator.DataType.STRING;
            break;
          default:
            expected = ListaCompilerValidator.DataType.GLOBAL;
            break;
        }
      } else {
        expected = ListaCompilerValidator.DataType.GLOBAL;
      }
      return expected;
    } else {
      return first;
    }
  }
  
  public static ListaCompilerValidator.DataType getDataType(final FourthLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final ListaCompilerValidator.DataType first = TypeInferrer.getDataType(((Term) _get));
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      return ListaCompilerValidator.DataType.INT;
    } else {
      return first;
    }
  }
  
  public static ListaCompilerValidator.DataType getDataType(final Term term) {
    if ((term instanceof MyInteger)) {
      return ListaCompilerValidator.DataType.INT;
    } else {
      if ((term instanceof MyString)) {
        return ListaCompilerValidator.DataType.STRING;
      } else {
        if ((term instanceof MyBool)) {
          return ListaCompilerValidator.DataType.BOOL;
        } else {
          if ((term instanceof List)) {
            return ListaCompilerValidator.DataType.LIST;
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
  
  public static ListaCompilerValidator.DataType getDataType(final FunctionCall fcall) {
    if ((fcall instanceof PreDefFunctionCall)) {
      return TypeInferrer.getDataType(((PreDefFunctionCall) fcall));
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        return TypeInferrer.getDataType(((UserDefFunctionCall) fcall));
      }
    }
    return null;
  }
  
  public static ListaCompilerValidator.DataType getDataType(final PreDefFunctionCall fcall) {
    PDFunction _function = fcall.getFunction();
    if (_function != null) {
      switch (_function) {
        case SHOW:
          return ListaCompilerValidator.DataType.STRING;
        case LENGTH:
        case CAR:
          return ListaCompilerValidator.DataType.INT;
        case CDR:
        case CONS:
          return ListaCompilerValidator.DataType.LIST;
        case IS_EMPTY:
          return ListaCompilerValidator.DataType.BOOL;
        default:
          break;
      }
    }
    return null;
  }
  
  public static ListaCompilerValidator.DataType getDataType(final UserDefFunctionCall fcall) {
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
  
  public static ListaCompilerValidator.DataType getDataType(final IfControlFlow ifCF) {
    Expression _iftrue = ifCF.getIftrue();
    return TypeInferrer.getDataType(_iftrue);
  }
  
  public static ListaCompilerValidator.DataType checkDataType(final Expression exp) {
    FirstLevelExp _exp = exp.getExp();
    return TypeInferrer.checkDataType(_exp);
  }
  
  public static ListaCompilerValidator.DataType checkDataType(final FirstLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final ListaCompilerValidator.DataType first = TypeInferrer.checkDataType(((SecondLevelExp) _get));
      final FirstLevelOp op = exp.getOp();
      EList<EObject> _args_1 = exp.getArgs();
      int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
        if (op != null) {
          switch (op) {
            case AND:
            case OR:
              expected = ListaCompilerValidator.DataType.BOOL;
              break;
            default:
              expected = ListaCompilerValidator.DataType.GLOBAL;
              break;
          }
        } else {
          expected = ListaCompilerValidator.DataType.GLOBAL;
        }
        boolean _and = false;
        boolean _equals = first.equals(expected);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          ListaCompilerValidator.DataType _checkDataType = TypeInferrer.checkDataType(((FirstLevelExp) _get_1));
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
  
  public static ListaCompilerValidator.DataType checkDataType(final SecondLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final ListaCompilerValidator.DataType first = TypeInferrer.checkDataType(((ThirdLevelExp) _get));
      final SecondLevelOp op = exp.getOp();
      EList<EObject> _args_1 = exp.getArgs();
      int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        ListaCompilerValidator.DataType expectedArgs = ListaCompilerValidator.DataType.GLOBAL;
        ListaCompilerValidator.DataType expectedReturn = ListaCompilerValidator.DataType.GLOBAL;
        if (op != null) {
          switch (op) {
            case GT:
            case LT:
              expectedArgs = ListaCompilerValidator.DataType.INT;
              expectedReturn = ListaCompilerValidator.DataType.BOOL;
              break;
            case EQ:
              return TypeInferrer.compareEquals(exp);
            default:
              expectedReturn = ListaCompilerValidator.DataType.GLOBAL;
              break;
          }
        } else {
          expectedReturn = ListaCompilerValidator.DataType.GLOBAL;
        }
        boolean _and = false;
        boolean _equals = first.equals(expectedArgs);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          ListaCompilerValidator.DataType _checkDataType = TypeInferrer.checkDataType(((SecondLevelExp) _get_1));
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
  
  public static ListaCompilerValidator.DataType checkDataType(final ThirdLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final ListaCompilerValidator.DataType first = TypeInferrer.checkDataType(((FourthLevelExp) _get));
      final ThirdLevelOp op = exp.getOp();
      EList<EObject> _args_1 = exp.getArgs();
      int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
        if (op != null) {
          switch (op) {
            case PLUS:
            case MINUS:
              expected = ListaCompilerValidator.DataType.INT;
              break;
            case CONCAT:
              expected = ListaCompilerValidator.DataType.STRING;
              break;
            default:
              expected = ListaCompilerValidator.DataType.GLOBAL;
              break;
          }
        } else {
          expected = ListaCompilerValidator.DataType.GLOBAL;
        }
        boolean _and = false;
        boolean _equals = first.equals(expected);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          ListaCompilerValidator.DataType _checkDataType = TypeInferrer.checkDataType(((ThirdLevelExp) _get_1));
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
  
  public static ListaCompilerValidator.DataType checkDataType(final FourthLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final ListaCompilerValidator.DataType first = TypeInferrer.checkDataType(((Term) _get));
      EList<EObject> _args_1 = exp.getArgs();
      int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        boolean _and = false;
        boolean _equals = first.equals(ListaCompilerValidator.DataType.INT);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          ListaCompilerValidator.DataType _checkDataType = TypeInferrer.checkDataType(((FourthLevelExp) _get_1));
          boolean _equals_1 = _checkDataType.equals(ListaCompilerValidator.DataType.INT);
          _and = _equals_1;
        }
        if (_and) {
          return ListaCompilerValidator.DataType.INT;
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
  
  public static ListaCompilerValidator.DataType checkDataType(final Term term) {
    if ((term instanceof MyInteger)) {
      return TypeInferrer.checkDataType(((MyInteger) term));
    } else {
      if ((term instanceof MyString)) {
        return ListaCompilerValidator.DataType.STRING;
      } else {
        if ((term instanceof MyBool)) {
          return TypeInferrer.checkDataType(((MyBool) term));
        } else {
          if ((term instanceof List)) {
            return ListaCompilerValidator.DataType.LIST;
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
  
  public static ListaCompilerValidator.DataType checkDataType(final MyInteger myInt) {
    try {
      if ((myInt instanceof NegInteger)) {
        final Term exp = ((NegInteger) myInt).getVal();
        if ((exp instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) exp).getExp();
          final ListaCompilerValidator.DataType expType = TypeInferrer.checkDataType(_exp);
          boolean _equals = expType.equals(ListaCompilerValidator.DataType.INT);
          boolean _not = (!_equals);
          if (_not) {
            throw new MismatchedTypeException("Argument type should be INT.");
          }
        }
      }
      return ListaCompilerValidator.DataType.INT;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ListaCompilerValidator.DataType checkDataType(final MyBool myBool) {
    try {
      if ((myBool instanceof NegBool)) {
        final Term exp = ((NegBool) myBool).getVal();
        if ((exp instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) exp).getExp();
          final ListaCompilerValidator.DataType expType = TypeInferrer.checkDataType(_exp);
          boolean _equals = expType.equals(ListaCompilerValidator.DataType.BOOL);
          boolean _not = (!_equals);
          if (_not) {
            throw new MismatchedTypeException("Argument type should be BOOL.");
          }
        }
      }
      return ListaCompilerValidator.DataType.BOOL;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ListaCompilerValidator.DataType checkDataType(final FunctionCall fcall) {
    if ((fcall instanceof PreDefFunctionCall)) {
      return TypeInferrer.checkDataType(((PreDefFunctionCall) fcall));
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        return TypeInferrer.checkDataType(((UserDefFunctionCall) fcall));
      }
    }
    return null;
  }
  
  public static ListaCompilerValidator.DataType checkDataType(final PreDefFunctionCall fcall) {
    try {
      ListaCompilerValidator.DataType expected = ListaCompilerValidator.DataType.GLOBAL;
      ArrayList<ListaCompilerValidator.DataType> paramsTypes = new ArrayList<ListaCompilerValidator.DataType>();
      PDFunction _function = fcall.getFunction();
      if (_function != null) {
        switch (_function) {
          case SHOW:
            expected = ListaCompilerValidator.DataType.STRING;
            paramsTypes.add(ListaCompilerValidator.DataType.GLOBAL);
            break;
          case LENGTH:
            expected = ListaCompilerValidator.DataType.INT;
            paramsTypes.add(ListaCompilerValidator.DataType.STRING);
            break;
          case CAR:
            expected = ListaCompilerValidator.DataType.INT;
            paramsTypes.add(ListaCompilerValidator.DataType.LIST);
            break;
          case CDR:
            expected = ListaCompilerValidator.DataType.LIST;
            paramsTypes.add(ListaCompilerValidator.DataType.LIST);
            break;
          case CONS:
            expected = ListaCompilerValidator.DataType.LIST;
            paramsTypes.add(ListaCompilerValidator.DataType.INT);
            paramsTypes.add(ListaCompilerValidator.DataType.LIST);
            break;
          case IS_EMPTY:
            expected = ListaCompilerValidator.DataType.BOOL;
            paramsTypes.add(ListaCompilerValidator.DataType.LIST);
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
          ListaCompilerValidator.DataType _get = paramsTypes.get(i);
          boolean _equals = _get.equals(ListaCompilerValidator.DataType.GLOBAL);
          boolean _not = (!_equals);
          if (_not) {
            ListaCompilerValidator.DataType _checkDataType = TypeInferrer.checkDataType(exp);
            ListaCompilerValidator.DataType _get_1 = paramsTypes.get(i);
            boolean _equals_1 = _checkDataType.equals(_get_1);
            boolean _not_1 = (!_equals_1);
            if (_not_1) {
              ListaCompilerValidator.DataType _get_2 = paramsTypes.get(i);
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
  
  public static ListaCompilerValidator.DataType checkDataType(final UserDefFunctionCall fcall) {
    try {
      FunctionDefinition _function = fcall.getFunction();
      String _name = _function.getName();
      boolean _containsKey = TypeInferrer.functionTypes.containsKey(_name);
      if (_containsKey) {
        final EList<Expression> args = fcall.getArgs();
        FunctionDefinition _function_1 = fcall.getFunction();
        String _name_1 = _function_1.getName();
        final HashMap<String, ListaCompilerValidator.DataType> params = TypeInferrer.functionParams.get(_name_1);
        int i = 0;
        FunctionDefinition _function_2 = fcall.getFunction();
        EList<String> _params = _function_2.getParams();
        for (final String current : _params) {
          {
            boolean _containsKey_1 = params.containsKey(current);
            if (_containsKey_1) {
              Expression _get = args.get(i);
              ListaCompilerValidator.DataType _checkDataType = TypeInferrer.checkDataType(_get);
              ListaCompilerValidator.DataType _get_1 = params.get(current);
              boolean _equals = _checkDataType.equals(_get_1);
              boolean _not = (!_equals);
              if (_not) {
                ListaCompilerValidator.DataType _get_2 = params.get(current);
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
  
  public static ListaCompilerValidator.DataType checkDataType(final IfControlFlow ifCF) {
    try {
      Expression _cond = ifCF.getCond();
      final ListaCompilerValidator.DataType cond = TypeInferrer.checkDataType(_cond);
      Expression _iftrue = ifCF.getIftrue();
      final ListaCompilerValidator.DataType iftrue = TypeInferrer.checkDataType(_iftrue);
      Expression _iffalse = ifCF.getIffalse();
      final ListaCompilerValidator.DataType iffalse = TypeInferrer.checkDataType(_iffalse);
      boolean _equals = cond.equals(ListaCompilerValidator.DataType.BOOL);
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
  
  public static ListaCompilerValidator.DataType compareEquals(final SecondLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final ListaCompilerValidator.DataType first = TypeInferrer.checkDataType(((ThirdLevelExp) _get));
      EList<EObject> _args_1 = exp.getArgs();
      EObject _get_1 = _args_1.get(1);
      final ListaCompilerValidator.DataType second = TypeInferrer.checkDataType(((SecondLevelExp) _get_1));
      boolean _equals = first.equals(second);
      if (_equals) {
        return ListaCompilerValidator.DataType.BOOL;
      }
      String _name = SecondLevelOp.EQ.getName();
      String _plus = ("The two arguments being compared with " + _name);
      String _plus_1 = (_plus + " should have the same type.");
      throw new MismatchedTypeException(_plus_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static MyVariable getVariable(final FirstLevelExp exp) {
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
  
  public static MyVariable getVariable(final SecondLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    EList<EObject> _args_1 = ((ThirdLevelExp) _get).getArgs();
    EObject _get_1 = _args_1.get(0);
    EList<EObject> _args_2 = ((FourthLevelExp) _get_1).getArgs();
    EObject _get_2 = _args_2.get(0);
    return TypeInferrer.getVariable(((Term) _get_2));
  }
  
  public static MyVariable getVariable(final ThirdLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    EList<EObject> _args_1 = ((FourthLevelExp) _get).getArgs();
    EObject _get_1 = _args_1.get(0);
    return TypeInferrer.getVariable(((Term) _get_1));
  }
  
  public static MyVariable getVariable(final FourthLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    return TypeInferrer.getVariable(((Term) _get));
  }
  
  public static MyVariable getVariable(final Term term) {
    if ((term instanceof MyVariable)) {
      return ((MyVariable) term);
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
  
  public static ListaCompilerValidator.DataType getDataType(final MyVariable variable) {
    boolean _equals = TypeInferrer.currentFunction.equals("");
    boolean _not = (!_equals);
    if (_not) {
      HashMap<String, ListaCompilerValidator.DataType> _get = TypeInferrer.functionParams.get(TypeInferrer.currentFunction);
      String _var = variable.getVar();
      boolean _containsKey = _get.containsKey(_var);
      if (_containsKey) {
        HashMap<String, ListaCompilerValidator.DataType> _get_1 = TypeInferrer.functionParams.get(TypeInferrer.currentFunction);
        String _var_1 = variable.getVar();
        return _get_1.get(_var_1);
      }
    }
    return ListaCompilerValidator.DataType.VAR;
  }
  
  public static void setFunctionType(final String name, final ListaCompilerValidator.DataType type) {
    boolean _containsKey = TypeInferrer.functionTypes.containsKey(name);
    if (_containsKey) {
      ListaCompilerValidator.DataType _get = TypeInferrer.functionTypes.get(name);
      boolean _equals = _get.equals(ListaCompilerValidator.DataType.VAR);
      if (_equals) {
        TypeInferrer.functionTypes.put(name, type);
      }
    } else {
      TypeInferrer.functionTypes.put(name, type);
    }
  }
  
  public static String getFunctionString(final FunctionDefinition fd) {
    final String name = fd.getName();
    ListaCompilerValidator.DataType _get = TypeInferrer.functionTypes.get(name);
    String res = ((name + "->") + _get);
    HashMap<String, ListaCompilerValidator.DataType> _get_1 = TypeInferrer.functionParams.get(name);
    Set<String> _keySet = _get_1.keySet();
    for (final String cur : _keySet) {
      String _res = res;
      HashMap<String, ListaCompilerValidator.DataType> _get_2 = TypeInferrer.functionParams.get(name);
      ListaCompilerValidator.DataType _get_3 = _get_2.get(cur);
      String _plus = ((("\n" + cur) + ":") + _get_3);
      res = (_res + _plus);
    }
    return res;
  }
  
  public static HashMap<String, ListaCompilerValidator.DataType> getFunctionTypes() {
    return TypeInferrer.functionTypes;
  }
  
  public static HashMap<String, HashMap<String, ListaCompilerValidator.DataType>> getFunctionParams() {
    return TypeInferrer.functionParams;
  }
}
