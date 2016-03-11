/**
 * generated by Xtext
 */
package edu.upb.compilacion.validation;

import edu.upb.compilacion.listaCompiler.Expression;
import edu.upb.compilacion.listaCompiler.FunctionCall;
import edu.upb.compilacion.listaCompiler.FunctionDefinition;
import edu.upb.compilacion.listaCompiler.ListaCompilerPackage;
import edu.upb.compilacion.validation.AbstractListaCompilerValidator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class ListaCompilerValidator extends AbstractListaCompilerValidator {
  @Check
  public Object checkParametersNumber(final FunctionCall fcall) {
    Object _xblockexpression = null;
    {
      final EObject function = fcall.getFunction();
      Object _xifexpression = null;
      if ((function instanceof FunctionDefinition)) {
        EList<String> _params = ((FunctionDefinition) function).getParams();
        final int paramsize = ((Object[])Conversions.unwrapArray(_params, Object.class)).length;
        EList<Expression> _args = fcall.getArgs();
        int _length = ((Object[])Conversions.unwrapArray(_args, Object.class)).length;
        boolean _notEquals = (_length != paramsize);
        if (_notEquals) {
          this.error(("Wrong number of parameters, should be " + Integer.valueOf(paramsize)), 
            ListaCompilerPackage.Literals.FUNCTION_CALL__ARGS, 
            "wrongParametersNumber");
        }
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
