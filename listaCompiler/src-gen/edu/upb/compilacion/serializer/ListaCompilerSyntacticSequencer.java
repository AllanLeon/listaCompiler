/*
 * generated by Xtext
 */
package edu.upb.compilacion.serializer;

import com.google.inject.Inject;
import edu.upb.compilacion.services.ListaCompilerGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class ListaCompilerSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ListaCompilerGrammarAccess grammarAccess;
	protected AbstractElementAlias match_FirstLevelExp_AmpersandKeyword_1_0_0_or_VerticalLineKeyword_1_0_1;
	protected AbstractElementAlias match_FourthLevelExp_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1;
	protected AbstractElementAlias match_SecondLevelExp_EqualsSignEqualsSignKeyword_1_0_2_or_GreaterThanSignKeyword_1_0_0_or_LessThanSignKeyword_1_0_1;
	protected AbstractElementAlias match_ThirdLevelExp_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0_or_PlusSignPlusSignKeyword_1_0_2;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ListaCompilerGrammarAccess) access;
		match_FirstLevelExp_AmpersandKeyword_1_0_0_or_VerticalLineKeyword_1_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getFirstLevelExpAccess().getAmpersandKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getFirstLevelExpAccess().getVerticalLineKeyword_1_0_1()));
		match_FourthLevelExp_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getFourthLevelExpAccess().getAsteriskKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getFourthLevelExpAccess().getSolidusKeyword_1_0_1()));
		match_SecondLevelExp_EqualsSignEqualsSignKeyword_1_0_2_or_GreaterThanSignKeyword_1_0_0_or_LessThanSignKeyword_1_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSecondLevelExpAccess().getEqualsSignEqualsSignKeyword_1_0_2()), new TokenAlias(false, false, grammarAccess.getSecondLevelExpAccess().getGreaterThanSignKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getSecondLevelExpAccess().getLessThanSignKeyword_1_0_1()));
		match_ThirdLevelExp_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0_or_PlusSignPlusSignKeyword_1_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getThirdLevelExpAccess().getHyphenMinusKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getThirdLevelExpAccess().getPlusSignKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getThirdLevelExpAccess().getPlusSignPlusSignKeyword_1_0_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_FirstLevelExp_AmpersandKeyword_1_0_0_or_VerticalLineKeyword_1_0_1.equals(syntax))
				emit_FirstLevelExp_AmpersandKeyword_1_0_0_or_VerticalLineKeyword_1_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FourthLevelExp_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1.equals(syntax))
				emit_FourthLevelExp_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SecondLevelExp_EqualsSignEqualsSignKeyword_1_0_2_or_GreaterThanSignKeyword_1_0_0_or_LessThanSignKeyword_1_0_1.equals(syntax))
				emit_SecondLevelExp_EqualsSignEqualsSignKeyword_1_0_2_or_GreaterThanSignKeyword_1_0_0_or_LessThanSignKeyword_1_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ThirdLevelExp_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0_or_PlusSignPlusSignKeyword_1_0_2.equals(syntax))
				emit_ThirdLevelExp_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0_or_PlusSignPlusSignKeyword_1_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '&' | '|'
	 *
	 * This ambiguous syntax occurs at:
	 *     first=SecondLevelExp (ambiguity) second=FirstLevelExp
	 */
	protected void emit_FirstLevelExp_AmpersandKeyword_1_0_0_or_VerticalLineKeyword_1_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '*' | '/'
	 *
	 * This ambiguous syntax occurs at:
	 *     first=Term (ambiguity) second=FourthLevelExp
	 */
	protected void emit_FourthLevelExp_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '>' | '<' | '=='
	 *
	 * This ambiguous syntax occurs at:
	 *     first=ThirdLevelExp (ambiguity) second=SecondLevelExp
	 */
	protected void emit_SecondLevelExp_EqualsSignEqualsSignKeyword_1_0_2_or_GreaterThanSignKeyword_1_0_0_or_LessThanSignKeyword_1_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '+' | '-' | '++'
	 *
	 * This ambiguous syntax occurs at:
	 *     first=FourthLevelExp (ambiguity) second=ThirdLevelExp
	 */
	protected void emit_ThirdLevelExp_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0_or_PlusSignPlusSignKeyword_1_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
