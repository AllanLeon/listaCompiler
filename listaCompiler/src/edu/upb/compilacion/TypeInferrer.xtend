package edu.upb.compilacion

import edu.upb.compilacion.listaCompiler.BracketExpression
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
import edu.upb.compilacion.listaCompiler.Term
import edu.upb.compilacion.listaCompiler.ThirdLevelExp
import edu.upb.compilacion.listaCompiler.ThirdLevelOp
import edu.upb.compilacion.listaCompiler.UserDefFunctionCall
import edu.upb.compilacion.listaCompiler.Variable
import java.util.ArrayList
import java.util.HashMap
import edu.upb.compilacion.listaCompiler.CastedVariable
import edu.upb.compilacion.listaCompiler.CastedType

class TypeInferrer {
	
	enum DataType {
		INT, STRING, BOOL, LIST, VOID, VAR, GLOBAL, CONCAT
	}
	
	private static var functionParams = new HashMap<String, HashMap<String,DataType>>();
	private static var functionTypes = new HashMap<String, DataType>();
	private static var currentFunction = "";
	
	static def resetFunction() {
		currentFunction = "";
	}
	
	
	
	static def inferDataType(FunctionDefinition fd) {
		currentFunction = fd.name;
		functionParams.put(fd.name, new HashMap<String, DataType>());
		inferDataType(fd.^return.exp, fd.name);
	}
	
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
				functionParams.get(fdName).put(var2, expected
				);
			} else {
				inferDataType(second, fdName);
			}
		} else {
			/*if (firstType.equals(DataType.VAR)) {
				val var1 = first.getVariable;
				functionParams.get(fdName).put(var1.^var, DataType.VAR);
			} else {
				inferDataType(first, fdName);
			}*/
			inferDataType(first, fdName);
		}
	}
	
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
			/*if (firstType.equals(DataType.VAR)) {
				val var1 = first.getVariable;
				functionParams.get(fdName).put(var1.^var, DataType.VAR);
			} else {
				inferDataType(first, fdName);
			}*/
			inferDataType(first, fdName);
		}
	}
	
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
			/*if (firstType.equals(DataType.VAR)) {
				val var1 = first.getVariable;
				functionParams.get(fdName).put(var1.^var, DataType.VAR);
			} else {
				inferDataType(first, fdName);
			}*/
			inferDataType(first, fdName);
		}
	}
	
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
			/*if (firstType.equals(DataType.VAR)) {
				val var1 = first.getVariable;
				functionParams.get(fdName).put(var1.^var, DataType.VAR);
			} else {
				inferDataType(first, fdName);
			}*/
			inferDataType(first, fdName);
		}
	}
	
	static def void inferDataType(Term term, String fdName) {
		if (term instanceof MyInteger) {
			inferDataType((term as MyInteger), fdName);
		} else if (term instanceof MyString) {
			setFunctionType(fdName, DataType.STRING);
		} else if (term instanceof MyBool) {
			inferDataType((term as MyBool), fdName);
		} else if (term instanceof List) {
			setFunctionType(fdName, DataType.LIST);
		} else if (term instanceof MyVariable) {
			inferDataType((term as MyVariable), fdName);
		} else if (term instanceof FunctionCall) {
			inferDataType((term as FunctionCall), fdName);
		} else if (term instanceof IfControlFlow) {
			inferDataType((term as IfControlFlow).iftrue.exp, fdName);
			inferDataType((term as IfControlFlow).iffalse.exp, fdName);
			inferDataType((term as IfControlFlow).cond.exp, fdName);
		} else if (term instanceof BracketExpression) {
			inferDataType((term as BracketExpression).exp.exp, fdName);
		}
	}
	
	static def void inferDataType(MyVariable variable, String fdName) {
		if (variable instanceof Variable) {
			setFunctionType(fdName, DataType.VAR);
		} else if (variable instanceof CastedVariable) {
			setFunctionType(fdName, getDataTypeFromCast((variable as CastedVariable).type));
		}
	}
	
	static def void inferDataType(MyInteger myInt, String fdName) {
		setFunctionType(fdName, DataType.INT);
		if (myInt instanceof NegInteger) {
			val exp = (myInt as NegInteger).^val;
			if (exp instanceof BracketExpression) {
				inferDataType((exp as BracketExpression).exp.exp, fdName);
			}
		}
	}
	
	static def void inferDataType(MyBool myBool, String fdName) {
		setFunctionType(fdName, DataType.BOOL);
		if (myBool instanceof NegBool) {
			val exp = (myBool as NegBool).^val;
			if (exp instanceof BracketExpression) {
				inferDataType((exp as BracketExpression).exp.exp, fdName);
			}
		}
	}
	
	static def void inferDataType(FunctionCall fcall, String fdName) {
		if (fcall instanceof PreDefFunctionCall) {
			inferDataType((fcall as PreDefFunctionCall), fdName);
		} else if (fcall instanceof UserDefFunctionCall) {
			inferDataType((fcall as UserDefFunctionCall), fdName);
		}
	}
	
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
			//default:
			//	throw new HugeException(fcall.function + " method is not predefined.")
		}
		for (exp : fcall.args) {
			inferDataType(exp.exp, fdName);
		}
	}
	
	static def void inferDataType(UserDefFunctionCall fcall, String fdName) {
		if (functionTypes.containsKey(fcall.function.name)) {
			setFunctionType(fdName, functionTypes.get(fcall.function.name));
		} else {
			setFunctionType(fdName, DataType.VAR);
		}
		for (exp : fcall.args) {
			inferDataType(exp.exp, fdName);
		}
	}
	
	/*def inferDataType(IfControlFlow ifCF, String fdName) {
		return ifCF.iftrue.getDataType;
	}*/	
	
	static def DataType getDataType(Expression exp) {
		return exp.exp.getDataType;
	}
	
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
			/*if (first.equals(expected) &&
				(exp.args.get(1) as FirstLevelExp).getDataType.equals(expected)) {
				return expected;
			} else {
				throw new MismatchedTypeException("Mismatched data types for operator " +
					 op.literal + ", arguments should be " + expected.toString() + ".");
			}*/
			return expected;
		} else {
			return first;
		}
	}
	
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
			/*if (first.equals(expected) &&
				(exp.args.get(1) as SecondLevelExp).getDataType.equals(expected)) {
				return expected;
			} else {
				throw new MismatchedTypeException("Mismatched data types for operator " +
					 op.literal + ", arguments should be " + expected.toString() + ".");
			}*/
			return expected;
		} else {
			return first;
		}
	}
	
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
			/*if (first.equals(expected) &&
				(exp.args.get(1) as ThirdLevelExp).getDataType.equals(expected)) {
				return expected;
			} else {
				throw new MismatchedTypeException("Mismatched data types for operator " +
					 op.literal + ", arguments should be " + expected.toString() + ".");
			}*/
			return expected;
		} else {
			return first;
		}
	}
	
	static def DataType getDataType(FourthLevelExp exp) {
		val first = (exp.args.get(0) as Term).getDataType;
		if (exp.args.length > 1) {
			/*if (first.equals(DataType.INT) &&
				(exp.args.get(1) as FourthLevelExp).getDataType.equals(DataType.INT)) {
				return DataType.INT;
			} else {
				throw new MismatchedTypeException("Mismatched data types for operator " + exp.op.literal + ", arguments should be INT.");
			}*/
			return DataType.INT;
		} else {
			return first;
		}
	}
	
	static def DataType getDataType(Term term) {
		if (term instanceof MyInteger) {
			return DataType.INT;
		} else if (term instanceof MyString) {
			return DataType.STRING;
		} else if (term instanceof MyBool) {
			return DataType.BOOL;
		} else if (term instanceof List) {
			return DataType.LIST;
		} else if (term instanceof MyVariable) {
			return (term as MyVariable).getDataType;
		} else if (term instanceof FunctionCall) {
			return (term as FunctionCall).getDataType;
		} else if (term instanceof IfControlFlow) {
			return (term as IfControlFlow).getDataType;
		} else if (term instanceof BracketExpression) {
			return (term as BracketExpression).exp.getDataType;
		}
	}
	
	static def DataType getDataType(MyVariable variable) {
		if (variable instanceof Variable) {
			return (variable as Variable).getDataType;
		} else if (variable instanceof CastedVariable) {
			val cvar = variable as CastedVariable;
			val type = getDataTypeFromCast(cvar.type);
			functionParams.get(currentFunction).put(cvar.^var, type);
			return getDataTypeFromCast(cvar.type);
		}
	}
	
	static def DataType getDataType(Variable variable) {
		if (!currentFunction.equals("")) {
			if (functionParams.get(currentFunction).containsKey(variable.^var)) {
				return functionParams.get(currentFunction).get(variable.^var);
			}
		}
		return DataType.VAR;
	}
	
	static def DataType getDataType(FunctionCall fcall) {
		if (fcall instanceof PreDefFunctionCall) {
			return (fcall as PreDefFunctionCall).getDataType;
		} else if (fcall instanceof UserDefFunctionCall) {
			return (fcall as UserDefFunctionCall).getDataType;
		}
	}
	
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
			//default:
			//  throw new HugeException(fcall.function + " method is not predefined.")
		}
	}
	
	static def DataType getDataType(UserDefFunctionCall fcall) {
		if (functionTypes.containsKey(fcall.function.name)) {
			return functionTypes.get(fcall.function.name);
		} else {
			return fcall.function.^return.getDataType;
		}
	}
	
	static def DataType getDataType(IfControlFlow ifCF) {
		return ifCF.iftrue.getDataType;
	}
	
	static def DataType checkDataType(Expression exp) {
		return exp.exp.checkDataType;
	}
	
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
					return exp.compareEquals
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
					return exp.checkStringConcat
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
	
	static def DataType checkStringConcat(ThirdLevelExp exp) {
		val first = (exp.args.get(0) as FourthLevelExp).checkDataType;
		val second = (exp.args.get(1) as ThirdLevelExp).checkDataType;
		if (first.equals(DataType.STRING)) {
			if (second.equals(DataType.INT) || second.equals(DataType.BOOL) || second.equals(DataType.STRING)) {
				return DataType.STRING;
			} else {
				throw new MismatchedTypeException(SecondLevelOp.EQ.literal + " only supports STRING, INT and BOOLEAN types.");
			}
		}
		if (second.equals(DataType.STRING)) {
			if (first.equals(DataType.INT) || first.equals(DataType.BOOL) || first.equals(DataType.STRING)) {
				return DataType.STRING;
			} else {
				throw new MismatchedTypeException(SecondLevelOp.EQ.literal + " only supports STRING, INT and BOOLEAN types.");
			}
		}
		throw new MismatchedTypeException("At least one of the arguments in a " + SecondLevelOp.EQ.literal + " operation should be type STRING.");
	}
	
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
	
	static def DataType checkDataType(Term term) {
		if (term instanceof MyInteger) {
			return (term as MyInteger).checkDataType;
		} else if (term instanceof MyString) {
			return DataType.STRING;
		} else if (term instanceof MyBool) {
			return (term as MyBool).checkDataType;
		} else if (term instanceof List) {
			return DataType.LIST;
		} else if (term instanceof MyVariable) {
			return (term as MyVariable).getDataType;
		} else if (term instanceof FunctionCall) {
			return (term as FunctionCall).checkDataType;
		} else if (term instanceof IfControlFlow) {
			return (term as IfControlFlow).checkDataType;
		} else if (term instanceof BracketExpression) {
			return (term as BracketExpression).exp.checkDataType;
		}
	}
	
	static def DataType checkDataType(MyInteger myInt) {
		if (myInt instanceof NegInteger) {
			val exp = (myInt as NegInteger).^val;
			if (exp instanceof BracketExpression) {
				val expType = (exp as BracketExpression).exp.checkDataType;
				if (!expType.equals(DataType.INT)) {
					throw new MismatchedTypeException("Argument type should be INT.")
				}
			}
		}
		return DataType.INT;
	}
	
	static def DataType checkDataType(MyBool myBool) {
		if (myBool instanceof NegBool) {
			val exp = (myBool as NegBool).^val;
			if (exp instanceof BracketExpression) {
				val expType = (exp as BracketExpression).exp.checkDataType;
				if (!expType.equals(DataType.BOOL)) {
					throw new MismatchedTypeException("Argument type should be BOOL.")
				}
			}
		}
		return DataType.BOOL;
	}
	
	static def DataType checkDataType(FunctionCall fcall) {
		if (fcall instanceof PreDefFunctionCall) {
			return (fcall as PreDefFunctionCall).checkDataType;
		} else if (fcall instanceof UserDefFunctionCall) {
			return (fcall as UserDefFunctionCall).checkDataType;
		}
	}
	
	static def DataType checkDataType(PreDefFunctionCall fcall) {
		var expected = DataType.GLOBAL;
		var paramsTypes = new ArrayList<DataType>();
		switch (fcall.function) {
			case PDFunction.SHOW: {
				expected = DataType.VOID;
				paramsTypes.add(DataType.GLOBAL);
			}
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
			if (!paramsTypes.get(i).equals(DataType.GLOBAL)) {
				if (!exp.checkDataType.equals(paramsTypes.get(i))) {
					throw new MismatchedTypeException("Argument type should be " + paramsTypes.get(i));
				}
			}
			i++;
		}
		return expected;
	}
	
	static def DataType checkDataType(UserDefFunctionCall fcall) {
		if (functionTypes.containsKey(fcall.function.name)) {
			val args = fcall.args;
			val params = functionParams.get(fcall.function.name);
			var i = 0;
			for (current : fcall.function.params) {
				if (params.containsKey(current)) {
					if (!args.get(i).checkDataType.equals(params.get(current))) {
						throw new MismatchedTypeException("Argument type should be " + params.get(current));
					}
				}
				i++;
			}
			return functionTypes.get(fcall.function.name);
		} else {
			throw new HugeException(fcall.function.getName + " method was not defined.")
		}
	}
	
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
	
	static def DataType compareEquals(SecondLevelExp exp) {
		val first = (exp.args.get(0) as ThirdLevelExp).checkDataType;
		val second = (exp.args.get(1) as SecondLevelExp).checkDataType;
		if (first.equals(second)) {
			return DataType.BOOL;
		}
		throw new MismatchedTypeException("The two arguments being compared with " + SecondLevelOp.EQ.getName() + " should have the same type.");
	}
	
	static def String getVariable(FirstLevelExp exp) {
		return ((((exp.args.get(0) as SecondLevelExp).args.get(0) as ThirdLevelExp).args.get(0) as FourthLevelExp).args.get(0) as Term).getVariable;
	}
	
	static def String getVariable(SecondLevelExp exp) {
		return (((exp.args.get(0) as ThirdLevelExp).args.get(0) as FourthLevelExp).args.get(0) as Term).getVariable;
	}
	
	static def String getVariable(ThirdLevelExp exp) {
		return ((exp.args.get(0) as FourthLevelExp).args.get(0) as Term).getVariable;
	}
	
	static def String getVariable(FourthLevelExp exp) {
		return (exp.args.get(0) as Term).getVariable;
	}
	
	static def String getVariable(Term term) {
		if (term instanceof MyVariable) {
			return (term as MyVariable).getVariable;
		} else if (term instanceof UserDefFunctionCall) {
			return (term as UserDefFunctionCall).function.^return.exp.getVariable;
		} else if (term instanceof IfControlFlow) {
			return (term as IfControlFlow).iftrue.exp.getVariable;
		} else if (term instanceof BracketExpression) {
			return (term as BracketExpression).exp.exp.getVariable;
		}
	} 
	
	static def String getVariable(MyVariable variable) {
		if (variable instanceof Variable) {
			return (variable as Variable).^var;
		} else if (variable instanceof CastedVariable) {
			/*val cvar = variable as CastedVariable;
			functionParams.get(currentFunction).put(cvar.^var, getDataTypeFromCast())
			return cvar.^var;*/
			return (variable as CastedVariable).^var;
		}
	}
	
	static def DataType getDataTypeFromCast(CastedType ct) {
		switch (ct) {
			case CastedType.BOOL:
				return DataType.BOOL
			case CastedType.INT:
				return DataType.INT
			case CastedType.STRING:
				return DataType.STRING
		}
	}
	
	static def void setFunctionType(String name, DataType type) {
		if (functionTypes.containsKey(name)) {
			if (functionTypes.get(name).equals(DataType.VAR)) {
				functionTypes.put(name, type);
			}
		} else {
			functionTypes.put(name, type);
		}
	}
	
	static def String getFunctionString(FunctionDefinition fd) {
		val name = fd.name;
		var res = name + "->" + functionTypes.get(name);
		for (cur : functionParams.get(name).keySet()) {
			res += "\n" + cur + ":" + functionParams.get(name).get(cur);
		}		
		return res;
	}
	
	static def getFunctionTypes() {
		return functionTypes;
	}
	
	static def getFunctionParams() {
		return functionParams;
	}
}