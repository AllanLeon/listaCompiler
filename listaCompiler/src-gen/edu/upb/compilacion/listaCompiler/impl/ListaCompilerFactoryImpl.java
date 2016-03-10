/**
 */
package edu.upb.compilacion.listaCompiler.impl;

import edu.upb.compilacion.listaCompiler.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ListaCompilerFactoryImpl extends EFactoryImpl implements ListaCompilerFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ListaCompilerFactory init()
  {
    try
    {
      ListaCompilerFactory theListaCompilerFactory = (ListaCompilerFactory)EPackage.Registry.INSTANCE.getEFactory(ListaCompilerPackage.eNS_URI);
      if (theListaCompilerFactory != null)
      {
        return theListaCompilerFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ListaCompilerFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListaCompilerFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ListaCompilerPackage.LISTA: return createLista();
      case ListaCompilerPackage.EVALUATION: return createEvaluation();
      case ListaCompilerPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case ListaCompilerPackage.EXPRESSION: return createExpression();
      case ListaCompilerPackage.TERM: return createTerm();
      case ListaCompilerPackage.CONTROL_FLOW: return createControlFlow();
      case ListaCompilerPackage.FUNCTION_CALL: return createFunctionCall();
      case ListaCompilerPackage.DATA_TYPE: return createDataType();
      case ListaCompilerPackage.INT_LIST: return createIntList();
      case ListaCompilerPackage.PRE_DEF_FUNCTION: return createPreDefFunction();
      case ListaCompilerPackage.OPERATOR: return createOperator();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Lista createLista()
  {
    ListaImpl lista = new ListaImpl();
    return lista;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Evaluation createEvaluation()
  {
    EvaluationImpl evaluation = new EvaluationImpl();
    return evaluation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition createFunctionDefinition()
  {
    FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term createTerm()
  {
    TermImpl term = new TermImpl();
    return term;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ControlFlow createControlFlow()
  {
    ControlFlowImpl controlFlow = new ControlFlowImpl();
    return controlFlow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionCall createFunctionCall()
  {
    FunctionCallImpl functionCall = new FunctionCallImpl();
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntList createIntList()
  {
    IntListImpl intList = new IntListImpl();
    return intList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreDefFunction createPreDefFunction()
  {
    PreDefFunctionImpl preDefFunction = new PreDefFunctionImpl();
    return preDefFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operator createOperator()
  {
    OperatorImpl operator = new OperatorImpl();
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListaCompilerPackage getListaCompilerPackage()
  {
    return (ListaCompilerPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ListaCompilerPackage getPackage()
  {
    return ListaCompilerPackage.eINSTANCE;
  }

} //ListaCompilerFactoryImpl
