/**
 */
package edu.upb.compilacion.listaCompiler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pre Def Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.PreDefFunctionCall#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getPreDefFunctionCall()
 * @model
 * @generated
 */
public interface PreDefFunctionCall extends FunctionCall
{
  /**
   * Returns the value of the '<em><b>Function</b></em>' attribute.
   * The literals are from the enumeration {@link edu.upb.compilacion.listaCompiler.PDFunction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.PDFunction
   * @see #setFunction(PDFunction)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getPreDefFunctionCall_Function()
   * @model
   * @generated
   */
  PDFunction getFunction();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.PreDefFunctionCall#getFunction <em>Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.PDFunction
   * @see #getFunction()
   * @generated
   */
  void setFunction(PDFunction value);

} // PreDefFunctionCall
