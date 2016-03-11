/**
 */
package edu.upb.compilacion.listaCompiler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>First Level Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getFirst <em>First</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getSecond <em>Second</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFirstLevelExp()
 * @model
 * @generated
 */
public interface FirstLevelExp extends Expression
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference.
   * @see #setFirst(SecondLevelExp)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFirstLevelExp_First()
   * @model containment="true"
   * @generated
   */
  SecondLevelExp getFirst();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getFirst <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' containment reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(SecondLevelExp value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference.
   * @see #setSecond(FirstLevelExp)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getFirstLevelExp_Second()
   * @model containment="true"
   * @generated
   */
  FirstLevelExp getSecond();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getSecond <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' containment reference.
   * @see #getSecond()
   * @generated
   */
  void setSecond(FirstLevelExp value);

} // FirstLevelExp
