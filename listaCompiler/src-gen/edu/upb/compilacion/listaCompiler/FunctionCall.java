/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.FunctionCall#getFunction <em>Function</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.FunctionCall#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends Term
{
  /**
   * Returns the value of the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' containment reference.
   * @see #setFunction(EObject)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFunctionCall_Function()
   * @model containment="true"
   * @generated
   */
  EObject getFunction();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.FunctionCall#getFunction <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' containment reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(EObject value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link edu.upb.compilacion.listaCompiler.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFunctionCall_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // FunctionCall
