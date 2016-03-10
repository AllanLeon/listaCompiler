/**
 */
package edu.upb.compilacion.listaCompiler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.ControlFlow#getName <em>Name</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.ControlFlow#getCond <em>Cond</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.ControlFlow#getIftrue <em>Iftrue</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.ControlFlow#getIffalse <em>Iffalse</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getControlFlow()
 * @model
 * @generated
 */
public interface ControlFlow extends Term
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getControlFlow_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.ControlFlow#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cond</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond</em>' containment reference.
   * @see #setCond(Expression)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getControlFlow_Cond()
   * @model containment="true"
   * @generated
   */
  Expression getCond();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.ControlFlow#getCond <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond</em>' containment reference.
   * @see #getCond()
   * @generated
   */
  void setCond(Expression value);

  /**
   * Returns the value of the '<em><b>Iftrue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iftrue</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iftrue</em>' containment reference.
   * @see #setIftrue(Expression)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getControlFlow_Iftrue()
   * @model containment="true"
   * @generated
   */
  Expression getIftrue();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.ControlFlow#getIftrue <em>Iftrue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Iftrue</em>' containment reference.
   * @see #getIftrue()
   * @generated
   */
  void setIftrue(Expression value);

  /**
   * Returns the value of the '<em><b>Iffalse</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iffalse</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iffalse</em>' containment reference.
   * @see #setIffalse(Expression)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getControlFlow_Iffalse()
   * @model containment="true"
   * @generated
   */
  Expression getIffalse();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.ControlFlow#getIffalse <em>Iffalse</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Iffalse</em>' containment reference.
   * @see #getIffalse()
   * @generated
   */
  void setIffalse(Expression value);

} // ControlFlow
