/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>First Level Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getArgs <em>Args</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFirstLevelExp()
 * @model
 * @generated
 */
public interface FirstLevelExp extends EObject
{
  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFirstLevelExp_Args()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getArgs();

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link edu.upb.compilacion.listaCompiler.FirstLevelOp}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.FirstLevelOp
   * @see #setOp(FirstLevelOp)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFirstLevelExp_Op()
   * @model
   * @generated
   */
  FirstLevelOp getOp();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.FirstLevelOp
   * @see #getOp()
   * @generated
   */
  void setOp(FirstLevelOp value);

} // FirstLevelExp
