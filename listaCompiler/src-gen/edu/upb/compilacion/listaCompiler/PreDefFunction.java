/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pre Def Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.PreDefFunction#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getPreDefFunction()
 * @model
 * @generated
 */
public interface PreDefFunction extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * The literals are from the enumeration {@link edu.upb.compilacion.listaCompiler.PDFunction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.PDFunction
   * @see #setName(PDFunction)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getPreDefFunction_Name()
   * @model
   * @generated
   */
  PDFunction getName();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.PreDefFunction#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.PDFunction
   * @see #getName()
   * @generated
   */
  void setName(PDFunction value);

} // PreDefFunction
