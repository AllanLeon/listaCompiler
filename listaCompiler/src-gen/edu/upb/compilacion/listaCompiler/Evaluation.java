/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.Evaluation#getReturn <em>Return</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getEvaluation()
 * @model
 * @generated
 */
public interface Evaluation extends EObject
{
  /**
   * Returns the value of the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return</em>' containment reference.
   * @see #setReturn(Expression)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getEvaluation_Return()
   * @model containment="true"
   * @generated
   */
  Expression getReturn();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.Evaluation#getReturn <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return</em>' containment reference.
   * @see #getReturn()
   * @generated
   */
  void setReturn(Expression value);

} // Evaluation
