package edu.upb.compilacion

import edu.upb.compilacion.listaCompiler.BracketExpression
import edu.upb.compilacion.listaCompiler.CastedType
import edu.upb.compilacion.listaCompiler.CastedVariable
import edu.upb.compilacion.listaCompiler.ComplexTerm
import edu.upb.compilacion.listaCompiler.Expression
import edu.upb.compilacion.listaCompiler.FirstLevelExp
import edu.upb.compilacion.listaCompiler.FirstLevelOp
import edu.upb.compilacion.listaCompiler.FourthLevelExp
import edu.upb.compilacion.listaCompiler.FunctionCall
import edu.upb.compilacion.listaCompiler.FunctionDefinition
import edu.upb.compilacion.listaCompiler.IfControlFlow
import edu.upb.compilacion.listaCompiler.List
import edu.upb.compilacion.listaCompiler.MyBool
import edu.upb.compilacion.listaCompiler.MyInteger
import edu.upb.compilacion.listaCompiler.MyString
import edu.upb.compilacion.listaCompiler.MyVariable
import edu.upb.compilacion.listaCompiler.NegBool
import edu.upb.compilacion.listaCompiler.NegInteger
import edu.upb.compilacion.listaCompiler.PDFunction
import edu.upb.compilacion.listaCompiler.PreDefFunctionCall
import edu.upb.compilacion.listaCompiler.SecondLevelExp
import edu.upb.compilacion.listaCompiler.SecondLevelOp
import edu.upb.compilacion.listaCompiler.SimpleTerm
import edu.upb.compilacion.listaCompiler.Term
import edu.upb.compilacion.listaCompiler.ThirdLevelExp
import edu.upb.compilacion.listaCompiler.ThirdLevelOp
import edu.upb.compilacion.listaCompiler.UserDefFunctionCall
import edu.upb.compilacion.listaCompiler.Variable
import java.util.ArrayList
import java.util.HashMap

class TypeInferrer {
	
	/**
	 * DataTypes that a expression could have.
	 */
	enum DataType {
		INT, STRING, BOOL, LIST, VOID, VAR, GLOBAL
	}
	
	/**
	 * Represents the symbols table.
	 */
	private static var functionParams = new HashMap<String, HashMap<String,DataType>>();
	private static var functionTypes = new HashMap<String, DataType>();
	private static var currentFunction = "";
	
	/**
	 * Resets the currentFunction string so the next check doesn't try to get another function
	 * type.
	 */
	static def resetCurrentFunction() {
		currentFunction = "";
	}
	
	/**
	 * Cleans the symbols table info of a function.
	 */
	static def removeFunctionInfo(FunctionDefinition fd) {
		functionParams.remove(fd.name);
		functionTypes.remove(fd.name);
	}
	
	/**
	 * Infers the data type of a function and it's parameters if any.
	 */
	static def inferDataType(FunctionDefinition fd) {
		currentFunction = fd.name;
		functionParams.put(fd.name, new HashMap<String, DataType>());
		searchCastedVariables(fd);
		inferDataType(fd.^return.exp, fd.name);
	}
	
	/**
	 * Automatically sets the type if a variable is casted.
	 */
	static def searchCastedVariables(FunctionDefinition fd) {
		for (mvar : fd.params) {
			if (mvar instanceof CastedVariable) {
				val cvar = mvar as CastedVariable;
				functionParams.get(fd.name).put(cvar.^var, getDataTypeFromCast(cvar.type));
			}
		}
	}
	
	/**
	 * Infers the type of a FirstLevelExp and then infers the type of both sides of it, the
	 * variables types are inferred based on the operator. The types are saved on the current
	 * function table.
	 */
	static def void inferDataType(FirstLevelExp exp, String fdName) {
		val first = exp.args.get(0) as SecondLevelExp;
		val firstType = first.getDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expected = DataType.GLOBAL;
			switch (op) {
				case FirstLevelOp.AND,
				case FirstLevelOp.OR:
					expected = DataType.BOOL
				default:
					expected = DataType.GLOBAL
			}
			setFunctionType(fdName, expected);
			val second = exp.args.get(1) as FirstLevelExp;
			val secondType = second.getDataType; 
			if (firstType.equals(DataType.VAR)) {
				val var1 = first.getVariable;
				functionParams.get(fdName).put(var1, expected);
			} else {
				inferDataType(first, fdName);
			}
			if (secondType.equals(DataType.VAR)) {
				val var2 = second.getVariable;
				functionParams.get(fdName).put(var2, expected);
			} else {
				inferDataType(second, fdName);
			}
		} else {
			inferDataType(first, fdName);
		}
	}
	
	/**
	 * Infers the type of a SecondLevelExp and then infers the type of both sides of it, the
	 * variables types are inferred based on the operator. The types are saved on the current
	 * function table.
	 */
	static def void inferDataType(SecondLevelExp exp, String fdName) {
		val first = exp.args.get(0) as ThirdLevelExp;
		val firstType = first.getDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expected = DataType.GLOBAL;
			switch (op) {
				case SecondLevelOp.GT,
				case SecondLevelOp.LT:
					expected = DataType.INT
				case SecondLevelOp.EQ:
					expected = DataType.BOOL
				default:
					expected = DataType.GLOBAL			
			}
			setFunctionType(fdName, expected);
			val second = exp.args.get(1) as SecondLevelExp;
			val secondType = second.getDataType; 
			if (firstType.equals(DataType.VAR)) {
				val var1 = first.getVariable;
				functionParams.get(fdName).put(var1, expected);
			} else {
				inferDataType(first, fdName);
			}
			if (secondType.equals(DataType.VAR)) {
				val var2 = second.getVariable;
				functionParams.get(fdName).put(var2, expected);
			} else {
				inferDataType(second, fdName);
			}
		} else {
			inferDataType(first, fdName);
		}
	}
	
	/**
	 * Infers the type of a ThirdLevelExp and then infers the type of both sides of it, the
	 * variables types are inferred based on the operator. The types are saved on the current
	 * function table.
	 */
	static def void inferDataType(ThirdLevelExp exp, String fdName) {
		val first = exp.args.get(0) as FourthLevelExp;
		val firstType = first.getDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expected = DataType.GLOBAL;
			switch (op) {
				case ThirdLevelOp.PLUS,
				case ThirdLevelOp.MINUS:
					expected = DataType.INT
				case ThirdLevelOp.CONCAT:
					expected = DataType.STRING
				default:
					expected = DataType.GLOBAL				
			}
			setFunctionType(fdName, expected);
			val second = exp.args.get(1) as ThirdLevelExp;
			val secondType = second.getDataType; 
			if (firstType.equals(DataType.VAR)) {
				val var1 = first.getVariable;
				functionParams.get(fdName).put(var1, expected);
			} else {
				inferDataType(first, fdName);
			}
			if (secondType.equals(DataType.VAR)) {
				val var2 = second.getVariable;
				functionParams.get(fdName).put(var2, expected);
			} else {
				inferDataType(second, fdName);
			}
		} else {
			inferDataType(first, fdName);
		}
	}
	
	/**
	 * Infers the type of a FourthLevelExp and then infers the type of both sides of it, the
	 * variables types are inferred based on the operator. The types are saved on the current
	 * function table.
	 */
	static def void inferDataType(FourthLevelExp exp, String fdName) {
		val first = exp.args.get(0) as Term;
		val firstType = first.getDataType;
		if (exp.args.length > 1) {
			var expected = DataType.INT;
			setFunctionType(fdName, expected);
			val second = exp.args.get(1) as FourthLevelExp;
			val secondType = second.getDataType; 
			if (firstType.equals(DataType.VAR)) {
				val var1 = first.getVariable;
				functionParams.get(fdName).put(var1, expected);
			} else {
				inferDataType(first, fdName);
			}
			if (secondType.equals(DataType.VAR)) {
				val var2 = second.getVariable;
				functionParams.get(fdName).put(var2, expected);
			} else {
				inferDataType(second, fdName);
			}
		} else {
			inferDataType(first, fdName);
		}
	}
	
	/**
	 * Infers the type of a Term.
	 */
	static def void inferDataType(Term term, String fdName) {
		if (term instanceof SimpleTerm) {
			inferDataType((term as SimpleTerm), fdName);
		} else if (term instanceof ComplexTerm) {
			inferDataType((term as ComplexTerm), fdName);
		}
	}
	
	/**
	 * Infers the type of a SimpleTerm, based of the instance of it.
	 */
	static def void inferDataType(SimpleTerm term, String fdName) {
		if (term instanceof MyInteger) {
			inferDataType((term as MyInteger), fdName);
		} else if (term instanceof MyString) {
			setFunctionType(fdName, DataType.STRING);
		} else if (term instanceof MyBool) {
			inferDataType((term as MyBool), fdName);
		} else if (term instanceof List) {
			inferDataType((term as List), fdName);
		} else if (term instanceof Variable) {
			setFunctionType(fdName, DataType.VAR);
		}
	}
	
	/**
	 * Infers the type of a list and it's elements. Saves the variables types in the current
	 * function table.
	 */
	static def void inferDataType(List li, String fdName) {
		for (el : li.elems) {
			if (el instanceof Variable) {
				functionParams.get(fdName).put((el as Variable).^var, DataType.INT);
			}
		}
		setFunctionType(fdName, DataType.LIST);
	}
	
	/**
	 * Infers the type of a ComplexTerm, based of the instance of it.
	 */
	static def void inferDataType(ComplexTerm term, String fdName) {
		if (term instanceof FunctionCall) {
			inferDataType((term as FunctionCall), fdName);
		} else if (term instanceof IfControlFlow) {
			inferDataType((term as IfControlFlow).iftrue.exp, fdName);
			inferDataType((term as IfControlFlow).iffalse.exp, fdName);
			inferDataType((term as IfControlFlow).cond.exp, fdName);
		} else if (term instanceof BracketExpression) {
			inferDataType((term as BracketExpression).exp.exp, fdName);
		}
	}
	
	/**
	 * Infers the type of a MyInteger, if it's a negation of a ComplexTerm, it's type is
	 * inferred as well.
	 */
	static def void inferDataType(MyInteger myInt, String fdName) {
		setFunctionType(fdName, DataType.INT);
		if (myInt instanceof NegInteger) {
			val exp = (myInt as NegInteger).^val;
			if (exp instanceof ComplexTerm) {
				inferDataType((exp as ComplexTerm), fdName
				);
			}
		}
	}
	
	/**
	 * Infers the type of a MyBool, if it's a negation of a ComplexTerm, it's type is
	 * inferred as well.
	 */
	static def void inferDataType(MyBool myBool, String fdName) {
		setFunctionType(fdName, DataType.BOOL);
		if (myBool instanceof NegBool) {
			val exp = (myBool as NegBool).^val;
			if (exp instanceof ComplexTerm) {
				inferDataType((exp as ComplexTerm), fdName);
			}
		}
	}
	
	/**
	 * Infers the type of a function call.
	 */
	static def void inferDataType(FunctionCall fcall, String fdName) {
		if (fcall instanceof PreDefFunctionCall) {
			inferDataType((fcall as PreDefFunctionCall), fdName);
		} else if (fcall instanceof UserDefFunctionCall) {
			inferDataType((fcall as UserDefFunctionCall), fdName);
		}
	}
	
	/**
	 * If an Expression calls a predefined function, it gains it's type.
	 */
	static def void inferDataType(PreDefFunctionCall fcall, String fdName) {
		switch (fcall.function) {
			case PDFunction.SHOW:
				setFunctionType(fdName, DataType.VOID)
			case PDFunction.LENGTH,
			case PDFunction.CAR:
				setFunctionType(fdName, DataType.INT)
			case PDFunction.CDR,
			case PDFunction.CONS:
				setFunctionType(fdName, DataType.LIST)
			case PDFunction.IS_EMPTY:
				setFunctionType(fdName, DataType.BOOL)
		}
		for (exp : fcall.args) {
			inferDataType(exp.exp, fdName);
		}
		inferPDFArgsDataType(fcall, fdName);
	}
	
	/**
	 * Infers the arguments types of a predefined function.
	 */
	static def void inferPDFArgsDataType(PreDefFunctionCall fcall, String fdName) {
		var paramsTypes = new ArrayList<DataType>();
		switch (fcall.function) {
			case PDFunction.SHOW: {
				paramsTypes.add(DataType.GLOBAL);
			}
			case PDFunction.LENGTH: {
				paramsTypes.add(DataType.STRING);
			}
			case PDFunction.CAR: {
				paramsTypes.add(DataType.LIST);
			}
			case PDFunction.CDR: {
				paramsTypes.add(DataType.LIST);
			}
			case PDFunction.CONS: {
				paramsTypes.add(DataType.INT);
				paramsTypes.add(DataType.LIST);
			}
			case PDFunction.IS_EMPTY: {
				paramsTypes.add(DataType.LIST);
			}
		}
		var i = 0;
		for (exp : fcall.args) {
			if (i >= paramsTypes.size()) {
				return;
			}
			if (!paramsTypes.get(i).equals(DataType.GLOBAL)) {
				if (exp.getDataType.equals(DataType.VAR)) {
					functionParams.get(fdName).put(exp.exp.getVariable, paramsTypes.get(i));
				}
			}
			i++;
		}
	}
	
	/**
	 * Infers the arguments types of an user defined function.
	 */
	static def void inferUDFArgsDataType(UserDefFunctionCall fcall, String fdName) {
		if (functionTypes.containsKey(fcall.function.name)) {
			val args = fcall.args;
			val params = functionParams.get(fcall.function.name);
			var i = 0;
			for (current : fcall.function.params) {
				if (i >= args.size()) {
					return;
				}
				if (params.containsKey(current.getVariable)) {
					if (args.get(i).getDataType.equals(DataType.VAR)) {
						functionParams.get(fdName).put(args.get(i).exp.getVariable, params.get(current.getVariable))
					}
				}
				i++;
			}
		}
	}
	
	/**
	 * If an Expression calls an user defined function, it gains it's type.
	 */
	static def void inferDataType(UserDefFunctionCall fcall, String fdName) {
		if (functionTypes.containsKey(fcall.function.name)) {
			setFunctionType(fdName, functionTypes.get(fcall.function.name));
		} else {
			setFunctionType(fdName, DataType.VAR);
		}
		for (exp : fcall.args) {
			inferDataType(exp.exp, fdName);
		}
		inferUDFArgsDataType(fcall, fdName);
	}
	
	/**
	 * Returns the DataType of an Expression
	 */
	static def DataType getDataType(Expression exp) {
		return exp.exp.getDataType;
	}
	
	/**
	 * Returns the DataType of a FirstLevelExp, based on it's operator or on it't left side.
	 */
	static def DataType getDataType(FirstLevelExp exp) {
		val first = (exp.args.get(0) as SecondLevelExp).getDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expected = DataType.GLOBAL;
			switch (op) {
				case FirstLevelOp.AND,
				case FirstLevelOp.OR:
					expected = DataType.BOOL
				default:
					expected = DataType.GLOBAL				
			}
			return expected;
		} else {
			return first;
		}
	}
	
	/**
	 * Returns the DataType of a SecondLevelExp, based on it's operator or on it't left side.
	 */
	static def DataType getDataType(SecondLevelExp exp) {
		val first = (exp.args.get(0) as ThirdLevelExp).getDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expected = DataType.GLOBAL;
			switch (op) {
				case SecondLevelOp.GT,
				case SecondLevelOp.LT,
				case SecondLevelOp.EQ:
					expected = DataType.BOOL
				default:
					expected = DataType.GLOBAL
			}
			return expected;
		} else {
			return first;
		}
	}
	
	/**
	 * Returns the DataType of a ThirdLevelExp, based on it's operator or on it't left side.
	 */
	static def DataType getDataType(ThirdLevelExp exp) {
		val first = (exp.args.get(0) as FourthLevelExp).getDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expected = DataType.GLOBAL;
			switch (op) {
				case ThirdLevelOp.PLUS,
				case ThirdLevelOp.MINUS:
					expected = DataType.INT
				case ThirdLevelOp.CONCAT:
					expected = DataType.STRING
				default:
					expected = DataType.GLOBAL				
			}
			return expected;
		} else {
			return first;
		}
	}
	
	/**
	 * Returns the DataType of a FourthLevelExp, based on it's operator or on it't left side.
	 */
	static def DataType getDataType(FourthLevelExp exp) {
		val first = (exp.args.get(0) as Term).getDataType;
		if (exp.args.length > 1) {
			return DataType.INT;
		} else {
			return first;
		}
	}
	
	/**
	 * Returns the DataType of a Term.
	 */
	static def DataType getDataType(Term term) {
		if (term instanceof SimpleTerm) {
			return (term as SimpleTerm).getDataType;
		} else if (term instanceof ComplexTerm) {
			return (term as ComplexTerm).getDataType;
		}
	}
	
	/**
	 * Returns the DataType of a SimpleTerm based on it's instance.
	 */
	static def DataType getDataType(SimpleTerm term) {
		if (term instanceof MyInteger) {
			return DataType.INT;
		} else if (term instanceof MyString) {
			return DataType.STRING;
		} else if (term instanceof MyBool) {
			return DataType.BOOL;
		} else if (term instanceof List) {
			return DataType.LIST;
		} else if (term instanceof Variable) {
			return (term as Variable).getDataType;
		}
	}
	
	/**
	 * Returns the DataType of a ComplexTerm based on it's instance.
	 */
	static def DataType getDataType(ComplexTerm term) {
		if (term instanceof FunctionCall) {
			return (term as FunctionCall).getDataType;
		} else if (term instanceof IfControlFlow) {
			return (term as IfControlFlow).getDataType;
		} else if (term instanceof BracketExpression) {
			return (term as BracketExpression).exp.getDataType;
		}
	}
	
	/**
	 * Returns the DataType of a variable if it has been already inferred.
	 */
	static def DataType getDataType(Variable variable) {
		if (!currentFunction.equals("")) {
			if (functionParams.get(currentFunction).containsKey(variable.^var)) {
				return functionParams.get(currentFunction).get(variable.^var);
			}
		}
		return DataType.VAR;
	}
	
	/**
	 * Returns the DataType of a function call.
	 */
	static def DataType getDataType(FunctionCall fcall) {
		if (fcall instanceof PreDefFunctionCall) {
			return (fcall as PreDefFunctionCall).getDataType;
		} else if (fcall instanceof UserDefFunctionCall) {
			return (fcall as UserDefFunctionCall).getDataType;
		}
	}
	
	/**
	 * Returns the DataType of a predefined function call.
	 */
	static def DataType getDataType(PreDefFunctionCall fcall) {
		switch (fcall.function) {
			case PDFunction.SHOW:
				return DataType.VOID
			case PDFunction.LENGTH,
			case PDFunction.CAR:
				return DataType.INT
			case PDFunction.CDR,
			case PDFunction.CONS:
				return DataType.LIST
			case PDFunction.IS_EMPTY:
				return DataType.BOOL
		}
	}
	
	/**
	 * Returns the DataType of an user defined function call.
	 */
	static def DataType getDataType(UserDefFunctionCall fcall) {
		if (functionTypes.containsKey(fcall.function.name)) {
			return functionTypes.get(fcall.function.name);
		} else {
			return fcall.function.^return.getDataType;
		}
	}
	
	/**
	 * Returns the DataType of an IfControlFlow.
	 */
	static def DataType getDataType(IfControlFlow ifCF) {
		return ifCF.iftrue.getDataType;
	}
	
	/**
	 * Checks and returns the DataType of a Expression.
	 */
	static def DataType checkDataType(Expression exp) {
		return exp.exp.checkDataType;
	}
	
	/**
	 * Checks and returns the DataType of a FirstLevelExp.
	 * Verifies that both sides of the expression have the type that it's operator accepts.
	 */
	static def DataType checkDataType(FirstLevelExp exp) {
		val first = (exp.args.get(0) as SecondLevelExp).checkDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expected = DataType.GLOBAL;
			switch (op) {
				case FirstLevelOp.AND,
				case FirstLevelOp.OR:
					expected = DataType.BOOL
				default:
					expected = DataType.GLOBAL				
			}
			if (first.equals(expected) &&
				(exp.args.get(1) as FirstLevelExp).checkDataType.equals(expected)) {
				return expected;
			} else {
				throw new MismatchedTypeException("Mismatched data types for operator " +
					 op.literal + ", arguments should be " + expected.toString() + ".");
			}
		} else {
			return first;
		}
	}
	
	/**
	 * Checks and returns the DataType of a SecondLevelExp.
	 * Verifies that both sides of the expression have the type that it's operator accepts.
	 */
	static def DataType checkDataType(SecondLevelExp exp) {
		val first = (exp.args.get(0) as ThirdLevelExp).checkDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expectedArgs = DataType.GLOBAL;
			var expectedReturn = DataType.GLOBAL;
			switch (op) {
				case SecondLevelOp.GT,
				case SecondLevelOp.LT: {
					expectedArgs = DataType.INT;
					expectedReturn = DataType.BOOL;
					}
				case SecondLevelOp.EQ:
					return exp.checkEqualsDataType
				default:
					expectedReturn = DataType.GLOBAL				
			}
			if (first.equals(expectedArgs) &&
				(exp.args.get(1) as SecondLevelExp).checkDataType.equals(expectedArgs)) {
				return expectedReturn;
			} else {
				throw new MismatchedTypeException("Mismatched data types for operator " +
					 op.literal + ", arguments should be " + expectedArgs.toString() + ".");
			}
		} else {
			return first;
		}
	}
	
	/**
	 * Checks and returns the DataType of a ThirdLevelExp.
	 * Verifies that both sides of the expression have the type that it's operator accepts.
	 */
	static def DataType checkDataType(ThirdLevelExp exp) {
		val first = (exp.args.get(0) as FourthLevelExp).checkDataType;
		val op = exp.op;
		if (exp.args.length > 1) {
			var expected = DataType.GLOBAL;
			switch (op) {
				case ThirdLevelOp.PLUS,
				case ThirdLevelOp.MINUS:
					expected = DataType.INT
				case ThirdLevelOp.CONCAT:
					return exp.checkConcatDataType
				default:
					expected = DataType.GLOBAL				
			}
			if (first.equals(expected) &&
				(exp.args.get(1) as ThirdLevelExp).checkDataType.equals(expected)) {
				return expected;					
			} else {
				throw new MismatchedTypeException("Mismatched data types for operator " +
					 op.literal + ", arguments should be " + expected.toString() + ".");
			}
		} else {
			return first;
		}
	}

	/**
	 * Checks and returns the DataType of a FourthLevelExp.
	 * Verifies that both sides of the expression have the type that it's operator accepts.
	 */
	static def DataType checkDataType(FourthLevelExp exp) {
		val first = (exp.args.get(0) as Term).checkDataType;
		if (exp.args.length > 1) {
			if (first.equals(DataType.INT) &&
				(exp.args.get(1) as FourthLevelExp).checkDataType.equals(DataType.INT)) {
				return DataType.INT;					
			} else {
				throw new MismatchedTypeException("Mismatched data types for operator " + exp.op.literal + ", arguments should be INT.");
			}
		} else {
			return first;
		}
	}
	
	/**
	 * Checks and returns the DataType of a ThirdLevelExp that uses a concat operator.
	 * This operator can accept BOOL, INT and STRING types, and needs a different check.
	 */
	static def DataType checkConcatDataType(ThirdLevelExp exp) {
		val first = (exp.args.get(0) as FourthLevelExp).checkDataType;
		val second = (exp.args.get(1) as ThirdLevelExp).checkDataType;
		if (first.equals(DataType.STRING)) {
			if (second.equals(DataType.INT) || second.equals(DataType.BOOL) || second.equals(DataType.STRING)) {
				return DataType.STRING;
			} else {
				throw new MismatchedTypeException(ThirdLevelOp.CONCAT.literal + " only supports STRING, INT and BOOLEAN types.");
			}
		}
		if (second.equals(DataType.STRING)) {
			if (first.equals(DataType.INT) || first.equals(DataType.BOOL) || first.equals(DataType.STRING)) {
				return DataType.STRING;
			} else {
				throw new MismatchedTypeException(ThirdLevelOp.CONCAT.literal + " only supports STRING, INT and BOOLEAN types.");
			}
		}
		throw new MismatchedTypeException("At least one of the arguments in a " + SecondLevelOp.EQ.literal + " operation should be type STRING.");
	}
	
	/**
	 * Checks and returns the DataType of a SecondLevelExp that uses an equals operator.
	 * This operator can accept all types, and needs a different check.
	 */
	static def DataType checkEqualsDataType(SecondLevelExp exp) {
		val first = (exp.args.get(0) as ThirdLevelExp).checkDataType;
		val second = (exp.args.get(1) as SecondLevelExp).checkDataType;
		if (first.equals(second)) {
			return DataType.BOOL;
		}
		throw new MismatchedTypeException("The two arguments being compared with " + SecondLevelOp.EQ.getName() + " should have the same type.");
	}
	
	/**
	 * Checks and returns the type of a Term.
	 */
	static def DataType checkDataType(Term term) {
		if (term instanceof SimpleTerm) {
			return (term as SimpleTerm).checkDataType;
		} else if (term instanceof ComplexTerm) {
			return (term as ComplexTerm).checkDataType;
		}
	}
	
	/**
	 * Checks and returns the type of a SimpleTerm, based on it's instance.
	 */
	static def DataType checkDataType(SimpleTerm term) {
		if (term instanceof MyInteger) {
			return (term as MyInteger).checkDataType;
		} else if (term instanceof MyString) {
			return DataType.STRING;
		} else if (term instanceof MyBool) {
			return (term as MyBool).checkDataType;
		} else if (term instanceof List) {
			return (term as List).checkDataType;
		} else if (term instanceof Variable) {
			return (term as Variable).getDataType;
		}
	}
	
	/**
	 * Checks and returns the type of a ComplexTerm, based on it's instance.
	 */
	static def DataType checkDataType(ComplexTerm term) {
		if (term instanceof FunctionCall) {
			return (term as FunctionCall).checkDataType;
		} else if (term instanceof IfControlFlow) {
			return (term as IfControlFlow).checkDataType;
		} else if (term instanceof BracketExpression) {
			return (term as BracketExpression).exp.checkDataType;
		}
	}
	
	/**
	 * Checks and returns the type of a List and it's elements.
	 */
	static def DataType checkDataType(List li) {
		for (el : li.elems) {
			if (el instanceof Variable) {
				if  (!(el as Variable).getDataType.equals(DataType.INT)) {
					throw new MismatchedTypeException("List elements must be INT.");
				} 
			}
		}
		return DataType.LIST;
	}
	
	/**
	 * Checks and returns the type of a MyInteger. If it's a negation of a ComplexTerm,
	 * it's type is checked as well.
	 */
	static def DataType checkDataType(MyInteger myInt) {
		if (myInt instanceof NegInteger) {
			val exp = (myInt as NegInteger).^val;
			if (exp instanceof ComplexTerm) {
				val expType = (exp as ComplexTerm).checkDataType;
				if (!expType.equals(DataType.INT)) {
					throw new MismatchedTypeException("Argument type should be INT.")
				}
			}
		}
		return DataType.INT;
	}
	
	/**
	 * Checks and returns the type of a MyBool. If it's a negation of a ComplexTerm,
	 * it's type is checked as well.
	 */
	static def DataType checkDataType(MyBool myBool) {
		if (myBool instanceof NegBool) {
			val exp = (myBool as NegBool).^val;
			if (exp instanceof ComplexTerm) {
				val expType = (exp as ComplexTerm).checkDataType;
				if (!expType.equals(DataType.BOOL)) {
					throw new MismatchedTypeException("Argument type should be BOOL.")
				}
			}
		}
		return DataType.BOOL;
	}
	
	/**
	 * Checks and returns the type of a FunctionCall.
	 */
	static def DataType checkDataType(FunctionCall fcall) {
		if (fcall instanceof PreDefFunctionCall) {
			return (fcall as PreDefFunctionCall).checkDataType;
		} else if (fcall instanceof UserDefFunctionCall) {
			return (fcall as UserDefFunctionCall).checkDataType;
		}
	}
	
	/**
	 * Checks and returns the type of a predefined function call and it's arguments.
	 */
	static def DataType checkDataType(PreDefFunctionCall fcall) {
		var expected = DataType.GLOBAL;
		var paramsTypes = new ArrayList<DataType>();
		switch (fcall.function) {
			case PDFunction.SHOW: 
				return checkShowDataType(fcall)
			case PDFunction.LENGTH: {
				expected = DataType.INT;
				paramsTypes.add(DataType.STRING);
			}
			case PDFunction.CAR: {
				expected = DataType.INT;
				paramsTypes.add(DataType.LIST);
			}
			case PDFunction.CDR: {
				expected = DataType.LIST;
				paramsTypes.add(DataType.LIST);
			}
			case PDFunction.CONS: {
				expected = DataType.LIST;
				paramsTypes.add(DataType.INT);
				paramsTypes.add(DataType.LIST);
			}
			case PDFunction.IS_EMPTY: {
				expected = DataType.BOOL;
				paramsTypes.add(DataType.LIST);
			}
			default:
				throw new HugeException(fcall.function.getName + " method is not predefined.")
		}
		var i = 0;
		for (exp : fcall.args) {
			if (i >= paramsTypes.size()) {
				throw new MismatchedTypeException("Too many arguments in function " + fcall.function.getName);
			}
			if (!paramsTypes.get(i).equals(DataType.GLOBAL)) {
				if (!exp.checkDataType.equals(paramsTypes.get(i))) {
					throw new MismatchedTypeException("Argument type should be " + paramsTypes.get(i));
				}
			}
			i++;
		}
		return expected;
	}
	
	/**
	 * Checks and returns the type of an user defined function call and it's arguments.
	 */
	static def DataType checkDataType(UserDefFunctionCall fcall) {
		if (functionTypes.containsKey(fcall.function.name)) {
			val args = fcall.args;
			val params = functionParams.get(fcall.function.name);
			var i = 0;
			for (current : fcall.function.params) {
				if (i >= args.size()) {
					throw new MismatchedTypeException("Too many arguments in function " + fcall.function.name);
				}
				val name = current.getVariable;
				if (params.containsKey(name)) {
					if (!args.get(i).checkDataType.equals(params.get(name))) {
						throw new MismatchedTypeException("Argument type should be " + params.get(name));
					}
				}
				i++;
			}
			return functionTypes.get(fcall.function.name);
		} else {
			throw new HugeException(fcall.function.getName + " method was not defined.")
		}
	}
	
	/**
	 * Checks that the argument of a show function call is BOOL, STRING, INT or LIST. 
	 */
	static def DataType checkShowDataType(PreDefFunctionCall fcall) {
		val arg = fcall.args.get(0).checkDataType;
		if (!(arg.equals(DataType.INT) || arg.equals(DataType.STRING) || arg.equals(DataType.BOOL) || arg.equals(DataType.LIST))) {
			throw new MismatchedTypeException("Unknown data type to show");
		}
		return DataType.VOID;
	}
	
	/**
	 * Checks and returns the type of an IfControlFlow, and checks the types of it's condition,
	 * if true return and if false return.
	 */
	static def DataType checkDataType(IfControlFlow ifCF) {
		val cond = ifCF.cond.checkDataType;
		val iftrue = ifCF.iftrue.checkDataType;
		val iffalse = ifCF.iffalse.checkDataType;		
		if (!cond.equals(DataType.BOOL)) {
			throw new MismatchedTypeException("Condition should be type BOOL.");
		}
		if (!iftrue.equals(iffalse)) {
			throw new MismatchedTypeException("Both statements should return the same type.");
		}		
		return iftrue;
	}
	
	/**
	 * Return the variable name of a given FirstLevelExp.
	 */
	static def String getVariable(FirstLevelExp exp) {
		return (exp.args.get(0) as SecondLevelExp).getVariable;
	}
	
	/**
	 * Return the variable name of a given SecondLevelExp.
	 */
	static def String getVariable(SecondLevelExp exp) {
		return (exp.args.get(0) as ThirdLevelExp).getVariable;
	}
	
	/**
	 * Return the variable name of a given ThirdLevelExp.
	 */
	static def String getVariable(ThirdLevelExp exp) {
		return (exp.args.get(0) as FourthLevelExp).getVariable;
	}
	
	/**
	 * Return the variable name of a given FourthLevelExp.
	 */
	static def String getVariable(FourthLevelExp exp) {
		return (exp.args.get(0) as Term).getVariable;
	}
	
	/**
	 * Return the variable name of a given Term.
	 */
	static def String getVariable(Term term) {
		if (term instanceof Variable) {
			return (term as Variable).^var;
		} else if (term instanceof UserDefFunctionCall) {
			return (term as UserDefFunctionCall).function.^return.exp.getVariable;
		} else if (term instanceof IfControlFlow) {
			return (term as IfControlFlow).iftrue.exp.getVariable;
		} else if (term instanceof BracketExpression) {
			return (term as BracketExpression).exp.exp.getVariable;
		}
	} 
	
	/**
	 * Returns the variable name of a given MyVariable.
	 */
	static def String getVariable(MyVariable variable) {
		if (variable instanceof Variable) {
			return (variable as Variable).^var;
		} else if (variable instanceof CastedVariable) {
			return (variable as CastedVariable).^var;
		}
	}
	
	/**
	 * Converts a given CastedType to a DataType.
	 */
	static def DataType getDataTypeFromCast(CastedType ct) {
		switch (ct) {
			case CastedType.BOOL:
				return DataType.BOOL
			case CastedType.INT:
				return DataType.INT
			case CastedType.STRING:
				return DataType.STRING
			case CastedType.LIST:
				return DataType.LIST
		}
	}
	
	/**
	 * Sets a function type if it's not already been set, or changes it if it wasn't inferred
	 * yet.
	 */
	static def void setFunctionType(String name, DataType type) {
		if (functionTypes.containsKey(name)) {
			if (functionTypes.get(name).equals(DataType.VAR)) {
				functionTypes.put(name, type);
			}
		} else {
			functionTypes.put(name, type);
		}
	}
	
	/**
	 * Returns the function types map (table).
	 */
	static def getFunctionTypes() {
		return functionTypes;
	}
	
	/**
	 * Returns the function parameters types map (table).
	 */
	static def getFunctionParams() {
		return functionParams;
	}
}