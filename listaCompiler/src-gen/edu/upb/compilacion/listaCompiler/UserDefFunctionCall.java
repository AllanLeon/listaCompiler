/**
 */
package edu.upb.compilacion.listaCompiler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Def Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.UserDefFunctionCall#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getUserDefFunctionCall()
 * @model
 * @generated
 */
public interface UserDefFunctionCall extends FunctionCall
{
  /**
   * Returns the value of the '<em><b>Function</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' reference.
   * @see #setFunction(FunctionDefinition)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getUserDefFunctionCall_Function()
   * @model
   * @generated
   */
  FunctionDefinition getFunction();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.UserDefFunctionCall#getFunction <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(FunctionDefinition value);

} // UserDefFunctionCall
