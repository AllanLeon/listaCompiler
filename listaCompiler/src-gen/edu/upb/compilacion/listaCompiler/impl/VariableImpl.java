/**
 */
package edu.upb.compilacion.listaCompiler.impl;

import edu.upb.compilacion.listaCompiler.ListElem;
import edu.upb.compilacion.listaCompiler.ListaCompilerPackage;
import edu.upb.compilacion.listaCompiler.MyVariable;
import edu.upb.compilacion.listaCompiler.Variable;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.impl.VariableImpl#getVar <em>Var</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableImpl extends SimpleTermImpl implements Variable
{
  /**
   * The default value of the '{@link #getVar() <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected static final String VAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVar() <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected String var = VAR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableImpl()
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
    return ListaCompilerPackage.Literals.VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVar()
  {
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVar(String newVar)
  {
    String oldVar = var;
    var = newVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ListaCompilerPackage.VARIABLE__VAR, oldVar, var));
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
      case ListaCompilerPackage.VARIABLE__VAR:
        return getVar();
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
      case ListaCompilerPackage.VARIABLE__VAR:
        setVar((String)newValue);
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
      case ListaCompilerPackage.VARIABLE__VAR:
        setVar(VAR_EDEFAULT);
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
      case ListaCompilerPackage.VARIABLE__VAR:
        return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == MyVariable.class)
    {
      switch (derivedFeatureID)
      {
        case ListaCompilerPackage.VARIABLE__VAR: return ListaCompilerPackage.MY_VARIABLE__VAR;
        default: return -1;
      }
    }
    if (baseClass == ListElem.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == MyVariable.class)
    {
      switch (baseFeatureID)
      {
        case ListaCompilerPackage.MY_VARIABLE__VAR: return ListaCompilerPackage.VARIABLE__VAR;
        default: return -1;
      }
    }
    if (baseClass == ListElem.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (var: ");
    result.append(var);
    result.append(')');
    return result.toString();
  }

} //VariableImpl
