package edu.upb.compilacion;

import edu.upb.compilacion.HugeException;
import edu.upb.compilacion.MismatchedTypeException;
import edu.upb.compilacion.TypeInferrer;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TypeInferrer2 {
  private HashMap<String, HashMap<String, TypeInferrer.DataType>> functionParams = new HashMap<String, HashMap<String, TypeInferrer.DataType>>();
  
  private HashMap<String, TypeInferrer.DataType> functionTypes = new HashMap<String, TypeInferrer.DataType>();
  
  private String currentFunction = "";
  
  public TypeInferrer2() {
    HashMap<String, HashMap<String, TypeInferrer.DataType>> _hashMap = new HashMap<String, HashMap<String, TypeInferrer.DataType>>();
    this.functionParams = _hashMap;
    HashMap<String, TypeInferrer.DataType> _hashMap_1 = new HashMap<String, TypeInferrer.DataType>();
    this.functionTypes = _hashMap_1;
  }
  
  public String resetFunction() {
    return this.currentFunction = "";
  }
  
  public void inferDataType(final FunctionDefinition fd) {
    String _name = fd.getName();
    this.currentFunction = _name;
    String _name_1 = fd.getName();
    HashMap<String, TypeInferrer.DataType> _hashMap = new HashMap<String, TypeInferrer.DataType>();
    this.functionParams.put(_name_1, _hashMap);
    Expression _return = fd.getReturn();
    FirstLevelExp _exp = _return.getExp();
    String _name_2 = fd.getName();
    this.inferDataType(_exp, _name_2);
  }
  
  public void inferDataType(final FirstLevelExp exp, final String fdName) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final SecondLevelExp first = ((SecondLevelExp) _get);
    final TypeInferrer.DataType firstType = this.getDataType(first);
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
      this.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final FirstLevelExp second = ((FirstLevelExp) _get_1);
      final TypeInferrer.DataType secondType = this.getDataType(second);
      boolean _equals = firstType.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        final MyVariable var1 = this.getVariable(first);
        HashMap<String, TypeInferrer.DataType> _get_2 = this.functionParams.get(fdName);
        String _var = var1.getVar();
        _get_2.put(_var, expected);
      } else {
        this.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(TypeInferrer.DataType.VAR);
      if (_equals_1) {
        final MyVariable var2 = this.getVariable(second);
        HashMap<String, TypeInferrer.DataType> _get_3 = this.functionParams.get(fdName);
        String _var_1 = var2.getVar();
        _get_3.put(_var_1, expected);
      } else {
        this.inferDataType(second, fdName);
      }
    } else {
      this.inferDataType(first, fdName);
    }
  }
  
  public void inferDataType(final SecondLevelExp exp, final String fdName) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final ThirdLevelExp first = ((ThirdLevelExp) _get);
    final TypeInferrer.DataType firstType = this.getDataType(first);
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
      this.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final SecondLevelExp second = ((SecondLevelExp) _get_1);
      final TypeInferrer.DataType secondType = this.getDataType(second);
      boolean _equals = firstType.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        final MyVariable var1 = this.getVariable(first);
        HashMap<String, TypeInferrer.DataType> _get_2 = this.functionParams.get(fdName);
        String _var = var1.getVar();
        _get_2.put(_var, expected);
      } else {
        this.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(TypeInferrer.DataType.VAR);
      if (_equals_1) {
        final MyVariable var2 = this.getVariable(second);
        HashMap<String, TypeInferrer.DataType> _get_3 = this.functionParams.get(fdName);
        String _var_1 = var2.getVar();
        _get_3.put(_var_1, expected);
      } else {
        this.inferDataType(second, fdName);
      }
    } else {
      this.inferDataType(first, fdName);
    }
  }
  
  public void inferDataType(final ThirdLevelExp exp, final String fdName) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final FourthLevelExp first = ((FourthLevelExp) _get);
    final TypeInferrer.DataType firstType = this.getDataType(first);
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
      this.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final ThirdLevelExp second = ((ThirdLevelExp) _get_1);
      final TypeInferrer.DataType secondType = this.getDataType(second);
      boolean _equals = firstType.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        final MyVariable var1 = this.getVariable(first);
        HashMap<String, TypeInferrer.DataType> _get_2 = this.functionParams.get(fdName);
        String _var = var1.getVar();
        _get_2.put(_var, expected);
      } else {
        this.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(TypeInferrer.DataType.VAR);
      if (_equals_1) {
        final MyVariable var2 = this.getVariable(second);
        HashMap<String, TypeInferrer.DataType> _get_3 = this.functionParams.get(fdName);
        String _var_1 = var2.getVar();
        _get_3.put(_var_1, expected);
      } else {
        this.inferDataType(second, fdName);
      }
    } else {
      this.inferDataType(first, fdName);
    }
  }
  
  public void inferDataType(final FourthLevelExp exp, final String fdName) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final Term first = ((Term) _get);
    final TypeInferrer.DataType firstType = this.getDataType(first);
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      TypeInferrer.DataType expected = TypeInferrer.DataType.INT;
      this.setFunctionType(fdName, expected);
      EList<EObject> _args_2 = exp.getArgs();
      EObject _get_1 = _args_2.get(1);
      final FourthLevelExp second = ((FourthLevelExp) _get_1);
      final TypeInferrer.DataType secondType = this.getDataType(second);
      boolean _equals = firstType.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        final MyVariable var1 = ((MyVariable) first);
        HashMap<String, TypeInferrer.DataType> _get_2 = this.functionParams.get(fdName);
        String _var = var1.getVar();
        _get_2.put(_var, expected);
      } else {
        this.inferDataType(first, fdName);
      }
      boolean _equals_1 = secondType.equals(TypeInferrer.DataType.VAR);
      if (_equals_1) {
        final MyVariable var2 = this.getVariable(second);
        HashMap<String, TypeInferrer.DataType> _get_3 = this.functionParams.get(fdName);
        String _var_1 = var2.getVar();
        _get_3.put(_var_1, expected);
      } else {
        this.inferDataType(second, fdName);
      }
    } else {
      this.inferDataType(first, fdName);
    }
  }
  
  public void inferDataType(final Term term, final String fdName) {
    if ((term instanceof MyInteger)) {
      this.inferDataType(((MyInteger) term), fdName);
    } else {
      if ((term instanceof MyString)) {
        this.setFunctionType(fdName, TypeInferrer.DataType.STRING);
      } else {
        if ((term instanceof MyBool)) {
          this.inferDataType(((MyBool) term), fdName);
        } else {
          if ((term instanceof List)) {
            this.setFunctionType(fdName, TypeInferrer.DataType.LIST);
          } else {
            if ((term instanceof MyVariable)) {
              this.setFunctionType(fdName, TypeInferrer.DataType.VAR);
            } else {
              if ((term instanceof FunctionCall)) {
                this.inferDataType(((FunctionCall) term), fdName);
              } else {
                if ((term instanceof IfControlFlow)) {
                  Expression _iftrue = ((IfControlFlow) term).getIftrue();
                  FirstLevelExp _exp = _iftrue.getExp();
                  this.inferDataType(_exp, fdName);
                  Expression _iffalse = ((IfControlFlow) term).getIffalse();
                  FirstLevelExp _exp_1 = _iffalse.getExp();
                  this.inferDataType(_exp_1, fdName);
                  Expression _cond = ((IfControlFlow) term).getCond();
                  FirstLevelExp _exp_2 = _cond.getExp();
                  this.inferDataType(_exp_2, fdName);
                } else {
                  if ((term instanceof BracketExpression)) {
                    Expression _exp_3 = ((BracketExpression) term).getExp();
                    FirstLevelExp _exp_4 = _exp_3.getExp();
                    this.inferDataType(_exp_4, fdName);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void inferDataType(final MyInteger myInt, final String fdName) {
    this.setFunctionType(fdName, TypeInferrer.DataType.INT);
    if ((myInt instanceof NegInteger)) {
      final Term exp = ((NegInteger) myInt).getVal();
      if ((exp instanceof BracketExpression)) {
        Expression _exp = ((BracketExpression) exp).getExp();
        FirstLevelExp _exp_1 = _exp.getExp();
        this.inferDataType(_exp_1, fdName);
      }
    }
  }
  
  public void inferDataType(final MyBool myBool, final String fdName) {
    this.setFunctionType(fdName, TypeInferrer.DataType.BOOL);
    if ((myBool instanceof NegBool)) {
      final Term exp = ((NegBool) myBool).getVal();
      if ((exp instanceof BracketExpression)) {
        Expression _exp = ((BracketExpression) exp).getExp();
        FirstLevelExp _exp_1 = _exp.getExp();
        this.inferDataType(_exp_1, fdName);
      }
    }
  }
  
  public void inferDataType(final FunctionCall fcall, final String fdName) {
    if ((fcall instanceof PreDefFunctionCall)) {
      this.inferDataType(((PreDefFunctionCall) fcall), fdName);
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        this.inferDataType(((UserDefFunctionCall) fcall), fdName);
      }
    }
  }
  
  public void inferDataType(final PreDefFunctionCall fcall, final String fdName) {
    PDFunction _function = fcall.getFunction();
    if (_function != null) {
      switch (_function) {
        case SHOW:
          this.setFunctionType(fdName, TypeInferrer.DataType.STRING);
          break;
        case LENGTH:
        case CAR:
          this.setFunctionType(fdName, TypeInferrer.DataType.INT);
          break;
        case CDR:
        case CONS:
          this.setFunctionType(fdName, TypeInferrer.DataType.LIST);
          break;
        case IS_EMPTY:
          this.setFunctionType(fdName, TypeInferrer.DataType.BOOL);
          break;
        default:
          break;
      }
    }
    EList<Expression> _args = fcall.getArgs();
    for (final Expression exp : _args) {
      FirstLevelExp _exp = exp.getExp();
      this.inferDataType(_exp, fdName);
    }
  }
  
  public void inferDataType(final UserDefFunctionCall fcall, final String fdName) {
    FunctionDefinition _function = fcall.getFunction();
    String _name = _function.getName();
    boolean _containsKey = this.functionTypes.containsKey(_name);
    if (_containsKey) {
      FunctionDefinition _function_1 = fcall.getFunction();
      String _name_1 = _function_1.getName();
      TypeInferrer.DataType _get = this.functionTypes.get(_name_1);
      this.setFunctionType(fdName, _get);
    } else {
      this.setFunctionType(fdName, TypeInferrer.DataType.VAR);
    }
    EList<Expression> _args = fcall.getArgs();
    for (final Expression exp : _args) {
      FirstLevelExp _exp = exp.getExp();
      this.inferDataType(_exp, fdName);
    }
  }
  
  /**
   * def inferDataType(IfControlFlow ifCF, String fdName) {
   * return ifCF.iftrue.getDataType;
   * }
   */
  public TypeInferrer.DataType getDataType(final Expression exp) {
    FirstLevelExp _exp = exp.getExp();
    return this.getDataType(_exp);
  }
  
  public TypeInferrer.DataType getDataType(final FirstLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final TypeInferrer.DataType first = this.getDataType(((SecondLevelExp) _get));
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
  
  public TypeInferrer.DataType getDataType(final SecondLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final TypeInferrer.DataType first = this.getDataType(((ThirdLevelExp) _get));
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
  
  public TypeInferrer.DataType getDataType(final ThirdLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final TypeInferrer.DataType first = this.getDataType(((FourthLevelExp) _get));
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
  
  public TypeInferrer.DataType getDataType(final FourthLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    final TypeInferrer.DataType first = this.getDataType(((Term) _get));
    EList<EObject> _args_1 = exp.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args_1, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      return TypeInferrer.DataType.INT;
    } else {
      return first;
    }
  }
  
  public TypeInferrer.DataType getDataType(final Term term) {
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
              return this.getDataType(((MyVariable) term));
            } else {
              if ((term instanceof FunctionCall)) {
                return this.getDataType(((FunctionCall) term));
              } else {
                if ((term instanceof IfControlFlow)) {
                  return this.getDataType(((IfControlFlow) term));
                } else {
                  if ((term instanceof BracketExpression)) {
                    Expression _exp = ((BracketExpression) term).getExp();
                    return this.getDataType(_exp);
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
  
  public TypeInferrer.DataType getDataType(final FunctionCall fcall) {
    if ((fcall instanceof PreDefFunctionCall)) {
      return this.getDataType(((PreDefFunctionCall) fcall));
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        return this.getDataType(((UserDefFunctionCall) fcall));
      }
    }
    return null;
  }
  
  public TypeInferrer.DataType getDataType(final PreDefFunctionCall fcall) {
    PDFunction _function = fcall.getFunction();
    if (_function != null) {
      switch (_function) {
        case SHOW:
          return TypeInferrer.DataType.STRING;
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
  
  public TypeInferrer.DataType getDataType(final UserDefFunctionCall fcall) {
    FunctionDefinition _function = fcall.getFunction();
    String _name = _function.getName();
    boolean _containsKey = this.functionTypes.containsKey(_name);
    if (_containsKey) {
      FunctionDefinition _function_1 = fcall.getFunction();
      String _name_1 = _function_1.getName();
      return this.functionTypes.get(_name_1);
    } else {
      FunctionDefinition _function_2 = fcall.getFunction();
      Expression _return = _function_2.getReturn();
      return this.getDataType(_return);
    }
  }
  
  public TypeInferrer.DataType getDataType(final IfControlFlow ifCF) {
    Expression _iftrue = ifCF.getIftrue();
    return this.getDataType(_iftrue);
  }
  
  public TypeInferrer.DataType checkDataType(final Expression exp) {
    FirstLevelExp _exp = exp.getExp();
    return this.checkDataType(_exp);
  }
  
  public TypeInferrer.DataType checkDataType(final FirstLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = this.checkDataType(((SecondLevelExp) _get));
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
          TypeInferrer.DataType _checkDataType = this.checkDataType(((FirstLevelExp) _get_1));
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
  
  public TypeInferrer.DataType checkDataType(final SecondLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = this.checkDataType(((ThirdLevelExp) _get));
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
              return this.compareEquals(exp);
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
          TypeInferrer.DataType _checkDataType = this.checkDataType(((SecondLevelExp) _get_1));
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
  
  public TypeInferrer.DataType checkDataType(final ThirdLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = this.checkDataType(((FourthLevelExp) _get));
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
        boolean _and = false;
        boolean _equals = first.equals(expected);
        if (!_equals) {
          _and = false;
        } else {
          EList<EObject> _args_2 = exp.getArgs();
          EObject _get_1 = _args_2.get(1);
          TypeInferrer.DataType _checkDataType = this.checkDataType(((ThirdLevelExp) _get_1));
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
  
  public TypeInferrer.DataType checkDataType(final FourthLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = this.checkDataType(((Term) _get));
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
          TypeInferrer.DataType _checkDataType = this.checkDataType(((FourthLevelExp) _get_1));
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
  
  public TypeInferrer.DataType checkDataType(final Term term) {
    if ((term instanceof MyInteger)) {
      return this.checkDataType(((MyInteger) term));
    } else {
      if ((term instanceof MyString)) {
        return TypeInferrer.DataType.STRING;
      } else {
        if ((term instanceof MyBool)) {
          return this.checkDataType(((MyBool) term));
        } else {
          if ((term instanceof List)) {
            return TypeInferrer.DataType.LIST;
          } else {
            if ((term instanceof MyVariable)) {
              return this.getDataType(((MyVariable) term));
            } else {
              if ((term instanceof FunctionCall)) {
                return this.checkDataType(((FunctionCall) term));
              } else {
                if ((term instanceof IfControlFlow)) {
                  return this.checkDataType(((IfControlFlow) term));
                } else {
                  if ((term instanceof BracketExpression)) {
                    Expression _exp = ((BracketExpression) term).getExp();
                    return this.checkDataType(_exp);
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
  
  public TypeInferrer.DataType checkDataType(final MyInteger myInt) {
    try {
      if ((myInt instanceof NegInteger)) {
        final Term exp = ((NegInteger) myInt).getVal();
        if ((exp instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) exp).getExp();
          final TypeInferrer.DataType expType = this.checkDataType(_exp);
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
  
  public TypeInferrer.DataType checkDataType(final MyBool myBool) {
    try {
      if ((myBool instanceof NegBool)) {
        final Term exp = ((NegBool) myBool).getVal();
        if ((exp instanceof BracketExpression)) {
          Expression _exp = ((BracketExpression) exp).getExp();
          final TypeInferrer.DataType expType = this.checkDataType(_exp);
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
  
  public TypeInferrer.DataType checkDataType(final FunctionCall fcall) {
    if ((fcall instanceof PreDefFunctionCall)) {
      return this.checkDataType(((PreDefFunctionCall) fcall));
    } else {
      if ((fcall instanceof UserDefFunctionCall)) {
        return this.checkDataType(((UserDefFunctionCall) fcall));
      }
    }
    return null;
  }
  
  public TypeInferrer.DataType checkDataType(final PreDefFunctionCall fcall) {
    try {
      TypeInferrer.DataType expected = TypeInferrer.DataType.GLOBAL;
      ArrayList<TypeInferrer.DataType> paramsTypes = new ArrayList<TypeInferrer.DataType>();
      PDFunction _function = fcall.getFunction();
      if (_function != null) {
        switch (_function) {
          case SHOW:
            expected = TypeInferrer.DataType.STRING;
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
            TypeInferrer.DataType _checkDataType = this.checkDataType(exp);
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
  
  public TypeInferrer.DataType checkDataType(final UserDefFunctionCall fcall) {
    try {
      FunctionDefinition _function = fcall.getFunction();
      String _name = _function.getName();
      boolean _containsKey = this.functionTypes.containsKey(_name);
      if (_containsKey) {
        final EList<Expression> args = fcall.getArgs();
        FunctionDefinition _function_1 = fcall.getFunction();
        String _name_1 = _function_1.getName();
        final HashMap<String, TypeInferrer.DataType> params = this.functionParams.get(_name_1);
        int i = 0;
        FunctionDefinition _function_2 = fcall.getFunction();
        EList<String> _params = _function_2.getParams();
        for (final String current : _params) {
          {
            boolean _containsKey_1 = params.containsKey(current);
            if (_containsKey_1) {
              Expression _get = args.get(i);
              TypeInferrer.DataType _checkDataType = this.checkDataType(_get);
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
        return this.functionTypes.get(_name_2);
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
  
  public TypeInferrer.DataType checkDataType(final IfControlFlow ifCF) {
    try {
      Expression _cond = ifCF.getCond();
      final TypeInferrer.DataType cond = this.checkDataType(_cond);
      Expression _iftrue = ifCF.getIftrue();
      final TypeInferrer.DataType iftrue = this.checkDataType(_iftrue);
      Expression _iffalse = ifCF.getIffalse();
      final TypeInferrer.DataType iffalse = this.checkDataType(_iffalse);
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
  
  public TypeInferrer.DataType compareEquals(final SecondLevelExp exp) {
    try {
      EList<EObject> _args = exp.getArgs();
      EObject _get = _args.get(0);
      final TypeInferrer.DataType first = this.checkDataType(((ThirdLevelExp) _get));
      EList<EObject> _args_1 = exp.getArgs();
      EObject _get_1 = _args_1.get(1);
      final TypeInferrer.DataType second = this.checkDataType(((SecondLevelExp) _get_1));
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
  
  public MyVariable getVariable(final FirstLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    EList<EObject> _args_1 = ((SecondLevelExp) _get).getArgs();
    EObject _get_1 = _args_1.get(0);
    EList<EObject> _args_2 = ((ThirdLevelExp) _get_1).getArgs();
    EObject _get_2 = _args_2.get(0);
    EList<EObject> _args_3 = ((FourthLevelExp) _get_2).getArgs();
    EObject _get_3 = _args_3.get(0);
    return this.getVariable(((Term) _get_3));
  }
  
  public MyVariable getVariable(final SecondLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    EList<EObject> _args_1 = ((ThirdLevelExp) _get).getArgs();
    EObject _get_1 = _args_1.get(0);
    EList<EObject> _args_2 = ((FourthLevelExp) _get_1).getArgs();
    EObject _get_2 = _args_2.get(0);
    return this.getVariable(((Term) _get_2));
  }
  
  public MyVariable getVariable(final ThirdLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    EList<EObject> _args_1 = ((FourthLevelExp) _get).getArgs();
    EObject _get_1 = _args_1.get(0);
    return this.getVariable(((Term) _get_1));
  }
  
  public MyVariable getVariable(final FourthLevelExp exp) {
    EList<EObject> _args = exp.getArgs();
    EObject _get = _args.get(0);
    return this.getVariable(((Term) _get));
  }
  
  public MyVariable getVariable(final Term term) {
    if ((term instanceof MyVariable)) {
      return ((MyVariable) term);
    } else {
      if ((term instanceof UserDefFunctionCall)) {
        FunctionDefinition _function = ((UserDefFunctionCall) term).getFunction();
        Expression _return = _function.getReturn();
        FirstLevelExp _exp = _return.getExp();
        return this.getVariable(_exp);
      } else {
        if ((term instanceof IfControlFlow)) {
          Expression _iftrue = ((IfControlFlow) term).getIftrue();
          FirstLevelExp _exp_1 = _iftrue.getExp();
          return this.getVariable(_exp_1);
        } else {
          if ((term instanceof BracketExpression)) {
            Expression _exp_2 = ((BracketExpression) term).getExp();
            FirstLevelExp _exp_3 = _exp_2.getExp();
            return this.getVariable(_exp_3);
          }
        }
      }
    }
    return null;
  }
  
  public TypeInferrer.DataType getDataType(final MyVariable variable) {
    boolean _equals = this.currentFunction.equals("");
    boolean _not = (!_equals);
    if (_not) {
      HashMap<String, TypeInferrer.DataType> _get = this.functionParams.get(this.currentFunction);
      String _var = variable.getVar();
      boolean _containsKey = _get.containsKey(_var);
      if (_containsKey) {
        HashMap<String, TypeInferrer.DataType> _get_1 = this.functionParams.get(this.currentFunction);
        String _var_1 = variable.getVar();
        return _get_1.get(_var_1);
      }
    }
    return TypeInferrer.DataType.VAR;
  }
  
  public void setFunctionType(final String name, final TypeInferrer.DataType type) {
    boolean _containsKey = this.functionTypes.containsKey(name);
    if (_containsKey) {
      TypeInferrer.DataType _get = this.functionTypes.get(name);
      boolean _equals = _get.equals(TypeInferrer.DataType.VAR);
      if (_equals) {
        this.functionTypes.put(name, type);
      }
    } else {
      this.functionTypes.put(name, type);
    }
  }
  
  public String getFunctionString(final FunctionDefinition fd) {
    final String name = fd.getName();
    TypeInferrer.DataType _get = this.functionTypes.get(name);
    String res = ((name + "->") + _get);
    HashMap<String, TypeInferrer.DataType> _get_1 = this.functionParams.get(name);
    Set<String> _keySet = _get_1.keySet();
    for (final String cur : _keySet) {
      String _res = res;
      HashMap<String, TypeInferrer.DataType> _get_2 = this.functionParams.get(name);
      TypeInferrer.DataType _get_3 = _get_2.get(cur);
      String _plus = ((("\n" + cur) + ":") + _get_3);
      res = (_res + _plus);
    }
    return res;
  }
  
  public HashMap<String, TypeInferrer.DataType> getFunctionTypes() {
    return this.functionTypes;
  }
  
  public HashMap<String, HashMap<String, TypeInferrer.DataType>> getFunctionParams() {
    return this.functionParams;
  }
}
