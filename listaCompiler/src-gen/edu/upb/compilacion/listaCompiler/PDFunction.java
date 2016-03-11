/**
 */
package edu.upb.compilacion.listaCompiler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>PD Function</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getPDFunction()
 * @model
 * @generated
 */
public enum PDFunction implements Enumerator
{
  /**
   * The '<em><b>Length</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LENGTH_VALUE
   * @generated
   * @ordered
   */
  LENGTH(0, "length", "length"),

  /**
   * The '<em><b>Cons</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONS_VALUE
   * @generated
   * @ordered
   */
  CONS(1, "cons", "cons"),

  /**
   * The '<em><b>Car</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CAR_VALUE
   * @generated
   * @ordered
   */
  CAR(2, "car", "car"),

  /**
   * The '<em><b>Cdr</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CDR_VALUE
   * @generated
   * @ordered
   */
  CDR(3, "cdr", "cdr"),

  /**
   * The '<em><b>Is Empty</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IS_EMPTY_VALUE
   * @generated
   * @ordered
   */
  IS_EMPTY(4, "isEmpty", "isEmpty"),

  /**
   * The '<em><b>Show</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SHOW_VALUE
   * @generated
   * @ordered
   */
  SHOW(5, "show", "show");

  /**
   * The '<em><b>Length</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Length</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LENGTH
   * @model name="length"
   * @generated
   * @ordered
   */
  public static final int LENGTH_VALUE = 0;

  /**
   * The '<em><b>Cons</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Cons</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONS
   * @model name="cons"
   * @generated
   * @ordered
   */
  public static final int CONS_VALUE = 1;

  /**
   * The '<em><b>Car</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Car</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CAR
   * @model name="car"
   * @generated
   * @ordered
   */
  public static final int CAR_VALUE = 2;

  /**
   * The '<em><b>Cdr</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Cdr</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CDR
   * @model name="cdr"
   * @generated
   * @ordered
   */
  public static final int CDR_VALUE = 3;

  /**
   * The '<em><b>Is Empty</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Is Empty</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IS_EMPTY
   * @model name="isEmpty"
   * @generated
   * @ordered
   */
  public static final int IS_EMPTY_VALUE = 4;

  /**
   * The '<em><b>Show</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Show</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SHOW
   * @model name="show"
   * @generated
   * @ordered
   */
  public static final int SHOW_VALUE = 5;

  /**
   * An array of all the '<em><b>PD Function</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final PDFunction[] VALUES_ARRAY =
    new PDFunction[]
    {
      LENGTH,
      CONS,
      CAR,
      CDR,
      IS_EMPTY,
      SHOW,
    };

  /**
   * A public read-only list of all the '<em><b>PD Function</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<PDFunction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>PD Function</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static PDFunction get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PDFunction result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>PD Function</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static PDFunction getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PDFunction result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>PD Function</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static PDFunction get(int value)
  {
    switch (value)
    {
      case LENGTH_VALUE: return LENGTH;
      case CONS_VALUE: return CONS;
      case CAR_VALUE: return CAR;
      case CDR_VALUE: return CDR;
      case IS_EMPTY_VALUE: return IS_EMPTY;
      case SHOW_VALUE: return SHOW;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private PDFunction(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //PDFunction
