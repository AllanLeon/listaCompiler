/**
 */
package edu.upb.compilacion.listaCompiler.impl;

import edu.upb.compilacion.listaCompiler.Bool;
import edu.upb.compilacion.listaCompiler.Evaluation;
import edu.upb.compilacion.listaCompiler.Expression;
import edu.upb.compilacion.listaCompiler.FirstLevelExp;
import edu.upb.compilacion.listaCompiler.FirstLevelOp;
import edu.upb.compilacion.listaCompiler.FourthLevelExp;
import edu.upb.compilacion.listaCompiler.FourthLevelOp;
import edu.upb.compilacion.listaCompiler.FunctionCall;
import edu.upb.compilacion.listaCompiler.FunctionDefinition;
import edu.upb.compilacion.listaCompiler.IfControlFlow;
import edu.upb.compilacion.listaCompiler.IntList;
import edu.upb.compilacion.listaCompiler.List;
import edu.upb.compilacion.listaCompiler.ListElem;
import edu.upb.compilacion.listaCompiler.Lista;
import edu.upb.compilacion.listaCompiler.ListaCompilerFactory;
import edu.upb.compilacion.listaCompiler.ListaCompilerPackage;
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
import edu.upb.compilacion.listaCompiler.Term;
import edu.upb.compilacion.listaCompiler.ThirdLevelExp;
import edu.upb.compilacion.listaCompiler.ThirdLevelOp;
import edu.upb.compilacion.listaCompiler.UserDefFunctionCall;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ListaCompilerPackageImpl extends EPackageImpl implements ListaCompilerPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass evaluationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass firstLevelExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass secondLevelExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thirdLevelExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fourthLevelExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass termEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myIntegerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass posIntegerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass negIntegerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myBoolEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass posBoolEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass negBoolEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass myStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifControlFlowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preDefFunctionCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass userDefFunctionCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listElemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum boolEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum pdFunctionEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum firstLevelOpEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum secondLevelOpEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum thirdLevelOpEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum fourthLevelOpEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ListaCompilerPackageImpl()
  {
    super(eNS_URI, ListaCompilerFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ListaCompilerPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ListaCompilerPackage init()
  {
    if (isInited) return (ListaCompilerPackage)EPackage.Registry.INSTANCE.getEPackage(ListaCompilerPackage.eNS_URI);

    // Obtain or create and register package
    ListaCompilerPackageImpl theListaCompilerPackage = (ListaCompilerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ListaCompilerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ListaCompilerPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theListaCompilerPackage.createPackageContents();

    // Initialize created meta-data
    theListaCompilerPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theListaCompilerPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ListaCompilerPackage.eNS_URI, theListaCompilerPackage);
    return theListaCompilerPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLista()
  {
    return listaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLista_Definitions()
  {
    return (EReference)listaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLista_Evaluations()
  {
    return (EReference)listaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvaluation()
  {
    return evaluationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEvaluation_Return()
  {
    return (EReference)evaluationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDefinition()
  {
    return functionDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDefinition_Name()
  {
    return (EAttribute)functionDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDefinition_Params()
  {
    return (EAttribute)functionDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefinition_Return()
  {
    return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Exp()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFirstLevelExp()
  {
    return firstLevelExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFirstLevelExp_Args()
  {
    return (EReference)firstLevelExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFirstLevelExp_Op()
  {
    return (EAttribute)firstLevelExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecondLevelExp()
  {
    return secondLevelExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondLevelExp_Args()
  {
    return (EReference)secondLevelExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSecondLevelExp_Op()
  {
    return (EAttribute)secondLevelExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThirdLevelExp()
  {
    return thirdLevelExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThirdLevelExp_Args()
  {
    return (EReference)thirdLevelExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThirdLevelExp_Op()
  {
    return (EAttribute)thirdLevelExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFourthLevelExp()
  {
    return fourthLevelExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFourthLevelExp_Args()
  {
    return (EReference)fourthLevelExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFourthLevelExp_Op()
  {
    return (EAttribute)fourthLevelExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTerm()
  {
    return termEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyInteger()
  {
    return myIntegerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyInteger_Val()
  {
    return (EAttribute)myIntegerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPosInteger()
  {
    return posIntegerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNegInteger()
  {
    return negIntegerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyVariable()
  {
    return myVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyVariable_Var()
  {
    return (EAttribute)myVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyBool()
  {
    return myBoolEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyBool_Val()
  {
    return (EAttribute)myBoolEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPosBool()
  {
    return posBoolEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNegBool()
  {
    return negBoolEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMyString()
  {
    return myStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMyString_Val()
  {
    return (EAttribute)myStringEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfControlFlow()
  {
    return ifControlFlowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfControlFlow_Cond()
  {
    return (EReference)ifControlFlowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfControlFlow_Iftrue()
  {
    return (EReference)ifControlFlowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfControlFlow_Iffalse()
  {
    return (EReference)ifControlFlowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionCall()
  {
    return functionCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionCall_Args()
  {
    return (EReference)functionCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreDefFunctionCall()
  {
    return preDefFunctionCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreDefFunctionCall_Function()
  {
    return (EAttribute)preDefFunctionCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUserDefFunctionCall()
  {
    return userDefFunctionCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUserDefFunctionCall_Function()
  {
    return (EReference)userDefFunctionCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getList()
  {
    return listEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListElem()
  {
    return listElemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntList()
  {
    return intListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIntList_Elems()
  {
    return (EReference)intListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getBool()
  {
    return boolEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getPDFunction()
  {
    return pdFunctionEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFirstLevelOp()
  {
    return firstLevelOpEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSecondLevelOp()
  {
    return secondLevelOpEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getThirdLevelOp()
  {
    return thirdLevelOpEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFourthLevelOp()
  {
    return fourthLevelOpEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListaCompilerFactory getListaCompilerFactory()
  {
    return (ListaCompilerFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    listaEClass = createEClass(LISTA);
    createEReference(listaEClass, LISTA__DEFINITIONS);
    createEReference(listaEClass, LISTA__EVALUATIONS);

    evaluationEClass = createEClass(EVALUATION);
    createEReference(evaluationEClass, EVALUATION__RETURN);

    functionDefinitionEClass = createEClass(FUNCTION_DEFINITION);
    createEAttribute(functionDefinitionEClass, FUNCTION_DEFINITION__NAME);
    createEAttribute(functionDefinitionEClass, FUNCTION_DEFINITION__PARAMS);
    createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__RETURN);

    expressionEClass = createEClass(EXPRESSION);
    createEReference(expressionEClass, EXPRESSION__EXP);

    firstLevelExpEClass = createEClass(FIRST_LEVEL_EXP);
    createEReference(firstLevelExpEClass, FIRST_LEVEL_EXP__ARGS);
    createEAttribute(firstLevelExpEClass, FIRST_LEVEL_EXP__OP);

    secondLevelExpEClass = createEClass(SECOND_LEVEL_EXP);
    createEReference(secondLevelExpEClass, SECOND_LEVEL_EXP__ARGS);
    createEAttribute(secondLevelExpEClass, SECOND_LEVEL_EXP__OP);

    thirdLevelExpEClass = createEClass(THIRD_LEVEL_EXP);
    createEReference(thirdLevelExpEClass, THIRD_LEVEL_EXP__ARGS);
    createEAttribute(thirdLevelExpEClass, THIRD_LEVEL_EXP__OP);

    fourthLevelExpEClass = createEClass(FOURTH_LEVEL_EXP);
    createEReference(fourthLevelExpEClass, FOURTH_LEVEL_EXP__ARGS);
    createEAttribute(fourthLevelExpEClass, FOURTH_LEVEL_EXP__OP);

    termEClass = createEClass(TERM);

    myIntegerEClass = createEClass(MY_INTEGER);
    createEAttribute(myIntegerEClass, MY_INTEGER__VAL);

    posIntegerEClass = createEClass(POS_INTEGER);

    negIntegerEClass = createEClass(NEG_INTEGER);

    myVariableEClass = createEClass(MY_VARIABLE);
    createEAttribute(myVariableEClass, MY_VARIABLE__VAR);

    myBoolEClass = createEClass(MY_BOOL);
    createEAttribute(myBoolEClass, MY_BOOL__VAL);

    posBoolEClass = createEClass(POS_BOOL);

    negBoolEClass = createEClass(NEG_BOOL);

    myStringEClass = createEClass(MY_STRING);
    createEAttribute(myStringEClass, MY_STRING__VAL);

    ifControlFlowEClass = createEClass(IF_CONTROL_FLOW);
    createEReference(ifControlFlowEClass, IF_CONTROL_FLOW__COND);
    createEReference(ifControlFlowEClass, IF_CONTROL_FLOW__IFTRUE);
    createEReference(ifControlFlowEClass, IF_CONTROL_FLOW__IFFALSE);

    functionCallEClass = createEClass(FUNCTION_CALL);
    createEReference(functionCallEClass, FUNCTION_CALL__ARGS);

    preDefFunctionCallEClass = createEClass(PRE_DEF_FUNCTION_CALL);
    createEAttribute(preDefFunctionCallEClass, PRE_DEF_FUNCTION_CALL__FUNCTION);

    userDefFunctionCallEClass = createEClass(USER_DEF_FUNCTION_CALL);
    createEReference(userDefFunctionCallEClass, USER_DEF_FUNCTION_CALL__FUNCTION);

    listEClass = createEClass(LIST);

    listElemEClass = createEClass(LIST_ELEM);

    intListEClass = createEClass(INT_LIST);
    createEReference(intListEClass, INT_LIST__ELEMS);

    // Create enums
    boolEEnum = createEEnum(BOOL);
    pdFunctionEEnum = createEEnum(PD_FUNCTION);
    firstLevelOpEEnum = createEEnum(FIRST_LEVEL_OP);
    secondLevelOpEEnum = createEEnum(SECOND_LEVEL_OP);
    thirdLevelOpEEnum = createEEnum(THIRD_LEVEL_OP);
    fourthLevelOpEEnum = createEEnum(FOURTH_LEVEL_OP);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    expressionEClass.getESuperTypes().add(this.getTerm());
    myIntegerEClass.getESuperTypes().add(this.getTerm());
    myIntegerEClass.getESuperTypes().add(this.getListElem());
    posIntegerEClass.getESuperTypes().add(this.getMyInteger());
    negIntegerEClass.getESuperTypes().add(this.getMyInteger());
    myVariableEClass.getESuperTypes().add(this.getTerm());
    myVariableEClass.getESuperTypes().add(this.getListElem());
    myBoolEClass.getESuperTypes().add(this.getTerm());
    posBoolEClass.getESuperTypes().add(this.getMyBool());
    negBoolEClass.getESuperTypes().add(this.getMyBool());
    myStringEClass.getESuperTypes().add(this.getTerm());
    ifControlFlowEClass.getESuperTypes().add(this.getTerm());
    functionCallEClass.getESuperTypes().add(this.getTerm());
    preDefFunctionCallEClass.getESuperTypes().add(this.getFunctionCall());
    userDefFunctionCallEClass.getESuperTypes().add(this.getFunctionCall());
    listEClass.getESuperTypes().add(this.getTerm());
    intListEClass.getESuperTypes().add(this.getList());

    // Initialize classes and features; add operations and parameters
    initEClass(listaEClass, Lista.class, "Lista", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLista_Definitions(), this.getFunctionDefinition(), null, "definitions", null, 0, -1, Lista.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLista_Evaluations(), this.getEvaluation(), null, "evaluations", null, 0, -1, Lista.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(evaluationEClass, Evaluation.class, "Evaluation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEvaluation_Return(), this.getExpression(), null, "return", null, 0, 1, Evaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionDefinitionEClass, FunctionDefinition.class, "FunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunctionDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionDefinition_Params(), ecorePackage.getEString(), "params", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionDefinition_Return(), this.getExpression(), null, "return", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Exp(), this.getFirstLevelExp(), null, "exp", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(firstLevelExpEClass, FirstLevelExp.class, "FirstLevelExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFirstLevelExp_Args(), ecorePackage.getEObject(), null, "args", null, 0, -1, FirstLevelExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFirstLevelExp_Op(), this.getFirstLevelOp(), "op", null, 0, 1, FirstLevelExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(secondLevelExpEClass, SecondLevelExp.class, "SecondLevelExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSecondLevelExp_Args(), ecorePackage.getEObject(), null, "args", null, 0, -1, SecondLevelExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSecondLevelExp_Op(), this.getSecondLevelOp(), "op", null, 0, 1, SecondLevelExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thirdLevelExpEClass, ThirdLevelExp.class, "ThirdLevelExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThirdLevelExp_Args(), ecorePackage.getEObject(), null, "args", null, 0, -1, ThirdLevelExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getThirdLevelExp_Op(), this.getThirdLevelOp(), "op", null, 0, 1, ThirdLevelExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fourthLevelExpEClass, FourthLevelExp.class, "FourthLevelExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFourthLevelExp_Args(), ecorePackage.getEObject(), null, "args", null, 0, -1, FourthLevelExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFourthLevelExp_Op(), this.getFourthLevelOp(), "op", null, 0, 1, FourthLevelExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(myIntegerEClass, MyInteger.class, "MyInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyInteger_Val(), ecorePackage.getEInt(), "val", null, 0, 1, MyInteger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(posIntegerEClass, PosInteger.class, "PosInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(negIntegerEClass, NegInteger.class, "NegInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(myVariableEClass, MyVariable.class, "MyVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyVariable_Var(), ecorePackage.getEString(), "var", null, 0, 1, MyVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(myBoolEClass, MyBool.class, "MyBool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyBool_Val(), this.getBool(), "val", null, 0, 1, MyBool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(posBoolEClass, PosBool.class, "PosBool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(negBoolEClass, NegBool.class, "NegBool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(myStringEClass, MyString.class, "MyString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMyString_Val(), ecorePackage.getEString(), "val", null, 0, 1, MyString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifControlFlowEClass, IfControlFlow.class, "IfControlFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfControlFlow_Cond(), this.getExpression(), null, "cond", null, 0, 1, IfControlFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfControlFlow_Iftrue(), this.getExpression(), null, "iftrue", null, 0, 1, IfControlFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfControlFlow_Iffalse(), this.getExpression(), null, "iffalse", null, 0, 1, IfControlFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionCall_Args(), this.getExpression(), null, "args", null, 0, -1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preDefFunctionCallEClass, PreDefFunctionCall.class, "PreDefFunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPreDefFunctionCall_Function(), this.getPDFunction(), "function", null, 0, 1, PreDefFunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(userDefFunctionCallEClass, UserDefFunctionCall.class, "UserDefFunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUserDefFunctionCall_Function(), this.getFunctionDefinition(), null, "function", null, 0, 1, UserDefFunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listEClass, List.class, "List", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(listElemEClass, ListElem.class, "ListElem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(intListEClass, IntList.class, "IntList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIntList_Elems(), this.getListElem(), null, "elems", null, 0, -1, IntList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(boolEEnum, Bool.class, "Bool");
    addEEnumLiteral(boolEEnum, Bool.TRUE);
    addEEnumLiteral(boolEEnum, Bool.FALSE);

    initEEnum(pdFunctionEEnum, PDFunction.class, "PDFunction");
    addEEnumLiteral(pdFunctionEEnum, PDFunction.LENGTH);
    addEEnumLiteral(pdFunctionEEnum, PDFunction.CONS);
    addEEnumLiteral(pdFunctionEEnum, PDFunction.CAR);
    addEEnumLiteral(pdFunctionEEnum, PDFunction.CDR);
    addEEnumLiteral(pdFunctionEEnum, PDFunction.IS_EMPTY);
    addEEnumLiteral(pdFunctionEEnum, PDFunction.SHOW);

    initEEnum(firstLevelOpEEnum, FirstLevelOp.class, "FirstLevelOp");
    addEEnumLiteral(firstLevelOpEEnum, FirstLevelOp.AND);
    addEEnumLiteral(firstLevelOpEEnum, FirstLevelOp.OR);

    initEEnum(secondLevelOpEEnum, SecondLevelOp.class, "SecondLevelOp");
    addEEnumLiteral(secondLevelOpEEnum, SecondLevelOp.GT);
    addEEnumLiteral(secondLevelOpEEnum, SecondLevelOp.LT);
    addEEnumLiteral(secondLevelOpEEnum, SecondLevelOp.EQ);

    initEEnum(thirdLevelOpEEnum, ThirdLevelOp.class, "ThirdLevelOp");
    addEEnumLiteral(thirdLevelOpEEnum, ThirdLevelOp.PLUS);
    addEEnumLiteral(thirdLevelOpEEnum, ThirdLevelOp.MINUS);
    addEEnumLiteral(thirdLevelOpEEnum, ThirdLevelOp.CONCAT);

    initEEnum(fourthLevelOpEEnum, FourthLevelOp.class, "FourthLevelOp");
    addEEnumLiteral(fourthLevelOpEEnum, FourthLevelOp.MULT);
    addEEnumLiteral(fourthLevelOpEEnum, FourthLevelOp.DIV);

    // Create resource
    createResource(eNS_URI);
  }

} //ListaCompilerPackageImpl
