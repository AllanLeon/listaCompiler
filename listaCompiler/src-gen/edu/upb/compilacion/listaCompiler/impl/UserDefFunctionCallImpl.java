/**
 */
package edu.upb.compilacion.listaCompiler.impl;

import edu.upb.compilacion.listaCompiler.FunctionDefinition;
import edu.upb.compilacion.listaCompiler.ListaCompilerPackage;
import edu.upb.compilacion.listaCompiler.UserDefFunctionCall;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Def Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.impl.UserDefFunctionCallImpl#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserDefFunctionCallImpl extends FunctionCallImpl implements UserDefFunctionCall
{
  /**
   * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected FunctionDefinition function;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UserDefFunctionCallImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ListaCompilerPackage.Literals.USER_DEF_FUNCTION_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition getFunction()
  {
    if (function != null && function.eIsProxy())
    {
      InternalEObject oldFunction = (InternalEObject)function;
      function = (FunctionDefinition)eResolveProxy(oldFunction);
      if (function != oldFunction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ListaCompilerPackage.USER_DEF_FUNCTION_CALL__FUNCTION, oldFunction, function));
      }
    }
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition basicGetFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(FunctionDefinition newFunction)
  {
    FunctionDefinition oldFunction = function;
    function = newFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ListaCompilerPackage.USER_DEF_FUNCTION_CALL__FUNCTION, oldFunction, function));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.USER_DEF_FUNCTION_CALL__FUNCTION:
        if (resolve) return getFunction();
        return basicGetFunction();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.USER_DEF_FUNCTION_CALL__FUNCTION:
        setFunction((FunctionDefinition)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.USER_DEF_FUNCTION_CALL__FUNCTION:
        setFunction((FunctionDefinition)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.USER_DEF_FUNCTION_CALL__FUNCTION:
        return function != null;
    }
    return super.eIsSet(featureID);
  }

} //UserDefFunctionCallImpl
