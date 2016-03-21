/**
 * generated by Xtext
 */
package edu.upb.compilacion.validation;

import edu.upb.compilacion.HugeException;
import edu.upb.compilacion.MismatchedTypeException;
import edu.upb.compilacion.TypeInferrer;
import edu.upb.compilacion.listaCompiler.Evaluation;
import edu.upb.compilacion.listaCompiler.Expression;
import edu.upb.compilacion.listaCompiler.FunctionDefinition;
import edu.upb.compilacion.listaCompiler.Lista;
import edu.upb.compilacion.listaCompiler.ListaCompilerPackage;
import edu.upb.compilacion.listaCompiler.MyVariable;
import edu.upb.compilacion.listaCompiler.PDFunction;
import edu.upb.compilacion.listaCompiler.PreDefFunctionCall;
import edu.upb.compilacion.listaCompiler.UserDefFunctionCall;
import edu.upb.compilacion.validation.AbstractListaCompilerValidator;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class ListaCompilerValidator extends AbstractListaCompilerValidator {
  private final static String WRONG_PARAMETERS_NUMBER = "wrongParametersNumber";
  
  private final static String WRONG_EXPRESSION_TYPE = "wrongExpressionType";
  
  private final static String INVALID_FUNCTION_DECLARATION = "invalidFunctionDeclaration";
  
  private final static String UNUSED_VARIABLE = "unusedVariable";
  
  /**
   * Checks that a function definition doesn't have the same name as a predefined function.
   */
  @Check
  public void checkFunctionDefinitionsPreDefNames(final Lista lista) {
    EList<FunctionDefinition> _definitions = lista.getDefinitions();
    for (final FunctionDefinition fd : _definitions) {
      PDFunction[] _values = PDFunction.values();
      int _length = _values.length;
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length, true);
      for (final Integer i : _doubleDotLessThan) {
        PDFunction _get = PDFunction.get((i).intValue());
        String _name = _get.getName();
        String _name_1 = fd.getName();
        boolean _equals = _name.equals(_name_1);
        if (_equals) {
          String _name_2 = fd.getName();
          String _plus = ("The method \'" + _name_2);
          String _plus_1 = (_plus + "\' is a predefined Lista method.");
          this.error(_plus_1, 
            ListaCompilerPackage.Literals.LISTA__DEFINITIONS, 
            ListaCompilerValidator.INVALID_FUNCTION_DECLARATION);
        }
      }
    }
  }
  
  /**
   * Checks that a function definition doesn't have the same name as an already defined function.
   */
  @Check
  public void checkFunctionDefinitionsNames(final Lista lista) {
    final EList<FunctionDefinition> definitions = lista.getDefinitions();
    String curName = "";
    int _length = ((Object[])Conversions.unwrapArray(definitions, Object.class)).length;
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(1, _length, true);
    for (final Integer cur : _doubleDotLessThan) {
      {
        FunctionDefinition _get = definitions.get((cur).intValue());
        String _name = _get.getName();
        curName = _name;
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, (cur).intValue(), true);
        for (final Integer i : _doubleDotLessThan_1) {
          FunctionDefinition _get_1 = definitions.get((i).intValue());
          String _name_1 = _get_1.getName();
          boolean _equals = _name_1.equals(curName);
          if (_equals) {
            this.error((("The method named \'" + curName) + "\' can only be declared once."), 
              ListaCompilerPackage.Literals.LISTA__DEFINITIONS, 
              ListaCompilerValidator.INVALID_FUNCTION_DECLARATION);
          }
        }
      }
    }
  }
  
  /**
   * Checks that a parameters isn't declared more than one time.
   */
  @Check
  public void checkFunctionDefinitionsParameters(final FunctionDefinition fd) {
    String curName = "";
    EList<MyVariable> _params = fd.getParams();
    int _length = ((Object[])Conversions.unwrapArray(_params, Object.class)).length;
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(1, _length, true);
    for (final Integer cur : _doubleDotLessThan) {
      {
        EList<MyVariable> _params_1 = fd.getParams();
        MyVariable _get = _params_1.get((cur).intValue());
        String _variable = TypeInferrer.getVariable(_get);
        curName = _variable;
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, (cur).intValue(), true);
        for (final Integer i : _doubleDotLessThan_1) {
          EList<MyVariable> _params_2 = fd.getParams();
          MyVariable _get_1 = _params_2.get((i).intValue());
          String _variable_1 = TypeInferrer.getVariable(_get_1);
          boolean _equals = _variable_1.equals(curName);
          if (_equals) {
            this.error((("The parameter \'" + curName) + "\' can only be declared once."), 
              ListaCompilerPackage.Literals.FUNCTION_DEFINITION__PARAMS, 
              ListaCompilerValidator.INVALID_FUNCTION_DECLARATION);
          }
        }
      }
    }
  }
  
  /**
   * Checks the number of parameters for a user defined function.
   */
  @Check
  public void checkUserDefParametersNumber(final UserDefFunctionCall fcall) {
    FunctionDefinition _function = fcall.getFunction();
    EList<MyVariable> _params = _function.getParams();
    final int params = ((Object[])Conversions.unwrapArray(_params, Object.class)).length;
    EList<Expression> _args = fcall.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args, Object.class)).length;
    boolean _notEquals = (_length != params);
    if (_notEquals) {
      this.error(("Wrong number of parameters, should be " + Integer.valueOf(params)), 
        ListaCompilerPackage.Literals.FUNCTION_CALL__ARGS, 
        ListaCompilerValidator.WRONG_PARAMETERS_NUMBER);
    }
  }
  
  /**
   * Checks the number of parameters for a predefined function.
   */
  @Check
  public void checkPreDefParametersNumber(final PreDefFunctionCall fcall) {
    final PDFunction function = fcall.getFunction();
    int params = 0;
    if (function != null) {
      switch (function) {
        case SHOW:
        case LENGTH:
        case CAR:
        case CDR:
        case IS_EMPTY:
          params = 1;
          break;
        case CONS:
          params = 2;
          break;
        default:
          String _literal = function.getLiteral();
          String _plus = ("Undeclared function " + _literal);
          this.error(_plus, 
            ListaCompilerPackage.Literals.FUNCTION_CALL__ARGS, 
            ListaCompilerValidator.INVALID_FUNCTION_DECLARATION);
          break;
      }
    } else {
      String _literal = function.getLiteral();
      String _plus = ("Undeclared function " + _literal);
      this.error(_plus, 
        ListaCompilerPackage.Literals.FUNCTION_CALL__ARGS, 
        ListaCompilerValidator.INVALID_FUNCTION_DECLARATION);
    }
    EList<Expression> _args = fcall.getArgs();
    int _length = ((Object[])Conversions.unwrapArray(_args, Object.class)).length;
    boolean _notEquals = (_length != params);
    if (_notEquals) {
      this.error(("Wrong number of parameters, should be " + Integer.valueOf(1)), 
        ListaCompilerPackage.Literals.FUNCTION_CALL__ARGS, 
        ListaCompilerValidator.WRONG_PARAMETERS_NUMBER);
    }
  }
  
  /**
   * Infers and checks the return expression type of a FunctionDefinition, verifies that it
   * satisfy all the expression checks inside TypeInferrer. The infer is done twice because
   * in the first one there is a chance that all the variables doesn't infer correctly
   * because they may need other variables' types as a pointer to infer it's type.
   * If there is an exception, shows an error with the exception message.
   */
  @Check
  public String checkFunctionDefinitionType(final FunctionDefinition fd) {
    String _xblockexpression = null;
    {
      TypeInferrer.removeFunctionInfo(fd);
      TypeInferrer.inferDataType(fd);
      TypeInferrer.inferDataType(fd);
      this.checkFunctionDefinitionParams(fd);
      try {
        Expression _return = fd.getReturn();
        TypeInferrer.checkDataType(_return);
      } catch (final Throwable _t) {
        if (_t instanceof MismatchedTypeException) {
          final MismatchedTypeException ex = (MismatchedTypeException)_t;
          String _message = ex.getMessage();
          this.error(_message, 
            ListaCompilerPackage.Literals.FUNCTION_DEFINITION__RETURN, 
            ListaCompilerValidator.WRONG_EXPRESSION_TYPE);
        } else if (_t instanceof HugeException) {
          final HugeException ex_1 = (HugeException)_t;
          String _message_1 = ex_1.getMessage();
          this.error(_message_1, 
            ListaCompilerPackage.Literals.FUNCTION_DEFINITION__RETURN, 
            ListaCompilerValidator.WRONG_EXPRESSION_TYPE);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = TypeInferrer.resetCurrentFunction();
    }
    return _xblockexpression;
  }
  
  /**
   * Checks the usage of a FunctionDefinition parameters, if there is an unused variable,
   * it shows a warning, if there is a variable that it's not declared it shows an error.
   */
  public void checkFunctionDefinitionParams(final FunctionDefinition fd) {
    EList<MyVariable> _params = fd.getParams();
    for (final MyVariable param : _params) {
      HashMap<String, HashMap<String, TypeInferrer.DataType>> _functionParams = TypeInferrer.getFunctionParams();
      String _name = fd.getName();
      HashMap<String, TypeInferrer.DataType> _get = _functionParams.get(_name);
      String _variable = TypeInferrer.getVariable(param);
      boolean _containsKey = _get.containsKey(_variable);
      boolean _not = (!_containsKey);
      if (_not) {
        String _variable_1 = TypeInferrer.getVariable(param);
        String _plus = ("Variable " + _variable_1);
        String _plus_1 = (_plus + " is not used.");
        this.warning(_plus_1, 
          ListaCompilerPackage.Literals.FUNCTION_DEFINITION__PARAMS, 
          ListaCompilerValidator.UNUSED_VARIABLE);
      }
    }
    HashMap<String, HashMap<String, TypeInferrer.DataType>> _functionParams_1 = TypeInferrer.getFunctionParams();
    String _name_1 = fd.getName();
    HashMap<String, TypeInferrer.DataType> _get_1 = _functionParams_1.get(_name_1);
    Set<String> _keySet = _get_1.keySet();
    for (final String param_1 : _keySet) {
      boolean _fdContainsParam = this.fdContainsParam(fd, param_1);
      boolean _not_1 = (!_fdContainsParam);
      if (_not_1) {
        this.error((("Variable " + param_1) + " is not declared, should be added to the function\'s parameters."), 
          ListaCompilerPackage.Literals.FUNCTION_DEFINITION__PARAMS, 
          ListaCompilerValidator.INVALID_FUNCTION_DECLARATION);
      }
    }
  }
  
  /**
   * Verifies that a FunctionDefinition contains a given parameter.
   */
  public boolean fdContainsParam(final FunctionDefinition fd, final String name) {
    EList<MyVariable> _params = fd.getParams();
    for (final MyVariable param : _params) {
      String _variable = TypeInferrer.getVariable(param);
      boolean _equals = _variable.equals(name);
      if (_equals) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Checks an Evaluation return expression type and verifies that it
   * satisfy all the expression checks inside TypeInferrer.
   */
  @Check
  public TypeInferrer.DataType checkFunctionEvaluationType(final Evaluation eval) {
    TypeInferrer.DataType _xtrycatchfinallyexpression = null;
    try {
      Expression _return = eval.getReturn();
      _xtrycatchfinallyexpression = TypeInferrer.checkDataType(_return);
    } catch (final Throwable _t) {
      if (_t instanceof MismatchedTypeException) {
        final MismatchedTypeException ex = (MismatchedTypeException)_t;
        String _message = ex.getMessage();
        this.error(_message, 
          ListaCompilerPackage.Literals.EVALUATION__RETURN, 
          ListaCompilerValidator.WRONG_EXPRESSION_TYPE);
      } else if (_t instanceof HugeException) {
        final HugeException ex_1 = (HugeException)_t;
        String _message_1 = ex_1.getMessage();
        this.error(_message_1, 
          ListaCompilerPackage.Literals.EVALUATION__RETURN, 
          ListaCompilerValidator.WRONG_EXPRESSION_TYPE);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
