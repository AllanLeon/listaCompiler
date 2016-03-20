/**
 */
package edu.upb.compilacion.listaCompiler.impl;

import edu.upb.compilacion.listaCompiler.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
      case ListaCompilerPackage.FIRST_LEVEL_EXP: return createFirstLevelExp();
      case ListaCompilerPackage.SECOND_LEVEL_EXP: return createSecondLevelExp();
      case ListaCompilerPackage.THIRD_LEVEL_EXP: return createThirdLevelExp();
      case ListaCompilerPackage.FOURTH_LEVEL_EXP: return createFourthLevelExp();
      case ListaCompilerPackage.TERM: return createTerm();
      case ListaCompilerPackage.BRACKET_EXPRESSION: return createBracketExpression();
      case ListaCompilerPackage.MY_INTEGER: return createMyInteger();
      case ListaCompilerPackage.POS_INTEGER: return createPosInteger();
      case ListaCompilerPackage.NEG_INTEGER: return createNegInteger();
      case ListaCompilerPackage.MY_VARIABLE: return createMyVariable();
      case ListaCompilerPackage.VARIABLE: return createVariable();
      case ListaCompilerPackage.CASTED_VARIABLE: return createCastedVariable();
      case ListaCompilerPackage.MY_BOOL: return createMyBool();
      case ListaCompilerPackage.POS_BOOL: return createPosBool();
      case ListaCompilerPackage.NEG_BOOL: return createNegBool();
      case ListaCompilerPackage.MY_STRING: return createMyString();
      case ListaCompilerPackage.IF_CONTROL_FLOW: return createIfControlFlow();
      case ListaCompilerPackage.FUNCTION_CALL: return createFunctionCall();
      case ListaCompilerPackage.PRE_DEF_FUNCTION_CALL: return createPreDefFunctionCall();
      case ListaCompilerPackage.USER_DEF_FUNCTION_CALL: return createUserDefFunctionCall();
      case ListaCompilerPackage.LIST: return createList();
      case ListaCompilerPackage.LIST_ELEM: return createListElem();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ListaCompilerPackage.BOOL:
        return createBoolFromString(eDataType, initialValue);
      case ListaCompilerPackage.PD_FUNCTION:
        return createPDFunctionFromString(eDataType, initialValue);
      case ListaCompilerPackage.FIRST_LEVEL_OP:
        return createFirstLevelOpFromString(eDataType, initialValue);
      case ListaCompilerPackage.SECOND_LEVEL_OP:
        return createSecondLevelOpFromString(eDataType, initialValue);
      case ListaCompilerPackage.THIRD_LEVEL_OP:
        return createThirdLevelOpFromString(eDataType, initialValue);
      case ListaCompilerPackage.FOURTH_LEVEL_OP:
        return createFourthLevelOpFromString(eDataType, initialValue);
      case ListaCompilerPackage.CASTED_TYPE:
        return createCastedTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ListaCompilerPackage.BOOL:
        return convertBoolToString(eDataType, instanceValue);
      case ListaCompilerPackage.PD_FUNCTION:
        return convertPDFunctionToString(eDataType, instanceValue);
      case ListaCompilerPackage.FIRST_LEVEL_OP:
        return convertFirstLevelOpToString(eDataType, instanceValue);
      case ListaCompilerPackage.SECOND_LEVEL_OP:
        return convertSecondLevelOpToString(eDataType, instanceValue);
      case ListaCompilerPackage.THIRD_LEVEL_OP:
        return convertThirdLevelOpToString(eDataType, instanceValue);
      case ListaCompilerPackage.FOURTH_LEVEL_OP:
        return convertFourthLevelOpToString(eDataType, instanceValue);
      case ListaCompilerPackage.CASTED_TYPE:
        return convertCastedTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
  public FirstLevelExp createFirstLevelExp()
  {
    FirstLevelExpImpl firstLevelExp = new FirstLevelExpImpl();
    return firstLevelExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecondLevelExp createSecondLevelExp()
  {
    SecondLevelExpImpl secondLevelExp = new SecondLevelExpImpl();
    return secondLevelExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThirdLevelExp createThirdLevelExp()
  {
    ThirdLevelExpImpl thirdLevelExp = new ThirdLevelExpImpl();
    return thirdLevelExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FourthLevelExp createFourthLevelExp()
  {
    FourthLevelExpImpl fourthLevelExp = new FourthLevelExpImpl();
    return fourthLevelExp;
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
  public BracketExpression createBracketExpression()
  {
    BracketExpressionImpl bracketExpression = new BracketExpressionImpl();
    return bracketExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyInteger createMyInteger()
  {
    MyIntegerImpl myInteger = new MyIntegerImpl();
    return myInteger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PosInteger createPosInteger()
  {
    PosIntegerImpl posInteger = new PosIntegerImpl();
    return posInteger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NegInteger createNegInteger()
  {
    NegIntegerImpl negInteger = new NegIntegerImpl();
    return negInteger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyVariable createMyVariable()
  {
    MyVariableImpl myVariable = new MyVariableImpl();
    return myVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CastedVariable createCastedVariable()
  {
    CastedVariableImpl castedVariable = new CastedVariableImpl();
    return castedVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyBool createMyBool()
  {
    MyBoolImpl myBool = new MyBoolImpl();
    return myBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PosBool createPosBool()
  {
    PosBoolImpl posBool = new PosBoolImpl();
    return posBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NegBool createNegBool()
  {
    NegBoolImpl negBool = new NegBoolImpl();
    return negBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyString createMyString()
  {
    MyStringImpl myString = new MyStringImpl();
    return myString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfControlFlow createIfControlFlow()
  {
    IfControlFlowImpl ifControlFlow = new IfControlFlowImpl();
    return ifControlFlow;
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
  public PreDefFunctionCall createPreDefFunctionCall()
  {
    PreDefFunctionCallImpl preDefFunctionCall = new PreDefFunctionCallImpl();
    return preDefFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserDefFunctionCall createUserDefFunctionCall()
  {
    UserDefFunctionCallImpl userDefFunctionCall = new UserDefFunctionCallImpl();
    return userDefFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List createList()
  {
    ListImpl list = new ListImpl();
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListElem createListElem()
  {
    ListElemImpl listElem = new ListElemImpl();
    return listElem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bool createBoolFromString(EDataType eDataType, String initialValue)
  {
    Bool result = Bool.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBoolToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PDFunction createPDFunctionFromString(EDataType eDataType, String initialValue)
  {
    PDFunction result = PDFunction.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPDFunctionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FirstLevelOp createFirstLevelOpFromString(EDataType eDataType, String initialValue)
  {
    FirstLevelOp result = FirstLevelOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFirstLevelOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecondLevelOp createSecondLevelOpFromString(EDataType eDataType, String initialValue)
  {
    SecondLevelOp result = SecondLevelOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSecondLevelOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThirdLevelOp createThirdLevelOpFromString(EDataType eDataType, String initialValue)
  {
    ThirdLevelOp result = ThirdLevelOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertThirdLevelOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FourthLevelOp createFourthLevelOpFromString(EDataType eDataType, String initialValue)
  {
    FourthLevelOp result = FourthLevelOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFourthLevelOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CastedType createCastedTypeFromString(EDataType eDataType, String initialValue)
  {
    CastedType result = CastedType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCastedTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
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
